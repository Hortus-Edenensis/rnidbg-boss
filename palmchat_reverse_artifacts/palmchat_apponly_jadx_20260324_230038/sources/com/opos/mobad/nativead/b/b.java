package com.opos.mobad.nativead.b;

import com.opos.mobad.model.data.MaterialFileData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements com.opos.mobad.ad.e.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MaterialFileData f9121a;

    public b(MaterialFileData materialFileData) {
        this.f9121a = materialFileData;
    }

    @Override // com.opos.mobad.ad.e.e
    public String a() {
        return this.f9121a.a();
    }

    @Override // com.opos.mobad.ad.e.e
    public String b() {
        return this.f9121a.b();
    }

    @Override // com.opos.mobad.ad.e.e
    public int c() {
        return this.f9121a.c();
    }

    @Override // com.opos.mobad.ad.e.e
    public int d() {
        return this.f9121a.d();
    }
}
