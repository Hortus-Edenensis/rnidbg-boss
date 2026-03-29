package com.opos.mobad.template.j;

import android.view.View;
import com.opos.mobad.template.a;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a.InterfaceC0778a f10190a;

    public c(int i) {
        super(i);
        this.f10190a = new a.InterfaceC0778a() { // from class: com.opos.mobad.template.j.c.1
            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int i2) {
                c.this.a(i2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(long j, long j2) {
                c.this.b(j, j2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(int i2) {
                c.this.b(i2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(long j, long j2) {
                c.this.c(j, j2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void e(View view, int[] iArr) {
                c.this.a(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void f() {
                c.this.m();
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void g(View view, int[] iArr) {
                c.this.g(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void h(View view, int[] iArr) {
                c.this.h(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void i(View view, int[] iArr) {
                c.this.b(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void j(View view, int[] iArr) {
                c.this.c(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void l(View view, int[] iArr) {
                c.this.k(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int i2, int[] iArr) {
                c.this.a(i2, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(View view, int[] iArr) {
                c.this.e(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(long j, long j2) {
                c.this.a(j, j2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(View view, int[] iArr) {
                c.this.f(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void f(View view, int[] iArr) {
                c.this.i(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(long j, long j2) {
                c.this.o();
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(Map<String, String> map) {
                c.this.c(map);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(View view, int[] iArr) {
                c.this.d(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int i2, boolean z) {
                com.opos.cmn.an.f.a.a("WrapperTemplateState", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                c.this.a(view, i2, z);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(int[] iArr) {
                c.this.a(iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int[] iArr) {
                c.this.j(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int[] iArr, boolean z) {
                c.this.a(view, iArr, z);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(a.b bVar, Map<String, String> map) {
                c.this.a(bVar, map);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(Map<String, String> map) {
                if (map != null && map.containsKey("isVisibleRect") && map.containsKey("isAttached")) {
                    c.this.b(map);
                } else {
                    c.this.a(map);
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int[] iArr) {
                c.this.b(iArr);
            }
        };
    }

    public a.InterfaceC0778a i() {
        return this.f10190a;
    }
}
