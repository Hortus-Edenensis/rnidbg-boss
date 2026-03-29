package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class gk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static gk f2830a = null;
    private static boolean b = false;
    private static boolean c = false;
    private Context d;

    private gk(Context context) {
        this.d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (c) {
                c = false;
                return;
            }
            c = true;
            gl glVar = new gl(this.d);
            new hx();
            ie ieVarC = hx.c(glVar);
            if (ieVarC != null) {
                JSONObject jSONObject = new JSONObject(ge.a(gj.a(ieVarC.f2902a, ge.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    gg.f(this.d, glVar.f2833a);
                    gg.g(this.d, glVar.b);
                    gg.h(this.d, glVar.c);
                    gg.i(this.d, glVar.d);
                    gg.j(this.d, glVar.e);
                    gg.k(this.d, glVar.f);
                    gg.l(this.d, glVar.g);
                    gg.b(this.d, glVar.i);
                    gg.m(this.d, glVar.h);
                    gg.a(this.d, SystemClock.elapsedRealtime());
                    String strOptString = jSONObject.optString("aaid", "");
                    String strOptString2 = jSONObject.optString("resetToken", "");
                    String strOptString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(strOptString)) {
                        gg.c(this.d, strOptString);
                    }
                    if (!TextUtils.isEmpty(strOptString2)) {
                        gg.e(this.d, strOptString2);
                    }
                    if (!TextUtils.isEmpty(strOptString3)) {
                        gg.d(this.d, strOptString3);
                    }
                }
            }
            c = false;
        } catch (Throwable unused) {
            c = false;
        }
    }

    public static gk a(Context context) {
        if (f2830a == null) {
            synchronized (gk.class) {
                if (f2830a == null) {
                    f2830a = new gk(context);
                }
            }
        }
        return f2830a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            if (b) {
                b = false;
                return;
            }
            b = true;
            gi giVar = new gi(this.d);
            new hx();
            ie ieVarC = hx.c(giVar);
            if (ieVarC != null) {
                JSONObject jSONObject = new JSONObject(ge.a(gj.a(ieVarC.f2902a, ge.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    gg.f(this.d, giVar.f2829a);
                    gg.g(this.d, giVar.b);
                    gg.h(this.d, giVar.c);
                    gg.i(this.d, giVar.d);
                    gg.j(this.d, giVar.e);
                    gg.k(this.d, giVar.f);
                    gg.l(this.d, giVar.g);
                    gg.b(this.d, giVar.i);
                    gg.m(this.d, giVar.h);
                    gg.a(this.d, SystemClock.elapsedRealtime());
                    String strOptString = jSONObject.optString("aaid", "");
                    String strOptString2 = jSONObject.optString("resetToken", "");
                    String strOptString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(strOptString)) {
                        gg.c(this.d, strOptString);
                    }
                    if (!TextUtils.isEmpty(strOptString2)) {
                        gg.e(this.d, strOptString2);
                    }
                    if (!TextUtils.isEmpty(strOptString3)) {
                        gg.d(this.d, strOptString3);
                    }
                }
            }
            b = false;
        } catch (Throwable unused) {
            b = false;
        }
    }

    public final String a() {
        String strC = "";
        try {
            if (gh.d) {
                strC = gg.c(this.d);
                long jD = gg.d(this.d);
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (TextUtils.isEmpty(strC)) {
                    jc.a().b(new jd() { // from class: com.amap.api.col.2sl.gk.1
                        @Override // com.amap.api.col.p0002sl.jd
                        public final void a() {
                            gk.this.b();
                        }
                    });
                } else if (jElapsedRealtime - jD > gh.b) {
                    jc.a().b(new jd() { // from class: com.amap.api.col.2sl.gk.2
                        @Override // com.amap.api.col.p0002sl.jd
                        public final void a() {
                            gk.this.c();
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        return strC;
    }
}
