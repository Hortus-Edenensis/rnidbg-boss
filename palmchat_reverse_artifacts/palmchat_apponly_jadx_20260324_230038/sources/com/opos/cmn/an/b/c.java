package com.opos.cmn.an.b;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static String a(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        MessageDigest messageDigest;
        int i;
        String str = "";
        if (file != null && file.isFile() && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bArr = new byte[4096];
                    messageDigest = MessageDigest.getInstance("MD5");
                } finally {
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("Md5Tool", "md5File", e);
            }
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (-1 == i2) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
                com.opos.cmn.an.f.a.c("Md5Tool", "md5File", e);
            }
            for (byte b : messageDigest.digest()) {
                String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str = str + hexString;
            }
            fileInputStream.close();
        }
        return str;
    }

    public static String b(String str) {
        return !com.opos.cmn.an.d.b.a(str) ? a(new File(str)) : "";
    }

    public static String a(String str) {
        return !com.opos.cmn.an.d.b.a(str) ? a(str.getBytes()) : "";
    }

    public static String a(byte[] bArr) {
        String str = "";
        if (bArr != null) {
            try {
                for (byte b : MessageDigest.getInstance("MD5").digest(bArr)) {
                    String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str = str + hexString;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("Md5Tool", "md5", e);
            }
        }
        return str;
    }
}
