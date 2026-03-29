package defpackage;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.apm.lite.MonitorCrash;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ef7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f17293a = null;
    public static volatile boolean b = false;
    public static volatile boolean c = false;
    public static Map<String, String> d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            ef7.f();
            if (ef7.d(false)) {
                jv6.a();
            }
        }
    }

    public static void a(String str) {
        if (d == null) {
            d = new HashMap();
        }
        d.put(str, String.valueOf(System.currentTimeMillis()));
        MonitorCrash.reInitAppLog(str);
    }

    public static void b(boolean z, JSONArray jSONArray) {
        try {
            re7.l(new File(wi7.E(x97.m()), "apmlite/configCrash/configFile"), jSONArray, false);
        } catch (IOException unused) {
        }
        try {
            re7.k(j(), d);
        } catch (Throwable unused2) {
        }
    }

    public static boolean c() {
        return b;
    }

    public static boolean d(boolean z) {
        File fileJ = j();
        try {
            Map<String, String> mapE = d;
            if (mapE == null) {
                mapE = re7.E(fileJ);
            }
            d = mapE;
            if (mapE == null) {
                d = new HashMap();
                return true;
            }
            if (mapE.size() < s07.k()) {
                return true;
            }
            Iterator<String> it = s07.l().iterator();
            while (it.hasNext()) {
                if (!d.containsKey(it.next())) {
                    return true;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z2 = false;
            for (Map.Entry<String, String> entry : d.entrySet()) {
                try {
                    long jLongValue = Long.decode(entry.getValue()).longValue();
                    if (ca7.d(entry.getKey())) {
                        if (jCurrentTimeMillis - jLongValue > ca7.g(entry.getKey())) {
                            z2 = true;
                        }
                    }
                } catch (Throwable th) {
                    kj7.f(th);
                }
            }
            kj7.a(z2 ? "config should be updated" : "config should not be updated");
            return z2;
        } catch (Throwable th2) {
            Log.e("npth", NotificationCompat.CATEGORY_ERROR, th2);
            return true;
        }
    }

    public static boolean e() {
        return c;
    }

    public static void f() {
        if (b) {
            return;
        }
        c = true;
        File file = new File(wi7.E(x97.m()), "apmlite/configCrash/configFile");
        if (file.exists()) {
            try {
                nv6.f(new JSONArray(re7.y(file)), false);
                b = true;
            } catch (Throwable unused) {
                nv6.f(null, false);
            }
        }
    }

    public static void g() {
        f();
        if (d(false)) {
            jv6.a();
        }
    }

    public static void h() {
        ih7.b().e(new a());
    }

    public static void i() {
        Map<String, String> map = d;
        if (map != null) {
            map.clear();
        }
    }

    public static File j() {
        if (f17293a == null) {
            f17293a = new File(wi7.E(x97.m()), "apmlite/configCrash/configInvalid");
        }
        return f17293a;
    }
}
