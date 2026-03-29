package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class zb7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22391a = "f";

    public static String a(String str) {
        Context contextA = wp0.a();
        if (contextA == null) {
            return "";
        }
        try {
            return contextA.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            ga7.d(f22391a, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            ga7.d(f22391a, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable unused) {
            ga7.d(f22391a, "throwable");
            return "";
        }
    }
}
