package com.baidu.mapsdkplatform.comjni.util;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class JNIMD5 {
    public static native String encodeUrlParamsValue(String str);

    public static native String getSignMD5String(String str);

    public static native String getSignMD5StringUTF8(String str);

    public static native String getUrlNeedInfo();
}
