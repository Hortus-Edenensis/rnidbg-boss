package com.vivo.push.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class u extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11211a;
    private int b;

    public u() {
        super(20);
        this.f11211a = -1L;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("undo_msg_v1", this.f11211a);
        dVar.a("undo_msg_type_v1", this.b);
    }

    public final long d() {
        return this.f11211a;
    }

    public final String e() {
        long j = this.f11211a;
        if (j != -1) {
            return String.valueOf(j);
        }
        return null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11211a = dVar.b("undo_msg_v1", this.f11211a);
        this.b = dVar.b("undo_msg_type_v1", 0);
    }
}
