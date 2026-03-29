package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.fh;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ay {
    private static final String Code = "Sha256Util";

    public static String Code(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null || !u.B(file)) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    String strCode = Code(fileInputStream);
                    bb.Code((Closeable) fileInputStream);
                    return strCode;
                } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused) {
                    fh.I(Code, "fail to get file sha256");
                    bb.Code((Closeable) fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                bb.Code((Closeable) fileInputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            fileInputStream = null;
        } catch (IOException unused3) {
            fileInputStream = null;
        } catch (NoSuchAlgorithmException unused4) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bb.Code((Closeable) fileInputStream2);
            throw th;
        }
    }

    private static String Code(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(com.huawei.openalliance.ad.constant.x.dW);
        byte[] bArr = new byte[8192];
        boolean z = false;
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                break;
            }
            messageDigest.update(bArr, 0, i);
            z = true;
        }
        if (z) {
            return y.Code(messageDigest.digest());
        }
        return null;
    }

    public static String Code(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(com.huawei.openalliance.ad.constant.x.dW);
            messageDigest.update(str.getBytes("utf-8"));
            return y.Code(messageDigest.digest());
        } catch (IOException | NoSuchAlgorithmException unused) {
            fh.I(Code, "fail to get file sha256");
            return null;
        }
    }

    public static byte[] Code(byte[] bArr) {
        try {
            return MessageDigest.getInstance(com.huawei.openalliance.ad.constant.x.dW).digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            fh.Z(Code, "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
