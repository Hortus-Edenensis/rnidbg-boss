package com.volcengine.lxvertc.videocall.call;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum CallType {
    VIDEO(1),
    VOICE(2);

    private final int value;

    CallType(int i) {
        this.value = i;
    }

    public static CallType formValue(int i) {
        CallType callType = VIDEO;
        return i == callType.getValue() ? callType : VOICE;
    }

    public int getValue() {
        return this.value;
    }
}
