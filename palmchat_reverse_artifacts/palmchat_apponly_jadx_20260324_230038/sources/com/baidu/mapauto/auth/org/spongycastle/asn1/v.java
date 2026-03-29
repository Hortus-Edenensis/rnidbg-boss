package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f3906a;
    public final int b;
    public final byte[][] c = new byte[11][];

    public v(int i, t1 t1Var) {
        this.f3906a = t1Var;
        this.b = i;
    }

    public final d a() throws IOException {
        int i = this.f3906a.read();
        if (i == -1) {
            return null;
        }
        InputStream inputStream = this.f3906a;
        if (inputStream instanceof q1) {
            q1 q1Var = (q1) inputStream;
            q1Var.f = false;
            q1Var.c();
        }
        int iB = i.b(i, this.f3906a);
        boolean z = (i & 32) != 0;
        int iA = i.a(this.b, this.f3906a);
        if (iA < 0) {
            if (!z) {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
            v vVar = new v(this.b, new q1(this.b, this.f3906a));
            if ((i & 64) != 0) {
                return new z(iB, vVar);
            }
            if ((i & 128) != 0) {
                return new i0(true, iB, vVar);
            }
            if (iB == 4) {
                return new c0(vVar);
            }
            if (iB == 8) {
                return new o0(vVar);
            }
            if (iB == 16) {
                return new e0(vVar);
            }
            if (iB == 17) {
                return new g0(vVar);
            }
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("unknown BER object encountered: 0x");
            sbA.append(Integer.toHexString(iB));
            throw new g(sbA.toString());
        }
        o1 o1Var = new o1(iA, this.f3906a);
        if ((i & 64) != 0) {
            return new k0(z, iB, o1Var.c());
        }
        if ((i & 128) != 0) {
            return new i0(z, iB, new v(u1.a(o1Var), o1Var));
        }
        if (!z) {
            if (iB == 4) {
                return new w0(o1Var);
            }
            try {
                return i.a(iB, o1Var, this.c);
            } catch (IllegalArgumentException e) {
                throw new g("corrupted stream detected", e);
            }
        }
        if (iB == 4) {
            return new c0(new v(u1.a(o1Var), o1Var));
        }
        if (iB == 8) {
            return new o0(new v(u1.a(o1Var), o1Var));
        }
        if (iB == 16) {
            return new a1(new v(u1.a(o1Var), o1Var));
        }
        if (iB == 17) {
            return new c1(new v(u1.a(o1Var), o1Var));
        }
        throw new IOException("unknown tag " + iB + " encountered");
    }

    public final e b() throws IOException {
        e eVar = new e();
        while (true) {
            d dVarA = a();
            if (dVarA == null) {
                return eVar;
            }
            eVar.f3872a.addElement(dVarA instanceof p1 ? ((p1) dVarA).a() : dVarA.c());
        }
    }

    public final w a(boolean z, int i) throws IOException {
        if (!z) {
            return new e1(false, i, new v0(((o1) this.f3906a).c()));
        }
        e eVarB = b();
        if (this.f3906a instanceof q1) {
            if (eVarB.f3872a.size() == 1) {
                return new h0(true, i, eVarB.a(0));
            }
            d0 d0Var = a0.f3864a;
            if (eVarB.f3872a.size() >= 1) {
                d0Var = new d0(eVarB);
            }
            return new h0(false, i, d0Var);
        }
        if (eVarB.f3872a.size() == 1) {
            return new e1(true, i, eVarB.a(0));
        }
        d l1Var = p0.f3893a;
        if (eVarB.f3872a.size() >= 1) {
            l1Var = new l1(eVarB);
        }
        return new e1(false, i, l1Var);
    }
}
