package defpackage;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.common.collect.ImmutableList;
import defpackage.j26;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ka1 implements j26.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18606a;
    public final List<m> b;

    public ka1(int i) {
        this(i, ImmutableList.of());
    }

    @Override // j26.c
    @Nullable
    public j26 a(int i, j26.b bVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new ph4(new zr3(bVar.b));
            }
            if (i == 21) {
                return new ph4(new fq2());
            }
            if (i == 27) {
                if (e(4)) {
                    return null;
                }
                return new ph4(new lf2(b(bVar), e(1), e(8)));
            }
            if (i == 36) {
                return new ph4(new mf2(b(bVar)));
            }
            if (i == 89) {
                return new ph4(new ui1(bVar.c));
            }
            if (i != 138) {
                if (i == 172) {
                    return new ph4(new m2(bVar.b));
                }
                if (i == 257) {
                    return new m45(new mc4("application/vnd.dvb.ait"));
                }
                if (i == 134) {
                    if (e(16)) {
                        return null;
                    }
                    return new m45(new mc4("application/x-scte35"));
                }
                if (i != 135) {
                    switch (i) {
                        case 15:
                            if (!e(2)) {
                                break;
                            }
                            break;
                        case 16:
                            break;
                        case 17:
                            if (!e(2)) {
                                break;
                            }
                            break;
                        default:
                            switch (i) {
                                case 130:
                                    if (!e(64)) {
                                    }
                                    break;
                            }
                            break;
                    }
                    return null;
                }
                return new ph4(new g2(bVar.b));
            }
            return new ph4(new li1(bVar.b));
        }
        return new ph4(new jf2(c(bVar)));
    }

    public final d55 b(j26.b bVar) {
        return new d55(d(bVar));
    }

    public final f66 c(j26.b bVar) {
        return new f66(d(bVar));
    }

    @Override // j26.c
    public SparseArray<j26> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    public final List<m> d(j26.b bVar) {
        String str;
        int i;
        if (e(32)) {
            return this.b;
        }
        gc4 gc4Var = new gc4(bVar.d);
        List<m> arrayList = this.b;
        while (gc4Var.a() > 0) {
            int iH = gc4Var.H();
            int iF = gc4Var.f() + gc4Var.H();
            if (iH == 134) {
                arrayList = new ArrayList<>();
                int iH2 = gc4Var.H() & 31;
                for (int i2 = 0; i2 < iH2; i2++) {
                    String strE = gc4Var.E(3);
                    int iH3 = gc4Var.H();
                    boolean z = (iH3 & 128) != 0;
                    if (z) {
                        i = iH3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bH = (byte) gc4Var.H();
                    gc4Var.V(1);
                    arrayList.add(new m.b().g0(str).X(strE).H(i).V(z ? ee0.b((bH & 64) != 0) : null).G());
                }
            }
            gc4Var.U(iF);
        }
        return arrayList;
    }

    public final boolean e(int i) {
        return (i & this.f18606a) != 0;
    }

    public ka1(int i, List<m> list) {
        this.f18606a = i;
        this.b = list;
    }
}
