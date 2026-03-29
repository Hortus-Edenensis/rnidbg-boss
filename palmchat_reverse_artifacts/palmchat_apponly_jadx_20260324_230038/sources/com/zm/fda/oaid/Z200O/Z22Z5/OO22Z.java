package com.zm.fda.oaid.Z200O.Z22Z5;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.zm.fda.oaid.Z200O.O022Z;
import com.zm.fda.oaid.Z200O.Z22Z5.OO22Z;
import com.zm.fda.oaid.Z25O0;
import com.zm.fda.oaid.interfaces.qiku.id.IOAIDInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z extends com.zm.fda.oaid.ZZ00Z {
    public static final String c = "FDA_OAID_360";
    public static final String d = com.zm.fda.oaid.Z2500.OO22Z.a("cWlrdS5zZXJ2aWNlLmFjdGlvbi5pZA==");
    public static final String e = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLnFpa3UuaWQ=");
    public boolean b = true;

    public OO22Z(Context context) {
        this.f16722a = context;
    }

    public static /* synthetic */ void b(Z25O0 z25o0, String str) {
        if (z25o0 != null) {
            z25o0.a(str);
        }
    }

    @Override // com.zm.fda.oaid.ZZ00Z
    public void c(final Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (this.f16722a == null) {
            z25o0.a("");
        } else {
            d(new Z25O0() { // from class: v44
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str) {
                    this.f21355a.a(z25o0, str);
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
            if (context.getPackageManager().getPackageInfo(e, 0) != null) {
                return true;
            }
            this.b = false;
            return ZZ00Z.a().d();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final Z25O0 z25o0, String str) {
        if (!com.zm.fda.oaid.ZZ00Z.a(str)) {
            super.a(new Z25O0() { // from class: y44
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str2) {
                    OO22Z.b(z25o0, str2);
                }
            });
        } else if (z25o0 != null) {
            z25o0.a(str);
        }
    }

    private void d(final Z25O0 z25o0) {
        if (this.f16722a == null) {
            return;
        }
        String strB = "";
        if (!isSupport() || this.f16722a == null) {
            com.zm.fda.oaid.Z2500.Z25O0.b(c, !isSupport() ? "不支持系统内部获取oaid" : "context = null");
            z25o0.a("");
            return;
        }
        if (this.b) {
            Intent intent = new Intent(d);
            intent.setPackage(e);
            O022Z.a(this.f16722a, intent, z25o0, new O022Z.OO22Z() { // from class: r44
                @Override // com.zm.fda.oaid.Z200O.O022Z.OO22Z
                public final void a(IBinder iBinder) {
                    OO22Z.a(z25o0, iBinder);
                }
            });
        } else {
            try {
                strB = ZZ00Z.a().b();
                com.zm.fda.oaid.Z2500.Z25O0.a(c, "QikuOaidManager get oaid:" + strB);
            } catch (Exception unused) {
            }
            z25o0.a(strB);
        }
    }

    public static /* synthetic */ void a(Z25O0 z25o0, IBinder iBinder) {
        if (z25o0 == null) {
            return;
        }
        String oaid = "";
        try {
            IOAIDInterface iOAIDInterfaceAsInterface = IOAIDInterface.Stub.asInterface(iBinder);
            if (iOAIDInterfaceAsInterface != null) {
                oaid = iOAIDInterfaceAsInterface.getOAID();
                com.zm.fda.oaid.Z2500.Z25O0.a(c, "anInterface get oaid:" + oaid);
            } else {
                Log.e(c, "IdsSupplier is null");
            }
        } catch (Throwable unused) {
        }
        z25o0.a(oaid);
    }
}
