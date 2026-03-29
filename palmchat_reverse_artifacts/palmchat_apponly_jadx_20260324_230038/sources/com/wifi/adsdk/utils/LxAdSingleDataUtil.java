package com.wifi.adsdk.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.x;
import com.lantern.auth.server.WkParams;
import com.wifi.adsdk.LxAdManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdSingleDataUtil {
    private static LxAdSingleDataUtil mInstance;
    private JSONObject deviceInfoData;
    private JSONObject mediaInfoData;
    private JSONObject voviApiData;

    private LxAdSingleDataUtil(Context context) {
        this.mediaInfoData = getMedia(context);
        this.deviceInfoData = getDevice(context);
        this.voviApiData = getVivoApi(context);
    }

    private JSONObject getDevice(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            this.deviceInfoData = jSONObject;
            jSONObject.put("osType", "android");
            this.deviceInfoData.put("an", BLPlatform.getOSVersion());
            this.deviceInfoData.put(CmcdData.OBJECT_TYPE_MUXED_AUDIO_AND_VIDEO, BLPlatform.getAndroidVersionCode());
            this.deviceInfoData.put("manufacturer", BLPlatform.getDeviceManufacturer());
            String deviceModel = BLPlatform.getDeviceModel();
            this.deviceInfoData.put(WkParams.MODEL, deviceModel);
            this.deviceInfoData.put(az.e, 1);
            this.deviceInfoData.put("brand", Build.BRAND);
            Point screenSize = BLPlatform.getScreenSize(context);
            this.deviceInfoData.put("screenWidth", screenSize.x);
            this.deviceInfoData.put("screenHeight", screenSize.y);
            String imei = LxAdManager.getAdManager().getConfig().getRealAppRuntime().getImei();
            this.deviceInfoData.put(WkParams.IMEI, imei);
            if (!TextUtils.isEmpty(imei)) {
                this.deviceInfoData.put("didMd5", Md5Utils.md5(imei));
            }
            this.deviceInfoData.put("bootMark", BLPlatform.getBootMark());
            this.deviceInfoData.put("updateMark", BLPlatform.getUpdateMark());
            this.deviceInfoData.put("hwverCodeOfHms", BLPlatform.getAppStoreVersion(context, "com.huawei.hwid"));
            this.deviceInfoData.put("hwverCodeOfAG", BLPlatform.getAppStoreVersion(context, x.ad));
            String oaId = LxAdManager.getAdManager().getConfig().getRealAppRuntime().getOaId();
            if (!TextUtils.isEmpty(oaId)) {
                this.deviceInfoData.put("hwisTrackingEnabled", "1");
            }
            this.deviceInfoData.put("oaid", oaId);
            this.deviceInfoData.put("androidId", LxAdManager.getAdManager().getConfig().getRealAppRuntime().getAndroidId());
            this.deviceInfoData.put("deviceStartSec", SystemClock.elapsedRealtime() / 1000);
            if (!TextUtils.isEmpty(deviceModel)) {
                this.deviceInfoData.put("deviceNameMd5", Md5Utils.md5(deviceModel));
            }
            this.deviceInfoData.put("hardwareMachine", deviceModel + "," + BLPlatform.getOSVersion());
            this.deviceInfoData.put("physicalMemoryByte", BLPlatform.getRamSize(context));
            this.deviceInfoData.put("harddiskSizeByte", BLPlatform.getRomSize(context));
            this.deviceInfoData.put("wxApiVer", LxAdManager.getAdManager().getConfig().getRealAppRuntime().getWxApiVer());
            this.deviceInfoData.put("openSdkVer", LxAdManager.getAdManager().getConfig().getRealAppRuntime().getOpenSdkVer());
            this.deviceInfoData.put("mac", LxAdManager.getAdManager().getConfig().getRealAppRuntime().getMac());
            this.deviceInfoData.put("sdFreeSpace", BLPlatform.getMemFree(context));
            this.deviceInfoData.put("manufacturerType", BLPlatform.getHonorHuaweiType());
            this.deviceInfoData.put("magicUiVersion", BLPlatform.getMagicUiVersion());
            this.deviceInfoData.put("deviceMode", BLPlatform.getDeviceMode());
            this.deviceInfoData.put("deviceId", LxAdManager.getAdManager().getConfig().getRealAppRuntime().getDeviceId());
        } catch (Exception unused) {
        }
        return this.deviceInfoData;
    }

    public static LxAdSingleDataUtil getInstance(Context context) {
        if (mInstance == null) {
            synchronized (LxAdSingleDataUtil.class) {
                if (mInstance == null) {
                    mInstance = new LxAdSingleDataUtil(context);
                }
            }
        }
        return mInstance;
    }

    private JSONObject getMedia(Context context) {
        JSONObject jSONObject = new JSONObject();
        this.mediaInfoData = jSONObject;
        try {
            jSONObject.put("appId", LxAdManager.getAdManager().getConfig().getAppId());
            this.mediaInfoData.put("appBundleId", context.getPackageName());
            this.mediaInfoData.put("appVersion", BLPlatform.getAppVersionCode(context));
            this.mediaInfoData.put("appVersionName", BLPlatform.getAppVersionName(context));
        } catch (Exception unused) {
        }
        return this.mediaInfoData;
    }

    private JSONObject getVivoApi(Context context) {
        JSONObject jSONObject = new JSONObject();
        this.voviApiData = jSONObject;
        try {
            jSONObject.put("sysVersion", BLPlatform.getSysRom());
            String appStoreVersion = BLPlatform.getAppStoreVersion(context, BLPlatform.VIVO_APPSTORE_PN);
            if (BLPlatform.isOppo()) {
                appStoreVersion = BLPlatform.getAppStoreVersion(context, "com.heytap.market");
            }
            this.voviApiData.put("appstoreVersion", appStoreVersion);
            this.voviApiData.put("browserVersion", BLPlatform.getAppStoreVersion(context, BLPlatform.VIVO_BROWSER_PN));
            this.voviApiData.put("romversion", Build.VERSION.RELEASE);
            this.voviApiData.put("elapsetime", SystemClock.elapsedRealtime());
        } catch (Exception unused) {
        }
        return this.voviApiData;
    }

    public JSONObject getDeviceInfoData() {
        return this.deviceInfoData;
    }

    public JSONObject getMediaInfoData() {
        return this.mediaInfoData;
    }

    public JSONObject getVoviApiData() {
        return this.voviApiData;
    }
}
