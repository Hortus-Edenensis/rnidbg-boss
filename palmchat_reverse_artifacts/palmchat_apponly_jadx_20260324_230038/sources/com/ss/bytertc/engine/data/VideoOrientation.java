package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum VideoOrientation {
    ADAPTIVE(0),
    PORTRAIT(1),
    LANDSCAPE(2);

    private int value;

    VideoOrientation(int i) {
        this.value = i;
    }

    @CalledByNative
    public static VideoOrientation fromId(int i) {
        for (VideoOrientation videoOrientation : values()) {
            if (videoOrientation.value() == i) {
                return videoOrientation;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = this.value;
        return i != 0 ? i != 1 ? i != 2 ? "" : "kVideoOrientationLandscape" : "kVideoOrientationPortrait" : "kVideoOrientationAdaptive";
    }

    public int value() {
        return this.value;
    }
}
