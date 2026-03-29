package com.wifi.ad.core.compliance;

import android.text.TextUtils;
import com.wifi.ad.core.WifiNestAd;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AdNativeStyleManagerSDK {
    public static int STYLE_VALUE1 = 1;
    public static int STYLE_VALUE2 = 2;

    public static int getNativeStyleView(int i) {
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        return wifiNestAd.getMAdRequestCallBack() != null ? wifiNestAd.getMAdRequestCallBack().getNativeStyleView(i) : STYLE_VALUE1;
    }

    public static boolean isShowComplianceInfo(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (wifiNestAd.getMAdRequestCallBack() != null) {
            return wifiNestAd.getMAdRequestCallBack().isShowComplianceInfo(str, i);
        }
        return false;
    }
}
