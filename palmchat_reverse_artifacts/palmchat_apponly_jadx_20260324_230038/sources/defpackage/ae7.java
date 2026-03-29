package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ae7 {
    public static File a(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[PHI: r4
      0x002c: PHI (r4v2 'e' java.lang.Throwable) = (r4v1 'e' java.lang.Throwable), (r4v4 'e' java.lang.Throwable) binds: [B:10:0x002a, B:14:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (FileNotFoundException e) {
            e = e;
            if (k17.k()) {
                e.printStackTrace();
            }
            return null;
        } catch (IOException e2) {
            e = e2;
            if (k17.k()) {
            }
            return null;
        }
    }

    public static File c(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException unused) {
            return null;
        }
    }
}
