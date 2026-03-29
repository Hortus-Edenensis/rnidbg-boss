package com.bytedance.realx.video;

import com.bytedance.realx.base.CalledByNative;
import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum RXVideoRotation {
    VIDEO_ROTATION_0(0),
    VIDEO_ROTATION_90(90),
    VIDEO_ROTATION_180(EffectConstants.ROTATION_DEGREES_180),
    VIDEO_ROTATION_270(270);

    private int value;

    RXVideoRotation(int i) {
        this.value = i;
    }

    @CalledByNative
    public static RXVideoRotation fromId(int i) {
        for (RXVideoRotation rXVideoRotation : values()) {
            if (rXVideoRotation.value() == i) {
                return rXVideoRotation;
            }
        }
        return null;
    }

    @CalledByNative
    public int value() {
        return this.value;
    }
}
