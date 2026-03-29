package com.oplus.tbl.exoplayer2.video;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface DropFrameManager {
    long adjustPresentTimeUs(long j);

    boolean canRender(long j);

    void doRender();

    void initialize(int i);

    boolean isAvailable();

    void setRealFps(float f);
}
