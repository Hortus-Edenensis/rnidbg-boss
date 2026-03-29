package com.igexin.push.core.d;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7203a = "GTConfigProxy";
    private static volatile b b;
    private e c = new a();

    private b() {
    }

    public static b d() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    @Override // com.igexin.push.core.d.e
    public final Map<String, String> a() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    @Override // com.igexin.push.core.d.e
    public final Map<String, String> b() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // com.igexin.push.core.d.e
    public final boolean c() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.c();
        }
        return false;
    }

    private void a(e eVar) {
        this.c = eVar;
    }

    @Override // com.igexin.push.core.d.e
    public final boolean a(Map<String, String> map) {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.a(map);
        }
        return false;
    }
}
