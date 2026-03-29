package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import defpackage.ix6;
import defpackage.tz6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class e37 extends p47 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            be7.a("2014");
            e37.this.f19938a = ix6.a.g(iBinder);
            try {
                iBinder.linkToDeath(e37.this.m, 0);
            } catch (RemoteException e) {
                e = e;
                str = "1028";
                be7.b(str, e);
            } catch (Exception e2) {
                e = e2;
                str = "1067";
                be7.b(str, e);
            }
            synchronized (e37.this.d) {
                be7.a("2015");
                e37.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            be7.a("2016");
            e37.this.f19938a = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e37 f17209a = new e37();
    }

    public e37() {
        this.e = new a();
    }

    @Override // defpackage.p47
    public Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(lx6.c("Y29tLmhleXRhcC5vcGVuaWQ="), lx6.c("Y29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl")));
        intent.setAction(lx6.c("YWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ=="));
        be7.a("2012");
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027 A[ORIG_RETURN, RETURN] */
    @Override // defpackage.p47
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(String str) {
        String str2;
        try {
            return this.i ? h(str) : ((ix6) this.f19938a).a(this.b, this.c, str);
        } catch (NullPointerException e) {
            e = e;
            str2 = "1027";
            be7.b(str2, e);
            return str != "OUID_STATUS" ? "FALSE" : "";
        } catch (Exception e2) {
            e = e2;
            str2 = "1070";
            be7.b(str2, e);
            if (str != "OUID_STATUS") {
            }
        }
    }

    @Override // defpackage.p47
    public void c(Context context, String str, String str2) {
        tz6.b.f21101a.b(context, str, str2);
    }

    @Override // defpackage.p47
    public boolean f(String str) {
        return tz6.b.f21101a.f(str);
    }

    @Override // defpackage.p47
    public boolean g(String str) {
        return tz6.b.f21101a.d(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean j(Context context) {
        String str;
        boolean z;
        boolean z2;
        this.h = context;
        String strC = lx6.c("Y29tLmhleXRhcC5vcGVuaWQ=");
        be7.a("2008:" + strC);
        try {
            PackageInfo packageInfo = this.h.getPackageManager().getPackageInfo(strC, 8);
            if (packageInfo == null || packageInfo.versionCode < 1) {
                z = false;
            } else {
                Context context2 = this.h;
                if (Build.VERSION.SDK_INT >= 29 || lx6.k(context2, "android").equals(lx6.k(context2, strC))) {
                    z = true;
                }
            }
            if (z) {
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (providerInfoArr == null || providerInfoArr.length == 0) {
                    Log.e("IDHelper", "1089");
                } else {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (providerInfo.authority.equals("com.oplus.omes.oaid_status_provider")) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    this.k = true;
                    be7.a("2053");
                }
                int i = Build.VERSION.SDK_INT;
                if ((i == 27 || i == 26) && packageInfo.versionCode >= 7) {
                    this.j = true;
                }
            }
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            str = "1068";
            be7.b(str, e);
            return false;
        } catch (Exception e2) {
            e = e2;
            str = "1069";
            be7.b(str, e);
            return false;
        }
    }
}
