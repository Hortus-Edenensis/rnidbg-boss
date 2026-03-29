package defpackage;

import defpackage.s96;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class iu0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18262a;
    public final byte[] b;

    public iu0(int i, byte[] bArr) {
        this.f18262a = i;
        this.b = bArr;
    }

    public static iu0[] b(byte[] bArr, s96 s96Var) {
        s96.c cVarD = s96Var.d();
        s96.b[] bVarArrA = cVarD.a();
        int iA = 0;
        for (s96.b bVar : bVarArrA) {
            iA += bVar.a();
        }
        iu0[] iu0VarArr = new iu0[iA];
        int i = 0;
        for (s96.b bVar2 : bVarArrA) {
            int i2 = 0;
            while (i2 < bVar2.a()) {
                int iB = bVar2.b();
                iu0VarArr[i] = new iu0(iB, new byte[cVarD.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = iu0VarArr[0].b.length - cVarD.b();
        int i3 = length - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            while (i6 < i) {
                iu0VarArr[i6].b[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        boolean z = s96Var.i() == 24;
        int i7 = z ? 8 : i;
        int i8 = 0;
        while (i8 < i7) {
            iu0VarArr[i8].b[i3] = bArr[i4];
            i8++;
            i4++;
        }
        int length2 = iu0VarArr[0].b.length;
        while (length < length2) {
            int i9 = 0;
            while (i9 < i) {
                int i10 = z ? (i9 + 8) % i : i9;
                iu0VarArr[i10].b[(!z || i10 <= 7) ? length : length - 1] = bArr[i4];
                i9++;
                i4++;
            }
            length++;
        }
        if (i4 == bArr.length) {
            return iu0VarArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] a() {
        return this.b;
    }

    public int c() {
        return this.f18262a;
    }
}
