package a.a.c.a.d;

import a.a.c.a.b.c;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class e implements a.a.c.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.a.c.a.e.c<Boolean> f1112a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends a.a.c.a.e.c<Boolean> {
        @Override // a.a.c.a.e.c
        public Boolean a(Object[] objArr) {
            boolean z = false;
            try {
                if (((Context) objArr[0]).getPackageManager().getPackageInfo("com.huawei.hwid", 128) != null) {
                    z = true;
                }
            } catch (Throwable unused) {
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends c.a {
        public long c = 0;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return f1112a.b(context).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    @Override // a.a.c.a.b.c
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.a a(Context context) {
        String string;
        String string2;
        b bVar = new b();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
            } catch (Throwable th) {
                th.getMessage();
            }
            if (TextUtils.isEmpty(string)) {
                Pair pair = (Pair) new o(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new f()).a();
                if (pair != null) {
                    bVar.f1105a = (String) pair.first;
                    bVar.b = ((Boolean) pair.second).booleanValue();
                    int i = 0;
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                        if (packageInfo != null) {
                            i = packageInfo.versionCode;
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        e.getMessage();
                    }
                    bVar.c = i;
                }
            } else {
                bVar.f1105a = string;
                bVar.b = Boolean.parseBoolean(string2);
                bVar.c = 202003021704L;
            }
        }
        return bVar;
    }

    @Override // a.a.c.a.b.c
    public boolean b(Context context) {
        return c(context);
    }
}
