package com.ss.bytertc.engine;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class InternalGameAudioVolumeInfo {
    public String userId;
    public int volume;

    public InternalGameAudioVolumeInfo(String str, int i) {
        this.userId = str;
        this.volume = i;
    }

    @CalledByNative
    private static InternalGameAudioVolumeInfo create(String str, int i) {
        return new InternalGameAudioVolumeInfo(str, i);
    }
}
