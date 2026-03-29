package com.oplus.tbl.exoplayer2;

import android.content.Context;
import android.os.SystemClock;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Log;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class FrameTimeRecorder {
    private static final long DEFAULT_DETECTOR_STUCK_INTERVAL_MS = 100;
    private static final long DEFAULT_EQUAL_INTERVAL_MS = 5;
    public static final int INITIAL_DELAY_INTERVAL = 1;
    private static final int NORMAL_REPORT_COUNT = 0;
    public static final int SCHEDULER_PERIOD_INTERVAL = 1;
    private static final String TAG = "FrameTimeRecorder";
    public static final int TYPE_QUEUED_IN_CODEC = 1;
    public static final int TYPE_QUEUED_OUT_CODEC = 2;
    private static final long VSYNC_OFFSET_PERCENTAGE = 80;
    private boolean debug;
    private StuckDetectListener listener;
    private long mActiveFrameReceivedTotalTime;
    private long mActiveFrameRenderTotalTime;
    private long mActiveReceivedCount;
    private long mActiveRenderCount;
    private AtomicInteger mFrameCountBuffered;
    private AtomicInteger mFrameCountQueuedInCodec;
    private AtomicInteger mFrameCountReceived;
    private AtomicInteger mFrameCountReleased;
    private Map<Long, Long> mFrameReceivedStuckMap;
    private long mLastActiveReceivedMs;
    private long mLastActiveRenderMs;
    private long mLastFrameReceivePtsUs;
    private long mLastFrameReceiveTimeMs;
    private long mLastFrameRenderPtsUs;
    private long mLastFrameRenderTimeMs;
    private Map<Long, Long> mQueuedInCodecFrameTimeMap;
    private Map<Long, Long> mReceiveFrameTimeMap;
    private Map<Long, Long> mReleaseFrameTimeMap;
    private ScheduledExecutorService mScheduler;
    private StreamingStuckResult mStuckResult;
    private AtomicLong mTotalElapsedTime;
    private Map<Long, Long> mTotalFrameElapsedTimeMap;

    /* JADX INFO: compiled from: SearchBox */
    public static final class FrameTimeRecorderHolder {
        private static final FrameTimeRecorder INSTANCE = new FrameTimeRecorder();

        private FrameTimeRecorderHolder() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface QueuedCodecType {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface StuckDetectListener {
        void detectedStuck(StreamingStuckResult streamingStuckResult);

        void normalReport(StreamingStuckResult streamingStuckResult);
    }

    private FrameTimeRecorder() {
        this.debug = false;
        this.mLastFrameReceiveTimeMs = -9223372036854775807L;
        this.mLastFrameReceivePtsUs = -9223372036854775807L;
        this.mActiveFrameReceivedTotalTime = 0L;
        this.mLastActiveReceivedMs = 0L;
        this.mActiveReceivedCount = 0L;
        this.mActiveFrameRenderTotalTime = 0L;
        this.mLastActiveRenderMs = 0L;
        this.mActiveRenderCount = 0L;
        this.mLastFrameRenderTimeMs = -9223372036854775807L;
        this.mLastFrameRenderPtsUs = -9223372036854775807L;
        this.mReceiveFrameTimeMap = new ConcurrentSkipListMap();
        this.mQueuedInCodecFrameTimeMap = new ConcurrentSkipListMap();
        this.mReleaseFrameTimeMap = new ConcurrentSkipListMap();
        this.mTotalFrameElapsedTimeMap = new ConcurrentSkipListMap();
        this.mFrameReceivedStuckMap = new ConcurrentSkipListMap();
        this.mTotalElapsedTime = new AtomicLong(0L);
        this.mFrameCountReceived = new AtomicInteger(0);
        this.mFrameCountBuffered = new AtomicInteger(0);
        this.mFrameCountQueuedInCodec = new AtomicInteger(0);
        this.mFrameCountReleased = new AtomicInteger(0);
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.mScheduler = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: f32
            @Override // java.lang.Runnable
            public final void run() {
                this.f17425a.calculateAverageFrameElapsedTime();
            }
        }, 1L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void calculateAverageFrameElapsedTime() {
        maybeNormalReport();
        if (this.mFrameCountReleased.get() > 0) {
            Log.i(TAG, "Average frame elapsed time over the last second: " + (this.mTotalElapsedTime.get() / ((double) this.mFrameCountReleased.get())) + " ms  for releaseCount " + this.mFrameCountReleased + " totalElapsedTime " + this.mTotalElapsedTime);
        } else {
            Log.i(TAG, "No frames received in the last second");
        }
        this.mTotalElapsedTime.set(0L);
        this.mFrameCountReceived.set(0);
        this.mFrameCountReleased.set(0);
    }

    public static FrameTimeRecorder getInstance() {
        return FrameTimeRecorderHolder.INSTANCE;
    }

    private boolean isIntervalsEqual(long j, long j2) {
        return Math.abs(j - j2) <= 5;
    }

    private void logD(String str, String str2) {
        if (this.debug) {
            Log.d(str, str2);
        }
    }

    private void maybeDetectReceiveStuck(long j, long j2) {
        if (this.listener != null) {
            long j3 = this.mLastFrameReceiveTimeMs;
            if (j3 != -9223372036854775807L) {
                long j4 = this.mLastFrameReceivePtsUs;
                if (j4 != -9223372036854775807L) {
                    long j5 = j2 - j3;
                    this.mActiveFrameReceivedTotalTime += j5;
                    long jUsToMs = C.usToMs(j - j4);
                    if (j5 > 100 && !isIntervalsEqual(j5, jUsToMs)) {
                        logD(TAG, "detectedStuck elapsedTime receive " + j5 + " ,pts elapsed " + jUsToMs + " ,active frame received total time " + this.mActiveFrameReceivedTotalTime);
                        StreamingStuckResult streamingStuckResultCreateStuckResult = StreamingStuckResult.createStuckResult(1, this.mLastFrameReceiveTimeMs, j5, j);
                        this.mStuckResult = streamingStuckResultCreateStuckResult;
                        this.listener.detectedStuck(streamingStuckResultCreateStuckResult);
                        this.mFrameReceivedStuckMap.put(Long.valueOf(j), Long.valueOf(j2));
                    }
                }
            }
        }
        this.mLastFrameReceiveTimeMs = j2;
        this.mLastFrameReceivePtsUs = j;
    }

    private void maybeDetectRenderStuck(long j, long j2) {
        if (this.listener != null) {
            long j3 = this.mLastFrameRenderTimeMs;
            if (j3 != -9223372036854775807L) {
                long j4 = this.mLastFrameRenderPtsUs;
                if (j4 != -9223372036854775807L) {
                    long j5 = j2 - j3;
                    this.mActiveFrameRenderTotalTime += j5;
                    long jUsToMs = C.usToMs(j - j4);
                    if (j5 > 100 && !isIntervalsEqual(j5, jUsToMs) && !this.mFrameReceivedStuckMap.containsKey(Long.valueOf(j))) {
                        logD(TAG, "detected stuck for elapsedTime render " + j5 + " ,pts elapsed " + jUsToMs);
                        StreamingStuckResult streamingStuckResultCreateStuckResult = StreamingStuckResult.createStuckResult(2, this.mLastFrameRenderTimeMs, j5, j);
                        this.mStuckResult = streamingStuckResultCreateStuckResult;
                        this.listener.detectedStuck(streamingStuckResultCreateStuckResult);
                    }
                }
            }
        }
        this.mLastFrameRenderTimeMs = j2;
        this.mLastFrameRenderPtsUs = j;
    }

    private void maybeNormalReport() {
        if (this.listener == null || this.mFrameCountReceived.get() <= 0 || this.mFrameCountReleased.get() <= 0) {
            return;
        }
        long j = (this.mActiveFrameReceivedTotalTime - this.mLastActiveReceivedMs) / ((long) this.mFrameCountReceived.get());
        long j2 = (this.mActiveFrameRenderTotalTime - this.mLastActiveRenderMs) / ((long) this.mFrameCountReleased.get());
        this.mLastActiveReceivedMs = this.mActiveFrameReceivedTotalTime;
        this.mLastActiveRenderMs = this.mActiveFrameRenderTotalTime;
        this.mActiveReceivedCount += (long) this.mFrameCountReceived.get();
        this.mActiveRenderCount += (long) this.mFrameCountReleased.get();
        StreamingStuckResult streamingStuckResultCreateNormalResult = StreamingStuckResult.createNormalResult(j, this.mFrameCountReceived.get(), j2, this.mFrameCountReleased.get());
        this.mStuckResult = streamingStuckResultCreateNormalResult;
        this.listener.normalReport(streamingStuckResultCreateNormalResult);
    }

    public synchronized void calculateFrameElapsedTime(long j) {
        long jLongValue = this.mReceiveFrameTimeMap.get(Long.valueOf(j)).longValue();
        long jLongValue2 = this.mQueuedInCodecFrameTimeMap.get(Long.valueOf(j)).longValue();
        long jLongValue3 = this.mReleaseFrameTimeMap.get(Long.valueOf(j)).longValue();
        long j2 = jLongValue3 - jLongValue;
        logD(TAG, "calculateFrameElapsedTime: timestamp " + j + ", elapsedTimeFromReciveToQueuedIn " + (jLongValue2 - jLongValue) + ", elapsedTimeFromQueueInToRelease " + (jLongValue3 - jLongValue2) + ", elapsedTimeAll " + j2);
        this.mTotalElapsedTime.addAndGet(j2);
        this.mTotalFrameElapsedTimeMap.put(Long.valueOf(j), Long.valueOf(j2));
        this.mReceiveFrameTimeMap.keySet().removeAll(this.mTotalFrameElapsedTimeMap.keySet());
        this.mReleaseFrameTimeMap.clear();
    }

    public int getFrameCountBuffered() {
        return this.mFrameCountBuffered.get();
    }

    public int getFrameCountQueuedInCodec() {
        return this.mFrameCountQueuedInCodec.get();
    }

    public int getFrameCountReceived() {
        return this.mFrameCountReceived.get();
    }

    public int getFrameCountReleased() {
        return this.mFrameCountReleased.get();
    }

    public long getReleaseDurationUs(@Nullable Context context) {
        Display defaultDisplay = ((WindowManager) Assertions.checkNotNull(context != null ? (WindowManager) context.getApplicationContext().getSystemService("window") : null)).getDefaultDisplay();
        if (defaultDisplay == null) {
            Log.w(TAG, "Unable to query display refresh rate.");
            return -9223372036854775807L;
        }
        double refreshRate = defaultDisplay.getRefreshRate();
        long j = (long) (1000000.0d / refreshRate);
        long j2 = (VSYNC_OFFSET_PERCENTAGE * j) / 100;
        logD(TAG, "Refresh rate is " + refreshRate + " frames per second, vsyncDurationUs " + j + ", vsyncOffsetUs " + j2);
        return j2;
    }

    public long getTotalElapsedTime() {
        return this.mTotalElapsedTime.get();
    }

    public synchronized void recordQueuedCodecFrameTime(long j, int i) {
        AtomicInteger atomicInteger;
        try {
            if (i == 1) {
                this.mQueuedInCodecFrameTimeMap.put(Long.valueOf(j), Long.valueOf(SystemClock.elapsedRealtime()));
                this.mFrameCountQueuedInCodec.incrementAndGet();
                atomicInteger = this.mFrameCountBuffered;
            } else {
                if (i == 2) {
                    this.mQueuedInCodecFrameTimeMap.remove(Long.valueOf(j));
                    atomicInteger = this.mFrameCountQueuedInCodec;
                }
                logD(TAG, "frameCountQueuedInCodec " + this.mFrameCountQueuedInCodec);
            }
            atomicInteger.decrementAndGet();
            logD(TAG, "frameCountQueuedInCodec " + this.mFrameCountQueuedInCodec);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void recordReceiveFrameTime(long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mReceiveFrameTimeMap.put(Long.valueOf(j), Long.valueOf(jElapsedRealtime));
        this.mFrameCountReceived.incrementAndGet();
        this.mFrameCountBuffered.incrementAndGet();
        logD(TAG, "frameCountReceived: " + this.mFrameCountReceived + ", frameCountBuffered " + this.mFrameCountBuffered);
        maybeDetectReceiveStuck(j, jElapsedRealtime);
    }

    public synchronized void recordReleaseFrameTime(long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mReleaseFrameTimeMap.put(Long.valueOf(j), Long.valueOf(jElapsedRealtime));
        this.mFrameCountReleased.incrementAndGet();
        logD(TAG, "frameCountReleased: " + this.mFrameCountReleased + ", frameCountBuffered " + this.mFrameCountBuffered);
        maybeDetectRenderStuck(j, jElapsedRealtime);
        if (this.mFrameReceivedStuckMap.containsKey(Long.valueOf(j))) {
            this.mFrameReceivedStuckMap.remove(Long.valueOf(j));
        }
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setOnDetectedStuckListener(StuckDetectListener stuckDetectListener) {
        this.listener = stuckDetectListener;
    }

    public synchronized void shutdown() {
        this.mScheduler.shutdown();
        this.mReceiveFrameTimeMap.clear();
        this.mQueuedInCodecFrameTimeMap.clear();
        this.mReleaseFrameTimeMap.clear();
        this.mTotalFrameElapsedTimeMap.clear();
        this.mFrameReceivedStuckMap.clear();
        this.mTotalElapsedTime.set(0L);
        this.mFrameCountReceived.set(0);
        this.mFrameCountReleased.set(0);
        this.mFrameCountBuffered.set(0);
        this.mFrameCountQueuedInCodec.set(0);
        this.mLastFrameReceiveTimeMs = -9223372036854775807L;
        this.mLastFrameReceivePtsUs = -9223372036854775807L;
        this.mActiveFrameReceivedTotalTime = 0L;
        this.mLastActiveReceivedMs = 0L;
        this.mActiveReceivedCount = 0L;
        this.mActiveFrameRenderTotalTime = 0L;
        this.mLastActiveRenderMs = 0L;
        this.mActiveRenderCount = 0L;
        this.mLastFrameRenderTimeMs = -9223372036854775807L;
        this.mLastFrameRenderPtsUs = -9223372036854775807L;
    }
}
