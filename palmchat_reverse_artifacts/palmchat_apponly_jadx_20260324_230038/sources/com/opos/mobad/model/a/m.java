package com.opos.mobad.model.a;

import com.opos.mobad.b.a.ac;
import com.opos.mobad.model.e.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class m extends a {
    private com.opos.mobad.model.b.b d;
    private String e;
    private List<ac> f;
    private com.opos.mobad.b g;

    public m(com.opos.mobad.b bVar, String str, String str2, com.opos.mobad.model.c.c cVar, boolean z, g.a aVar, com.opos.mobad.model.b.c cVar2) {
        super(bVar, str, cVar, z, new g(str, str2, false), aVar);
        this.f = new ArrayList();
        this.g = bVar;
        this.e = str;
        this.d = new com.opos.mobad.model.b.a.a(bVar, cVar2);
    }

    private void f() {
        if (this.f.size() <= 0) {
            return;
        }
        int i = 0;
        for (ac acVar : this.f) {
            if (i >= 1) {
                return;
            }
            com.opos.mobad.model.utils.g.a(this.g.b(), acVar);
            i++;
        }
    }

    @Override // com.opos.mobad.model.a.a
    public void a(com.opos.mobad.model.c.c cVar) {
        a(this.e, cVar);
    }

    @Override // com.opos.mobad.model.a.a, com.opos.mobad.model.e.a
    public void b() {
        f();
        super.b();
    }

    private void a(final String str, final com.opos.mobad.model.c.c cVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.m.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.model.c.d dVarA = m.this.d.a(str, cVar, ((a) m.this).f9037a);
                com.opos.cmn.an.f.a.b("sLoader", "fetchNewResponseAsync() response=", dVarA);
                com.opos.mobad.model.utils.f.a(m.this.g.b(), str, dVarA.d());
                if (dVarA.p()) {
                    m.this.g.n().a();
                }
                if (dVarA.f() == 1035) {
                    m.this.g.q().a(str, false, dVarA.l() * 1000);
                }
                m.this.a(dVarA);
            }
        });
    }

    @Override // com.opos.mobad.model.a.a
    public void b(ac acVar) {
        if (acVar != null) {
            this.f.add(acVar);
        }
    }
}
