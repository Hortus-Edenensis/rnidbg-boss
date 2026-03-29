package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static be f10873a = null;
    private static String b = null;
    private static boolean c = false;

    public static synchronized String a(Context context) {
        if (!UMConfigure.shouldCollectOaid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAID(): oaid开关已关闭。");
            return null;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
        if (context == null) {
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        if (f10873a == null) {
            f10873a = bh.a();
        }
        be beVar = f10873a;
        if (beVar != null) {
            try {
                String strA = beVar.a(context);
                if (!TextUtils.isEmpty(strA)) {
                    b = strA;
                }
                c = true;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "OpenDeviceId:getOAID() result: " + b);
                return b;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String b(Context context) {
        if (UMConfigure.shouldCollectOaid()) {
            return c ? b : a(context);
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAIDFromCache(): oaid开关已关闭。");
        return null;
    }

    @Deprecated
    public static synchronized String c(Context context) {
        if (UMConfigure.shouldCollectOaid()) {
            return null;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaid(): oaid开关已关闭。");
        return null;
    }

    @Deprecated
    public static synchronized String d(Context context) {
        if (UMConfigure.shouldCollectOaid()) {
            return null;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaidFromCache(): oaid开关已关闭。");
        return null;
    }
}
