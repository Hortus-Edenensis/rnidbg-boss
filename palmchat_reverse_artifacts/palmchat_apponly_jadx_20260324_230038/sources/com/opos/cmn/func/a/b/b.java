package com.opos.cmn.func.a.b;

import android.content.Context;
import android.net.SSLSessionCache;
import android.text.TextUtils;
import com.heytap.baselib.cloudctrl.database.AreaCode;
import com.heytap.common.LogLevel;
import com.heytap.common.iinterface.IAccountCallback;
import com.heytap.httpdns.env.ApiEnv;
import com.heytap.httpdns.env.HttpDnsConfig;
import com.heytap.nearx.okhttp.extension.HeyConfig;
import com.heytap.nearx.okhttp.extension.api.IPv6Config;
import com.heytap.nearx.okhttp3.Call;
import com.heytap.nearx.okhttp3.Callback;
import com.heytap.nearx.okhttp3.Headers;
import com.heytap.nearx.okhttp3.MediaType;
import com.heytap.nearx.okhttp3.OkHttpClient;
import com.heytap.nearx.okhttp3.Request;
import com.heytap.nearx.okhttp3.RequestBody;
import com.heytap.nearx.okhttp3.Response;
import com.heytap.nearx.taphttp.statitics.HttpStatConfig;
import com.heytap.nearx.taphttp.statitics.StatisticCallback;
import com.heytap.trace.AppTraceConfig;
import com.opos.cmn.func.a.a.a.b;
import com.opos.cmn.func.a.a.a.d;
import com.opos.cmn.func.a.a.a.e;
import com.opos.cmn.func.a.a.a.g;
import com.opos.cmn.func.a.a.e;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements com.opos.cmn.func.a.b.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static OkHttpClient f7941a;
    private volatile OkHttpClient b;
    private HashMap<Long, Call> c = new HashMap<>();
    private Object d = new Object();
    private Object e = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Callback {
    }

    /* JADX INFO: renamed from: com.opos.cmn.func.a.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0666b implements StatisticCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e.a f7942a;

        public C0666b(e.a aVar) {
            this.f7942a = aVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements IAccountCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.func.a.a.a.c f7943a;

        public c(com.opos.cmn.func.a.a.a.c cVar) {
            this.f7943a = cVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7944a;

        static {
            int[] iArr = new int[b.a.values().length];
            f7944a = iArr;
            try {
                iArr[b.a.CN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7944a[b.a.EU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7944a[b.a.SA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7944a[b.a.SEA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e<K, V> extends HashMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Headers f7945a;

        private e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        public void a(Headers headers) {
            this.f7945a = headers;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (obj == null) {
                return null;
            }
            String str = (String) obj;
            Headers headers = this.f7945a;
            if (headers == null) {
                return (V) super.get(obj);
            }
            V v = (V) headers.get(str);
            if (v != null) {
                return v;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f implements com.opos.cmn.func.a.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Headers f7946a;
        private Map<String, String> b;

        public f(Headers headers) {
            this.b = null;
            this.f7946a = headers;
            if (headers != null) {
                try {
                    this.b = new HashMap();
                    for (String str : this.f7946a.names()) {
                        if (str != null) {
                            this.b.put(str, this.f7946a.get(str));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.opos.cmn.func.a.a.a
        public String a(String str) {
            Headers headers = this.f7946a;
            if (headers == null || str == null) {
                return null;
            }
            return headers.get(str);
        }
    }

    private static AreaCode a(b.a aVar, Context context) {
        if (aVar == null) {
            aVar = com.opos.cmn.func.a.b.a.c.e(context);
        }
        int i = d.f7944a[aVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return AreaCode.EU;
            }
            if (i == 3) {
                return AreaCode.SA;
            }
            if (i == 4) {
                return AreaCode.SEA;
            }
        }
        return AreaCode.CN;
    }

    private static ApiEnv b() {
        return com.opos.cmn.func.a.b.a.a.a() ? ApiEnv.TEST : ApiEnv.RELEASE;
    }

    private static HttpDnsConfig a(com.opos.cmn.func.a.a.a.c cVar, Context context) {
        if (cVar == null) {
            return null;
        }
        String strD = cVar.b;
        String strC = cVar.c;
        if (TextUtils.isEmpty(strD)) {
            strD = com.opos.cmn.func.a.b.a.c.d(context);
        }
        if (TextUtils.isEmpty(strC)) {
            strC = com.opos.cmn.func.a.b.a.c.c(context);
        }
        HttpDnsConfig httpDnsConfig = new HttpDnsConfig(cVar.f7922a, strD, strC, cVar.d);
        List<String> list = cVar.e;
        if (list != null && !list.isEmpty()) {
            httpDnsConfig.setInnerWhiteList(cVar.e);
        }
        if (cVar.f != null) {
            httpDnsConfig.setSsoCallback(new c(cVar));
        }
        return httpDnsConfig;
    }

    private static OkHttpClient b(Context context) {
        OkHttpClient okHttpClient;
        OkHttpClient okHttpClient2 = f7941a;
        if (okHttpClient2 != null) {
            return okHttpClient2;
        }
        synchronized (b.class) {
            if (f7941a == null) {
                try {
                    g gVarB = com.opos.cmn.func.a.b.a.c.b(context);
                    OkHttpClient.Builder builderA = a();
                    a(context, builderA, gVarB);
                    f7941a = builderA.build();
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("HttpTapExternalHttpImpl", "init fail", e2);
                }
                okHttpClient = f7941a;
            } else {
                okHttpClient = f7941a;
            }
        }
        return okHttpClient;
    }

    public static HeyConfig.Builder a(com.opos.cmn.func.a.a.a.d dVar, Context context) {
        IPv6Config iPv6ConfigA;
        AppTraceConfig appTraceConfigA;
        e.a aVar;
        HttpDnsConfig httpDnsConfigA;
        if (dVar == null) {
            dVar = new d.a().a();
        }
        HeyConfig.Builder builder = new HeyConfig.Builder();
        try {
            builder.allUseGlsbKey(true);
        } catch (Throwable unused) {
        }
        builder.defaultUserAgent(com.opos.cmn.func.a.b.a.f.a());
        ApiEnv apiEnvB = b();
        com.opos.cmn.an.f.a.a("HttpTapExternalHttpImpl", "config set ApiEnv " + apiEnvB);
        builder.setEnv(apiEnvB);
        com.opos.cmn.func.a.a.a.c cVar = dVar.b;
        if (cVar != null && (httpDnsConfigA = a(cVar, context)) != null) {
            builder.useHttpDns(httpDnsConfigA);
        }
        builder.setLogLevel(dVar.f ? LogLevel.LEVEL_NONE : LogLevel.LEVEL_VERBOSE);
        com.opos.cmn.func.a.a.a.e eVar = dVar.e;
        if (eVar != null && (aVar = eVar.f7926a) != null) {
            builder.useHttpStat(new HttpStatConfig(true, new C0666b(aVar), dVar.e.b));
        }
        com.opos.cmn.func.a.a.a.b bVar = dVar.f7924a;
        if (bVar != null) {
            if (!bVar.f7919a) {
                return builder;
            }
            builder.setCloudConfig(dVar.f7924a.b, a(bVar.c, context));
        }
        com.opos.cmn.func.a.a.a.a aVar2 = dVar.c;
        if (aVar2 != null && (appTraceConfigA = a(aVar2)) != null) {
            builder.useAppTrace(appTraceConfigA);
        }
        com.opos.cmn.func.a.a.a.f fVar = dVar.d;
        if (fVar != null && (iPv6ConfigA = a(fVar)) != null) {
            builder.useIPv6Switch(iPv6ConfigA);
        }
        try {
            builder.setSSLSessionCache(new SSLSessionCache(context.getDir("ads_ssl_session", 0)));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("HttpTapExternalHttpImpl", "", e2);
        }
        return builder;
    }

    private static OkHttpClient b(Context context, g gVar) {
        try {
            OkHttpClient okHttpClientB = b(context);
            if (gVar == null) {
                return okHttpClientB;
            }
            if (okHttpClientB == null) {
                return null;
            }
            OkHttpClient.Builder builderNewBuilder = okHttpClientB.newBuilder();
            a(context, builderNewBuilder, gVar);
            return builderNewBuilder.build();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("HttpTapExternalHttpImpl", "getOkHttpClient", e2);
            return null;
        }
    }

    private static IPv6Config a(com.opos.cmn.func.a.a.a.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new IPv6Config(fVar.f7927a, fVar.b, fVar.c, fVar.d);
    }

    private Request b(Context context, com.opos.cmn.func.a.a.d dVar) {
        Request.Builder builderUrl;
        if (dVar == null) {
            return null;
        }
        com.opos.cmn.func.a.a.d dVarA = com.opos.cmn.func.a.b.a.c.a(context, dVar);
        Request.Builder builder = new Request.Builder();
        Map<String, String> map = dVarA.c;
        if (map != null) {
            for (String str : map.keySet()) {
                builder.addHeader(str, dVarA.c.get(str));
            }
        }
        String str2 = dVarA.f7932a;
        if (str2 == "GET") {
            builderUrl = builder.url(dVarA.b).get();
        } else {
            if (str2 == "POST") {
                byte[] bArr = dVarA.d;
                builder.post(bArr != null ? RequestBody.create((MediaType) null, bArr) : RequestBody.create((MediaType) null, new byte[0]));
            }
            builderUrl = builder.url(dVarA.b);
        }
        return builderUrl.build();
    }

    private Call a(long j) {
        try {
            synchronized (this.d) {
                Call call = this.c.get(Long.valueOf(j));
                if (call == null) {
                    return null;
                }
                this.c.remove(Long.valueOf(j));
                return call;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("HttpTapExternalHttpImpl", "removeRequestFromMap fail", e2);
            return null;
        }
    }

    private static OkHttpClient.Builder a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.readTimeout(30000L, timeUnit);
        builder.connectTimeout(30000L, timeUnit);
        return builder;
    }

    private static OkHttpClient.Builder a(Context context, OkHttpClient.Builder builder, g gVar) {
        com.opos.cmn.an.f.a.a("HttpTapExternalHttpImpl", "setOkHttpClientParams initParameter:" + gVar);
        if (gVar != null) {
            SSLSocketFactory sSLSocketFactory = gVar.c;
            if (sSLSocketFactory != null) {
                X509TrustManager x509TrustManager = gVar.e;
                if (x509TrustManager != null) {
                    builder.sslSocketFactory(sSLSocketFactory, x509TrustManager);
                } else {
                    builder.sslSocketFactory(sSLSocketFactory);
                }
            }
            HostnameVerifier hostnameVerifier = gVar.d;
            if (hostnameVerifier != null) {
                builder.hostnameVerifier(hostnameVerifier);
            }
            long j = gVar.b;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builder.readTimeout(j, timeUnit).connectTimeout(gVar.f7929a, timeUnit);
            HeyConfig.Builder builderA = a(gVar.f, context);
            if (builderA != null) {
                builder.config(builderA.build(context));
            }
        }
        return builder;
    }

    private static AppTraceConfig a(com.opos.cmn.func.a.a.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new AppTraceConfig(aVar.f7917a, aVar.b);
    }

    @Override // com.opos.cmn.func.a.b.e
    public com.opos.cmn.func.a.a.e a(Context context, com.opos.cmn.func.a.a.d dVar) {
        Request requestB;
        if (dVar == null || context == null) {
            return null;
        }
        try {
            try {
                Context applicationContext = context.getApplicationContext();
                a(applicationContext, (g) null);
                com.opos.cmn.an.f.a.a("HttpTapExternalHttpImpl", dVar.toString());
                if (this.b != null && (requestB = b(applicationContext, dVar)) != null) {
                    Call callNewCall = this.b.newCall(requestB);
                    a(dVar.e, callNewCall);
                    com.opos.cmn.func.a.a.e eVarA = a(callNewCall.execute());
                    StringBuilder sb = new StringBuilder();
                    sb.append("onResponse,");
                    sb.append(eVarA == null ? com.igexin.push.core.b.m : eVarA.toString());
                    com.opos.cmn.an.f.a.a("HttpTapExternalHttpImpl", sb.toString());
                    return eVarA;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("HttpTapExternalHttpImpl", "execSync fail", e2);
            }
            return null;
        } finally {
            a(dVar.e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.opos.cmn.func.a.a.e a(Response response) {
        long j;
        if (response == null) {
            return null;
        }
        int iCode = response.code();
        String strMessage = response.message();
        InputStream inputStreamByteStream = response.body() != null ? response.body().byteStream() : null;
        Headers headersBuild = response.headers().newBuilder().build();
        if (headersBuild != null) {
            String str = headersBuild.get("Content-Length");
            if (TextUtils.isEmpty(str)) {
                j = -1;
            } else {
                try {
                    j = Long.parseLong(str);
                } catch (Exception unused) {
                    j = -1;
                }
            }
        }
        return new e.a().a(iCode).a(strMessage).a(j).a(a(headersBuild)).a(new f(headersBuild)).a(inputStreamByteStream).a();
    }

    private Map<String, String> a(Headers headers) {
        a aVar = null;
        if (headers == null) {
            return null;
        }
        try {
            e eVar = new e(aVar);
            eVar.a(headers);
            for (String str : headers.names()) {
                if (str != null) {
                    eVar.put(str, headers.get(str));
                }
            }
            return eVar;
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(long j, Call call) {
        if (call != null) {
            synchronized (this.d) {
                this.c.put(Long.valueOf(j), call);
            }
        }
    }

    @Override // com.opos.cmn.func.a.b.d
    public void a(Context context) {
        a(context, (g) null);
    }

    private void a(Context context, g gVar) {
        if (this.b == null) {
            synchronized (this.e) {
                if (this.b == null) {
                    Context applicationContext = context.getApplicationContext();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.b = b(applicationContext, gVar);
                    com.opos.cmn.an.f.a.a("HttpTapExternalHttpImpl", "getOkHttpClient cost time:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                }
            }
        }
    }
}
