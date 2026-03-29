package androidx.media3.transformer;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.transformer.AssetLoader;
import com.google.common.collect.ImmutableMap;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class RawAssetLoader implements AssetLoader {
    private final AssetLoader.Listener assetLoaderListener;

    @Nullable
    private final Format audioFormat;
    private SampleConsumer audioSampleConsumer;
    private final EditedMediaItem editedMediaItem;

    @Nullable
    private final OnInputFrameProcessedListener frameProcessedListener;
    private boolean isAudioEndOfStreamSignaled;
    private boolean isAudioTrackAdded;
    private volatile boolean isStarted;
    private boolean isVideoEndOfStreamSignaled;
    private boolean isVideoTrackAdded;
    private volatile long lastQueuedAudioPresentationTimeUs;
    private volatile long lastQueuedVideoPresentationTimeUs;
    private int progressState;

    @Nullable
    private final Format videoFormat;
    private SampleConsumer videoSampleConsumer;

    public RawAssetLoader(EditedMediaItem editedMediaItem, AssetLoader.Listener listener, @Nullable Format format, @Nullable Format format2, @Nullable OnInputFrameProcessedListener onInputFrameProcessedListener) {
        boolean z = true;
        Assertions.checkArgument((format == null && format2 == null) ? false : true);
        if (format2 != null && (format2.height == -1 || format2.width == -1)) {
            z = false;
        }
        Assertions.checkArgument(z);
        this.editedMediaItem = editedMediaItem;
        this.assetLoaderListener = listener;
        this.audioFormat = format;
        this.videoFormat = format2 != null ? format2.buildUpon().setColorInfo(TransformerUtil.getValidColor(format2.colorInfo)).setSampleMimeType("video/raw").build() : null;
        this.frameProcessedListener = onInputFrameProcessedListener;
        this.progressState = 0;
        this.lastQueuedAudioPresentationTimeUs = Long.MAX_VALUE;
        this.lastQueuedVideoPresentationTimeUs = Long.MAX_VALUE;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap<Integer, String> getDecoderNames() {
        return ImmutableMap.of();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int getProgress(ProgressHolder progressHolder) {
        if (this.progressState == 2) {
            long jMin = Math.min(this.lastQueuedAudioPresentationTimeUs, this.lastQueuedVideoPresentationTimeUs);
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            progressHolder.progress = Util.percentInt(jMin, this.editedMediaItem.durationUs);
        }
        return this.progressState;
    }

    public boolean queueAudioData(ByteBuffer byteBuffer, long j, boolean z) {
        Assertions.checkState(!this.isAudioEndOfStreamSignaled);
        if (!this.isStarted) {
            return false;
        }
        try {
            if (!this.isAudioTrackAdded) {
                this.assetLoaderListener.onTrackAdded((Format) Assertions.checkNotNull(this.audioFormat), 2);
                this.isAudioTrackAdded = true;
            }
            if (this.audioSampleConsumer == null) {
                SampleConsumer sampleConsumerOnOutputFormat = this.assetLoaderListener.onOutputFormat((Format) Assertions.checkNotNull(this.audioFormat));
                if (sampleConsumerOnOutputFormat == null) {
                    return false;
                }
                this.audioSampleConsumer = sampleConsumerOnOutputFormat;
            }
            DecoderInputBuffer inputBuffer = this.audioSampleConsumer.getInputBuffer();
            if (inputBuffer == null) {
                return false;
            }
            inputBuffer.ensureSpaceForWrite(byteBuffer.remaining());
            inputBuffer.data.put(byteBuffer).flip();
            if (z) {
                inputBuffer.addFlag(4);
            }
            if (this.audioSampleConsumer.queueInputBuffer()) {
                this.lastQueuedAudioPresentationTimeUs = j;
                this.isAudioEndOfStreamSignaled = z;
                return true;
            }
        } catch (ExportException e) {
            this.assetLoaderListener.onError(e);
        } catch (RuntimeException e2) {
            this.assetLoaderListener.onError(ExportException.createForAssetLoader(e2, 1000));
        }
        return false;
    }

    public boolean queueInputTexture(int i, long j) {
        Assertions.checkState(!this.isVideoEndOfStreamSignaled);
        try {
            if (!this.isVideoTrackAdded) {
                if (!this.isStarted) {
                    return false;
                }
                this.assetLoaderListener.onTrackAdded((Format) Assertions.checkNotNull(this.videoFormat), 2);
                this.isVideoTrackAdded = true;
            }
            if (this.videoSampleConsumer == null) {
                SampleConsumer sampleConsumerOnOutputFormat = this.assetLoaderListener.onOutputFormat((Format) Assertions.checkNotNull(this.videoFormat));
                if (sampleConsumerOnOutputFormat == null) {
                    return false;
                }
                this.videoSampleConsumer = sampleConsumerOnOutputFormat;
                sampleConsumerOnOutputFormat.setOnInputFrameProcessedListener((OnInputFrameProcessedListener) Assertions.checkNotNull(this.frameProcessedListener));
            }
            int iQueueInputTexture = this.videoSampleConsumer.queueInputTexture(i, j);
            if (iQueueInputTexture == 2) {
                return false;
            }
            if (iQueueInputTexture == 3) {
                this.isVideoEndOfStreamSignaled = true;
            }
            this.lastQueuedVideoPresentationTimeUs = j;
            return true;
        } catch (ExportException e) {
            this.assetLoaderListener.onError(e);
            return false;
        } catch (RuntimeException e2) {
            this.assetLoaderListener.onError(ExportException.createForAssetLoader(e2, 1000));
            return false;
        }
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
        this.progressState = 0;
    }

    public void signalEndOfVideoInput() {
        try {
            if (this.isVideoEndOfStreamSignaled) {
                return;
            }
            this.isVideoEndOfStreamSignaled = true;
            ((SampleConsumer) Assertions.checkNotNull(this.videoSampleConsumer)).signalEndOfVideoInput();
        } catch (RuntimeException e) {
            this.assetLoaderListener.onError(ExportException.createForAssetLoader(e, 1000));
        }
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        long j = this.editedMediaItem.durationUs;
        this.progressState = j == -9223372036854775807L ? 3 : 2;
        this.assetLoaderListener.onDurationUs(j);
        this.assetLoaderListener.onTrackCount((this.audioFormat == null || this.videoFormat == null) ? 1 : 2);
        this.isStarted = true;
    }
}
