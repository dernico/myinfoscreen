package n.der.myinfoscreen.components.weather.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import n.der.myinfoscreen.components.weather.models.WeatherDetails;

public class OpenWeatherService implements IWeatherService {
    private final static String BaseUrl = "https://api.openweathermap.org/data/2.5";

    private Context _ctx;

    public OpenWeatherService(Context ctx){
        _ctx = ctx;
    }

    @Override
    public void getWeather(double lng, double lat, final IWeatherServiceResultCallback callback) {
        RequestQueue queue = Volley.newRequestQueue(_ctx);
        String url = BaseUrl + String.format("/weather?lat=%1$f&lon=%2$f&appid=%3$s", lat, lng, OpenWeatherApi.ApiKey);
        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            WeatherDetails details = WeatherDetails.GetWeatherDetails(response);
                            callback.success(details);
                        } catch (JSONException e) {
                            callback.error(e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.error(error);
                    }
                });
        queue.add(jsonObjectRequest);
    }
}
