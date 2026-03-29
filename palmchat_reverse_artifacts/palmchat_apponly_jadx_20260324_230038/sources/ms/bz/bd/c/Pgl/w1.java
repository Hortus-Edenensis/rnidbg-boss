package ms.bz.bd.c.Pgl;

import com.umeng.analytics.pro.dn;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import ms.bz.bd.c.Pgl.pblx;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class w1 extends pbly {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SSLSocketFactory f19353a;

    @Override // ms.bz.bd.c.Pgl.pbly
    public final Object[] c(String str, String str2, String str3) {
        return h(str, null, null, str3, str2, false);
    }

    @Override // ms.bz.bd.c.Pgl.pbly
    public final Object[] f(String str, String str2, String str3) {
        return h(str, null, str2, str3, null, false);
    }

    @Override // ms.bz.bd.c.Pgl.pbly
    public final Object[] g(String str, byte[] bArr, String str2, String str3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28a066", new byte[]{16, 35, 1, 80, 12, 44, 25, dn.k, 36, 112, 0, 54, 27, 65, 7, 53, 113, 12, 34, 108, 99, 119, 95, 9, 73});
        return h(str, bArr, str2, str3, null, true);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(5:124|3|4|(5:128|6|(3:8|2b|16)|19|(1:21))|25)|(11:129|26|(1:30)|(1:34)|35|(4:37|38|112|39)(1:42)|110|43|44|122|45)|(9:47|126|(1:49)(1:50)|51|(4:52|(1:54)(1:131)|92|93)|55|(1:57)(1:58)|59|60)(1:63)|64|116|65|68|92|93|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x023c, code lost:
    
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "f3ee42", new byte[]{100, 57, 21, 46, 3, 52, 55});
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0289 A[Catch: all -> 0x02e2, TryCatch #0 {all -> 0x02e2, blocks: (B:81:0x0273, B:83:0x0289, B:85:0x02ac), top: B:108:0x0273 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object[] h(String str, byte[] bArr, String str2, String str3, String str4, boolean z) throws Throwable {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        DataOutputStream dataOutputStream;
        BufferedInputStream bufferedInputStream2;
        int responseCode;
        BufferedInputStream bufferedInputStream3;
        byte[] bArr2;
        byte[] byteArray;
        BufferedInputStream bufferedInputStream4;
        OutputStream fileOutputStream;
        byte[] bArr3;
        pblx.pgla pglaVar = new pblx.pgla();
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                try {
                    if (this.f19353a == null) {
                        synchronized (w1.class) {
                            try {
                                if (this.f19353a == null) {
                                    SSLContext sSLContext = SSLContext.getInstance((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1f5c8e", new byte[]{20, 72, 117}));
                                    sSLContext.init(null, null, null);
                                    this.f19353a = sSLContext.getSocketFactory();
                                }
                            } finally {
                            }
                        }
                    }
                    SSLSocketFactory sSLSocketFactory = this.f19353a;
                    if (sSLSocketFactory != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = null;
                    dataOutputStream = dataOutputStream2;
                    bufferedInputStream3 = bufferedInputStream;
                    pbly.d(bufferedInputStream3);
                    pbly.e(dataOutputStream);
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = null;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "93efd1", new byte[]{9, 50, 21, 23, 75, 50}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "887e16", new byte[]{99, 117, dn.l}));
            httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0972ad", new byte[]{2, 52, 74, 72, 91, 112, 39, 17, 105, 108}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8efcc9", new byte[]{2, 98, 16, 7, 17, 15, 55, 77, 33, 54}));
            httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5dffb9", new byte[]{17, 117, 16, 0, 16, 15, 49, 64, 57, 34}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fd1b31", new byte[]{85, ByteCompanionObject.MAX_VALUE, 86, 19, 40, 39, 107, 70, 101, ByteCompanionObject.MAX_VALUE, 90, 85, 113, 50, 39}));
            httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bdc69f", new byte[]{80, 105, 30, 86, 3, ByteCompanionObject.MAX_VALUE, 117, 8, 6, ByteCompanionObject.MAX_VALUE, 99, 99}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "627afe", new byte[]{38, 32, 84, 25, 80, 113, 52, 7, 111, 62, 41, ByteCompanionObject.MAX_VALUE, 75, 22, 77, 119, 33, 94, 117, 37, 53, 53, 69, 24}));
            if (str2 != null && str2.trim().length() > 0) {
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a5e45e", new byte[]{83, 56, 25, 75, 3, 119}), String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cc0a14", new byte[]{97, 100, 80, 6, 7, 44, 110, 75, 101, 108, 55, 114}), str2));
            }
            if (str3 != null && str3.trim().length() > 0) {
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "955c9b", new byte[]{48, 122, 82, 3, 75, 103, Utf8.REPLACEMENT_BYTE, 5, 113, 54, 59, 35, 11, 3, 7, 114}), str3);
            }
            pglaVar.b(str);
            if (z) {
                httpURLConnection.setRequestMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4b6853", new byte[]{21, 79, 118, 120}));
                httpURLConnection.setDoOutput(true);
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    try {
                        dataOutputStream.write(bArr);
                        dataOutputStream.flush();
                    } catch (Exception unused3) {
                        responseCode = -1;
                        bufferedInputStream2 = null;
                        try {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0c1042", new byte[]{50, 105, 65, 123, 3, 52});
                            pglaVar.a(httpURLConnection != null ? httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "930274", new byte[]{48, 124, 87, 82, 69, 47, 53, 21, 104, 102})) : null, responseCode);
                            pbly.d(bufferedInputStream2);
                            pbly.e(dataOutputStream);
                            if (httpURLConnection != null) {
                            }
                            bArr2 = null;
                            return new Object[]{String.valueOf(responseCode), bArr2};
                        } catch (Throwable th3) {
                            th = th3;
                            dataOutputStream2 = dataOutputStream;
                            bufferedInputStream = bufferedInputStream2;
                            dataOutputStream = dataOutputStream2;
                            bufferedInputStream3 = bufferedInputStream;
                            pbly.d(bufferedInputStream3);
                            pbly.e(dataOutputStream);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception unused4) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61115a", new byte[]{52, 59, 65, 122, 2, 103, 103});
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream3 = null;
                    pbly.d(bufferedInputStream3);
                    pbly.e(dataOutputStream);
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } else {
                dataOutputStream = null;
            }
            try {
                responseCode = httpURLConnection.getResponseCode();
            } catch (Exception unused5) {
                bufferedInputStream2 = null;
                responseCode = -1;
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0c1042", new byte[]{50, 105, 65, 123, 3, 52});
                pglaVar.a(httpURLConnection != null ? httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "930274", new byte[]{48, 124, 87, 82, 69, 47, 53, 21, 104, 102})) : null, responseCode);
                pbly.d(bufferedInputStream2);
                pbly.e(dataOutputStream);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused6) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "77f035", new byte[]{53, Base64.padSymbol, 22, 123, 4, 51, 102});
                    }
                }
                bArr2 = null;
                return new Object[]{String.valueOf(responseCode), bArr2};
            }
            try {
                pglaVar.c(httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "58734e", new byte[]{60, 119, 80, 83, 70, 126, 57, 30, 111, 103})), responseCode);
            } catch (Exception unused7) {
                bufferedInputStream2 = null;
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0c1042", new byte[]{50, 105, 65, 123, 3, 52});
                pglaVar.a(httpURLConnection != null ? httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "930274", new byte[]{48, 124, 87, 82, 69, 47, 53, 21, 104, 102})) : null, responseCode);
                pbly.d(bufferedInputStream2);
                pbly.e(dataOutputStream);
                if (httpURLConnection != null) {
                }
                bArr2 = null;
                return new Object[]{String.valueOf(responseCode), bArr2};
            }
        } catch (Exception unused8) {
            dataOutputStream = null;
            bufferedInputStream2 = null;
            responseCode = -1;
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0c1042", new byte[]{50, 105, 65, 123, 3, 52});
            pglaVar.a(httpURLConnection != null ? httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "930274", new byte[]{48, 124, 87, 82, 69, 47, 53, 21, 104, 102})) : null, responseCode);
            pbly.d(bufferedInputStream2);
            pbly.e(dataOutputStream);
            if (httpURLConnection != null) {
            }
            bArr2 = null;
            return new Object[]{String.valueOf(responseCode), bArr2};
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream2 = null;
            bufferedInputStream = null;
            dataOutputStream = dataOutputStream2;
            bufferedInputStream3 = bufferedInputStream;
            pbly.d(bufferedInputStream3);
            pbly.e(dataOutputStream);
            if (httpURLConnection != null) {
            }
            throw th;
        }
        if (responseCode == 200) {
            bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                fileOutputStream = str4 != null ? new FileOutputStream(str4) : new ByteArrayOutputStream();
                bArr3 = new byte[256];
            } catch (Exception unused9) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0c1042", new byte[]{50, 105, 65, 123, 3, 52});
                pglaVar.a(httpURLConnection != null ? httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "930274", new byte[]{48, 124, 87, 82, 69, 47, 53, 21, 104, 102})) : null, responseCode);
                pbly.d(bufferedInputStream2);
                pbly.e(dataOutputStream);
                if (httpURLConnection != null) {
                }
                bArr2 = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream3 = bufferedInputStream2;
                pbly.d(bufferedInputStream3);
                pbly.e(dataOutputStream);
                if (httpURLConnection != null) {
                }
                throw th;
            }
            while (true) {
                int i = bufferedInputStream2.read(bArr3);
                if (i <= 0) {
                    break;
                }
                fileOutputStream.write(bArr3, 0, i);
                return new Object[]{String.valueOf(responseCode), bArr2};
            }
            fileOutputStream.flush();
            byteArray = fileOutputStream instanceof ByteArrayOutputStream ? ((ByteArrayOutputStream) fileOutputStream).toByteArray() : null;
            fileOutputStream.close();
            bufferedInputStream4 = bufferedInputStream2;
        } else {
            byteArray = null;
            bufferedInputStream4 = null;
        }
        pbly.d(bufferedInputStream4);
        pbly.e(dataOutputStream);
        httpURLConnection.disconnect();
        bArr2 = byteArray;
        return new Object[]{String.valueOf(responseCode), bArr2};
    }
}
