package n.der.myinfoscreen.components.weather.services;

import com.android.volley.Response;

import org.json.JSONObject;

import n.der.myinfoscreen.components.weather.models.WeatherDetails;

public interface IWeatherService {

    void getWeather(double lng, double lat, IWeatherServiceResultCallback callback);
}
