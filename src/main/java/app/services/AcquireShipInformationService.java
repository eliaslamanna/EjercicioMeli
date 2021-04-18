package app.services;

import app.exceptions.CoordinateNotFoundException;
import app.exceptions.MessageIncompleteException;
import app.model.*;
import app.requirements.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcquireShipInformationService {

    @Autowired
    GetSatellitesPossiblePositionsRequirement getSatellitesPossiblePositionsRequirement;
    @Autowired
    GetShipLocationRequirement getShipLocation;
    @Autowired
    WrapMessageTogetherRequirement wrapMessageTogetherRequirement;
    @Autowired
    InsertSatelliteRequirement insertSatelliteRequirement;
    @Autowired
    GetSatellitesDataRequirement getSatellitesDataRequirement;

    // input: distancia al emisor tal cual se recibe en cada satélite
    // output: las coordenadas ‘x’ e ‘y’ del emisor del mensaje
    public Coordinate getLocation(Float[] distances) throws CoordinateNotFoundException {

        ArrayList<Coordinate> coordinatesKenobi = new ArrayList<>();
        ArrayList<Coordinate> coordinatesSkywalker = new ArrayList<>();
        ArrayList<Coordinate> coordinatesSato = new ArrayList<>();

        getSatellitesPossiblePositionsRequirement.run(new GetSatellitePossiblePositionsRequest(coordinatesKenobi,coordinatesSkywalker,coordinatesSato,distances));

        return getShipLocation.run(new GetShipLocationRequest(coordinatesKenobi,coordinatesSkywalker,coordinatesSato));
    }


    // input: el mensaje tal cual es recibido en cada satélite
    // output: el mensaje tal cual lo genera el emisor del mensaje
    public String getMessage(ArrayList<ArrayList<String>> messages) throws MessageIncompleteException {
        return wrapMessageTogetherRequirement.run(messages);
    }

    public void insertSatellite(String satelliteName, Float satelliteDistance, List<String> satelliteMessage) {
        insertSatelliteRequirement.run(new InsertSatelliteRequest(satelliteName,satelliteDistance,satelliteMessage));
    }

    public SatellitesDataContainer getSatellitesData() {
        return getSatellitesDataRequirement.run(null);
    }
}
