package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends r {
    public static final byte[] b = {-1};
    public static final byte[] c = {0};
    public static final c d = new c(false);
    public static final c e = new c(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3868a;

    @Deprecated
    public c(boolean z) {
        this.f3868a = z ? b : c;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f3868a, 1);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return 3;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return this.f3868a[0];
    }

    public final String toString() {
        return this.f3868a[0] != 0 ? "TRUE" : "FALSE";
    }

    public c(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        }
        byte b2 = bArr[0];
        if (b2 == 0) {
            this.f3868a = c;
        } else if ((b2 & UByte.MAX_VALUE) == 255) {
            this.f3868a = b;
        } else {
            this.f3868a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        return (rVar instanceof c) && this.f3868a[0] == ((c) rVar).f3868a[0];
    }
}
