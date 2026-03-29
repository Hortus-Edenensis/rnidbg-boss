package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class AbiUtil {
    private static Abi bdm;

    /* JADX INFO: compiled from: SearchBox */
    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String cy(Context context) {
        return isArm64(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054 A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:21:0x0042, B:22:0x0046, B:24:0x0054, B:25:0x0059), top: B:33:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #1 {all -> 0x005e, blocks: (B:21:0x0042, B:22:0x0046, B:24:0x0054, B:25:0x0059), top: B:33:0x0042 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Abi cz(Context context) {
        Abi abi = bdm;
        if (abi != null) {
            return abi;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            bdm = Process.is64Bit() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
        } else {
            try {
                bdm = ((Boolean) z.callMethod(z.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
            } catch (Throwable th) {
                th.printStackTrace();
                if (context == null) {
                    try {
                        context = ServiceProvider.getContext();
                        if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                            bdm = Abi.UNKNOWN;
                        } else {
                            bdm = Abi.ARM64_V8A;
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        bdm = Abi.UNKNOWN;
                    }
                } else if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                }
            }
        }
        return bdm;
    }

    public static boolean isArm64(Context context) {
        return cz(context) == Abi.ARM64_V8A;
    }
}
