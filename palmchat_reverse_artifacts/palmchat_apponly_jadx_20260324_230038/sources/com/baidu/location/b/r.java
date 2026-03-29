package com.baidu.location.b;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class r {
    private static final Lock c = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OkHttpClient f3452a;
    private String b = null;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, String str);

        void a(int i, String str, byte[] bArr);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final r f3454a = new r();
    }

    public r() {
        b();
    }

    public static r a() {
        return b.f3454a;
    }

    private synchronized void b() {
        if (this.f3452a == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            try {
                String str = com.baidu.location.e.h.aZ;
                int i = com.baidu.location.e.h.ba;
                if (!TextUtils.isEmpty(str) && i != -1) {
                    builder.proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(str, i)));
                    final String str2 = com.baidu.location.e.h.bb;
                    final String str3 = com.baidu.location.e.h.bc;
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        builder.authenticator(new Authenticator() { // from class: com.baidu.location.b.r.1
                            @Override // okhttp3.Authenticator
                            public Request authenticate(Route route, Response response) {
                                return response.request().newBuilder().header(HttpHeaders.PROXY_AUTHORIZATION, Credentials.basic(str2, str3)).build();
                            }
                        });
                    }
                }
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                this.f3452a = builder.connectTimeout(12000L, timeUnit).readTimeout(12000L, timeUnit).writeTimeout(12000L, timeUnit).dns(l.a().c()).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Request.Builder c() {
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        String str = com.baidu.location.e.h.aw;
        if (str != null) {
            builder.addHeader("bd-loc-android", str);
        }
        return builder;
    }

    private RequestBody a(Map<String, Object> map) {
        c.lock();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        String string = sb.toString();
        c.unlock();
        return RequestBody.create(mediaType, string);
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(Map<String, Object> map, String str, a aVar) {
        StringBuilder sb;
        try {
            RequestBody requestBodyA = a(map);
            Request.Builder builderC = c();
            String str2 = this.b;
            if (str2 != null) {
                builderC.addHeader("alwd", str2);
            }
            Response responseExecute = this.f3452a.newCall(builderC.url(str).post(requestBodyA).build()).execute();
            if (!responseExecute.isSuccessful()) {
                aVar.a(responseExecute.code(), responseExecute.message());
            } else if (responseExecute.body() != null) {
                aVar.a(200, responseExecute.body().string(), new byte[1]);
            } else {
                aVar.a(400, responseExecute.message());
            }
        } catch (IOException e) {
            e = e;
            e.printStackTrace();
            if (aVar != null) {
                sb = new StringBuilder();
                sb.append("e=");
                sb.append(e.getMessage());
                aVar.a(-100, sb.toString());
            }
        } catch (Exception e2) {
            e = e2;
            if (aVar != null) {
                sb = new StringBuilder();
                sb.append("e=");
                sb.append(e.getMessage());
                aVar.a(-100, sb.toString());
            }
        }
    }
}
