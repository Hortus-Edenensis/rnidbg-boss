package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class un {
    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static String b(File file, String str) {
        if (str == null || str.length() == 0) {
            str = "UTF-8";
        }
        try {
            return new String(a(new FileInputStream(file)), str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean c(String str, String str2, String str3) {
        if (str2 != null && str2.length() != 0) {
            if (str3 == null || str3.length() == 0) {
                str3 = "UTF-8";
            }
            try {
                return d(str, str2.getBytes(str3));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean d(String str, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            v.d("data is empty:" + bArr);
            return false;
        }
        try {
            if (str.startsWith("file://")) {
                str = str.substring(7);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            v.d("FileNotFoundException:" + e.getMessage());
            return false;
        } catch (IOException e2) {
            v.d("IOException:" + e2.getMessage());
            return false;
        }
    }
}
