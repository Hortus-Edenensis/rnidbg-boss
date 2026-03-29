package com.igexin.push.core.i.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class f extends b<e> {
    public f(e eVar) {
        super(eVar);
    }

    @Override // com.igexin.push.core.i.a.b, com.igexin.push.core.i.a.l
    public final void b() {
        ((e) this.f7274a).a().prepareToDraw();
    }

    @Override // com.igexin.push.core.i.a.m
    public final Class<e> d() {
        return e.class;
    }

    @Override // com.igexin.push.core.i.a.m
    public final int e() {
        h hVar = ((e) this.f7274a).c.f7278a;
        return hVar.f7280a.m() + hVar.j;
    }

    @Override // com.igexin.push.core.i.a.m
    public final void f() {
        ((e) this.f7274a).stop();
        e eVar = (e) this.f7274a;
        eVar.e = true;
        h hVar = eVar.c.f7278a;
        hVar.b.clear();
        hVar.b();
        hVar.c = false;
        if (hVar.e != null) {
            hVar.e = null;
        }
        if (hVar.g != null) {
            hVar.g = null;
        }
        if (hVar.i != null) {
            hVar.i = null;
        }
        hVar.f7280a.o();
        hVar.f = true;
    }
}
