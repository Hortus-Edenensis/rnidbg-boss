package com.bytedance.sdk.component.fx.nr.u.a;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx {
    public static fx u(X509TrustManager x509TrustManager) {
        return com.bytedance.sdk.component.fx.nr.u.x.pn.nr().u(x509TrustManager);
    }

    public abstract List<Certificate> u(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
