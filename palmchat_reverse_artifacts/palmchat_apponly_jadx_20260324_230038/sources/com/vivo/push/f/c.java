package com.vivo.push.f;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.vivo.push.util.t;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PrivateKey f11231a = null;
    private PublicKey b = null;
    private KeyStore c;
    private X500Principal d;
    private Context e;

    public c(Context context) {
        this.e = context;
        a(context);
    }

    private synchronized void a(Context context) {
        try {
            b();
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "init error" + e.getMessage());
        }
    }

    private void b(Context context) {
        try {
            if (context == null) {
                t.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 999);
            KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM, "AndroidKeyStore");
            keyPairGenerator.initialize(keyPairGeneratorSpecBuild);
            keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "generateRSAKeyPairSign error" + e.getMessage());
        }
    }

    private PrivateKey c(Context context) {
        PrivateKey privateKey;
        try {
            privateKey = this.f11231a;
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
        }
        if (privateKey != null) {
            return privateKey;
        }
        if (context == null) {
            t.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        KeyStore.Entry entryD = d(context);
        if (entryD instanceof KeyStore.PrivateKeyEntry) {
            PrivateKey privateKey2 = ((KeyStore.PrivateKeyEntry) entryD).getPrivateKey();
            this.f11231a = privateKey2;
            return privateKey2;
        }
        return null;
    }

    private KeyStore.Entry d(Context context) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException {
        try {
            if (context == null) {
                t.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
            return this.c.getEntry("PushRsaKeyAlias", null);
        } catch (Exception e) {
            b(context);
            KeyStore.Entry entry = this.c.getEntry("PushRsaKeyAlias", null);
            e.printStackTrace();
            t.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            return entry;
        }
    }

    @Override // com.vivo.push.f.a
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || c(this.e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey privateKeyC = c(this.e);
            Signature signature = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);
            signature.initSign(privateKeyC);
            signature.update(bytes);
            String strEncodeToString = Base64.encodeToString(signature.sign(), 2);
            t.d("RsaSecurity", str.hashCode() + " = " + strEncodeToString);
            return strEncodeToString;
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "signClientSDK error" + e.getMessage());
            return null;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.c == null) {
                b();
            }
            return this.c.containsAlias(str);
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.f.a
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "verifyClientSDK error" + e.getMessage());
            return false;
        }
    }

    private void b() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.c = keyStore;
            keyStore.load(null);
            this.d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "initKeyStore error" + e.getMessage());
        }
    }

    @Override // com.vivo.push.f.a
    public final PublicKey a() {
        try {
            PublicKey publicKey = this.b;
            if (publicKey != null) {
                return publicKey;
            }
            KeyStore.Entry entryD = d(this.e);
            if (!(entryD instanceof KeyStore.PrivateKeyEntry)) {
                return null;
            }
            PublicKey publicKey2 = ((KeyStore.PrivateKeyEntry) entryD).getCertificate().getPublicKey();
            this.b = publicKey2;
            return publicKey2;
        } catch (Exception e) {
            e.printStackTrace();
            t.a("RsaSecurity", "getPublicKeySign error" + e.getMessage());
            return null;
        }
    }
}
