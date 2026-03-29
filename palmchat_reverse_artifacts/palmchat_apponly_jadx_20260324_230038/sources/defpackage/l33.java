package defpackage;

import androidx.annotation.Nullable;
import androidx.media3.extractor.avi.AviExtractor;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class l33 implements fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<fn> f18897a;
    public final int b;

    public l33(int i, ImmutableList<fn> immutableList) {
        this.b = i;
        this.f18897a = immutableList;
    }

    @Nullable
    public static fn a(int i, int i2, gc4 gc4Var) {
        switch (i) {
            case AviExtractor.FOURCC_strf /* 1718776947 */:
                return bl5.d(i2, gc4Var);
            case AviExtractor.FOURCC_avih /* 1751742049 */:
                return hn.b(gc4Var);
            case AviExtractor.FOURCC_strh /* 1752331379 */:
                return in.c(gc4Var);
            case AviExtractor.FOURCC_strn /* 1852994675 */:
                return cl5.a(gc4Var);
            default:
                return null;
        }
    }

    public static l33 c(int i, gc4 gc4Var) {
        ImmutableList.a aVar = new ImmutableList.a();
        int iG = gc4Var.g();
        int iB = -2;
        while (gc4Var.a() > 8) {
            int iU = gc4Var.u();
            int iF = gc4Var.f() + gc4Var.u();
            gc4Var.T(iF);
            fn fnVarC = iU == 1414744396 ? c(gc4Var.u(), gc4Var) : a(iU, iB, gc4Var);
            if (fnVarC != null) {
                if (fnVarC.getType() == 1752331379) {
                    iB = ((in) fnVarC).b();
                }
                aVar.a(fnVarC);
            }
            gc4Var.U(iF);
            gc4Var.T(iG);
        }
        return new l33(i, aVar.e());
    }

    @Nullable
    public <T extends fn> T b(Class<T> cls) {
        o46<fn> it = this.f18897a.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    @Override // defpackage.fn
    public int getType() {
        return this.b;
    }
}
