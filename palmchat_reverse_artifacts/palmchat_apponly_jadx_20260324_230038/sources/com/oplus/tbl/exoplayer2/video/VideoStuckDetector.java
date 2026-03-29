package com.oplus.tbl.exoplayer2.video;

import android.os.SystemClock;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class VideoStuckDetector {
    private static final float DEFAULT_DECODER_OUTPUT_RATIO_FOR_SMOOTH_PLAY = 0.9f;
    private static final int DEFAULT_DECODER_STUCK_DETECT_OFFSET_MS = 10000;
    private static final int DEFAULT_DETECTOR_DELAY_MS = 5000;
    private static final int DEFAULT_DETECTOR_RANGE_MS = 120000;
    private static final int DEFAULT_DETECTOR_REPORT_FPS_OFFSET_MS = 2000;
    private static final int DEFAULT_DETECTOR_STUCK_COUNT = 10;
    private static final float DEFAULT_FPS_FOR_SMOOTH_PLAY = 10.0f;
    private static final int DEFAULT_INPUT_DETECTOR_RANGE_MS = 120000;
    private static final int DEFAULT_INPUT_QUEUE_SIZE = 5;
    private static final float DEFAULT_INPUT_RATIO_FOR_SMOOTH_PLAY = 0.6f;
    private static final int DEFAULT_INPUT_STEP_MS = 1000;
    private static final int DEFAULT_INPUT_STUCK_DETECT_OFFSET_MS = 10000;
    private static final int DEFAULT_RENDER_DROP_TO_KEY_FRAME_COUNT = 10;
    private static final int DEFAULT_RENDER_QUEUE_SIZE = 201;
    private static final int DEFAULT_RENDER_STUCK_DETECT_OFFSET_MS = 10000;
    private static final int MILLI_SECS_PER_SEC = 1000;
    private static final String TAG = "VideoStuckDetector";
    private int decoderType;
    private int dropCount;
    VideoRendererEventListener.EventDispatcher eventDispatcher;
    private float frameRate;
    private int inputCount;
    private boolean isEnabled;
    private boolean isStarted;
    private int outputCount;
    private int renderCount;
    private int skipCount;
    private long nextStuckBaseTimeMs = Long.MAX_VALUE;
    private long detectorRangeMs = 120000;
    private int totalStuckCount = 0;
    private int maxVideoStuckCount = 10;
    private int startDetectorDelayMs = 5000;
    private long baseTimeMs = Long.MAX_VALUE;
    private long renderPositionMs = Long.MAX_VALUE;
    List<IStuckDetector> detectorList = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class DecoderStuckDetector implements IStuckDetector {
        private static final String TAG = "DecoderStuckDetector";
        private long baseTimeMs;
        private int inputFrames;
        private int outputFrames;
        private float rateForSmoothPlay;
        private int stuckDetectOffsetMs;

        public DecoderStuckDetector(int i, float f) {
            this.stuckDetectOffsetMs = i <= 0 ? 10000 : i;
            this.rateForSmoothPlay = f <= 0.0f ? VideoStuckDetector.DEFAULT_DECODER_OUTPUT_RATIO_FOR_SMOOTH_PLAY : f;
            this.baseTimeMs = Long.MAX_VALUE;
            resetInternal();
        }

        private void resetInternal() {
            this.inputFrames = 0;
            this.outputFrames = 0;
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public VideoStuckResult detectStuck(long j) {
            int i;
            if (j - this.baseTimeMs < this.stuckDetectOffsetMs || (i = this.inputFrames) <= 0 || this.outputFrames / i >= this.rateForSmoothPlay) {
                return null;
            }
            Log.d(TAG, "detectStuck decoder capability low input:" + this.inputFrames + ", output:" + this.outputFrames);
            return VideoStuckResult.createResult(21, VideoStuckDetector.this.decoderType, VideoStuckDetector.this.renderPositionMs, 0L);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onDroppedOutputBuffer(long j, int i, boolean z) {
            if (j <= this.baseTimeMs) {
                return;
            }
            this.outputFrames += i;
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onQueuedInputBuffer(long j) {
            if (j <= this.baseTimeMs) {
                return;
            }
            this.inputFrames++;
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onRenderedOutputBuffer(long j, long j2) {
            if (j <= this.baseTimeMs) {
                return;
            }
            this.outputFrames++;
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public /* synthetic */ void onSetFrameRate(float f) {
            d.e(this, f);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onSkippedOutputBuffer(long j, int i, boolean z) {
            if (j <= this.baseTimeMs) {
                return;
            }
            this.outputFrames += i;
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void reset(long j) {
            this.baseTimeMs = j;
            resetInternal();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class FrameRateStuckDetector implements IStuckDetector {
        private static final String TAG = "FrameRateStuckDetector";
        private long baseTimeMs;
        private float frameRate;
        private boolean hasFrameRate = false;
        private float minFrameRateForSmoothPlay;

        public FrameRateStuckDetector(float f) {
            this.minFrameRateForSmoothPlay = f <= 0.0f ? 10.0f : f;
            this.baseTimeMs = Long.MAX_VALUE;
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public VideoStuckResult detectStuck(long j) {
            if (j <= this.baseTimeMs || !this.hasFrameRate || this.frameRate >= this.minFrameRateForSmoothPlay) {
                return null;
            }
            return VideoStuckResult.createResult(1, VideoStuckDetector.this.decoderType, VideoStuckDetector.this.renderPositionMs, 0L);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public /* synthetic */ void onDroppedOutputBuffer(long j, int i, boolean z) {
            d.b(this, j, i, z);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public /* synthetic */ void onQueuedInputBuffer(long j) {
            d.c(this, j);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public /* synthetic */ void onRenderedOutputBuffer(long j, long j2) {
            d.d(this, j, j2);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onSetFrameRate(float f) {
            Log.d(TAG, "onSetFrameRate frameRate:" + f);
            if (f > 0.0f) {
                this.hasFrameRate = true;
                this.frameRate = f;
            }
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public /* synthetic */ void onSkippedOutputBuffer(long j, int i, boolean z) {
            d.f(this, j, i, z);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void reset(long j) {
            this.baseTimeMs = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface IStuckDetector {
        VideoStuckResult detectStuck(long j);

        void onDroppedOutputBuffer(long j, int i, boolean z);

        void onQueuedInputBuffer(long j);

        void onRenderedOutputBuffer(long j, long j2);

        void onSetFrameRate(float f);

        void onSkippedOutputBuffer(long j, int i, boolean z);

        void reset(long j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class InputStuckDetector implements IStuckDetector {
        private static final String TAG = "InputStuckDetector";
        private long baseTimeMs;
        private int curInputFrames;
        private int curInputIdx;
        private int detectorRangeMs;
        private float frameRate;
        private Deque<InputItem> inputItems;
        private Deque<InputPtsItem> inputPtsItems;
        private int inputStepMs;
        private int maxInputQueueSize;
        private float rateForSmoothPlay;
        private int stuckDetectOffsetMs;

        /* JADX INFO: compiled from: SearchBox */
        public final class InputItem {
            public long inputMs;
            public long renderMs;

            public InputItem(long j, long j2) {
                this.inputMs = j;
                this.renderMs = j2;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public final class InputPtsItem {
            public float fps;
            public long inputMs;
            public long renderMs;

            public InputPtsItem(long j, float f, long j2) {
                this.inputMs = j;
                this.fps = f;
                this.renderMs = j2;
            }
        }

        public InputStuckDetector(int i, int i2, int i3, int i4, float f) {
            this.inputStepMs = i <= 0 ? 1000 : i;
            this.maxInputQueueSize = i2 <= 0 ? 5 : i2;
            this.detectorRangeMs = i3 <= 0 ? 120000 : i3;
            this.stuckDetectOffsetMs = i4 <= 0 ? 10000 : i4;
            this.rateForSmoothPlay = f <= 0.0f ? VideoStuckDetector.DEFAULT_INPUT_RATIO_FOR_SMOOTH_PLAY : f;
            this.inputItems = new ArrayDeque();
            this.inputPtsItems = new ArrayDeque();
            this.baseTimeMs = Long.MAX_VALUE;
            this.frameRate = 0.0f;
            resetInternal();
        }

        private void evictInputItems(long j) {
            InputItem next;
            Iterator<InputItem> it = this.inputItems.iterator();
            while (it.hasNext() && (next = it.next()) != null && next.inputMs <= j) {
                it.remove();
            }
        }

        private void resetInternal() {
            this.curInputIdx = 0;
            this.curInputFrames = 0;
            this.inputItems.clear();
            this.inputPtsItems.clear();
        }

        private void updateInputFpsItems(long j, boolean z) {
            long j2 = this.baseTimeMs;
            int i = this.curInputIdx;
            int i2 = this.inputStepMs;
            long j3 = ((long) (i * i2)) + j2;
            long j4 = j - j3;
            if (j4 <= 0) {
                Log.d(TAG, "timeMs:" + j + " <= curInputBaseTimeMs:" + j3);
                return;
            }
            if (j4 <= i2) {
                if (z) {
                    this.curInputFrames++;
                    return;
                }
                return;
            }
            int i3 = (int) (j4 / ((long) i2));
            if (j - ((long) (i2 * i3)) == 0) {
                i3--;
            }
            int i4 = i3;
            int iMin = Math.min(i4, this.maxInputQueueSize + 1);
            int i5 = i4 - iMin;
            for (int i6 = 0; i6 < iMin; i6++) {
                this.inputPtsItems.add(new InputPtsItem(j3 + ((long) ((i6 + i5) * this.inputStepMs)), this.curInputFrames, VideoStuckDetector.this.renderPositionMs));
                this.curInputFrames = 0;
                if (this.inputPtsItems.size() > this.maxInputQueueSize) {
                    this.inputPtsItems.removeFirst();
                }
            }
            this.curInputIdx += i4;
            if (z) {
                this.curInputFrames++;
            }
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public VideoStuckResult detectStuck(long j) {
            if (j > this.baseTimeMs + ((long) this.stuckDetectOffsetMs) && this.frameRate > 0.0f) {
                evictInputItems(j - ((long) this.detectorRangeMs));
                int i = 0;
                updateInputFpsItems(j, false);
                long jMin = Math.min(j - this.baseTimeMs, this.detectorRangeMs);
                long size = ((long) (this.inputItems.size() * 1000)) / jMin;
                float f = this.rateForSmoothPlay * this.frameRate;
                if (size < f) {
                    Log.d(TAG, "detectStuck average input fps low averageInputFps:" + size + ", minInputRatio:" + f);
                    Log.d(TAG, "detectStuck size:" + this.inputItems.size() + ", timeDurationMs:" + jMin);
                    return VideoStuckResult.createResult(11, VideoStuckDetector.this.decoderType, this.inputItems.isEmpty() ? VideoStuckDetector.this.renderPositionMs : this.inputItems.getFirst().renderMs, jMin);
                }
                if (this.inputPtsItems.size() < this.maxInputQueueSize) {
                    return null;
                }
                for (InputPtsItem inputPtsItem : this.inputPtsItems) {
                    if (inputPtsItem != null && inputPtsItem.fps < f) {
                        i++;
                    }
                }
                if (i > this.maxInputQueueSize * this.rateForSmoothPlay) {
                    Log.d(TAG, "detectStuck queue input fps low");
                    return VideoStuckResult.createResult(12, VideoStuckDetector.this.decoderType, this.inputPtsItems.getFirst().renderMs, this.maxInputQueueSize * 1000);
                }
            }
            return null;
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public /* synthetic */ void onDroppedOutputBuffer(long j, int i, boolean z) {
            d.b(this, j, i, z);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onQueuedInputBuffer(long j) {
            if (j <= this.baseTimeMs) {
                return;
            }
            this.inputItems.add(new InputItem(j, VideoStuckDetector.this.renderPositionMs));
            evictInputItems(j - ((long) this.detectorRangeMs));
            updateInputFpsItems(j, true);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public /* synthetic */ void onRenderedOutputBuffer(long j, long j2) {
            d.d(this, j, j2);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onSetFrameRate(float f) {
            Log.d(TAG, "onSetFrameRate frameRate:" + f);
            if (f > 0.0f) {
                this.frameRate = f;
            }
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public /* synthetic */ void onSkippedOutputBuffer(long j, int i, boolean z) {
            d.f(this, j, i, z);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void reset(long j) {
            this.baseTimeMs = j;
            resetInternal();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class RenderStuckDetector implements IStuckDetector {
        private static final int DEFAULT_30_FPS_FRAME_DURATION_MS = 33;
        private static final float DEFAULT_DIFF_INVALID_RATIO = 0.33f;
        private static final String TAG = "RenderStuckDetector";
        private long baseTimeMs;
        private int dropToKeyFrameCount;
        private float frameRate;
        private int maxDropToKeyFrameCount;
        private int maxFramesDropToKeyFrame;
        private Deque<RenderItem> renderItems;
        private int renderQueueSize;
        private long renderedFrames;
        private int stuckDetectOffsetMs;
        private long totalRenderPtsDiff;
        private long totalRenderTimeDiff;

        /* JADX INFO: compiled from: SearchBox */
        public class RenderItem {
            public long ptsMs;
            public long renderMs;
            public long timeMs;

            public RenderItem(long j, long j2, long j3) {
                this.timeMs = j;
                this.ptsMs = j2;
                this.renderMs = j3;
            }
        }

        public RenderStuckDetector(int i, int i2, int i3) {
            this.maxDropToKeyFrameCount = i <= 0 ? 10 : i;
            this.renderQueueSize = i2 <= 0 ? 201 : i2;
            this.stuckDetectOffsetMs = i3 <= 0 ? 10000 : i3;
            this.baseTimeMs = Long.MAX_VALUE;
            this.frameRate = 0.0f;
            this.renderItems = new ArrayDeque();
            resetInternal();
        }

        private boolean isRenderPtsEven() {
            int size = this.renderItems.size();
            int i = this.renderQueueSize;
            if (size < i) {
                return true;
            }
            long j = this.totalRenderPtsDiff / ((long) (i - 1));
            if (j > 33) {
                Iterator<RenderItem> it = this.renderItems.iterator();
                RenderItem next = it.next();
                int i2 = 0;
                while (it.hasNext()) {
                    RenderItem next2 = it.next();
                    if (next2.ptsMs - next.ptsMs > 2 * j) {
                        i2++;
                    }
                    next = next2;
                }
                if (i2 > this.renderQueueSize * DEFAULT_DIFF_INVALID_RATIO) {
                    return false;
                }
            }
            return true;
        }

        private boolean isRenderTimeEven() {
            int size = this.renderItems.size();
            int i = this.renderQueueSize;
            if (size < i) {
                return true;
            }
            long j = this.totalRenderTimeDiff / ((long) (i - 1));
            if (j > 33) {
                Iterator<RenderItem> it = this.renderItems.iterator();
                RenderItem next = it.next();
                int i2 = 0;
                while (it.hasNext()) {
                    RenderItem next2 = it.next();
                    if (next2.timeMs - next.timeMs > 2 * j) {
                        i2++;
                    }
                    next = next2;
                }
                if (i2 > this.renderQueueSize * DEFAULT_DIFF_INVALID_RATIO) {
                    return false;
                }
            }
            return true;
        }

        private void resetInternal() {
            this.renderedFrames = 0L;
            this.dropToKeyFrameCount = 0;
            this.maxFramesDropToKeyFrame = 0;
            this.renderItems.clear();
            this.totalRenderTimeDiff = 0L;
            this.totalRenderPtsDiff = 0L;
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public VideoStuckResult detectStuck(long j) {
            if (j > ((long) this.stuckDetectOffsetMs) + this.baseTimeMs) {
                float f = this.frameRate;
                if (f >= 0.0f) {
                    if (this.dropToKeyFrameCount > this.maxDropToKeyFrameCount) {
                        return VideoStuckResult.createResult(32, VideoStuckDetector.this.decoderType, VideoStuckDetector.this.renderPositionMs, 0L);
                    }
                    if (this.maxFramesDropToKeyFrame > f) {
                        return VideoStuckResult.createResult(33, VideoStuckDetector.this.decoderType, VideoStuckDetector.this.renderPositionMs, 0L);
                    }
                    if ((this.renderedFrames * 1000) / (j - r0) < 10.0f) {
                        return VideoStuckResult.createResult(31, VideoStuckDetector.this.decoderType, VideoStuckDetector.this.renderPositionMs, 0L);
                    }
                    if (!isRenderPtsEven()) {
                        return VideoStuckResult.createResult(35, VideoStuckDetector.this.decoderType, this.renderItems.getFirst().renderMs, j - this.renderItems.getFirst().timeMs);
                    }
                    if (!isRenderTimeEven()) {
                        return VideoStuckResult.createResult(34, VideoStuckDetector.this.decoderType, this.renderItems.getFirst().renderMs, j - this.renderItems.getFirst().timeMs);
                    }
                }
            }
            return null;
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onDroppedOutputBuffer(long j, int i, boolean z) {
            if (j <= this.baseTimeMs || !z) {
                return;
            }
            this.dropToKeyFrameCount++;
            this.maxFramesDropToKeyFrame = Math.max(i, this.maxFramesDropToKeyFrame);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public /* synthetic */ void onQueuedInputBuffer(long j) {
            d.c(this, j);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onRenderedOutputBuffer(long j, long j2) {
            if (j <= this.baseTimeMs) {
                return;
            }
            this.renderedFrames++;
            if (!this.renderItems.isEmpty()) {
                this.totalRenderPtsDiff += j2 - this.renderItems.getLast().ptsMs;
                this.totalRenderTimeDiff += j - this.renderItems.getLast().timeMs;
            }
            this.renderItems.add(new RenderItem(j, j2, VideoStuckDetector.this.renderPositionMs));
            if (this.renderItems.size() > this.renderQueueSize) {
                RenderItem renderItemPoll = this.renderItems.poll();
                this.totalRenderPtsDiff += renderItemPoll.ptsMs - this.renderItems.getFirst().ptsMs;
                this.totalRenderTimeDiff += renderItemPoll.timeMs - this.renderItems.getFirst().timeMs;
            }
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onSetFrameRate(float f) {
            if (f > 0.0f) {
                this.frameRate = f;
            }
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void onSkippedOutputBuffer(long j, int i, boolean z) {
            if (j <= this.baseTimeMs || !z) {
                return;
            }
            this.dropToKeyFrameCount++;
            this.maxFramesDropToKeyFrame = Math.max(i, this.maxFramesDropToKeyFrame);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoStuckDetector.IStuckDetector
        public void reset(long j) {
            this.baseTimeMs = j;
            resetInternal();
        }
    }

    public VideoStuckDetector(int i) {
        this.decoderType = i;
        initializeDetectors();
        this.frameRate = 0.0f;
        this.inputCount = 0;
        this.outputCount = 0;
        this.renderCount = 0;
        this.skipCount = 0;
        this.dropCount = 0;
        this.isEnabled = false;
        this.isStarted = false;
        this.eventDispatcher = null;
    }

    private boolean canStart() {
        Log.d(TAG, "isEnabled:" + this.isEnabled);
        return this.isEnabled && !this.isStarted && this.totalStuckCount < this.maxVideoStuckCount;
    }

    private void initializeDetectors() {
        this.detectorList.add(new FrameRateStuckDetector(10.0f));
        this.detectorList.add(new InputStuckDetector(1000, 5, 120000, 10000, DEFAULT_INPUT_RATIO_FOR_SMOOTH_PLAY));
        this.detectorList.add(new DecoderStuckDetector(10000, DEFAULT_DECODER_OUTPUT_RATIO_FOR_SMOOTH_PLAY));
        this.detectorList.add(new RenderStuckDetector(10, 201, 10000));
    }

    private boolean isTimeValid(long j, long j2) {
        return j > j2;
    }

    private void maybeNotifyStuck(long j) {
        IStuckDetector iStuckDetector;
        VideoStuckResult videoStuckResultDetectStuck = null;
        for (int i = 0; i < this.detectorList.size() && shouldNotifyStuck(j) && ((iStuckDetector = this.detectorList.get(i)) == null || (videoStuckResultDetectStuck = iStuckDetector.detectStuck(j)) == null); i++) {
        }
        if (videoStuckResultDetectStuck != null) {
            notifyStuck(videoStuckResultDetectStuck, j);
        }
    }

    private void notifyStuck(VideoStuckResult videoStuckResult, long j) {
        if (videoStuckResult == null) {
            Log.d(TAG, "notifyStuck result is null");
            return;
        }
        this.totalStuckCount++;
        long jElapsedRealtime = SystemClock.elapsedRealtime() + this.detectorRangeMs;
        this.nextStuckBaseTimeMs = jElapsedRealtime;
        resetDetectors(jElapsedRealtime);
        if (this.eventDispatcher != null) {
            long j2 = this.baseTimeMs;
            if (j > 2000 + j2) {
                videoStuckResult.inputFps = (int) (((long) (this.inputCount * 1000)) / (j - j2));
                videoStuckResult.outputFps = (int) (((long) (this.outputCount * 1000)) / (j - j2));
                videoStuckResult.renderFps = (int) (((long) (this.renderCount * 1000)) / (j - j2));
            }
            Log.d(TAG, "notifyStuck result:" + videoStuckResult);
            this.eventDispatcher.onVideoStucked(videoStuckResult);
        }
        if (this.totalStuckCount >= this.maxVideoStuckCount) {
            stopInternal();
        }
    }

    private void resetDetectors(long j) {
        for (int i = 0; i < this.detectorList.size(); i++) {
            IStuckDetector iStuckDetector = this.detectorList.get(i);
            if (iStuckDetector != null) {
                iStuckDetector.reset(j);
            }
        }
    }

    private void resetFrameCounter() {
        this.inputCount = 0;
        this.outputCount = 0;
        this.renderCount = 0;
        this.skipCount = 0;
        this.dropCount = 0;
    }

    private boolean shouldNotifyStuck(long j) {
        return j > this.nextStuckBaseTimeMs && this.totalStuckCount < this.maxVideoStuckCount;
    }

    private void stopInternal() {
        if (this.isStarted) {
            this.isStarted = false;
        }
    }

    public synchronized void detectStuck() {
        if (this.isStarted) {
            maybeNotifyStuck(SystemClock.elapsedRealtime());
        }
    }

    public synchronized void enable(boolean z) {
        this.isEnabled = z;
    }

    public synchronized void initialize(VideoRendererEventListener.EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public synchronized void onDroppedOutputBuffer(int i, boolean z) {
        if (this.isStarted) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (isTimeValid(jElapsedRealtime, this.baseTimeMs)) {
                this.dropCount += i;
                this.outputCount += i;
                for (int i2 = 0; i2 < this.detectorList.size(); i2++) {
                    IStuckDetector iStuckDetector = this.detectorList.get(i2);
                    if (iStuckDetector != null) {
                        iStuckDetector.onDroppedOutputBuffer(jElapsedRealtime, i, z);
                    }
                }
            }
        }
    }

    public synchronized void onQueuedInputBuffer() {
        if (this.isStarted) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (isTimeValid(jElapsedRealtime, this.baseTimeMs)) {
                this.inputCount++;
                for (int i = 0; i < this.detectorList.size(); i++) {
                    IStuckDetector iStuckDetector = this.detectorList.get(i);
                    if (iStuckDetector != null) {
                        iStuckDetector.onQueuedInputBuffer(jElapsedRealtime);
                    }
                }
            }
        }
    }

    public synchronized void onRenderedOutputBuffer(long j) {
        if (this.isStarted) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (isTimeValid(jElapsedRealtime, this.baseTimeMs)) {
                this.renderCount++;
                this.outputCount++;
                for (int i = 0; i < this.detectorList.size(); i++) {
                    IStuckDetector iStuckDetector = this.detectorList.get(i);
                    if (iStuckDetector != null) {
                        iStuckDetector.onRenderedOutputBuffer(jElapsedRealtime, j);
                    }
                }
            }
        }
    }

    public synchronized void onSetFrameRate(float f) {
        Log.d(TAG, "onSetFrameRate frameRate:" + f);
        if (f > 0.0f) {
            this.frameRate = f;
            for (int i = 0; i < this.detectorList.size(); i++) {
                IStuckDetector iStuckDetector = this.detectorList.get(i);
                if (iStuckDetector != null) {
                    iStuckDetector.onSetFrameRate(f);
                }
            }
        }
    }

    public synchronized void onSkippedOutputBuffer(int i, boolean z) {
        if (this.isStarted) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (isTimeValid(jElapsedRealtime, this.baseTimeMs)) {
                this.skipCount += i;
                this.outputCount += i;
                for (int i2 = 0; i2 < this.detectorList.size(); i2++) {
                    IStuckDetector iStuckDetector = this.detectorList.get(i2);
                    if (iStuckDetector != null) {
                        iStuckDetector.onSkippedOutputBuffer(jElapsedRealtime, i, z);
                    }
                }
            }
        }
    }

    public synchronized void reset() {
        this.nextStuckBaseTimeMs = Long.MAX_VALUE;
        this.totalStuckCount = 0;
        resetFrameCounter();
        this.isStarted = false;
    }

    public synchronized void start() {
        if (canStart()) {
            resetFrameCounter();
            long jElapsedRealtime = SystemClock.elapsedRealtime() + ((long) this.startDetectorDelayMs);
            this.baseTimeMs = jElapsedRealtime;
            this.nextStuckBaseTimeMs = jElapsedRealtime;
            Log.d(TAG, "start baseTimeMs:" + this.baseTimeMs + ", nextStuckBaseTimeMs:" + this.nextStuckBaseTimeMs);
            resetDetectors(this.nextStuckBaseTimeMs);
            this.isStarted = true;
        }
    }

    public synchronized void stop() {
        stopInternal();
    }

    public synchronized void updateTime(long j) {
        this.renderPositionMs = j;
    }
}
