package com.oplus.tbl.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.MediaItem;
import com.oplus.tbl.exoplayer2.Timeline;
import com.oplus.tbl.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.oplus.tbl.exoplayer2.drm.DrmSessionManager;
import com.oplus.tbl.exoplayer2.drm.DrmSessionManagerProvider;
import com.oplus.tbl.exoplayer2.extractor.DefaultExtractorsFactory;
import com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory;
import com.oplus.tbl.exoplayer2.source.MediaSource;
import com.oplus.tbl.exoplayer2.source.ProgressiveMediaPeriod;
import com.oplus.tbl.exoplayer2.source.ProgressiveMediaSource;
import com.oplus.tbl.exoplayer2.upstream.Allocator;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.oplus.tbl.exoplayer2.upstream.HttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import com.oplus.tbl.exoplayer2.util.Assertions;
import defpackage.gm3;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    private final int continueLoadingCheckIntervalBytes;
    private final DataSource.Factory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final ExtractorsFactory extractorsFactory;
    private final LoadErrorHandlingPolicy loadableLoadErrorHandlingPolicy;
    private final MediaItem mediaItem;
    private final MediaItem.PlaybackProperties playbackProperties;
    private boolean timelineIsLive;
    private boolean timelineIsSeekable;

    @Nullable
    private TransferListener transferListener;
    private boolean timelineIsPlaceholder = true;
    private long timelineDurationUs = -9223372036854775807L;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements MediaSourceFactory {
        private int continueLoadingCheckIntervalBytes;

        @Nullable
        private String customCacheKey;
        private final DataSource.Factory dataSourceFactory;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private ExtractorsFactory extractorsFactory;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;

        @Nullable
        private Object tag;
        private boolean usingCustomDrmSessionManagerProvider;

        public Factory(DataSource.Factory factory) {
            this(factory, new DefaultExtractorsFactory());
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        public Factory setContinueLoadingCheckIntervalBytes(int i) {
            this.continueLoadingCheckIntervalBytes = i;
            return this;
        }

        @Deprecated
        public Factory setCustomCacheKey(@Nullable String str) {
            this.customCacheKey = str;
            return this;
        }

        @Deprecated
        public Factory setExtractorsFactory(@Nullable ExtractorsFactory extractorsFactory) {
            if (extractorsFactory == null) {
                extractorsFactory = new DefaultExtractorsFactory();
            }
            this.extractorsFactory = extractorsFactory;
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        public /* synthetic */ MediaSourceFactory setStreamKeys(List list) {
            return gm3.b(this, list);
        }

        @Deprecated
        public Factory setTag(@Nullable Object obj) {
            this.tag = obj;
            return this;
        }

        public Factory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
            this.dataSourceFactory = factory;
            this.extractorsFactory = extractorsFactory;
            this.drmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.continueLoadingCheckIntervalBytes = 1048576;
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        public Factory setDrmHttpDataSourceFactory(@Nullable HttpDataSource.Factory factory) {
            if (!this.usingCustomDrmSessionManagerProvider) {
                ((DefaultDrmSessionManagerProvider) this.drmSessionManagerProvider).setDrmHttpDataSourceFactory(factory);
            }
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        public Factory setDrmSessionManager(@Nullable final DrmSessionManager drmSessionManager) {
            if (drmSessionManager == null) {
                setDrmSessionManagerProvider((DrmSessionManagerProvider) null);
            } else {
                setDrmSessionManagerProvider(new DrmSessionManagerProvider() { // from class: go4
                    @Override // com.oplus.tbl.exoplayer2.drm.DrmSessionManagerProvider
                    public final DrmSessionManager get(MediaItem mediaItem) {
                        return ProgressiveMediaSource.Factory.lambda$setDrmSessionManager$0(drmSessionManager, mediaItem);
                    }
                });
            }
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        public Factory setDrmSessionManagerProvider(@Nullable DrmSessionManagerProvider drmSessionManagerProvider) {
            boolean z;
            if (drmSessionManagerProvider != null) {
                this.drmSessionManagerProvider = drmSessionManagerProvider;
                z = true;
            } else {
                this.drmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
                z = false;
            }
            this.usingCustomDrmSessionManagerProvider = z;
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        public Factory setDrmUserAgent(@Nullable String str) {
            if (!this.usingCustomDrmSessionManagerProvider) {
                ((DefaultDrmSessionManagerProvider) this.drmSessionManagerProvider).setDrmUserAgent(str);
            }
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        public Factory setLoadErrorHandlingPolicy(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public ProgressiveMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setUri(uri).build());
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        public ProgressiveMediaSource createMediaSource(MediaItem mediaItem) {
            MediaItem.Builder builderBuildUpon;
            MediaItem.Builder tag;
            Assertions.checkNotNull(mediaItem.playbackProperties);
            MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            boolean z = playbackProperties.tag == null && this.tag != null;
            boolean z2 = playbackProperties.customCacheKey == null && this.customCacheKey != null;
            if (!z || !z2) {
                if (z) {
                    tag = mediaItem.buildUpon().setTag(this.tag);
                    mediaItem = tag.build();
                    MediaItem mediaItem2 = mediaItem;
                    return new ProgressiveMediaSource(mediaItem2, this.dataSourceFactory, this.extractorsFactory, this.drmSessionManagerProvider.get(mediaItem2), this.loadErrorHandlingPolicy, this.continueLoadingCheckIntervalBytes);
                }
                if (z2) {
                    builderBuildUpon = mediaItem.buildUpon();
                }
                MediaItem mediaItem22 = mediaItem;
                return new ProgressiveMediaSource(mediaItem22, this.dataSourceFactory, this.extractorsFactory, this.drmSessionManagerProvider.get(mediaItem22), this.loadErrorHandlingPolicy, this.continueLoadingCheckIntervalBytes);
            }
            builderBuildUpon = mediaItem.buildUpon().setTag(this.tag);
            tag = builderBuildUpon.setCustomCacheKey(this.customCacheKey);
            mediaItem = tag.build();
            MediaItem mediaItem222 = mediaItem;
            return new ProgressiveMediaSource(mediaItem222, this.dataSourceFactory, this.extractorsFactory, this.drmSessionManagerProvider.get(mediaItem222), this.loadErrorHandlingPolicy, this.continueLoadingCheckIntervalBytes);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ DrmSessionManager lambda$setDrmSessionManager$0(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
            return drmSessionManager;
        }
    }

    public ProgressiveMediaSource(MediaItem mediaItem, DataSource.Factory factory, ExtractorsFactory extractorsFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i) {
        this.playbackProperties = (MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem.playbackProperties);
        this.mediaItem = mediaItem;
        this.dataSourceFactory = factory;
        this.extractorsFactory = extractorsFactory;
        this.drmSessionManager = drmSessionManager;
        this.loadableLoadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.continueLoadingCheckIntervalBytes = i;
    }

    private void notifySourceInfoRefreshed() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false, this.timelineIsLive, (Object) null, this.mediaItem);
        if (this.timelineIsPlaceholder) {
            singlePeriodTimeline = new ForwardingTimeline(singlePeriodTimeline) { // from class: com.oplus.tbl.exoplayer2.source.ProgressiveMediaSource.1
                @Override // com.oplus.tbl.exoplayer2.source.ForwardingTimeline, com.oplus.tbl.exoplayer2.Timeline
                public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
                    super.getWindow(i, window, j);
                    window.isPlaceholder = true;
                    return window;
                }
            };
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
        TransferListener transferListener = this.transferListener;
        if (transferListener != null) {
            dataSourceCreateDataSource.addTransferListener(transferListener);
        }
        return new ProgressiveMediaPeriod(this.playbackProperties.uri, dataSourceCreateDataSource, this.extractorsFactory, this.drmSessionManager, createDrmEventDispatcher(mediaPeriodId), this.loadableLoadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId), this, allocator, this.playbackProperties.customCacheKey, this.continueLoadingCheckIntervalBytes);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Override // com.oplus.tbl.exoplayer2.source.BaseMediaSource, com.oplus.tbl.exoplayer2.source.MediaSource
    @Nullable
    @Deprecated
    public Object getTag() {
        return this.playbackProperties.tag;
    }

    @Override // com.oplus.tbl.exoplayer2.source.ProgressiveMediaPeriod.Listener
    public void onSourceInfoRefreshed(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.timelineDurationUs;
        }
        if (!this.timelineIsPlaceholder && this.timelineDurationUs == j && this.timelineIsSeekable == z && this.timelineIsLive == z2) {
            return;
        }
        this.timelineDurationUs = j;
        this.timelineIsSeekable = z;
        this.timelineIsLive = z2;
        this.timelineIsPlaceholder = false;
        notifySourceInfoRefreshed();
    }

    @Override // com.oplus.tbl.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.transferListener = transferListener;
        this.drmSessionManager.prepare();
        notifySourceInfoRefreshed();
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).release();
    }

    @Override // com.oplus.tbl.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.drmSessionManager.release();
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }
}
