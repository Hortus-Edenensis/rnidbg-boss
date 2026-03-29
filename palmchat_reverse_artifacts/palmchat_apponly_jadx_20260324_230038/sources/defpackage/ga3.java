package defpackage;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ga3 {
    public static void a(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        } else if (file.exists() && file.isDirectory()) {
            c(file);
            file.delete();
        }
    }

    public static void b(String str) {
        a(new File(str));
    }

    public static void c(File file) {
        File[] fileArrListFiles;
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                b(file2.getAbsolutePath());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static boolean d(File file) throws Throwable {
        FileInputStream fileInputStream;
        if (file == null) {
            return false;
        }
        ?? r1 = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            r1 = -1;
        } catch (IOException e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            pu1.u(fileInputStream2);
            r1 = fileInputStream2;
        } catch (Throwable th2) {
            th = th2;
            r1 = fileInputStream;
            pu1.u(r1);
            throw th;
        }
        if (fileInputStream.read() != -1) {
            pu1.u(fileInputStream);
            return true;
        }
        pu1.u(fileInputStream);
        return false;
    }

    public static byte[] e(InputStream inputStream) throws IOException {
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

    public static String f(File file, String str) {
        if (str == null || str.length() == 0) {
            str = "UTF-8";
        }
        try {
            return new String(e(new FileInputStream(file)), str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean g(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str3 == null || str3.length() == 0) {
            str3 = "UTF-8";
        }
        try {
            return h(str, str2.getBytes(str3));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean h(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream;
        if (bArr == null || bArr.length == 0) {
            ma3.d("data is empty:" + bArr);
            return false;
        }
        if (str == null || str.length() == 0) {
            ma3.d("file is invalid:" + str);
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (str.startsWith("file://")) {
                    str = str.substring(7);
                }
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            fileOutputStream.write(bArr);
            pu1.u(fileOutputStream);
            return true;
        } catch (FileNotFoundException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            ma3.d("FileNotFoundException:" + e.getMessage());
            pu1.u(fileOutputStream2);
            return false;
        } catch (IOException e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            ma3.d("IOException:" + e.getMessage());
            pu1.u(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            pu1.u(fileOutputStream2);
            throw th;
        }
    }
}
