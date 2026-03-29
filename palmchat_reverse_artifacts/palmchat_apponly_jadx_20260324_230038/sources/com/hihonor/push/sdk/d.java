package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h1 f6442a;
    public static final d b = new d();

    public final void a(Context context) {
        if (f6442a == null) {
            f6442a = new h1(context, "push");
        }
    }

    public synchronized String b(Context context) {
        String str;
        a(context);
        str = "";
        SharedPreferences sharedPreferences = f6442a.f6453a;
        boolean z = true;
        if (sharedPreferences != null && sharedPreferences.contains("key_push_token")) {
            SharedPreferences sharedPreferences2 = f6442a.f6453a;
            if (sharedPreferences2 == null || !sharedPreferences2.contains("key_aes_gcm")) {
                z = false;
            }
            if (z) {
                SharedPreferences sharedPreferences3 = f6442a.f6453a;
                String string = sharedPreferences3 != null ? sharedPreferences3.getString("key_push_token", "") : "";
                SharedPreferences sharedPreferences4 = f6442a.f6453a;
                byte[] bArrDecode = Base64.decode(sharedPreferences4 != null ? sharedPreferences4.getString("key_aes_gcm", "") : "", 0);
                String str2 = "";
                if (!TextUtils.isEmpty(string) && bArrDecode != null && bArrDecode.length >= 16) {
                    try {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDecode, EncryptUtils.AES_ENCRYPT_ALGORITHM);
                        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                        String strSubstring = string.substring(0, 24);
                        String strSubstring2 = string.substring(24);
                        if (!TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strSubstring2)) {
                            cipher.init(2, secretKeySpec, new GCMParameterSpec(128, b.a(strSubstring)));
                            str2 = new String(cipher.doFinal(b.a(strSubstring2)), StandardCharsets.UTF_8);
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    f6442a.a("key_aes_gcm");
                    f6442a.a("key_push_token");
                } else {
                    str = str2;
                }
            } else {
                f6442a.a("key_push_token");
            }
        }
        return str;
    }

    public synchronized void a(Context context, String str) {
        byte[] bArr;
        byte[] bArr2;
        a(context);
        if (TextUtils.isEmpty(str)) {
            f6442a.a("key_push_token");
        } else {
            String strA = b.a(context, context.getPackageName());
            byte[] bArrA = b.a("EA23F5B8C7577CDC744ABD1C6D7E143D5123F8F282BF4E7853C1EC86BD2EDD22");
            byte[] bArrA2 = b.a(strA);
            try {
                bArr = new byte[32];
                new SecureRandom().nextBytes(bArr);
            } catch (Exception unused) {
                bArr = new byte[0];
            }
            String strEncodeToString = Base64.encodeToString(b.a(b.a(b.a(b.a(bArrA, -4), bArrA2), 6), bArr), 0);
            boolean zA = f6442a.a("key_aes_gcm", strEncodeToString);
            byte[] bArrDecode = Base64.decode(strEncodeToString, 0);
            String str2 = "";
            if (!TextUtils.isEmpty(str) && bArrDecode != null && bArrDecode.length >= 16) {
                try {
                    try {
                        bArr2 = new byte[12];
                        new SecureRandom().nextBytes(bArr2);
                    } catch (GeneralSecurityException e) {
                        e.getMessage();
                    }
                } catch (Exception unused2) {
                    bArr2 = new byte[0];
                }
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDecode, EncryptUtils.AES_ENCRYPT_ALGORITHM);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr2));
                byte[] bArrDoFinal = cipher.doFinal(bytes);
                if (bArrDoFinal != null && bArrDoFinal.length != 0) {
                    str2 = b.a(bArr2) + b.a(bArrDoFinal);
                }
            }
            if (zA && !TextUtils.isEmpty(str2)) {
                f6442a.a("key_push_token", str2);
            }
        }
    }
}
