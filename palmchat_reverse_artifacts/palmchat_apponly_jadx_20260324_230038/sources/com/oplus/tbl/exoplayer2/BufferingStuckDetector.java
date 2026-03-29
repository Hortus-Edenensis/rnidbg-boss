package com.oplus.tbl.exoplayer2;

import android.os.SystemClock;
import com.oplus.tbl.exoplayer2.util.Log;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BufferingStuckDetector {
    private static final int DEFAULT_BUFFERING_TIME_MAX_THRESHOLD_MS = 10000;
    private static final int DEFAULT_BUFFERING_TIME_MIN_THRESHOLD_MS = 1000;
    private static final int DEFAULT_DETECTOR_RANGE_MS = 60000;
    private static final int DEFAULT_STUCK_COUNT = 10;
    private static final int DEFAULT_TOTAL_BUFFERING_COUNT = 10;
    private static final int DEFAULT_TOTAL_BUFFERING_TIME_MS = 10000;
    private static final String TAG = "BufferingStuckDetector";
    private BufferingStuckDetectorInternal detectorInternal;
    private boolean isEnabled;
    private boolean isStarted;
    private int maxStuckCount;
    private long startTimeMs;
    private int totalStuckCount;

    /* JADX INFO: compiled from: SearchBox */
    public static final class BufferingStuckDetectorInternal {
        private long baseTimeMs;
        private long bufferingTimeMaxThresholdMs;
        private long bufferingTimeMinThresholdMs;
        private long detectorRangeMs;
        private boolean isBuffering;
        private long maxBufferingCount;
        private long maxBufferingDurationMs;
        private int totalBufferingCount;
        private int totalBufferingDurationMs;
        private Deque<BufferingItem> bufferingItems = new ArrayDeque();
        private BufferingItem curBufferingItem = new BufferingItem();

        /* JADX INFO: compiled from: SearchBox */
        public static final class BufferingItem {
            public long durationMs;
            public long endMs;
            public long renderMs;
            public long startMs;

            public BufferingItem() {
                this(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE);
            }

            public void reset() {
                this.startMs = Long.MAX_VALUE;
                this.endMs = Long.MAX_VALUE;
                this.durationMs = Long.MAX_VALUE;
                this.renderMs = Long.MAX_VALUE;
            }

            public BufferingItem(long j, long j2, long j3, long j4) {
                this.startMs = j;
                this.endMs = j2;
                this.durationMs = j3;
                this.renderMs = j4;
            }
        }

        public BufferingStuckDetectorInternal(long j, long j2, long j3, long j4, long j5) {
            this.detectorRangeMs = j;
            this.maxBufferingCount = j2;
            this.maxBufferingDurationMs = j3;
            this.bufferingTimeMaxThresholdMs = j4;
            this.bufferingTimeMinThresholdMs = j5;
            resetInternal(true);
        }

        private BufferingStuckResult detectInternal(long j) {
            BufferingItem bufferingItem;
            if (j <= this.baseTimeMs) {
                return null;
            }
            if (this.bufferingItems.isEmpty()) {
                bufferingItem = null;
            } else {
                bufferingItem = null;
                for (BufferingItem bufferingItem2 : this.bufferingItems) {
                    if (bufferingItem2 != null && (bufferingItem == null || bufferingItem.durationMs < bufferingItem2.durationMs)) {
                        bufferingItem = bufferingItem2;
                    }
                }
            }
            if (this.isBuffering) {
                BufferingItem bufferingItem3 = this.curBufferingItem;
                bufferingItem3.endMs = j;
                long j2 = j - bufferingItem3.startMs;
                bufferingItem3.durationMs = j2;
                if (((long) this.totalBufferingDurationMs) + j2 > this.maxBufferingDurationMs) {
                    return BufferingStuckResult.createResult(2, (this.bufferingItems.isEmpty() ? this.curBufferingItem : this.bufferingItems.getFirst()).renderMs, ((long) this.totalBufferingDurationMs) + this.curBufferingItem.durationMs);
                }
                if (this.totalBufferingCount + 1 > this.maxBufferingCount) {
                    return BufferingStuckResult.createResult(1, (this.bufferingItems.isEmpty() ? this.curBufferingItem : this.bufferingItems.getFirst()).renderMs, ((long) this.totalBufferingDurationMs) + this.curBufferingItem.durationMs);
                }
            } else if (!this.bufferingItems.isEmpty() && bufferingItem != null) {
                long j3 = bufferingItem.durationMs;
                if (j3 > this.bufferingTimeMaxThresholdMs) {
                    return BufferingStuckResult.createResult(4, bufferingItem.renderMs, j3);
                }
                if (j3 > this.bufferingTimeMinThresholdMs) {
                    return BufferingStuckResult.createResult(3, bufferingItem.renderMs, j3);
                }
                if (this.totalBufferingDurationMs > this.maxBufferingDurationMs) {
                    return BufferingStuckResult.createResult(2, this.bufferingItems.getFirst().renderMs, this.totalBufferingDurationMs);
                }
                if (this.totalBufferingCount > this.maxBufferingCount) {
                    return BufferingStuckResult.createResult(1, this.bufferingItems.getFirst().renderMs, this.totalBufferingDurationMs);
                }
            }
            return null;
        }

        private void evictBufferingItems(long j) {
            Iterator<BufferingItem> it = this.bufferingItems.iterator();
            while (it.hasNext()) {
                BufferingItem next = it.next();
                if (next != null) {
                    if (next.endMs <= j) {
                        this.totalBufferingCount--;
                        this.totalBufferingDurationMs = (int) (((long) this.totalBufferingDurationMs) - next.durationMs);
                        it.remove();
                    } else {
                        long j2 = next.startMs;
                        if (j2 < j) {
                            long j3 = j - j2;
                            next.startMs = j;
                            next.durationMs -= j3;
                            this.totalBufferingDurationMs = (int) (((long) this.totalBufferingDurationMs) - j3);
                        }
                    }
                }
            }
            if (this.isBuffering) {
                BufferingItem bufferingItem = this.curBufferingItem;
                if (bufferingItem.startMs < j) {
                    bufferingItem.startMs = j;
                }
            }
        }

        private void resetInternal(boolean z) {
            if (z) {
                this.isBuffering = false;
                this.curBufferingItem.reset();
            }
            this.baseTimeMs = Long.MAX_VALUE;
            this.totalBufferingCount = 0;
            this.totalBufferingDurationMs = 0;
            this.bufferingItems.clear();
        }

        public BufferingStuckResult detect(long j) {
            BufferingStuckResult bufferingStuckResultDetectInternal = detectInternal(j);
            if (bufferingStuckResultDetectInternal != null) {
                Log.d(BufferingStuckDetector.TAG, "detect result:" + bufferingStuckResultDetectInternal);
                resetInternal(false);
                this.baseTimeMs = j + this.detectorRangeMs;
            }
            return bufferingStuckResultDetectInternal;
        }

        public BufferingStuckResult endBuffering(long j) {
            Log.d(BufferingStuckDetector.TAG, "endBuffering timeMs:" + j);
            if (!this.isBuffering) {
                return null;
            }
            BufferingItem bufferingItem = this.curBufferingItem;
            bufferingItem.endMs = j;
            long j2 = bufferingItem.startMs;
            long j3 = j - j2;
            bufferingItem.durationMs = j3;
            this.bufferingItems.add(new BufferingItem(j2, j, j3, bufferingItem.renderMs));
            this.totalBufferingCount++;
            long j4 = this.totalBufferingDurationMs;
            BufferingItem bufferingItem2 = this.curBufferingItem;
            this.totalBufferingDurationMs = (int) (j4 + bufferingItem2.durationMs);
            bufferingItem2.reset();
            this.isBuffering = false;
            evictBufferingItems(Math.max(j - this.detectorRangeMs, this.baseTimeMs));
            BufferingStuckResult bufferingStuckResultDetectInternal = detectInternal(j);
            if (bufferingStuckResultDetectInternal != null) {
                Log.d(BufferingStuckDetector.TAG, "endBuffering result:" + bufferingStuckResultDetectInternal);
                resetInternal(false);
                this.baseTimeMs = j + this.detectorRangeMs;
            }
            return bufferingStuckResultDetectInternal;
        }

        public void reset() {
            resetInternal(true);
        }

        public void startBuffering(long j, long j2) {
            Log.d(BufferingStuckDetector.TAG, "startBuffering timeMs:" + j + ", renderTimeMs:" + j2);
            if (this.isBuffering) {
                return;
            }
            if (this.baseTimeMs == Long.MAX_VALUE) {
                this.baseTimeMs = j;
            }
            this.isBuffering = true;
            BufferingItem bufferingItem = this.curBufferingItem;
            bufferingItem.startMs = j;
            bufferingItem.renderMs = j2;
        }
    }

    public BufferingStuckDetector() {
        this(10);
    }

    private boolean shouldDetect(long j) {
        return this.isStarted && this.totalStuckCount < this.maxStuckCount && j > this.startTimeMs;
    }

    public BufferingStuckResult detectStuck() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!shouldDetect(jElapsedRealtime)) {
            return null;
        }
        BufferingStuckResult bufferingStuckResultDetect = this.detectorInternal.detect(jElapsedRealtime);
        if (bufferingStuckResultDetect == null) {
            return bufferingStuckResultDetect;
        }
        this.totalStuckCount++;
        return bufferingStuckResultDetect;
    }

    public void enable(boolean z) {
        this.isEnabled = z;
    }

    public BufferingStuckResult endBuffering() {
        Log.d(TAG, "endBuffering");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        BufferingStuckResult bufferingStuckResultEndBuffering = this.detectorInternal.endBuffering(jElapsedRealtime);
        if (shouldDetect(jElapsedRealtime)) {
            return bufferingStuckResultEndBuffering;
        }
        return null;
    }

    public void endDetector() {
        Log.d(TAG, "endDetector");
        if (!this.isStarted) {
            Log.d(TAG, "not in started status, can't end detector");
        } else {
            this.detectorInternal.reset();
            this.isStarted = false;
        }
    }

    public void reset() {
        this.isStarted = false;
        this.totalStuckCount = 0;
    }

    public void startBuffering(long j) {
        Log.d(TAG, "startBuffering renderTimeMs:" + j);
        this.detectorInternal.startBuffering(SystemClock.elapsedRealtime(), j);
    }

    public void startDetector() {
        Log.d(TAG, "startDetector isEnabled:" + this.isEnabled);
        if (!this.isEnabled || this.isStarted || this.totalStuckCount >= this.maxStuckCount) {
            Log.d(TAG, "can't start detector");
            return;
        }
        this.isStarted = true;
        this.startTimeMs = SystemClock.elapsedRealtime();
        this.detectorInternal.reset();
    }

    public BufferingStuckDetector(int i) {
        this.maxStuckCount = i <= 0 ? 10 : i;
        this.totalStuckCount = 0;
        this.detectorInternal = new BufferingStuckDetectorInternal(60000L, 10L, 10000L, 10000L, 1000L);
        this.isEnabled = false;
        this.isStarted = false;
    }
}
