package com.ss.bytertc.ktv.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class HotMusicInfo {
    public String hotName;
    public MusicHotType hotType;
    public MusicInfo[] musicInfos;

    @CalledByNative
    public HotMusicInfo(MusicHotType musicHotType, String str, MusicInfo[] musicInfoArr) {
        this.hotType = musicHotType;
        this.hotName = str;
        this.musicInfos = musicInfoArr;
    }
}
