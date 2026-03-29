package com.qiniu.android.bigdata.client;

import com.qiniu.android.http.CancellationHandler;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ProxyConfiguration;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.UrlConverter;
import com.qiniu.android.http.UserAgent;
import com.qiniu.android.http.dns.Dns;
import com.qiniu.android.http.dns.DnsPrefetcher;
import com.qiniu.android.http.dns.IDnsNetworkAddress;
import com.qiniu.android.http.request.httpclient.CountingRequestBody;
import com.qiniu.android.http.request.httpclient.MultipartBody;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Client {
    public static final String ContentTypeHeader = "Content-Type";
    public static final String DefaultMime = "application/octet-stream";
    public static final String FormMime = "application/x-www-form-urlencoded";
    public static final String JsonMime = "application/json";
    private final UrlConverter converter;
    private OkHttpClient httpClient;

    /* JADX INFO: compiled from: SearchBox */
    public static class ResponseTag {
        public long duration;
        public String ip;

        private ResponseTag() {
            this.ip = "";
            this.duration = -1L;
        }
    }

    public Client() {
        this(null, 10, 30, null, null);
    }

    private static JSONObject buildJsonResp(byte[] bArr) throws Exception {
        String str = new String(bArr, "utf-8");
        return StringUtils.isNullOrEmpty(str) ? new JSONObject() : new JSONObject(str);
    }

    private static ResponseInfo buildResponseInfo(Response response, String str, long j, UpToken upToken, long j2) {
        String message;
        byte[] bArrBytes;
        JSONObject jSONObjectBuildJsonResp;
        int iCode = response.code();
        String strHeader = response.header("X-Reqid");
        if (strHeader != null) {
            String str2 = strHeader.trim().split(",")[0];
        }
        try {
            bArrBytes = response.body().bytes();
            message = null;
        } catch (IOException e) {
            message = e.getMessage();
            bArrBytes = null;
        }
        if (!ctype(response).equals("application/json") || bArrBytes == null) {
            message = bArrBytes == null ? "null body" : new String(bArrBytes);
            jSONObjectBuildJsonResp = null;
        } else {
            try {
                jSONObjectBuildJsonResp = buildJsonResp(bArrBytes);
            } catch (Exception e2) {
                e = e2;
                jSONObjectBuildJsonResp = null;
            }
            try {
                if (response.code() != 200) {
                    message = jSONObjectBuildJsonResp.optString("error", new String(bArrBytes, "utf-8"));
                }
            } catch (Exception e3) {
                e = e3;
                if (response.code() < 300) {
                    message = e.getMessage();
                }
            }
        }
        HashMap map = new HashMap();
        int size = response.headers().size();
        for (int i = 0; i < size; i++) {
            map.put(response.headers().name(i).toLowerCase(), response.headers().value(i));
        }
        return ResponseInfo.create(null, iCode, map, jSONObjectBuildJsonResp, message);
    }

    private static String ctype(Response response) {
        MediaType mediaType = response.body().get$contentType();
        if (mediaType == null) {
            return "";
        }
        return mediaType.type() + "/" + mediaType.subtype();
    }

    private static long getContentLength(Response response) {
        try {
            RequestBody requestBodyBody = response.request().body();
            if (requestBodyBody == null) {
                return 0L;
            }
            return requestBodyBody.contentLength();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onRet(Response response, String str, long j, UpToken upToken, long j2, final CompletionHandler completionHandler) {
        final ResponseInfo responseInfoBuildResponseInfo = buildResponseInfo(response, str, j, upToken, j2);
        AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.bigdata.client.Client.3
            @Override // java.lang.Runnable
            public void run() {
                CompletionHandler completionHandler2 = completionHandler;
                ResponseInfo responseInfo = responseInfoBuildResponseInfo;
                completionHandler2.complete(responseInfo, responseInfo.response);
            }
        });
    }

    private ResponseInfo send(final Request.Builder builder, StringMap stringMap) {
        if (stringMap != null) {
            stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.bigdata.client.Client.7
                @Override // com.qiniu.android.utils.StringMap.Consumer
                public void accept(String str, Object obj) {
                    builder.header(str, obj.toString());
                }
            });
        }
        builder.header("User-Agent", UserAgent.instance().getUa(""));
        System.currentTimeMillis();
        ResponseTag responseTag = new ResponseTag();
        try {
            return buildResponseInfo(this.httpClient.newCall(builder.tag(responseTag).build()).execute(), responseTag.ip, responseTag.duration, null, 0L);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseInfo.create(null, -1, null, null, e.getMessage());
        }
    }

    private static String via(Response response) {
        String strHeader = response.header("X-Via", "");
        if (!strHeader.equals("")) {
            return strHeader;
        }
        String strHeader2 = response.header("X-Px", "");
        if (!strHeader2.equals("")) {
            return strHeader2;
        }
        String strHeader3 = response.header("Fw-Via", "");
        strHeader3.equals("");
        return strHeader3;
    }

    public void asyncGet(String str, StringMap stringMap, UpToken upToken, CompletionHandler completionHandler) {
        asyncSend(new Request.Builder().get().url(str), stringMap, upToken, 0L, completionHandler);
    }

    public void asyncMultipartPost(String str, PostArgs postArgs, UpToken upToken, ProgressHandler progressHandler, CompletionHandler completionHandler, CancellationHandler cancellationHandler) {
        RequestBody requestBodyCreate;
        long length;
        if (postArgs.file != null) {
            requestBodyCreate = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.file);
            length = postArgs.file.length();
        } else {
            requestBodyCreate = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.data);
            length = postArgs.data.length;
        }
        asyncMultipartPost(str, postArgs.params, upToken, length, progressHandler, postArgs.fileName, requestBodyCreate, completionHandler, cancellationHandler);
    }

    public void asyncPost(String str, byte[] bArr, StringMap stringMap, UpToken upToken, long j, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        asyncPost(str, bArr, 0, bArr.length, stringMap, upToken, j, progressHandler, completionHandler, upCancellationSignal);
    }

    public void asyncSend(final Request.Builder builder, StringMap stringMap, final UpToken upToken, final long j, final CompletionHandler completionHandler) {
        if (stringMap != null) {
            stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.bigdata.client.Client.4
                @Override // com.qiniu.android.utils.StringMap.Consumer
                public void accept(String str, Object obj) {
                    builder.header(str, obj.toString());
                }
            });
        }
        if (upToken != null) {
            builder.header("User-Agent", UserAgent.instance().getUa(upToken.accessKey));
        } else {
            builder.header("User-Agent", UserAgent.instance().getUa("pandora"));
        }
        this.httpClient.newCall(builder.tag(new ResponseTag()).build()).enqueue(new Callback() { // from class: com.qiniu.android.bigdata.client.Client.5
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                iOException.printStackTrace();
                String message = iOException.getMessage();
                completionHandler.complete(ResponseInfo.create(null, iOException instanceof CancellationHandler.CancellationException ? -2 : iOException instanceof UnknownHostException ? -1003 : (message == null || message.indexOf("Broken pipe") != 0) ? iOException instanceof SocketTimeoutException ? -1001 : iOException instanceof ConnectException ? -1004 : -1 : -1005, null, null, iOException.getMessage()), null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseTag responseTag = (ResponseTag) response.request().tag();
                Client.onRet(response, responseTag.ip, responseTag.duration, upToken, j, completionHandler);
            }
        });
    }

    public ResponseInfo syncGet(String str, StringMap stringMap) {
        return send(new Request.Builder().get().url(str), stringMap);
    }

    public ResponseInfo syncMultipartPost(String str, PostArgs postArgs, UpToken upToken) {
        RequestBody requestBodyCreate;
        long length;
        if (postArgs.file != null) {
            requestBodyCreate = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.file);
            length = postArgs.file.length();
        } else {
            requestBodyCreate = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.data);
            length = postArgs.data.length;
        }
        return syncMultipartPost(str, postArgs.params, upToken, length, postArgs.fileName, requestBodyCreate);
    }

    public ResponseInfo syncSend(final Request.Builder builder, StringMap stringMap, UpToken upToken, long j) {
        if (stringMap != null) {
            stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.bigdata.client.Client.9
                @Override // com.qiniu.android.utils.StringMap.Consumer
                public void accept(String str, Object obj) {
                    builder.header(str, obj.toString());
                }
            });
        }
        builder.header("User-Agent", UserAgent.instance().getUa(upToken.accessKey));
        ResponseTag responseTag = new ResponseTag();
        try {
            return buildResponseInfo(this.httpClient.newCall(builder.tag(responseTag).build()).execute(), responseTag.ip, responseTag.duration, upToken, j);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            return ResponseInfo.create(null, e instanceof UnknownHostException ? -1003 : (message == null || message.indexOf("Broken pipe") != 0) ? e instanceof SocketTimeoutException ? -1001 : e instanceof ConnectException ? -1004 : -1 : -1005, null, null, e.getMessage());
        }
    }

    public Client(ProxyConfiguration proxyConfiguration, int i, int i2, UrlConverter urlConverter, Dns dns) {
        this.converter = urlConverter;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (proxyConfiguration != null) {
            builder.proxy(proxyConfiguration.proxy());
            if (proxyConfiguration.user != null && proxyConfiguration.password != null) {
                builder.proxyAuthenticator(proxyConfiguration.authenticator());
            }
        }
        builder.dns(new okhttp3.Dns() { // from class: com.qiniu.android.bigdata.client.Client.1
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String str) throws UnknownHostException {
                InetAddress byName;
                List<IDnsNetworkAddress> inetAddressByHost = DnsPrefetcher.getInstance().getInetAddressByHost(str);
                if (inetAddressByHost != null && inetAddressByHost.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (IDnsNetworkAddress iDnsNetworkAddress : inetAddressByHost) {
                        if (iDnsNetworkAddress.getIpValue() != null && (byName = InetAddress.getByName(iDnsNetworkAddress.getIpValue())) != null) {
                            arrayList.add(byName);
                        }
                    }
                    if (arrayList.size() > 0) {
                        return arrayList;
                    }
                }
                return okhttp3.Dns.SYSTEM.lookup(str);
            }
        });
        builder.networkInterceptors().add(new Interceptor() { // from class: com.qiniu.android.bigdata.client.Client.2
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                String string;
                Request request = chain.request();
                long jCurrentTimeMillis = System.currentTimeMillis();
                Response responseProceed = chain.proceed(request);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                ResponseTag responseTag = (ResponseTag) request.tag();
                try {
                    string = chain.connection().socket().getRemoteSocketAddress().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    string = "";
                }
                responseTag.ip = string;
                responseTag.duration = jCurrentTimeMillis2 - jCurrentTimeMillis;
                return responseProceed;
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(i, timeUnit);
        builder.readTimeout(i2, timeUnit);
        builder.writeTimeout(0L, timeUnit);
        this.httpClient = builder.build();
    }

    public void asyncPost(String str, byte[] bArr, int i, int i2, StringMap stringMap, UpToken upToken, long j, ProgressHandler progressHandler, CompletionHandler completionHandler, CancellationHandler cancellationHandler) {
        RequestBody requestBodyCreate;
        Object obj;
        UrlConverter urlConverter = this.converter;
        String strConvert = urlConverter != null ? urlConverter.convert(str) : str;
        if (bArr == null || bArr.length <= 0) {
            requestBodyCreate = RequestBody.create((MediaType) null, new byte[0]);
        } else {
            MediaType mediaType = MediaType.parse("application/octet-stream");
            if (stringMap != null && (obj = stringMap.get("Content-Type")) != null) {
                mediaType = MediaType.parse(obj.toString());
            }
            requestBodyCreate = RequestBody.create(mediaType, bArr, i, i2);
        }
        RequestBody countingRequestBody = requestBodyCreate;
        if (progressHandler != null || cancellationHandler != null) {
            countingRequestBody = new CountingRequestBody(countingRequestBody, progressHandler, j, cancellationHandler);
        }
        asyncSend(new Request.Builder().url(strConvert).post(countingRequestBody), stringMap, upToken, j, completionHandler);
    }

    private void asyncMultipartPost(String str, StringMap stringMap, UpToken upToken, long j, ProgressHandler progressHandler, String str2, RequestBody requestBody, CompletionHandler completionHandler, CancellationHandler cancellationHandler) {
        UrlConverter urlConverter = this.converter;
        String strConvert = urlConverter != null ? urlConverter.convert(str) : str;
        final MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart("file", str2, requestBody);
        stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.bigdata.client.Client.6
            @Override // com.qiniu.android.utils.StringMap.Consumer
            public void accept(String str3, Object obj) {
                builder.addFormDataPart(str3, obj.toString());
            }
        });
        builder.setType(MediaType.parse("multipart/form-data"));
        RequestBody requestBodyBuild = builder.build();
        if (progressHandler != null || cancellationHandler != null) {
            requestBodyBuild = new CountingRequestBody(requestBodyBuild, progressHandler, j, cancellationHandler);
        }
        asyncSend(new Request.Builder().url(strConvert).post(requestBodyBuild), null, upToken, j, completionHandler);
    }

    private ResponseInfo syncMultipartPost(String str, StringMap stringMap, UpToken upToken, long j, String str2, RequestBody requestBody) {
        final MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart("file", str2, requestBody);
        stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.bigdata.client.Client.8
            @Override // com.qiniu.android.utils.StringMap.Consumer
            public void accept(String str3, Object obj) {
                builder.addFormDataPart(str3, obj.toString());
            }
        });
        builder.setType(MediaType.parse("multipart/form-data"));
        return syncSend(new Request.Builder().url(str).post(builder.build()), null, upToken, j);
    }
}
