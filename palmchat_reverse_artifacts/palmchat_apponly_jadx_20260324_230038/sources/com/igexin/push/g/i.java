package com.igexin.push.g;

import androidx.media3.common.MimeTypes;
import com.huawei.openalliance.ad.constant.bi;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f7365a;
    String b;
    File c;
    private byte[] d;

    private i(File file) {
        this.c = file;
    }

    private static String a(byte[] bArr) {
        Object obj = null;
        if (bArr != null && bArr.length >= 10) {
            byte b = bArr[0];
            if (b == 71 && bArr[1] == 73 && bArr[2] == 70) {
                obj = "GIF";
            } else {
                byte b2 = bArr[1];
                if (b2 == 80 && bArr[2] == 78 && bArr[3] == 71) {
                    obj = "PNG";
                } else if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
                    obj = "JPG";
                } else if (b == 66 && b2 == 77) {
                    obj = "BMP";
                }
            }
        }
        return "JPG".equals(obj) ? "image/jpeg" : "GIF".equals(obj) ? bi.B : "PNG".equals(obj) ? "image/png" : "BMP".equals(obj) ? MimeTypes.IMAGE_BMP : "application/octet-stream";
    }

    private String b() {
        File file;
        if (this.f7365a == null && (file = this.c) != null && file.exists()) {
            this.f7365a = this.c.getName();
        }
        return this.f7365a;
    }

    private String c() throws Throwable {
        if (this.b == null) {
            byte[] bArrA = a();
            Object obj = null;
            if (bArrA != null && bArrA.length >= 10) {
                byte b = bArrA[0];
                if (b == 71 && bArrA[1] == 73 && bArrA[2] == 70) {
                    obj = "GIF";
                } else {
                    byte b2 = bArrA[1];
                    if (b2 == 80 && bArrA[2] == 78 && bArrA[3] == 71) {
                        obj = "PNG";
                    } else if (bArrA[6] == 74 && bArrA[7] == 70 && bArrA[8] == 73 && bArrA[9] == 70) {
                        obj = "JPG";
                    } else if (b == 66 && b2 == 77) {
                        obj = "BMP";
                    }
                }
            }
            this.b = "JPG".equals(obj) ? "image/jpeg" : "GIF".equals(obj) ? bi.B : "PNG".equals(obj) ? "image/png" : "BMP".equals(obj) ? MimeTypes.IMAGE_BMP : "application/octet-stream";
        }
        return this.b;
    }

    private i(String str) {
        this(new File(str));
    }

    private static String b(byte[] bArr) {
        if (bArr != null && bArr.length >= 10) {
            byte b = bArr[0];
            if (b == 71 && bArr[1] == 73 && bArr[2] == 70) {
                return "GIF";
            }
            byte b2 = bArr[1];
            if (b2 == 80 && bArr[2] == 78 && bArr[3] == 71) {
                return "PNG";
            }
            if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
                return "JPG";
            }
            if (b == 66 && b2 == 77) {
                return "BMP";
            }
        }
        return null;
    }

    public final byte[] a() throws Throwable {
        File file;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        if (this.d == null && (file = this.c) != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(this.c);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i = fileInputStream.read();
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(i);
                        } catch (Throwable th2) {
                            th = th2;
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    }
                    this.d = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                fileInputStream = null;
            }
        }
        return this.d;
    }

    private i(String str, byte[] bArr) {
        this.f7365a = str;
        this.d = bArr;
    }

    private i(String str, byte[] bArr, String str2) {
        this(str, bArr);
        this.b = str2;
    }

    private i(byte[] bArr) {
        this.d = bArr;
    }
}
