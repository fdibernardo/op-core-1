package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.DataUnitValuePerAccessLevel;
import java.util.ArrayList;
import java.util.List;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-03-11T13:10:20.376Z")
public class DataUnit   {
  
  private String id = null;
  private String description = null;
  private List<DataUnitValuePerAccessLevel> valuesPerAccessLevel = new ArrayList<DataUnitValuePerAccessLevel>();

  
  /**
   * Id of the data unit.
   **/
  public DataUnit id(String id) {
    this.id = id;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Id of the data unit.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Description of the data unit.
   **/
  public DataUnit description(String description) {
    this.description = description;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Description of the data unit.")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   **/
  public DataUnit valuesPerAccessLevel(List<DataUnitValuePerAccessLevel> valuesPerAccessLevel) {
    this.valuesPerAccessLevel = valuesPerAccessLevel;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("valuesPerAccessLevel")
  public List<DataUnitValuePerAccessLevel> getValuesPerAccessLevel() {
    return valuesPerAccessLevel;
  }
  public void setValuesPerAccessLevel(List<DataUnitValuePerAccessLevel> valuesPerAccessLevel) {
    this.valuesPerAccessLevel = valuesPerAccessLevel;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataUnit dataUnit = (DataUnit) o;
    return Objects.equals(this.id, dataUnit.id) &&
        Objects.equals(this.description, dataUnit.description) &&
        Objects.equals(this.valuesPerAccessLevel, dataUnit.valuesPerAccessLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, valuesPerAccessLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataUnit {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    valuesPerAccessLevel: ").append(toIndentedString(valuesPerAccessLevel)).append("\n");
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

