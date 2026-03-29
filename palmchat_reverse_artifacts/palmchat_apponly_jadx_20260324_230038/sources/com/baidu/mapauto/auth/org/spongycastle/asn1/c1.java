package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class c1 implements d, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f3870a;

    public c1(v vVar) {
        this.f3870a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new b1(this.f3870a.b());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e) {
            throw new q(e.getMessage(), e);
        }
    }
}
