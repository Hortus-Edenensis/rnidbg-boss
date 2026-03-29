package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.apm.lite.ICommonParams;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a87 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1171a;
    public ICommonParams b;
    public ICommonParams c;

    public a87(Context context, ICommonParams iCommonParams) {
        this(context, iCommonParams, null);
    }

    public static String a(Map<String, Object> map, String str) {
        Object obj;
        if (map == null || (obj = map.get(str)) == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public static boolean c(Map<String, Object> map) {
        return map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code"));
    }

    public Map<String, Object> b() {
        Map<String, Object> mapD = d();
        if (a(mapD, "aid") == null) {
            mapD.put("aid", 4444);
        }
        return mapD;
    }

    public Map<String, Object> d() {
        Map<String, Object> map;
        Throwable th;
        Map<String, Object> map2;
        try {
            ICommonParams iCommonParams = this.c;
            map2 = iCommonParams != null ? iCommonParams.getCommonParams() : new HashMap<>();
            try {
                map2.putAll(this.b.getCommonParams());
                th = null;
            } catch (Throwable th2) {
                map = map2;
                th = th2;
                Map<String, Object> map3 = map;
                th = th;
                map2 = map3;
            }
        } catch (Throwable th3) {
            th = th3;
            map = null;
        }
        if (map2 == null) {
            map2 = new HashMap<>(4);
            if (th != null) {
                try {
                    map2.put("err_info", yl7.b(th));
                } catch (Throwable unused) {
                }
            }
        }
        if (c(map2)) {
            try {
                PackageInfo packageInfo = this.f1171a.getPackageManager().getPackageInfo(this.f1171a.getPackageName(), 128);
                map2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                map2.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (map2.get("update_version_code") == null) {
                    Bundle bundle = packageInfo.applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = map2.get("version_code");
                    }
                    map2.put("update_version_code", obj);
                }
            } catch (Throwable unused2) {
                map2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, kv6.n(this.f1171a));
                map2.put("version_code", Integer.valueOf(kv6.o(this.f1171a)));
                if (map2.get("update_version_code") == null) {
                    map2.put("update_version_code", map2.get("version_code"));
                }
            }
        } else {
            try {
                String str = this.f1171a.getPackageManager().getPackageInfo(this.f1171a.getPackageName(), 128).versionName;
                String str2 = (String) Class.forName(this.f1171a.getPackageName() + ".BuildConfig").getDeclaredField("VERSION_NAME").get(null);
                if (str != null && !str.equals(str2)) {
                    map2.put("manifest_version", str);
                }
            } catch (Throwable unused3) {
            }
        }
        return map2;
    }

    public ICommonParams e() {
        return this.b;
    }

    public String f() {
        try {
            return this.b.getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String g() {
        try {
            return String.valueOf(this.b.getCommonParams().get("aid"));
        } catch (Throwable unused) {
            return "4444";
        }
    }

    public long h() {
        try {
            return this.b.getUserId();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public a87(Context context, ICommonParams iCommonParams, a87 a87Var) {
        this.f1171a = context;
        this.b = iCommonParams;
        this.c = a87Var == null ? null : a87Var.b;
    }
}
