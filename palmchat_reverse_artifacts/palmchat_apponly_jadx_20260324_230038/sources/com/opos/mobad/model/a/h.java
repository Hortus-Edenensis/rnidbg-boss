package com.opos.mobad.model.a;

import com.opos.mobad.model.e.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class h implements com.opos.mobad.model.e.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.model.b.c f9049a;

    public h(com.opos.mobad.model.b.c cVar) {
        this.f9049a = cVar;
    }

    @Override // com.opos.mobad.model.e.h
    public com.opos.mobad.model.e.g a(com.opos.mobad.b bVar, String str, String str2, com.opos.mobad.model.c.c cVar, boolean z, int i, int i2, h.a aVar) {
        return new j(bVar, str, str2, cVar, z, this.f9049a, i, i2, aVar);
    }
}
