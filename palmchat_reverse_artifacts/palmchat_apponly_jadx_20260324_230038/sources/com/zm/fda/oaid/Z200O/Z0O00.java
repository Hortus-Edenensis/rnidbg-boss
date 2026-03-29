package com.zm.fda.oaid.Z200O;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import com.zm.fda.oaid.Z200O.O022Z;
import com.zm.fda.oaid.interfaces.oplus.stdid.IStdID;
import defpackage.nq6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z0O00 extends ZZ0O5 {
    public static final String e = "FDA_OAID_oneplus";
    public static final String f = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmNvbG9yb3MubWNz");

    /* JADX INFO: compiled from: SearchBox */
    public class OO22Z implements O022Z.OO22Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.zm.fda.oaid.Z25O0 f16710a;

        public OO22Z(com.zm.fda.oaid.Z25O0 z25o0) {
            this.f16710a = z25o0;
        }

        @Override // com.zm.fda.oaid.Z200O.O022Z.OO22Z
        public void a(IBinder iBinder) {
            String strA;
            if (this.f16710a == null) {
                return;
            }
            if (iBinder != null) {
                strA = Z0O00.this.a(iBinder);
                com.zm.fda.oaid.Z2500.Z25O0.a(Z0O00.e, "getOaidBySelf oaid :" + strA);
            } else {
                strA = "";
            }
            this.f16710a.a(strA);
        }
    }

    public Z0O00(Context context) {
        super(context);
        this.f16722a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.zm.fda.oaid.Z25O0 z25o0, String str) {
        if (com.zm.fda.oaid.ZZ00Z.a(str)) {
            z25o0.a(str);
        } else {
            z25o0.getClass();
            a(new nq6(z25o0));
        }
    }

    private void d(com.zm.fda.oaid.Z25O0 z25o0) {
        String string = Settings.Secure.getString(this.f16722a.getContentResolver(), com.zm.fda.oaid.Z2500.OO22Z.a("b3BsdXNfb21lc19zdGRpZF9vdWlk"));
        com.zm.fda.oaid.Z2500.Z25O0.a(e, "oplus_omes_stdid_ouid getOaidBySelf oaid :" + string);
        if (com.zm.fda.oaid.ZZ00Z.a(string)) {
            z25o0.a(string);
        } else {
            if (!isSupport()) {
                z25o0.a("");
                return;
            }
            Intent intent = new Intent(com.zm.fda.oaid.Z2500.OO22Z.a("YWN0aW9uLmNvbS5vcGx1cy5zdGRpZC5JRF9TRVJWSUNF"));
            intent.setComponent(new ComponentName(f, com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLm9wbHVzLnN0ZGlkLklkZW50aWZ5U2VydmljZQ==")));
            O022Z.a(this.f16722a, intent, z25o0, new OO22Z(z25o0));
        }
    }

    @Override // com.zm.fda.oaid.Z200O.ZZ0O5, com.zm.fda.oaid.ZZ00Z
    public void c(final com.zm.fda.oaid.Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (this.f16722a != null) {
            d(new com.zm.fda.oaid.Z25O0() { // from class: tp6
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str) {
                    this.f21039a.a(z25o0, str);
                }
            });
        } else {
            com.zm.fda.oaid.Z2500.Z25O0.a(e, "context==null, oaid 返回空");
            z25o0.a("");
        }
    }

    @Override // com.zm.fda.oaid.Z200O.ZZ0O5, com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        Context context = this.f16722a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(f, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.zm.fda.oaid.Z200O.ZZ0O5
    public String a(IBinder iBinder, String str, String str2) {
        try {
            IStdID iStdIDAsInterface = IStdID.Stub.asInterface(iBinder);
            if (iStdIDAsInterface != null) {
                return iStdIDAsInterface.getSerID(str, str2, com.zm.fda.oaid.Z2500.OO22Z.a("T1VJRA=="));
            }
            Log.e(e, "getSerId err");
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
