package com.wifi.adsdk.event;

import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AdEventHttp {
    private static final int MAX_REDIRECTS = 20;
    private static HostnameVerifier mHostnameVerifier;
    private static SSLSocketFactory mSSLSocketFactory;
    protected String mUrl;
    private Map<String, String> mHeaders = new HashMap();
    private int mConnectTimeout = 30000;
    private int mReadTimeout = 90000;

    public AdEventHttp(String str) {
        this.mUrl = str;
    }

    private boolean excuteGetCrossProtocal(String str) throws IOException {
        String protocol = new URL(str).getProtocol();
        if (protocol == null || protocol.length() == 0) {
            throw new IOException("protocol is null");
        }
        HttpURLConnection httpURLConnectionMakeConnection = makeConnection(str);
        httpURLConnectionMakeConnection.connect();
        int responseCode = httpURLConnectionMakeConnection.getResponseCode();
        httpURLConnectionMakeConnection.disconnect();
        return responseCode == 200;
    }

    private static HostnameVerifier getHostnameVerifier() {
        if (mHostnameVerifier == null) {
            mHostnameVerifier = new HostnameVerifier() { // from class: com.wifi.adsdk.event.AdEventHttp.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            };
        }
        return mHostnameVerifier;
    }

    public static SSLSocketFactory getSSLSocketFactory() {
        if (mSSLSocketFactory == null) {
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.wifi.adsdk.event.AdEventHttp.2
                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                }
            }};
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(new KeyManager[0], trustManagerArr, new SecureRandom());
                mSSLSocketFactory = sSLContext.getSocketFactory();
            } catch (Exception unused) {
            }
        }
        return mSSLSocketFactory;
    }

    private static URL handleRedirect(URL url, String str) throws IOException {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if (BaseConstants.SCHEME_HTTPS.equals(protocol) || HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b9, code lost:
    
        throw new java.io.IOException("protocol is null");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpURLConnection makeConnection(String str) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i > 20) {
                throw new ProtocolException("Too many redirects: " + i2);
            }
            String protocol = url.getProtocol();
            if (protocol == null || protocol.length() == 0) {
                break;
            }
            if (protocol.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else if (protocol.equals(BaseConstants.SCHEME_HTTPS)) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setHostnameVerifier(getHostnameVerifier());
                httpsURLConnection.setSSLSocketFactory(getSSLSocketFactory());
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = null;
            }
            if (httpURLConnection == null) {
                throw new IOException("connection is null");
            }
            httpURLConnection.setConnectTimeout(this.mConnectTimeout);
            httpURLConnection.setReadTimeout(this.mReadTimeout);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            for (String str2 : this.mHeaders.keySet()) {
                httpURLConnection.setRequestProperty(str2, this.mHeaders.get(str2));
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                return httpURLConnection;
            }
            String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
            httpURLConnection.disconnect();
            url = handleRedirect(url, headerField);
            i = i2;
        }
    }

    public boolean get() throws IOException {
        return excuteGetCrossProtocal(this.mUrl);
    }

    public void setHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DefaultTrustManager implements X509TrustManager {
        private DefaultTrustManager() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }
    }
}
