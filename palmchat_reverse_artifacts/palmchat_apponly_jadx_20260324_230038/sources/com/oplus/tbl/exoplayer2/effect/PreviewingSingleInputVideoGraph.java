package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.DebugViewProvider;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tbl.exoplayer2.PreviewingVideoGraph;
import com.oplus.tbl.exoplayer2.VideoFrameProcessor;
import com.oplus.tbl.exoplayer2.VideoGraph;
import com.oplus.tbl.exoplayer2.effect.DefaultVideoFrameProcessor;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class PreviewingSingleInputVideoGraph extends SingleInputVideoGraph implements PreviewingVideoGraph {

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements PreviewingVideoGraph.Factory {
        private final VideoFrameProcessor.Factory videoFrameProcessorFactory;

        public Factory() {
            this(new DefaultVideoFrameProcessor.Factory.Builder().build());
        }

        @Override // com.oplus.tbl.exoplayer2.PreviewingVideoGraph.Factory
        public PreviewingVideoGraph create(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, List<Effect> list, long j) {
            Presentation presentation = null;
            for (int i = 0; i < list.size(); i++) {
                Effect effect = list.get(i);
                if (effect instanceof Presentation) {
                    presentation = (Presentation) effect;
                }
            }
            return new PreviewingSingleInputVideoGraph(context, this.videoFrameProcessorFactory, colorInfo, colorInfo2, debugViewProvider, listener, executor, presentation, j);
        }

        public Factory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
        }
    }

    private PreviewingSingleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, ColorInfo colorInfo2, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, @Nullable Presentation presentation, long j) {
        super(context, factory, colorInfo, colorInfo2, listener, debugViewProvider, executor, VideoCompositorSettings.DEFAULT, false, presentation, j);
    }

    @Override // com.oplus.tbl.exoplayer2.PreviewingVideoGraph
    public void renderOutputFrame(long j) {
        getProcessor(0).renderOutputFrame(j);
    }
}
