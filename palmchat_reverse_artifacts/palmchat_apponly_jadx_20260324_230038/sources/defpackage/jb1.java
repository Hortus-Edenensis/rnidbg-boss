package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Formatter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class jb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vp f18369a;
    public final kb1[] b;
    public ou c;
    public final int d;

    public jb1(vp vpVar, ou ouVar) {
        this.f18369a = vpVar;
        int iA = vpVar.a();
        this.d = iA;
        this.c = ouVar;
        this.b = new kb1[iA + 2];
    }

    public static boolean b(fe0 fe0Var, fe0 fe0Var2) {
        if (fe0Var2 == null || !fe0Var2.g() || fe0Var2.a() != fe0Var.a()) {
            return false;
        }
        fe0Var.i(fe0Var2.c());
        return true;
    }

    public static int c(int i, int i2, fe0 fe0Var) {
        if (fe0Var == null || fe0Var.g()) {
            return i2;
        }
        if (!fe0Var.h(i)) {
            return i2 + 1;
        }
        fe0Var.i(i);
        return 0;
    }

    public final void a(kb1 kb1Var) {
        if (kb1Var != null) {
            ((lb1) kb1Var).g(this.f18369a);
        }
    }

    public final int d() {
        int iF = f();
        if (iF == 0) {
            return 0;
        }
        for (int i = 1; i < this.d + 1; i++) {
            fe0[] fe0VarArrD = this.b[i].d();
            for (int i2 = 0; i2 < fe0VarArrD.length; i2++) {
                fe0 fe0Var = fe0VarArrD[i2];
                if (fe0Var != null && !fe0Var.g()) {
                    e(i, i2, fe0VarArrD);
                }
            }
        }
        return iF;
    }

    public final void e(int i, int i2, fe0[] fe0VarArr) {
        fe0 fe0Var = fe0VarArr[i2];
        fe0[] fe0VarArrD = this.b[i - 1].d();
        kb1 kb1Var = this.b[i + 1];
        fe0[] fe0VarArrD2 = kb1Var != null ? kb1Var.d() : fe0VarArrD;
        fe0[] fe0VarArr2 = new fe0[14];
        fe0VarArr2[2] = fe0VarArrD[i2];
        fe0VarArr2[3] = fe0VarArrD2[i2];
        if (i2 > 0) {
            int i3 = i2 - 1;
            fe0VarArr2[0] = fe0VarArr[i3];
            fe0VarArr2[4] = fe0VarArrD[i3];
            fe0VarArr2[5] = fe0VarArrD2[i3];
        }
        if (i2 > 1) {
            int i4 = i2 - 2;
            fe0VarArr2[8] = fe0VarArr[i4];
            fe0VarArr2[10] = fe0VarArrD[i4];
            fe0VarArr2[11] = fe0VarArrD2[i4];
        }
        if (i2 < fe0VarArr.length - 1) {
            int i5 = i2 + 1;
            fe0VarArr2[1] = fe0VarArr[i5];
            fe0VarArr2[6] = fe0VarArrD[i5];
            fe0VarArr2[7] = fe0VarArrD2[i5];
        }
        if (i2 < fe0VarArr.length - 2) {
            int i6 = i2 + 2;
            fe0VarArr2[9] = fe0VarArr[i6];
            fe0VarArr2[12] = fe0VarArrD[i6];
            fe0VarArr2[13] = fe0VarArrD2[i6];
        }
        for (int i7 = 0; i7 < 14 && !b(fe0Var, fe0VarArr2[i7]); i7++) {
        }
    }

    public final int f() {
        g();
        return h() + i();
    }

    public final void g() {
        kb1[] kb1VarArr = this.b;
        kb1 kb1Var = kb1VarArr[0];
        if (kb1Var == null || kb1VarArr[this.d + 1] == null) {
            return;
        }
        fe0[] fe0VarArrD = kb1Var.d();
        fe0[] fe0VarArrD2 = this.b[this.d + 1].d();
        for (int i = 0; i < fe0VarArrD.length; i++) {
            fe0 fe0Var = fe0VarArrD[i];
            if (fe0Var != null && fe0VarArrD2[i] != null && fe0Var.c() == fe0VarArrD2[i].c()) {
                for (int i2 = 1; i2 <= this.d; i2++) {
                    fe0 fe0Var2 = this.b[i2].d()[i];
                    if (fe0Var2 != null) {
                        fe0Var2.i(fe0VarArrD[i].c());
                        if (!fe0Var2.g()) {
                            this.b[i2].d()[i] = null;
                        }
                    }
                }
            }
        }
    }

    public final int h() {
        kb1 kb1Var = this.b[0];
        if (kb1Var == null) {
            return 0;
        }
        fe0[] fe0VarArrD = kb1Var.d();
        int i = 0;
        for (int i2 = 0; i2 < fe0VarArrD.length; i2++) {
            fe0 fe0Var = fe0VarArrD[i2];
            if (fe0Var != null) {
                int iC = fe0Var.c();
                int iC2 = 0;
                for (int i3 = 1; i3 < this.d + 1 && iC2 < 2; i3++) {
                    fe0 fe0Var2 = this.b[i3].d()[i2];
                    if (fe0Var2 != null) {
                        iC2 = c(iC, iC2, fe0Var2);
                        if (!fe0Var2.g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    public final int i() {
        kb1[] kb1VarArr = this.b;
        int i = this.d;
        if (kb1VarArr[i + 1] == null) {
            return 0;
        }
        fe0[] fe0VarArrD = kb1VarArr[i + 1].d();
        int i2 = 0;
        for (int i3 = 0; i3 < fe0VarArrD.length; i3++) {
            fe0 fe0Var = fe0VarArrD[i3];
            if (fe0Var != null) {
                int iC = fe0Var.c();
                int iC2 = 0;
                for (int i4 = this.d + 1; i4 > 0 && iC2 < 2; i4--) {
                    fe0 fe0Var2 = this.b[i4].d()[i3];
                    if (fe0Var2 != null) {
                        iC2 = c(iC, iC2, fe0Var2);
                        if (!fe0Var2.g()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public int j() {
        return this.d;
    }

    public int k() {
        return this.f18369a.b();
    }

    public int l() {
        return this.f18369a.c();
    }

    public ou m() {
        return this.c;
    }

    public kb1 n(int i) {
        return this.b[i];
    }

    public kb1[] o() {
        a(this.b[0]);
        a(this.b[this.d + 1]);
        int i = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW;
        while (true) {
            int iD = d();
            if (iD <= 0 || iD >= i) {
                break;
            }
            i = iD;
        }
        return this.b;
    }

    public void p(ou ouVar) {
        this.c = ouVar;
    }

    public void q(int i, kb1 kb1Var) {
        this.b[i] = kb1Var;
    }

    public String toString() {
        kb1[] kb1VarArr = this.b;
        kb1 kb1Var = kb1VarArr[0];
        if (kb1Var == null) {
            kb1Var = kb1VarArr[this.d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < kb1Var.d().length; i++) {
            formatter.format("CW %3d:", Integer.valueOf(i));
            for (int i2 = 0; i2 < this.d + 2; i2++) {
                kb1 kb1Var2 = this.b[i2];
                if (kb1Var2 == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    fe0 fe0Var = kb1Var2.d()[i];
                    if (fe0Var == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", Integer.valueOf(fe0Var.c()), Integer.valueOf(fe0Var.e()));
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
