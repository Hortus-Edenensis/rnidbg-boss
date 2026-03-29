package com.beizi.fusion.model;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.c.b;
import com.beizi.fusion.tool.ap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RequestInfo {
    private static RequestInfo mInstance;
    private String adConfigVersion;
    private String appId;
    private String appVersion;
    private String appVersionCode;
    private String channelStr;
    private String configVersion;
    private Context context;
    private String customOaid;
    private DevInfo devInfo;
    private EnvInfo envInfo;
    private String eventVersion;
    private String installTime;
    private String nowTime;
    private String packageName;
    private String sdkVersion;
    private String taskVersion;
    private String updateTime;
    public boolean isInit = false;
    private String forbidSensor = "0";

    private RequestInfo(Context context) {
        this.context = context;
    }

    public static RequestInfo getInstance(Context context) {
        if (mInstance == null) {
            synchronized (RequestInfo.class) {
                if (mInstance == null) {
                    mInstance = new RequestInfo(context);
                }
            }
        }
        return mInstance;
    }

    public String getAdConfigVersion() {
        return this.adConfigVersion;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getChannelStr() {
        return this.channelStr;
    }

    public String getConfigVersion() {
        return this.configVersion;
    }

    public String getCustomOaid() {
        return this.customOaid;
    }

    public DevInfo getDevInfo() {
        return this.devInfo;
    }

    public EnvInfo getEnvInfo() {
        return this.envInfo;
    }

    public String getEventVersion() {
        return this.eventVersion;
    }

    public String getForbidSensor() {
        return this.forbidSensor;
    }

    public String getInstallTime() {
        return this.installTime;
    }

    public String getNowTime() {
        return this.nowTime;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getTaskVersion() {
        return this.taskVersion;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public RequestInfo init() {
        this.appId = b.a().b();
        this.channelStr = b.a().c();
        if (!TextUtils.isEmpty(b.a().d())) {
            this.customOaid = b.a().d();
        } else if (BeiZis.getCustomController() != null) {
            String devOaid = BeiZis.getCustomController().getDevOaid();
            if (!TextUtils.isEmpty(devOaid)) {
                this.customOaid = devOaid;
            }
        }
        if (BeiZis.getCustomController() != null && BeiZis.getCustomController().forbidSensor()) {
            this.forbidSensor = "1";
        }
        this.packageName = ap.c(this.context);
        this.installTime = String.valueOf(ap.a(this.context));
        this.updateTime = String.valueOf(ap.b(this.context));
        this.appVersion = ap.d(this.context);
        this.appVersionCode = String.valueOf(ap.e(this.context));
        this.sdkVersion = "5.2.2.0";
        this.devInfo = new DevInfo(this.context);
        this.envInfo = new EnvInfo(this.context);
        this.isInit = true;
        return mInstance;
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void setAdConfigVersion(String str) {
        this.adConfigVersion = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setAppVersionCode(String str) {
        this.appVersionCode = str;
    }

    public void setChannelStr(String str) {
        this.channelStr = str;
    }

    public void setConfigVersion(String str) {
        this.configVersion = str;
    }

    public void setCustomOaid(String str) {
        this.customOaid = str;
    }

    public void setDevInfo(DevInfo devInfo) {
        this.devInfo = devInfo;
    }

    public void setEnvInfo(EnvInfo envInfo) {
        this.envInfo = envInfo;
    }

    public void setEventVersion(String str) {
        this.eventVersion = str;
    }

    public void setInstallTime(String str) {
        this.installTime = str;
    }

    public void setNowTime(String str) {
        this.nowTime = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setTaskVersion(String str) {
        this.taskVersion = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void updateUserAgent(String str) {
        EnvInfo envInfo = this.envInfo;
        if (envInfo == null) {
            return;
        }
        envInfo.setUserAgent(str);
    }
}
