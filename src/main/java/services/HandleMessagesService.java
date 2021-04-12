package services;

import exceptions.MessageIncompleteException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class HandleMessagesService {

    public int getMessageLength(ArrayList<ArrayList<String>> messages) {
        ArrayList<String> differentWords = new ArrayList<>();
        for(ArrayList<String> message : messages){
            differentWords = (ArrayList<String>) Stream.concat(differentWords.stream(), message.stream())
                    .distinct()
                    .collect(Collectors.toList());
        }
        differentWords.remove("");
        return differentWords.size();
    }

    public void makeMesssagesSameSize(ArrayList<ArrayList<String>> messages, int size) throws MessageIncompleteException {
        for(ArrayList<String> message: messages) {
            while(message.size() > size) {
                if(message.get(0).equals("")) {
                    message.remove(0);
                }
                else {
                    throw new MessageIncompleteException();
                }
            }
        }
    }

    public String wrapMessageTogether(ArrayList<ArrayList<String>> messages) throws MessageIncompleteException {
        int messageLength = getMessageLength(messages);
        makeMesssagesSameSize(messages, messageLength);
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
