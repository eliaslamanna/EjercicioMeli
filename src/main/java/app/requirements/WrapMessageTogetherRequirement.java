package app.requirements;

import app.exceptions.MessageIncompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Component
public class WrapMessageTogetherRequirement {

    @Autowired
    GetMessageLengthRequirement getMessageLengthRequirement;
    @Autowired
    MakeMessagesSameSizeRequirement messagesSameSizeRequirement;

    public String wrapMessageTogether(ArrayList<ArrayList<String>> messages) throws MessageIncompleteException {
        int messageLength = getMessageLengthRequirement.getMessageLength(messages);
        messagesSameSizeRequirement.makeMessagesSameSize(messages, messageLength);
        ArrayList<String> completeMessage = new ArrayList<>();
        IntStream.range(0,messageLength).forEach(i -> completeMessage.add(""));

        messages.stream().forEach( message -> {
            message.stream()
                    .filter(word -> !word.equals(""))
                    .forEach( word -> {
                        completeMessage.set(message.indexOf(word), word);
                    });
        });

        String returnValue = String.join(" ", completeMessage);

        return returnValue;
    }

}
