package app.model;

import java.util.ArrayList;

public class GetSatellitePossiblePositionsRequest {

    private ArrayList<Coordinate> coordinatesKenobi;
    private ArrayList<Coordinate> coordinatesSkywalker;
    private ArrayList<Coordinate> coordinatesSato;
    private Float[] distances;

    public GetSatellitePossiblePositionsRequest(ArrayList<Coordinate> coordinatesKenobi, ArrayList<Coordinate> coordinatesSkywalker, ArrayList<Coordinate> coordinatessato, Float[] distances) {
        this.coordinatesKenobi = coordinatesKenobi;
        this.coordinatesSkywalker = coordinatesSkywalker;
        this.coordinatesSato = coordinatessato;
        this.distances = distances;
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

    public Float[] getDistances() {
        return distances;
    }
}
