package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import defpackage.j27;
import defpackage.z17;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d37 extends p47 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            be7.a("2014");
            d37.this.f19938a = j27.a.g(iBinder);
            try {
                iBinder.linkToDeath(d37.this.m, 0);
            } catch (RemoteException e) {
                e = e;
                str = "1076";
                be7.b(str, e);
            } catch (Exception e2) {
                e = e2;
                str = "1077";
                be7.b(str, e);
            }
            synchronized (d37.this.d) {
                be7.a("2015");
                d37.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            be7.a("2016");
            d37.this.f19938a = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d37 f16969a = new d37();
    }

    public d37() {
        this.e = new a();
    }

    @Override // defpackage.p47
    public Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.oplus.stdid", "com.oplus.stdid.IdentifyService"));
        intent.setAction("action.com.oplus.stdid.ID_SERVICE");
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
            return this.i ? h(str) : ((j27) this.f19938a).a(this.b, this.c, str);
        } catch (NullPointerException e) {
            e = e;
            str2 = "1080";
            be7.b(str2, e);
            return str != "OUID_STATUS" ? "FALSE" : "";
        } catch (Exception e2) {
            e = e2;
            str2 = "1081";
            be7.b(str2, e);
            if (str != "OUID_STATUS") {
            }
        }
    }

    @Override // defpackage.p47
    public void c(Context context, String str, String str2) {
        z17.a.f22322a.b(context, str, str2);
    }

    @Override // defpackage.p47
    public boolean f(String str) {
        return z17.a.f22322a.f(str);
    }

    @Override // defpackage.p47
    public boolean g(String str) {
        return z17.a.f22322a.d(str);
    }
}
