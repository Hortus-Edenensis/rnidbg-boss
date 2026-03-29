package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.JNIBaseApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class EncryptUtil extends JNIBaseApi {
    private static native String nativeDecrypt(String str, String str2);

    private static native String nativeEncrypt(String str, String str2);
}
