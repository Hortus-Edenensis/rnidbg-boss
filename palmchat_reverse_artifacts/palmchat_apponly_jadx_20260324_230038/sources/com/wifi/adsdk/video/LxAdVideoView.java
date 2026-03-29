package com.wifi.adsdk.video;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.adsdk.LxAdManager;
import com.wifi.adsdk.entity.LxAdBaseView;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.utils.LxAdLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdVideoView extends FrameLayout {
    private Object exoPlayView;
    private LxAdBaseView mAdBaseView;
    private LxAdBeanData mAdItem;
    private Context mContext;
    private Runnable mUpdateRunnable;
    private boolean report0Done;
    private boolean report100Done;
    private boolean report25Done;
    private boolean report50Done;
    private boolean report75Done;
    private long videoAllDuration;
    private boolean videoFinish;

    public LxAdVideoView(@NonNull Context context, LxAdBeanData lxAdBeanData, LxAdBaseView lxAdBaseView) {
        super(context);
        this.videoFinish = false;
        this.report0Done = false;
        this.report25Done = false;
        this.report50Done = false;
        this.report75Done = false;
        this.report100Done = false;
        this.videoAllDuration = 0L;
        this.mUpdateRunnable = new Runnable() { // from class: com.wifi.adsdk.video.LxAdVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LxAdVideoView.this.videoFinish) {
                    return;
                }
                WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                if (wifiNestAd.getMAdRequestCallBack() != null && LxAdVideoView.this.exoPlayView != null) {
                    long videoCurPosition = wifiNestAd.getMAdRequestCallBack().getVideoCurPosition(LxAdVideoView.this.exoPlayView);
                    if (LxAdVideoView.this.videoAllDuration > 0) {
                        int i = (int) ((videoCurPosition * 100.0f) / LxAdVideoView.this.videoAllDuration);
                        LxAdLog.d("LxAdVideoView videoAdFinish videoFinish true curPosition " + videoCurPosition + " process " + i);
                        if (!LxAdVideoView.this.report25Done && i >= 15 && i <= 35) {
                            LxAdVideoView.this.report25Done = true;
                            LxAdManager.getAdManager().getConfig().getUrlEvent().reportVideo25(LxAdVideoView.this.mAdItem);
                        }
                        if (!LxAdVideoView.this.report50Done && i >= 40 && i <= 60) {
                            LxAdVideoView.this.report50Done = true;
                            LxAdManager.getAdManager().getConfig().getUrlEvent().reportVideo50(LxAdVideoView.this.mAdItem);
                        }
                        if (!LxAdVideoView.this.report75Done && i >= 65 && i <= 85) {
                            LxAdVideoView.this.report75Done = true;
                            LxAdManager.getAdManager().getConfig().getUrlEvent().reportVideo75(LxAdVideoView.this.mAdItem);
                        }
                    }
                }
                LxAdVideoView.this.checkVideoResumeOrPause();
                LxAdVideoView.this.postUpdateRunnable();
            }
        };
        this.mContext = context;
        this.mAdItem = lxAdBeanData;
        this.mAdBaseView = lxAdBaseView;
        addExoPlayView();
    }

    private void addExoPlayView() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        if (lxAdBeanData == null || lxAdBeanData.getVideo() == null || TextUtils.isEmpty(this.mAdItem.getVideo().getVideoUrl())) {
            return;
        }
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (wifiNestAd.getMAdRequestCallBack() != null) {
            this.exoPlayView = wifiNestAd.getMAdRequestCallBack().addVideoAdView(this.mAdItem.getVideo().getVideoUrl(), this, this.mAdBaseView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVideoResumeOrPause() {
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (wifiNestAd.getMAdRequestCallBack() == null || this.exoPlayView == null) {
            return;
        }
        wifiNestAd.getMAdRequestCallBack().checkVideoResumeOrPause(viewIsVisible(), this.exoPlayView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postUpdateRunnable() {
        removeCallbacks(this.mUpdateRunnable);
        postDelayed(this.mUpdateRunnable, 500L);
    }

    private boolean viewIsVisible() {
        try {
            if (!getLocalVisibleRect(new Rect())) {
                return false;
            }
            boolean z = getWindowVisibility() == 0;
            WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
            return !(wifiNestAd.getMAdRequestCallBack() != null ? wifiNestAd.getMAdRequestCallBack().isAppBackGround() : true) && z;
        } catch (Exception unused) {
            return false;
        }
    }

    public void changeVoiceStatus(boolean z) {
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (wifiNestAd.getMAdRequestCallBack() == null || this.exoPlayView == null) {
            return;
        }
        wifiNestAd.getMAdRequestCallBack().changeVoiceStatus(this.exoPlayView, z);
    }

    public void onDestroy() {
        this.videoFinish = true;
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (wifiNestAd.getMAdRequestCallBack() == null || this.exoPlayView == null) {
            return;
        }
        wifiNestAd.getMAdRequestCallBack().destroyVideo(this.exoPlayView);
    }

    public void restartVideo() {
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (wifiNestAd.getMAdRequestCallBack() == null || this.exoPlayView == null) {
            return;
        }
        wifiNestAd.getMAdRequestCallBack().restartVideo(this.exoPlayView);
        this.videoFinish = false;
        postUpdateRunnable();
    }

    public void videoAdFinish() {
        this.videoFinish = true;
        if (!this.report100Done) {
            this.report100Done = true;
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportVideoE(this.mAdItem);
        }
        LxAdLog.d("LxAdVideoView videoAdFinish videoFinish true ");
    }

    public void videoAdStart(long j) {
        this.videoAllDuration = j;
        if (!this.report0Done) {
            this.report0Done = true;
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportVideoMute(this.mAdItem);
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportVideoS(this.mAdItem);
        }
        LxAdLog.d("LxAdVideoView videoAdStart videoAllDuration " + this.videoAllDuration);
        postUpdateRunnable();
    }
}
