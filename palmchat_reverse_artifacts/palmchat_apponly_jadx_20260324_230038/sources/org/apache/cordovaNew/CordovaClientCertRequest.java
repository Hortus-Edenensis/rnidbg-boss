package org.apache.cordovaNew;

import android.annotation.SuppressLint;
import android.webkit.ClientCertRequest;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaClientCertRequest implements ICordovaClientCertRequest {
    private final ClientCertRequest request;

    public CordovaClientCertRequest(ClientCertRequest clientCertRequest) {
        this.request = clientCertRequest;
    }

    @Override // org.apache.cordovaNew.ICordovaClientCertRequest
    @SuppressLint({"NewApi"})
    public void cancel() {
        this.request.cancel();
    }

    @Override // org.apache.cordovaNew.ICordovaClientCertRequest
    @SuppressLint({"NewApi"})
    public String getHost() {
        return this.request.getHost();
    }

    @Override // org.apache.cordovaNew.ICordovaClientCertRequest
    @SuppressLint({"NewApi"})
    public String[] getKeyTypes() {
        return this.request.getKeyTypes();
    }

    @Override // org.apache.cordovaNew.ICordovaClientCertRequest
    @SuppressLint({"NewApi"})
    public int getPort() {
        return this.request.getPort();
    }

    @Override // org.apache.cordovaNew.ICordovaClientCertRequest
    @SuppressLint({"NewApi"})
    public Principal[] getPrincipals() {
        return this.request.getPrincipals();
    }

    @Override // org.apache.cordovaNew.ICordovaClientCertRequest
    @SuppressLint({"NewApi"})
    public void ignore() {
        this.request.ignore();
    }

    @Override // org.apache.cordovaNew.ICordovaClientCertRequest
    @SuppressLint({"NewApi"})
    public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
        this.request.proceed(privateKey, x509CertificateArr);
    }
}
