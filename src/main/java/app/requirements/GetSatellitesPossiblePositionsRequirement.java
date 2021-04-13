package app.requirements;

import app.model.Coordinate;
import app.model.SatelliteKenobi;
import app.model.SatelliteSato;
import app.model.SatelliteSkywalker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Component
public class GetSatellitesPossiblePositionsRequirement {

    public void getSatellitesPossiblePositions(ArrayList<Coordinate> coordinatesKenobi, ArrayList<Coordinate> coordinatesSkywalker, ArrayList<Coordinate> coordinatesSato, Float[] distances) {

        SatelliteKenobi kenobi = new SatelliteKenobi(distances[0]);
        SatelliteSkywalker skywalker = new SatelliteSkywalker(distances[1]);
        SatelliteSato sato = new SatelliteSato(distances[2]);

        IntStream
                .range(0,360)
                .forEach(i -> {
                    Coordinate currentCoordinateKenobi = new Coordinate((float) Math.cos(i) * kenobi.getDistance()  + kenobi.getCoordinates().getX(),(float) Math.sin(i) * kenobi.getDistance() + kenobi.getCoordinates().getY());
                    coordinatesKenobi.add(currentCoordinateKenobi);

                    Coordinate currentCoordinateSkywalker = new Coordinate((float) Math.cos(i) * skywalker.getDistance() + skywalker.getCoordinates().getX(),(float) Math.sin(i) * skywalker.getDistance() + skywalker.getCoordinates().getY());
                    coordinatesSkywalker.add(currentCoordinateSkywalker);

                    Coordinate currentCoordinateSato = new Coordinate((float) Math.cos(i) * sato.getDistance() + sato.getCoordinates().getX(),(float) Math.sin(i) * sato.getDistance() + sato.getCoordinates().getY());
                    coordinatesSato.add(currentCoordinateSato);
                });
    }

}
