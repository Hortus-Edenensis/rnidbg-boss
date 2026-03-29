package defpackage;

import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.ad.model.GDTDownloadRespBean;
import com.zenmen.palmchat.ad.model.WKRson;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class kw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f18842a = "ReportManager";

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18843a;
        public final /* synthetic */ s7 b;

        public a(String str, s7 s7Var) {
            this.f18843a = str;
            this.b = s7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            s7 s7Var;
            try {
                HttpURLConnection httpURLConnectionE = kw4.e(this.f18843a);
                if (httpURLConnectionE.getResponseCode() == 200 && (s7Var = this.b) != null && s7Var.A() && this.b.z()) {
                    String strC = kw4.c(httpURLConnectionE.getInputStream());
                    LogUtil.d(kw4.f18842a, "result = " + strC);
                    GDTDownloadRespBean gDTDownloadRespBean = (GDTDownloadRespBean) new WKRson().fromJson(strC, GDTDownloadRespBean.class);
                    if (gDTDownloadRespBean != null) {
                        this.b.h0(gDTDownloadRespBean);
                    }
                }
            } catch (Exception e) {
                LogUtil.d(kw4.f18842a, "exception = " + e.toString());
            }
        }
    }

    public static String c(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line + "/n");
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    inputStream.close();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        inputStream.close();
        return sb.toString();
    }

    public static URL d(URL url, String str) throws IOException {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if (BaseConstants.SCHEME_HTTPS.equals(protocol) || HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
    
        throw new java.io.IOException("protocol is null");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpURLConnection e(String str) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i > 5) {
                throw new ProtocolException("Too many redirects: " + i2);
            }
            String protocol = url.getProtocol();
            if (protocol == null || protocol.length() == 0) {
                break;
            }
            if (protocol.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else if (protocol.equals(BaseConstants.SCHEME_HTTPS)) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                HttpsHelper.getmInstance();
                httpsURLConnection.setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
                httpsURLConnection.setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = null;
            }
            if (httpURLConnection == null) {
                throw new IOException("connection is null");
            }
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                return httpURLConnection;
            }
            String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
            httpURLConnection.disconnect();
            url = d(url, headerField);
            i = i2;
        }
    }

    public static void f(String str, String str2, s7 s7Var) {
        LogUtil.i(f18842a, "report oldUrl = " + str + "-----newUrl = " + str2);
        l6.d().e().execute(new a(str2, s7Var));
    }
}
