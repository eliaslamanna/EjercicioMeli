package app.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ShipDataResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-12T15:51:34.057Z[GMT]")


public class ShipDataResponse   {
  @JsonProperty("position")
  private Coordinate position = null;

  @JsonProperty("message")
  private String message = null;

  public ShipDataResponse(Coordinate position, String message) {
    this.position = position;
    this.message = message;
  }

  public ShipDataResponse position(Coordinate position) {
    this.position = position;
    return this;
  }

  /**
   * Get position
   * @return position
   **/
  @Schema(description = "")
  
    @Valid
    public Coordinate getPosition() {
    return position;
  }

  public void setPosition(Coordinate position) {
    this.position = position;
  }

  public ShipDataResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  @Schema(description = "")
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
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
    ShipDataResponse shipDataResponse = (ShipDataResponse) o;
    return Objects.equals(this.position, shipDataResponse.position) &&
        Objects.equals(this.message, shipDataResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShipDataResponse {\n");
    
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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
