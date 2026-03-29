package defpackage;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import com.google.common.collect.ImmutableList;
import defpackage.dl5;
import defpackage.wh6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class vh6 extends dl5 {

    @Nullable
    public a n;
    public int o;
    public boolean p;

    @Nullable
    public wh6.c q;

    @Nullable
    public wh6.a r;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wh6.c f21447a;
        public final wh6.a b;
        public final byte[] c;
        public final wh6.b[] d;
        public final int e;

        public a(wh6.c cVar, wh6.a aVar, byte[] bArr, wh6.b[] bVarArr, int i) {
            this.f21447a = cVar;
            this.b = aVar;
            this.c = bArr;
            this.d = bVarArr;
            this.e = i;
        }
    }

    @VisibleForTesting
    public static void n(gc4 gc4Var, long j) {
        if (gc4Var.b() < gc4Var.g() + 4) {
            gc4Var.R(Arrays.copyOf(gc4Var.e(), gc4Var.g() + 4));
        } else {
            gc4Var.T(gc4Var.g() + 4);
        }
        byte[] bArrE = gc4Var.e();
        bArrE[gc4Var.g() - 4] = (byte) (j & 255);
        bArrE[gc4Var.g() - 3] = (byte) ((j >>> 8) & 255);
        bArrE[gc4Var.g() - 2] = (byte) ((j >>> 16) & 255);
        bArrE[gc4Var.g() - 1] = (byte) ((j >>> 24) & 255);
    }

    public static int o(byte b, a aVar) {
        return !aVar.d[p(b, aVar.e, 1)].f21708a ? aVar.f21447a.g : aVar.f21447a.h;
    }

    @VisibleForTesting
    public static int p(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    public static boolean r(gc4 gc4Var) {
        try {
            return wh6.m(1, gc4Var, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // defpackage.dl5
    public void e(long j) {
        super.e(j);
        this.p = j != 0;
        wh6.c cVar = this.q;
        this.o = cVar != null ? cVar.g : 0;
    }

    @Override // defpackage.dl5
    public long f(gc4 gc4Var) {
        if ((gc4Var.e()[0] & 1) == 1) {
            return -1L;
        }
        int iO = o(gc4Var.e()[0], (a) vh.i(this.n));
        long j = this.p ? (this.o + iO) / 4 : 0;
        n(gc4Var, j);
        this.p = true;
        this.o = iO;
        return j;
    }

    @Override // defpackage.dl5
    public boolean i(gc4 gc4Var, long j, dl5.b bVar) throws IOException {
        if (this.n != null) {
            vh.e(bVar.f17072a);
            return false;
        }
        a aVarQ = q(gc4Var);
        this.n = aVarQ;
        if (aVarQ == null) {
            return true;
        }
        wh6.c cVar = aVarQ.f21447a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar.j);
        arrayList.add(aVarQ.c);
        bVar.f17072a = new m.b().g0("audio/vorbis").I(cVar.e).b0(cVar.d).J(cVar.b).h0(cVar.c).V(arrayList).Z(wh6.c(ImmutableList.copyOf(aVarQ.b.b))).G();
        return true;
    }

    @Override // defpackage.dl5
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    @Nullable
    @VisibleForTesting
    public a q(gc4 gc4Var) throws IOException {
        wh6.c cVar = this.q;
        if (cVar == null) {
            this.q = wh6.j(gc4Var);
            return null;
        }
        wh6.a aVar = this.r;
        if (aVar == null) {
            this.r = wh6.h(gc4Var);
            return null;
        }
        byte[] bArr = new byte[gc4Var.g()];
        System.arraycopy(gc4Var.e(), 0, bArr, 0, gc4Var.g());
        return new a(cVar, aVar, bArr, wh6.k(gc4Var, cVar.b), wh6.a(r4.length - 1));
    }
}
