package com.zm.fda.OOZ20;

import android.text.TextUtils;
import android.util.Log;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zm.fda.O52OZ.Z0O00;
import com.zm.fda.O52OZ.ZZ050;
import com.zm.fda.utils.EventLog;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16649a = 0;
    public static final int b = 1;
    public static final String c = "AES/ECB/PKCS5Padding";
    public static String d;
    public static String e;

    public static byte[] a(byte[] bArr, int i) {
        Cipher cipher;
        if (bArr != null && bArr.length != 0) {
            a();
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(e.getBytes());
                SecretKeySpec secretKeySpec = new SecretKeySpec(d.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
                if (i == 1) {
                    cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(2, secretKeySpec);
                } else {
                    cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(2, secretKeySpec, ivParameterSpec);
                }
                return cipher.doFinal(bArr);
            } catch (Exception e2) {
                EventLog.e("fob_fda", "decryptAES error:" + e2.getMessage());
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr, int i) {
        Cipher cipher;
        if (bArr != null && bArr.length != 0) {
            a();
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(e.getBytes("UTF-8"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(d.getBytes("UTF-8"), EncryptUtils.AES_ENCRYPT_ALGORITHM);
                if (i == 1) {
                    cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(1, secretKeySpec);
                } else {
                    cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                }
                return cipher.doFinal(bArr);
            } catch (Exception e2) {
                Log.e("fob_fda", "encryptAES error:", e2);
            }
        }
        return null;
    }

    public static String c() {
        return ZZ050.a(com.zm.fda.ZZ00Z.b(), com.zm.fda.Z200O.ZZ00Z.h, com.zm.fda.Z200O.ZZ00Z.v, "GrsH6H!%97T68UKf");
    }

    public static String d() {
        return ZZ050.a(com.zm.fda.ZZ00Z.b(), com.zm.fda.Z200O.ZZ00Z.h, com.zm.fda.Z200O.ZZ00Z.u, "cI&siw0LgUtx&TGp");
    }

    public static String e() {
        return ZZ050.a(com.zm.fda.ZZ00Z.b(), com.zm.fda.Z200O.ZZ00Z.h, com.zm.fda.Z200O.ZZ00Z.s, "0rGIMc#f2Kj04cGRAWqkrEHy@q10asM8");
    }

    public static String a(byte[] bArr) {
        return Z0O00.b(b(bArr, 1));
    }

    public static String b(byte[] bArr) {
        return Z0O00.b(b(bArr, 0));
    }

    public static String a(String str) {
        byte[] bArrA;
        return (str == null || TextUtils.isEmpty(str) || (bArrA = a(Z0O00.a(str), 1)) == null) ? "" : new String(bArrA);
    }

    public static String b(String str) {
        byte[] bArrA;
        return (str == null || TextUtils.isEmpty(str) || (bArrA = a(Z0O00.a(str), 0)) == null) ? "" : new String(bArrA);
    }

    public static void a() {
        if (TextUtils.isEmpty(e) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(e) || TextUtils.isEmpty(d)) {
                d = ZZ050.a(com.zm.fda.ZZ00Z.b(), com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.q, "6UTPhrBGxw2BRSzm");
                e = ZZ050.a(com.zm.fda.ZZ00Z.b(), com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.r, "DoT9*pMgESQ0uRr@");
            }
        }
    }

    public static String b() {
        return ZZ050.a(com.zm.fda.ZZ00Z.b(), com.zm.fda.Z200O.ZZ00Z.h, com.zm.fda.Z200O.ZZ00Z.t, "TT0007");
    }
}
