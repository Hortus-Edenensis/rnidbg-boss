package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum VideoFrameType {
    RAW_MEMORY(0),
    GL_TEXTURE(2);

    private int value;

    VideoFrameType(int i) {
        this.value = i;
    }

    @CalledByNative
    public static VideoFrameType fromId(int i) {
        for (VideoFrameType videoFrameType : values()) {
            if (videoFrameType.value() == i) {
                return videoFrameType;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == RAW_MEMORY ? "kVideoFrameTypeRawMemory" : "kVideoFrameTypeGLTexture";
    }

    @CalledByNative
    public int value() {
        return this.value;
    }
}
