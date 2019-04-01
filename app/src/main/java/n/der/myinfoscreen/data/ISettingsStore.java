package n.der.myinfoscreen.data;

import n.der.myinfoscreen.domain.WakeupTime;

public interface ISettingsStore {
    void SaveWakeupTime(WakeupTime time);
    WakeupTime GetWakeupTime();

}
