package com.google.android.exoplayer2;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.e0;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class d implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0.d f5848a = new e0.d();

    @Override // com.google.android.exoplayer2.v
    public final void d(p pVar) {
        p(ImmutableList.of(pVar));
    }

    public final int f() {
        e0 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return -1;
        }
        return currentTimeline.i(getCurrentMediaItemIndex(), h(), getShuffleModeEnabled());
    }

    public final int g() {
        e0 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return -1;
        }
        return currentTimeline.p(getCurrentMediaItemIndex(), h(), getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.v
    public final long getContentDuration() {
        e0 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return -9223372036854775807L;
        }
        return currentTimeline.r(getCurrentMediaItemIndex(), this.f5848a).f();
    }

    public final int h() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    @Override // com.google.android.exoplayer2.v
    public final boolean hasNextMediaItem() {
        return f() != -1;
    }

    @Override // com.google.android.exoplayer2.v
    public final boolean hasPreviousMediaItem() {
        return g() != -1;
    }

    public final void i(int i) {
        j(getCurrentMediaItemIndex(), -9223372036854775807L, i, true);
    }

    @Override // com.google.android.exoplayer2.v
    public final boolean isCommandAvailable(int i) {
        return getAvailableCommands().c(i);
    }

    @Override // com.google.android.exoplayer2.v
    public final boolean isCurrentMediaItemDynamic() {
        e0 currentTimeline = getCurrentTimeline();
        return !currentTimeline.u() && currentTimeline.r(getCurrentMediaItemIndex(), this.f5848a).i;
    }

    @Override // com.google.android.exoplayer2.v
    public final boolean isCurrentMediaItemLive() {
        e0 currentTimeline = getCurrentTimeline();
        return !currentTimeline.u() && currentTimeline.r(getCurrentMediaItemIndex(), this.f5848a).h();
    }

    @Override // com.google.android.exoplayer2.v
    public final boolean isCurrentMediaItemSeekable() {
        e0 currentTimeline = getCurrentTimeline();
        return !currentTimeline.u() && currentTimeline.r(getCurrentMediaItemIndex(), this.f5848a).h;
    }

    @Override // com.google.android.exoplayer2.v
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    @VisibleForTesting(otherwise = 4)
    public abstract void j(int i, long j, int i2, boolean z);

    public final void k(long j, int i) {
        j(getCurrentMediaItemIndex(), j, i, false);
    }

    public final void l(int i, int i2) {
        j(i, -9223372036854775807L, i2, false);
    }

    public final void m(int i) {
        int iF = f();
        if (iF == -1) {
            return;
        }
        if (iF == getCurrentMediaItemIndex()) {
            i(i);
        } else {
            l(iF, i);
        }
    }

    public final void n(long j, int i) {
        long currentPosition = getCurrentPosition() + j;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        k(Math.max(currentPosition, 0L), i);
    }

    public final void o(int i) {
        int iG = g();
        if (iG == -1) {
            return;
        }
        if (iG == getCurrentMediaItemIndex()) {
            i(i);
        } else {
            l(iG, i);
        }
    }

    public final void p(List<p> list) {
        setMediaItems(list, true);
    }

    @Override // com.google.android.exoplayer2.v
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // com.google.android.exoplayer2.v
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override // com.google.android.exoplayer2.v
    public final void seekBack() {
        n(-getSeekBackIncrement(), 11);
    }

    @Override // com.google.android.exoplayer2.v
    public final void seekForward() {
        n(getSeekForwardIncrement(), 12);
    }

    @Override // com.google.android.exoplayer2.v
    public final void seekTo(long j) {
        k(j, 5);
    }

    @Override // com.google.android.exoplayer2.v
    public final void seekToDefaultPosition() {
        l(getCurrentMediaItemIndex(), 4);
    }

    @Override // com.google.android.exoplayer2.v
    public final void seekToNext() {
        if (getCurrentTimeline().u() || isPlayingAd()) {
            return;
        }
        if (hasNextMediaItem()) {
            m(9);
        } else if (isCurrentMediaItemLive() && isCurrentMediaItemDynamic()) {
            l(getCurrentMediaItemIndex(), 9);
        }
    }

    @Override // com.google.android.exoplayer2.v
    public final void seekToPrevious() {
        if (getCurrentTimeline().u() || isPlayingAd()) {
            return;
        }
        boolean zHasPreviousMediaItem = hasPreviousMediaItem();
        if (isCurrentMediaItemLive() && !isCurrentMediaItemSeekable()) {
            if (zHasPreviousMediaItem) {
                o(7);
            }
        } else if (!zHasPreviousMediaItem || getCurrentPosition() > getMaxSeekToPreviousPosition()) {
            k(0L, 7);
        } else {
            o(7);
        }
    }

    @Override // com.google.android.exoplayer2.v
    public final void seekTo(int i, long j) {
        j(i, j, 10, false);
    }
}
