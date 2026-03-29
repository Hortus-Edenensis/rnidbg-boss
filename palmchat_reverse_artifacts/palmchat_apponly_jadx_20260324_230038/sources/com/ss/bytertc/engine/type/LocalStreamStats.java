package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalLocalStreamStats;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LocalStreamStats {
    public LocalAudioStats audioStats;
    public boolean isScreen;
    public int rxQuality;
    public int txQuality;
    public LocalVideoStats videoStats;

    public LocalStreamStats() {
    }

    public String toString() {
        return "LocalStreamStats{audioStats=" + this.audioStats + ", videoStats=" + this.videoStats + ", isScreen=" + this.isScreen + ", txQuality=" + this.txQuality + ", rxQuality=" + this.rxQuality + '}';
    }

    public LocalStreamStats(InternalLocalStreamStats internalLocalStreamStats) {
        LocalAudioStats localAudioStats = new LocalAudioStats(internalLocalStreamStats.audioStats);
        LocalVideoStats localVideoStats = new LocalVideoStats(internalLocalStreamStats.videoStats);
        this.audioStats = localAudioStats;
        this.videoStats = localVideoStats;
        this.isScreen = internalLocalStreamStats.isScreen;
        this.txQuality = internalLocalStreamStats.txQuality;
        this.rxQuality = internalLocalStreamStats.rxQuality;
    }
}
