package model;

/**
 * Table: shipdata
 */
public class Shipdata {
    /**
     * Column: id
     */
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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