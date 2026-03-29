package com.oplus.tbl.exoplayer2;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.MediaItem;
import com.oplus.tbl.exoplayer2.Timeline;
import com.oplus.tbl.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class BasePlayer implements Player {
    protected final Timeline.Window window = new Timeline.Window();

    private int getRepeatModeForNavigation() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void addMediaItem(int i, MediaItem mediaItem) {
        addMediaItems(i, Collections.singletonList(mediaItem));
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void fastSeekTo(int i, long j, boolean z) {
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -9223372036854775807L;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final long getCurrentLiveOffset() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty() || currentTimeline.getWindow(getCurrentWindowIndex(), this.window).windowStartTimeMs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return (this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - getContentPosition();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    @Nullable
    public final Object getCurrentManifest() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).manifest;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    @Nullable
    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).mediaItem;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    @Nullable
    @Deprecated
    public final Object getCurrentTag() {
        MediaItem.PlaybackProperties playbackProperties;
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty() || (playbackProperties = currentTimeline.getWindow(getCurrentWindowIndex(), this.window).mediaItem.playbackProperties) == null) {
            return null;
        }
        return playbackProperties.tag;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public MediaItem getMediaItemAt(int i) {
        return getCurrentTimeline().getWindow(i, this.window).mediaItem;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final int getNextWindowIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getNextWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final int getPreviousWindowIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getPreviousWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final boolean hasNext() {
        return getNextWindowIndex() != -1;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final boolean hasPrevious() {
        return getPreviousWindowIndex() != -1;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final boolean isCurrentWindowDynamic() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final boolean isCurrentWindowLive() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isLive();
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final boolean isCurrentWindowSeekable() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void moveMediaItem(int i, int i2) {
        if (i != i2) {
            moveMediaItems(i, i + 1, i2);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final void next() {
        int nextWindowIndex = getNextWindowIndex();
        if (nextWindowIndex != -1) {
            seekToDefaultPosition(nextWindowIndex);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final void previous() {
        int previousWindowIndex = getPreviousWindowIndex();
        if (previousWindowIndex != -1) {
            seekToDefaultPosition(previousWindowIndex);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void seekTo(int i, long j) {
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem) {
        setMediaItems(Collections.singletonList(mediaItem));
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list) {
        setMediaItems(list, true);
    }

    @RequiresApi(api = 19)
    public abstract void setVideoEffects(List<Effect> list);

    @Override // com.oplus.tbl.exoplayer2.Player
    public final void stop() {
        stop(false);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void addMediaItem(MediaItem mediaItem) {
        addMediaItems(Collections.singletonList(mediaItem));
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final void fastSeekTo(long j, boolean z) {
        fastSeekTo(getCurrentWindowIndex(), j, z);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final void seekTo(long j) {
        seekTo(getCurrentWindowIndex(), j);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public final void seekToDefaultPosition(int i) {
        seekTo(i, -9223372036854775807L);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem, long j) {
        setMediaItems(Collections.singletonList(mediaItem), 0, j);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem, boolean z) {
        setMediaItems(Collections.singletonList(mediaItem), z);
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void enableDynamicWallpaper(boolean z) {
    }

    @Override // com.oplus.tbl.exoplayer2.Player
    public void enableStuckDetector(boolean z) {
    }
}
