/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import com.google.gson.Gson;
import io.swagger.utils.Utils;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author ISA Group
 */
@Component
public class AbstractModuleManifest {

    private static final Logger LOG = Logger.getLogger(AbstractModuleManifest.class.getName());
    protected String MANIFEST = "module_manifest.json";

    @PostConstruct
    void loadModule() {
        LOG.info("[IDEAS] Module is not loaded. Loading...");
        String json = Utils.loadFileContents(MANIFEST);
        Gson gson = new Gson();
        ModuleManifest module = gson.fromJson(json, io.swagger.model.ModuleManifest.class);
        BeanUtils.copyProperties(module, this);
    }
}
