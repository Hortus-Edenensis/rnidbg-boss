package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class j extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3884a;

    public j(BigInteger bigInteger) {
        this.f3884a = bigInteger.toByteArray();
    }

    public static boolean b(byte[] bArr) {
        if (bArr.length > 1) {
            byte b = bArr[0];
            if (b == 0 && (bArr[1] & ByteCompanionObject.MIN_VALUE) == 0) {
                return true;
            }
            if (b == -1 && (bArr[1] & ByteCompanionObject.MIN_VALUE) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f3884a, 2);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return u1.a(this.f3884a.length) + 1 + this.f3884a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f3884a;
            if (i == bArr.length) {
                return i2;
            }
            i2 ^= (bArr[i] & UByte.MAX_VALUE) << (i % 4);
            i++;
        }
    }

    public final BigInteger i() {
        return new BigInteger(1, this.f3884a);
    }

    public final String toString() {
        return new BigInteger(this.f3884a).toString();
    }

    public j(byte[] bArr) {
        if (!com.baidu.mapauto.auth.org.spongycastle.util.c.a() && b(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.f3884a = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof j) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f3884a, ((j) rVar).f3884a);
        }
        return false;
    }

    public static j a(Object obj) {
        if (obj == null || (obj instanceof j)) {
            return (j) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (j) r.a((byte[]) obj);
            } catch (Exception e) {
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("encoding error in getInstance: ");
                sbA.append(e.toString());
                throw new IllegalArgumentException(sbA.toString());
            }
        }
        StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("illegal object in getInstance: ");
        sbA2.append(obj.getClass().getName());
        throw new IllegalArgumentException(sbA2.toString());
    }
}
