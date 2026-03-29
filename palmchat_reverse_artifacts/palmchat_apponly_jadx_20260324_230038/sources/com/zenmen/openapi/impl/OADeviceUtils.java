package com.zenmen.openapi.impl;

import com.lantern.auth.server.WkParams;
import com.zenmen.openapi.OpenApiManager;
import defpackage.ac1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class OADeviceUtils {
    public static String TYPE_INFO_AID = "getAndroidId";
    public static String TYPE_INFO_CHANID = "getChanId";
    public static String TYPE_INFO_DEVICEID = "getDeviceId";
    public static String TYPE_INFO_IMEI = "getImei";
    public static String TYPE_INFO_LANGUAGE = "getLanguage";
    public static String TYPE_INFO_MAC = "getMac";
    public static String TYPE_INFO_NETMODEL = "getNetModel";
    public static String TYPE_INFO_VERCODE = "getVersionCode";
    public static String TYPE_INFO_VERNAME = "getVersionName";

    public static String getAndroidId() {
        return getDeviceInfo(TYPE_INFO_AID);
    }

    public static String getChanId() {
        return getDeviceInfo(TYPE_INFO_CHANID);
    }

    public static String getDeviceId() {
        return getDeviceInfo(TYPE_INFO_DEVICEID);
    }

    public static String getDeviceInfo(String str) {
        return OpenApiManager.getDeviveInfo(str);
    }

    public static String getImei() {
        return getDeviceInfo(TYPE_INFO_IMEI);
    }

    public static String getLanguage() {
        return getDeviceInfo(TYPE_INFO_LANGUAGE);
    }

    public static String getMac() {
        return getDeviceInfo(TYPE_INFO_MAC);
    }

    public static String getNetModel() {
        return getDeviceInfo(TYPE_INFO_NETMODEL);
    }

    public static Map<String, String> getPublicParams(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("verName", getVersionName());
        map.put("verCode", getVersionCode());
        map.put("chanId", getChanId());
        map.put(WkParams.IMEI, getImei() != null ? getImei() : "");
        String str = ac1.f1194a;
        map.put("mac", getMac() != null ? getMac() : "");
        map.put("deviceId", getDeviceId());
        map.put("netModel", getNetModel());
        map.put("androidId", getAndroidId());
        map.put(WkParams.LANG, getLanguage());
        return map;
    }

    public static String getVersionCode() {
        return getDeviceInfo(TYPE_INFO_VERCODE);
    }

    public static String getVersionName() {
        return getDeviceInfo(TYPE_INFO_VERNAME);
    }
}
