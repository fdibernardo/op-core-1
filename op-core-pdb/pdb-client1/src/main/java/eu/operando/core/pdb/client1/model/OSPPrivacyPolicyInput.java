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
import eu.operando.core.pdb.client1.model.AccessPolicy;
import eu.operando.core.pdb.client1.model.OSPDataRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * OSPPrivacyPolicyInput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-07-13T14:33:54.425Z")
public class OSPPrivacyPolicyInput {
  @SerializedName("policy_text")
  private String policyText = null;

  @SerializedName("policy_url")
  private String policyUrl = null;

  @SerializedName("workflow")
  private List<OSPDataRequest> workflow = new ArrayList<OSPDataRequest>();

  @SerializedName("policies")
  private List<AccessPolicy> policies = new ArrayList<AccessPolicy>();

  public OSPPrivacyPolicyInput policyText(String policyText) {
    this.policyText = policyText;
    return this;
  }

   /**
   * The content of the OSP privacy policy, textually described and published. It is a the full text adverstised by the OSP. 
   * @return policyText
  **/
  @ApiModelProperty(example = "null", value = "The content of the OSP privacy policy, textually described and published. It is a the full text adverstised by the OSP. ")
  public String getPolicyText() {
    return policyText;
  }

  public void setPolicyText(String policyText) {
    this.policyText = policyText;
  }

  public OSPPrivacyPolicyInput policyUrl(String policyUrl) {
    this.policyUrl = policyUrl;
    return this;
  }

   /**
   * The url location of the privacy policy of the OSP 
   * @return policyUrl
  **/
  @ApiModelProperty(example = "null", value = "The url location of the privacy policy of the OSP ")
  public String getPolicyUrl() {
    return policyUrl;
  }

  public void setPolicyUrl(String policyUrl) {
    this.policyUrl = policyUrl;
  }

  public OSPPrivacyPolicyInput workflow(List<OSPDataRequest> workflow) {
    this.workflow = workflow;
    return this;
  }

  public OSPPrivacyPolicyInput addWorkflowItem(OSPDataRequest workflowItem) {
    this.workflow.add(workflowItem);
    return this;
  }

   /**
   * The sequence of requests that this OSP makes (simple ordered array list in this version). The requests describes the operations that the OSP may carry out on the data. This can be used for compliance checking and computation of user policies. 
   * @return workflow
  **/
  @ApiModelProperty(example = "null", value = "The sequence of requests that this OSP makes (simple ordered array list in this version). The requests describes the operations that the OSP may carry out on the data. This can be used for compliance checking and computation of user policies. ")
  public List<OSPDataRequest> getWorkflow() {
    return workflow;
  }

  public void setWorkflow(List<OSPDataRequest> workflow) {
    this.workflow = workflow;
  }

  public OSPPrivacyPolicyInput policies(List<AccessPolicy> policies) {
    this.policies = policies;
    return this;
  }

  public OSPPrivacyPolicyInput addPoliciesItem(AccessPolicy policiesItem) {
    this.policies.add(policiesItem);
    return this;
  }

   /**
   * The list of rights that the OSP intends to follow e.g. give X access to Y data for Z purpose. This information can then be used in calculation of the policy and in compliance checking. 
   * @return policies
  **/
  @ApiModelProperty(example = "null", value = "The list of rights that the OSP intends to follow e.g. give X access to Y data for Z purpose. This information can then be used in calculation of the policy and in compliance checking. ")
  public List<AccessPolicy> getPolicies() {
    return policies;
  }

  public void setPolicies(List<AccessPolicy> policies) {
    this.policies = policies;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OSPPrivacyPolicyInput osPPrivacyPolicyInput = (OSPPrivacyPolicyInput) o;
    return Objects.equals(this.policyText, osPPrivacyPolicyInput.policyText) &&
        Objects.equals(this.policyUrl, osPPrivacyPolicyInput.policyUrl) &&
        Objects.equals(this.workflow, osPPrivacyPolicyInput.workflow) &&
        Objects.equals(this.policies, osPPrivacyPolicyInput.policies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(policyText, policyUrl, workflow, policies);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OSPPrivacyPolicyInput {\n");
    
    sb.append("    policyText: ").append(toIndentedString(policyText)).append("\n");
    sb.append("    policyUrl: ").append(toIndentedString(policyUrl)).append("\n");
    sb.append("    workflow: ").append(toIndentedString(workflow)).append("\n");
    sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
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

