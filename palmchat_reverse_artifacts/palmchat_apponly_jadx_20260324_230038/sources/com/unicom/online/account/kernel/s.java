package com.unicom.online.account.kernel;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11169a = false;
    public static boolean b = false;
    private static final HostnameVerifier c = new HostnameVerifier() { // from class: com.unicom.online.account.kernel.s.1
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(Context context, String str, Object obj) throws Throwable {
        String host;
        HttpURLConnection httpURLConnection;
        URL url;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            url = new URL(str);
            host = url.getHost();
        } catch (MalformedURLException e) {
            e = e;
            host = str;
        }
        try {
            url.getPort();
        } catch (MalformedURLException e2) {
            e = e2;
            e.printStackTrace();
        }
        if (host.contains(f.e()) && b && f11169a) {
            if (!TextUtils.isEmpty(ac.f11151a)) {
                str = str.replaceFirst(f.e(), a(ac.f11151a));
            }
            b = false;
        }
        ab.b("\n■★■★■★■★■★■★■★■★■★■\n requestGetHttp() requestUrl - >" + str.substring(0, 25) + "...\n ...\n iRetry = " + ad.e() + "■★■★■★■★■★■★■★■★■★■\n");
        HttpsURLConnection httpsURLConnection = 0;
        try {
            try {
                URL url2 = new URL(str);
                httpURLConnection = (HttpURLConnection) (obj != null ? ((Network) obj).openConnection(url2) : url2.openConnection());
                try {
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.addRequestProperty("Connection", "close");
                    httpURLConnection.connect();
                    ab.b("connect cost:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    int responseCode = httpURLConnection.getResponseCode();
                    ab.b("\n■★■★■★■★■★■★■★■★■★■\n requestGetHttp() statusCode - >" + responseCode + "\n ■★■★■★■★■★■★■★■★■★■\n");
                    StringBuilder sb = new StringBuilder("response cost:");
                    sb.append(System.currentTimeMillis() - jCurrentTimeMillis2);
                    ab.b(sb.toString());
                    if (responseCode == 200) {
                        String strA = a(httpURLConnection.getInputStream());
                        if (!TextUtils.isEmpty(strA)) {
                            httpURLConnection.disconnect();
                            return strA;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", 410012);
                        jSONObject.put("msg", "outputStr isEmpty");
                        jSONObject.put("data", "requestUrl:".concat(str));
                        String string = jSONObject.toString();
                        httpURLConnection.disconnect();
                        return string;
                    }
                    if (responseCode != 302) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("code", 410010);
                        jSONObject2.put("msg", "http statusCode NOK ".concat(String.valueOf(responseCode)));
                        jSONObject2.put("data", "requestUrl:".concat(str));
                        String string2 = jSONObject2.toString();
                        httpURLConnection.disconnect();
                        return string2;
                    }
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    ab.b("redirectUrl is \n".concat(String.valueOf(headerField)));
                    ab.b("System.currentTimeMillis() is  \n" + System.currentTimeMillis());
                    if (TextUtils.isEmpty(headerField)) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("code", 410013);
                        jSONObject3.put("msg", "无跳转地址");
                        jSONObject3.put("data", host);
                        String string3 = jSONObject3.toString();
                        httpURLConnection.disconnect();
                        return string3;
                    }
                    if (headerField.startsWith(BaseConstants.SCHEME_HTTPS)) {
                        String strA2 = a(context, headerField, null, obj);
                        httpURLConnection.disconnect();
                        return strA2;
                    }
                    String strA3 = a(context, headerField, obj);
                    httpURLConnection.disconnect();
                    return strA3;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    try {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("code", 410024);
                        jSONObject4.put("msg", "http异常" + e.getMessage());
                        jSONObject4.put("data", "requestUrl->".concat(str));
                        String string4 = jSONObject4.toString();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return string4;
                    } catch (Exception unused) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                httpsURLConnection = "■★■★■★■★■★■★■★■★■★■\n";
                if (httpsURLConnection != 0) {
                    httpsURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (httpsURLConnection != 0) {
            }
            throw th;
        }
    }

    public final String a(Context context, String str, HashMap<String, String> map, Object obj) {
        String host;
        String strReplaceFirst = str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            host = new URL(strReplaceFirst).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            host = "";
        }
        String str2 = host;
        if (str2.contains(f.e()) && b && f11169a) {
            String strReplaceFirst2 = !TextUtils.isEmpty(ac.f11151a) ? strReplaceFirst.replaceFirst(f.e(), a(ac.f11151a)) : strReplaceFirst;
            b = false;
            strReplaceFirst = strReplaceFirst2;
        }
        ab.b("\n■★■★■★■★■★■★■★■★■★■\n requestGetHttps() requestUrl - >" + strReplaceFirst.substring(0, 30) + "...\n ...\n ■★■★■★■★■★■★■★■★■★■\n");
        try {
            URL url = new URL(strReplaceFirst);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) (obj != null ? ((Network) obj).openConnection(url) : url.openConnection());
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(false);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setInstanceFollowRedirects(false);
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setHostnameVerifier(c);
            httpsURLConnection.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(true);
            if (map != null) {
                for (String str3 : map.keySet()) {
                    httpsURLConnection.setRequestProperty(str3, map.get(str3));
                }
            }
            httpsURLConnection.addRequestProperty("Connection", "close");
            ab.b("TAG\thttpsURLConnection.connect();\n");
            httpsURLConnection.connect();
            ab.b("connect cost:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            int responseCode = httpsURLConnection.getResponseCode();
            ab.b("\n■★■★■★■★■★■★■★■★■★■\n requestGetHttps() statusCode - >" + responseCode + "\n ■★■★■★■★■★■★■★■★■★■\n");
            StringBuilder sb = new StringBuilder("response cost:");
            sb.append(System.currentTimeMillis() - jCurrentTimeMillis2);
            ab.b(sb.toString());
            if (responseCode == 200) {
                String strA = a(httpsURLConnection.getInputStream());
                if (!TextUtils.isEmpty(strA)) {
                    return strA;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 410012);
                jSONObject.put("msg", "outputStr isEmpty");
                jSONObject.put("data", "requestUrl:".concat(strReplaceFirst));
                return jSONObject.toString();
            }
            if (responseCode != 302) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 410010);
                jSONObject2.put("msg", "https statusCode NOK ".concat(String.valueOf(responseCode)));
                jSONObject2.put("data", "requestUrl:".concat(strReplaceFirst));
                return jSONObject2.toString();
            }
            String headerField = httpsURLConnection.getHeaderField(HttpHeaders.LOCATION);
            ab.b("redirectUrl is \n".concat(String.valueOf(headerField)));
            ab.b("System.currentTimeMillis() is  \n" + System.currentTimeMillis());
            if (!TextUtils.isEmpty(headerField)) {
                return headerField.startsWith(BaseConstants.SCHEME_HTTPS) ? a(context, headerField, null, obj) : a(context, headerField, obj);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("code", 410013);
            jSONObject3.put("msg", "无跳转地址");
            jSONObject3.put("data", str2);
            return jSONObject3.toString();
        } catch (Exception e2) {
            int iE = ad.e();
            ab.b("\n■★■★■★■★■★■★■★■★■★■\n iRetry = >" + iE + " \n   e-->" + e2 + "\n ■★■★■★■★■★■★■★■★■★■\n");
            e2.printStackTrace();
            String message = e2.getMessage();
            if (message == null || iE >= ad.d()) {
                try {
                    ab.b("catch (Exception e) is  ".concat(String.valueOf(e2)));
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("code", 410011);
                    jSONObject4.put("msg", "https异常 : ".concat(String.valueOf(message)));
                    jSONObject4.put("data", "requestUrl->".concat(strReplaceFirst));
                    return jSONObject4.toString();
                } catch (Exception unused) {
                    return null;
                }
            }
            int iF = ad.f();
            if (message.contains("resolve host")) {
                if (str2.contains(f.e()) || str2.contains(f.f())) {
                    ab.b("resolve host error: retry->" + iF + " times \ne_getMessage=" + message);
                    b = true;
                    f11169a = true;
                    if (!TextUtils.isEmpty(ac.f11151a)) {
                        strReplaceFirst = strReplaceFirst.replaceFirst(f.e(), a(ac.f11151a));
                    }
                    return a(context, strReplaceFirst, map, obj);
                }
            }
            if (message.contains("Failed to connect")) {
                ab.b("Failed to connect error: retry->" + iF + " times \ne_getMessage=" + message);
                return a(context, strReplaceFirst, map, obj);
            }
            ab.b("other  error: retry->" + iF + " times \ne_getMessage=" + message);
            return a(context, strReplaceFirst, map, obj);
        }
    }

    private static String a(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        byte[] bArr;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    bArr = new byte[1024];
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            th = th3;
        }
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            th = th2;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused2) {
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        String str = new String(byteArrayOutputStream.toByteArray());
        try {
            byteArrayOutputStream.close();
            inputStream.close();
        } catch (Exception unused3) {
        }
        return str;
    }

    private static String a(String str) {
        if (!str.contains(":")) {
            return str;
        }
        return "[" + str + "]";
    }
}
