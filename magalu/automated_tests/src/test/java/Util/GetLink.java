package Util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class GetLink {
    private JSONObject jsonObject;

    public GetLink() {
        JSONParser parser = new JSONParser();
        Object object = null;
        try {
            object = parser.parse(new FileReader("assets/env.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) object;
    }
    public String getBaseUrl() {
        return (String) jsonObject.get("magazineluizawebsite");
    }
    public String getChromeDriverPath() {
        return (String) jsonObject.get("chromeDriver");
    }
}
