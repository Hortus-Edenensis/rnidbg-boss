package com.opos.mobad.template.c;

import android.content.Context;
import com.opos.mobad.template.a;
import com.opos.mobad.template.f.l;
import com.opos.mobad.template.f.q;
import com.opos.mobad.template.f.s;
import com.opos.mobad.template.f.t;
import com.opos.mobad.template.f.x;
import com.opos.mobad.template.h.aa;
import com.opos.mobad.template.h.af;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f implements d {
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.opos.mobad.template.a a(Context context, int i, a.InterfaceC0778a interfaceC0778a, com.opos.mobad.template.a aVar, com.opos.mobad.d.a aVar2) {
        com.opos.mobad.template.f.e eVarA;
        Context applicationContext;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        if (i == 5) {
            eVarA = x.a(context.getApplicationContext(), 0, false, aVar2, true);
        } else if (i == 48) {
            eVarA = x.a(context.getApplicationContext(), 1, false, aVar2, true);
        } else if (i == 2071) {
            eVarA = x.a(context.getApplicationContext(), 0, 3, aVar2, true);
        } else if (i != 7) {
            if (i != 8 && i != 9) {
                if (i != 2154 && i != 2155) {
                    switch (i) {
                        case 12:
                            applicationContext = context.getApplicationContext();
                            i2 = 0;
                            z = true;
                            z2 = true;
                            i3 = 12;
                            eVarA = x.a(applicationContext, i2, z, aVar2, z2, i3);
                            break;
                        case 13:
                        case 15:
                            eVarA = x.a(context.getApplicationContext(), 1, true, aVar2, true);
                            break;
                        case 14:
                            applicationContext = context.getApplicationContext();
                            i2 = 0;
                            z = true;
                            z2 = true;
                            i3 = 14;
                            eVarA = x.a(applicationContext, i2, z, aVar2, z2, i3);
                            break;
                        default:
                            switch (i) {
                                case 50:
                                    break;
                                case 51:
                                case 52:
                                    eVarA = x.a(context.getApplicationContext(), 1, false, aVar2, i);
                                    break;
                                default:
                                    switch (i) {
                                        case 2007:
                                            eVarA = x.a(context.getApplicationContext(), 0, 2, aVar2, true);
                                            break;
                                        case 2008:
                                            eVarA = x.a(context.getApplicationContext(), 1, 2, aVar2, true);
                                            break;
                                        case 2009:
                                        case 2010:
                                            break;
                                        default:
                                            eVarA = null;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    eVarA = x.a(context.getApplicationContext());
                }
            } else {
                eVarA = x.a(context.getApplicationContext(), 0, false, aVar2, i);
            }
        }
        if (eVarA == null) {
            if (aVar != null) {
                aVar.a(interfaceC0778a);
            }
            return aVar;
        }
        e eVar = new e(aVar, eVarA);
        eVar.a(interfaceC0778a);
        return eVar;
    }

    @Override // com.opos.mobad.template.c.d
    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, a.InterfaceC0778a interfaceC0778a, com.opos.mobad.d.a aVar2) {
        com.opos.mobad.template.a aVarH;
        if (i == 5) {
            aVarH = l.h(context, i, aVar2);
        } else if (i == 12) {
            aVarH = s.a(context, i, aVar.a(context), aVar2);
        } else if (i == 13) {
            aVarH = q.a(context, i, aVar.a(context), aVar2);
        } else if (i == 14) {
            aVarH = s.b(context, i, aVar.a(context), aVar2);
        } else if (i == 15) {
            aVarH = q.b(context, i, aVar.a(context), aVar2);
        } else if (i == 48) {
            aVarH = l.d(context, i, aVar2);
        } else if (i == 2071) {
            aVarH = com.opos.mobad.template.f.f.a(context, i, aVar2);
        } else if (i == 2082) {
            aVarH = com.opos.mobad.template.h.x.e(context, i, aVar.a(context), aVar2);
        } else if (i == 2102) {
            aVarH = com.opos.mobad.template.h.x.j(context, i, aVar.a(context), aVar2);
        } else if (i == 7) {
            aVarH = l.f(context, i, aVar2);
        } else if (i == 8) {
            aVarH = l.e(context, i, aVar2);
        } else if (i == 9) {
            aVarH = l.g(context, i, aVar2);
        } else if (i == 27) {
            aVarH = af.a(context, i, aVar.a(context), aVar2);
        } else if (i == 28) {
            aVarH = af.b(context, i, aVar.a(context), aVar2);
        } else if (i == 2114) {
            aVarH = com.opos.mobad.template.h.c.a(context, i, aVar.a(context), aVar2);
        } else if (i == 2115) {
            aVarH = com.opos.mobad.template.h.c.b(context, i, aVar.a(context), aVar2);
        } else if (i == 2154) {
            aVarH = t.b(context, i, aVar2);
        } else if (i == 2155) {
            aVarH = t.a(context, i, aVar2);
        } else if (i == 2158) {
            aVarH = aa.a(context, i, aVar2);
        } else if (i != 2159) {
            switch (i) {
                case 50:
                    aVarH = l.b(context, i, aVar2);
                    break;
                case 51:
                    aVarH = l.a(context, i, aVar2);
                    break;
                case 52:
                    aVarH = l.c(context, i, aVar2);
                    break;
                default:
                    switch (i) {
                        case 2007:
                            aVarH = com.opos.mobad.template.f.j.a(context, 2007, aVar2);
                            break;
                        case 2008:
                            aVarH = com.opos.mobad.template.f.j.b(context, 2008, aVar2);
                            break;
                        case 2009:
                            aVarH = com.opos.mobad.template.f.g.a(context, 2009, aVar2);
                            break;
                        case 2010:
                            aVarH = com.opos.mobad.template.f.g.b(context, 2010, aVar2);
                            break;
                        default:
                            switch (i) {
                                case 2028:
                                    aVarH = com.opos.mobad.template.h.x.a(context, i, aVar.a(context), aVar2);
                                    break;
                                case 2029:
                                    aVarH = com.opos.mobad.template.h.x.c(context, i, aVar.a(context), aVar2);
                                    break;
                                case 2030:
                                    aVarH = com.opos.mobad.template.h.x.b(context, i, aVar.a(context), aVar2);
                                    break;
                                case 2031:
                                    aVarH = com.opos.mobad.template.h.x.d(context, i, aVar.a(context), aVar2);
                                    break;
                                default:
                                    switch (i) {
                                        case 2084:
                                            aVarH = com.opos.mobad.template.h.x.f(context, i, aVar.a(context), aVar2);
                                            break;
                                        case 2085:
                                            aVarH = com.opos.mobad.template.h.x.g(context, i, aVar.a(context), aVar2);
                                            break;
                                        case 2086:
                                            aVarH = com.opos.mobad.template.h.x.h(context, i, aVar.a(context), aVar2);
                                            break;
                                        case 2087:
                                            aVarH = com.opos.mobad.template.h.x.i(context, i, aVar.a(context), aVar2);
                                            break;
                                        default:
                                            aVarH = null;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            aVarH = aa.b(context, i, aVar2);
        }
        com.opos.mobad.template.a aVar3 = aVarH;
        return aVar3 != null ? a(context, i, interfaceC0778a, aVar3, aVar2) : aVar3;
    }
}
