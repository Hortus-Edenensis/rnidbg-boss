package com.wifi.adsdk.params;

import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.entity.LxEventReplace;
import com.wifi.adsdk.event.AdEventManager;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultUrlEvent implements ILxAdUrlEvent {
    public void OnDcUrlsEvent(List<String> list, LxEventReplace lxEventReplace) {
        if (list == null || list.size() == 0) {
            return;
        }
        AdEventManager.getInstance().onAdEvent(list, lxEventReplace);
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void report(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        OnDcUrlsEvent(list, null);
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportAppOpenLink(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getAppOpenLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportClick(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getClickLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportClose(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null || lxAdBeanData.isAdCloseEventUrl()) {
            return;
        }
        lxAdBeanData.setAdCloseEventUrl(true);
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getUserCloseLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportDeepSuccess(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getDeeplinkSuccessLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportDeeplinkFailLink(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getDeeplinkFailLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportDownloadFail(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getDownloadFailLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportDownloadS(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        if (lxAdBeanData.getEventReplace() != null) {
            lxAdBeanData.getEventReplace().setDldStatus("1");
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getDownloadStartedLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportDownloaded(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        if (lxAdBeanData.getEventReplace() != null) {
            lxAdBeanData.getEventReplace().setDldStatus("2");
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getDownloadFinishedLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportInstallFail(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getInstallFailLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportInstallFinished(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        if (lxAdBeanData.getEventReplace() != null) {
            lxAdBeanData.getEventReplace().setDldStatus("4");
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getInstallFinishedLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportInstallStart(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        if (lxAdBeanData.getEventReplace() != null) {
            lxAdBeanData.getEventReplace().setDldStatus("3");
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getInstallStartedLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportShow(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getShowLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportVideo25(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getVideoShow25ppLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportVideo50(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getVideoShow50ppLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportVideo75(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getVideoShow75ppLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportVideoClose(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getVideoShowCloseLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportVideoE(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getVideoShowEndLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportVideoMute(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getVideoShowMuteLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportVideoPause(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getVideoShowPauseLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportVideoReplay(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getVideoShowReplayLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportVideoS(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getVideoShowStartLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportWinNoticeLink(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getWinNoticeLink(), lxAdBeanData.getEventReplace());
    }

    @Override // com.wifi.adsdk.params.ILxAdUrlEvent
    public void reportWxAppSuccess(LxAdBeanData lxAdBeanData) {
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return;
        }
        OnDcUrlsEvent(lxAdBeanData.getTrackingList().getMiniProgramSuccessLink(), lxAdBeanData.getEventReplace());
    }
}
