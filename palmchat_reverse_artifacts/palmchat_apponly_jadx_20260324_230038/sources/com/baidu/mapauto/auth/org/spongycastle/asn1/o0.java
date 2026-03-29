package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class o0 implements d, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f3891a;

    public o0(v vVar) {
        this.f3891a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        try {
            return new n0(this.f3891a.b());
        } catch (IllegalArgumentException e) {
            throw new g(e.getMessage(), e);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e) {
            throw new q("unable to get DER object", e);
        } catch (IllegalArgumentException e2) {
            throw new q("unable to get DER object", e2);
        }
    }
}
