package n.der.myinfoscreen.components.weather.models;

public class WeatherMain {
    private int temp;
    private int pressure;
    private int humidity;
    private int tempMin;
    private int tempMax;
    private int seaLevel;
    private int groundLvl;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = toCalvin(temp);
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = toCalvin(tempMin);
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = toCalvin(tempMax);
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public int getGroundLvl() {
        return groundLvl;
    }

    public void setGroundLvl(int groundLvl) {
        this.groundLvl = groundLvl;
    }

    private int toCalvin(int kelvin){
        return (int) (kelvin - 272.15);
    }
}
