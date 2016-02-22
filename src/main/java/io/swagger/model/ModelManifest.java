package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Operation;
import io.swagger.model.Syntax;
import java.util.*;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-22T12:03:26.044+01:00")
public class ModelManifest   {
  
  private String id = null;
  private String extension = null;
  private String name = null;
  private List<Syntax> syntaxes = new ArrayList<Syntax>();
  private List<Operation> operations = new ArrayList<Operation>();

  
  /**
   * Unique identifier representing the model supported by the module.
   **/
  
  @ApiModelProperty(value = "Unique identifier representing the model supported by the module.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Extension of the files belonging to this model.
   **/
  
  @ApiModelProperty(value = "Extension of the files belonging to this model.")
  @JsonProperty("extension")
  public String getExtension() {
    return extension;
  }
  public void setExtension(String extension) {
    this.extension = extension;
  }

  
  /**
   * Name of the model.
   **/
  
  @ApiModelProperty(value = "Name of the model.")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * List containing the syntax supported by this model.
   **/
  
  @ApiModelProperty(value = "List containing the syntax supported by this model.")
  @JsonProperty("syntaxes")
  public List<Syntax> getSyntaxes() {
    return syntaxes;
  }
  public void setSyntaxes(List<Syntax> syntaxes) {
    this.syntaxes = syntaxes;
  }

  
  /**
   * List containing the operations supported by this model.
   **/
  
  @ApiModelProperty(value = "List containing the operations supported by this model.")
  @JsonProperty("operations")
  public List<Operation> getOperations() {
    return operations;
  }
  public void setOperations(List<Operation> operations) {
    this.operations = operations;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelManifest modelManifest = (ModelManifest) o;
    return Objects.equals(id, modelManifest.id) &&
        Objects.equals(extension, modelManifest.extension) &&
        Objects.equals(name, modelManifest.name) &&
        Objects.equals(syntaxes, modelManifest.syntaxes) &&
        Objects.equals(operations, modelManifest.operations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, extension, name, syntaxes, operations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelManifest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    syntaxes: ").append(toIndentedString(syntaxes)).append("\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
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

