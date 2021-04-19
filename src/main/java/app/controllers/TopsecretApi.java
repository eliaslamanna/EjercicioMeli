/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package app.controllers;

import app.exceptions.CoordinateNotFoundException;
import app.exceptions.DifferenteMessagesException;
import app.model.ShipDataRequest;
import app.model.ShipDataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-14T02:41:47.463Z[GMT]")
@Validated
public interface TopsecretApi {

    @Operation(summary = "gets the location and message of the ship", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = ShipDataResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "ERROR The message or the possition couldn't be determinated", content = @Content(schema = @Schema(implementation = ShipDataResponse.class))) })
    @RequestMapping(value = "/topsecret",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ShipDataResponse> getDataShip(@Parameter(in = ParameterIn.DEFAULT, description = "satellites", required=true, schema=@Schema()) @Valid @RequestBody ShipDataRequest body) throws CoordinateNotFoundException, DifferenteMessagesException;

}

