package com.google.i18n.phonenumbers;

import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class ShortNumberUtil {

    /* JADX INFO: compiled from: SearchBox */
    public enum ShortNumberCost {
        TOLL_FREE,
        STANDARD_RATE,
        PREMIUM_RATE,
        UNKNOWN_COST
    }

    public boolean connectsToEmergencyNumber(String str, String str2) {
        return ShortNumberInfo.getInstance().connectsToEmergencyNumber(str, str2);
    }

    public Set<String> getSupportedRegions() {
        return ShortNumberInfo.getInstance().getSupportedRegions();
    }

    public boolean isEmergencyNumber(String str, String str2) {
        return ShortNumberInfo.getInstance().isEmergencyNumber(str, str2);
    }
}
