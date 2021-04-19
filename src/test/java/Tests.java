import app.UserApplication;
import app.exceptions.DifferenteMessagesException;
import app.model.MakeMessagesSameSizeRequest;
import app.requirements.GetMessageLengthRequirement;
import app.requirements.MakeMessagesSameSizeRequirement;
import app.requirements.WrapMessageTogetherRequirement;
import app.services.AcquireShipInformationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserApplication.class})
public class Tests {

    @Autowired(required = true)
    WrapMessageTogetherRequirement wrapMessageTogetherRequirement;
    @Autowired(required = true)
    MakeMessagesSameSizeRequirement makeMessagesSameSizeRequirement;
    @Autowired(required = true)
    GetMessageLengthRequirement getMessageLengthRequirement;
    @Autowired(required = true)
    AcquireShipInformationService acquireShipInformationService;


    @Before
    public void before() {
        WrapMessageTogetherRequirement wrapMessageTogetherRequirement = new WrapMessageTogetherRequirement();
        MakeMessagesSameSizeRequirement makeMessagesSameSizeRequirement = new MakeMessagesSameSizeRequirement();
        GetMessageLengthRequirement getMessageLengthRequirement = new GetMessageLengthRequirement();
        AcquireShipInformationService acquireShipInformationService = new AcquireShipInformationService();
    }

    @Test
    public void getMessageLengthFindsCorrectSize() {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add("This");
        msg1.add("is");
        msg1.add(" ");
        msg1.add("message");
        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add(" ");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add("This");
        msg3.add("is");
        msg3.add("a");
        msg3.add(" ");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        int size = getMessageLengthRequirement.run(msgArr);
        Assert.assertEquals(4, size);
    }

    @Test
    public void makeMesssagesSameSizeConvertsMessagesCorrectly() throws DifferenteMessagesException {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add(" ");
        msg1.add("This");
        msg1.add("is");
        msg1.add(" ");
        msg1.add("message");
        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add(" ");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add(" ");
        msg3.add(" ");
        msg3.add(" ");
        msg3.add("is");
        msg3.add(" ");
        msg3.add(" ");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        makeMessagesSameSizeRequirement.run(new MakeMessagesSameSizeRequest(msgArr, 4));
        Assert.assertEquals(3,msgArr.stream().filter(arr -> arr.size() == 4).collect(Collectors.toList()).size());
    }

    @Test
    public void wrapMessagesTogetherFormCompleteMessage() throws DifferenteMessagesException {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add(" ");
        msg1.add("This");
        msg1.add("is");
        msg1.add(" ");
        msg1.add("message");
        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add(" ");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add(" ");
        msg3.add(" ");
        msg3.add(" ");
        msg3.add("is");
        msg3.add(" ");
        msg3.add(" ");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        Assert.assertEquals("This is a message", wrapMessageTogetherRequirement.run(msgArr));
    }

    @Test(expected = DifferenteMessagesException.class)
    public void incompleteMessageThrowsException() throws DifferenteMessagesException {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<ArrayList<String>>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add("This");
        msg1.add(" ");
        msg1.add("message");
        msg1.add(" ");        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add(" ");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add("This");
        msg3.add(" ");
        msg3.add("a");
        msg3.add(" ");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        String completeMsg = wrapMessageTogetherRequirement.run(msgArr);

        Assert.assertEquals(2,2);
    }

    @Test
    public void getMessageWorksCorrectly() throws DifferenteMessagesException {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add(" ");
        msg1.add("This");
        msg1.add("is");
        msg1.add(" ");
        msg1.add("message");
        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add(" ");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add(" ");
        msg3.add(" ");
        msg3.add(" ");
        msg3.add("is");
        msg3.add(" ");
        msg3.add(" ");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        Assert.assertEquals("This is a message", acquireShipInformationService.getMessage(msgArr));
    }
    
}
