package com.tencent.turingfd.sdk.ams.ad;

import com.tencent.turingfd.sdk.ams.ad.Bergamot;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Andromeda {
    public static Bergamot a(Bagasse bagasse, URL url, Map<String, String> map) throws Throwable {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setRequestProperty("User-Agent", "Turing");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setRequestMethod(bagasse.c);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(bagasse.e);
                httpURLConnection.setReadTimeout(bagasse.f);
                httpURLConnection.setInstanceFollowRedirects(bagasse.g);
                Bergamot.Cdo cdo = new Bergamot.Cdo();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    if (responseCode != 305) {
                        switch (responseCode) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                cdo.f10662a = responseCode;
                                Bergamot bergamot = new Bergamot(cdo);
                                try {
                                    httpURLConnection.disconnect();
                                    break;
                                } catch (Throwable unused) {
                                }
                                return bergamot;
                        }
                    }
                    cdo.f10662a = responseCode;
                    cdo.d = true;
                    cdo.c = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    Bergamot bergamot2 = new Bergamot(cdo);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                    return bergamot2;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Auriga.a(bufferedInputStream2, byteArrayOutputStream);
                    URL url2 = httpURLConnection.getURL();
                    if (!url.getHost().equals(url2.getHost())) {
                        cdo.d = true;
                        cdo.c = url2.toString();
                    }
                    cdo.b = byteArrayOutputStream.toByteArray();
                    Bergamot bergamot3 = new Bergamot(cdo);
                    Auriga.a(bufferedInputStream2);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                    return bergamot3;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    Auriga.a(bufferedInputStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }
}
