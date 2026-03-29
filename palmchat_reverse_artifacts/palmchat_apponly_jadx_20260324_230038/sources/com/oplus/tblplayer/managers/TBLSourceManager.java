package com.oplus.tblplayer.managers;

import androidx.annotation.NonNull;
import com.kwad.sdk.collector.AppStatusRules;
import com.oplus.tbl.exoplayer2.C;
import com.oplus.tbl.exoplayer2.MediaItem;
import com.oplus.tbl.exoplayer2.ext.okhttp.OkHttpDataSource;
import com.oplus.tbl.exoplayer2.source.ClippingMediaSource;
import com.oplus.tbl.exoplayer2.source.LoopingMediaSource;
import com.oplus.tbl.exoplayer2.source.MediaSource;
import com.oplus.tbl.exoplayer2.source.MediaSourceFactory;
import com.oplus.tbl.exoplayer2.source.ProgressiveMediaSource;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DefaultDataSourceFactory;
import com.oplus.tbl.exoplayer2.upstream.DefaultHttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.FileDataSource;
import com.oplus.tbl.exoplayer2.upstream.HttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import com.oplus.tbl.exoplayer2.upstream.cache.Cache;
import com.oplus.tbl.exoplayer2.upstream.cache.CacheDataSink;
import com.oplus.tbl.exoplayer2.upstream.cache.CacheDataSource;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.extractor.TBLExtractorsFactory;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.upstream.TBLOkHttpDataSourceFactory;
import com.oplus.tblplayer.utils.FormatUtil;
import com.oplus.tblplayer.utils.LogUtil;
import okhttp3.CacheControl;
import okhttp3.Call;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLSourceManager {
    private static final String TAG = "TBLSourceManager";

    public static DataSource.Factory buildCacheDataSourceFactory(DataSource.Factory factory, Cache cache) {
        return buildCacheDataSourceFactory(factory, cache, null);
    }

    private static MediaSource buildDashMediaSource(@NonNull DataSource.Factory factory, @NonNull MediaItem mediaItem) {
        try {
            return ((MediaSourceFactory) Class.forName("com.oplus.tbl.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory)).createMediaSource(mediaItem);
        } catch (Exception unused) {
            return null;
        }
    }

    private static MediaSource buildHlsMediaSource(@NonNull DataSource.Factory factory, @NonNull MediaItem mediaItem) {
        try {
            return ((MediaSourceFactory) Class.forName("com.oplus.tbl.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory)).createMediaSource(mediaItem);
        } catch (Exception unused) {
            return null;
        }
    }

    public static HttpDataSource.Factory buildHttpDataSourceFactory(String str) {
        return buildHttpDataSourceFactory(str, null);
    }

    public static MediaSource buildMediaSource(@NonNull DataSource.Factory factory, @NonNull MediaUrl mediaUrl, int i, int i2) {
        MediaSource mediaSourceBuildDashMediaSource;
        String str;
        int iInferContentType = mediaUrl.inferContentType();
        LogUtil.d(TAG, "buildMediaSource: Url infer content type is " + iInferContentType);
        MediaItem mediaItemBuild = new MediaItem.Builder().setUri(mediaUrl.getUri()).setCustomCacheKey(mediaUrl.getCustomCacheKey()).build();
        switch (iInferContentType) {
            case 0:
                mediaSourceBuildDashMediaSource = buildDashMediaSource(factory, mediaItemBuild);
                str = "No suitable media source found for dash content type.";
                break;
            case 1:
                mediaSourceBuildDashMediaSource = buildSsMediaSource(factory, mediaItemBuild);
                str = "No suitable media source found for smoothstreaming content type.";
                break;
            case 2:
                mediaSourceBuildDashMediaSource = buildHlsMediaSource(factory, mediaItemBuild);
                str = "No suitable media source found for hls content type.";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                mediaSourceBuildDashMediaSource = buildProgressiveMediaSource(factory, mediaItemBuild, mediaUrl, i, i2);
                str = "No suitable media source found for progressive content type.";
                break;
            default:
                throw new UnsupportedOperationException("Unsupported type: " + iInferContentType);
        }
        return (MediaSource) Assertions.checkNotNull(mediaSourceBuildDashMediaSource, str);
    }

    public static HttpDataSource.Factory buildOkHttpDataSourceFactory(String str, Call.Factory factory, CacheControl cacheControl) {
        return buildOkHttpDataSourceFactory(str, factory, cacheControl, null);
    }

    private static TBLExtractorsFactory buildProgressiveExtractorsFactory(@NonNull MediaUrl mediaUrl, int i) {
        return (mediaUrl.isLocalFileUri() && i == 0 && FormatUtil.isFfmpegNativeLibraryAvailable()) ? new TBLExtractorsFactory(3, Globals.isBinauralCaptureVideoEnabled()) : new TBLExtractorsFactory(i, Globals.isBinauralCaptureVideoEnabled());
    }

    private static MediaSource buildProgressiveMediaSource(@NonNull DataSource.Factory factory, @NonNull MediaItem mediaItem, @NonNull MediaUrl mediaUrl, int i, int i2) {
        int i3;
        TBLExtractorsFactory tBLExtractorsFactoryBuildProgressiveExtractorsFactory = buildProgressiveExtractorsFactory(mediaUrl, i);
        tBLExtractorsFactoryBuildProgressiveExtractorsFactory.setTsExtractorFlags(8);
        tBLExtractorsFactoryBuildProgressiveExtractorsFactory.setTsExtractorTimestampSearchBytes(i2);
        if (mediaUrl.isHttpLiveFlv()) {
            tBLExtractorsFactoryBuildProgressiveExtractorsFactory.setFlvExtractorFlags(1);
            i3 = AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE;
        } else {
            i3 = 1048576;
        }
        return maybeLoopingMediaSource(mediaUrl, maybeClipMediaSource(mediaUrl, new ProgressiveMediaSource.Factory(factory, tBLExtractorsFactoryBuildProgressiveExtractorsFactory).setContinueLoadingCheckIntervalBytes(i3).createMediaSource(mediaItem)));
    }

    public static CacheDataSource.Factory buildReadOnlyCacheDataSource(DefaultDataSourceFactory defaultDataSourceFactory, Cache cache) {
        return new CacheDataSource.Factory().setCache(cache).setUpstreamDataSourceFactory(defaultDataSourceFactory).setCacheReadDataSourceFactory(new FileDataSource.Factory()).setCacheWriteDataSinkFactory(null).setFlags(2).setEventListener(null);
    }

    private static MediaSource buildSsMediaSource(@NonNull DataSource.Factory factory, @NonNull MediaItem mediaItem) {
        try {
            return ((MediaSourceFactory) Class.forName("com.oplus.tbl.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(factory)).createMediaSource(mediaItem);
        } catch (Exception unused) {
            return null;
        }
    }

    public static HttpDataSource.Factory buildTBLOkHttpDataSourceFactory(String str, Call.Factory factory, CacheControl cacheControl, TransferListener transferListener, boolean z, boolean z2, Cache cache) {
        return new TBLOkHttpDataSourceFactory(factory, str, transferListener, cacheControl, z, z2, cache);
    }

    private static MediaSource maybeClipMediaSource(@NonNull MediaUrl mediaUrl, MediaSource mediaSource) {
        return (mediaUrl.getClipStartPositionMs() == 0 && mediaUrl.getClipEndPositionMs() == Long.MIN_VALUE) ? mediaSource : new ClippingMediaSource(mediaSource, C.msToUs(mediaUrl.getClipStartPositionMs()), C.msToUs(mediaUrl.getClipEndPositionMs()));
    }

    private static MediaSource maybeLoopingMediaSource(@NonNull MediaUrl mediaUrl, MediaSource mediaSource) {
        return mediaUrl.getLoopCount() <= 0 ? mediaSource : new LoopingMediaSource(mediaSource, mediaUrl.getLoopCount());
    }

    public static boolean shouldRequirePreCache(MediaUrl mediaUrl) {
        switch (mediaUrl.inferContentType()) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return false;
            case 3:
            default:
                return true;
        }
    }

    public static DataSource.Factory buildCacheDataSourceFactory(DataSource.Factory factory, Cache cache, CacheDataSource.EventListener eventListener) {
        return new CacheDataSource.Factory().setCache(cache).setUpstreamDataSourceFactory(factory).setCacheReadDataSourceFactory(new FileDataSource.Factory()).setCacheWriteDataSinkFactory(new CacheDataSink.Factory().setCache(cache).setFragmentSize(Globals.getMaxCacheFileSize())).setFlags(2).setEventListener(eventListener);
    }

    public static HttpDataSource.Factory buildHttpDataSourceFactory(String str, TransferListener transferListener) {
        return new DefaultHttpDataSource.Factory().setUserAgent(str).setTransferListener(transferListener);
    }

    public static HttpDataSource.Factory buildOkHttpDataSourceFactory(String str, Call.Factory factory, CacheControl cacheControl, TransferListener transferListener) {
        return new OkHttpDataSource.Factory(factory).setUserAgent(str).setTransferListener(transferListener).setCacheControl(cacheControl);
    }
}
