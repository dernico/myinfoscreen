package n.der.myinfoscreen.services;

import n.der.myinfoscreen.domain.WakeupTime;

public interface IAlarmService {
    void setAlarm(WakeupTime wakeupTime);
    void setAlarm(WakeupTime wakeupTime, long intervalMillis);
    void cancelAlarm();
}
