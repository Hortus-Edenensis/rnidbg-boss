package com.wifi.adsdk;

import android.content.Context;
import android.util.Log;
import com.wifi.adsdk.http.AbstractHttp;
import com.wifi.adsdk.http.DefaultHttpManager;
import com.wifi.adsdk.listener.ILxAdWxMiniProgramListener;
import com.wifi.adsdk.params.DefaultEventReporter;
import com.wifi.adsdk.params.DefaultUrlEvent;
import com.wifi.adsdk.params.ILxAdAppRuntime;
import com.wifi.adsdk.params.ILxAdGetLocation;
import com.wifi.adsdk.params.ILxAdReporter;
import com.wifi.adsdk.params.ILxAdUrlEvent;
import com.wifi.adsdk.thread.CachedThreadPool;
import com.wifi.adsdk.utils.LxAdLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdConfig {
    private ILxAdAppRuntime adAppRuntime;
    private LxAdRealAppRuntime adRealAppRuntime;
    private String appId;
    private String appName;
    private CachedThreadPool cachedThreadPool;
    private final Context context;
    private boolean debugMode = false;
    private boolean debugUrl = false;
    private ILxAdGetLocation getLocation;
    private AbstractHttp httpManager;
    private ILxAdReporter reporter;
    private String token;
    private ILxAdUrlEvent urlEvent;
    private ILxAdWxMiniProgramListener wxMiniProgramListener;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private final LxAdConfig config;

        public Builder(Context context) {
            this.config = new LxAdConfig(context);
        }

        public LxAdConfig build() {
            Log.d("", "LxAd config build");
            if (this.config.adAppRuntime == null) {
                throw new NullPointerException("you show set setWifiAppRunTime when init sdk in order to supply devices info");
            }
            if (this.config.reporter == null) {
                LxAdConfig lxAdConfig = this.config;
                lxAdConfig.reporter = new DefaultEventReporter(lxAdConfig.context);
            }
            if (this.config.httpManager == null) {
                this.config.httpManager = new DefaultHttpManager();
            }
            if (this.config.urlEvent == null) {
                this.config.urlEvent = new DefaultUrlEvent();
            }
            if (this.config.cachedThreadPool == null) {
                this.config.cachedThreadPool = new CachedThreadPool();
            }
            if (this.config.adRealAppRuntime == null) {
                this.config.adRealAppRuntime = new LxAdRealAppRuntime(this.config.adAppRuntime, this.config.context);
            }
            return this.config;
        }

        public Builder setAppId(String str) {
            this.config.appId = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.config.appName = str;
            return this;
        }

        public Builder setDebugMode(boolean z) {
            this.config.debugMode = z;
            LxAdLog.setDebugMode(z);
            return this;
        }

        public Builder setDebugUrl(boolean z) {
            this.config.debugUrl = z;
            return this;
        }

        public Builder setGetLocation(ILxAdGetLocation iLxAdGetLocation) {
            this.config.getLocation = iLxAdGetLocation;
            return this;
        }

        public Builder setLxAppRunTime(ILxAdAppRuntime iLxAdAppRuntime) {
            this.config.adAppRuntime = iLxAdAppRuntime;
            return this;
        }

        public Builder setReporter(ILxAdReporter iLxAdReporter) {
            this.config.reporter = iLxAdReporter;
            return this;
        }

        public Builder setToken(String str) {
            this.config.token = str;
            return this;
        }

        public Builder setWxMiniProgramListener(ILxAdWxMiniProgramListener iLxAdWxMiniProgramListener) {
            this.config.wxMiniProgramListener = iLxAdWxMiniProgramListener;
            return this;
        }
    }

    public LxAdConfig(Context context) {
        this.context = context;
    }

    public ILxAdGetLocation adGetLocation() {
        return this.getLocation;
    }

    public String getAppId() {
        return this.appId;
    }

    public ILxAdAppRuntime getAppRuntime() {
        return this.adAppRuntime;
    }

    public CachedThreadPool getCachedThreadPool() {
        return this.cachedThreadPool;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean getDebugMode() {
        return this.debugMode;
    }

    public boolean getDebugUrl() {
        return this.debugUrl;
    }

    public AbstractHttp getHttpManager() {
        return this.httpManager;
    }

    public LxAdRealAppRuntime getRealAppRuntime() {
        return this.adRealAppRuntime;
    }

    public ILxAdReporter getReporter() {
        return this.reporter;
    }

    public String getToken() {
        return this.token;
    }

    public ILxAdUrlEvent getUrlEvent() {
        return this.urlEvent;
    }

    public ILxAdWxMiniProgramListener getWxMiniProgramListener() {
        return this.wxMiniProgramListener;
    }
}
