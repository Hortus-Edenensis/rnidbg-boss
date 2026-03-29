package androidx.media3.transformer;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.transformer.AssetLoader;
import com.google.common.collect.ImmutableMap;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class SurfaceAssetLoader implements AssetLoader {
    public static final String MEDIA_ITEM_URI_SCHEME = "transformer_surface_asset";
    private final Callback callback;
    private Format contentFormat;
    private final EditedMediaItem editedMediaItem;
    private final Handler handler;
    private boolean isStarted;
    private boolean isVideoEndOfStreamSignaled;
    private final AssetLoader.Listener listener;
    private int progressState;
    private SampleConsumer sampleConsumer;

    /* JADX INFO: compiled from: SearchBox */
    public interface Callback {
        void onSurfaceAssetLoaderCreated(SurfaceAssetLoader surfaceAssetLoader);

        void onSurfaceReady(Surface surface, EditedMediaItem editedMediaItem);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements AssetLoader.Factory {
        private final Callback callback;

        public Factory(Callback callback) {
            this.callback = callback;
        }

        @Override // androidx.media3.transformer.AssetLoader.Factory
        public SurfaceAssetLoader createAssetLoader(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
            Assertions.checkState(((String) Assertions.checkNotNull(((MediaItem.LocalConfiguration) Assertions.checkNotNull(editedMediaItem.mediaItem.localConfiguration)).uri.getScheme())).equals(SurfaceAssetLoader.MEDIA_ITEM_URI_SCHEME));
            SurfaceAssetLoader surfaceAssetLoader = new SurfaceAssetLoader(editedMediaItem, looper, listener, this.callback);
            this.callback.onSurfaceAssetLoaderCreated(surfaceAssetLoader);
            return surfaceAssetLoader;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$maybeFinishPreparation$2() {
        this.callback.onSurfaceReady(((SampleConsumer) Assertions.checkNotNull(this.sampleConsumer)).getInputSurface(), this.editedMediaItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setContentFormat$0(Format format) {
        this.contentFormat = format;
        try {
            maybeFinishPreparation();
        } catch (RuntimeException e) {
            this.listener.onError(ExportException.createForAssetLoader(e, 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signalEndOfInput$1() {
        SampleConsumer sampleConsumer;
        try {
            if (this.isVideoEndOfStreamSignaled || (sampleConsumer = this.sampleConsumer) == null) {
                return;
            }
            this.isVideoEndOfStreamSignaled = true;
            sampleConsumer.signalEndOfVideoInput();
        } catch (RuntimeException e) {
            this.listener.onError(ExportException.createForAssetLoader(e, 1000));
        }
    }

    private void maybeFinishPreparation() {
        if (!this.isStarted || this.contentFormat == null) {
            return;
        }
        this.listener.onTrackCount(1);
        this.listener.onDurationUs(-9223372036854775807L);
        this.listener.onTrackAdded(this.contentFormat, 2);
        try {
            SampleConsumer sampleConsumer = (SampleConsumer) Assertions.checkNotNull(this.listener.onOutputFormat(this.contentFormat));
            this.sampleConsumer = sampleConsumer;
            sampleConsumer.setOnInputSurfaceReadyListener(new Runnable() { // from class: yo5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22243a.lambda$maybeFinishPreparation$2();
                }
            });
        } catch (ExportException e) {
            this.listener.onError(e);
        }
        this.progressState = 3;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap<Integer, String> getDecoderNames() {
        return ImmutableMap.of();
    }

    public EditedMediaItem getEditedMediaItem() {
        return this.editedMediaItem;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int getProgress(ProgressHolder progressHolder) {
        return this.progressState;
    }

    public void setContentFormat(final Format format) {
        Assertions.checkArgument(Objects.equals(format.sampleMimeType, "video/raw"));
        Assertions.checkArgument(format.width != -1);
        Assertions.checkArgument(format.height != -1);
        Assertions.checkArgument(((ColorInfo) Assertions.checkNotNull(format.colorInfo)).isDataSpaceValid());
        this.handler.post(new Runnable() { // from class: xo5
            @Override // java.lang.Runnable
            public final void run() {
                this.f22026a.lambda$setContentFormat$0(format);
            }
        });
    }

    public void signalEndOfInput() {
        this.handler.post(new Runnable() { // from class: wo5
            @Override // java.lang.Runnable
            public final void run() {
                this.f21766a.lambda$signalEndOfInput$1();
            }
        });
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        this.isStarted = true;
        maybeFinishPreparation();
    }

    private SurfaceAssetLoader(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, Callback callback) {
        this.editedMediaItem = editedMediaItem;
        this.listener = listener;
        this.callback = callback;
        this.handler = new Handler(looper);
        this.progressState = 0;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
    }
}
