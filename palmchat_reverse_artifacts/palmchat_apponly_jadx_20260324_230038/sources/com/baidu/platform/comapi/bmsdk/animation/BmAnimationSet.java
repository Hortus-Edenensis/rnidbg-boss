package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmAnimationSet extends BmAnimation {
    public BmAnimationSet() {
        super(86, nativeCreate());
    }

    private static native boolean nativeAddAnimation(long j, long j2, int i);

    private static native long nativeCreate();

    public boolean a(BmAnimation bmAnimation, int i) {
        if (bmAnimation == null) {
            return false;
        }
        return nativeAddAnimation(this.nativeInstance, bmAnimation.getNativeInstance(), i);
    }
}
