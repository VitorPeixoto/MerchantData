import org.json.JSONObject;

import java.io.*;

/**
 * Created by Vitor on 31/05/2016.
 */
public abstract class JSONElement {
    protected static JSONObject jsonObject;
    protected static File file                     = null;
    protected static FileReader fileReader         = null;
    protected static BufferedReader bufferedReader = null;

    protected static void initialize(String source) {
        try {
            file           = new File(source);
            fileReader     = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected static void close() {
        try {
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static String readAll() {
        String line = "",
               json = "";

        while(line != null) {
            json += line;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }
}
