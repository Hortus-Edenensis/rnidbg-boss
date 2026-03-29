package com.zm.wfsdk.phonemark;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PhoneMarkHelper {
    static {
        System.loadLibrary("phonemark");
    }

    public static String getBootMark() {
        char[] cArrNativeGetBootMark = nativeGetBootMark();
        return cArrNativeGetBootMark == null ? "" : String.valueOf(cArrNativeGetBootMark).trim();
    }

    public static String getUpdateMark() {
        int[] iArrNativeGetUpdateMark = nativeGetUpdateMark();
        if (iArrNativeGetUpdateMark == null || iArrNativeGetUpdateMark.length < 2) {
            return "";
        }
        return iArrNativeGetUpdateMark[0] + "." + iArrNativeGetUpdateMark[1];
    }

    public static native char[] nativeGetBootMark();

    public static native int[] nativeGetUpdateMark();
}
