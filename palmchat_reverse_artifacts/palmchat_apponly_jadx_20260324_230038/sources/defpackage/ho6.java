package defpackage;

import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ho6 {
    public static String a(String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str2 != null && str2.length() != 0 && str3 != null && str3.length() != 0) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return vn.a(cipher.doFinal(b(str).getBytes()));
            } catch (Exception e) {
                v.c(e);
            }
        }
        return str;
    }

    public static String b(String str) {
        int length = str.length() % 16;
        for (int i = 0; i < 16 - length; i++) {
            str = str + ' ';
        }
        return str;
    }
}
