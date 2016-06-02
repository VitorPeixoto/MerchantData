import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Vitor on 31/05/2016.
 */
public class Grade extends JSONElement {
    private final String name;
    private final double min,
                         max;

    public Grade(String name, double min, double max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public static ArrayList<Grade> readFromJSON(String source) {
        initialize(source);
        String json = readAll();

        jsonObject = new JSONObject(json);
        ArrayList<Grade> grades = new ArrayList<>();
        int i = 0;
        while(jsonObject.has(""+i)) {
            JSONObject gradeObject = jsonObject.getJSONObject(""+i);
            Grade g = new Grade(gradeObject.getString("name"), gradeObject.getDouble("min"), gradeObject.getDouble("max"));
            grades.add(g);
            i++;
        }

        close();
        return grades;
    }
}
