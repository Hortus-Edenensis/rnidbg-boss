package defpackage;

import android.content.Context;
import com.zenmen.palmchat.privinfo.PrivInfoManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bl6 {
    public bl6(Context context) {
    }

    public String a() {
        String bssid = PrivInfoManager.INSTANCE.getBssid();
        return bssid == null ? "NULL" : bssid;
    }

    public String b() {
        String ssid = PrivInfoManager.INSTANCE.getSsid();
        return ssid == null ? "NULL" : ssid;
    }
}
