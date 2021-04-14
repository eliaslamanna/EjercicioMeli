package app.requirements;

import app.exceptions.CoordinateNotFoundException;
import app.model.Coordinate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class GetShipLocationRequirement {

    public Coordinate getShipLocation(ArrayList<Coordinate> coordinatesKenobi, ArrayList<Coordinate> coordinatesSkywalker, ArrayList<Coordinate> coordinatesSato) throws CoordinateNotFoundException {

        Coordinate returnCoordinate = null;
        try{
            returnCoordinate = coordinatesKenobi
                    .stream()
                    .filter(currentCoor -> coordinatesSkywalker.contains(currentCoor) && coordinatesSato.contains(currentCoor))
                    .collect(Collectors.toList()).get(0);
        }
        catch(Exception e){
        }

        return returnCoordinate;
    }

}
