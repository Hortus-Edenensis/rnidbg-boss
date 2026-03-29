package com.tide.protocol.config;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.tide.protocol.BuildConfig;
import com.tide.protocol.host.model.PluginInfo;
import com.tide.protocol.model.JsonTransformable;
import com.tide.protocol.report.IFdaReporter;
import com.tide.protocol.util.TdLogUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TideWholeConfig implements JsonTransformable {
    private static final String TAG = "TideWholeConfig";
    private static TideWholeConfig instance;
    private String androidId;
    private String appId;
    private String appVersion;
    private int appVersionCode;
    private double latitude;
    private double longitude;
    private String oaId;
    private int osVersion;
    private String packageName;
    private Map<String, IFdaReporter> reporterMap;
    private String vendor;
    private final String tideFrameVersion = BuildConfig.VERSION_NAME;
    private final int tideFrameCode = BuildConfig.VERSION_CODE;
    private Map<String, Long> pluginInitStartMap = new ConcurrentHashMap();
    private final Map<String, ITideHostConfig> hostConfigs = new ConcurrentHashMap();
    private final Map<String, ITidePluginConfig> pluginConfigs = new ConcurrentHashMap();
    private Map<String, PluginInfo> allPluginInfoMaps = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private String androidId;
        private String appVersion;
        private int appVersionCode;
        private int osVersion;
        private String packageName;
        private String vendor;

        public Builder androidId(String str) {
            this.androidId = str;
            return this;
        }

        public Builder appVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder appVersionCode(int i) {
            this.appVersionCode = i;
            return this;
        }

        public void build() {
            TideWholeConfig.getInstance().setOtherInfo(this);
        }

        public Builder osVersion(int i) {
            this.osVersion = i;
            return this;
        }

        public Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        public Builder vendor(String str) {
            this.vendor = str;
            return this;
        }
    }

    private TideWholeConfig() {
    }

    public static synchronized TideWholeConfig getInstance() {
        if (instance == null) {
            instance = new TideWholeConfig();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOtherInfo(Builder builder) {
        this.osVersion = builder.osVersion;
        this.appVersion = builder.appVersion;
        this.appVersionCode = builder.appVersionCode;
        this.packageName = builder.packageName;
        this.vendor = builder.vendor;
    }

    public String getAndroidId() {
        return this.androidId;
    }

    public String getAppId(String str) {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getHostVersion(String str) {
        ITideHostConfig iTideHostConfig;
        return (TextUtils.isEmpty(str) || (iTideHostConfig = this.hostConfigs.get(str)) == null) ? "" : iTideHostConfig.getHostVersion();
    }

    public int getHostVersionCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        ITideHostConfig iTideHostConfig = this.hostConfigs.get(str);
        if (iTideHostConfig != null) {
            return iTideHostConfig.getHostVersionCode();
        }
        Map<String, PluginInfo> map = this.allPluginInfoMaps;
        if (map == null || map.get(str) == null) {
            return -1;
        }
        return this.allPluginInfoMaps.get(str).getHostVCode();
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getOaId() {
        return this.oaId;
    }

    public int getOsVersion() {
        return this.osVersion;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPluginFrom(String str) {
        Map<String, PluginInfo> map;
        return (TextUtils.isEmpty(str) || (map = this.allPluginInfoMaps) == null || map.get(str) == null) ? "" : this.allPluginInfoMaps.get(str).getPluginFrom();
    }

    public PluginInfo getPluginInfo(String str) {
        Map<String, PluginInfo> map;
        if (TextUtils.isEmpty(str) || (map = this.allPluginInfoMaps) == null) {
            return null;
        }
        return map.get(str);
    }

    public long getPluginStartTime(String str) {
        Map<String, Long> map = this.pluginInitStartMap;
        if (map == null || map.size() == 0 || TextUtils.isEmpty(str)) {
            return 0L;
        }
        return this.pluginInitStartMap.get(str).longValue();
    }

    public String getPluginVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        ITidePluginConfig iTidePluginConfig = this.pluginConfigs.get(str);
        if (iTidePluginConfig != null) {
            return iTidePluginConfig.getPluginVersion();
        }
        Map<String, PluginInfo> map = this.allPluginInfoMaps;
        return (map == null || map.get(str) == null) ? "" : this.allPluginInfoMaps.get(str).getPluginVName();
    }

    public int getPluginVersionCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        ITidePluginConfig iTidePluginConfig = this.pluginConfigs.get(str);
        if (iTidePluginConfig != null) {
            return iTidePluginConfig.getPluginVersionCode();
        }
        Map<String, PluginInfo> map = this.allPluginInfoMaps;
        if (map == null || map.get(str) == null) {
            return -1;
        }
        return this.allPluginInfoMaps.get(str).getPluginVCode();
    }

    public int getPluginVersionCodeFromPluginInfo(String str) {
        Map<String, PluginInfo> map;
        if (TextUtils.isEmpty(str) || (map = this.allPluginInfoMaps) == null || map.get(str) == null) {
            return -1;
        }
        return this.allPluginInfoMaps.get(str).getPluginVCode();
    }

    public IFdaReporter getReporter(String str) {
        Map<String, IFdaReporter> map = this.reporterMap;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return this.reporterMap.get(str);
    }

    public int getTideFrameCode() {
        return this.tideFrameCode;
    }

    public String getTideFrameVersion() {
        return this.tideFrameVersion;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void putPluginInfo(String str, PluginInfo pluginInfo) {
        if (TextUtils.isEmpty(str) || pluginInfo == null) {
            return;
        }
        if (this.allPluginInfoMaps == null) {
            this.allPluginInfoMaps = new ConcurrentHashMap();
        }
        this.allPluginInfoMaps.put(str, pluginInfo);
    }

    public synchronized void savePluginStartInitTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.pluginInitStartMap == null) {
                this.pluginInitStartMap = new ConcurrentHashMap();
            }
            this.pluginInitStartMap.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void setLocation(double d, double d2) {
        this.latitude = d2;
        this.longitude = d;
    }

    public void setTideHostConfig(ITideHostConfig iTideHostConfig) {
        if (iTideHostConfig == null || TextUtils.isEmpty(iTideHostConfig.getPluginName())) {
            return;
        }
        this.hostConfigs.put(iTideHostConfig.getPluginName(), iTideHostConfig);
        TdLogUtils.log(TAG, iTideHostConfig.getHostVersionCode() + "");
        synchronized (this) {
            if (TextUtils.isEmpty(this.appId)) {
                this.appId = iTideHostConfig.getAppId();
            }
            if (TextUtils.isEmpty(this.oaId)) {
                this.oaId = iTideHostConfig.getOaId();
            }
            if (TextUtils.isEmpty(this.androidId)) {
                this.androidId = iTideHostConfig.getAndroidId();
            }
            if (this.longitude == 0.0d) {
                this.longitude = iTideHostConfig.getLongitude();
            }
            if (this.longitude == 0.0d) {
                this.latitude = iTideHostConfig.getLatitude();
            }
            if (this.reporterMap == null) {
                this.reporterMap = new ConcurrentHashMap();
            }
            if (iTideHostConfig.getFdaReporter() != null) {
                this.reporterMap.put(iTideHostConfig.getPluginName(), iTideHostConfig.getFdaReporter());
            }
        }
    }

    public void setTidePluginConfig(ITidePluginConfig iTidePluginConfig) {
        if (iTidePluginConfig == null || TextUtils.isEmpty(iTidePluginConfig.getPluginName())) {
            return;
        }
        this.pluginConfigs.put(iTidePluginConfig.getPluginName(), iTidePluginConfig);
    }

    @Override // com.tide.protocol.model.JsonTransformable
    public String toJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("frame_version", getTideFrameVersion());
            jSONObject.put("frame_code", getTideFrameCode());
            jSONObject.put("appVersion", getAppVersion());
            jSONObject.put("app_code", getAppVersionCode());
            jSONObject.put("package_name", getPackageName());
            jSONObject.put("os_version", getOsVersion());
            jSONObject.put("os", 1);
            jSONObject.put("vendor", getVendor());
            jSONObject.put("android_id", getAndroidId());
            jSONObject.put("longitude", getLongitude());
            jSONObject.put("latitude", getLatitude());
            jSONObject.put("host_code", getHostVersionCode(str));
            jSONObject.put("host_version", getHostVersion(str));
            jSONObject.put("appid", getAppId(str));
            jSONObject.put("oaid", getOaId());
            jSONObject.put("plugin_code", getPluginVersionCode(str));
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, getPluginVersion(str));
            jSONObject.put("plugin_name", str);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
