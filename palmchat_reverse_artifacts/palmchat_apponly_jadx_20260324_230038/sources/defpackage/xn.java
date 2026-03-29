package defpackage;

import android.net.SSLCertificateSocketFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class xn {
    public static SSLSocketFactory q;
    public static HostnameVerifier r;
    public static Map<String, List<String>> s;
    public String b;
    public Proxy c;
    public Boolean j;
    public SSLSocketFactory l;
    public HostnameVerifier m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22006a = "BLHttp";
    public Map<String, String> d = new HashMap();
    public int e = 15000;
    public int f = 30000;
    public int g = 1;
    public int i = -1;
    public boolean n = true;
    public boolean o = true;
    public HashMap<String, String> p = new HashMap<>();
    public c k = new c();
    public long h = System.currentTimeMillis();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22007a;

        public a(String str) {
            this.f22007a = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            v.a("verify hostname:%s", str);
            v.a("verify " + sSLSession.getProtocol() + " connection with " + sSLSession.getPeerHost() + " using " + sSLSession.getCipherSuite(), new Object[0]);
            if (xn.r == null) {
                HostnameVerifier unused = xn.r = HttpsURLConnection.getDefaultHostnameVerifier();
            }
            return xn.r.verify(this.f22007a, sSLSession);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements HostnameVerifier {
        public b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f22009a = 0;
        public String b = "";
        public String c = "";
        public String d = "";
        public String e = "";
        public String f = "";
        public String g = "";
        public String h = "";

        public c() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements X509TrustManager {
        public d() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends SSLSocketFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22010a;

        public e(String str) {
            this.f22010a = str;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket() throws IOException {
            return null;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return new String[0];
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return new String[0];
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i) throws IOException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            return null;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
            String str2 = this.f22010a;
            if (str2 != null) {
                str = str2;
            }
            v.a("customized createSocket. host: " + str, new Object[0]);
            InetAddress inetAddress = socket.getInetAddress();
            if (z) {
                socket.close();
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
            v.a("92241>sl.getSupportedProtocols()>" + TextUtils.join(",", sSLSocket.getSupportedProtocols()), new Object[0]);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            v.a("Setting SNI hostname:" + str, new Object[0]);
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            SSLSession session = sSLSocket.getSession();
            v.a("Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite(), new Object[0]);
            return sSLSocket;
        }
    }

    public xn(String str) {
        this.b = str;
    }

    public static void d(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i == -1) {
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
            gZIPOutputStream.write(bArr, 0, i);
        }
    }

    public static byte[] e(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    public static String f(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (String str : map.keySet()) {
            if (i > 0) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            String str2 = map.get(str);
            try {
                String strEncode = URLEncoder.encode(str, "UTF-8");
                if (str2 == null) {
                    str2 = "";
                }
                String strEncode2 = URLEncoder.encode(str2, "UTF-8");
                stringBuffer.append(strEncode);
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(strEncode2);
            } catch (UnsupportedEncodingException e2) {
                v.c(e2);
            } catch (Exception e3) {
                v.c(e3);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static String n(String str, Map<String, String> map) {
        return o(str, map, 1);
    }

    public static String o(String str, Map<String, String> map, int i) {
        return q(str, f(map), i);
    }

    public static String q(String str, String str2, int i) {
        return new xn(str).p(str2);
    }

    public final byte[] g(byte[] bArr, String str, String str2, InputStream inputStream) {
        List<String> list;
        v.a(this.f22006a + "doIPRetry", new Object[0]);
        if (s == null) {
            return bArr;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host) || (list = s.get(host)) == null) {
            return bArr;
        }
        byte[] bArrI = null;
        for (String str3 : list) {
            v.a("#61939，读取到重试域名/IP，域名/IP=" + str3, new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.reset();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            String strReplaceFirst = str.replaceFirst(host, str3);
            try {
                v.a("#61939，域名/IP=" + str3 + "开始重试！", new Object[0]);
                bArrI = i(strReplaceFirst, str2, inputStream);
                v.a("#61939，域名/IP=" + str3 + "重试成功！", new Object[0]);
                return bArrI;
            } catch (IOException e3) {
                v.c(e3);
                v.a("#61939，重试失败！继续重试下一个域名/IP！", new Object[0]);
            } catch (Exception e4) {
                v.c(e4);
                v.a("#61939，重试失败！继续重试下一个域名/IP！", new Object[0]);
            }
        }
        return bArrI;
    }

    public final byte[] h(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public final byte[] i(String str, String str2, InputStream inputStream) throws IOException {
        v.a("%s %s %s", Long.valueOf(this.h), str2, str);
        new URL(str);
        HttpURLConnection httpURLConnectionK = k(str, str2);
        if ("POST".equals(str2)) {
            httpURLConnectionK.setDoOutput(true);
            if (inputStream != null) {
                l(httpURLConnectionK.getOutputStream(), inputStream);
                inputStream.close();
            }
        }
        httpURLConnectionK.connect();
        v.g("responseCode:%d responseMessage:%s", Integer.valueOf(httpURLConnectionK.getResponseCode()), httpURLConnectionK.getResponseMessage());
        InputStream inputStream2 = httpURLConnectionK.getInputStream();
        if (inputStream2 == null) {
            inputStream2 = httpURLConnectionK.getErrorStream();
        }
        byte[] bArrH = h(inputStream2, httpURLConnectionK.getContentLength());
        httpURLConnectionK.disconnect();
        return bArrH;
    }

    public final boolean j() {
        if (this.d.containsKey("Content-Encoding")) {
            return Constants.CP_GZIP.equals(this.d.get("Content-Encoding"));
        }
        return false;
    }

    public final HttpURLConnection k(String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
        v.a("oponConnection-->" + str, new Object[0]);
        URL url = new URL(str);
        String protocol = url.getProtocol();
        if (protocol == null || protocol.length() == 0) {
            throw new IOException("protocol is null");
        }
        if (protocol.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            v.a("92241>http", new Object[0]);
            Proxy proxy = this.c;
            if (proxy != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
            } else {
                String host = url.getHost();
                CharSequence charSequence = (String) this.p.get(host);
                v.a("host:%s ip:%s", host, charSequence);
                if (charSequence != null) {
                    httpURLConnection = (HttpURLConnection) new URL(str.replace(host, charSequence)).openConnection();
                    httpURLConnection.setRequestProperty("Host", host);
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
            }
        } else {
            a aVar = null;
            if (protocol.equals(BaseConstants.SCHEME_HTTPS)) {
                v.a("92241>https", new Object[0]);
                if (this.c != null) {
                    v.a("92241>mProxy!= null", new Object[0]);
                    httpsURLConnection = (HttpsURLConnection) url.openConnection(this.c);
                } else {
                    v.a("92241>mProxy== null", new Object[0]);
                    String host2 = url.getHost();
                    String str3 = this.p.get(host2);
                    v.a("host:%s ip:%s", host2, str3);
                    if (str3 != null) {
                        v.a("92241>ip != null " + str3, new Object[0]);
                        httpsURLConnection = (HttpsURLConnection) new URL(str.replace(host2, str3)).openConnection();
                        httpsURLConnection.setRequestProperty("Host", host2);
                        this.l = new e(host2);
                        this.m = new a(host2);
                    } else {
                        v.a("92241>ip== null", new Object[0]);
                        httpsURLConnection = (HttpsURLConnection) url.openConnection();
                    }
                }
                if (this.l != null) {
                    v.a("92241>mSSLSocketFactory != null", new Object[0]);
                    httpsURLConnection.setSSLSocketFactory(c(this.l));
                    HostnameVerifier hostnameVerifier = this.m;
                    if (hostnameVerifier != null) {
                        httpsURLConnection.setHostnameVerifier(hostnameVerifier);
                    }
                } else if (q != null) {
                    v.a("92241>sDefaultSSLSocketFactory != null", new Object[0]);
                    httpsURLConnection.setSSLSocketFactory(c(q));
                    HostnameVerifier hostnameVerifier2 = r;
                    if (hostnameVerifier2 != null) {
                        httpsURLConnection.setHostnameVerifier(hostnameVerifier2);
                    }
                } else if (this.n) {
                    v.a("92241>mAllowAny true", new Object[0]);
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(new KeyManager[0], new TrustManager[]{new d(aVar)}, new SecureRandom());
                        SSLContext.setDefault(sSLContext);
                        v.a("92241>setSSLSocketFactory()--> url-->" + str, new Object[0]);
                        httpsURLConnection.setSSLSocketFactory(c(sSLContext.getSocketFactory()));
                        httpsURLConnection.setHostnameVerifier(new b());
                    } catch (KeyManagementException e2) {
                        v.c(e2);
                    } catch (NoSuchAlgorithmException e3) {
                        v.c(e3);
                    } catch (Exception e4) {
                        v.c(e4);
                    }
                }
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = null;
            }
        }
        if (httpURLConnection == null) {
            throw new IOException("connection is null");
        }
        httpURLConnection.setConnectTimeout(this.e);
        httpURLConnection.setReadTimeout(this.f);
        httpURLConnection.setRequestMethod(str2);
        int i = this.i;
        if (i != -1) {
            httpURLConnection.setUseCaches(i == 1);
        }
        Boolean bool = this.j;
        if (bool != null) {
            httpURLConnection.setInstanceFollowRedirects(bool.booleanValue());
        }
        httpURLConnection.setDoInput(true);
        for (String str4 : this.d.keySet()) {
            String str5 = this.d.get(str4);
            v.a("%s=%s", str4, str5);
            httpURLConnection.setRequestProperty(str4, str5);
        }
        return httpURLConnection;
    }

    public final void l(OutputStream outputStream, InputStream inputStream) throws IOException {
        inputStream.available();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr, 0, 4096);
            if (i == -1) {
                outputStream.flush();
                outputStream.close();
                return;
            }
            outputStream.write(bArr, 0, i);
        }
    }

    public byte[] m(byte[] bArr) {
        char c2;
        byte[] bArrI = null;
        if (bArr == null) {
            return null;
        }
        if (j()) {
            try {
                bArr = e(bArr);
                c2 = 0;
            } catch (Exception e2) {
                v.c(e2);
                this.d.remove("Content-Encoding");
                c2 = 4;
            }
        } else {
            c2 = 0;
        }
        for (int i = 0; i < this.g; i++) {
            try {
                bArrI = i(this.b, "POST", new ByteArrayInputStream(bArr));
            } catch (IOException e3) {
                v.c(e3);
                c2 = 1;
            } catch (Exception e4) {
                v.c(e4);
                c2 = 3;
            }
            if (c2 == 0) {
                break;
            }
        }
        if (c2 == 0 || !this.o) {
            return bArrI;
        }
        v.a("#61939,请求失败,开始IP/域名重试,url=" + this.b + "; 是否需要IP重试:" + this.o, new Object[0]);
        return g(bArrI, this.b, "POST", new ByteArrayInputStream(bArr));
    }

    public String p(String str) {
        byte[] bArrM;
        try {
            bArrM = m(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            v.c(e2);
            bArrM = null;
        }
        if (bArrM != null && bArrM.length != 0) {
            try {
                return new String(bArrM, "UTF-8");
            } catch (UnsupportedEncodingException e3) {
                v.c(e3);
            } catch (Exception e4) {
                v.c(e4);
                return "";
            }
        }
        return "";
    }

    public static SSLSocketFactory c(SSLSocketFactory sSLSocketFactory) {
        return sSLSocketFactory;
    }
}
