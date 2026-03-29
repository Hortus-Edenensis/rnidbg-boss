package cn.fly.verify;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import cn.fly.verify.fq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ap {
    public static void a() {
        int i;
        if (as.d(ax.g()) && as.b(ax.g()) && fq.d.l().equalsIgnoreCase(as.b("4F50706F")) && (i = Build.VERSION.SDK_INT) >= 23 && i <= 28 && ai.a().h() == 0 && !aq.i()) {
            try {
                a(ax.g().getApplicationContext());
                f.a().b("[FlyVerify] ==>%s", "oppo reconnect");
            } catch (Exception e) {
                f.a().c(e);
            }
        }
    }

    public static void a(Context context) {
        WifiManager wifiManager;
        if (context == null || (wifiManager = (WifiManager) fq.d.a("wifi")) == null) {
            return;
        }
        int networkId = wifiManager.getConnectionInfo().getNetworkId();
        wifiManager.disableNetwork(networkId);
        wifiManager.disconnect();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            f.a().b("[FlyVerify] ==>%s", "reconnect wifi interrupted " + e.getMessage());
        }
        wifiManager.enableNetwork(networkId, true);
        wifiManager.reconnect();
    }
}
