package com.baidu.mapsdkplatform.comapi.commonutils.b;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.commonutils.b.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3965a;
    private File b;
    private com.baidu.mapsdkplatform.comapi.commonutils.b.a c;
    private c.InterfaceC0084c d;
    private volatile boolean e = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    public b(String str, File file, com.baidu.mapsdkplatform.comapi.commonutils.b.a aVar, c.InterfaceC0084c interfaceC0084c) {
        this.f3965a = str;
        this.b = file;
        this.c = aVar;
        this.d = interfaceC0084c;
    }

    public boolean a() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d0 A[Catch: IOException -> 0x00cc, TRY_LEAVE, TryCatch #6 {IOException -> 0x00cc, blocks: (B:41:0x00c8, B:45:0x00d0), top: B:57:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.InputStream, java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() throws Throwable {
        RandomAccessFile randomAccessFile;
        HttpURLConnection httpURLConnection;
        ?? inputStream = 0;
        inputStream = 0;
        inputStream = 0;
        try {
            try {
                URL url = new URL(this.f3965a);
                if (HttpClient.isHttpsEnable) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection.setHostnameVerifier(new a());
                    httpURLConnection = httpsURLConnection;
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + this.c.b() + "-" + this.c.a());
                httpURLConnection.setRequestProperty("Connection", HTTP.CONN_KEEP_ALIVE);
                randomAccessFile = new RandomAccessFile(this.b, "rw");
                try {
                    randomAccessFile.seek(this.c.b());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200 || responseCode == 206) {
                        byte[] bArr = new byte[1048576];
                        inputStream = httpURLConnection.getInputStream();
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                randomAccessFile.write(bArr, 0, i);
                            }
                        }
                    }
                    this.e = true;
                    if (inputStream != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception unused) {
                    this.e = false;
                    this.d.b(this);
                    if (inputStream != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        throw th;
                    }
                }
                if (0 != 0) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            if (0 != 0) {
            }
            throw th;
        }
        this.d.a(this);
    }
}
