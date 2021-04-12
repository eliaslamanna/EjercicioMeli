package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.CoordinateNotFoundException;
import exceptions.MessageIncompleteException;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import model.Coordinate;
import model.ShipDataRequest;
import model.ShipDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import services.AcquireShipInformationService;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-12T15:51:34.057Z[GMT]")
@RestController
public class TopsecretApiController implements TopsecretApi {

    private static final Logger log = LoggerFactory.getLogger(TopsecretApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    AcquireShipInformationService acquireShipInformationService;

    @org.springframework.beans.factory.annotation.Autowired
    public TopsecretApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<ShipDataResponse> getDataShip(@Parameter(in = ParameterIn.DEFAULT, description = "satellites", required=true, schema=@Schema()) @Valid @RequestBody ShipDataRequest body) throws CoordinateNotFoundException, MessageIncompleteException {

        ArrayList<ArrayList<String>> messages = new ArrayList<>();
        messages.add((ArrayList<String>) body.getSatellites().get(0).getMessage());
        messages.add((ArrayList<String>) body.getSatellites().get(1).getMessage());
        messages.add((ArrayList<String>) body.getSatellites().get(2).getMessage());

        Float[] distances = {
                body.getSatellites().get(0).getDistance(),
                body.getSatellites().get(1).getDistance(),
                body.getSatellites().get(2).getDistance()
        };

        String completeMessage = acquireShipInformationService.getMessage(messages);
        Coordinate shipCoordinates = acquireShipInformationService.getLocation(distances);

        return ResponseEntity.ok(new ShipDataResponse(shipCoordinates, completeMessage));
    }

}
