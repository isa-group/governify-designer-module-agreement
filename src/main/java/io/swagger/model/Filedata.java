package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-22T12:03:26.044+01:00")
public class Filedata   {
  
  private String fileUri = null;
  private String content = null;

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("fileUri")
  public String getFileUri() {
    return fileUri;
  }
  public void setFileUri(String fileUri) {
    this.fileUri = fileUri;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("content")
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Filedata filedata = (Filedata) o;
    return Objects.equals(fileUri, filedata.fileUri) &&
        Objects.equals(content, filedata.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileUri, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Filedata {\n");
    
    sb.append("    fileUri: ").append(toIndentedString(fileUri)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

