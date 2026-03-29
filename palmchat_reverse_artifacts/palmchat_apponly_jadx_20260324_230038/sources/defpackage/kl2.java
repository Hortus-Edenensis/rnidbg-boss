package defpackage;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface kl2<T extends Entry> {
    DashPathEffect A();

    boolean B();

    boolean B0();

    T C0(float f, float f2, DataSet.Rounding rounding);

    float E();

    float I();

    int K0();

    vb3 L0();

    dd2 M0(int i);

    boolean O();

    float S();

    float W();

    h96 Z();

    void a0(h96 h96Var);

    int b(T t);

    Legend.LegendForm d();

    List<Integer> e0();

    void f0();

    int getColor();

    String getLabel();

    T h(int i);

    boolean h0();

    float i();

    YAxis.AxisDependency i0();

    boolean isVisible();

    Typeface j();

    int l(int i);

    void o(float f, float f2);

    T o0(float f, float f2);

    List<T> p(float f);

    List<dd2> q();

    dd2 r0();

    float t0();

    float y();

    int z0(int i);
}
