package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum RemoteMirrorType {
    NONE(0),
    RENDER(1);

    private int value;

    RemoteMirrorType(int i) {
        this.value = i;
    }

    @CalledByNative
    public static RemoteMirrorType fromId(int i) {
        for (RemoteMirrorType remoteMirrorType : values()) {
            if (remoteMirrorType.value() == i) {
                return remoteMirrorType;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == NONE ? "NONE" : this == RENDER ? "RENDER" : "";
    }

    public int value() {
        return this.value;
    }
}
