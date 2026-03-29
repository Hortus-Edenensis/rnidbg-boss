package defpackage;

import com.github.mikephil.charting.components.YAxis;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class vh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f21445a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;
    public int g;
    public YAxis.AxisDependency h;
    public float i;
    public float j;

    public vh2(float f, float f2, int i) {
        this.e = -1;
        this.g = -1;
        this.f21445a = f;
        this.b = f2;
        this.f = i;
    }

    public boolean a(vh2 vh2Var) {
        return vh2Var != null && this.f == vh2Var.f && this.f21445a == vh2Var.f21445a && this.g == vh2Var.g && this.e == vh2Var.e;
    }

    public YAxis.AxisDependency b() {
        return this.h;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }

    public float e() {
        return this.i;
    }

    public float f() {
        return this.j;
    }

    public int g() {
        return this.g;
    }

    public float h() {
        return this.f21445a;
    }

    public float i() {
        return this.c;
    }

    public float j() {
        return this.b;
    }

    public float k() {
        return this.d;
    }

    public void l(int i) {
        this.e = i;
    }

    public void m(float f, float f2) {
        this.i = f;
        this.j = f2;
    }

    public String toString() {
        return "Highlight, x: " + this.f21445a + ", y: " + this.b + ", dataSetIndex: " + this.f + ", stackIndex (only stacked barentry): " + this.g;
    }

    public vh2(float f, int i, int i2) {
        this(f, Float.NaN, i);
        this.g = i2;
    }

    public vh2(float f, float f2, float f3, float f4, int i, YAxis.AxisDependency axisDependency) {
        this.e = -1;
        this.g = -1;
        this.f21445a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.f = i;
        this.h = axisDependency;
    }

    public vh2(float f, float f2, float f3, float f4, int i, int i2, YAxis.AxisDependency axisDependency) {
        this(f, f2, f3, f4, i, axisDependency);
        this.g = i2;
    }
}
