package com.opos.mobad.template.c;

import android.content.Context;
import com.opos.mobad.template.a;
import com.opos.mobad.template.h.aa;
import com.opos.mobad.template.h.ab;
import com.opos.mobad.template.h.ac;
import com.opos.mobad.template.h.af;
import com.opos.mobad.template.h.ag;
import com.opos.mobad.template.h.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class h implements d {
    @Override // com.opos.mobad.template.c.d
    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, a.InterfaceC0778a interfaceC0778a, com.opos.mobad.d.a aVar2) {
        com.opos.mobad.template.a aVarA;
        if (i == 27) {
            aVarA = af.a(context, i, aVar.a(context), aVar2);
        } else if (i == 28) {
            aVarA = af.b(context, i, aVar.a(context), aVar2);
        } else if (i == 2082) {
            aVarA = x.e(context, i, aVar.a(context), aVar2);
        } else if (i == 2102) {
            aVarA = x.j(context, i, aVar.a(context), aVar2);
        } else if (i == 2163) {
            aVarA = ag.a(context, i, aVar.a(context), aVar2);
        } else if (i == 2114) {
            aVarA = com.opos.mobad.template.h.c.a(context, i, aVar.a(context), aVar2);
        } else if (i == 2115) {
            aVarA = com.opos.mobad.template.h.c.b(context, i, aVar.a(context), aVar2);
        } else if (i == 10001) {
            aVarA = ac.b(context, i, aVar.a(context), aVar2);
        } else if (i != 10002) {
            switch (i) {
                case 2028:
                    aVarA = x.a(context, i, aVar.a(context), aVar2);
                    break;
                case 2029:
                    aVarA = x.c(context, i, aVar.a(context), aVar2);
                    break;
                case 2030:
                    aVarA = x.b(context, i, aVar.a(context), aVar2);
                    break;
                case 2031:
                    aVarA = x.d(context, i, aVar.a(context), aVar2);
                    break;
                default:
                    switch (i) {
                        case 2084:
                            aVarA = x.f(context, i, aVar.a(context), aVar2);
                            break;
                        case 2085:
                            aVarA = x.g(context, i, aVar.a(context), aVar2);
                            break;
                        case 2086:
                            aVarA = x.h(context, i, aVar.a(context), aVar2);
                            break;
                        case 2087:
                            aVarA = x.i(context, i, aVar.a(context), aVar2);
                            break;
                        default:
                            switch (i) {
                                case 2158:
                                    aVarA = aa.a(context, i, aVar2);
                                    break;
                                case 2159:
                                    aVarA = aa.b(context, i, aVar2);
                                    break;
                                case 2160:
                                    aVarA = ab.a(context, i, aVar.a(context), aVar2);
                                    break;
                                case 2161:
                                    aVarA = ab.b(context, i, aVar.a(context), aVar2);
                                    break;
                                default:
                                    return null;
                            }
                            break;
                    }
                    break;
            }
        } else {
            aVarA = ac.a(context, i, aVar.a(context), aVar2);
        }
        aVarA.a(interfaceC0778a);
        return aVarA;
    }
}
