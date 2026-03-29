package defpackage;

import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class gl5 implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            ga7.e("", "verify: certificate is : " + x509Certificate.getSubjectDN().getName());
            h17.a(str, x509Certificate, true);
            c47.b();
            return true;
        } catch (SSLException e) {
            ga7.d("", "SSLException : " + e.getMessage());
            return false;
        }
    }
}
