package app.requirements;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class GetMessageLengthRequirement {

    public int getMessageLength(ArrayList<ArrayList<String>> messages) {
        ArrayList<String> differentWords = new ArrayList<>();
        for(ArrayList<String> message : messages){
            differentWords = (ArrayList<String>) Stream.concat(differentWords.stream(), message.stream())
                    .distinct()
                    .collect(Collectors.toList());
        }
        differentWords.remove(" ");
        return differentWords.size();
    }

}
