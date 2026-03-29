package androidx.media3.effect;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface VideoCompositor extends GlTextureProducer {

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onEnded();

        void onError(VideoFrameProcessingException videoFrameProcessingException);
    }

    void queueInputTexture(int i, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, ColorInfo colorInfo, long j);

    void registerInputSource(int i);

    void release();

    void setVideoCompositorSettings(VideoCompositorSettings videoCompositorSettings);

    void signalEndOfInputSource(int i);
}
