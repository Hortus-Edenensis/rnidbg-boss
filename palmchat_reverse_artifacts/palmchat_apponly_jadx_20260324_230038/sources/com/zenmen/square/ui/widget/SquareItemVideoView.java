package com.zenmen.square.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.f0;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.v;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a46;
import defpackage.k06;
import defpackage.k86;
import defpackage.ma3;
import defpackage.mw;
import defpackage.qj5;
import defpackage.te6;
import defpackage.wj4;
import defpackage.xr0;
import defpackage.zm;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareItemVideoView extends LxRelativeLayout implements zm {
    private boolean buffering;
    private boolean hasFirstFrame;
    private StyledPlayerView mExoPlayerView;
    private SquareFeed mFeed;
    private int mFrom;
    private String mLastUrl;
    private v.d onStateChangeListener;
    private long playBeginTime;
    private MagicTextureMediaPlayer player;
    private c shouldState;
    private c status;
    private ImageView videoCover;
    private RelativeLayout videoLayout;
    private ImageView videoPlay;
    private ProgressBar videoProgress;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements v.d {
        public a() {
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void B(f0 f0Var) {
            wj4.C(this, f0Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void D(v vVar, v.c cVar) {
            wj4.f(this, vVar, cVar);
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
        public void onIsPlayingChanged(boolean z) {
            wj4.h(this, z);
            if (z) {
                SquareItemVideoView.this.status = c.PLAYING;
            } else {
                SquareItemVideoView.this.status = c.PAUSE;
            }
            SquareItemVideoView.this.updateStatus();
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
        public void onPlaybackStateChanged(int i) {
            ma3.a("onPlaybackStateChanged " + i + " " + SquareItemVideoView.this.getPlayPath(), new Object[0]);
            if (i == 2) {
                if (SquareItemVideoView.this.shouldState == c.PLAYING) {
                    SquareItemVideoView.this.videoProgress.setVisibility(0);
                }
            } else if (i == 3 && SquareItemVideoView.this.mExoPlayerView.getPlayer().getPlayWhenReady()) {
                SquareItemVideoView.this.videoCover.setVisibility(8);
                SquareItemVideoView.this.videoPlay.setVisibility(8);
                SquareItemVideoView.this.playBeginTime = System.currentTimeMillis();
            }
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
        public void onRenderedFirstFrame() {
            SquareItemVideoView.this.videoProgress.setVisibility(8);
            SquareItemVideoView.this.videoCover.setVisibility(8);
            SquareItemVideoView.this.hasFirstFrame = true;
            SquareItemVideoView.this.updateStatus();
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

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void r(k06 k06Var) {
            wj4.B(this, k06Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void s(PlaybackException playbackException) {
            wj4.q(this, playbackException);
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
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16564a;

        static {
            int[] iArr = new int[c.values().length];
            f16564a = iArr;
            try {
                iArr[c.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16564a[c.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16564a[c.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c {
        DOWNLOAD,
        PLAYING,
        PAUSE,
        STOP
    }

    public SquareItemVideoView(Context context) {
        super(context);
        this.status = c.STOP;
        this.hasFirstFrame = false;
        this.buffering = false;
        this.playBeginTime = 0L;
        this.onStateChangeListener = new a();
    }

    public static Media getPlayMedia(SquareFeed squareFeed) {
        List<Media> list;
        if (squareFeed == null || squareFeed.feedType != 3 || (list = squareFeed.mediaList) == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    private String getThumbUrl(Media media) {
        return media.url;
    }

    private boolean isPlayerReleased() {
        StyledPlayerView styledPlayerView = this.mExoPlayerView;
        return styledPlayerView == null || styledPlayerView.getPlayer() == null;
    }

    private void releasePlayer() {
        if (isPlayerReleased()) {
            return;
        }
        try {
            this.mExoPlayerView.getPlayer().stop();
            this.mExoPlayerView.getPlayer().release();
            this.mExoPlayerView.setPlayer(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reportTime() {
        if (this.playBeginTime > 0) {
            qj5.c0(this.mFeed, System.currentTimeMillis() - this.playBeginTime, this.mFrom);
            this.playBeginTime = 0L;
        }
    }

    private void setMedia(int i, int i2, boolean z) {
        List<Media> list;
        SquareFeed squareFeed = this.mFeed;
        if (squareFeed == null || (list = squareFeed.mediaList) == null || list.size() == 0) {
            return;
        }
        Media media = this.mFeed.mediaList.get(0);
        if (TextUtils.equals(this.mLastUrl, media.videoUrl)) {
            return;
        }
        this.mLastUrl = media.videoUrl;
        String thumbUrl = getThumbUrl(media);
        if (thumbUrl == null) {
            return;
        }
        a46.u(a46.h(this.videoCover, k86.p(thumbUrl)), this.videoCover, R$drawable.bg_feed_item_loading);
    }

    private void setupExoPlayer(Media media, boolean z) {
        j jVarF;
        v player = this.mExoPlayerView.getPlayer();
        if (player instanceof j) {
            player.stop();
            jVarF = (j) player;
        } else {
            jVarF = new j.b(getContext()).l(mw.b().c()).f();
            this.mExoPlayerView.setPlayer(jVarF);
        }
        jVarF.d(new p.c().j(media.videoUrl).a());
        jVarF.setRepeatMode(1);
        jVarF.prepare();
        jVarF.setPlayWhenReady(z);
        jVarF.e(this.onStateChangeListener);
        jVarF.setVolume(0.0f);
        this.shouldState = c.PAUSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStatus() {
        LogUtil.v("Square", "host: status=" + this.status + " " + getPlayPath());
        int i = b.f16564a[this.status.ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.videoCover.setVisibility(4);
                this.videoPlay.setVisibility(0);
                this.videoProgress.setVisibility(4);
            } else if (i == 3) {
                this.videoCover.setVisibility(0);
                this.videoPlay.setVisibility(0);
            }
        } else if (this.hasFirstFrame) {
            this.videoCover.setVisibility(4);
            this.videoPlay.setVisibility(4);
        } else {
            this.videoCover.setVisibility(0);
            this.videoPlay.setVisibility(0);
        }
        c cVar = this.status;
        if (cVar == c.PLAYING) {
            this.playBeginTime = System.currentTimeMillis();
        } else if ((cVar == c.PAUSE || cVar == c.STOP) && this.playBeginTime > 0) {
            qj5.c0(this.mFeed, System.currentTimeMillis() - this.playBeginTime, this.mFrom);
            this.playBeginTime = 0L;
        }
    }

    public void bindMedia(SquareFeed squareFeed, int i, int i2, int i3, boolean z) {
        this.mFeed = squareFeed;
        this.mFrom = i3;
        ViewGroup.LayoutParams layoutParams = this.videoLayout.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.videoLayout.setLayoutParams(layoutParams);
        setMedia(i, i2, z);
    }

    @Override // defpackage.zm
    public boolean canPlay() {
        return true;
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        addView(LayoutInflater.from(context).inflate(R$layout.layout_square_item_video_view, (ViewGroup) this, false));
        this.videoLayout = (RelativeLayout) findViewById(R$id.square_item_video_field);
        this.mExoPlayerView = (StyledPlayerView) findViewById(R$id.exo_player);
        this.videoPlay = (ImageView) findViewById(R$id.square_video_play_btn);
        this.videoCover = (ImageView) findViewById(R$id.square_video_cover);
        this.videoProgress = (ProgressBar) findViewById(R$id.square_video_progress);
    }

    @Override // defpackage.zm
    public ViewGroup getContainerView() {
        return this.videoLayout;
    }

    @Override // defpackage.zm
    public String getPlayPath() {
        Media playMedia = getPlayMedia(this.mFeed);
        if (playMedia == null || playMedia.getWidth() == 0 || playMedia.getHeight() == 0) {
            return null;
        }
        return playMedia.videoUrl;
    }

    @Override // defpackage.zm
    public boolean isZooming() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // defpackage.zm
    public void onPlayPause() {
        LogUtil.d("logvideo", "host: pause");
        c cVar = c.PAUSE;
        this.shouldState = cVar;
        if (isPlayerReleased()) {
            return;
        }
        this.mExoPlayerView.getPlayer().pause();
        this.status = cVar;
        updateStatus();
    }

    @Override // defpackage.zm
    public void onPlayRelease() {
        LogUtil.d("logvideo", "host: release=" + this);
        releasePlayer();
        this.status = c.STOP;
        this.hasFirstFrame = false;
        updateStatus();
    }

    @Override // defpackage.zm
    public void onPlayResume() {
        LogUtil.d("logvideo", "host: resume");
        onPlayStart(getPlayPath());
    }

    @Override // defpackage.zm
    public void onPlayStart(String str) {
        c cVar = c.PLAYING;
        this.shouldState = cVar;
        LogUtil.d("Square", "host: start=" + str);
        Media playMedia = getPlayMedia(this.mFeed);
        if (playMedia == null || playMedia.getWidth() == 0 || playMedia.getHeight() == 0) {
            return;
        }
        if (isPlayerReleased()) {
            LogUtil.d("logvideo", "host: start=" + str + " but isPlayerReleased");
            setupExoPlayer(playMedia, true);
        } else {
            this.mExoPlayerView.getPlayer().play();
        }
        this.status = cVar;
        updateStatus();
    }

    public void onPlayStop() {
        LogUtil.d("logvideo", "host: stop");
        releasePlayer();
        c cVar = c.STOP;
        this.status = cVar;
        this.shouldState = cVar;
        updateStatus();
    }

    public SquareItemVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = c.STOP;
        this.hasFirstFrame = false;
        this.buffering = false;
        this.playBeginTime = 0L;
        this.onStateChangeListener = new a();
    }

    public SquareItemVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = c.STOP;
        this.hasFirstFrame = false;
        this.buffering = false;
        this.playBeginTime = 0L;
        this.onStateChangeListener = new a();
    }

    @RequiresApi(api = 21)
    public SquareItemVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.status = c.STOP;
        this.hasFirstFrame = false;
        this.buffering = false;
        this.playBeginTime = 0L;
        this.onStateChangeListener = new a();
    }
}
