package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class cd {
    private static boolean bgN = false;
    private static final List<a> bgO = new CopyOnWriteArrayList();

    public static boolean er(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == -1;
    }

    public static List<a> o(Context context, int i) {
        WifiManager wifiManager;
        if (bc.useNetworkStateDisable()) {
            return new ArrayList();
        }
        if (!bgN && ServiceProvider.getSDKConfig().canReadNearbyWifiList()) {
            List<a> list = bgO;
            if (list.isEmpty() && context != null) {
                if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(32L)) {
                    return list;
                }
                try {
                    if (er(context) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
                        return list;
                    }
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    if (scanResults != null) {
                        for (ScanResult scanResult : scanResults) {
                            a aVar = new a();
                            aVar.bgP = scanResult.SSID;
                            aVar.bgQ = scanResult.BSSID;
                            aVar.level = scanResult.level;
                            if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                                bgO.add(aVar);
                            } else {
                                bgO.add(0, aVar);
                            }
                            List<a> list2 = bgO;
                            if (list2.size() >= i) {
                                return list2;
                            }
                        }
                    }
                } catch (Exception e) {
                    bgN = true;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
                return bgO;
            }
        }
        return bgO;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.kwad.sdk.core.b {
        public String bgP;
        public String bgQ;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "level", this.level);
            aa.putValue(jSONObject, "ssid", this.bgP);
            aa.putValue(jSONObject, "bssid", this.bgQ);
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }
    }
}
