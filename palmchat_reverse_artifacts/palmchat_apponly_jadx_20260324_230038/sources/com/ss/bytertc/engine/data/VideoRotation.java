package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;
import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum VideoRotation {
    VIDEO_ROTATION_0(0),
    VIDEO_ROTATION_90(90),
    VIDEO_ROTATION_180(EffectConstants.ROTATION_DEGREES_180),
    VIDEO_ROTATION_270(270);

    private int value;

    VideoRotation(int i) {
        this.value = i;
    }

    @CalledByNative
    public static VideoRotation fromId(int i) {
        for (VideoRotation videoRotation : values()) {
            if (videoRotation.value() == i) {
                return videoRotation;
            }
        }
        return null;
    }

    @CalledByNative
    public int value() {
        return this.value;
    }
}
