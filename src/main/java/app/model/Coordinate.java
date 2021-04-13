package app.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Coordinate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-12T15:51:34.057Z[GMT]")


public class Coordinate   {
  @JsonProperty("x")
  private Float x = null;

  @JsonProperty("y")
  private Float y = null;

  public Coordinate(Float x, Float y) {
    this.x = x;
    this.y = y;
  }

  public Coordinate() {
    super();
  }

  public Coordinate x(Float x) {
    this.x = x;
    return this;
  }

  /**
   * Get x
   * @return x
   **/
  @Schema(description = "")
  
    public Float getX() {
    return x;
  }

  public void setX(Float x) {
    this.x = x;
  }

  public Coordinate y(Float y) {
    this.y = y;
    return this;
  }

  /**
   * Get y
   * @return y
   **/
  @Schema(description = "")
  
    public Float getY() {
    return y;
  }

  public void setY(Float y) {
    this.y = y;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coordinate coordinate = (Coordinate) o;
    return Objects.equals(this.x, coordinate.x) &&
        Objects.equals(this.y, coordinate.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coordinate {\n");
    
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
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
