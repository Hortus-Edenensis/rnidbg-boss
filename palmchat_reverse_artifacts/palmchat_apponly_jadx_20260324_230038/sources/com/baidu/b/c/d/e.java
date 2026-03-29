package com.baidu.b.c.d;

import java.math.BigInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f3333a;
    private BigInteger b;

    public e(byte[] bArr, byte[] bArr2) {
        this.f3333a = new BigInteger(bArr);
        this.b = new BigInteger(bArr2);
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger a() {
        return this.f3333a;
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger b() {
        return this.b;
    }
}
