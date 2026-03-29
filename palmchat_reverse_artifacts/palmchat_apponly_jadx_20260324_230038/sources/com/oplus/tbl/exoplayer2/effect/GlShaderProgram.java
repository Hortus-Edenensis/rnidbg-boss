package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface GlShaderProgram {

    /* JADX INFO: compiled from: SearchBox */
    public interface ErrorListener {
        void onError(VideoFrameProcessingException videoFrameProcessingException);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface InputListener {
        void onFlush();

        void onInputFrameProcessed(GlTextureInfo glTextureInfo);

        void onReadyToAcceptInputFrame();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OutputListener {
        void onCurrentOutputStreamEnded();

        void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j);
    }

    void flush();

    void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j);

    void release() throws VideoFrameProcessingException;

    void releaseOutputFrame(GlTextureInfo glTextureInfo);

    void setErrorListener(Executor executor, ErrorListener errorListener);

    void setInputListener(InputListener inputListener);

    void setOutputListener(OutputListener outputListener);

    void signalEndOfCurrentInputStream();
}
