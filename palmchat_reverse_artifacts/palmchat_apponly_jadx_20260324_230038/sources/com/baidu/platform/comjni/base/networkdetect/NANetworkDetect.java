package com.baidu.platform.comjni.base.networkdetect;

import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NANetworkDetect extends NativeComponent {
    public NANetworkDetect() {
        create();
    }

    private native long nativeCreate();

    private native int nativeGetNetworkIP();

    private native boolean nativeIsNetWeak(long j);

    private native boolean nativeNetworkDetect(long j, String str);

    private native int nativeRelease(long j);

    private native boolean nativeSetNetStateDetectParams(long j, String str);

    public boolean a(String str) {
        return nativeNetworkDetect(this.mNativePointer, str);
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
}
