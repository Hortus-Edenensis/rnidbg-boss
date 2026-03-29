package com.opos.mobad.template.c;

import android.content.Context;
import com.opos.mobad.template.a;
import com.opos.mobad.template.i.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a implements d {
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    @Override // com.opos.mobad.template.c.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, a.InterfaceC0778a interfaceC0778a, com.opos.mobad.d.a aVar2) {
        com.opos.mobad.template.a aVarA;
        if (i == 21) {
            aVarA = com.opos.mobad.template.i.f.a(context, i, a(i), aVar2);
        } else if (i == 25) {
            aVarA = s.b(context, i, aVar.a(context), a(i), aVar2);
        } else if (i != 56) {
            if (i == 59) {
                aVarA = com.opos.mobad.template.i.f.b(context, i, a(i), aVar2);
            } else if (i == 62) {
                aVarA = com.opos.mobad.template.i.f.c(context, i, a(i), aVar2);
            } else if (i == 68) {
                aVarA = com.opos.mobad.template.i.f.e(context, i, a(i), aVar2);
            } else if (i == 71) {
                aVarA = s.a(context, i, aVar.a(context), a(i), aVar2);
            } else {
                if (i != 76) {
                    return null;
                }
                aVarA = s.c(context, i, aVar.a(context), a(i), aVar2);
            }
        }
        aVarA.a(interfaceC0778a);
        return aVarA;
    }

    private static final com.opos.mobad.template.i.j a(int i) {
        return i != 76 ? com.opos.mobad.template.i.j.NONE : com.opos.mobad.template.i.j.BREATH;
    }
}
