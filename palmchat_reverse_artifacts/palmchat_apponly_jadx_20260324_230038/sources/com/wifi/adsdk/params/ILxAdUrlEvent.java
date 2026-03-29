package com.wifi.adsdk.params;

import com.wifi.adsdk.entity.LxAdBeanData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ILxAdUrlEvent {
    void report(List<String> list);

    void reportAppOpenLink(LxAdBeanData lxAdBeanData);

    void reportClick(LxAdBeanData lxAdBeanData);

    void reportClose(LxAdBeanData lxAdBeanData);

    void reportDeepSuccess(LxAdBeanData lxAdBeanData);

    void reportDeeplinkFailLink(LxAdBeanData lxAdBeanData);

    void reportDownloadFail(LxAdBeanData lxAdBeanData);

    void reportDownloadS(LxAdBeanData lxAdBeanData);

    void reportDownloaded(LxAdBeanData lxAdBeanData);

    void reportInstallFail(LxAdBeanData lxAdBeanData);

    void reportInstallFinished(LxAdBeanData lxAdBeanData);

    void reportInstallStart(LxAdBeanData lxAdBeanData);

    void reportShow(LxAdBeanData lxAdBeanData);

    void reportVideo25(LxAdBeanData lxAdBeanData);

    void reportVideo50(LxAdBeanData lxAdBeanData);

    void reportVideo75(LxAdBeanData lxAdBeanData);

    void reportVideoClose(LxAdBeanData lxAdBeanData);

    void reportVideoE(LxAdBeanData lxAdBeanData);

    void reportVideoMute(LxAdBeanData lxAdBeanData);

    void reportVideoPause(LxAdBeanData lxAdBeanData);

    void reportVideoReplay(LxAdBeanData lxAdBeanData);

    void reportVideoS(LxAdBeanData lxAdBeanData);

    void reportWinNoticeLink(LxAdBeanData lxAdBeanData);

    void reportWxAppSuccess(LxAdBeanData lxAdBeanData);
}
