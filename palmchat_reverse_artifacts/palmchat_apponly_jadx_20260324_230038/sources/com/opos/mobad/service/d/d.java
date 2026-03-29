package com.opos.mobad.service.d;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.i.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9219a = com.opos.cmn.an.b.b.a(com.cdo.oaps.ad.a.b);
    public static final String b = com.opos.cmn.an.b.b.a("Y29tLm9wb3MuYWRz");
    private static d c;
    private Context d;
    private InterfaceC0771d e;
    private g f;
    private f g;
    private e h;
    private String i;
    private String j;
    private String k;
    private com.opos.cmn.i.a l;
    private com.opos.cmn.i.a m;
    private com.opos.cmn.i.a n;
    private com.opos.cmn.i.a o;
    private String p;
    private String q;
    private volatile b r;
    private volatile b s;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        String a();

        String b();

        String c();

        int d();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9228a;
        public final String b;

        public b(int i, String str) {
            this.f9228a = i;
            this.b = str;
        }

        public String toString() {
            return "AppVerInfo{verCode=" + this.f9228a + ", verName='" + this.b + "'}";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        String a();
    }

    /* JADX INFO: renamed from: com.opos.mobad.service.d.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0771d {
        String a();

        String b();

        boolean c();

        void d();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        String a();

        long b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        int a();

        String b();

        int c();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        String a();

        String b();

        boolean c();

        void d();
    }

    private d() {
    }

    private int b(Context context) {
        return com.opos.cmn.an.h.d.a.d(context, "com.heytap.market") ? com.opos.cmn.an.h.d.a.b(context, "com.heytap.market") : com.opos.cmn.an.h.d.a.b(context, f9219a);
    }

    private int d(Context context) {
        String str = b;
        if (com.opos.cmn.an.h.d.a.d(context, str)) {
            return com.opos.cmn.an.h.d.a.b(context, str);
        }
        return -1;
    }

    private void u() {
        this.n = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.d.d.1
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0673a interfaceC0673a) {
                com.opos.cmn.an.f.a.b("infoManager", "init instant");
                if (d.this.e == null) {
                    interfaceC0673a.b();
                } else {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.d.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                d.this.e.d();
                                a.InterfaceC0673a interfaceC0673a2 = interfaceC0673a;
                                if (interfaceC0673a2 != null) {
                                    interfaceC0673a2.a();
                                }
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                                a.InterfaceC0673a interfaceC0673a3 = interfaceC0673a;
                                if (interfaceC0673a3 != null) {
                                    interfaceC0673a3.b();
                                }
                            }
                        }
                    });
                }
            }
        }, Integer.MAX_VALUE, 120000);
        this.o = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.d.d.2
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0673a interfaceC0673a) {
                com.opos.cmn.an.f.a.b("infoManager", "init xgame");
                if (d.this.f == null) {
                    interfaceC0673a.b();
                } else {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.d.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                d.this.f.d();
                                a.InterfaceC0673a interfaceC0673a2 = interfaceC0673a;
                                if (interfaceC0673a2 != null) {
                                    interfaceC0673a2.a();
                                }
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                                a.InterfaceC0673a interfaceC0673a3 = interfaceC0673a;
                                if (interfaceC0673a3 != null) {
                                    interfaceC0673a3.b();
                                }
                            }
                        }
                    });
                }
            }
        }, Integer.MAX_VALUE, 120000);
        this.l = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.d.d.3
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0673a interfaceC0673a) {
                com.opos.cmn.an.f.a.b("infoManager", "init market");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.d.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.v();
                            d.this.w();
                            a.InterfaceC0673a interfaceC0673a2 = interfaceC0673a;
                            if (interfaceC0673a2 != null) {
                                interfaceC0673a2.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                            a.InterfaceC0673a interfaceC0673a3 = interfaceC0673a;
                            if (interfaceC0673a3 != null) {
                                interfaceC0673a3.b();
                            }
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 120000);
        this.m = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.d.d.4
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0673a interfaceC0673a) {
                com.opos.cmn.an.f.a.b("infoManager", "init operator");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.d.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d dVar = d.this;
                            dVar.p = com.opos.cmn.an.h.e.a.e(dVar.d);
                            a.InterfaceC0673a interfaceC0673a2 = interfaceC0673a;
                            if (interfaceC0673a2 != null) {
                                interfaceC0673a2.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                            a.InterfaceC0673a interfaceC0673a3 = interfaceC0673a;
                            if (interfaceC0673a3 != null) {
                                interfaceC0673a3.b();
                            }
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 180000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b v() {
        this.r = new b(b(this.d), a(this.d));
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b w() {
        if (!com.opos.cmn.an.h.d.a.d(this.d, b)) {
            return null;
        }
        this.s = new b(d(this.d), c(this.d));
        return this.s;
    }

    public String f() {
        g gVar = this.f;
        if (gVar == null) {
            return "";
        }
        this.o.a();
        return gVar.a();
    }

    public String g() {
        g gVar = this.f;
        if (gVar == null) {
            return "";
        }
        this.o.a();
        return gVar.b();
    }

    public String h() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = com.opos.cmn.an.c.d.b();
        }
        return this.i;
    }

    public String i() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = com.opos.cmn.an.c.d.a();
        }
        return this.j;
    }

    public String j() {
        if (TextUtils.isEmpty(this.k)) {
            this.k = com.opos.cmn.an.c.c.c();
        }
        return this.k;
    }

    public b k() {
        b bVar = this.r;
        if (bVar != null) {
            this.l.a();
            return bVar;
        }
        b bVarV = v();
        this.r = bVarV;
        return bVarV;
    }

    public b l() {
        b bVar = this.s;
        if (bVar != null) {
            this.l.a();
            return bVar;
        }
        b bVarW = w();
        this.s = bVarW;
        return bVarW;
    }

    public int m() {
        return this.g.a();
    }

    public String n() {
        return this.g.b();
    }

    public int o() {
        return this.g.c();
    }

    public String p() {
        e eVar = this.h;
        return eVar == null ? "" : eVar.a();
    }

    public long q() {
        e eVar = this.h;
        if (eVar == null) {
            return 0L;
        }
        return eVar.b();
    }

    public String r() {
        if (!TextUtils.isEmpty(this.p)) {
            this.m.a();
            return this.p;
        }
        String strE = com.opos.cmn.an.h.e.a.e(this.d);
        this.p = strE;
        return strE;
    }

    public String s() {
        return this.q;
    }

    public void t() {
        this.h = null;
        this.e = null;
        this.f = null;
    }

    public static final d a() {
        d dVar;
        d dVar2 = c;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            if (c == null) {
                c = new d();
            }
            dVar = c;
        }
        return dVar;
    }

    private String c(Context context) {
        String str = b;
        return com.opos.cmn.an.h.d.a.d(context, str) ? com.opos.cmn.an.h.d.a.c(context, str) : "";
    }

    public boolean e() {
        g gVar = this.f;
        if (gVar == null) {
            return false;
        }
        this.o.a();
        return gVar.c();
    }

    private String a(Context context) {
        return com.opos.cmn.an.h.d.a.d(context, "com.heytap.market") ? com.opos.cmn.an.h.d.a.c(context, "com.heytap.market") : com.opos.cmn.an.h.d.a.c(context, f9219a);
    }

    public String b() {
        InterfaceC0771d interfaceC0771d = this.e;
        if (interfaceC0771d == null) {
            return "";
        }
        this.n.a();
        return interfaceC0771d.b();
    }

    public boolean c() {
        InterfaceC0771d interfaceC0771d = this.e;
        if (interfaceC0771d == null) {
            return false;
        }
        this.n.a();
        return interfaceC0771d.c();
    }

    public String d() {
        InterfaceC0771d interfaceC0771d = this.e;
        if (interfaceC0771d == null) {
            return "";
        }
        this.n.a();
        return interfaceC0771d.a();
    }

    public void a(Context context, InterfaceC0771d interfaceC0771d, g gVar, f fVar, e eVar) {
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        this.q = applicationContext.getPackageName();
        this.e = interfaceC0771d;
        this.f = gVar;
        this.g = fVar;
        this.h = eVar;
        u();
    }
}
