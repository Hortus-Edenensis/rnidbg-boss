package com.zm.fda.oaid.Z200O;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.zm.fda.oaid.Z200O.O022Z;
import com.zm.fda.oaid.Z200O.Z25O0;
import com.zm.fda.oaid.interfaces.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z25O0 implements com.zm.fda.oaid.O022Z {
    public static final String b = "FDA_OAID_gms";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16713a;

    public Z25O0(Context context) {
        this.f16713a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final com.zm.fda.oaid.Z25O0 z25o0) {
        Intent intent = new Intent(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmdvb2dsZS5hbmRyb2lkLmdtcy5hZHMuaWRlbnRpZmllci5zZXJ2aWNlLlNUQVJU"));
        intent.setPackage(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmdvb2dsZS5hbmRyb2lkLmdtcw=="));
        O022Z.a(this.f16713a, intent, z25o0, new O022Z.OO22Z() { // from class: xp6
            @Override // com.zm.fda.oaid.Z200O.O022Z.OO22Z
            public final void a(IBinder iBinder) {
                Z25O0.a(z25o0, iBinder);
            }
        });
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        Context context = this.f16713a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLmFuZHJvaWQudmVuZGluZw=="), 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.zm.fda.oaid.O022Z
    public void a(final com.zm.fda.oaid.Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (this.f16713a == null) {
            z25o0.a("");
        } else {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: yp6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22251a.b(z25o0);
                }
            });
        }
    }

    public static /* synthetic */ void a(com.zm.fda.oaid.Z25O0 z25o0, IBinder iBinder) {
        String id;
        if (z25o0 == null) {
            return;
        }
        id = "";
        try {
            IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
            id = iAdvertisingIdServiceAsInterface != null ? iAdvertisingIdServiceAsInterface.getId() : "";
            com.zm.fda.oaid.Z2500.Z25O0.a(b, "getOAIDByMSA get oaid:" + id);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        z25o0.a(id);
    }
}
