package com.vivo.push.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class h extends aa {
    public h(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) vVar;
        String strE = iVar.e();
        com.vivo.push.util.t.d("OnBindTask", "doTask,订阅APP结果 = " + iVar.i() + " clientToken= " + strE);
        com.vivo.push.m.a().a(iVar.h(), iVar.i(), strE);
        com.vivo.push.t.b(new i(this, strE, iVar));
    }
}
