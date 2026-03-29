package com.bytedance.sdk.openadsdk.core.y;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {
    public static String a() {
        return dw().getWifiMac(null);
    }

    public static String b() {
        return dw().getMcc();
    }

    public static int bg() {
        return dw().getTimeZoneInt();
    }

    public static String bq() {
        return dw().getRom();
    }

    public static com.bytedance.sdk.component.b.u.u dw() {
        return (com.bytedance.sdk.component.b.u.u) com.bytedance.sdk.openadsdk.ats.fx.u("device_info");
    }

    public static String fx() {
        return dw().getLocalLanguage();
    }

    public static String iz() {
        return dw().getTotalMem();
    }

    public static String jk() {
        return dw().getCompilingTime();
    }

    public static String k() {
        return dw().getIpv6();
    }

    public static String l() {
        return dw().getMacAddress(null);
    }

    public static String mv() {
        return dw().getWebViewUA();
    }

    public static com.bytedance.sdk.component.b.u.fx my() {
        return dw().getLocation();
    }

    public static String n() {
        return dw().getImei(null);
    }

    public static String nr() {
        return dw().getDeviceModel();
    }

    public static String o() {
        return dw().getAppLogDid();
    }

    public static String pn() {
        return dw().getMnc();
    }

    public static String s() {
        return dw().getIP();
    }

    public static String sx() {
        return dw().getUUId();
    }

    public static String t() {
        return dw().getBuildSerial();
    }

    public static String u() {
        return dw().getAndroidId();
    }

    public static String x() {
        return dw().getTotalSpace();
    }

    public static String b(com.bytedance.sdk.openadsdk.core.h.u uVar) {
        return dw().getSSID(Boolean.valueOf((uVar.nr() && uVar.fx()) ? false : true));
    }

    public static String fx(com.bytedance.sdk.openadsdk.core.h.u uVar) {
        return dw().getMacAddress(Boolean.valueOf(uVar.nr()));
    }

    public static String[] nr(boolean z) {
        return dw().getNewIpAddrs(z);
    }

    public static String pn(com.bytedance.sdk.openadsdk.core.h.u uVar) {
        return dw().getImsi(Boolean.valueOf(uVar.u()));
    }

    public static int u(boolean z) {
        return dw().getDeviceType(z);
    }

    public static String fx(boolean z) {
        return dw().getOAID(z);
    }

    public static String nr(com.bytedance.sdk.openadsdk.core.h.u uVar) {
        return dw().getImei(Boolean.valueOf(uVar.u()));
    }

    public static String u(com.bytedance.sdk.openadsdk.core.h.u uVar) {
        return dw().getWifiMac(Boolean.valueOf((uVar.nr() && uVar.fx()) ? false : true));
    }

    public static List<ResolveInfo> u(Intent intent, int i) {
        return com.bytedance.sdk.openadsdk.core.dw.getContext().getPackageManager().queryIntentActivities(intent, i);
    }
}
