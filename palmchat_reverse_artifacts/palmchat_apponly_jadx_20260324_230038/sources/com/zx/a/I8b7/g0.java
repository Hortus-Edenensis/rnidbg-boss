package com.zx.a.I8b7;

import com.zx.a.I8b7.n0;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class g0 implements n0 {
    @Override // com.zx.a.I8b7.n0
    public t1 a(n0.a aVar) throws IOException {
        if (!w3.a(m3.f16830a, true)) {
            throw new IllegalStateException("network is not available");
        }
        j1 j1Var = (j1) aVar;
        return j1Var.a(j1Var.c, j1Var.d);
    }
}
