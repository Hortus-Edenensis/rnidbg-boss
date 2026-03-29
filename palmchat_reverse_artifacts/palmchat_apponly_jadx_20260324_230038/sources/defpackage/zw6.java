package defpackage;

import android.util.Base64;
import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class zw6 {
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
                return new String(Base64.encodeToString(cipher.doFinal(b(d27.b(str.getBytes()))), 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr.length % 16 == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[((bArr.length / 16) + 1) * 16];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
