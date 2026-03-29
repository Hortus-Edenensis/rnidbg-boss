package com.ss.bytertc.engine;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SubscribeVideoConfig {
    private int priority;
    private int videoIndex;

    public SubscribeVideoConfig(int i, int i2) {
        this.videoIndex = i;
        this.priority = i2;
    }

    @CalledByNative
    public int getPriority() {
        return this.priority;
    }

    @CalledByNative
    public int getVideoIndex() {
        return this.videoIndex;
    }

    public String toString() {
        return "SubscribeVideoConfig{videoIndex=" + this.videoIndex + ", priority=" + this.priority + '}';
    }
}
