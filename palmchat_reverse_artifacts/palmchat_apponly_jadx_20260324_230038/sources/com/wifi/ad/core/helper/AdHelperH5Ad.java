package com.wifi.ad.core.helper;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.chapterad.WkChapterAdShowMg;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.AdShowConfig;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.feedbanner.WkFeedBannerShowMg;
import com.wifi.ad.core.listener.FeedBannerLoadListener;
import com.wifi.ad.core.listener.FeedBannerShowListener;
import com.wifi.ad.core.listener.H5CallListener;
import com.wifi.ad.core.listener.InterstitialShowListener;
import com.wifi.ad.core.listener.RewardShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.strategy.SdkStrategy;
import com.wifi.ad.core.utils.MD5Util;
import com.wifi.ad.core.utils.WifiLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nJ&\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J,\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u0011J\"\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u0011J\"\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u0011J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u001b"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperH5Ad;", "", "()V", "destroyAd", "", "requestId", "", "getAdRequestId", "getAdSDKVersion", "context", "Landroid/content/Context;", "getH5Ad", "activity", "Landroid/app/Activity;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", bq.f.s, "Lcom/wifi/ad/core/listener/H5CallListener;", "hideH5Ad", "showH5Ad", "parentView", "Landroid/view/ViewGroup;", "adShowString", "showListener", "showH5InterstitialAd", "showH5RewardVideoAd", "showHideH5Ad", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperH5Ad {
    public static final AdHelperH5Ad INSTANCE = new AdHelperH5Ad();

    private AdHelperH5Ad() {
    }

    public static /* synthetic */ void getH5Ad$default(AdHelperH5Ad adHelperH5Ad, Activity activity, AdParams adParams, H5CallListener h5CallListener, int i, Object obj) {
        if ((i & 4) != 0) {
            h5CallListener = null;
        }
        adHelperH5Ad.getH5Ad(activity, adParams, h5CallListener);
    }

    public final synchronized void destroyAd(String requestId) {
        AdHelperH5RewardVideo.INSTANCE.destroyAd(requestId);
        AdHelperH5InterstitialAd.INSTANCE.destroyAd(requestId);
        SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
        HashMap<String, List<NestAdData>> allAdData = companion.getAllAdData();
        if (allAdData == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }
        if (allAdData.containsKey(requestId)) {
            HashMap<String, List<NestAdData>> allAdData2 = companion.getAllAdData();
            if (allAdData2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
            TypeIntrinsics.asMutableMap(allAdData2).remove(requestId);
        }
        HashMap<String, View> allAdAdView = companion.getAllAdAdView();
        if (allAdAdView == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }
        if (allAdAdView.containsKey(requestId)) {
            HashMap<String, View> allAdAdView2 = companion.getAllAdAdView();
            if (allAdAdView2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
            TypeIntrinsics.asMutableMap(allAdAdView2).remove(requestId);
        }
        HashMap<String, H5CallListener> allAdLoadListener = companion.getAllAdLoadListener();
        if (allAdLoadListener == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }
        if (allAdLoadListener.containsKey(requestId)) {
            companion.getAllAdLoadListener().get(requestId);
            HashMap<String, H5CallListener> allAdLoadListener2 = companion.getAllAdLoadListener();
            if (allAdLoadListener2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
            TypeIntrinsics.asMutableMap(allAdLoadListener2).remove(requestId);
        }
        HashMap<String, H5CallListener> allAdShowListener = companion.getAllAdShowListener();
        if (allAdShowListener == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }
        if (allAdShowListener.containsKey(requestId)) {
            companion.getAllAdShowListener().get(requestId);
            HashMap<String, H5CallListener> allAdShowListener2 = companion.getAllAdShowListener();
            if (allAdShowListener2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
            TypeIntrinsics.asMutableMap(allAdShowListener2).remove(requestId);
        }
    }

    public final String getAdRequestId() {
        return MD5Util.toMD5(String.valueOf(System.currentTimeMillis()) + UUID.randomUUID());
    }

    public final String getAdSDKVersion(Context context) {
        return NestSdkVersion.INSTANCE.getVersion(context);
    }

    public final synchronized void getH5Ad(@NonNull Activity activity, @NonNull AdParams adParams, @NonNull final H5CallListener listener) {
        WifiLog.d("H5Ad requestH5Ad AdParams " + adParams.toString());
        boolean z = true;
        if (adParams.getH5AdType() == 1 || adParams.getH5AdType() == 2) {
            AdHelperFeedBanner.INSTANCE.getFeedBannerAd(activity, adParams, new FeedBannerLoadListener() { // from class: com.wifi.ad.core.helper.AdHelperH5Ad.getH5Ad.1
                @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
                public void onAdFailed(String errorCode, String message, String requestId) throws JSONException {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errCode", errorCode);
                    jSONObject.put(WifiNestConst.OtherConst.KEY_MSG, message);
                    H5CallListener h5CallListener = listener;
                    if (h5CallListener != null) {
                        String string = jSONObject.toString();
                        Intrinsics.checkExpressionValueIsNotNull(string, "errorObject.toString()");
                        h5CallListener.onResult(requestId, "onAdFailed", string);
                    }
                }

                @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
                public void onAdLoad(String providerType, String requestId) {
                    H5CallListener h5CallListener = listener;
                    if (h5CallListener != null) {
                        h5CallListener.onResult(requestId, "onAdLoad", "");
                    }
                }

                @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
                public void onStart(String requestId) {
                    H5CallListener h5CallListener = listener;
                    if (h5CallListener != null) {
                        h5CallListener.onResult(requestId, "onStart", "");
                    }
                }
            });
        } else if (adParams.getH5AdType() == 3) {
            AdHelperH5RewardVideo.INSTANCE.getRewardAd(activity, adParams, new FeedBannerLoadListener() { // from class: com.wifi.ad.core.helper.AdHelperH5Ad.getH5Ad.2
                @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
                public void onAdFailed(String errorCode, String message, String requestId) throws JSONException {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errCode", errorCode);
                    jSONObject.put(WifiNestConst.OtherConst.KEY_MSG, message);
                    H5CallListener h5CallListener = listener;
                    if (h5CallListener != null) {
                        String string = jSONObject.toString();
                        Intrinsics.checkExpressionValueIsNotNull(string, "errorObject.toString()");
                        h5CallListener.onResult(requestId, "onAdFailed", string);
                    }
                }

                @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
                public void onAdLoad(String providerType, String requestId) {
                    H5CallListener h5CallListener = listener;
                    if (h5CallListener != null) {
                        h5CallListener.onResult(requestId, "onAdLoad", "");
                    }
                }

                @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
                public void onStart(String requestId) {
                    H5CallListener h5CallListener = listener;
                    if (h5CallListener != null) {
                        h5CallListener.onResult(requestId, "onStart", "");
                    }
                }
            });
        } else if (adParams.getH5AdType() == 4) {
            AdHelperH5InterstitialAd.INSTANCE.getInterstitialAd(activity, adParams, new FeedBannerLoadListener() { // from class: com.wifi.ad.core.helper.AdHelperH5Ad.getH5Ad.3
                @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
                public void onAdFailed(String errorCode, String message, String requestId) throws JSONException {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errCode", errorCode);
                    jSONObject.put(WifiNestConst.OtherConst.KEY_MSG, message);
                    H5CallListener h5CallListener = listener;
                    if (h5CallListener != null) {
                        String string = jSONObject.toString();
                        Intrinsics.checkExpressionValueIsNotNull(string, "errorObject.toString()");
                        h5CallListener.onResult(requestId, "onAdFailed", string);
                    }
                }

                @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
                public void onAdLoad(String providerType, String requestId) {
                    H5CallListener h5CallListener = listener;
                    if (h5CallListener != null) {
                        h5CallListener.onResult(requestId, "onAdLoad", "");
                    }
                }

                @Override // com.wifi.ad.core.listener.FeedBannerLoadListener
                public void onStart(String requestId) {
                    H5CallListener h5CallListener = listener;
                    if (h5CallListener != null) {
                        h5CallListener.onResult(requestId, "onStart", "");
                    }
                }
            });
        }
        if (adParams.getExt() != null) {
            Map<String, String> ext = adParams.getExt();
            if (ext == null) {
                Intrinsics.throwNpe();
            }
            if (ext.containsKey("requestId") && listener != null) {
                Map<String, String> ext2 = adParams.getExt();
                if (ext2 == null) {
                    Intrinsics.throwNpe();
                }
                String str = ext2.get("requestId");
                if (str != null && str.length() != 0) {
                    z = false;
                }
                if (!z) {
                    HashMap<String, H5CallListener> allAdLoadListener = SdkStrategy.INSTANCE.getAllAdLoadListener();
                    Map<String, String> ext3 = adParams.getExt();
                    if (ext3 == null) {
                        Intrinsics.throwNpe();
                    }
                    String str2 = ext3.get("requestId");
                    if (str2 == null) {
                        Intrinsics.throwNpe();
                    }
                    allAdLoadListener.put(str2, listener);
                }
            }
        }
    }

    public final synchronized void hideH5Ad(String requestId) {
        List<NestAdData> list;
        SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
        HashMap<String, View> allAdAdView = companion.getAllAdAdView();
        if (allAdAdView == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }
        if (allAdAdView.containsKey(requestId)) {
            View view = companion.getAllAdAdView().get(requestId);
            if (view == null) {
                Intrinsics.throwNpe();
            }
            view.setVisibility(8);
            HashMap<String, List<NestAdData>> allAdData = companion.getAllAdData();
            if (allAdData == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
            if (allAdData.containsKey(requestId) && (list = companion.getAllAdData().get(requestId)) != null && (!list.isEmpty())) {
                NestAdData nestAdData = list.get(0);
                EventParams eventParams = new EventParams.Builder().setDspName(nestAdData.getDspName()).setNestSid(nestAdData.getNestSid()).setSrcId(String.valueOf(nestAdData.getAdCode())).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(nestAdData.getSdkFrom()).build();
                AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
                AdParams adParams = nestAdData.getAdParams();
                reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_HIDE, eventParams, adParams != null ? adParams.getExt() : null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void showH5Ad(@NonNull Activity activity, @NonNull ViewGroup parentView, String adShowString, @NonNull final H5CallListener showListener) {
        List<NestAdData> list;
        WifiLog.d("H5Banner showH5Ad start");
        WifiLog.d("H5Ad showH5Ad adShowString " + adShowString);
        JSONObject jSONObject = new JSONObject(adShowString);
        int iOptInt = jSONObject.optInt("adHeight");
        int iOptInt2 = jSONObject.optInt("adWidth");
        String adRequestId = jSONObject.optString("requestId");
        int iOptInt3 = jSONObject.optInt("adType", 1);
        int iOptInt4 = jSONObject.optInt("useDefaultBg", 0);
        String adBg = jSONObject.optString("adbg", "#ffffff");
        int iOptInt5 = jSONObject.optInt("closeType", 0);
        String chapterName = jSONObject.optString("chapterName");
        String chapterNameColor = jSONObject.optString("chapterNameColor", "#775C4B");
        String adTitleTextColor = jSONObject.optString("adTitleTextColor", "#4B2D1B");
        String textLinkText = jSONObject.optString("textLinkText");
        String textLinkColor = jSONObject.optString("textLinkColor", "#53321B");
        String rewardBtnText = jSONObject.optString("rewardBtnText");
        String contentBgColor = jSONObject.optString("contentBgColor", "#ffffff");
        String rewardBtnBgColor = jSONObject.optString("rewardBtnBgColor", "#EDE1CA");
        String rewardBtnStrokeColor = jSONObject.optString("rewardBtnStrokeColor", "#D33C33");
        String rewardBtnTextColor = jSONObject.optString("rewardBtnTextColor", "#D33C33");
        String downloadBtnBgColor = jSONObject.optString("downloadBtnBgColor", "#D33C33");
        String downloadBtnTextColor = jSONObject.optString("downloadBtnTextColor", "#ffffff");
        int iOptInt6 = jSONObject.optInt("rewardBtnClickHide", 0);
        WifiLog.d("H5Ad showH5Ad height " + iOptInt + " width " + iOptInt2 + " adBg " + adBg + " adRequestId " + adRequestId);
        if (!(adRequestId == null || adRequestId.length() == 0)) {
            SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
            list = companion.getAllAdData().containsKey(adRequestId) ? companion.getAllAdData().get(adRequestId) : null;
        }
        List<NestAdData> list2 = list;
        if (list2 == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errCode", "-400001");
            jSONObject2.put(WifiNestConst.OtherConst.KEY_MSG, "adData is null");
            Intrinsics.checkExpressionValueIsNotNull(adRequestId, "adRequestId");
            String string = jSONObject2.toString();
            Intrinsics.checkExpressionValueIsNotNull(string, "errorObject.toString()");
            showListener.onResult(adRequestId, "onAdFailed", string);
            return;
        }
        if (!(adRequestId == null || adRequestId.length() == 0)) {
            SdkStrategy.INSTANCE.getAllAdShowListener().put(adRequestId, showListener);
        }
        WifiLog.d("H5Ad showH5Ad allDatas " + list2 + " SdkStrategy.allAdData " + SdkStrategy.INSTANCE.getAllAdData() + " parentView " + parentView);
        AdShowConfig.Builder useDefaultBg = new AdShowConfig.Builder().setAdHeight(iOptInt).setAdWidth(iOptInt2).setCloseType(iOptInt5).setUseDefaultBg(iOptInt4);
        Intrinsics.checkExpressionValueIsNotNull(adBg, "adBg");
        AdShowConfig.Builder bgColor = useDefaultBg.setBgColor(adBg);
        Intrinsics.checkExpressionValueIsNotNull(contentBgColor, "contentBgColor");
        AdShowConfig.Builder contentBgColor2 = bgColor.setContentBgColor(contentBgColor);
        Intrinsics.checkExpressionValueIsNotNull(chapterName, "chapterName");
        AdShowConfig.Builder chapterName2 = contentBgColor2.setChapterName(chapterName);
        Intrinsics.checkExpressionValueIsNotNull(chapterNameColor, "chapterNameColor");
        AdShowConfig.Builder chapterNameColor2 = chapterName2.setChapterNameColor(chapterNameColor);
        Intrinsics.checkExpressionValueIsNotNull(adTitleTextColor, "adTitleTextColor");
        AdShowConfig.Builder adTitleTextColor2 = chapterNameColor2.setAdTitleTextColor(adTitleTextColor);
        Intrinsics.checkExpressionValueIsNotNull(textLinkText, "textLinkText");
        AdShowConfig.Builder textLinkText2 = adTitleTextColor2.setTextLinkText(textLinkText);
        Intrinsics.checkExpressionValueIsNotNull(textLinkColor, "textLinkColor");
        AdShowConfig.Builder textLinkColor2 = textLinkText2.setTextLinkColor(textLinkColor);
        Intrinsics.checkExpressionValueIsNotNull(rewardBtnText, "rewardBtnText");
        AdShowConfig.Builder rewardBtnText2 = textLinkColor2.setRewardBtnText(rewardBtnText);
        Intrinsics.checkExpressionValueIsNotNull(rewardBtnBgColor, "rewardBtnBgColor");
        AdShowConfig.Builder rewardBtnBgColor2 = rewardBtnText2.setRewardBtnBgColor(rewardBtnBgColor);
        Intrinsics.checkExpressionValueIsNotNull(rewardBtnStrokeColor, "rewardBtnStrokeColor");
        AdShowConfig.Builder rewardBtnStrokeColor2 = rewardBtnBgColor2.setRewardBtnStrokeColor(rewardBtnStrokeColor);
        Intrinsics.checkExpressionValueIsNotNull(rewardBtnTextColor, "rewardBtnTextColor");
        AdShowConfig.Builder rewardBtnTextColor2 = rewardBtnStrokeColor2.setRewardBtnTextColor(rewardBtnTextColor);
        Intrinsics.checkExpressionValueIsNotNull(downloadBtnBgColor, "downloadBtnBgColor");
        AdShowConfig.Builder downloadBtnBgColor2 = rewardBtnTextColor2.setDownloadBtnBgColor(downloadBtnBgColor);
        Intrinsics.checkExpressionValueIsNotNull(downloadBtnTextColor, "downloadBtnTextColor");
        AdShowConfig adShowConfigBuild = downloadBtnBgColor2.setDownloadBtnTextColor(downloadBtnTextColor).setRewardBtnClickHide(iOptInt6).build();
        if (iOptInt3 == 1) {
            new WkFeedBannerShowMg(adRequestId, activity, parentView, list2, adShowConfigBuild, new FeedBannerShowListener() { // from class: com.wifi.ad.core.helper.AdHelperH5Ad$showH5Ad$h5Show$1
                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onAdClicked(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onAdClicked", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onAdCloseClick(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onAdClose", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onAdExposed(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onAdExposed", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onAdRemove(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onAdRemove", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadComplete(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onDownloadComplete", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadFailed(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onDownloadFailed", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadInstalled(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onDownloadInstalled", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadPause(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onDownloadPause", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadProgress(String providerType, String adData, int progress, String requestId) {
                    showListener.onResult(requestId, "onDownloadProgress", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadStart(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onDownloadStart", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onRewardBtnClick(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onRewardBtnClick", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onTextLinkClicked(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onTextLinkClicked", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onVideoComplete(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onVideoComplete", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onVideoError(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onVideoError", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onVideoPause(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onVideoPause", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onVideoStart(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onVideoStart", adData);
                }
            });
        } else if (iOptInt3 == 2) {
            new WkChapterAdShowMg(adRequestId, activity, parentView, list2, adShowConfigBuild, new FeedBannerShowListener() { // from class: com.wifi.ad.core.helper.AdHelperH5Ad$showH5Ad$h5Show$2
                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onAdClicked(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onAdClicked", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onAdCloseClick(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onAdClose", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onAdExposed(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onAdExposed", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onAdRemove(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onAdRemove", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadComplete(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onDownloadComplete", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadFailed(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onDownloadFailed", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadInstalled(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onDownloadInstalled", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadPause(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onDownloadPause", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadProgress(String providerType, String adData, int progress, String requestId) {
                    showListener.onResult(requestId, "onDownloadProgress", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onDownloadStart(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onDownloadStart", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onRewardBtnClick(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onRewardBtnClick", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onTextLinkClicked(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onTextLinkClicked", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onVideoComplete(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onVideoComplete", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onVideoError(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onVideoError", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onVideoPause(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onVideoPause", adData);
                }

                @Override // com.wifi.ad.core.listener.FeedBannerShowListener
                public void onVideoStart(String providerType, String adData, String requestId) {
                    showListener.onResult(requestId, "onVideoStart", adData);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void showH5InterstitialAd(@NonNull Activity activity, String adShowString, @NonNull final H5CallListener showListener) {
        List<NestAdData> list;
        WifiLog.d("H5InterstitialAd showInterstitialAd start");
        JSONObject jSONObject = new JSONObject(adShowString);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = jSONObject.optString("requestId");
        WifiLog.d("H5InterstitialAd showInterstitialAd adRequestId " + ((String) objectRef.element));
        String str = (String) objectRef.element;
        boolean z = true;
        if (!(str == null || str.length() == 0)) {
            SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
            list = companion.getAllAdData().containsKey((String) objectRef.element) ? companion.getAllAdData().get((String) objectRef.element) : null;
        }
        if (list == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errCode", "-400002");
            jSONObject2.put(WifiNestConst.OtherConst.KEY_MSG, "adData is null");
            String adRequestId = (String) objectRef.element;
            Intrinsics.checkExpressionValueIsNotNull(adRequestId, "adRequestId");
            String string = jSONObject2.toString();
            Intrinsics.checkExpressionValueIsNotNull(string, "errorObject.toString()");
            showListener.onResult(adRequestId, "onAdFailed", string);
            return;
        }
        String str2 = (String) objectRef.element;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (!z) {
            SdkStrategy.INSTANCE.getAllAdShowListener().put((String) objectRef.element, showListener);
        }
        WifiLog.d("H5InterstitialAd showInterstitialAd allDatas " + list + " SdkStrategy.allAdData " + SdkStrategy.INSTANCE.getAllAdData());
        NestAdData nestAdData = list.get(0);
        if (nestAdData == null) {
            Intrinsics.throwNpe();
        }
        nestAdData.setAdRenderListener(new NestAdData.AdRenderListener() { // from class: com.wifi.ad.core.helper.AdHelperH5Ad.showH5InterstitialAd.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.wifi.ad.core.data.NestAdData.AdRenderListener
            public void onRenderFail(String providerType, NestAdData adData, int errorCode, String message) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("errCode", errorCode);
                jSONObject3.put(WifiNestConst.OtherConst.KEY_MSG, message);
                H5CallListener h5CallListener = showListener;
                String adRequestId2 = (String) objectRef.element;
                Intrinsics.checkExpressionValueIsNotNull(adRequestId2, "adRequestId");
                String string2 = jSONObject3.toString();
                Intrinsics.checkExpressionValueIsNotNull(string2, "errorObject.toString()");
                h5CallListener.onResult(adRequestId2, "onRenderFail", string2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.wifi.ad.core.data.NestAdData.AdRenderListener
            public void onRenderSuccess(String providerType, NestAdData adData) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("errCode", "0");
                jSONObject3.put(WifiNestConst.OtherConst.KEY_MSG, "激励视频展示成功 " + providerType);
                H5CallListener h5CallListener = showListener;
                String adRequestId2 = (String) objectRef.element;
                Intrinsics.checkExpressionValueIsNotNull(adRequestId2, "adRequestId");
                String string2 = jSONObject3.toString();
                Intrinsics.checkExpressionValueIsNotNull(string2, "errorObject.toString()");
                h5CallListener.onResult(adRequestId2, "onRenderSuccess", string2);
            }
        });
        AdHelperH5InterstitialAd.INSTANCE.showInterstitialAd(activity, nestAdData, new InterstitialShowListener() { // from class: com.wifi.ad.core.helper.AdHelperH5Ad.showH5InterstitialAd.2
            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onAdClicked(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onAdClicked", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onAdClose(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onAdClose", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onAdExposed(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onAdExposed", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onAdSkipClick(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onAdSkipClick", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onDownloadComplete(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onDownloadComplete", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onDownloadFailed(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onDownloadFailed", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onDownloadInstalled(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onDownloadInstalled", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onDownloadPause(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onDownloadPause", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onDownloadProgress(String providerType, String adData, int progress, String requestId) {
                showListener.onResult(requestId, "onDownloadProgress", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onDownloadStart(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onDownloadStart", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onVideoComplete(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onVideoComplete", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onVideoError(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onVideoError", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onVideoPause(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onVideoPause", adData);
            }

            @Override // com.wifi.ad.core.listener.InterstitialShowListener
            public void onVideoStart(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onVideoStart", adData);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void showH5RewardVideoAd(@NonNull Activity activity, String adShowString, @NonNull final H5CallListener showListener) {
        List<NestAdData> list;
        WifiLog.d("H5RewardVideo showRewardAd start");
        JSONObject jSONObject = new JSONObject(adShowString);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = jSONObject.optString("requestId");
        WifiLog.d("H5RewardVideo showRewardAd adRequestId " + ((String) objectRef.element));
        String str = (String) objectRef.element;
        boolean z = true;
        if (!(str == null || str.length() == 0)) {
            SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
            list = companion.getAllAdData().containsKey((String) objectRef.element) ? companion.getAllAdData().get((String) objectRef.element) : null;
        }
        if (list == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errCode", "-400002");
            jSONObject2.put(WifiNestConst.OtherConst.KEY_MSG, "adData is null");
            String adRequestId = (String) objectRef.element;
            Intrinsics.checkExpressionValueIsNotNull(adRequestId, "adRequestId");
            String string = jSONObject2.toString();
            Intrinsics.checkExpressionValueIsNotNull(string, "errorObject.toString()");
            showListener.onResult(adRequestId, "onAdFailed", string);
            return;
        }
        String str2 = (String) objectRef.element;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (!z) {
            SdkStrategy.INSTANCE.getAllAdShowListener().put((String) objectRef.element, showListener);
        }
        WifiLog.d("H5Banner showH5Ad allDatas " + list + " SdkStrategy.allAdData " + SdkStrategy.INSTANCE.getAllAdData());
        NestAdData nestAdData = list.get(0);
        if (nestAdData == null) {
            Intrinsics.throwNpe();
        }
        nestAdData.setAdRenderListener(new NestAdData.AdRenderListener() { // from class: com.wifi.ad.core.helper.AdHelperH5Ad.showH5RewardVideoAd.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.wifi.ad.core.data.NestAdData.AdRenderListener
            public void onRenderFail(String providerType, NestAdData adData, int errorCode, String message) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("errCode", errorCode);
                jSONObject3.put(WifiNestConst.OtherConst.KEY_MSG, message);
                H5CallListener h5CallListener = showListener;
                String adRequestId2 = (String) objectRef.element;
                Intrinsics.checkExpressionValueIsNotNull(adRequestId2, "adRequestId");
                String string2 = jSONObject3.toString();
                Intrinsics.checkExpressionValueIsNotNull(string2, "errorObject.toString()");
                h5CallListener.onResult(adRequestId2, "onRenderFail", string2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.wifi.ad.core.data.NestAdData.AdRenderListener
            public void onRenderSuccess(String providerType, NestAdData adData) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("errCode", "0");
                jSONObject3.put(WifiNestConst.OtherConst.KEY_MSG, "激励视频展示成功 " + providerType);
                H5CallListener h5CallListener = showListener;
                String adRequestId2 = (String) objectRef.element;
                Intrinsics.checkExpressionValueIsNotNull(adRequestId2, "adRequestId");
                String string2 = jSONObject3.toString();
                Intrinsics.checkExpressionValueIsNotNull(string2, "errorObject.toString()");
                h5CallListener.onResult(adRequestId2, "onRenderSuccess", string2);
            }
        });
        AdHelperH5RewardVideo.INSTANCE.showRewardVideoAd(activity, nestAdData, new RewardShowListener() { // from class: com.wifi.ad.core.helper.AdHelperH5Ad.showH5RewardVideoAd.2
            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onAdClicked(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onAdClicked", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onAdClose(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onAdClose", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onAdExposed(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onAdExposed", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onAdRewardVerify(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onAdRewardVerify", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onDownloadComplete(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onDownloadComplete", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onDownloadFailed(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onDownloadFailed", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onDownloadInstalled(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onDownloadInstalled", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onDownloadPause(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onDownloadPause", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onDownloadProgress(String providerType, String adData, int progress, String requestId) {
                showListener.onResult(requestId, "onDownloadProgress", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onDownloadStart(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onDownloadStart", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onVideoComplete(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onVideoComplete", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onVideoError(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onVideoError", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onVideoPause(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onVideoPause", adData);
            }

            @Override // com.wifi.ad.core.listener.RewardShowListener
            public void onVideoStart(String providerType, String adData, String requestId) {
                showListener.onResult(requestId, "onVideoStart", adData);
            }
        });
    }

    public final synchronized void showHideH5Ad(String requestId) {
        List<NestAdData> list;
        SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
        HashMap<String, View> allAdAdView = companion.getAllAdAdView();
        if (allAdAdView == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }
        if (allAdAdView.containsKey(requestId)) {
            View view = companion.getAllAdAdView().get(requestId);
            if (view == null) {
                Intrinsics.throwNpe();
            }
            view.setVisibility(0);
            HashMap<String, List<NestAdData>> allAdData = companion.getAllAdData();
            if (allAdData == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
            if (allAdData.containsKey(requestId) && (list = companion.getAllAdData().get(requestId)) != null && (!list.isEmpty())) {
                NestAdData nestAdData = list.get(0);
                EventParams eventParams = new EventParams.Builder().setDspName(nestAdData.getDspName()).setNestSid(nestAdData.getNestSid()).setSrcId(String.valueOf(nestAdData.getAdCode())).setInventoryId(nestAdData.getInventoryId()).setSdkFrom(nestAdData.getSdkFrom()).build();
                AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
                AdParams adParams = nestAdData.getAdParams();
                reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_SHOW_HIDE, eventParams, adParams != null ? adParams.getExt() : null);
            }
        }
    }
}
