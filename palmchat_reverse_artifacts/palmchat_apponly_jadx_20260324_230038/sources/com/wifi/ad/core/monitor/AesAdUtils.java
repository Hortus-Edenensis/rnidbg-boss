package com.wifi.ad.core.monitor;

import android.net.Uri;
import com.wifi.ad.core.utils.SharePreferenceUtils;
import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AesAdUtils {
    private static final String AES_IV;
    private static final String AES_KEY;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static {
        SharePreferenceUtils sharePreferenceUtils = SharePreferenceUtils.INSTANCE;
        AES_KEY = sharePreferenceUtils.getString("ad_js_s1", "em8yiHgRR8hokscn", null);
        AES_IV = sharePreferenceUtils.getString("ad_js_s2", "SDyX5BTewLpLEH6V", null);
    }

    public static String encryptAES(String str) {
        String str2;
        if (str == null || str.length() == 0) {
            return "";
        }
        String str3 = AES_KEY;
        if (str3 == null || str3.length() == 0 || (str2 = AES_IV) == null || str2.length() == 0) {
            return str;
        }
        try {
            String strEncode = Uri.encode(str.trim(), "UTF-8");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return "AES:0:" + toHexString(cipher.doFinal(padString(strEncode).getBytes()));
        } catch (Exception unused) {
            return str;
        }
    }

    private static String padString(String str) {
        int length = str.length() % 16;
        for (int i = 0; i < 16 - length; i++) {
            str = str + ' ';
        }
        return str;
    }

    private static String toHexString(byte[] bArr) {
        return bArr == null ? "" : toHexString(bArr, 0, bArr.length);
    }

    private static String toHexString(byte[] bArr, int i, int i2) {
        char[] cArr = new char[i2 * 2];
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            byte b = bArr[i4];
            int i5 = i3 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i3] = cArr2[(b >>> 4) & 15];
            i3 = i5 + 1;
            cArr[i5] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
