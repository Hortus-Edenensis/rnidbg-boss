package androidx.media3.effect;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements VideoFrameProcessingTaskExecutor.Task {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultVideoCompositor f1329a;

    public /* synthetic */ l(DefaultVideoCompositor defaultVideoCompositor) {
        this.f1329a = defaultVideoCompositor;
    }

    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
    public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
        this.f1329a.maybeComposite();
    }
}
