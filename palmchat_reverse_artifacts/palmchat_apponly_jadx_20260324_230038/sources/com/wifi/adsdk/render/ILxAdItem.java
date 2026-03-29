package com.wifi.adsdk.render;

import android.content.Context;
import android.view.View;
import com.wifi.adsdk.entity.SingleImage;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ILxAdItem {
    String getAdId();

    String getApiId();

    String getApiSrcId();

    String getAppDeveloper();

    String getAppFunction();

    String getAppIcon();

    String getAppName();

    String getAppPermission();

    String getAppPrivacy();

    long getAppSize();

    String getAppVersion();

    String getBtnText();

    List<String> getClicks();

    List<String> getDeeplinkSuccessLink();

    String getDeeplinkUrl();

    String getDescription();

    String getDigest();

    List<String> getDownloadFinish();

    String getDownloadMd5();

    List<String> getDownloadStart();

    String getDownloadUrl();

    int getEcpm();

    View getExpressView(Context context);

    List<SingleImage> getImageList();

    String getImageUrl();

    List<String> getInstallPSs();

    List<String> getInstalleds();

    String getLandingUrl();

    int getMaterialHeight();

    int getMaterialType();

    int getMaterialWidth();

    String getPackageName();

    String getRequestId();

    List<String> getShows();

    SingleImage getSingleImage();

    String getSlotId();

    String getTitle();

    List<String> getVideo25s();

    List<String> getVideo50s();

    List<String> getVideo75s();

    int getVideoDura();

    List<String> getVideoEs();

    int getVideoHeight();

    String getVideoImgUrl();

    List<String> getVideoSs();

    String getVideoUrl();

    View getVideoView(Context context);

    int getVideoWidth();

    boolean isDownloadAd();
}
