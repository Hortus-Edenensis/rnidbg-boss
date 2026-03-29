package com.opos.mobad.e;

import android.content.Context;
import com.opos.mobad.j;
import com.opos.mobad.k;
import com.opos.mobad.r;
import com.opos.mobad.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8788a;
    private r b = new h();
    private com.opos.mobad.a c = new a();
    private com.opos.mobad.h d = new e();
    private com.opos.mobad.i e = new f();
    private s f = new i();
    private com.opos.mobad.e g = new c();
    private com.opos.mobad.f h = new d();
    private k i = new g();

    public b(Context context) {
        this.f8788a = context.getApplicationContext();
    }

    @Override // com.opos.mobad.j
    public k g() {
        return this.i;
    }

    @Override // com.opos.mobad.j
    public com.opos.mobad.service.c.a h() {
        return com.opos.mobad.service.c.a.a();
    }

    @Override // com.opos.mobad.j
    public r i() {
        return this.b;
    }

    @Override // com.opos.mobad.j
    public com.opos.mobad.a j() {
        return this.c;
    }

    @Override // com.opos.mobad.j
    public com.opos.mobad.model.e.b k() {
        return com.opos.mobad.model.e.b.a(this.f8788a.getApplicationContext());
    }

    @Override // com.opos.mobad.j
    public com.opos.mobad.cmn.service.a.a l() {
        return com.opos.mobad.cmn.service.a.a.a(this.f8788a);
    }

    @Override // com.opos.mobad.j
    public com.opos.mobad.cmn.service.pkginstall.c m() {
        return com.opos.mobad.cmn.service.pkginstall.c.a(this.f8788a);
    }

    @Override // com.opos.mobad.j
    public com.opos.mobad.h n() {
        return this.d;
    }

    @Override // com.opos.mobad.j
    public com.opos.mobad.i o() {
        return this.e;
    }

    @Override // com.opos.mobad.j
    public s p() {
        return this.f;
    }

    @Override // com.opos.mobad.j
    public com.opos.mobad.e q() {
        return this.g;
    }

    @Override // com.opos.mobad.j
    public com.opos.mobad.f r() {
        return this.h;
    }
}
