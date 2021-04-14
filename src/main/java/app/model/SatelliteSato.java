package app.model;

public class SatelliteSato extends Satellite{

    private Coordinate coordinates = new Coordinate(500F,100F);

    public SatelliteSato(float distance) {
        this.distance = distance;
    }

    @Override
    public Coordinate getCoordinates() {
        return coordinates;
    }

    @Override
    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }
}
