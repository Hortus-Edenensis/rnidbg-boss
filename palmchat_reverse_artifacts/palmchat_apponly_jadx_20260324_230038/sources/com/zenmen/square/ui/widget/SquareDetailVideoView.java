package com.zenmen.square.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.f0;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.v;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.friendcircle.video.a;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.photoview.PhotoView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.k06;
import defpackage.k86;
import defpackage.mw;
import defpackage.or2;
import defpackage.te6;
import defpackage.tg4;
import defpackage.wj4;
import defpackage.xr0;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareDetailVideoView extends LxRelativeLayout {
    public static or2 IMAGE_SIZE = null;
    public static final String KEY_INIT_POSITION = "key_init_position";
    public static final String KEY_ITEM = "key_item";
    public static final String KEY_POSITION = "key_position";
    public static final String KEY_VIDEO_POSITION = "key_video_position";
    private static String TAG = "SquareDetailVideoView";
    private boolean isVideoPaused;
    private View mErrorView;
    private StyledPlayerView mExoPlayerView;
    private SquareFeed mFeed;
    private Media mMedia;
    private long mPlayStartTimeMillis;
    private ProgressBar mProgress;
    private ImageView mVideoThumbnail;
    private View mask;
    private v.d onStateChangeListener;
    private long playTime;
    private a.b videoDownloadingListener;

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
        public void onRenderedFirstFrame() {
            SquareDetailVideoView.this.mVideoThumbnail.setVisibility(8);
            SquareDetailVideoView.this.mProgress.setVisibility(8);
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
        public void s(PlaybackException playbackException) {
            wj4.q(this, playbackException);
            SquareDetailVideoView.this.mErrorView.setVisibility(0);
            HashMap map = new HashMap();
            if (SquareDetailVideoView.this.mMedia != null) {
                map.put("videoUrl", SquareDetailVideoView.this.mMedia.videoUrl);
                map.put("localPath", SquareDetailVideoView.this.mMedia.localPath);
                map.put("feedId", SquareDetailVideoView.this.mFeed != null ? Long.valueOf(SquareDetailVideoView.this.mFeed.id) : com.igexin.push.core.b.m);
            }
            LogUtil.log4ClientError("Media_load_fail_PlayerError", map, playbackException);
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
    public class b extends DrawableImageViewTarget {
        public b(ImageView imageView) {
            super(imageView);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            super.onResourceReady(drawable, transition);
            SquareDetailVideoView.this.mVideoThumbnail.setScaleType(PhotoView.getSquarePhotoViewScaleType(SquareDetailVideoView.this.getPreViewSize(), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
            SquareDetailVideoView.this.mask.setVisibility(8);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            super.onLoadFailed(drawable);
            SquareDetailVideoView.this.mask.setVisibility(8);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable drawable) {
            super.onLoadStarted(drawable);
            SquareDetailVideoView.this.mask.setVisibility(8);
        }
    }

    public SquareDetailVideoView(Context context) {
        super(context);
        this.isVideoPaused = false;
        this.playTime = 0L;
        this.onStateChangeListener = new a();
    }

    private boolean hasSDPermission() {
        return tg4.b(getContext(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList);
    }

    private void releasePlayer() {
        this.mVideoThumbnail.setVisibility(0);
        StyledPlayerView styledPlayerView = this.mExoPlayerView;
        if (styledPlayerView == null || styledPlayerView.getPlayer() == null) {
            return;
        }
        try {
            this.mExoPlayerView.getPlayer().stop();
            this.mExoPlayerView.getPlayer().release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateUI(boolean z) {
        j jVarF;
        String str;
        LogUtil.d("logvideof", "updateUI " + this);
        if ((getContext() instanceof Activity) && ((Activity) getContext()).isDestroyed()) {
            return;
        }
        Glide.with(getContext()).load2(k86.p(this.mMedia.url)).diskCacheStrategy(DiskCacheStrategy.DATA).priority(Priority.IMMEDIATE).error(R$drawable.bg_feed_item_loading).transition(DrawableTransitionOptions.withCrossFade()).into(new b(this.mVideoThumbnail));
        v player = this.mExoPlayerView.getPlayer();
        LogUtil.d("logvideof", "updateUI " + this + "player=" + player + " mMedia.localPath=" + this.mMedia.localPath);
        if (player instanceof j) {
            player.stop();
            jVarF = (j) player;
            str = null;
        } else if (TextUtils.isEmpty(this.mMedia.localPath)) {
            jVarF = new j.b(getContext()).l(mw.b().c()).f();
            this.mExoPlayerView.setPlayer(jVarF);
            str = this.mMedia.videoUrl;
        } else {
            jVarF = new j.b(getContext()).l(new d(getContext())).f();
            this.mExoPlayerView.setPlayer(jVarF);
            str = this.mMedia.localPath;
        }
        jVarF.d(new p.c().j(str).a());
        jVarF.setRepeatMode(1);
        jVarF.prepare();
        jVarF.setPlayWhenReady(z);
        jVarF.e(this.onStateChangeListener);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_square_detail_video_view, (ViewGroup) this, false);
        addView(viewInflate);
        this.mVideoThumbnail = (ImageView) viewInflate.findViewById(R$id.square_video_thumbnail);
        this.mExoPlayerView = (StyledPlayerView) viewInflate.findViewById(R$id.exo_player);
        this.mask = viewInflate.findViewById(R$id.square_mask);
        this.mProgress = (ProgressBar) viewInflate.findViewById(R$id.square_video_progress);
        this.mErrorView = viewInflate.findViewById(R$id.square_video_error);
        LogUtil.d("logvideof", "createView: " + this);
    }

    public long getPlayTime() {
        return this.playTime;
    }

    public or2 getPreViewSize() {
        or2 or2Var = IMAGE_SIZE;
        if (or2Var == null || or2Var.a() == 0 || IMAGE_SIZE.b() == 0) {
            IMAGE_SIZE = new or2(getMeasuredWidth(), getMeasuredHeight());
        }
        return IMAGE_SIZE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        StringBuilder sb = new StringBuilder();
        sb.append("onAttachedToWindow: ");
        sb.append(this);
        sb.append(" ");
        Media media = this.mMedia;
        sb.append(media == null ? com.igexin.push.core.b.m : media.videoUrl);
        LogUtil.d("logvideof", sb.toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StringBuilder sb = new StringBuilder();
        sb.append("onDetachedFromWindow: ");
        sb.append(this);
        sb.append(" ");
        Media media = this.mMedia;
        sb.append(media == null ? com.igexin.push.core.b.m : media.videoUrl);
        LogUtil.d("logvideof", sb.toString());
        releasePlayer();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        IMAGE_SIZE = new or2(i, i2);
    }

    public void pausePlayer() {
        StringBuilder sb = new StringBuilder();
        sb.append("pausePlayer ");
        sb.append(this);
        sb.append(this.isVideoPaused);
        sb.append(" ");
        Media media = this.mMedia;
        sb.append(media == null ? com.igexin.push.core.b.m : media.videoUrl);
        LogUtil.d("logvideof", sb.toString());
        StyledPlayerView styledPlayerView = this.mExoPlayerView;
        if (styledPlayerView == null || styledPlayerView.getPlayer() == null) {
            return;
        }
        this.mExoPlayerView.getPlayer().pause();
        if (this.mPlayStartTimeMillis > 0 && System.currentTimeMillis() > this.mPlayStartTimeMillis) {
            this.playTime += System.currentTimeMillis() - this.mPlayStartTimeMillis;
        }
        this.mPlayStartTimeMillis = 0L;
        this.isVideoPaused = true;
    }

    public void setFeed(SquareFeed squareFeed, boolean z) {
        LogUtil.d("logvideof", "setFeed " + this);
        if (squareFeed != null) {
            try {
                List<Media> list = squareFeed.mediaList;
                if (list != null && list.size() != 0) {
                    if (TextUtils.isEmpty(squareFeed.mediaList.get(0).videoUrl) && TextUtils.isEmpty(squareFeed.mediaList.get(0).localPath)) {
                        return;
                    }
                    SquareFeed squareFeed2 = this.mFeed;
                    if ((squareFeed2 == null || squareFeed2.id != squareFeed.id) && this.mExoPlayerView != null) {
                        this.mFeed = squareFeed;
                        this.mMedia = squareFeed.mediaList.get(0);
                        updateUI(z);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void startPlay() {
        StringBuilder sb = new StringBuilder();
        sb.append("startPlay ");
        sb.append(this);
        Media media = this.mMedia;
        sb.append(media != null ? media.videoUrl : null);
        sb.append(" mExoPlayerView=");
        sb.append(this.mExoPlayerView);
        sb.append(" getPlayer=");
        StyledPlayerView styledPlayerView = this.mExoPlayerView;
        sb.append(styledPlayerView != null ? styledPlayerView.getPlayer() : null);
        LogUtil.d("logvideof", sb.toString());
        StyledPlayerView styledPlayerView2 = this.mExoPlayerView;
        if (styledPlayerView2 != null && styledPlayerView2.getPlayer() != null) {
            this.mExoPlayerView.getPlayer().play();
        }
        this.mPlayStartTimeMillis = System.currentTimeMillis();
        this.isVideoPaused = false;
    }

    public void toggleState() {
        StyledPlayerView styledPlayerView = this.mExoPlayerView;
        if (styledPlayerView == null || styledPlayerView.getPlayer() == null) {
            return;
        }
        if (this.mExoPlayerView.getPlayer().isPlaying()) {
            this.mExoPlayerView.getPlayer().pause();
        } else {
            this.mExoPlayerView.getPlayer().play();
        }
    }

    public SquareDetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isVideoPaused = false;
        this.playTime = 0L;
        this.onStateChangeListener = new a();
    }

    public SquareDetailVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isVideoPaused = false;
        this.playTime = 0L;
        this.onStateChangeListener = new a();
    }

    @RequiresApi(api = 21)
    public SquareDetailVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isVideoPaused = false;
        this.playTime = 0L;
        this.onStateChangeListener = new a();
    }

    public void setFrom(int i) {
    }
}
