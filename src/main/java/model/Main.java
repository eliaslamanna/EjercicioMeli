package model;

import exceptions.CoordinateNotFoundException;
import exceptions.MessageIncompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import services.HandleMessagesService;

import java.util.ArrayList;

public class Main {

    public static int getDifferentWords(ArrayList<ArrayList<String>> messages) {
        int shortestSize = messages.get(0).size();
        for(ArrayList<String> message : messages) {
            if(message.size() < shortestSize) {
                shortestSize = message.size();
            }
        }
        return shortestSize;
    }

    public static void makeMesssagesSameSize(ArrayList<ArrayList<String>> messages, int size) throws MessageIncompleteException {
        for(ArrayList<String> message: messages) {
            while(message.size() > size) {
                if(message.get(0).equals("")) {
                    message.remove(0);
                }

            }
        }
    }

    public static String wrapMessageTogether(ArrayList<ArrayList<String>> messages, int size) {
        String returnValue = "";
        ArrayList<String> asd = new ArrayList<>();

        for(ArrayList<String> message: messages) {
            for(String word : message) {
                if(!word.equals("")) {
                    asd.add(message.indexOf(word), word);
                }
            }
        }

        returnValue = String.join(" ", asd);
        System.out.println(returnValue);

        return returnValue;
    }

    @Autowired
    HandleMessagesService service;

    public static void main(String[] args) throws CoordinateNotFoundException, MessageIncompleteException {


    }

}
