package app.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ShipDataRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-12T15:51:34.057Z[GMT]")


public class ShipDataRequest   {
  @JsonProperty("satellites")
  @Valid
  private List<SatelliteRequest> satellites = null;

  public ShipDataRequest satellites(List<SatelliteRequest> satellites) {
    this.satellites = satellites;
    return this;
  }

  public ShipDataRequest addSatellitesItem(SatelliteRequest satellitesItem) {
    if (this.satellites == null) {
      this.satellites = new ArrayList<SatelliteRequest>();
    }
    this.satellites.add(satellitesItem);
    return this;
  }

  /**
   * Get satellites
   * @return satellites
   **/
  @Schema(description = "")
      @Valid
    public List<SatelliteRequest> getSatellites() {
    return satellites;
  }

  public void setSatellites(List<SatelliteRequest> satellites) {
    this.satellites = satellites;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShipDataRequest shipDataRequest = (ShipDataRequest) o;
    return Objects.equals(this.satellites, shipDataRequest.satellites);
  }

  @Override
  public int hashCode() {
    return Objects.hash(satellites);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShipDataRequest {\n");
    
    sb.append("    satellites: ").append(toIndentedString(satellites)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
