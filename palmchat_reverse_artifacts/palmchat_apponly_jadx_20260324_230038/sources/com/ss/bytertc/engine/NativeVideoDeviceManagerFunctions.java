package com.ss.bytertc.engine;

import com.ss.bytertc.engine.video.VideoDeviceInfo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NativeVideoDeviceManagerFunctions {
    public static native List<VideoDeviceInfo> nativeEnumerateVideoCaptureDevices(long j);

    public static native int nativeSetVideoCaptureDevice(long j, String str);
}
