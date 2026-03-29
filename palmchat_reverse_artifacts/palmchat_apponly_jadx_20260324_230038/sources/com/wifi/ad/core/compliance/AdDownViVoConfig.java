package com.wifi.ad.core.compliance;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdDownHelper;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AdDownViVoConfig {
    public static final int CLICK_AREA_1 = 1;
    public static final int CLICK_AREA_2 = 2;
    public static final int CLICK_AREA_3 = 3;
    private static final String TAG_ALL = "all";
    private static final String TAG_CHANNEL = "channel";
    private static final String TAG_CLICKAREA = "clickArea";
    private static final String TAG_COMPLIANCEINFO = "complianceInfo";
    private static final String TAG_DOWNLOAD_TYPE = "downloadType";
    private static final String TAG_NATIVEAD_COMPLIANCE = "NativeAd_compliance";
    private static final String TAG_SCENE = "scene";
    private static final String TAG_VERSION = "version";
    private static final String TAG_VERSIONNAME = "versionName";
    private static final String TAG_VIDEO_CLICK = "videoClick";
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_NOT_DOWNLOAD = 2;
    private static final String VIVO_CHANNLE = "VIVO_D624EC4ADC709B48";
    public static ArrayList<NativeComplianceModel> allModel = null;
    public static final boolean isTest = true;
    private static boolean parError = false;

    private static boolean allowCheck(NativeComplianceModel nativeComplianceModel) {
        if (nativeComplianceModel == null) {
            return false;
        }
        ArrayList<String> channels = nativeComplianceModel.getChannels();
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        String channel = nestInfoTaker.getChannel();
        if (channels == null || channels.size() <= 0) {
            return false;
        }
        if (!channels.contains(channel) && !channels.contains("all")) {
            return false;
        }
        ArrayList<String> versions = nativeComplianceModel.getVersions();
        String appVer = nestInfoTaker.getAppVer();
        if (versions == null || versions.size() <= 0) {
            return false;
        }
        if (!versions.contains(appVer) && !versions.contains("all")) {
            return false;
        }
        ArrayList<String> versionNames = nativeComplianceModel.getVersionNames();
        String appVerName = nestInfoTaker.getAppVerName();
        if (versionNames == null || versionNames.size() <= 0) {
            return false;
        }
        return versionNames.contains(appVerName) || versionNames.contains("all");
    }

    public static void checkVideoViewClick(NestAdData nestAdData) {
    }

    public static ArrayList<View> createClickView(ArrayList<View> arrayList, ArrayList<View> arrayList2, NestAdData nestAdData, ArrayList<View> arrayList3) {
        if (arrayList != null && arrayList2 != null && nestAdData != null) {
            int i = nestAdData.getInteractionType().intValue() != 1 ? 2 : 1;
            int clickArea = getClickArea(nestAdData.getAdScene() + "", i);
            WifiLog.d("AdDownViVoConfig createClickView clickArea " + clickArea + " scene " + nestAdData.getAdScene() + " downType " + i);
            if (clickArea == 2) {
                arrayList.clear();
                arrayList.addAll(arrayList2);
            } else if (clickArea == 3) {
                if (AdNativeStyleManagerSDK.getNativeStyleView(nestAdData.getAdScene()) == AdNativeStyleManagerSDK.STYLE_VALUE2) {
                    try {
                        if (SDKAlias.GDT.getType().equals(nestAdData.getAdType())) {
                            AdDownHelper.INSTANCE.saveClickViews(arrayList, nestAdData);
                        } else if (arrayList3 != null && arrayList3.size() > 0) {
                            arrayList.clear();
                            arrayList.addAll(arrayList3);
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    AdDownHelper.INSTANCE.saveClickViews(arrayList, nestAdData);
                }
            }
        }
        return arrayList;
    }

    private static int getClickArea(String str, int i) {
        ArrayList<NativeComplianceModel> arrayList;
        ArrayList<String> scenes;
        String channel = NestInfoTaker.INSTANCE.getChannel();
        WifiLog.d("AdDownViVoConfig getClickArea scene " + str + " downType " + i + " curChannel " + channel);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(channel) && (arrayList = allModel) != null && arrayList.size() > 0) {
            try {
                int size = allModel.size();
                for (int i2 = 0; i2 < size; i2++) {
                    NativeComplianceModel nativeComplianceModel = allModel.get(i2);
                    if (allowCheck(nativeComplianceModel) && (((scenes = nativeComplianceModel.getScenes()) != null && scenes.size() > 0 && scenes.contains(str)) || scenes.contains("all"))) {
                        ArrayList<Integer> downloadType = nativeComplianceModel.getDownloadType();
                        boolean z = true;
                        if ((downloadType == null || downloadType.size() <= 0 || !downloadType.contains(Integer.valueOf(i))) && i != 1) {
                            z = false;
                        }
                        WifiLog.d("AdDownViVoConfig getClickArea allCheck " + z);
                        if (z) {
                            int clickArea = nativeComplianceModel.getClickArea();
                            WifiLog.d("AdDownViVoConfig getClickArea res " + clickArea);
                            return clickArea;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        WifiLog.d("AdDownViVoConfig getClickArea return -1 ");
        return -1;
    }

    public static void initAllConfig(String str) {
        WifiLog.d("AdDownViVoConfig initAllConfig ext " + str);
        parError = false;
        if (TextUtils.isEmpty(str)) {
            parError = true;
        } else {
            if (allModel == null) {
                allModel = new ArrayList<>();
            }
            allModel.clear();
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray(TAG_NATIVEAD_COMPLIANCE);
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        NativeComplianceModel nativeComplianceModel = new NativeComplianceModel();
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(TAG_VERSIONNAME);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                arrayList.add(jSONArrayOptJSONArray2.optString(i2));
                            }
                            nativeComplianceModel.setVersionNames(arrayList);
                        }
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("version");
                        if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                                arrayList2.add(jSONArrayOptJSONArray3.optString(i3));
                            }
                            nativeComplianceModel.setVersions(arrayList2);
                        }
                        JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("channel");
                        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                                arrayList3.add(jSONArrayOptJSONArray4.optString(i4));
                            }
                            nativeComplianceModel.setChannels(arrayList3);
                        }
                        JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("scene");
                        if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                            ArrayList<String> arrayList4 = new ArrayList<>();
                            for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                                arrayList4.add(jSONArrayOptJSONArray5.optString(i5));
                            }
                            nativeComplianceModel.setScenes(arrayList4);
                        }
                        JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(TAG_DOWNLOAD_TYPE);
                        if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                            ArrayList<Integer> arrayList5 = new ArrayList<>();
                            for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                                arrayList5.add(Integer.valueOf(jSONArrayOptJSONArray6.optInt(i6)));
                            }
                            nativeComplianceModel.setDownloadType(arrayList5);
                        }
                        nativeComplianceModel.setComplianceInfo(jSONObjectOptJSONObject.optBoolean(TAG_COMPLIANCEINFO));
                        nativeComplianceModel.setVideoClick(jSONObjectOptJSONObject.optString(TAG_VIDEO_CLICK));
                        nativeComplianceModel.setClickArea(jSONObjectOptJSONObject.optInt(TAG_CLICKAREA));
                        allModel.add(nativeComplianceModel);
                    }
                }
            } catch (Exception e) {
                WifiLog.d("AdDownViVoConfig initAllConfig Exception " + e.toString());
                parError = true;
            }
        }
        WifiLog.d("AdDownViVoConfig initAllConfig parError " + parError);
    }

    public static boolean isNativeVideoClick(String str, int i, String str2) {
        ArrayList<NativeComplianceModel> arrayList;
        ArrayList<String> scenes;
        String channel = NestInfoTaker.INSTANCE.getChannel();
        WifiLog.d("AdDownViVoConfig isNativeVideoClick scene " + str + " downType " + i + " sdkFrom " + str2);
        if (!TextUtils.isEmpty(str) && (arrayList = allModel) != null && arrayList.size() > 0) {
            try {
                int size = allModel.size();
                for (int i2 = 0; i2 < size; i2++) {
                    NativeComplianceModel nativeComplianceModel = allModel.get(i2);
                    if (allowCheck(nativeComplianceModel) && (((scenes = nativeComplianceModel.getScenes()) != null && scenes.size() > 0 && scenes.contains(str)) || scenes.contains("all"))) {
                        ArrayList<Integer> downloadType = nativeComplianceModel.getDownloadType();
                        boolean z = (downloadType != null && downloadType.size() > 0 && downloadType.contains(Integer.valueOf(i))) || i == 1;
                        WifiLog.d("AdDownViVoConfig isNativeVideoClick allCheck " + z);
                        if (z) {
                            String videoClick = nativeComplianceModel.getVideoClick();
                            WifiLog.d("AdDownViVoConfig isNativeVideoClick res " + videoClick);
                            if (!TextUtils.isEmpty(videoClick) && videoClick.contains(str2)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (!parError || !VIVO_CHANNLE.equals(channel)) {
            return false;
        }
        WifiLog.d("AdDownViVoConfig isNativeVideoClick parError " + parError + " curChannel " + channel);
        return true;
    }

    public static boolean isShowComplianceInfo(String str, int i) {
        ArrayList<NativeComplianceModel> arrayList;
        ArrayList<String> scenes;
        String channel = NestInfoTaker.INSTANCE.getChannel();
        WifiLog.d("AdDownViVoConfig isShowComplianceInfo scene " + str + " downType " + i + " curChannel " + channel);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(channel) && (arrayList = allModel) != null && arrayList.size() > 0) {
            try {
                int size = allModel.size();
                for (int i2 = 0; i2 < size; i2++) {
                    NativeComplianceModel nativeComplianceModel = allModel.get(i2);
                    ArrayList<String> channels = nativeComplianceModel.getChannels();
                    if (((channels != null && channels.size() > 0 && channels.contains(channel)) || channels.contains("all")) && (((scenes = nativeComplianceModel.getScenes()) != null && scenes.size() > 0 && scenes.contains(str)) || scenes.contains("all"))) {
                        ArrayList<Integer> downloadType = nativeComplianceModel.getDownloadType();
                        boolean z = (downloadType != null && downloadType.size() > 0 && downloadType.contains(Integer.valueOf(i))) || i == 1;
                        WifiLog.d("AdDownViVoConfig isShowComplianceInfo allCheck " + z);
                        if (z) {
                            boolean zIsComplianceInfo = nativeComplianceModel.isComplianceInfo();
                            WifiLog.d("AdDownViVoConfig isShowComplianceInfo res " + zIsComplianceInfo);
                            return zIsComplianceInfo;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (!parError || !VIVO_CHANNLE.equals(channel)) {
            return false;
        }
        WifiLog.d("AdDownViVoConfig isShowComplianceInfo parError " + parError + " curChannel " + channel);
        return true;
    }

    public static void checkVideoViewClick(NestAdData nestAdData, ViewGroup viewGroup) {
        if (nestAdData == null || viewGroup == null) {
            return;
        }
        try {
            int i = nestAdData.getInteractionType().intValue() != 1 ? 2 : 1;
            String adType = nestAdData.getAdType();
            if (isNativeVideoClick(nestAdData.getAdScene() + "", i, adType == SDKAlias.GDT.getType() ? "gdt" : adType == SDKAlias.CSJ.getType() ? "csj" : adType == SDKAlias.KS.getType() ? "ks" : adType == SDKAlias.BEIZI.getType() ? "beizi" : adType == SDKAlias.FEISUO.getType() ? "feisuo" : adType == SDKAlias.LXAD.getType() ? "lxad" : null)) {
                WifiLog.d("AdDownViVoConfig checkVideoViewClick addClickVideo adData.getAdScene() " + nestAdData.getAdScene() + " downType " + i);
                int i2 = 0;
                while (true) {
                    if (i2 >= viewGroup.getChildCount()) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i2);
                    if ("ad_video_click".equals(childAt.getTag())) {
                        viewGroup.removeView(childAt);
                        WifiLog.d("AdDownViVoConfig checkVideoViewClick find add View childView " + childAt);
                        break;
                    }
                    i2++;
                }
                View view = new View(viewGroup.getContext());
                view.setTag("ad_video_click");
                view.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.compliance.AdDownViVoConfig.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        WifiLog.d("AdDownViVoConfig checkVideoViewClick click v " + view2);
                    }
                });
                viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Exception unused) {
        }
    }
}
