package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import defpackage.vu6;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class rz6 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Callable<WifiInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20630a;

        public a(Context context) {
            this.f20630a = context;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WifiInfo call() {
            return ((WifiManager) this.f20630a.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements vu6.a<Object, Boolean> {
        @Override // vu6.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20631a;

        public c(Context context) {
            this.f20631a = context;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            return p37.a(this.f20631a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements vu6.a<Object, Boolean> {
        @Override // vu6.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof NetworkInfo) || obj == null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements Callable<NetworkInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20632a;

        public e(Context context) {
            this.f20632a = context;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NetworkInfo call() {
            return ((ConnectivityManager) this.f20632a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f implements vu6.a<Object, Boolean> {
        @Override // vu6.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20633a;
        public final /* synthetic */ ru6 b;

        public g(Context context, ru6 ru6Var) {
            this.f20633a = context;
            this.b = ru6Var;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            try {
                return mu6.b(this.f20633a);
            } catch (Throwable th) {
                xt6.g(this.b, "third", "GetUtdidEx", th.getClass().getName());
                return "";
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h implements vu6.a<Object, Boolean> {
        @Override // vu6.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20634a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ ru6 d;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements APSecuritySdk.InitResultListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String[] f20635a;
            public final /* synthetic */ ConditionVariable b;

            public a(String[] strArr, ConditionVariable conditionVariable) {
                this.f20635a = strArr;
                this.b = conditionVariable;
            }

            @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
            public void onResult(APSecuritySdk.TokenResult tokenResult) {
                if (tokenResult != null) {
                    this.f20635a[0] = tokenResult.apdidToken;
                }
                this.b.open();
            }
        }

        public i(String str, String str2, Context context, ru6 ru6Var) {
            this.f20634a = str;
            this.b = str2;
            this.c = context;
            this.d = ru6Var;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            HashMap map = new HashMap();
            map.put("tid", this.f20634a);
            map.put("utdid", this.b);
            String[] strArr = {""};
            try {
                APSecuritySdk aPSecuritySdk = APSecuritySdk.getInstance(this.c);
                ConditionVariable conditionVariable = new ConditionVariable();
                aPSecuritySdk.initToken(0, map, new a(strArr, conditionVariable));
                conditionVariable.block(3000L);
            } catch (Throwable th) {
                w97.d(th);
                xt6.g(this.d, "third", "GetApdidEx", th.getClass().getName());
            }
            if (TextUtils.isEmpty(strArr[0])) {
                xt6.g(this.d, "third", "GetApdidNull", "missing token");
            }
            return strArr[0];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j implements vu6.a<Object, Boolean> {
        @Override // vu6.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof WifiInfo) || obj == null);
        }
    }

    public static NetworkInfo a(ru6 ru6Var, Context context) {
        Context contextA = vu6.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (NetworkInfo) vu6.c(2, 10L, timeUnit, new d(), new e(contextA), false, 10L, timeUnit, ru6Var, false);
    }

    public static String b(ru6 ru6Var, Context context, String str, String str2) {
        Context contextA = vu6.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (String) vu6.c(4, 10L, timeUnit, new h(), new i(str, str2, contextA, ru6Var), true, 3L, timeUnit, ru6Var, true);
    }

    public static String c(ru6 ru6Var, Context context) {
        if (!vt6.I().D()) {
            return "";
        }
        return (String) vu6.c(1, 1L, TimeUnit.DAYS, new b(), new c(vu6.a(context)), true, 200L, TimeUnit.MILLISECONDS, ru6Var, true);
    }

    public static String d(ru6 ru6Var, Context context) {
        return (String) vu6.c(3, 1L, TimeUnit.DAYS, new f(), new g(vu6.a(context), ru6Var), true, 3L, TimeUnit.SECONDS, ru6Var, false);
    }

    public static WifiInfo e(ru6 ru6Var, Context context) {
        Context contextA = vu6.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (WifiInfo) vu6.c(5, 10L, timeUnit, new j(), new a(contextA), false, 10L, timeUnit, ru6Var, false);
    }
}
