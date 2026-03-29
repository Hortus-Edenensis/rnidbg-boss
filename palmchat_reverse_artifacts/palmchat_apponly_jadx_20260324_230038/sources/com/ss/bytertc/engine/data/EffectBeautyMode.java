package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum EffectBeautyMode {
    WHITE(0),
    SMOOTH(1),
    SHARPEN(2),
    CLEAR(3);

    private int value;

    EffectBeautyMode(int i) {
        this.value = i;
    }

    @CalledByNative
    public static EffectBeautyMode fromId(int i) {
        for (EffectBeautyMode effectBeautyMode : values()) {
            if (effectBeautyMode.value() == i) {
                return effectBeautyMode;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == WHITE ? "kEffectBeautyWhiteMode" : this == SMOOTH ? "kEffectBeautySmoothMode" : this == SHARPEN ? "kEffectBeautySharpenMode" : this == CLEAR ? "kEffectBeautyClearMode" : "";
    }

    public int value() {
        return this.value;
    }
}
