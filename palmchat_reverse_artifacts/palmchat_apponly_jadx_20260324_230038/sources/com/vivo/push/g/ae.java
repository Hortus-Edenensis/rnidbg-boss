package com.vivo.push.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class ae extends aa {
    public ae(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) vVar;
        com.vivo.push.util.t.c("OnUnBindTask", "doTask,解订阅APP结果 = " + iVar.i() + " clientToken= " + iVar.e());
        com.vivo.push.m.a().a(iVar.h(), iVar.i(), new Object[0]);
        com.vivo.push.t.b(new af(this, iVar));
    }
}
