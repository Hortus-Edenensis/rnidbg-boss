package defpackage;

import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import defpackage.sq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ki1 implements sq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sq.b f18695a;
    public final sq<Integer, Integer> b;
    public final sq<Float, Float> c;
    public final sq<Float, Float> d;
    public final sq<Float, Float> e;
    public final sq<Float, Float> f;
    public boolean g = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends i93<Float> {
        public final /* synthetic */ i93 d;

        public a(i93 i93Var) {
            this.d = i93Var;
        }

        @Override // defpackage.i93
        @Nullable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float a(w83<Float> w83Var) {
            Float f = (Float) this.d.a(w83Var);
            if (f == null) {
                return null;
            }
            return Float.valueOf(f.floatValue() * 2.55f);
        }
    }

    public ki1(sq.b bVar, com.airbnb.lottie.model.layer.a aVar, ii1 ii1Var) {
        this.f18695a = bVar;
        sq<Integer, Integer> sqVarA = ii1Var.a().a();
        this.b = sqVarA;
        sqVarA.a(this);
        aVar.i(sqVarA);
        sq<Float, Float> sqVarA2 = ii1Var.d().a();
        this.c = sqVarA2;
        sqVarA2.a(this);
        aVar.i(sqVarA2);
        sq<Float, Float> sqVarA3 = ii1Var.b().a();
        this.d = sqVarA3;
        sqVarA3.a(this);
        aVar.i(sqVarA3);
        sq<Float, Float> sqVarA4 = ii1Var.c().a();
        this.e = sqVarA4;
        sqVarA4.a(this);
        aVar.i(sqVarA4);
        sq<Float, Float> sqVarA5 = ii1Var.e().a();
        this.f = sqVarA5;
        sqVarA5.a(this);
        aVar.i(sqVarA5);
    }

    public void a(Paint paint) {
        if (this.g) {
            this.g = false;
            double dFloatValue = ((double) this.d.h().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.e.h().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.b.h().intValue();
            paint.setShadowLayer(this.f.h().floatValue(), fSin, fCos, Color.argb(Math.round(this.c.h().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }

    public void b(@Nullable i93<Integer> i93Var) {
        this.b.n(i93Var);
    }

    public void c(@Nullable i93<Float> i93Var) {
        this.d.n(i93Var);
    }

    public void d(@Nullable i93<Float> i93Var) {
        this.e.n(i93Var);
    }

    @Override // sq.b
    public void e() {
        this.g = true;
        this.f18695a.e();
    }

    public void f(@Nullable i93<Float> i93Var) {
        if (i93Var == null) {
            this.c.n(null);
        } else {
            this.c.n(new a(i93Var));
        }
    }

    public void g(@Nullable i93<Float> i93Var) {
        this.f.n(i93Var);
    }
}
