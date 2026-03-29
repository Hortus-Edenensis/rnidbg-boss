package com.oplus.tbl.exoplayer2;

import com.oplus.tbl.exoplayer2.source.TrackGroupArray;
import com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection;
import com.oplus.tbl.exoplayer2.upstream.Allocator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface LoadControl {
    Allocator getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr);

    boolean retainBackBufferFromKeyframe();

    boolean shouldContinueLoading(long j, long j2, float f);

    boolean shouldStartPlayback(long j, float f, boolean z, long j2);
}
