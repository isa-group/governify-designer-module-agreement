package es.us.isa.governify.designer.modules.agreement.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Operation supported by the model.
 *
 */
@ApiModel(description = "Operation supported by the model.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-22T12:03:26.044+01:00")
public class Operation {

    private String id = null;
    private String name = null;
    private String description = null;
    private String type = null;
    private Config config = null;

    /**
     * Unique identifier representing this operation, i.e. \"checkValidity\"
   *
     */
    @ApiModelProperty(value = "Unique identifier representing this operation, i.e. \"checkValidity\"")
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name of this operation, i.e. \"Check validity\"
   *
     */
    @ApiModelProperty(value = "Name of this operation, i.e. \"Check validity\"")
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Description of this operation, i.e. \"Check if document is valid.\"
   *
     */
    @ApiModelProperty(value = "Description of this operation, i.e. \"Check if document is valid.\"")
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Type of the operation. Can be \"simple\", \"requireFile\" or
     * \"createFile\"
   *
     */
    @ApiModelProperty(value = "Type of the operation. Can be \"simple\", \"requireFile\" or \"createFile\"")
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("config")
    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operation operation = (Operation) o;
        return Objects.equals(id, operation.id)
                && Objects.equals(name, operation.name)
                && Objects.equals(description, operation.description)
                && Objects.equals(type, operation.type)
                && Objects.equals(config, operation.config);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, type, config);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Operation {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    config: ").append(toIndentedString(config)).append("\n");
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
