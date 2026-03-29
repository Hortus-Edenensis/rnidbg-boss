package com.kwad.sdk.crash;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Keep
public class FakeNativeCrash {
    public static final String TAG = "FakeNativeCrash";

    @Keep
    public static native void init(boolean z, int i);

    @Keep
    public static void upload(int i, int i2, String str) {
        com.kwad.sdk.core.d.c.e(TAG, "upload: signal=" + i + ", code=" + i2 + ", nativeBacktraceStr=" + str);
    }
}
