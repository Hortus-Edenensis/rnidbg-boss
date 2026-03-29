package com.vivo.push.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class f extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11199a;

    public f() {
        super(0);
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        if (dVar != null) {
            dVar.a("APP_CLIENT_SWITCH_FLAG", this.f11199a);
        }
    }

    public final void d() {
        this.f11199a = 15;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "DefaultCommand";
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        if (dVar != null) {
            this.f11199a = dVar.b("APP_CLIENT_SWITCH_FLAG", 0);
        }
    }
}
