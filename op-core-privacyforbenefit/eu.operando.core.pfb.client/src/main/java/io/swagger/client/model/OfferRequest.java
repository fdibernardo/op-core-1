package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


/**
 * OfferRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-06-10T07:22:24.300Z")
public class OfferRequest   {
  
  private String ospId = null;
  private String title = null;
  private String description = null;
  private String serviceWebsite = null;
  private Boolean isEnabled = null;
  private String ospCallbackUrl = null;
  private Date expirationDate = null;

  
  /**
   * Id of the OSP to which belongs the offer.
   **/
  public OfferRequest ospId(String ospId) {
    this.ospId = ospId;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Id of the OSP to which belongs the offer.")
  @JsonProperty("osp_id")
  public String getOspId() {
    return ospId;
  }
  public void setOspId(String ospId) {
    this.ospId = ospId;
  }


  /**
   * Description of the offer.
   **/
  public OfferRequest title(String title) {
    this.title = title;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Description of the offer.")
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }


  /**
   * Description of the offer.
   **/
  public OfferRequest description(String description) {
    this.description = description;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Description of the offer.")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }


  /**
   * Website of the offering.
   **/
  public OfferRequest serviceWebsite(String serviceWebsite) {
    this.serviceWebsite = serviceWebsite;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Website of the offering.")
  @JsonProperty("service_website")
  public String getServiceWebsite() {
    return serviceWebsite;
  }
  public void setServiceWebsite(String serviceWebsite) {
    this.serviceWebsite = serviceWebsite;
  }


  /**
   * Indication whether the offer is enabled or not.
   **/
  public OfferRequest isEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Indication whether the offer is enabled or not.")
  @JsonProperty("is_enabled")
  public Boolean getIsEnabled() {
    return isEnabled;
  }
  public void setIsEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
  }


  /**
   * Callback url.
   **/
  public OfferRequest ospCallbackUrl(String ospCallbackUrl) {
    this.ospCallbackUrl = ospCallbackUrl;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Callback url.")
  @JsonProperty("osp_callback_url")
  public String getOspCallbackUrl() {
    return ospCallbackUrl;
  }
  public void setOspCallbackUrl(String ospCallbackUrl) {
    this.ospCallbackUrl = ospCallbackUrl;
  }


  /**
   * Date when the offer expires.
   **/
  public OfferRequest expirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Date when the offer expires.")
  @JsonProperty("expiration_date")
  public Date getExpirationDate() {
    return expirationDate;
  }
  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfferRequest offerRequest = (OfferRequest) o;
    return Objects.equals(this.ospId, offerRequest.ospId) &&
        Objects.equals(this.title, offerRequest.title) &&
        Objects.equals(this.description, offerRequest.description) &&
        Objects.equals(this.serviceWebsite, offerRequest.serviceWebsite) &&
        Objects.equals(this.isEnabled, offerRequest.isEnabled) &&
        Objects.equals(this.ospCallbackUrl, offerRequest.ospCallbackUrl) &&
        Objects.equals(this.expirationDate, offerRequest.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ospId, title, description, serviceWebsite, isEnabled, ospCallbackUrl, expirationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfferRequest {\n");
    
    sb.append("    ospId: ").append(toIndentedString(ospId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    serviceWebsite: ").append(toIndentedString(serviceWebsite)).append("\n");
    sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
    sb.append("    ospCallbackUrl: ").append(toIndentedString(ospCallbackUrl)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
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

