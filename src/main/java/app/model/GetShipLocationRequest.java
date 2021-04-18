package app.model;

import java.util.ArrayList;

public class GetShipLocationRequest {

    private ArrayList<Coordinate> coordinatesKenobi;
    private ArrayList<Coordinate> coordinatesSkywalker;
    private ArrayList<Coordinate> coordinatesSato;

    public GetShipLocationRequest(ArrayList<Coordinate> coordinatesKenobi, ArrayList<Coordinate> coordinatesSkywalker, ArrayList<Coordinate> coordinatesSato) {
        this.coordinatesKenobi = coordinatesKenobi;
        this.coordinatesSkywalker = coordinatesSkywalker;
        this.coordinatesSato = coordinatesSato;
    }

    public ArrayList<Coordinate> getCoordinatesKenobi() {
        return coordinatesKenobi;
    }

    public ArrayList<Coordinate> getCoordinatesSkywalker() {
        return coordinatesSkywalker;
    }

    public ArrayList<Coordinate> getCoordinatesSato() {
        return coordinatesSato;
    }
}
