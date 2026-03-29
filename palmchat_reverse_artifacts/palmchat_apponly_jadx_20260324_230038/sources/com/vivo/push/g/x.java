package com.vivo.push.g;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class x extends aa {
    public x(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        Context context = this.f11282a;
        if (com.vivo.push.util.z.c(context, context.getPackageName())) {
            e eVar = new e(vVar);
            eVar.a(((aa) this).b);
            eVar.a(vVar);
        } else {
            d dVar = new d(vVar);
            dVar.a(((aa) this).b);
            dVar.a(vVar);
        }
    }
}
