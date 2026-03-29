package com.wifi.adsdk.event;

import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.wifi.adsdk.AdAllInitConfig;
import com.wifi.adsdk.LxAdManager;
import com.wifi.adsdk.entity.LxEventReplace;
import com.wifi.adsdk.utils.BLPlatform;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.adsdk.utils.LxAdUtil;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AdEventHttpGetTask implements Runnable {
    private LxEventReplace eventReplace;
    private List<String> mUrls;

    public AdEventHttpGetTask(List<String> list, LxEventReplace lxEventReplace) {
        this.mUrls = list;
        this.eventReplace = lxEventReplace;
    }

    private String replacePlaceholder(String str) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        LxAdLog.d("lxad replacePlaceholder start url " + str);
        if (this.eventReplace != null && !TextUtils.isEmpty(str)) {
            String apiKey = this.eventReplace.getApiKey();
            if (str.contains(LxEventReplace.__OAID__)) {
                String oaId = LxAdManager.getAdManager().getConfig().getRealAppRuntime().getOaId();
                if (!TextUtils.isEmpty(oaId)) {
                    str = str.replace(LxEventReplace.__OAID__, oaId);
                }
            }
            if (str.contains(LxEventReplace.__TS__) && !TextUtils.isEmpty(this.eventReplace.getTS())) {
                str = str.replace(LxEventReplace.__TS__, this.eventReplace.getTS());
            }
            if (str.contains(LxEventReplace.__WIN_PRICE__) && !TextUtils.isEmpty(this.eventReplace.getWinPrice())) {
                str = str.replace(LxEventReplace.__WIN_PRICE__, this.eventReplace.getWinPrice());
            }
            if (str.contains(LxEventReplace.__AD_LT_X__) && !TextUtils.isEmpty(this.eventReplace.getlTX())) {
                str = str.replace(LxEventReplace.__AD_LT_X__, this.eventReplace.getlTX());
            }
            if (str.contains(LxEventReplace.__AD_LT_Y__) && !TextUtils.isEmpty(this.eventReplace.getlTY())) {
                str = str.replace(LxEventReplace.__AD_LT_Y__, this.eventReplace.getlTY());
            }
            if (str.contains(LxEventReplace.__AD_RB_X__) && !TextUtils.isEmpty(this.eventReplace.getrBX())) {
                str = str.replace(LxEventReplace.__AD_RB_X__, this.eventReplace.getrBX());
            }
            if (str.contains(LxEventReplace.__AD_RB_Y__) && !TextUtils.isEmpty(this.eventReplace.getrBY())) {
                str = str.replace(LxEventReplace.__AD_RB_Y__, this.eventReplace.getrBY());
            }
            if (str.contains(LxEventReplace.__CLICKAREA__) && !TextUtils.isEmpty(this.eventReplace.getClickAre())) {
                str = str.replace(LxEventReplace.__CLICKAREA__, this.eventReplace.getClickAre());
            }
            if (str.contains(LxEventReplace.__CARRIER__) && LxAdUtil.carrier >= 0) {
                str = str.replace(LxEventReplace.__CARRIER__, LxAdUtil.carrier + "");
            }
            if (str.contains(LxEventReplace.__SLD__) && !TextUtils.isEmpty(this.eventReplace.getSld())) {
                str = str.replace(LxEventReplace.__SLD__, this.eventReplace.getSld());
            }
            if (str.contains(LxEventReplace.__CALL_UP_RESULT__) && !TextUtils.isEmpty(this.eventReplace.getWxCall())) {
                str = str.replace(LxEventReplace.__CALL_UP_RESULT__, this.eventReplace.getWxCall());
            }
            if (str.contains(LxEventReplace.__DP_RESULT__) && !TextUtils.isEmpty(this.eventReplace.getDpResult())) {
                str = str.replace(LxEventReplace.__DP_RESULT__, this.eventReplace.getDpResult());
            }
            if (str.contains(LxEventReplace.__DP_REASON__) && !TextUtils.isEmpty(this.eventReplace.getDpReason())) {
                str = str.replace(LxEventReplace.__DP_REASON__, this.eventReplace.getDpReason());
            }
            if (str.contains(LxEventReplace.__SHOW_TIME__) && !TextUtils.isEmpty(this.eventReplace.getHwShowTime())) {
                str = str.replace(LxEventReplace.__SHOW_TIME__, this.eventReplace.getHwShowTime());
            }
            if (str.contains(LxEventReplace.__NET_TYPE__)) {
                int networkType = BLPlatform.getNetworkType(LxAdManager.getAdManager().getContext());
                str = str.replace(LxEventReplace.__NET_TYPE__, networkType == 100 ? "WIFI" : networkType != 0 ? "2G" : GrsBaseInfo.CountryCodeSource.UNKNOWN);
            }
            if (str.contains(LxEventReplace.__MAX_SHOW_RATIO__) && !TextUtils.isEmpty(this.eventReplace.getHwMaxShowRatio())) {
                str = str.replace(LxEventReplace.__MAX_SHOW_RATIO__, this.eventReplace.getHwMaxShowRatio());
            }
            if (str.contains(LxEventReplace.__AD_W__) && !TextUtils.isEmpty(this.eventReplace.getrBX())) {
                str = str.replace(LxEventReplace.__AD_W__, this.eventReplace.getrBX());
            }
            if (str.contains(LxEventReplace.__AD_H__) && !TextUtils.isEmpty(this.eventReplace.getrBY())) {
                str = str.replace(LxEventReplace.__AD_H__, this.eventReplace.getrBY());
            }
            if (str.contains(LxEventReplace.__VIDEO_TIME__) && !TextUtils.isEmpty(this.eventReplace.getVideoTime())) {
                str = str.replace(LxEventReplace.__VIDEO_TIME__, this.eventReplace.getVideoTime());
            }
            if (str.contains(LxEventReplace.__END_TIME__) && !TextUtils.isEmpty(this.eventReplace.getVideoTime())) {
                str = str.replace(LxEventReplace.__END_TIME__, this.eventReplace.getVideoTime());
            }
            if (str.contains(LxEventReplace.__DLD_PHASE__) && !TextUtils.isEmpty(this.eventReplace.getDldStatus())) {
                str = str.replace(LxEventReplace.__DLD_PHASE__, this.eventReplace.getDldStatus());
            }
            if (str.contains(LxEventReplace.__BEGIN_TIME__)) {
                str = str.replace(LxEventReplace.__BEGIN_TIME__, "0");
            }
            if (!"huawei".equals(apiKey)) {
                if (!TextUtils.isEmpty(this.eventReplace.getClickX()) && str.contains(LxEventReplace.__DOWN_X__)) {
                    str = str.replace(LxEventReplace.__DOWN_X__, this.eventReplace.getClickX());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getClickY()) && str.contains(LxEventReplace.__DOWN_Y__)) {
                    str = str.replace(LxEventReplace.__DOWN_Y__, this.eventReplace.getClickY());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getUpX()) && str.contains(LxEventReplace.__UP_X__)) {
                    str = str.replace(LxEventReplace.__UP_X__, this.eventReplace.getUpX());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getUpY()) && str.contains(LxEventReplace.__UP_Y__)) {
                    str = str.replace(LxEventReplace.__UP_Y__, this.eventReplace.getUpY());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getHwDownTime()) && str.contains(LxEventReplace.__DOWN_TIME__)) {
                    str = str.replace(LxEventReplace.__DOWN_TIME__, this.eventReplace.getHwDownTime());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getHwUpTime()) && str.contains(LxEventReplace.__UP_TIME__)) {
                    str = str.replace(LxEventReplace.__UP_TIME__, this.eventReplace.getHwUpTime());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getHwXAcc()) && str.contains(LxEventReplace.__X_MAX_ACC__)) {
                    str = str.replace(LxEventReplace.__X_MAX_ACC__, this.eventReplace.getHwXAcc());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getHwYAcc()) && str.contains(LxEventReplace.__Y_MAX_ACC__)) {
                    str = str.replace(LxEventReplace.__Y_MAX_ACC__, this.eventReplace.getHwYAcc());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getHwZAcc()) && str.contains(LxEventReplace.__Z_MAX_ACC__)) {
                    str = str.replace(LxEventReplace.__Z_MAX_ACC__, this.eventReplace.getHwZAcc());
                }
            } else if ("0".equals(this.eventReplace.getSld()) || "1".equals(this.eventReplace.getSld())) {
                if (!TextUtils.isEmpty(this.eventReplace.getClickX()) && str.contains(LxEventReplace.__DOWN_X__)) {
                    str = str.replace(LxEventReplace.__DOWN_X__, this.eventReplace.getClickX());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getClickY()) && str.contains(LxEventReplace.__DOWN_Y__)) {
                    str = str.replace(LxEventReplace.__DOWN_Y__, this.eventReplace.getClickY());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getUpX()) && str.contains(LxEventReplace.__UP_X__)) {
                    str = str.replace(LxEventReplace.__UP_X__, this.eventReplace.getUpX());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getUpY()) && str.contains(LxEventReplace.__UP_Y__)) {
                    str = str.replace(LxEventReplace.__UP_Y__, this.eventReplace.getUpY());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getHwDownTime()) && str.contains(LxEventReplace.__DOWN_TIME__)) {
                    str = str.replace(LxEventReplace.__DOWN_TIME__, this.eventReplace.getHwDownTime());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getHwUpTime()) && str.contains(LxEventReplace.__UP_TIME__)) {
                    str = str.replace(LxEventReplace.__UP_TIME__, this.eventReplace.getHwUpTime());
                }
            } else if ("2".equals(this.eventReplace.getSld())) {
                if (!TextUtils.isEmpty(this.eventReplace.getHwXAcc()) && str.contains(LxEventReplace.__X_MAX_ACC__)) {
                    str = str.replace(LxEventReplace.__X_MAX_ACC__, this.eventReplace.getHwXAcc());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getHwYAcc()) && str.contains(LxEventReplace.__Y_MAX_ACC__)) {
                    str = str.replace(LxEventReplace.__Y_MAX_ACC__, this.eventReplace.getHwYAcc());
                }
                if (!TextUtils.isEmpty(this.eventReplace.getHwZAcc()) && str.contains(LxEventReplace.__Z_MAX_ACC__)) {
                    str = str.replace(LxEventReplace.__Z_MAX_ACC__, this.eventReplace.getHwZAcc());
                }
            }
            if (str.contains(LxEventReplace.__DENSITY__) && !TextUtils.isEmpty(this.eventReplace.getDensity())) {
                str = str.replace(LxEventReplace.__DENSITY__, this.eventReplace.getDensity());
            }
            try {
                if (!TextUtils.isEmpty(apiKey) && (jSONObject = AdAllInitConfig.replaceConfigObj) != null && jSONObject.has(apiKey) && (jSONObjectOptJSONObject = AdAllInitConfig.replaceConfigObj.optJSONObject(apiKey)) != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String strOptString = jSONObjectOptJSONObject.optString(next);
                        if (str.contains(next)) {
                            str = str.replace(next, strOptString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        LxAdLog.d("lxad replacePlaceholder end url " + str);
        return str;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> list = this.mUrls;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.mUrls.size(); i++) {
            String str = this.mUrls.get(i);
            if (!TextUtils.isEmpty(str)) {
                try {
                    String strReplacePlaceholder = replacePlaceholder(str);
                    AdEventHttp adEventHttp = new AdEventHttp(strReplacePlaceholder);
                    if ("huawei".equals(this.eventReplace.getApiKey())) {
                        adEventHttp.setHeader("User-Agent", LxAdManager.getAdManager().getConfig().getRealAppRuntime().getUa());
                    }
                    LxAdLog.d("lxad AdEventHttpGetTask run success " + adEventHttp.get() + " url " + strReplacePlaceholder);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
