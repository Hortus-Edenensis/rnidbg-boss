package com.opos.mobad.template.c;

import android.content.Context;
import com.opos.mobad.template.a;
import com.opos.mobad.template.g.am;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements d {
    @Override // com.opos.mobad.template.c.d
    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, a.InterfaceC0778a interfaceC0778a, com.opos.mobad.d.a aVar2) {
        com.opos.mobad.template.a aVarA;
        if (i == 2) {
            aVarA = com.opos.mobad.template.b.c.a(context, a(context), i, aVar2);
        } else if (i == 3) {
            aVarA = com.opos.mobad.template.b.b.a(context, a(context), i, aVar2);
        } else if (i == 4) {
            aVarA = com.opos.mobad.template.b.b.b(context, a(context), i, aVar2);
        } else if (i == 53) {
            aVarA = com.opos.mobad.template.b.b.c(context, a(context), i, aVar2);
        } else if (i == 2027) {
            aVarA = com.opos.mobad.template.b.b.d(context, a(context), i, aVar2);
        } else if (i == 2032) {
            aVarA = com.opos.mobad.template.b.d.d(context, a(context), i, aVar2);
        } else if (i == 2047) {
            aVarA = com.opos.mobad.template.b.d.c(context, a(context), i, aVar2);
        } else if (i == 2044) {
            aVarA = com.opos.mobad.template.b.d.a(context, a(context), i, aVar2);
        } else {
            if (i != 2045) {
                return null;
            }
            aVarA = com.opos.mobad.template.b.d.b(context, a(context), i, aVar2);
        }
        aVarA.a(interfaceC0778a);
        return aVarA;
    }

    private static am a(Context context) {
        int iB = com.opos.cmn.an.h.f.a.b(context);
        return new am(iB, (int) (((double) iB) * 0.6d));
    }
}
