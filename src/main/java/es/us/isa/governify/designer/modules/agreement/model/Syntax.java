package es.us.isa.governify.designer.modules.agreement.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Syntax supported by the model.
 *
 */
@ApiModel(description = "Syntax supported by the model.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-22T12:03:26.044+01:00")
public class Syntax {

    private String id = null;
    private Boolean readOnly = null;
    private Boolean syntaxCheck = null;
    private String editorModeId = null;
    private String editorModeURI = null;
    private String editorThemeId = null;
    private String editorThemeURI = null;

    /**
     * Identifier of this syntax.
   *
     */
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
   *
     */
    @ApiModelProperty(value = "Indicates whether the documents in this syntax are read-only or not.")
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    
    @ApiModelProperty(value = "Indicates whether the documents in this syntax must be checked or not.")
    @JsonProperty("syntaxCheck")
    public Boolean getSyntaxCheck() {
        return syntaxCheck;
    }

    public void setSyntaxCheck(Boolean syntaxCheck) {
        this.syntaxCheck = syntaxCheck;
    }

    @JsonProperty("editorModeId")
    public String getEditorModeId() {
        return editorModeId;
    }

    public void setEditorModeId(String editorModeId) {
        this.editorModeId = editorModeId;
    }

    @JsonProperty("editorModeURI")
    public String getEditorModeURI() {
        return editorModeURI;
    }

    public void setEditorModeURI(String editorModeURI) {
        this.editorModeURI = editorModeURI;
    }

    @JsonProperty("editorThemeId")
    public String getEditorThemeId() {
        return editorThemeId;
    }

    public void setEditorThemeId(String editorThemeId) {
        this.editorThemeId = editorThemeId;
    }

    @JsonProperty("editorThemeURI")
    public String getEditorThemeURI() {
        return editorThemeURI;
    }

    public void setEditorThemeURI(String editorThemeURI) {
        this.editorThemeURI = editorThemeURI;
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
        return Objects.equals(id, syntax.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
