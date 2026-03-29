package com.opos.mobad.c.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.n.a.d f8570a;

    public a() {
    }

    public a(com.opos.mobad.n.a.d dVar) {
        this.f8570a = dVar;
    }

    public boolean a() {
        Boolean bool;
        com.opos.mobad.n.a.d dVar = this.f8570a;
        return (dVar == null || (bool = dVar.e) == null) ? com.opos.mobad.n.a.d.d.booleanValue() : bool.booleanValue();
    }

    public String b() {
        String str;
        com.opos.mobad.n.a.d dVar = this.f8570a;
        return (dVar == null || (str = dVar.f) == null) ? "" : str;
    }
}
