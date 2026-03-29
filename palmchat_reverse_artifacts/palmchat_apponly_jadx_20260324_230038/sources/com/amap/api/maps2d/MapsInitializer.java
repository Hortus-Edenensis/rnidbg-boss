package com.amap.api.maps2d;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.col.p0002sl.ba;
import com.amap.api.col.p0002sl.ft;
import com.amap.api.col.p0002sl.fx;
import com.amap.api.col.p0002sl.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3088a = true;
    private static boolean b = false;
    private static int c = 1;
    public static String sdcardDir = "";

    public static boolean getNetworkEnable() {
        return f3088a;
    }

    public static int getProtocol() {
        return c;
    }

    public static boolean getUpdateDataActiveEnable() {
        return b;
    }

    public static String getVersion() {
        return "6.0.0";
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            ba.f2628a = context.getApplicationContext();
        }
    }

    public static void loadWorldGridMap(boolean z) {
        z.i = !z ? 1 : 0;
    }

    public static void replaceURL(String str, String str2) {
        if (str == null || str.equals("")) {
            return;
        }
        z.h = str;
        z.g = str2 + "DIY";
        if (str.contains("openstreetmap")) {
            z.c = 19;
        }
    }

    public static void setApiKey(String str) {
        ft.a(str);
    }

    public static void setNetworkEnable(boolean z) {
        f3088a = z;
    }

    public static void setProtocol(int i) {
        c = i;
        fx.a().a(c == 2);
    }

    public static void setUpdateDataActiveEnable(boolean z) {
        b = z;
    }
}
