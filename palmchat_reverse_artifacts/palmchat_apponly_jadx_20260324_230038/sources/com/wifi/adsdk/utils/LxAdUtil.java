package com.wifi.adsdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.adsdk.LxAdManager;
import com.wifi.adsdk.LxAdSdk;
import com.wifi.adsdk.download.LxAdDLManager;
import com.wifi.adsdk.entity.ClickTargetBean;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.entity.LxEventReplace;
import com.wifi.adsdk.entity.SingleImage;
import com.wifi.adsdk.entity.TrackingListBean;
import com.wifi.adsdk.entity.VideoData;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.LxAdConst;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdUtil {
    public static final int CLICK_FROM_BUTTON = 2;
    public static final int CLICK_FROM_NORMAL = 1;
    public static final int CLICK_FROM_VIDEO = 4;
    public static final int CLICK_FROM_YY = 3;
    public static final int CLICK_TYPE_CC = 5;
    public static final int CLICK_TYPE_NN = 2;
    public static final int CLICK_TYPE_NORMAL = 0;
    public static final int CLICK_TYPE_OTHER = 6;
    public static final int CLICK_TYPE_SX = 4;
    public static final int CLICK_TYPE_YY = 1;
    public static final int CLICK_TYPE_ZY = 3;
    public static final String DSP_TYPE_HONOR = "honor";
    public static final String DSP_TYPE_HUAWEI = "huawei";
    public static final String DSP_TYPE_OPPO = "oppo";
    public static final String DSP_TYPE_VIVO = "vivo";
    public static final String LXAD_FEED_CONTAINER_TAG = "LXAD_FEED_CONTAINER_TAG";
    public static final int MATERIAL_TYPE_GROUP_IMG = 2;
    public static final int MATERIAL_TYPE_IMG = 1;
    public static final int MATERIAL_TYPE_VIDEO = 3;
    public static final String URL_CONFIG_RELEASE = "https://short.lianxinapp.com/adx/config";
    public static final String URL_CONFIG_TEST = "https://short1.lx-qa.com/adx/config";
    public static final String URL_RELEASE = "https://short.lianxinapp.com/adx/adGet";
    public static final String URL_TEST = "https://short1.lx-qa.com/adx/adGet";
    public static int carrier = -1;

    public static JSONObject buildParams(Context context, LxAdReqParams lxAdReqParams, int i) {
        if (lxAdReqParams == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", lxAdReqParams.getClientReqId());
            jSONObject.put("pos", getPos(lxAdReqParams, i));
            jSONObject.put("media", LxAdSingleDataUtil.getInstance(context).getMediaInfoData());
            jSONObject.put(bd.m, getUser());
            jSONObject.put("device", LxAdSingleDataUtil.getInstance(context).getDeviceInfoData());
            jSONObject.put("network", getNetWork(context));
            jSONObject.put(MapBundleKey.MapObjKey.OBJ_GEO, getGeo());
            jSONObject.put("vivoApi", LxAdSingleDataUtil.getInstance(context).getVoviApiData());
            jSONObject.put("timestamp", System.currentTimeMillis());
            LxAdLog.d("LxAdUtil buildParams data " + jSONObject.toString());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONObject getGeo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f.C, LxAdManager.getAdManager().getConfig().getRealAppRuntime().getLatitude());
            jSONObject.put(f.D, LxAdManager.getAdManager().getConfig().getRealAppRuntime().getLongitude());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static ArrayList<String> getLinkArrays(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(jSONArrayOptJSONArray.optString(i));
        }
        return arrayList;
    }

    private static JSONObject getNetWork(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("connectType", BLPlatform.getNetworkType(context));
            String strConvertIsp = BLPlatform.convertIsp(context);
            carrier = BLPlatform.convertIspToNativeCode(context, strConvertIsp);
            jSONObject.put(bt.B, strConvertIsp);
            jSONObject.put(bt.P, carrier);
            jSONObject.put("ua", LxAdManager.getAdManager().getConfig().getRealAppRuntime().getUa());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONObject getPos(LxAdReqParams lxAdReqParams, int i) {
        JSONObject jSONObject = new JSONObject();
        if (lxAdReqParams != null) {
            try {
                jSONObject.put("slotId", lxAdReqParams.getLxSrcId());
                jSONObject.put("slotType", i);
                jSONObject.put("width", lxAdReqParams.getWidth());
                jSONObject.put("height", lxAdReqParams.getHeight());
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_SDKVER, LxAdSdk.getVersion());
                int i2 = Integer.parseInt(lxAdReqParams.getScene());
                jSONObject.put("scene", i2);
                NestAdData nestAdDataFindCacheMaxAdByScene = SPCacheManager.INSTANCE.findCacheMaxAdByScene(i2);
                if (nestAdDataFindCacheMaxAdByScene != null) {
                    jSONObject.put("cacheTopAdcost", nestAdDataFindCacheMaxAdByScene.getAdCost());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    private static JSONObject getUser() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<String> installPkgs = LxAdManager.getAdManager().getConfig().getRealAppRuntime().getInstallPkgs();
            if (installPkgs != null && installPkgs.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < installPkgs.size(); i++) {
                    jSONArray.put(installPkgs.get(i));
                }
                jSONObject.put("appList", jSONArray);
            }
            jSONObject.put("gender", LxAdManager.getAdManager().getConfig().getRealAppRuntime().getGender());
            jSONObject.put("age", LxAdManager.getAdManager().getConfig().getRealAppRuntime().getAge());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String getsdfile(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), str);
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return stringBuffer.toString();
                }
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static LxAdBeanData parseFeedAd(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
                LxAdBeanData lxAdBeanData = new LxAdBeanData();
                String strOptString = jSONObjectOptJSONObject.optString("apiId");
                lxAdBeanData.setApiId(strOptString);
                lxAdBeanData.setRequestId(jSONObjectOptJSONObject.optString("requestId"));
                lxAdBeanData.setApiSlotId(jSONObjectOptJSONObject.optString("apiSlotId"));
                lxAdBeanData.setSlotId(jSONObjectOptJSONObject.optString("slotId"));
                lxAdBeanData.setAdId(jSONObjectOptJSONObject.optString("adId"));
                lxAdBeanData.setMaterialId(jSONObjectOptJSONObject.optString("materialId"));
                lxAdBeanData.setEcpm(jSONObjectOptJSONObject.optInt("ecpm"));
                lxAdBeanData.setAdType(jSONObjectOptJSONObject.optInt("adType"));
                lxAdBeanData.setMaterialType(jSONObjectOptJSONObject.optInt("materialType"));
                lxAdBeanData.setIconUrl(jSONObjectOptJSONObject.optString(LxAdDLManager.ITEM_ICONURL));
                lxAdBeanData.setTitle(jSONObjectOptJSONObject.optString("title"));
                lxAdBeanData.setDescription(jSONObjectOptJSONObject.optString("description"));
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("singleImage");
                if (jSONObjectOptJSONObject2 != null) {
                    SingleImage singleImage = new SingleImage();
                    singleImage.setUrl(jSONObjectOptJSONObject2.optString("url"));
                    singleImage.setHeight(jSONObjectOptJSONObject2.optInt("height"));
                    singleImage.setWidth(jSONObjectOptJSONObject2.optInt("width"));
                    lxAdBeanData.setSingleImage(singleImage);
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("groupImage");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        SingleImage singleImage2 = new SingleImage();
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                        singleImage2.setUrl(jSONObjectOptJSONObject3.optString("url"));
                        singleImage2.setHeight(jSONObjectOptJSONObject3.optInt("height"));
                        singleImage2.setWidth(jSONObjectOptJSONObject3.optInt("width"));
                        arrayList.add(singleImage2);
                    }
                    lxAdBeanData.setGroupImage(arrayList);
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("video");
                if (jSONObjectOptJSONObject4 != null) {
                    VideoData videoData = new VideoData();
                    videoData.setPreImgUrl(jSONObjectOptJSONObject4.optString("preImgUrl"));
                    videoData.setVideoUrl(jSONObjectOptJSONObject4.optString("videoUrl"));
                    videoData.setVideoWidth(jSONObjectOptJSONObject4.optInt("width"));
                    videoData.setVideoHeight(jSONObjectOptJSONObject4.optInt("height"));
                    videoData.setVideoDuration(jSONObjectOptJSONObject4.optInt("duration"));
                    videoData.setVideoFileSize(jSONObjectOptJSONObject4.optInt("fileSize"));
                    lxAdBeanData.setVideo(videoData);
                }
                lxAdBeanData.setAppBundleId(jSONObjectOptJSONObject.optString("appBundleId"));
                lxAdBeanData.setAppSize(jSONObjectOptJSONObject.optInt(LxAdDLManager.ITEM_APPSIZE));
                lxAdBeanData.setAppInfoUrl(jSONObjectOptJSONObject.optString("appInfoUrl"));
                lxAdBeanData.setAppName(jSONObjectOptJSONObject.optString(WfConstant.EVENT_KEY_APP_NAME));
                lxAdBeanData.setAdvertiserName(jSONObjectOptJSONObject.optString(LxAdDLManager.ITEM_ADVERNAME));
                lxAdBeanData.setAppVersion(jSONObjectOptJSONObject.optString("appVersion"));
                lxAdBeanData.setPermissionUrl(jSONObjectOptJSONObject.optString(LxAdDLManager.ITEM_PERURL));
                lxAdBeanData.setDescriptionUrl(jSONObjectOptJSONObject.optString(LxAdDLManager.ITEM_DESCURL));
                lxAdBeanData.setPrivacyPolicyUrl(jSONObjectOptJSONObject.optString("privacyPolicyUrl"));
                lxAdBeanData.setClickInteractType(jSONObjectOptJSONObject.optInt("clickInteractType"));
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("clickTargetUrl");
                if (jSONObjectOptJSONObject5 != null) {
                    ClickTargetBean clickTargetBean = new ClickTargetBean();
                    clickTargetBean.setCustomizedInvokeUrl(jSONObjectOptJSONObject5.optString("customizedInvokeUrl"));
                    clickTargetBean.setQuickAppUrl(jSONObjectOptJSONObject5.optString("quickAppUrl"));
                    clickTargetBean.setMarketUrl(jSONObjectOptJSONObject5.optString("marketUrl"));
                    clickTargetBean.setPackageUrl(jSONObjectOptJSONObject5.optString("packageUrl"));
                    clickTargetBean.setLandingPageUrl(jSONObjectOptJSONObject5.optString("landingPageUrl"));
                    clickTargetBean.setWechatApp(jSONObjectOptJSONObject5.optString("wechatApp"));
                    clickTargetBean.setDeeplinkButtonUrl(jSONObjectOptJSONObject5.optString("deeplinkButtonUrl"));
                    lxAdBeanData.setClickTargetUrl(clickTargetBean);
                }
                lxAdBeanData.setSplashSkipTime(jSONObjectOptJSONObject.optInt("splashSkipTime"));
                lxAdBeanData.setWechatAppUsername(jSONObjectOptJSONObject.optString("wechatAppUsername"));
                lxAdBeanData.setWechatAppPath(jSONObjectOptJSONObject.optString("wechatAppPath"));
                lxAdBeanData.setWechatAppExtData(jSONObjectOptJSONObject.optString("wechatAppExtData"));
                lxAdBeanData.setWechatCanvas(jSONObjectOptJSONObject.optString("wechatCanvas"));
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject.optJSONObject("tracking");
                if (jSONObjectOptJSONObject6 != null) {
                    TrackingListBean trackingListBean = new TrackingListBean();
                    trackingListBean.setDeeplinkSuccessLink(getLinkArrays(jSONObjectOptJSONObject6, "deeplinkSuccessLink"));
                    trackingListBean.setMiniProgramSuccessLink(getLinkArrays(jSONObjectOptJSONObject6, "miniProgramSuccessLink"));
                    trackingListBean.setInstallFinishedLink(getLinkArrays(jSONObjectOptJSONObject6, "installFinishedLink"));
                    trackingListBean.setVideoShow50ppLink(getLinkArrays(jSONObjectOptJSONObject6, "videoShow50ppLink"));
                    trackingListBean.setVideoShow25ppLink(getLinkArrays(jSONObjectOptJSONObject6, "videoShow25ppLink"));
                    trackingListBean.setVideoShow75ppLink(getLinkArrays(jSONObjectOptJSONObject6, "videoShow75ppLink"));
                    trackingListBean.setDownloadFinishedLink(getLinkArrays(jSONObjectOptJSONObject6, "downloadFinishedLink"));
                    trackingListBean.setVideoShowStartLink(getLinkArrays(jSONObjectOptJSONObject6, "videoShowStartLink"));
                    trackingListBean.setVideoShowEndLink(getLinkArrays(jSONObjectOptJSONObject6, "videoShowEndLink"));
                    trackingListBean.setClickLink(getLinkArrays(jSONObjectOptJSONObject6, "clickLink"));
                    trackingListBean.setDownloadStartedLink(getLinkArrays(jSONObjectOptJSONObject6, "downloadStartedLink"));
                    trackingListBean.setInstallStartedLink(getLinkArrays(jSONObjectOptJSONObject6, "installStartedLink"));
                    trackingListBean.setShowLink(getLinkArrays(jSONObjectOptJSONObject6, "showLink"));
                    trackingListBean.setVideoShowCloseLink(getLinkArrays(jSONObjectOptJSONObject6, "videoShowCloseLink"));
                    trackingListBean.setVideoShowMuteLink(getLinkArrays(jSONObjectOptJSONObject6, "videoShowMuteLink"));
                    trackingListBean.setVideoShowPauseLink(getLinkArrays(jSONObjectOptJSONObject6, "videoShowPauseLink"));
                    trackingListBean.setVideoShowReplayLink(getLinkArrays(jSONObjectOptJSONObject6, "videoShowReplayLink"));
                    trackingListBean.setDeeplinkFailLink(getLinkArrays(jSONObjectOptJSONObject6, "deeplinkFailLink"));
                    trackingListBean.setDownloadActiveLink(getLinkArrays(jSONObjectOptJSONObject6, "downloadActiveLink"));
                    trackingListBean.setAppOpenLink(getLinkArrays(jSONObjectOptJSONObject6, "appOpenLink"));
                    trackingListBean.setUserCloseLink(getLinkArrays(jSONObjectOptJSONObject6, "userCloseLink"));
                    trackingListBean.setWinNoticeLink(getLinkArrays(jSONObjectOptJSONObject6, "winNoticeLink"));
                    trackingListBean.setDownloadFailLink(getLinkArrays(jSONObjectOptJSONObject6, "downloadFailLink"));
                    trackingListBean.setInstallFailLink(getLinkArrays(jSONObjectOptJSONObject6, "installFailLink"));
                    lxAdBeanData.setTrackingList(trackingListBean);
                }
                lxAdBeanData.setAdInteractType(jSONObjectOptJSONObject.optInt("adInteractType"));
                lxAdBeanData.setxAccMax(jSONObjectOptJSONObject.optInt("xAccMax"));
                lxAdBeanData.setyAccMax(jSONObjectOptJSONObject.optInt("yAccMax"));
                lxAdBeanData.setzAccMax(jSONObjectOptJSONObject.optInt("zAccMax"));
                lxAdBeanData.setTurnX(jSONObjectOptJSONObject.optInt("turnX"));
                lxAdBeanData.setTurnY(jSONObjectOptJSONObject.optInt("turnY"));
                lxAdBeanData.setTurnZ(jSONObjectOptJSONObject.optInt("turnZ"));
                lxAdBeanData.setTurnTime(jSONObjectOptJSONObject.optInt("turnTime"));
                lxAdBeanData.setxSwipeMax(jSONObjectOptJSONObject.optInt("xSwipeMax"));
                lxAdBeanData.setySwipeMax(jSONObjectOptJSONObject.optInt("ySwipeMax"));
                lxAdBeanData.setEventReplace(new LxEventReplace(strOptString));
                return lxAdBeanData;
            } catch (Exception e) {
                LxAdLog.d("LxAdUtil parseFeedAd Exception " + e.toString());
            }
        }
        return null;
    }
}
