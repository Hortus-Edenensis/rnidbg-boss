package com.baidu.platform.comjni.engine;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NAEngine extends NativeComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LongLinkClient f4244a = null;
    private static boolean b = false;

    public NAEngine() {
        create();
    }

    public static void a() {
        nativeInitClass(new Bundle(), 0);
        b = true;
    }

    public static boolean b() {
        return nativeStartSocketProc();
    }

    public static boolean c() {
        try {
            LongLinkClient longLinkClient = f4244a;
            if (longLinkClient != null) {
                longLinkClient.unRegister(null);
                f4244a.release();
                f4244a = null;
            }
            return nativeUninitEngine();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String getIP(String str) {
        return nativeGetIP(str);
    }

    public static boolean initLongLinkClient() {
        if (f4244a == null) {
            try {
                f4244a = LongLinkClient.create();
            } catch (ComInitException unused) {
            }
        }
        return f4244a != null;
    }

    private native long nativeCreate();

    private static native void nativeEnableMonitor(boolean z);

    private static native boolean nativeGetFlaxLength(Bundle bundle);

    private static native String nativeGetIP(String str);

    private static native void nativeInitCVLogFilePath(String str);

    private static native int nativeInitClass(Object obj, int i);

    private static native boolean nativeInitEngine(Object obj, String str);

    private static native void nativeInitMonitor(String str);

    private static native void nativeMonitorAddLog(int i, String str, String str2);

    private static native void nativeMonitorSetLogPriority(int i);

    private static native void nativeMonitorSetOutPutType(int i);

    private native int nativeRelease(long j);

    private static native void nativeSetHttpsEnable(boolean z);

    private static native void nativeSetMonitorLogFilter(String[] strArr);

    private static native void nativeSetNewDomainEnable(boolean z);

    private static native void nativeSetProxyInfo(String str, int i);

    private static native void nativeStartRunningRequest();

    private static native boolean nativeStartSocketProc();

    private static native boolean nativeStartSocketProcByCache(String str);

    private static native void nativeSyncAppRuntime(String str);

    private static native void nativeUninitCVLogFilePath();

    private static native boolean nativeUninitEngine();

    public static void restartLongLink() {
        LongLinkClient longLinkClient = f4244a;
        if (longLinkClient != null) {
            try {
                longLinkClient.start();
            } catch (Exception unused) {
            }
        }
    }

    public static void startRunningRequest() {
        nativeStartRunningRequest();
    }

    public static void stopLongLink() {
        LongLinkClient longLinkClient = f4244a;
        if (longLinkClient != null) {
            try {
                longLinkClient.stop();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        return nativeRelease(this.mNativePointer);
    }

    public static void b(int i) {
        nativeMonitorSetOutPutType(i);
    }

    public static boolean a(Context context, String str) {
        if (!b) {
            a();
        }
        try {
            return nativeInitEngine(context, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(String str) {
        nativeInitMonitor(str);
    }

    public static void a(boolean z) {
        nativeEnableMonitor(z);
        nativeMonitorSetLogPriority(1);
    }

    public static void a(int i) {
        nativeMonitorSetLogPriority(i);
    }

    public static void a(String[] strArr) {
        nativeSetMonitorLogFilter(strArr);
    }

    public static void a(int i, String str, String str2) {
        nativeMonitorAddLog(i, str, str2);
    }
}
