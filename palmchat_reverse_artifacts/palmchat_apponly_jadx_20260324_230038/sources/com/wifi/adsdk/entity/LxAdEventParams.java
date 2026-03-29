package com.wifi.adsdk.entity;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.wifi.adsdk.LxAdManager;
import com.wifi.adsdk.LxAdSdk;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.LxAdConst;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdEventParams {
    private int adMode;
    private String adUnitId;
    private int adcost;
    private String apiId;
    private String apiSrcId;
    private String appId;
    private int code;
    private String lxsdkSrcid;
    private String lxsdkver;
    private String msg;
    private String progress;
    private String requestId;
    private String scene;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private final LxAdEventParams params = new LxAdEventParams();

        public LxAdEventParams build() {
            return this.params;
        }

        public Builder setAdMode(int i) {
            this.params.adMode = i;
            return this;
        }

        public Builder setAdUnitId(String str) {
            this.params.adUnitId = str;
            return this;
        }

        public Builder setAdcost(int i) {
            this.params.adcost = i;
            return this;
        }

        public Builder setApiId(String str) {
            this.params.apiId = str;
            return this;
        }

        public Builder setApiSrcId(String str) {
            this.params.apiSrcId = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.params.appId = str;
            return this;
        }

        public Builder setCode(int i) {
            this.params.code = i;
            return this;
        }

        public Builder setDownloadProcess(String str) {
            this.params.progress = str;
            return this;
        }

        public Builder setLxsdkSrcid(String str) {
            this.params.lxsdkSrcid = str;
            return this;
        }

        public Builder setLxsdkver(String str) {
            this.params.lxsdkver = str;
            return this;
        }

        public Builder setMsg(String str) {
            this.params.msg = str;
            return this;
        }

        public Builder setRequestId(String str) {
            this.params.requestId = str;
            return this;
        }

        public Builder setScene(String str) {
            this.params.scene = str;
            return this;
        }
    }

    public static LxAdEventParams createEventParams(LxAdReqParams lxAdReqParams, int i, int i2, String str, int i3, String str2, String str3, String str4) {
        if (lxAdReqParams != null) {
            return new Builder().setRequestId(lxAdReqParams.getClientReqId()).setScene(lxAdReqParams.getScene()).setAdMode(i2).setAdcost(i).setApiId(str).setLxsdkSrcid(lxAdReqParams.getLxSrcId()).setAdUnitId(lxAdReqParams.getNestSrcId()).setAppId(LxAdManager.getAdManager().getConfig().getAppId()).setMsg(str2).setCode(i3).setApiSrcId(str3).setDownloadProcess(str4).setLxsdkver(LxAdSdk.getVersion()).build();
        }
        return null;
    }

    public static String toJson(@NonNull LxAdEventParams lxAdEventParams) {
        try {
            JSONObject jSONObject = new JSONObject();
            String requestId = lxAdEventParams.getRequestId();
            if (!TextUtils.isEmpty(requestId)) {
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_REQUESTID, requestId);
            }
            String scene = lxAdEventParams.getScene();
            if (!TextUtils.isEmpty(scene)) {
                jSONObject.put("scene", scene);
            }
            String apiSrcId = lxAdEventParams.getApiSrcId();
            if (!TextUtils.isEmpty(apiSrcId)) {
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_APISRCID, apiSrcId);
            }
            String progress = lxAdEventParams.getProgress();
            if (!TextUtils.isEmpty(progress)) {
                jSONObject.put("progress", progress);
            }
            String apiId = lxAdEventParams.getApiId();
            if (!TextUtils.isEmpty(apiId)) {
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_APIID, apiId);
            }
            String sdkVersion = lxAdEventParams.getSdkVersion();
            if (!TextUtils.isEmpty(sdkVersion)) {
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_SDKVER, sdkVersion);
            }
            String appId = lxAdEventParams.getAppId();
            if (!TextUtils.isEmpty(appId)) {
                jSONObject.put("appid", appId);
            }
            String lxSdkSrcid = lxAdEventParams.getLxSdkSrcid();
            if (!TextUtils.isEmpty(lxSdkSrcid)) {
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_LXSDKSRCID, lxSdkSrcid);
            }
            String adUnitId = lxAdEventParams.getAdUnitId();
            if (!TextUtils.isEmpty(adUnitId)) {
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADUNITID, adUnitId);
            }
            jSONObject.put("code", lxAdEventParams.getCode());
            jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, lxAdEventParams.getAdMode());
            String msg = lxAdEventParams.getMsg();
            if (!TextUtils.isEmpty(msg)) {
                jSONObject.put("msg", msg);
            }
            jSONObject.put("adcost", lxAdEventParams.getAdcost());
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getAdMode() {
        return this.adMode;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public int getAdcost() {
        return this.adcost;
    }

    public String getApiId() {
        return this.apiId;
    }

    public String getApiSrcId() {
        return this.apiSrcId;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getCode() {
        return this.code;
    }

    public String getLxSdkSrcid() {
        return this.lxsdkSrcid;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getProgress() {
        return this.progress;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getScene() {
        return this.scene;
    }

    public String getSdkVersion() {
        return this.lxsdkver;
    }

    private LxAdEventParams() {
    }
}
