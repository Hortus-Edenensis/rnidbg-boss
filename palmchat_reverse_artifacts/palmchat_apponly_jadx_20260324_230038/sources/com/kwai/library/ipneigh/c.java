package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    private static d D(Context context, boolean z) {
        return b(context, false, false);
    }

    private static d b(Context context, boolean z, boolean z2) {
        String strJ;
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String strFD = b.fD(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
            if (z) {
                strJ = "";
            } else {
                strJ = a.ii("timeout 5 ip neigh show " + strFD);
            }
            if (z || TextUtils.isEmpty(strJ)) {
                strJ = KwaiIpNeigh.j(strFD, false);
            }
            String strIk = b.ik(strJ);
            return new d(strIk, !TextUtils.isEmpty(strIk), strJ);
        } catch (Throwable th) {
            return new d("", false, th.getMessage());
        }
    }

    public static d eC(Context context) {
        return D(context, false);
    }
}
