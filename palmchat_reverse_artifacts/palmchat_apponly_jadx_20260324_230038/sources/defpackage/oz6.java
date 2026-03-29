package defpackage;

import android.content.Context;
import android.util.Log;
import defpackage.xy2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class oz6 extends i {
    public static List<z55> d;
    public static final Map<String, i> e = new HashMap();
    public static String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f19907a;
    public final d87 b;
    public final d87 c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements xy2.a {
        @Override // xy2.a
        public String a(j jVar) {
            String str;
            if (jVar.b().equals(h.c)) {
                str = "/agcgw_all/CN";
            } else if (jVar.b().equals(h.e)) {
                str = "/agcgw_all/RU";
            } else if (jVar.b().equals(h.d)) {
                str = "/agcgw_all/DE";
            } else {
                if (!jVar.b().equals(h.f)) {
                    return null;
                }
                str = "/agcgw_all/SG";
            }
            return jVar.getString(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements xy2.a {
        @Override // xy2.a
        public String a(j jVar) {
            String str;
            if (jVar.b().equals(h.c)) {
                str = "/agcgw_all/CN_back";
            } else if (jVar.b().equals(h.e)) {
                str = "/agcgw_all/RU_back";
            } else if (jVar.b().equals(h.d)) {
                str = "/agcgw_all/DE_back";
            } else {
                if (!jVar.b().equals(h.f)) {
                    return null;
                }
                str = "/agcgw_all/SG_back";
            }
            return jVar.getString(str);
        }
    }

    public oz6(j jVar) {
        Log.d("AGC_Instance", "AGConnectInstanceImpl init");
        this.f19907a = jVar;
        if (d == null) {
            Log.e("AGC_Instance", "please call `initialize()` first");
        }
        this.b = new d87(d, jVar.getContext());
        d87 d87Var = new d87(null, jVar.getContext());
        this.c = d87Var;
        if (jVar instanceof e17) {
            d87Var.c(((e17) jVar).d(), jVar.getContext());
        }
        Log.d("AGC_Instance", "AGConnectInstanceImpl init end");
    }

    public static i f() {
        String str = f;
        if (str == null) {
            str = "DEFAULT_INSTANCE";
        }
        return i(str);
    }

    public static i g(j jVar) {
        return h(jVar, false);
    }

    public static synchronized i h(j jVar, boolean z) {
        i oz6Var;
        Map<String, i> map = e;
        oz6Var = map.get(jVar.a());
        if (oz6Var == null || z) {
            oz6Var = new oz6(jVar);
            map.put(jVar.a(), oz6Var);
        }
        return oz6Var;
    }

    public static synchronized i i(String str) {
        i iVar;
        iVar = e.get(str);
        if (iVar == null) {
            if ("DEFAULT_INSTANCE".equals(str)) {
                Log.w("AGC_Instance", "please call `initialize()` first");
            } else {
                Log.w("AGC_Instance", "not find instance for : " + str);
            }
        }
        return iVar;
    }

    public static synchronized void j(Context context) {
        Log.w("AGC_Instance", "agc sdk initialize");
        if (e.size() > 0) {
            Log.w("AGC_Instance", "Repeated invoking initialize");
        } else {
            k(context, l.c(context));
        }
    }

    public static synchronized void k(Context context, j jVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            Log.w("AGC_Instance", "context.getApplicationContext null");
        } else {
            context = applicationContext;
        }
        l();
        if (d == null) {
            d = new b47(context).b();
        }
        h(jVar, true);
        f = jVar.a();
        Log.i("AGC_Instance", "initFinish callback start");
        qv6.a();
        Log.i("AGC_Instance", "AGC SDK initialize end");
    }

    public static void l() {
        xy2.b("/agcgw/url", new a());
        xy2.b("/agcgw/backurl", new b());
    }

    @Override // defpackage.i
    public Context b() {
        return this.f19907a.getContext();
    }

    @Override // defpackage.i
    public j d() {
        return this.f19907a;
    }
}
