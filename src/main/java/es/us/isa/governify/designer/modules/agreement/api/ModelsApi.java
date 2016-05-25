package es.us.isa.governify.designer.modules.agreement.api;

import com.google.gson.Gson;
import es.us.isa.governify.designer.modules.agreement.model.ModelManifest;
import es.us.isa.governify.designer.modules.agreement.model.Operation;
import es.us.isa.governify.designer.modules.agreement.model.AppResponse;
import es.us.isa.governify.designer.modules.agreement.model.Filedata;
import es.us.isa.governify.designer.modules.agreement.model.Syntax;
import es.us.isa.governify.designer.modules.agreement.model.Test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import es.us.isa.governify.designer.modules.agreement.model.ModuleManifest;
import es.us.isa.governify.designer.modules.agreement.model.Parameter;
import es.us.isa.governify.designer.modules.agreement.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.http.MediaType.*;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/api/v2/models", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/models")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-02-16T11:47:24.773+01:00")
public class ModelsApi {

    private static final Logger LOG = Logger.getLogger(ModelsApi.class.getName());

    @Autowired
    private ModuleManifest module;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private class ResourceNotFoundException extends RuntimeException {
    }

    @ApiOperation(value = "", notes = "This endpoint returns a list containing all models supported by the agreement module.", response = ModelManifest.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "List containing the models supported by the agreement module in JSON format.")})
    @RequestMapping(value = "", produces = {"application/json", "text/plain"}, method = RequestMethod.GET)
    public ResponseEntity<List<ModelManifest>> modelsGet() throws NotFoundException {
        return new ResponseEntity<>(module.getModels(), HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "This endpoint returns the model manifest indentified by **modelId**.", response = ModelManifest.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The model manifest in JSON format")})
    @RequestMapping(value = "/{modelId}", produces = {"application/json", "text/plain"}, method = RequestMethod.GET)
    public ResponseEntity<ModelManifest> modelsModelIdGet(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId) throws NotFoundException {
        for (ModelManifest modelManifest : module.getModels()) {
            if (modelManifest.getId().equals(modelId)) {
                return new ResponseEntity<>(modelManifest, HttpStatus.OK);
            }
        }
        throw new ResourceNotFoundException();
    }

    @ApiOperation(value = "", notes = "This endpoint returns a list containing all operations supported by this model.", response = Operation.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "List containing the operations supported by this model in JSON format")})
    @RequestMapping(value = "/{modelId}/operations", produces = {"application/json", "text/plain"}, method = RequestMethod.GET)
    public ResponseEntity<List<Operation>> modelsModelIdOperationsGet(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }

        return new ResponseEntity<>(model.getOperations(), HttpStatus.OK);

    }

    @ApiOperation(value = "", notes = "This endpoint returns the operation identified by *operationId*.", response = Operation.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operation supported by this model in JSON format")})
    @RequestMapping(value = "/{modelId}/operations/{operationId}", produces = {"application/json", "text/plain"}, method = RequestMethod.GET)
    public ResponseEntity<Operation> modelsModelIdOperationsOperationIdGet(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId,
            @ApiParam(value = "", required = true) @PathVariable("operationId") String operationId) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }
        for (Operation op : model.getOperations()) {
            if (op.getId().equals(operationId)) {
                return new ResponseEntity<>(op, HttpStatus.OK);
            }
        }
        throw new ResourceNotFoundException();
    }

    @ApiOperation(value = "", notes = "This endpoint returns the result of executing this operation.", response = AppResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "AppResponse with the result")})
    @RequestMapping(value = "/{modelId}/operations/{operationId}", produces = {"application/json", "text/plain"}, method = RequestMethod.POST)
    public ResponseEntity<AppResponse> modelsModelIdOperationsOperationIdPost(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId,
            @ApiParam(value = "", required = true) @PathVariable("operationId") String operationId,
            @ApiParam(value = "", required = true) @RequestBody List<Filedata> data) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }

        AppResponse appResponse = AnalyzeDelegate.analize(operationId, data);
        return new ResponseEntity<>(appResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "This endpoint returns a list containing the syntax supported by this model.", response = Syntax.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "List containing the syntax supported by this model in JSON format.")})
    @RequestMapping(value = "/{modelId}/syntaxes", produces = {"application/json", "text/plain"}, method = RequestMethod.GET)
    public ResponseEntity<List<Syntax>> modelsModelIdSyntaxesGet(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }
        return new ResponseEntity<>(model.getSyntaxes(), HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "This endpoint returns the syntax identified by *syntaxId*.", response = Syntax.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Syntax in JSON format.")})
    @RequestMapping(value = "/{modelId}/syntaxes/{syntaxId}", produces = {"application/json", "text/plain"}, method = RequestMethod.GET)
    public ResponseEntity<Syntax> modelsModelIdSyntaxesSyntaxIdGet(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId,
            @ApiParam(value = "Can be **iagree**, **json** or **yaml**", required = true) @PathVariable("syntaxId") String syntaxId) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }
        for (Syntax s : model.getSyntaxes()) {
            if (s.getId().equals(syntaxId)) {
                return new ResponseEntity<>(s, HttpStatus.OK);
            }
        }
        throw new ResourceNotFoundException();
    }

    @ApiOperation(value = "", notes = "This endpoint returns whether the syntax of this model is valid or not.", response = AppResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "AppResponse")})
    @RequestMapping(value = "/{modelId}/syntaxes/{syntaxId}/check", produces = {"application/json", "text/plain"}, method = RequestMethod.POST)
    public ResponseEntity<AppResponse> modelsModelIdSyntaxesSyntaxIdCheckPost(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId,
            @ApiParam(value = "Can be **iagree**, **json** or **yaml**", required = true) @PathVariable("syntaxId") String syntaxId,
            @ApiParam(value = "", required = true) @RequestBody Filedata data) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }
        AppResponse appResponse = LanguageDelegate.checkLanguage(syntaxId, data);
        return new ResponseEntity<>(appResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "This endpoint returns the result of converting from the current syntax to another supported syntax.\n", response = AppResponse.class)
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "AppResponse with the result of the conversion")})
    @RequestMapping(value = "/{modelId}/syntaxes/{srcSyntaxId}/translate/{destSyntaxId}", produces = {"application/json", "text/plain"}, method = RequestMethod.POST)
    public ResponseEntity<AppResponse> modelsModelIdSyntaxesSrcSyntaxIdTranslateDestSyntaxIdPost(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId,
            @ApiParam(value = "Can be **iagree**, **json** or **yaml**", required = true) @PathVariable("srcSyntaxId") String srcSyntaxId,
            @ApiParam(value = "Can be **iagree**, **json** or **yaml**", required = true) @PathVariable("destSyntaxId") String destSyntaxId,
            @ApiParam(value = "", required = true) @RequestBody Filedata data) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }
        AppResponse appResponse = ConversionDelegate.convert(srcSyntaxId, destSyntaxId, data);
        return new ResponseEntity<>(appResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "This endpoint returns the mode of this syntax.", response = Void.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Mode of this syntax")})
    @RequestMapping(value = "/{modelId}/syntaxes/{syntaxId}/mode", produces = {"application/json", "text/plain"}, method = RequestMethod.GET)
    public ResponseEntity<String> modelsModelIdSyntaxesSyntaxIdModeGet(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId,
            @ApiParam(value = "Can be **iagree**, **json** or **yaml**", required = true) @PathVariable("syntaxId") String syntaxId) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }
        String mode = Utils.loadFileContents("/modes/mode-" + modelId +".js");
        return new ResponseEntity<>(mode, HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "This endpoint returns the theme of this syntax.", response = Void.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Theme of this syntax")})
    @RequestMapping(value = "/{modelId}/syntaxes/{syntaxId}/theme", produces = {"application/json", "text/plain"}, method = RequestMethod.GET)
    public ResponseEntity<String> modelsModelIdSyntaxesSyntaxIdThemeGet(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId,
            @ApiParam(value = "Can be **iagree**, **json** or **yaml**", required = true) @PathVariable("syntaxId") String syntaxId) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }
        String theme = Utils.loadFileContents("/modes/theme-" + modelId +".js");
        return new ResponseEntity<>(theme, HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "This endpoint returns the model tests.", response = Test.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "List containg the tests supported by this model in JSON format")})
    @RequestMapping(value = "/{modelId}/tests", produces = {"application/json", "text/plain"}, method = RequestMethod.GET)
    public ResponseEntity<List<Test>> modelsModelIdTestsGet(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }
        String jsonTests = Utils.loadFileContents("/tests/" + modelId + "/tests.json");
        Test[] arrTests = new Gson().fromJson(jsonTests, Test[].class);
        List<Test> tests = new ArrayList<>(Arrays.asList(arrTests));
        for (Test test : tests) {
            Parameter param = test.getOperationParams();
            for (Filedata data : param.getData()) {
                data.setContent(Utils.loadFileContents(data.getFileUri()));
            }
        }
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "This endpoint returns the model test identified by **testId**.", response = Test.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Test description in JSON format")})
    @RequestMapping(value = "/{modelId}/tests/{testId}", produces = {"application/json", "text/plain"}, method = RequestMethod.GET)
    public ResponseEntity<Test> modelsModelIdTestsTestIdGet(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId,
            @ApiParam(value = "", required = true) @PathVariable("testId") String testId) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }
        String jsonTests = Utils.loadFileContents("/tests/" + modelId + "/tests.json");
        Test[] tests = new Gson().fromJson(jsonTests, Test[].class);
        Test test = null;
        for (Test t : tests) {
            if(t.getId().equals(testId)){
                test = t;
                Parameter param = t.getOperationParams();
                for (Filedata data : param.getData()) {
                    data.setContent(Utils.loadFileContents(data.getFileUri()));
                }
            }
        }
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "This endpoint returns the result of executing this test.", response = AppResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "AppResponse with the result")})
    @RequestMapping(value = "/{modelId}/tests/{testId}", produces = {"application/json", "text/plain"}, method = RequestMethod.POST)
    public ResponseEntity<Boolean> modelsModelIdTestsTestIdPost(
            @ApiParam(value = "Can be **template**, **offer** or **agreement**", required = true) @PathVariable("modelId") String modelId,
            @ApiParam(value = "", required = true) @PathVariable("testId") String testId) throws NotFoundException {
        ModelManifest model = modelsModelIdGet(modelId).getBody();
        if (model == null) {
            throw new ResourceNotFoundException();
        }
        String jsonTests = Utils.loadFileContents("/tests/" + modelId + "/tests.json");
        Test[] tests = new Gson().fromJson(jsonTests, Test[].class);
        Boolean res = null;
        for (Test test : tests) {
            if(test.getId().equals(testId)){
                Parameter param = test.getOperationParams();
                for (Filedata data : param.getData()) {
                    data.setContent(Utils.loadFileContents(data.getFileUri()));
                }
                ResponseEntity<AppResponse> entity = modelsModelIdOperationsOperationIdPost(modelId, test.getOperationParams().getOperationId(), test.getOperationParams().getData());
                AppResponse response = entity.getBody();
                for(AppResponse expectedResponse : test.getResults()){
                    res = response.equals(expectedResponse);
                    if(res) break;
                }
            }
        }
        
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
