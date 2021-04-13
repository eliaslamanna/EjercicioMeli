package app.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * SatelliteRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-12T15:51:34.057Z[GMT]")


public class SatelliteRequest   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("distance")
  private Float distance = null;

  @JsonProperty("message")
  @Valid
  private List<String> message = null;

  public SatelliteRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(description = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SatelliteRequest distance(Float distance) {
    this.distance = distance;
    return this;
  }

  /**
   * Get distance
   * @return distance
   **/
  @Schema(description = "")
  
    public Float getDistance() {
    return distance;
  }

  public void setDistance(Float distance) {
    this.distance = distance;
  }

  public SatelliteRequest message(List<String> message) {
    this.message = message;
    return this;
  }

  public SatelliteRequest addMessageItem(String messageItem) {
    if (this.message == null) {
      this.message = new ArrayList<String>();
    }
    this.message.add(messageItem);
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  @Schema(description = "")
  
    public List<String> getMessage() {
    return message;
  }

  public void setMessage(List<String> message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SatelliteRequest satelliteRequest = (SatelliteRequest) o;
    return Objects.equals(this.name, satelliteRequest.name) &&
        Objects.equals(this.distance, satelliteRequest.distance) &&
        Objects.equals(this.message, satelliteRequest.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, distance, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SatelliteRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
