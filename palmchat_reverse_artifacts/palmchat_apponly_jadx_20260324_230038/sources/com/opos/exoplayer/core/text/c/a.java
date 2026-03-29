package com.opos.exoplayer.core.text.c;

import android.graphics.Bitmap;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.opos.exoplayer.core.text.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f8336a;
    private final C0702a b;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.text.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0702a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p f8337a = new p();
        private final int[] b = new int[256];
        private boolean c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;

        public Cue a() {
            int iG;
            if (this.d == 0 || this.e == 0 || this.h == 0 || this.i == 0 || this.f8337a.c() == 0 || this.f8337a.d() != this.f8337a.c() || !this.c) {
                return null;
            }
            this.f8337a.c(0);
            int i = this.h * this.i;
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int iG2 = this.f8337a.g();
                if (iG2 != 0) {
                    iG = i2 + 1;
                    iArr[i2] = this.b[iG2];
                } else {
                    int iG3 = this.f8337a.g();
                    if (iG3 != 0) {
                        iG = ((iG3 & 64) == 0 ? iG3 & 63 : ((iG3 & 63) << 8) | this.f8337a.g()) + i2;
                        Arrays.fill(iArr, i2, iG, (iG3 & 128) == 0 ? 0 : this.b[this.f8337a.g()]);
                    }
                }
                i2 = iG;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.h, this.i, Bitmap.Config.ARGB_8888);
            float f = this.f;
            float f2 = this.d;
            float f3 = f / f2;
            float f4 = this.g;
            float f5 = this.e;
            return new Cue(bitmapCreateBitmap, f3, 0, f4 / f5, 0, this.h / f2, this.i / f5);
        }

        public void b() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.f8337a.a(0);
            this.c = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(p pVar, int i) {
            if (i < 19) {
                return;
            }
            this.d = pVar.h();
            this.e = pVar.h();
            pVar.d(11);
            this.f = pVar.h();
            this.g = pVar.h();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p pVar, int i) {
            if (i % 5 != 2) {
                return;
            }
            pVar.d(2);
            Arrays.fill(this.b, 0);
            int i2 = i / 5;
            for (int i3 = 0; i3 < i2; i3++) {
                int iG = pVar.g();
                int iG2 = pVar.g();
                int iG3 = pVar.g();
                int iG4 = pVar.g();
                double d = iG2;
                double d2 = iG3 - 128;
                double d3 = iG4 - 128;
                this.b[iG] = (y.a((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255) << 8) | (pVar.g() << 24) | (y.a((int) ((1.402d * d2) + d), 0, 255) << 16) | y.a((int) (d + (d3 * 1.772d)), 0, 255);
            }
            this.c = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(p pVar, int i) {
            int iK;
            if (i < 4) {
                return;
            }
            pVar.d(3);
            int i2 = i - 4;
            if ((pVar.g() & 128) != 0) {
                if (i2 < 7 || (iK = pVar.k()) < 4) {
                    return;
                }
                this.h = pVar.h();
                this.i = pVar.h();
                this.f8337a.a(iK - 4);
                i2 -= 7;
            }
            int iD = this.f8337a.d();
            int iC = this.f8337a.c();
            if (iD >= iC || i2 <= 0) {
                return;
            }
            int iMin = Math.min(i2, iC - iD);
            pVar.a(this.f8337a.f8400a, iD, iMin);
            this.f8337a.c(iD + iMin);
        }
    }

    public a() {
        super("PgsDecoder");
        this.f8336a = new p();
        this.b = new C0702a();
    }

    private static Cue a(p pVar, C0702a c0702a) {
        int iC = pVar.c();
        int iG = pVar.g();
        int iH = pVar.h();
        int iD = pVar.d() + iH;
        Cue cueA = null;
        if (iD > iC) {
            pVar.c(iC);
            return null;
        }
        if (iG != 128) {
            switch (iG) {
                case 20:
                    c0702a.a(pVar, iH);
                    break;
                case 21:
                    c0702a.b(pVar, iH);
                    break;
                case 22:
                    c0702a.c(pVar, iH);
                    break;
            }
        } else {
            cueA = c0702a.a();
            c0702a.b();
        }
        pVar.c(iD);
        return cueA;
    }

    @Override // com.opos.exoplayer.core.text.a
    public com.opos.exoplayer.core.text.b a(byte[] bArr, int i, boolean z) {
        this.f8336a.a(bArr, i);
        this.b.b();
        ArrayList arrayList = new ArrayList();
        while (this.f8336a.b() >= 3) {
            Cue cueA = a(this.f8336a, this.b);
            if (cueA != null) {
                arrayList.add(cueA);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
