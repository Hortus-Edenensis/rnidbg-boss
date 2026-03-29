package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalAudioVolumeInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AudioVolumeInfo {
    public int linearVolume;
    public int nonlinearVolume;
    public String uid;

    public AudioVolumeInfo(String str, int i, int i2) {
        this.uid = str;
        this.nonlinearVolume = i;
        this.linearVolume = i2;
    }

    public AudioVolumeInfo(InternalAudioVolumeInfo internalAudioVolumeInfo) {
        this.uid = internalAudioVolumeInfo.uid;
        this.nonlinearVolume = internalAudioVolumeInfo.nonlinearVolume;
        this.linearVolume = internalAudioVolumeInfo.linearVolume;
    }
}
