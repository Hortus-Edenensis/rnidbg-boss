package com.baidu.platform.comjni.base.sdkauth;

import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NASDKAuth extends NativeComponent {
    public NASDKAuth() {
        create();
    }

    private static native long nativeCreate();

    private static native int nativeRelease(long j);

    public static native boolean nativeSetAuth(long j, String str, int i);

    public boolean a(String str, int i) {
        return nativeSetAuth(this.mNativePointer, str, i);
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer == 0) {
            return 0;
        }
        int iNativeRelease = nativeRelease(this.mNativePointer);
        this.mNativePointer = 0L;
        return iNativeRelease;
    }
}
