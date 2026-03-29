package com.zx.a.I8b7;

import com.zx.a.I8b7.n0;
import com.zx.a.I8b7.q1;
import com.zx.a.I8b7.t1;
import com.zx.a.I8b7.u1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class s0 implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r0 f16858a;

    public s0(r0 r0Var, int i) {
        this.f16858a = r0Var;
    }

    @Override // com.zx.a.I8b7.n0
    public t1 a(n0.a aVar) throws IOException {
        j1 j1Var = (j1) aVar;
        q1 q1Var = j1Var.c;
        q1.a aVar2 = new q1.a(q1Var);
        StringBuilder sb = new StringBuilder();
        sb.append(q1Var.b + " " + q1Var.f16847a.toString() + " " + q1Var.e + "\n");
        s1 s1Var = q1Var.d;
        if (s1Var != null && ((r1) s1Var).f16853a.a() != null) {
            if (((r1) q1Var.d).b > 2147483647L) {
                StringBuilder sbA = f3.a("request body content length: ");
                sbA.append(((r1) q1Var.d).b);
                sbA.append("\n");
                sb.append(sbA.toString());
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                r1 r1Var = (r1) q1Var.d;
                byteArrayOutputStream.write(r1Var.c, r1Var.d, r1Var.b);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                sb.append(new String(byteArray, StandardCharsets.UTF_8) + "\n");
                aVar2.d = s1.a(((r1) q1Var.d).f16853a, byteArray);
            }
        }
        this.f16858a.a(sb.toString());
        t1 t1VarA = j1Var.a(new q1(aVar2), j1Var.d);
        t1.a aVar3 = new t1.a(t1VarA);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(t1VarA.b + " " + t1VarA.c + " " + q1Var.f16847a.toString() + " " + q1Var.e + "\n");
        u1 u1Var = t1VarA.e;
        if (u1Var != null && ((u1.a) u1Var).f16869a.a() != null) {
            u1 u1Var2 = t1VarA.e;
            if (((u1.a) u1Var2).b > 2147483647L) {
                StringBuilder sbA2 = f3.a("response body content length: ");
                sbA2.append(((u1.a) t1VarA.e).b);
                sbA2.append("\n");
                sb2.append(sbA2.toString());
            } else {
                byte[] bArrA = u1Var2.a();
                sb2.append("response body size: ");
                sb2.append(bArrA.length);
                sb2.append(", ");
                sb2.append(new String(bArrA, StandardCharsets.UTF_8) + "\n");
                aVar3.e = u1.a(((u1.a) t1VarA.e).f16869a, (long) bArrA.length, new ByteArrayInputStream(bArrA));
            }
        }
        this.f16858a.a(sb2.toString());
        return aVar3.a();
    }
}
