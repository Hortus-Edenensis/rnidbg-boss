package com.opos.mobad.template;

import android.content.Context;
import com.opos.mobad.template.a;
import com.opos.mobad.template.c.j;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.d.a f9468a;
    private j b;

    public f(j jVar, com.opos.mobad.d.a aVar) {
        this.f9468a = aVar;
        this.b = jVar;
    }

    public final a a(Context context, int i, com.opos.mobad.template.l.a aVar, a.InterfaceC0778a interfaceC0778a) {
        com.opos.mobad.d.a aVar2;
        j jVar = this.b;
        if (jVar == null || (aVar2 = this.f9468a) == null) {
            return null;
        }
        return jVar.a(context, i, aVar, interfaceC0778a, aVar2);
    }
}
