package io.swagger.api;

import io.swagger.model.ModuleManifest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping(value = "", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-02-16T11:47:24.773+01:00")
public class DefaultApi {

    @Autowired
    private ModuleManifest module;

    @ApiOperation(value = "", notes = "This endpoint returns the agreement module manifest.", response = ModuleManifest.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The agreement module manifest in JSON format")})
    @RequestMapping(value = "/manifest",
            produces = {"application/json", "text/plain"},
            method = RequestMethod.GET)
    public ResponseEntity<ModuleManifest> rootGet() throws NotFoundException {
        return new ResponseEntity<>(module, HttpStatus.OK);
    }
    
    @ApiOperation(value = "", notes = "This endpoint returns the agreement module manifest.", response = ModuleManifest.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The agreement module manifest in JSON format")})
    @RequestMapping(value = "/api/v1",
            produces = {"application/json", "text/plain"},
            method = RequestMethod.GET)
    public ResponseEntity<ModuleManifest> rootApiGet() throws NotFoundException {
        return rootGet();
    }

    @ApiOperation(value = "", notes = "This endpoint returns the agreement module manifest.", response = ModuleManifest.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The agreement module manifest in JSON format")})
    @RequestMapping(value = "/version",
            produces = {"application/json", "text/plain"},
            method = RequestMethod.GET)
    public ResponseEntity<String> rootVersionGet() throws NotFoundException {
        Properties p = new Properties();
        try {
            p.load(getClass().getClassLoader().getResourceAsStream("module.properties"));
        } catch (IOException ex) {
            Logger.getLogger(DefaultApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseEntity<>("\"" + p.getProperty("version") + "\"", HttpStatus.OK);
    }

    @ApiOperation(value = "/help", notes = "This endpoint returns the help content defined for the agreement module.", response = Void.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Help content of the agreement module in JSON format.")})
    @RequestMapping(value = "",
            produces = {"application/json", "text/plain"},
            method = RequestMethod.GET)
    public ResponseEntity<Void> helpGet()
            throws NotFoundException {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
