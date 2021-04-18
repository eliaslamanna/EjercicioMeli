package app.requirements;

import app.exceptions.MessageIncompleteException;
import app.model.MakeMessagesSameSizeRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MakeMessagesSameSizeRequirement extends HandlerRequirement<MakeMessagesSameSizeRequest, Void>{

    @Override
    public Void run(MakeMessagesSameSizeRequest request) throws MessageIncompleteException {
        for(ArrayList<String> message: request.getMessages()) {
            while(message.size() > request.getSize()) {
                if(message.get(0).equals(" ")) {
                    message.remove(0);
                }
                else {
                    throw new MessageIncompleteException();
                }
            }
        }
        return null;
    }

}
