package com.ss.bytertc.engine.handler;

import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.engine.IRTCAudioDeviceManagerEx;
import com.ss.bytertc.engine.engineimpl.RTCVideoImpl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCAudioDeviceEventHandler {
    private static final String TAG = "RtcAudioDeviceEventHandler";

    @CalledByNative
    public void onRecordingAudioVolumeIndication(int i) {
        IRTCAudioDeviceManagerEx.IRTCAudioDeviceEventHandler audioDeviceManagerEvent = RTCVideoImpl.getAudioDeviceManagerEvent();
        if (audioDeviceManagerEvent != null) {
            audioDeviceManagerEvent.onRecordingAudioVolumeIndication(i);
        }
    }

    @CalledByNative
    public void OnLoopbackAudioVolumeIndication(int i) {
    }
}
