package app.requirements;

import app.exceptions.CoordinateNotFoundException;
import app.model.Coordinate;
import app.model.GetShipLocationRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class GetShipLocationRequirement extends HandlerRequirement<GetShipLocationRequest, Coordinate>{
    
    @Override
    public Coordinate run(GetShipLocationRequest request) {
        Coordinate returnCoordinate = null;
        try{
            returnCoordinate = request.getCoordinatesKenobi()
                    .stream()
                    .filter(currentCoor -> request.getCoordinatesSkywalker().contains(currentCoor) && request.getCoordinatesSato().contains(currentCoor))
                    .collect(Collectors.toList()).get(0);
        }
        catch(Exception e){
        }

        return returnCoordinate;
    }
}
