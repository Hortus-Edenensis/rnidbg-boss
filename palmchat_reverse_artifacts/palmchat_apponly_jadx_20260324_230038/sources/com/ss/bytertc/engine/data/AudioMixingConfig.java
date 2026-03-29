package com.ss.bytertc.engine.data;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AudioMixingConfig {
    public long callbackOnProgressInterval;
    public int playCount;
    public int position;
    public boolean syncProgressToRecordFrame;
    public AudioMixingType type;

    public AudioMixingConfig(AudioMixingType audioMixingType, int i) {
        this(audioMixingType, i, 0, 0L);
    }

    public String toString() {
        return "AudioMixingConfig{type='" + this.type + "', playCount='" + this.playCount + "', pos='" + this.position + "', callbackOnProgressInterval='" + this.callbackOnProgressInterval + "'}";
    }

    public AudioMixingConfig(AudioMixingType audioMixingType, int i, int i2, long j) {
        this.syncProgressToRecordFrame = false;
        this.type = audioMixingType;
        this.playCount = i;
        this.position = i2;
        this.callbackOnProgressInterval = j;
    }
}
