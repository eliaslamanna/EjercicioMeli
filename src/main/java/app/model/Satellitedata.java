package app.model;

/**
 * Table: satellitedata
 */
public class Satellitedata {
    /**
     * Column: name
     */
    private String name;

    /**
     * Column: distance
     */
    private Float distance;

    /**
     * Column: message
     */
    private String message;

    public Satellitedata(String name, Float distance, String message) {
        this.name = name;
        this.distance = distance;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}