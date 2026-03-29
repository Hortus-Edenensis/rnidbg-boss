package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.f0;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.ui.b;
import com.google.android.exoplayer2.v;
import defpackage.g86;
import defpackage.jr1;
import defpackage.k06;
import defpackage.te6;
import defpackage.vh;
import defpackage.wj4;
import defpackage.xr0;
import defpackage.xv4;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class PlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    private static final int MAX_UPDATE_INTERVAL_MS = 1000;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    private long[] adGroupTimesMs;
    private final float buttonAlphaDisabled;
    private final float buttonAlphaEnabled;
    private final c componentListener;
    private long currentBufferedPosition;
    private long currentPosition;
    private long currentWindowOffset;

    @Nullable
    private final TextView durationView;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;

    @Nullable
    private final View fastForwardButton;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private final Runnable hideAction;
    private long hideAtMs;
    private boolean isAttachedToWindow;
    private boolean multiWindowTimeBar;

    @Nullable
    private final View nextButton;

    @Nullable
    private final View pauseButton;
    private final e0.b period;

    @Nullable
    private final View playButton;
    private boolean[] playedAdGroups;

    @Nullable
    private v player;

    @Nullable
    private final TextView positionView;

    @Nullable
    private final View previousButton;

    @Nullable
    private d progressUpdateListener;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;

    @Nullable
    private final ImageView repeatToggleButton;
    private int repeatToggleModes;

    @Nullable
    private final View rewindButton;
    private boolean scrubbing;
    private boolean showFastForwardButton;
    private boolean showMultiWindowTimeBar;
    private boolean showNextButton;
    private boolean showPreviousButton;
    private boolean showRewindButton;
    private boolean showShuffleButton;
    private int showTimeoutMs;

    @Nullable
    private final ImageView shuffleButton;
    private final Drawable shuffleOffButtonDrawable;
    private final String shuffleOffContentDescription;
    private final Drawable shuffleOnButtonDrawable;
    private final String shuffleOnContentDescription;

    @Nullable
    private final com.google.android.exoplayer2.ui.b timeBar;
    private int timeBarMinUpdateIntervalMs;
    private final Runnable updateProgressAction;
    private final CopyOnWriteArrayList<e> visibilityListeners;

    @Nullable
    private final View vrButton;
    private final e0.d window;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(21)
    public static final class b {
        @DoNotInline
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c implements v.d, b.a, View.OnClickListener {
        public c() {
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void B(f0 f0Var) {
            wj4.C(this, f0Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public void D(v vVar, v.c cVar) {
            if (cVar.b(4, 5)) {
                PlayerControlView.this.updatePlayPauseButton();
            }
            if (cVar.b(4, 5, 7)) {
                PlayerControlView.this.updateProgress();
            }
            if (cVar.a(8)) {
                PlayerControlView.this.updateRepeatModeButton();
            }
            if (cVar.a(9)) {
                PlayerControlView.this.updateShuffleButton();
            }
            if (cVar.b(8, 9, 11, 0, 13)) {
                PlayerControlView.this.updateNavigation();
            }
            if (cVar.b(11, 0)) {
                PlayerControlView.this.updateTimeline();
            }
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void I(p pVar, int i) {
            wj4.j(this, pVar, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void d(xr0 xr0Var) {
            wj4.b(this, xr0Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void f(Metadata metadata) {
            wj4.l(this, metadata);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void g(u uVar) {
            wj4.n(this, uVar);
        }

        @Override // com.google.android.exoplayer2.ui.b.a
        public void h(com.google.android.exoplayer2.ui.b bVar, long j, boolean z) {
            PlayerControlView.this.scrubbing = false;
            if (z || PlayerControlView.this.player == null) {
                return;
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.seekToTimeBarPosition(playerControlView.player, j);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void i(te6 te6Var) {
            wj4.D(this, te6Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void l(v.e eVar, v.e eVar2, int i) {
            wj4.u(this, eVar, eVar2, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void m(e0 e0Var, int i) {
            wj4.A(this, e0Var, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void n(q qVar) {
            wj4.k(this, qVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v vVar = PlayerControlView.this.player;
            if (vVar == null) {
                return;
            }
            if (PlayerControlView.this.nextButton == view) {
                vVar.seekToNext();
                return;
            }
            if (PlayerControlView.this.previousButton == view) {
                vVar.seekToPrevious();
                return;
            }
            if (PlayerControlView.this.fastForwardButton == view) {
                if (vVar.getPlaybackState() != 4) {
                    vVar.seekForward();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.rewindButton == view) {
                vVar.seekBack();
                return;
            }
            if (PlayerControlView.this.playButton == view) {
                g86.q0(vVar);
                return;
            }
            if (PlayerControlView.this.pauseButton == view) {
                g86.p0(vVar);
            } else if (PlayerControlView.this.repeatToggleButton == view) {
                vVar.setRepeatMode(xv4.a(vVar.getRepeatMode(), PlayerControlView.this.repeatToggleModes));
            } else if (PlayerControlView.this.shuffleButton == view) {
                vVar.setShuffleModeEnabled(!vVar.getShuffleModeEnabled());
            }
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onCues(List list) {
            wj4.c(this, list);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
            wj4.e(this, i, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            wj4.g(this, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            wj4.h(this, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onLoadingChanged(boolean z) {
            wj4.i(this, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            wj4.m(this, z, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onPlaybackStateChanged(int i) {
            wj4.o(this, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            wj4.p(this, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            wj4.s(this, z, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            wj4.t(this, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onRenderedFirstFrame() {
            wj4.v(this);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onRepeatModeChanged(int i) {
            wj4.w(this, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            wj4.x(this, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            wj4.y(this, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            wj4.z(this, i, i2);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onVolumeChanged(float f) {
            wj4.E(this, f);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void p(PlaybackException playbackException) {
            wj4.r(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.ui.b.a
        public void q(com.google.android.exoplayer2.ui.b bVar, long j) {
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(g86.i0(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, j));
            }
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void r(k06 k06Var) {
            wj4.B(this, k06Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void s(PlaybackException playbackException) {
            wj4.q(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.ui.b.a
        public void t(com.google.android.exoplayer2.ui.b bVar, long j) {
            PlayerControlView.this.scrubbing = true;
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(g86.i0(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, j));
            }
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void w(v.b bVar) {
            wj4.a(this, bVar);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void x(i iVar) {
            wj4.d(this, iVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void h(int i);
    }

    static {
        jr1.a("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    private static boolean canShowMultiWindowTimeBar(e0 e0Var, e0.d dVar) {
        if (e0Var.t() > 100) {
            return false;
        }
        int iT = e0Var.t();
        for (int i = 0; i < iT; i++) {
            if (e0Var.r(i, dVar).n == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    private void hideAfterTimeout() {
        removeCallbacks(this.hideAction);
        if (this.showTimeoutMs <= 0) {
            this.hideAtMs = -9223372036854775807L;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i = this.showTimeoutMs;
        this.hideAtMs = jUptimeMillis + ((long) i);
        if (this.isAttachedToWindow) {
            postDelayed(this.hideAction, i);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static boolean isHandledMediaKey(int i) {
        return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    private void requestPlayPauseAccessibilityFocus() {
        View view;
        View view2;
        boolean zW0 = g86.W0(this.player);
        if (zW0 && (view2 = this.playButton) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (zW0 || (view = this.pauseButton) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    private void requestPlayPauseFocus() {
        View view;
        View view2;
        boolean zW0 = g86.W0(this.player);
        if (zW0 && (view2 = this.playButton) != null) {
            view2.requestFocus();
        } else {
            if (zW0 || (view = this.pauseButton) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    private void seekTo(v vVar, int i, long j) {
        vVar.seekTo(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToTimeBarPosition(v vVar, long j) {
        int currentMediaItemIndex;
        e0 currentTimeline = vVar.getCurrentTimeline();
        if (this.multiWindowTimeBar && !currentTimeline.u()) {
            int iT = currentTimeline.t();
            currentMediaItemIndex = 0;
            while (true) {
                long jF = currentTimeline.r(currentMediaItemIndex, this.window).f();
                if (j < jF) {
                    break;
                }
                if (currentMediaItemIndex == iT - 1) {
                    j = jF;
                    break;
                } else {
                    j -= jF;
                    currentMediaItemIndex++;
                }
            }
        } else {
            currentMediaItemIndex = vVar.getCurrentMediaItemIndex();
        }
        seekTo(vVar, currentMediaItemIndex, j);
        updateProgress();
    }

    private void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateRepeatModeButton();
        updateShuffleButton();
        updateTimeline();
    }

    private void updateButton(boolean z, boolean z2, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z2);
        view.setAlpha(z2 ? this.buttonAlphaEnabled : this.buttonAlphaDisabled);
        view.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigation() {
        boolean zIsCommandAvailable;
        boolean zIsCommandAvailable2;
        boolean zIsCommandAvailable3;
        boolean zIsCommandAvailable4;
        boolean zIsCommandAvailable5;
        if (isVisible() && this.isAttachedToWindow) {
            v vVar = this.player;
            if (vVar != null) {
                zIsCommandAvailable = vVar.isCommandAvailable(5);
                zIsCommandAvailable3 = vVar.isCommandAvailable(7);
                zIsCommandAvailable4 = vVar.isCommandAvailable(11);
                zIsCommandAvailable5 = vVar.isCommandAvailable(12);
                zIsCommandAvailable2 = vVar.isCommandAvailable(9);
            } else {
                zIsCommandAvailable = false;
                zIsCommandAvailable2 = false;
                zIsCommandAvailable3 = false;
                zIsCommandAvailable4 = false;
                zIsCommandAvailable5 = false;
            }
            updateButton(this.showPreviousButton, zIsCommandAvailable3, this.previousButton);
            updateButton(this.showRewindButton, zIsCommandAvailable4, this.rewindButton);
            updateButton(this.showFastForwardButton, zIsCommandAvailable5, this.fastForwardButton);
            updateButton(this.showNextButton, zIsCommandAvailable2, this.nextButton);
            com.google.android.exoplayer2.ui.b bVar = this.timeBar;
            if (bVar != null) {
                bVar.setEnabled(zIsCommandAvailable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayPauseButton() {
        boolean z;
        boolean z2;
        if (isVisible() && this.isAttachedToWindow) {
            boolean zW0 = g86.W0(this.player);
            View view = this.playButton;
            boolean z3 = true;
            if (view != null) {
                z = (!zW0 && view.isFocused()) | false;
                z2 = (g86.f17680a < 21 ? z : !zW0 && b.a(this.playButton)) | false;
                this.playButton.setVisibility(zW0 ? 0 : 8);
            } else {
                z = false;
                z2 = false;
            }
            View view2 = this.pauseButton;
            if (view2 != null) {
                z |= zW0 && view2.isFocused();
                if (g86.f17680a < 21) {
                    z3 = z;
                } else if (!zW0 || !b.a(this.pauseButton)) {
                    z3 = false;
                }
                z2 |= z3;
                this.pauseButton.setVisibility(zW0 ? 8 : 0);
            }
            if (z) {
                requestPlayPauseFocus();
            }
            if (z2) {
                requestPlayPauseAccessibilityFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        long contentPosition;
        long contentBufferedPosition;
        if (isVisible() && this.isAttachedToWindow) {
            v vVar = this.player;
            if (vVar != null) {
                contentPosition = this.currentWindowOffset + vVar.getContentPosition();
                contentBufferedPosition = this.currentWindowOffset + vVar.getContentBufferedPosition();
            } else {
                contentPosition = 0;
                contentBufferedPosition = 0;
            }
            boolean z = contentPosition != this.currentPosition;
            this.currentPosition = contentPosition;
            this.currentBufferedPosition = contentBufferedPosition;
            TextView textView = this.positionView;
            if (textView != null && !this.scrubbing && z) {
                textView.setText(g86.i0(this.formatBuilder, this.formatter, contentPosition));
            }
            com.google.android.exoplayer2.ui.b bVar = this.timeBar;
            if (bVar != null) {
                bVar.setPosition(contentPosition);
                this.timeBar.setBufferedPosition(contentBufferedPosition);
            }
            removeCallbacks(this.updateProgressAction);
            int playbackState = vVar == null ? 1 : vVar.getPlaybackState();
            if (vVar == null || !vVar.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.updateProgressAction, 1000L);
                return;
            }
            com.google.android.exoplayer2.ui.b bVar2 = this.timeBar;
            long jMin = Math.min(bVar2 != null ? bVar2.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f = vVar.getPlaybackParameters().f5989a;
            postDelayed(this.updateProgressAction, g86.r(f > 0.0f ? (long) (jMin / f) : 1000L, this.timeBarMinUpdateIntervalMs, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRepeatModeButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.repeatToggleButton) != null) {
            if (this.repeatToggleModes == 0) {
                updateButton(false, false, imageView);
                return;
            }
            v vVar = this.player;
            if (vVar == null) {
                updateButton(true, false, imageView);
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                return;
            }
            updateButton(true, true, imageView);
            int repeatMode = vVar.getRepeatMode();
            if (repeatMode == 0) {
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
            } else if (repeatMode == 1) {
                this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
            } else if (repeatMode == 2) {
                this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
            }
            this.repeatToggleButton.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShuffleButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.shuffleButton) != null) {
            v vVar = this.player;
            if (!this.showShuffleButton) {
                updateButton(false, false, imageView);
                return;
            }
            if (vVar == null) {
                updateButton(true, false, imageView);
                this.shuffleButton.setImageDrawable(this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(this.shuffleOffContentDescription);
            } else {
                updateButton(true, true, imageView);
                this.shuffleButton.setImageDrawable(vVar.getShuffleModeEnabled() ? this.shuffleOnButtonDrawable : this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(vVar.getShuffleModeEnabled() ? this.shuffleOnContentDescription : this.shuffleOffContentDescription);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateTimeline() {
        int i;
        e0.d dVar;
        long jQ;
        v vVar = this.player;
        if (vVar == null) {
            return;
        }
        boolean z = true;
        this.multiWindowTimeBar = this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(vVar.getCurrentTimeline(), this.window);
        long j = 0;
        this.currentWindowOffset = 0L;
        e0 currentTimeline = vVar.getCurrentTimeline();
        if (currentTimeline.u()) {
            i = 0;
        } else {
            int currentMediaItemIndex = vVar.getCurrentMediaItemIndex();
            boolean z2 = this.multiWindowTimeBar;
            int i2 = z2 ? 0 : currentMediaItemIndex;
            int iT = z2 ? currentTimeline.t() - 1 : currentMediaItemIndex;
            long j2 = 0;
            i = 0;
            while (true) {
                if (i2 > iT) {
                    break;
                }
                if (i2 == currentMediaItemIndex) {
                    this.currentWindowOffset = g86.m1(j2);
                }
                currentTimeline.r(i2, this.window);
                e0.d dVar2 = this.window;
                if (dVar2.n == -9223372036854775807L) {
                    vh.g(this.multiWindowTimeBar ^ z);
                    break;
                }
                int i3 = dVar2.o;
                while (true) {
                    dVar = this.window;
                    if (i3 <= dVar.p) {
                        currentTimeline.j(i3, this.period);
                        int iF = this.period.f();
                        for (int iR = this.period.r(); iR < iF; iR++) {
                            long jI = this.period.i(iR);
                            if (jI == Long.MIN_VALUE) {
                                long j3 = this.period.d;
                                if (j3 != -9223372036854775807L) {
                                    jI = j3;
                                    jQ = jI + this.period.q();
                                    if (jQ < 0) {
                                        long[] jArr = this.adGroupTimesMs;
                                        if (i == jArr.length) {
                                            int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                            this.adGroupTimesMs = Arrays.copyOf(jArr, length);
                                            this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, length);
                                        }
                                        this.adGroupTimesMs[i] = g86.m1(j2 + jQ);
                                        this.playedAdGroups[i] = this.period.s(iR);
                                        i++;
                                    }
                                }
                            } else {
                                jQ = jI + this.period.q();
                                if (jQ < 0) {
                                }
                            }
                        }
                        i3++;
                    }
                }
                j2 += dVar.n;
                i2++;
                z = true;
            }
            j = j2;
        }
        long jM1 = g86.m1(j);
        TextView textView = this.durationView;
        if (textView != null) {
            textView.setText(g86.i0(this.formatBuilder, this.formatter, jM1));
        }
        com.google.android.exoplayer2.ui.b bVar = this.timeBar;
        if (bVar != null) {
            bVar.setDuration(jM1);
            int length2 = this.extraAdGroupTimesMs.length;
            int i4 = i + length2;
            long[] jArr2 = this.adGroupTimesMs;
            if (i4 > jArr2.length) {
                this.adGroupTimesMs = Arrays.copyOf(jArr2, i4);
                this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, i4);
            }
            System.arraycopy(this.extraAdGroupTimesMs, 0, this.adGroupTimesMs, i, length2);
            System.arraycopy(this.extraPlayedAdGroups, 0, this.playedAdGroups, i, length2);
            this.timeBar.setAdGroupTimesMs(this.adGroupTimesMs, this.playedAdGroups, i4);
        }
        updateProgress();
    }

    public void addVisibilityListener(e eVar) {
        vh.e(eVar);
        this.visibilityListeners.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        v vVar = this.player;
        if (vVar == null || !isHandledMediaKey(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (vVar.getPlaybackState() == 4) {
                return true;
            }
            vVar.seekForward();
            return true;
        }
        if (keyCode == 89) {
            vVar.seekBack();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            g86.r0(vVar);
            return true;
        }
        if (keyCode == 87) {
            vVar.seekToNext();
            return true;
        }
        if (keyCode == 88) {
            vVar.seekToPrevious();
            return true;
        }
        if (keyCode == 126) {
            g86.q0(vVar);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        g86.p0(vVar);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.hideAction);
        } else if (motionEvent.getAction() == 1) {
            hideAfterTimeout();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public v getPlayer() {
        return this.player;
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public boolean getShowShuffleButton() {
        return this.showShuffleButton;
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public boolean getShowVrButton() {
        View view = this.vrButton;
        return view != null && view.getVisibility() == 0;
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            Iterator<e> it = this.visibilityListeners.iterator();
            while (it.hasNext()) {
                it.next().h(getVisibility());
            }
            removeCallbacks(this.updateProgressAction);
            removeCallbacks(this.hideAction);
            this.hideAtMs = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        long j = this.hideAtMs;
        if (j != -9223372036854775807L) {
            long jUptimeMillis = j - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.hideAction, jUptimeMillis);
            }
        } else if (isVisible()) {
            hideAfterTimeout();
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        removeCallbacks(this.updateProgressAction);
        removeCallbacks(this.hideAction);
    }

    public void removeVisibilityListener(e eVar) {
        this.visibilityListeners.remove(eVar);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.extraAdGroupTimesMs = new long[0];
            this.extraPlayedAdGroups = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) vh.e(zArr);
            vh.a(jArr.length == zArr2.length);
            this.extraAdGroupTimesMs = jArr;
            this.extraPlayedAdGroups = zArr2;
        }
        updateTimeline();
    }

    public void setPlayer(@Nullable v vVar) {
        boolean z = true;
        vh.g(Looper.myLooper() == Looper.getMainLooper());
        if (vVar != null && vVar.getApplicationLooper() != Looper.getMainLooper()) {
            z = false;
        }
        vh.a(z);
        v vVar2 = this.player;
        if (vVar2 == vVar) {
            return;
        }
        if (vVar2 != null) {
            vVar2.a(this.componentListener);
        }
        this.player = vVar;
        if (vVar != null) {
            vVar.e(this.componentListener);
        }
        updateAll();
    }

    public void setRepeatToggleModes(int i) {
        this.repeatToggleModes = i;
        v vVar = this.player;
        if (vVar != null) {
            int repeatMode = vVar.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.player.setRepeatMode(0);
            } else if (i == 1 && repeatMode == 2) {
                this.player.setRepeatMode(1);
            } else if (i == 2 && repeatMode == 1) {
                this.player.setRepeatMode(2);
            }
        }
        updateRepeatModeButton();
    }

    public void setShowFastForwardButton(boolean z) {
        this.showFastForwardButton = z;
        updateNavigation();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.showMultiWindowTimeBar = z;
        updateTimeline();
    }

    public void setShowNextButton(boolean z) {
        this.showNextButton = z;
        updateNavigation();
    }

    public void setShowPreviousButton(boolean z) {
        this.showPreviousButton = z;
        updateNavigation();
    }

    public void setShowRewindButton(boolean z) {
        this.showRewindButton = z;
        updateNavigation();
    }

    public void setShowShuffleButton(boolean z) {
        this.showShuffleButton = z;
        updateShuffleButton();
    }

    public void setShowTimeoutMs(int i) {
        this.showTimeoutMs = i;
        if (isVisible()) {
            hideAfterTimeout();
        }
    }

    public void setShowVrButton(boolean z) {
        View view = this.vrButton;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.timeBarMinUpdateIntervalMs = g86.q(i, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.vrButton;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            updateButton(getShowVrButton(), onClickListener != null, this.vrButton);
        }
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            Iterator<e> it = this.visibilityListeners.iterator();
            while (it.hasNext()) {
                it.next().h(getVisibility());
            }
            updateAll();
            requestPlayPauseFocus();
            requestPlayPauseAccessibilityFocus();
        }
        hideAfterTimeout();
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int getRepeatToggleModes(TypedArray typedArray, int i) {
        return typedArray.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, i);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int resourceId = R$layout.exo_player_control_view;
        this.showTimeoutMs = 5000;
        this.repeatToggleModes = 0;
        this.timeBarMinUpdateIntervalMs = 200;
        this.hideAtMs = -9223372036854775807L;
        this.showRewindButton = true;
        this.showFastForwardButton = true;
        this.showPreviousButton = true;
        this.showNextButton = true;
        this.showShuffleButton = false;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, i, 0);
            try {
                this.showTimeoutMs = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, this.showTimeoutMs);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, resourceId);
                this.repeatToggleModes = getRepeatToggleModes(typedArrayObtainStyledAttributes, this.repeatToggleModes);
                this.showRewindButton = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_rewind_button, this.showRewindButton);
                this.showFastForwardButton = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_fastforward_button, this.showFastForwardButton);
                this.showPreviousButton = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_previous_button, this.showPreviousButton);
                this.showNextButton = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_next_button, this.showNextButton);
                this.showShuffleButton = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, this.showShuffleButton);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_time_bar_min_update_interval, this.timeBarMinUpdateIntervalMs));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.visibilityListeners = new CopyOnWriteArrayList<>();
        this.period = new e0.b();
        this.window = new e0.d();
        StringBuilder sb = new StringBuilder();
        this.formatBuilder = sb;
        this.formatter = new Formatter(sb, Locale.getDefault());
        this.adGroupTimesMs = new long[0];
        this.playedAdGroups = new boolean[0];
        this.extraAdGroupTimesMs = new long[0];
        this.extraPlayedAdGroups = new boolean[0];
        c cVar = new c();
        this.componentListener = cVar;
        this.updateProgressAction = new Runnable() { // from class: zj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f22437a.updateProgress();
            }
        };
        this.hideAction = new Runnable() { // from class: ak4
            @Override // java.lang.Runnable
            public final void run() {
                this.f1246a.hide();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        int i2 = R$id.exo_progress;
        com.google.android.exoplayer2.ui.b bVar = (com.google.android.exoplayer2.ui.b) findViewById(i2);
        View viewFindViewById = findViewById(R$id.exo_progress_placeholder);
        if (bVar != null) {
            this.timeBar = bVar;
        } else if (viewFindViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(i2);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.timeBar = defaultTimeBar;
        } else {
            this.timeBar = null;
        }
        this.durationView = (TextView) findViewById(R$id.exo_duration);
        this.positionView = (TextView) findViewById(R$id.exo_position);
        com.google.android.exoplayer2.ui.b bVar2 = this.timeBar;
        if (bVar2 != null) {
            bVar2.addListener(cVar);
        }
        View viewFindViewById2 = findViewById(R$id.exo_play);
        this.playButton = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R$id.exo_pause);
        this.pauseButton = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        View viewFindViewById4 = findViewById(R$id.exo_prev);
        this.previousButton = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(cVar);
        }
        View viewFindViewById5 = findViewById(R$id.exo_next);
        this.nextButton = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R$id.exo_rew);
        this.rewindButton = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R$id.exo_ffwd);
        this.fastForwardButton = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.repeatToggleButton = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_shuffle);
        this.shuffleButton = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View viewFindViewById8 = findViewById(R$id.exo_vr);
        this.vrButton = viewFindViewById8;
        setShowVrButton(false);
        updateButton(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.buttonAlphaEnabled = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.buttonAlphaDisabled = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.repeatOffButtonDrawable = g86.U(context, resources, R$drawable.exo_controls_repeat_off);
        this.repeatOneButtonDrawable = g86.U(context, resources, R$drawable.exo_controls_repeat_one);
        this.repeatAllButtonDrawable = g86.U(context, resources, R$drawable.exo_controls_repeat_all);
        this.shuffleOnButtonDrawable = g86.U(context, resources, R$drawable.exo_controls_shuffle_on);
        this.shuffleOffButtonDrawable = g86.U(context, resources, R$drawable.exo_controls_shuffle_off);
        this.repeatOffButtonContentDescription = resources.getString(R$string.exo_controls_repeat_off_description);
        this.repeatOneButtonContentDescription = resources.getString(R$string.exo_controls_repeat_one_description);
        this.repeatAllButtonContentDescription = resources.getString(R$string.exo_controls_repeat_all_description);
        this.shuffleOnContentDescription = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.shuffleOffContentDescription = resources.getString(R$string.exo_controls_shuffle_off_description);
        this.currentPosition = -9223372036854775807L;
        this.currentBufferedPosition = -9223372036854775807L;
    }

    public void setProgressUpdateListener(@Nullable d dVar) {
    }
}
