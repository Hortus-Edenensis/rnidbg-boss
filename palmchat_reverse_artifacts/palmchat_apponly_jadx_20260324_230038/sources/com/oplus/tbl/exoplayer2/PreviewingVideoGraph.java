package com.oplus.tbl.exoplayer2;

import android.content.Context;
import com.oplus.tbl.exoplayer2.VideoGraph;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface PreviewingVideoGraph extends VideoGraph {

    /* JADX INFO: compiled from: SearchBox */
    public interface Factory {
        PreviewingVideoGraph create(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, List<Effect> list, long j) throws VideoFrameProcessingException;
    }

    void renderOutputFrame(long j);
}
