package com.opos.mobad.f.a.c;

import android.content.Context;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsListener;
import com.opos.cmn.i.g;
import com.opos.mobad.c.a.d;
import com.opos.mobad.c.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8840a;

    /* JADX INFO: renamed from: com.opos.mobad.f.a.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0743a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f8841a;
        public final int b;
        public final String c;

        public C0743a(int i, String str) {
            this.f8841a = i == 0;
            this.b = i;
            this.c = str;
        }
    }

    public a(Context context) {
        this.f8840a = context.getApplicationContext();
    }

    private boolean b(int i) {
        if (!com.opos.mobad.service.d.a.a(b.j().k()) || !c(i)) {
            return false;
        }
        com.opos.cmn.an.f.a.b("", "checkChannel is child " + i);
        return true;
    }

    private boolean c(int i) {
        return i == d.a.b || i == d.a.c || i == d.a.e;
    }

    public C0743a a(int i) {
        return !b.a().a(i) ? new C0743a(-5, "") : b(i) ? new C0743a(-8, "") : new C0743a(0, "");
    }

    public C0743a a(int i, boolean z) {
        return (z && c(i)) ? new C0743a(-10, "") : (c(i) && g.a(this.f8840a)) ? new C0743a(-11, "inter error keyguard") : a(i);
    }

    public C0743a a(String str) {
        return !b.k() ? new C0743a(-4, "SDK not initialized") : !b.b().a(str) ? new C0743a(AnalyticsListener.EVENT_DRM_SESSION_RELEASED, "inter error request") : new C0743a(0, "");
    }

    public C0743a a(String str, int i) {
        return !b.b().a(str) ? new C0743a(AnalyticsListener.EVENT_DRM_SESSION_RELEASED, "inter error request") : b(i) ? new C0743a(-8, "inter error request") : new C0743a(0, "");
    }

    public C0743a a(String str, int i, boolean z) {
        return (z && c(i)) ? new C0743a(-10, "inter error request server bidding") : (c(i) && g.a(this.f8840a)) ? new C0743a(-11, "inter error keyguard") : a(str, i);
    }
}
