package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import defpackage.sq;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class jk4 implements rc4, sq.b, d03 {
    public final String b;
    public final u83 c;
    public final PolystarShape.Type d;
    public final boolean e;
    public final boolean f;
    public final sq<?, Float> g;
    public final sq<?, PointF> h;
    public final sq<?, Float> i;

    @Nullable
    public final sq<?, Float> j;
    public final sq<?, Float> k;

    @Nullable
    public final sq<?, Float> l;
    public final sq<?, Float> m;
    public boolean o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f18426a = new Path();
    public final uk0 n = new uk0();

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18427a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f18427a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18427a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public jk4(u83 u83Var, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.c = u83Var;
        this.b = polystarShape.d();
        PolystarShape.Type typeJ = polystarShape.j();
        this.d = typeJ;
        this.e = polystarShape.k();
        this.f = polystarShape.l();
        sq<Float, Float> sqVarA = polystarShape.g().a();
        this.g = sqVarA;
        sq<PointF, PointF> sqVarA2 = polystarShape.h().a();
        this.h = sqVarA2;
        sq<Float, Float> sqVarA3 = polystarShape.i().a();
        this.i = sqVarA3;
        sq<Float, Float> sqVarA4 = polystarShape.e().a();
        this.k = sqVarA4;
        sq<Float, Float> sqVarA5 = polystarShape.f().a();
        this.m = sqVarA5;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (typeJ == type) {
            this.j = polystarShape.b().a();
            this.l = polystarShape.c().a();
        } else {
            this.j = null;
            this.l = null;
        }
        aVar.i(sqVarA);
        aVar.i(sqVarA2);
        aVar.i(sqVarA3);
        aVar.i(sqVarA4);
        aVar.i(sqVarA5);
        if (typeJ == type) {
            aVar.i(this.j);
            aVar.i(this.l);
        }
        sqVarA.a(this);
        sqVarA2.a(this);
        sqVarA3.a(this);
        sqVarA4.a(this);
        sqVarA5.a(this);
        if (typeJ == type) {
            this.j.a(this);
            this.l.a(this);
        }
    }

    public final void b() {
        int i;
        double d;
        double d2;
        double d3;
        int iFloor = (int) Math.floor(this.g.h().floatValue());
        double radians = Math.toRadians((this.i == null ? 0.0d : r2.h().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.m.h().floatValue() / 100.0f;
        float fFloatValue2 = this.k.h().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.f18426a.moveTo(fCos, fSin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < dCeil) {
            float fCos2 = (float) (Math.cos(d7) * d5);
            double d8 = dCeil;
            float fSin2 = (float) (d5 * Math.sin(d7));
            if (fFloatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.f18426a.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan22)) * f), fSin2 + (f * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                i = i2;
                d = d7;
                d2 = d5;
                d3 = d6;
                this.f18426a.lineTo(fCos2, fSin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF pointFH = this.h.h();
        this.f18426a.offset(pointFH.x, pointFH.y);
        this.f18426a.close();
    }

    @Override // defpackage.c03
    public void c(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        sp3.k(b03Var, i, list, b03Var2, this);
    }

    @Override // sq.b
    public void e() {
        j();
    }

    @Override // defpackage.ko0
    public void f(List<ko0> list, List<ko0> list2) {
        for (int i = 0; i < list.size(); i++) {
            ko0 ko0Var = list.get(i);
            if (ko0Var instanceof q16) {
                q16 q16Var = (q16) ko0Var;
                if (q16Var.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.n.a(q16Var);
                    q16Var.b(this);
                }
            }
        }
    }

    @Override // defpackage.ko0
    public String getName() {
        return this.b;
    }

    @Override // defpackage.rc4
    public Path getPath() {
        if (this.o) {
            return this.f18426a;
        }
        this.f18426a.reset();
        if (this.e) {
            this.o = true;
            return this.f18426a;
        }
        int i = a.f18427a[this.d.ordinal()];
        if (i == 1) {
            i();
        } else if (i == 2) {
            b();
        }
        this.f18426a.close();
        this.n.b(this.f18426a);
        this.o = true;
        return this.f18426a;
    }

    @Override // defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        sq<?, Float> sqVar;
        sq<?, Float> sqVar2;
        if (t == d93.w) {
            this.g.n(i93Var);
            return;
        }
        if (t == d93.x) {
            this.i.n(i93Var);
            return;
        }
        if (t == d93.n) {
            this.h.n(i93Var);
            return;
        }
        if (t == d93.y && (sqVar2 = this.j) != null) {
            sqVar2.n(i93Var);
            return;
        }
        if (t == d93.z) {
            this.k.n(i93Var);
            return;
        }
        if (t == d93.A && (sqVar = this.l) != null) {
            sqVar.n(i93Var);
        } else if (t == d93.B) {
            this.m.n(i93Var);
        }
    }

    public final void i() {
        int i;
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        double d2;
        float f6;
        float f7;
        float f8;
        double d3;
        float fFloatValue = this.g.h().floatValue();
        double radians = Math.toRadians((this.i == null ? 0.0d : r2.h().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f9 = (float) (6.283185307179586d / d4);
        if (this.f) {
            f9 *= -1.0f;
        }
        float f10 = f9 / 2.0f;
        float f11 = fFloatValue - ((int) fFloatValue);
        int i2 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (double) ((1.0f - f11) * f10);
        }
        float fFloatValue2 = this.k.h().floatValue();
        float fFloatValue3 = this.j.h().floatValue();
        sq<?, Float> sqVar = this.l;
        float fFloatValue4 = sqVar != null ? sqVar.h().floatValue() / 100.0f : 0.0f;
        sq<?, Float> sqVar2 = this.m;
        float fFloatValue5 = sqVar2 != null ? sqVar2.h().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f3 = ((fFloatValue2 - fFloatValue3) * f11) + fFloatValue3;
            i = i2;
            double d5 = f3;
            float fCos = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.f18426a.moveTo(fCos, fSin);
            d = radians + ((double) ((f9 * f11) / 2.0f));
            f = fCos;
            f2 = f10;
        } else {
            i = i2;
            double d6 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d6);
            float fSin2 = (float) (d6 * Math.sin(radians));
            this.f18426a.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f10;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d4) * 2.0d;
        int i3 = 0;
        float f12 = f2;
        float f13 = f;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 >= dCeil) {
                PointF pointFH = this.h.h();
                this.f18426a.offset(pointFH.x, pointFH.y);
                this.f18426a.close();
                return;
            }
            float f14 = z ? fFloatValue2 : fFloatValue3;
            if (f3 == 0.0f || d7 != dCeil - 2.0d) {
                f4 = f9;
                f5 = f12;
            } else {
                f4 = f9;
                f5 = (f9 * f11) / 2.0f;
            }
            if (f3 == 0.0f || d7 != dCeil - 1.0d) {
                d2 = d7;
                f6 = f3;
                f3 = f14;
            } else {
                d2 = d7;
                f6 = f3;
            }
            double d8 = f3;
            double d9 = dCeil;
            float fCos3 = (float) (d8 * Math.cos(d));
            float fSin3 = (float) (d8 * Math.sin(d));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.f18426a.lineTo(fCos3, fSin3);
                d3 = d;
                f7 = fFloatValue4;
                f8 = fFloatValue5;
            } else {
                f7 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f13) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f8 = fFloatValue5;
                d3 = d;
                double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin5 = (float) Math.sin(dAtan22);
                float f15 = z ? f7 : f8;
                float f16 = z ? f8 : f7;
                float f17 = (z ? fFloatValue3 : fFloatValue2) * f15 * 0.47829f;
                float f18 = fCos4 * f17;
                float f19 = f17 * fSin4;
                float f20 = (z ? fFloatValue2 : fFloatValue3) * f16 * 0.47829f;
                float f21 = fCos5 * f20;
                float f22 = f20 * fSin5;
                if (i != 0) {
                    if (i3 == 0) {
                        f18 *= f11;
                        f19 *= f11;
                    } else if (d2 == d9 - 1.0d) {
                        f21 *= f11;
                        f22 *= f11;
                    }
                }
                this.f18426a.cubicTo(f13 - f18, fSin - f19, fCos3 + f21, fSin3 + f22, fCos3, fSin3);
            }
            d = d3 + ((double) f5);
            z = !z;
            i3++;
            f13 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f8;
            fFloatValue4 = f7;
            f3 = f6;
            f9 = f4;
            dCeil = d9;
        }
    }

    public final void j() {
        this.o = false;
        this.c.invalidateSelf();
    }
}
