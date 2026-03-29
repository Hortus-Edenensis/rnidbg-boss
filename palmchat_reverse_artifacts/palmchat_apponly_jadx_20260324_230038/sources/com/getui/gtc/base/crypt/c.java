package com.getui.gtc.base.crypt;

import android.content.Context;
import com.getui.gtc.base.util.io.IOUtils;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    KeyPair f5694a;
    private b b;
    private File c;

    public c(Context context, KeyPair keyPair) throws NoSuchAlgorithmException {
        this.c = context.getFilesDir();
        this.f5694a = keyPair;
        if (keyPair == null) {
            this.b = new b(context.getPackageName());
        }
    }

    public final SecretKey a(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        return a(str, true, this.f5694a);
    }

    public final IvParameterSpec b(String str, boolean z, KeyPair keyPair) throws Throwable {
        File file = new File(this.c, str);
        if (file.exists() || !z) {
            try {
                byte[] file2 = IOUtils.readFile(file);
                return new IvParameterSpec((keyPair == null && (keyPair = this.f5694a) == null) ? this.b.b(file2) : CryptTools.decrypt("RSA/ECB/PKCS1Padding", keyPair.getPrivate(), file2));
            } catch (IOException | InvalidAlgorithmParameterException unused) {
                return null;
            }
        }
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        KeyPair keyPair2 = this.f5694a;
        IOUtils.saveToFile(keyPair2 != null ? CryptTools.encrypt("RSA/ECB/PKCS1Padding", keyPair2.getPublic(), bArr) : this.b.a(bArr), new File(this.c, str));
        return new IvParameterSpec(bArr);
    }

    public final SecretKey a(String str, boolean z, KeyPair keyPair) throws Throwable {
        File file = new File(this.c, str);
        if (file.exists() || !z) {
            try {
                byte[] file2 = IOUtils.readFile(file);
                return CryptTools.wrapperKey(EncryptUtils.AES_ENCRYPT_ALGORITHM, (keyPair == null && (keyPair = this.f5694a) == null) ? this.b.b(file2) : CryptTools.decrypt("RSA/ECB/PKCS1Padding", keyPair.getPrivate(), file2));
            } catch (IOException | InvalidAlgorithmParameterException unused) {
                return null;
            }
        }
        SecretKey secretKeyGenerateKey = CryptTools.generateKey(EncryptUtils.AES_ENCRYPT_ALGORITHM, 128);
        byte[] encoded = secretKeyGenerateKey.getEncoded();
        KeyPair keyPair2 = this.f5694a;
        IOUtils.saveToFile(keyPair2 != null ? CryptTools.encrypt("RSA/ECB/PKCS1Padding", keyPair2.getPublic(), encoded) : this.b.a(encoded), new File(this.c, str));
        return secretKeyGenerateKey;
    }
}
