package defpackage;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class zh0 extends su0 {
    public List<su0> g;
    public WeakReference<Chart> h;
    public List<vh2> i;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22417a;

        static {
            int[] iArr = new int[CombinedChart.DrawOrder.values().length];
            f22417a = iArr;
            try {
                iArr[CombinedChart.DrawOrder.BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22417a[CombinedChart.DrawOrder.BUBBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22417a[CombinedChart.DrawOrder.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22417a[CombinedChart.DrawOrder.CANDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22417a[CombinedChart.DrawOrder.SCATTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public zh0(CombinedChart combinedChart, g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
        this.g = new ArrayList(5);
        this.i = new ArrayList();
        this.h = new WeakReference<>(combinedChart);
        h();
    }

    @Override // defpackage.su0
    public void b(Canvas canvas) {
        Iterator<su0> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().b(canvas);
        }
    }

    @Override // defpackage.su0
    public void c(Canvas canvas) {
        Iterator<su0> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().c(canvas);
        }
    }

    @Override // defpackage.su0
    public void d(Canvas canvas, vh2[] vh2VarArr) {
        Chart chart = this.h.get();
        if (chart == null) {
            return;
        }
        for (su0 su0Var : this.g) {
            Object barData = su0Var instanceof mp ? ((mp) su0Var).h.getBarData() : su0Var instanceof o23 ? ((o23) su0Var).i.getLineData() : su0Var instanceof jz ? ((jz) su0Var).i.getCandleData() : su0Var instanceof s25 ? ((s25) su0Var).i.getScatterData() : su0Var instanceof uu ? ((uu) su0Var).h.getBubbleData() : null;
            int iIndexOf = barData == null ? -1 : ((ai0) chart.getData()).u().indexOf(barData);
            this.i.clear();
            for (vh2 vh2Var : vh2VarArr) {
                if (vh2Var.c() == iIndexOf || vh2Var.c() == -1) {
                    this.i.add(vh2Var);
                }
            }
            List<vh2> list = this.i;
            su0Var.d(canvas, (vh2[]) list.toArray(new vh2[list.size()]));
        }
    }

    @Override // defpackage.su0
    public void e(Canvas canvas) {
        Iterator<su0> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().e(canvas);
        }
    }

    @Override // defpackage.su0
    public void f() {
        Iterator<su0> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public void h() {
        this.g.clear();
        CombinedChart combinedChart = (CombinedChart) this.h.get();
        if (combinedChart == null) {
            return;
        }
        for (CombinedChart.DrawOrder drawOrder : combinedChart.getDrawOrder()) {
            int i = a.f22417a[drawOrder.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5 && combinedChart.getScatterData() != null) {
                                this.g.add(new s25(combinedChart, this.b, this.f20113a));
                            }
                        } else if (combinedChart.getCandleData() != null) {
                            this.g.add(new jz(combinedChart, this.b, this.f20113a));
                        }
                    } else if (combinedChart.getLineData() != null) {
                        this.g.add(new o23(combinedChart, this.b, this.f20113a));
                    }
                } else if (combinedChart.getBubbleData() != null) {
                    this.g.add(new uu(combinedChart, this.b, this.f20113a));
                }
            } else if (combinedChart.getBarData() != null) {
                this.g.add(new mp(combinedChart, this.b, this.f20113a));
            }
        }
    }
}
