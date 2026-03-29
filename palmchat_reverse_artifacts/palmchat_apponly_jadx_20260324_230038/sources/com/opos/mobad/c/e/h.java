package com.opos.mobad.c.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h implements d<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8601a;

    public h(int i) {
        this.f8601a = i;
    }

    @Override // com.opos.mobad.c.e.d
    public boolean a(e eVar) {
        return eVar.b() >= this.f8601a;
    }
}
