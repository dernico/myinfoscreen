package n.der.myinfoscreen.components.weather.services;

import com.android.volley.VolleyError;

import org.json.JSONException;

import n.der.myinfoscreen.components.weather.models.WeatherDetails;

public interface IWeatherServiceResultCallback {
    void success(WeatherDetails weatherDetails);
    void error(VolleyError error);
    void error(JSONException error);
}
