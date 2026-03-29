package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.ev;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class es {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f11552a = Log.isLoggable("BCompressed", 3);

    public static byte[] a(er erVar, byte[] bArr) {
        try {
            byte[] bArrA = ev.a.a(bArr);
            if (f11552a) {
                com.xiaomi.channel.commonutils.logger.b.m75a("BCompressed", "decompress " + bArr.length + " to " + bArrA.length + " for " + erVar);
                if (erVar.f400a == 1) {
                    com.xiaomi.channel.commonutils.logger.b.m75a("BCompressed", "decompress not support upStream");
                }
            }
            return bArrA;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m75a("BCompressed", "decompress error " + e);
            return bArr;
        }
    }
}
