package com.ss.bytertc.audio.device.router;

import com.ss.bytertc.audio.device.router.AudioRouteDeviceManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IAudioRouteCallback {
    void onDeviceEvent(@AudioRouteDeviceManager.RoutingDeviceType int i, boolean z);

    void onError(int i, String str);
}
