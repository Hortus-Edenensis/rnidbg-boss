package com.tide.host.a;

import com.ss.android.download.api.constant.BaseConstants;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HostnameVerifier f10788a;

    public static HttpURLConnection a(URL url) throws NoSuchAlgorithmException, KeyManagementException {
        if (!url.getProtocol().equalsIgnoreCase(BaseConstants.SCHEME_HTTPS)) {
            return (HttpURLConnection) url.openConnection();
        }
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[]{new e()}, new SecureRandom());
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        HostnameVerifier defaultHostnameVerifier = f10788a;
        if (defaultHostnameVerifier == null) {
            defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            f10788a = defaultHostnameVerifier;
        }
        httpsURLConnection.setHostnameVerifier(defaultHostnameVerifier);
        return httpsURLConnection;
    }
}
