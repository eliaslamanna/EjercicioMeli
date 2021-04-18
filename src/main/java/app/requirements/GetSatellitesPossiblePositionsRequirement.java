package app.requirements;

import app.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Component
public class GetSatellitesPossiblePositionsRequirement extends HandlerRequirement<GetSatellitePossiblePositionsRequest, Void>{

    @Override
    public Void run(GetSatellitePossiblePositionsRequest request) {
            SatelliteKenobi kenobi = new SatelliteKenobi(request.getDistances()[0]);
            SatelliteSkywalker skywalker = new SatelliteSkywalker(request.getDistances()[1]);
            SatelliteSato sato = new SatelliteSato(request.getDistances()[2]);

            IntStream
                    .range(0,360)
                    .forEach(i -> {
                        Coordinate currentCoordinateKenobi = new Coordinate((float) Math.cos(i) * kenobi.getDistance()  + kenobi.getCoordinates().getX(),(float) Math.sin(i) * kenobi.getDistance() + kenobi.getCoordinates().getY());
                        request.getCoordinatesKenobi().add(currentCoordinateKenobi);

                        Coordinate currentCoordinateSkywalker = new Coordinate((float) Math.cos(i) * skywalker.getDistance() + skywalker.getCoordinates().getX(),(float) Math.sin(i) * skywalker.getDistance() + skywalker.getCoordinates().getY());
                        request.getCoordinatesSkywalker().add(currentCoordinateSkywalker);

                        Coordinate currentCoordinateSato = new Coordinate((float) Math.cos(i) * sato.getDistance() + sato.getCoordinates().getX(),(float) Math.sin(i) * sato.getDistance() + sato.getCoordinates().getY());
                        request.getCoordinatesSato().add(currentCoordinateSato);
                    });

            return null;
        }
}
