package com.vivo.push.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class v extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11212a;
    private long b;

    public v(int i) {
        super(i);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f11212a);
        dVar.a("notify_id", this.b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11212a = dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.b = dVar.b("notify_id", -1L);
    }

    public final long g() {
        return this.b;
    }

    public final String j() {
        return this.f11212a;
    }
}
