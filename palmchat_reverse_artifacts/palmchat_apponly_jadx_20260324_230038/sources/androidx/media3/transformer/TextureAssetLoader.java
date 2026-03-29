package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.transformer.AssetLoader;
import com.google.common.collect.ImmutableMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
@Deprecated
public final class TextureAssetLoader implements AssetLoader {
    private final AssetLoader.Listener assetLoaderListener;
    private final EditedMediaItem editedMediaItem;
    private final Format format;
    private final OnInputFrameProcessedListener frameProcessedListener;
    private boolean isEndOfStreamSignaled;
    private volatile boolean isStarted;
    private boolean isTrackAdded;
    private volatile long lastQueuedPresentationTimeUs;
    private int progressState;
    private SampleConsumer sampleConsumer;

    public TextureAssetLoader(EditedMediaItem editedMediaItem, AssetLoader.Listener listener, Format format, OnInputFrameProcessedListener onInputFrameProcessedListener) {
        Assertions.checkArgument(editedMediaItem.durationUs != -9223372036854775807L);
        Assertions.checkArgument((format.height == -1 || format.width == -1) ? false : true);
        this.editedMediaItem = editedMediaItem;
        this.assetLoaderListener = listener;
        this.format = format.buildUpon().setColorInfo(TransformerUtil.getValidColor(format.colorInfo)).setSampleMimeType("video/raw").build();
        this.frameProcessedListener = onInputFrameProcessedListener;
        this.progressState = 0;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap<Integer, String> getDecoderNames() {
        return ImmutableMap.of();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int getProgress(ProgressHolder progressHolder) {
        if (this.progressState == 2) {
            progressHolder.progress = Util.percentInt(this.lastQueuedPresentationTimeUs, this.editedMediaItem.durationUs);
        }
        return this.progressState;
    }

    public boolean queueInputTexture(int i, long j) {
        try {
            if (!this.isTrackAdded) {
                if (!this.isStarted) {
                    return false;
                }
                this.assetLoaderListener.onTrackAdded(this.format, 2);
                this.isTrackAdded = true;
            }
            if (this.sampleConsumer == null) {
                SampleConsumer sampleConsumerOnOutputFormat = this.assetLoaderListener.onOutputFormat(this.format);
                if (sampleConsumerOnOutputFormat == null) {
                    return false;
                }
                this.sampleConsumer = sampleConsumerOnOutputFormat;
                sampleConsumerOnOutputFormat.setOnInputFrameProcessedListener(this.frameProcessedListener);
            }
            int iQueueInputTexture = this.sampleConsumer.queueInputTexture(i, j);
            if (iQueueInputTexture == 2) {
                return false;
            }
            if (iQueueInputTexture == 3) {
                this.isEndOfStreamSignaled = true;
            }
            this.lastQueuedPresentationTimeUs = j;
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
            if (this.isEndOfStreamSignaled) {
                return;
            }
            this.isEndOfStreamSignaled = true;
            ((SampleConsumer) Assertions.checkNotNull(this.sampleConsumer)).signalEndOfVideoInput();
        } catch (RuntimeException e) {
            this.assetLoaderListener.onError(ExportException.createForAssetLoader(e, 1000));
        }
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        this.progressState = 2;
        this.assetLoaderListener.onDurationUs(this.editedMediaItem.durationUs);
        this.assetLoaderListener.onTrackCount(1);
        this.isStarted = true;
    }
}
