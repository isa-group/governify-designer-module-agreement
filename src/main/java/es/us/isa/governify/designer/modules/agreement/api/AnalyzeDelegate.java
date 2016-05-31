/**
 *
 */
package es.us.isa.governify.designer.modules.agreement.api;

import java.io.InputStream;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.operations.core.csp.WhyAreNotCompliant;
import es.us.isa.aml.operations.noCore.Valid;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeError;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeErrorListener;
import es.us.isa.aml.util.Util;
import es.us.isa.governify.designer.modules.agreement.model.AppResponse;
import es.us.isa.governify.designer.modules.agreement.model.AppResponse.StatusEnum;
import es.us.isa.governify.designer.modules.agreement.model.Filedata;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class AnalyzeDelegate {

    public static AppResponse analize(String id, List<Filedata> data) {
        String fileUri = data.get(0).getFileUri();
        String content = data.get(0).getContent();

        AppResponse appResponse = new AppResponse();

        InputStream in = AnalyzeDelegate.class
                .getResourceAsStream("/defaultConfig.json");
        String config = Util.getStringFromInputStream(in);

        AgreementManager manager = new AgreementManager(config);
        AgreementModel model, model2;

        try {
            IAgreeParser parser = new IAgreeParser();
            model = parser.doParse(content);
            IAgreeErrorListener errorListener = parser.getErrorListener();
            if (errorListener.hasErrors()) {
                StringBuilder lines = new StringBuilder();
                List<IAgreeError> errors = errorListener.getErrors();
                for (IAgreeError error : errors) {
                    lines.append(error.getLineNo());
                    if (errors.indexOf(error) != errors.size() - 1) {
                        lines.append(", ");
                    }
                }
                if (lines.toString().isEmpty()) {
                    appResponse.setMessage("<pre>This document is not supported by analysis operations.</pre>");
                } else {
                    appResponse.setMessage("<pre>This document is not supported by analysis operations. "
                            + "See annotations in lines " + lines + " for more information.</pre>");
                }
                appResponse.setStatus(StatusEnum.OK_PROBLEMS);
            } else if (id.equals("checkValidity")) {
                if (manager.isValid(model)) {
                    appResponse
                            .setMessage("<pre><b>The document is consistent.</b></pre>");
                    appResponse.setStatus(StatusEnum.OK);
                } else {
                    Valid op = new Valid();
                    op.analyze(model);

                    if (!op.getResult().getConflicts().isEmpty()) {
                        appResponse.setMessage("<pre><b>" + op.getResult().getExplaining() + "</b>\n" + op.getResult().getConflicts() + "</pre>");
                    } else {
                        appResponse.setMessage("<pre><b>" + op.getResult().getExplaining() + "</b></pre>");
                    }
                    appResponse.setStatus(StatusEnum.OK_PROBLEMS);
                }

            } else if (id.equals("checkCompliance") && data.size() > 1) {
                String fileUri2 = data.get(1).getFileUri();
                String content2 = data.get(1).getContent();
                model2 = parser.doParse(content2);

                AreCompliant op = new AreCompliant();
                op.analyze(model, model2);
                Boolean compliant = op.getResult().getCompliant();
                if (compliant != null) {
                    if (compliant) {
                        appResponse
                                .setMessage("<pre><b>The provided offer is compliant with the provided template.</b></pre>");
                        appResponse.setStatus(StatusEnum.OK);
                    } else {
                        appResponse
                                .setMessage("<pre><b>The documents are not compliant.</b></pre>");
                        appResponse.setStatus(StatusEnum.OK_PROBLEMS);
                    }
                } else {
                    appResponse.setMessage("<pre>There was an error.</pre>");
                    appResponse.setStatus(StatusEnum.ERROR);
                }
            } else if (id.equals("checkComplianceAuto") && data.size() > 1) {
                String fileUri2 = data.get(1).getFileUri();
                String content2 = data.get(1).getContent();
                model2 = parser.doParse(content2);

                AreCompliant op = new AreCompliant();
                op.analyze(model, model2);
                Boolean compliant = op.getResult().getCompliant();
                if (compliant != null) {
                    if (compliant) {
                        appResponse
                                .setMessage("<pre><b>The provided offer is compliant with the provided template.</b></pre>");
                        appResponse.setStatus(StatusEnum.OK);
                    } else {
                        appResponse
                                .setMessage("<pre><b>The documents are not compliant.</b></pre>");
                        appResponse.setStatus(StatusEnum.OK_PROBLEMS);
                    }
                } else {
                    appResponse.setMessage("<pre>There was an error.</pre>");
                    appResponse.setStatus(StatusEnum.ERROR);
                }
            } else if (id.equals("complianceAnalysis") && data.size() > 1) {
                String fileUri2 = data.get(1).getFileUri();
                String content2 = data.get(1).getContent();
                model2 = parser.doParse(content2);

                WhyAreNotCompliant op = new WhyAreNotCompliant();
                op.analyze(model, model2);
                Boolean compliant = op.getResult().getCompliant();
                if (compliant != null) {
                    if (compliant) {
                        appResponse
                                .setMessage("<pre><b>The provided offer is compliant with the provided template.</b></pre>");
                        appResponse.setStatus(StatusEnum.OK);
                    } else {
                        appResponse
                                .setMessage("<pre><b>The documents are not compliant:</b>\n"
                                        + " - Conflict type: "
                                        + op.getResult().getConflictType()
                                        + "\n"
                                        + " - Conflicting offer terms: "
                                        + op.getResult().getConflicts()
                                        + "\n"
                                        + " - Affected template terms: "
                                        + op.getResult().getAffectedTerms()
                                        + "</pre>");
                        appResponse.setStatus(StatusEnum.OK_PROBLEMS);
                    }
                } else {
                    appResponse.setMessage("<pre>There was an error.</pre>");
                    appResponse.setStatus(StatusEnum.ERROR);
                }
            } else if (id.equals("generateOPL")) {
                try {
                    appResponse = ConversionDelegate.convert("iagree", "opl", data.get(0));
                    appResponse.setMessage("<pre><b>The OPL document has been generated successfully.</b></pre>");
                } catch (Exception e) {
                    appResponse.setMessage("<pre>There was an error.</pre>");
                    appResponse.setStatus(StatusEnum.ERROR);
                }
            }

        } catch (Exception e) {
            appResponse.setMessage("<pre>" + e.getMessage() + "</pre>");
            appResponse.setStatus(StatusEnum.OK_PROBLEMS);
        }

        return appResponse;
    }

    private static String constructUri(String uri, String extension) {
        String ret = "";
        String[] listUri = uri.split("/");
        String file = listUri[listUri.length - 1];

        String[] fileaux = file.split("\\.");
        String filename = fileaux[0];

        for (int i = 0; i < listUri.length - 1; i++) {
            ret += listUri[i] + "/";
        }
        ret += filename + "." + extension;
        return ret;
    }

    @Override
    public String toString() {
        return "AnalyzerDelegate - v1.0.0";
    }

}
