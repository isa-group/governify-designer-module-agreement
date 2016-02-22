package es.us.isa.ideas.controller.agreement.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeError;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeErrorListener;
import io.swagger.model.AppAnnotation;
import io.swagger.model.AppAnnotation.SeverityEnum;
import io.swagger.model.AppResponse;
import io.swagger.model.AppResponse.StatusEnum;
import io.swagger.model.Filedata;

public class LanguageDelegate {

    private static final Logger LOGGER = Logger
            .getLogger(LanguageDelegate.class.getName());

    public static AppResponse checkLanguage(String format, Filedata data) {

        String fileUri = data.getFileUri();
        String content = data.getContent();
        
        AppResponse appResponse = new AppResponse();
        List<AppAnnotation> annotations = new ArrayList<>();

        if (format.equals("iagree")) {
            IAgreeParser parser = new IAgreeParser();
            try {
                parser.doParse(content);
                IAgreeErrorListener errorListener = parser.getErrorListener();                
                if (errorListener.hasErrors()) {
                    for (IAgreeError error : errorListener.getErrors()) {
                        Integer lineNo = error.getLineNo() - 1;
                        Integer columnNo = error.getCharStart();

                        AppAnnotation appAnnot = new AppAnnotation();
                        appAnnot.setLine(lineNo);
                        appAnnot.setColumn(columnNo);
                        appAnnot.setMessage(error.getMessage().replace("\"", "'"));
                        appAnnot.setSeverity(SeverityEnum.valueOf(error.getSeverity().name()));
                        annotations.add(appAnnot);
                    }
                }
            } catch (Exception e) {
                IAgreeErrorListener errorListener = parser.getErrorListener();
                if (errorListener.hasErrors()) {
                    for (IAgreeError error : errorListener.getErrors()) {
                        Integer lineNo = error.getLineNo() - 1;
                        Integer columnNo = error.getCharStart();

                        AppAnnotation appAnnot = new AppAnnotation();
                        appAnnot.setLine(lineNo);
                        appAnnot.setColumn(columnNo);
                        appAnnot.setMessage(error.getMessage().replace("\"", "'"));
                        appAnnot.setSeverity(SeverityEnum.valueOf(error.getSeverity().name()));
                        annotations.add(appAnnot);
                    }
                }
                appResponse.setStatus(StatusEnum.OK_PROBLEMS);
            }

            if (!annotations.isEmpty()) {
                appResponse.setStatus(StatusEnum.OK_PROBLEMS);
                appResponse.setMessage("This document contains syntax errors.");
                appResponse.setAnnotations(annotations);
            } else {
                appResponse.setStatus(StatusEnum.OK);
                appResponse.setMessage("This document is syntactically correct.");
            }

        } else {
            LOGGER.log(Level.INFO, "No language checker is implemented for this format: {0}", format);
        }

        return appResponse;
    }

}
