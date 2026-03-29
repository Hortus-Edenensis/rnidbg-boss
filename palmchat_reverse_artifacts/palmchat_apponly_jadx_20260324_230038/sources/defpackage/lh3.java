package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lh3 {
    public static boolean b = false;
    public static lh3 c = new lh3();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OkHttpClient f18978a = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends EventListener {
        public a() {
        }

        @Override // okhttp3.EventListener
        public void connectEnd(@NonNull Call call, @NonNull InetSocketAddress inetSocketAddress, @NonNull Proxy proxy, @Nullable Protocol protocol) {
            super.connectEnd(call, inetSocketAddress, proxy, protocol);
            if (LogUtil.isLogEnable()) {
                LogUtil.i("MediaLoader", "connectEnd " + call.request() + " inetSocketAddress=" + inetSocketAddress.getAddress());
            }
        }

        @Override // okhttp3.EventListener
        public void connectFailed(@NonNull Call call, @NonNull InetSocketAddress inetSocketAddress, @NonNull Proxy proxy, @Nullable Protocol protocol, @NonNull IOException iOException) {
            super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
            if (LogUtil.isLogEnable()) {
                LogUtil.i("MediaLoader", "connectFailed " + call.request(), iOException);
            }
        }

        @Override // okhttp3.EventListener
        public void connectStart(@NonNull Call call, @NonNull InetSocketAddress inetSocketAddress, @NonNull Proxy proxy) {
            super.connectStart(call, inetSocketAddress, proxy);
            if (LogUtil.isLogEnable()) {
                LogUtil.i("MediaLoader", "connectStart " + call.request());
            }
        }

        @Override // okhttp3.EventListener
        public void connectionAcquired(@NonNull Call call, @NonNull Connection connection) {
            super.connectionAcquired(call, connection);
            if (LogUtil.isLogEnable()) {
                LogUtil.i("MediaLoader", "connectionAcquired " + call.request());
            }
        }

        @Override // okhttp3.EventListener
        public void connectionReleased(@NonNull Call call, @NonNull Connection connection) {
            super.connectionReleased(call, connection);
            if (LogUtil.isLogEnable()) {
                LogUtil.i("MediaLoader", "connectionReleased " + call.request());
            }
        }

        @Override // okhttp3.EventListener
        public void dnsEnd(@NonNull Call call, @NonNull String str, @NonNull List<InetAddress> list) {
            super.dnsEnd(call, str, list);
            if (LogUtil.isLogEnable()) {
                LogUtil.i("MediaLoader", "dnsEnd " + call.request());
            }
        }

        @Override // okhttp3.EventListener
        public void dnsStart(@NonNull Call call, @NonNull String str) {
            super.dnsStart(call, str);
            if (LogUtil.isLogEnable()) {
                LogUtil.i("MediaLoader", "dnsStart " + call.request());
            }
        }

        @Override // okhttp3.EventListener
        public void requestFailed(@NonNull Call call, @NonNull IOException iOException) {
            super.requestFailed(call, iOException);
            if (LogUtil.isLogEnable()) {
                LogUtil.i("MediaLoader", "requestFailed " + call.request(), iOException);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements HostnameVerifier {
        public c() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public static lh3 a() {
        return c;
    }

    public OkHttpClient b() {
        if (this.f18978a == null) {
            synchronized (lh3.class) {
                if (this.f18978a == null) {
                    this.f18978a = c();
                }
            }
        }
        return this.f18978a;
    }

    public final OkHttpClient c() {
        OkHttpClient.Builder builderEventListener = new OkHttpClient.Builder().dns(ia3.d()).eventListener(new a());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderWriteTimeout = builderEventListener.connectTimeout(5L, timeUnit).readTimeout(5L, timeUnit).writeTimeout(5L, timeUnit);
        TrustManager[] trustManagerArr = {new b()};
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            builderWriteTimeout.sslSocketFactory(sSLContext.getSocketFactory(), (X509TrustManager) trustManagerArr[0]);
            builderWriteTimeout.hostnameVerifier(new c());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builderWriteTimeout.build();
    }

    public final boolean d() {
        JSONObject config = vs0.a().getConfig("httpdns_media_ipv6");
        boolean zOptBoolean = config != null ? config.optBoolean(AnalyticsConstants.SDK_TYPE) : false;
        LogUtil.i("MediaLoader", "isConfigOpen" + zOptBoolean);
        return zOptBoolean;
    }

    public boolean e() {
        return d() || b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements X509TrustManager {
        public b() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }
    }
}
