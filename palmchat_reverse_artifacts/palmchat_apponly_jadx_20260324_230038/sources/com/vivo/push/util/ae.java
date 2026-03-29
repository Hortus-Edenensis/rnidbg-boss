package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class ae implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f11295a = new HashMap<>();
    private static final HashMap<String, Long> b = new HashMap<>();
    private static final HashMap<String, String> c = new HashMap<>();
    private static ae d;
    private Context e;
    private e f;
    private boolean g;

    private ae(Context context) {
        this.g = false;
        this.e = context;
        this.g = a(context);
        t.d("SystemCache", "init status is " + this.g + ";  curCache is " + this.f);
    }

    public static synchronized ae b(Context context) {
        if (d == null) {
            d = new ae(context.getApplicationContext());
        }
        return d;
    }

    public final void a() {
        ad adVar = new ad();
        if (adVar.a(this.e)) {
            adVar.a();
            t.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        ab abVar = new ab();
        this.f = abVar;
        boolean zA = abVar.a(context);
        if (!zA) {
            ad adVar = new ad();
            this.f = adVar;
            zA = adVar.a(context);
        }
        if (!zA) {
            this.f = null;
        }
        return zA;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        e eVar;
        String str3 = c.get(str);
        return (str3 != null || (eVar = this.f) == null) ? str3 : eVar.a(str, str2);
    }
}
