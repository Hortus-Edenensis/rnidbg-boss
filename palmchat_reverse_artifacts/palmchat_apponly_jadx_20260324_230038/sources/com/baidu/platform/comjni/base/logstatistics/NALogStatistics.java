package com.baidu.platform.comjni.base.logstatistics;

import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NALogStatistics extends NativeComponent {
    public NALogStatistics() {
        create();
    }

    public static native boolean nativeAddLog(long j, int i, int i2, String str, String str2, String str3);

    public static native long nativeCreate();

    public static native boolean nativeRegisterCallback(long j);

    public static native int nativeRelease(long j);

    public static native boolean nativeSave(long j);

    public boolean a(int i, int i2, String str, String str2, String str3) {
        return nativeAddLog(this.mNativePointer, i, i2, str, str2, str3);
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
