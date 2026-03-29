package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3863a;
    public final int b;
    public final byte[] c;

    public a(boolean z, int i, byte[] bArr) {
        this.f3863a = z;
        this.b = i;
        this.c = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof a)) {
            return false;
        }
        a aVar = (a) rVar;
        return this.f3863a == aVar.f3863a && this.b == aVar.b && com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.c, aVar.c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        return u1.a(this.c.length) + u1.b(this.b) + this.c.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return this.f3863a;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        boolean z = this.f3863a;
        return ((z ? 1 : 0) ^ this.b) ^ com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public void a(p pVar) throws IOException {
        int i = this.f3863a ? 96 : 64;
        int i2 = this.b;
        byte[] bArr = this.c;
        pVar.a(i, i2);
        pVar.b(bArr.length);
        pVar.f3892a.write(bArr);
    }
}
