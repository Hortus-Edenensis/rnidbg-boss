package com.lantern.core.network;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.efs.sdk.base.Constants;
import com.lantern.core.MobEvent;
import com.lantern.core.network.utils.NECallback;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NEHttp {
    private static final int BUFFER = 1024;
    public static final int COMPRESS_ERROR = 4;
    public static final int NETWORK_ERROR = 1;
    public static final int OK = 0;
    public static final int OTHER_ERROR = 3;
    public static final int SERVER_ERROR = 2;
    private static int sDnsIpv6 = -1;
    private NECallback mCallBack;
    private String mUrl;
    private Map<String, String> mHeaders = new HashMap();
    private int mConnectTimeout = 30000;
    private int mReadTimeout = 90000;
    private int mTryTimes = 1;
    private int mUseCacheMode = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static class DNS {
        public String dirIP;
        public String host;
        public String newURL;
    }

    public NEHttp(String str, NECallback nECallback) {
        this.mUrl = str;
        this.mCallBack = nECallback;
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

    private byte[] download(InputStream inputStream, int i) throws IOException {
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

    private byte[] excute(String str, String str2, InputStream inputStream) throws IOException {
        DNS url = parseURL(str);
        if (url != null) {
            str = url.newURL;
        }
        URL url2 = new URL(str);
        String protocol = url2.getProtocol();
        if (protocol == null || protocol.length() == 0) {
            throw new IOException("protocol is null");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
        setHostHeader(httpURLConnection, url);
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
        httpURLConnection.setDoInput(true);
        for (String str3 : this.mHeaders.keySet()) {
            httpURLConnection.setRequestProperty(str3, this.mHeaders.get(str3));
        }
        if ("POST".equals(str2)) {
            httpURLConnection.setDoOutput(true);
            if (inputStream != null) {
                post(httpURLConnection.getOutputStream(), inputStream);
                inputStream.close();
            }
        }
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        String responseMessage = httpURLConnection.getResponseMessage();
        InputStream inputStream2 = httpURLConnection.getInputStream();
        if (inputStream2 == null) {
            inputStream2 = httpURLConnection.getErrorStream();
        }
        byte[] bArrDownload = download(inputStream2, httpURLConnection.getContentLength());
        if (this.mCallBack != null && (bArrDownload == null || bArrDownload.length == 0)) {
            setCallBackMsg(responseMessage, responseCode);
        }
        httpURLConnection.disconnect();
        return bArrDownload;
    }

    private boolean isGzipRequest() {
        if (this.mHeaders.containsKey("Content-Encoding")) {
            return Constants.CP_GZIP.equals(this.mHeaders.get("Content-Encoding"));
        }
        return false;
    }

    public static DNS parseURL(String str) {
        Inet6Address inet6Address;
        if (sDnsIpv6 == -1) {
            sDnsIpv6 = MobEvent.getForceDnsIpv6();
        }
        if (sDnsIpv6 == 1 && !TextUtils.isEmpty(str) && URLUtil.isHttpUrl(str)) {
            String host = Uri.parse(str).getHost();
            try {
                InetAddress[] allByName = InetAddress.getAllByName(host);
                if (allByName != null && allByName.length != 0) {
                    int length = allByName.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        InetAddress inetAddress = allByName[i];
                        if (!(inetAddress instanceof Inet6Address)) {
                            i++;
                        } else if (inetAddress.isReachable(15000)) {
                            inet6Address = (Inet6Address) inetAddress;
                        }
                    }
                    inet6Address = null;
                    if (inet6Address != null) {
                        DNS dns = new DNS();
                        dns.host = host;
                        String hostAddress = inet6Address.getHostAddress();
                        dns.dirIP = hostAddress;
                        dns.newURL = str.replace(host, String.format("[%s]", hostAddress));
                        return dns;
                    }
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    private void post(OutputStream outputStream, InputStream inputStream) throws IOException {
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

    private void setCallBackMsg(String str, int i) {
        NECallback nECallback = this.mCallBack;
        if (nECallback != null) {
            nECallback.run(0, str, Integer.valueOf(i));
        }
    }

    public static void setForceDnsIpv6(int i) {
        sDnsIpv6 = i;
    }

    public static void setHostHeader(URLConnection uRLConnection, DNS dns) {
        if (uRLConnection == null || dns == null) {
            return;
        }
        uRLConnection.setRequestProperty("host", dns.host);
    }

    public void setHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
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

    public byte[] post(byte[] bArr) {
        char c;
        if (isGzipRequest()) {
            try {
                bArr = compress(bArr);
                c = 0;
            } catch (Exception e) {
                this.mHeaders.remove("Content-Encoding");
                setCallBackMsg(e.getMessage(), -1);
                c = 4;
            }
        } else {
            c = 0;
        }
        byte[] bArrExcute = null;
        for (int i = 0; i < this.mTryTimes; i++) {
            try {
                bArrExcute = excute(this.mUrl, "POST", new ByteArrayInputStream(bArr));
            } catch (IOException e2) {
                setCallBackMsg(e2.getMessage(), -1);
                c = 1;
            } catch (Exception e3) {
                setCallBackMsg(e3.getMessage(), -1);
                c = 3;
            }
            if (c == 0) {
                break;
            }
        }
        return bArrExcute;
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

    public static byte[] post(String str, byte[] bArr, NECallback nECallback) {
        NEHttp nEHttp = new NEHttp(str, nECallback);
        nEHttp.setHeader("Content-Type", "application/octet-stream");
        nEHttp.setHeader("User-Agent", "a");
        return nEHttp.post(bArr);
    }
}
