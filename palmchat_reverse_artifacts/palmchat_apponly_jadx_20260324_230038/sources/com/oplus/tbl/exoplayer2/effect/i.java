package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor;
import com.oplus.tbl.exoplayer2.util.GlUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class i implements VideoFrameProcessingTaskExecutor.Task {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultVideoCompositor f7604a;

    public /* synthetic */ i(DefaultVideoCompositor defaultVideoCompositor) {
        this.f7604a = defaultVideoCompositor;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
    public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
        this.f7604a.maybeComposite();
    }
}
