package com.bytedance.sdk.openadsdk.gi;

import com.bytedance.embedapplog.util.TTEncryptUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static byte[] u(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.a(bArr, i);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
