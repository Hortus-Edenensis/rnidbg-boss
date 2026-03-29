package com.vivo.push.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class k extends aa {
    public k(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.util.t.d("OnClearCacheTask", "delete push info " + this.f11282a.getPackageName());
        com.vivo.push.util.ae.b(this.f11282a).a();
    }
}
