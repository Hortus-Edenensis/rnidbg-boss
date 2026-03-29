package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import androidx.media3.extractor.DefaultExtractorsFactory;
import defpackage.er3;
import defpackage.o65;
import defpackage.r33;
import defpackage.x42;
import defpackage.z42;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class MetadataRetriever implements AutoCloseable {
    public static final int DEFAULT_MAXIMUM_PARALLEL_RETRIEVALS = 5;

    @GuardedBy("lock")
    private final List<r33<?>> allFutures;
    private final Clock clock;

    @GuardedBy("lock")
    private MetadataRetrieverInternal internalRetriever;
    private final Object lock;
    private final MediaItem mediaItem;
    private final MediaSource.Factory mediaSourceFactory;

    @GuardedBy("lock")
    private o65<InternalResult> preparationFuture;

    @GuardedBy("lock")
    private boolean released;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private Clock clock;

        @Nullable
        private final Context context;
        private final MediaItem mediaItem;

        @Nullable
        private MediaSource.Factory mediaSourceFactory;

        public Builder(@Nullable Context context, MediaItem mediaItem) {
            this.context = context != null ? context.getApplicationContext() : null;
            this.mediaItem = (MediaItem) Assertions.checkNotNull(mediaItem);
            this.clock = Clock.DEFAULT;
        }

        public MetadataRetriever build() {
            if (this.mediaSourceFactory == null) {
                Assertions.checkStateNotNull(this.context, "Context must be provided if MediaSource.Factory is not set.");
                this.mediaSourceFactory = new DefaultMediaSourceFactory(this.context, new DefaultExtractorsFactory().setMp4ExtractorFlags(6));
            }
            return new MetadataRetriever(this.mediaItem, (MediaSource.Factory) Assertions.checkNotNull(this.mediaSourceFactory), this.clock);
        }

        public Builder setClock(Clock clock) {
            this.clock = (Clock) Assertions.checkNotNull(clock);
            return this;
        }

        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            this.mediaSourceFactory = (MediaSource.Factory) Assertions.checkNotNull(factory);
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class InternalResult {
        public final Timeline timeline;
        public final TrackGroupArray trackGroups;

        public InternalResult(TrackGroupArray trackGroupArray, Timeline timeline) {
            this.trackGroups = trackGroupArray;
            this.timeline = timeline;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class MetadataRetrieverInternal {
        private static final int MESSAGE_CHECK_FOR_FAILURE = 2;
        private static final int MESSAGE_CONTINUE_LOADING = 3;
        private static final int MESSAGE_PREPARE_SOURCE = 1;
        private static final int MESSAGE_RELEASE = 4;
        private static final SharedWorkerThread SHARED_WORKER_THREAD = new SharedWorkerThread();
        private final MediaItem mediaItem;
        private final MediaSource.Factory mediaSourceFactory;
        private final HandlerWrapper mediaSourceHandler;
        private final OnFailureListener onFailureListener;
        private final OnPreparedListener onPreparedListener;

        /* JADX INFO: compiled from: SearchBox */
        public final class MediaSourceHandlerCallback implements Handler.Callback {
            private static final int ERROR_POLL_INTERVAL_MS = 100;
            private MediaPeriod mediaPeriod;
            private MediaSource mediaSource;
            private final MediaSourceCaller mediaSourceCaller = new MediaSourceCaller();
            private boolean released;
            private Timeline timeline;

            /* JADX INFO: compiled from: SearchBox */
            public final class MediaSourceCaller implements MediaSource.MediaSourceCaller {
                private boolean mediaPeriodCreated;
                private final MediaPeriodCallback mediaPeriodCallback = new MediaPeriodCallback();
                private final Allocator allocator = new DefaultAllocator(true, 65536);

                /* JADX INFO: compiled from: SearchBox */
                public final class MediaPeriodCallback implements MediaPeriod.Callback {
                    private MediaPeriodCallback() {
                    }

                    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
                    public void onPrepared(MediaPeriod mediaPeriod) {
                        MetadataRetrieverInternal.this.onPreparedListener.onPrepared(mediaPeriod.getTrackGroups(), (Timeline) Assertions.checkNotNull(MediaSourceHandlerCallback.this.timeline));
                        MetadataRetrieverInternal.this.mediaSourceHandler.obtainMessage(4).sendToTarget();
                    }

                    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
                    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
                        MetadataRetrieverInternal.this.mediaSourceHandler.obtainMessage(3).sendToTarget();
                    }
                }

                public MediaSourceCaller() {
                }

                @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
                public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
                    MediaSourceHandlerCallback.this.timeline = timeline;
                    if (this.mediaPeriodCreated) {
                        return;
                    }
                    this.mediaPeriodCreated = true;
                    MediaSourceHandlerCallback.this.mediaPeriod = mediaSource.createPeriod(new MediaSource.MediaPeriodId(timeline.getUidOfPeriod(0)), this.allocator, 0L);
                    MediaSourceHandlerCallback.this.mediaPeriod.prepare(this.mediaPeriodCallback, 0L);
                }
            }

            public MediaSourceHandlerCallback() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (this.released) {
                    return true;
                }
                int i = message.what;
                if (i == 1) {
                    MediaSource mediaSourceCreateMediaSource = MetadataRetrieverInternal.this.mediaSourceFactory.createMediaSource((MediaItem) message.obj);
                    this.mediaSource = mediaSourceCreateMediaSource;
                    mediaSourceCreateMediaSource.prepareSource(this.mediaSourceCaller, null, PlayerId.UNSET);
                    MetadataRetrieverInternal.this.mediaSourceHandler.sendEmptyMessage(2);
                    return true;
                }
                if (i == 2) {
                    try {
                        MediaPeriod mediaPeriod = this.mediaPeriod;
                        if (mediaPeriod == null) {
                            ((MediaSource) Assertions.checkNotNull(this.mediaSource)).maybeThrowSourceInfoRefreshError();
                        } else {
                            mediaPeriod.maybeThrowPrepareError();
                        }
                        MetadataRetrieverInternal.this.mediaSourceHandler.sendEmptyMessageDelayed(2, 100);
                    } catch (IOException e) {
                        MetadataRetrieverInternal.this.onFailureListener.onFailure(e);
                        MetadataRetrieverInternal.this.mediaSourceHandler.obtainMessage(4).sendToTarget();
                    }
                    return true;
                }
                if (i == 3) {
                    ((MediaPeriod) Assertions.checkNotNull(this.mediaPeriod)).continueLoading(new LoadingInfo.Builder().setPlaybackPositionUs(0L).build());
                    return true;
                }
                if (i != 4) {
                    return false;
                }
                if (this.mediaPeriod != null) {
                    ((MediaSource) Assertions.checkNotNull(this.mediaSource)).releasePeriod(this.mediaPeriod);
                }
                MediaSource mediaSource = this.mediaSource;
                if (mediaSource != null) {
                    mediaSource.releaseSource(this.mediaSourceCaller);
                }
                MetadataRetrieverInternal.this.mediaSourceHandler.removeCallbacksAndMessages(null);
                MetadataRetrieverInternal.SHARED_WORKER_THREAD.removeWorker();
                this.released = true;
                return true;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface OnFailureListener {
            void onFailure(Exception exc);
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface OnPreparedListener {
            void onPrepared(TrackGroupArray trackGroupArray, Timeline timeline);
        }

        public MetadataRetrieverInternal(MediaSource.Factory factory, MediaItem mediaItem, Clock clock, OnPreparedListener onPreparedListener, OnFailureListener onFailureListener) {
            this.mediaSourceFactory = factory;
            this.mediaItem = mediaItem;
            this.onPreparedListener = onPreparedListener;
            this.onFailureListener = onFailureListener;
            this.mediaSourceHandler = clock.createHandler(SHARED_WORKER_THREAD.addWorker(), new MediaSourceHandlerCallback());
        }

        public void queueRetrieval() {
            SHARED_WORKER_THREAD.startRetrieval(this);
        }

        public void release() {
            this.mediaSourceHandler.obtainMessage(4).sendToTarget();
        }

        public void start() {
            this.mediaSourceHandler.obtainMessage(1, this.mediaItem).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SharedWorkerThread {
        public static final AtomicInteger MAX_PARALLEL_RETRIEVALS = new AtomicInteger(5);

        @Nullable
        private HandlerThread mediaSourceThread;
        private final Deque<MetadataRetrieverInternal> pendingRetrievals = new ArrayDeque();
        private int referenceCount;

        @GuardedBy("this")
        private void maybeStartNewRetrieval() {
            if (!this.pendingRetrievals.isEmpty() && this.referenceCount - this.pendingRetrievals.size() < MAX_PARALLEL_RETRIEVALS.get()) {
                this.pendingRetrievals.removeFirst().start();
            }
        }

        public synchronized Looper addWorker() {
            if (this.mediaSourceThread == null) {
                Assertions.checkState(this.referenceCount == 0);
                HandlerThread handlerThread = new HandlerThread("ExoPlayer:MetadataRetriever");
                this.mediaSourceThread = handlerThread;
                handlerThread.start();
            }
            this.referenceCount++;
            return ((HandlerThread) Assertions.checkNotNull(this.mediaSourceThread)).getLooper();
        }

        public synchronized void removeWorker() {
            int i = this.referenceCount - 1;
            this.referenceCount = i;
            if (i == 0) {
                ((HandlerThread) Assertions.checkNotNull(this.mediaSourceThread)).quit();
                this.mediaSourceThread = null;
                this.pendingRetrievals.clear();
            } else {
                maybeStartNewRetrieval();
            }
        }

        public synchronized void startRetrieval(MetadataRetrieverInternal metadataRetrieverInternal) {
            this.pendingRetrievals.addLast(metadataRetrieverInternal);
            maybeStartNewRetrieval();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$close$2() {
        synchronized (this.lock) {
            MetadataRetrieverInternal metadataRetrieverInternal = this.internalRetriever;
            if (metadataRetrieverInternal != null) {
                metadataRetrieverInternal.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPreparation$0(TrackGroupArray trackGroupArray, Timeline timeline) {
        synchronized (this.lock) {
            ((o65) Assertions.checkNotNull(this.preparationFuture)).A(new InternalResult(trackGroupArray, timeline));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPreparation$1(Exception exc) {
        synchronized (this.lock) {
            ((o65) Assertions.checkNotNull(this.preparationFuture)).B(exc);
        }
    }

    @Deprecated
    public static r33<TrackGroupArray> retrieveMetadata(Context context, MediaItem mediaItem) {
        return retrieveMetadata(context, mediaItem, Clock.DEFAULT);
    }

    public static void setMaximumParallelRetrievals(int i) {
        Assertions.checkArgument(i >= 1);
        SharedWorkerThread.MAX_PARALLEL_RETRIEVALS.set(i);
    }

    @GuardedBy("lock")
    private void startPreparation() {
        if (this.preparationFuture == null) {
            this.preparationFuture = o65.E();
            MetadataRetrieverInternal metadataRetrieverInternal = new MetadataRetrieverInternal(this.mediaSourceFactory, this.mediaItem, this.clock, new MetadataRetrieverInternal.OnPreparedListener() { // from class: uo3
                @Override // androidx.media3.exoplayer.MetadataRetriever.MetadataRetrieverInternal.OnPreparedListener
                public final void onPrepared(TrackGroupArray trackGroupArray, Timeline timeline) {
                    this.f21254a.lambda$startPreparation$0(trackGroupArray, timeline);
                }
            }, new MetadataRetrieverInternal.OnFailureListener() { // from class: vo3
                @Override // androidx.media3.exoplayer.MetadataRetriever.MetadataRetrieverInternal.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f21499a.lambda$startPreparation$1(exc);
                }
            });
            this.internalRetriever = metadataRetrieverInternal;
            metadataRetrieverInternal.queueRetrieval();
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.released) {
                return;
            }
            this.released = true;
            z42.g(this.allFutures).b(new Runnable() { // from class: wo3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21763a.lambda$close$2();
                }
            }, er3.a());
        }
    }

    public r33<Long> retrieveDurationUs() {
        synchronized (this.lock) {
            if (this.released) {
                return z42.e(new IllegalStateException("Retriever is released."));
            }
            r33<Timeline> r33VarRetrieveTimeline = retrieveTimeline();
            final o65 o65VarE = o65.E();
            this.allFutures.add(o65VarE);
            z42.a(r33VarRetrieveTimeline, new x42<Timeline>() { // from class: androidx.media3.exoplayer.MetadataRetriever.3
                @Override // defpackage.x42
                public void onFailure(Throwable th) {
                    o65VarE.B(th);
                }

                @Override // defpackage.x42
                public void onSuccess(Timeline timeline) {
                    if (timeline.isEmpty()) {
                        o65VarE.A(-9223372036854775807L);
                    } else {
                        o65VarE.A(Long.valueOf(timeline.getWindow(0, new Timeline.Window()).getDurationUs()));
                    }
                }
            }, er3.a());
            return o65VarE;
        }
    }

    public r33<Timeline> retrieveTimeline() {
        synchronized (this.lock) {
            if (this.released) {
                return z42.e(new IllegalStateException("Retriever is released."));
            }
            startPreparation();
            final o65 o65VarE = o65.E();
            this.allFutures.add(o65VarE);
            z42.a((r33) Assertions.checkNotNull(this.preparationFuture), new x42<InternalResult>() { // from class: androidx.media3.exoplayer.MetadataRetriever.2
                @Override // defpackage.x42
                public void onFailure(Throwable th) {
                    o65VarE.B(th);
                }

                @Override // defpackage.x42
                public void onSuccess(InternalResult internalResult) {
                    o65VarE.A(internalResult.timeline);
                }
            }, er3.a());
            return o65VarE;
        }
    }

    public r33<TrackGroupArray> retrieveTrackGroups() {
        synchronized (this.lock) {
            if (this.released) {
                return z42.e(new IllegalStateException("Retriever is released."));
            }
            startPreparation();
            final o65 o65VarE = o65.E();
            this.allFutures.add(o65VarE);
            z42.a((r33) Assertions.checkNotNull(this.preparationFuture), new x42<InternalResult>() { // from class: androidx.media3.exoplayer.MetadataRetriever.1
                @Override // defpackage.x42
                public void onFailure(Throwable th) {
                    o65VarE.B(th);
                }

                @Override // defpackage.x42
                public void onSuccess(InternalResult internalResult) {
                    o65VarE.A(internalResult.trackGroups);
                }
            }, er3.a());
            return o65VarE;
        }
    }

    private MetadataRetriever(MediaItem mediaItem, MediaSource.Factory factory, Clock clock) {
        this.mediaItem = mediaItem;
        this.mediaSourceFactory = factory;
        this.clock = clock;
        this.lock = new Object();
        this.allFutures = new ArrayList();
    }

    @Deprecated
    public static r33<TrackGroupArray> retrieveMetadata(MediaSource.Factory factory, MediaItem mediaItem) {
        return retrieveMetadata(factory, mediaItem, Clock.DEFAULT);
    }

    @VisibleForTesting
    @Deprecated
    public static r33<TrackGroupArray> retrieveMetadata(Context context, MediaItem mediaItem, Clock clock) {
        MetadataRetriever metadataRetrieverBuild = new Builder(context, mediaItem).setClock(clock).build();
        try {
            r33<TrackGroupArray> r33VarRetrieveTrackGroups = metadataRetrieverBuild.retrieveTrackGroups();
            metadataRetrieverBuild.close();
            return r33VarRetrieveTrackGroups;
        } catch (Throwable th) {
            if (metadataRetrieverBuild != null) {
                try {
                    metadataRetrieverBuild.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Deprecated
    private static r33<TrackGroupArray> retrieveMetadata(MediaSource.Factory factory, MediaItem mediaItem, Clock clock) {
        MetadataRetriever metadataRetrieverBuild = new Builder(null, mediaItem).setMediaSourceFactory(factory).setClock(clock).build();
        try {
            r33<TrackGroupArray> r33VarRetrieveTrackGroups = metadataRetrieverBuild.retrieveTrackGroups();
            metadataRetrieverBuild.close();
            return r33VarRetrieveTrackGroups;
        } catch (Throwable th) {
            if (metadataRetrieverBuild != null) {
                try {
                    metadataRetrieverBuild.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
