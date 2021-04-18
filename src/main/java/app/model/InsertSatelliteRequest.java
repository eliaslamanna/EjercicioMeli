package app.model;

import java.util.List;

public class InsertSatelliteRequest {

    private String satelliteName;
    private Float satelliteDistance;
    List<String> satelliteMessage;

    public InsertSatelliteRequest(String satelliteName, Float satelliteDistance, List<String> satelliteMessage) {
        this.satelliteName = satelliteName;
        this.satelliteDistance = satelliteDistance;
        this.satelliteMessage = satelliteMessage;
    }

    public String getSatelliteName() {
        return satelliteName;
    }

    public Float getSatelliteDistance() {
        return satelliteDistance;
    }

    public List<String> getSatelliteMessage() {
        return satelliteMessage;
    }
}
