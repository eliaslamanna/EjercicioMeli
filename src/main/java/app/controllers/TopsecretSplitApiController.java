package app.controllers;

import app.exceptions.CoordinateNotFoundException;
import app.exceptions.MessageIncompleteException;
import app.mapper.ShipdataMapper;
import app.model.*;
import app.services.AcquireShipInformationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import model.Satellitedata;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.util.Buildable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-15T05:32:29.302Z[GMT]")
@RestController
public class TopsecretSplitApiController implements TopsecretSplitApi {

    private static final Logger log = LoggerFactory.getLogger(TopsecretSplitApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    ShipdataMapper shipdataMapper;
    @Autowired
    AcquireShipInformationService acquireShipInformationService;

    @org.springframework.beans.factory.annotation.Autowired
    public TopsecretSplitApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<ShipDataResponse> getSplitDataShip() throws MessageIncompleteException, CoordinateNotFoundException {
        List<Satellitedata> satellites = shipdataMapper.selectAll();
        Satellitedata kenobi = satellites.get(0);
        Satellitedata skywalker = satellites.get(2);
        Satellitedata sato = satellites.get(1);

        Float[] distances = {kenobi.getDistance(),skywalker.getDistance(),sato.getDistance()};

        ArrayList<ArrayList<String>> messages = new ArrayList<ArrayList<String>>();
        ArrayList<String> currentMessage = new ArrayList<String>();
        satellites.stream().forEach(satellite -> {
            currentMessage.clear();
            String[] message = satellite.getMessage().split(",");
            for(int i  = 0; i < message.length; i ++) {
                currentMessage.add(message[i]);
            }
            messages.add(currentMessage);
        });


        String completeMessage = acquireShipInformationService.getMessage(messages);
        Coordinate shipCoordinates = acquireShipInformationService.getLocation(distances);

        if(completeMessage == null || shipCoordinates == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ShipDataResponse(shipCoordinates, completeMessage));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ShipDataResponse(shipCoordinates, completeMessage));
    }

    @Override
    public ResponseEntity<SatelliteDataResponse> updateSplitSatelliteData(@Parameter(in = ParameterIn.PATH, description = "satellite to update", required=true, schema=@Schema()) @PathVariable("satellite_name") String satelliteName, @Parameter(in = ParameterIn.DEFAULT, description = "satellite", required=true, schema=@Schema()) @Valid @RequestBody SplitShipDataRequest body) {
        shipdataMapper.insertOrUpdateSatellite(satelliteName, body.getDistance(), body.getMessage().toString());
        SatelliteDataResponse response = new SatelliteDataResponse(satelliteName,body.getDistance(),body.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
