package es.us.isa.governify.designer.modules.agreement.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Utils {

    private static final Logger LOG = Logger.getLogger(Utils.class.getName());

    public static String loadFileContents(String relativePath) {
        InputStream inputStream = Utils.class.getClassLoader()
                .getResourceAsStream(relativePath);

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            LOG.severe(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    LOG.severe(e.getMessage());
                }
            }
        }

        return sb.toString();
    }
}
