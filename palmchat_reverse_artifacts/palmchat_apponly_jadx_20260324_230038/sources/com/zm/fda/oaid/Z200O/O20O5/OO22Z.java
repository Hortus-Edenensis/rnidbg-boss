package com.zm.fda.oaid.Z200O.O20O5;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import com.zm.fda.oaid.Z200O.O022Z;
import com.zm.fda.oaid.Z200O.O20O5.OO22Z;
import com.zm.fda.oaid.Z25O0;
import com.zm.fda.oaid.interfaces.huawei.hms.ads.identifier.OpenDeviceIdentifierService;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16709a = "FDA_OAID_HW_API";
    public static final String b = com.zm.fda.oaid.Z2500.OO22Z.a("cHBzX29haWQ=");
    public static final String c = com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF");

    public static void a(Context context, Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        String string = "";
        if (context == null) {
            z25o0.a("");
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                string = Settings.Global.getString(context.getContentResolver(), b);
                com.zm.fda.oaid.Z2500.Z25O0.a(f16709a, "get oaid from Settings.Global:" + string);
                if (!com.zm.fda.oaid.ZZ00Z.a(string)) {
                    b(context, z25o0);
                    return;
                }
            } catch (Throwable unused) {
            }
        }
        z25o0.a(string);
    }

    public static void b(Context context, final Z25O0 z25o0) throws IOException {
        try {
            context.getPackageManager().getPackageInfo(O022Z.a(context), 128);
            Intent intent = new Intent(c);
            intent.setPackage(O022Z.a(context));
            com.zm.fda.oaid.Z200O.O022Z.a(context, intent, z25o0, new O022Z.OO22Z() { // from class: q44
                @Override // com.zm.fda.oaid.Z200O.O022Z.OO22Z
                public final void a(IBinder iBinder) {
                    OO22Z.a(z25o0, iBinder);
                }
            });
        } catch (PackageManager.NameNotFoundException unused) {
            throw new IOException("Service not found");
        }
    }

    public static /* synthetic */ void a(Z25O0 z25o0, IBinder iBinder) {
        String oaid;
        if (z25o0 == null) {
            return;
        }
        try {
            oaid = OpenDeviceIdentifierService.Stub.asInterface(iBinder).getOaid();
            try {
                com.zm.fda.oaid.Z2500.Z25O0.a(f16709a, "get oaid from requestAdvertisingIdInfo:" + oaid);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            oaid = "";
        }
        z25o0.a(oaid);
    }

    public static boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo(O022Z.a(context), 128);
            new Intent(c).setPackage(O022Z.a(context));
            return !r1.queryIntentServices(r2, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }
}
