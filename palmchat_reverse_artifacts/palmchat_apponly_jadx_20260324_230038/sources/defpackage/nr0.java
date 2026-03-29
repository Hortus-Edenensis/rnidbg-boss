package defpackage;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class nr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f19582a;
    public final PointF b;
    public final PointF c;

    public nr0() {
        this.f19582a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
    }

    public PointF a() {
        return this.f19582a;
    }

    public PointF b() {
        return this.b;
    }

    public PointF c() {
        return this.c;
    }

    public void d(float f, float f2) {
        this.f19582a.set(f, f2);
    }

    public void e(float f, float f2) {
        this.b.set(f, f2);
    }

    public void f(float f, float f2) {
        this.c.set(f, f2);
    }

    @NonNull
    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.c.x), Float.valueOf(this.c.y), Float.valueOf(this.f19582a.x), Float.valueOf(this.f19582a.y), Float.valueOf(this.b.x), Float.valueOf(this.b.y));
    }

    public nr0(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f19582a = pointF;
        this.b = pointF2;
        this.c = pointF3;
    }
}
