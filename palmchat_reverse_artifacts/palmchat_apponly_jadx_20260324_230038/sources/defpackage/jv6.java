package defpackage;

import androidx.media3.common.C;
import com.apm.lite.j.e;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class jv6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Runnable f18523a = new a();
    public static int b = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            mj7 mj7VarB;
            Runnable runnable;
            long j;
            ih7.b().j(jv6.f18523a);
            if (yi7.c(x97.m())) {
                jv6.g();
            }
            if (jv6.b > 0) {
                if (kv6.k(x97.m())) {
                    mj7VarB = ih7.b();
                    runnable = jv6.f18523a;
                    j = C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
                } else {
                    mj7VarB = ih7.b();
                    runnable = jv6.f18523a;
                    j = 60000;
                }
                mj7VarB.f(runnable, j);
            }
        }
    }

    public static void a() {
        b = 40;
        ih7.b().e(f18523a);
    }

    public static void b() {
        if (!ef7.e()) {
            ef7.f();
        }
        if (yi7.c(x97.m()) && ef7.d(false)) {
            g();
        }
    }

    public static byte[] f() {
        try {
            return e.l(x97.o().getConfigUrl(), null, s07.c().toString().getBytes());
        } catch (Throwable th) {
            kj7.f(th);
            return null;
        }
    }

    public static synchronized void g() {
        int i = b;
        if (i > 0) {
            b = i - 1;
        }
        kj7.a("try fetchApmConfig");
        if (kv6.k(x97.m())) {
            JSONArray jSONArrayOptJSONArray = null;
            try {
                byte[] bArrF = f();
                if (bArrF != null) {
                    jSONArrayOptJSONArray = new JSONObject(new String(bArrF)).optJSONArray("data");
                }
            } catch (Throwable th) {
                kj7.e("npth", th);
            }
            kj7.a("after fetchApmConfig net " + jSONArrayOptJSONArray);
            if (jSONArrayOptJSONArray != null) {
                nv6.f(jSONArrayOptJSONArray, true);
                b = 0;
            } else {
                b -= 10;
            }
        } else {
            ef7.f();
            if (ef7.c()) {
                b = 0;
            }
        }
    }
}
