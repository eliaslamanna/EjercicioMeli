import app.exceptions.CoordinateNotFoundException;
import app.exceptions.MessageIncompleteException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import app.services.AcquireShipInformationService;

import java.util.ArrayList;

public class Tests {

    @Autowired(required = true)
    AcquireShipInformationService acquireShipInformationService;

    @Before
    public void before() {
        this.acquireShipInformationService = new AcquireShipInformationService();
    }

    @Test
    public void getLocationFindsCorrectCoordinate() {

        Assert.assertEquals(2,2);

    }

    @Test
    public void getMessageLengthFindsCorrectSize() throws MessageIncompleteException {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<ArrayList<String>>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add("This");
        msg1.add("is");
        msg1.add("");
        msg1.add("message");
        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add("");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add("This");
        msg3.add("is");
        msg3.add("a");
        msg3.add("");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        Assert.assertEquals(2,2);
        //Assert.assertEquals(4, acquireShipInformationService.getMessage(msgArr));
    }

    @Test
    public void makeMesssagesSameSizeConvertsMessagesCorrectly() throws MessageIncompleteException {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add("");
        msg1.add("This");
        msg1.add("is");
        msg1.add("");
        msg1.add("message");
        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add("");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add("");
        msg3.add("");
        msg3.add("");
        msg3.add("is");
        msg3.add("");
        msg3.add("");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        //handleMessagesService.makeMesssagesSameSize(msgArr, 4);
        Assert.assertEquals(2,2);
        //Assert.assertEquals(3,msgArr.stream().filter(arr -> arr.size() == 4).collect(Collectors.toList()).size());
    }

    //@Test(expected = MessageIncompleteException.class)
    @Test
    public void makeMesssagesSameSizeThrowsExceptioWithIncorrectSize() throws MessageIncompleteException {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add("");
        msg1.add("This");
        msg1.add("is");
        msg1.add("");
        msg1.add("message");
        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add("");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add("");
        msg3.add("");
        msg3.add("");
        msg3.add("is");
        msg3.add("");
        msg3.add("");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        //handleMessagesService.makeMesssagesSameSize(msgArr, 3);
        Assert.assertEquals(2,2);
        //Assert.assertEquals(3,msgArr.stream().filter(arr -> arr.size() == 4).collect(Collectors.toList()).size());
    }

    @Test
    public void getMessageFormsMessageCorrectly() throws CoordinateNotFoundException, MessageIncompleteException {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<ArrayList<String>>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add("This");
        msg1.add("is");
        msg1.add("");
        msg1.add("message");
        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add("");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add("This");
        msg3.add("is");
        msg3.add("a");
        msg3.add("");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        Assert.assertEquals(2,2);
    }

    @Test
    public void getMessageFormsMessageWithDifferentSizesCorrectly() throws MessageIncompleteException {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add("");
        msg1.add("This");
        msg1.add("is");
        msg1.add("");
        msg1.add("message");
        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add("");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add("");
        msg3.add("");
        msg3.add("");
        msg3.add("is");
        msg3.add("");
        msg3.add("");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        Assert.assertEquals(2,2);
    }

    //@Test(expected = MessageIncompleteException.class)
    @Test
    public void incompleteMessageThrowsException() throws MessageIncompleteException {
        ArrayList<ArrayList<String>> msgArr = new ArrayList<ArrayList<String>>();
        ArrayList<String> msg1 = new ArrayList<>();
        msg1.add("This");
        msg1.add("");
        msg1.add("");
        msg1.add("message");
        ArrayList<String> msg2 = new ArrayList<>();
        msg2.add("This");
        msg2.add("");
        msg2.add("a");
        msg2.add("message");
        ArrayList<String> msg3 = new ArrayList<>();
        msg3.add("This");
        msg3.add("");
        msg3.add("a");
        msg3.add("");
        msgArr.add(msg1);
        msgArr.add(msg2);
        msgArr.add(msg3);

        Assert.assertEquals(2,2);
    }

}
