package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fl7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17553a;
    public ij7 b;
    public Map<String, Object> c;

    public fl7(@NonNull Context context, @NonNull ij7 ij7Var) {
        this.f17553a = context;
        this.b = ij7Var;
    }

    public static boolean f(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }

    public String a() {
        return sl7.a(this.f17553a);
    }

    @NonNull
    public ij7 b() {
        return this.b;
    }

    @Nullable
    public Map<String, Object> c() {
        if (this.c == null) {
            this.c = this.b.x();
        }
        return this.c;
    }

    public String d() {
        return this.b.nr();
    }

    @Nullable
    public Map<String, Object> e() {
        Map<String, Object> mapU = this.b.u();
        if (mapU == null) {
            mapU = new HashMap<>(4);
        }
        if (f(mapU)) {
            try {
                PackageInfo packageInfo = this.f17553a.getPackageManager().getPackageInfo(this.f17553a.getPackageName(), 128);
                mapU.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                mapU.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (mapU.get("update_version_code") == null) {
                    Bundle bundle = packageInfo.applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = mapU.get("version_code");
                    }
                    mapU.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                mapU.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, sl7.f(this.f17553a));
                mapU.put("version_code", Integer.valueOf(sl7.c(this.f17553a)));
                if (mapU.get("update_version_code") == null) {
                    mapU.put("update_version_code", mapU.get("version_code"));
                }
            }
        }
        return mapU;
    }
}
