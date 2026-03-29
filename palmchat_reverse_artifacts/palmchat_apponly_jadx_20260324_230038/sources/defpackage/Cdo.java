package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: do, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Cdo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f17088a;
    public static a b;

    /* JADX INFO: renamed from: do$a */
    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        int getVersionCode();

        String getVersionName();
    }

    /* JADX INFO: renamed from: do$b */
    /* JADX INFO: compiled from: SearchBox */
    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17089a;
        public int b;
        public long c;
        public long d;
        public String e;
        public String f;

        public b(@NonNull Context context) throws Exception {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
            this.f17089a = packageInfo.versionName;
            this.b = packageInfo.versionCode;
            this.c = packageInfo.firstInstallTime;
            this.d = packageInfo.lastUpdateTime;
            a(context);
        }

        public final void a(Context context) {
            Bundle bundleA = ho.a(context);
            if (bundleA != null) {
                this.e = String.valueOf(bundleA.get("OS_CHANNEL"));
                this.f = String.valueOf(bundleA.get("splits_abi"));
            }
        }

        @Override // defpackage.Cdo.a
        public int getVersionCode() {
            return this.b;
        }

        @Override // defpackage.Cdo.a
        public String getVersionName() {
            return this.f17089a;
        }
    }

    public static a a(Context context) throws Exception {
        if (f17088a == null) {
            f17088a = new b(context);
        }
        return f17088a;
    }

    public static a b(Context context) throws Exception {
        a aVar = b;
        return aVar != null ? aVar : a(context);
    }

    public static int c(Context context) {
        try {
            return b(context).getVersionCode();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String d(Context context) {
        try {
            return b(context).getVersionName();
        } catch (Exception unused) {
            return "0.0";
        }
    }
}
