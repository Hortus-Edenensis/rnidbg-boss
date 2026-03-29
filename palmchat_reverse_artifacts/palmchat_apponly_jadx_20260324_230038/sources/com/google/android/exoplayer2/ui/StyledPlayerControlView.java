package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.common.C;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.f0;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.ui.b;
import com.google.android.exoplayer2.v;
import com.google.common.collect.ImmutableList;
import defpackage.b91;
import defpackage.g06;
import defpackage.g86;
import defpackage.jr1;
import defpackage.k06;
import defpackage.mm5;
import defpackage.qz5;
import defpackage.te6;
import defpackage.vh;
import defpackage.wj4;
import defpackage.xr0;
import defpackage.xv4;
import defpackage.yz5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class StyledPlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    private static final int MAX_UPDATE_INTERVAL_MS = 1000;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    private static final float[] PLAYBACK_SPEEDS;
    private static final int SETTINGS_AUDIO_TRACK_SELECTION_POSITION = 1;
    private static final int SETTINGS_PLAYBACK_SPEED_POSITION = 0;
    private long[] adGroupTimesMs;

    @Nullable
    private final View audioTrackButton;
    private final b audioTrackSelectionAdapter;
    private final float buttonAlphaDisabled;
    private final float buttonAlphaEnabled;
    private final c componentListener;
    private final mm5 controlViewLayoutManager;
    private long currentWindowOffset;

    @Nullable
    private final TextView durationView;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;

    @Nullable
    private final View fastForwardButton;

    @Nullable
    private final TextView fastForwardButtonTextView;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;

    @Nullable
    private final ImageView fullScreenButton;
    private final String fullScreenEnterContentDescription;
    private final Drawable fullScreenEnterDrawable;
    private final String fullScreenExitContentDescription;
    private final Drawable fullScreenExitDrawable;
    private boolean isAttachedToWindow;
    private boolean isFullScreen;

    @Nullable
    private final ImageView minimalFullScreenButton;
    private boolean multiWindowTimeBar;
    private boolean needToHideBars;

    @Nullable
    private final View nextButton;

    @Nullable
    private d onFullScreenModeChangedListener;
    private final e0.b period;

    @Nullable
    private final View playPauseButton;
    private final e playbackSpeedAdapter;

    @Nullable
    private final View playbackSpeedButton;
    private boolean[] playedAdGroups;

    @Nullable
    private v player;

    @Nullable
    private final TextView positionView;

    @Nullable
    private final View previousButton;

    @Nullable
    private f progressUpdateListener;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;

    @Nullable
    private final ImageView repeatToggleButton;
    private int repeatToggleModes;
    private final Resources resources;

    @Nullable
    private final View rewindButton;

    @Nullable
    private final TextView rewindButtonTextView;
    private boolean scrubbing;
    private final h settingsAdapter;

    @Nullable
    private final View settingsButton;
    private final RecyclerView settingsView;
    private final PopupWindow settingsWindow;
    private final int settingsWindowMargin;
    private boolean showMultiWindowTimeBar;
    private int showTimeoutMs;

    @Nullable
    private final ImageView shuffleButton;
    private final Drawable shuffleOffButtonDrawable;
    private final String shuffleOffContentDescription;
    private final Drawable shuffleOnButtonDrawable;
    private final String shuffleOnContentDescription;

    @Nullable
    private final ImageView subtitleButton;
    private final Drawable subtitleOffButtonDrawable;
    private final String subtitleOffContentDescription;
    private final Drawable subtitleOnButtonDrawable;
    private final String subtitleOnContentDescription;
    private final j textTrackSelectionAdapter;

    @Nullable
    private final com.google.android.exoplayer2.ui.b timeBar;
    private int timeBarMinUpdateIntervalMs;
    private final yz5 trackNameProvider;
    private final Runnable updateProgressAction;
    private final CopyOnWriteArrayList<m> visibilityListeners;

    @Nullable
    private final View vrButton;
    private final e0.d window;

    /* JADX INFO: compiled from: SearchBox */
    public final class b extends l {
        public b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(View view) {
            if (StyledPlayerControlView.this.player == null || !StyledPlayerControlView.this.player.isCommandAvailable(29)) {
                return;
            }
            ((v) g86.j(StyledPlayerControlView.this.player)).c(StyledPlayerControlView.this.player.getTrackSelectionParameters().A().B(1).J(1, false).A());
            StyledPlayerControlView.this.settingsAdapter.f(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
            StyledPlayerControlView.this.settingsWindow.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void e(i iVar) {
            iVar.d.setText(R$string.exo_track_selection_auto);
            iVar.e.setVisibility(i(((v) vh.e(StyledPlayerControlView.this.player)).getTrackSelectionParameters()) ? 4 : 0);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ul5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f21241a.k(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void g(String str) {
            StyledPlayerControlView.this.settingsAdapter.f(1, str);
        }

        public final boolean i(k06 k06Var) {
            for (int i = 0; i < this.e.size(); i++) {
                if (k06Var.y.containsKey(this.e.get(i).f5995a.b())) {
                    return true;
                }
            }
            return false;
        }

        public void j(List<k> list) {
            this.e = list;
            k06 trackSelectionParameters = ((v) vh.e(StyledPlayerControlView.this.player)).getTrackSelectionParameters();
            if (list.isEmpty()) {
                StyledPlayerControlView.this.settingsAdapter.f(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_none));
                return;
            }
            if (!i(trackSelectionParameters)) {
                StyledPlayerControlView.this.settingsAdapter.f(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                k kVar = list.get(i);
                if (kVar.a()) {
                    StyledPlayerControlView.this.settingsAdapter.f(1, kVar.c);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c implements v.d, b.a, View.OnClickListener, PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void B(f0 f0Var) {
            wj4.C(this, f0Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public void D(v vVar, v.c cVar) {
            if (cVar.b(4, 5, 13)) {
                StyledPlayerControlView.this.updatePlayPauseButton();
            }
            if (cVar.b(4, 5, 7, 13)) {
                StyledPlayerControlView.this.updateProgress();
            }
            if (cVar.b(8, 13)) {
                StyledPlayerControlView.this.updateRepeatModeButton();
            }
            if (cVar.b(9, 13)) {
                StyledPlayerControlView.this.updateShuffleButton();
            }
            if (cVar.b(8, 9, 11, 0, 16, 17, 13)) {
                StyledPlayerControlView.this.updateNavigation();
            }
            if (cVar.b(11, 0, 13)) {
                StyledPlayerControlView.this.updateTimeline();
            }
            if (cVar.b(12, 13)) {
                StyledPlayerControlView.this.updatePlaybackSpeedList();
            }
            if (cVar.b(2, 13)) {
                StyledPlayerControlView.this.updateTrackLists();
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
            StyledPlayerControlView.this.scrubbing = false;
            if (!z && StyledPlayerControlView.this.player != null) {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.seekToTimeBarPosition(styledPlayerControlView.player, j);
            }
            StyledPlayerControlView.this.controlViewLayoutManager.X();
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
            v vVar = StyledPlayerControlView.this.player;
            if (vVar == null) {
                return;
            }
            StyledPlayerControlView.this.controlViewLayoutManager.X();
            if (StyledPlayerControlView.this.nextButton == view) {
                if (vVar.isCommandAvailable(9)) {
                    vVar.seekToNext();
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.previousButton == view) {
                if (vVar.isCommandAvailable(7)) {
                    vVar.seekToPrevious();
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.fastForwardButton == view) {
                if (vVar.getPlaybackState() == 4 || !vVar.isCommandAvailable(12)) {
                    return;
                }
                vVar.seekForward();
                return;
            }
            if (StyledPlayerControlView.this.rewindButton == view) {
                if (vVar.isCommandAvailable(11)) {
                    vVar.seekBack();
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.playPauseButton == view) {
                g86.r0(vVar);
                return;
            }
            if (StyledPlayerControlView.this.repeatToggleButton == view) {
                if (vVar.isCommandAvailable(15)) {
                    vVar.setRepeatMode(xv4.a(vVar.getRepeatMode(), StyledPlayerControlView.this.repeatToggleModes));
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.shuffleButton == view) {
                if (vVar.isCommandAvailable(14)) {
                    vVar.setShuffleModeEnabled(!vVar.getShuffleModeEnabled());
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.settingsButton == view) {
                StyledPlayerControlView.this.controlViewLayoutManager.W();
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.displaySettingsWindow(styledPlayerControlView.settingsAdapter, StyledPlayerControlView.this.settingsButton);
                return;
            }
            if (StyledPlayerControlView.this.playbackSpeedButton == view) {
                StyledPlayerControlView.this.controlViewLayoutManager.W();
                StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                styledPlayerControlView2.displaySettingsWindow(styledPlayerControlView2.playbackSpeedAdapter, StyledPlayerControlView.this.playbackSpeedButton);
            } else if (StyledPlayerControlView.this.audioTrackButton == view) {
                StyledPlayerControlView.this.controlViewLayoutManager.W();
                StyledPlayerControlView styledPlayerControlView3 = StyledPlayerControlView.this;
                styledPlayerControlView3.displaySettingsWindow(styledPlayerControlView3.audioTrackSelectionAdapter, StyledPlayerControlView.this.audioTrackButton);
            } else if (StyledPlayerControlView.this.subtitleButton == view) {
                StyledPlayerControlView.this.controlViewLayoutManager.W();
                StyledPlayerControlView styledPlayerControlView4 = StyledPlayerControlView.this;
                styledPlayerControlView4.displaySettingsWindow(styledPlayerControlView4.textTrackSelectionAdapter, StyledPlayerControlView.this.subtitleButton);
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

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (StyledPlayerControlView.this.needToHideBars) {
                StyledPlayerControlView.this.controlViewLayoutManager.X();
            }
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
            if (StyledPlayerControlView.this.positionView != null) {
                StyledPlayerControlView.this.positionView.setText(g86.i0(StyledPlayerControlView.this.formatBuilder, StyledPlayerControlView.this.formatter, j));
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
            StyledPlayerControlView.this.scrubbing = true;
            if (StyledPlayerControlView.this.positionView != null) {
                StyledPlayerControlView.this.positionView.setText(g86.i0(StyledPlayerControlView.this.formatBuilder, StyledPlayerControlView.this.formatter, j));
            }
            StyledPlayerControlView.this.controlViewLayoutManager.W();
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void w(v.b bVar) {
            wj4.a(this, bVar);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void x(com.google.android.exoplayer2.i iVar) {
            wj4.d(this, iVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public interface d {
        void q(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class e extends RecyclerView.Adapter<i> {
        public final String[] e;
        public final float[] f;
        public int g;

        public e(String[] strArr, float[] fArr) {
            this.e = strArr;
            this.f = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i, View view) {
            if (i != this.g) {
                StyledPlayerControlView.this.setPlaybackSpeed(this.f[i]);
            }
            StyledPlayerControlView.this.settingsWindow.dismiss();
        }

        public String b() {
            return this.e[this.g];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, final int i) {
            String[] strArr = this.e;
            if (i < strArr.length) {
                iVar.d.setText(strArr[i]);
            }
            if (i == this.g) {
                iVar.itemView.setSelected(true);
                iVar.e.setVisibility(0);
            } else {
                iVar.itemView.setSelected(false);
                iVar.e.setVisibility(4);
            }
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: vl5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f21476a.c(i, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public void f(float f) {
            int i = 0;
            int i2 = 0;
            float f2 = Float.MAX_VALUE;
            while (true) {
                float[] fArr = this.f;
                if (i >= fArr.length) {
                    this.g = i2;
                    return;
                }
                float fAbs = Math.abs(f - fArr[i]);
                if (fAbs < f2) {
                    i2 = i;
                    f2 = fAbs;
                }
                i++;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.e.length;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class g extends RecyclerView.ViewHolder {
        public final TextView d;
        public final TextView e;
        public final ImageView f;

        public g(View view) {
            super(view);
            if (g86.f17680a < 26) {
                view.setFocusable(true);
            }
            this.d = (TextView) view.findViewById(R$id.exo_main_text);
            this.e = (TextView) view.findViewById(R$id.exo_sub_text);
            this.f = (ImageView) view.findViewById(R$id.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: wl5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f21746a.p(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(View view) {
            StyledPlayerControlView.this.onSettingViewClicked(getAdapterPosition());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends RecyclerView.Adapter<g> {
        public final String[] e;
        public final String[] f;
        public final Drawable[] g;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.e = strArr;
            this.f = new String[strArr.length];
            this.g = drawableArr;
        }

        public boolean a() {
            return g(1) || g(0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i) {
            if (g(i)) {
                gVar.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                gVar.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
            gVar.d.setText(this.e[i]);
            if (this.f[i] == null) {
                gVar.e.setVisibility(8);
            } else {
                gVar.e.setText(this.f[i]);
            }
            if (this.g[i] == null) {
                gVar.f.setVisibility(8);
            } else {
                gVar.f.setImageDrawable(this.g[i]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i) {
            return StyledPlayerControlView.this.new g(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_settings_list_item, viewGroup, false));
        }

        public void f(int i, String str) {
            this.f[i] = str;
        }

        public final boolean g(int i) {
            if (StyledPlayerControlView.this.player == null) {
                return false;
            }
            if (i == 0) {
                return StyledPlayerControlView.this.player.isCommandAvailable(13);
            }
            if (i != 1) {
                return true;
            }
            return StyledPlayerControlView.this.player.isCommandAvailable(30) && StyledPlayerControlView.this.player.isCommandAvailable(29);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.e.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i extends RecyclerView.ViewHolder {
        public final TextView d;
        public final View e;

        public i(View view) {
            super(view);
            if (g86.f17680a < 26) {
                view.setFocusable(true);
            }
            this.d = (TextView) view.findViewById(R$id.exo_text);
            this.e = view.findViewById(R$id.exo_check);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f0.a f5995a;
        public final int b;
        public final String c;

        public k(f0 f0Var, int i, int i2, String str) {
            this.f5995a = f0Var.b().get(i);
            this.b = i2;
            this.c = str;
        }

        public boolean a() {
            return this.f5995a.h(this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public abstract class l extends RecyclerView.Adapter<i> {
        public List<k> e = new ArrayList();

        public l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(v vVar, qz5 qz5Var, k kVar, View view) {
            if (vVar.isCommandAvailable(29)) {
                vVar.c(vVar.getTrackSelectionParameters().A().G(new g06(qz5Var, ImmutableList.of(Integer.valueOf(kVar.b)))).J(kVar.f5995a.d(), false).A());
                g(kVar.c);
                StyledPlayerControlView.this.settingsWindow.dismiss();
            }
        }

        public void b() {
            this.e = Collections.emptyList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: d */
        public void onBindViewHolder(i iVar, int i) {
            final v vVar = StyledPlayerControlView.this.player;
            if (vVar == null) {
                return;
            }
            if (i == 0) {
                e(iVar);
                return;
            }
            final k kVar = this.e.get(i - 1);
            final qz5 qz5VarB = kVar.f5995a.b();
            boolean z = vVar.getTrackSelectionParameters().y.get(qz5VarB) != null && kVar.a();
            iVar.d.setText(kVar.c);
            iVar.e.setVisibility(z ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: yl5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f22221a.c(vVar, qz5VarB, kVar, view);
                }
            });
        }

        public abstract void e(i iVar);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public abstract void g(String str);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.e.isEmpty()) {
                return 0;
            }
            return this.e.size() + 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public interface m {
        void h(int i);
    }

    static {
        jr1.a("goog.exo.ui");
        PLAYBACK_SPEEDS = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    private static boolean canShowMultiWindowTimeBar(v vVar, e0.d dVar) {
        e0 currentTimeline;
        int iT;
        if (!vVar.isCommandAvailable(17) || (iT = (currentTimeline = vVar.getCurrentTimeline()).t()) <= 1 || iT > 100) {
            return false;
        }
        for (int i2 = 0; i2 < iT; i2++) {
            if (currentTimeline.r(i2, dVar).n == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displaySettingsWindow(RecyclerView.Adapter<?> adapter, View view) {
        this.settingsView.setAdapter(adapter);
        updateSettingsWindowSize();
        this.needToHideBars = false;
        this.settingsWindow.dismiss();
        this.needToHideBars = true;
        this.settingsWindow.showAsDropDown(view, (getWidth() - this.settingsWindow.getWidth()) - this.settingsWindowMargin, (-this.settingsWindow.getHeight()) - this.settingsWindowMargin);
    }

    private ImmutableList<k> gatherSupportedTrackInfosOfType(f0 f0Var, int i2) {
        ImmutableList.a aVar = new ImmutableList.a();
        ImmutableList<f0.a> immutableListB = f0Var.b();
        for (int i3 = 0; i3 < immutableListB.size(); i3++) {
            f0.a aVar2 = immutableListB.get(i3);
            if (aVar2.d() == i2) {
                for (int i4 = 0; i4 < aVar2.f5874a; i4++) {
                    if (aVar2.i(i4)) {
                        com.google.android.exoplayer2.m mVarC = aVar2.c(i4);
                        if ((mVarC.d & 2) == 0) {
                            aVar.a(new k(f0Var, i3, i4, this.trackNameProvider.a(mVarC)));
                        }
                    }
                }
            }
        }
        return aVar.e();
    }

    private void initTrackSelectionAdapter() {
        this.textTrackSelectionAdapter.b();
        this.audioTrackSelectionAdapter.b();
        v vVar = this.player;
        if (vVar != null && vVar.isCommandAvailable(30) && this.player.isCommandAvailable(29)) {
            f0 currentTracks = this.player.getCurrentTracks();
            this.audioTrackSelectionAdapter.j(gatherSupportedTrackInfosOfType(currentTracks, 1));
            if (this.controlViewLayoutManager.A(this.subtitleButton)) {
                this.textTrackSelectionAdapter.i(gatherSupportedTrackInfosOfType(currentTracks, 3));
            } else {
                this.textTrackSelectionAdapter.i(ImmutableList.of());
            }
        }
    }

    private static void initializeFullScreenButton(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    @SuppressLint({"InlinedApi"})
    private static boolean isHandledMediaKey(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFullScreenButtonClicked(View view) {
        if (this.onFullScreenModeChangedListener == null) {
            return;
        }
        boolean z = !this.isFullScreen;
        this.isFullScreen = z;
        updateFullScreenButtonForState(this.fullScreenButton, z);
        updateFullScreenButtonForState(this.minimalFullScreenButton, this.isFullScreen);
        d dVar = this.onFullScreenModeChangedListener;
        if (dVar != null) {
            dVar.q(this.isFullScreen);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i5 - i3;
        int i11 = i9 - i7;
        if (!(i4 - i2 == i8 - i6 && i10 == i11) && this.settingsWindow.isShowing()) {
            updateSettingsWindowSize();
            this.settingsWindow.update(view, (getWidth() - this.settingsWindow.getWidth()) - this.settingsWindowMargin, (-this.settingsWindow.getHeight()) - this.settingsWindowMargin, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSettingViewClicked(int i2) {
        if (i2 == 0) {
            displaySettingsWindow(this.playbackSpeedAdapter, (View) vh.e(this.settingsButton));
        } else if (i2 == 1) {
            displaySettingsWindow(this.audioTrackSelectionAdapter, (View) vh.e(this.settingsButton));
        } else {
            this.settingsWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToTimeBarPosition(v vVar, long j2) {
        if (this.multiWindowTimeBar) {
            if (vVar.isCommandAvailable(17) && vVar.isCommandAvailable(10)) {
                e0 currentTimeline = vVar.getCurrentTimeline();
                int iT = currentTimeline.t();
                int i2 = 0;
                while (true) {
                    long jF = currentTimeline.r(i2, this.window).f();
                    if (j2 < jF) {
                        break;
                    }
                    if (i2 == iT - 1) {
                        j2 = jF;
                        break;
                    } else {
                        j2 -= jF;
                        i2++;
                    }
                }
                vVar.seekTo(i2, j2);
            }
        } else if (vVar.isCommandAvailable(5)) {
            vVar.seekTo(j2);
        }
        updateProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f2) {
        v vVar = this.player;
        if (vVar == null || !vVar.isCommandAvailable(13)) {
            return;
        }
        v vVar2 = this.player;
        vVar2.b(vVar2.getPlaybackParameters().d(f2));
    }

    private boolean shouldEnablePlayPauseButton() {
        v vVar = this.player;
        return (vVar == null || !vVar.isCommandAvailable(1) || (this.player.isCommandAvailable(17) && this.player.getCurrentTimeline().u())) ? false : true;
    }

    private void updateButton(boolean z, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        view.setAlpha(z ? this.buttonAlphaEnabled : this.buttonAlphaDisabled);
    }

    private void updateFastForwardButton() {
        v vVar = this.player;
        int seekForwardIncrement = (int) ((vVar != null ? vVar.getSeekForwardIncrement() : C.DEFAULT_SEEK_FORWARD_INCREMENT_MS) / 1000);
        TextView textView = this.fastForwardButtonTextView;
        if (textView != null) {
            textView.setText(String.valueOf(seekForwardIncrement));
        }
        View view = this.fastForwardButton;
        if (view != null) {
            view.setContentDescription(this.resources.getQuantityString(R$plurals.exo_controls_fastforward_by_amount_description, seekForwardIncrement, Integer.valueOf(seekForwardIncrement)));
        }
    }

    private void updateFullScreenButtonForState(@Nullable ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(this.fullScreenExitDrawable);
            imageView.setContentDescription(this.fullScreenExitContentDescription);
        } else {
            imageView.setImageDrawable(this.fullScreenEnterDrawable);
            imageView.setContentDescription(this.fullScreenEnterContentDescription);
        }
    }

    private static void updateFullScreenButtonVisibility(@Nullable View view, boolean z) {
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
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
                zIsCommandAvailable = (this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(vVar, this.window)) ? vVar.isCommandAvailable(10) : vVar.isCommandAvailable(5);
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
            if (zIsCommandAvailable4) {
                updateRewindButton();
            }
            if (zIsCommandAvailable5) {
                updateFastForwardButton();
            }
            updateButton(zIsCommandAvailable3, this.previousButton);
            updateButton(zIsCommandAvailable4, this.rewindButton);
            updateButton(zIsCommandAvailable5, this.fastForwardButton);
            updateButton(zIsCommandAvailable2, this.nextButton);
            com.google.android.exoplayer2.ui.b bVar = this.timeBar;
            if (bVar != null) {
                bVar.setEnabled(zIsCommandAvailable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayPauseButton() {
        if (isVisible() && this.isAttachedToWindow && this.playPauseButton != null) {
            boolean zW0 = g86.W0(this.player);
            int i2 = zW0 ? R$drawable.exo_styled_controls_play : R$drawable.exo_styled_controls_pause;
            int i3 = zW0 ? R$string.exo_controls_play_description : R$string.exo_controls_pause_description;
            ((ImageView) this.playPauseButton).setImageDrawable(g86.U(getContext(), this.resources, i2));
            this.playPauseButton.setContentDescription(this.resources.getString(i3));
            updateButton(shouldEnablePlayPauseButton(), this.playPauseButton);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaybackSpeedList() {
        v vVar = this.player;
        if (vVar == null) {
            return;
        }
        this.playbackSpeedAdapter.f(vVar.getPlaybackParameters().f5989a);
        this.settingsAdapter.f(0, this.playbackSpeedAdapter.b());
        updateSettingsButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        long contentPosition;
        long contentBufferedPosition;
        if (isVisible() && this.isAttachedToWindow) {
            v vVar = this.player;
            if (vVar == null || !vVar.isCommandAvailable(16)) {
                contentPosition = 0;
                contentBufferedPosition = 0;
            } else {
                contentPosition = this.currentWindowOffset + vVar.getContentPosition();
                contentBufferedPosition = this.currentWindowOffset + vVar.getContentBufferedPosition();
            }
            TextView textView = this.positionView;
            if (textView != null && !this.scrubbing) {
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
            float f2 = vVar.getPlaybackParameters().f5989a;
            postDelayed(this.updateProgressAction, g86.r(f2 > 0.0f ? (long) (jMin / f2) : 1000L, this.timeBarMinUpdateIntervalMs, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRepeatModeButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.repeatToggleButton) != null) {
            if (this.repeatToggleModes == 0) {
                updateButton(false, imageView);
                return;
            }
            v vVar = this.player;
            if (vVar == null || !vVar.isCommandAvailable(15)) {
                updateButton(false, this.repeatToggleButton);
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                return;
            }
            updateButton(true, this.repeatToggleButton);
            int repeatMode = vVar.getRepeatMode();
            if (repeatMode == 0) {
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
            } else if (repeatMode == 1) {
                this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
            }
        }
    }

    private void updateRewindButton() {
        v vVar = this.player;
        int seekBackIncrement = (int) ((vVar != null ? vVar.getSeekBackIncrement() : 5000L) / 1000);
        TextView textView = this.rewindButtonTextView;
        if (textView != null) {
            textView.setText(String.valueOf(seekBackIncrement));
        }
        View view = this.rewindButton;
        if (view != null) {
            view.setContentDescription(this.resources.getQuantityString(R$plurals.exo_controls_rewind_by_amount_description, seekBackIncrement, Integer.valueOf(seekBackIncrement)));
        }
    }

    private void updateSettingsButton() {
        updateButton(this.settingsAdapter.a(), this.settingsButton);
    }

    private void updateSettingsWindowSize() {
        this.settingsView.measure(0, 0);
        this.settingsWindow.setWidth(Math.min(this.settingsView.getMeasuredWidth(), getWidth() - (this.settingsWindowMargin * 2)));
        this.settingsWindow.setHeight(Math.min(getHeight() - (this.settingsWindowMargin * 2), this.settingsView.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShuffleButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.shuffleButton) != null) {
            v vVar = this.player;
            if (!this.controlViewLayoutManager.A(imageView)) {
                updateButton(false, this.shuffleButton);
                return;
            }
            if (vVar == null || !vVar.isCommandAvailable(14)) {
                updateButton(false, this.shuffleButton);
                this.shuffleButton.setImageDrawable(this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(this.shuffleOffContentDescription);
            } else {
                updateButton(true, this.shuffleButton);
                this.shuffleButton.setImageDrawable(vVar.getShuffleModeEnabled() ? this.shuffleOnButtonDrawable : this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(vVar.getShuffleModeEnabled() ? this.shuffleOnContentDescription : this.shuffleOffContentDescription);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateTimeline() {
        long jH0;
        int i2;
        e0.d dVar;
        long jQ;
        v vVar = this.player;
        if (vVar == null) {
            return;
        }
        boolean z = true;
        this.multiWindowTimeBar = this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(vVar, this.window);
        this.currentWindowOffset = 0L;
        e0 currentTimeline = vVar.isCommandAvailable(17) ? vVar.getCurrentTimeline() : e0.f5869a;
        if (!currentTimeline.u()) {
            int currentMediaItemIndex = vVar.getCurrentMediaItemIndex();
            boolean z2 = this.multiWindowTimeBar;
            int i3 = z2 ? 0 : currentMediaItemIndex;
            int iT = z2 ? currentTimeline.t() - 1 : currentMediaItemIndex;
            long j2 = 0;
            i2 = 0;
            while (true) {
                if (i3 > iT) {
                    break;
                }
                if (i3 == currentMediaItemIndex) {
                    this.currentWindowOffset = g86.m1(j2);
                }
                currentTimeline.r(i3, this.window);
                e0.d dVar2 = this.window;
                if (dVar2.n == -9223372036854775807L) {
                    vh.g(this.multiWindowTimeBar ^ z);
                    break;
                }
                int i4 = dVar2.o;
                while (true) {
                    dVar = this.window;
                    if (i4 <= dVar.p) {
                        currentTimeline.j(i4, this.period);
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
                                        if (i2 == jArr.length) {
                                            int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                            this.adGroupTimesMs = Arrays.copyOf(jArr, length);
                                            this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, length);
                                        }
                                        this.adGroupTimesMs[i2] = g86.m1(j2 + jQ);
                                        this.playedAdGroups[i2] = this.period.s(iR);
                                        i2++;
                                    }
                                }
                            } else {
                                jQ = jI + this.period.q();
                                if (jQ < 0) {
                                }
                            }
                        }
                        i4++;
                    }
                }
                j2 += dVar.n;
                i3++;
                z = true;
            }
            jH0 = j2;
        } else if (vVar.isCommandAvailable(16)) {
            long contentDuration = vVar.getContentDuration();
            jH0 = contentDuration != -9223372036854775807L ? g86.H0(contentDuration) : 0L;
            i2 = 0;
        }
        long jM1 = g86.m1(jH0);
        TextView textView = this.durationView;
        if (textView != null) {
            textView.setText(g86.i0(this.formatBuilder, this.formatter, jM1));
        }
        com.google.android.exoplayer2.ui.b bVar = this.timeBar;
        if (bVar != null) {
            bVar.setDuration(jM1);
            int length2 = this.extraAdGroupTimesMs.length;
            int i5 = i2 + length2;
            long[] jArr2 = this.adGroupTimesMs;
            if (i5 > jArr2.length) {
                this.adGroupTimesMs = Arrays.copyOf(jArr2, i5);
                this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, i5);
            }
            System.arraycopy(this.extraAdGroupTimesMs, 0, this.adGroupTimesMs, i2, length2);
            System.arraycopy(this.extraPlayedAdGroups, 0, this.playedAdGroups, i2, length2);
            this.timeBar.setAdGroupTimesMs(this.adGroupTimesMs, this.playedAdGroups, i5);
        }
        updateProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrackLists() {
        initTrackSelectionAdapter();
        updateButton(this.textTrackSelectionAdapter.getItemCount() > 0, this.subtitleButton);
        updateSettingsButton();
    }

    @Deprecated
    public void addVisibilityListener(m mVar) {
        vh.e(mVar);
        this.visibilityListeners.add(mVar);
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
            if (vVar.getPlaybackState() == 4 || !vVar.isCommandAvailable(12)) {
                return true;
            }
            vVar.seekForward();
            return true;
        }
        if (keyCode == 89 && vVar.isCommandAvailable(11)) {
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
            if (!vVar.isCommandAvailable(9)) {
                return true;
            }
            vVar.seekToNext();
            return true;
        }
        if (keyCode == 88) {
            if (!vVar.isCommandAvailable(7)) {
                return true;
            }
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

    @Nullable
    public v getPlayer() {
        return this.player;
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public boolean getShowShuffleButton() {
        return this.controlViewLayoutManager.A(this.shuffleButton);
    }

    public boolean getShowSubtitleButton() {
        return this.controlViewLayoutManager.A(this.subtitleButton);
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public boolean getShowVrButton() {
        return this.controlViewLayoutManager.A(this.vrButton);
    }

    public void hide() {
        this.controlViewLayoutManager.C();
    }

    public void hideImmediately() {
        this.controlViewLayoutManager.F();
    }

    public boolean isAnimationEnabled() {
        return this.controlViewLayoutManager.I();
    }

    public boolean isFullyVisible() {
        return this.controlViewLayoutManager.J();
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void notifyOnVisibilityChange() {
        Iterator<m> it = this.visibilityListeners.iterator();
        while (it.hasNext()) {
            it.next().h(getVisibility());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.controlViewLayoutManager.P();
        this.isAttachedToWindow = true;
        if (isFullyVisible()) {
            this.controlViewLayoutManager.X();
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.controlViewLayoutManager.Q();
        this.isAttachedToWindow = false;
        removeCallbacks(this.updateProgressAction);
        this.controlViewLayoutManager.W();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.controlViewLayoutManager.R(z, i2, i3, i4, i5);
    }

    @Deprecated
    public void removeVisibilityListener(m mVar) {
        this.visibilityListeners.remove(mVar);
    }

    public void requestPlayPauseFocus() {
        View view = this.playPauseButton;
        if (view != null) {
            view.requestFocus();
        }
    }

    public void setAnimationEnabled(boolean z) {
        this.controlViewLayoutManager.Y(z);
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

    @Deprecated
    public void setOnFullScreenModeChangedListener(@Nullable d dVar) {
        this.onFullScreenModeChangedListener = dVar;
        updateFullScreenButtonVisibility(this.fullScreenButton, dVar != null);
        updateFullScreenButtonVisibility(this.minimalFullScreenButton, dVar != null);
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

    public void setRepeatToggleModes(int i2) {
        this.repeatToggleModes = i2;
        v vVar = this.player;
        if (vVar != null && vVar.isCommandAvailable(15)) {
            int repeatMode = this.player.getRepeatMode();
            if (i2 == 0 && repeatMode != 0) {
                this.player.setRepeatMode(0);
            } else if (i2 == 1 && repeatMode == 2) {
                this.player.setRepeatMode(1);
            } else if (i2 == 2 && repeatMode == 1) {
                this.player.setRepeatMode(2);
            }
        }
        this.controlViewLayoutManager.Z(this.repeatToggleButton, i2 != 0);
        updateRepeatModeButton();
    }

    public void setShowFastForwardButton(boolean z) {
        this.controlViewLayoutManager.Z(this.fastForwardButton, z);
        updateNavigation();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.showMultiWindowTimeBar = z;
        updateTimeline();
    }

    public void setShowNextButton(boolean z) {
        this.controlViewLayoutManager.Z(this.nextButton, z);
        updateNavigation();
    }

    public void setShowPreviousButton(boolean z) {
        this.controlViewLayoutManager.Z(this.previousButton, z);
        updateNavigation();
    }

    public void setShowRewindButton(boolean z) {
        this.controlViewLayoutManager.Z(this.rewindButton, z);
        updateNavigation();
    }

    public void setShowShuffleButton(boolean z) {
        this.controlViewLayoutManager.Z(this.shuffleButton, z);
        updateShuffleButton();
    }

    public void setShowSubtitleButton(boolean z) {
        this.controlViewLayoutManager.Z(this.subtitleButton, z);
    }

    public void setShowTimeoutMs(int i2) {
        this.showTimeoutMs = i2;
        if (isFullyVisible()) {
            this.controlViewLayoutManager.X();
        }
    }

    public void setShowVrButton(boolean z) {
        this.controlViewLayoutManager.Z(this.vrButton, z);
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.timeBarMinUpdateIntervalMs = g86.q(i2, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.vrButton;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            updateButton(onClickListener != null, this.vrButton);
        }
    }

    public void show() {
        this.controlViewLayoutManager.c0();
    }

    public void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateRepeatModeButton();
        updateShuffleButton();
        updateTrackLists();
        updatePlaybackSpeedList();
        updateTimeline();
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int getRepeatToggleModes(TypedArray typedArray, int i2) {
        return typedArray.getInt(R$styleable.StyledPlayerControlView_repeat_toggle_modes, i2);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v24, types: [android.view.LayoutInflater] */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.view.ViewGroup, com.google.android.exoplayer2.ui.StyledPlayerControlView$a] */
    /* JADX WARN: Type inference failed for: r8v7 */
    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2, @Nullable AttributeSet attributeSet2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        c cVar;
        boolean z9;
        boolean z10;
        ?? r8;
        super(context, attributeSet, i2);
        int resourceId = R$layout.exo_styled_player_control_view;
        this.showTimeoutMs = 5000;
        this.repeatToggleModes = 0;
        this.timeBarMinUpdateIntervalMs = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.StyledPlayerControlView, i2, 0);
            try {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.StyledPlayerControlView_controller_layout_id, resourceId);
                this.showTimeoutMs = typedArrayObtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_show_timeout, this.showTimeoutMs);
                this.repeatToggleModes = getRepeatToggleModes(typedArrayObtainStyledAttributes, this.repeatToggleModes);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z14 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_next_button, true);
                boolean z15 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z16 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z17 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_time_bar_min_update_interval, this.timeBarMinUpdateIntervalMs));
                boolean z18 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_animation_enabled, true);
                typedArrayObtainStyledAttributes.recycle();
                z8 = z16;
                z5 = z13;
                z2 = z17;
                z6 = z14;
                z3 = z11;
                z4 = z12;
                z = z18;
                z7 = z15;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z = true;
            z2 = false;
            z3 = true;
            z4 = true;
            z5 = true;
            z6 = true;
            z7 = false;
            z8 = false;
        }
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        c cVar2 = new c();
        this.componentListener = cVar2;
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
        this.updateProgressAction = new Runnable() { // from class: rl5
            @Override // java.lang.Runnable
            public final void run() {
                this.f20504a.updateProgress();
            }
        };
        this.durationView = (TextView) findViewById(R$id.exo_duration);
        this.positionView = (TextView) findViewById(R$id.exo_position);
        ImageView imageView = (ImageView) findViewById(R$id.exo_subtitle);
        this.subtitleButton = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar2);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_fullscreen);
        this.fullScreenButton = imageView2;
        initializeFullScreenButton(imageView2, new View.OnClickListener() { // from class: sl5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20776a.onFullScreenButtonClicked(view);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R$id.exo_minimal_fullscreen);
        this.minimalFullScreenButton = imageView3;
        initializeFullScreenButton(imageView3, new View.OnClickListener() { // from class: sl5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20776a.onFullScreenButtonClicked(view);
            }
        });
        View viewFindViewById = findViewById(R$id.exo_settings);
        this.settingsButton = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(cVar2);
        }
        View viewFindViewById2 = findViewById(R$id.exo_playback_speed);
        this.playbackSpeedButton = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar2);
        }
        View viewFindViewById3 = findViewById(R$id.exo_audio_track);
        this.audioTrackButton = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar2);
        }
        int i3 = R$id.exo_progress;
        com.google.android.exoplayer2.ui.b bVar = (com.google.android.exoplayer2.ui.b) findViewById(i3);
        View viewFindViewById4 = findViewById(R$id.exo_progress_placeholder);
        if (bVar != null) {
            this.timeBar = bVar;
            cVar = cVar2;
            z9 = z;
            z10 = z2;
            r8 = 0;
        } else if (viewFindViewById4 != null) {
            r8 = 0;
            cVar = cVar2;
            z9 = z;
            z10 = z2;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, R$style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(i3);
            defaultTimeBar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.timeBar = defaultTimeBar;
        } else {
            cVar = cVar2;
            z9 = z;
            z10 = z2;
            r8 = 0;
            this.timeBar = null;
        }
        com.google.android.exoplayer2.ui.b bVar2 = this.timeBar;
        c cVar3 = cVar;
        if (bVar2 != null) {
            bVar2.addListener(cVar3);
        }
        View viewFindViewById5 = findViewById(R$id.exo_play_pause);
        this.playPauseButton = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar3);
        }
        View viewFindViewById6 = findViewById(R$id.exo_prev);
        this.previousButton = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar3);
        }
        View viewFindViewById7 = findViewById(R$id.exo_next);
        this.nextButton = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar3);
        }
        Typeface font = ResourcesCompat.getFont(context, R$font.roboto_medium_numbers);
        ?? FindViewById = findViewById(R$id.exo_rew);
        ?? r5 = FindViewById == 0 ? (TextView) findViewById(R$id.exo_rew_with_amount) : r8;
        this.rewindButtonTextView = r5;
        if (r5 != 0) {
            r5.setTypeface(font);
        }
        FindViewById = FindViewById == 0 ? r5 : FindViewById;
        this.rewindButton = FindViewById;
        if (FindViewById != 0) {
            FindViewById.setOnClickListener(cVar3);
        }
        ?? FindViewById2 = findViewById(R$id.exo_ffwd);
        ?? r52 = FindViewById2 == 0 ? (TextView) findViewById(R$id.exo_ffwd_with_amount) : r8;
        this.fastForwardButtonTextView = r52;
        if (r52 != 0) {
            r52.setTypeface(font);
        }
        FindViewById2 = FindViewById2 == 0 ? r52 : FindViewById2;
        this.fastForwardButton = FindViewById2;
        if (FindViewById2 != 0) {
            FindViewById2.setOnClickListener(cVar3);
        }
        ImageView imageView4 = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.repeatToggleButton = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(cVar3);
        }
        ImageView imageView5 = (ImageView) findViewById(R$id.exo_shuffle);
        this.shuffleButton = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(cVar3);
        }
        Resources resources = context.getResources();
        this.resources = resources;
        this.buttonAlphaEnabled = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.buttonAlphaDisabled = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View viewFindViewById8 = findViewById(R$id.exo_vr);
        this.vrButton = viewFindViewById8;
        if (viewFindViewById8 != null) {
            updateButton(false, viewFindViewById8);
        }
        mm5 mm5Var = new mm5(this);
        this.controlViewLayoutManager = mm5Var;
        mm5Var.Y(z9);
        h hVar = new h(new String[]{resources.getString(R$string.exo_controls_playback_speed), resources.getString(R$string.exo_track_selection_title_audio)}, new Drawable[]{g86.U(context, resources, R$drawable.exo_styled_controls_speed), g86.U(context, resources, R$drawable.exo_styled_controls_audiotrack)});
        this.settingsAdapter = hVar;
        this.settingsWindowMargin = resources.getDimensionPixelSize(R$dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.exo_styled_settings_list, r8);
        this.settingsView = recyclerView;
        recyclerView.setAdapter(hVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        this.settingsWindow = popupWindow;
        if (g86.f17680a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        popupWindow.setOnDismissListener(cVar3);
        this.needToHideBars = true;
        this.trackNameProvider = new b91(getResources());
        this.subtitleOnButtonDrawable = g86.U(context, resources, R$drawable.exo_styled_controls_subtitle_on);
        this.subtitleOffButtonDrawable = g86.U(context, resources, R$drawable.exo_styled_controls_subtitle_off);
        this.subtitleOnContentDescription = resources.getString(R$string.exo_controls_cc_enabled_description);
        this.subtitleOffContentDescription = resources.getString(R$string.exo_controls_cc_disabled_description);
        this.textTrackSelectionAdapter = new j();
        this.audioTrackSelectionAdapter = new b();
        this.playbackSpeedAdapter = new e(resources.getStringArray(R$array.exo_controls_playback_speeds), PLAYBACK_SPEEDS);
        this.fullScreenExitDrawable = g86.U(context, resources, R$drawable.exo_styled_controls_fullscreen_exit);
        this.fullScreenEnterDrawable = g86.U(context, resources, R$drawable.exo_styled_controls_fullscreen_enter);
        this.repeatOffButtonDrawable = g86.U(context, resources, R$drawable.exo_styled_controls_repeat_off);
        this.repeatOneButtonDrawable = g86.U(context, resources, R$drawable.exo_styled_controls_repeat_one);
        this.repeatAllButtonDrawable = g86.U(context, resources, R$drawable.exo_styled_controls_repeat_all);
        this.shuffleOnButtonDrawable = g86.U(context, resources, R$drawable.exo_styled_controls_shuffle_on);
        this.shuffleOffButtonDrawable = g86.U(context, resources, R$drawable.exo_styled_controls_shuffle_off);
        this.fullScreenExitContentDescription = resources.getString(R$string.exo_controls_fullscreen_exit_description);
        this.fullScreenEnterContentDescription = resources.getString(R$string.exo_controls_fullscreen_enter_description);
        this.repeatOffButtonContentDescription = this.resources.getString(R$string.exo_controls_repeat_off_description);
        this.repeatOneButtonContentDescription = this.resources.getString(R$string.exo_controls_repeat_one_description);
        this.repeatAllButtonContentDescription = this.resources.getString(R$string.exo_controls_repeat_all_description);
        this.shuffleOnContentDescription = this.resources.getString(R$string.exo_controls_shuffle_on_description);
        this.shuffleOffContentDescription = this.resources.getString(R$string.exo_controls_shuffle_off_description);
        this.controlViewLayoutManager.Z((ViewGroup) findViewById(R$id.exo_bottom_bar), true);
        this.controlViewLayoutManager.Z(this.fastForwardButton, z4);
        this.controlViewLayoutManager.Z(this.rewindButton, z3);
        this.controlViewLayoutManager.Z(this.previousButton, z5);
        this.controlViewLayoutManager.Z(this.nextButton, z6);
        this.controlViewLayoutManager.Z(this.shuffleButton, z7);
        this.controlViewLayoutManager.Z(this.subtitleButton, z8);
        this.controlViewLayoutManager.Z(this.vrButton, z10);
        this.controlViewLayoutManager.Z(this.repeatToggleButton, this.repeatToggleModes != 0);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: tl5
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                this.f21020a.onLayoutChange(view, i4, i5, i6, i7, i8, i9, i10, i11);
            }
        });
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class j extends l {
        public j() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(View view) {
            if (StyledPlayerControlView.this.player == null || !StyledPlayerControlView.this.player.isCommandAvailable(29)) {
                return;
            }
            StyledPlayerControlView.this.player.c(StyledPlayerControlView.this.player.getTrackSelectionParameters().A().B(3).F(-3).A());
            StyledPlayerControlView.this.settingsWindow.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l, androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i) {
            super.onBindViewHolder(iVar, i);
            if (i > 0) {
                iVar.e.setVisibility(this.e.get(i + (-1)).a() ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void e(i iVar) {
            boolean z;
            iVar.d.setText(R$string.exo_track_selection_none);
            int i = 0;
            while (true) {
                if (i >= this.e.size()) {
                    z = true;
                    break;
                } else {
                    if (this.e.get(i).a()) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            iVar.e.setVisibility(z ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: xl5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f21999a.j(view);
                }
            });
        }

        public void i(List<k> list) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (list.get(i).a()) {
                    z = true;
                    break;
                }
                i++;
            }
            if (StyledPlayerControlView.this.subtitleButton != null) {
                ImageView imageView = StyledPlayerControlView.this.subtitleButton;
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                imageView.setImageDrawable(z ? styledPlayerControlView.subtitleOnButtonDrawable : styledPlayerControlView.subtitleOffButtonDrawable);
                StyledPlayerControlView.this.subtitleButton.setContentDescription(z ? StyledPlayerControlView.this.subtitleOnContentDescription : StyledPlayerControlView.this.subtitleOffContentDescription);
            }
            this.e = list;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void g(String str) {
        }
    }

    public void setProgressUpdateListener(@Nullable f fVar) {
    }
}
