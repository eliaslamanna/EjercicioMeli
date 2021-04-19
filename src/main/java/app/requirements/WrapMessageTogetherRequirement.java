package app.requirements;

import app.exceptions.DifferenteMessagesException;
import app.model.MakeMessagesSameSizeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Component
public class WrapMessageTogetherRequirement extends HandlerRequirement<ArrayList<ArrayList<String>>, String>{

    @Autowired
    GetMessageLengthRequirement getMessageLengthRequirement;
    @Autowired
    MakeMessagesSameSizeRequirement messagesSameSizeRequirement;

    @Override
    public String run(ArrayList<ArrayList<String>> messages) throws DifferenteMessagesException {
        int messageLength = getMessageLengthRequirement.run(messages);
        messagesSameSizeRequirement.run(new MakeMessagesSameSizeRequest(messages, messageLength));
        ArrayList<String> msg1 = messages.get(0);
        ArrayList<String> msg2 = messages.get(1);
        ArrayList<String> msg3 = messages.get(2);
        boolean[] invalidvalidMessage = {false};
        IntStream.range(0,msg1.size()).forEach(i -> {
            String word1 = msg1.get(i);
            String word2 = msg2.get(i);
            String word3 = msg3.get(i);
            if((!word1.equals(" ") && !word1.equals(word2) && !word2.equals(" ")) || (!word3.equals(" ") && !word2.equals(word3)) && !word2.equals(" ")) {
                    invalidvalidMessage[0] = true;
            }
        });
        if(invalidvalidMessage[0]) {
            throw new DifferenteMessagesException();
        }
        ArrayList<String> completeMessage = new ArrayList<>();
        IntStream.range(0,messageLength).forEach(i -> completeMessage.add(" "));

        messages.stream().forEach( message -> {
            message.stream()
                    .filter(word -> !word.equals(" "))
                    .forEach( word -> {
                        completeMessage.set(message.indexOf(word), word);
                    });
        });

        String returnValue = String.join(" ", completeMessage);

        return returnValue;
    }
}
