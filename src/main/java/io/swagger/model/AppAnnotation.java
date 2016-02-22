package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Application annotations.
 **/

@ApiModel(description = "Application annotations.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-22T12:03:26.044+01:00")
public class AppAnnotation   {
  


  public enum SeverityEnum {
    INFO("INFO"),
    WARNING("WARNING"),
    ERROR("ERROR"),
    FATAL("FATAL");

    private String value;

    SeverityEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private SeverityEnum severity = null;
  private Integer line = null;
  private Integer column = null;
  private String message = null;

  
  /**
   * Severity of the annotation.
   **/
  
  @ApiModelProperty(value = "Severity of the annotation.")
  @JsonProperty("severity")
  public SeverityEnum getSeverity() {
    return severity;
  }
  public void setSeverity(SeverityEnum severity) {
    this.severity = severity;
  }

  
  /**
   * Annotation line.
   **/
  
  @ApiModelProperty(value = "Annotation line.")
  @JsonProperty("line")
  public Integer getLine() {
    return line;
  }
  public void setLine(Integer line) {
    this.line = line;
  }

  
  /**
   * Annotation column.
   **/
  
  @ApiModelProperty(value = "Annotation column.")
  @JsonProperty("column")
  public Integer getColumn() {
    return column;
  }
  public void setColumn(Integer column) {
    this.column = column;
  }

  
  /**
   * Annotation message.
   **/
  
  @ApiModelProperty(value = "Annotation message.")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppAnnotation appAnnotation = (AppAnnotation) o;
    return Objects.equals(severity, appAnnotation.severity) &&
        Objects.equals(line, appAnnotation.line) &&
        Objects.equals(column, appAnnotation.column) &&
        Objects.equals(message, appAnnotation.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(severity, line, column, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppAnnotation {\n");
    
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
    sb.append("    column: ").append(toIndentedString(column)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

