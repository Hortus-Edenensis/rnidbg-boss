package defpackage;

import android.os.Build;
import android.util.Base64;
import android.util.Log;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class jd7 {
    public static SecretKey a(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            KeyStore.Entry entry = keyStore.getEntry(str, null);
            SecretKey secretKey = entry != null ? ((KeyStore.SecretKeyEntry) entry).getSecretKey() : null;
            return (secretKey != null || Build.VERSION.SDK_INT < 23) ? secretKey : c(str);
        } catch (Exception e) {
            be7.b("1016", e);
            return null;
        }
    }

    public static byte[] b(String str, String str2, String str3) {
        try {
            byte[] bArrDecode = Base64.decode(str2, 2);
            byte[] bArrDecode2 = Base64.decode(str3, 2);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArrDecode2);
            SecretKey secretKeyA = a(str);
            if (secretKeyA == null) {
                return null;
            }
            cipher.init(2, secretKeyA, gCMParameterSpec);
            return cipher.doFinal(bArrDecode);
        } catch (Exception e) {
            be7.b("1015", e);
            return null;
        } catch (InstantiationError unused) {
            Log.e("IDHelper", "1093");
            return null;
        }
    }

    public static SecretKey c(String str) {
        try {
            Log.e("IDHelper", "generateSecretKey, alias:" + str);
            KeyGenerator keyGenerator = KeyGenerator.getInstance(EncryptUtils.AES_ENCRYPT_ALGORITHM, "AndroidKeyStore");
            xy6.a();
            keyGenerator.init(wy6.a(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
            return keyGenerator.generateKey();
        } catch (Exception e) {
            be7.b("1017", e);
            return null;
        }
    }
}
