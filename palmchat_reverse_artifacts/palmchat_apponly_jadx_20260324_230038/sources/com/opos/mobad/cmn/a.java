package com.opos.mobad.cmn;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.b;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.m.m;
import com.opos.mobad.model.c.c;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    public static final String a(b bVar, String str, int i) {
        return a(bVar, str, i, 2);
    }

    public static final String b(b bVar, String str, int i) {
        return a(bVar, str, i, null);
    }

    private static final String a(b bVar, String str, int i, Integer num) {
        if (bVar != null) {
            try {
                if (!TextUtils.isEmpty(str) && a(i)) {
                    Context contextB = bVar.b();
                    if (contextB == null) {
                        com.opos.cmn.an.f.a.b("ServerTool", "get fail context");
                        return null;
                    }
                    c cVarA = g.a(bVar, str, i, m.a(), (List<String>) null);
                    if (num != null) {
                        cVarA.a(num.intValue());
                    }
                    byte[] bArrA = com.opos.mobad.model.b.a(contextB).a(bVar, cVarA);
                    if (bArrA == null) {
                        com.opos.cmn.an.f.a.a("ServerTool", "get fail adRequest");
                        return null;
                    }
                    String strA = a(m.a());
                    String strA2 = a(strA, "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALP1X5pm2MA1qewaLswjD7y69Q9TN3ErM2Nb6cKWSLjuot0+oSxixUmZ7Z8rmTJADKHV/pqwQdeDXdvlRkmhWtkCAwEAAQ==");
                    if (TextUtils.isEmpty(strA2)) {
                        com.opos.cmn.an.f.a.a("ServerTool", "get fail asymmetricStr");
                        return null;
                    }
                    String strA3 = a(bArrA, strA);
                    if (TextUtils.isEmpty(strA3)) {
                        com.opos.cmn.an.f.a.a("ServerTool", "get fail symmetricStr");
                        return null;
                    }
                    String str2 = "230413_" + strA2 + "_" + strA3;
                    com.opos.cmn.an.f.a.a("ServerTool", "posType = " + i + "," + str, str2);
                    return str2;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("ServerTool", "", (Throwable) e);
                return null;
            }
        }
        com.opos.cmn.an.f.a.b("ServerTool", "get fail:" + str + "," + i);
        return null;
    }

    private static final byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.opos.cmn.an.b.b.d(str.getBytes(StandardCharsets.UTF_8));
    }

    private static final String a(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance(EncryptUtils.AES_ENCRYPT_ALGORITHM);
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(str.getBytes());
        keyGenerator.init(128, secureRandom);
        return com.opos.cmn.an.b.b.a(keyGenerator.generateKey().getEncoded());
    }

    private static final String a(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(b(str2)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, rSAPublicKey);
        return com.opos.cmn.an.b.b.a(cipher.doFinal(str.getBytes("UTF-8")));
    }

    private static final String a(byte[] bArr, String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(1, new SecretKeySpec(b(str), EncryptUtils.AES_ENCRYPT_ALGORITHM));
            return com.opos.cmn.an.b.b.a(cipher.doFinal(bArr));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ServerTool", "", (Throwable) e);
            return new String(bArr);
        }
    }

    private static final boolean a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }
}
