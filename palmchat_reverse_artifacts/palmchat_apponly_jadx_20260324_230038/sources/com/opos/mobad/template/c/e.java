package com.opos.mobad.template.c;

import android.view.View;
import com.opos.mobad.template.a;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.a f9341a;
    private com.opos.mobad.template.f.e b;
    private a.InterfaceC0778a d;
    private boolean c = false;
    private a.InterfaceC0778a e = new a.InterfaceC0778a() { // from class: com.opos.mobad.template.c.e.1
        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void a(int i) {
            if (e.this.c) {
                return;
            }
            e.this.c = true;
            if (e.this.b != null && e.this.b.a() != null) {
                e.this.b.a().setVisibility(8);
            }
            if (e.this.d != null) {
                e.this.d.a(i);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void b(long j, long j2) {
            if (e.this.d != null) {
                e.this.d.b(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void c(int i) {
            if (e.this.d != null) {
                e.this.d.c(i);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void d(long j, long j2) {
            if (e.this.d != null) {
                e.this.d.d(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void e(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.e(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void f() {
            if (e.this.d != null) {
                e.this.d.f();
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void g(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.g(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void h(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.h(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void i(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.i(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void j(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.j(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void l(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.l(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void a(int i, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.a(i, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void b(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.b(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void c(long j, long j2) {
            if (e.this.d != null) {
                e.this.d.c(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void d(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.d(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void f(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.f(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void a(long j, long j2) {
            if (e.this.d != null) {
                e.this.d.a(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void b(Map<String, String> map) {
            if (e.this.d != null) {
                e.this.d.b(map);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void c(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.c(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void a(View view, int i, boolean z) {
            com.opos.cmn.an.f.a.a("InterstitialProxy", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
            if (e.this.d != null) {
                e.this.d.a(view, i, z);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void b(int[] iArr) {
            if (e.this.d != null) {
                e.this.d.b(iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void a(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.a(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void a(View view, int[] iArr, boolean z) {
            if (e.this.d != null) {
                e.this.d.a(view, iArr, z);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void a(a.b bVar, Map<String, String> map) {
            if (e.this.d != null) {
                e.this.d.a(bVar, map);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void a(Map<String, String> map) {
            if (e.this.d != null) {
                e.this.d.a(map);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC0778a
        public void a(int[] iArr) {
            if (e.this.d != null) {
                e.this.d.a(iArr);
            }
        }
    };

    public e(com.opos.mobad.template.a aVar, com.opos.mobad.template.f.e eVar) {
        this.f9341a = aVar;
        this.b = eVar;
        eVar.a(aVar.c());
        this.f9341a.a(this.e);
        this.b.a(this.e);
    }

    private boolean f() {
        return this.f9341a == null || this.b == null;
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        if (f()) {
            return;
        }
        this.f9341a.b();
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        if (f()) {
            return null;
        }
        return this.b.a();
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        if (f()) {
            return;
        }
        this.b.b();
        this.f9341a.d();
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        if (f()) {
            return 0;
        }
        return this.f9341a.e();
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (f()) {
            return;
        }
        this.f9341a.a();
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        if (f()) {
            return;
        }
        this.d = interfaceC0778a;
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (f()) {
            return;
        }
        this.f9341a.a(fVar);
        this.b.a(fVar);
    }
}
