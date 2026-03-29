package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import defpackage.pr0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class th4 extends md5 {
    public final gc4 o;
    public final gc4 p;
    public final a q;

    @Nullable
    public Inflater r;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gc4 f20987a = new gc4();
        public final int[] b = new int[256];
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        @Nullable
        public pr0 d() {
            int iH;
            if (this.d == 0 || this.e == 0 || this.h == 0 || this.i == 0 || this.f20987a.g() == 0 || this.f20987a.f() != this.f20987a.g() || !this.c) {
                return null;
            }
            this.f20987a.U(0);
            int i = this.h * this.i;
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int iH2 = this.f20987a.H();
                if (iH2 != 0) {
                    iH = i2 + 1;
                    iArr[i2] = this.b[iH2];
                } else {
                    int iH3 = this.f20987a.H();
                    if (iH3 != 0) {
                        iH = ((iH3 & 64) == 0 ? iH3 & 63 : ((iH3 & 63) << 8) | this.f20987a.H()) + i2;
                        Arrays.fill(iArr, i2, iH, (iH3 & 128) == 0 ? 0 : this.b[this.f20987a.H()]);
                    }
                }
                i2 = iH;
            }
            return new pr0.b().f(Bitmap.createBitmap(iArr, this.h, this.i, Bitmap.Config.ARGB_8888)).k(this.f / this.d).l(0).h(this.g / this.e, 0).i(0).n(this.h / this.d).g(this.i / this.e).a();
        }

        public final void e(gc4 gc4Var, int i) {
            int iK;
            if (i < 4) {
                return;
            }
            gc4Var.V(3);
            int i2 = i - 4;
            if ((gc4Var.H() & 128) != 0) {
                if (i2 < 7 || (iK = gc4Var.K()) < 4) {
                    return;
                }
                this.h = gc4Var.N();
                this.i = gc4Var.N();
                this.f20987a.Q(iK - 4);
                i2 -= 7;
            }
            int iF = this.f20987a.f();
            int iG = this.f20987a.g();
            if (iF >= iG || i2 <= 0) {
                return;
            }
            int iMin = Math.min(i2, iG - iF);
            gc4Var.l(this.f20987a.e(), iF, iMin);
            this.f20987a.U(iF + iMin);
        }

        public final void f(gc4 gc4Var, int i) {
            if (i < 19) {
                return;
            }
            this.d = gc4Var.N();
            this.e = gc4Var.N();
            gc4Var.V(11);
            this.f = gc4Var.N();
            this.g = gc4Var.N();
        }

        public final void g(gc4 gc4Var, int i) {
            if (i % 5 != 2) {
                return;
            }
            gc4Var.V(2);
            Arrays.fill(this.b, 0);
            int i2 = i / 5;
            for (int i3 = 0; i3 < i2; i3++) {
                int iH = gc4Var.H();
                int iH2 = gc4Var.H();
                int iH3 = gc4Var.H();
                int iH4 = gc4Var.H();
                double d = iH2;
                double d2 = iH3 - 128;
                double d3 = iH4 - 128;
                this.b[iH] = (g86.q((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255) << 8) | (gc4Var.H() << 24) | (g86.q((int) ((1.402d * d2) + d), 0, 255) << 16) | g86.q((int) (d + (d3 * 1.772d)), 0, 255);
            }
            this.c = true;
        }

        public void h() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.f20987a.Q(0);
            this.c = false;
        }
    }

    public th4() {
        super("PgsDecoder");
        this.o = new gc4();
        this.p = new gc4();
        this.q = new a();
    }

    @Nullable
    public static pr0 y(gc4 gc4Var, a aVar) {
        int iG = gc4Var.g();
        int iH = gc4Var.H();
        int iN = gc4Var.N();
        int iF = gc4Var.f() + iN;
        pr0 pr0VarD = null;
        if (iF > iG) {
            gc4Var.U(iG);
            return null;
        }
        if (iH != 128) {
            switch (iH) {
                case 20:
                    aVar.g(gc4Var, iN);
                    break;
                case 21:
                    aVar.e(gc4Var, iN);
                    break;
                case 22:
                    aVar.f(gc4Var, iN);
                    break;
            }
        } else {
            pr0VarD = aVar.d();
            aVar.h();
        }
        gc4Var.U(iF);
        return pr0VarD;
    }

    @Override // defpackage.md5
    public dn5 v(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.o.S(bArr, i);
        x(this.o);
        this.q.h();
        ArrayList arrayList = new ArrayList();
        while (this.o.a() >= 3) {
            pr0 pr0VarY = y(this.o, this.q);
            if (pr0VarY != null) {
                arrayList.add(pr0VarY);
            }
        }
        return new uh4(Collections.unmodifiableList(arrayList));
    }

    public final void x(gc4 gc4Var) {
        if (gc4Var.a() <= 0 || gc4Var.j() != 120) {
            return;
        }
        if (this.r == null) {
            this.r = new Inflater();
        }
        if (g86.v0(gc4Var, this.p, this.r)) {
            gc4Var.S(this.p.e(), this.p.g());
        }
    }
}
