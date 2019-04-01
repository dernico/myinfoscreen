package n.der.myinfoscreen.data;

import android.content.Context;
import android.content.SharedPreferences;

import n.der.myinfoscreen.R;
import n.der.myinfoscreen.domain.WakeupTime;

public class SharedPreferencesSettingsStore implements ISettingsStore {

    private Context _context;
    private final String _hourofdayKey = "settings_wakuptime_hourofday";
    private final String _timeKey = "settings_wakeuptime_time";

    public SharedPreferencesSettingsStore(Context context){
        _context = context;
    }

    public void SaveWakeupTime(WakeupTime time){
        SharedPreferences prefs = _context.getSharedPreferences("MyInfoscreen_Settings", Context.MODE_PRIVATE);
        prefs.edit()
                .putInt(_hourofdayKey, time.getHourOfDay())
                .putInt(_timeKey, time.getHourOfDay())
                .commit();
    }

    @Override
    public WakeupTime GetWakeupTime() {
        WakeupTime time = new WakeupTime();
        SharedPreferences prefs = _context.getSharedPreferences("MyInfoscreen_Settings", Context.MODE_PRIVATE);
        time.setHourOfDay(prefs.getInt(_hourofdayKey,0));
        time.setMinute(prefs.getInt(_timeKey, 0));
        return time;
    }
}
