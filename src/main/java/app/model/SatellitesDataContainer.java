package app.model;

import java.util.ArrayList;

public class SatellitesDataContainer {

    Float[] distances;
    ArrayList<ArrayList<String>> messages;

    public SatellitesDataContainer(Float[] distances, ArrayList<ArrayList<String>> messages) {
        this.distances = distances;
        this.messages = messages;
    }

    public Float[] getDistances() {
        return distances;
    }

    public ArrayList<ArrayList<String>> getMessages() {
        return messages;
    }

}
