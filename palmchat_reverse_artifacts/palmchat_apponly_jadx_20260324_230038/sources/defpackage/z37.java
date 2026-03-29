package defpackage;

import android.content.Context;
import android.util.Log;
import defpackage.xy2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class z37 extends l {
    public final Context c;
    public final String d;
    public volatile zl0 e;
    public final Object f = new Object();
    public h g = h.b;
    public final Map<String, String> h = new HashMap();
    public volatile ea7 i;

    public z37(Context context, String str) {
        this.c = context;
        this.d = str;
    }

    public static String e(String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return '/' + str.substring(i);
    }

    @Override // defpackage.j
    public String a() {
        return "DEFAULT_INSTANCE";
    }

    @Override // defpackage.j
    public h b() {
        Log.d("AGC_ConfigImpl", "getRoutePolicy");
        if (this.g == null) {
            this.g = h.b;
        }
        h hVar = this.g;
        h hVar2 = h.b;
        if (hVar == hVar2 && this.e == null) {
            f();
        }
        h hVar3 = this.g;
        return hVar3 == null ? hVar2 : hVar3;
    }

    public final void f() {
        Log.d("AGC_ConfigImpl", "initConfigReader");
        if (this.e == null) {
            synchronized (this.f) {
                if (this.e == null) {
                    this.e = new jh7(this.c, this.d);
                    this.i = new ea7(this.e);
                }
                h();
            }
        }
    }

    public final String g(String str) {
        xy2.a aVar;
        Map<String, xy2.a> mapA = xy2.a();
        if (mapA.containsKey(str) && (aVar = mapA.get(str)) != null) {
            return aVar.a(this);
        }
        return null;
    }

    @Override // defpackage.j
    public Context getContext() {
        return this.c;
    }

    @Override // defpackage.j
    public String getString(String str) {
        return i(str, null);
    }

    public final void h() {
        if (this.g == h.b) {
            if (this.e != null) {
                this.g = t86.f(this.e.getString("/region", null), this.e.getString("/agcgw/url", null));
            } else {
                Log.w("AGConnectServiceConfig", "get route fail , config not ready");
            }
        }
    }

    public String i(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("path must not be null.");
        }
        if (this.e == null) {
            f();
        }
        String strE = e(str);
        String str3 = this.h.get(strE);
        if (str3 != null) {
            return str3;
        }
        String strG = g(strE);
        if (strG != null) {
            return strG;
        }
        String string = this.e.getString(strE, str2);
        return ea7.c(string) ? this.i.a(string, str2) : string;
    }
}
