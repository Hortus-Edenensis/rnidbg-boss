package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qiniu.android.collect.ReportItem;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.media.player.MediaPlayerNotificationInfo;
import com.zenmen.media.player.OnStateChangeListener;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.video.a;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.AspectRatioFrameLayout;
import defpackage.ds0;
import defpackage.ga3;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.k86;
import defpackage.lf5;
import defpackage.pu1;
import defpackage.py4;
import defpackage.rb3;
import defpackage.xm;
import defpackage.zm;
import defpackage.zn6;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SmallVideoViewHolder extends MomentsBaseViewHolder implements View.OnClickListener, zm, a.b {
    public static String Z = "SmallVideoViewHolder";
    public Context I;
    public ViewGroup J;
    public ImageView K;
    public ImageView L;
    public ProgressBar M;
    public AspectRatioFrameLayout N;
    public MagicTextureMediaPlayer O;
    public TextView P;
    public ImageView Q;
    public TextView R;
    public ImageView S;
    public Feed T;
    public String U;
    public d V;
    public boolean W;
    public boolean X;
    public boolean Y;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xm xmVar = new xm();
            xmVar.b(0);
            ds0.a().b(xmVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14026a;

        static {
            int[] iArr = new int[d.values().length];
            f14026a = iArr;
            try {
                iArr[d.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14026a[d.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14026a[d.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14026a[d.STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum d {
        DOWNLOAD,
        PLAYING,
        PAUSE,
        STOP
    }

    public SmallVideoViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
        this.V = d.STOP;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.I = context;
    }

    public static Media L(Feed feed) {
        List<Media> mediaList;
        if (feed == null || feed.getFeedType() != 6 || (mediaList = feed.getMediaList()) == null || mediaList.size() <= 0) {
            return null;
        }
        return mediaList.get(0);
    }

    public final String M(Media media) {
        if (media == null || TextUtils.isEmpty(media.videoUrl)) {
            return null;
        }
        return pu1.l + File.separator + rb3.c(media.videoUrl) + "_cache";
    }

    public final String N(Media media) {
        if (media == null || TextUtils.isEmpty(media.videoUrl)) {
            return null;
        }
        return pu1.l + File.separator + rb3.c(media.videoUrl);
    }

    public final void O() {
        if (this.O != null) {
            LogUtil.d(Z, "host: releasePlayer");
            this.N.removeView(this.O);
            this.O.setOnStateChangeListener(null);
            this.O.release();
            this.O = null;
            this.W = false;
            this.U = null;
        }
    }

    public final void P() {
        LogUtil.d(Z, "host: requestUpdate");
        ViewGroup viewGroup = this.J;
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new b());
    }

    public final void Q() throws Throwable {
        if (TextUtils.isEmpty(this.U)) {
            return;
        }
        File file = new File(this.U);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        try {
            Feed feed = this.T;
            if (feed == null || feed.getMediaList() == null || this.T.getMediaList().size() <= 0) {
                return;
            }
            Media media = this.T.getMediaList().get(0);
            String strM = M(media);
            pu1.f(file, new File(strM));
            media.localPath = strM;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void R() {
        O();
        LogUtil.d(Z, "host: setupPlayer");
        MagicTextureMediaPlayer magicTextureMediaPlayer = new MagicTextureMediaPlayer(m());
        this.O = magicTextureMediaPlayer;
        magicTextureMediaPlayer.setRenderMode(3);
        Media mediaL = L(this.T);
        if (mediaL != null && mediaL.getWidth() > 0 && mediaL.getHeight() > 0) {
            this.O.setOriginSize(mediaL.getWidth(), mediaL.getHeight());
        }
        this.O.setFixedSize(true);
        this.N.addView(this.O, new ViewGroup.LayoutParams(-1, -1));
        this.W = false;
        this.Y = false;
        this.O.setOnStateChangeListener(new a());
    }

    public final void S() {
        LogUtil.v(Z, "host: status=" + this.V);
        int i = c.f14026a[this.V.ordinal()];
        if (i == 1) {
            this.K.setVisibility(0);
            this.L.setVisibility(4);
            this.M.setVisibility(0);
            this.N.setVisibility(4);
            return;
        }
        if (i == 2) {
            if (this.W) {
                this.K.setVisibility(4);
            } else {
                this.K.setVisibility(0);
            }
            this.L.setVisibility(4);
            if (this.X || this.Y) {
                this.M.setVisibility(0);
            } else {
                this.M.setVisibility(4);
            }
            this.N.setVisibility(0);
            return;
        }
        if (i == 3) {
            this.K.setVisibility(4);
            this.L.setVisibility(0);
            this.M.setVisibility(4);
            this.N.setVisibility(0);
            return;
        }
        if (i != 4) {
            return;
        }
        this.K.setVisibility(0);
        this.L.setVisibility(0);
        this.M.setVisibility(4);
        this.N.setVisibility(4);
    }

    @Override // com.zenmen.palmchat.friendcircle.video.a.b
    public void a(String str, String str2) throws Throwable {
        LogUtil.d(Z, "host: onDownloadComplete=" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str2);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        try {
            Feed feed = this.T;
            if (feed == null || feed.getMediaList() == null || this.T.getMediaList().size() <= 0) {
                return;
            }
            Media media = this.T.getMediaList().get(0);
            String strM = M(media);
            pu1.f(file, new File(strM));
            media.localPath = strM;
            P();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.video.a.b
    public void b(String str) {
        LogUtil.d(Z, "host: onDownloadingStarted=" + str);
    }

    @Override // defpackage.zm
    public boolean canPlay() {
        return (TextUtils.isEmpty(L(this.T).videoUrl) ^ true) && lf5.b();
    }

    @Override // defpackage.zm
    public ViewGroup getContainerView() {
        return this.J;
    }

    @Override // defpackage.zm
    public String getPlayPath() {
        Media mediaL = L(this.T);
        if (mediaL == null) {
            return null;
        }
        return mediaL.videoUrl;
    }

    @Override // defpackage.zm
    public boolean isZooming() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.item_smallvideo_field || view.getId() == R$id.item_smallvideo_field_new) {
            Media media = this.T.getMediaList().get(0);
            LogUtil.d(Z, "jumpToNativeFromShare wid = " + media.wid + "， wineFeedId = " + media.wineFeedId);
            lf5.e(this.I, String.valueOf(this.T.getFeedId()), 0, media.wineFeedId, this.T.getUid());
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(this.A));
            map.put("feedid", this.T.getFeedId());
            map.put("feedType", Integer.valueOf(this.T.getFeedType()));
            map.put(ReportItem.RequestKeyRequestId, this.T.reqId);
            zn6.j("pagediscover_feeds", "click", map);
        }
    }

    @Override // defpackage.zm
    public void onPlayPause() {
        LogUtil.d(Z, "host: pause");
        d dVar = this.V;
        if (dVar != d.PLAYING) {
            if (dVar == d.DOWNLOAD) {
                onPlayRelease();
                return;
            }
            return;
        }
        MagicTextureMediaPlayer magicTextureMediaPlayer = this.O;
        if (magicTextureMediaPlayer != null) {
            if (magicTextureMediaPlayer.isPlaying()) {
                this.O.pause();
            }
            this.V = d.PAUSE;
            S();
        }
    }

    @Override // defpackage.zm
    public void onPlayRelease() {
        LogUtil.d(Z, "host: release=" + this);
        O();
        this.V = d.STOP;
        S();
    }

    @Override // defpackage.zm
    public void onPlayResume() {
        LogUtil.d(Z, "host: resume");
        if (this.V != d.PAUSE) {
            onPlayStart(getPlayPath());
            return;
        }
        MagicTextureMediaPlayer magicTextureMediaPlayer = this.O;
        if (magicTextureMediaPlayer != null) {
            if (!magicTextureMediaPlayer.isPlaying()) {
                this.O.pause();
            }
            this.V = d.PLAYING;
            S();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    @Override // defpackage.zm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPlayStart(String str) {
        String strM;
        String strN;
        LogUtil.d(Z, "host: start=" + str);
        d dVar = this.V;
        d dVar2 = d.PLAYING;
        if (dVar == dVar2) {
            return;
        }
        Media mediaL = L(this.T);
        String str2 = null;
        if (mediaL != null) {
            strM = M(mediaL);
            if (!com.zenmen.palmchat.friendcircle.video.a.c().b(strM)) {
                strM = null;
            }
            if (!TextUtils.isEmpty(strM) && (!k86.D() || (py4.d() && !ga3.d(new File(strM))))) {
                strM = null;
            }
        }
        if (!TextUtils.isEmpty(strM) || mediaL == null) {
            strN = null;
        } else {
            str2 = mediaL.videoUrl;
            strN = N(mediaL);
        }
        boolean z = (TextUtils.isEmpty(strM) && (TextUtils.isEmpty(str2) || TextUtils.isEmpty(strN))) ? false : true;
        LogUtil.d(Z, "shouldPlay = " + z + ", videoUrl = " + str2 + ", cacheTempPath = " + strN);
        if (!z) {
            if (this.T == null || mediaL == null) {
                return;
            }
            this.V = d.DOWNLOAD;
            S();
            com.zenmen.palmchat.friendcircle.video.a.c().a(m(), String.valueOf(this.T.getFeedId()), mediaL.videoUrl, mediaL.url, this);
            return;
        }
        R();
        if (this.O != null) {
            if (TextUtils.isEmpty(strM)) {
                LogUtil.d(Z, "host: stream url=" + str2 + ", cache=" + strN);
                this.O.setCachePath(strN);
                this.O.setVideo(str2);
                this.X = true;
                this.U = strN;
            } else {
                LogUtil.d(Z, "host: local path=" + strM);
                this.O.setVideo(strM);
            }
            this.O.setLoop(true);
            this.O.setResumable(false);
            this.O.mute(true);
            this.O.start();
            this.V = dVar2;
            S();
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void x(@NonNull Feed feed, int i, int i2) {
        Media media;
        if (feed != null) {
            this.T = feed;
            if (feed.getMediaList() == null || (media = this.T.getMediaList().get(0)) == null) {
                return;
            }
            gr2.j().h(media.midUrl, this.K, hr2.j());
            this.R.setText(media.title);
            this.P.setText(media.getSourceName());
            gr2.j().h(media.getSourceIcon(), this.Q, hr2.i());
            gr2.j().h(lf5.c(), this.S, hr2.i());
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void z(@NonNull View view) {
        View viewL = l(R$id.small_video_layout);
        View viewL2 = l(R$id.small_video_layot_new);
        viewL.setVisibility(0);
        viewL2.setVisibility(8);
        this.K = (ImageView) u(this.K, R$id.smallvideo_cover);
        this.R = (TextView) u(this.R, R$id.wine_title);
        this.Q = (ImageView) u(this.Q, R$id.wine_head);
        this.P = (TextView) u(this.P, R$id.wine_name);
        this.S = (ImageView) u(this.S, R$id.source_icon);
        this.N = (AspectRatioFrameLayout) u(this.N, R$id.video_content);
        this.L = (ImageView) u(this.L, R$id.video_play_btn);
        this.M = (ProgressBar) u(this.M, R$id.video_progress);
        this.N.setResizeMode(4);
        ViewGroup viewGroup = (ViewGroup) u(this.J, R$id.item_smallvideo_field);
        this.J = viewGroup;
        viewGroup.setOnClickListener(this);
    }

    @Override // com.zenmen.palmchat.friendcircle.video.a.b
    public void g(Exception exc) {
    }

    @Override // com.zenmen.palmchat.friendcircle.video.a.b
    public void i(int i) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements OnStateChangeListener {
        public a() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferFinished() throws Throwable {
            LogUtil.d(SmallVideoViewHolder.Z, "host: onBufferFinished");
            SmallVideoViewHolder.this.X = false;
            SmallVideoViewHolder.this.S();
            SmallVideoViewHolder.this.Q();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferingDone() {
            LogUtil.d(SmallVideoViewHolder.Z, "host: onBufferingDone");
            SmallVideoViewHolder.this.X = false;
            SmallVideoViewHolder.this.S();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferingStarted() {
            LogUtil.d(SmallVideoViewHolder.Z, "host: onBufferingStarted");
            SmallVideoViewHolder.this.X = true;
            SmallVideoViewHolder.this.S();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
            LogUtil.d(SmallVideoViewHolder.Z, "host: onError=" + i2);
            SmallVideoViewHolder.this.Y = true;
            SmallVideoViewHolder.this.S();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onPrepared(int i, int i2) {
            LogUtil.d(SmallVideoViewHolder.Z, "host: onPrepared");
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onStarted() {
            LogUtil.d(SmallVideoViewHolder.Z, "host: onStarted");
            if (SmallVideoViewHolder.this.T == null || SmallVideoViewHolder.this.T.getMediaList().size() <= 0) {
                return;
            }
            lf5.a(SmallVideoViewHolder.this.T.getMediaList().get(0).wineFeedId, SmallVideoViewHolder.this.T.getUid());
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onVideoFirstFrame() {
            LogUtil.d(SmallVideoViewHolder.Z, "host: onVideoFirstFrame");
            SmallVideoViewHolder.this.W = true;
            SmallVideoViewHolder.this.X = false;
            SmallVideoViewHolder.this.Y = false;
            SmallVideoViewHolder.this.S();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onCompleted() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onPaused() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onSeekCompleted() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onVideoFormatchanged(int i, int i2) {
        }
    }
}
