package com.lantern.auth.core;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.utils.ConstantMix;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BLHttp {
    private static final String CERT = "-----BEGIN CERTIFICATE-----\nMIIFGTCCBAGgAwIBAgIJAKxZdyvq7wJpMA0GCSqGSIb3DQEBCwUAMIG0MQswCQYD\nVQQGEwJVUzEQMA4GA1UECBMHQXJpem9uYTETMBEGA1UEBxMKU2NvdHRzZGFsZTEa\nMBgGA1UEChMRR29EYWRkeS5jb20sIEluYy4xLTArBgNVBAsTJGh0dHA6Ly9jZXJ0\ncy5nb2RhZGR5LmNvbS9yZXBvc2l0b3J5LzEzMDEGA1UEAxMqR28gRGFkZHkgU2Vj\ndXJlIENlcnRpZmljYXRlIEF1dGhvcml0eSAtIEcyMB4XDTE1MDMwOTA0MjYzOFoX\nDTE3MDQwNDA0MjUxN1owODEhMB8GA1UECxMYRG9tYWluIENvbnRyb2wgVmFsaWRh\ndGVkMRMwEQYDVQQDDAoqLjUxeTUubmV0MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8A\nMIIBCgKCAQEA6huu9DXBQmBsSwJmz8+6WsUfqaaYwYbTsanThaAK6f4LOvwfl9GK\nOHfj4ltEFQDCgt+6CACnGdDoFxZfqR3ZDfruOK7oA79ekxpVYPiw41tiQ4FiBTIl\nklV0N8jhVLQXxweoqXp0bfH3Ks/Cye6Y62rUA9/O62DLeqBzXFivmKeWteH/VX27\nzVwNSUw4Wg4VHpWAqzsdq7XSSLk8hCnlyjXB4aJazzo3rMFvbXuaGn1EF2wOARVw\ngHktRbbpiuUUCiJWh8ByGowY/Vfevi0a5/c61mq77To0IYsjQ2fLISqF5UNp+T0W\n0cVShdt4pld7yIxFNsz3gOyzlFiWOxkPswIDAQABo4IBpzCCAaMwDAYDVR0TAQH/\nBAIwADAdBgNVHSUEFjAUBggrBgEFBQcDAQYIKwYBBQUHAwIwDgYDVR0PAQH/BAQD\nAgWgMDYGA1UdHwQvMC0wK6ApoCeGJWh0dHA6Ly9jcmwuZ29kYWRkeS5jb20vZ2Rp\nZzJzMS04Ny5jcmwwUwYDVR0gBEwwSjBIBgtghkgBhv1tAQcXATA5MDcGCCsGAQUF\nBwIBFitodHRwOi8vY2VydGlmaWNhdGVzLmdvZGFkZHkuY29tL3JlcG9zaXRvcnkv\nMHYGCCsGAQUFBwEBBGowaDAkBggrBgEFBQcwAYYYaHR0cDovL29jc3AuZ29kYWRk\neS5jb20vMEAGCCsGAQUFBzAChjRodHRwOi8vY2VydGlmaWNhdGVzLmdvZGFkZHku\nY29tL3JlcG9zaXRvcnkvZ2RpZzIuY3J0MB8GA1UdIwQYMBaAFEDCvSeOzDSDMKIz\n1/tss/C0LIDOMB8GA1UdEQQYMBaCCiouNTF5NS5uZXSCCDUxeTUubmV0MB0GA1Ud\nDgQWBBRdeFn9Kzv+SXCzyP+3CDuiv/mNETANBgkqhkiG9w0BAQsFAAOCAQEAkN6S\n0UXlYaCQCgthqJlNHjTT2WtZF0N/bSpmsJuwlikUwi6uT0cyPl/jVpZncO0RkX8c\nEGf0W52T0Dp8sCi24bWZeGR0M/R9XEiYNdenMTiGdNs97LkQ+Amg02AnII3vxSVH\nPjhdn2nuqACa/0vAlE7NAFJFSkeO05SitMUbYIEH6552lgkdR7QTHc5jcrBmtXDx\naUeZDaMnJfDfGJyP78GYgnSa1m+24I3Mh9eMrWMOqdpqmtsaVerBqrhLQKjlG8OG\n8lmRP4f1LfLVQUA6Zg/eq7SHMax+RnhgxcByXCtxDoTt5+UJnFAlTszxJYe1GuSv\nxFxak69xavfpfahV+w==\n-----END CERTIFICATE-----";
    public static final int NETWORK_ERROR = 1;
    public static final int OK = 0;
    public static final int OTHER_ERROR = 3;
    public static final int SERVER_ERROR = 2;
    public static SSLSocketFactory sslSocketFactory;
    private BLHttpListener mListener;
    private BLPostHandler mPostHandler;
    private Proxy mProxy;
    private KeyStore mSSLKey;
    private String mUrl;
    private Map<String, String> mHeaders = new HashMap();
    private int mConnectTimeout = 30000;
    private int mReadTimeout = 90000;
    private int mTryTimes = 1;

    /* JADX INFO: compiled from: SearchBox */
    public interface BLHttpListener {
        void downloadFinished(int i);

        void downloadProgress(int i, int i2);

        void uploadFinished(int i);

        void uploadProgress(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface BLPostHandler {
        void doPost(OutputStream outputStream) throws IOException;
    }

    public BLHttp(String str) {
        this.mUrl = str;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void copyWithoutOutputClosing(InputStream inputStream, OutputStream outputStream) throws IOException {
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

    private byte[] download(InputStream inputStream, int i) throws IOException {
        if (i <= 0) {
            i = -1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        BLHttpListener bLHttpListener = this.mListener;
        if (bLHttpListener != null) {
            bLHttpListener.downloadProgress(0, i);
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
            BLHttpListener bLHttpListener2 = this.mListener;
            if (bLHttpListener2 != null) {
                bLHttpListener2.downloadProgress(i2, i);
            }
        }
    }

    private byte[] excute(String str, String str2, InputStream inputStream) throws Exception {
        HttpURLConnection httpURLConnection;
        BLLog.i("%s %s", str2, str);
        URL url = new URL(str);
        String protocol = url.getProtocol();
        if (protocol == null || protocol.length() == 0) {
            throw new IOException("protocol is null");
        }
        if (protocol.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            Proxy proxy = this.mProxy;
            httpURLConnection = proxy != null ? (HttpURLConnection) url.openConnection(proxy) : (HttpURLConnection) url.openConnection();
        } else if (protocol.equals(BaseConstants.SCHEME_HTTPS)) {
            Proxy proxy2 = this.mProxy;
            HttpsURLConnection httpsURLConnection = proxy2 != null ? (HttpsURLConnection) url.openConnection(proxy2) : (HttpsURLConnection) url.openConnection();
            SSLSocketFactory sSLSocketFactory = sslSocketFactory;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                BLLog.d("set ssl factory by default cache", new Object[0]);
            } else {
                httpsURLConnection.setSSLSocketFactory(SSLContext.getInstance("Default").getSocketFactory());
            }
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.lantern.auth.core.BLHttp.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str3, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str3)) {
                        return false;
                    }
                    return str3.contains(ConstantMix.DOMAIN);
                }
            });
            httpURLConnection = httpsURLConnection;
        } else {
            httpURLConnection = null;
        }
        if (httpURLConnection == null) {
            throw new IOException("connection is null");
        }
        httpURLConnection.setConnectTimeout(this.mConnectTimeout);
        httpURLConnection.setReadTimeout(this.mReadTimeout);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setDoInput(true);
        for (String str3 : this.mHeaders.keySet()) {
            String str4 = this.mHeaders.get(str3);
            BLLog.i("%s=%s", str3, str4);
            httpURLConnection.setRequestProperty(str3, str4);
        }
        if ("POST".equals(str2)) {
            httpURLConnection.setDoOutput(true);
            BLPostHandler bLPostHandler = this.mPostHandler;
            if (bLPostHandler != null) {
                bLPostHandler.doPost(httpURLConnection.getOutputStream());
            } else if (inputStream != null) {
                post(httpURLConnection.getOutputStream(), inputStream);
                inputStream.close();
            }
        }
        httpURLConnection.connect();
        BLLog.i("responseCode:%d responseMessage:%s", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage());
        InputStream inputStream2 = httpURLConnection.getInputStream();
        if (inputStream2 == null) {
            inputStream2 = httpURLConnection.getErrorStream();
        }
        byte[] bArrDownload = download(inputStream2, httpURLConnection.getContentLength());
        httpURLConnection.disconnect();
        return bArrDownload;
    }

    public static String getString(String str) {
        return getString(str, 1);
    }

    private static KeyStore loadCert() throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(CERT.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            try {
                Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
                KeyStore keyStore = KeyStore.getInstance("PKCS12", "BC");
                keyStore.load(null, null);
                keyStore.setCertificateEntry("trust", certificateGenerateCertificate);
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return keyStore;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            } catch (KeyStoreException e4) {
                e = e4;
                e.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                e.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            } catch (NoSuchProviderException e6) {
                e = e6;
                e.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            } catch (CertificateException e7) {
                e = e7;
                e.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            }
        } catch (IOException e8) {
            e = e8;
            byteArrayInputStream = null;
        } catch (KeyStoreException e9) {
            e = e9;
            byteArrayInputStream = null;
        } catch (NoSuchAlgorithmException e10) {
            e = e10;
            byteArrayInputStream = null;
        } catch (NoSuchProviderException e11) {
            e = e11;
            byteArrayInputStream = null;
        } catch (CertificateException e12) {
            e = e12;
            byteArrayInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th;
        }
    }

    private void post(OutputStream outputStream, InputStream inputStream) throws IOException {
        int iAvailable = inputStream.available();
        BLHttpListener bLHttpListener = this.mListener;
        if (bLHttpListener != null) {
            bLHttpListener.uploadProgress(0, iAvailable);
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
                BLHttpListener bLHttpListener2 = this.mListener;
                if (bLHttpListener2 != null) {
                    bLHttpListener2.uploadProgress(i, iAvailable);
                }
            }
        }
    }

    public static String postFile(String str, String str2) {
        return postFile(str, str2, 1);
    }

    public static String postFileAsForm(String str, Map<String, String> map, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(str2);
        arrayList2.add(str3);
        return postFileAsForm(str, map, arrayList, arrayList2);
    }

    public static String postString(String str, String str2) throws Exception {
        return postString(str, str2, 1);
    }

    public byte[] get() {
        byte[] bArrExcute = null;
        int i = 0;
        for (int i2 = 0; i2 < this.mTryTimes; i2++) {
            try {
                bArrExcute = excute(this.mUrl, "GET", null);
            } catch (IOException e) {
                BLLog.e(e);
                i = 1;
            } catch (Exception e2) {
                BLLog.e(e2);
                i = 3;
            }
            BLHttpListener bLHttpListener = this.mListener;
            if (bLHttpListener != null) {
                bLHttpListener.downloadFinished(i);
            }
            if (i == 0) {
                break;
            }
        }
        return bArrExcute;
    }

    public String postMap(Map<String, String> map) throws Exception {
        return postString(convertParam(map));
    }

    public void setHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    public void setKeyStore(KeyStore keyStore) {
        this.mSSLKey = keyStore;
    }

    public void setListener(BLHttpListener bLHttpListener) {
        this.mListener = bLHttpListener;
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

    public void setTimeout(int i, int i2) {
        this.mConnectTimeout = i;
        this.mReadTimeout = i2;
    }

    public void setTryTimes(int i) {
        this.mTryTimes = i;
    }

    public static String getString(String str, int i) {
        BLHttp bLHttp = new BLHttp(str);
        bLHttp.setTryTimes(i);
        byte[] bArr = bLHttp.get();
        if (bArr != null && bArr.length != 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                BLLog.e(e);
            }
        }
        return "";
    }

    public static String postFile(String str, String str2, int i) {
        byte[] bArrPost;
        BLHttp bLHttp = new BLHttp(str);
        bLHttp.setTryTimes(i);
        try {
            bArrPost = bLHttp.post(new FileInputStream(str2));
        } catch (FileNotFoundException e) {
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

    public static String postMap(String str, Map<String, String> map) throws Exception {
        return postMap(str, map, 1);
    }

    public static String postString(String str, String str2, int i) throws Exception {
        return new BLHttp(str).postString(str2);
    }

    public void setProxy(Proxy proxy) {
        this.mProxy = proxy;
    }

    public static String postMap(String str, Map<String, String> map, int i) throws Exception {
        return postString(str, convertParam(map), i);
    }

    public String postString(String str) throws Exception {
        byte[] bArrPost = post(str.getBytes("UTF-8"));
        if (bArrPost != null && bArrPost.length != 0) {
            try {
                return new String(bArrPost, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                BLLog.e(e);
            }
        }
        return "";
    }

    public static String postFileAsForm(String str, final Map<String, String> map, final List<String> list, final List<String> list2) {
        final String str2 = "-----" + UUID.randomUUID().toString() + "-----";
        final String str3 = HttpClient.ENDFLAG + str2 + HttpClient.ENDFLAG + HttpClient.NEWLINE;
        BLHttp bLHttp = new BLHttp(str);
        bLHttp.setHeader("connection", "keep-alive");
        bLHttp.setHeader("charset", "UTF-8");
        bLHttp.setHeader("Content-Type", "multipart/form-data;boundary=" + str2);
        byte[] bArrPost = bLHttp.post(new BLPostHandler() { // from class: com.lantern.auth.core.BLHttp.2
            @Override // com.lantern.auth.core.BLHttp.BLPostHandler
            public void doPost(OutputStream outputStream) throws IOException {
                if (map != null) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : map.entrySet()) {
                        sb.append(HttpClient.ENDFLAG);
                        sb.append(str2);
                        sb.append(HttpClient.NEWLINE);
                        sb.append("Content-Disposition: form-data; name=\"" + ((String) entry.getKey()) + "\"" + HttpClient.NEWLINE);
                        sb.append("Content-Type: text/plain; charset=UTF-8\r\n");
                        sb.append("Content-Transfer-Encoding: 8bit\r\n");
                        sb.append(HttpClient.NEWLINE);
                        sb.append((String) entry.getValue());
                        sb.append(HttpClient.NEWLINE);
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    String fileName = BLFile.getFileName((String) list.get(i));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(HttpClient.ENDFLAG);
                    sb2.append(str2);
                    sb2.append(HttpClient.NEWLINE);
                    sb2.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + fileName + "\"" + HttpClient.NEWLINE);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Content-Type: ");
                    sb3.append((String) list2.get(i));
                    sb3.append(HttpClient.NEWLINE);
                    sb2.append(sb3.toString());
                    sb2.append("Content-Transfer-Encoding: binary\r\n");
                    sb2.append(HttpClient.NEWLINE);
                    outputStream.write(sb2.toString().getBytes("UTF-8"));
                    BLHttp.copyWithoutOutputClosing(new FileInputStream((String) list.get(i)), outputStream);
                    outputStream.write(HttpClient.NEWLINE.getBytes());
                    outputStream.write(str3.getBytes());
                    outputStream.flush();
                }
                outputStream.close();
            }
        });
        if (bArrPost != null && bArrPost.length != 0) {
            try {
                return new String(bArrPost, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                BLLog.e(e);
            }
        }
        return "";
    }

    public static byte[] get(String str) {
        return get(str, 1);
    }

    public static byte[] get(String str, int i) {
        BLHttp bLHttp = new BLHttp(str);
        bLHttp.setTryTimes(i);
        return bLHttp.get();
    }

    public byte[] post(byte[] bArr) throws Exception {
        if (this.mTryTimes <= 0) {
            return null;
        }
        try {
            byte[] bArrExcute = excute(this.mUrl, "POST", new ByteArrayInputStream(bArr));
            BLHttpListener bLHttpListener = this.mListener;
            if (bLHttpListener == null) {
                return bArrExcute;
            }
            bLHttpListener.uploadFinished(0);
            return bArrExcute;
        } catch (IOException e) {
            BLLog.e(e);
            throw e;
        } catch (Exception e2) {
            BLLog.e(e2);
            throw e2;
        }
    }

    public byte[] post(BLPostHandler bLPostHandler) {
        setPostHandler(bLPostHandler);
        byte[] bArrExcute = null;
        int i = 0;
        for (int i2 = 0; i2 < this.mTryTimes; i2++) {
            try {
                bArrExcute = excute(this.mUrl, "POST", null);
            } catch (IOException e) {
                BLLog.e(e);
                i = 1;
            } catch (Exception e2) {
                BLLog.e(e2);
                i = 3;
            }
            BLHttpListener bLHttpListener = this.mListener;
            if (bLHttpListener != null) {
                bLHttpListener.uploadFinished(i);
            }
            if (i == 0) {
                break;
            }
        }
        return bArrExcute;
    }

    public byte[] post(InputStream inputStream) {
        byte[] bArrExcute = null;
        int i = 0;
        for (int i2 = 0; i2 < this.mTryTimes; i2++) {
            try {
                bArrExcute = excute(this.mUrl, "POST", inputStream);
            } catch (IOException e) {
                BLLog.e(e);
                i = 1;
            } catch (Exception e2) {
                BLLog.e(e2);
                i = 3;
            }
            BLHttpListener bLHttpListener = this.mListener;
            if (bLHttpListener != null) {
                bLHttpListener.uploadFinished(i);
            }
            if (i == 0) {
                break;
            }
        }
        return bArrExcute;
    }

    public static byte[] post(String str, byte[] bArr) throws Exception {
        return post(str, bArr, 1);
    }

    public static byte[] post(String str, byte[] bArr, int i) throws Exception {
        BLHttp bLHttp = new BLHttp(str);
        bLHttp.setTryTimes(i);
        return bLHttp.post(bArr);
    }
}
