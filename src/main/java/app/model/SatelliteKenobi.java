package app.model;

public class SatelliteKenobi extends Satellite{

    private Coordinate coordinates = new Coordinate(-500F,-200F);

    public SatelliteKenobi(float distance) {
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
