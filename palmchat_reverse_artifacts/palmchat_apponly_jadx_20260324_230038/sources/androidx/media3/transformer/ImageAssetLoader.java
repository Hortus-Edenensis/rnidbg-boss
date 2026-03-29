package androidx.media3.transformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.ConstantRateTimestampIterator;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.transformer.AssetLoader;
import com.google.common.collect.ImmutableMap;
import defpackage.r33;
import defpackage.x42;
import defpackage.z42;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class ImageAssetLoader implements AssetLoader {
    private static final int QUEUE_BITMAP_INTERVAL_MS = 10;
    private final BitmapLoader bitmapLoader;
    private final Context context;
    private final EditedMediaItem editedMediaItem;
    private final AssetLoader.Listener listener;
    private volatile int progress;
    private int progressState;
    private final boolean retainHdrFromUltraHdrImage;

    @Nullable
    private SampleConsumer sampleConsumer;
    private final ScheduledExecutorService scheduledExecutorService;

    /* JADX INFO: renamed from: androidx.media3.transformer.ImageAssetLoader$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements x42<Bitmap> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(Bitmap bitmap, Format format) {
            ImageAssetLoader.this.lambda$queueBitmapInternal$1(bitmap, format);
        }

        @Override // defpackage.x42
        public void onFailure(Throwable th) {
            ImageAssetLoader.this.listener.onError(ExportException.createForAssetLoader(th, 2000));
        }

        @Override // defpackage.x42
        public void onSuccess(final Bitmap bitmap) {
            ImageAssetLoader.this.progress = 50;
            Format formatBuild = new Format.Builder().setHeight(bitmap.getHeight()).setWidth(bitmap.getWidth()).setSampleMimeType(MimeTypes.IMAGE_RAW).setColorInfo(ColorInfo.SRGB_BT709_FULL).build();
            final Format formatBuild2 = (ImageAssetLoader.this.retainHdrFromUltraHdrImage && Build.VERSION.SDK_INT >= 34 && bitmap.hasGainmap()) ? formatBuild.buildUpon().setSampleMimeType(MimeTypes.IMAGE_JPEG_R).build() : formatBuild;
            try {
                ImageAssetLoader.this.listener.onTrackAdded(formatBuild, 2);
                ImageAssetLoader.this.scheduledExecutorService.submit(new Runnable() { // from class: androidx.media3.transformer.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1506a.lambda$onSuccess$0(bitmap, formatBuild2);
                    }
                });
            } catch (RuntimeException e) {
                ImageAssetLoader.this.listener.onError(ExportException.createForAssetLoader(e, 1000));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements AssetLoader.Factory {
        private final BitmapLoader bitmapLoader;
        private final Context context;

        public Factory(Context context, BitmapLoader bitmapLoader) {
            this.context = context;
            this.bitmapLoader = bitmapLoader;
        }

        @Override // androidx.media3.transformer.AssetLoader.Factory
        public AssetLoader createAssetLoader(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
            return new ImageAssetLoader(this.context, editedMediaItem, listener, this.bitmapLoader, compositionSettings.retainHdrFromUltraHdrImage, null);
        }
    }

    public /* synthetic */ ImageAssetLoader(Context context, EditedMediaItem editedMediaItem, AssetLoader.Listener listener, BitmapLoader bitmapLoader, boolean z, AnonymousClass1 anonymousClass1) {
        this(context, editedMediaItem, listener, bitmapLoader, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: queueBitmapInternal, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$queueBitmapInternal$1(final Bitmap bitmap, final Format format) {
        try {
            SampleConsumer sampleConsumer = this.sampleConsumer;
            if (sampleConsumer == null) {
                this.sampleConsumer = this.listener.onOutputFormat(format);
                this.scheduledExecutorService.schedule(new Runnable() { // from class: sq2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20807a.lambda$queueBitmapInternal$0(bitmap, format);
                    }
                }, 10L, TimeUnit.MILLISECONDS);
                return;
            }
            int iQueueInputBitmap = sampleConsumer.queueInputBitmap(bitmap, new ConstantRateTimestampIterator(this.editedMediaItem.durationUs, r4.frameRate));
            if (iQueueInputBitmap == 1) {
                this.progress = 100;
                this.sampleConsumer.signalEndOfVideoInput();
            } else if (iQueueInputBitmap == 2) {
                this.scheduledExecutorService.schedule(new Runnable() { // from class: tq2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21043a.lambda$queueBitmapInternal$1(bitmap, format);
                    }
                }, 10L, TimeUnit.MILLISECONDS);
            } else {
                if (iQueueInputBitmap != 3) {
                    throw new IllegalStateException();
                }
                this.progress = 100;
            }
        } catch (ExportException e) {
            this.listener.onError(e);
        } catch (RuntimeException e2) {
            this.listener.onError(ExportException.createForAssetLoader(e2, 1000));
        }
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap<Integer, String> getDecoderNames() {
        return ImmutableMap.of();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int getProgress(ProgressHolder progressHolder) {
        if (this.progressState == 2) {
            progressHolder.progress = this.progress;
        }
        return this.progressState;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
        this.progressState = 0;
        this.scheduledExecutorService.shutdownNow();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        r33<Bitmap> r33VarE;
        this.progressState = 2;
        this.listener.onDurationUs(this.editedMediaItem.durationUs);
        this.listener.onTrackCount(1);
        String imageMimeType = TransformerUtil.getImageMimeType(this.context, this.editedMediaItem.mediaItem);
        if (imageMimeType == null || !this.bitmapLoader.supportsMimeType(imageMimeType)) {
            r33VarE = z42.e(ParserException.createForUnsupportedContainerFeature("Attempted to load a Bitmap from unsupported MIME type: " + imageMimeType));
        } else {
            r33VarE = this.bitmapLoader.loadBitmap(((MediaItem.LocalConfiguration) Assertions.checkNotNull(this.editedMediaItem.mediaItem.localConfiguration)).uri);
        }
        z42.a(r33VarE, new AnonymousClass1(), this.scheduledExecutorService);
    }

    private ImageAssetLoader(Context context, EditedMediaItem editedMediaItem, AssetLoader.Listener listener, BitmapLoader bitmapLoader, boolean z) {
        Assertions.checkState(editedMediaItem.durationUs != -9223372036854775807L);
        Assertions.checkState(editedMediaItem.frameRate != -2147483647);
        this.context = context;
        this.editedMediaItem = editedMediaItem;
        this.listener = listener;
        this.bitmapLoader = bitmapLoader;
        this.retainHdrFromUltraHdrImage = z;
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this.progressState = 0;
    }
}
