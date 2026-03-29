package com.zm.fissionsdk.api;

import android.text.TextUtils;
import com.zm.fissionsdk.api.interfaces.IFissionRuntime;
import com.zm.fissionsdk.api.interfaces.IFissionWxMiniProgramListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FissionConfig {
    public static final String PERSONAL_RECOMMEND = "personalRecommend";
    public static final String SENSOR_ENABLE = "sensorEnable";
    public static final String USER_AGENT = "userAgent";
    private Builder mBuilder;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private String appId;
        private String appName;
        private String channel;
        private boolean debug;
        private IFissionRuntime fissionRuntime;
        private Map<String, Object> globalConfig;
        private FissionSensitivityController sensitivityController;
        private boolean supportMultiProcess;
        private String token;
        private FissionUnityConfig unityConfig;
        private String wxApiVer;
        private IFissionWxMiniProgramListener wxMiniProgramListener;
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

        public FissionConfig build() {
            return new FissionConfig(this);
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

        public Builder setFissionRuntime(IFissionRuntime iFissionRuntime) {
            this.fissionRuntime = iFissionRuntime;
            return this;
        }

        public Builder setSensitivityController(FissionSensitivityController fissionSensitivityController) {
            this.sensitivityController = fissionSensitivityController;
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

        public Builder setToken(String str) {
            this.token = str;
            return this;
        }

        public Builder setUnityConfig(FissionUnityConfig fissionUnityConfig) {
            this.unityConfig = fissionUnityConfig;
            return this;
        }

        public Builder setWxApiVer(String str) {
            this.wxApiVer = str;
            return this;
        }

        public Builder setWxMiniProgramListener(IFissionWxMiniProgramListener iFissionWxMiniProgramListener) {
            this.wxMiniProgramListener = iFissionWxMiniProgramListener;
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

    public Map<String, Object> getAllGlobalConfig() {
        return this.mBuilder.globalConfig;
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

    public IFissionRuntime getFissionRuntime() {
        return this.mBuilder.fissionRuntime;
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

    public FissionSensitivityController getSensitivityController() {
        return this.mBuilder.sensitivityController;
    }

    public String getToken() {
        return this.mBuilder.token;
    }

    public FissionUnityConfig getUnityConfig() {
        return this.mBuilder.unityConfig;
    }

    public String getWxApiVer() {
        return this.mBuilder.wxApiVer;
    }

    public IFissionWxMiniProgramListener getWxMiniProgramListener() {
        return this.mBuilder.wxMiniProgramListener;
    }

    public int getWxOpensdkVer() {
        return this.mBuilder.wxOpensdkVer;
    }

    public boolean isDebug() {
        return this.mBuilder.debug;
    }

    public boolean isShowDownloadToast() {
        return this.mBuilder.showDownloadToast;
    }

    public boolean isSupportMultiProcess() {
        return this.mBuilder.supportMultiProcess;
    }

    private FissionConfig(Builder builder) {
        this.mBuilder = builder;
    }
}
