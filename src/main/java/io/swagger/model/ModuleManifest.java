package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;
import org.springframework.stereotype.Component;

@Component
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-22T12:03:26.044+01:00")
public class ModuleManifest extends AbstractModuleManifest {

    private String id = null;
    private String title = null;
    private String description = null;
    private String apiVersion = null;
    private String helpUri = null;
    private List<ModelManifest> models = new ArrayList<>();

    /**
     * Unique identifier representing the module.
   *
     */
    @ApiModelProperty(value = "Unique identifier representing the module.")
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Title of the module.
   *
     */
    @ApiModelProperty(value = "Title of the module.")
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Description of the module.
   *
     */
    @ApiModelProperty(value = "Description of the module.")
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Version of module.
   *
     */
    @ApiModelProperty(value = "Version of module.")
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Help URI of module.
   *
     */
    @ApiModelProperty(value = "Help URI of module.")
    @JsonProperty("helpUri")
    public String getHelpUri() {
        return helpUri;
    }

    public void setHelpUri(String helpUri) {
        this.helpUri = helpUri;
    }

    /**
     * List containing the models supported by this module.
   *
     */
    @ApiModelProperty(value = "List containing the models supported by this module.")
    @JsonProperty("models")
    public List<ModelManifest> getModels() {
        return models;
    }

    public void setModels(List<ModelManifest> models) {
        this.models = models;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModuleManifest moduleManifest = (ModuleManifest) o;
        return Objects.equals(id, moduleManifest.id)
                && Objects.equals(title, moduleManifest.title)
                && Objects.equals(description, moduleManifest.description)
                && Objects.equals(apiVersion, moduleManifest.apiVersion)
                && Objects.equals(helpUri, moduleManifest.helpUri)
                && Objects.equals(models, moduleManifest.models);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, apiVersion, helpUri, models);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModuleManifest {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
        sb.append("    helpUri: ").append(toIndentedString(helpUri)).append("\n");
        sb.append("    models: ").append(toIndentedString(models)).append("\n");
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
