package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LocalAudioPropertiesInfo {
    public AudioPropertiesInfo audioPropertiesInfo;
    public StreamIndex streamIndex;

    public LocalAudioPropertiesInfo(StreamIndex streamIndex, AudioPropertiesInfo audioPropertiesInfo) {
        this.streamIndex = streamIndex;
        this.audioPropertiesInfo = audioPropertiesInfo;
    }

    @CalledByNative
    private static LocalAudioPropertiesInfo create(int i, int i2, int i3, float[] fArr, int i4, double d, int i5) {
        AudioPropertiesInfo audioPropertiesInfo = new AudioPropertiesInfo(i2, i3, fArr, i4);
        audioPropertiesInfo.voicePitch = d;
        audioPropertiesInfo.deviceLoopDelay = i5;
        return new LocalAudioPropertiesInfo(StreamIndex.fromId(i), audioPropertiesInfo);
    }

    public String toString() {
        return "LocalAudioPropertiesInfo{streamIndex='" + this.streamIndex + "'audioPropertiesInfo='" + this.audioPropertiesInfo.toString() + "'}";
    }
}
