package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gv2 {
    public static volatile gv2 i;
    public static final Object j = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17819a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    public gv2() {
        this.f17819a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.f17819a = k();
        this.b = f();
        this.c = j();
        this.d = l();
        this.e = h();
        this.f = i();
        this.g = c();
        this.h = d();
    }

    public static gv2 a() {
        if (i == null) {
            synchronized (j) {
                if (i == null) {
                    i = new gv2();
                }
            }
        }
        return i;
    }

    public boolean b(Context context) {
        return this.b || this.f17819a;
    }

    public final boolean c() {
        k63.j("JClientsHelper", "isPluginJCommonSDK:true");
        return true;
    }

    public final boolean d() {
        boolean z;
        try {
            Class.forName("cn.jiguang.jmlinksdk.core.JMlinkInterfaceImpl");
            z = true;
        } catch (ClassNotFoundException e) {
            k63.j("JClientsHelper", "isPluginJMLinkSDK:" + e.getMessage());
            z = false;
        }
        k63.j("JClientsHelper", "isPluginJMLinkSDK:" + z);
        return z;
    }

    public boolean e() {
        return this.b;
    }

    public final boolean f() {
        boolean z;
        try {
            Class.forName("cn.jpush.im.android.api.JMessageClient");
            z = true;
        } catch (ClassNotFoundException e) {
            k63.j("JClientsHelper", "isPluginJMessageSDK:" + e.getMessage());
            z = false;
        }
        k63.j("JClientsHelper", "isPluginJMessageSDK:" + z);
        return z;
    }

    public boolean g() {
        return this.f17819a;
    }

    public final boolean h() {
        boolean z;
        try {
            Class.forName("cn.jiguang.adsdk.api.JSSPInterface");
            z = true;
        } catch (ClassNotFoundException e) {
            k63.j("JClientsHelper", "isPluginJSspSDK:" + e.getMessage());
            z = false;
        }
        k63.j("JClientsHelper", "isPluginJSspSDK:" + z);
        return z;
    }

    public final boolean i() {
        boolean z;
        try {
            Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
            z = true;
        } catch (ClassNotFoundException e) {
            k63.j("JClientsHelper", "isPluginJVerificationSDK:" + e.getMessage());
            z = false;
        }
        k63.j("JClientsHelper", "isPluginJVerificationSDK:" + z);
        return z;
    }

    public final boolean j() {
        boolean z;
        try {
            Class.forName("cn.jiguang.analytics.android.api.JAnalyticsInterface");
            z = true;
        } catch (ClassNotFoundException e) {
            k63.j("JClientsHelper", "isPluginJanalyticsSDK:" + e.getMessage());
            z = false;
        }
        k63.j("JClientsHelper", "isPluginJanalyticsSDK:" + z);
        return z;
    }

    public final boolean k() {
        boolean z;
        try {
            Class.forName("cn.jpush.android.api.JPushInterface");
            z = true;
        } catch (ClassNotFoundException e) {
            k63.j("JClientsHelper", "isPluginJpushSDK:" + e.getMessage());
            z = false;
        }
        k63.j("JClientsHelper", "isPluginJpushSDK:" + z);
        return z;
    }

    public final boolean l() {
        boolean z;
        try {
            Class.forName("cn.jiguang.share.android.api.JShareInterface");
            z = true;
        } catch (ClassNotFoundException e) {
            k63.j("JClientsHelper", "isPluginJshareSDK:" + e.getMessage());
            z = false;
        }
        k63.j("JClientsHelper", "isPluginJshareSDK:" + z);
        return z;
    }
}
