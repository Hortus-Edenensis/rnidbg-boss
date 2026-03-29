package com.ss.bytertc.engine.data;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum MediaInputType {
    MEDIA_INPUT_TYPE_EXTERNAL(0),
    MEDIA_INPUT_TYPE_INTERNAL(1);

    private int value;

    MediaInputType(int i) {
        this.value = i;
    }

    public static MediaInputType fromId(int i) {
        for (MediaInputType mediaInputType : values()) {
            if (mediaInputType.value() == i) {
                return mediaInputType;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
