package com.oplus.tbl.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.Util;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class VideoFrameReleaseOldHelper {
    private static final double DEFAULT_DISPLAY_REFRESH_RATE = -1.0d;
    private static final float DEFAULT_PLAYBACK_SPEED_RATE = 1.0f;
    private static final long MAX_ALLOWED_ADJUSTMENT_NS = 20000000;
    private static final float MAX_INTERVAL_FPS = 1.0f;
    private static final int MINIMUM_FRAMES_WITHOUT_SYNC_TO_CLEAR_SURFACE_FRAME_RATE = 30;
    private static final long MINIMUM_MATCHING_FRAME_DURATION_FOR_HIGH_CONFIDENCE_NS = 5000000000L;
    private static final float MINIMUM_MEDIA_FRAME_RATE_CHANGE_FOR_UPDATE_HIGH_CONFIDENCE = 0.02f;
    private static final float MINIMUM_MEDIA_FRAME_RATE_CHANGE_FOR_UPDATE_LOW_CONFIDENCE = 1.0f;
    private static final String TAG = "VideoFrameReleaseOldHelper";
    private static final long VSYNC_OFFSET_PERCENTAGE = 80;
    private static final long VSYNC_SAMPLE_UPDATE_PERIOD_MS = 500;
    private double currentDisplayRefreshRate;

    @Nullable
    private final DefaultDisplayListener displayListener;
    private float formatFrameRate;
    private long frameIndex;
    private final FixedFrameRateEstimator frameRateEstimator = new FixedFrameRateEstimator();
    private long lastAdjustedFrameIndex;
    private long lastAdjustedReleaseTimeNs;
    private long lastSnappedTimeNs;
    private long pendingLastAdjustedFrameIndex;
    private long pendingLastAdjustedReleaseTimeNs;
    private long pendingLastSnappedTimeNs;
    private float playbackSpeed;
    private boolean started;

    @Nullable
    private Surface surface;
    private float surfaceMediaFrameRate;
    private float surfacePlaybackFrameRate;
    private long vsyncDurationNs;
    private long vsyncOffsetNs;

    @Nullable
    private final VSyncSampler vsyncSampler;

    @Nullable
    private final WindowManager windowManager;

    /* JADX INFO: compiled from: SearchBox */
    public static final class VSyncSampler implements Handler.Callback, Choreographer.FrameCallback {
        private static final int CREATE_CHOREOGRAPHER = 0;
        private static final VSyncSampler INSTANCE = new VSyncSampler();
        private static final int MSG_ADD_OBSERVER = 1;
        private static final int MSG_REMOVE_OBSERVER = 2;
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread;
        private final Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs = -9223372036854775807L;

        private VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.choreographerOwnerThread = handlerThread;
            handlerThread.start();
            Handler handlerCreateHandler = Util.createHandler(handlerThread.getLooper(), this);
            this.handler = handlerCreateHandler;
            handlerCreateHandler.sendEmptyMessage(0);
        }

        private void addObserverInternal() {
            int i = this.observerCount + 1;
            this.observerCount = i;
            if (i == 1) {
                ((Choreographer) Assertions.checkNotNull(this.choreographer)).postFrameCallback(this);
            }
        }

        private void createChoreographerInstanceInternal() {
            this.choreographer = Choreographer.getInstance();
        }

        public static VSyncSampler getInstance() {
            return INSTANCE;
        }

        private void removeObserverInternal() {
            int i = this.observerCount - 1;
            this.observerCount = i;
            if (i == 0) {
                ((Choreographer) Assertions.checkNotNull(this.choreographer)).removeFrameCallback(this);
                this.sampledVsyncTimeNs = -9223372036854775807L;
            }
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.sampledVsyncTimeNs = j;
            ((Choreographer) Assertions.checkNotNull(this.choreographer)).postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                createChoreographerInstanceInternal();
                return true;
            }
            if (i == 1) {
                addObserverInternal();
                return true;
            }
            if (i != 2) {
                return false;
            }
            removeObserverInternal();
            return true;
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }
    }

    public VideoFrameReleaseOldHelper(@Nullable Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            this.windowManager = (WindowManager) context.getSystemService("window");
        } else {
            this.windowManager = null;
        }
        if (this.windowManager != null) {
            this.displayListener = Util.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17((Context) Assertions.checkNotNull(context)) : null;
            this.vsyncSampler = VSyncSampler.getInstance();
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = -9223372036854775807L;
        this.vsyncOffsetNs = -9223372036854775807L;
        this.currentDisplayRefreshRate = DEFAULT_DISPLAY_REFRESH_RATE;
        this.formatFrameRate = -1.0f;
        this.playbackSpeed = 1.0f;
    }

    private static boolean adjustmentAllowed(long j, long j2) {
        return Math.abs(j - j2) <= MAX_ALLOWED_ADJUSTMENT_NS;
    }

    private void clearSurfaceFrameRate() {
        Surface surface;
        if (Util.SDK_INT < 30 || (surface = this.surface) == null || this.surfacePlaybackFrameRate == 0.0f) {
            return;
        }
        this.surfacePlaybackFrameRate = 0.0f;
        setSurfaceFrameRateV30(surface, 0.0f);
    }

    private static long closestVsync(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j5 = j3 + j5;
            j4 = j5;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    private boolean deviceNeedsReadjustSnappedTimeNsWorkaround() {
        String str = Util.MODEL;
        str.hashCode();
        switch (str) {
            case "PHY110":
            case "PHZ110":
            case "PJF110":
            case "PKB110":
            case "CPH2625":
            case "CPH2651":
            case "RMX3851":
            case "RMX3920":
            case "RMX3921":
            case "RMX3987":
            case "RMX3988":
            case "RMX3989":
            case "RMX3990":
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        if (r4 == (r12 * 2)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
    
        r19 = r29 - r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a4, code lost:
    
        if ((r12 * 2.5d) < r4) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long doReadjustSnappedTimeNsWorkaround(long j, long j2, long j3) {
        long jClosestVsync;
        long j4;
        long jClosestVsync2;
        long j5;
        boolean z = Math.abs(((double) this.formatFrameRate) - this.currentDisplayRefreshRate) <= 1.0d;
        boolean z2 = Math.abs(((double) (this.formatFrameRate * 2.0f)) - this.currentDisplayRefreshRate) <= 1.0d;
        String str = Util.MODEL;
        if (!str.equals("PHY110") && !str.equals("PHZ110") && !str.equals("CPH2625")) {
            jClosestVsync = j;
        } else if (this.playbackSpeed == 1.0f) {
            long j6 = this.lastSnappedTimeNs;
            if (j6 != -1) {
                long j7 = j - j6;
                if (!z) {
                    if (z2) {
                        j4 = this.vsyncDurationNs;
                        double d = j7;
                        if (j4 * 0.5d <= d && d <= j4 * 1.5d) {
                            long j8 = j2 + j4;
                            jClosestVsync = closestVsync(j8, j3, j4);
                            this.pendingLastSnappedTimeNs = jClosestVsync;
                        }
                    }
                    jClosestVsync = j;
                    this.pendingLastSnappedTimeNs = jClosestVsync;
                } else if (j7 == 0) {
                    long j9 = this.vsyncDurationNs;
                    jClosestVsync = closestVsync(j2 + j9, j3, j9);
                    this.pendingLastSnappedTimeNs = jClosestVsync;
                } else {
                    j4 = this.vsyncDurationNs;
                }
            } else {
                jClosestVsync = j;
                this.pendingLastSnappedTimeNs = jClosestVsync;
            }
        }
        if (str.equals("PJF110")) {
            if (this.playbackSpeed == 1.0f) {
                long j10 = this.lastSnappedTimeNs;
                if (j10 != -1) {
                    long j11 = jClosestVsync - j10;
                    if (z) {
                        double d2 = j11;
                        long j12 = this.vsyncDurationNs;
                        if (d2 >= j12 * 2.5d && d2 < j12 * 3.5d) {
                            jClosestVsync = closestVsync(j2 - j12, j3, j12);
                        }
                    }
                }
            }
            this.pendingLastSnappedTimeNs = jClosestVsync;
        }
        if (str.equals("RMX3851")) {
            if (this.playbackSpeed == 1.0f) {
                long j13 = this.lastSnappedTimeNs;
                if (j13 != -1) {
                    long j14 = jClosestVsync - j13;
                    if (z2) {
                        long j15 = this.vsyncDurationNs;
                        double d3 = j14;
                        if (j15 * 0.5d <= d3 && d3 <= j15 * 1.5d) {
                            j5 = j2 + j15;
                        } else if (j15 * 2.5d <= d3 && d3 < j15 * 10.5d) {
                            j5 = j2 - (((long) (((int) ((d3 - (j15 * 2.5d)) / j15)) + 1)) * j15);
                        }
                        jClosestVsync = closestVsync(j5, j3, j15);
                    }
                }
            }
            this.pendingLastSnappedTimeNs = jClosestVsync;
        }
        if (str.equals("RMX3987") || str.equals("RMX3988") || str.equals("RMX3989") || str.equals("RMX3990") || str.equals("RMX3920") || str.equals("RMX3921") || str.equals("CPH2651") || str.equals("PKB110")) {
            if (this.playbackSpeed == 1.0f) {
                long j16 = this.lastSnappedTimeNs;
                if (j16 != -1) {
                    long j17 = jClosestVsync - j16;
                    if (z) {
                        if (j17 == 0) {
                            long j18 = this.vsyncDurationNs;
                            jClosestVsync2 = closestVsync(j2 + j18, j3, j18);
                        } else {
                            long j19 = this.vsyncDurationNs;
                            if (j17 == 2 * j19) {
                                jClosestVsync2 = closestVsync(j2 - j19, j3, j19);
                            }
                        }
                        jClosestVsync = jClosestVsync2;
                    }
                }
            }
            this.pendingLastSnappedTimeNs = jClosestVsync;
        }
        return jClosestVsync;
    }

    @Nullable
    @RequiresApi(17)
    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new DefaultDisplayListener(displayManager);
    }

    private void resetAdjustment() {
        this.frameIndex = 0L;
        this.lastAdjustedFrameIndex = -1L;
        this.pendingLastAdjustedFrameIndex = -1L;
        this.lastSnappedTimeNs = -1L;
        this.pendingLastSnappedTimeNs = -1L;
    }

    @RequiresApi(30)
    private static void setSurfaceFrameRateV30(Surface surface, float f) {
        try {
            surface.setFrameRate(f, f == 0.0f ? 0 : 1);
        } catch (IllegalStateException e) {
            Log.e(TAG, "Failed to call Surface.setFrameRate", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams() {
        double refreshRate;
        Display defaultDisplay = ((WindowManager) Assertions.checkNotNull(this.windowManager)).getDefaultDisplay();
        if (defaultDisplay != null) {
            refreshRate = defaultDisplay.getRefreshRate();
            long j = (long) (1.0E9d / refreshRate);
            this.vsyncDurationNs = j;
            this.vsyncOffsetNs = (j * VSYNC_OFFSET_PERCENTAGE) / 100;
        } else {
            Log.w(TAG, "Unable to query display refresh rate");
            this.vsyncDurationNs = -9223372036854775807L;
            this.vsyncOffsetNs = -9223372036854775807L;
            refreshRate = DEFAULT_DISPLAY_REFRESH_RATE;
        }
        this.currentDisplayRefreshRate = refreshRate;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateSurfaceMediaFrameRate() {
        if (Util.SDK_INT < 30 || this.surface == null) {
            return;
        }
        float frameRate = this.frameRateEstimator.isSynced() ? this.frameRateEstimator.getFrameRate() : this.formatFrameRate;
        float f = this.surfaceMediaFrameRate;
        if (frameRate == f) {
            return;
        }
        boolean z = true;
        if (frameRate != -1.0f && f != -1.0f) {
            if (Math.abs(frameRate - this.surfaceMediaFrameRate) < (this.frameRateEstimator.isSynced() && (this.frameRateEstimator.getMatchingFrameDurationSumNs() > MINIMUM_MATCHING_FRAME_DURATION_FOR_HIGH_CONFIDENCE_NS ? 1 : (this.frameRateEstimator.getMatchingFrameDurationSumNs() == MINIMUM_MATCHING_FRAME_DURATION_FOR_HIGH_CONFIDENCE_NS ? 0 : -1)) >= 0 ? MINIMUM_MEDIA_FRAME_RATE_CHANGE_FOR_UPDATE_HIGH_CONFIDENCE : 1.0f)) {
            }
        } else if (frameRate == -1.0f && this.frameRateEstimator.getFramesWithoutSyncCount() < 30) {
            z = false;
        }
        if (z) {
            this.surfaceMediaFrameRate = frameRate;
            updateSurfacePlaybackFrameRate(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateSurfacePlaybackFrameRate(boolean z) {
        Surface surface;
        float f;
        if (Util.SDK_INT < 30 || (surface = this.surface) == null) {
            return;
        }
        if (this.started) {
            float f2 = this.surfaceMediaFrameRate;
            f = f2 != -1.0f ? f2 * this.playbackSpeed : 0.0f;
        }
        if (z || this.surfacePlaybackFrameRate != f) {
            this.surfacePlaybackFrameRate = f;
            setSurfaceFrameRateV30(surface, f);
        }
    }

    public long adjustReleaseTime(long j) {
        if (this.lastAdjustedFrameIndex != -1 && this.frameRateEstimator.isSynced()) {
            long frameDurationNs = this.lastAdjustedReleaseTimeNs + ((long) ((this.frameRateEstimator.getFrameDurationNs() * (this.frameIndex - this.lastAdjustedFrameIndex)) / this.playbackSpeed));
            if (adjustmentAllowed(j, frameDurationNs)) {
                j = frameDurationNs;
            } else {
                resetAdjustment();
            }
        }
        this.pendingLastAdjustedFrameIndex = this.frameIndex;
        this.pendingLastAdjustedReleaseTimeNs = j;
        VSyncSampler vSyncSampler = this.vsyncSampler;
        if (vSyncSampler == null || this.vsyncDurationNs == -9223372036854775807L) {
            return j;
        }
        long j2 = vSyncSampler.sampledVsyncTimeNs;
        if (j2 == -9223372036854775807L) {
            return j;
        }
        long jClosestVsync = closestVsync(j, j2, this.vsyncDurationNs);
        if (deviceNeedsReadjustSnappedTimeNsWorkaround()) {
            jClosestVsync = doReadjustSnappedTimeNsWorkaround(jClosestVsync, j, j2);
        }
        return jClosestVsync - this.vsyncOffsetNs;
    }

    @TargetApi(17)
    public void onDisabled() {
        if (this.windowManager != null) {
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.unregister();
            }
            ((VSyncSampler) Assertions.checkNotNull(this.vsyncSampler)).removeObserver();
        }
    }

    @TargetApi(17)
    public void onEnabled() {
        if (this.windowManager != null) {
            ((VSyncSampler) Assertions.checkNotNull(this.vsyncSampler)).addObserver();
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.register();
            }
            updateDefaultDisplayRefreshRateParams();
        }
    }

    public void onFormatChanged(float f) {
        this.formatFrameRate = f;
        this.frameRateEstimator.reset();
        updateSurfaceMediaFrameRate();
    }

    public void onNextFrame(long j) {
        long j2 = this.pendingLastAdjustedFrameIndex;
        if (j2 != -1) {
            this.lastAdjustedFrameIndex = j2;
            this.lastAdjustedReleaseTimeNs = this.pendingLastAdjustedReleaseTimeNs;
            this.lastSnappedTimeNs = this.pendingLastSnappedTimeNs;
        }
        this.frameIndex++;
        this.frameRateEstimator.onNextFrame(j * 1000);
        updateSurfaceMediaFrameRate();
    }

    public void onPlaybackSpeed(float f) {
        this.playbackSpeed = f;
        resetAdjustment();
        updateSurfacePlaybackFrameRate(false);
    }

    public void onPositionReset() {
        resetAdjustment();
    }

    public void onStarted() {
        this.started = true;
        resetAdjustment();
        updateSurfacePlaybackFrameRate(false);
    }

    public void onStopped() {
        this.started = false;
        clearSurfaceFrameRate();
    }

    public void onSurfaceChanged(@Nullable Surface surface) {
        if (surface instanceof DummySurface) {
            surface = null;
        }
        if (this.surface == surface) {
            return;
        }
        clearSurfaceFrameRate();
        this.surface = surface;
        updateSurfacePlaybackFrameRate(true);
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(17)
    public final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManager displayManager;

        public DefaultDisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                VideoFrameReleaseOldHelper.this.updateDefaultDisplayRefreshRateParams();
            }
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, Util.createHandlerForCurrentLooper());
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }
}
