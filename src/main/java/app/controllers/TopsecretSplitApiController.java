package app.controllers;

import app.mapper.ShipdataMapper;
import app.model.SatelliteDataResponse;
import app.model.ShipDataResponse;
import app.model.SplitShipDataRequest;
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

    @org.springframework.beans.factory.annotation.Autowired
    public TopsecretSplitApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<ShipDataResponse> getSplitDataShip() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ShipDataResponse>(objectMapper.readValue("{\n  \"position\" : {\n    \"x\" : 0.8008282,\n    \"y\" : 6.0274563\n  },\n  \"message\" : \"message\"\n}", ShipDataResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ShipDataResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ShipDataResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<SatelliteDataResponse> updateSplitSatelliteData(@Parameter(in = ParameterIn.PATH, description = "satellite to update", required=true, schema=@Schema()) @PathVariable("satellite_name") String satelliteName, @Parameter(in = ParameterIn.DEFAULT, description = "satellite", required=true, schema=@Schema()) @Valid @RequestBody SplitShipDataRequest body) {
        Satellitedata satelliteData = new Satellitedata(satelliteName,body.getDistance(),body.getMessage().toString());
        shipdataMapper.insert(satelliteData);
        SatelliteDataResponse response = new SatelliteDataResponse(satelliteName,body.getDistance(),body.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
