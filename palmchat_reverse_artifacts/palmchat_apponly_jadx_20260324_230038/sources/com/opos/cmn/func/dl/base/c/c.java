package com.opos.cmn.func.dl.base.c;

import android.content.Context;
import com.opos.cmn.func.a.a.d;
import com.opos.cmn.func.dl.base.c.d;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.func.a.a.e f7976a;
    private Map<String, String> b = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements d.a {
        @Override // com.opos.cmn.func.dl.base.c.d.a
        public final d a() {
            return new c();
        }
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a() {
        com.opos.cmn.func.a.a.e eVar = this.f7976a;
        if (eVar != null) {
            return eVar.c;
        }
        return null;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String b() {
        com.opos.cmn.func.a.a.e eVar = this.f7976a;
        return eVar != null ? eVar.b : "";
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void c() {
        com.opos.cmn.func.a.a.e eVar = this.f7976a;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final int d() {
        com.opos.cmn.func.a.a.e eVar = this.f7976a;
        if (eVar != null) {
            return eVar.f7934a;
        }
        return -1;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final long e() {
        com.opos.cmn.func.a.a.e eVar = this.f7976a;
        if (eVar != null) {
            return eVar.d;
        }
        return -1L;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a(Context context, String str, b bVar) {
        Map<String, String> map = bVar.f7975a;
        if (map != null) {
            this.b.putAll(map);
        }
        this.f7976a = com.opos.cmn.func.a.a.b.a().a(context, new d.a().b(str).a(this.b).a("GET").a());
        return a();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String a(String str) {
        com.opos.cmn.func.a.a.a aVar;
        com.opos.cmn.func.a.a.e eVar = this.f7976a;
        return (eVar == null || (aVar = eVar.f) == null) ? "" : aVar.a(str);
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void a(String str, String str2) {
        this.b.put(str, str2);
    }
}
