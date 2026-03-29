package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class px2 extends iv2 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile px2 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20127a;
    public kx2 b;

    public static px2 s() {
        if (c == null) {
            synchronized (px2.class) {
                if (c == null) {
                    c = new px2();
                }
            }
        }
        return c;
    }

    @Override // defpackage.iv2
    public void e(Context context, String str) {
        this.b = jx2.d(context);
    }

    @Override // defpackage.iv2
    public String i(Context context) {
        this.f20127a = context;
        vx2.b = true;
        return "JWakeReport";
    }

    @Override // defpackage.iv2
    public boolean p(Context context, String str) {
        return super.p(context, str);
    }

    @Override // defpackage.iv2
    public void r(Context context, String str) {
        if (this.b.t) {
            JSONArray jSONArrayN = mx2.n(context);
            if (jSONArrayN == null || jSONArrayN.length() == 0) {
                p63.a("JWakeReport", "no report wakeData");
            } else {
                p63.a("JWakeReport", "report wakeData:" + jSONArrayN);
                rv2.C(context, jSONArrayN);
                mx2.d(context);
            }
        } else {
            p63.f("JWakeReport", "server set do not report wake data.");
        }
        if (this.b.u) {
            JSONArray jSONArrayC = vx2.c(context);
            if (jSONArrayC == null || jSONArrayC.length() == 0) {
                p63.a("JWakeReport", "no report wakedData");
            } else {
                p63.a("JWakeReport", "report wakedData:" + jSONArrayC);
                rv2.C(context, jSONArrayC);
                vx2.a(context);
            }
        } else {
            p63.f("JWakeReport", "server set do not report waked data.");
        }
        super.r(context, str);
    }
}
