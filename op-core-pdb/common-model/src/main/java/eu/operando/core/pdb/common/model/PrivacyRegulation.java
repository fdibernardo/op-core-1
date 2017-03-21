/////////////////////////////////////////////////////////////////////////
//
// © University of Southampton IT Innovation Centre, 2016
//
// Copyright in this software belongs to University of Southampton
// IT Innovation Centre of Gamma House, Enterprise Road,
// Chilworth Science Park, Southampton, SO16 7NS, UK.
//
// This software may not be used, sold, licensed, transferred, copied
// or reproduced in whole or in part in any manner or form or in or
// on any media by any person other than in accordance with the terms
// of the Licence Agreement supplied with the software, or otherwise
// without the prior written consent of the copyright owners.
//
// This software is distributed WITHOUT ANY WARRANTY, without even the
// implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
// PURPOSE, except where stated in the Licence Agreement supplied with
// the software.
//
//      Created By :            Panos Melas
//      Created Date :          2017-03-21
//      Created for Project :   OPERANDO
//
/////////////////////////////////////////////////////////////////////////

/*
 * OSP Enforcement (OSE)
 *  The OSP enforcement component provides a set of functions that manage the interaction of OSP behaviour with the user's private data. The OSE component is largely in charge of ensuring that an OSP follows both privacy regulations and policies put in place by the user (i.e. in the OPERANDO UPPs). There are a set of events that trigger the usage of this API.  1) When a new G2C OSP registers with OPERANDO via the OPERANDO console. The management console informs the OSE, which then checks that an OSP conforms with existing privacy regulations; if it breaches the regulations, the OSE returns via the management console a report describing the breaches.  2) When a change of OSP privacy policy or of the OSP's privacy settings are detected by the watchdog component. The watchdog component sends a message to a privacy analyst who reviews any changes. The privacy analyst may then inform the OSE of the new OSP information (to be checked for compliance with regulations and users' UPPs.  3) When a privacy legislation is entered (or changed) via the Regulator API. The OSE checks registered OSPs for compliance with the new regulations; where there is a breach the OSP is notified either by e-mail or the console.
 *
 * OpenAPI spec version: 0.0.8
 * Contact: support@operando.eu
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package eu.operando.core.pdb.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A privacy rule that reflects a given privacy legislation as described by a particular set of laws in a given jurisdiction.
 */
@ApiModel(description = "A privacy rule that reflects a given privacy legislation as described by a particular set of laws in a given jurisdiction. ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-19T14:47:13.883Z")
public class PrivacyRegulation   {
  @JsonProperty("reg_id")
  private String regId = null;

  @JsonProperty("legislation_sector")
  private String legislationSector = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("private_information_type")
  private String privateInformationType = null;

  @JsonProperty("action")
  private String action = null;

  @JsonProperty("required_consent")
  private String requiredConsent = null;

  public PrivacyRegulation regId(String regId) {
    this.regId = regId;
    return this;
  }

   /**
   * Get regId
   * @return regId
  **/
  @JsonProperty("reg_id")
  @ApiModelProperty(value = "")
  public String getRegId() {
    return regId;
  }

  public void setRegId(String regId) {
    this.regId = regId;
  }

  public PrivacyRegulation legislationSector(String legislationSector) {
    this.legislationSector = legislationSector;
    return this;
  }

   /**
   * The identifier of the set of legislation rules this rule belongs to e.g. the UK data protection act.
   * @return legislationSector
  **/
  @JsonProperty("legislation_sector")
  @ApiModelProperty(required = true, value = "The identifier of the set of legislation rules this rule belongs to e.g. the UK data protection act. ")
  public String getLegislationSector() {
    return legislationSector;
  }

  public void setLegislationSector(String legislationSector) {
    this.legislationSector = legislationSector;
  }

  public PrivacyRegulation reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * The purpose for performing an action on data e.g. medical care, marketing, admin
   * @return reason
  **/
  @JsonProperty("reason")
  @ApiModelProperty(value = "The purpose for performing an action on data e.g. medical care, marketing, admin")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public PrivacyRegulation privateInformationType(String privateInformationType) {
    this.privateInformationType = privateInformationType;
    return this;
  }

   /**
   * The type of private information; e.g. is it information that identifies the user (e.g. id number)? is it location information about the user? Is it about their activities?
   * @return privateInformationType
  **/
  @JsonProperty("private_information_type")
  @ApiModelProperty(value = "The type of private information; e.g. is it information that identifies the user (e.g. id number)? is it location information about the user? Is it about their activities? ")
  public String getPrivateInformationType() {
    return privateInformationType;
  }

  public void setPrivateInformationType(String privateInformationType) {
    this.privateInformationType = privateInformationType;
  }

  public PrivacyRegulation action(String action) {
    this.action = action;
    return this;
  }

   /**
   * The action being carried out on the data
   * @return action
  **/
  @JsonProperty("action")
  @ApiModelProperty(value = "The action being carried out on the data")
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public PrivacyRegulation requiredConsent(String requiredConsent) {
    this.requiredConsent = requiredConsent;
    return this;
  }

   /**
   * The type of consent that must be followed
   * @return requiredConsent
  **/
  @JsonProperty("required_consent")
  @ApiModelProperty(value = "The type of consent that must be followed")
  public String getRequiredConsent() {
    return requiredConsent;
  }

  public void setRequiredConsent(String requiredConsent) {
    this.requiredConsent = requiredConsent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrivacyRegulation privacyRegulation = (PrivacyRegulation) o;
    return Objects.equals(this.regId, privacyRegulation.regId) &&
        Objects.equals(this.legislationSector, privacyRegulation.legislationSector) &&
        Objects.equals(this.reason, privacyRegulation.reason) &&
        Objects.equals(this.privateInformationType, privacyRegulation.privateInformationType) &&
        Objects.equals(this.action, privacyRegulation.action) &&
        Objects.equals(this.requiredConsent, privacyRegulation.requiredConsent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regId, legislationSector, reason, privateInformationType, action, requiredConsent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrivacyRegulation {\n");

    sb.append("    regId: ").append(toIndentedString(regId)).append("\n");
    sb.append("    legislationSector: ").append(toIndentedString(legislationSector)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    privateInformationType: ").append(toIndentedString(privateInformationType)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    requiredConsent: ").append(toIndentedString(requiredConsent)).append("\n");
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

