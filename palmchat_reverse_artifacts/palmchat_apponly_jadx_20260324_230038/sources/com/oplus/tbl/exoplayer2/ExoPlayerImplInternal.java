package com.oplus.tbl.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.DefaultMediaClock;
import com.oplus.tbl.exoplayer2.MediaItem;
import com.oplus.tbl.exoplayer2.MediaSourceList;
import com.oplus.tbl.exoplayer2.PlayerMessage;
import com.oplus.tbl.exoplayer2.Renderer;
import com.oplus.tbl.exoplayer2.Timeline;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsCollector;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.source.MediaPeriod;
import com.oplus.tbl.exoplayer2.source.MediaSource;
import com.oplus.tbl.exoplayer2.source.SampleStream;
import com.oplus.tbl.exoplayer2.source.ShuffleOrder;
import com.oplus.tbl.exoplayer2.source.TrackGroupArray;
import com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection;
import com.oplus.tbl.exoplayer2.trackselection.TrackSelector;
import com.oplus.tbl.exoplayer2.trackselection.TrackSelectorResult;
import com.oplus.tbl.exoplayer2.upstream.BandwidthMeter;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Clock;
import com.oplus.tbl.exoplayer2.util.HandlerWrapper;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.TraceUtil;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.qo5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class ExoPlayerImplInternal implements Handler.Callback, DefaultMediaClock.PlaybackParametersListener, MediaSourceList.MediaSourceListInfoRefreshListener, PlayerMessage.Sender, MediaPeriod.Callback, TrackSelector.InvalidationListener {
    private static final int ACTIVE_INTERVAL_MS = 10;
    private static final int ACTIVE_INTERVAL_MS_HIGH_PERFORMANCE = 3;
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final long MIN_RENDERER_SLEEP_DURATION_MS = 2000;
    private static final int MSG_ADD_MEDIA_SOURCES = 18;
    private static final int MSG_ATTEMPT_ERROR_RECOVERY = 25;
    private static final int MSG_DO_SOME_WORK = 2;
    private static final int MSG_MEDIAITEM_TRANSITION_REASON_UNKNOWN = 28;
    private static final int MSG_MOVE_MEDIA_SOURCES = 19;
    private static final int MSG_PERIOD_PREPARED = 8;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 16;
    private static final int MSG_PLAYLIST_UPDATE_REQUESTED = 22;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_REMOVE_MEDIA_SOURCES = 20;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEEK_TO_INTERNAL = 26;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_EXPECTED_END_POSITION = 29;
    private static final int MSG_SET_FOREGROUND_MODE = 13;
    private static final int MSG_SET_MEDIA_SOURCES = 17;
    private static final int MSG_SET_OFFLOAD_SCHEDULING_ENABLED = 24;
    private static final int MSG_SET_PAUSE_AT_END_OF_WINDOW = 23;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 11;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 12;
    private static final int MSG_SET_SHUFFLE_ORDER = 21;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 9;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 10;
    private static final int MSG_UPDATE_BACK_BUFFER_DURATION = 27;
    private String TAG = "ExoPlayerImplInternal_ins_" + Thread.currentThread().getId();
    private final int activeIntervalMs;
    private long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private BufferingStuckDetector bufferingStuckDetector;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private boolean foregroundMode;
    private final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private boolean isRebuffering;
    private final LivePlaybackSpeedControl livePlaybackSpeedControl;
    private final LoadControl loadControl;
    private long mExpectedPresentationTimeUs;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndexHint;
    private boolean offloadSchedulingEnabled;
    private boolean pauseAtEndOfWindow;

    @Nullable
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;

    @Nullable
    private ExoPlaybackException pendingRecoverableError;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private PlaybackInfoUpdate playbackInfoUpdate;
    private final PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Looper playbackLooper;
    private final MediaPeriodQueue queue;
    private final long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private int repeatMode;
    private boolean requestForRendererSleep;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private SeekParamsInternal seekParamsInternal;
    private long setForegroundModeTimeoutMs;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    /* JADX INFO: compiled from: SearchBox */
    public static final class MediaSourceListUpdateMessage {
        private final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
        private final long positionUs;
        private final ShuffleOrder shuffleOrder;
        private final int windowIndex;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder, int i, long j) {
            this.mediaSourceHolders = list;
            this.shuffleOrder = shuffleOrder;
            this.windowIndex = i;
            this.positionUs = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
            this.fromIndex = i;
            this.toIndex = i2;
            this.newFromIndex = i3;
            this.shuffleOrder = shuffleOrder;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;

        @Nullable
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        @Override // java.lang.Comparable
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            return i != 0 ? i : Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }

        public void setResolvedPosition(int i, long j, Object obj) {
            this.resolvedPeriodIndex = i;
            this.resolvedPeriodTimeUs = j;
            this.resolvedPeriodUid = obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class PlaybackInfoUpdate {
        public int discontinuityReason;
        private boolean hasPendingChange;
        public boolean hasPlayWhenReadyChangeReason;
        public int operationAcks;
        public int playWhenReadyChangeReason;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.playbackInfo = playbackInfo;
        }

        public void incrementPendingOperationAcks(int i) {
            this.hasPendingChange |= i > 0;
            this.operationAcks += i;
        }

        public void setPlayWhenReadyChangeReason(int i) {
            this.hasPendingChange = true;
            this.hasPlayWhenReadyChangeReason = true;
            this.playWhenReadyChangeReason = i;
        }

        public void setPlaybackInfo(PlaybackInfo playbackInfo) {
            this.hasPendingChange |= this.playbackInfo != playbackInfo;
            this.playbackInfo = playbackInfo;
        }

        public void setPositionDiscontinuity(int i) {
            if (this.positionDiscontinuity && this.discontinuityReason != 4) {
                Assertions.checkArgument(i == 4);
                return;
            }
            this.hasPendingChange = true;
            this.positionDiscontinuity = true;
            this.discontinuityReason = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface PlaybackInfoUpdateListener {
        void onPlaybackInfoUpdate(PlaybackInfoUpdate playbackInfoUpdate);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class PositionUpdateForPlaylistChange {
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource.MediaPeriodId periodId;
        public final long periodPositionUs;
        public final long requestedContentPositionUs;
        public final boolean setTargetLiveOffset;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.periodId = mediaPeriodId;
            this.periodPositionUs = j;
            this.requestedContentPositionUs = j2;
            this.forceBufferingState = z;
            this.endPlayback = z2;
            this.setTargetLiveOffset = z3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum SeekCase {
        SEEK_FORWARD_NOT_CACHED,
        SEEK_FORWARD_IN_GOP,
        SEEK_FORWARD_OUT_GOP,
        SEEK_BACKWARD
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SeekParamsInternal {
        private static final String TAG = "SeekParamsInternal";
        SeekParamsItem curSeekItem = new SeekParamsItem();
        SeekParamsItem pendingSeekItem = new SeekParamsItem();
        long lastVideoPresentTimeUs = -9223372036854775807L;
        long fastRendererTimeUs = -9223372036854775807L;

        /* JADX INFO: compiled from: SearchBox */
        public static final class SeekParamsItem {
            private int seekId = -1;
            private int seekType = 0;
            private int lastSeekType = 0;
            private SeekPosition seekPosition = null;

            public int getLastSeekType() {
                return this.lastSeekType;
            }

            public int getSeekId() {
                return this.seekId;
            }

            public SeekPosition getSeekPosition() {
                return this.seekPosition;
            }

            public int getSeekType() {
                return this.seekType;
            }

            public void setLastSeekType(int i) {
                this.lastSeekType = i;
            }

            public void setSeekId(int i) {
                this.seekId = i;
            }

            public void setSeekPosition(SeekPosition seekPosition) {
                this.seekPosition = seekPosition;
            }

            public void setSeekType(int i) {
                this.seekType = i;
            }
        }

        public void finishSeek() {
            this.curSeekItem.setSeekId(-1);
            if (this.curSeekItem.getSeekType() == 2) {
                this.curSeekItem.setSeekType(0);
            }
            this.curSeekItem.setSeekPosition(null);
            this.fastRendererTimeUs = -9223372036854775807L;
            this.lastVideoPresentTimeUs = -9223372036854775807L;
        }

        public int getCurSeekId() {
            return this.curSeekItem.getSeekId();
        }

        public SeekPosition getCurSeekPosition() {
            return this.curSeekItem.getSeekPosition();
        }

        public int getCurSeekType() {
            return this.curSeekItem.getSeekType();
        }

        public long getFastRendererTimeUs() {
            return this.fastRendererTimeUs;
        }

        public int getLastSeekType() {
            return this.curSeekItem.getLastSeekType();
        }

        public long getLastVideoPresentTimeUs() {
            return this.lastVideoPresentTimeUs;
        }

        public int getPendingSeekId() {
            return this.pendingSeekItem.getSeekId();
        }

        public SeekPosition getPendingSeekPosition() {
            return this.pendingSeekItem.getSeekPosition();
        }

        public int getPendingSeekType() {
            return this.pendingSeekItem.getSeekType();
        }

        public boolean hasPendingSeek() {
            return this.pendingSeekItem.getSeekId() != -1;
        }

        public boolean isSeeking() {
            return this.curSeekItem.getSeekId() != -1;
        }

        public void setCurSeekId(int i) {
            this.curSeekItem.setSeekId(i);
        }

        public void setCurSeekPosition(SeekPosition seekPosition) {
            this.curSeekItem.setSeekPosition(seekPosition);
        }

        public void setCurSeekType(int i) {
            this.curSeekItem.setSeekType(i);
        }

        public void setFastRendererTimeUs(long j) {
            this.fastRendererTimeUs = j;
        }

        public void setLastSeekType(int i) {
            this.curSeekItem.setLastSeekType(i);
        }

        public void setLastVideoPresentTimeUs(long j) {
            this.lastVideoPresentTimeUs = j;
        }

        public void setPendingSeekId(int i) {
            this.pendingSeekItem.setSeekId(i);
        }

        public void setPendingSeekPosition(SeekPosition seekPosition) {
            this.pendingSeekItem.setSeekPosition(seekPosition);
        }

        public void setPendingSeekType(int i) {
            this.pendingSeekItem.setSeekType(i);
        }

        public void startSeek() {
            if (this.curSeekItem.getSeekId() != -1) {
                Log.d(TAG, "curSeekId is not completed, skip it");
            }
            this.curSeekItem.setSeekId(this.pendingSeekItem.getSeekId());
            this.curSeekItem.setSeekType(this.pendingSeekItem.getSeekType());
            this.curSeekItem.setSeekPosition(this.pendingSeekItem.getSeekPosition());
            this.pendingSeekItem.setSeekId(-1);
            this.pendingSeekItem.setSeekType(0);
            this.pendingSeekItem.setSeekPosition(null);
            this.fastRendererTimeUs = -9223372036854775807L;
            this.lastVideoPresentTimeUs = -9223372036854775807L;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int i, long j) {
            this.timeline = timeline;
            this.windowIndex = i;
            this.windowPositionUs = j;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i, boolean z, @Nullable AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j, boolean z2, boolean z3, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener) {
        this.playbackInfoUpdateListener = playbackInfoUpdateListener;
        this.renderers = rendererArr;
        this.trackSelector = trackSelector;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.repeatMode = i;
        this.shuffleModeEnabled = z;
        this.seekParameters = seekParameters;
        this.livePlaybackSpeedControl = livePlaybackSpeedControl;
        this.releaseTimeoutMs = j;
        this.setForegroundModeTimeoutMs = j;
        this.pauseAtEndOfWindow = z2;
        this.activeIntervalMs = z3 ? 3 : 10;
        this.clock = clock;
        this.mExpectedPresentationTimeUs = -9223372036854775807L;
        this.backBufferDurationUs = loadControl.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl.retainBackBufferFromKeyframe();
        PlaybackInfo playbackInfoCreateDummy = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfo = playbackInfoCreateDummy;
        this.playbackInfoUpdate = new PlaybackInfoUpdate(playbackInfoCreateDummy);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].init(i2, clock);
            this.rendererCapabilities[i2] = rendererArr[i2].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock);
        this.pendingMessages = new ArrayList<>();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.deliverPendingMessageAtStartPositionRequired = true;
        Handler handler = new Handler(looper);
        this.queue = new MediaPeriodQueue(analyticsCollector, handler);
        this.mediaSourceList = new MediaSourceList(this, analyticsCollector, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.internalPlaybackThread = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.playbackLooper = looper2;
        this.handler = clock.createHandler(looper2, this);
        this.seekParamsInternal = new SeekParamsInternal();
        this.bufferingStuckDetector = new BufferingStuckDetector();
    }

    private void addMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        if (i == -1) {
            i = mediaSourceList.getSize();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList.addMediaSources(i, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder));
    }

    private void attemptErrorRecovery(ExoPlaybackException exoPlaybackException) throws ExoPlaybackException {
        Assertions.checkArgument(exoPlaybackException.isRecoverable && exoPlaybackException.type == 1);
        try {
            seekToCurrentPosition(true);
        } catch (Exception e) {
            exoPlaybackException.addSuppressed(e);
            throw exoPlaybackException;
        }
    }

    private void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.isCanceled()) {
            return;
        }
        try {
            playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        if (isRendererEnabled(renderer)) {
            this.mediaClock.onRendererDisabled(renderer);
            ensureStopped(renderer);
            renderer.disable();
            this.enabledRendererCount--;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doSomeWork() throws ExoPlaybackException, IOException {
        boolean z;
        boolean z2;
        boolean zFirstVideoFrameRendered;
        boolean z3;
        boolean z4;
        boolean z5;
        PlaybackInfo playbackInfo;
        int i;
        long j;
        boolean z6;
        PlaybackInfo playbackInfo2;
        long j2;
        long jUptimeMillis = this.clock.uptimeMillis();
        updatePeriods();
        int i2 = this.playbackInfo.playbackState;
        int i3 = 1;
        if (i2 == 1 || i2 == 4) {
            this.handler.removeMessages(2);
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            scheduleNextWork(jUptimeMillis, this.activeIntervalMs);
            return;
        }
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        if (playingPeriod.prepared) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            int i4 = 0;
            z = true;
            z2 = true;
            zFirstVideoFrameRendered = false;
            z3 = false;
            z4 = false;
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i4 >= rendererArr.length) {
                    break;
                }
                Renderer renderer = rendererArr[i4];
                if (isRendererEnabled(renderer)) {
                    if (this.seekParamsInternal.getCurSeekType() != i3 || renderer.getTrackType() != i3) {
                        renderer.setLastSeekType(this.seekParamsInternal.getLastSeekType());
                        renderer.render(this.rendererPositionUs, jElapsedRealtime);
                    }
                    z = z && renderer.isEnded();
                    boolean z7 = playingPeriod.sampleStreams[i4] != renderer.getStream();
                    boolean z8 = z7 || (!z7 && renderer.hasReadStreamToEnd()) || renderer.isReady() || renderer.isEnded();
                    z2 = z2 && z8;
                    if (!z8) {
                        renderer.maybeThrowStreamError();
                    }
                    if (renderer.getTrackType() == 2) {
                        z3 = !renderer.isAbnormalSurface();
                        zFirstVideoFrameRendered = renderer.firstVideoFrameRendered();
                        if (this.seekParamsInternal.isSeeking()) {
                            j2 = jElapsedRealtime;
                            this.seekParamsInternal.setLastVideoPresentTimeUs(renderer.lastPresentTimeUs());
                        } else {
                            j2 = jElapsedRealtime;
                        }
                        long j3 = this.mExpectedPresentationTimeUs;
                        if (j3 != -9223372036854775807L && renderer.isReachEndPosition(j3)) {
                            setState(4);
                            stopRenderers();
                            updatePlaybackPositions();
                            Log.d(this.TAG, "Expected end at " + this.mExpectedPresentationTimeUs + ",will end playback.");
                            this.mExpectedPresentationTimeUs = -9223372036854775807L;
                            renderer.setEndRendererPosition(-9223372036854775807L);
                        }
                    } else {
                        j2 = jElapsedRealtime;
                        if (renderer.getTrackType() == 1 && renderer.getState() == 2) {
                            z4 = true;
                        }
                    }
                } else {
                    j2 = jElapsedRealtime;
                }
                i4++;
                jElapsedRealtime = j2;
                i3 = 1;
            }
        } else {
            playingPeriod.mediaPeriod.maybeThrowPrepareError();
            z = true;
            z2 = true;
            zFirstVideoFrameRendered = false;
            z3 = false;
            z4 = false;
        }
        long j4 = playingPeriod.info.durationUs;
        boolean z9 = z && playingPeriod.prepared && (j4 == -9223372036854775807L || j4 <= this.playbackInfo.positionUs);
        if (z9 && this.pendingPauseAtEndOfPeriod) {
            this.pendingPauseAtEndOfPeriod = false;
            setPlayWhenReadyInternal(false, this.playbackInfo.playbackSuppressionReason, false, 5);
        }
        if (!z9 || !playingPeriod.info.isFinal) {
            if (this.playbackInfo.playbackState == 2 && shouldTransitionToReadyState(z2)) {
                setState(3);
                this.pendingRecoverableError = null;
                if (shouldPlayWhenReady()) {
                    bufferingStuckResultMaybeDetectStuck = this.isRebuffering ? maybeEndBuffering() : null;
                    startRenderers();
                }
            } else if (this.playbackInfo.playbackState != 3 || (this.enabledRendererCount != 0 ? z2 : isTimelineReady())) {
                bufferingStuckResultMaybeDetectStuck = maybeDetectStuck();
            } else {
                this.isRebuffering = shouldPlayWhenReady();
                setState(2);
                if (this.isRebuffering) {
                    maybeStartDetector();
                    maybeStartBuffering(this.rendererPositionUs / 1000);
                    notifyTrackSelectionRebuffer();
                    this.livePlaybackSpeedControl.notifyRebuffer();
                }
            }
            if (bufferingStuckResultMaybeDetectStuck != null && bufferingStuckResultMaybeDetectStuck.stuckType != 0) {
                maybeHandleBufferingStuckResult(bufferingStuckResultMaybeDetectStuck);
            }
            if (this.playbackInfo.playbackState == 2) {
                int i5 = 0;
                while (true) {
                    Renderer[] rendererArr2 = this.renderers;
                    if (i5 >= rendererArr2.length) {
                        break;
                    }
                    if (isRendererEnabled(rendererArr2[i5]) && this.renderers[i5].getStream() == playingPeriod.sampleStreams[i5]) {
                        this.renderers[i5].maybeThrowStreamError();
                    }
                    i5++;
                }
                PlaybackInfo playbackInfo3 = this.playbackInfo;
                if (!playbackInfo3.isLoading && playbackInfo3.totalBufferedDurationUs < 500000) {
                    isLoadingPossible();
                }
            }
            z5 = this.offloadSchedulingEnabled;
            playbackInfo = this.playbackInfo;
            if (z5 != playbackInfo.offloadSchedulingEnabled) {
                this.playbackInfo = playbackInfo.copyWithOffloadSchedulingEnabled(z5);
            }
            if (this.seekParamsInternal.isSeeking() && (zFirstVideoFrameRendered || (!z3 && z4))) {
                maybeHandleSeekCompleted(true);
                if (this.seekParamsInternal.hasPendingSeek()) {
                    this.handler.obtainMessage(26, this.seekParamsInternal.getPendingSeekId(), this.seekParamsInternal.getPendingSeekType(), this.seekParamsInternal.getPendingSeekPosition()).sendToTarget();
                }
            }
            if (zFirstVideoFrameRendered) {
                j = this.activeIntervalMs;
            } else {
                if ((shouldPlayWhenReady() && this.playbackInfo.playbackState == 3) || (i = this.playbackInfo.playbackState) == 2) {
                    z6 = !maybeScheduleWakeup(jUptimeMillis, this.activeIntervalMs);
                    playbackInfo2 = this.playbackInfo;
                    if (playbackInfo2.sleepingForOffload != z6) {
                    }
                    this.requestForRendererSleep = false;
                    TraceUtil.endSection();
                }
                if (this.enabledRendererCount == 0 || i == 4) {
                    this.handler.removeMessages(2);
                    z6 = false;
                    playbackInfo2 = this.playbackInfo;
                    if (playbackInfo2.sleepingForOffload != z6) {
                        this.playbackInfo = playbackInfo2.copyWithSleepingForOffload(z6);
                    }
                    this.requestForRendererSleep = false;
                    TraceUtil.endSection();
                }
                j = 1000;
            }
            scheduleNextWork(jUptimeMillis, j);
            z6 = false;
            playbackInfo2 = this.playbackInfo;
            if (playbackInfo2.sleepingForOffload != z6) {
            }
            this.requestForRendererSleep = false;
            TraceUtil.endSection();
        }
        setState(4);
        stopRenderers();
        if (bufferingStuckResultMaybeDetectStuck != null) {
            maybeHandleBufferingStuckResult(bufferingStuckResultMaybeDetectStuck);
        }
        if (this.playbackInfo.playbackState == 2) {
        }
        z5 = this.offloadSchedulingEnabled;
        playbackInfo = this.playbackInfo;
        if (z5 != playbackInfo.offloadSchedulingEnabled) {
        }
        if (this.seekParamsInternal.isSeeking()) {
            maybeHandleSeekCompleted(true);
            if (this.seekParamsInternal.hasPendingSeek()) {
            }
        }
        if (zFirstVideoFrameRendered) {
        }
        scheduleNextWork(jUptimeMillis, j);
        z6 = false;
        playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.sleepingForOffload != z6) {
        }
        this.requestForRendererSleep = false;
        TraceUtil.endSection();
    }

    private void enableRenderer(int i, boolean z) throws ExoPlaybackException {
        Renderer renderer = this.renderers[i];
        if (isRendererEnabled(renderer)) {
            return;
        }
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z2 = readingPeriod == this.queue.getPlayingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i];
        Format[] formats = getFormats(trackSelectorResult.selections[i]);
        boolean z3 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
        boolean z4 = !z && z3;
        this.enabledRendererCount++;
        renderer.enable(rendererConfiguration, formats, readingPeriod.sampleStreams[i], this.rendererPositionUs, z4, z2, readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset());
        renderer.handleMessage(103, new Renderer.WakeupListener() { // from class: com.oplus.tbl.exoplayer2.ExoPlayerImplInternal.1
            @Override // com.oplus.tbl.exoplayer2.Renderer.WakeupListener
            public void onSleep(long j) {
                if (j >= 2000) {
                    ExoPlayerImplInternal.this.requestForRendererSleep = true;
                }
            }

            @Override // com.oplus.tbl.exoplayer2.Renderer.WakeupListener
            public void onWakeup() {
                ExoPlayerImplInternal.this.handler.sendEmptyMessage(2);
            }
        });
        this.mediaClock.onRendererEnabled(renderer);
        if (z3) {
            renderer.start();
        }
    }

    private void enableRenderers() throws ExoPlaybackException {
        enableRenderers(new boolean[this.renderers.length]);
    }

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private ImmutableList<Metadata> extractMetadataFromTrackSelectionArray(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.a aVar = new ImmutableList.a();
        boolean z = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.getFormat(0).metadata;
                if (metadata == null) {
                    aVar.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    aVar.a(metadata);
                    z = true;
                }
            }
        }
        return z ? aVar.e() : ImmutableList.of();
    }

    private long getCurrentLiveOffsetUs() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        return getLiveOffsetUs(playbackInfo.timeline, playbackInfo.periodId.periodUid, playbackInfo.positionUs);
    }

    private static Format[] getFormats(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = exoTrackSelection.getFormat(i);
        }
        return formatArr;
    }

    private long getLiveOffsetUs(Timeline timeline, Object obj, long j) {
        timeline.getWindow(timeline.getPeriodByUid(obj, this.period).windowIndex, this.window);
        Timeline.Window window = this.window;
        if (window.windowStartTimeMs != -9223372036854775807L && window.isLive()) {
            Timeline.Window window2 = this.window;
            if (window2.isDynamic) {
                return C.msToUs(window2.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - (j + this.period.getPositionInWindowUs());
            }
        }
        return -9223372036854775807L;
    }

    private long getMaxRendererReadPositionUs() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return 0L;
        }
        long rendererOffset = readingPeriod.getRendererOffset();
        if (!readingPeriod.prepared) {
            return rendererOffset;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return rendererOffset;
            }
            if (isRendererEnabled(rendererArr[i]) && this.renderers[i].getStream() == readingPeriod.sampleStreams[i]) {
                long readingPositionUs = this.renderers[i].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i++;
        }
    }

    private Pair<MediaSource.MediaPeriodId, Long> getPlaceholderFirstMediaPeriodPosition(Timeline timeline) {
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L);
        }
        Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
        MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(timeline, periodPosition.first, 0L);
        long jLongValue = ((Long) periodPosition.second).longValue();
        if (mediaPeriodIdResolveMediaPeriodIdForAds.isAd()) {
            timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAds.periodUid, this.period);
            jLongValue = mediaPeriodIdResolveMediaPeriodIdForAds.adIndexInAdGroup == this.period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAds.adGroupIndex) ? this.period.getAdResumePositionUs() : 0L;
        }
        return Pair.create(mediaPeriodIdResolveMediaPeriodIdForAds, Long.valueOf(jLongValue));
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handleLoadingMediaPeriodChanged(boolean z) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.id;
        boolean z2 = !this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (z2) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        playbackInfo.bufferedPositionUs = loadingPeriod == null ? playbackInfo.positionUs : loadingPeriod.getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((z2 || z) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    private void handleMediaSourceListInfoRefreshed(Timeline timeline) throws Throwable {
        SeekPosition seekPosition;
        PositionUpdateForPlaylistChange positionUpdateForPlaylistChangeResolvePositionForPlaylistChange = resolvePositionForPlaylistChange(timeline, this.playbackInfo, this.pendingInitialSeekPosition, this.queue, this.repeatMode, this.shuffleModeEnabled, this.window, this.period);
        MediaSource.MediaPeriodId mediaPeriodId = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.periodId;
        long j = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.requestedContentPositionUs;
        boolean z = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.forceBufferingState;
        long jSeekToPeriodPosition = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.periodPositionUs;
        boolean z2 = (this.playbackInfo.periodId.equals(mediaPeriodId) && jSeekToPeriodPosition == this.playbackInfo.positionUs) ? false : true;
        try {
            if (positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.endPlayback) {
                if (this.playbackInfo.playbackState != 1) {
                    setState(4);
                }
                resetInternal(false, false, false, true);
            }
            try {
                if (z2) {
                    if (!timeline.isEmpty()) {
                        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
                            if (playingPeriod.info.id.equals(mediaPeriodId)) {
                                playingPeriod.info = this.queue.getUpdatedMediaPeriodInfo(timeline, playingPeriod.info);
                            }
                        }
                        jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, jSeekToPeriodPosition, z);
                    }
                } else if (!this.queue.updateQueuedPeriods(timeline, this.rendererPositionUs, getMaxRendererReadPositionUs())) {
                    seekToCurrentPosition(false);
                }
                PlaybackInfo playbackInfo = this.playbackInfo;
                updateLivePlaybackSpeedControl(timeline, mediaPeriodId, playbackInfo.timeline, playbackInfo.periodId, positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.setTargetLiveOffset ? jSeekToPeriodPosition : -9223372036854775807L);
                if (z2 || j != this.playbackInfo.requestedContentPositionUs) {
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, j);
                }
                resetPendingPauseAtEndOfPeriod();
                resolvePendingMessagePositions(timeline, this.playbackInfo.timeline);
                this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline);
                if (!timeline.isEmpty()) {
                    this.pendingInitialSeekPosition = null;
                }
                handleLoadingMediaPeriodChanged(false);
            } catch (Throwable th) {
                th = th;
                seekPosition = null;
                PlaybackInfo playbackInfo2 = this.playbackInfo;
                SeekPosition seekPosition2 = seekPosition;
                updateLivePlaybackSpeedControl(timeline, mediaPeriodId, playbackInfo2.timeline, playbackInfo2.periodId, positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.setTargetLiveOffset ? jSeekToPeriodPosition : -9223372036854775807L);
                if (z2 || j != this.playbackInfo.requestedContentPositionUs) {
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, j);
                }
                resetPendingPauseAtEndOfPeriod();
                resolvePendingMessagePositions(timeline, this.playbackInfo.timeline);
                this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline);
                if (!timeline.isEmpty()) {
                    this.pendingInitialSeekPosition = seekPosition2;
                }
                handleLoadingMediaPeriodChanged(false);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            seekPosition = null;
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.timeline);
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
            if (loadingPeriod == this.queue.getPlayingPeriod()) {
                resetRendererPosition(loadingPeriod.info.startPositionUs);
                enableRenderers();
                PlaybackInfo playbackInfo = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo.periodId, loadingPeriod.info.startPositionUs, playbackInfo.requestedContentPositionUs);
            }
            maybeContinueLoading();
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, float f, boolean z, boolean z2) throws ExoPlaybackException {
        if (z) {
            if (z2) {
                this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        }
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setPlaybackSpeed(f, playbackParameters.speed);
            }
        }
    }

    @CheckResult
    private PlaybackInfo handlePositionDiscontinuity(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        List<Metadata> listOf;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        this.deliverPendingMessageAtStartPositionRequired = (!this.deliverPendingMessageAtStartPositionRequired && j == this.playbackInfo.positionUs && mediaPeriodId.equals(this.playbackInfo.periodId)) ? false : true;
        resetPendingPauseAtEndOfPeriod();
        PlaybackInfo playbackInfo = this.playbackInfo;
        TrackGroupArray trackGroupArray2 = playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.trackSelectorResult;
        List<Metadata> list = playbackInfo.staticMetadata;
        if (this.mediaSourceList.isPrepared()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            TrackGroupArray trackGroups = playingPeriod == null ? TrackGroupArray.EMPTY : playingPeriod.getTrackGroups();
            TrackSelectorResult trackSelectorResult3 = playingPeriod == null ? this.emptyTrackSelectorResult : playingPeriod.getTrackSelectorResult();
            ImmutableList<Metadata> immutableListExtractMetadataFromTrackSelectionArray = extractMetadataFromTrackSelectionArray(trackSelectorResult3.selections);
            if (playingPeriod != null) {
                MediaPeriodInfo mediaPeriodInfo = playingPeriod.info;
                if (mediaPeriodInfo.requestedContentPositionUs != j2) {
                    playingPeriod.info = mediaPeriodInfo.copyWithRequestedContentPositionUs(j2);
                }
            }
            trackGroupArray = trackGroups;
            trackSelectorResult = trackSelectorResult3;
            listOf = immutableListExtractMetadataFromTrackSelectionArray;
        } else if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
            listOf = list;
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
        } else {
            trackGroupArray = TrackGroupArray.EMPTY;
            trackSelectorResult = this.emptyTrackSelectorResult;
            listOf = ImmutableList.of();
        }
        return this.playbackInfo.copyWithNewPosition(mediaPeriodId, j, j2, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult, listOf);
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (!readingPeriod.prepared) {
            return false;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i];
            SampleStream sampleStream = readingPeriod.sampleStreams[i];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.hasReadStreamToEnd())) {
                break;
            }
            i++;
        }
        return false;
    }

    private boolean isLoadingPossible() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod == null || loadingPeriod.getNextLoadPositionUs() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean isRendererEnabled(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j = playingPeriod.info.durationUs;
        return playingPeriod.prepared && (j == -9223372036854775807L || this.playbackInfo.positionUs < j || !shouldPlayWhenReady());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$release$0() {
        return Boolean.valueOf(this.released);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessageToTargetThread$1(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException e) {
            Log.e(this.TAG, "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private void maybeContinueLoading() {
        boolean zShouldContinueLoading = shouldContinueLoading();
        this.shouldContinueLoading = zShouldContinueLoading;
        if (zShouldContinueLoading) {
            this.queue.getLoadingPeriod().continueLoading(this.rendererPositionUs);
        }
        updateIsLoading();
    }

    private BufferingStuckResult maybeDetectStuck() {
        BufferingStuckDetector bufferingStuckDetector = this.bufferingStuckDetector;
        if (bufferingStuckDetector != null) {
            return bufferingStuckDetector.detectStuck();
        }
        return null;
    }

    private BufferingStuckResult maybeEndBuffering() {
        BufferingStuckDetector bufferingStuckDetector = this.bufferingStuckDetector;
        if (bufferingStuckDetector != null) {
            return bufferingStuckDetector.endBuffering();
        }
        return null;
    }

    private void maybeEndDetector() {
        BufferingStuckDetector bufferingStuckDetector = this.bufferingStuckDetector;
        if (bufferingStuckDetector != null) {
            bufferingStuckDetector.endDetector();
        }
    }

    private void maybeHandleBufferingStuckResult(BufferingStuckResult bufferingStuckResult) {
        if (this.bufferingStuckDetector == null) {
            return;
        }
        Log.d(this.TAG, "buffering result:" + bufferingStuckResult);
        this.playbackInfo = this.playbackInfo.copyWithBufferingStuckResult(bufferingStuckResult);
    }

    private void maybeHandleSeekCompleted(boolean z) {
        if (this.seekParamsInternal.isSeeking()) {
            int curSeekId = this.seekParamsInternal.getCurSeekId();
            int curSeekType = this.seekParamsInternal.getCurSeekType();
            this.seekParamsInternal.setLastSeekType(curSeekType);
            Log.d(this.TAG, "seek complete with id:" + curSeekId + ", seekType:" + curSeekType + ", success:" + z);
            this.seekParamsInternal.finishSeek();
            this.playbackInfo = this.playbackInfo.copyWithSeekResult(new SeekResult(curSeekId, curSeekType, z));
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        this.playbackInfoUpdate.setPlaybackInfo(this.playbackInfo);
        if (this.playbackInfoUpdate.hasPendingChange) {
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(this.playbackInfoUpdate);
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    private void maybeResetDetector() {
        BufferingStuckDetector bufferingStuckDetector = this.bufferingStuckDetector;
        if (bufferingStuckDetector != null) {
            bufferingStuckDetector.reset();
        }
    }

    private boolean maybeScheduleWakeup(long j, long j2) {
        if (this.offloadSchedulingEnabled && this.requestForRendererSleep) {
            return false;
        }
        scheduleNextWork(j, j2);
        return true;
    }

    private void maybeStartBuffering(long j) {
        BufferingStuckDetector bufferingStuckDetector = this.bufferingStuckDetector;
        if (bufferingStuckDetector != null) {
            bufferingStuckDetector.startBuffering(j);
        }
    }

    private void maybeStartDetector() {
        BufferingStuckDetector bufferingStuckDetector = this.bufferingStuckDetector;
        if (bufferingStuckDetector != null) {
            bufferingStuckDetector.startDetector();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r1 > 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        r3 = r7.pendingMessages.get(r1 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r3 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        r4 = r3.resolvedPeriodIndex;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
    
        if (r4 > r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (r4 != r0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r3.resolvedPeriodTimeUs <= r8) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r1 <= 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
    
        if (r1 >= r7.pendingMessages.size()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        r3 = r7.pendingMessages.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        if (r3 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        if (r3.resolvedPeriodUid == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
    
        r4 = r3.resolvedPeriodIndex;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
    
        if (r4 < r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
    
        if (r4 != r0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
    
        if (r3.resolvedPeriodTimeUs > r8) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
    
        if (r1 >= r7.pendingMessages.size()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
    
        if (r3 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
    
        if (r3.resolvedPeriodUid == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008f, code lost:
    
        if (r3.resolvedPeriodIndex != r0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0091, code lost:
    
        r4 = r3.resolvedPeriodTimeUs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0095, code lost:
    
        if (r4 <= r8) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r4 > r10) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        sendMessageToTarget(r3.message);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a6, code lost:
    
        if (r3.message.getDeleteAfterDelivery() != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ae, code lost:
    
        if (r3.message.isCanceled() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b1, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b4, code lost:
    
        r7.pendingMessages.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bf, code lost:
    
        if (r1 >= r7.pendingMessages.size()) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c1, code lost:
    
        r3 = r7.pendingMessages.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ca, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cc, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d3, code lost:
    
        if (r3.message.getDeleteAfterDelivery() != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00dd, code lost:
    
        r7.pendingMessages.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e2, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e3, code lost:
    
        r7.nextPendingMessageIndexHint = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0045, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x006a, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0055 -> B:12:0x0039). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0084 -> B:25:0x0060). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void maybeTriggerPendingMessages(long j, long j2) throws ExoPlaybackException {
        if (this.pendingMessages.isEmpty() || this.playbackInfo.periodId.isAd()) {
            return;
        }
        if (this.deliverPendingMessageAtStartPositionRequired) {
            j--;
            this.deliverPendingMessageAtStartPositionRequired = false;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        int indexOfPeriod = playbackInfo.timeline.getIndexOfPeriod(playbackInfo.periodId.periodUid);
        int iMin = Math.min(this.nextPendingMessageIndexHint, this.pendingMessages.size());
    }

    private void maybeUpdateLoadingPeriod() throws ExoPlaybackException {
        MediaPeriodInfo nextMediaPeriodInfo;
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod() && (nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo)) != null) {
            MediaPeriodHolder mediaPeriodHolderEnqueueNextMediaPeriodHolder = this.queue.enqueueNextMediaPeriodHolder(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSourceList, nextMediaPeriodInfo, this.emptyTrackSelectorResult);
            mediaPeriodHolderEnqueueNextMediaPeriodHolder.mediaPeriod.prepare(this, nextMediaPeriodInfo.startPositionUs);
            if (this.queue.getPlayingPeriod() == mediaPeriodHolderEnqueueNextMediaPeriodHolder) {
                resetRendererPosition(mediaPeriodHolderEnqueueNextMediaPeriodHolder.getStartPositionRendererTime());
            }
            handleLoadingMediaPeriodChanged(false);
        }
        if (!this.shouldContinueLoading) {
            maybeContinueLoading();
        } else {
            this.shouldContinueLoading = isLoadingPossible();
            updateIsLoading();
        }
    }

    private void maybeUpdatePlayingPeriod() throws ExoPlaybackException {
        boolean z = false;
        while (shouldAdvancePlayingPeriod()) {
            if (z) {
                maybeNotifyPlaybackInfoChanged();
            }
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            MediaPeriodHolder mediaPeriodHolderAdvancePlayingPeriod = this.queue.advancePlayingPeriod();
            MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolderAdvancePlayingPeriod.info;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodInfo.id, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.requestedContentPositionUs);
            this.playbackInfoUpdate.setPositionDiscontinuity(playingPeriod.info.isLastInTimelinePeriod ? 0 : 3);
            Timeline timeline = this.playbackInfo.timeline;
            updateLivePlaybackSpeedControl(timeline, mediaPeriodHolderAdvancePlayingPeriod.info.id, timeline, playingPeriod.info.id, -9223372036854775807L);
            resetPendingPauseAtEndOfPeriod();
            updatePlaybackPositions();
            z = true;
        }
    }

    private void maybeUpdateReadingPeriod() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return;
        }
        int i = 0;
        if (readingPeriod.getNext() != null && !this.pendingPauseAtEndOfPeriod) {
            if (hasReadingPeriodFinishedReading()) {
                if (readingPeriod.getNext().prepared || this.rendererPositionUs >= readingPeriod.getNext().getStartPositionRendererTime()) {
                    TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                    MediaPeriodHolder mediaPeriodHolderAdvanceReadingPeriod = this.queue.advanceReadingPeriod();
                    TrackSelectorResult trackSelectorResult2 = mediaPeriodHolderAdvanceReadingPeriod.getTrackSelectorResult();
                    if (mediaPeriodHolderAdvanceReadingPeriod.prepared && mediaPeriodHolderAdvanceReadingPeriod.mediaPeriod.readDiscontinuity() != -9223372036854775807L) {
                        setAllRendererStreamsFinal();
                        return;
                    }
                    for (int i2 = 0; i2 < this.renderers.length; i2++) {
                        boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i2);
                        boolean zIsRendererEnabled2 = trackSelectorResult2.isRendererEnabled(i2);
                        if (zIsRendererEnabled && !this.renderers[i2].isCurrentStreamFinal()) {
                            boolean z = this.rendererCapabilities[i2].getTrackType() == 7;
                            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i2];
                            RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i2];
                            if (!zIsRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z) {
                                this.renderers[i2].setCurrentStreamFinal();
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!readingPeriod.info.isFinal && !this.pendingPauseAtEndOfPeriod) {
            return;
        }
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return;
            }
            Renderer renderer = rendererArr[i];
            SampleStream sampleStream = readingPeriod.sampleStreams[i];
            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                renderer.setCurrentStreamFinal();
            }
            i++;
        }
    }

    private void maybeUpdateReadingRenderers() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null || this.queue.getPlayingPeriod() == readingPeriod || readingPeriod.allRenderersEnabled || !replaceStreamsOrDisableRendererForTransition()) {
            return;
        }
        enableRenderers();
    }

    private void mediaSourceListUpdateRequestedInternal() throws Throwable {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline());
    }

    private void mediaitemTransitionReasonUnknown() {
        throw new IllegalStateException("The change reason of window uid is unknown");
    }

    private void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.moveMediaSourceRange(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder));
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    private void notifyTrackSelectionPlayWhenReadyChanged(boolean z) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z);
                }
            }
        }
    }

    private void notifyTrackSelectionRebuffer() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onRebuffer();
                }
            }
        }
    }

    private void prepareInternal() {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        maybeResetDetector();
        resetInternal(false, false, false, true);
        this.loadControl.onPrepared();
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        this.mediaSourceList.prepare(this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void releaseInternal() {
        resetInternal(true, false, true, false);
        releaseRenderers();
        this.loadControl.onReleased();
        setState(1);
        this.internalPlaybackThread.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void releaseRenderers() {
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return;
            }
            rendererArr[i].release();
            i++;
        }
    }

    private void removeMediaItemsInternal(int i, int i2, ShuffleOrder shuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.removeMediaSourceRange(i, i2, shuffleOrder));
    }

    private boolean replaceStreamsOrDisableRendererForTransition() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        int i = 0;
        boolean z = false;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return !z;
            }
            Renderer renderer = rendererArr[i];
            if (isRendererEnabled(renderer)) {
                boolean z2 = renderer.getStream() != readingPeriod.sampleStreams[i];
                if (!trackSelectorResult.isRendererEnabled(i) || z2) {
                    if (!renderer.isCurrentStreamFinal()) {
                        renderer.replaceStream(getFormats(trackSelectorResult.selections[i]), readingPeriod.sampleStreams[i], readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset());
                    } else if (renderer.isEnded()) {
                        disableRenderer(renderer);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        float f = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z = true;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null && playingPeriod.prepared; playingPeriod = playingPeriod.getNext()) {
            TrackSelectorResult trackSelectorResultSelectTracks = playingPeriod.selectTracks(f, this.playbackInfo.timeline);
            int i = 0;
            if (!trackSelectorResultSelectTracks.isEquivalent(playingPeriod.getTrackSelectorResult())) {
                MediaPeriodQueue mediaPeriodQueue = this.queue;
                if (z) {
                    MediaPeriodHolder playingPeriod2 = mediaPeriodQueue.getPlayingPeriod();
                    boolean zRemoveAfter = this.queue.removeAfter(playingPeriod2);
                    boolean[] zArr = new boolean[this.renderers.length];
                    long jApplyTrackSelection = playingPeriod2.applyTrackSelection(trackSelectorResultSelectTracks, this.playbackInfo.positionUs, zRemoveAfter, zArr);
                    PlaybackInfo playbackInfo = this.playbackInfo;
                    PlaybackInfo playbackInfoHandlePositionDiscontinuity = handlePositionDiscontinuity(playbackInfo.periodId, jApplyTrackSelection, playbackInfo.requestedContentPositionUs);
                    this.playbackInfo = playbackInfoHandlePositionDiscontinuity;
                    if (playbackInfoHandlePositionDiscontinuity.playbackState != 4 && jApplyTrackSelection != playbackInfoHandlePositionDiscontinuity.positionUs) {
                        this.playbackInfoUpdate.setPositionDiscontinuity(4);
                        resetRendererPosition(jApplyTrackSelection);
                    }
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i];
                        boolean zIsRendererEnabled = isRendererEnabled(renderer);
                        zArr2[i] = zIsRendererEnabled;
                        SampleStream sampleStream = playingPeriod2.sampleStreams[i];
                        if (zIsRendererEnabled) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr[i]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i++;
                    }
                    enableRenderers(zArr2);
                } else {
                    mediaPeriodQueue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        playingPeriod.applyTrackSelection(trackSelectorResultSelectTracks, Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                    }
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (playingPeriod == readingPeriod) {
                z = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void resetInternal(boolean z, boolean z2, boolean z3, boolean z4) {
        MediaSource.MediaPeriodId mediaPeriodId;
        long j;
        long j2;
        boolean z5;
        this.handler.removeMessages(2);
        this.isRebuffering = false;
        this.mediaClock.stop();
        this.rendererPositionUs = 0L;
        for (Renderer renderer : this.renderers) {
            try {
                disableRenderer(renderer);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e(this.TAG, "Disable failed.", e);
            }
        }
        if (z) {
            for (Renderer renderer2 : this.renderers) {
                try {
                    renderer2.reset();
                } catch (RuntimeException e2) {
                    Log.e(this.TAG, "Reset failed.", e2);
                }
            }
        }
        this.enabledRendererCount = 0;
        PlaybackInfo playbackInfo = this.playbackInfo;
        MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo.periodId;
        long j3 = playbackInfo.positionUs;
        long j4 = shouldUseRequestedContentPosition(this.playbackInfo, this.period, this.window) ? this.playbackInfo.requestedContentPositionUs : this.playbackInfo.positionUs;
        if (z2) {
            this.pendingInitialSeekPosition = null;
            Pair<MediaSource.MediaPeriodId, Long> placeholderFirstMediaPeriodPosition = getPlaceholderFirstMediaPeriodPosition(this.playbackInfo.timeline);
            MediaSource.MediaPeriodId mediaPeriodId3 = (MediaSource.MediaPeriodId) placeholderFirstMediaPeriodPosition.first;
            long jLongValue = ((Long) placeholderFirstMediaPeriodPosition.second).longValue();
            if (!mediaPeriodId3.equals(this.playbackInfo.periodId)) {
                z5 = true;
                mediaPeriodId = mediaPeriodId3;
                j = jLongValue;
                j2 = -9223372036854775807L;
                this.queue.clear();
                this.shouldContinueLoading = false;
                PlaybackInfo playbackInfo2 = this.playbackInfo;
                Timeline timeline = playbackInfo2.timeline;
                int i = playbackInfo2.playbackState;
                ExoPlaybackException exoPlaybackException = !z4 ? null : playbackInfo2.playbackError;
                TrackGroupArray trackGroupArray = !z5 ? TrackGroupArray.EMPTY : playbackInfo2.trackGroups;
                TrackSelectorResult trackSelectorResult = !z5 ? this.emptyTrackSelectorResult : playbackInfo2.trackSelectorResult;
                List listOf = !z5 ? ImmutableList.of() : playbackInfo2.staticMetadata;
                PlaybackInfo playbackInfo3 = this.playbackInfo;
                this.playbackInfo = new PlaybackInfo(timeline, mediaPeriodId, j2, i, exoPlaybackException, false, trackGroupArray, trackSelectorResult, listOf, mediaPeriodId, playbackInfo3.playWhenReady, playbackInfo3.playbackSuppressionReason, playbackInfo3.playbackParameters, j, 0L, j, this.offloadSchedulingEnabled, false);
                if (z3) {
                    this.mediaSourceList.release();
                }
                this.pendingRecoverableError = null;
            }
            mediaPeriodId = mediaPeriodId3;
            j = jLongValue;
            j2 = -9223372036854775807L;
        } else {
            mediaPeriodId = mediaPeriodId2;
            j = j3;
            j2 = j4;
        }
        z5 = false;
        this.queue.clear();
        this.shouldContinueLoading = false;
        PlaybackInfo playbackInfo22 = this.playbackInfo;
        Timeline timeline2 = playbackInfo22.timeline;
        int i2 = playbackInfo22.playbackState;
        if (!z4) {
        }
        TrackGroupArray trackGroupArray2 = !z5 ? TrackGroupArray.EMPTY : playbackInfo22.trackGroups;
        TrackSelectorResult trackSelectorResult2 = !z5 ? this.emptyTrackSelectorResult : playbackInfo22.trackSelectorResult;
        List listOf2 = !z5 ? ImmutableList.of() : playbackInfo22.staticMetadata;
        PlaybackInfo playbackInfo32 = this.playbackInfo;
        this.playbackInfo = new PlaybackInfo(timeline2, mediaPeriodId, j2, i2, exoPlaybackException, false, trackGroupArray2, trackSelectorResult2, listOf2, mediaPeriodId, playbackInfo32.playWhenReady, playbackInfo32.playbackSuppressionReason, playbackInfo32.playbackParameters, j, 0L, j, this.offloadSchedulingEnabled, false);
        if (z3) {
        }
        this.pendingRecoverableError = null;
    }

    private void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        this.pendingPauseAtEndOfPeriod = playingPeriod != null && playingPeriod.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    private void resetRendererPosition(long j) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            j = playingPeriod.toRendererTime(j);
        }
        this.rendererPositionUs = j;
        this.mediaClock.resetPosition(j);
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.resetPosition(this.rendererPositionUs);
            }
        }
        notifyTrackSelectionDiscontinuity();
    }

    private void resetRendererPositionInGop(long j) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            j = playingPeriod.toRendererTime(j);
        }
        this.rendererPositionUs = j;
        this.mediaClock.resetPosition(j);
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.resetPositionInGop(this.rendererPositionUs);
            }
        }
    }

    private void resetSeekResultForSeek() {
        this.playbackInfo = this.playbackInfo.copyWithSeekResult(null);
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        int i = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, window).lastPeriodIndex;
        Object obj = timeline.getPeriod(i, period, true).uid;
        long j = period.durationUs;
        pendingMessageInfo.setResolvedPosition(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    private static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i, boolean z, Timeline.Window window, Timeline.Period period) {
        Object obj = pendingMessageInfo.resolvedPeriodUid;
        if (obj == null) {
            Pair<Object, Long> pairResolveSeekPosition = resolveSeekPosition(timeline, new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getWindowIndex(), pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE ? -9223372036854775807L : C.msToUs(pendingMessageInfo.message.getPositionMs())), false, i, z, window, period);
            if (pairResolveSeekPosition == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(pairResolveSeekPosition.first), ((Long) pairResolveSeekPosition.second).longValue(), pairResolveSeekPosition.first);
            if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            }
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
            resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            return true;
        }
        pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        timeline2.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period);
        if (timeline2.getWindow(period.windowIndex, window).isPlaceholder) {
            Pair<Object, Long> periodPosition = timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, pendingMessageInfo.resolvedPeriodTimeUs + period.getPositionInWindowUs());
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(periodPosition.first), ((Long) periodPosition.second).longValue(), periodPosition.first);
        }
        return true;
    }

    private void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        if (timeline.isEmpty() && timeline2.isEmpty()) {
            return;
        }
        for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size), timeline, timeline2, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
        }
        Collections.sort(this.pendingMessages);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(Timeline timeline, PlaybackInfo playbackInfo, @Nullable SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i, boolean z, Timeline.Window window, Timeline.Period period) {
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        int firstWindowIndex;
        int firstWindowIndex2;
        boolean z4;
        boolean z5;
        MediaPeriodQueue mediaPeriodQueue2;
        long adResumePositionUs;
        long j;
        MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds;
        int i4;
        boolean z6;
        int i5;
        boolean z7;
        boolean z8;
        boolean z9;
        if (timeline.isEmpty()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L, -9223372036854775807L, false, true, false);
        }
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        Object obj = mediaPeriodId.periodUid;
        boolean zShouldUseRequestedContentPosition = shouldUseRequestedContentPosition(playbackInfo, period, window);
        long jLongValue = zShouldUseRequestedContentPosition ? playbackInfo.requestedContentPositionUs : playbackInfo.positionUs;
        boolean z10 = false;
        if (seekPosition == null) {
            i2 = -1;
            if (playbackInfo.timeline.isEmpty()) {
                firstWindowIndex = timeline.getFirstWindowIndex(z);
            } else if (timeline.getIndexOfPeriod(obj) == -1) {
                Object objResolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i, z, obj, playbackInfo.timeline, timeline);
                if (objResolveSubsequentPeriod == null) {
                    firstWindowIndex2 = timeline.getFirstWindowIndex(z);
                    z4 = true;
                } else {
                    firstWindowIndex2 = timeline.getPeriodByUid(objResolveSubsequentPeriod, period).windowIndex;
                    z4 = false;
                }
                z5 = z4;
                z2 = false;
                z3 = false;
            } else {
                if (!zShouldUseRequestedContentPosition) {
                    i3 = -1;
                    z2 = false;
                    z3 = false;
                    z5 = false;
                    if (i3 == i2) {
                    }
                    mediaPeriodIdResolveMediaPeriodIdForAds = mediaPeriodQueue2.resolveMediaPeriodIdForAds(timeline, obj, adResumePositionUs);
                    if (mediaPeriodIdResolveMediaPeriodIdForAds.nextAdGroupIndex != i2) {
                    }
                    if (mediaPeriodId.periodUid.equals(obj)) {
                        z10 = true;
                    }
                    if (z10) {
                    }
                    if (mediaPeriodIdResolveMediaPeriodIdForAds.isAd()) {
                    }
                    return new PositionUpdateForPlaylistChange(mediaPeriodIdResolveMediaPeriodIdForAds, adResumePositionUs, j, z2, z5, z3);
                }
                if (jLongValue != -9223372036854775807L) {
                    playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, period);
                    Pair<Object, Long> periodPosition = timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(obj, period).windowIndex, jLongValue + period.getPositionInWindowUs());
                    obj = periodPosition.first;
                    jLongValue = ((Long) periodPosition.second).longValue();
                    i3 = -1;
                    z2 = false;
                    z3 = true;
                    z5 = false;
                    if (i3 == i2) {
                        Pair<Object, Long> periodPosition2 = timeline.getPeriodPosition(window, period, i3, -9223372036854775807L);
                        obj = periodPosition2.first;
                        mediaPeriodQueue2 = mediaPeriodQueue;
                        adResumePositionUs = ((Long) periodPosition2.second).longValue();
                        j = -9223372036854775807L;
                    } else {
                        mediaPeriodQueue2 = mediaPeriodQueue;
                        adResumePositionUs = jLongValue;
                        j = adResumePositionUs;
                    }
                    mediaPeriodIdResolveMediaPeriodIdForAds = mediaPeriodQueue2.resolveMediaPeriodIdForAds(timeline, obj, adResumePositionUs);
                    boolean z11 = mediaPeriodIdResolveMediaPeriodIdForAds.nextAdGroupIndex != i2 || ((i4 = mediaPeriodId.nextAdGroupIndex) != i2 && mediaPeriodIdResolveMediaPeriodIdForAds.adGroupIndex >= i4);
                    if (mediaPeriodId.periodUid.equals(obj) && !mediaPeriodId.isAd() && !mediaPeriodIdResolveMediaPeriodIdForAds.isAd() && z11) {
                        z10 = true;
                    }
                    if (z10) {
                        mediaPeriodIdResolveMediaPeriodIdForAds = mediaPeriodId;
                    }
                    if (mediaPeriodIdResolveMediaPeriodIdForAds.isAd()) {
                        if (mediaPeriodIdResolveMediaPeriodIdForAds.equals(mediaPeriodId)) {
                            adResumePositionUs = playbackInfo.positionUs;
                        } else {
                            timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAds.periodUid, period);
                            adResumePositionUs = mediaPeriodIdResolveMediaPeriodIdForAds.adIndexInAdGroup == period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAds.adGroupIndex) ? period.getAdResumePositionUs() : 0L;
                        }
                    }
                    return new PositionUpdateForPlaylistChange(mediaPeriodIdResolveMediaPeriodIdForAds, adResumePositionUs, j, z2, z5, z3);
                }
                firstWindowIndex = timeline.getPeriodByUid(obj, period).windowIndex;
            }
            i3 = firstWindowIndex;
            z2 = false;
            z3 = false;
            z5 = false;
            if (i3 == i2) {
            }
            mediaPeriodIdResolveMediaPeriodIdForAds = mediaPeriodQueue2.resolveMediaPeriodIdForAds(timeline, obj, adResumePositionUs);
            if (mediaPeriodIdResolveMediaPeriodIdForAds.nextAdGroupIndex != i2) {
            }
            if (mediaPeriodId.periodUid.equals(obj)) {
            }
            if (z10) {
            }
            if (mediaPeriodIdResolveMediaPeriodIdForAds.isAd()) {
            }
            return new PositionUpdateForPlaylistChange(mediaPeriodIdResolveMediaPeriodIdForAds, adResumePositionUs, j, z2, z5, z3);
        }
        i2 = -1;
        Pair<Object, Long> pairResolveSeekPosition = resolveSeekPosition(timeline, seekPosition, true, i, z, window, period);
        if (pairResolveSeekPosition == null) {
            firstWindowIndex2 = timeline.getFirstWindowIndex(z);
            z9 = false;
            z7 = false;
            z8 = true;
        } else {
            if (seekPosition.windowPositionUs == -9223372036854775807L) {
                i5 = timeline.getPeriodByUid(pairResolveSeekPosition.first, period).windowIndex;
                z6 = false;
            } else {
                obj = pairResolveSeekPosition.first;
                jLongValue = ((Long) pairResolveSeekPosition.second).longValue();
                z6 = true;
                i5 = -1;
            }
            z7 = playbackInfo.playbackState == 4;
            z8 = false;
            z9 = z6;
            firstWindowIndex2 = i5;
        }
        z3 = z9;
        z2 = z7;
        z5 = z8;
        i3 = firstWindowIndex2;
        if (i3 == i2) {
        }
        mediaPeriodIdResolveMediaPeriodIdForAds = mediaPeriodQueue2.resolveMediaPeriodIdForAds(timeline, obj, adResumePositionUs);
        if (mediaPeriodIdResolveMediaPeriodIdForAds.nextAdGroupIndex != i2) {
        }
        if (mediaPeriodId.periodUid.equals(obj)) {
        }
        if (z10) {
        }
        if (mediaPeriodIdResolveMediaPeriodIdForAds.isAd()) {
        }
        return new PositionUpdateForPlaylistChange(mediaPeriodIdResolveMediaPeriodIdForAds, adResumePositionUs, j, z2, z5, z3);
    }

    @Nullable
    private static Pair<Object, Long> resolveSeekPosition(Timeline timeline, SeekPosition seekPosition, boolean z, int i, boolean z2, Timeline.Window window, Timeline.Period period) {
        Pair<Object, Long> periodPosition;
        Object objResolveSubsequentPeriod;
        Timeline timeline2 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline timeline3 = timeline2.isEmpty() ? timeline : timeline2;
        try {
            periodPosition = timeline3.getPeriodPosition(window, period, seekPosition.windowIndex, seekPosition.windowPositionUs);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (timeline.equals(timeline3)) {
            return periodPosition;
        }
        if (timeline.getIndexOfPeriod(periodPosition.first) != -1) {
            timeline3.getPeriodByUid(periodPosition.first, period);
            return timeline3.getWindow(period.windowIndex, window).isPlaceholder ? timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(periodPosition.first, period).windowIndex, seekPosition.windowPositionUs) : periodPosition;
        }
        if (z && (objResolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i, z2, periodPosition.first, timeline3, timeline)) != null) {
            return timeline.getPeriodPosition(window, period, timeline.getPeriodByUid(objResolveSubsequentPeriod, period).windowIndex, -9223372036854775807L);
        }
        return null;
    }

    @Nullable
    public static Object resolveSubsequentPeriod(Timeline.Window window, Timeline.Period period, int i, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int nextPeriodIndex = indexOfPeriod;
        int indexOfPeriod2 = -1;
        for (int i2 = 0; i2 < periodCount && indexOfPeriod2 == -1; i2++) {
            nextPeriodIndex = timeline.getNextPeriodIndex(nextPeriodIndex, period, window, i, z);
            if (nextPeriodIndex == -1) {
                break;
            }
            indexOfPeriod2 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(nextPeriodIndex));
        }
        if (indexOfPeriod2 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(indexOfPeriod2);
    }

    private void scheduleNextWork(long j, long j2) {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageAtTime(2, j + j2);
    }

    private void seekToCurrentPosition(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.id;
        long jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (jSeekToPeriodPosition != this.playbackInfo.positionUs) {
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, this.playbackInfo.requestedContentPositionUs);
            if (z) {
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void seekToInternal(SeekPosition seekPosition, int i, int i2, boolean z) throws Throwable {
        long jLongValue;
        long j;
        MediaSource.MediaPeriodId mediaPeriodId;
        boolean z2;
        long j2;
        long j3;
        long j4;
        PlaybackInfo playbackInfo;
        int i3;
        if (!z) {
            this.handler.removeMessages(26);
            this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            this.seekParamsInternal.setPendingSeekId(i);
            this.seekParamsInternal.setPendingSeekType(i2);
            this.seekParamsInternal.setPendingSeekPosition(seekPosition);
        }
        Pair<Object, Long> pairResolveSeekPosition = resolveSeekPosition(this.playbackInfo.timeline, seekPosition, true, this.repeatMode, this.shuffleModeEnabled, this.window, this.period);
        if (pairResolveSeekPosition == null) {
            Pair<MediaSource.MediaPeriodId, Long> placeholderFirstMediaPeriodPosition = getPlaceholderFirstMediaPeriodPosition(this.playbackInfo.timeline);
            mediaPeriodId = (MediaSource.MediaPeriodId) placeholderFirstMediaPeriodPosition.first;
            jLongValue = ((Long) placeholderFirstMediaPeriodPosition.second).longValue();
            z2 = !this.playbackInfo.timeline.isEmpty();
            j = -9223372036854775807L;
        } else {
            Object obj = pairResolveSeekPosition.first;
            jLongValue = ((Long) pairResolveSeekPosition.second).longValue();
            j = seekPosition.windowPositionUs == -9223372036854775807L ? -9223372036854775807L : jLongValue;
            MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(this.playbackInfo.timeline, obj, jLongValue);
            if (mediaPeriodIdResolveMediaPeriodIdForAds.isAd()) {
                this.playbackInfo.timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAds.periodUid, this.period);
                jLongValue = this.period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAds.adGroupIndex) == mediaPeriodIdResolveMediaPeriodIdForAds.adIndexInAdGroup ? this.period.getAdResumePositionUs() : 0L;
                mediaPeriodId = mediaPeriodIdResolveMediaPeriodIdForAds;
                z2 = true;
            } else {
                mediaPeriodId = mediaPeriodIdResolveMediaPeriodIdForAds;
                z2 = seekPosition.windowPositionUs == -9223372036854775807L;
            }
        }
        try {
            if (this.playbackInfo.timeline.isEmpty()) {
                this.pendingInitialSeekPosition = seekPosition;
            } else {
                if (pairResolveSeekPosition != null) {
                    if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
                        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
                        long adjustedSeekPositionUs = (playingPeriod == null || !playingPeriod.prepared || jLongValue == 0) ? jLongValue : playingPeriod.mediaPeriod.getAdjustedSeekPositionUs(jLongValue, this.seekParameters);
                        long j5 = adjustedSeekPositionUs;
                        if (C.usToMs(adjustedSeekPositionUs) == C.usToMs(this.playbackInfo.positionUs) && ((i3 = (playbackInfo = this.playbackInfo).playbackState) == 2 || i3 == 3)) {
                            j2 = playbackInfo.positionUs;
                            try {
                                if (!this.seekParamsInternal.isSeeking() && this.seekParamsInternal.hasPendingSeek()) {
                                    resetSeekResultForSeek();
                                    this.seekParamsInternal.startSeek();
                                    maybeHandleSeekCompleted(true);
                                }
                                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j2, j);
                                if (z2) {
                                    this.playbackInfoUpdate.setPositionDiscontinuity(2);
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j2, j);
                                if (z2) {
                                }
                                throw th;
                            }
                        }
                        j3 = j5;
                    } else {
                        j3 = jLongValue;
                    }
                    long jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, j3, this.playbackInfo.playbackState == 4);
                    boolean z3 = (jLongValue != jSeekToPeriodPosition) | z2;
                    try {
                        PlaybackInfo playbackInfo2 = this.playbackInfo;
                        Timeline timeline = playbackInfo2.timeline;
                        updateLivePlaybackSpeedControl(timeline, mediaPeriodId, timeline, playbackInfo2.periodId, j);
                        z2 = z3;
                        j4 = jSeekToPeriodPosition;
                        this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j4, j);
                        if (z2) {
                            return;
                        }
                        this.playbackInfoUpdate.setPositionDiscontinuity(2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = z3;
                        j2 = jSeekToPeriodPosition;
                        this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j2, j);
                        if (z2) {
                            this.playbackInfoUpdate.setPositionDiscontinuity(2);
                        }
                        throw th;
                    }
                }
                if (this.playbackInfo.playbackState != 1) {
                    setState(4);
                }
                resetInternal(false, true, false, true);
            }
            j4 = jLongValue;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j4, j);
            if (z2) {
            }
        } catch (Throwable th3) {
            th = th3;
            j2 = jLongValue;
        }
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod(), z);
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == -9223372036854775807L) {
            sendMessageToTarget(playerMessage);
            return;
        }
        if (this.playbackInfo.timeline.isEmpty()) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
            return;
        }
        PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
        Timeline timeline = this.playbackInfo.timeline;
        if (!resolvePendingMessagePosition(pendingMessageInfo, timeline, timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
            playerMessage.markAsProcessed(false);
        } else {
            this.pendingMessages.add(pendingMessageInfo);
            Collections.sort(this.pendingMessages);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getLooper() != this.playbackLooper) {
            this.handler.obtainMessage(15, playerMessage).sendToTarget();
            return;
        }
        deliverMessage(playerMessage);
        int i = this.playbackInfo.playbackState;
        if (i == 3 || i == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void sendMessageToTargetThread(final PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        if (looper.getThread().isAlive()) {
            this.clock.createHandler(looper, null).post(new Runnable() { // from class: com.oplus.tbl.exoplayer2.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7574a.lambda$sendMessageToTargetThread$1(playerMessage);
                }
            });
        } else {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
        }
    }

    private void setAllRendererStreamsFinal() {
        for (Renderer renderer : this.renderers) {
            if (renderer.getStream() != null) {
                renderer.setCurrentStreamFinal();
            }
        }
    }

    private void setEndPositionInternal(long j) {
        this.mExpectedPresentationTimeUs = j;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                renderer.setEndRendererPosition(this.mExpectedPresentationTimeUs);
            }
        }
    }

    private void setFastRendererPosition(long j) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            j = playingPeriod.toRendererTime(j);
        }
        Log.d(this.TAG, "set fastRenderTime from:" + this.seekParamsInternal.getFastRendererTimeUs() + ",to:" + j);
        this.seekParamsInternal.setFastRendererTimeUs(j);
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.setFastRendererPosition(j);
            }
        }
    }

    private void setForegroundModeInternal(boolean z, @Nullable AtomicBoolean atomicBoolean) {
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            if (!z) {
                for (Renderer renderer : this.renderers) {
                    if (!isRendererEnabled(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setMediaSources(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder));
    }

    private void setOffloadSchedulingEnabledInternal(boolean z) {
        if (z == this.offloadSchedulingEnabled) {
            return;
        }
        this.offloadSchedulingEnabled = z;
        PlaybackInfo playbackInfo = this.playbackInfo;
        int i = playbackInfo.playbackState;
        if (z || i == 4 || i == 1) {
            this.playbackInfo = playbackInfo.copyWithOffloadSchedulingEnabled(z);
        } else {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPauseAtEndOfWindowInternal(boolean z) throws ExoPlaybackException {
        this.pauseAtEndOfWindow = z;
        resetPendingPauseAtEndOfPeriod();
        if (!this.pendingPauseAtEndOfPeriod || this.queue.getReadingPeriod() == this.queue.getPlayingPeriod()) {
            return;
        }
        seekToCurrentPosition(true);
        handleLoadingMediaPeriodChanged(false);
    }

    private void setPlayWhenReadyInternal(boolean z, int i, boolean z2, int i2) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.playbackInfoUpdate.setPlayWhenReadyChangeReason(i2);
        this.playbackInfo = this.playbackInfo.copyWithPlayWhenReady(z, i);
        this.isRebuffering = false;
        notifyTrackSelectionPlayWhenReadyChanged(z);
        if (!shouldPlayWhenReady()) {
            maybeEndDetector();
            stopRenderers();
            updatePlaybackPositions();
            return;
        }
        int i3 = this.playbackInfo.playbackState;
        if (i3 == 3) {
            maybeStartDetector();
            startRenderers();
        } else if (i3 != 2) {
            return;
        }
        this.handler.sendEmptyMessage(2);
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        this.mediaClock.setPlaybackParameters(playbackParameters);
        handlePlaybackParameters(this.mediaClock.getPlaybackParameters(), true);
    }

    private void setRepeatModeInternal(int i) throws ExoPlaybackException {
        this.repeatMode = i;
        if (!this.queue.updateRepeatMode(this.playbackInfo.timeline, i)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void setShuffleModeEnabledInternal(boolean z) throws ExoPlaybackException {
        this.shuffleModeEnabled = z;
        if (!this.queue.updateShuffleModeEnabled(this.playbackInfo.timeline, z)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleOrderInternal(ShuffleOrder shuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setShuffleOrder(shuffleOrder));
    }

    private void setState(int i) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playbackState != i) {
            this.playbackInfo = playbackInfo.copyWithPlaybackState(i);
        }
    }

    private boolean shouldAdvancePlayingPeriod() {
        MediaPeriodHolder playingPeriod;
        MediaPeriodHolder next;
        return shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (playingPeriod = this.queue.getPlayingPeriod()) != null && (next = playingPeriod.getNext()) != null && this.rendererPositionUs >= next.getStartPositionRendererTime() && next.allRenderersEnabled;
    }

    private boolean shouldContinueLoading() {
        if (!isLoadingPossible()) {
            return false;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return this.loadControl.shouldContinueLoading(loadingPeriod == this.queue.getPlayingPeriod() ? loadingPeriod.toPeriodTime(this.rendererPositionUs) : loadingPeriod.toPeriodTime(this.rendererPositionUs) - loadingPeriod.info.startPositionUs, getTotalBufferedDurationUs(loadingPeriod.getNextLoadPositionUs()), this.mediaClock.getPlaybackParameters().speed);
    }

    private boolean shouldPlayWhenReady() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.playWhenReady && playbackInfo.playbackSuppressionReason == 0;
    }

    private boolean shouldTransitionToReadyState(boolean z) {
        if (this.enabledRendererCount == 0) {
            return isTimelineReady();
        }
        if (!z) {
            return false;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (!playbackInfo.isLoading) {
            return true;
        }
        long targetLiveOffsetUs = shouldUseLivePlaybackSpeedControl(playbackInfo.timeline, this.queue.getPlayingPeriod().info.id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : -9223372036854775807L;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal) || (loadingPeriod.info.id.isAd() && !loadingPeriod.prepared) || this.loadControl.shouldStartPlayback(getTotalBufferedDurationUs(), this.mediaClock.getPlaybackParameters().speed, this.isRebuffering, targetLiveOffsetUs);
    }

    private boolean shouldUseLivePlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.isAd() || timeline.isEmpty()) {
            return false;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        if (!this.window.isLive()) {
            return false;
        }
        Timeline.Window window = this.window;
        return window.isDynamic && window.windowStartTimeMs != -9223372036854775807L;
    }

    private static boolean shouldUseRequestedContentPosition(PlaybackInfo playbackInfo, Timeline.Period period, Timeline.Window window) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        Timeline timeline = playbackInfo.timeline;
        return mediaPeriodId.isAd() || timeline.isEmpty() || timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, period).windowIndex, window).isPlaceholder;
    }

    private boolean shouldUseStreamingPlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.isAd() || timeline.isEmpty()) {
            return false;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        return Util.castNonNull(((MediaItem.PlaybackProperties) Util.castNonNull(this.window.mediaItem.playbackProperties)).tag) instanceof DefaultStreamingSpeedControl;
    }

    private void startRenderers() throws ExoPlaybackException {
        this.isRebuffering = false;
        this.mediaClock.start();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.start();
            }
        }
    }

    private void stopInternal(boolean z, boolean z2) {
        resetInternal(z || !this.foregroundMode, false, true, false);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.loadControl.onStopped();
        setState(1);
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                ensureStopped(renderer);
            }
        }
    }

    private void updateIsLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z = this.shouldContinueLoading || (loadingPeriod != null && loadingPeriod.mediaPeriod.isLoading());
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (z != playbackInfo.isLoading) {
            this.playbackInfo = playbackInfo.copyWithIsLoading(z);
        }
    }

    private void updateLivePlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j) {
        if (timeline.isEmpty() || !shouldUseLivePlaybackSpeedControl(timeline, mediaPeriodId)) {
            return;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        this.livePlaybackSpeedControl.setLiveConfiguration((MediaItem.LiveConfiguration) Util.castNonNull(this.window.liveConfiguration));
        if (j != -9223372036854775807L) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(getLiveOffsetUs(timeline, mediaPeriodId.periodUid, j));
            return;
        }
        if (Util.areEqual(!timeline2.isEmpty() ? timeline2.getWindow(timeline2.getPeriodByUid(mediaPeriodId2.periodUid, this.period).windowIndex, this.window).uid : null, this.window.uid)) {
            return;
        }
        this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(-9223372036854775807L);
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        if (this.playbackInfo.timeline.isEmpty() || !this.mediaSourceList.isPrepared()) {
            return;
        }
        maybeUpdateLoadingPeriod();
        maybeUpdateReadingPeriod();
        maybeUpdateReadingRenderers();
        maybeUpdatePlayingPeriod();
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            return;
        }
        long discontinuity = playingPeriod.prepared ? playingPeriod.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != -9223372036854775807L) {
            resetRendererPosition(discontinuity);
            if (discontinuity != this.playbackInfo.positionUs) {
                PlaybackInfo playbackInfo = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo.periodId, discontinuity, playbackInfo.requestedContentPositionUs);
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        } else {
            long jSyncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs(playingPeriod != this.queue.getReadingPeriod());
            this.rendererPositionUs = jSyncAndGetPositionUs;
            long periodTime = playingPeriod.toPeriodTime(jSyncAndGetPositionUs);
            maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
            this.playbackInfo.positionUs = periodTime;
        }
        this.playbackInfo.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (!playbackInfo2.playWhenReady || playbackInfo2.playbackState != 3 || !shouldUseStreamingPlaybackSpeedControl(playbackInfo2.timeline, playbackInfo2.periodId) || this.playbackInfo.playbackParameters.speed != 1.0f) {
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            if (playbackInfo3.playWhenReady && playbackInfo3.playbackState == 3 && shouldUseLivePlaybackSpeedControl(playbackInfo3.timeline, playbackInfo3.periodId) && this.playbackInfo.playbackParameters.speed == 1.0f) {
                float adjustedPlaybackSpeed = this.livePlaybackSpeedControl.getAdjustedPlaybackSpeed(getCurrentLiveOffsetUs(), getTotalBufferedDurationUs());
                if (this.mediaClock.getPlaybackParameters().speed != adjustedPlaybackSpeed) {
                    this.mediaClock.setPlaybackParameters(this.playbackInfo.playbackParameters.withSpeed(adjustedPlaybackSpeed));
                    handlePlaybackParameters(this.playbackInfo.playbackParameters, this.mediaClock.getPlaybackParameters().speed, false, false);
                    return;
                }
                return;
            }
            return;
        }
        float adjustedPlaybackSpeed2 = ((DefaultStreamingSpeedControl) Util.castNonNull(((MediaItem.PlaybackProperties) Util.castNonNull(this.window.mediaItem.playbackProperties)).tag)).getAdjustedPlaybackSpeed(this.mediaClock.getPendingDataOffsetUs(), this.mediaClock.getPlaybackParameters().speed);
        if (this.mediaClock.getPlaybackParameters().speed != adjustedPlaybackSpeed2) {
            Log.d(this.TAG, "updatePlaybackPositions: current speed is: " + this.mediaClock.getPlaybackParameters().speed + ", adjusted speed is = " + adjustedPlaybackSpeed2);
            this.mediaClock.setPlaybackParameters(this.playbackInfo.playbackParameters.withSpeed(adjustedPlaybackSpeed2));
            handlePlaybackParameters(this.playbackInfo.playbackParameters, this.mediaClock.getPlaybackParameters().speed, false, false);
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f);
                }
            }
        }
    }

    private synchronized void waitUninterruptibly(qo5<Boolean> qo5Var, long j) {
        long jElapsedRealtime = this.clock.elapsedRealtime() + j;
        boolean z = false;
        while (!qo5Var.get2().booleanValue() && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jElapsedRealtime - this.clock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public void addMediaSources(int i, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(18, i, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, -9223372036854775807L)).sendToTarget();
    }

    public void enableBufferingStuckDetector(boolean z) {
        BufferingStuckDetector bufferingStuckDetector = this.bufferingStuckDetector;
        if (bufferingStuckDetector != null) {
            bufferingStuckDetector.enable(z);
        }
    }

    public void enableDynamicWallpaper(boolean z) {
        this.handler.obtainMessage(27).sendToTarget();
    }

    public void experimentalSetForegroundModeTimeoutMs(long j) {
        this.setForegroundModeTimeoutMs = j;
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        this.handler.obtainMessage(24, z ? 1 : 0, 0).sendToTarget();
    }

    public Looper getPlaybackLooper() {
        return this.playbackLooper;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        ExoPlaybackException e;
        MediaPeriodHolder readingPeriod;
        try {
            switch (message.what) {
                case 0:
                    prepareInternal();
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj, message.arg1, message.arg2, false);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(false, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 10:
                    reselectTracksInternal();
                    break;
                case 11:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 12:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 13:
                    setForegroundModeInternal(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackParameters((PlaybackParameters) message.obj, false);
                    break;
                case 17:
                    setMediaItemsInternal((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    addMediaItemsInternal((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    moveMediaItemsInternal((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    removeMediaItemsInternal(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    setShuffleOrderInternal((ShuffleOrder) message.obj);
                    break;
                case 22:
                    mediaSourceListUpdateRequestedInternal();
                    break;
                case 23:
                    setPauseAtEndOfWindowInternal(message.arg1 != 0);
                    break;
                case 24:
                    setOffloadSchedulingEnabledInternal(message.arg1 == 1);
                    break;
                case 25:
                    attemptErrorRecovery((ExoPlaybackException) message.obj);
                    break;
                case 26:
                    seekToInternal((SeekPosition) message.obj, message.arg1, message.arg2, true);
                    break;
                case 27:
                    this.backBufferDurationUs = this.loadControl.getBackBufferDurationUs();
                    return true;
                case 28:
                    mediaitemTransitionReasonUnknown();
                    return true;
                case 29:
                    setEndPositionInternal(((Long) message.obj).longValue());
                    return true;
                default:
                    return false;
            }
            maybeNotifyPlaybackInfoChanged();
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.type == 1 && (readingPeriod = this.queue.getReadingPeriod()) != null) {
                e = e.copyWithMediaPeriodId(readingPeriod.info.id);
            }
            if (e.isRecoverable && this.pendingRecoverableError == null) {
                Log.w(this.TAG, "Recoverable playback error", e);
                this.pendingRecoverableError = e;
                Message messageObtainMessage = this.handler.obtainMessage(25, e);
                messageObtainMessage.getTarget().sendMessageAtFrontOfQueue(messageObtainMessage);
                maybeHandleSeekCompleted(false);
                maybeNotifyPlaybackInfoChanged();
            } else {
                ExoPlaybackException exoPlaybackException = this.pendingRecoverableError;
                if (exoPlaybackException != null) {
                    e.addSuppressed(exoPlaybackException);
                    this.pendingRecoverableError = null;
                }
                Log.e(this.TAG, "Playback error", e);
                stopInternal(true, false);
                this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
                maybeHandleSeekCompleted(false);
                maybeNotifyPlaybackInfoChanged();
            }
        } catch (IOException e3) {
            e = ExoPlaybackException.createForSource(e3);
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            if (playingPeriod != null) {
                e = e.copyWithMediaPeriodId(playingPeriod.info.id);
            }
            Log.e(this.TAG, "Playback error", e);
            stopInternal(false, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
            maybeHandleSeekCompleted(false);
            maybeNotifyPlaybackInfoChanged();
        } catch (RuntimeException e4) {
            e = ExoPlaybackException.createForUnexpected(e4);
            Log.e(this.TAG, "Playback error", e);
            stopInternal(true, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
            maybeHandleSeekCompleted(false);
            maybeNotifyPlaybackInfoChanged();
        }
        return true;
    }

    public void mediaitemTransitionReasonUnknownMessage() {
        this.handler.sendEmptyMessage(28);
    }

    public void moveMediaSources(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(19, new MoveMediaItemsMessage(i, i2, i3, shuffleOrder)).sendToTarget();
    }

    @Override // com.oplus.tbl.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    @Override // com.oplus.tbl.exoplayer2.DefaultMediaClock.PlaybackParametersListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    @Override // com.oplus.tbl.exoplayer2.MediaSourceList.MediaSourceListInfoRefreshListener
    public void onPlaylistUpdateRequested() {
        this.handler.sendEmptyMessage(22);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    public void prepare() {
        this.handler.obtainMessage(0).sendToTarget();
    }

    public synchronized boolean release() {
        if (!this.released && this.internalPlaybackThread.isAlive()) {
            this.handler.sendEmptyMessage(7);
            waitUninterruptibly(new qo5() { // from class: com.oplus.tbl.exoplayer2.z
                @Override // defpackage.qo5
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return this.f7679a.lambda$release$0();
                }
            }, this.releaseTimeoutMs);
            return this.released;
        }
        return true;
    }

    public void removeMediaSources(int i, int i2, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(20, i, i2, shuffleOrder).sendToTarget();
    }

    public void seekTo(Timeline timeline, int i, long j, int i2, int i3) {
        this.handler.obtainMessage(3, i2, i3, new SeekPosition(timeline, i, j)).sendToTarget();
    }

    @Override // com.oplus.tbl.exoplayer2.PlayerMessage.Sender
    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.released && this.internalPlaybackThread.isAlive()) {
            this.handler.obtainMessage(14, playerMessage).sendToTarget();
            return;
        }
        Log.w(this.TAG, "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    public void setEndPositionUs(long j) {
        Log.d(this.TAG, "setEndPositionUs " + j);
        this.handler.obtainMessage(29, Long.valueOf(j)).sendToTarget();
    }

    public synchronized boolean setForegroundMode(boolean z) {
        if (!this.released && this.internalPlaybackThread.isAlive()) {
            if (z) {
                this.handler.obtainMessage(13, 1, 0).sendToTarget();
                return true;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.handler.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
            waitUninterruptibly(new qo5() { // from class: ir1
                @Override // defpackage.qo5
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return Boolean.valueOf(atomicBoolean.get());
                }
            }, this.setForegroundModeTimeoutMs);
            return atomicBoolean.get();
        }
        return true;
    }

    public void setMediaSources(List<MediaSourceList.MediaSourceHolder> list, int i, long j, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i, j)).sendToTarget();
    }

    public void setPauseAtEndOfWindow(boolean z) {
        this.handler.obtainMessage(23, z ? 1 : 0, 0).sendToTarget();
    }

    public void setPlayWhenReady(boolean z, int i) {
        this.handler.obtainMessage(1, z ? 1 : 0, i).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setRepeatMode(int i) {
        this.handler.obtainMessage(11, i, 0).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        this.handler.obtainMessage(5, seekParameters).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z) {
        this.handler.obtainMessage(12, z ? 1 : 0, 0).sendToTarget();
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    public void stop() {
        this.handler.obtainMessage(6).sendToTarget();
    }

    private void enableRenderers(boolean[] zArr) throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        for (int i = 0; i < this.renderers.length; i++) {
            if (!trackSelectorResult.isRendererEnabled(i)) {
                this.renderers[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.renderers.length; i2++) {
            if (trackSelectorResult.isRendererEnabled(i2)) {
                enableRenderer(i2, zArr[i2]);
            }
        }
        readingPeriod.allRenderersEnabled = true;
    }

    private long getTotalBufferedDurationUs(long j) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0L;
        }
        return Math.max(0L, j - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, boolean z) throws ExoPlaybackException {
        handlePlaybackParameters(playbackParameters, playbackParameters.speed, true, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z, boolean z2) throws ExoPlaybackException {
        SeekCase seekCase;
        stopRenderers();
        this.isRebuffering = false;
        if (z2 || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder next = playingPeriod;
        while (next != null && !mediaPeriodId.equals(next.info.id)) {
            next = next.getNext();
        }
        if (z || playingPeriod != next || (next != null && next.toRendererTime(j) < 0)) {
            for (Renderer renderer : this.renderers) {
                disableRenderer(renderer);
            }
            if (next != null) {
                while (this.queue.getPlayingPeriod() != next) {
                    this.queue.advancePlayingPeriod();
                }
                this.queue.removeAfter(next);
                next.setRendererOffset(0L);
                enableRenderers();
            }
        }
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        if (next != null) {
            mediaPeriodQueue.removeAfter(next);
            SeekCase seekCase2 = SeekCase.SEEK_FORWARD_NOT_CACHED;
            if (next.prepared) {
                long j2 = next.info.durationUs;
                if (j2 != -9223372036854775807L && j >= j2) {
                    j = Math.max(0L, j2 - 1);
                }
                if (this.seekParamsInternal.getPendingSeekType() != 0) {
                    long j3 = this.rendererPositionUs;
                    if (j < j3) {
                        seekCase = SeekCase.SEEK_BACKWARD;
                    } else {
                        long nextKeyFramePositionUs = next.mediaPeriod.getNextKeyFramePositionUs(j3);
                        Log.d(this.TAG, "nextKeyFramePositionUs:" + nextKeyFramePositionUs);
                        if (nextKeyFramePositionUs == -1) {
                            seekCase = next.mediaPeriod.getLargestQueuedTimeUsByType(2) >= j ? SeekCase.SEEK_FORWARD_IN_GOP : seekCase2;
                        } else if (this.rendererPositionUs > j || j >= nextKeyFramePositionUs) {
                            seekCase = SeekCase.SEEK_FORWARD_OUT_GOP;
                        }
                    }
                    boolean zIsSeeking = this.seekParamsInternal.isSeeking();
                    Log.d(this.TAG, "seekCase:" + seekCase + ", isSeeking:" + zIsSeeking + ",periodPositionUs:" + j + ", rendererPositionUs:" + this.rendererPositionUs);
                    if (zIsSeeking && this.seekParamsInternal.getPendingSeekType() == 1) {
                        long lastVideoPresentTimeUs = this.seekParamsInternal.getLastVideoPresentTimeUs();
                        Log.d(this.TAG, "lastVideoPresentTimeUs:" + lastVideoPresentTimeUs);
                        if (lastVideoPresentTimeUs == -9223372036854775807L) {
                            Log.d(this.TAG, "not received any data, just waiting");
                            return j;
                        }
                        if (seekCase == seekCase2) {
                            Log.d(this.TAG, "not cached enough data");
                            setFastRendererPosition(-9223372036854775807L);
                            return j;
                        }
                        if (seekCase == SeekCase.SEEK_FORWARD_IN_GOP) {
                            Log.d(this.TAG, "need pending the forward seek in same GOP");
                            setFastRendererPosition(-9223372036854775807L);
                            return j;
                        }
                        if (seekCase != SeekCase.SEEK_FORWARD_OUT_GOP) {
                            setFastRendererPosition(j);
                            if (lastVideoPresentTimeUs <= j) {
                                Log.d(this.TAG, "need pending the backward seek if not decoded enough data");
                            }
                            return j;
                        }
                        if (this.seekParamsInternal.getFastRendererTimeUs() != -9223372036854775807L ? this.seekParamsInternal.getFastRendererTimeUs() > lastVideoPresentTimeUs : lastVideoPresentTimeUs < this.rendererPositionUs) {
                            setFastRendererPosition(lastVideoPresentTimeUs);
                        }
                        return j;
                    }
                    seekCase2 = seekCase;
                }
                resetSeekResultForSeek();
                this.seekParamsInternal.startSeek();
                if (next.hasEnabledTracks) {
                    if (seekCase2 != SeekCase.SEEK_FORWARD_IN_GOP) {
                        j = next.mediaPeriod.seekToUs(j);
                        next.mediaPeriod.discardBuffer(j - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                    } else {
                        if (!next.mediaPeriod.seekToUsInGop(j, this.seekParamsInternal.getCurSeekType() == 2)) {
                            Log.d(this.TAG, "seekToUsInGop failed, fallback to SeekToUs");
                            seekCase2 = SeekCase.SEEK_FORWARD_OUT_GOP;
                            j = next.mediaPeriod.seekToUs(j);
                        }
                        next.mediaPeriod.discardBuffer(j - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                    }
                }
            } else {
                next.info = next.info.copyWithStartPositionUs(j);
            }
            if (seekCase2 != SeekCase.SEEK_FORWARD_IN_GOP) {
                resetRendererPosition(j);
            } else {
                resetRendererPositionInGop(j);
            }
            maybeContinueLoading();
        } else {
            mediaPeriodQueue.clear();
            resetRendererPosition(j);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j;
    }
}
