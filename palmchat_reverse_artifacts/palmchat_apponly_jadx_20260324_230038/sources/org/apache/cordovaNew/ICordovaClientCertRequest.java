package org.apache.cordovaNew;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface ICordovaClientCertRequest {
    void cancel();

    String getHost();

    String[] getKeyTypes();

    int getPort();

    Principal[] getPrincipals();

    void ignore();

    void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr);
}
