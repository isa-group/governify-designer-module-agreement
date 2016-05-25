package es.us.isa.governify.designer.modules.agreement.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-02-22T12:03:26.044+01:00")
public class Config {

    private String modalTitle = null;
    private String modalDescription = null;
    private String filter = null;
    

    @ApiModelProperty(value = "")
    @JsonProperty("modalTitle")
    public String getModalTitle() {
        return modalTitle;
    }

    public void setModalTitle(String modalTitle) {
        this.modalTitle = modalTitle;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("modalDescription")
    public String getModalDescription() {
        return modalDescription;
    }

    public void setModalDescription(String modalDescription) {
        this.modalDescription = modalDescription;
    }

    /**
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("filter")
    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Config config = (Config) o;
        return Objects.equals(filter, config.filter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filter);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Config {\n");

        sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
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
