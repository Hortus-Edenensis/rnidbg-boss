package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static boolean u = false;

    private static PublicKey u() throws Exception {
        return KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    public static boolean u(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(u().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    public static boolean u(final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String hostAddress;
                    try {
                        hostAddress = InetAddress.getByName(str).getHostAddress();
                    } catch (Exception unused) {
                        hostAddress = "";
                    }
                    if (hostAddress.equals("127.0.0.1") || hostAddress.equals("::1")) {
                        boolean unused2 = b.u = true;
                    }
                }
            });
        } catch (UnsatisfiedLinkError unused) {
        }
        return u;
    }
}
