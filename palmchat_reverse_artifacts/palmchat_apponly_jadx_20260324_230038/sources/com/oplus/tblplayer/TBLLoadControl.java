package com.oplus.tblplayer;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.LoadControl;
import com.oplus.tbl.exoplayer2.PlayerMessage;
import com.oplus.tbl.exoplayer2.Renderer;
import com.oplus.tbl.exoplayer2.source.TrackGroupArray;
import com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection;
import com.oplus.tbl.exoplayer2.upstream.Allocator;
import com.oplus.tbl.exoplayer2.upstream.DefaultAllocator;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tblplayer.configure.LoadConfig;
import com.oplus.tblplayer.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLLoadControl implements LoadControl, PlayerMessage.Target {
    public static final int MSG_CHANGED_LOAD_CONFIG = 10001;
    public static final int MSG_ENABLE_MINIVIEW_MODE = 10004;
    public static final int MSG_ENABLE_STREAMING_MODE = 10002;
    private String TAG;

    @NonNull
    private final DefaultAllocator allocator;
    private Handler handler;
    private boolean isLoading;
    private boolean isMiniViewEnabled;
    private boolean isStreamingMode;
    private int lastBufferingPercent;
    private EventListener listener;

    @NonNull
    private LoadConfig loadConfig;
    private int targetBufferBytes;

    /* JADX INFO: compiled from: SearchBox */
    public interface EventListener {
        void onBufferedPercentChanged(int i);

        void onBufferingPercentChanged(int i);
    }

    public TBLLoadControl() {
        this(new LoadConfig.Builder().build());
    }

    private void enableMiniView(boolean z) {
        LogUtil.d(this.TAG, "enableMiniView enable:" + z);
        this.isMiniViewEnabled = z;
        updateTargetBufferBytes();
    }

    private static int getDefaultBufferSize(int i) {
        if (i == 0) {
            return 144310272;
        }
        if (i == 1) {
            return 13107200;
        }
        if (i == 2) {
            return 131072000;
        }
        if (i == 3 || i == 5 || i == 6) {
            return 131072;
        }
        if (i == 7) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

    private int getTargetBufferBytes() {
        if (this.isMiniViewEnabled) {
            return 13107200;
        }
        return this.targetBufferBytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$maybeNotifyBufferedChanged$1() {
        this.listener.onBufferedPercentChanged(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyBufferingPercentChanged$0(int i) {
        this.listener.onBufferingPercentChanged(i);
    }

    private void maybeNotifyBufferedChanged(boolean z) {
        Handler handler;
        if (!z || this.listener == null || (handler = this.handler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: lr5
            @Override // java.lang.Runnable
            public final void run() {
                this.f19065a.lambda$maybeNotifyBufferedChanged$1();
            }
        });
    }

    private void maybeNotifyBufferingChanged(boolean z, long j, long j2) {
        int iMin = 100;
        boolean z2 = true;
        if (z) {
            LogUtil.d(this.TAG, "maybeNotifyBufferingChanged: will start Playback (100%).");
            this.lastBufferingPercent = 0;
        } else {
            iMin = Math.min(100, Math.max(0, (int) ((100 * j) / j2)));
            if (this.lastBufferingPercent != iMin) {
                this.lastBufferingPercent = iMin;
                LogUtil.dfmt(this.TAG, "maybeNotifyBufferingChanged: percent: %d, [%d / %d]", Integer.valueOf(iMin), Long.valueOf(j / 1000), Long.valueOf(j2 / 1000));
            } else {
                z2 = false;
            }
        }
        if (!z2 || this.listener == null || this.handler == null) {
            return;
        }
        notifyBufferingPercentChanged(iMin);
    }

    private void notifyBufferingPercentChanged(final int i) {
        Handler handler;
        if (this.listener == null || (handler = this.handler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: mr5
            @Override // java.lang.Runnable
            public final void run() {
                this.f19304a.lambda$notifyBufferingPercentChanged$0(i);
            }
        });
    }

    private void reset(boolean z) {
        LogUtil.d(this.TAG, "reset: resetAllocator " + z);
        updateTargetBufferBytes(this.loadConfig);
        this.isLoading = false;
        this.lastBufferingPercent = 0;
        if (z) {
            this.allocator.reset();
        }
    }

    private void updateTargetBufferBytes() {
        LogUtil.d(this.TAG, "update size :" + getTargetBufferBytes());
        this.allocator.setTargetBufferSize(getTargetBufferBytes());
    }

    public void addEventListener(Handler handler, EventListener eventListener) {
        this.listener = eventListener;
        this.handler = handler;
    }

    public int calculateTargetBufferBytes(Renderer[] rendererArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int defaultBufferSize = 0;
        for (int i = 0; i < rendererArr.length; i++) {
            if (exoTrackSelectionArr[i] != null) {
                defaultBufferSize += getDefaultBufferSize(rendererArr[i].getTrackType());
            }
        }
        return Math.max(13107200, defaultBufferSize);
    }

    @Override // com.oplus.tbl.exoplayer2.LoadControl
    public Allocator getAllocator() {
        return this.allocator;
    }

    @Override // com.oplus.tbl.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return this.loadConfig.backBufferDurationUs;
    }

    public long getBufferForPlaybackUs() {
        return this.loadConfig.bufferForPlaybackUs;
    }

    @Override // com.oplus.tbl.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 10001) {
            if (obj instanceof LoadConfig) {
                setLoadConfig((LoadConfig) obj);
            }
        } else if (i == 10004) {
            enableMiniView(((Boolean) obj).booleanValue());
        } else if (i == 10002) {
            this.isStreamingMode = ((Boolean) obj).booleanValue();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.LoadControl
    public void onPrepared() {
        reset(false);
    }

    @Override // com.oplus.tbl.exoplayer2.LoadControl
    public void onReleased() {
        reset(true);
    }

    @Override // com.oplus.tbl.exoplayer2.LoadControl
    public void onStopped() {
        reset(true);
    }

    @Override // com.oplus.tbl.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        int iCalculateTargetBufferBytes = this.loadConfig.targetBufferBytesOverwrite;
        if (iCalculateTargetBufferBytes == -1) {
            iCalculateTargetBufferBytes = calculateTargetBufferBytes(rendererArr, exoTrackSelectionArr);
        }
        this.targetBufferBytes = iCalculateTargetBufferBytes;
        this.allocator.setTargetBufferSize(getTargetBufferBytes());
    }

    @Override // com.oplus.tbl.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return this.loadConfig.retainBackBufferFromKeyframe;
    }

    public void setLoadConfig(@NonNull LoadConfig loadConfig) {
        this.loadConfig = loadConfig;
        if (loadConfig.targetBufferBytesOverwrite != -1) {
            updateTargetBufferBytes(loadConfig);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long j, long j2, float f) {
        boolean z = this.allocator.getTotalBytesAllocated() >= getTargetBufferBytes();
        long jMin = this.loadConfig.minBufferUs;
        if (f > 1.0f) {
            jMin = Math.min(Util.getMediaDurationForPlayoutDuration(jMin, f), this.loadConfig.maxBufferUs);
        }
        if (j2 < Math.max(jMin, 500000L)) {
            boolean z2 = this.loadConfig.prioritizeTimeOverSizeThresholds || !z;
            this.isLoading = z2;
            if (!z2 && j2 < 500000) {
                LogUtil.w(this.TAG, "Target buffer size reached with less than 500ms of buffered media data.");
                this.isLoading = true;
            }
        } else if (j2 >= this.loadConfig.maxBufferUs || z) {
            this.isLoading = false;
        }
        if (this.isStreamingMode) {
            this.isLoading = true;
        }
        maybeNotifyBufferedChanged(this.isLoading);
        return this.isLoading;
    }

    @Override // com.oplus.tbl.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j, float f, boolean z, long j2) {
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(j, f);
        LoadConfig loadConfig = this.loadConfig;
        long jMin = z ? loadConfig.bufferForPlaybackAfterRebufferUs : loadConfig.bufferForPlaybackUs;
        if (j2 != -9223372036854775807L) {
            jMin = Math.min(j2 / 2, jMin);
        }
        long j3 = jMin;
        boolean z2 = j3 <= 0 || playoutDurationForMediaDuration >= j3 || (!this.loadConfig.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= getTargetBufferBytes());
        maybeNotifyBufferingChanged(z2, playoutDurationForMediaDuration, j3);
        return z2;
    }

    public TBLLoadControl(@NonNull DefaultAllocator defaultAllocator, @NonNull LoadConfig loadConfig) {
        this.TAG = "TBLLoadControl_ins_" + Thread.currentThread().getId();
        this.allocator = defaultAllocator;
        this.loadConfig = loadConfig;
        updateTargetBufferBytes(loadConfig);
    }

    private void updateTargetBufferBytes(@NonNull LoadConfig loadConfig) {
        int i = loadConfig.targetBufferBytesOverwrite;
        if (i == -1) {
            i = 13107200;
        }
        this.targetBufferBytes = i;
    }

    public TBLLoadControl(@NonNull LoadConfig loadConfig) {
        this(new DefaultAllocator(true, 65536), loadConfig);
    }
}
