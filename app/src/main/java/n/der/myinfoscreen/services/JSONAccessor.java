package n.der.myinfoscreen.services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONAccessor {

    public static int getIntSafe(JSONObject json, String key) throws JSONException {
        if(json.has(key)){
            return json.getInt(key);
        }
        return 0;
    }

    public static String getStringSafe(JSONObject json, String key) throws JSONException {
        if(json.has(key)){
            return json.getString(key);
        }
        return "";
    }

    public static JSONArray getArraySafe(JSONObject json, String key) throws JSONException {
        if(json.has(key)){
            return json.getJSONArray(key);
        }
        return new JSONArray();
    }

    public static boolean getBooleanSafe(JSONObject json, String key) throws JSONException {
        if(json.has(key)){
            return json.getBoolean(key);
        }
        return false;
    }
}
