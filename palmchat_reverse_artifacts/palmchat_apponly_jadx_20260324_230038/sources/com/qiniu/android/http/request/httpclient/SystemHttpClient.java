package com.qiniu.android.http.request.httpclient;

import com.qiniu.android.http.CancellationHandler;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ProxyConfiguration;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.dns.SystemDns;
import com.qiniu.android.http.metrics.UploadSingleRequestMetrics;
import com.qiniu.android.http.request.IRequestClient;
import com.qiniu.android.http.request.Request;
import com.qiniu.android.storage.GlobalConfiguration;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.StringUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SystemHttpClient extends IRequestClient {
    public static final String ContentTypeHeader = "Content-Type";
    public static final String DefaultMime = "application/octet-stream";
    public static final String FormMime = "application/x-www-form-urlencoded";
    public static final String JsonMime = "application/json";
    private static final OkHttpClient baseClient = new OkHttpClient();
    private static ConnectionPool pool;
    private Call call;
    private IRequestClient.CompleteHandler completeHandler;
    private Request currentRequest;
    private boolean hasHandleComplete = false;
    private OkHttpClient httpClient;
    private UploadSingleRequestMetrics metrics;
    private IRequestClient.Progress requestProgress;

    /* JADX INFO: compiled from: SearchBox */
    public static class ResponseTag {
        public String ip = "";
        public long duration = -1;

        private ResponseTag() {
        }
    }

    private static JSONObject buildJsonResp(byte[] bArr) throws Exception {
        String str = new String(bArr, "utf-8");
        return StringUtils.isNullOrEmpty(str) ? new JSONObject() : new JSONObject(str);
    }

    private EventListener createEventLister() {
        return new EventListener() { // from class: com.qiniu.android.http.request.httpclient.SystemHttpClient.4
            @Override // okhttp3.EventListener
            public void callEnd(Call call) {
                SystemHttpClient.this.metrics.end();
            }

            @Override // okhttp3.EventListener
            public void callFailed(Call call, IOException iOException) {
                SystemHttpClient.this.metrics.end();
            }

            @Override // okhttp3.EventListener
            public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
                SystemHttpClient.this.metrics.setSecureConnectionEndDate(new Date());
            }

            @Override // okhttp3.EventListener
            public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
                SystemHttpClient.this.metrics.setConnectEndDate(new Date());
            }

            @Override // okhttp3.EventListener
            public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
                SystemHttpClient.this.metrics.setConnectStartDate(new Date());
                if (inetSocketAddress == null || inetSocketAddress.getAddress() == null) {
                    return;
                }
                SystemHttpClient.this.metrics.setRemoteAddress(inetSocketAddress.getAddress().getHostAddress());
                SystemHttpClient.this.metrics.setRemotePort(Integer.valueOf(inetSocketAddress.getPort()));
            }

            @Override // okhttp3.EventListener
            public void dnsEnd(Call call, String str, List<InetAddress> list) {
                SystemHttpClient.this.metrics.setDomainLookupEndDate(new Date());
            }

            @Override // okhttp3.EventListener
            public void dnsStart(Call call, String str) {
                SystemHttpClient.this.metrics.setDomainLookupStartDate(new Date());
            }

            @Override // okhttp3.EventListener
            public void requestBodyEnd(Call call, long j) {
                SystemHttpClient.this.metrics.setRequestEndDate(new Date());
                SystemHttpClient.this.metrics.setCountOfRequestBodyBytesSent(j);
            }

            @Override // okhttp3.EventListener
            public void requestFailed(Call call, IOException iOException) {
                SystemHttpClient.this.metrics.setCountOfRequestBodyBytesSent(0L);
            }

            @Override // okhttp3.EventListener
            public void requestHeadersEnd(Call call, okhttp3.Request request) {
                SystemHttpClient.this.metrics.setCountOfRequestHeaderBytesSent(request.headers().toString().length());
            }

            @Override // okhttp3.EventListener
            public void requestHeadersStart(Call call) {
                SystemHttpClient.this.metrics.setRequestStartDate(new Date());
            }

            @Override // okhttp3.EventListener
            public void responseBodyEnd(Call call, long j) {
                SystemHttpClient.this.metrics.setResponseEndDate(new Date());
                SystemHttpClient.this.metrics.setCountOfResponseBodyBytesReceived(j);
            }

            @Override // okhttp3.EventListener
            public void responseFailed(Call call, IOException iOException) {
                SystemHttpClient.this.metrics.setResponseEndDate(new Date());
            }

            @Override // okhttp3.EventListener
            public void responseHeadersEnd(Call call, Response response) {
                Headers headers = response.headers();
                if (headers == null || headers.byteCount() <= 0) {
                    return;
                }
                SystemHttpClient.this.metrics.setCountOfResponseHeaderBytesReceived(headers.byteCount());
            }

            @Override // okhttp3.EventListener
            public void responseHeadersStart(Call call) {
                SystemHttpClient.this.metrics.setResponseStartDate(new Date());
            }

            @Override // okhttp3.EventListener
            public void secureConnectEnd(Call call, Handshake handshake) {
                SystemHttpClient.this.metrics.setSecureConnectionStartDate(new Date());
            }

            @Override // okhttp3.EventListener
            public void secureConnectStart(Call call) {
                SystemHttpClient.this.metrics.setConnectEndDate(new Date());
            }

            @Override // okhttp3.EventListener
            public void callStart(Call call) {
            }

            @Override // okhttp3.EventListener
            public void requestBodyStart(Call call) {
            }

            @Override // okhttp3.EventListener
            public void responseBodyStart(Call call) {
            }

            @Override // okhttp3.EventListener
            public void connectionAcquired(Call call, Connection connection) {
            }

            @Override // okhttp3.EventListener
            public void connectionReleased(Call call, Connection connection) {
            }
        };
    }

    private OkHttpClient createHttpClient(ProxyConfiguration proxyConfiguration) {
        if (this.currentRequest == null) {
            return null;
        }
        OkHttpClient.Builder builderNewBuilder = baseClient.newBuilder();
        if (proxyConfiguration != null) {
            builderNewBuilder.proxy(proxyConfiguration.proxy());
            if (proxyConfiguration.user != null && proxyConfiguration.password != null) {
                builderNewBuilder.proxyAuthenticator(proxyConfiguration.authenticator());
            }
        }
        builderNewBuilder.eventListener(createEventLister());
        if (GlobalConfiguration.getInstance().isDnsOpen) {
            builderNewBuilder.dns(new Dns() { // from class: com.qiniu.android.http.request.httpclient.SystemHttpClient.2
                @Override // okhttp3.Dns
                public List<InetAddress> lookup(String str) throws UnknownHostException {
                    if (SystemHttpClient.this.currentRequest.getInetAddress() == null || !str.equals(SystemHttpClient.this.currentRequest.host)) {
                        return new SystemDns().lookupInetAddress(str);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(SystemHttpClient.this.currentRequest.getInetAddress());
                    return arrayList;
                }
            });
        }
        builderNewBuilder.connectionPool(getConnectPool());
        long j = this.currentRequest.timeout;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builderNewBuilder.connectTimeout(j, timeUnit);
        builderNewBuilder.readTimeout(this.currentRequest.timeout, timeUnit);
        builderNewBuilder.writeTimeout(60L, timeUnit);
        return builderNewBuilder.build();
    }

    private Request.Builder createRequestBuilder(final IRequestClient.Progress progress) {
        ByteBody byteBody;
        com.qiniu.android.http.request.Request request = this.currentRequest;
        if (request == null) {
            return null;
        }
        Headers headersOf = Headers.of(request.allHeaders);
        if (this.currentRequest.httpMethod.equals(com.qiniu.android.http.request.Request.HttpMethodHEAD) || this.currentRequest.httpMethod.equals("GET")) {
            Request.Builder builderUrl = new Request.Builder().get().url(this.currentRequest.urlString);
            for (String str : this.currentRequest.allHeaders.keySet()) {
                builderUrl.header(str, this.currentRequest.allHeaders.get(str));
            }
            return builderUrl;
        }
        if (!this.currentRequest.httpMethod.equals("POST") && !this.currentRequest.httpMethod.equals("PUT")) {
            return null;
        }
        Request.Builder builderHeaders = new Request.Builder().url(this.currentRequest.urlString).headers(headersOf);
        if (this.currentRequest.httpBody.length > 0) {
            MediaType mediaType = MediaType.parse("application/octet-stream");
            String str2 = this.currentRequest.allHeaders.get("Content-Type");
            if (str2 != null) {
                mediaType = MediaType.parse(str2);
            }
            byteBody = new ByteBody(mediaType, this.currentRequest.httpBody);
        } else {
            byteBody = new ByteBody(null, new byte[0]);
        }
        CountingRequestBody countingRequestBody = new CountingRequestBody(byteBody, new ProgressHandler() { // from class: com.qiniu.android.http.request.httpclient.SystemHttpClient.3
            @Override // com.qiniu.android.http.ProgressHandler
            public void onProgress(long j, long j2) {
                IRequestClient.Progress progress2 = progress;
                if (progress2 != null) {
                    progress2.progress(j, j2);
                }
            }
        }, this.currentRequest.httpBody.length, null);
        return this.currentRequest.httpMethod.equals("POST") ? builderHeaders.post(countingRequestBody) : this.currentRequest.httpMethod.equals("PUT") ? builderHeaders.put(countingRequestBody) : builderHeaders;
    }

    private static synchronized ConnectionPool getConnectPool() {
        if (pool == null) {
            pool = new ConnectionPool(10, 10L, TimeUnit.MINUTES);
        }
        return pool;
    }

    private static String getOkHttpVersion() {
        try {
            try {
                try {
                    OkHttp okHttp = OkHttp.INSTANCE;
                    return OkHttp.class.getField("VERSION").get(OkHttp.class) + "";
                } catch (Exception unused) {
                    return "";
                }
            } catch (Exception unused2) {
                Class<?> cls = Class.forName("okhttp3.internal.Version");
                return (cls.getMethod("userAgent", new Class[0]).invoke(cls, new Object[0]) + "").replace("okhttp/", "");
            }
        } catch (Exception unused3) {
            Class<?> cls2 = Class.forName("okhttp3.internal.Version");
            return (cls2.getField("userAgent").get(cls2) + "").replace("okhttp/", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStatusCodeByException(Exception exc) {
        String message = exc.getMessage();
        if ((message != null && message.contains("Canceled")) || (exc instanceof CancellationHandler.CancellationException)) {
            return -2;
        }
        if (exc instanceof UnknownHostException) {
            return -1003;
        }
        if (message != null && message.indexOf("Broken pipe") == 0) {
            return -1005;
        }
        if (exc instanceof SocketTimeoutException) {
            return -1001;
        }
        if (exc instanceof ConnectException) {
            return -1004;
        }
        if (exc instanceof ProtocolException) {
            return 100;
        }
        if (exc instanceof SSLException) {
            return ResponseInfo.NetworkSSLError;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleError(com.qiniu.android.http.request.Request request, int i, String str, IRequestClient.CompleteHandler completeHandler) {
        synchronized (this) {
            if (this.hasHandleComplete) {
                return;
            }
            this.hasHandleComplete = true;
            ResponseInfo responseInfoCreate = ResponseInfo.create(request, i, null, null, str);
            this.metrics.setResponse(responseInfoCreate);
            this.metrics.setRequest(request);
            this.metrics.end();
            completeHandler.complete(responseInfoCreate, this.metrics, responseInfoCreate.response);
            releaseResource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResponse(com.qiniu.android.http.request.Request request, Response response, IRequestClient.CompleteHandler completeHandler) {
        String message;
        byte[] bArrBytes;
        synchronized (this) {
            if (this.hasHandleComplete) {
                return;
            }
            this.hasHandleComplete = true;
            int iCode = response.code();
            HashMap map = new HashMap();
            int size = response.headers().size();
            for (int i = 0; i < size; i++) {
                map.put(response.headers().name(i).toLowerCase(), response.headers().value(i));
            }
            JSONObject jSONObjectBuildJsonResp = null;
            try {
                bArrBytes = response.body().bytes();
                message = null;
            } catch (Exception e) {
                message = e.getMessage();
                bArrBytes = null;
            }
            if (bArrBytes == null) {
                message = response.message();
            } else if (responseContentType(response) != "application/json") {
                String str = new String(bArrBytes);
                if (str.length() > 0) {
                    try {
                        jSONObjectBuildJsonResp = new JSONObject(str);
                    } catch (Exception unused) {
                    }
                }
            } else {
                try {
                    jSONObjectBuildJsonResp = buildJsonResp(bArrBytes);
                } catch (Exception e2) {
                    message = e2.getMessage();
                    iCode = -1015;
                }
            }
            ResponseInfo responseInfoCreate = ResponseInfo.create(request, iCode, map, jSONObjectBuildJsonResp, message);
            this.metrics.setResponse(responseInfoCreate);
            this.metrics.setRequest(request);
            if (response.protocol() == Protocol.HTTP_1_0) {
                this.metrics.setHttpVersion("1.0");
            } else if (response.protocol() == Protocol.HTTP_1_1) {
                this.metrics.setHttpVersion("1.1");
            } else if (response.protocol() == Protocol.HTTP_2) {
                this.metrics.setHttpVersion("2");
            }
            this.metrics.end();
            completeHandler.complete(responseInfoCreate, this.metrics, responseInfoCreate.response);
            releaseResource();
        }
    }

    private void releaseResource() {
        this.currentRequest = null;
        this.requestProgress = null;
        this.completeHandler = null;
        this.metrics = null;
        this.httpClient = null;
        this.call = null;
    }

    private static String responseContentType(Response response) {
        MediaType mediaType = response.body().get$contentType();
        if (mediaType == null) {
            return "";
        }
        return mediaType.type() + "/" + mediaType.subtype();
    }

    @Override // com.qiniu.android.http.request.IRequestClient
    public synchronized void cancel() {
        Call call = this.call;
        if (call != null && !call.getCanceled()) {
            this.call.cancel();
        }
    }

    @Override // com.qiniu.android.http.request.IRequestClient
    public void request(com.qiniu.android.http.request.Request request, boolean z, ProxyConfiguration proxyConfiguration, IRequestClient.Progress progress, IRequestClient.CompleteHandler completeHandler) {
        UploadSingleRequestMetrics uploadSingleRequestMetrics = new UploadSingleRequestMetrics();
        this.metrics = uploadSingleRequestMetrics;
        uploadSingleRequestMetrics.start();
        this.metrics.setClientName("okhttp");
        this.metrics.setClientVersion(getOkHttpVersion());
        if (request != null) {
            this.metrics.setRemoteAddress(request.ip);
        }
        this.metrics.setRequest(request);
        this.currentRequest = request;
        this.requestProgress = progress;
        this.completeHandler = completeHandler;
        this.httpClient = createHttpClient(proxyConfiguration);
        Request.Builder builderCreateRequestBuilder = createRequestBuilder(this.requestProgress);
        if (builderCreateRequestBuilder == null) {
            ResponseInfo responseInfoInvalidArgument = ResponseInfo.invalidArgument("invalid http request");
            handleError(request, responseInfoInvalidArgument.statusCode, responseInfoInvalidArgument.message, completeHandler);
            return;
        }
        Call callNewCall = this.httpClient.newCall(builderCreateRequestBuilder.build());
        this.call = callNewCall;
        if (z) {
            callNewCall.enqueue(new Callback() { // from class: com.qiniu.android.http.request.httpclient.SystemHttpClient.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    iOException.printStackTrace();
                    String message = iOException.getMessage();
                    int statusCodeByException = SystemHttpClient.this.getStatusCodeByException(iOException);
                    if (call.getCanceled()) {
                        statusCodeByException = -2;
                        message = "user cancelled";
                    }
                    SystemHttpClient systemHttpClient = SystemHttpClient.this;
                    systemHttpClient.handleError(systemHttpClient.currentRequest, statusCodeByException, message, SystemHttpClient.this.completeHandler);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, final Response response) throws IOException {
                    AsyncRun.runInBack(new Runnable() { // from class: com.qiniu.android.http.request.httpclient.SystemHttpClient.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SystemHttpClient systemHttpClient = SystemHttpClient.this;
                            systemHttpClient.handleResponse(systemHttpClient.currentRequest, response, SystemHttpClient.this.completeHandler);
                        }
                    });
                }
            });
            return;
        }
        try {
            handleResponse(request, callNewCall.execute(), completeHandler);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            int statusCodeByException = getStatusCodeByException(e);
            if (this.call.getCanceled()) {
                statusCodeByException = -2;
                message = "user cancelled";
            }
            handleError(request, statusCodeByException, message, completeHandler);
        }
    }
}
