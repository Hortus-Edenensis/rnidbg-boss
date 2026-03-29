package com.wifi.ad.core.sensitive;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.wifi.ad.core.sensitive.NestInfoSupplier;
import com.wifi.ad.core.utils.WifiLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010.\u001a\u0004\u0018\u00010\u0004J\r\u0010/\u001a\u0004\u0018\u000100¢\u0006\u0002\u00101J\b\u00102\u001a\u0004\u0018\u00010\u0004J\b\u00103\u001a\u0004\u0018\u00010\u0004J\b\u00104\u001a\u0004\u0018\u00010\u0004J\b\u00105\u001a\u0004\u0018\u00010\u0004J\b\u00106\u001a\u0004\u0018\u00010\u0004J\b\u00107\u001a\u0004\u0018\u00010\u0004J\b\u00108\u001a\u0004\u0018\u00010\u0004J\b\u00109\u001a\u0004\u0018\u00010\u0004J\u0010\u0010:\u001a\u0004\u0018\u00010\u00042\u0006\u0010;\u001a\u000200J\r\u0010<\u001a\u0004\u0018\u000100¢\u0006\u0002\u00101J\u0010\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010>\u001a\u00020?J\u0010\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010>\u001a\u00020?J\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010BJ\b\u0010C\u001a\u0004\u0018\u00010\u0004J\b\u0010D\u001a\u0004\u0018\u00010\u0004J\b\u0010E\u001a\u0004\u0018\u00010\u0004J\b\u0010F\u001a\u0004\u0018\u00010\u0004J\u0010\u0010G\u001a\u0004\u0018\u00010\u00042\u0006\u0010>\u001a\u00020?J\u0010\u0010H\u001a\u0004\u0018\u00010\u00042\u0006\u0010;\u001a\u000200J\b\u0010I\u001a\u0004\u0018\u00010\u0004J\u0006\u0010J\u001a\u000200J\n\u0010K\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010L\u001a\u0004\u0018\u00010\u0004J\b\u0010M\u001a\u0004\u0018\u00010\u0004J\r\u0010N\u001a\u0004\u0018\u00010O¢\u0006\u0002\u0010PJ\u0006\u0010Q\u001a\u000200J\b\u0010R\u001a\u0004\u0018\u00010\u0004J\u0010\u0010S\u001a\u00020T2\b\u0010,\u001a\u0004\u0018\u00010-J\u0010\u0010U\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010\u0004J\u0012\u0010W\u001a\u00020T2\b\u0010X\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010Y\u001a\u00020T2\b\u0010Z\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010[\u001a\u00020T2\b\u0010\\\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010]\u001a\u00020T2\b\u0010^\u001a\u0004\u0018\u00010\u0004J\u0012\u0010_\u001a\u00020T2\b\u0010`\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010a\u001a\u00020T2\b\u0010b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010c\u001a\u00020T2\b\u0010d\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010e\u001a\u00020T2\b\u0010f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010g\u001a\u00020T2\b\u0010h\u001a\u0004\u0018\u00010\u0004J\u0010\u0010i\u001a\u00020T2\b\u0010j\u001a\u0004\u0018\u00010\u0004J\u0010\u0010k\u001a\u00020T2\b\u0010l\u001a\u0004\u0018\u00010\u0004J\u0010\u0010m\u001a\u00020T2\b\u0010n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010o\u001a\u00020T2\u0006\u0010p\u001a\u00020\u0004H\u0002J\u0010\u0010q\u001a\u00020T2\b\u0010r\u001a\u0004\u0018\u00010\u0004J\u0010\u0010s\u001a\u00020T2\b\u0010t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010u\u001a\u00020T2\b\u0010v\u001a\u0004\u0018\u00010\u0004J\u0012\u0010w\u001a\u00020T2\b\u0010x\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/wifi/ad/core/sensitive/NestInfoTaker;", "", "()V", "ADXURL", "", "ANDROIDID", "APPVER", "APPVERNAME", "CHANNEL", "CITYCODE", "DEVICEID", "DEVICEINFO", "IMEI1", "IMEI2", "LATITUDE", "LONGITUDE", "LXUA", "MACADDRESS", "MEID", "OAID", "UA", "UID", "isCanUseLocationFreely", "Lcom/wifi/ad/core/sensitive/NestInfoSupplier$LocationState;", "()Lcom/wifi/ad/core/sensitive/NestInfoSupplier$LocationState;", "setCanUseLocationFreely", "(Lcom/wifi/ad/core/sensitive/NestInfoSupplier$LocationState;)V", "isCanUsePhoneStateFreely", "Lcom/wifi/ad/core/sensitive/NestInfoSupplier$PhoneState;", "()Lcom/wifi/ad/core/sensitive/NestInfoSupplier$PhoneState;", "setCanUsePhoneStateFreely", "(Lcom/wifi/ad/core/sensitive/NestInfoSupplier$PhoneState;)V", "isCanUseWifiStateFreely", "Lcom/wifi/ad/core/sensitive/NestInfoSupplier$WifiState;", "()Lcom/wifi/ad/core/sensitive/NestInfoSupplier$WifiState;", "setCanUseWifiStateFreely", "(Lcom/wifi/ad/core/sensitive/NestInfoSupplier$WifiState;)V", "isCanUseWriteExternalFreely", "Lcom/wifi/ad/core/sensitive/NestInfoSupplier$StorageState;", "()Lcom/wifi/ad/core/sensitive/NestInfoSupplier$StorageState;", "setCanUseWriteExternalFreely", "(Lcom/wifi/ad/core/sensitive/NestInfoSupplier$StorageState;)V", "map", "", "supplier", "Lcom/wifi/ad/core/sensitive/NestInfoSupplier;", "getAdxUrl", "getAge", "", "()Ljava/lang/Integer;", "getAndroidId", "getAppVer", "getAppVerName", "getChannel", "getCityCode", "getConfigTai", "getDeviceId", "getDeviceInfo", "getDftConfig", "scene", "getGender", "getImEI1", "context", "Landroid/content/Context;", "getImEI2", "getInstalledPackages", "", "getLXUA", "getLatitude", "getLongitude", "getMacAddress", "getMeID", "getNativeConfig", "getOaId", "getOpenSdkVer", "getSystemModel", "getUA", "getUId", "getVpnStatus", "", "()Ljava/lang/Boolean;", "getWxApiVer", "getWxAppId", "init", "", "putAdxUrl", "adxUrl", "putAndroidID", "androidID", "putAppVer", NestInfoTaker.APPVER, "putAppVerName", NestInfoTaker.APPVERNAME, "putChannel", "channel", "putCityCode", NestInfoTaker.CITYCODE, "putDeviceID", "deviceID", "putDeviceInfo", "deviceInfo", "putImEI1", "imEI1", "putImEI2", "imEI2", "putLXUA", NestInfoTaker.LXUA, "putLatitude", "latitude", "putLongitude", "longitude", "putMacAddress", "macAddress", "putMeId", "meId", "putOaId", "oaId", "putUA", "ua", "putUID", "uid", "core_release"}, k = 1, mv = {1, 1, 16})
public final class NestInfoTaker {
    private static final String ADXURL = "adxurl";
    private static final String ANDROIDID = "androidid";
    private static final String APPVER = "appver";
    private static final String APPVERNAME = "appvername";
    private static final String CHANNEL = "channel";
    private static final String CITYCODE = "cityCode";
    private static final String DEVICEID = "deviceid";
    private static final String DEVICEINFO = "deviceinfo";
    private static final String IMEI1 = "imei1";
    private static final String IMEI2 = "imei2";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String LXUA = "lxua";
    private static final String MACADDRESS = "macadress";
    private static final String MEID = "meid";
    private static final String OAID = "oaid";
    private static final String UA = "ua";
    private static final String UID = "uid";
    private static NestInfoSupplier supplier;
    public static final NestInfoTaker INSTANCE = new NestInfoTaker();
    private static final Map<String, String> map = new HashMap();
    private static NestInfoSupplier.LocationState isCanUseLocationFreely = NestInfoSupplier.LocationState.ALLOW_USE;
    private static NestInfoSupplier.WifiState isCanUseWifiStateFreely = NestInfoSupplier.WifiState.ALLOW_USE;
    private static NestInfoSupplier.PhoneState isCanUsePhoneStateFreely = NestInfoSupplier.PhoneState.ALLOW_USE;
    private static NestInfoSupplier.StorageState isCanUseWriteExternalFreely = NestInfoSupplier.StorageState.ALLOW_USE;

    private NestInfoTaker() {
    }

    private final String getSystemModel() {
        return Build.MODEL;
    }

    private final void putAndroidID(String androidID) {
        WifiLog.d("NestInfoTaker putAndroidID = " + androidID);
        map.put(ANDROIDID, androidID);
    }

    private final void putAppVer(String appver) {
        WifiLog.d("NestInfoTaker appver = " + appver);
        map.put(APPVER, appver);
    }

    private final void putAppVerName(String appvername) {
        WifiLog.d("NestInfoTaker appvername = " + appvername);
        map.put(APPVERNAME, appvername);
    }

    private final void putCityCode(String cityCode) {
        WifiLog.d("NestInfoTaker cityCode = " + cityCode);
        map.put(CITYCODE, cityCode);
    }

    private final void putDeviceID(String deviceID) {
        WifiLog.d("NestInfoTaker putDeviceID = " + deviceID);
        map.put("deviceid", deviceID);
    }

    private final void putDeviceInfo(String deviceInfo) {
        WifiLog.d("NestInfoTaker putDeviceInfo = " + deviceInfo);
        map.put(DEVICEINFO, deviceInfo);
    }

    private final void putMacAddress(String macAddress) {
        WifiLog.d("NestInfoTaker putMacAddress = " + macAddress);
        map.put(MACADDRESS, macAddress);
    }

    private final void putUID(String uid) {
        WifiLog.d("NestInfoTaker putUID = " + uid);
        map.put("uid", uid);
    }

    public final String getAdxUrl() {
        String adxUrl = map.get(ADXURL);
        if (adxUrl == null || adxUrl.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            adxUrl = nestInfoSupplier != null ? nestInfoSupplier.getAdxUrl() : null;
            if (!(adxUrl == null || adxUrl.length() == 0)) {
                putAdxUrl(adxUrl);
            }
        }
        WifiLog.d("NestInfoTaker getAdxUrl = " + adxUrl);
        return adxUrl;
    }

    public final Integer getAge() {
        NestInfoSupplier nestInfoSupplier = supplier;
        if (nestInfoSupplier == null) {
            return 0;
        }
        if (nestInfoSupplier == null) {
            Intrinsics.throwNpe();
        }
        return nestInfoSupplier.getAge();
    }

    public final String getAndroidId() {
        String androidId = map.get(ANDROIDID);
        if (androidId == null || androidId.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            androidId = nestInfoSupplier != null ? nestInfoSupplier.getAndroidId() : null;
            if (!(androidId == null || androidId.length() == 0)) {
                putAndroidID(androidId);
            }
        }
        WifiLog.d("NestInfoTaker getAndroidId = " + androidId);
        return androidId;
    }

    public final String getAppVer() {
        String appVer = map.get(APPVER);
        if (appVer == null || appVer.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            appVer = nestInfoSupplier != null ? nestInfoSupplier.getAppVer() : null;
            if (!(appVer == null || appVer.length() == 0)) {
                putAppVer(appVer);
            }
        }
        WifiLog.d("NestInfoTaker appver = " + appVer);
        return appVer;
    }

    public final String getAppVerName() {
        String appVerName = map.get(APPVERNAME);
        if (appVerName == null || appVerName.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            appVerName = nestInfoSupplier != null ? nestInfoSupplier.getAppVerName() : null;
            if (!(appVerName == null || appVerName.length() == 0)) {
                putAppVerName(appVerName);
            }
        }
        WifiLog.d("NestInfoTaker appverName = " + appVerName);
        return appVerName;
    }

    public final String getChannel() {
        String channel = map.get("channel");
        if (channel == null || channel.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            channel = nestInfoSupplier != null ? nestInfoSupplier.getChannel() : null;
            if (!(channel == null || channel.length() == 0)) {
                putChannel(channel);
            }
        }
        WifiLog.d("NestInfoTaker getChannel = " + channel);
        return channel;
    }

    public final String getCityCode() {
        String lxCityCode = map.get(CITYCODE);
        if (lxCityCode == null || lxCityCode.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            lxCityCode = nestInfoSupplier != null ? nestInfoSupplier.getLxCityCode() : null;
            if (!(lxCityCode == null || lxCityCode.length() == 0)) {
                putCityCode(lxCityCode);
            }
        }
        WifiLog.d("NestInfoTaker cityCode = " + lxCityCode);
        return lxCityCode;
    }

    public final String getConfigTai() {
        NestInfoSupplier nestInfoSupplier = supplier;
        if (nestInfoSupplier != null) {
            return nestInfoSupplier.getConfigTai();
        }
        return null;
    }

    public final String getDeviceId() {
        String deviceId = map.get("deviceid");
        if (deviceId == null || deviceId.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            deviceId = nestInfoSupplier != null ? nestInfoSupplier.getDeviceId() : null;
            if (!(deviceId == null || deviceId.length() == 0)) {
                putDeviceID(deviceId);
            }
        }
        WifiLog.d("NestInfoTaker getDeviceId = " + deviceId);
        return deviceId;
    }

    public final String getDeviceInfo() {
        String deviceInfo = map.get(DEVICEINFO);
        if (deviceInfo == null || deviceInfo.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            deviceInfo = nestInfoSupplier != null ? nestInfoSupplier.getDeviceInfo() : null;
            if (!(deviceInfo == null || deviceInfo.length() == 0)) {
                putDeviceInfo(deviceInfo);
            }
        }
        WifiLog.d("NestInfoTaker deviceInfo = " + deviceInfo);
        return deviceInfo;
    }

    public final String getDftConfig(int scene) {
        NestInfoSupplier nestInfoSupplier = supplier;
        if (nestInfoSupplier != null) {
            return nestInfoSupplier.getDftConfig(scene);
        }
        return null;
    }

    public final Integer getGender() {
        NestInfoSupplier nestInfoSupplier = supplier;
        if (nestInfoSupplier == null) {
            return 0;
        }
        if (nestInfoSupplier == null) {
            Intrinsics.throwNpe();
        }
        return nestInfoSupplier.getGender();
    }

    public final String getImEI1(Context context) {
        String imei1;
        Map<String, String> map2 = map;
        if (map2.containsKey(IMEI1)) {
            imei1 = map2.get(IMEI1);
            if (!TextUtils.isEmpty(imei1)) {
                WifiLog.d("NestInfoTaker getImEI1 = " + imei1);
                return imei1;
            }
        } else {
            imei1 = "";
        }
        if (imei1 == null || imei1.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            imei1 = nestInfoSupplier != null ? nestInfoSupplier.getImei1() : null;
            if (!(imei1 == null || imei1.length() == 0)) {
                putImEI1(imei1);
            }
        }
        WifiLog.d("NestInfoTaker getImEI1 = " + imei1);
        return imei1;
    }

    public final String getImEI2(Context context) {
        String imei2;
        Map<String, String> map2 = map;
        if (map2.containsKey(IMEI2)) {
            imei2 = map2.get(IMEI2);
            if (!TextUtils.isEmpty(imei2)) {
                WifiLog.d("NestInfoTaker getImEI2 = " + imei2);
                return imei2;
            }
        } else {
            imei2 = "";
        }
        if (imei2 == null || imei2.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            imei2 = nestInfoSupplier != null ? nestInfoSupplier.getImei2() : null;
            if (!(imei2 == null || imei2.length() == 0)) {
                putImEI2(imei2);
            }
        }
        WifiLog.d("NestInfoTaker getImEI2 = " + imei2);
        return imei2;
    }

    public final List<String> getInstalledPackages() {
        NestInfoSupplier nestInfoSupplier = supplier;
        if (nestInfoSupplier != null) {
            return nestInfoSupplier.getInstalledPackages();
        }
        return null;
    }

    public final String getLXUA() {
        String lxua = map.get(LXUA);
        if (lxua == null || lxua.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            lxua = nestInfoSupplier != null ? nestInfoSupplier.getLXUA() : null;
            if (!(lxua == null || lxua.length() == 0)) {
                putLXUA(lxua);
            }
        }
        WifiLog.d("NestInfoTaker getLXUA = " + lxua);
        return lxua;
    }

    public final String getLatitude() {
        String latitude = map.get("latitude");
        if (latitude == null || latitude.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            latitude = nestInfoSupplier != null ? nestInfoSupplier.getLatitude() : null;
            if (!(latitude == null || latitude.length() == 0)) {
                putLatitude(latitude);
            }
        }
        WifiLog.d("NestInfoTaker getLatitude = " + latitude);
        return latitude;
    }

    public final String getLongitude() {
        String longitude = map.get("longitude");
        if (longitude == null || longitude.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            longitude = nestInfoSupplier != null ? nestInfoSupplier.getLongitude() : null;
            if (!(longitude == null || longitude.length() == 0)) {
                putLongitude(longitude);
            }
        }
        WifiLog.d("NestInfoTaker getLongitude = " + longitude);
        return longitude;
    }

    public final String getMacAddress() {
        String macAddress = map.get(MACADDRESS);
        if (macAddress == null || macAddress.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            macAddress = nestInfoSupplier != null ? nestInfoSupplier.getMacAddress() : null;
            if (!(macAddress == null || macAddress.length() == 0)) {
                putMacAddress(macAddress);
            }
        }
        WifiLog.d("NestInfoTaker getMacAddress = " + macAddress);
        return macAddress;
    }

    public final String getMeID(Context context) {
        String imei;
        Map<String, String> map2 = map;
        if (map2.containsKey(MEID)) {
            imei = map2.get(MEID);
            if (!TextUtils.isEmpty(imei)) {
                WifiLog.d("NestInfoTaker getMeID = " + imei);
                return imei;
            }
        } else {
            imei = "";
        }
        if (imei == null || imei.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            imei = nestInfoSupplier != null ? nestInfoSupplier.getImei() : null;
            if (!(imei == null || imei.length() == 0)) {
                putMeId(imei);
            }
        }
        WifiLog.d("NestInfoTaker getMeID = " + imei);
        return imei;
    }

    public final String getNativeConfig(int scene) {
        NestInfoSupplier nestInfoSupplier = supplier;
        if (nestInfoSupplier != null) {
            return nestInfoSupplier.getNativeConfig(scene);
        }
        return null;
    }

    public final String getOaId() {
        String oaId = map.get(OAID);
        if (oaId == null || oaId.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            oaId = nestInfoSupplier != null ? nestInfoSupplier.getOaId() : null;
            if (!(oaId == null || oaId.length() == 0)) {
                putOaId(oaId);
            }
        }
        WifiLog.d("NestInfoTaker getOaId = " + oaId);
        return oaId;
    }

    public final int getOpenSdkVer() {
        NestInfoSupplier nestInfoSupplier = supplier;
        if (nestInfoSupplier == null) {
            return 0;
        }
        if (nestInfoSupplier == null) {
            Intrinsics.throwNpe();
        }
        return nestInfoSupplier.getOpenSdkVer();
    }

    public final String getUA() {
        String ua = map.get("ua");
        if (ua == null || ua.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            ua = nestInfoSupplier != null ? nestInfoSupplier.getUA() : null;
            if (!(ua == null || ua.length() == 0)) {
                putUA(ua);
            }
        }
        WifiLog.d("NestInfoTaker ua = " + ua);
        return ua;
    }

    public final String getUId() {
        String uId = map.get("uid");
        if (uId == null || uId.length() == 0) {
            NestInfoSupplier nestInfoSupplier = supplier;
            uId = nestInfoSupplier != null ? nestInfoSupplier.getUId() : null;
            if (!(uId == null || uId.length() == 0)) {
                putUID(uId);
            }
        }
        WifiLog.d("NestInfoTaker getuid = " + uId);
        return uId;
    }

    public final Boolean getVpnStatus() {
        NestInfoSupplier nestInfoSupplier = supplier;
        if (nestInfoSupplier == null) {
            return Boolean.FALSE;
        }
        if (nestInfoSupplier != null) {
            return Boolean.valueOf(nestInfoSupplier.getLxVpnStatus());
        }
        return null;
    }

    public final int getWxApiVer() {
        NestInfoSupplier nestInfoSupplier = supplier;
        if (nestInfoSupplier == null) {
            return 0;
        }
        if (nestInfoSupplier == null) {
            Intrinsics.throwNpe();
        }
        return nestInfoSupplier.getWxApiVer();
    }

    public final String getWxAppId() {
        NestInfoSupplier nestInfoSupplier = supplier;
        if (nestInfoSupplier != null) {
            return nestInfoSupplier.getWxAppId();
        }
        return null;
    }

    public final void init(NestInfoSupplier supplier2) {
        NestInfoSupplier.LocationState locationStateCanSdkUseLocationState;
        NestInfoSupplier.PhoneState phoneStateCanSdkUsePhoneState;
        NestInfoSupplier.WifiState wifiStateCanSdkUseWifiState;
        NestInfoSupplier.StorageState storageStateCanSdkUseSdCardState;
        supplier = supplier2;
        putMeId(supplier2 != null ? supplier2.getImei() : null);
        putImEI1(supplier2 != null ? supplier2.getImei1() : null);
        putImEI2(supplier2 != null ? supplier2.getImei2() : null);
        putUA(supplier2 != null ? supplier2.getUA() : null);
        putLXUA(supplier2 != null ? supplier2.getLXUA() : null);
        putOaId(supplier2 != null ? supplier2.getOaId() : null);
        putAdxUrl(supplier2 != null ? supplier2.getAdxUrl() : null);
        putLatitude(String.valueOf(supplier2 != null ? supplier2.getLatitude() : null));
        putLongitude(String.valueOf(supplier2 != null ? supplier2.getLongitude() : null));
        putChannel(supplier2 != null ? supplier2.getChannel() : null);
        putDeviceInfo(supplier2 != null ? supplier2.getDeviceInfo() : null);
        putAppVer(supplier2 != null ? supplier2.getAppVer() : null);
        putAppVerName(supplier2 != null ? supplier2.getAppVerName() : null);
        putAndroidID(supplier2 != null ? supplier2.getAndroidId() : null);
        putDeviceID(supplier2 != null ? supplier2.getDeviceId() : null);
        putCityCode(supplier2 != null ? supplier2.getLxCityCode() : null);
        putUID(supplier2 != null ? supplier2.getUId() : null);
        if (supplier2 == null || (locationStateCanSdkUseLocationState = supplier2.canSdkUseLocationState()) == null) {
            locationStateCanSdkUseLocationState = isCanUseLocationFreely;
        }
        isCanUseLocationFreely = locationStateCanSdkUseLocationState;
        if (supplier2 == null || (phoneStateCanSdkUsePhoneState = supplier2.canSdkUsePhoneState()) == null) {
            phoneStateCanSdkUsePhoneState = isCanUsePhoneStateFreely;
        }
        isCanUsePhoneStateFreely = phoneStateCanSdkUsePhoneState;
        if (supplier2 == null || (wifiStateCanSdkUseWifiState = supplier2.canSdkUseWifiState()) == null) {
            wifiStateCanSdkUseWifiState = isCanUseWifiStateFreely;
        }
        isCanUseWifiStateFreely = wifiStateCanSdkUseWifiState;
        if (supplier2 == null || (storageStateCanSdkUseSdCardState = supplier2.canSdkUseSdCardState()) == null) {
            storageStateCanSdkUseSdCardState = isCanUseWriteExternalFreely;
        }
        isCanUseWriteExternalFreely = storageStateCanSdkUseSdCardState;
        WifiLog.d("NestInfoTaker init() isCanUseLocation = " + isCanUseLocationFreely + " isCanUsePhoneState = " + isCanUsePhoneStateFreely + " isCanUseWifiState = " + isCanUseWifiStateFreely + " isCanUseWriteExternal = " + isCanUseWriteExternalFreely);
    }

    public final NestInfoSupplier.LocationState isCanUseLocationFreely() {
        return isCanUseLocationFreely;
    }

    public final NestInfoSupplier.PhoneState isCanUsePhoneStateFreely() {
        return isCanUsePhoneStateFreely;
    }

    public final NestInfoSupplier.WifiState isCanUseWifiStateFreely() {
        return isCanUseWifiStateFreely;
    }

    public final NestInfoSupplier.StorageState isCanUseWriteExternalFreely() {
        return isCanUseWriteExternalFreely;
    }

    public final void putAdxUrl(String adxUrl) {
        WifiLog.d("NestInfoTaker putAdxUrl = " + adxUrl);
        map.put(ADXURL, adxUrl);
    }

    public final void putChannel(String channel) {
        WifiLog.d("NestInfoTaker putChannel = " + channel);
        map.put("channel", channel);
    }

    public final void putImEI1(String imEI1) {
        WifiLog.d("NestInfoTaker putImEI1 = " + imEI1);
        map.put(IMEI1, imEI1);
    }

    public final void putImEI2(String imEI2) {
        WifiLog.d("NestInfoTaker putImEI2 = " + imEI2);
        map.put(IMEI2, imEI2);
    }

    public final void putLXUA(String lxua) {
        WifiLog.d("NestInfoTaker putLXUA = " + lxua);
        map.put(LXUA, lxua);
    }

    public final void putLatitude(String latitude) {
        WifiLog.d("NestInfoTaker putLatitude = " + latitude);
        map.put("latitude", latitude);
    }

    public final void putLongitude(String longitude) {
        WifiLog.d("NestInfoTaker putLongitude = " + longitude);
        map.put("longitude", longitude);
    }

    public final void putMeId(String meId) {
        WifiLog.d("NestInfoTaker putMeId = " + meId);
        map.put(MEID, meId);
    }

    public final void putOaId(String oaId) {
        WifiLog.d("NestInfoTaker putOaId = " + oaId);
        map.put(OAID, oaId);
    }

    public final void putUA(String ua) {
        WifiLog.d("NestInfoTaker putUA = " + ua);
        map.put("ua", ua);
    }

    public final void setCanUseLocationFreely(NestInfoSupplier.LocationState locationState) {
        isCanUseLocationFreely = locationState;
    }

    public final void setCanUsePhoneStateFreely(NestInfoSupplier.PhoneState phoneState) {
        isCanUsePhoneStateFreely = phoneState;
    }

    public final void setCanUseWifiStateFreely(NestInfoSupplier.WifiState wifiState) {
        isCanUseWifiStateFreely = wifiState;
    }

    public final void setCanUseWriteExternalFreely(NestInfoSupplier.StorageState storageState) {
        isCanUseWriteExternalFreely = storageState;
    }
}
