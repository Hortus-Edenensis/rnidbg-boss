package com.bytedance.sdk.openadsdk.core.l.b;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public HttpURLConnection b;
        public int fx;
        public Map<String, String> nr;
        public InputStream u;

        public u(InputStream inputStream, Map<String, String> map, int i, HttpURLConnection httpURLConnection) {
            this.u = inputStream;
            this.nr = map;
            this.fx = i;
            this.b = httpURLConnection;
        }
    }

    public static HttpURLConnection u(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception unused) {
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? u(httpURLConnection.getHeaderField(HttpHeaders.LOCATION), map) : httpURLConnection;
        } catch (Exception unused2) {
            httpURLConnection2 = httpURLConnection;
            return httpURLConnection2;
        }
    }

    public static Map<String, String> u(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            map.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return map;
    }

    public static u u(String str, List<com.ss.android.socialbase.downloader.model.fx> list) throws IOException {
        int responseCode;
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.model.fx fxVar : list) {
                map.put(fxVar.u(), fxVar.nr());
            }
        }
        HttpURLConnection httpURLConnectionU = u(str, map);
        if (httpURLConnectionU == null || (responseCode = httpURLConnectionU.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> mapU = u(httpURLConnectionU);
        InputStream inputStream = httpURLConnectionU.getInputStream();
        String contentEncoding = httpURLConnectionU.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains(Constants.CP_GZIP)) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new u(inputStream, mapU, responseCode, httpURLConnectionU);
    }
}
