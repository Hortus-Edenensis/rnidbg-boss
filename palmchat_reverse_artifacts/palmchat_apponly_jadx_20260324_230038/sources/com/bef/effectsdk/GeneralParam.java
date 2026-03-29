package com.bef.effectsdk;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class GeneralParam {
    public static String getParamByKey(String str) {
        return nativeGetParamByKey(str);
    }

    private static native String nativeGetParamByKey(String str);

    private static native void nativeSetParamWithKey(String str, String str2);

    private static native void nativeSetParams(HashMap<String, String> map);

    public static void setParamWithKey(String str, String str2) {
        nativeSetParamWithKey(str, str2);
    }

    public static void setParams(HashMap<String, String> map) {
        nativeSetParams(map);
    }
}
