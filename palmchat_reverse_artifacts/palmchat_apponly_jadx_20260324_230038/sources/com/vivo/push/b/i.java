package com.vivo.push.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class i extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11201a;
    private String b;
    private String c;
    private String d;

    public i(int i) {
        super(i);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("app_id", this.f11201a);
        dVar.a("client_id", this.b);
        dVar.a("client_token", this.c);
        dVar.a("client_token_validity_period", this.d);
    }

    public final String d() {
        return this.f11201a;
    }

    public final String e() {
        return this.c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11201a = dVar.a("app_id");
        this.b = dVar.a("client_id");
        this.c = dVar.a("client_token");
        this.d = dVar.a("client_token_validity_period");
    }
}
