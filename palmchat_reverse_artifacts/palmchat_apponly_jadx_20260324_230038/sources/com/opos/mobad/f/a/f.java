package com.opos.mobad.f.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.e.h;
import com.opos.mobad.ad.e.t;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.q;
import com.opos.mobad.f.a.a.r;
import com.opos.mobad.f.a.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f extends com.opos.mobad.m.e {
    private q<com.opos.mobad.ad.e.g, com.opos.mobad.ad.e.h> b;
    private String c;
    private String d;
    private List<String> e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends r<com.opos.mobad.ad.e.h> implements com.opos.mobad.ad.e.j, com.opos.mobad.ad.g {
        private final com.opos.mobad.ad.e.j b;

        public a(int i, com.opos.mobad.f.a.a.p pVar, com.opos.mobad.ad.e.j jVar) {
            super(i, pVar);
            this.b = jVar;
        }

        @Override // com.opos.mobad.ad.g
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.e.j jVar = this.b;
            if (jVar instanceof com.opos.mobad.ad.g) {
                ((com.opos.mobad.ad.g) jVar).a(map);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements com.opos.mobad.ad.e.h, com.opos.mobad.ad.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.mobad.ad.e.h f8865a;
        private String b;
        private String c;
        private boolean d = false;
        private int e;
        private int f;
        private List<String> g;

        public b(com.opos.mobad.ad.e.h hVar, String str, String str2, int i, int i2, List<String> list) {
            this.f8865a = hVar;
            this.b = str;
            this.c = str2;
            this.e = i;
            this.f = i2;
            this.g = list;
        }

        @Override // com.opos.mobad.ad.e.h
        public String a() {
            return this.f8865a.a();
        }

        @Override // com.opos.mobad.ad.e.h
        public String b() {
            return this.f8865a.b();
        }

        @Override // com.opos.mobad.ad.e.h
        public List<com.opos.mobad.ad.e.e> c() {
            return this.f8865a.c();
        }

        @Override // com.opos.mobad.ad.e.h
        public List<com.opos.mobad.ad.e.e> d() {
            return this.f8865a.d();
        }

        @Override // com.opos.mobad.ad.j
        public int e() {
            return 0;
        }

        @Override // com.opos.mobad.ad.j
        public int f() {
            int i;
            if (com.opos.mobad.c.b.a().b(this.b)) {
                i = this.f;
            } else {
                com.opos.cmn.an.f.a.b("NativeAdvanceAdDelegator", "isBiddingOutEnable: false");
                i = -102;
            }
            com.opos.mobad.c.b.e().a(this.b, this.c, i, this.e);
            return i;
        }

        @Override // com.opos.mobad.ad.e.h
        public int g() {
            return this.f8865a.g();
        }

        @Override // com.opos.mobad.ad.e.h
        public int h() {
            return this.f8865a.h();
        }

        @Override // com.opos.mobad.ad.e.h
        public com.opos.mobad.ad.e.e i() {
            return this.f8865a.i();
        }

        @Override // com.opos.mobad.ad.e.h
        public boolean j() {
            return this.f8865a.j();
        }

        @Override // com.opos.mobad.ad.e.h
        public String k() {
            return this.f8865a.k();
        }

        @Override // com.opos.mobad.ad.e.h
        public String l() {
            return this.f8865a.l();
        }

        @Override // com.opos.mobad.ad.e.h
        public void m() {
            this.f8865a.m();
        }

        @Override // com.opos.mobad.ad.e.h
        public com.opos.mobad.ad.e.b n() {
            return this.f8865a.n();
        }

        @Override // com.opos.mobad.ad.e.h
        public String o() {
            return this.f8865a.o();
        }

        @Override // com.opos.mobad.ad.e.h
        public int p() {
            return this.f8865a.p();
        }

        @Override // com.opos.mobad.ad.e.h
        public List<com.opos.mobad.ad.e.e> q() {
            return this.f8865a.q();
        }

        @Override // com.opos.mobad.ad.f
        public void setDlClickListener(com.opos.mobad.ad.g gVar) {
            com.opos.mobad.ad.e.h hVar = this.f8865a;
            if (hVar instanceof com.opos.mobad.ad.f) {
                ((com.opos.mobad.ad.f) hVar).setDlClickListener(gVar);
            }
        }

        @Override // com.opos.mobad.ad.j
        public void a(int i, String str, int i2) {
            if (!com.opos.mobad.c.b.a().b(this.b) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.c.b.e().a(this.b, this.c, i, str, this.e, this.f, i2);
        }

        @Override // com.opos.mobad.ad.j
        public void b(int i) {
            if (!com.opos.mobad.c.b.a().b(this.b) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.c.b.e().a(this.b, this.c, this.e, this.f, i);
        }

        @Override // com.opos.mobad.ad.j
        public void c(int i) {
            if ((com.opos.mobad.c.b.a().b(this.b) || this.g != null) && !this.d) {
                this.f8865a.c(i);
            }
        }

        @Override // com.opos.mobad.ad.e.h
        public void a(Context context, FrameLayout frameLayout, com.opos.mobad.ad.e.k kVar) {
            this.f8865a.a(context, frameLayout, kVar);
        }

        @Override // com.opos.mobad.ad.e.h
        public void a(Context context, FrameLayout frameLayout, t tVar, List<View> list, List<View> list2) {
            this.f8865a.a(context, frameLayout, tVar, list, list2);
        }

        @Override // com.opos.mobad.ad.e.h
        public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2) {
            this.f8865a.a(context, list, aVar, list2, aVar2);
        }

        @Override // com.opos.mobad.ad.e.h
        public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2, List<View> list3, h.a aVar3) {
            this.f8865a.a(context, list, aVar, list2, aVar2, list3, aVar3);
        }

        @Override // com.opos.mobad.ad.e.h
        public void a(com.opos.mobad.ad.e.i iVar) {
            this.f8865a.a(iVar);
        }

        @Override // com.opos.mobad.ad.e.h
        public boolean a(String str) {
            return this.f8865a.a(str);
        }
    }

    public f(final Context context, final String str, com.opos.mobad.f.a.e.a aVar, final com.opos.mobad.ad.e.j jVar, List<d.a> list, d.a aVar2, long j, final com.opos.mobad.f.b bVar, final com.opos.mobad.ad.privacy.a aVar3) {
        super(jVar);
        this.d = str;
        this.b = a(str, aVar, list, aVar2, j, new com.opos.mobad.f.a.b.c<com.opos.mobad.ad.e.g>() { // from class: com.opos.mobad.f.a.f.1
            @Override // com.opos.mobad.f.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.e.g b(d.a aVar4, com.opos.mobad.f.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar.b(aVar4.f);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(context, str, aVar4.g, aVar4.j, aVar4.i, f.this.new a(aVar4.f, pVar, jVar), aVar3);
            }
        }, new com.opos.mobad.f.a.c.a(context));
    }

    private int h() {
        return com.opos.mobad.c.b.a().s();
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
    }

    @Override // com.opos.mobad.m.f
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.b
    public boolean d() {
        return false;
    }

    private q<com.opos.mobad.ad.e.g, com.opos.mobad.ad.e.h> a(String str, com.opos.mobad.f.a.e.a aVar, List<d.a> list, d.a aVar2, long j, com.opos.mobad.f.a.b.c<com.opos.mobad.ad.e.g> cVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j, cVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.f.2
            @Override // com.opos.mobad.ad.b.a
            public void onAdFailed(int i, String str2) {
                int iA = com.opos.mobad.f.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("NativeAdvanceAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                f.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdReady() {
                List listG = f.this.b.g();
                f fVar = f.this;
                fVar.b(fVar.a((List<com.opos.mobad.ad.e.h>) listG, fVar.b.j()));
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdClose() {
            }
        });
    }

    @Override // com.opos.mobad.m.f
    public boolean b(String str, int i) {
        return b(str, i, null);
    }

    @Override // com.opos.mobad.m.f
    public boolean b(String str, int i, List<String> list) {
        return b(str, i, list, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.opos.mobad.ad.e.h> a(List<com.opos.mobad.ad.e.h> list, int i) {
        if (list == null || list.size() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (com.opos.mobad.ad.e.h hVar : list) {
            if (hVar != null) {
                arrayList.add(new b(hVar, this.d, this.c, i, h.a(this.b.j(), hVar, this.b.k()), this.e));
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.m.f
    public boolean b(String str, int i, List<String> list, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
            this.e = list;
            this.b.a(str, i, list, str2);
            return true;
        }
        com.opos.cmn.an.f.a.b("NativeAdvanceAdDelegator", "error request Id:" + str);
        c(10701, "show error, please reload");
        return true;
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.b
    public void a() {
        a(h());
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.l
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f8869a != 0) {
            com.opos.mobad.c.b.f().c(this.d);
        }
        a(aVarA.b, i, list);
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.l
    public void a(List<String> list) {
        a(h(), list);
    }
}
