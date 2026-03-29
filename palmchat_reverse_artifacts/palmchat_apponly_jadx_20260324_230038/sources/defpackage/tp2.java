package defpackage;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.AppContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.f;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class tp2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c[] f21032a = {new c("mparticle.uc.cn", "来自UC链接", "https://image.uc.cn/favicon.ico"), new c("www.douban.com", "来自豆瓣链接", "https://img3.doubanio.com/favicon.ico")};
    public static final Pattern[] b = {Pattern.compile("rel=[\"']shortcut icon[\"'][^\r\n>]+?((?<=href=[\"']).+?(?=[\"']))"), Pattern.compile("((?<=href=[\"']).+?(?=[\"']))[^\r\n<]+?rel=[\"']shortcut icon[\"']")};
    public static final Pattern c = Pattern.compile("</head>");
    public static final HostnameVerifier d = new a();
    public static SSLSocketFactory e = q().getSocketFactory();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public String b;
        public String c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21033a = 6;
        public int d = 0;

        public b(String str) {
            this.b = str;
            this.c = str;
        }

        public boolean a() {
            return this.d <= 6;
        }

        public String b() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
            this.d++;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21034a;
        public String b;
        public String c;

        public c(String str, String str2, String str3) {
            this.f21034a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    public static HttpURLConnection a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        System.getProperty("http.agent");
        httpURLConnection.setRequestProperty("User-Agent", WebSettings.getDefaultUserAgent(AppContext.getContext()));
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(e);
            httpsURLConnection.setHostnameVerifier(d);
        }
        return httpURLConnection;
    }

    public static c b(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(zy4.c(str))) {
            return null;
        }
        for (c cVar : f21032a) {
            if (str.toLowerCase().contains(cVar.f21034a)) {
                return cVar;
            }
        }
        return null;
    }

    public static String c(String str) {
        Document documentP = p(str);
        if (documentP == null) {
            return null;
        }
        for (f fVar : documentP.q0("meta")) {
            if ("description".equalsIgnoreCase(fVar.f("name"))) {
                return fVar.f("content");
            }
        }
        return null;
    }

    public static String d(String str) {
        int iIndexOf;
        String strReplace = (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf("charset=")) == -1) ? null : str.substring(iIndexOf + 8).replace("]", "");
        return (TextUtils.isEmpty(strReplace) || !Charset.isSupported(strReplace)) ? "UTF-8" : strReplace;
    }

    public static String e(String str, String str2) {
        String strB;
        String string;
        if (str == null || str2 == null) {
            return null;
        }
        if (pf2.c(str2)) {
            String strB2 = new lk6().b(str);
            if (!TextUtils.isEmpty(strB2)) {
                return strB2;
            }
        }
        Document documentP = p(str);
        if (documentP == null) {
            return null;
        }
        String strH = h(documentP);
        if (TextUtils.isEmpty(strH)) {
            strH = f("apple-touch-icon", documentP, true);
        }
        if (TextUtils.isEmpty(strH)) {
            strH = f("icon", documentP, false);
        }
        if (TextUtils.isEmpty(strH)) {
            strH = f("shortcut icon", documentP, false);
        }
        if (!TextUtils.isEmpty(strH) && !URLUtil.isNetworkUrl(strH)) {
            try {
                URL url = new URL(str2);
                if (strH.startsWith("//")) {
                    string = url.getProtocol() + ":" + strH;
                } else if (strH.charAt(0) == '/') {
                    string = url.getProtocol() + "://" + url.getHost() + strH;
                } else {
                    String path = url.getPath();
                    StringBuilder sb = new StringBuilder();
                    sb.append(url.getProtocol());
                    sb.append("://");
                    sb.append(url.getHost());
                    sb.append(path);
                    sb.append(path.endsWith("/") ? "" : "/");
                    sb.append(strH);
                    string = sb.toString();
                }
                strH = string;
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                strH = null;
            }
        }
        String str3 = (TextUtils.isEmpty(strH) || strH.length() <= 256) ? strH : null;
        return (!TextUtils.isEmpty(str3) || (strB = pf2.b(str2)) == null) ? TextUtils.isEmpty(str3) ? g(str) : str3 : strB;
    }

    public static String f(String str, Document document, boolean z) {
        if (TextUtils.isEmpty(str) || document == null) {
            return null;
        }
        Elements elementsP0 = z ? document.p0("rel", str) : document.o0("rel", str);
        if (elementsP0.size() <= 0) {
            return null;
        }
        Iterator<f> it = elementsP0.iterator();
        while (it.hasNext()) {
            String strF = it.next().f("href");
            Log.e("FindIcon", "href is " + strF);
            if (!TextUtils.isEmpty(strF) && !strF.endsWith(".svg")) {
                return strF;
            }
        }
        return null;
    }

    public static String g(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("<img.*src\\s*=\\s*(.*?)[^>]*?>", 2).matcher(str);
        while (matcher.find()) {
            Matcher matcher2 = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(matcher.group());
            while (matcher2.find()) {
                if (!TextUtils.isEmpty(matcher2.group(1))) {
                    arrayList.add(matcher2.group(1));
                }
            }
        }
        return !arrayList.isEmpty() ? (String) arrayList.get(0) : "";
    }

    public static String h(Document document) {
        Elements elementsH0 = document.H0("meta[property=og:image");
        return (elementsH0 == null || elementsH0.isEmpty()) ? "" : elementsH0.get(0).f("content");
    }

    public static String i(Document document) {
        Elements elementsH0 = document.H0("meta[property=og:title");
        return (elementsH0 == null || elementsH0.isEmpty()) ? "" : elementsH0.get(0).f("content");
    }

    public static String j(String str, String str2) {
        Document documentP;
        if (pf2.c(str2)) {
            String strA = new lk6().a(str);
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        if (str == null || (documentP = p(str)) == null) {
            return null;
        }
        String strI = i(documentP);
        return TextUtils.isEmpty(strI) ? documentP.Y0() : strI;
    }

    public static String[] k(b bVar, String str, boolean z, boolean z2) throws Throwable {
        HttpURLConnection httpURLConnectionA;
        String line;
        String[] strArr = new String[2];
        StringBuilder sb = new StringBuilder();
        Pattern patternCompile = Pattern.compile("<head>[\\s\\S]+?<\\/?head>");
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    httpURLConnectionA = a(bVar.b());
                    try {
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e = e4;
                httpURLConnectionA = null;
            } catch (Throwable th) {
                th = th;
                httpURLConnectionA = null;
            }
            if (bVar.a() && (httpURLConnectionA.getResponseCode() == 301 || httpURLConnectionA.getResponseCode() == 302)) {
                String headerField = httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION);
                if (!headerField.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    headerField = bVar.b() + "/" + headerField;
                }
                bVar.c(headerField);
                String[] strArrK = k(bVar, str, z, z2);
                try {
                    httpURLConnectionA.disconnect();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return strArrK;
            }
            strArr[0] = httpURLConnectionA.getURL().toString();
            if (z && httpURLConnectionA.getResponseCode() != 200) {
                try {
                    httpURLConnectionA.disconnect();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return strArr;
            }
            if (TextUtils.isEmpty(str)) {
                str = d(httpURLConnectionA.getContentType());
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnectionA.getInputStream(), Charset.forName(str)));
            while (true) {
                try {
                    line = bufferedReader2.readLine();
                    if (line != null) {
                        if (line.contains("charset=")) {
                            String strO = o(line);
                            if (!TextUtils.isEmpty(strO) && !strO.equalsIgnoreCase(str)) {
                                String[] strArrK2 = k(new b(strArr[0]), strO, z, z2);
                                try {
                                    bufferedReader2.close();
                                    httpURLConnectionA.disconnect();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                                return strArrK2;
                            }
                        }
                        sb.append(line);
                        sb.append("\n");
                        if (z2 && patternCompile.matcher(sb).find()) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception e8) {
                    e = e8;
                    bufferedReader = bufferedReader2;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                            throw th;
                        }
                    }
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                    }
                    throw th;
                }
            }
            String str2 = strArr[0];
            if (!HttpHost.DEFAULT_SCHEME_NAME.equals(zy4.f(str2)) || !TextUtils.isEmpty(line)) {
                bufferedReader2.close();
                httpURLConnectionA.disconnect();
                strArr[1] = sb.toString();
                return strArr;
            }
            String[] strArrK3 = k(new b(str2.replaceFirst(HttpHost.DEFAULT_SCHEME_NAME, BaseConstants.SCHEME_HTTPS)), str, z, z2);
            try {
                bufferedReader2.close();
                httpURLConnectionA.disconnect();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return strArrK3;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String[] l(String str) {
        b bVar = new b(str);
        return pf2.c(str) ? k(bVar, null, false, false) : k(bVar, null, false, true);
    }

    public static String[] m(String str, boolean z) {
        b bVar = new b(str);
        return pf2.c(str) ? k(bVar, null, z, false) : k(bVar, null, z, true);
    }

    public static String[] n(String str, boolean z, boolean z2) {
        b bVar = new b(str);
        return pf2.c(str) ? k(bVar, null, z, false) : k(bVar, null, z, z2);
    }

    public static String o(String str) {
        int iIndexOf;
        Document documentP = p(str);
        String strReplace = null;
        if (documentP != null) {
            Iterator<f> it = documentP.q0("meta").iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f next = it.next();
                if ("Content-Type".equalsIgnoreCase(next.f("http-equiv"))) {
                    String strF = next.f("content");
                    if (!TextUtils.isEmpty(strF) && (iIndexOf = strF.indexOf("charset=")) != -1) {
                        strReplace = strF.substring(iIndexOf + 8).replace("]", "");
                    }
                }
            }
        }
        return (TextUtils.isEmpty(strReplace) || !Charset.isSupported(strReplace)) ? "" : strReplace;
    }

    public static Document p(String str) {
        try {
            return cz2.a(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static SSLContext q() {
        SSLContext sSLContext;
        TrustManager[] trustManagerArr = {new d()};
        SSLContext sSLContext2 = null;
        try {
            try {
                sSLContext = SSLContext.getInstance("SSL");
            } catch (Throwable unused) {
                return null;
            }
        } catch (KeyManagementException e2) {
            e = e2;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
        }
        try {
            sSLContext.init(null, trustManagerArr, null);
            return sSLContext;
        } catch (KeyManagementException e4) {
            e = e4;
            sSLContext2 = sSLContext;
            e.printStackTrace();
            return sSLContext2;
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            sSLContext2 = sSLContext;
            e.printStackTrace();
            return sSLContext2;
        } catch (Throwable unused2) {
            return sSLContext;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements TrustManager, X509TrustManager {
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
