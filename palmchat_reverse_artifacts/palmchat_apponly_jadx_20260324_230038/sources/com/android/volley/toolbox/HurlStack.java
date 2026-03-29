package com.android.volley.toolbox;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.CustomAuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.HttpClientStack;
import com.baidu.mapapi.http.wrapper.HttpManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qiniu.android.http.dns.DnsSource;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zm.fissionsdk.WVVzW;
import defpackage.ap3;
import defpackage.it0;
import defpackage.k86;
import defpackage.nl0;
import defpackage.pw3;
import defpackage.rl0;
import defpackage.te1;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class HurlStack implements HttpStack {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String TAG = "HurlStack";
    final HostnameVerifier DO_NOT_VERIFY;
    private final SSLSocketFactory mSslSocketFactory;
    private final UrlRewriter mUrlRewriter;

    /* JADX INFO: compiled from: SearchBox */
    public interface UrlRewriter {
        String rewriteUrl(String str);
    }

    public HurlStack() {
        this(null);
    }

    private static void addBodyIfExists(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        if (EncryptedJsonRequest.ENCRYPT_CHECK_ENABLE && (request instanceof EncryptedJsonRequest)) {
            EncryptedJsonRequest encryptedJsonRequest = (EncryptedJsonRequest) request;
            if (!encryptedJsonRequest.isBodyEncrypted()) {
                String str = EncryptedJsonRequest.TAG;
                LogUtil.i(str, "body is not encrypt" + request.getUrl());
                if (AppContext.getSecretKey() == null) {
                    LogUtil.i(str, "body can't encrypt");
                    throw new CustomAuthFailureError("EncryptedJsonRequest body is not encrypted " + request.getUrl());
                }
                encryptedJsonRequest.encryptBodyWithSkey();
                LogUtil.i(str, "body append encrypt");
            }
        }
        byte[] body = request.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", request.getBodyContentType());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(body);
            dataOutputStream.close();
        }
    }

    private HttpResponse doRequest(String str, Request<?> request, Map<String, String> map, boolean z, boolean z2) throws IOException, AuthFailureError {
        if (request != null && request.isCanceled()) {
            throw new IOException("request has Canceled");
        }
        HashMap map2 = new HashMap();
        map2.putAll(request.getHeaders());
        map2.putAll(map);
        UrlRewriter urlRewriter = this.mUrlRewriter;
        if (urlRewriter != null) {
            String strRewriteUrl = urlRewriter.rewriteUrl(str);
            if (strRewriteUrl == null) {
                throw new IOException("URL blocked by rewriter: " + str);
            }
            str = strRewriteUrl;
        }
        if (EncryptedJsonRequest.ENCRYPT_CHECK_ENABLE && (request instanceof EncryptedJsonRequest)) {
            EncryptedJsonRequest encryptedJsonRequest = (EncryptedJsonRequest) request;
            LogUtil.i(TAG, "doRequest " + str + " needcheckToken =" + encryptedJsonRequest.isNeedCheckUrlToken() + "  istokenready=" + k86.H(str));
            if (encryptedJsonRequest.isNeedCheckUrlToken() && !k86.H(str)) {
                String strGenerateMessageToken = EncryptUtils.generateMessageToken();
                if (TextUtils.isEmpty(strGenerateMessageToken)) {
                    LogUtil.i(EncryptedJsonRequest.TAG, "url append token Fail AND triggle exception");
                    throw new CustomAuthFailureError("EncryptedJsonRequest url's token is null " + str);
                }
                LogUtil.i(EncryptedJsonRequest.TAG, "url append token OK");
                str = k86.g0(str, strGenerateMessageToken);
            }
        }
        if (!ap3.a().i()) {
            throw new CustomAuthFailureError("CustomAuthFailureError netWork is not ready " + str);
        }
        HttpURLConnection httpURLConnectionOpenConnection = openConnection(new URL(str), request, z, z2);
        for (String str2 : map2.keySet()) {
            httpURLConnectionOpenConnection.addRequestProperty(str2, (String) map2.get(str2));
        }
        setConnectionParametersForRequest(httpURLConnectionOpenConnection, request);
        ProtocolVersion protocolVersion = new ProtocolVersion(HttpVersion.HTTP, 1, 1);
        if (httpURLConnectionOpenConnection.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, httpURLConnectionOpenConnection.getResponseCode(), httpURLConnectionOpenConnection.getResponseMessage()));
        basicHttpResponse.setEntity(entityFromConnection(httpURLConnectionOpenConnection));
        for (Map.Entry<String, List<String>> entry : httpURLConnectionOpenConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
            }
        }
        return basicHttpResponse;
    }

    private static HttpEntity entityFromConnection(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(errorStream);
        basicHttpEntity.setContentLength(httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    private void logExceptionUrl(HttpResponse httpResponse, String str) {
        LogUtil.i(TAG, LogUtil.LogType.LOG_TYPE_BACKGROUND_NETWORK, 3, new HashMap<String, Object>((httpResponse == null || httpResponse.getStatusLine() == null) ? -1 : httpResponse.getStatusLine().getStatusCode(), str) { // from class: com.android.volley.toolbox.HurlStack.1
            final /* synthetic */ int val$code;
            final /* synthetic */ String val$url;

            {
                this.val$code = i;
                this.val$url = str;
                put("action", LogUtil.NETWORK_LOG);
                put("status", "urlSuccess");
                put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i));
                put("url", str);
                put(DnsSource.Udp, it0.k().toString());
            }
        }, (Throwable) null);
    }

    private HttpURLConnection openConnection(URL url, Request<?> request, boolean z, boolean z2) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection httpURLConnectionCreateConnection = createConnection(url);
        int timeoutMs = request.getTimeoutMs();
        httpURLConnectionCreateConnection.setConnectTimeout(timeoutMs);
        httpURLConnectionCreateConnection.setReadTimeout(timeoutMs);
        httpURLConnectionCreateConnection.setUseCaches(false);
        httpURLConnectionCreateConnection.setDoInput(true);
        if (BaseConstants.SCHEME_HTTPS.equals(url.getProtocol()) && (sSLSocketFactory = this.mSslSocketFactory) != null) {
            ((HttpsURLConnection) httpURLConnectionCreateConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        if (BaseConstants.SCHEME_HTTPS.equals(url.getProtocol())) {
            if (z2) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnectionCreateConnection;
                httpsURLConnection.setSSLSocketFactory(HttpsHelper.getmInstance().getmSSLSocketFactoryRed());
                httpsURLConnection.setHostnameVerifier(this.DO_NOT_VERIFY);
            } else {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) httpURLConnectionCreateConnection;
                HttpsHelper.getmInstance();
                httpsURLConnection2.setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
                httpsURLConnection2.setHostnameVerifier(this.DO_NOT_VERIFY);
            }
        }
        return httpURLConnectionCreateConnection;
    }

    public static void setConnectionParametersForRequest(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", request.getPostBodyContentType());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(postBody);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                addBodyIfExists(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                addBodyIfExists(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod(HttpManager.HTTP_DELETE);
                return;
            case 4:
                httpURLConnection.setRequestMethod(com.qiniu.android.http.request.Request.HttpMethodHEAD);
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod(WVVzW.b);
                return;
            case 7:
                httpURLConnection.setRequestMethod(HttpClientStack.HttpPatch.METHOD_NAME);
                addBodyIfExists(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    public HttpURLConnection createConnection(URL url) throws IOException {
        return pw3.a() ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
    
        r14 = doRequest(r6, r14, r15, false, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b5, code lost:
    
        if (r7 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
    
        logExceptionUrl(r14, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ba, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bb, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bc, code lost:
    
        defpackage.it0.k().s("all ip failed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c5, code lost:
    
        throw r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c6, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c7, code lost:
    
        throw r14;
     */
    @Override // com.android.volley.toolbox.HttpStack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws Exception {
        boolean z;
        String url = request.getUrl();
        boolean z2 = true;
        boolean z3 = nl0.i(url) && nl0.j() && !rl0.h().d().getDynamicConfig(DynamicConfig.Type.DISABLE_CERT_CHECK).isEnable();
        Iterator<te1> it = it0.k().g().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            te1 next = it.next();
            if (next.a(url)) {
                for (int i = 0; i < 2; i++) {
                    DNSNode[] dNSNodeArrI = it0.k().i(next.f20971a);
                    if (dNSNodeArrI != null) {
                        for (DNSNode dNSNode : dNSNodeArrI) {
                            String strQ = it0.q(url, next, dNSNode);
                            HashMap map2 = new HashMap();
                            map2.putAll(map);
                            map2.put("Host", next.f20971a);
                            try {
                                return doRequest(strQ, request, map2, true, z3);
                            } catch (CustomAuthFailureError e) {
                                throw e;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        z = z2;
                    } else {
                        if (!it0.k().n() || i != 0) {
                            break;
                        }
                        it0.k().t("dns cache is empty when doing HTTP request" + url);
                    }
                }
                z2 = false;
                z = z2;
            }
        }
    }

    public HurlStack(UrlRewriter urlRewriter) {
        this(urlRewriter, null);
    }

    public HurlStack(UrlRewriter urlRewriter, SSLSocketFactory sSLSocketFactory) {
        this.DO_NOT_VERIFY = new HostnameVerifier() { // from class: com.android.volley.toolbox.HurlStack.2
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        };
        this.mUrlRewriter = urlRewriter;
        this.mSslSocketFactory = sSLSocketFactory;
    }
}
