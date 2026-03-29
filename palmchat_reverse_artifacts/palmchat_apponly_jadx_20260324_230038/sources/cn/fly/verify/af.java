package cn.fly.verify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import android.webkit.WebSettings;
import cn.fly.verify.common.exception.VerifyException;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.wifi.ad.core.config.EventParams;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f2062a;
    private HashMap<String, Object> b;

    public af(HashMap<String, Object> map, HashMap<String, Object> map2) {
        this.f2062a = map;
        this.b = map2;
    }

    private String b(Context context) {
        String defaultUserAgent;
        try {
            defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        } catch (Exception unused) {
            defaultUserAgent = null;
        }
        StringBuilder sb = new StringBuilder();
        int length = defaultUserAgent.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = defaultUserAgent.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public String a(Context context) {
        String strB;
        if (context != null) {
            try {
                strB = b(context);
            } catch (Throwable unused) {
                strB = null;
            }
        } else {
            strB = null;
        }
        return TextUtils.isEmpty(strB) ? "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1" : strB;
    }

    private HashMap<String, Object> b(Network network, String str, HttpURLConnection httpURLConnection) {
        int responseCode;
        HashMap<String, Object> map = new HashMap<>();
        if (httpURLConnection != null) {
            try {
                responseCode = httpURLConnection.getResponseCode();
            } catch (Throwable unused) {
                Throwable th = new Throwable("CU_HTTP_REQUEST_FAILED");
                map.put("code", 1);
                map.put("res", th.getMessage());
                return map;
            }
        } else {
            responseCode = -1;
        }
        if (responseCode == 200) {
            String strA = a(httpURLConnection, "UTF-8");
            map.put("code", 0);
            map.put("res", strA);
            return map;
        }
        if (responseCode != 301 && responseCode != 302) {
            Throwable th2 = new Throwable("CU_SERVER_RESPONSE_CODE");
            map.put("code", 1);
            map.put("res", th2.getMessage());
            return map;
        }
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
        String headerField2 = httpURLConnection.getHeaderField("Set-Cookie");
        String path = httpURLConnection.getURL().getPath();
        if (TextUtils.isEmpty(headerField)) {
            Throwable th3 = new Throwable("CU_NO_REDIRECT_ADDRESS_CODE");
            map.put("code", 1);
            map.put("res", th3.getMessage());
            return map;
        }
        HttpURLConnection httpURLConnectionA = a(network, headerField);
        if (TextUtils.isEmpty(headerField2)) {
            httpURLConnectionA.setRequestProperty("Cookie", "");
        } else {
            "/ctcnet/gctcmc.do".equals(path);
            httpURLConnectionA.setRequestProperty("Cookie", headerField2);
        }
        return a(network, "GET", httpURLConnectionA);
    }

    public String a(HttpURLConnection httpURLConnection, String str) {
        StringBuilder sb;
        if (httpURLConnection != null) {
            try {
                sb = new StringBuilder();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), str));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append('\n');
                    }
                } catch (UnsupportedEncodingException | IOException unused) {
                }
            } catch (UnsupportedEncodingException | IOException unused2) {
                sb = null;
            }
        } else {
            sb = null;
        }
        if (sb == null) {
            return null;
        }
        return sb.toString().trim();
    }

    @SuppressLint({"DefaultLocale"})
    public HttpURLConnection a(Network network, String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            throw new Throwable("CU_HTTP_URL_EMPTY");
        }
        URL url = new URL(str);
        String strJ = al.j();
        URLConnection uRLConnectionOpenConnection = network != null ? (HttpURLConnection) network.openConnection(url) : null;
        if (uRLConnectionOpenConnection == null) {
            uRLConnectionOpenConnection = url.openConnection();
        } else if (strJ.equalsIgnoreCase("WIFI")) {
            strJ = "2";
        }
        if (uRLConnectionOpenConnection == null) {
            throw new Throwable("CU_HTTP_CHANNEL_OPEN_FAILED");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("user-agent", a(ax.g()));
        httpURLConnection.setRequestProperty(EventParams.KEY_PARAM_NETTYPE, String.valueOf(strJ));
        httpURLConnection.setRequestProperty("os", "android");
        HashMap<String, Object> map = this.b;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : this.b.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), (String) entry.getValue());
            }
        }
        return httpURLConnection;
    }

    private HashMap<String, Object> a(Network network, String str, HttpURLConnection httpURLConnection) {
        HashMap<String, Object> map = new HashMap<>();
        if (httpURLConnection != null) {
            try {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("connection", "keep-alive");
                if ("POST".equals(str) && this.f2062a != null) {
                    httpURLConnection.setRequestMethod(str);
                    httpURLConnection.connect();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(ag.a(this.f2062a).getBytes("utf-8"));
                    httpURLConnection.getOutputStream().write(byteArrayOutputStream.toByteArray());
                }
            } catch (Throwable th) {
                map.put("code", 1);
                map.put("res", th.getMessage());
                return map;
            }
        }
        return b(network, str, httpURLConnection);
    }

    public void a(Network network, String str, cn.fly.verify.common.callback.b bVar, String str2) {
        VerifyException verifyException;
        try {
            HashMap<String, Object> mapA = a(network, "POST", a(network, str));
            int iIntValue = (mapA == null || !mapA.containsKey("code")) ? -1 : ((Integer) mapA.get("code")).intValue();
            String str3 = (mapA == null || !mapA.containsKey("res")) ? null : (String) mapA.get("res");
            if (iIntValue != 0 || str3 == null) {
                verifyException = new VerifyException(302002, str3);
            } else {
                try {
                    int iOptInt = new JSONObject(str3).optInt("code");
                    if (iOptInt != 0) {
                        bVar.a(new VerifyException(iOptInt, str3));
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(ag.a(new JSONObject(str3).optString(MapBundleKey.MapObjKey.OBJ_SL_OBJ), str2));
                        String strOptString = jSONObject.optString("accessCode");
                        String strOptString2 = jSONObject.optString("fakeMobile");
                        long jOptLong = jSONObject.optLong(com.umeng.analytics.pro.bd.b);
                        HashMap map = new HashMap();
                        map.put("optoken", strOptString);
                        map.put("expired", Long.valueOf(jOptLong));
                        map.put("phone", strOptString2);
                        bVar.a(map);
                        return;
                    } catch (Throwable th) {
                        bVar.a(new VerifyException(302001, as.a(th)));
                        return;
                    }
                } catch (Throwable th2) {
                    verifyException = new VerifyException(302003, as.a(th2));
                }
            }
            bVar.a(verifyException);
        } catch (Throwable th3) {
            bVar.a(new VerifyException(302002, as.a(th3)));
        }
    }
}
