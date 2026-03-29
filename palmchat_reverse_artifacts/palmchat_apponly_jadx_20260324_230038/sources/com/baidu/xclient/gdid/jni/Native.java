package com.baidu.xclient.gdid.jni;

import com.baidu.xclient.gdid.j.f;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Native {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4317a = "";

    static {
        try {
            System.loadLibrary("tiny_magic");
        } catch (Throwable th) {
            f4317a = f.b(th).replaceAll("\t", x.aQ).replaceAll("\n", x.aQ);
            throw th;
        }
    }

    public String a() {
        return f4317a;
    }

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] acn(byte[] bArr, byte[] bArr2);

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native byte[] dcn(byte[] bArr, byte[] bArr2);

    public native Object jnictl(int i, Object obj, Object obj2, Object obj3);
}
