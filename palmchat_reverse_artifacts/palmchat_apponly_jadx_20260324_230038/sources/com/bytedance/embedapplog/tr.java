package com.bytedance.embedapplog;

import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class tr {
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] u(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                if (u.n()) {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes("UTF-8"));
                        gZIPOutputStream = gZIPOutputStream2;
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        try {
                            ti.nr(th);
                            if (gZIPOutputStream != null) {
                                gZIPOutputStream.close();
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!u.n()) {
                            }
                        } catch (Throwable th2) {
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e) {
                                    ti.nr(e);
                                }
                            }
                            throw th2;
                        }
                    }
                } else {
                    byteArrayOutputStream.write(str.getBytes("UTF-8"));
                }
            } catch (IOException e2) {
                ti.nr(e2);
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (gZIPOutputStream != null) {
            gZIPOutputStream.close();
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        return !u.n() ? TTEncryptUtils.a(byteArray2, byteArray2.length) : byteArray2;
    }
}
