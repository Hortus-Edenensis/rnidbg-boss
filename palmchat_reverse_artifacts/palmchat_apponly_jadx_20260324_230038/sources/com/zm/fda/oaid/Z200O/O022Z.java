package com.zm.fda.oaid.Z200O;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z implements ServiceConnection {
    public static final String d = "FDA_OAID_DeviceService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16707a;
    public final com.zm.fda.oaid.Z25O0 b;
    public final OO22Z c;

    /* JADX INFO: compiled from: SearchBox */
    @FunctionalInterface
    public interface OO22Z {
        void a(IBinder iBinder);
    }

    public O022Z(Context context, com.zm.fda.oaid.Z25O0 z25o0, OO22Z oo22z) {
        this.f16707a = context;
        this.b = z25o0;
        this.c = oo22z;
    }

    public static void a(Context context, Intent intent, com.zm.fda.oaid.Z25O0 z25o0, OO22Z oo22z) {
        new O022Z(context, z25o0, oo22z).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i(d, "onServiceConnected ");
        OO22Z oo22z = this.c;
        if (oo22z != null) {
            try {
                oo22z.a(iBinder);
            } catch (Throwable th) {
                Log.e(d, "callRemoteInterface err", th);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d(d, "onServiceDisconnected");
    }

    private void a(Intent intent) {
        Context context = this.f16707a;
        if (context == null) {
            a("");
            return;
        }
        try {
            if (context.bindService(intent, this, 1)) {
                return;
            }
        } catch (Throwable th) {
            Log.e(d, "bindService err", th);
        }
        a("");
    }

    private void a(String str) {
        com.zm.fda.oaid.Z25O0 z25o0 = this.b;
        if (z25o0 != null) {
            z25o0.a(str);
        }
    }
}
