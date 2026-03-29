package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum VideoSuperResolutionModeChangedReason {
    VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF(0),
    VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON(1),
    VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED(2),
    VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE(3),
    VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT(4),
    VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE(5),
    VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED(6),
    VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED(7),
    VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT(8),
    VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST(9);

    private int value;

    VideoSuperResolutionModeChangedReason(int i) {
        this.value = i;
    }

    @CalledByNative
    public static VideoSuperResolutionModeChangedReason fromId(int i) {
        for (VideoSuperResolutionModeChangedReason videoSuperResolutionModeChangedReason : values()) {
            if (videoSuperResolutionModeChangedReason.value() == i) {
                return videoSuperResolutionModeChangedReason;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = this.value;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 100 ? i != 101 ? i != 200 ? "" : "kVideoSuperResolutionModeChangedReasonOther" : "kVideoSuperResolutionModeChangedReasonStreamNotExist" : "kVideoSuperResolutionModeChangedReasonNoComponent" : "kVideoSuperResolutionModeChangedReasonDynamicClose" : "kVideoSuperResolutionModeChangedReasonDeviceNotSupport" : "kVideoSuperResolutionModeChangedReasonOverUse" : "kVideoSuperResolutionModeChangedReasonResolutionExceed" : "kVideoSuperResolutionModeChangedReasonAPIOn" : "kVideoSuperResolutionModeChangedReasonAPIOff";
    }

    public int value() {
        return this.value;
    }
}
