package com.bytedance.sdk.openadsdk.core.o;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static String fx = "OutProcessEncryptUtils";
    private static volatile nr nr = null;
    static String u = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALo9WqslO45/EjPWz6YMAu8PBgzV9Ujk3TSQSgebYdNPLJ2u0Y69eSj5DRk7uVplC+WkdEJGznST4OXTRZyKI9ECAwEAAQ==";
    private PublicKey b = null;
    private b pn;

    private nr() {
    }

    private b b(Context context) {
        b bVar = new b();
        bVar.u = fx.u();
        bVar.nr = fx.u();
        String str = bVar.u + "#" + bVar.nr;
        for (int i = 2; i >= 0; i--) {
            byte[] bArrU = u(context, str);
            if (bArrU != null && bArrU.length > 0) {
                bVar.fx = Base64.encodeToString(bArrU, 2);
            }
            if (!TextUtils.isEmpty(bVar.fx)) {
                break;
            }
        }
        return bVar;
    }

    private PublicKey fx(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(u, 2)));
    }

    private PublicKey nr(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (this.b == null) {
            this.b = fx(context);
        }
        return this.b;
    }

    public static nr u() {
        if (nr == null) {
            synchronized (nr.class) {
                if (nr == null) {
                    nr = new nr();
                }
            }
        }
        return nr;
    }

    private byte[] u(PublicKey publicKey, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    public b u(Context context) {
        b bVarB;
        b bVar = this.pn;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            bVarB = b(context);
            this.pn = bVarB;
        }
        return bVarB;
    }

    private byte[] u(Context context, String str) {
        try {
            return u(nr(context), str.getBytes());
        } catch (Exception unused) {
            return null;
        }
    }
}
