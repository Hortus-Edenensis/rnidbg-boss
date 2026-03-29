package defpackage;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class cq<T extends Entry> implements kl2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Integer> f16897a;
    public List<dd2> b;
    public List<Integer> c;
    public String d;
    public YAxis.AxisDependency e;
    public boolean f;
    public transient h96 g;
    public Typeface h;
    public Legend.LegendForm i;
    public float j;
    public float k;
    public DashPathEffect l;
    public boolean m;
    public boolean n;
    public vb3 o;
    public float p;
    public boolean q;

    public cq() {
        this.f16897a = null;
        this.b = null;
        this.c = null;
        this.d = "DataSet";
        this.e = YAxis.AxisDependency.LEFT;
        this.f = true;
        this.i = Legend.LegendForm.DEFAULT;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = null;
        this.m = true;
        this.n = true;
        this.o = new vb3();
        this.p = 17.0f;
        this.q = true;
        this.f16897a = new ArrayList();
        this.c = new ArrayList();
        this.f16897a.add(Integer.valueOf(Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 234, 255)));
        this.c.add(-16777216);
    }

    @Override // defpackage.kl2
    public DashPathEffect A() {
        return this.l;
    }

    @Override // defpackage.kl2
    public boolean B() {
        return this.n;
    }

    @Override // defpackage.kl2
    public boolean B0() {
        return this.g == null;
    }

    @Override // defpackage.kl2
    public float E() {
        return this.k;
    }

    @Override // defpackage.kl2
    public vb3 L0() {
        return this.o;
    }

    @Override // defpackage.kl2
    public boolean O() {
        return this.f;
    }

    public void P0() {
        f0();
    }

    public void Q0() {
        if (this.f16897a == null) {
            this.f16897a = new ArrayList();
        }
        this.f16897a.clear();
    }

    public void R0(int i) {
        Q0();
        this.f16897a.add(Integer.valueOf(i));
    }

    public void S0(boolean z) {
        this.n = z;
    }

    public void T0(boolean z) {
        this.m = z;
    }

    public void U0(float f) {
        this.k = f;
    }

    public void V0(float f) {
        this.j = f;
    }

    public void W0(List<Integer> list) {
        this.c = list;
    }

    public void X0(float f) {
        this.p = s86.e(f);
    }

    @Override // defpackage.kl2
    public h96 Z() {
        return B0() ? s86.j() : this.g;
    }

    @Override // defpackage.kl2
    public void a0(h96 h96Var) {
        if (h96Var == null) {
            return;
        }
        this.g = h96Var;
    }

    @Override // defpackage.kl2
    public Legend.LegendForm d() {
        return this.i;
    }

    @Override // defpackage.kl2
    public List<Integer> e0() {
        return this.f16897a;
    }

    @Override // defpackage.kl2
    public int getColor() {
        return this.f16897a.get(0).intValue();
    }

    @Override // defpackage.kl2
    public String getLabel() {
        return this.d;
    }

    @Override // defpackage.kl2
    public boolean h0() {
        return this.m;
    }

    @Override // defpackage.kl2
    public float i() {
        return this.j;
    }

    @Override // defpackage.kl2
    public YAxis.AxisDependency i0() {
        return this.e;
    }

    @Override // defpackage.kl2
    public boolean isVisible() {
        return this.q;
    }

    @Override // defpackage.kl2
    public Typeface j() {
        return this.h;
    }

    @Override // defpackage.kl2
    public int l(int i) {
        List<Integer> list = this.c;
        return list.get(i % list.size()).intValue();
    }

    @Override // defpackage.kl2
    public float t0() {
        return this.p;
    }

    @Override // defpackage.kl2
    public int z0(int i) {
        List<Integer> list = this.f16897a;
        return list.get(i % list.size()).intValue();
    }

    public cq(String str) {
        this();
        this.d = str;
    }
}
