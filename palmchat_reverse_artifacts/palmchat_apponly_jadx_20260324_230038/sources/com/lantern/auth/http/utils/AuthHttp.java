package com.lantern.auth.http.utils;

import android.net.Network;
import android.net.SSLCertificateSocketFactory;
import com.efs.sdk.base.Constants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.http.CellularNetReqManager;
import com.lantern.auth.http.CellularNetwork;
import com.lantern.auth.util.report.AuthReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AuthHttp {
    private static final int BUFFER = 1024;
    public static final int COMPRESS_ERROR = 4;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public static final String METHOD_GET = "GET";
    public static final int NETWORK_ERROR = 1;
    public static final int OK = 0;
    public static final int OTHER_ERROR = 3;
    public static final String SERVER_CHARSET = "UTF-8";
    public static final int SERVER_ERROR = 2;
    private static HostnameVerifier sDefaultHostnameVerifier;
    private static SSLSocketFactory sDefaultSSLSocketFactory;
    String TAG;
    private Boolean followRedirects;
    private boolean forceCellular;
    private boolean mAllowAny;
    private BLCallback mCallback;
    private int mConnectTimeout;
    private AuthHttpErrorBean mErrorBean;
    private Map<String, String> mHeaders;
    private HostnameVerifier mHostnameVerifier;
    private boolean mIsForceIpRetry;
    private AuthHttpListener mListener;
    private BLPostHandler mPostHandler;
    private Proxy mProxy;
    private int mReadTimeout;
    private SSLSocketFactory mSSLSocketFactory;
    private int mTryTimes;
    private long mTs;
    private String mUrl;
    private int mUseCacheMode;

    /* JADX INFO: compiled from: SearchBox */
    public class AuthHttpErrorBean {
        public long time = 0;
        public String pid = "";
        public String serverIp = "";
        public String netState = "";
        public String errorCode = "";
        public String errorDetail = "";
        public String clientIp = "";
        public String clientSp = "";

        public AuthHttpErrorBean() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AuthHttpErrorListener {
        void error(AuthHttpErrorBean authHttpErrorBean);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AuthHttpListener {
        void downloadFinished(int i);

        void downloadProgress(int i, int i2);

        void getResponseCode(int i);

        void onException(Exception exc);

        void uploadFinished(int i);

        void uploadProgress(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface BLIPRetryListener {
        void onRetryWithIP(String str, String str2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface BLPostHandler {
        void doPost(OutputStream outputStream) throws IOException;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Response {
        public Exception ex;
        public byte[] mBody;
        public int mCode;
        public Map<String, List<String>> mHeaders;
        public String mMessage;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class TlsSniSocketFactory extends SSLSocketFactory {
        private String mHostName;

        public TlsSniSocketFactory(String str) {
            this.mHostName = str;
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
            String str2 = this.mHostName;
            if (str2 != null) {
                str = str2;
            }
            BLLog.d("customized createSocket. host: " + str, new Object[0]);
            InetAddress inetAddress = socket.getInetAddress();
            if (z) {
                socket.close();
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            BLLog.d("Setting SNI hostname:" + str, new Object[0]);
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            SSLSession session = sSLSocket.getSession();
            BLLog.d("Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite(), new Object[0]);
            return sSLSocket;
        }
    }

    public AuthHttp(String str) {
        this.TAG = "AuthHttp";
        this.mHeaders = new HashMap();
        this.mConnectTimeout = 15000;
        this.mReadTimeout = 30000;
        this.mTryTimes = 1;
        this.mUseCacheMode = -1;
        this.mAllowAny = true;
        this.mIsForceIpRetry = true;
        this.mUrl = str;
        this.mErrorBean = new AuthHttpErrorBean();
        this.mTs = System.currentTimeMillis();
    }

    private static byte[] compress(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        compress(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    public static String convertParam(Map<String, String> map) {
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
            } catch (UnsupportedEncodingException e) {
                BLLog.e(e);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private static void copyWithoutOutputClosing(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr, 0, 4096);
            if (i == -1) {
                outputStream.flush();
                inputStream.close();
                return;
            }
            outputStream.write(bArr, 0, i);
        }
    }

    public static byte[] decompress(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decompress(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    private byte[] download(InputStream inputStream, int i) throws IOException {
        if (i <= 0) {
            i = -1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        AuthHttpListener authHttpListener = this.mListener;
        if (authHttpListener != null) {
            authHttpListener.downloadProgress(0, i);
        }
        int i2 = 0;
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i3);
            i2 += i3;
            AuthHttpListener authHttpListener2 = this.mListener;
            if (authHttpListener2 != null) {
                authHttpListener2.downloadProgress(i2, i);
            }
        }
    }

    private byte[] excute(String str, String str2, InputStream inputStream) throws IOException {
        BLLog.d("%s %s %s", Long.valueOf(this.mTs), str2, str);
        new URL(str);
        CellularNetwork cellularNetworkRequestCelluarNetwork = CellularNetReqManager.getInstance().requestCelluarNetwork();
        if (cellularNetworkRequestCelluarNetwork.mNetwork == null) {
            AuthReport.doCellEvent(2);
            throw new IOException("request g failed");
        }
        AuthReport.doCellEvent(1);
        HttpURLConnection httpURLConnectionOpenCellularConnection = openCellularConnection(str, str2, cellularNetworkRequestCelluarNetwork.mNetwork);
        if ("POST".equals(str2)) {
            httpURLConnectionOpenCellularConnection.setDoOutput(true);
            BLPostHandler bLPostHandler = this.mPostHandler;
            if (bLPostHandler != null) {
                bLPostHandler.doPost(httpURLConnectionOpenCellularConnection.getOutputStream());
            } else if (inputStream != null) {
                post(httpURLConnectionOpenCellularConnection.getOutputStream(), inputStream);
                inputStream.close();
            }
        }
        httpURLConnectionOpenCellularConnection.connect();
        int responseCode = httpURLConnectionOpenCellularConnection.getResponseCode();
        AuthHttpListener authHttpListener = this.mListener;
        if (authHttpListener != null) {
            authHttpListener.getResponseCode(responseCode);
        }
        BLLog.i("responseCode:%d responseMessage:%s", Integer.valueOf(responseCode), httpURLConnectionOpenCellularConnection.getResponseMessage());
        InputStream inputStream2 = httpURLConnectionOpenCellularConnection.getInputStream();
        if (inputStream2 == null) {
            inputStream2 = httpURLConnectionOpenCellularConnection.getErrorStream();
        }
        byte[] bArrDownload = download(inputStream2, httpURLConnectionOpenCellularConnection.getContentLength());
        httpURLConnectionOpenCellularConnection.disconnect();
        CellularNetReqManager.getInstance().unRegisterCallback(cellularNetworkRequestCelluarNetwork.mNetworkCallback);
        return bArrDownload;
    }

    public static String getHeader(Map<String, List<String>> map, String str) {
        List<String> list;
        if (map == null || (list = map.get(str)) == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public static String getRedirect(Response response) {
        if (response == null || !isRedirect(response.mCode)) {
            return null;
        }
        return getHeader(response.mHeaders, HttpHeaders.LOCATION);
    }

    private boolean isGzipRequest() {
        if (this.mHeaders.containsKey("Content-Encoding")) {
            return Constants.CP_GZIP.equals(this.mHeaders.get("Content-Encoding"));
        }
        return false;
    }

    public static boolean isRedirect(int i) {
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public static boolean isSuccessful(int i) {
        return i >= 200 && i < 300;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0073: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:116), block:B:56:0x0073 */
    public static KeyStore loadCert(byte[] bArr) throws Throwable {
        InputStream inputStream;
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream2 = null;
        try {
        } catch (Throwable th) {
            th = th;
            inputStream2 = inputStream;
        }
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
            } catch (IOException e) {
                BLLog.e(e);
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            byteArrayInputStream = null;
        } catch (KeyStoreException e3) {
            e = e3;
            byteArrayInputStream = null;
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            byteArrayInputStream = null;
        } catch (NoSuchProviderException e5) {
            e = e5;
            byteArrayInputStream = null;
        } catch (CertificateException e6) {
            e = e6;
            byteArrayInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e7) {
                    BLLog.e(e7);
                }
            }
            throw th;
        }
        try {
            Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
            KeyStore keyStore = KeyStore.getInstance("PKCS12", "BC");
            keyStore.load(null, null);
            keyStore.setCertificateEntry("trust", certificateGenerateCertificate);
            try {
                byteArrayInputStream.close();
            } catch (IOException e8) {
                BLLog.e(e8);
            }
            return keyStore;
        } catch (IOException e9) {
            e = e9;
            BLLog.e(e);
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return null;
        } catch (KeyStoreException e10) {
            e = e10;
            BLLog.e(e);
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return null;
        } catch (NoSuchAlgorithmException e11) {
            e = e11;
            BLLog.e(e);
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return null;
        } catch (NoSuchProviderException e12) {
            e = e12;
            BLLog.e(e);
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return null;
        } catch (CertificateException e13) {
            e = e13;
            BLLog.e(e);
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0066: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:103), block:B:48:0x0066 */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static KeyStore loadCertDefaultType(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
                        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                        keyStore.load(null, null);
                        keyStore.setCertificateEntry("trust", certificateGenerateCertificate);
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e) {
                            BLLog.e(e);
                        }
                        return keyStore;
                    } catch (IOException e2) {
                        e = e2;
                        BLLog.e(e);
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        return null;
                    } catch (KeyStoreException e3) {
                        e = e3;
                        BLLog.e(e);
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        return null;
                    } catch (NoSuchAlgorithmException e4) {
                        e = e4;
                        BLLog.e(e);
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        return null;
                    } catch (CertificateException e5) {
                        e = e5;
                        BLLog.e(e);
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e6) {
                            BLLog.e(e6);
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                byteArrayInputStream = null;
            } catch (KeyStoreException e8) {
                e = e8;
                byteArrayInputStream = null;
            } catch (NoSuchAlgorithmException e9) {
                e = e9;
                byteArrayInputStream = null;
            } catch (CertificateException e10) {
                e = e10;
                byteArrayInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        } catch (IOException e11) {
            BLLog.e(e11);
        }
    }

    private HttpURLConnection openCellularConnection(String str, String str2, Network network) throws IOException {
        URL url = new URL(str);
        String protocol = url.getProtocol();
        if (protocol == null || protocol.length() == 0) {
            throw new IOException("protocol is null");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(url);
        if (httpURLConnection instanceof HttpsURLConnection) {
            SSLSocketFactory sSLSocketFactory = this.mSSLSocketFactory;
            if (sSLSocketFactory != null) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                HostnameVerifier hostnameVerifier = this.mHostnameVerifier;
                if (hostnameVerifier != null) {
                    httpsURLConnection.setHostnameVerifier(hostnameVerifier);
                }
            } else {
                SSLSocketFactory sSLSocketFactory2 = sDefaultSSLSocketFactory;
                if (sSLSocketFactory2 != null) {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) httpURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(sSLSocketFactory2);
                    HostnameVerifier hostnameVerifier2 = sDefaultHostnameVerifier;
                    if (hostnameVerifier2 != null) {
                        httpsURLConnection2.setHostnameVerifier(hostnameVerifier2);
                    }
                }
            }
        }
        if (httpURLConnection == null) {
            throw new IOException("connection is null");
        }
        httpURLConnection.setConnectTimeout(this.mConnectTimeout);
        httpURLConnection.setReadTimeout(this.mReadTimeout);
        httpURLConnection.setRequestMethod(str2);
        int i = this.mUseCacheMode;
        if (i != -1) {
            httpURLConnection.setUseCaches(i == 1);
        }
        Boolean bool = this.followRedirects;
        if (bool != null) {
            httpURLConnection.setInstanceFollowRedirects(bool.booleanValue());
        }
        httpURLConnection.setDoInput(true);
        for (String str3 : this.mHeaders.keySet()) {
            String str4 = this.mHeaders.get(str3);
            BLLog.d("%s=%s", str3, str4);
            httpURLConnection.setRequestProperty(str3, str4);
        }
        return httpURLConnection;
    }

    private void post(OutputStream outputStream, InputStream inputStream) throws IOException {
        int iAvailable = inputStream.available();
        AuthHttpListener authHttpListener = this.mListener;
        if (authHttpListener != null) {
            authHttpListener.uploadProgress(0, iAvailable);
        }
        byte[] bArr = new byte[4096];
        int i = 0;
        while (true) {
            int i2 = inputStream.read(bArr, 0, 4096);
            if (i2 == -1) {
                outputStream.flush();
                outputStream.close();
                return;
            } else {
                outputStream.write(bArr, 0, i2);
                i += i2;
                AuthHttpListener authHttpListener2 = this.mListener;
                if (authHttpListener2 != null) {
                    authHttpListener2.uploadProgress(i, iAvailable);
                }
            }
        }
    }

    public static String postString(String str, String str2) {
        return postString(str, str2, 1);
    }

    public static void setDefaultHostNameVerifier(HostnameVerifier hostnameVerifier) {
        sDefaultHostnameVerifier = hostnameVerifier;
    }

    public static void setDefaultSSLCert(String str) {
        KeyStore keyStoreLoadCert;
        if (str == null || (keyStoreLoadCert = loadCert(str.getBytes())) == null) {
            return;
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStoreLoadCert);
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
            SSLContext.setDefault(sSLContext);
            sDefaultSSLSocketFactory = sSLContext.getSocketFactory();
        } catch (KeyManagementException e) {
            BLLog.e(e);
        } catch (KeyStoreException e2) {
            BLLog.e(e2);
        } catch (NoSuchAlgorithmException e3) {
            BLLog.e(e3);
        }
    }

    public static void setDefaultSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        sDefaultSSLSocketFactory = sSLSocketFactory;
    }

    public String postMap(Map<String, String> map) {
        return postString(convertParam(map));
    }

    public void setAllowAnySSLCert(boolean z) {
        this.mAllowAny = z;
    }

    public void setForceCellular(boolean z) {
        this.forceCellular = z;
    }

    public void setHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    public void setHostNameVerifier(HostnameVerifier hostnameVerifier) {
        this.mHostnameVerifier = hostnameVerifier;
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.followRedirects = Boolean.valueOf(z);
    }

    public void setListener(AuthHttpListener authHttpListener) {
        this.mListener = authHttpListener;
    }

    public void setPostHandler(BLPostHandler bLPostHandler) {
        this.mPostHandler = bLPostHandler;
    }

    public void setProxy(String str, int i) {
        if (str == null || i <= 0) {
            return;
        }
        this.mProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
    }

    public void setSSLCert(String str) {
        KeyStore keyStoreLoadCert;
        if (str == null || (keyStoreLoadCert = loadCert(str.getBytes())) == null) {
            return;
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStoreLoadCert);
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
            SSLContext.setDefault(sSLContext);
            this.mSSLSocketFactory = sSLContext.getSocketFactory();
        } catch (KeyManagementException e) {
            BLLog.e(e);
        } catch (KeyStoreException e2) {
            BLLog.e(e2);
        } catch (NoSuchAlgorithmException e3) {
            BLLog.e(e3);
        }
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.mSSLSocketFactory = sSLSocketFactory;
    }

    public void setTimeout(int i, int i2) {
        this.mConnectTimeout = i;
        this.mReadTimeout = i2;
    }

    public void setTryTimes(int i) {
        this.mTryTimes = i;
    }

    public void setUseCaches(boolean z) {
        if (z) {
            this.mUseCacheMode = 1;
        } else {
            this.mUseCacheMode = 0;
        }
    }

    public static boolean isSuccessful(Response response) {
        return response != null && isSuccessful(response.mCode);
    }

    public static String postMap(String str, Map<String, String> map) {
        return postMap(str, map, 1);
    }

    public static String postString(String str, String str2, int i) {
        return new AuthHttp(str).postString(str2);
    }

    public void setProxy(Proxy proxy) {
        this.mProxy = proxy;
    }

    public static String postMap(String str, Map<String, String> map, int i) {
        return postString(str, convertParam(map), i);
    }

    public String postString(String str) {
        byte[] bArrPost;
        try {
            bArrPost = post(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            BLLog.e(e);
            bArrPost = null;
        }
        if (bArrPost != null && bArrPost.length != 0) {
            try {
                return new String(bArrPost, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                BLLog.e(e2);
            }
        }
        return "";
    }

    private static void compress(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i != -1) {
                gZIPOutputStream.write(bArr, 0, i);
            } else {
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
        }
    }

    public static void decompress(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = gZIPInputStream.read(bArr, 0, 1024);
            if (i != -1) {
                outputStream.write(bArr, 0, i);
            } else {
                gZIPInputStream.close();
                return;
            }
        }
    }

    public byte[] post(byte[] bArr) {
        int i;
        if (isGzipRequest()) {
            try {
                bArr = compress(bArr);
                i = 0;
            } catch (Exception e) {
                BLLog.e(e);
                i = 4;
                if (this.mListener != null) {
                    this.mListener.uploadFinished(4);
                }
                this.mHeaders.remove("Content-Encoding");
            }
        } else {
            i = 0;
        }
        byte[] bArrExcute = null;
        for (int i2 = 0; i2 < this.mTryTimes; i2++) {
            try {
                bArrExcute = excute(this.mUrl, "POST", new ByteArrayInputStream(bArr));
            } catch (IOException e2) {
                BLLog.e(e2);
                AuthHttpListener authHttpListener = this.mListener;
                if (authHttpListener != null) {
                    authHttpListener.onException(e2);
                }
                i = 1;
            } catch (Exception e3) {
                BLLog.e(e3);
                AuthHttpListener authHttpListener2 = this.mListener;
                if (authHttpListener2 != null) {
                    authHttpListener2.onException(e3);
                }
                i = 3;
            }
            AuthHttpListener authHttpListener3 = this.mListener;
            if (authHttpListener3 != null) {
                authHttpListener3.uploadFinished(i);
            }
            if (i == 0) {
                break;
            }
        }
        return bArrExcute;
    }

    private boolean download(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        if (i <= 0) {
            i = -1;
        }
        byte[] bArr = new byte[4096];
        AuthHttpListener authHttpListener = this.mListener;
        if (authHttpListener != null) {
            authHttpListener.downloadProgress(0, i);
        }
        int i2 = 0;
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 != -1) {
                outputStream.write(bArr, 0, i3);
                i2 += i3;
                AuthHttpListener authHttpListener2 = this.mListener;
                if (authHttpListener2 != null) {
                    authHttpListener2.downloadProgress(i2, i);
                }
            } else {
                inputStream.close();
                outputStream.flush();
                outputStream.close();
                return true;
            }
        }
    }

    public AuthHttp(String str, boolean z, BLCallback bLCallback) {
        this.TAG = "AuthHttp";
        this.mHeaders = new HashMap();
        this.mConnectTimeout = 15000;
        this.mReadTimeout = 30000;
        this.mTryTimes = 1;
        this.mUseCacheMode = -1;
        this.mAllowAny = true;
        this.mIsForceIpRetry = true;
        this.mUrl = str;
        this.mErrorBean = new AuthHttpErrorBean();
        this.mTs = System.currentTimeMillis();
        this.mCallback = bLCallback;
        this.mIsForceIpRetry = z;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DefaultTrustManager implements X509TrustManager {
        private DefaultTrustManager() {
        }

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
