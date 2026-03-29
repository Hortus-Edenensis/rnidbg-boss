package com.zm.fissionsdk;

import com.zm.adxsdk.protocol.api.interfaces.IWfAdvert;
import com.zm.adxsdk.protocol.api.interfaces.WfAppDownloadListener;
import com.zm.adxsdk.protocol.api.interfaces.WfVideoListener;
import com.zm.fissionsdk.api.interfaces.IFission;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WVZZZ implements IFission {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IWfAdvert f16734a;

    /* JADX INFO: compiled from: SearchBox */
    public class ZV2Zz implements WfVideoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFission.VideoListener f16735a;

        public ZV2Zz(IFission.VideoListener videoListener) {
            this.f16735a = videoListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfVideoListener
        public void onVideoComplete() {
            IFission.VideoListener videoListener = this.f16735a;
            if (videoListener != null) {
                videoListener.onVideoComplete();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfVideoListener
        public void onVideoContinuePlay() {
            IFission.VideoListener videoListener = this.f16735a;
            if (videoListener != null) {
                videoListener.onVideoContinuePlay();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfVideoListener
        public void onVideoError(int i, String str) {
            IFission.VideoListener videoListener = this.f16735a;
            if (videoListener != null) {
                videoListener.onVideoError(i, str);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfVideoListener
        public void onVideoPause() {
            IFission.VideoListener videoListener = this.f16735a;
            if (videoListener != null) {
                videoListener.onVideoPause();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfVideoListener
        public void onVideoPlay() {
            IFission.VideoListener videoListener = this.f16735a;
            if (videoListener != null) {
                videoListener.onVideoPlay();
            }
        }
    }

    public WVZZZ(IWfAdvert iWfAdvert) {
        this.f16734a = iWfAdvert;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    public void addExtraInfo(Map<String, Object> map) {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            iWfAdvert.addExtraInfo(map);
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    public void destroy() {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            iWfAdvert.destroy();
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    public int getAdLogo() {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            return iWfAdvert.getAdLogo();
        }
        return 0;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    public int getECpm() {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            return iWfAdvert.getECpm();
        }
        return 0;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    public String getSid() {
        IWfAdvert iWfAdvert = this.f16734a;
        return iWfAdvert != null ? iWfAdvert.getSid() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionBidding
    public void onBidFail(String str, String str2) {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            iWfAdvert.onBidFail(str, str2);
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionBidding
    public void onBidSuccess(String str) {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            iWfAdvert.onBidSuccess(str, str, "0", "");
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    public void pause() {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            iWfAdvert.pause();
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    public void resume() {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            iWfAdvert.resume();
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    public void setDownloadListener(IFission.AppDownloadListener appDownloadListener) {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            iWfAdvert.setDownloadListener(new zZZ2W(appDownloadListener));
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    public void setRewardListener(IFission.RewardListener rewardListener) {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            iWfAdvert.setRewardListener(rewardListener);
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    public void setVideoListener(IFission.VideoListener videoListener) {
        IWfAdvert iWfAdvert = this.f16734a;
        if (iWfAdvert != null) {
            iWfAdvert.setVideoListener(new ZV2Zz(videoListener));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class zZZ2W implements WfAppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFission.AppDownloadListener f16736a;

        public zZZ2W(IFission.AppDownloadListener appDownloadListener) {
            this.f16736a = appDownloadListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfAppDownloadListener
        public void onDownloadActive(long j, long j2) {
            IFission.AppDownloadListener appDownloadListener = this.f16736a;
            if (appDownloadListener != null) {
                appDownloadListener.onDownloadActive(j, j2);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfAppDownloadListener
        public void onDownloadFail(int i, String str) {
            IFission.AppDownloadListener appDownloadListener = this.f16736a;
            if (appDownloadListener != null) {
                appDownloadListener.onDownloadFail(i, str);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfAppDownloadListener
        public void onDownloadFinish() {
            IFission.AppDownloadListener appDownloadListener = this.f16736a;
            if (appDownloadListener != null) {
                appDownloadListener.onDownloadFinish();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfAppDownloadListener
        public void onDownloadPause(long j, long j2) {
            IFission.AppDownloadListener appDownloadListener = this.f16736a;
            if (appDownloadListener != null) {
                appDownloadListener.onDownloadPause(j, j2);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfAppDownloadListener
        public void onDownloadStart() {
            IFission.AppDownloadListener appDownloadListener = this.f16736a;
            if (appDownloadListener != null) {
                appDownloadListener.onDownloadStart();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfAppDownloadListener
        public void onInstall() {
            IFission.AppDownloadListener appDownloadListener = this.f16736a;
            if (appDownloadListener != null) {
                appDownloadListener.onInstall();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfAppDownloadListener
        public void onDownloadDelete() {
        }
    }
}
