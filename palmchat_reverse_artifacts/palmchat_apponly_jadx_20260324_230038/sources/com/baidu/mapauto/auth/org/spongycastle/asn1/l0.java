package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class l0 extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f3886a;

    public l0(char[] cArr) {
        this.f3886a = cArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(30);
        pVar.b(this.f3886a.length * 2);
        int i = 0;
        while (true) {
            char[] cArr = this.f3886a;
            if (i == cArr.length) {
                return;
            }
            char c = cArr[i];
            pVar.a((byte) (c >> '\b'));
            pVar.a((byte) c);
            i++;
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return (this.f3886a.length * 2) + u1.a(this.f3886a.length * 2) + 1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        char[] cArr = this.f3886a;
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ cArr[length];
        }
    }

    public final String toString() {
        return new String(this.f3886a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof l0)) {
            return false;
        }
        char[] cArr = this.f3886a;
        char[] cArr2 = ((l0) rVar).f3886a;
        if (cArr != cArr2) {
            if (cArr == null || cArr2 == null || cArr.length != cArr2.length) {
                return false;
            }
            for (int i = 0; i != cArr.length; i++) {
                if (cArr[i] != cArr2[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
