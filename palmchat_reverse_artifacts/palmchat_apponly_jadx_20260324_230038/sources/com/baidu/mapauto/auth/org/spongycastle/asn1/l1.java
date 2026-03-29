package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class l1 extends s {
    public int b;

    public l1() {
        this.b = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        p pVarB = pVar.b();
        if (this.b < 0) {
            Enumeration enumerationElements = this.f3899a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().h().e();
            }
            this.b = iE;
        }
        int i = this.b;
        pVar.a(48);
        pVar.b(i);
        Enumeration enumerationElements2 = this.f3899a.elements();
        while (enumerationElements2.hasMoreElements()) {
            pVarB.a((d) enumerationElements2.nextElement());
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        if (this.b < 0) {
            Enumeration enumerationElements = this.f3899a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().h().e();
            }
            this.b = iE;
        }
        int i = this.b;
        return u1.a(i) + 1 + i;
    }

    public l1(e eVar) {
        super(eVar);
        this.b = -1;
    }
}
