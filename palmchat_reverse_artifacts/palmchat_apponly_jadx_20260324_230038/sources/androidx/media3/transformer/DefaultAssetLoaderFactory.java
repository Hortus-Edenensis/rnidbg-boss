package androidx.media3.transformer;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.DefaultDecoderFactory;
import androidx.media3.transformer.ExoPlayerAssetLoader;
import androidx.media3.transformer.ImageAssetLoader;
import defpackage.er3;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class DefaultAssetLoaderFactory implements AssetLoader.Factory {
    private static final String TAG = "DefaultAssetLoaderFact";
    private final BitmapLoader bitmapLoader;
    private final Clock clock;
    private final Context context;
    private final Codec.DecoderFactory decoderFactory;
    private AssetLoader.Factory exoPlayerAssetLoaderFactory;
    private AssetLoader.Factory imageAssetLoaderFactory;

    @Nullable
    private final LogSessionId logSessionId;

    @Nullable
    private final MediaSource.Factory mediaSourceFactory;

    @Nullable
    private final TrackSelector.Factory trackSelectorFactory;

    public DefaultAssetLoaderFactory(Context context, Codec.DecoderFactory decoderFactory, Clock clock, @Nullable LogSessionId logSessionId) {
        this.context = context.getApplicationContext();
        this.decoderFactory = decoderFactory;
        this.clock = clock;
        BitmapFactory.Options options = null;
        this.mediaSourceFactory = null;
        this.trackSelectorFactory = null;
        this.logSessionId = logSessionId;
        if (Build.VERSION.SDK_INT >= 26) {
            options = new BitmapFactory.Options();
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        this.bitmapLoader = new DataSourceBitmapLoader(er3.b(Executors.newSingleThreadExecutor()), new DefaultDataSource.Factory(context), options, 4096);
    }

    @Override // androidx.media3.transformer.AssetLoader.Factory
    public AssetLoader createAssetLoader(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
        MediaItem mediaItem = editedMediaItem.mediaItem;
        if (!TransformerUtil.isImage(this.context, mediaItem) || ((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration)).imageDurationMs == -9223372036854775807L) {
            if (this.exoPlayerAssetLoaderFactory == null) {
                this.exoPlayerAssetLoaderFactory = new ExoPlayerAssetLoader.Factory(this.context, this.decoderFactory, this.clock, this.mediaSourceFactory, this.trackSelectorFactory, this.logSessionId);
            }
            return this.exoPlayerAssetLoaderFactory.createAssetLoader(editedMediaItem, looper, listener, compositionSettings);
        }
        if (this.imageAssetLoaderFactory == null) {
            this.imageAssetLoaderFactory = new ImageAssetLoader.Factory(this.context, this.bitmapLoader);
        }
        return this.imageAssetLoaderFactory.createAssetLoader(editedMediaItem, looper, listener, compositionSettings);
    }

    public DefaultAssetLoaderFactory(Context context, BitmapLoader bitmapLoader) {
        this.context = context.getApplicationContext();
        this.bitmapLoader = bitmapLoader;
        this.decoderFactory = new DefaultDecoderFactory.Builder(context).build();
        this.clock = Clock.DEFAULT;
        this.mediaSourceFactory = null;
        this.trackSelectorFactory = null;
        this.logSessionId = null;
    }

    public DefaultAssetLoaderFactory(Context context, Codec.DecoderFactory decoderFactory, Clock clock, @Nullable MediaSource.Factory factory, BitmapLoader bitmapLoader) {
        this.context = context.getApplicationContext();
        this.decoderFactory = decoderFactory;
        this.clock = clock;
        this.mediaSourceFactory = factory;
        this.bitmapLoader = bitmapLoader;
        this.trackSelectorFactory = null;
        this.logSessionId = null;
    }

    public DefaultAssetLoaderFactory(Context context, Codec.DecoderFactory decoderFactory, Clock clock, @Nullable MediaSource.Factory factory, BitmapLoader bitmapLoader, TrackSelector.Factory factory2) {
        this.context = context.getApplicationContext();
        this.decoderFactory = decoderFactory;
        this.clock = clock;
        this.mediaSourceFactory = factory;
        this.bitmapLoader = bitmapLoader;
        this.trackSelectorFactory = factory2;
        this.logSessionId = null;
    }
}
