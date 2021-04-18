package app.model;

import java.util.ArrayList;

public class MakeMessagesSameSizeRequest {

    private ArrayList<ArrayList<String>> messages;
    private int size;

    public MakeMessagesSameSizeRequest(ArrayList<ArrayList<String>> messages, int size) {
        this.messages = messages;
        this.size = size;
    }

    public ArrayList<ArrayList<String>> getMessages() {
        return messages;
    }

    public int getSize() {
        return size;
    }
}
