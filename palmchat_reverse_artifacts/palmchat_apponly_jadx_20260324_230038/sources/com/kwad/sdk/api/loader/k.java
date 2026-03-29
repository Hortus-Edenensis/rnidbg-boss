package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.core.TLSConnectionUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class k {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(String str, File file) throws Throwable {
        BufferedInputStream bufferedInputStream;
        ?? r1;
        FileOutputStream fileOutputStream;
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (file.exists()) {
                j.j(file);
            }
            FileOutputStream fileOutputStream3 = new FileOutputStream(file, false);
            try {
                HttpURLConnection httpURLConnectionCreateUrlConnection = createUrlConnection(str);
                try {
                    bufferedInputStream = new BufferedInputStream(httpURLConnectionCreateUrlConnection.getInputStream());
                    try {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i == -1) {
                                closeQuietly(fileOutputStream3);
                                closeQuietly(bufferedInputStream);
                                httpURLConnectionCreateUrlConnection.disconnect();
                                return;
                            }
                            fileOutputStream3.write(bArr, 0, i);
                        }
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream3;
                        httpURLConnection = httpURLConnectionCreateUrlConnection;
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        r1 = httpURLConnection;
                        closeQuietly(fileOutputStream2);
                        closeQuietly(bufferedInputStream);
                        if (r1 != 0) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    fileOutputStream = fileOutputStream3;
                    httpURLConnection = httpURLConnectionCreateUrlConnection;
                    th = th2;
                    bufferedInputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                fileOutputStream2 = fileOutputStream3;
                r1 = bufferedInputStream;
                closeQuietly(fileOutputStream2);
                closeQuietly(bufferedInputStream);
                if (r1 != 0) {
                    r1.disconnect();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static HttpURLConnection createUrlConnection(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(120000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        return httpURLConnection;
    }
}
