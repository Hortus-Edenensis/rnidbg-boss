package com.baidu.mshield.x6.e;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f4086a = null;
    public static volatile boolean b = false;
    public static volatile boolean c = false;
    public static int d;
    public Context e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends com.baidu.mshield.x6.f.m.a {
        public final /* synthetic */ int b;

        public a(int i) {
            this.b = i;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.c(h.this.e, this.b).b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends com.baidu.mshield.x6.f.m.a {
        public b() {
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.d(h.this.e).a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends com.baidu.mshield.x6.f.m.a {
        public final /* synthetic */ int b;

        public c(int i) {
            this.b = i;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.e(h.this.e, this.b).a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends com.baidu.mshield.x6.f.m.a {
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public d(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.e(h.this.e, this.b, this.c).a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends com.baidu.mshield.x6.f.m.a {
        public e() {
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.b(h.this.e).a();
        }
    }

    public h(Context context) {
        this.e = context;
    }

    public void b() {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new b());
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public static synchronized h a(Context context) {
        if (f4086a == null) {
            f4086a = new h(context);
        }
        return f4086a;
    }

    public void a(int i, boolean z) {
        try {
            if (c) {
                return;
            }
            c = true;
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.e);
            if (!z && com.baidu.mshield.x6.f.f.c().equals(bVar.c())) {
                c = false;
            } else {
                com.baidu.mshield.x6.f.m.c.b().a(new a(i));
            }
        } catch (Throwable th) {
            c = false;
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public void a(int i) {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new c(i));
            a(5, false);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public void a(int i, int i2) {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new d(i, i2));
            a(5, false);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public void a() {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new e());
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }
}
