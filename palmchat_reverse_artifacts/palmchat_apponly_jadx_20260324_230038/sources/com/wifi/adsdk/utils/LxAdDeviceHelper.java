package com.wifi.adsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdDeviceHelper {
    private static ConcurrentHashMap<String, String> cacheMap = new ConcurrentHashMap<>();

    public static int extractVersion(String str, String str2) {
        String upperCase = str.toUpperCase();
        String upperCase2 = str2.toUpperCase();
        if (upperCase.startsWith(upperCase2)) {
            String strReplaceAll = upperCase.substring(upperCase2.length()).replaceAll("_", "");
            String[] strArrSplit = strReplaceAll.split("\\.");
            if (strArrSplit != null && strArrSplit.length > 0) {
                try {
                    int i = Integer.parseInt(strArrSplit[0]);
                    if (i >= 10) {
                        return i * 100;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            String strReplaceAll2 = strReplaceAll.replaceAll("\\D+", "");
            if (TextUtils.isEmpty(strReplaceAll2)) {
                return 0;
            }
            int length = strReplaceAll2.length();
            if (length > 3) {
                strReplaceAll2 = strReplaceAll2.substring(0, 3);
            } else if (length < 3) {
                StringBuilder sb = new StringBuilder(strReplaceAll2);
                for (int i2 = 0; i2 < 3 - length; i2++) {
                    sb.append(0);
                }
                strReplaceAll2 = sb.toString();
            }
            try {
                return Integer.parseInt(strReplaceAll2);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public static LxAdIDevice getDevice(Context context) {
        if (LxAdEmuiDevice.isEmuiDevice()) {
            return new LxAdEmuiDevice(context);
        }
        if (LxAdMiuiDevice.isMiuiDevice()) {
            return new LxAdMiuiDevice(context);
        }
        if (LxAdOppoDevice.isOppoDevice()) {
            return new LxAdOppoDevice(context);
        }
        if (LxAdVivoDevice.isVivoDevice()) {
            return new LxAdVivoDevice(context);
        }
        return null;
    }

    public static String getProp(String str) throws Throwable {
        String str2 = cacheMap.get(str);
        if (str2 != null) {
            return str2;
        }
        String propImp = getPropImp(str);
        cacheMap.put(str, propImp);
        return propImp;
    }

    public static String getPropImp(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line == null ? "" : line;
        } catch (IOException unused2) {
            bufferedReader2 = bufferedReader;
            Log.e("Rom", "Unable to read prop " + str);
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static int getVersion(String str, String str2) throws Throwable {
        String prop = getProp(str);
        if (TextUtils.isEmpty(prop)) {
            return -1;
        }
        return extractVersion(prop, str2);
    }

    public static boolean needPermissionGuide() {
        return LxAdEmuiDevice.isEmuiDevice() || LxAdMiuiDevice.isMiuiDevice() || LxAdOppoDevice.isOppoDevice();
    }
}
