package com.ss.bytertc.engine.video;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITextureBuffer {
    @CalledByNative
    int getTextureId();

    @CalledByNative
    int getTypeGlTarget();

    @CalledByNative
    float[] nativeGetTransFormMatrix();

    @CalledByNative
    void release();

    @CalledByNative
    void retain();
}
