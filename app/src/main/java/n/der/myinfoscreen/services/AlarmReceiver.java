package n.der.myinfoscreen.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.Toast;

import n.der.myinfoscreen.Constants;
import n.der.myinfoscreen.FullscreenActivity;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent fullscreenintent = new Intent(context, FullscreenActivity.class);
        fullscreenintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        fullscreenintent.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED +
//                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD +
//                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON +
//                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        fullscreenintent.putExtra(Constants.IntentData.AlarmReceiver.IsAlarm, true);
        context.startActivity(fullscreenintent);
    }
}
