package com.ss.bytertc.engine;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IRTCAudioDeviceManager {
    int startAudioDeviceRecordTest(int i);

    int startAudioPlaybackDeviceTest(String str, int i);

    int stopAudioDevicePlayTest();

    int stopAudioDeviceRecordAndPlayTest();

    int stopAudioPlaybackDeviceTest();
}
