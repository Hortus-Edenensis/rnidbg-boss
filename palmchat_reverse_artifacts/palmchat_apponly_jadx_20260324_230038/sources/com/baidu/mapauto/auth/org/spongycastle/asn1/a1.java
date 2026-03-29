package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class a1 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f3865a;

    public a1(v vVar) {
        this.f3865a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new z0(this.f3865a.b());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
