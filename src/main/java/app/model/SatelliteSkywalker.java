package app.model;

public class SatelliteSkywalker extends Satellite{

    private Coordinate coordinates = new Coordinate(100F,-100F);

    public SatelliteSkywalker(float distance) {
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
