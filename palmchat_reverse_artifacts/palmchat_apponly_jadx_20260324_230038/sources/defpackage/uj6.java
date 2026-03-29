package defpackage;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.x;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class uj6 {
    public URLConnection a(String str, Map<String, String> map, String str2) {
        boolean z;
        DNSNode[] dNSNodeArrI;
        try {
            URL url = new URL(str);
            Iterator<te1> it = it0.k().g().iterator();
            String str3 = null;
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                }
                te1 next = it.next();
                if (next.a(str) && (dNSNodeArrI = it0.k().i(next.f20971a)) != null && dNSNodeArrI.length > 0) {
                    str3 = dNSNodeArrI[0].host;
                }
            }
            LogUtil.i("WebViewHttpDns", "recursiveRequest path =" + str + ",ip=" + str3);
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            String strReplaceFirst = str.replaceFirst(url.getHost(), str3);
            LogUtil.i("WebViewHttpDns", "newUrl=" + strReplaceFirst);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strReplaceFirst).openConnection();
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setInstanceFollowRedirects(false);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            httpURLConnection.setRequestProperty("Host", url.getHost());
            if (httpURLConnection instanceof HttpsURLConnection) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                httpsURLConnection.setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
                HttpsHelper.getmInstance();
                httpsURLConnection.setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
            }
            int responseCode = httpURLConnection.getResponseCode();
            LogUtil.i("WebViewHttpDns", "url=" + url + " code=" + responseCode);
            if (responseCode < 300 || responseCode >= 400) {
                return httpURLConnection;
            }
            if (map != null) {
                Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (it2.next().getKey().contains("Cookie")) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                return null;
            }
            String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
            if (headerField == null) {
                headerField = httpURLConnection.getHeaderField("location");
            }
            if (headerField == null) {
                return null;
            }
            if (!headerField.startsWith("http://") && !headerField.startsWith("https://")) {
                URL url2 = new URL(str);
                headerField = url2.getProtocol() + "://" + url2.getHost() + headerField;
            }
            return a(headerField, map, str);
        } catch (MalformedURLException e) {
            Log.w("WebViewHttpDns", "recursiveRequest MalformedURLException", e);
            return null;
        } catch (IOException e2) {
            Log.w("WebViewHttpDns", "recursiveRequest IOException", e2);
            return null;
        } catch (Exception e3) {
            Log.w("WebViewHttpDns", "unknow exception", e3);
            return null;
        }
    }

    public WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest) {
        String strSubstring;
        String str;
        if (webResourceRequest != null && webResourceRequest.getUrl() != null) {
            String strTrim = webResourceRequest.getUrl().getScheme().trim();
            String method = webResourceRequest.getMethod();
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            String string = webResourceRequest.getUrl().toString();
            if ((strTrim.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) || strTrim.equalsIgnoreCase(BaseConstants.SCHEME_HTTPS)) && method.equalsIgnoreCase("get") && kj2.d(string) && !string.contains(CordovaWebViewClient.ZX_LOCAL_RES)) {
                try {
                    URLConnection uRLConnectionA = a(string, requestHeaders, null);
                    if (uRLConnectionA == null) {
                        return null;
                    }
                    String contentType = uRLConnectionA.getContentType();
                    if (contentType != null) {
                        str = contentType.split(x.aQ)[0];
                        String[] strArrSplit = contentType.split(x.aQ);
                        if (strArrSplit.length > 1) {
                            strSubstring = strArrSplit[1];
                            if (strSubstring.contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
                                strSubstring = strSubstring.substring(strSubstring.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1);
                            }
                        } else {
                            strSubstring = null;
                        }
                        if (strSubstring == null && (contentType.startsWith("text/") || contentType.contains("javascript") || contentType.contains("text/html") || contentType.contains("text/css") || contentType.contains("application/javascript") || contentType.contains("text/javascript"))) {
                            strSubstring = "UTF-8";
                        }
                    } else {
                        strSubstring = null;
                        str = null;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionA;
                    int responseCode = httpURLConnection.getResponseCode();
                    String responseMessage = httpURLConnection.getResponseMessage();
                    Set<String> setKeySet = httpURLConnection.getHeaderFields().keySet();
                    LogUtil.i("WebViewHttpDns", "intercept mime =" + str + " charset=" + strSubstring + " contentType=" + contentType);
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    if (TextUtils.isEmpty(strSubstring) && !str.startsWith("image") && !str.startsWith("audio") && !str.startsWith("video")) {
                        return null;
                    }
                    WebResourceResponse webResourceResponse = new WebResourceResponse(str, strSubstring, httpURLConnection.getInputStream());
                    webResourceResponse.setStatusCodeAndReasonPhrase(responseCode, responseMessage);
                    HashMap map = new HashMap();
                    for (String str2 : setKeySet) {
                        map.put(str2, httpURLConnection.getHeaderField(str2));
                    }
                    webResourceResponse.setResponseHeaders(map);
                    LogUtil.i("WebViewHttpDns", "intercept success charset =" + strSubstring + " mime=" + str);
                    return webResourceResponse;
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtil.i("WebViewHttpDns", "shouldInterceptRequest error", e);
                }
            }
        }
        return null;
    }
}
