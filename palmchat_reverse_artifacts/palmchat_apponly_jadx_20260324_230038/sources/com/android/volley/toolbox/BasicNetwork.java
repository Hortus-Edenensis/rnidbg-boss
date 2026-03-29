package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.CustomAuthFailureError;
import com.android.volley.LXRequestHelper;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.push.core.b;
import com.qiniu.android.http.dns.DnsSource;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.hx3;
import defpackage.ir5;
import defpackage.it0;
import defpackage.pw3;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static int DEFAULT_POOL_SIZE = 4096;
    private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
    }

    private void addCacheHeaders(Map<String, String> map, Cache.Entry entry) {
        if (entry == null) {
            return;
        }
        String str = entry.etag;
        if (str != null) {
            map.put(HttpHeaders.IF_NONE_MATCH, str);
        }
        if (entry.serverDate > 0) {
            try {
                map.put(HttpHeaders.IF_MODIFIED_SINCE, DateUtils.formatDate(new Date(entry.serverDate)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private static void attemptRetryOnTokenException(Request<?> request, VolleyError volleyError) throws VolleyError {
        if (!(request instanceof EncryptedJsonRequest) || !hx3.m(AppContext.getContext())) {
            throw volleyError;
        }
        EncryptedJsonRequest encryptedJsonRequest = (EncryptedJsonRequest) request;
        RetryPolicy tokenRetryPolicy = encryptedJsonRequest.getTokenRetryPolicy();
        tokenRetryPolicy.retry(volleyError);
        long jB = ir5.b();
        StringBuilder sb = new StringBuilder();
        String str = EncryptedJsonRequest.TAG;
        sb.append(str);
        sb.append("_attemptRetryOnTokenException");
        LogUtil.i(sb.toString(), "url=" + request.getUrl() + "  sleep=" + tokenRetryPolicy.getCurrentTimeout() + "========================");
        LXRequestHelper.getInstance().waitForToken(encryptedJsonRequest, (long) tokenRetryPolicy.getCurrentTimeout());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("_attemptRetryOnTokenException");
        LogUtil.i(sb2.toString(), "url=" + request.getUrl() + "  sleep=" + tokenRetryPolicy.getCurrentTimeout() + " realSleep=" + ir5.e(jB));
    }

    public static Map<String, String> convertHeaders(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private byte[] entityToBytes(HttpEntity httpEntity) throws ServerError, IOException {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new ServerError();
            }
            byte[] buf = this.mPool.getBuf(1024);
            while (true) {
                int i = content.read(buf);
                if (i == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(buf, 0, i);
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException unused) {
                VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(buf);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused2) {
                VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(null);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    private void logErrorStatusCode(int i, String str) {
        if (i / 100 != 2) {
            pw3.d(str, i, null);
            LogUtil.i("BasicNetwork", LogUtil.LogType.LOG_TYPE_BACKGROUND_NETWORK, 3, new HashMap<String, Object>(i, str) { // from class: com.android.volley.toolbox.BasicNetwork.1
                final /* synthetic */ int val$statusCode;
                final /* synthetic */ String val$url;

                {
                    this.val$statusCode = i;
                    this.val$url = str;
                    put("action", LogUtil.NETWORK_LOG);
                    put("status", "statusCodeError");
                    put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i));
                    put("url", str);
                    put(DnsSource.Udp, it0.k().toString());
                }
            }, (Throwable) null);
        }
    }

    private void logSlowRequests(long j, Request<?> request, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > SLOW_REQUEST_THRESHOLD_MS) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : b.m;
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    public void logError(String str, String str2, long j) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ca, code lost:
    
        throw new java.io.IOException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.android.volley.toolbox.BasicNetwork] */
    @Override // com.android.volley.Network
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NetworkResponse performRequest(Request<?> request) throws VolleyError {
        ?? r17;
        HttpResponse httpResponsePerformRequest;
        byte[] bArr;
        StatusLine statusLine;
        int statusCode;
        Map<String, String> mapConvertHeaders;
        ?? r1;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        LXRequestHelper.logRequest(request, "start");
        while (true) {
            Map<String, String> mapEmptyMap = Collections.emptyMap();
            try {
                try {
                    HashMap map = new HashMap();
                    addCacheHeaders(map, request.getCacheEntry());
                    httpResponsePerformRequest = this.mHttpStack.performRequest(request, map);
                    try {
                        statusLine = httpResponsePerformRequest.getStatusLine();
                        statusCode = statusLine.getStatusCode();
                        mapConvertHeaders = convertHeaders(httpResponsePerformRequest.getAllHeaders());
                    } catch (IOException e) {
                        e = e;
                    }
                    try {
                        logErrorStatusCode(statusCode, request.getUrl());
                        try {
                            if (statusCode == 304) {
                                Cache.Entry cacheEntry = request.getCacheEntry();
                                if (cacheEntry == null) {
                                    return new NetworkResponse(304, null, mapConvertHeaders, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                }
                                cacheEntry.responseHeaders.putAll(mapConvertHeaders);
                                return new NetworkResponse(304, cacheEntry.data, cacheEntry.responseHeaders, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            }
                            byte[] bArrEntityToBytes = httpResponsePerformRequest.getEntity() != null ? entityToBytes(httpResponsePerformRequest.getEntity()) : new byte[0];
                            try {
                                r1 = this;
                                r1.logSlowRequests(SystemClock.elapsedRealtime() - jElapsedRealtime, request, bArrEntityToBytes, statusLine);
                                try {
                                    if (statusCode < 200 || statusCode > 299) {
                                        break;
                                    }
                                    LXRequestHelper.logRequest(request, "success");
                                    return new NetworkResponse(statusCode, bArrEntityToBytes, mapConvertHeaders, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                } catch (IOException e2) {
                                    e = e2;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                r1 = mapConvertHeaders;
                            }
                            r17 = r1;
                            bArr = bArrEntityToBytes;
                        } catch (IOException e4) {
                            e = e4;
                            bArr = null;
                            r17 = mapConvertHeaders;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        mapEmptyMap = mapConvertHeaders;
                        r17 = mapEmptyMap;
                        bArr = null;
                    }
                } catch (IOException e6) {
                    e = e6;
                    r17 = mapEmptyMap;
                    httpResponsePerformRequest = null;
                    bArr = null;
                }
            } catch (CustomAuthFailureError e7) {
                attemptRetryOnTokenException(request, e7);
            } catch (MalformedURLException e8) {
                throw new RuntimeException("Bad URL " + request.getUrl(), e8);
            } catch (SocketTimeoutException unused) {
                attemptRetryOnException("socket", request, new TimeoutError());
            } catch (ConnectTimeoutException unused2) {
                attemptRetryOnException("connection", request, new TimeoutError());
            }
            if (httpResponsePerformRequest == null) {
                throw new NoConnectionError(e);
            }
            int statusCode2 = httpResponsePerformRequest.getStatusLine().getStatusCode();
            VolleyLog.e("Unexpected response code %d for %s", Integer.valueOf(statusCode2), request.getUrl());
            if (bArr == null) {
                throw new NetworkError((NetworkResponse) null);
            }
            NetworkResponse networkResponse = new NetworkResponse(statusCode2, bArr, r17, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
            if (statusCode2 != 401 && statusCode2 != 403) {
                throw new ServerError(networkResponse);
            }
            attemptRetryOnException("auth", request, new AuthFailureError(networkResponse));
        }
    }

    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mPool = byteArrayPool;
    }
}
