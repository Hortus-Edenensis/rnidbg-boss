package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class p0 implements VideoFrameProcessingTaskExecutor.Task {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GlShaderProgram f7619a;

    @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
    public final void run() {
        this.f7619a.signalEndOfCurrentInputStream();
    }
}
