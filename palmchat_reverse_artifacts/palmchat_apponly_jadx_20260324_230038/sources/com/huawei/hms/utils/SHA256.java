package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class SHA256 {
    public static byte[] digest(byte[] bArr) {
        try {
            return MessageDigest.getInstance(x.dW).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            HMSLog.e("SHA256", "NoSuchAlgorithmException" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] digest(File file) throws Throwable {
        BufferedInputStream bufferedInputStream;
        MessageDigest messageDigest;
        byte[] bArr;
        int i;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance(x.dW);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (IOException | NoSuchAlgorithmException unused) {
            }
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = bufferedInputStream2;
        }
        try {
            bArr = new byte[4096];
            i = 0;
        } catch (IOException | NoSuchAlgorithmException unused2) {
            bufferedInputStream2 = bufferedInputStream;
            HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
            IOUtils.closeQuietly((InputStream) bufferedInputStream2);
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((InputStream) bufferedInputStream);
            throw th;
        }
        while (true) {
            int i2 = bufferedInputStream.read(bArr);
            if (i2 == -1) {
                break;
            }
            i += i2;
            messageDigest.update(bArr, 0, i2);
            return new byte[0];
        }
        if (i > 0) {
            byte[] bArrDigest = messageDigest.digest();
            IOUtils.closeQuietly((InputStream) bufferedInputStream);
            return bArrDigest;
        }
        IOUtils.closeQuietly((InputStream) bufferedInputStream);
        return new byte[0];
    }
}
