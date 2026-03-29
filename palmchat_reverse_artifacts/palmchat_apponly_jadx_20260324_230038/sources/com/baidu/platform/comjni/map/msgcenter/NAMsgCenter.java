package com.baidu.platform.comjni.map.msgcenter;

import com.baidu.platform.comjni.JNIBaseApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NAMsgCenter extends JNIBaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4264a = 0;

    private native boolean nativeCancelRequest(long j);

    private native long nativeCreate();

    private native boolean nativeFetchAccessToken(long j);

    private native String nativeGetCenterParam(long j, String str);

    private native boolean nativeMSGCStartup(long j);

    private native boolean nativeRegMsgCenter(long j, String str);

    private native int nativeRelease(long j);

    private native boolean nativeSetCenterParam(long j, String str);
}
