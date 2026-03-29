package com.ss.bytertc.engine.video;

import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.engine.type.VideoDeviceFacing;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VideoDeviceInfo {
    public VideoDeviceFacing deviceFacing;
    public String deviceId;
    public String deviceName;

    public VideoDeviceInfo() {
        this.deviceId = "";
        this.deviceName = "";
        this.deviceFacing = VideoDeviceFacing.UNKNOWN;
    }

    @CalledByNative
    public static VideoDeviceInfo create(String str, String str2, VideoDeviceFacing videoDeviceFacing) {
        return new VideoDeviceInfo(str, str2, videoDeviceFacing);
    }

    public VideoDeviceInfo(String str, String str2, VideoDeviceFacing videoDeviceFacing) {
        this.deviceId = str;
        this.deviceName = str2;
        this.deviceFacing = videoDeviceFacing;
    }
}
