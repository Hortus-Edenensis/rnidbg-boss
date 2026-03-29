package defpackage;

import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class n05 implements X509TrustManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public X509TrustManager f19405a;

    public n05(String str) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            KeyStore.TrustedCertificateEntry trustedCertificateEntry = new KeyStore.TrustedCertificateEntry(x509Certificate);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setEntry("ca_root", trustedCertificateEntry, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.f19405a = (X509TrustManager) trustManager;
                    return;
                }
            }
        } catch (Throwable th) {
            k63.l("SSLTrustManager", "init trustManager failed, error:" + th);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        k63.a("SSLTrustManager", "checkClientTrusted");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        X509Certificate x509Certificate;
        k63.a("SSLTrustManager", "checkServerTrusted");
        if (x509CertificateArr == null || x509CertificateArr.length == 0 || (x509Certificate = x509CertificateArr[0]) == null) {
            throw new CertificateException("Check Server x509Certificates is empty");
        }
        try {
            x509Certificate.checkValidity();
        } catch (CertificateExpiredException e) {
            k63.l("SSLTrustManager", "checkServerTrusted: CertificateExpiredException:" + e.getLocalizedMessage());
        } catch (CertificateNotYetValidException e2) {
            k63.l("SSLTrustManager", "checkServerTrusted: CertificateNotYetValidException:" + e2.getLocalizedMessage());
        } catch (Throwable th) {
            k63.l("SSLTrustManager", "checkServerTrusted failed, error" + th.getLocalizedMessage());
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        k63.a("SSLTrustManager", "getAcceptedIssuers");
        return this.f19405a.getAcceptedIssuers();
    }
}
