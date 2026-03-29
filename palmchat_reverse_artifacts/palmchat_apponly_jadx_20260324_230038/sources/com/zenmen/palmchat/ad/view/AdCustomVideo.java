package com.zenmen.palmchat.ad.view;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.media.player.MediaPlayerNotificationInfo;
import com.zenmen.media.player.OnStateChangeListener;
import com.zenmen.palmchat.ad.model.AdInfoBean;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a7;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.qd3;
import defpackage.ry5;
import defpackage.s7;
import defpackage.z6;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdCustomVideo extends AdView {
    private static final String TAG = "AdCustomVideo";
    private boolean hasReset;
    private boolean isBuffering;
    private boolean isPreVideoLoading;
    private ImageView mAdCoverImageView;
    private ProgressBar mAdCustomVideoLoad;
    private ImageView mAdCustomVideoStart;
    private AdVideoViewNew mAdCustomVideoView;
    private TextView mAdViewDuration;
    private Context mContext;
    private s7 mCurrentAdsBean;
    private boolean mIsBindVideoPath;
    private float mSpeed;
    private RelativeLayout mVideoLayout;
    private int videoBeginTime;
    private int videoEndTime;
    private int videoEndTimeNoPause;
    private int videoPlayingIndex;
    private int videoStatus;
    private int videoType;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdCustomVideo.this.startPlayVideo(false);
            AdCustomVideo.this.reportClick(4);
        }
    }

    public AdCustomVideo(Context context) {
        this(context, null);
    }

    private void init() {
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAdxLog(String str) {
        s7 s7Var = this.mCurrentAdsBean;
        if (s7Var == null || s7Var.e() == null) {
            LogUtil.e(TAG, "reportAdxLog--:" + str + "---->Null");
            return;
        }
        LogUtil.e(TAG, "reportAdxLog--:" + str + "---->" + this.mCurrentAdsBean.e().toString());
    }

    private void setOnListener() {
        this.mAdCustomVideoStart.setOnClickListener(new a());
        this.mAdCustomVideoView.setOnStateChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlayVideo(boolean z) {
        LogUtil.d(TAG, "startPlayVideo");
        s7 s7Var = this.mCurrentAdsBean;
        if (s7Var == null) {
            return;
        }
        s7Var.d0(z);
        if (this.mCurrentAdsBean.D() && !this.mIsBindVideoPath) {
            String strT = this.mCurrentAdsBean.t();
            String strC = z6.d().c(strT, true);
            if (!(!TextUtils.isEmpty(strC)) && !hx3.m(c.b())) {
                ry5.a("网络异常");
                return;
            }
            try {
                if (TextUtils.isEmpty(strC)) {
                    this.mAdCustomVideoView.setVideoPath(strT);
                    this.mIsBindVideoPath = true;
                } else {
                    try {
                        this.mAdCustomVideoView.setVideoPath(strC);
                        this.mIsBindVideoPath = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.mAdCustomVideoView.setVideoPath(strT);
                        this.mIsBindVideoPath = true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } else if (!this.mCurrentAdsBean.D()) {
            return;
        }
        if (!this.hasReset && this.isBuffering) {
            this.mAdCustomVideoLoad.setVisibility(0);
        }
        this.mAdCustomVideoView.seekTo(0);
        this.mAdCustomVideoView.setLoop(false);
        this.mAdCustomVideoView.setResumable(false);
        this.mAdCustomVideoView.mute(true);
        this.mAdCustomVideoView.setSpeed(this.mSpeed);
        this.mAdCustomVideoView.start();
        this.mAdCustomVideoStart.setVisibility(8);
        this.mAdCoverImageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchViewStatus(boolean z) {
        this.mAdCoverImageView.setVisibility(0);
        this.mAdCustomVideoLoad.setVisibility(8);
        this.mAdCustomVideoStart.setVisibility(0);
        LogUtil.i(TAG, "switchViewStatus" + this.mAdCustomVideoView.getCurrentPosition() + " " + this.mAdCustomVideoView.isPlaying());
        this.hasReset = true;
        if (this.mAdCustomVideoView.isPlaying()) {
            this.mAdCustomVideoView.pause();
            if (z) {
                return;
            }
            setAdInfoBean(false);
            reportAdxLog("reportPlayQuit");
            this.mCurrentAdsBean.U();
        }
    }

    public AdInfoBean getVideoAdInfoBean(boolean z) {
        s7 s7Var = this.mCurrentAdsBean;
        AdInfoBean adInfoBean = (s7Var == null || s7Var.e() == null) ? new AdInfoBean(this.rootView.getLeft(), this.rootView.getTop(), this.rootView.getRight(), this.rootView.getBottom()) : this.mCurrentAdsBean.e();
        adInfoBean.setVideoTime(this.mAdCustomVideoView.getDuration() / 1000);
        if (this.mCurrentAdsBean != null && z) {
            adInfoBean.setPlayTime(this.mAdCustomVideoView.getDuration() / 1000);
            adInfoBean.setEndTime(this.mAdCustomVideoView.getDuration() / 1000);
        } else if (this.mAdCustomVideoView.getCurrentPosition() < 200) {
            adInfoBean.setPlayTime(this.mAdCustomVideoView.getCurrentPosition() / 1000);
        } else {
            int iCeil = (int) Math.ceil(((double) this.mAdCustomVideoView.getCurrentPosition()) / 1000.0d);
            if (iCeil > this.mAdCustomVideoView.getDuration() / 1000) {
                iCeil = this.mAdCustomVideoView.getDuration() / 1000;
            }
            adInfoBean.setPlayTime(iCeil);
            adInfoBean.setEndTime(iCeil);
        }
        adInfoBean.setBeginTime(this.videoBeginTime / 1000);
        adInfoBean.setPlayFirstFrame(this.videoBeginTime <= 100 ? 1 : 0);
        adInfoBean.setPlayLastFrame(this.videoEndTimeNoPause >= this.mAdCustomVideoView.getDuration() - 100 ? 1 : 0);
        adInfoBean.setScene(1);
        adInfoBean.setType(this.videoType);
        s7 s7Var2 = this.mCurrentAdsBean;
        if (s7Var2 != null) {
            adInfoBean.setBehavior(s7Var2.v() ? 1 : 2);
        }
        adInfoBean.setStatus(this.videoStatus);
        LogUtil.d(TAG, "getVideoAdInfoBean = " + adInfoBean.toString());
        return adInfoBean;
    }

    public int getVideoDuration() {
        AdVideoViewNew adVideoViewNew = this.mAdCustomVideoView;
        if (adVideoViewNew != null) {
            return adVideoViewNew.getDuration();
        }
        return 0;
    }

    public int getVideoIndex() {
        AdVideoViewNew adVideoViewNew = this.mAdCustomVideoView;
        if (adVideoViewNew != null) {
            return adVideoViewNew.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void initView() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R$layout.layout_ad_video_widget2, this);
        super.initView();
        this.mVideoLayout = (RelativeLayout) this.rootView.findViewById(R$id.ad_video_layout);
        this.mAdCustomVideoView = (AdVideoViewNew) this.rootView.findViewById(R$id.ad_custom_videoView);
        this.mAdCustomVideoStart = (ImageView) this.rootView.findViewById(R$id.ad_custom_video_start);
        this.mAdCustomVideoLoad = (ProgressBar) this.rootView.findViewById(R$id.ad_custom_video_load);
        this.mAdCoverImageView = (ImageView) this.rootView.findViewById(R$id.ad_custom_video_cover);
        this.mAdViewDuration = (TextView) this.rootView.findViewById(R$id.ad_video_duration);
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void onPause() {
        super.onPause();
        LogUtil.i(TAG, "onPause");
        switchViewStatus(false);
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void onResume() {
        super.onResume();
        LogUtil.i(TAG, "onResume");
    }

    public void onVideoPause(boolean z) {
        LogUtil.i(TAG, "onPause--->" + this.mAdCustomVideoView.isPlaying());
        this.videoType = 2;
        if (this.mAdCustomVideoView.isPlaying()) {
            this.videoPlayingIndex = this.mAdCustomVideoView.getCurrentPosition();
            this.mAdCustomVideoView.pause();
            setVideoCoverBackground(null);
        }
        if (z) {
            this.mAdCustomVideoView.setVisibility(8);
        }
    }

    public void onVideoResume(boolean z) {
        LogUtil.d(TAG, "onVideoResume");
        if (z) {
            this.mAdCustomVideoView.setVisibility(0);
        }
        this.isPreVideoLoading = false;
        LogUtil.i(TAG, "seekTo--->" + this.videoPlayingIndex);
        s7 s7Var = this.mCurrentAdsBean;
        if (s7Var != null && s7Var.D() && !this.mAdCustomVideoView.isPlaying() && this.videoPlayingIndex != -1) {
            this.mAdCustomVideoView.start();
            if (this.mCurrentAdsBean != null) {
                setAdInfoBean(false);
                reportAdxLog("reportPlayBegin");
                this.mCurrentAdsBean.S(false);
            }
        }
        this.videoPlayingIndex = -1;
    }

    public void pause() {
        if (this.mAdCustomVideoView.canPause()) {
            this.mAdCustomVideoView.pause();
        }
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void release() {
        super.release();
        LogUtil.i(TAG, "release");
        switchViewStatus(false);
        z6.d().a(this.mAdCustomVideoView.getCachePath());
        AdVideoViewNew adVideoViewNew = this.mAdCustomVideoView;
        if (adVideoViewNew != null) {
            adVideoViewNew.release();
        }
    }

    public void setAdInfoBean(boolean z) {
        AdInfoBean videoAdInfoBean;
        super.setAdInfoBean();
        if (this.mCurrentAdsBean != null && (videoAdInfoBean = getVideoAdInfoBean(z)) != null) {
            this.mCurrentAdsBean.u(videoAdInfoBean);
        }
        LogUtil.d(TAG, "setAdInfoBean = " + this.adInfoBean.toString());
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void setData(s7 s7Var) {
        qd3 qd3VarN;
        List<String> listE;
        if (s7Var == null && this.mCurrentAdsBean == null) {
            return;
        }
        super.setData(s7Var);
        if (s7Var != null && (qd3VarN = s7Var.n()) != null && (listE = qd3VarN.e()) != null && listE.size() != 0) {
            gr2.j().h(listE.get(0), this.mAdCoverImageView, AdView.getDisplayImageOptions());
            LogUtil.d(TAG, "AdManager setData title = " + qd3VarN.i() + ", imgurl = " + listE.get(0));
        }
        if (this.isPreVideoLoading && s7Var == this.mCurrentAdsBean) {
            LogUtil.i(TAG, "已经被预加载过，直接播放");
            this.isPreVideoLoading = false;
            onVideoResume(false);
            return;
        }
        this.isPreVideoLoading = false;
        if (s7Var != null) {
            this.mCurrentAdsBean = s7Var;
        }
        this.videoPlayingIndex = -1;
        try {
            setOnListener();
        } catch (Exception e) {
            e.printStackTrace();
        }
        qd3.a aVarS = this.mCurrentAdsBean.s();
        if (aVarS != null) {
            long jB = aVarS.b();
            LogUtil.d(TAG, "video dutation = " + jB);
            if (jB != 0) {
                this.mAdViewDuration.setText(a7.f(new Long(jB).intValue()));
                this.mAdViewDuration.setVisibility(0);
            } else {
                this.mAdViewDuration.setVisibility(8);
            }
        }
        Point pointC = a7.c(s7Var, 1);
        ViewGroup.LayoutParams layoutParams = this.mVideoLayout.getLayoutParams();
        layoutParams.width = pointC.x;
        layoutParams.height = pointC.y;
        this.mVideoLayout.setLayoutParams(layoutParams);
        this.mAdCustomVideoView.setVisibility(0);
        this.mIsBindVideoPath = false;
        if (!this.mCurrentAdsBean.D()) {
            setVisibility(8);
            return;
        }
        String strT = this.mCurrentAdsBean.t();
        String strC = z6.d().c(strT, true);
        LogUtil.d(TAG, "cacheVideoUrl = " + strC);
        try {
            if (!TextUtils.isEmpty(strC)) {
                try {
                    this.mAdCustomVideoView.setVideoPath(strC);
                    this.mIsBindVideoPath = true;
                    startPlayVideo(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.mAdCustomVideoView.setVideoPath(strT);
                    this.mIsBindVideoPath = true;
                }
            } else if (hx3.n()) {
                this.mAdCustomVideoView.setVideoPath(strT);
                this.mIsBindVideoPath = true;
                startPlayVideo(true);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            setVisibility(8);
        }
    }

    public void setSpeed(float f) {
        this.mSpeed = f;
        LogUtil.d(TAG, "setSpeed = " + this.mSpeed);
    }

    public void start() {
        if (this.mCurrentAdsBean != null) {
            this.mAdCustomVideoView.start();
        }
    }

    public AdCustomVideo(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdCustomVideo(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoStatus = 1;
        this.videoType = 1;
        this.videoPlayingIndex = -1;
        this.mIsBindVideoPath = false;
        this.mSpeed = 1.0f;
        this.isBuffering = true;
        this.hasReset = false;
        this.mContext = context;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoCoverBackground(s7 s7Var) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements OnStateChangeListener {
        public b() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferFinished() throws Throwable {
            LogUtil.i(AdCustomVideo.TAG, "onBufferFinished");
            z6.d().g(AdCustomVideo.this.mCurrentAdsBean.t(), AdCustomVideo.this.mAdCustomVideoView.getCachePath());
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferingDone() {
            AdCustomVideo.this.mAdCustomVideoLoad.setVisibility(8);
            LogUtil.i(AdCustomVideo.TAG, "缓冲结束");
            AdCustomVideo.this.videoStatus = 0;
            AdCustomVideo.this.isBuffering = false;
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferingStarted() {
            if (AdCustomVideo.this.mAdCustomVideoView.isPlaying()) {
                AdCustomVideo.this.mAdCustomVideoLoad.setVisibility(0);
            }
            LogUtil.i(AdCustomVideo.TAG, "正在缓冲");
            AdCustomVideo.this.videoStatus = 1;
            AdCustomVideo.this.isBuffering = true;
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onCompleted() {
            LogUtil.i(AdCustomVideo.TAG, "onCompletion");
            AdCustomVideo adCustomVideo = AdCustomVideo.this;
            adCustomVideo.videoEndTime = adCustomVideo.mAdCustomVideoView.getDuration();
            AdCustomVideo adCustomVideo2 = AdCustomVideo.this;
            adCustomVideo2.videoEndTimeNoPause = adCustomVideo2.mAdCustomVideoView.getDuration();
            if (AdCustomVideo.this.mCurrentAdsBean != null) {
                AdCustomVideo.this.setAdInfoBean(true);
                AdCustomVideo.this.reportAdxLog("reportPlayEnd");
                AdCustomVideo.this.mCurrentAdsBean.T();
                AdCustomVideo adCustomVideo3 = AdCustomVideo.this;
                adCustomVideo3.setVideoCoverBackground(adCustomVideo3.mCurrentAdsBean);
            }
            AdCustomVideo.this.videoType = 3;
            AdCustomVideo.this.switchViewStatus(true);
            z6.d().a(AdCustomVideo.this.mAdCustomVideoView.getCachePath());
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
            LogUtil.i(AdCustomVideo.TAG, "播放失败");
            AdCustomVideo.this.mAdCustomVideoView.stop();
            AdCustomVideo.this.mAdCustomVideoLoad.setVisibility(8);
            AdCustomVideo.this.videoStatus = 2;
            AdCustomVideo.this.setVideoCoverBackground(null);
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onPaused() {
            LogUtil.i(AdCustomVideo.TAG, "onPaused");
            AdCustomVideo.this.videoType = 2;
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onPrepared(int i, int i2) {
            LogUtil.i(AdCustomVideo.TAG, "onPrepared");
            AdCustomVideo.this.mAdCustomVideoLoad.setVisibility(8);
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onStarted() {
            AdCustomVideo.this.mAdCoverImageView.setVisibility(8);
            if (AdCustomVideo.this.videoBeginTime == 0) {
                AdCustomVideo adCustomVideo = AdCustomVideo.this;
                adCustomVideo.videoBeginTime = adCustomVideo.mAdCustomVideoView.getCurrentPosition();
            }
            LogUtil.i(AdCustomVideo.TAG, "渲染的第一帧视频---videoBeginTime--->" + AdCustomVideo.this.videoBeginTime);
            if (AdCustomVideo.this.isPreVideoLoading) {
                LogUtil.i(AdCustomVideo.TAG, "预加载，设置暂停");
                AdCustomVideo.this.onVideoPause(false);
                return;
            }
            if (AdCustomVideo.this.mCurrentAdsBean != null) {
                AdCustomVideo.this.setAdInfoBean(false);
                AdCustomVideo.this.reportAdxLog("reportPlayBegin");
                AdCustomVideo.this.mCurrentAdsBean.S(AdCustomVideo.this.mCurrentAdsBean.v());
            }
            AdCustomVideo.this.setVideoCoverBackground(null);
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onVideoFormatchanged(int i, int i2) {
            LogUtil.i(AdCustomVideo.TAG, "onVideoFormatchanged");
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onSeekCompleted() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onVideoFirstFrame() {
        }
    }
}
