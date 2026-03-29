package com.ss.bytertc.engine;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IRTCAudioDeviceManagerEx {

    /* JADX INFO: compiled from: SearchBox */
    public interface IRTCAudioDeviceEventHandler {
        void onRecordingAudioVolumeIndication(int i);
    }

    void setEnableSpeakerphone(boolean z);

    int startAudioCaptureDeviceTest(int i);

    int startAudioPlaybackDeviceTest(String str, int i);

    int stopAudioCaptureDeviceTest();

    int stopAudioPlaybackDeviceTest();
}
