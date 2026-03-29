package com.vivo.push.restructure.a.a;

import android.content.Context;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class h extends a<com.vivo.push.restructure.a.a> {
    public h(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("InitNode", aVar, iVar);
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        Context contextB = com.vivo.push.restructure.a.a().b();
        com.vivo.push.m.a().a(contextB);
        t.d("InitNode", "PushMessageReceiver " + contextB.getPackageName() + " ; requestId = " + aVar.c());
        return 0;
    }
}
