package com.zm.adxsdk.protocol.api;

import android.text.TextUtils;
import com.zm.adxsdk.protocol.api.interfaces.IWfRemoteConfig;
import com.zm.adxsdk.protocol.api.interfaces.IWfReporter;
import com.zm.adxsdk.protocol.api.interfaces.IWfRuntime;
import com.zm.adxsdk.protocol.api.interfaces.IWfWechatMiniPListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WfConfig {
    public static final String PERSONAL_RECOMMEND = "personalRecommend";
    public static final String SENSOR_ENABLE = "sensorEnable";
    public static final String USER_AGENT = "userAgent";
    private Builder mBuilder;
    private IWfRuntime mRuntime;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private String appId;
        private String appName;
        private String channel;
        private boolean debug;
        private Map<String, Object> globalConfig;
        private boolean isRecommend;
        private boolean isTeenagerModel;
        private IWfRemoteConfig remoteConfig;
        private IWfReporter reporter;
        private WfSensitivityController sensitivityController;
        private boolean supportMultiProcess;
        private String token;
        private WfUnityConfig unityConfig;
        private boolean useFda;
        private boolean useFdaCrash;
        private IWfWechatMiniPListener wechatMiniPListener;
        private IWfRuntime wfRuntime;
        private String wxApiVer;
        private int wxOpensdkVer;
        private boolean allowShowNotification = true;
        private boolean showDownloadToast = true;

        public Builder addGlobalConfig(String str, Object obj) {
            if (this.globalConfig == null) {
                this.globalConfig = new ConcurrentHashMap();
            }
            try {
                if (!TextUtils.isEmpty(str) && obj != null) {
                    this.globalConfig.put(str, obj);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return this;
        }

        public WfConfig build() {
            return new WfConfig(this);
        }

        public Builder setAllowShowNotification(boolean z) {
            this.allowShowNotification = z;
            return this;
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setGlobalConfig(Map<String, Object> map) {
            try {
                if (this.globalConfig == null || map == null || map.isEmpty()) {
                    this.globalConfig = map;
                } else {
                    this.globalConfig.putAll(map);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return this;
        }

        public Builder setRecommend(boolean z) {
            this.isRecommend = z;
            return this;
        }

        public Builder setRemoteConfig(IWfRemoteConfig iWfRemoteConfig) {
            this.remoteConfig = iWfRemoteConfig;
            return this;
        }

        public Builder setReporter(IWfReporter iWfReporter) {
            this.reporter = iWfReporter;
            return this;
        }

        public Builder setSensitivityController(WfSensitivityController wfSensitivityController) {
            this.sensitivityController = wfSensitivityController;
            return this;
        }

        public Builder setShowDownloadToast(boolean z) {
            this.showDownloadToast = z;
            return this;
        }

        public Builder setSupportMultiProcess(boolean z) {
            this.supportMultiProcess = z;
            return this;
        }

        public Builder setTeenagerModel(boolean z) {
            this.isTeenagerModel = z;
            return this;
        }

        public Builder setToken(String str) {
            this.token = str;
            return this;
        }

        public Builder setUnityConfig(WfUnityConfig wfUnityConfig) {
            this.unityConfig = wfUnityConfig;
            return this;
        }

        public Builder setUseFda(boolean z) {
            this.useFda = z;
            return this;
        }

        public Builder setUseFdaCrash(boolean z) {
            this.useFdaCrash = z;
            return this;
        }

        public Builder setWechatMiniPListener(IWfWechatMiniPListener iWfWechatMiniPListener) {
            this.wechatMiniPListener = iWfWechatMiniPListener;
            return this;
        }

        public Builder setWfRuntime(IWfRuntime iWfRuntime) {
            this.wfRuntime = iWfRuntime;
            return this;
        }

        public Builder setWxApiVer(String str) {
            this.wxApiVer = str;
            return this;
        }

        public Builder setWxOpensdkVer(int i) {
            this.wxOpensdkVer = i;
            return this;
        }
    }

    public boolean allowShowNotification() {
        return this.mBuilder.allowShowNotification;
    }

    public String getAppId() {
        return this.mBuilder.appId;
    }

    public String getAppName() {
        return this.mBuilder.appName;
    }

    public String getChannel() {
        return this.mBuilder.channel;
    }

    public Object getGlobalConfig(String str) {
        try {
            if (this.mBuilder.globalConfig != null) {
                return this.mBuilder.globalConfig.get(str);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public IWfRemoteConfig getRemoteConfig() {
        return this.mBuilder.remoteConfig;
    }

    public IWfReporter getReporter() {
        return this.mBuilder.reporter;
    }

    public WfSensitivityController getSensitivityController() {
        return this.mBuilder.sensitivityController;
    }

    public String getToken() {
        return this.mBuilder.token;
    }

    public WfUnityConfig getUnityConfig() {
        return this.mBuilder.unityConfig;
    }

    public IWfRuntime getWfRuntime() {
        return this.mBuilder.wfRuntime;
    }

    public IWfWechatMiniPListener getWfWechatMiniPListener() {
        return this.mBuilder.wechatMiniPListener;
    }

    public String getWxApiVer() {
        return this.mBuilder.wxApiVer;
    }

    public int getWxOpensdkVer() {
        return this.mBuilder.wxOpensdkVer;
    }

    public boolean isDebug() {
        return this.mBuilder.debug;
    }

    public boolean isRecommend() {
        return this.mBuilder.isRecommend;
    }

    public boolean isShowDownloadToast() {
        return this.mBuilder.showDownloadToast;
    }

    public boolean isSupportMultiProcess() {
        return this.mBuilder.supportMultiProcess;
    }

    public boolean isTeenagerModel() {
        return this.mBuilder.isTeenagerModel;
    }

    public boolean useFda() {
        return this.mBuilder.useFda;
    }

    public boolean useFdaCrash() {
        return this.mBuilder.useFdaCrash;
    }

    private WfConfig(Builder builder) {
        this.mBuilder = builder;
    }
}
