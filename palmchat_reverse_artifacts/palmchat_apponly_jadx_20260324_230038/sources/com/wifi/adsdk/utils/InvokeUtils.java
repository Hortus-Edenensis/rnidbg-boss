package com.wifi.adsdk.utils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class InvokeUtils {
    public static Object invokeBooleanMethod(Object obj, String str, boolean z) {
        try {
            return obj.getClass().getMethod(str, Boolean.TYPE).invoke(obj, Boolean.valueOf(z));
        } catch (Exception unused) {
            return null;
        }
    }
}
