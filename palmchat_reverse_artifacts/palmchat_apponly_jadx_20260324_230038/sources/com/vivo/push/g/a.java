package com.vivo.push.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class a extends com.vivo.push.s {
    public a(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) vVar;
        com.vivo.push.model.a aVarA = com.vivo.push.util.z.a(this.f11282a, com.vivo.push.restructure.a.a().f());
        if (aVarA == null) {
            com.vivo.push.m.a().a(cVar.f(), 1005, new Object[0]);
            return;
        }
        String strA = aVarA.a();
        if (aVarA.c()) {
            com.vivo.push.m.a().a(cVar.f(), 1004, new Object[0]);
            vVar = new com.vivo.push.b.e();
        } else {
            int iA = com.vivo.push.util.x.a(cVar);
            if (iA != 0) {
                com.vivo.push.m.a().a(cVar.f(), iA, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.f11282a, strA, vVar);
    }
}
