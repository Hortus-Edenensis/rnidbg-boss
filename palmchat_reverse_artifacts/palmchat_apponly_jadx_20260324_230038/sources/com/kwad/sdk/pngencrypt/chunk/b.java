package com.kwad.sdk.pngencrypt.chunk;

import com.oplus.tblplayer.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final byte[] baF = gO("IHDR");
    public static final byte[] baG = gO("PLTE");
    public static final byte[] baH = gO("IDAT");
    public static final byte[] baI = gO("IEND");
    private static byte[] baJ = new byte[4096];
    public static Pattern baK = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static byte[] b(byte[] bArr, int i, int i2, boolean z) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream3;
        InflaterInputStream inflaterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                InflaterInputStream inflaterInputStream2 = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        g(inflaterInputStream2, byteArrayOutputStream2);
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        return byteArray;
                    } catch (Exception unused) {
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream3 = byteArrayOutputStream2;
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream3);
                        return new byte[0];
                    } catch (Throwable th) {
                        th = th;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                    byteArrayOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception unused3) {
                byteArrayOutputStream3 = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            }
        } catch (Exception unused4) {
            byteArrayOutputStream3 = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        }
    }

    public static String c(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.ban);
    }

    public static String d(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.bao);
    }

    private static void g(InputStream inputStream, OutputStream outputStream) {
        synchronized (baJ) {
            while (true) {
                int i = inputStream.read(baJ);
                if (i > 0) {
                    outputStream.write(baJ, 0, i);
                }
            }
        }
    }

    public static byte[] gO(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.ban);
    }

    public static boolean gP(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean gQ(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean gR(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }

    public static String h(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.ban);
    }

    public static String i(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.bao);
    }

    public static String i(byte[] bArr, int i) {
        return (bArr == null || bArr.length < 8) ? Constants.STRING_VALUE_UNSET : c(bArr, 4, 4);
    }
}
