package defpackage;

import android.content.Context;
import android.os.Build;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f1624a = new HashMap();

    public static void a(HttpURLConnection httpURLConnection) {
        Map<String, String> map = f1624a;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : f1624a.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public static String b() {
        return "Android/" + ac1.g;
    }

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(f(Build.BRAND));
        sb.append("/");
        sb.append(f(Build.MODEL));
        sb.append("/");
        sb.append("Android/");
        sb.append(f(Build.VERSION.RELEASE));
        sb.append("/");
        sb.append(ac1.f);
        sb.append("/");
        sb.append(ac1.g);
        sb.append("/");
        sb.append(Locale.getDefault().toString());
        sb.append("/");
        float f = context.getResources().getDisplayMetrics().density;
        int i = (int) f;
        if (f - i > 0.0f) {
            sb.append(f);
        } else {
            sb.append(i);
        }
        sb.append("x/");
        sb.append(ac1.m);
        sb.append("/");
        sb.append(f(ac1.f1194a));
        return sb.toString();
    }

    public static String d() {
        return f1624a.get("User-Agent-ZX");
    }

    public static Map<String, String> e() {
        return f1624a;
    }

    public static String f(String str) {
        return str != null ? str.replace("/", "_") : "unknown";
    }

    public static void g(Context context) {
        HashMap map = new HashMap();
        f1624a = map;
        map.put("User-Agent-ZX", c(context));
        f1624a.put("User-Agent-ZX-Version", b());
    }
}
