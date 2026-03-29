package com.zenmen.palmchat.utils;

import android.util.Log;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jivesoftware.smack.util.Base64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class HttpsHelper {
    public static final HostnameVerifier DO_NOT_VERIFY = new c();
    private static HttpsHelper mInstance;
    private static SSLSocketFactory mSSLSocketFactory;
    private static SSLSocketFactory mSSLSocketFactoryRed;
    private static SSLContext sslContext;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements X509TrustManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ X509Certificate[][] f15690a;

        public b(X509Certificate[][] x509CertificateArr) {
            this.f15690a = x509CertificateArr;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            LogUtil.i("Longer", "checkClientTrusted =" + x509CertificateArr);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            LogUtil.i("Longer", "checkServerTrusted =" + x509CertificateArr);
            try {
                X509Certificate[][] x509CertificateArr2 = this.f15690a;
                int length = x509CertificateArr2.length;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    X509Certificate[] x509CertificateArr3 = x509CertificateArr2[i];
                    if (x509CertificateArr[0].getSubjectDN().getName().equals(x509CertificateArr3[0].getSubjectDN().getName())) {
                        x509CertificateArr[0].checkValidity();
                        z = true;
                        x509CertificateArr[0].verify(x509CertificateArr3[1].getPublicKey());
                        break;
                    }
                    i++;
                }
                if (z) {
                } else {
                    throw new CertificateException();
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.e("Longer", "checkServerTrusted error=" + e);
                throw new CertificateException("verify failed" + e.toString());
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            Log.i("Longer", "getAcceptedIssuers =");
            return new X509Certificate[0];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends SSLSocketFactory {
        public static final String[] b = {"TLSv1.1", "TLSv1.2"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SSLSocketFactory f15691a;

        public d(SSLSocketFactory sSLSocketFactory) {
            this.f15691a = sSLSocketFactory;
        }

        public final Socket a(Socket socket) {
            if (socket instanceof SSLSocket) {
                ((SSLSocket) socket).setEnabledProtocols(b);
            }
            return socket;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
            return a(this.f15691a.createSocket(socket, str, i, z));
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return this.f15691a.getDefaultCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return this.f15691a.getSupportedCipherSuites();
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i) throws IOException {
            return a(this.f15691a.createSocket(str, i));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
            return a(this.f15691a.createSocket(str, i, inetAddress, i2));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            return a(this.f15691a.createSocket(inetAddress, i));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            return a(this.f15691a.createSocket(inetAddress, i, inetAddress2, i2));
        }
    }

    private HttpsHelper() {
        SSLContext sSLContextSslContextForTrustedCertificates = sslContextForTrustedCertificates();
        sslContext = sSLContextSslContextForTrustedCertificates;
        mSSLSocketFactory = sSLContextSslContextForTrustedCertificates.getSocketFactory();
    }

    public static byte[] getBytes(char[] cArr) {
        Charset charsetForName = Charset.forName("UTF-8");
        CharBuffer charBufferAllocate = CharBuffer.allocate(cArr.length);
        charBufferAllocate.put(cArr);
        charBufferAllocate.flip();
        return charsetForName.encode(charBufferAllocate).array();
    }

    private X509Certificate[][] getX509Certificates() {
        List<byte[][]> certificateArray2 = getCertificateArray2();
        X509Certificate[][] x509CertificateArr = new X509Certificate[certificateArray2.size()][];
        for (int i = 0; i < certificateArray2.size(); i++) {
            byte[][] bArr = certificateArray2.get(i);
            X509Certificate[] x509CertificateArr2 = new X509Certificate[bArr.length];
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr[i2]);
                    x509CertificateArr2[i2] = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                    byteArrayInputStream.close();
                }
                x509CertificateArr[i] = x509CertificateArr2;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CertificateException e2) {
                e2.printStackTrace();
            }
        }
        return x509CertificateArr;
    }

    public static HttpsHelper getmInstance() {
        if (mInstance == null) {
            mInstance = new HttpsHelper();
        }
        return mInstance;
    }

    public static SSLSocketFactory getmSSLSocketFactory() {
        return mSSLSocketFactory;
    }

    public static void setHttpsSSLAllow() {
        HttpsURLConnection.setDefaultSSLSocketFactory(mSSLSocketFactory);
        HttpsURLConnection.setDefaultHostnameVerifier(DO_NOT_VERIFY);
        LogUtil.i("zxHostName: ", "setHttpsSSLAllow");
        writeHostName();
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002f: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:48), block:B:19:0x002f */
    public static SSLContext sslContextForTrustedCertificates() {
        SSLContext sSLContext;
        NoSuchAlgorithmException e;
        KeyManagementException e2;
        SSLContext sSLContext2;
        try {
            try {
                sSLContext = SSLContext.getInstance("TLS");
            } catch (Throwable unused) {
                return sSLContext2;
            }
        } catch (KeyManagementException e3) {
            sSLContext = null;
            e2 = e3;
        } catch (NoSuchAlgorithmException e4) {
            sSLContext = null;
            e = e4;
        } catch (Throwable unused2) {
            return null;
        }
        try {
            sSLContext.init(null, new TrustManager[]{new a()}, new SecureRandom());
            return sSLContext;
        } catch (KeyManagementException e5) {
            e2 = e5;
            e2.printStackTrace();
            return sSLContext;
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            e.printStackTrace();
            return sSLContext;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0031: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:50), block:B:19:0x0031 */
    private SSLContext sslContextForTrustedCertificatesRed() {
        SSLContext sSLContext;
        NoSuchAlgorithmException e;
        KeyManagementException e2;
        SSLContext sSLContext2;
        try {
            try {
                X509Certificate[][] x509Certificates = getX509Certificates();
                sSLContext = SSLContext.getInstance("TLS");
                try {
                    sSLContext.init(null, new TrustManager[]{new b(x509Certificates)}, new SecureRandom());
                    return sSLContext;
                } catch (KeyManagementException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return sSLContext;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    e.printStackTrace();
                    return sSLContext;
                }
            } catch (Throwable unused) {
                return sSLContext2;
            }
        } catch (KeyManagementException e5) {
            sSLContext = null;
            e2 = e5;
        } catch (NoSuchAlgorithmException e6) {
            sSLContext = null;
            e = e6;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void writeHostName() {
        LogUtil.i("zxHostName: ", "SSLSocket " + HttpsURLConnection.getDefaultSSLSocketFactory().toString());
        LogUtil.i("zxHostName: ", "hostname: " + HttpsURLConnection.getDefaultHostnameVerifier().toString());
    }

    public native List<byte[][]> getCertificateArray();

    public List<byte[][]> getCertificateArray2() {
        ArrayList arrayList = new ArrayList();
        byte[][] bArr = {Base64.decode("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"), Base64.decode("MIIErjCCA5agAwIBAgIQBYAmfwbylVM0jhwYWl7uLjANBgkqhkiG9w0BAQsFADBhMQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3d3cuZGlnaWNlcnQuY29tMSAwHgYDVQQDExdEaWdpQ2VydCBHbG9iYWwgUm9vdCBDQTAeFw0xNzEyMDgxMjI4MjZaFw0yNzEyMDgxMjI4MjZaMHIxCzAJBgNVBAYTAkNOMSUwIwYDVQQKExxUcnVzdEFzaWEgVGVjaG5vbG9naWVzLCBJbmMuMR0wGwYDVQQLExREb21haW4gVmFsaWRhdGVkIFNTTDEdMBsGA1UEAxMUVHJ1c3RBc2lhIFRMUyBSU0EgQ0EwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCgWa9X+ph+wAm8Yh1Fk1MjKbQ5QwBOOKVaZR/OfCh+F6f93u7vZHGcUU/lvVGgUQnbzJhR1UV2epJae+m7cxnXIKdD0/VS9btAgwJszGFvwoqXeaCqFoP71wPmXjjUwLT70+qvX4hdyYfOJcjeTz5QKtg8zQwxaK9x4JT9CoOmoVdVhEBAiD3DwR5fFgOHDwwGxdJWVBvktnoAzjdTLXDdbSVC5jZ0u8oq9BiTDv7jAlsB5F8aZgvSZDOQeFrwaOTbKWSEInEhnchKZTD1dz6aBlk1xGEI5PZWAnVAba/ofH33ktymaTDsE6xRDnW97pDkimCRak6CEbfe3dXw6OV5AgMBAAGjggFPMIIBSzAdBgNVHQ4EFgQUf9OZ86BHDjEAVlYijrfMnt3KAYowHwYDVR0jBBgwFoAUA95QNVbRTLtm8KPiGxvDl7I90VUwDgYDVR0PAQH/BAQDAgGGMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjASBgNVHRMBAf8ECDAGAQH/AgEAMDQGCCsGAQUFBwEBBCgwJjAkBggrBgEFBQcwAYYYaHR0cDovL29jc3AuZGlnaWNlcnQuY29tMEIGA1UdHwQ7MDkwN6A1oDOGMWh0dHA6Ly9jcmwzLmRpZ2ljZXJ0LmNvbS9EaWdpQ2VydEdsb2JhbFJvb3RDQS5jcmwwTAYDVR0gBEUwQzA3BglghkgBhv1sAQIwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cuZGlnaWNlcnQuY29tL0NQUzAIBgZngQwBAgEwDQYJKoZIhvcNAQELBQADggEBAK3dVOj5dlv4MzK2i233lDYvyJ3slFY2X2HKTYGte8nbK6i5/fsDImMYihAkp6VaNY/en8WZ5qcrQPVLuJrJDSXT04NnMeZOQDUoj/NHAmdfCBB/h1bZ5OGK6Sf1h5Yx/5wR4f3TUoPgGlnU7EuPISLNdMRiDrXntcImDAiRvkh5GJuH4YCVE6XEntqaNIgGkRwxKSgnU3Id3iuFbW9FUQ9Qqtb1GX91AJ7i4153TikGgYCdwYkBURD8gSVe8OAco6IfZOYt/TEwii1Ivi1CqnuUlWpsF1LdQNIdfbW3TSe0BhQa7ifbVIfvPWHYOu3rkg1ZeMo6XRU9B4n5VyJYRmE="), Base64.decode("MIIDrzCCApegAwIBAgIQCDvgVpBCRrGhdWrJWZHHSjANBgkqhkiG9w0BAQUFADBhMQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3d3cuZGlnaWNlcnQuY29tMSAwHgYDVQQDExdEaWdpQ2VydCBHbG9iYWwgUm9vdCBDQTAeFw0wNjExMTAwMDAwMDBaFw0zMTExMTAwMDAwMDBaMGExCzAJBgNVBAYTAlVTMRUwEwYDVQQKEwxEaWdpQ2VydCBJbmMxGTAXBgNVBAsTEHd3dy5kaWdpY2VydC5jb20xIDAeBgNVBAMTF0RpZ2lDZXJ0IEdsb2JhbCBSb290IENBMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4jvhEXLeqKTTo1eqUKKPC3eQyaKl7hLOllsBCSDMAZOnTjC3U/dDxGkAV53ijSLdhwZAAIEJzs4bg7/fzTtxRuLWZscFs3YnFo97nh6Vfe63SKMI2tavegw5BmV/Sl0fvBf4q77uKNd0f3p4mVmFaG5cIzJLv07A6Fpt43C/dxC//AH2hdmoRBBYMql1GNXRor5H4idq9Joz+EkIYIvUX7Q6hL+hqkpMfT7PT19sdl6gSzeRntwi5m3OFBqOasv+zbMUZBfHWymeMr/y7vrTC0LUq7dBMtoM1O/4gdW7jVg/tRvoSSiicNoxBN33shbyTApOB6jtSj1etX+jkMOvJwIDAQABo2MwYTAOBgNVHQ8BAf8EBAMCAYYwDwYDVR0TAQH/BAUwAwEB/zAdBgNVHQ4EFgQUA95QNVbRTLtm8KPiGxvDl7I90VUwHwYDVR0jBBgwFoAUA95QNVbRTLtm8KPiGxvDl7I90VUwDQYJKoZIhvcNAQEFBQADggEBAMucN6pIExIK+t1EnE9SsPTfrgT1eXkIoyQY/EsrhMAtudXH/vTBH1jLuG2cenTnmCmrEbXjcKChzUyImZOMkXDiqw8cvpOp/2PV5Adg06O/nVsJ8dWO41P0jmP6P6fbtGbfYmbW0W5BjfIttep3Sp+dWOIrWcBAI+0tKIJFPnlUkiaY4IBIqDfv8NZ5YBberOgOzW6sRBc4L0na4UU+Krk2U886UAb3LujEV0lsYSEY1QSteDwsOoBrp+uvFRTp2InBuThs4pFsiv9kuXclVzDAGySj4dzp30d8tbQkCAUw7C29C79Fv1C5qfPrmAESrciIxpg0X40KPMbp1ZWVbd4=")};
        arrayList.addAll(getCertificateArray());
        arrayList.add(bArr);
        return arrayList;
    }

    public SSLSocketFactory getmSSLSocketFactoryRed() {
        if (mSSLSocketFactoryRed == null) {
            synchronized (HttpsHelper.class) {
                SSLContext sSLContextSslContextForTrustedCertificatesRed = sslContextForTrustedCertificatesRed();
                if (sSLContextSslContextForTrustedCertificatesRed != null) {
                    mSSLSocketFactoryRed = new d(sSLContextSslContextForTrustedCertificatesRed.getSocketFactory());
                }
            }
        }
        return mSSLSocketFactoryRed;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements X509TrustManager {
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
