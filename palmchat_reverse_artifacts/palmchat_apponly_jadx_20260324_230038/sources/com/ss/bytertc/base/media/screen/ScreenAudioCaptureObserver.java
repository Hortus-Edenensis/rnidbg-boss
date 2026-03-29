package com.ss.bytertc.base.media.screen;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ScreenAudioCaptureObserver {
    void onAudioFrameCapture(byte[] bArr, int i, int i2, int i3);

    void onCapturerStarted();

    void onCapturerStopped();
}
