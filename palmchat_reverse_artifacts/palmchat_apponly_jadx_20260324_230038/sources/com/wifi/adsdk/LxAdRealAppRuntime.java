package com.wifi.adsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.wifi.adsdk.params.ILxAdAppRuntime;
import com.wifi.adsdk.utils.BLPlatform;
import com.wifi.adsdk.utils.LxAdSpUtils;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdRealAppRuntime implements ILxAdAppRuntime {
    private static String androidId = "";
    private static long durationTime = 600000;
    private static String imei = "";
    private static String mac = "";
    private static final String spLatitudeLastKey = "spLatitudeLastKey";
    private static final String spLongitudeLastKey = "spLongitudeLastKey";
    private ILxAdAppRuntime mAppRuntime;
    private Context mContext;

    public LxAdRealAppRuntime(ILxAdAppRuntime iLxAdAppRuntime, Context context) {
        this.mAppRuntime = iLxAdAppRuntime;
        this.mContext = context;
        Log.d("", "LxAd LxAdRealAppRuntime init");
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean alist() {
        return false;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public int getAge() {
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        if (iLxAdAppRuntime != null) {
            return iLxAdAppRuntime.getAge();
        }
        return 0;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getAndroidId() {
        if (!TextUtils.isEmpty(androidId)) {
            return androidId;
        }
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        if (iLxAdAppRuntime != null) {
            String androidId2 = iLxAdAppRuntime.getAndroidId();
            androidId = androidId2;
            if (TextUtils.isEmpty(androidId2) && this.mAppRuntime.isCanUseAndroidId()) {
                imei = BLPlatform.getAndroidID(this.mContext);
            }
        }
        return androidId;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getChanId() {
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        return iLxAdAppRuntime != null ? iLxAdAppRuntime.getChanId() : "";
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getDeviceId() {
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        return iLxAdAppRuntime != null ? iLxAdAppRuntime.getDeviceId() : "";
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public int getGender() {
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        if (iLxAdAppRuntime != null) {
            return iLxAdAppRuntime.getGender();
        }
        return 0;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getImei() {
        if (!TextUtils.isEmpty(imei)) {
            return imei;
        }
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        if (iLxAdAppRuntime != null) {
            String imei2 = iLxAdAppRuntime.getImei();
            imei = imei2;
            if (TextUtils.isEmpty(imei2) && this.mAppRuntime.isCanUsePhoneState()) {
                imei = BLPlatform.getPhoneIMEI(this.mContext);
            }
        }
        return imei;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public List<String> getInstallPkgs() {
        if (AdAllInitConfig.isCanUseInstalledPackages) {
            return BLPlatform.getInstalledApplications(this.mContext);
        }
        return null;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getLatitude() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - LxAdSpUtils.getLong(LxAdSpUtils.spName, spLatitudeLastKey, jCurrentTimeMillis, this.mContext) <= durationTime) {
            ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
            return iLxAdAppRuntime != null ? iLxAdAppRuntime.getLatitude() : "0.0";
        }
        if (LxAdManager.getAdManager().getConfig().adGetLocation() == null) {
            return "0.0";
        }
        LxAdSpUtils.setLong(LxAdSpUtils.spName, spLatitudeLastKey, jCurrentTimeMillis, this.mContext);
        return LxAdManager.getAdManager().getConfig().adGetLocation().getLatitude();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getLongitude() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - LxAdSpUtils.getLong(LxAdSpUtils.spName, spLongitudeLastKey, jCurrentTimeMillis, this.mContext) <= durationTime) {
            ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
            return iLxAdAppRuntime != null ? iLxAdAppRuntime.getLongitude() : "0.0";
        }
        if (LxAdManager.getAdManager().getConfig().adGetLocation() == null) {
            return "0.0";
        }
        LxAdSpUtils.setLong(LxAdSpUtils.spName, spLongitudeLastKey, jCurrentTimeMillis, this.mContext);
        return LxAdManager.getAdManager().getConfig().adGetLocation().getLongitude();
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getMac() {
        if (AdAllInitConfig.allowMac) {
            if (!TextUtils.isEmpty(mac)) {
                return mac;
            }
            mac = BLPlatform.getDeviceMAC(this.mContext);
        }
        return mac;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getOaId() {
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        return iLxAdAppRuntime != null ? iLxAdAppRuntime.getOaId() : "";
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public int getOpenSdkVer() {
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        if (iLxAdAppRuntime != null) {
            return iLxAdAppRuntime.getOpenSdkVer();
        }
        return 0;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getUa() {
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        return iLxAdAppRuntime != null ? iLxAdAppRuntime.getUa() : "";
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public String getUid() {
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        return iLxAdAppRuntime != null ? iLxAdAppRuntime.getUid() : "";
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public int getWxApiVer() {
        ILxAdAppRuntime iLxAdAppRuntime = this.mAppRuntime;
        if (iLxAdAppRuntime != null) {
            return iLxAdAppRuntime.getWxApiVer();
        }
        return 0;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean isCanUseAndroidId() {
        return false;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean isCanUseMacAddress() {
        return false;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean isCanUsePhoneState() {
        return false;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean isCanUseWifiState() {
        return false;
    }

    @Override // com.wifi.adsdk.params.ILxAdAppRuntime
    public boolean isCanUseWriteExternal() {
        return false;
    }
}
