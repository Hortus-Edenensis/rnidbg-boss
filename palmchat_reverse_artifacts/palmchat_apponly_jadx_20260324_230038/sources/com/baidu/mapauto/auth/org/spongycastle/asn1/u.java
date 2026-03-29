package com.baidu.mapauto.auth.org.spongycastle.asn1;

import com.baidu.mapauto.auth.org.spongycastle.util.a;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u extends r implements Iterable<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f3903a = new Vector();
    public boolean b = false;

    public u() {
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof u)) {
            return false;
        }
        u uVar = (u) rVar;
        if (this.f3903a.size() != uVar.f3903a.size()) {
            return false;
        }
        Enumeration enumerationElements = this.f3903a.elements();
        Enumeration enumerationElements2 = uVar.f3903a.elements();
        while (enumerationElements.hasMoreElements()) {
            d dVar = (d) enumerationElements.nextElement();
            if (dVar == null) {
                dVar = t0.f3901a;
            }
            d dVar2 = (d) enumerationElements2.nextElement();
            if (dVar2 == null) {
                dVar2 = t0.f3901a;
            }
            r rVarC = dVar.c();
            r rVarC2 = dVar2.c();
            if (rVarC != rVarC2 && !rVarC.equals(rVarC2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() throws IOException {
        if (this.b) {
            b1 b1Var = new b1();
            b1Var.f3903a = this.f3903a;
            return b1Var;
        }
        Vector vector = new Vector();
        for (int i = 0; i != this.f3903a.size(); i++) {
            vector.addElement(this.f3903a.elementAt(i));
        }
        b1 b1Var2 = new b1();
        b1Var2.f3903a = vector;
        b1Var2.i();
        return b1Var2;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        m1 m1Var = new m1();
        m1Var.f3903a = this.f3903a;
        return m1Var;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        Enumeration enumerationElements = this.f3903a.elements();
        int size = this.f3903a.size();
        while (enumerationElements.hasMoreElements()) {
            Object obj = (d) enumerationElements.nextElement();
            if (obj == null) {
                obj = t0.f3901a;
            }
            size = (size * 17) ^ obj.hashCode();
        }
        return size;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i() throws java.io.IOException {
        /*
            r15 = this;
            java.lang.String r0 = "cannot encode object added to SET"
            java.lang.String r1 = "DER"
            boolean r2 = r15.b
            if (r2 != 0) goto L90
            r2 = 1
            r15.b = r2
            java.util.Vector r3 = r15.f3903a
            int r3 = r3.size()
            if (r3 <= r2) goto L90
            java.util.Vector r3 = r15.f3903a
            int r3 = r3.size()
            int r3 = r3 - r2
            r4 = 1
        L1b:
            if (r4 == 0) goto L90
            java.util.Vector r4 = r15.f3903a
            r5 = 0
            java.lang.Object r4 = r4.elementAt(r5)
            com.baidu.mapauto.auth.org.spongycastle.asn1.d r4 = (com.baidu.mapauto.auth.org.spongycastle.asn1.d) r4
            com.baidu.mapauto.auth.org.spongycastle.asn1.r r4 = r4.c()     // Catch: java.io.IOException -> L8a
            byte[] r4 = r4.a(r1)     // Catch: java.io.IOException -> L8a
            r7 = r4
            r4 = 0
            r6 = 0
            r8 = 0
        L32:
            if (r8 == r3) goto L87
            java.util.Vector r9 = r15.f3903a
            int r10 = r8 + 1
            java.lang.Object r9 = r9.elementAt(r10)
            com.baidu.mapauto.auth.org.spongycastle.asn1.d r9 = (com.baidu.mapauto.auth.org.spongycastle.asn1.d) r9
            com.baidu.mapauto.auth.org.spongycastle.asn1.r r9 = r9.c()     // Catch: java.io.IOException -> L81
            byte[] r9 = r9.a(r1)     // Catch: java.io.IOException -> L81
            int r11 = r7.length
            int r12 = r9.length
            int r11 = java.lang.Math.min(r11, r12)
            r12 = 0
        L4d:
            if (r12 == r11) goto L5f
            r13 = r7[r12]
            r14 = r9[r12]
            if (r13 == r14) goto L5c
            r11 = r13 & 255(0xff, float:3.57E-43)
            r12 = r14 & 255(0xff, float:3.57E-43)
            if (r11 >= r12) goto L64
            goto L62
        L5c:
            int r12 = r12 + 1
            goto L4d
        L5f:
            int r12 = r7.length
            if (r11 != r12) goto L64
        L62:
            r11 = 1
            goto L65
        L64:
            r11 = 0
        L65:
            if (r11 == 0) goto L69
            r7 = r9
            goto L7f
        L69:
            java.util.Vector r4 = r15.f3903a
            java.lang.Object r4 = r4.elementAt(r8)
            java.util.Vector r6 = r15.f3903a
            java.lang.Object r9 = r6.elementAt(r10)
            r6.setElementAt(r9, r8)
            java.util.Vector r6 = r15.f3903a
            r6.setElementAt(r4, r10)
            r4 = r8
            r6 = 1
        L7f:
            r8 = r10
            goto L32
        L81:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L87:
            r3 = r4
            r4 = r6
            goto L1b
        L8a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapauto.auth.org.spongycastle.asn1.u.i():void");
    }

    @Override // java.lang.Iterable
    public final Iterator<d> iterator() {
        d[] dVarArr = new d[this.f3903a.size()];
        for (int i = 0; i != this.f3903a.size(); i++) {
            dVarArr[i] = (d) this.f3903a.elementAt(i);
        }
        return new a.C0076a(dVarArr);
    }

    public final String toString() {
        return this.f3903a.toString();
    }

    public u(e eVar) {
        for (int i = 0; i != eVar.a(); i++) {
            this.f3903a.addElement(eVar.a(i));
        }
    }
}
