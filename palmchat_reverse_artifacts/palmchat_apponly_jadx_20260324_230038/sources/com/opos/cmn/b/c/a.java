package com.opos.cmn.b.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GZipTool", "safeClose", e);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0044: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0044 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(InputStream inputStream, OutputStream outputStream) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Exception e;
        Closeable closeable;
        if (inputStream == null || outputStream == null) {
            return false;
        }
        Closeable closeable2 = null;
        try {
            try {
                gZIPInputStream = new GZIPInputStream(inputStream);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = gZIPInputStream.read(bArr);
                        if (-1 == i) {
                            outputStream.flush();
                            a(gZIPInputStream);
                            a(inputStream);
                            a(outputStream);
                            return true;
                        }
                        outputStream.write(bArr, 0, i);
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.opos.cmn.an.f.a.c("GZipTool", "decompress", e);
                    if (gZIPInputStream != null) {
                        a(gZIPInputStream);
                    }
                    a(inputStream);
                    a(outputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                if (closeable2 != null) {
                    a(closeable2);
                }
                a(inputStream);
                a(outputStream);
                throw th;
            }
        } catch (Exception e3) {
            gZIPInputStream = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            if (closeable2 != null) {
            }
            a(inputStream);
            a(outputStream);
            throw th;
        }
    }

    private static boolean a(InputStream inputStream, OutputStream outputStream) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        Exception e;
        byte[] bArr;
        if (inputStream == null || outputStream == null) {
            return false;
        }
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream, false);
            try {
                try {
                    bArr = new byte[4096];
                } catch (Exception e2) {
                    e = e2;
                    com.opos.cmn.an.f.a.c("GZipTool", "compress", e);
                    if (gZIPOutputStream != null) {
                        a(gZIPOutputStream);
                    }
                    a(inputStream);
                    a(outputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream2 = gZIPOutputStream;
            }
        } catch (Exception e3) {
            gZIPOutputStream = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
        }
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                gZIPOutputStream.finish();
                gZIPOutputStream.flush();
                a(gZIPOutputStream);
                a(inputStream);
                a(outputStream);
                return true;
            }
            gZIPOutputStream.write(bArr, 0, i);
            th = th;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                a(gZIPOutputStream2);
            }
            a(inputStream);
            a(outputStream);
            throw th;
        }
    }

    public static byte[] b(byte[] bArr) {
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (b(byteArrayInputStream, byteArrayOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
        }
        return null;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (a(byteArrayInputStream, byteArrayOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
        }
        return null;
    }
}
