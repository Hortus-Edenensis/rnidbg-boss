package com.lantern.auth.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BLMessageDigest {
    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            return BLHexDump.toHexString(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            BLLog.e(e);
            return "";
        } catch (NoSuchAlgorithmException e2) {
            BLLog.e(e2);
            return "";
        }
    }

    public static String md5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return BLHexDump.toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            BLLog.e(e);
            return "";
        }
    }

    public static String md5(File file) throws Throwable {
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[2014];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i);
            }
            String hexString = BLHexDump.toHexString(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                BLLog.e(e2);
            }
            return hexString;
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            BLLog.e(e);
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    BLLog.e(e4);
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    BLLog.e(e5);
                }
            }
            throw th;
        }
    }
}
