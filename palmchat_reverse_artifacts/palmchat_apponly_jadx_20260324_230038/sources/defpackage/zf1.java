package defpackage;

import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zf1 {
    public static HttpURLConnection a(String str, Map<String, String> map, int i, int i2) throws IOException {
        URL url = new URL(k86.R(str));
        LogUtil.i("DownloadUtil", "createConnectionForDownload url=" + url);
        HttpURLConnection httpURLConnectionD = k86.d(url);
        httpURLConnectionD.setConnectTimeout(i);
        httpURLConnectionD.setReadTimeout(i2);
        httpURLConnectionD.setInstanceFollowRedirects(false);
        if (map != null) {
            for (String str2 : map.keySet()) {
                httpURLConnectionD.addRequestProperty(str2, map.get(str2));
            }
        }
        b13.a(httpURLConnectionD);
        if (httpURLConnectionD instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnectionD;
            HttpsHelper.getmInstance();
            httpsURLConnection.setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
            httpsURLConnection.setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
        }
        return httpURLConnectionD;
    }
}
