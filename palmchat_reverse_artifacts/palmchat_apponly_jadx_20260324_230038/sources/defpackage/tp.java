package defpackage;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class tp extends su0 {
    public a g;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21030a;
        public int b;
        public int c;

        public a() {
        }

        public void a(rp rpVar, mk2 mk2Var) {
            float fMax = Math.max(0.0f, Math.min(1.0f, tp.this.b.h()));
            float lowestVisibleX = rpVar.getLowestVisibleX();
            float highestVisibleX = rpVar.getHighestVisibleX();
            T tC0 = mk2Var.C0(lowestVisibleX, Float.NaN, DataSet.Rounding.DOWN);
            T tC02 = mk2Var.C0(highestVisibleX, Float.NaN, DataSet.Rounding.UP);
            this.f21030a = tC0 == 0 ? 0 : mk2Var.b(tC0);
            this.b = tC02 != 0 ? mk2Var.b(tC02) : 0;
            this.c = (int) ((r2 - this.f21030a) * fMax);
        }
    }

    public tp(g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
        this.g = new a();
    }

    public boolean h(Entry entry, mk2 mk2Var) {
        return entry != null && ((float) mk2Var.b(entry)) < ((float) mk2Var.K0()) * this.b.h();
    }

    public boolean i(kl2 kl2Var) {
        return kl2Var.isVisible() && (kl2Var.h0() || kl2Var.B());
    }
}
