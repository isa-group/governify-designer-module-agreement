package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Syntax supported by the model.
 **/

@ApiModel(description = "Syntax supported by the model.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-22T12:03:26.044+01:00")
public class Syntax   {
  
  private String id = null;
  private Boolean readOnly = null;

  
  /**
   * Identifier of this syntax.
   **/
  
  @ApiModelProperty(value = "Identifier of this syntax.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Indicates whether the documents in this syntax are read-only or not.
   **/
  
  @ApiModelProperty(value = "Indicates whether the documents in this syntax are read-only or not.")
  @JsonProperty("readOnly")
  public Boolean getReadOnly() {
    return readOnly;
  }
  public void setReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Syntax syntax = (Syntax) o;
    return Objects.equals(id, syntax.id) &&
        Objects.equals(readOnly, syntax.readOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, readOnly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Syntax {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
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

