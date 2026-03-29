package com.igexin.push.c;

import android.text.TextUtils;
import com.igexin.push.c.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class g extends h implements i {
    private static g e;

    private g() {
        super(com.igexin.push.core.e.ap, com.igexin.push.core.e.ar);
        this.d.j = false;
    }

    public static synchronized g a() {
        if (e == null) {
            e = new g();
        }
        return e;
    }

    @Override // com.igexin.push.c.h
    public final int c() {
        return b.EnumC0466b.b;
    }

    @Override // com.igexin.push.c.i
    public final void a(int i, d dVar) {
        e eVarA;
        if (dVar == null || TextUtils.isEmpty(dVar.a()) || (eVarA = a(dVar.a())) == null) {
            return;
        }
        a(dVar);
        eVarA.a();
        m();
        if (i == b.a.f7103a) {
            l();
        }
    }

    @Override // com.igexin.push.c.i
    public final void b() {
    }

    @Override // com.igexin.push.c.h
    public final i d() {
        return this;
    }
}
