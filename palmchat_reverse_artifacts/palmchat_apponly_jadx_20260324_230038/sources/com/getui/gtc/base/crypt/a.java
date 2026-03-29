package com.getui.gtc.base.crypt;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import com.zenmen.palmchat.utils.EncryptUtils;
import defpackage.wy6;
import defpackage.xy6;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.crypto.SecretKey;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f5692a = new Object();
    private final Object b = new Object();

    @TargetApi(18)
    private KeyPair a(Context context, String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpecBuild;
        KeyPair keyPairGenerateKeyPair;
        synchronized (this.b) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM, "AndroidKeyStore");
            if (Build.VERSION.SDK_INT >= 23) {
                xy6.a();
                algorithmParameterSpecBuild = wy6.a(str, 3).setBlockModes("ECB").setEncryptionPaddings("PKCS1Padding").setKeySize(1024).build();
            } else {
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 30);
                algorithmParameterSpecBuild = new KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new X500Principal("CN=".concat(String.valueOf(str)))).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            }
            keyPairGenerator.initialize(algorithmParameterSpecBuild);
            keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        }
        return keyPairGenerateKeyPair;
    }

    @TargetApi(18)
    public final KeyPair a(Context context, String str, boolean z) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        synchronized (this.b) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.containsAlias(str) || !z) {
                return new KeyPair(keyStore.getCertificate(str).getPublicKey(), (PrivateKey) keyStore.getKey(str, null));
            }
            return a(context, str);
        }
    }

    @TargetApi(23)
    public final SecretKey a(String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        SecretKey secretKey;
        synchronized (this.f5692a) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            keyStore.containsAlias(str);
            secretKey = (SecretKey) keyStore.getKey(str, null);
        }
        return secretKey;
    }
}
