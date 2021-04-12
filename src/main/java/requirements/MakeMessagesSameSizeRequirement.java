package requirements;

import exceptions.MessageIncompleteException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MakeMessagesSameSizeRequirement {

    public void makeMessagesSameSize(ArrayList<ArrayList<String>> messages, int size) throws MessageIncompleteException {
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

}
