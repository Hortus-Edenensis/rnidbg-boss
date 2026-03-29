package defpackage;

import android.content.Context;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ec7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17274a;
    public long b;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ec7 f17275a = new ec7();
    }

    public ec7() {
        this.f17274a = null;
        this.b = 0L;
    }

    public static ec7 a() {
        return b.f17275a;
    }

    public String b(Context context) {
        if (this.f17274a == null) {
            g(context);
        }
        return this.f17274a;
    }

    public final void c(Context context, long j) {
        w17.b(context, "AppExitTime", j);
    }

    public final void d(Context context, String str) {
        w17.c(context, "AppSessionId", str);
    }

    public final String e() {
        return UUID.randomUUID().toString();
    }

    public void f(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.b = jCurrentTimeMillis;
        c(context, jCurrentTimeMillis);
    }

    public void g(Context context) {
        if (i(context)) {
            this.f17274a = k(context);
        } else {
            h(context);
        }
    }

    public void h(Context context) {
        String strE = e();
        this.f17274a = strE;
        d(context, strE);
    }

    public final boolean i(Context context) {
        if (this.b == 0) {
            this.b = j(context);
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
        return jCurrentTimeMillis > 0 && jCurrentTimeMillis < 30000;
    }

    public final long j(Context context) {
        return w17.d(context, "AppExitTime", 0L);
    }

    public final String k(Context context) {
        return w17.e(context, "AppSessionId", "");
    }
}
