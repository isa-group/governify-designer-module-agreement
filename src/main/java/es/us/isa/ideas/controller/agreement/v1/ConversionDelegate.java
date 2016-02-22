package es.us.isa.ideas.controller.agreement.v1;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.Error.ERROR_SEVERITY;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.JsonParser;
import es.us.isa.aml.parsers.agreements.WsagParser;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeError;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeErrorListener;
import es.us.isa.aml.parsers.agreements.YamlParser;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;
import es.us.isa.aml.translator.builders.wsag.WSAGBuilder;
import es.us.isa.ideas.controller.agreement.util.TranslateUtil;
import io.swagger.model.AppAnnotation;
import io.swagger.model.AppAnnotation.SeverityEnum;
import io.swagger.model.AppResponse;
import io.swagger.model.AppResponse.StatusEnum;
import io.swagger.model.Filedata;

public class ConversionDelegate {

    public static AppResponse convert(String currentFormat,
            String desiredFormat, Filedata data) {
        
        String fileUri = data.getFileUri();
        String content = data.getContent();

        AppResponse appResponse = new AppResponse();

        if (currentFormat.equals("iagree") && desiredFormat.equals("opl")) {

            IAgreeParser parser = new IAgreeParser();
            AgreementModel model = parser.doParse(content);

            IAgreeErrorListener errorListener = parser.getErrorListener();

            if (errorListener.hasErrors()) {
                appResponse.setStatus(StatusEnum.OK_PROBLEMS);

                List<AppAnnotation> annotations = new ArrayList<>();

                for (IAgreeError error : errorListener.getErrors()) {

                    Integer lineNo = error.getLineNo() - 1;
                    Integer columnNo = error.getCharStart();

                    AppAnnotation appAnnot = new AppAnnotation();
                    appAnnot.setLine(lineNo);
                    appAnnot.setColumn(columnNo);
                    appAnnot.setMessage(error.getMessage().replace("\"", "'"));
                    appAnnot.setSeverity(AppAnnotation.SeverityEnum.ERROR);
                    annotations.add(appAnnot);
                }
                appResponse.setAnnotations(annotations);

            } else {

                Translator translator = new Translator(new CSPBuilder());
                String opl = translator.print(model);

                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(opl);
            }
        } else if (currentFormat.equals("iagree") && desiredFormat.equals("wsag")) {

            IAgreeParser parser = new IAgreeParser();
            AgreementModel model = parser.doParse(content);

            IAgreeErrorListener errorListener = parser.getErrorListener();

            if (errorListener.hasErrors()) {
                appResponse.setStatus(StatusEnum.OK_PROBLEMS);

                List<AppAnnotation> annotations = new ArrayList<>();

                for (IAgreeError error : errorListener.getErrors()) {

                    Integer lineNo = error.getLineNo() - 1;
                    Integer columnNo = error.getCharStart();

                    AppAnnotation appAnnot = new AppAnnotation();
                    appAnnot.setLine(lineNo);
                    appAnnot.setColumn(columnNo);
                    appAnnot.setMessage(error.getMessage().replace("\"", "'"));
                    appAnnot.setSeverity(SeverityEnum.ERROR);
                    annotations.add(appAnnot);
                }
                appResponse.setAnnotations(annotations);

            } else {
                Translator translator = new Translator(new WSAGBuilder());
                String wsag = translator.print(model);

                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(wsag);
            }
        } else if (currentFormat.equals("wsag") && desiredFormat.equals("iagree")) {

            WsagParser parser = new WsagParser();
            AgreementModel model = parser.doParse(content);
            if (model != null) {
                Translator translator = new Translator(new IAgreeBuilder());
                String iagree = translator.print(model);
                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(iagree);
            }
        } else if (currentFormat.equals("iagree") && desiredFormat.equals("json")) {
            IAgreeParser parser = new IAgreeParser();
            AgreementModel model = parser.doParse(content);
            IAgreeErrorListener errorListener = parser.getErrorListener();
            if(hasCriticalErrors(errorListener)){
                appResponse.setStatus(StatusEnum.OK_PROBLEMS);
                List<AppAnnotation> annotations = new ArrayList<>();
                for (IAgreeError error : errorListener.getErrors()) {
                    Integer lineNo = error.getLineNo() - 1;
                    Integer columnNo = error.getCharStart();
                    AppAnnotation appAnnot = new AppAnnotation();
                    appAnnot.setLine(lineNo);
                    appAnnot.setColumn(columnNo);
                    appAnnot.setMessage(error.getMessage().replace("\"", "'"));
                    appAnnot.setSeverity(SeverityEnum.ERROR);
                    annotations.add(appAnnot);
                }
                appResponse.setAnnotations(annotations);
            } else {
                JsonParser translator = new JsonParser();
                String json = translator.parserToJson(model);
                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(json);
            }
        } else if (currentFormat.equals("iagree") && desiredFormat.equals("yaml")) {
            IAgreeParser parser = new IAgreeParser();
            AgreementModel model = parser.doParse(content);
            IAgreeErrorListener errorListener = parser.getErrorListener();
            if(hasCriticalErrors(errorListener)){
                appResponse.setStatus(StatusEnum.OK_PROBLEMS);
                List<AppAnnotation> annotations = new ArrayList<>();
                for (IAgreeError error : errorListener.getErrors()) {
                    Integer lineNo = error.getLineNo() - 1;
                    Integer columnNo = error.getCharStart();
                    AppAnnotation appAnnot = new AppAnnotation();
                    appAnnot.setLine(lineNo);
                    appAnnot.setColumn(columnNo);
                    appAnnot.setMessage(error.getMessage().replace("\"", "'"));
                    appAnnot.setSeverity(SeverityEnum.ERROR);
                    annotations.add(appAnnot);
                }
                appResponse.setAnnotations(annotations);
            } else {
                YamlParser translator = new YamlParser();
                String yaml = translator.parserToYaml(model);
                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(yaml);
            }
        } else if (currentFormat.equals("json") && desiredFormat.equals("iagree")) {
            JsonParser jparser = new JsonParser();
            AgreementModel model = jparser.doParse(content);
            if (model != null) {
                Translator translator = new Translator(new IAgreeBuilder());
                String iagree = translator.print(model);
                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(iagree);
            }
        } else if (currentFormat.equals("yaml") && desiredFormat.equals("iagree")) {
            YamlParser yparser = new YamlParser();
            AgreementModel model = yparser.doParse(content);
            if (model != null) {
                Translator translator = new Translator(new IAgreeBuilder());
                String iagree = translator.print(model);
                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(iagree);
            }
        } else if (currentFormat.equals("yaml") && desiredFormat.equals("json")) {
            appResponse.setStatus(AppResponse.StatusEnum.OK);
            appResponse.setData(TranslateUtil.convertToJson(content));
        } else if (currentFormat.equals("json") && desiredFormat.equals("yaml")) {
            appResponse.setStatus(AppResponse.StatusEnum.OK);
            appResponse.setData(TranslateUtil.convertToYaml(content));
        } else if (currentFormat.equals("json") && desiredFormat.equals("wsag")) {
            JsonParser jparser = new JsonParser();
            AgreementModel model = jparser.doParse(content);
            if (model != null) {
                Translator translator = new Translator(new IAgreeBuilder());
                String iagree = translator.print(model);
                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(TranslateUtil.iagree2wsag(iagree));
            }
        } else if (currentFormat.equals("yaml") && desiredFormat.equals("wsag")) {
            YamlParser yparser = new YamlParser();
            AgreementModel model = yparser.doParse(content);
            if (model != null) {
                Translator translator = new Translator(new IAgreeBuilder());
                String iagree = translator.print(model);
                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(TranslateUtil.iagree2wsag(iagree));
            }
        } else if (currentFormat.equals("wsag") && desiredFormat.equals("json")) {
            
            IAgreeParser parser = new IAgreeParser();
            AgreementModel model = parser.doParse(TranslateUtil.wsag2iagree(content));
            IAgreeErrorListener errorListener = parser.getErrorListener();
            if (errorListener.hasErrors()) {
                appResponse.setStatus(StatusEnum.OK_PROBLEMS);
                List<AppAnnotation> annotations = new ArrayList<>();
                for (IAgreeError error : errorListener.getErrors()) {
                    Integer lineNo = error.getLineNo() - 1;
                    Integer columnNo = error.getCharStart();
                    AppAnnotation appAnnot = new AppAnnotation();
                    appAnnot.setLine(lineNo);
                    appAnnot.setColumn(columnNo);
                    appAnnot.setMessage(error.getMessage().replace("\"", "'"));
                    appAnnot.setSeverity(SeverityEnum.ERROR);
                    annotations.add(appAnnot);
                }
                appResponse.setAnnotations(annotations);
            } else {
                JsonParser translator = new JsonParser();
                String json = translator.parserToJson(model);
                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(json);
            }

        } else if (currentFormat.equals("wsag") && desiredFormat.equals("yaml")) {
            IAgreeParser parser = new IAgreeParser();
            AgreementModel model = parser.doParse(TranslateUtil.wsag2iagree(content));
            IAgreeErrorListener errorListener = parser.getErrorListener();
            if (errorListener.hasErrors()) {
                appResponse.setStatus(StatusEnum.OK_PROBLEMS);
                List<AppAnnotation> annotations = new ArrayList<>();
                for (IAgreeError error : errorListener.getErrors()) {
                    Integer lineNo = error.getLineNo() - 1;
                    Integer columnNo = error.getCharStart();
                    AppAnnotation appAnnot = new AppAnnotation();
                    appAnnot.setLine(lineNo);
                    appAnnot.setColumn(columnNo);
                    appAnnot.setMessage(error.getMessage().replace("\"", "'"));
                    appAnnot.setSeverity(SeverityEnum.ERROR);
                    annotations.add(appAnnot);
                }
                appResponse.setAnnotations(annotations);
            } else {
                YamlParser translator = new YamlParser();
                String yaml = translator.parserToYaml(model);
                appResponse.setStatus(StatusEnum.OK);
                appResponse.setData(yaml);
            }
        }
        return appResponse;
    }
    
    
    public static Boolean hasCriticalErrors(IAgreeErrorListener errors){
        Boolean res=false;
        for(IAgreeError er:errors.getErrors()){
            if((er.getSeverity()!=ERROR_SEVERITY.INFO)&&(er.getSeverity()!=ERROR_SEVERITY.WARNING)){
                res=true;
                break;
            }
        }
        return res;
    }
}
