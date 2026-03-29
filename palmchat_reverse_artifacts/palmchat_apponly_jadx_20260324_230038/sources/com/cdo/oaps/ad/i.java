package com.cdo.oaps.ad;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class i {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return a(f.d(new c().b(b(str), h.a(h.a("7U727ALEWH8".getBytes())))));
    }

    private static byte[] b(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            try {
                return str.getBytes("UTF-8");
            } catch (IOException unused) {
                return new byte[0];
            }
        } catch (UnsupportedEncodingException unused2) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeUTF(str);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            dataOutputStream.close();
            int length = byteArray.length - 2;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 2, bArr, 0, length);
            return bArr;
        }
    }

    private static String a(byte[] bArr) {
        return bArr == null ? "" : a(bArr, 0, bArr.length);
    }

    private static String a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }
}
