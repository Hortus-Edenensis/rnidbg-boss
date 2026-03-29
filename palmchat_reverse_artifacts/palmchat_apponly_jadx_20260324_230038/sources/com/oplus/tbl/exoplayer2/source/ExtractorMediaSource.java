package com.oplus.tbl.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.MediaItem;
import com.oplus.tbl.exoplayer2.Timeline;
import com.oplus.tbl.exoplayer2.drm.DrmSessionManager;
import com.oplus.tbl.exoplayer2.drm.DrmSessionManagerProvider;
import com.oplus.tbl.exoplayer2.extractor.DefaultExtractorsFactory;
import com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory;
import com.oplus.tbl.exoplayer2.source.MediaSource;
import com.oplus.tbl.exoplayer2.upstream.Allocator;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.oplus.tbl.exoplayer2.upstream.HttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import com.oplus.tbl.exoplayer2.util.Assertions;
import defpackage.gm3;
import defpackage.ll3;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class ExtractorMediaSource extends CompositeMediaSource<Void> {

    @Deprecated
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    private final ProgressiveMediaSource progressiveMediaSource;

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public interface EventListener {
        void onLoadError(IOException iOException);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public static final class EventListenerWrapper implements MediaSourceEventListener {
        private final EventListener eventListener;

        public EventListenerWrapper(EventListener eventListener) {
            this.eventListener = (EventListener) Assertions.checkNotNull(eventListener);
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            ll3.a(this, i, mediaPeriodId, mediaLoadData);
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            ll3.b(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            ll3.c(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            this.eventListener.onLoadError(iOException);
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            ll3.e(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
        public /* synthetic */ void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            ll3.f(this, i, mediaPeriodId, mediaLoadData);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public static final class Factory implements MediaSourceFactory {

        @Nullable
        private String customCacheKey;
        private final DataSource.Factory dataSourceFactory;

        @Nullable
        private Object tag;
        private ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        private int continueLoadingCheckIntervalBytes = 1048576;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public ExtractorMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setUri(uri).build());
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        public Factory setContinueLoadingCheckIntervalBytes(int i) {
            this.continueLoadingCheckIntervalBytes = i;
            return this;
        }

        public Factory setCustomCacheKey(@Nullable String str) {
            this.customCacheKey = str;
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public MediaSourceFactory setDrmHttpDataSourceFactory(@Nullable HttpDataSource.Factory factory) {
            throw new UnsupportedOperationException();
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public Factory setDrmSessionManager(@Nullable DrmSessionManager drmSessionManager) {
            throw new UnsupportedOperationException();
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public Factory setDrmSessionManagerProvider(@Nullable DrmSessionManagerProvider drmSessionManagerProvider) {
            throw new UnsupportedOperationException();
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public MediaSourceFactory setDrmUserAgent(@Nullable String str) {
            throw new UnsupportedOperationException();
        }

        public Factory setExtractorsFactory(@Nullable ExtractorsFactory extractorsFactory) {
            if (extractorsFactory == null) {
                extractorsFactory = new DefaultExtractorsFactory();
            }
            this.extractorsFactory = extractorsFactory;
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
        public /* synthetic */ MediaSourceFactory setStreamKeys(List list) {
            return gm3.b(this, list);
        }

        @Deprecated
        public Factory setTag(@Nullable Object obj) {
            this.tag = obj;
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.source.MediaSourceFactory
        public ExtractorMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.playbackProperties);
            MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            Uri uri = playbackProperties.uri;
            DataSource.Factory factory = this.dataSourceFactory;
            ExtractorsFactory extractorsFactory = this.extractorsFactory;
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
            String str = this.customCacheKey;
            int i = this.continueLoadingCheckIntervalBytes;
            Object obj = playbackProperties.tag;
            if (obj == null) {
                obj = this.tag;
            }
            return new ExtractorMediaSource(uri, factory, extractorsFactory, loadErrorHandlingPolicy, str, i, obj);
        }
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, @Nullable Handler handler, @Nullable EventListener eventListener) {
        this(uri, factory, extractorsFactory, handler, eventListener, null);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return this.progressiveMediaSource.createPeriod(mediaPeriodId, allocator, j);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.progressiveMediaSource.getMediaItem();
    }

    @Override // com.oplus.tbl.exoplayer2.source.BaseMediaSource, com.oplus.tbl.exoplayer2.source.MediaSource
    @Nullable
    @Deprecated
    public Object getTag() {
        return this.progressiveMediaSource.getTag();
    }

    @Override // com.oplus.tbl.exoplayer2.source.CompositeMediaSource, com.oplus.tbl.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.progressiveMediaSource);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.progressiveMediaSource.releasePeriod(mediaPeriod);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, @Nullable Handler handler, @Nullable EventListener eventListener, @Nullable String str) {
        this(uri, factory, extractorsFactory, handler, eventListener, str, 1048576);
    }

    @Override // com.oplus.tbl.exoplayer2.source.CompositeMediaSource
    /* JADX INFO: renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void lambda$prepareChildSource$0(@Nullable Void r1, MediaSource mediaSource, Timeline timeline) {
        refreshSourceInfo(timeline);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, @Nullable Handler handler, @Nullable EventListener eventListener, @Nullable String str, int i) {
        this(uri, factory, extractorsFactory, new DefaultLoadErrorHandlingPolicy(), str, i, (Object) null);
        if (eventListener == null || handler == null) {
            return;
        }
        addEventListener(handler, new EventListenerWrapper(eventListener));
    }

    private ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, @Nullable String str, int i, @Nullable Object obj) {
        this.progressiveMediaSource = new ProgressiveMediaSource(new MediaItem.Builder().setUri(uri).setCustomCacheKey(str).setTag(obj).build(), factory, extractorsFactory, DrmSessionManager.DRM_UNSUPPORTED, loadErrorHandlingPolicy, i);
    }
}
