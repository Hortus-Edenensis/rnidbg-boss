package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.zenmen.palmchat.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class k10 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends h96 {
        @Override // defpackage.h96
        public String f(float f) {
            return String.valueOf((int) f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ul2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LineChart f18549a;

        public b(LineChart lineChart) {
            this.f18549a = lineChart;
        }

        @Override // defpackage.ul2
        public float a(hm2 hm2Var, q23 q23Var) {
            return this.f18549a.getAxisLeft().l();
        }
    }

    public static List<Integer> a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i; i3++) {
            arrayList.add(Integer.valueOf((int) (Math.random() * ((double) i2))));
        }
        return arrayList;
    }

    public static void b(LineChart lineChart) {
        lineChart.getDescription().g(false);
        lineChart.setMaxVisibleValueCount(60);
        lineChart.setPinchZoom(false);
        lineChart.setDrawGridBackground(false);
        lineChart.getXAxis().g(false);
        lineChart.getAxisRight().g(false);
        lineChart.getAxisLeft().g(false);
        lineChart.getAxisRight().D(false);
        lineChart.getAxisRight().E(false);
        lineChart.getXAxis().D(false);
        lineChart.getXAxis().E(false);
        lineChart.getLegend().g(false);
        lineChart.setTouchEnabled(false);
        lineChart.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Context context, LineChart lineChart, List<Integer> list, boolean z) {
        int color = Color.parseColor("#14CD64");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = true;
        for (int i = 0; i < list.size(); i++) {
            int iIntValue = list.get(i).intValue();
            if (i == list.size() - 1 && z) {
                arrayList.add(new Entry(i, iIntValue, ContextCompat.getDrawable(context, R.drawable.chart_circle_green)));
                arrayList2.add(Integer.valueOf(color));
            } else {
                arrayList.add(new Entry(i, iIntValue, ContextCompat.getDrawable(context, R.drawable.chart_circle_dot)));
                arrayList2.add(0);
            }
            if (iIntValue != 0) {
                z2 = false;
            }
        }
        if (lineChart.getData() != 0 && ((p23) lineChart.getData()).f() > 0) {
            LineDataSet lineDataSet = (LineDataSet) ((p23) lineChart.getData()).e(0);
            lineDataSet.c1(arrayList);
            lineDataSet.P0();
            ((p23) lineChart.getData()).t();
            lineChart.notifyDataSetChanged();
            return;
        }
        LineDataSet lineDataSet2 = new LineDataSet(arrayList, "DataSet 1");
        lineDataSet2.S0(true);
        lineDataSet2.a0(new a());
        lineDataSet2.R0(color);
        lineDataSet2.j1(color);
        lineDataSet2.h1(1.0f);
        lineDataSet2.k1(3.0f);
        lineDataSet2.l1(true);
        lineDataSet2.U0(1.0f);
        lineDataSet2.V0(15.0f);
        lineDataSet2.X0(9.0f);
        lineDataSet2.e1(true);
        lineDataSet2.m1(new b(lineChart));
        if (s86.s() >= 18) {
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.chart_fade_green);
            if (z2) {
                lineDataSet2.f1(-1);
            } else {
                lineDataSet2.g1(drawable);
            }
        } else {
            lineDataSet2.f1(-1);
        }
        lineDataSet2.T0(true);
        lineDataSet2.W0(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(lineDataSet2);
        lineChart.setData(new p23(arrayList3));
    }
}
