package com.zm.fda.oaid.Z200O;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.zm.fda.oaid.Z200O.O022Z;
import com.zm.fda.oaid.Z200O.OO22Z;
import com.zm.fda.oaid.interfaces.coolpad.deviceidsupport.IDeviceIdManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z extends com.zm.fda.oaid.ZZ00Z {
    public static final String b = "FDA_OAID_coolpad";
    public static final String c = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmNvb2xwYWQuZGV2aWNlaWRzdXBwb3J0");
    public static final String d = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmNvb2xwYWQuZGV2aWNlaWRzdXBwb3J0LkRldmljZUlkU2VydmljZQ==");

    public OO22Z(Context context) {
        this.f16722a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.zm.fda.oaid.Z25O0 z25o0, String str) {
        if (!com.zm.fda.oaid.ZZ00Z.a(str)) {
            a(new com.zm.fda.oaid.Z25O0() { // from class: z44
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str2) {
                    OO22Z.b(z25o0, str2);
                }
            });
        } else if (z25o0 != null) {
            z25o0.a(str);
        }
    }

    public static /* synthetic */ void b(com.zm.fda.oaid.Z25O0 z25o0, String str) {
        if (z25o0 != null) {
            z25o0.a(str);
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
            d(new com.zm.fda.oaid.Z25O0() { // from class: u44
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str) {
                    this.f21132a.a(z25o0, str);
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
        } catch (Exception unused) {
            Log.e(b, "coolpad not support inner api");
            return false;
        }
    }

    private void d(final com.zm.fda.oaid.Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (!isSupport()) {
            z25o0.a("");
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(c, d));
        O022Z.a(this.f16722a, intent, z25o0, new O022Z.OO22Z() { // from class: p44
            @Override // com.zm.fda.oaid.Z200O.O022Z.OO22Z
            public final void a(IBinder iBinder) {
                this.f19936a.a(z25o0, iBinder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.zm.fda.oaid.Z25O0 z25o0, IBinder iBinder) {
        if (z25o0 == null) {
            return;
        }
        String oaid = "";
        if (iBinder == null) {
            z25o0.a("");
            return;
        }
        try {
            IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (iDeviceIdManagerAsInterface != null) {
                oaid = iDeviceIdManagerAsInterface.getOAID(this.f16722a.getPackageName());
                com.zm.fda.oaid.Z2500.Z25O0.a(b, "getOaidBySelf get oaid:" + oaid);
            } else {
                Log.e(b, "IDeviceIdManager is null");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        z25o0.a(oaid);
    }
}
