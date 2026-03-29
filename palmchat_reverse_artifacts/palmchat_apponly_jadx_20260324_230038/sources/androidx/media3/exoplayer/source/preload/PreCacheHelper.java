package androidx.media3.exoplayer.source.preload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MediaItem;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.offline.DefaultDownloaderFactory;
import androidx.media3.exoplayer.offline.DownloadHelper;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.offline.Downloader;
import androidx.media3.exoplayer.offline.DownloaderFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.preload.PreCacheHelper;
import androidx.media3.exoplayer.util.ReleasableExecutor;
import defpackage.k41;
import defpackage.qo5;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class PreCacheHelper {

    @VisibleForTesting
    static final int DEFAULT_MIN_RETRY_COUNT = 5;
    private final Handler applicationHandler = Util.createHandlerForCurrentOrMainLooper();

    @Nullable
    private DownloadCallback currentDownloadCallback;
    private final DownloadHelper.Factory downloadHelperFactory;
    private final DownloaderFactory downloaderFactory;

    @Nullable
    private final Listener listener;
    private final MediaItem mediaItem;
    private final Handler preCacheHandler;

    @Nullable
    private final MediaSource.Factory testMediaSourceFactory;

    /* JADX INFO: compiled from: SearchBox */
    public final class DownloadCallback implements DownloadHelper.Callback {
        private final DownloadHelper downloadHelper;

        @Nullable
        private Downloader downloader;

        @Nullable
        private Task downloaderTask;
        private final long durationMs;

        @GuardedBy("lock")
        private boolean isCanceled;
        private boolean isPreparationOngoing;
        private final Object lock;

        @Nullable
        private DownloadRequest pendingDownloadRequest;

        @Nullable
        private final ReleasableExecutorSupplier releasableExecutorSupplier;
        private final long startPositionMs;

        public DownloadCallback(long j, long j2) {
            Assertions.checkState(Looper.myLooper() == PreCacheHelper.this.preCacheHandler.getLooper());
            this.lock = new Object();
            this.startPositionMs = j;
            this.durationMs = j2;
            if (PreCacheHelper.this.testMediaSourceFactory != null) {
                this.releasableExecutorSupplier = null;
                this.downloadHelper = PreCacheHelper.this.downloadHelperFactory.create(PreCacheHelper.this.testMediaSourceFactory.createMediaSource(PreCacheHelper.this.mediaItem));
            } else {
                ReleasableExecutorSupplier releasableExecutorSupplier = new ReleasableExecutorSupplier(PreCacheHelper.this.preCacheHandler);
                this.releasableExecutorSupplier = releasableExecutorSupplier;
                PreCacheHelper.this.downloadHelperFactory.setLoadExecutor(releasableExecutorSupplier);
                this.downloadHelper = PreCacheHelper.this.downloadHelperFactory.create(PreCacheHelper.this.mediaItem);
                releasableExecutorSupplier.setDownloadCallback(this);
            }
            this.isPreparationOngoing = true;
            this.downloadHelper.prepare(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyListeners$6(Consumer consumer) {
            synchronized (this.lock) {
                if (this.isCanceled) {
                    return;
                }
                if (PreCacheHelper.this.listener != null) {
                    consumer.accept(PreCacheHelper.this.listener);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDownloadProgress$4(Task task, Listener listener) {
            listener.onPreCacheProgress(PreCacheHelper.this.mediaItem, task.contentLength, task.bytesDownloaded, task.percentDownloaded);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDownloadProgress$5(final Task task) {
            if (task != this.downloaderTask) {
                return;
            }
            notifyListeners(new Consumer() { // from class: androidx.media3.exoplayer.source.preload.g
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f1466a.lambda$onDownloadProgress$4(task, (PreCacheHelper.Listener) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDownloadStopped$2(IOException iOException, Listener listener) {
            listener.onDownloadError(PreCacheHelper.this.mediaItem, iOException);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDownloadStopped$3(Task task) {
            if (task != this.downloaderTask) {
                return;
            }
            this.downloaderTask = null;
            final IOException iOException = task.finalException;
            if (task.isRemove || iOException == null) {
                return;
            }
            notifyListeners(new Consumer() { // from class: androidx.media3.exoplayer.source.preload.d
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f1463a.lambda$onDownloadStopped$2(iOException, (PreCacheHelper.Listener) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPrepareError$1(IOException iOException, Listener listener) {
            listener.onPrepareError(PreCacheHelper.this.mediaItem, iOException);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPrepared$0(MediaItem mediaItem, Listener listener) {
            listener.onPrepared(PreCacheHelper.this.mediaItem, mediaItem);
        }

        private void notifyListeners(final Consumer<Listener> consumer) {
            PreCacheHelper.this.applicationHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1469a.lambda$notifyListeners$6(consumer);
                }
            });
        }

        public void cancel(boolean z) {
            Assertions.checkState(Looper.myLooper() == PreCacheHelper.this.preCacheHandler.getLooper());
            synchronized (this.lock) {
                this.isCanceled = true;
            }
            this.pendingDownloadRequest = null;
            this.downloadHelper.release();
            Task task = this.downloaderTask;
            if (task == null || !task.isRemove) {
                Task task2 = this.downloaderTask;
                if (task2 != null) {
                    task2.cancel();
                }
                if (!z || this.downloader == null) {
                    return;
                }
                Task task3 = new Task(this.downloader, true, 5, this);
                this.downloaderTask = task3;
                task3.start();
            }
        }

        public boolean isReusable(long j, long j2) {
            Task task;
            boolean z = true;
            Assertions.checkState(Looper.myLooper() == PreCacheHelper.this.preCacheHandler.getLooper());
            synchronized (this.lock) {
                if (this.isCanceled || j != this.startPositionMs || j2 != this.durationMs || (!this.isPreparationOngoing && ((task = this.downloaderTask) == null || task.isRemove))) {
                    z = false;
                }
            }
            return z;
        }

        public void maybeSubmitPendingDownloadRequest() {
            Assertions.checkState(Looper.myLooper() == PreCacheHelper.this.preCacheHandler.getLooper());
            if (this.pendingDownloadRequest != null) {
                this.downloader = PreCacheHelper.this.downloaderFactory.createDownloader(this.pendingDownloadRequest);
                Task task = new Task(this.downloader, false, 5, this);
                this.downloaderTask = task;
                task.start();
                this.pendingDownloadRequest = null;
            }
        }

        public void onDownloadProgress(final Task task) {
            PreCacheHelper.this.preCacheHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1464a.lambda$onDownloadProgress$5(task);
                }
            });
        }

        public void onDownloadStopped(final Task task) {
            PreCacheHelper.this.preCacheHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1467a.lambda$onDownloadStopped$3(task);
                }
            });
        }

        @Override // androidx.media3.exoplayer.offline.DownloadHelper.Callback
        public void onPrepareError(DownloadHelper downloadHelper, final IOException iOException) {
            Assertions.checkState(Looper.myLooper() == PreCacheHelper.this.preCacheHandler.getLooper());
            Assertions.checkState(downloadHelper == this.downloadHelper);
            this.isPreparationOngoing = false;
            this.downloadHelper.release();
            notifyListeners(new Consumer() { // from class: androidx.media3.exoplayer.source.preload.f
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f1465a.lambda$onPrepareError$1(iOException, (PreCacheHelper.Listener) obj);
                }
            });
        }

        @Override // androidx.media3.exoplayer.offline.DownloadHelper.Callback
        public void onPrepared(DownloadHelper downloadHelper, boolean z) {
            Assertions.checkState(Looper.myLooper() == PreCacheHelper.this.preCacheHandler.getLooper());
            Assertions.checkState(downloadHelper == this.downloadHelper);
            this.isPreparationOngoing = false;
            DownloadRequest downloadRequest = downloadHelper.getDownloadRequest(null, this.startPositionMs, this.durationMs);
            this.downloadHelper.release();
            final MediaItem mediaItem = downloadRequest.toMediaItem(PreCacheHelper.this.mediaItem.buildUpon());
            notifyListeners(new Consumer() { // from class: androidx.media3.exoplayer.source.preload.i
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f1468a.lambda$onPrepared$0(mediaItem, (PreCacheHelper.Listener) obj);
                }
            });
            this.pendingDownloadRequest = downloadRequest;
            ReleasableExecutorSupplier releasableExecutorSupplier = this.releasableExecutorSupplier;
            if (releasableExecutorSupplier == null || releasableExecutorSupplier.wereExecutorsReleased()) {
                maybeSubmitPendingDownloadRequest();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onDownloadError(MediaItem mediaItem, IOException iOException);

        void onPreCacheProgress(MediaItem mediaItem, long j, long j2, float f);

        void onPrepareError(MediaItem mediaItem, IOException iOException);

        void onPrepared(MediaItem mediaItem, MediaItem mediaItem2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ReleasableExecutorSupplier implements qo5<ReleasableExecutor> {
        private DownloadCallback downloadCallback;

        @GuardedBy("this")
        private int executorCount;
        private final Handler preCacheHandler;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onExecutorReleased$0() {
            Assertions.checkState(wereExecutorsReleased());
            DownloadCallback downloadCallback = this.downloadCallback;
            if (downloadCallback != null) {
                downloadCallback.maybeSubmitPendingDownloadRequest();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onExecutorReleased() {
            synchronized (this) {
                Assertions.checkState(this.executorCount > 0);
                this.executorCount--;
                if (wereExecutorsReleased()) {
                    this.preCacheHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1471a.lambda$onExecutorReleased$0();
                        }
                    });
                }
            }
        }

        public void setDownloadCallback(DownloadCallback downloadCallback) {
            this.downloadCallback = downloadCallback;
        }

        public boolean wereExecutorsReleased() {
            boolean z;
            synchronized (this) {
                z = this.executorCount == 0;
            }
            return z;
        }

        private ReleasableExecutorSupplier(Handler handler) {
            this.preCacheHandler = handler;
        }

        @Override // defpackage.qo5
        /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
        public ReleasableExecutor get2() {
            synchronized (this) {
                this.executorCount++;
            }
            return new ReleasableSingleThreadExecutor(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1470a.onExecutorReleased();
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ReleasableSingleThreadExecutor implements ReleasableExecutor {
        private final ExecutorService executor;
        private final Runnable releaseRunnable;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.executor.execute(runnable);
        }

        @Override // androidx.media3.exoplayer.util.ReleasableExecutor
        public void release() {
            execute(this.releaseRunnable);
            this.executor.shutdown();
        }

        private ReleasableSingleThreadExecutor(Runnable runnable) {
            this.executor = Util.newSingleThreadExecutor("PreCacheHelper:Loader");
            this.releaseRunnable = runnable;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Task extends Thread implements Downloader.ProgressListener {
        private volatile long bytesDownloaded;
        private volatile long contentLength;

        @Nullable
        private DownloadCallback downloadCallback;
        private final Downloader downloader;

        @Nullable
        private volatile IOException finalException;
        private volatile boolean isCanceled;
        private final boolean isRemove;
        private final int minRetryCount;
        private volatile float percentDownloaded;

        private static int getRetryDelayMillis(int i) {
            return Math.min((i - 1) * 1000, 5000);
        }

        public void cancel() {
            this.downloadCallback = null;
            if (this.isCanceled) {
                return;
            }
            this.isCanceled = true;
            this.downloader.cancel();
            interrupt();
        }

        @Override // androidx.media3.exoplayer.offline.Downloader.ProgressListener
        public void onProgress(long j, long j2, float f) {
            this.contentLength = j;
            this.bytesDownloaded = j2;
            this.percentDownloaded = f;
            DownloadCallback downloadCallback = this.downloadCallback;
            if (downloadCallback != null) {
                downloadCallback.onDownloadProgress(this);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    if (this.isRemove) {
                        this.downloader.remove();
                    } else {
                        long j = -1;
                        int i = 0;
                        while (!this.isCanceled) {
                            try {
                                this.downloader.download(this);
                                break;
                            } catch (IOException e) {
                                if (!this.isCanceled) {
                                    if (this.bytesDownloaded != j) {
                                        j = this.bytesDownloaded;
                                        i = 0;
                                    }
                                    i++;
                                    if (i > this.minRetryCount) {
                                        throw e;
                                    }
                                    Thread.sleep(getRetryDelayMillis(i));
                                }
                            }
                        }
                    }
                } catch (IOException e2) {
                    this.finalException = e2;
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException unused2) {
            }
            DownloadCallback downloadCallback = this.downloadCallback;
            if (downloadCallback != null) {
                downloadCallback.onDownloadStopped(this);
            }
        }

        private Task(Downloader downloader, boolean z, int i, DownloadCallback downloadCallback) {
            this.downloader = downloader;
            this.isRemove = z;
            this.minRetryCount = i;
            this.downloadCallback = downloadCallback;
            this.contentLength = -1L;
        }
    }

    public PreCacheHelper(MediaItem mediaItem, @Nullable MediaSource.Factory factory, DownloadHelper.Factory factory2, DownloaderFactory downloaderFactory, Looper looper, @Nullable Listener listener) {
        this.mediaItem = mediaItem;
        this.testMediaSourceFactory = factory;
        this.downloadHelperFactory = factory2;
        this.downloaderFactory = downloaderFactory;
        this.listener = listener;
        this.preCacheHandler = Util.createHandler(looper, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preCache$0(long j, long j2) {
        DownloadCallback downloadCallback = this.currentDownloadCallback;
        if (downloadCallback == null || !downloadCallback.isReusable(j, j2)) {
            DownloadCallback downloadCallback2 = this.currentDownloadCallback;
            if (downloadCallback2 != null) {
                downloadCallback2.cancel(false);
            }
            this.currentDownloadCallback = new DownloadCallback(j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2(boolean z) {
        DownloadCallback downloadCallback = this.currentDownloadCallback;
        if (downloadCallback != null) {
            downloadCallback.cancel(z);
            this.currentDownloadCallback = null;
        }
        this.preCacheHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$1() {
        DownloadCallback downloadCallback = this.currentDownloadCallback;
        if (downloadCallback != null) {
            downloadCallback.cancel(false);
        }
    }

    public void preCache(final long j, final long j2) {
        this.preCacheHandler.post(new Runnable() { // from class: el4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17312a.lambda$preCache$0(j, j2);
            }
        });
    }

    public void release(final boolean z) {
        this.preCacheHandler.post(new Runnable() { // from class: fl4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17551a.lambda$release$2(z);
            }
        });
    }

    public void stop() {
        this.preCacheHandler.post(new Runnable() { // from class: dl4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17070a.lambda$stop$1();
            }
        });
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory {
        private final Cache cache;

        @Nullable
        private Listener listener;
        private final Looper preCacheLooper;
        private final RenderersFactory renderersFactory;
        private final DataSource.Factory upstreamDataSourceFactory;
        private TrackSelectionParameters trackSelectionParameters = TrackSelectionParameters.DEFAULT;
        private Executor downloadExecutor = new k41();

        public Factory(Context context, Cache cache, Looper looper) {
            this.cache = cache;
            this.preCacheLooper = looper;
            this.upstreamDataSourceFactory = new DefaultDataSource.Factory(context);
            this.renderersFactory = new DefaultRenderersFactory(context);
        }

        public PreCacheHelper create(MediaItem mediaItem) {
            CacheDataSource.Factory cache = new CacheDataSource.Factory().setUpstreamDataSourceFactory(this.upstreamDataSourceFactory).setCache(this.cache);
            return new PreCacheHelper(mediaItem, null, new DownloadHelper.Factory().setDataSourceFactory(cache).setRenderersFactory(this.renderersFactory).setTrackSelectionParameters(this.trackSelectionParameters), new DefaultDownloaderFactory(cache, this.downloadExecutor), this.preCacheLooper, this.listener);
        }

        public Factory setDownloadExecutor(Executor executor) {
            this.downloadExecutor = executor;
            return this;
        }

        public Factory setListener(@Nullable Listener listener) {
            this.listener = listener;
            return this;
        }

        public Factory setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
            this.trackSelectionParameters = trackSelectionParameters;
            return this;
        }

        public Factory(Context context, Cache cache, RenderersFactory renderersFactory, Looper looper) {
            this.cache = cache;
            this.preCacheLooper = looper;
            this.upstreamDataSourceFactory = new DefaultDataSource.Factory(context);
            this.renderersFactory = renderersFactory;
        }

        public Factory(Context context, Cache cache, DataSource.Factory factory, Looper looper) {
            this.cache = cache;
            this.preCacheLooper = looper;
            this.upstreamDataSourceFactory = factory;
            this.renderersFactory = new DefaultRenderersFactory(context);
        }

        public Factory(Cache cache, DataSource.Factory factory, RenderersFactory renderersFactory, Looper looper) {
            this.cache = cache;
            this.preCacheLooper = looper;
            this.upstreamDataSourceFactory = factory;
            this.renderersFactory = renderersFactory;
        }
    }
}
