package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class ReplayableFrameCacheGlShaderProgram extends FrameCacheGlShaderProgram {
    private static final int CAPACITY = 2;
    private static final int REGULAR_FRAME_INDEX = 1;
    private static final int REPLAY_FRAME_INDEX = 0;
    private int cacheSize;
    private final TimedGlTextureInfo[] cachedFrames;

    public ReplayableFrameCacheGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        super(context, 2, z);
        this.cachedFrames = new TimedGlTextureInfo[2];
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.cacheSize = 0;
        super.flush();
    }

    public long getReplayFramePresentationTimeUs() {
        if (isEmpty()) {
            return -9223372036854775807L;
        }
        return this.cachedFrames[0].presentationTimeUs;
    }

    public boolean isEmpty() {
        return this.cacheSize == 0;
    }

    public void onFrameRendered(long j) {
        int i = this.cacheSize;
        if (i >= 2) {
            TimedGlTextureInfo[] timedGlTextureInfoArr = this.cachedFrames;
            TimedGlTextureInfo timedGlTextureInfo = timedGlTextureInfoArr[1];
            if (j < timedGlTextureInfo.presentationTimeUs) {
                return;
            }
            TimedGlTextureInfo timedGlTextureInfo2 = timedGlTextureInfoArr[0];
            timedGlTextureInfoArr[0] = timedGlTextureInfo;
            this.cacheSize = i - 1;
            super.releaseOutputFrame(timedGlTextureInfo2.glTextureInfo);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        Assertions.checkState(this.cacheSize < 2);
        super.queueInputFrame(glObjectsProvider, glTextureInfo, j);
        TimedGlTextureInfo[] timedGlTextureInfoArr = this.cachedFrames;
        int i = this.cacheSize;
        this.cacheSize = i + 1;
        timedGlTextureInfoArr[i] = new TimedGlTextureInfo((GlTextureInfo) Assertions.checkNotNull(this.outputTexturePool.getMostRecentlyUsedTexture()), j);
    }

    public void replayFrame() {
        if (isEmpty()) {
            return;
        }
        TimedGlTextureInfo timedGlTextureInfo = this.cachedFrames[0];
        getOutputListener().onOutputFrameAvailable(timedGlTextureInfo.glTextureInfo, timedGlTextureInfo.presentationTimeUs);
        if (this.cacheSize > 1) {
            TimedGlTextureInfo timedGlTextureInfo2 = this.cachedFrames[1];
            getOutputListener().onOutputFrameAvailable(timedGlTextureInfo2.glTextureInfo, timedGlTextureInfo2.presentationTimeUs);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        for (int i = 0; i < this.cacheSize; i++) {
            super.releaseOutputFrame(this.cachedFrames[i].glTextureInfo);
        }
        this.cacheSize = 0;
        super.signalEndOfCurrentInputStream();
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
    }
}
