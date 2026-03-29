package com.oplus.tbl.exoplayer2.util;

import com.oplus.tbl.exoplayer2.PlaybackParameters;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface MediaClock {
    long getPendingDataOffsetUs();

    PlaybackParameters getPlaybackParameters();

    long getPositionUs();

    void setPlaybackParameters(PlaybackParameters playbackParameters);
}
