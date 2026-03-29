package com.wifi.ad.core.callback;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.wifi.adsdk.download.LxAdDLManager;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0001H&J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u0001H&J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u001a\u001a\u00020\rH&J\u001a\u0010\u001b\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u0015H&J\b\u0010\u001d\u001a\u00020\nH&J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H&J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H&J\u001a\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#H&J*\u0010$\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010'H&J\u0018\u0010(\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H&¨\u0006)"}, d2 = {"Lcom/wifi/ad/core/callback/AdRequestCallBack;", "", "()V", "addVideoAdView", "videoUrl", "", "parentView", "Landroid/view/ViewGroup;", "baseView", "changeVoiceStatus", "", "exoPlayView", "voiceStatus", "", "checkVideoResumeOrPause", "result", "deleteDownApp", LxAdDLManager.ITEM_PKGURL, "pkgName", "destroyVideo", "getNativeStyleView", "", "scene", "getVideoCurPosition", "", "hasDownPkg", "isAppBackGround", "isShowComplianceInfo", "downType", "onAdRequest", "restartVideo", "resumeDlAd", "showBlurImg", "url", "view", "Landroid/widget/ImageView;", "startDlAd", "downFilePath", "dataObj", "Lorg/json/JSONObject;", "stopDlAd", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class AdRequestCallBack {
    public abstract Object addVideoAdView(String videoUrl, ViewGroup parentView, Object baseView);

    public abstract void changeVoiceStatus(Object exoPlayView, boolean voiceStatus);

    public abstract void checkVideoResumeOrPause(boolean result, Object exoPlayView);

    public abstract void deleteDownApp(String pkgUrl, String pkgName);

    public abstract void destroyVideo(Object exoPlayView);

    public abstract int getNativeStyleView(int scene);

    public abstract long getVideoCurPosition(Object exoPlayView);

    public abstract boolean hasDownPkg(String pkgName);

    public abstract boolean isAppBackGround();

    public abstract boolean isShowComplianceInfo(String scene, int downType);

    public abstract void onAdRequest();

    public abstract void restartVideo(Object exoPlayView);

    public abstract void resumeDlAd(String pkgUrl, String pkgName);

    public abstract boolean showBlurImg(String url, ImageView view);

    public abstract void startDlAd(String pkgUrl, String downFilePath, String pkgName, JSONObject dataObj);

    public abstract void stopDlAd(String pkgUrl, String pkgName);
}
