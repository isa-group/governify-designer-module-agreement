package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AppResponse;
import java.util.*;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-22T12:03:26.044+01:00")
public class Test   {
  
  private String id = null;
  private String description = null;
  private String operationURI = null;
  private String operationMethod = null;
  private String parameters = null;
  private List<AppResponse> results = new ArrayList<AppResponse>();

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("operationURI")
  public String getOperationURI() {
    return operationURI;
  }
  public void setOperationURI(String operationURI) {
    this.operationURI = operationURI;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("operationMethod")
  public String getOperationMethod() {
    return operationMethod;
  }
  public void setOperationMethod(String operationMethod) {
    this.operationMethod = operationMethod;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("parameters")
  public String getParameters() {
    return parameters;
  }
  public void setParameters(String parameters) {
    this.parameters = parameters;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("results")
  public List<AppResponse> getResults() {
    return results;
  }
  public void setResults(List<AppResponse> results) {
    this.results = results;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Test test = (Test) o;
    return Objects.equals(id, test.id) &&
        Objects.equals(description, test.description) &&
        Objects.equals(operationURI, test.operationURI) &&
        Objects.equals(operationMethod, test.operationMethod) &&
        Objects.equals(parameters, test.parameters) &&
        Objects.equals(results, test.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, operationURI, operationMethod, parameters, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Test {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    operationURI: ").append(toIndentedString(operationURI)).append("\n");
    sb.append("    operationMethod: ").append(toIndentedString(operationMethod)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

