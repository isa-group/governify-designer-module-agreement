package es.us.isa.governify.designer.modules.agreement.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import es.us.isa.governify.designer.modules.agreement.model.AppAnnotation;
import java.util.*;



/**
 * Application response.
 **/

@ApiModel(description = "Application response.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-22T12:03:26.044+01:00")
public class AppResponse   {
  


  public enum StatusEnum {
    OK("OK"),
    OK_PROBLEMS("OK_PROBLEMS"),
    ERROR("ERROR"),
    SESSION_ERROR("SESSION_ERROR");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private StatusEnum status = null;
  private String message = null;
  private String data = null;
  private List<AppAnnotation> annotations = new ArrayList<AppAnnotation>();

  
  /**
   * Status of the response.
   **/
  
  @ApiModelProperty(value = "Status of the response.")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  
  /**
   * Message of the response.
   **/
  
  @ApiModelProperty(value = "Message of the response.")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  
  /**
   * Attached data to the response.
   **/
  
  @ApiModelProperty(value = "Attached data to the response.")
  @JsonProperty("data")
  public String getData() {
    return data;
  }
  public void setData(String data) {
    this.data = data;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("annotations")
  public List<AppAnnotation> getAnnotations() {
    return annotations;
  }
  public void setAnnotations(List<AppAnnotation> annotations) {
    this.annotations = annotations;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppResponse appResponse = (AppResponse) o;
    return Objects.equals(status, appResponse.status) &&
        Objects.equals(message, appResponse.message) &&
        Objects.equals(data, appResponse.data) &&
        Objects.equals(annotations, appResponse.annotations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, message, data, annotations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    annotations: ").append(toIndentedString(annotations)).append("\n");
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

