package com.ss.bytertc.engine.type;

import com.ss.android.ttvecamera.TECameraResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum SetRoomExtraInfoResult {
    SUCCESS(0),
    NOT_JOIN_ROOM(-1),
    KEY_IS_NULL(-2),
    VALUE_IS_NULL(-3),
    UNKNOW(-99),
    KEY_IS_EMPTY(-400),
    TOO_OFTEN(-406),
    SILENT_USER(TECameraResult.TER_CAMERA_FOCUS_NOT_SUPPORT),
    KEY_TOO_LONG(TECameraResult.TER_CAMERA_EC_FAILED),
    VALUE_TOO_LONG(TECameraResult.TER_CAMERA_EC_NOT_SUPPORT),
    SERVER_ERROR(TECameraResult.TER_SENSE_TIME_ERROR);

    private final int value;

    SetRoomExtraInfoResult() {
        this.value = 0;
    }

    public static SetRoomExtraInfoResult fromId(int i) {
        for (SetRoomExtraInfoResult setRoomExtraInfoResult : values()) {
            if (setRoomExtraInfoResult.value() == i) {
                return setRoomExtraInfoResult;
            }
        }
        return UNKNOW;
    }

    public int value() {
        return this.value;
    }

    SetRoomExtraInfoResult(int i) {
        this.value = i;
    }
}
