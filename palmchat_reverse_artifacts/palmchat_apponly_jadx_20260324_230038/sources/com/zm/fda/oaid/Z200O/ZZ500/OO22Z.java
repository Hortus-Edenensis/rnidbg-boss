package com.zm.fda.oaid.Z200O.ZZ500;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import com.zm.fda.oaid.Z200O.O022Z;
import com.zm.fda.oaid.Z200O.ZZ500.OO22Z;
import com.zm.fda.oaid.Z25O0;
import com.zm.fda.oaid.interfaces.bun.lib.MsaIdInterface;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z implements com.zm.fda.oaid.O022Z {
    public static final String b = "FDA_OAID_MsaImpl";
    public static final String c = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmJ1bi5tc2EuYWN0aW9uLmJpbmR0by5zZXJ2aWNl");
    public static final String d = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmJ1bi5tc2EuYWN0aW9uLnN0YXJ0LnNlcnZpY2U=");
    public static final String e = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLm1kaWQubXNh");
    public static final String f = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLm1kaWQubXNhLnNlcnZpY2UuTXNhSWRTZXJ2aWNl");
    public static final String g = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLm1kaWQubXNhLnNlcnZpY2UuTXNhS2xTZXJ2aWNl");
    public static final String h = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmJ1bi5tc2EucGFyYW0ucGtnbmFtZQ==");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16717a;

    public OO22Z(Context context) {
        this.f16717a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final Z25O0 z25o0) {
        a();
        Intent intent = new Intent(c);
        intent.setClassName(e, f);
        intent.putExtra(h, this.f16717a.getPackageName());
        com.zm.fda.oaid.Z200O.O022Z.a(this.f16717a, intent, z25o0, new O022Z.OO22Z() { // from class: w44
            @Override // com.zm.fda.oaid.Z200O.O022Z.OO22Z
            public final void a(IBinder iBinder) {
                OO22Z.a(z25o0, iBinder);
            }
        });
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        Context context = this.f16717a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(e, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.zm.fda.oaid.O022Z
    public void a(final Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (this.f16717a == null) {
            z25o0.a("");
        } else {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: s44
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20664a.b(z25o0);
                }
            });
        }
    }

    public static /* synthetic */ void a(Z25O0 z25o0, IBinder iBinder) {
        if (z25o0 == null) {
            return;
        }
        String oaid = "";
        try {
            MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (msaIdInterfaceAsInterface != null && msaIdInterfaceAsInterface.isSupported()) {
                oaid = msaIdInterfaceAsInterface.getOAID();
                com.zm.fda.oaid.Z2500.Z25O0.a(b, "get oaid:" + oaid);
            } else {
                Log.e(b, "MsaIdInterface#isSupported return false");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        z25o0.a(oaid);
    }

    private void a() {
        try {
            Intent intent = new Intent(d);
            intent.setClassName(e, g);
            intent.putExtra(h, this.f16717a.getPackageName());
            if (Build.VERSION.SDK_INT >= 26) {
                this.f16717a.startForegroundService(intent);
            } else {
                this.f16717a.startService(intent);
            }
        } catch (Exception unused) {
        }
    }
}
