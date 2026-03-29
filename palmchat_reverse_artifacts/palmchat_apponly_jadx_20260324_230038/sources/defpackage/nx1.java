package defpackage;

import androidx.annotation.Nullable;
import defpackage.dl5;
import defpackage.px1;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class nx1 extends dl5 {

    @Nullable
    public px1 n;

    @Nullable
    public a o;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements k64 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public px1 f19636a;
        public px1.a b;
        public long c = -1;
        public long d = -1;

        public a(px1 px1Var, px1.a aVar) {
            this.f19636a = px1Var;
            this.b = aVar;
        }

        @Override // defpackage.k64
        public long a(ps1 ps1Var) {
            long j = this.d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.d = -1L;
            return j2;
        }

        public void b(long j) {
            this.c = j;
        }

        @Override // defpackage.k64
        public v45 createSeekMap() {
            vh.g(this.c != -1);
            return new ox1(this.f19636a, this.c);
        }

        @Override // defpackage.k64
        public void startSeek(long j) {
            long[] jArr = this.b.f20126a;
            this.d = jArr[g86.i(jArr, j, true, true)];
        }
    }

    public static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(gc4 gc4Var) {
        return gc4Var.a() >= 5 && gc4Var.H() == 127 && gc4Var.J() == 1179402563;
    }

    @Override // defpackage.dl5
    public long f(gc4 gc4Var) {
        if (o(gc4Var.e())) {
            return n(gc4Var);
        }
        return -1L;
    }

    @Override // defpackage.dl5
    public boolean i(gc4 gc4Var, long j, dl5.b bVar) {
        byte[] bArrE = gc4Var.e();
        px1 px1Var = this.n;
        if (px1Var == null) {
            px1 px1Var2 = new px1(bArrE, 17);
            this.n = px1Var2;
            bVar.f17072a = px1Var2.g(Arrays.copyOfRange(bArrE, 9, gc4Var.g()), null);
            return true;
        }
        if ((bArrE[0] & ByteCompanionObject.MAX_VALUE) == 3) {
            px1.a aVarG = mx1.g(gc4Var);
            px1 px1VarB = px1Var.b(aVarG);
            this.n = px1VarB;
            this.o = new a(px1VarB, aVarG);
            return true;
        }
        if (!o(bArrE)) {
            return true;
        }
        a aVar = this.o;
        if (aVar != null) {
            aVar.b(j);
            bVar.b = this.o;
        }
        vh.e(bVar.f17072a);
        return false;
    }

    @Override // defpackage.dl5
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }

    public final int n(gc4 gc4Var) {
        int i = (gc4Var.e()[2] & UByte.MAX_VALUE) >> 4;
        if (i == 6 || i == 7) {
            gc4Var.V(4);
            gc4Var.O();
        }
        int iJ = lx1.j(gc4Var, i);
        gc4Var.U(0);
        return iJ;
    }
}
