/*
   	* Copyright (c) 2016 {TECNALIA}.
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

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * SearchRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-02-02T14:11:23.419Z")
public class SearchRequest {
  @SerializedName("requesterId")
  private String requesterId = null;

  @SerializedName("query")
  private String query = null;

  @SerializedName("queryName")
  private String queryName = null;

  @SerializedName("dataTypeMap")
  private String dataTypeMap = null;

  @SerializedName("attributeTypeMap")
  private String attributeTypeMap = null;

  @SerializedName("kAnonymity")
  private Integer kAnonymity = null;

   /**
   * Id of the requester in order to perform any filter in case it is needed.
   * @return requesterId
  **/
  @ApiModelProperty(example = "null", value = "Id of the requester in order to perform any filter in case it is needed.")
  public String getRequesterId() {
    return requesterId;
  }

  public void setRequesterId(String requesterId) {
    this.requesterId = requesterId;
  }

  public SearchRequest query(String query) {
    this.query = query;
    return this;
  }

   /**
   * Query encapsulating the set of data units and the personal ids of the people whose personal data is wanted to be received.
   * @return query
  **/
  @ApiModelProperty(example = "null", value = "Query encapsulating the set of data units and the personal ids of the people whose personal data is wanted to be received.")
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public SearchRequest queryName(String queryName) {
    this.queryName = queryName;
    return this;
  }

   /**
   * Name of the query to be executed.
   * @return queryName
  **/
  @ApiModelProperty(example = "null", value = "Name of the query to be executed.")
  public String getQueryName() {
    return queryName;
  }

  public void setQueryName(String queryName) {
    this.queryName = queryName;
  }

  public SearchRequest dataTypeMap(String dataTypeMap) {
    this.dataTypeMap = dataTypeMap;
    return this;
  }

   /**
   * Map containing the data types of the fields referenced in the query (String,Integer,Date...).
   * @return dataTypeMap
  **/
  @ApiModelProperty(example = "null", value = "Map containing the data types of the fields referenced in the query (String,Integer,Date...).")
  public String getDataTypeMap() {
    return dataTypeMap;
  }

  public void setDataTypeMap(String dataTypeMap) {
    this.dataTypeMap = dataTypeMap;
  }

  public SearchRequest attributeTypeMap(String attributeTypeMap) {
    this.attributeTypeMap = attributeTypeMap;
    return this;
  }

   /**
   * Map containing the nature of the fields referenced in the query taking into account annonymization needs (Identifying,Sensitive,Quasy Identifying...).
   * @return attributeTypeMap
  **/
  @ApiModelProperty(example = "null", value = "Map containing the nature of the fields referenced in the query taking into account annonymization needs (Identifying,Sensitive,Quasy Identifying...).")
  public String getAttributeTypeMap() {
    return attributeTypeMap;
  }

  public void setAttributeTypeMap(String attributeTypeMap) {
    this.attributeTypeMap = attributeTypeMap;
  }
   /**
   * kAnonymity parameter.
   * @return kAnonymity
  **/
  @ApiModelProperty(example = "null", value = "kAnonymity parameter.")
  public Integer getKAnonymity() {
    return kAnonymity;
  }

  public void setKAnonymity(Integer kAnonymity) {
    this.kAnonymity = kAnonymity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchRequest searchRequest = (SearchRequest) o;
    return Objects.equals(this.requesterId, searchRequest.requesterId) &&
        Objects.equals(this.query, searchRequest.query) &&
        Objects.equals(this.queryName, searchRequest.queryName) &&
        Objects.equals(this.dataTypeMap, searchRequest.dataTypeMap) &&
        Objects.equals(this.attributeTypeMap, searchRequest.attributeTypeMap) &&
        Objects.equals(this.kAnonymity, searchRequest.kAnonymity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requesterId, query, queryName, dataTypeMap, attributeTypeMap, kAnonymity);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchRequest {\n");
    
    sb.append("    requesterId: ").append(toIndentedString(requesterId)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    queryName: ").append(toIndentedString(queryName)).append("\n");
    sb.append("    dataTypeMap: ").append(toIndentedString(dataTypeMap)).append("\n");
    sb.append("    attributeTypeMap: ").append(toIndentedString(attributeTypeMap)).append("\n");
    sb.append("    kAnonymity: ").append(toIndentedString(kAnonymity)).append("\n");
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
