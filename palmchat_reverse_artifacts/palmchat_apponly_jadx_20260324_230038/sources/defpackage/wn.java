package defpackage;

import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wn {
    public static SSLSocketFactory g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21754a;
    public Proxy b;
    public Map<String, String> c = new HashMap();
    public int d = 30000;
    public int e = 30000;
    public int f = 1;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements HostnameVerifier {
        public a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public wn(String str) {
        this.f21754a = str;
    }

    public static String a(Map<String, String> map) {
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
                ma3.c(e);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static byte[] e(String str) {
        return f(str, 1);
    }

    public static byte[] f(String str, int i) {
        wn wnVar = new wn(str);
        wnVar.m(i);
        return wnVar.d();
    }

    public static String i(String str, Map<String, String> map) {
        try {
            return j(str, map, 1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String j(String str, Map<String, String> map, int i) throws Exception {
        return l(str, a(map), i);
    }

    public static String l(String str, String str2, int i) throws Exception {
        return new wn(str).k(str2);
    }

    public final byte[] b(InputStream inputStream, int i) throws IOException {
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

    public final byte[] c(String str, String str2, InputStream inputStream) throws Exception {
        HttpURLConnection httpURLConnection;
        ma3.g("%s %s", str2, str);
        URL url = new URL(str);
        String protocol = url.getProtocol();
        if (protocol == null || protocol.length() == 0) {
            throw new IOException("protocol is null");
        }
        if (protocol.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            Proxy proxy = this.b;
            httpURLConnection = proxy != null ? (HttpURLConnection) url.openConnection(proxy) : (HttpURLConnection) url.openConnection();
        } else if (protocol.equals(BaseConstants.SCHEME_HTTPS)) {
            Proxy proxy2 = this.b;
            HttpsURLConnection httpsURLConnection = proxy2 != null ? (HttpsURLConnection) url.openConnection(proxy2) : (HttpsURLConnection) url.openConnection();
            if (g == null) {
                g = SSLContext.getInstance("Default").getSocketFactory();
            }
            httpsURLConnection.setSSLSocketFactory(g);
            httpsURLConnection.setHostnameVerifier(new a());
            httpURLConnection = httpsURLConnection;
        } else {
            httpURLConnection = null;
        }
        if (httpURLConnection == null) {
            throw new IOException("connection is null");
        }
        httpURLConnection.setConnectTimeout(this.d);
        httpURLConnection.setReadTimeout(this.e);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setDoInput(true);
        for (String str3 : this.c.keySet()) {
            String str4 = this.c.get(str3);
            ma3.g("%s=%s", str3, str4);
            httpURLConnection.setRequestProperty(str3, str4);
        }
        if ("POST".equals(str2)) {
            httpURLConnection.setDoOutput(true);
            if (inputStream != null) {
                g(httpURLConnection.getOutputStream(), inputStream);
                inputStream.close();
            }
        }
        httpURLConnection.connect();
        ma3.g("responseCode:%d responseMessage:%s", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage());
        InputStream inputStream2 = httpURLConnection.getInputStream();
        if (inputStream2 == null) {
            inputStream2 = httpURLConnection.getErrorStream();
        }
        byte[] bArrB = b(inputStream2, httpURLConnection.getContentLength());
        httpURLConnection.disconnect();
        return bArrB;
    }

    public byte[] d() {
        byte[] bArrC = null;
        char c = 0;
        for (int i = 0; i < this.f; i++) {
            try {
                bArrC = c(this.f21754a, "GET", null);
            } catch (IOException e) {
                ma3.c(e);
                c = 1;
            } catch (Exception e2) {
                ma3.c(e2);
                c = 3;
            }
            if (c == 0) {
                break;
            }
        }
        return bArrC;
    }

    public final void g(OutputStream outputStream, InputStream inputStream) throws IOException {
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

    public byte[] h(byte[] bArr) throws Exception {
        if (this.f <= 0) {
            return null;
        }
        try {
            return c(this.f21754a, "POST", new ByteArrayInputStream(bArr));
        } catch (IOException e) {
            ma3.c(e);
            throw e;
        } catch (Exception e2) {
            ma3.c(e2);
            throw e2;
        }
    }

    public String k(String str) throws Exception {
        byte[] bArrH = h(str.getBytes("UTF-8"));
        if (bArrH != null && bArrH.length != 0) {
            try {
                return new String(bArrH, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ma3.c(e);
            }
        }
        return "";
    }

    public void m(int i) {
        this.f = i;
    }
}
