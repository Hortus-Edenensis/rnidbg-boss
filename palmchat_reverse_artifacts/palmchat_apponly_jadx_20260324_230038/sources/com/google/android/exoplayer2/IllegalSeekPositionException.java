package com.google.android.exoplayer2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final e0 timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(e0 e0Var, int i, long j) {
        this.timeline = e0Var;
        this.windowIndex = i;
        this.positionMs = j;
    }
}
