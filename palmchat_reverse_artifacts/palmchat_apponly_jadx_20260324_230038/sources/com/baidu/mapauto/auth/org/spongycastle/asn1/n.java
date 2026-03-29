package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class n extends r implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f3889a;

    public n(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("string cannot be null");
        }
        this.f3889a = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.o
    public final InputStream b() {
        return new ByteArrayInputStream(this.f3889a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        return new v0(this.f3889a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        return new v0(this.f3889a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(i());
    }

    public byte[] i() {
        return this.f3889a;
    }

    public final String toString() {
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("#");
        byte[] bArr = this.f3889a;
        com.baidu.mapauto.auth.org.spongycastle.util.encoders.e eVar = com.baidu.mapauto.auth.org.spongycastle.util.encoders.d.f3921a;
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            eVar.getClass();
            for (int i = 0; i < 0 + length; i++) {
                int i2 = bArr[i] & UByte.MAX_VALUE;
                byteArrayOutputStream.write(eVar.f3922a[i2 >>> 4]);
                byteArrayOutputStream.write(eVar.f3922a[i2 & 15]);
            }
            sbA.append(com.baidu.mapauto.auth.org.spongycastle.util.d.a(byteArrayOutputStream.toByteArray()));
            return sbA.toString();
        } catch (Exception e) {
            StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("exception encoding Hex string: ");
            sbA2.append(e.getMessage());
            throw new com.baidu.mapauto.auth.org.spongycastle.util.encoders.c(sbA2.toString(), e);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof n) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f3889a, ((n) rVar).f3889a);
        }
        return false;
    }
}
