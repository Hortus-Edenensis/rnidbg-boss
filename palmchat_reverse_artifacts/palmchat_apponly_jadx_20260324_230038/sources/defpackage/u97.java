package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.instant.router.callback.Callback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class u97 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f21164a;
    public static Handler b;
    public static com.oplus.instant.router.callback.a c = new com.oplus.instant.router.callback.a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21165a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ Map f;

        public a(Context context, String str, Map map, Map map2, Map map3, Map map4) {
            this.f21165a = context;
            this.b = str;
            this.c = map;
            this.d = map2;
            this.e = map3;
            this.f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ie7.h(this.f21165a) < 1100) {
                u97.y(u97.c, new Exception("platform not found"));
            } else {
                u97.z(this.b, this.f21165a, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21166a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ Map f;

        public b(String str, Context context, Map map, Map map2, Map map3, Map map4) {
            this.f21166a = str;
            this.b = context;
            this.c = map;
            this.d = map2;
            this.e = map3;
            this.f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            u97.B(this.f21166a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21167a;
        public final /* synthetic */ Intent b;
        public final /* synthetic */ Callback c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                u97.u(c.this.c);
            }
        }

        public c(Context context, Intent intent, Callback callback) {
            this.f21167a = context;
            this.b = intent;
            this.c = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!(this.f21167a instanceof Activity)) {
                    this.b.addFlags(268435456);
                }
                this.f21167a.startActivity(this.b);
                u97.f21164a.post(new a());
            } catch (Exception e) {
                u97.y(this.c, e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callback f21169a;
        public final /* synthetic */ Throwable b;

        public d(Callback callback, Throwable th) {
            this.f21169a = callback;
            this.b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            u97.A(this.f21169a, this.b);
        }
    }

    public static void A(Callback callback, Throwable th) {
        Callback.Response response = new Callback.Response();
        response.setCode(-8);
        response.setMsg(th.getMessage());
        callback.onResponse(response);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void B(String str, Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        String queryParameter;
        if (str != null) {
            try {
                if (str.contains("pkg")) {
                    try {
                        queryParameter = Uri.parse(str).getQueryParameter("pkg");
                    } catch (Exception unused) {
                        queryParameter = "";
                    }
                } else {
                    queryParameter = "";
                }
            } catch (Throwable th) {
                y(c, th);
                return;
            }
        }
        i(context, queryParameter);
        o(map, queryParameter);
        Map<String, Object> mapS = s(map);
        String str2 = (String) mapS.get("secret");
        String str3 = (String) mapS.get("origin");
        Uri uriQ = q(str, j17.a(context, str2, e(mapS)));
        ContentValues contentValuesA = a(context, str, map, map2, map3, map4, str2, str3);
        context.getContentResolver().registerContentObserver(uriQ, false, new zv6(context, mapS, c, uriQ));
        context.getContentResolver().insert(uriQ, contentValuesA);
    }

    public static ContentValues a(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        g(contentValues, OapsKey.KEY_SIGN_TYPE, map.get(OapsKey.KEY_SIGN_TYPE));
        g(contentValues, "req_url", j17.a(context, str2, str));
        g(contentValues, "from", "ins_sdk");
        g(contentValues, "origin", str3);
        f(contentValues, "encrypt", 1);
        h(contentValues, "EXTRA_DEEPLINK_PARAMS", map2);
        h(contentValues, "EXTRA_STAT_PARAMS", map3);
        h(contentValues, "EXTRA_EXTEND_PARAMS", map4);
        return contentValues;
    }

    public static Cursor b(Context context, Uri uri) {
        try {
            return context.getContentResolver().query(uri, null, null, null, null);
        } catch (Throwable th) {
            h87.d("RequestUtil", th);
            return null;
        }
    }

    public static Uri c(String str, String str2) {
        StringBuilder sb;
        String str3;
        Uri uri = Uri.parse(str);
        if (uv6.b()) {
            sb = new StringBuilder();
            str3 = "content://tv.";
        } else {
            sb = new StringBuilder();
            str3 = "content://";
        }
        sb.append(str3);
        sb.append(uri.getScheme());
        sb.append("_");
        sb.append(uri.getHost());
        sb.append("/");
        sb.append(str2);
        return Uri.parse(sb.toString());
    }

    public static String e(Map<String, ?> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(str);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(map.get(str));
        }
        return sb.toString();
    }

    public static void f(ContentValues contentValues, String str, int i) {
        contentValues.put(str, Integer.valueOf(i));
    }

    public static void g(ContentValues contentValues, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        contentValues.put(str, str2);
    }

    public static void h(ContentValues contentValues, String str, Map<String, ?> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        contentValues.put(str, e(map));
    }

    public static void i(Context context, String str) throws com.oplus.instant.router.c.a {
        if (!ie7.f(context)) {
            throw new com.oplus.instant.router.c.a(104, str);
        }
    }

    public static synchronized void j(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        x();
        Context applicationContext = context.getApplicationContext();
        if (c37.b(applicationContext, str, map4)) {
            callback = c37.a(context, str, callback);
        }
        if (str.startsWith("hap://app/") && map4 != null && "1".equals(map4.get("in_one_task"))) {
            callback = new com.oplus.instant.router.callback.c(context, str, callback);
        }
        c.a(callback);
        f21164a.post(new a(applicationContext, str, map2, map, map3, map4));
    }

    public static void m(Exception exc, Context context, String str, Callback callback) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            y(callback, exc);
            return;
        }
        if (b == null) {
            b = new Handler(Looper.getMainLooper());
        }
        b.post(new c(context, intent, callback));
    }

    public static void o(Map<String, String> map, String str) throws com.oplus.instant.router.c.a {
        if (!map.containsKey("origin")) {
            throw new com.oplus.instant.router.c.a(102, str);
        }
        if (!map.containsKey("secret")) {
            throw new com.oplus.instant.router.c.a(103, str);
        }
    }

    public static boolean p(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        if (!"oaps".equals(uri.getScheme()) && !"hap".equals(uri.getScheme())) {
            return false;
        }
        if (!"oaps".equals(uri.getScheme()) || "instant".equals(uri.getHost())) {
            return !TextUtils.isEmpty(uri.getPath());
        }
        return false;
    }

    public static Uri q(String str, String str2) {
        StringBuilder sb;
        String str3;
        Uri uri = Uri.parse(str);
        if (uv6.b()) {
            sb = new StringBuilder();
            str3 = "content://tv.preload_";
        } else {
            sb = new StringBuilder();
            str3 = "content://preload_";
        }
        sb.append(str3);
        sb.append(uri.getScheme());
        sb.append("_");
        sb.append(uri.getHost());
        sb.append("/");
        sb.append(str2);
        return Uri.parse(sb.toString());
    }

    public static Map<String, Object> s(Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.put("ts", String.valueOf(System.currentTimeMillis()));
        map2.put("version", ie7.a());
        return map2;
    }

    public static void t(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        x();
        c.a(callback);
        f21164a.post(new b(str, context, map2, map, map3, map4));
    }

    public static void u(Callback callback) {
        Callback.Response response = new Callback.Response();
        response.setCode(1);
        response.setMsg("success");
        callback.onResponse(response);
    }

    public static synchronized void x() {
        Handler handler = f21164a;
        if (handler == null || handler.getLooper() == null) {
            HandlerThread handlerThread = new HandlerThread("instant-req");
            handlerThread.start();
            if (handlerThread.getLooper() != null) {
                f21164a = new Handler(handlerThread.getLooper());
            } else {
                f21164a = new Handler();
            }
        }
    }

    public static void y(Callback callback, Throwable th) {
        if (rd7.a()) {
            f21164a.post(new d(callback, th));
        } else {
            A(callback, th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
    
        if (r13.startsWith("hap://") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0092, code lost:
    
        if (r13.startsWith("hap://") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
    
        m(r0, r14, r13, defpackage.u97.c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void z(String str, Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        String queryParameter;
        if (str != null) {
            try {
                try {
                    if (str.contains("pkg")) {
                        try {
                            queryParameter = Uri.parse(str).getQueryParameter("pkg");
                        } catch (Exception unused) {
                            queryParameter = "";
                        }
                    } else {
                        queryParameter = "";
                    }
                } catch (Throwable th) {
                    th = th;
                    y(c, th);
                    return;
                }
            } catch (IllegalArgumentException e) {
                th = e;
                if (th.getMessage().contains("Unknown URL content")) {
                }
                y(c, th);
                return;
            } catch (SecurityException e2) {
                th = e2;
                if (th.getMessage().contains("Failed to find provider hap_app")) {
                }
                y(c, th);
                return;
            }
        }
        i(context, queryParameter);
        o(map, queryParameter);
        Map<String, Object> mapS = s(map);
        String str2 = (String) mapS.get("secret");
        String str3 = (String) mapS.get("origin");
        Uri uriC = c(str, j17.a(context, str2, e(mapS)));
        ContentValues contentValuesA = a(context, str, map, map2, map3, map4, str2, str3);
        context.getContentResolver().registerContentObserver(uriC, false, new zv6(context, mapS, c, uriC));
        context.getContentResolver().insert(uriC, contentValuesA);
    }
}
