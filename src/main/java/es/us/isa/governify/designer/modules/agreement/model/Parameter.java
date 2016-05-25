package es.us.isa.governify.designer.modules.agreement.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-04-19T10:30:51.731Z")
public class Parameter {

    private String modelId = null;
    private String operationId = null;
    private List<Filedata> data = new ArrayList<>();

    /**
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("modelId")
    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    /**
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("operationId")
    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    /**
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("data")
    public List<Filedata> getData() {
        return data;
    }

    public void setData(List<Filedata> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parameter parameter = (Parameter) o;
        return Objects.equals(modelId, parameter.modelId)
                && Objects.equals(operationId, parameter.operationId)
                && Objects.equals(data, parameter.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelId, operationId, data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Parameter {\n");

        sb.append("  modelId: ").append(modelId).append("\n");
        sb.append("  operationId: ").append(operationId).append("\n");
        sb.append("  data: ").append(data).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
