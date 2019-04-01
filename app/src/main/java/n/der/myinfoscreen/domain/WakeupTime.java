package n.der.myinfoscreen.domain;

public class WakeupTime {

    private int hourOfDay;
    private int minute;

    public WakeupTime(){}

    public WakeupTime(int hourOfDay, int minute){
        this.hourOfDay = hourOfDay;
        this.minute = minute;
    }

    public int getHourOfDay() {
        return hourOfDay;
    }

    public void setHourOfDay(int hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
