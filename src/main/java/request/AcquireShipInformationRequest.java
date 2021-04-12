package request;

import exceptions.CoordinateNotFoundException;
import exceptions.MessageIncompleteException;
import model.Coordinate;
import model.SatelliteKenobi;
import model.SatelliteSato;
import model.SatelliteSkywalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import services.AcquireShipInformationService;
import services.HandleMessagesService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AcquireShipInformationRequest {

    @Autowired
    AcquireShipInformationService acquireShipInformationService;
    @Autowired
    HandleMessagesService handleMessagesService;

    // input: distancia al emisor tal cual se recibe en cada satélite
    // output: las coordenadas ‘x’ e ‘y’ del emisor del mensaje
    public Coordinate getLocation(float[] distances) throws CoordinateNotFoundException {

        ArrayList<Coordinate> coordinatesKenobi = new ArrayList<>();
        ArrayList<Coordinate> coordinatesSkywalker = new ArrayList<>();
        ArrayList<Coordinate> coordinatesSato = new ArrayList<>();

        acquireShipInformationService.getSatellitesPossiblePositions(coordinatesKenobi,coordinatesSkywalker,coordinatesSato,distances);
        Coordinate returnCoordinate = acquireShipInformationService.getShipLocation(coordinatesKenobi,coordinatesSkywalker,coordinatesSato);

        return returnCoordinate;
    }


    // input: el mensaje tal cual es recibido en cada satélite
    // output: el mensaje tal cual lo genera el emisor del mensaje
    public String getMessage(ArrayList<ArrayList<String>> messages) throws CoordinateNotFoundException, MessageIncompleteException {
        String completeMessege = handleMessagesService.wrapMessageTogether(messages);
        return completeMessege;
    }

}
