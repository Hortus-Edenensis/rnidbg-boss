package com.bun.miitmdid.core;

import android.content.Context;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IPermissionCallbackListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MdidSdkHelper {
    public static final int SDK_VERSION_CODE = e.b();
    public static final String SDK_VERSION = e.a();
    private static long globalTimeout = 5000;

    public static boolean InitCert(Context context, String str) {
        try {
            return e.a(context, str);
        } catch (AbstractMethodError | Error | Exception unused) {
            return false;
        }
    }

    public static int InitSdk(Context context, boolean z, IIdentifierListener iIdentifierListener) {
        try {
            return new e(z, globalTimeout).a(context, iIdentifierListener);
        } catch (Error e) {
            e.printStackTrace();
            return 1008615;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1008615;
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
            return 1008615;
        }
    }

    public static void requestOAIDPermission(Context context, IPermissionCallbackListener iPermissionCallbackListener) {
        e.a(context, iPermissionCallbackListener);
    }

    public static boolean setGlobalTimeout(long j) {
        if (j <= 0) {
            return false;
        }
        globalTimeout = j;
        return true;
    }

    public static int InitSdk(Context context, boolean z, boolean z2, boolean z3, boolean z4, IIdentifierListener iIdentifierListener) {
        try {
            return new e(z, globalTimeout, z2, z3, z4).a(context, iIdentifierListener);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return 1008615;
        } catch (Error e2) {
            e2.printStackTrace();
            return 1008615;
        } catch (Exception e3) {
            e3.printStackTrace();
            return 1008615;
        }
    }
}
