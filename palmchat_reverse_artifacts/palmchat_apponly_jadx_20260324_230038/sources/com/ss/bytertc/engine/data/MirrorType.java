package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum MirrorType {
    MIRROR_TYPE_NONE(0),
    MIRROR_TYPE_RENDER(1),
    MIRROR_TYPE_RENDER_AND_ENCODER(3);

    private int value;

    MirrorType(int i) {
        this.value = i;
    }

    @CalledByNative
    public static MirrorType fromId(int i) {
        for (MirrorType mirrorType : values()) {
            if (mirrorType.value() == i) {
                return mirrorType;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == MIRROR_TYPE_NONE ? "kMirrorTypeNone" : this == MIRROR_TYPE_RENDER ? "kMirrorTypeRender" : this == MIRROR_TYPE_RENDER_AND_ENCODER ? "kMirrorTypeRenderAndEncoder" : "";
    }

    public int value() {
        return this.value;
    }
}
