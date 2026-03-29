package com.vivo.push.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class o extends aa {
    public o(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.l lVar = (com.vivo.push.b.l) vVar;
        int iD = lVar.d();
        int iE = lVar.e();
        com.vivo.push.util.ac.c().a("key_dispatch_environment", iD);
        com.vivo.push.util.ac.c().a("key_dispatch_area", iE);
        com.vivo.push.util.t.d("OnDispatcherReceiveTask", "environment  and area=" + iD + "  ; " + iE);
    }
}
