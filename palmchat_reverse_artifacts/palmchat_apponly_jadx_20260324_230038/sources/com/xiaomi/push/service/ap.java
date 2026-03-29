package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ap f11728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f946a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f947a;

    private ap(Context context) {
        this.f947a = context.getApplicationContext();
    }

    public static ap a(Context context) {
        if (f11728a == null) {
            f11728a = new ap(context);
        }
        return f11728a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m725a() {
        String str = com.xiaomi.push.x.f1045a;
        return str.contains("xmsf") || str.contains("xiaomi") || str.contains("miui");
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i = this.f946a;
        if (i != 0) {
            return i;
        }
        try {
            this.f946a = Settings.Global.getInt(this.f947a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f946a;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Uri m724a() {
        return Settings.Global.getUriFor("device_provisioned");
    }
}
