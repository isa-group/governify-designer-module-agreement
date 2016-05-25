package es.us.isa.governify.designer.modules.agreement.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * Application annotations.
 **/
@ApiModel(description = "Application annotations.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-04-18T10:25:59.389Z")
public class AppAnnotation  {
  
  public enum TypeEnum {
     info,  warning,  error,  fatal, 
  };
  
  private TypeEnum type = null;
  private Integer row = null;
  private Integer column = null;
  private String text = null;

  /**
   * Severity of the annotation.
   **/
  @ApiModelProperty(value = "Severity of the annotation.")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /**
   * Annotation line.
   **/
  @ApiModelProperty(value = "Annotation line.")
  @JsonProperty("row")
  public Integer getRow() {
    return row;
  }
  public void setRow(Integer row) {
    this.row = row;
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
  @JsonProperty("text")
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
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
    return Objects.equals(type, appAnnotation.type) &&
        Objects.equals(row, appAnnotation.row) &&
        Objects.equals(column, appAnnotation.column) &&
        Objects.equals(text, appAnnotation.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, row, column, text);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppAnnotation {\n");
    
    sb.append("  type: ").append(type).append("\n");
    sb.append("  row: ").append(row).append("\n");
    sb.append("  column: ").append(column).append("\n");
    sb.append("  text: ").append(text).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
