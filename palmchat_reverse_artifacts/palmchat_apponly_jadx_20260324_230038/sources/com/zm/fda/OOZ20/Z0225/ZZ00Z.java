package com.zm.fda.OOZ20.Z0225;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16641a = 1024;

    public static byte[] a(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                a(byteArrayInputStream, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                if (byteArrayInputStream != null) {
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused5) {
                    }
                }
                if (byteArrayInputStream == null) {
                    throw th;
                }
                try {
                    byteArrayInputStream.close();
                    throw th;
                } catch (Exception unused6) {
                    throw th;
                }
            }
        } catch (Exception unused7) {
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
        }
        try {
            byteArrayInputStream.close();
        } catch (Exception unused8) {
        }
        return bArr;
    }

    public static byte[] b(byte[] bArr) {
        byte[] byteArray = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr2 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = gZIPInputStream.read(bArr2, 0, 1024);
                if (i == -1) {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return byteArray;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    bArr = new byte[1024];
                } catch (Exception unused) {
                    gZIPOutputStream2 = gZIPOutputStream;
                    if (gZIPOutputStream2 == null) {
                        return;
                    } else {
                        gZIPOutputStream2.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream2 = gZIPOutputStream;
                    if (gZIPOutputStream2 != null) {
                        try {
                            gZIPOutputStream2.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                return;
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i == -1) {
                break;
            } else {
                gZIPOutputStream.write(bArr, 0, i);
            }
        }
        gZIPOutputStream.finish();
        gZIPOutputStream.close();
        gZIPOutputStream.close();
    }
}
