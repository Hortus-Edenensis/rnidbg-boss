package com.opos.mobad.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f9193a = new AtomicBoolean(false);

    public static void a() {
        try {
            if (f9193a.compareAndSet(true, false)) {
                com.opos.cmn.an.f.a.a("LocationTool", MiPushClient.COMMAND_UNREGISTER);
                com.opos.mobad.d.b.b.a().b();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("LocationTool", "", e);
        }
    }

    public static boolean b() {
        return f9193a.get();
    }

    public static double[] c() {
        try {
            return com.opos.mobad.d.b.b.a().c();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("LocationTool", "", e);
            return new double[]{0.0d, 0.0d};
        }
    }

    public static com.opos.mobad.d.b.a d() {
        try {
            return com.opos.mobad.d.b.b.a().d();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("LocationTool", "", e);
            return new com.opos.mobad.d.b.a(0.0d, 0.0d, 0L, false);
        }
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                if (f9193a.compareAndSet(false, true)) {
                    com.opos.cmn.an.f.a.a("LocationTool", "register");
                    com.opos.mobad.d.b.b.a().a(context);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("LocationTool", "", e);
            }
        }
    }
}
