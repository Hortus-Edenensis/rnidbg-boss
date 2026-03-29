package com.opos.exoplayer.core.extractor.b;

import com.opos.exoplayer.core.util.p;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f8168a = new f();
    private final p b = new p(new byte[65025], 0);
    private int c = -1;
    private int d;
    private boolean e;

    private int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            f fVar = this.f8168a;
            if (i5 >= fVar.d) {
                break;
            }
            int[] iArr = fVar.g;
            this.d = i4 + 1;
            i2 = iArr[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public f b() {
        return this.f8168a;
    }

    public p c() {
        return this.b;
    }

    public void d() {
        p pVar = this.b;
        byte[] bArr = pVar.f8400a;
        if (bArr.length == 65025) {
            return;
        }
        pVar.f8400a = Arrays.copyOf(bArr, Math.max(65025, pVar.c()));
    }

    public void a() {
        this.f8168a.a();
        this.b.a();
        this.c = -1;
        this.e = false;
    }

    public boolean a(com.opos.exoplayer.core.extractor.f fVar) {
        int i;
        com.opos.exoplayer.core.util.a.b(fVar != null);
        if (this.e) {
            this.e = false;
            this.b.a();
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.f8168a.a(fVar, true)) {
                    return false;
                }
                f fVar2 = this.f8168a;
                int iA = fVar2.e;
                if ((fVar2.b & 1) == 1 && this.b.c() == 0) {
                    iA += a(0);
                    i = this.d + 0;
                } else {
                    i = 0;
                }
                fVar.b(iA);
                this.c = i;
            }
            int iA2 = a(this.c);
            int i2 = this.c + this.d;
            if (iA2 > 0) {
                if (this.b.e() < this.b.c() + iA2) {
                    p pVar = this.b;
                    pVar.f8400a = Arrays.copyOf(pVar.f8400a, pVar.c() + iA2);
                }
                p pVar2 = this.b;
                fVar.b(pVar2.f8400a, pVar2.c(), iA2);
                p pVar3 = this.b;
                pVar3.b(pVar3.c() + iA2);
                this.e = this.f8168a.g[i2 + (-1)] != 255;
            }
            if (i2 == this.f8168a.d) {
                i2 = -1;
            }
            this.c = i2;
        }
        return true;
    }
}
