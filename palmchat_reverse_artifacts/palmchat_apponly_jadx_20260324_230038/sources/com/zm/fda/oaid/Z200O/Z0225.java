package com.zm.fda.oaid.Z200O;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.zm.fda.oaid.Z200O.O022Z;
import com.zm.fda.oaid.Z200O.Z0225;
import com.zm.fda.oaid.interfaces.zui.deviceidservice.IDeviceidInterface;
import defpackage.nq6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z0225 extends com.zm.fda.oaid.ZZ00Z {
    public static final String b = "FDA_OAID_lenovo";
    public static final String c = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLnp1aS5kZXZpY2VpZHNlcnZpY2U=");

    public Z0225(Context context) {
        this.f16722a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.zm.fda.oaid.Z25O0 z25o0, String str) {
        if (com.zm.fda.oaid.ZZ00Z.a(str)) {
            z25o0.a(str);
        } else {
            z25o0.getClass();
            super.a(new nq6(z25o0));
        }
    }

    @Override // com.zm.fda.oaid.ZZ00Z
    public void c(final com.zm.fda.oaid.Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (this.f16722a == null) {
            z25o0.a("");
        } else {
            d(new com.zm.fda.oaid.Z25O0() { // from class: pp6
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str) {
                    this.f20074a.a(z25o0, str);
                }
            });
        }
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        Context context = this.f16722a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(c, 0) != null;
        } catch (Exception e) {
            Log.e(b, "lenovo is not support", e);
            return false;
        }
    }

    private void d(final com.zm.fda.oaid.Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (!isSupport() || this.f16722a == null) {
            z25o0.a("");
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(c, com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLnp1aS5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlaWRTZXJ2aWNl"));
        O022Z.a(this.f16722a, intent, z25o0, new O022Z.OO22Z() { // from class: rp6
            @Override // com.zm.fda.oaid.Z200O.O022Z.OO22Z
            public final void a(IBinder iBinder) {
                Z0225.a(z25o0, iBinder);
            }
        });
    }

    public static /* synthetic */ void a(com.zm.fda.oaid.Z25O0 z25o0, IBinder iBinder) {
        if (z25o0 == null) {
            return;
        }
        String oaid = "";
        try {
            IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
            if (iDeviceidInterfaceAsInterface != null && iDeviceidInterfaceAsInterface.isSupport()) {
                oaid = iDeviceidInterfaceAsInterface.getOAID();
                com.zm.fda.oaid.Z2500.Z25O0.a(b, "lenovo device get oaid:" + oaid);
            } else {
                Log.e(b, "IDeviceidInterface is null or not support");
            }
        } catch (Throwable th) {
            Log.e(b, "getOaidBySelf err", th);
        }
        z25o0.a(oaid);
    }
}
