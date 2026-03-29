package com.heytap.mspsdk.util;

import com.heytap.mspsdk.log.MspLog;
import com.oplus.os.OplusBuild;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f6413a = -1;

    public static boolean a() {
        try {
            return b() >= 34;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int b() {
        if (f6413a != -1) {
            return f6413a;
        }
        f6413a = OplusBuild.getOplusOSVERSION();
        MspLog.e("ColorOSVersionUtils", "oplus ver:" + f6413a);
        return f6413a;
    }
}
