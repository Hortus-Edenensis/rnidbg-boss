package com.vivo.push.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class b extends com.vivo.push.s {
    public b(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.model.a aVarA = com.vivo.push.util.z.a(this.f11282a, com.vivo.push.restructure.a.a().f());
        try {
            if (((com.vivo.push.b.d) vVar).d() ? j.a(this.f11282a) : j.b(this.f11282a)) {
                com.vivo.push.model.a aVarA2 = com.vivo.push.util.z.a(this.f11282a, com.vivo.push.restructure.a.a().f());
                if (aVarA == null || aVarA2 == null || aVarA2.a() == null || !aVarA2.a().equals(aVarA.a())) {
                    if (aVarA != null && aVarA.a() != null) {
                        com.vivo.push.a.a.a(this.f11282a, aVarA.a(), new com.vivo.push.b.y(aVarA.a()));
                    }
                    if (aVarA2 == null || aVarA2.a() == null) {
                        return;
                    }
                    com.vivo.push.b.f fVar = new com.vivo.push.b.f();
                    com.vivo.push.restructure.a.a();
                    fVar.d();
                    com.vivo.push.a.a.a(this.f11282a, aVarA2.a(), fVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
