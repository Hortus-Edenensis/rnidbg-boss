package com.getui.gtc.a.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = null;
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        byteArrayOutputStream.close();
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return byteArray;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(4:73|3|64|4)|(5:62|5|(1:7)(1:80)|72|39)|8|75|9|58|13|17|72|39|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        r2.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r1.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byte[] byteArray = null;
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
        }
        while (true) {
            try {
                int i = gZIPInputStream.read();
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(i);
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    byteArrayInputStream.close();
                } finally {
                }
            }
            return byteArray;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        gZIPInputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }
}
