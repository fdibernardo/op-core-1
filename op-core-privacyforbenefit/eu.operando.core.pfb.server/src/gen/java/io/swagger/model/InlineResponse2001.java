/*
   	* Copyright (c) 2017 {TECNALIA}.
    * All rights reserved. This program and the accompanying materials
    * are made available under the terms of the The MIT License (MIT).
    * which accompanies this distribution, and is available at
    * http://opensource.org/licenses/MIT
    *
    * Contributors:
    *    Gorka Benguria Elguezabal {TECNALIA}
    *    Gorka Mikel Echevarría {TECNALIA}
    * Initially developed in the context of OPERANDO EU project www.operando.eu
 */
package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-10T07:14:29.764Z")
public class InlineResponse2001   {
  
  private Object data = null;

  /**
   **/
  public InlineResponse2001 data(Object data) {
    this.data = data;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("data")
  public Object getData() {
    return data;
  }
  public void setData(Object data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(data, inlineResponse2001.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

