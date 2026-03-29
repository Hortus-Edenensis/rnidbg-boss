package com.xiaomi.push;

import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class di {
    public static byte[] a(String str, byte[] bArr) {
        byte[] bArrM185a = ay.m185a(str);
        try {
            a(bArrM185a);
            return h.a(bArrM185a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] bArrM185a = ay.m185a(str);
        try {
            a(bArrM185a);
            return h.b(bArrM185a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        if (com.xiaomi.push.service.ah.a(context).a(gk.DCJobMutualSwitch.a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !ac.a(context, str, j);
        }
        return false;
    }
}
