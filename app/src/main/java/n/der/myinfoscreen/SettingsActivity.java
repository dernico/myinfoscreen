package n.der.myinfoscreen;

import android.app.AlarmManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

import n.der.myinfoscreen.data.ISettingsStore;
import n.der.myinfoscreen.data.SharedPreferencesSettingsStore;
import n.der.myinfoscreen.domain.WakeupTime;
import n.der.myinfoscreen.services.AlarmService;
import n.der.myinfoscreen.services.IAlarmService;

public class SettingsActivity extends AppCompatActivity {

    private IAlarmService _alarmService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final Context _con = this;

        _alarmService = new AlarmService(this);

        findViewById(R.id.button_set_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                int currentMinute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(SettingsActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {

                        ISettingsStore store = new SharedPreferencesSettingsStore(getApplicationContext());
                        WakeupTime wakeupTime = new WakeupTime(hourOfDay, minutes);
                        store.SaveWakeupTime(wakeupTime);
                        _alarmService.setAlarm(wakeupTime, AlarmManager.INTERVAL_DAY);

                    }
                }, currentHour, currentMinute, true);
                timePickerDialog.show();

            }
        });

        findViewById(R.id.button_cancel_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _alarmService.cancelAlarm();
            }
        });

        findViewById(R.id.button_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}