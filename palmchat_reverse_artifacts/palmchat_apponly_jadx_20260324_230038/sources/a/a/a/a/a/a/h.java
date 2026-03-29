package a.a.a.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final h c = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f1058a = new f(false, null, null, null, 15);
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(a.f1059a);

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends Lambda implements Function0<Map<String, ? extends a.a.a.a.a.a.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1059a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Map<String, ? extends a.a.a.a.a.a.a> invoke() {
            f fVar = h.f1058a;
            return MapsKt__MapsKt.mapOf(TuplesKt.to("1", new b(fVar.b)), TuplesKt.to("2", new c(fVar.c)), TuplesKt.to("3", new d(fVar.d)));
        }
    }

    public static final String a(h hVar, Context context) {
        NetworkCapabilities networkCapabilities;
        int i = Build.VERSION.SDK_INT;
        if (i < 23 || context.checkSelfPermission(com.kuaishou.weapon.p0.g.b) != -1) {
            a.a.a.a.a.a.k.c netWorkUtils = a.a.a.a.a.a.k.c.a(context);
            Intrinsics.checkNotNullExpressionValue(netWorkUtils, "netWorkUtils");
            netWorkUtils.getClass();
            int i2 = 0;
            try {
                ConnectivityManager connectivityManager = netWorkUtils.b;
                NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    if (i >= 23) {
                        Network activeNetwork = netWorkUtils.b.getActiveNetwork();
                        if (activeNetwork != null && (networkCapabilities = netWorkUtils.b.getNetworkCapabilities(activeNetwork)) != null) {
                            boolean zHasTransport = networkCapabilities.hasTransport(4);
                            boolean zHasTransport2 = networkCapabilities.hasTransport(0);
                            boolean zHasTransport3 = networkCapabilities.hasTransport(1);
                            if (zHasTransport) {
                                i2 = 4;
                            } else if (!a.a.a.a.a.a.k.c.a(netWorkUtils.b) || !zHasTransport3) {
                                if (!zHasTransport3) {
                                    if (zHasTransport2) {
                                    }
                                }
                            }
                        }
                    } else {
                        int type = activeNetworkInfo.getType();
                        i2 = type == 1 ? a.a.a.a.a.a.k.c.a(netWorkUtils.b) ? 3 : 1 : type == 0 ? 2 : 5;
                    }
                }
            } catch (Exception unused) {
            }
            if (i2 != 3 || Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.CHANGE_NETWORK_STATE") != -1) {
                if (i2 == 3 || i2 == 2) {
                    return "41128";
                }
                return "21128" + i2;
            }
        }
        return "31128";
    }

    public final i a() {
        for (Map.Entry entry : ((Map) b.getValue()).entrySet()) {
            if (Intrinsics.areEqual(((a.a.a.a.a.a.a) entry.getValue()).b.b, "01128")) {
                return ((a.a.a.a.a.a.a) entry.getValue()).b;
            }
        }
        return new i("111128");
    }

    public final void a(f newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "config");
        f fVar = f1058a;
        fVar.getClass();
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        fVar.f1055a = newConfig.f1055a;
        e eVar = fVar.b;
        e eVar2 = newConfig.b;
        eVar.f1054a = eVar2.f1054a;
        eVar.b = eVar2.b;
        e eVar3 = fVar.c;
        e eVar4 = newConfig.c;
        eVar3.f1054a = eVar4.f1054a;
        eVar3.b = eVar4.b;
        e eVar5 = fVar.d;
        e eVar6 = newConfig.d;
        eVar5.f1054a = eVar6.f1054a;
        eVar5.b = eVar6.b;
    }
}
