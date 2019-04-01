package n.der.myinfoscreen.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

import n.der.myinfoscreen.SettingsActivity;
import n.der.myinfoscreen.data.ISettingsStore;
import n.der.myinfoscreen.data.SharedPreferencesSettingsStore;
import n.der.myinfoscreen.domain.WakeupTime;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        ISettingsStore store = new SharedPreferencesSettingsStore(getContext());
        store.SaveWakeupTime(new WakeupTime(hourOfDay, minute));
    }
}
