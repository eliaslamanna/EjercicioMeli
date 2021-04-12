package services;

import exceptions.CoordinateNotFoundException;
import model.Coordinate;
import model.SatelliteKenobi;
import model.SatelliteSato;
import model.SatelliteSkywalker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AcquireShipInformationService {

    public void getSatellitesPossiblePositions(ArrayList<Coordinate> coordinatesKenobi, ArrayList<Coordinate> coordinatesSkywalker, ArrayList<Coordinate> coordinatesSato, float[] distances) {

        SatelliteKenobi kenobi = new SatelliteKenobi(distances[0]);
        SatelliteSkywalker skywalker = new SatelliteSkywalker(distances[1]);
        SatelliteSato sato = new SatelliteSato(distances[2]);

        IntStream
            .range(0,360)
            .forEach(i -> {
                Coordinate currentCoordinateKenobi = new Coordinate((float) Math.cos(i) * kenobi.getDistance()  + kenobi.getCoordinates().getPositionX(),(float) Math.sin(i) * kenobi.getDistance() + kenobi.getCoordinates().getPositionY());
                coordinatesKenobi.add(currentCoordinateKenobi);

                Coordinate currentCoordinateSkywalker = new Coordinate((float) Math.cos(i) * skywalker.getDistance() + skywalker.getCoordinates().getPositionX(),(float) Math.sin(i) * skywalker.getDistance() + skywalker.getCoordinates().getPositionY());
                coordinatesSkywalker.add(currentCoordinateSkywalker);

                Coordinate currentCoordinateSato = new Coordinate((float) Math.cos(i) * sato.getDistance() + sato.getCoordinates().getPositionX(),(float) Math.sin(i) * sato.getDistance() + sato.getCoordinates().getPositionY());
                coordinatesSato.add(currentCoordinateSato);
            });
    }

    public Coordinate getShipLocation(ArrayList<Coordinate> coordinatesKenobi, ArrayList<Coordinate> coordinatesSkywalker, ArrayList<Coordinate> coordinatesSato) throws CoordinateNotFoundException {

        Coordinate returnCoordinate = coordinatesKenobi
                .stream()
                .filter(currentCoor -> coordinatesSkywalker.contains(currentCoor) && coordinatesSato.contains(currentCoor))
                .collect(Collectors.toList()).get(0);

        if(returnCoordinate == null) {
            throw new CoordinateNotFoundException();
        }

        return returnCoordinate;
    }

}
