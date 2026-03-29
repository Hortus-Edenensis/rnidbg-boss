package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface VideoCompositor extends GlTextureProducer {

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onEnded();

        void onError(VideoFrameProcessingException videoFrameProcessingException);
    }

    void queueInputTexture(int i, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, ColorInfo colorInfo, long j);

    int registerInputSource();

    void release();

    void signalEndOfInputSource(int i);
}
