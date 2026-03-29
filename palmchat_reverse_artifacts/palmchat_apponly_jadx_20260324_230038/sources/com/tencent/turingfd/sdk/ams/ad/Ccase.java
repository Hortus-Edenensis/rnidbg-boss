package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.case, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Ccase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f10751a;

    public static synchronized boolean a(Context context) {
        if (f10751a != null) {
            return true;
        }
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        f10751a = applicationContext;
        return true;
    }

    public static synchronized Context a() {
        return f10751a;
    }
}
