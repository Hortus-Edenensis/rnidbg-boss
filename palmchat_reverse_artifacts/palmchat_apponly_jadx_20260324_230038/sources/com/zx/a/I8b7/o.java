package com.zx.a.I8b7;

import com.ss.android.download.api.constant.BaseConstants;
import com.zx.a.I8b7.n0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class o implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o2 f16837a;

    public o(o2 o2Var) {
        this.f16837a = o2Var;
    }

    @Override // com.zx.a.I8b7.n0
    public t1 a(n0.a aVar) throws IOException {
        j1 j1Var = (j1) aVar;
        q1 q1Var = j1Var.c;
        HttpURLConnection httpURLConnection = j1Var.d;
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(q1Var.d != null);
        httpURLConnection.setConnectTimeout(this.f16837a.f);
        httpURLConnection.setReadTimeout(this.f16837a.g);
        httpURLConnection.setInstanceFollowRedirects(this.f16837a.e);
        this.f16837a.getClass();
        httpURLConnection.setUseCaches(false);
        if (BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(q1Var.f16847a.getProtocol())) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLSocketFactory sSLSocketFactory = this.f16837a.c;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
            HostnameVerifier hostnameVerifier = this.f16837a.d;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }
        }
        Map<String, String> map = q1Var.c;
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                httpURLConnection.setRequestProperty(str, map.get(str));
            }
        }
        httpURLConnection.connect();
        return j1Var.a(q1Var, httpURLConnection);
    }
}
