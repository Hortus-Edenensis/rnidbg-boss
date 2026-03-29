package com.opos.mobad.f.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.e.s;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.q;
import com.opos.mobad.f.a.a.r;
import com.opos.mobad.f.a.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g extends com.opos.mobad.m.g {
    private String b;
    private String c;
    private q<com.opos.mobad.ad.e.n, com.opos.mobad.ad.e.p> d;
    private List<String> e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends r<com.opos.mobad.ad.e.p> implements com.opos.mobad.ad.e.o, com.opos.mobad.ad.g {
        private int c;
        private final com.opos.mobad.ad.e.o d;

        public a(int i, com.opos.mobad.f.a.a.p pVar, com.opos.mobad.ad.e.o oVar) {
            super(i, pVar);
            this.c = i;
            this.d = oVar;
        }

        @Override // com.opos.mobad.ad.g
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.e.o oVar = this.d;
            if (oVar instanceof com.opos.mobad.ad.g) {
                ((com.opos.mobad.ad.g) oVar).a(map);
            }
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdClick(com.opos.mobad.ad.e.p pVar) {
            if (this.c == g.this.d.j()) {
                com.opos.mobad.c.b.f().b(g.this.b);
                g.this.a(pVar);
            }
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdClose(com.opos.mobad.ad.e.p pVar) {
            if (this.c == g.this.d.j()) {
                g.this.c(pVar);
            }
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdShow(com.opos.mobad.ad.e.p pVar) {
            if (this.c == g.this.d.j()) {
                com.opos.mobad.c.b.f().a(g.this.b);
                g.this.b(pVar);
            }
        }

        @Override // com.opos.mobad.ad.e.o
        public void onRenderFailed(com.opos.mobad.ad.e.q qVar, com.opos.mobad.ad.e.p pVar) {
            if (this.c == g.this.d.j()) {
                g.this.a(qVar, pVar);
            }
        }

        @Override // com.opos.mobad.ad.e.o
        public void onRenderSuccess(com.opos.mobad.ad.e.p pVar) {
            if (this.c == g.this.d.j()) {
                g.this.d(pVar);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements com.opos.mobad.ad.e.p, com.opos.mobad.ad.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8868a;
        private String b;
        private int c;
        private boolean d = false;
        private com.opos.mobad.ad.e.p e;
        private int f;
        private List<String> g;

        public b(com.opos.mobad.ad.e.p pVar, String str, String str2, int i, int i2, List<String> list) {
            this.e = pVar;
            this.f8868a = str;
            this.b = str2;
            this.c = i;
            this.f = i2;
            this.g = list;
        }

        @Override // com.opos.mobad.ad.e.p
        public View a() {
            return this.e.a();
        }

        @Override // com.opos.mobad.ad.e.p
        public void b() {
            this.e.b();
        }

        @Override // com.opos.mobad.ad.e.p
        public void c() {
            this.e.c();
        }

        @Override // com.opos.mobad.ad.e.p
        public Object d() {
            return this.e.d();
        }

        @Override // com.opos.mobad.ad.j
        public int e() {
            return 0;
        }

        @Override // com.opos.mobad.ad.j
        public int f() {
            if (com.opos.mobad.c.b.a().b(this.f8868a)) {
                return this.f;
            }
            return -102;
        }

        @Override // com.opos.mobad.ad.e.p
        public String g() {
            return this.e.g();
        }

        @Override // com.opos.mobad.ad.f
        public void setDlClickListener(com.opos.mobad.ad.g gVar) {
            com.opos.mobad.ad.e.p pVar = this.e;
            if (pVar instanceof com.opos.mobad.ad.f) {
                ((com.opos.mobad.ad.f) pVar).setDlClickListener(gVar);
            }
        }

        @Override // com.opos.mobad.ad.j
        public void a(int i, String str, int i2) {
            if (!com.opos.mobad.c.b.a().b(this.f8868a) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.c.b.e().a(this.f8868a, this.b, i, str, this.c, this.f, i2);
        }

        @Override // com.opos.mobad.ad.j
        public void b(int i) {
            if (!com.opos.mobad.c.b.a().b(this.f8868a) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.c.b.e().a(this.f8868a, this.b, this.c, this.f, i);
        }

        @Override // com.opos.mobad.ad.j
        public void c(int i) {
            if ((com.opos.mobad.c.b.a().b(this.f8868a) || this.g != null) && !this.d) {
                this.e.c(i);
            }
        }

        @Override // com.opos.mobad.ad.e.p
        public void a(Object obj) {
            this.e.a(obj);
        }
    }

    public g(final Context context, final s sVar, final String str, com.opos.mobad.f.a.e.a aVar, final com.opos.mobad.ad.e.o oVar, List<d.a> list, d.a aVar2, long j, final com.opos.mobad.f.b bVar) {
        super(oVar);
        this.b = str;
        this.d = a(str, aVar, list, aVar2, j, new com.opos.mobad.f.a.b.c<com.opos.mobad.ad.e.n>() { // from class: com.opos.mobad.f.a.g.1
            @Override // com.opos.mobad.f.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.e.n b(d.a aVar3, com.opos.mobad.f.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar.b(aVar3.f);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(context, new s.a().a(sVar.f8530a).b(sVar.b).a(), str, aVar3.g, g.this.new a(aVar3.f, pVar, oVar));
            }
        }, new com.opos.mobad.f.a.c.a(context));
    }

    private int h() {
        return com.opos.mobad.c.b.a().u();
    }

    @Override // com.opos.mobad.m.f
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.b
    public boolean d() {
        return false;
    }

    private q<com.opos.mobad.ad.e.n, com.opos.mobad.ad.e.p> a(String str, com.opos.mobad.f.a.e.a aVar, List<d.a> list, d.a aVar2, long j, com.opos.mobad.f.a.b.c<com.opos.mobad.ad.e.n> cVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j, cVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.g.2
            @Override // com.opos.mobad.ad.b.a
            public void onAdFailed(int i, String str2) {
                int iA = com.opos.mobad.f.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("NativeTemplateAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                g.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdReady() {
                List listG = g.this.d.g();
                g gVar = g.this;
                gVar.b(gVar.a((List<com.opos.mobad.ad.e.p>) listG, gVar.d.j()));
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdClose() {
            }
        });
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.d.b();
    }

    @Override // com.opos.mobad.m.f
    public boolean b(String str, int i) {
        return b(str, i, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.opos.mobad.ad.e.p> a(List<com.opos.mobad.ad.e.p> list, int i) {
        if (list == null || list.size() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (com.opos.mobad.ad.e.p pVar : list) {
            if (pVar != null) {
                arrayList.add(new b(pVar, this.b, this.c, i, h.a(pVar, this.d.k()), this.e));
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.m.f
    public boolean b(String str, int i, List<String> list) {
        return b(str, i, list, "");
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.b
    public void a() {
        a(h());
    }

    @Override // com.opos.mobad.m.f
    public boolean b(String str, int i, List<String> list, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
            this.e = list;
            this.d.a(str, i, list, str2);
            return true;
        }
        com.opos.cmn.an.f.a.b("NativeTemplateAdDelegator", "error request Id:" + str);
        c(10701, "show error, please reload");
        return true;
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.l
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f8869a != 0) {
            com.opos.mobad.c.b.f().c(this.b);
        }
        a(aVarA.b, i, list);
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.l
    public void a(List<String> list) {
        a(h(), list);
    }
}
