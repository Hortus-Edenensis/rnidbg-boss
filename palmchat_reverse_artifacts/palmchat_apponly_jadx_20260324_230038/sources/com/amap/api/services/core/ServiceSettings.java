package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.p0002sl.dh;
import com.amap.api.col.p0002sl.di;
import com.amap.api.col.p0002sl.es;
import com.amap.api.col.p0002sl.ft;
import com.amap.api.col.p0002sl.fx;
import com.amap.api.col.p0002sl.ga;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static ServiceSettings c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3143a = "zh-CN";
    private int b = 1;
    private int d = 20000;
    private int e = 20000;

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (c == null) {
            c = new ServiceSettings();
        }
        return c;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z) {
        ga.a(context, z, dh.a(false));
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z, boolean z2) {
        ga.a(context, z, z2, dh.a(false));
    }

    public void destroyInnerAsynThreadPool() {
        try {
            es.b();
        } catch (Throwable th) {
            di.a(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }

    public int getConnectionTimeOut() {
        return this.d;
    }

    public String getLanguage() {
        return this.f3143a;
    }

    public int getProtocol() {
        return this.b;
    }

    public int getSoTimeOut() {
        return this.e;
    }

    public void setApiKey(String str) {
        ft.a(str);
    }

    public void setConnectionTimeOut(int i) {
        if (i < 5000) {
            this.d = 5000;
        } else if (i > 30000) {
            this.d = 30000;
        } else {
            this.d = i;
        }
    }

    public void setLanguage(String str) {
        this.f3143a = str;
    }

    public void setProtocol(int i) {
        this.b = i;
        fx.a().a(this.b == 2);
    }

    public void setSoTimeOut(int i) {
        if (i < 5000) {
            this.e = 5000;
        } else if (i > 30000) {
            this.e = 30000;
        } else {
            this.e = i;
        }
    }
}
