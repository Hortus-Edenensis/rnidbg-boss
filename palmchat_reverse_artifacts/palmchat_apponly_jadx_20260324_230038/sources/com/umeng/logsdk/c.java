package com.umeng.logsdk;

import android.util.Base64;
import com.efs.sdk.base.core.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class c {
    public static String a(byte[] bArr) {
        return new String(Base64.encode(bArr, 11));
    }

    public static String b(byte[] bArr) {
        try {
            return new String(Base64.decode(bArr, 11));
        } catch (Throwable th) {
            Log.e("efs.base", "decode error", th);
            return "";
        }
    }
}
