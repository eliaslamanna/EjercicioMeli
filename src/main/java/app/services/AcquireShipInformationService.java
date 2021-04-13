package app.services;

import app.exceptions.CoordinateNotFoundException;
import app.exceptions.MessageIncompleteException;
import app.model.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.requirements.GetSatellitesPossiblePositionsRequirement;
import app.requirements.GetShipLocationRequirement;
import app.requirements.WrapMessageTogetherRequirement;

import java.util.ArrayList;

@Service
public class AcquireShipInformationService {

    @Autowired
    GetSatellitesPossiblePositionsRequirement getSatellitesPossiblePositionsRequirement;
    @Autowired
    GetShipLocationRequirement getShipLocation;
    @Autowired
    WrapMessageTogetherRequirement wrapMessageTogetherRequirement;

    // input: distancia al emisor tal cual se recibe en cada satélite
    // output: las coordenadas ‘x’ e ‘y’ del emisor del mensaje
    public Coordinate getLocation(Float[] distances) throws CoordinateNotFoundException {

        ArrayList<Coordinate> coordinatesKenobi = new ArrayList<>();
        ArrayList<Coordinate> coordinatesSkywalker = new ArrayList<>();
        ArrayList<Coordinate> coordinatesSato = new ArrayList<>();

        getSatellitesPossiblePositionsRequirement.getSatellitesPossiblePositions(coordinatesKenobi,coordinatesSkywalker,coordinatesSato,distances);

        return getShipLocation.getShipLocation(coordinatesKenobi,coordinatesSkywalker,coordinatesSato);
    }


    // input: el mensaje tal cual es recibido en cada satélite
    // output: el mensaje tal cual lo genera el emisor del mensaje
    public String getMessage(ArrayList<ArrayList<String>> messages) throws MessageIncompleteException {
        return wrapMessageTogetherRequirement.wrapMessageTogether(messages);
    }

}
