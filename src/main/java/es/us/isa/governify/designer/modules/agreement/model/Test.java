package es.us.isa.governify.designer.modules.agreement.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-04-19T10:30:51.731Z")
public class Test {

    private String id = null;
    private String description = null;
    private String operationMethod = null;
    private String operationURI = null;
    private Parameter operationParams = null;
    private List<AppResponse> results = new ArrayList<>();

    /**
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("operationMethod")
    public String getOperationMethod() {
        return operationMethod;
    }

    public void setOperationMethod(String operationMethod) {
        this.operationMethod = operationMethod;
    }

    /**
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("operationURI")
    public String getOperationURI() {
        return operationURI;
    }

    public void setOperationURI(String operationURI) {
        this.operationURI = operationURI;
    }

    /**
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("operationParams")
    public Parameter getOperationParams() {
        return operationParams;
    }

    public void setOperationParams(Parameter operationParams) {
        this.operationParams = operationParams;
    }

    /**
     *
     */
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
        return Objects.equals(id, test.id)
                && Objects.equals(description, test.description)
                && Objects.equals(operationMethod, test.operationMethod)
                && Objects.equals(operationURI, test.operationURI)
                && Objects.equals(operationParams, test.operationParams)
                && Objects.equals(results, test.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, operationMethod, operationURI, operationParams, results);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Test {\n");

        sb.append("  id: ").append(id).append("\n");
        sb.append("  description: ").append(description).append("\n");
        sb.append("  operationMethod: ").append(operationMethod).append("\n");
        sb.append("  operationURI: ").append(operationURI).append("\n");
        sb.append("  operationParams: ").append(operationParams).append("\n");
        sb.append("  results: ").append(results).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
