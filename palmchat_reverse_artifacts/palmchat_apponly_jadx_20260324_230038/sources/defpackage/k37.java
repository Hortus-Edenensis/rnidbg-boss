package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class k37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18568a;
    public String b = qh7.g(24);

    public k37(boolean z) {
        this.f18568a = z;
    }

    public static int a(String str) {
        return Integer.parseInt(str);
    }

    public static String d(int i) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i));
    }

    public static byte[] e(String str, String str2) {
        return o77.a(str, str2);
    }

    public static byte[] f(String str, byte[] bArr, String str2) {
        return ta7.b(str, bArr, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] g(byte[]... bArr) throws Throwable {
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        ?? r0 = 0;
        bArr = null;
        byte[] bArr2 = null;
        if (bArr != null) {
            ?? length = bArr.length;
            try {
                if (length != 0) {
                    try {
                        length = new ByteArrayOutputStream();
                        try {
                            dataOutputStream = new DataOutputStream(length);
                            try {
                                for (byte[] bArr3 : bArr) {
                                    dataOutputStream.write(d(bArr3.length).getBytes());
                                    dataOutputStream.write(bArr3);
                                }
                                dataOutputStream.flush();
                                byte[] byteArray = length.toByteArray();
                                try {
                                    length.close();
                                } catch (Exception unused) {
                                }
                                bArr2 = byteArray;
                            } catch (Exception e) {
                                e = e;
                                w97.d(e);
                                if (length != 0) {
                                    try {
                                        length.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                if (dataOutputStream != null) {
                                }
                                return bArr2;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            dataOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            outputStream = null;
                            r0 = length;
                            if (r0 != 0) {
                                try {
                                    r0.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (outputStream != null) {
                                throw th;
                            }
                            try {
                                outputStream.close();
                                throw th;
                            } catch (Exception unused4) {
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        length = 0;
                        dataOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = null;
                        if (r0 != 0) {
                        }
                        if (outputStream != null) {
                        }
                    }
                    try {
                        dataOutputStream.close();
                    } catch (Exception unused5) {
                    }
                    return bArr2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public static byte[] h(String str, byte[] bArr, String str2) {
        return ta7.d(str, bArr, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e07 b(q77 q77Var, String str) {
        ByteArrayInputStream byteArrayInputStream;
        String str2;
        String str3;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(q77Var.a());
            try {
                try {
                    byte[] bArr = new byte[5];
                    byteArrayInputStream.read(bArr);
                    byte[] bArr2 = new byte[a(new String(bArr))];
                    byteArrayInputStream.read(bArr2);
                    str2 = new String(bArr2);
                } catch (Exception e) {
                    e = e;
                    str2 = null;
                }
                try {
                    byte[] bArr3 = new byte[5];
                    byteArrayInputStream.read(bArr3);
                    int iA = a(new String(bArr3));
                    if (iA > 0) {
                        byte[] bArrB = new byte[iA];
                        byteArrayInputStream.read(bArrB);
                        if (this.f18568a) {
                            bArrB = f(this.b, bArrB, str);
                        }
                        if (q77Var.b()) {
                            bArrB = c07.b(bArrB);
                        }
                        str3 = new String(bArrB);
                    } else {
                        str3 = null;
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception e2) {
                    e = e2;
                    w97.d(e);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    str3 = null;
                }
            } catch (Throwable th) {
                th = th;
                byteArrayInputStream2 = byteArrayInputStream;
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayInputStream = null;
            str2 = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayInputStream2 != null) {
            }
            throw th;
        }
        if (str2 == null && str3 == null) {
            return null;
        }
        return new e07(str2, str3);
    }

    public q77 c(e07 e07Var, boolean z, String str) {
        if (e07Var == null) {
            return null;
        }
        byte[] bytes = e07Var.b().getBytes();
        byte[] bytes2 = e07Var.a().getBytes();
        if (z) {
            try {
                bytes2 = c07.a(bytes2);
            } catch (Exception unused) {
                z = false;
            }
        }
        return new q77(z, this.f18568a ? g(bytes, e(this.b, hu6.b), h(this.b, bytes2, str)) : g(bytes, bytes2));
    }
}
