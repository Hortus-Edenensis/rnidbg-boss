package com.zm.fda.oaid.Z200O;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.zm.fda.oaid.Z200O.O022Z;
import com.zm.fda.oaid.Z200O.ZZ0O5;
import com.zm.fda.oaid.interfaces.heytap.openid.IOpenID;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ0O5 extends com.zm.fda.oaid.ZZ00Z {
    public static final String c = "FDA_OAID_oppo";
    public static final String d = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmhleXRhcC5vcGVuaWQ=");
    public String b;

    public ZZ0O5(Context context) {
        this.f16722a = context;
    }

    @Override // com.zm.fda.oaid.ZZ00Z
    public void c(com.zm.fda.oaid.Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (this.f16722a == null) {
            z25o0.a("");
        } else {
            d(new OO22Z(z25o0));
        }
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        Context context = this.f16722a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(d, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.zm.fda.oaid.Z25O0 z25o0, IBinder iBinder) {
        String strA;
        if (z25o0 == null) {
            return;
        }
        if (iBinder != null) {
            strA = a(iBinder);
            com.zm.fda.oaid.Z2500.Z25O0.a(c, "getOaidBySelf oaid:" + strA);
        } else {
            strA = "";
        }
        z25o0.a(strA);
    }

    private void d(final com.zm.fda.oaid.Z25O0 z25o0) {
        Intent intent = new Intent(com.zm.fda.oaid.Z2500.OO22Z.a("YWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ=="));
        intent.setComponent(new ComponentName(d, com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl")));
        O022Z.a(this.f16722a, intent, z25o0, new O022Z.OO22Z() { // from class: rq6
            @Override // com.zm.fda.oaid.Z200O.O022Z.OO22Z
            public final void a(IBinder iBinder) {
                this.f20553a.a(z25o0, iBinder);
            }
        });
    }

    /* JADX INFO: compiled from: SearchBox */
    public class OO22Z implements com.zm.fda.oaid.Z25O0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.zm.fda.oaid.Z25O0 f16714a;

        public OO22Z(com.zm.fda.oaid.Z25O0 z25o0) {
            this.f16714a = z25o0;
        }

        @Override // com.zm.fda.oaid.Z25O0
        public void a(String str) {
            if (!com.zm.fda.oaid.ZZ00Z.a(str)) {
                ZZ0O5 zz0o5 = ZZ0O5.this;
                final com.zm.fda.oaid.Z25O0 z25o0 = this.f16714a;
                ZZ0O5.super.a(new com.zm.fda.oaid.Z25O0() { // from class: sq6
                    @Override // com.zm.fda.oaid.Z25O0
                    public final void a(String str2) {
                        ZZ0O5.OO22Z.a(z25o0, str2);
                    }
                });
            } else {
                com.zm.fda.oaid.Z25O0 z25o02 = this.f16714a;
                if (z25o02 != null) {
                    z25o02.a(str);
                }
            }
        }

        public static /* synthetic */ void a(com.zm.fda.oaid.Z25O0 z25o0, String str) {
            if (z25o0 != null) {
                z25o0.a(str);
            }
        }
    }

    public String a(IBinder iBinder) {
        Context context = this.f16722a;
        if (context == null) {
            return "";
        }
        try {
            String packageName = context.getPackageName();
            String str = this.b;
            if (str == null) {
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f16722a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b : bArrDigest) {
                    sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                }
                String string = sb.toString();
                this.b = string;
                return a(iBinder, packageName, string);
            }
            return a(iBinder, packageName, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String a(IBinder iBinder, String str, String str2) {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface == null) {
            Log.e(c, "get IOpenID service err");
            return "";
        }
        return iOpenIDAsInterface.getSerID(str, str2, "OUID");
    }
}
