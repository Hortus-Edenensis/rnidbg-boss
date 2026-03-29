package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.qiniu.android.collect.ReportItem;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.media.player.MediaPlayerNotificationInfo;
import com.zenmen.media.player.OnStateChangeListener;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.video.a;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.AspectRatioFrameLayout;
import defpackage.a46;
import defpackage.ds0;
import defpackage.ei4;
import defpackage.ga3;
import defpackage.gr2;
import defpackage.je1;
import defpackage.k86;
import defpackage.l50;
import defpackage.lf5;
import defpackage.pu1;
import defpackage.py4;
import defpackage.rb3;
import defpackage.xm;
import defpackage.zm;
import defpackage.zn6;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VideoViewHolder extends MomentsBaseViewHolder implements View.OnClickListener, zm, a.b {
    public Context I;
    public RelativeLayout J;
    public ImageView K;
    public ImageView L;
    public ImageView M;
    public ProgressBar N;
    public AspectRatioFrameLayout O;
    public MagicTextureMediaPlayer P;
    public Feed Q;
    public e R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public String X;
    public int Y;
    public int Z;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f14027a;

        public a(Media media) {
            this.f14027a = media;
            put("wid", media.wid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xm xmVar = new xm();
            xmVar.b(0);
            ds0.a().b(xmVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14030a;

        static {
            int[] iArr = new int[e.values().length];
            f14030a = iArr;
            try {
                iArr[e.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14030a[e.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14030a[e.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14030a[e.STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum e {
        DOWNLOAD,
        PLAYING,
        PAUSE,
        STOP
    }

    public VideoViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
        this.R = e.STOP;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.Y = 0;
        this.Z = 0;
        this.I = context;
        this.Y = a46.b(this.itemView.getContext(), 180.0f);
        this.Z = a46.b(this.itemView.getContext(), 208.0f);
        R();
    }

    public static Media J(Feed feed) {
        List<Media> mediaList;
        if (feed == null || feed.getFeedType() != 3 || (mediaList = feed.getMediaList()) == null || mediaList.size() <= 0) {
            return null;
        }
        return mediaList.get(0);
    }

    public final String K(Media media) {
        if (media.localThumbPath != null && new File(media.localThumbPath).exists()) {
            return media.localThumbPath;
        }
        String str = media.midUrl;
        return str != null ? str : media.url;
    }

    public final String L(Media media) {
        if (media == null || TextUtils.isEmpty(media.videoUrl)) {
            return null;
        }
        return pu1.l + File.separator + rb3.c(media.videoUrl) + "_cache";
    }

    public final String M(Media media) {
        if (media == null || TextUtils.isEmpty(media.videoUrl)) {
            return null;
        }
        return pu1.l + File.separator + rb3.c(media.videoUrl);
    }

    public final void N() {
        if (this.P != null) {
            LogUtil.d("logvideo", "host: releasePlayer");
            this.O.removeView(this.P);
            this.P.setOnStateChangeListener(null);
            this.P.release();
            this.P = null;
            this.U = false;
            this.X = null;
        }
    }

    public final void O() {
        LogUtil.d("logvideo", "host: requestUpdate");
        RelativeLayout relativeLayout = this.J;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.post(new c());
    }

    public final void P() throws Throwable {
        if (TextUtils.isEmpty(this.X)) {
            return;
        }
        File file = new File(this.X);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        try {
            Feed feed = this.Q;
            if (feed == null || feed.getMediaList() == null || this.Q.getMediaList().size() <= 0) {
                return;
            }
            Media media = this.Q.getMediaList().get(0);
            String strL = L(media);
            pu1.f(file, new File(strL));
            media.localPath = strL;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Q() {
        N();
        LogUtil.d("logvideo", "host: setupPlayer");
        MagicTextureMediaPlayer magicTextureMediaPlayer = new MagicTextureMediaPlayer(m());
        this.P = magicTextureMediaPlayer;
        magicTextureMediaPlayer.setFixedSize(true);
        this.P.setMode(4);
        Media mediaJ = J(this.Q);
        if (mediaJ != null && mediaJ.getWidth() > 0 && mediaJ.getHeight() > 0) {
            this.P.setOriginSize(mediaJ.getWidth(), mediaJ.getHeight());
        }
        this.O.addView(this.P, new ViewGroup.LayoutParams(-1, -1));
        this.U = false;
        this.W = false;
        this.P.setOnStateChangeListener(new b());
    }

    public final void R() {
        LogUtil.v("logvideo", "host: status=" + this.R);
        int i = d.f14030a[this.R.ordinal()];
        if (i == 1) {
            this.K.setVisibility(0);
            this.L.setVisibility(4);
            this.N.setVisibility(0);
            this.O.setVisibility(4);
            this.M.setVisibility(4);
            return;
        }
        if (i == 2) {
            if (this.U) {
                this.K.setVisibility(4);
            } else {
                this.K.setVisibility(0);
            }
            this.L.setVisibility(4);
            if (this.W) {
                this.M.setVisibility(0);
                this.N.setVisibility(4);
            } else {
                this.M.setVisibility(4);
                if (this.V) {
                    this.N.setVisibility(0);
                } else {
                    this.N.setVisibility(4);
                }
            }
            this.O.setVisibility(0);
            return;
        }
        if (i == 3) {
            this.K.setVisibility(4);
            if (this.S) {
                this.L.setVisibility(4);
            } else {
                this.L.setVisibility(0);
            }
            this.N.setVisibility(4);
            this.O.setVisibility(0);
            this.M.setVisibility(4);
            return;
        }
        if (i != 4) {
            return;
        }
        this.K.setVisibility(0);
        if (this.S) {
            this.L.setVisibility(4);
        } else {
            this.L.setVisibility(0);
        }
        this.N.setVisibility(4);
        this.O.setVisibility(4);
        this.M.setVisibility(4);
    }

    @Override // com.zenmen.palmchat.friendcircle.video.a.b
    public void a(String str, String str2) throws Throwable {
        LogUtil.d("logvideo", "host: onDownloadComplete=" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str2);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        try {
            Feed feed = this.Q;
            if (feed == null || feed.getMediaList() == null || this.Q.getMediaList().size() <= 0) {
                return;
            }
            Media media = this.Q.getMediaList().get(0);
            String strL = L(media);
            pu1.f(file, new File(strL));
            media.localPath = strL;
            O();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.video.a.b
    public void b(String str) {
        LogUtil.d("logvideo", "host: onDownloadingStarted=" + str);
    }

    @Override // defpackage.zm
    public boolean canPlay() {
        return true;
    }

    @Override // com.zenmen.palmchat.friendcircle.video.a.b
    public void g(Exception exc) {
        LogUtil.d("logvideo", "host: onDownloadFail");
    }

    @Override // defpackage.zm
    public ViewGroup getContainerView() {
        return this.J;
    }

    @Override // defpackage.zm
    public String getPlayPath() {
        Media mediaJ = J(this.Q);
        if (mediaJ == null) {
            return null;
        }
        return mediaJ.videoUrl;
    }

    @Override // defpackage.zm
    public boolean isZooming() {
        return this.T;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Feed feed;
        if (l50.a()) {
            return;
        }
        if (view.getId() != R$id.item_video_field) {
            if (view.getId() != R$id.video_tag || (feed = this.Q) == null || feed.getMediaList() == null || this.Q.getMediaList().size() <= 0) {
                return;
            }
            Media media = this.Q.getMediaList().get(0);
            lf5.g(this.I, media.wid);
            LogUtil.uploadInfoImmediate("dou_M36_source", new a(media));
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(this.A));
            map.put("feedid", this.Q.getFeedId());
            map.put("feedType", Integer.valueOf(this.Q.getFeedType()));
            map.put(ReportItem.RequestKeyRequestId, this.Q.reqId);
            zn6.j("pagediscover_feeds", "click", map);
            return;
        }
        Feed feed2 = this.Q;
        if (feed2 == null || feed2.getMediaList() == null || this.Q.getMediaList().size() <= 0) {
            return;
        }
        List<Media> mediaList = this.Q.getMediaList();
        ArrayList arrayList = new ArrayList();
        if (mediaList == null || mediaList.size() <= 0) {
            return;
        }
        for (Media media2 : mediaList) {
            FeedBean feedBean = new FeedBean();
            MediaItem mediaItem = new MediaItem();
            mediaItem.fileFullPath = media2.videoUrl;
            mediaItem.thumbnailPath = media2.url;
            mediaItem.localPath = L(media2);
            mediaItem.localThumbPath = media2.localThumbPath;
            mediaItem.mimeType = 1;
            mediaItem.playLength = media2.videoDuration;
            feedBean.setMediaItem(mediaItem);
            feedBean.setWidth(media2.width);
            feedBean.setHeight(media2.height);
            feedBean.setFeedId(this.Q.getFeedId().longValue());
            feedBean.setCreateDt(this.Q.getCreateDt().longValue());
            feedBean.setUid(this.Q.getUid());
            arrayList.add(feedBean);
        }
        e eVar = this.R;
        if (eVar == e.PLAYING || eVar == e.DOWNLOAD) {
            int[] iArr = new int[2];
            this.J.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            int i = iArr[0];
            rect.left = i;
            rect.top = iArr[1];
            rect.right = i + this.J.getWidth();
            rect.bottom = rect.top + this.J.getHeight();
            this.S = true;
            this.T = true;
            MagicTextureMediaPlayer magicTextureMediaPlayer = this.P;
            ei4.i((Activity) this.I, arrayList, 0, rect, magicTextureMediaPlayer != null ? magicTextureMediaPlayer.getPosition() + 500 : 0, this.Q, this.A);
        } else {
            ei4.j((Activity) this.I, arrayList, 0, this.Q, this.A);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("feed_id", this.Q.getFeedId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.onClickEvent("M34", null, jSONObject.toString());
        HashMap map2 = new HashMap();
        map2.put("from", Integer.valueOf(this.A));
        map2.put("feedid", this.Q.getFeedId());
        map2.put("feedType", Integer.valueOf(this.Q.getFeedType()));
        map2.put(ReportItem.RequestKeyRequestId, this.Q.reqId);
        zn6.j("pagediscover_feeds", "click", map2);
    }

    @Override // defpackage.zm
    public void onPlayPause() {
        LogUtil.d("logvideo", "host: pause");
        e eVar = this.R;
        if (eVar != e.PLAYING) {
            if (eVar == e.DOWNLOAD) {
                onPlayRelease();
                return;
            }
            return;
        }
        MagicTextureMediaPlayer magicTextureMediaPlayer = this.P;
        if (magicTextureMediaPlayer != null) {
            if (magicTextureMediaPlayer.isPlaying()) {
                this.P.pause();
            }
            this.R = e.PAUSE;
            R();
        }
    }

    @Override // defpackage.zm
    public void onPlayRelease() {
        LogUtil.d("logvideo", "host: release=" + this);
        N();
        this.R = e.STOP;
        R();
        this.T = false;
    }

    @Override // defpackage.zm
    public void onPlayResume() {
        LogUtil.d("logvideo", "host: resume");
        if (this.R != e.PAUSE) {
            onPlayStart(getPlayPath());
            return;
        }
        this.S = false;
        MagicTextureMediaPlayer magicTextureMediaPlayer = this.P;
        if (magicTextureMediaPlayer != null) {
            if (!magicTextureMediaPlayer.isPlaying()) {
                this.P.pause();
            }
            this.R = e.PLAYING;
            R();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    @Override // defpackage.zm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPlayStart(String str) {
        String strL;
        String strM;
        LogUtil.d("logvideo", "host: start=" + str);
        e eVar = this.R;
        e eVar2 = e.PLAYING;
        if (eVar == eVar2) {
            return;
        }
        Media mediaJ = J(this.Q);
        String str2 = null;
        if (mediaJ != null) {
            strL = L(mediaJ);
            if (!com.zenmen.palmchat.friendcircle.video.a.c().b(strL)) {
                strL = null;
            }
            if (!TextUtils.isEmpty(strL) && (!k86.D() || (py4.d() && !ga3.d(new File(strL))))) {
                strL = null;
            }
        }
        if (!TextUtils.isEmpty(strL) || mediaJ == null) {
            strM = null;
        } else {
            str2 = mediaJ.videoUrl;
            strM = M(mediaJ);
        }
        if (!((TextUtils.isEmpty(strL) && (TextUtils.isEmpty(str2) || TextUtils.isEmpty(strM))) ? false : true)) {
            if (this.Q == null || mediaJ == null) {
                return;
            }
            this.S = false;
            this.R = e.DOWNLOAD;
            R();
            com.zenmen.palmchat.friendcircle.video.a.c().a(m(), String.valueOf(this.Q.getFeedId()), mediaJ.videoUrl, mediaJ.url, this);
            return;
        }
        this.S = false;
        Q();
        if (this.P != null) {
            if (TextUtils.isEmpty(strL)) {
                LogUtil.d("logvideo", "host: stream url=" + str2 + ", cache=" + strM);
                this.P.setCachePath(strM);
                this.P.setVideo(str2);
                this.V = true;
                this.X = strM;
            } else {
                LogUtil.d("logvideo", "host: local path=" + strL);
                this.P.setVideo(strL);
            }
            this.P.setLoop(true);
            this.P.setResumable(false);
            this.P.mute(true);
            this.P.start();
            this.R = eVar2;
            R();
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void x(@NonNull Feed feed, int i, int i2) {
        if (feed == null || feed.getMediaList() == null || feed.getMediaList().size() == 0) {
            return;
        }
        this.Q = feed;
        this.K.setImageDrawable(null);
        Media media = this.Q.getMediaList().get(0);
        ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
        if (media.getHeight() >= media.getWidth()) {
            int i3 = this.Y;
            layoutParams.width = i3;
            layoutParams.height = Math.round((i3 / 3.0f) * 4.0f);
        } else {
            int i4 = this.Z;
            layoutParams.width = i4;
            layoutParams.height = Math.round((i4 / 4.0f) * 3.0f);
        }
        this.J.setLayoutParams(layoutParams);
        String strK = K(media);
        if (strK == null) {
            return;
        }
        gr2.j().h(a46.h(this.K, k86.p(strK)), this.K, new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).r());
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void z(@NonNull View view) {
        this.J = (RelativeLayout) u(this.J, R$id.item_video_field);
        this.O = (AspectRatioFrameLayout) u(this.O, R$id.video_content);
        this.K = (ImageView) u(this.K, R$id.video_cover);
        this.L = (ImageView) u(this.L, R$id.video_play_btn);
        this.M = (ImageView) u(this.M, R$id.video_error);
        this.N = (ProgressBar) u(this.N, R$id.video_progress);
        this.J.setOnClickListener(this);
    }

    @Override // com.zenmen.palmchat.friendcircle.video.a.b
    public void i(int i) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements OnStateChangeListener {
        public b() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferFinished() throws Throwable {
            LogUtil.d("logvideo", "host: onBufferFinished");
            VideoViewHolder.this.V = false;
            VideoViewHolder.this.R();
            VideoViewHolder.this.P();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferingDone() {
            LogUtil.d("logvideo", "host: onBufferingDone");
            VideoViewHolder.this.V = false;
            VideoViewHolder.this.R();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferingStarted() {
            LogUtil.d("logvideo", "host: onBufferingStarted");
            VideoViewHolder.this.V = true;
            VideoViewHolder.this.R();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
            LogUtil.d("logvideo", "host: onError=" + i2);
            VideoViewHolder.this.W = true;
            VideoViewHolder.this.R();
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onPrepared(int i, int i2) {
            LogUtil.d("logvideo", "host: onPrepared");
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onVideoFirstFrame() {
            LogUtil.d("logvideo", "host: onVideoFirstFrame");
            VideoViewHolder.this.U = true;
            VideoViewHolder.this.V = false;
            VideoViewHolder.this.W = false;
            VideoViewHolder.this.R();
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
        public void onStarted() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onVideoFormatchanged(int i, int i2) {
        }
    }
}
