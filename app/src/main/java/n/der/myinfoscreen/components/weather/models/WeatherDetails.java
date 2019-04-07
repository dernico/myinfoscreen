package n.der.myinfoscreen.components.weather.models;

/*
* Example Response
* {
    coord: {
        lon: 139.01,
        lat: 35.02
    },
    weather: [
        {
            id: 800,
            main: "Clear",
            description: "clear sky",
            icon: "01n"
        }
    ],
    base: "stations",
    main: {
        temp: 285.514,
        pressure: 1013.75,
        humidity: 100,
        temp_min: 285.514,
        temp_max: 285.514,
        sea_level: 1023.22,
        grnd_level: 1013.75
    },
    wind: {
        speed: 5.52,
        deg: 311
    },
    clouds: {
        all: 0
    },
    dt: 1485792967,
    sys: {
        message: 0.0025,
        country: "JP",
        sunrise: 1485726240,
        sunset: 1485763863
    },
    id: 1907296,
    name: "Tawarano",
    cod: 200
}
* */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import n.der.myinfoscreen.services.JSONAccessor;

public class WeatherDetails {
    private Coordinates coordinates;
    private ArrayList<Weather> weather;
    private WeatherMain main;
    private Wind wind;
    private Clouds clouds;
    private WeatherSys sys;
    private String base;
    private int id;
    private String name;
    private int cod;

    public static WeatherDetails GetWeatherDetails(JSONObject json) throws JSONException {
        WeatherDetails details = new WeatherDetails();
        details.setId(JSONAccessor.getIntSafe(json, "id"));
        details.setName(JSONAccessor.getStringSafe(json,"name"));
        details.setCod(JSONAccessor.getIntSafe(json,"cod"));

        JSONArray weatherjson = JSONAccessor.getArraySafe(json,"weather");

        ArrayList<Weather> weather = new ArrayList<>();
        for(int i = 0; i < weatherjson.length(); i++){
            Weather w = new Weather();

            w.setId(JSONAccessor.getIntSafe(weatherjson.getJSONObject(i),"id"));
            w.setDescription(JSONAccessor.getStringSafe(weatherjson.getJSONObject(i),"description"));
            w.setIcon(JSONAccessor.getStringSafe(weatherjson.getJSONObject(i),"icon"));
            w.setMain(JSONAccessor.getStringSafe(weatherjson.getJSONObject(i),"main"));
            weather.add(w);
        }
        details.setWeather(weather);

        JSONObject mainjson = json.getJSONObject("main");
        WeatherMain main = new WeatherMain();

        main.setGroundLvl(JSONAccessor.getIntSafe(mainjson, "grnd_level"));
        main.setSeaLevel(JSONAccessor.getIntSafe(mainjson, "sea_level"));

        main.setHumidity(JSONAccessor.getIntSafe(mainjson, "humidity"));
        main.setPressure(JSONAccessor.getIntSafe(mainjson, "pressure"));
        main.setTemp(JSONAccessor.getIntSafe(mainjson, "temp"));
        main.setTempMax(JSONAccessor.getIntSafe(mainjson, "temp_max"));
        main.setTempMin(JSONAccessor.getIntSafe(mainjson, "temp_min"));
        details.setMain(main);

        JSONObject windjson = json.getJSONObject("wind");
        Wind wind = new Wind();
        wind.setDeg(JSONAccessor.getIntSafe(windjson, "deg"));
        wind.setSpeed(JSONAccessor.getIntSafe(windjson, "speed"));
        details.setWind(wind);

        JSONObject cloudjson = json.getJSONObject("wind");
        Clouds cloud = new Clouds();
        cloud.setAll(JSONAccessor.getIntSafe(cloudjson,"all"));
        details.setClouds(cloud);

        JSONObject sysjson = json.getJSONObject("sys");
        WeatherSys sys = new WeatherSys();
        sys.setCountry(JSONAccessor.getStringSafe(sysjson,"country"));
        sys.setMessage(JSONAccessor.getIntSafe(sysjson,"message"));
        sys.setSunrise(JSONAccessor.getIntSafe(sysjson,"sunrise"));
        sys.setSunset(JSONAccessor.getIntSafe(sysjson,"sunset"));

        return details;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return cod;
    }

    public void setCod(int code) {
        this.cod = code;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public WeatherSys getSys() {
        return sys;
    }

    public void setSys(WeatherSys sys) {
        this.sys = sys;
    }
}
