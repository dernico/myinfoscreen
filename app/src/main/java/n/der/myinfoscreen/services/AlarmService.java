package n.der.myinfoscreen.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

import n.der.myinfoscreen.domain.WakeupTime;

import static android.content.Context.ALARM_SERVICE;

public class AlarmService implements IAlarmService {
    private Context _ctx;
    private final int _alarmRequestCode = 548657895;

    public AlarmService(Context ctx){
        _ctx = ctx;
    }

    @Override
    public void setAlarm(WakeupTime wakeupTime) {
        this.setAlarm(wakeupTime, 0);
    }
    @Override
    public void setAlarm(WakeupTime wakeupTime, long intervalMillis) {
        AlarmManager alarmManager = (AlarmManager) _ctx.getSystemService(ALARM_SERVICE);
        Calendar alarmCalendar = Calendar.getInstance();
        int hour = alarmCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = alarmCalendar.get(Calendar.MINUTE);
        int seconds = alarmCalendar.get(Calendar.SECOND);

        alarmCalendar.set(Calendar.HOUR_OF_DAY, wakeupTime.getHourOfDay());
        alarmCalendar.set(Calendar.MINUTE, wakeupTime.getMinute());
        alarmCalendar.set(Calendar.SECOND, 0);

        // create a pending intent that delays the intent
        // until the specified calendar time
        Intent alarmReiver = new Intent(_ctx, AlarmReceiver.class);
        PendingIntent pending_intent =
                PendingIntent.getBroadcast(_ctx, _alarmRequestCode,
                        alarmReiver, PendingIntent.FLAG_UPDATE_CURRENT);

        // set the alarm manager
        if(intervalMillis > 0) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmCalendar.getTimeInMillis(), intervalMillis, pending_intent);
        }else{
            alarmManager.set(AlarmManager.RTC_WAKEUP, alarmCalendar.getTimeInMillis(), pending_intent);
        }

    }

    @Override
    public void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) _ctx.getSystemService(ALARM_SERVICE);
        Intent alarmReiver = new Intent(_ctx, AlarmReceiver.class);
        PendingIntent pending_intent = PendingIntent.getBroadcast(
                _ctx, _alarmRequestCode,
                alarmReiver, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pending_intent);
    }
}
