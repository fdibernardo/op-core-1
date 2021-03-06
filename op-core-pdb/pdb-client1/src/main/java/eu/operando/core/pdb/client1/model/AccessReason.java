/*
 * Policy DB
 * The Policy Database that stores three types of documents in dedicated collections.   1) User Privacy Policy. Each OPERANDO user has one UPP document describing their privacy policies for each of the OSP services they are subscribed to. The UPP contains the current B2C privacy settings for a subscribed to OSP. The UPP contains the users privacy preferences. The UPP contains the G2C access policies for the OSP with justification for access.   2) The legislation policies. The regulations entered into OPERANDO using the OPERANDO regulation API.   3) The OSP descriptions and data requests. For each OSP its privacy policy, its access control rules, and the data it requests (as a workflow). For B2C, the set of privacy settings is stored. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: support@operando.eu
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package eu.operando.core.pdb.client1.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AccessReason
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-07-13T14:33:54.425Z")
public class AccessReason {
  @SerializedName("reasonid")
  private String reasonid = null;

  @SerializedName("datauser")
  private String datauser = null;

  @SerializedName("datasubjecttype")
  private String datasubjecttype = null;

  @SerializedName("datatype")
  private String datatype = null;

  @SerializedName("reason")
  private String reason = null;

  public AccessReason reasonid(String reasonid) {
    this.reasonid = reasonid;
    return this;
  }

   /**
   * An identifier within this privacy policy e.g osp_reason1. This is not globally unique and is defined by the OSP. However, OSP must ensure that  identifiers are unique within the policy list. 
   * @return reasonid
  **/
  @ApiModelProperty(example = "null", value = "An identifier within this privacy policy e.g osp_reason1. This is not globally unique and is defined by the OSP. However, OSP must ensure that  identifiers are unique within the policy list. ")
  public String getReasonid() {
    return reasonid;
  }

  public void setReasonid(String reasonid) {
    this.reasonid = reasonid;
  }

  public AccessReason datauser(String datauser) {
    this.datauser = datauser;
    return this;
  }

   /**
   * Who is using the data. 
   * @return datauser
  **/
  @ApiModelProperty(example = "null", value = "Who is using the data. ")
  public String getDatauser() {
    return datauser;
  }

  public void setDatauser(String datauser) {
    this.datauser = datauser;
  }

  public AccessReason datasubjecttype(String datasubjecttype) {
    this.datasubjecttype = datasubjecttype;
    return this;
  }

   /**
   * What is the type or group of the user this private data concerns e.g. patient, helper etc. 
   * @return datasubjecttype
  **/
  @ApiModelProperty(example = "null", value = "What is the type or group of the user this private data concerns e.g. patient, helper etc. ")
  public String getDatasubjecttype() {
    return datasubjecttype;
  }

  public void setDatasubjecttype(String datasubjecttype) {
    this.datasubjecttype = datasubjecttype;
  }

  public AccessReason datatype(String datatype) {
    this.datatype = datatype;
    return this;
  }

   /**
   * What is the type of data this refers to e.g. e-mail address, medical record etc. 
   * @return datatype
  **/
  @ApiModelProperty(example = "null", value = "What is the type of data this refers to e.g. e-mail address, medical record etc. ")
  public String getDatatype() {
    return datatype;
  }

  public void setDatatype(String datatype) {
    this.datatype = datatype;
  }

  public AccessReason reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * Usage of this information if for what purpose e.g. marketing, healthcare delivery. 
   * @return reason
  **/
  @ApiModelProperty(example = "null", value = "Usage of this information if for what purpose e.g. marketing, healthcare delivery. ")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessReason accessReason = (AccessReason) o;
    return Objects.equals(this.reasonid, accessReason.reasonid) &&
        Objects.equals(this.datauser, accessReason.datauser) &&
        Objects.equals(this.datasubjecttype, accessReason.datasubjecttype) &&
        Objects.equals(this.datatype, accessReason.datatype) &&
        Objects.equals(this.reason, accessReason.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reasonid, datauser, datasubjecttype, datatype, reason);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessReason {\n");
    
    sb.append("    reasonid: ").append(toIndentedString(reasonid)).append("\n");
    sb.append("    datauser: ").append(toIndentedString(datauser)).append("\n");
    sb.append("    datasubjecttype: ").append(toIndentedString(datasubjecttype)).append("\n");
    sb.append("    datatype: ").append(toIndentedString(datatype)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

