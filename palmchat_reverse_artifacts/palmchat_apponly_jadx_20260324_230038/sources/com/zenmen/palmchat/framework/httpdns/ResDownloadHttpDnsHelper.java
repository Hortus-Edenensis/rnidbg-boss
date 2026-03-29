package com.zenmen.palmchat.framework.httpdns;

import android.util.Pair;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.b13;
import defpackage.it0;
import defpackage.te1;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ResDownloadHttpDnsHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13977a;

    /* JADX INFO: compiled from: SearchBox */
    public static class ResIOException extends IOException {
        public int code;

        public ResIOException(String str, int i) {
            super(str);
            this.code = i;
        }
    }

    public ResDownloadHttpDnsHelper(int i) {
        this.f13977a = i;
    }

    public final HttpURLConnection a(String str, Map<String, String> map) throws IOException {
        LogUtil.i("ResDownloadHttpDnsHelper", "createConnection start " + str + " additionalHeaders=" + az2.c(map));
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(this.f13977a);
        httpURLConnection.setReadTimeout(this.f13977a);
        if (map != null) {
            for (String str2 : map.keySet()) {
                httpURLConnection.addRequestProperty(str2, map.get(str2));
            }
        }
        b13.a(httpURLConnection);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            HttpsHelper.getmInstance();
            httpsURLConnection.setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
            httpsURLConnection.setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
        }
        httpURLConnection.connect();
        LogUtil.i("ResDownloadHttpDnsHelper", "createConnection end " + str + " additionalHeaders=" + az2.c(map));
        return httpURLConnection;
    }

    public final HttpURLConnection b(String str, Map<String, String> map, Map<String, String> map2) throws IOException {
        LogUtil.i("ResDownloadHttpDnsHelper", "doGetStreamFromNetwork start " + str + " additionalHeaders=" + az2.c(map));
        HashMap map3 = new HashMap();
        if (map != null) {
            map3.putAll(map);
        }
        if (map2 != null) {
            map3.putAll(map2);
        }
        HttpURLConnection httpURLConnectionA = a(str, map3);
        int i = 0;
        while (httpURLConnectionA.getResponseCode() / 100 == 3) {
            if (i >= 3) {
                throw new IOException("too many redirect! url=" + str);
            }
            String headerField = httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION);
            httpURLConnectionA.disconnect();
            httpURLConnectionA = c(headerField, map, true);
            i++;
        }
        int responseCode = httpURLConnectionA.getResponseCode();
        LogUtil.i("ResDownloadHttpDnsHelper", "doGetStreamFromNetwork end " + str + " additionalHeaders=" + az2.c(map) + "resCode=" + responseCode);
        if (responseCode == 200) {
            return httpURLConnectionA;
        }
        throw new ResIOException("request failed with response code " + responseCode, responseCode);
    }

    public HttpURLConnection c(String str, Map<String, String> map, boolean z) throws IOException {
        LogUtil.i("ResDownloadHttpDnsHelper", "loadDataWithRedirects start url =" + str + " redirect=" + z);
        Pair<te1, DNSNode> pairL = it0.k().l(str);
        if (pairL != null) {
            String strQ = it0.q(str.toString(), (te1) pairL.first, (DNSNode) pairL.second);
            HashMap map2 = new HashMap();
            map2.put("Host", ((te1) pairL.first).f20971a);
            try {
                LogUtil.i("ResDownloadHttpDnsHelper", "loadDataWithRedirects doGetStreamFromNetwork ip start ");
                return b(strQ, map, map2);
            } catch (ResIOException e) {
                if (e.code >= 404) {
                    throw e;
                }
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        LogUtil.i("ResDownloadHttpDnsHelper", "loadDataWithRedirects doGetStreamFromNetwork url start ");
        return b(str, map, null);
    }

    public ResDownloadHttpDnsHelper() {
        this(10000);
    }
}
