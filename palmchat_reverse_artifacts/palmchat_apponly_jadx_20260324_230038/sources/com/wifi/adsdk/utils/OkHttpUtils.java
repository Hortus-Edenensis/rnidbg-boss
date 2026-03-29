package com.wifi.adsdk.utils;

import android.os.Build;
import com.wifi.adsdk.utils.VerifierUtils;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class OkHttpUtils {
    private static volatile OkHttpUtils instance;
    private OkHttpClient mOkHttpClient;

    private OkHttpUtils() {
        if (Build.VERSION.SDK_INT >= 29) {
            OkHttpClient.Builder builderNewBuilder = new OkHttpClient().newBuilder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.mOkHttpClient = builderNewBuilder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).sslSocketFactory(VerifierUtils.createSSLSocketFactory(), new X509TrustManager() { // from class: com.wifi.adsdk.utils.OkHttpUtils.1
                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                }
            }).hostnameVerifier(new VerifierUtils.TrustAllHostnameVerifier()).build();
        } else {
            OkHttpClient.Builder builderNewBuilder2 = new OkHttpClient().newBuilder();
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            this.mOkHttpClient = builderNewBuilder2.connectTimeout(30L, timeUnit2).readTimeout(30L, timeUnit2).writeTimeout(30L, timeUnit2).sslSocketFactory(VerifierUtils.createSSLSocketFactory()).hostnameVerifier(new VerifierUtils.TrustAllHostnameVerifier()).build();
        }
    }

    public static OkHttpUtils getInstance() {
        if (instance == null) {
            synchronized (OkHttpUtils.class) {
                if (instance == null) {
                    instance = new OkHttpUtils();
                }
            }
        }
        return instance;
    }

    public OkHttpClient getOkHttpClient() {
        return this.mOkHttpClient;
    }
}
