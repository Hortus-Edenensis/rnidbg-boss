package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    private static volatile a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f11291a;
    private byte[] b;

    private a(Context context) {
        ac.c().a(ContextDelegate.getContext(context));
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context.getApplicationContext());
                }
            }
        }
        return c;
    }

    private synchronized byte[] b() {
        byte[] bArr = this.b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bArrE = ac.c().e();
        this.b = bArrE;
        return bArrE;
    }

    public final String a(String str) throws Exception {
        String strA = j.a(a());
        String strA2 = j.a(b());
        byte[] bArrDecode = Base64.decode(str, 2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(strA2.getBytes("utf-8"), EncryptUtils.AES_ENCRYPT_ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(strA.getBytes("utf-8")));
        return new String(cipher.doFinal(bArrDecode), "utf-8");
    }

    private synchronized byte[] a() {
        byte[] bArr = this.f11291a;
        if (bArr == null || bArr.length <= 0) {
            this.f11291a = ac.c().d();
        }
        return this.f11291a;
    }
}
