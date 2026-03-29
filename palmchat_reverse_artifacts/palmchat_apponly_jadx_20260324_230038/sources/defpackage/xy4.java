package defpackage;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.a;
import defpackage.sq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class xy4 implements i75, sq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u83 f22081a;
    public final String b;
    public final sq<Float, Float> c;

    @Nullable
    public z65 d;

    public xy4(u83 u83Var, a aVar, wy4 wy4Var) {
        this.f22081a = u83Var;
        this.b = wy4Var.c();
        sq<Float, Float> sqVarA = wy4Var.b().a();
        this.c = sqVarA;
        aVar.i(sqVarA);
        sqVarA.a(this);
    }

    public static int b(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    public static int c(int i, int i2) {
        return i - (b(i, i2) * i2);
    }

    @Override // sq.b
    public void e() {
        this.f22081a.invalidateSelf();
    }

    @Override // defpackage.i75
    public z65 g(z65 z65Var) {
        List<nr0> list;
        List<nr0> listA = z65Var.a();
        if (listA.size() <= 2) {
            return z65Var;
        }
        float fFloatValue = this.c.h().floatValue();
        if (fFloatValue == 0.0f) {
            return z65Var;
        }
        z65 z65VarI = i(z65Var);
        z65VarI.f(z65Var.b().x, z65Var.b().y);
        List<nr0> listA2 = z65VarI.a();
        boolean zD = z65Var.d();
        int i = 0;
        int i2 = 0;
        while (i < listA.size()) {
            nr0 nr0Var = listA.get(i);
            nr0 nr0Var2 = listA.get(c(i - 1, listA.size()));
            nr0 nr0Var3 = listA.get(c(i - 2, listA.size()));
            PointF pointFC = (i != 0 || zD) ? nr0Var2.c() : z65Var.b();
            PointF pointFB = (i != 0 || zD) ? nr0Var2.b() : pointFC;
            PointF pointFA = nr0Var.a();
            PointF pointFC2 = nr0Var3.c();
            PointF pointFC3 = nr0Var.c();
            boolean z = !z65Var.d() && i == 0 && i == listA.size() + (-1);
            if (pointFB.equals(pointFC) && pointFA.equals(pointFC) && !z) {
                float f = pointFC.x;
                float f2 = f - pointFC2.x;
                float f3 = pointFC.y;
                float f4 = f3 - pointFC2.y;
                float f5 = pointFC3.x - f;
                float f6 = pointFC3.y - f3;
                list = listA;
                float fHypot = (float) Math.hypot(f2, f4);
                float fHypot2 = (float) Math.hypot(f5, f6);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f7 = pointFC.x;
                float f8 = ((pointFC2.x - f7) * fMin) + f7;
                float f9 = pointFC.y;
                float f10 = ((pointFC2.y - f9) * fMin) + f9;
                float f11 = ((pointFC3.x - f7) * fMin2) + f7;
                float f12 = ((pointFC3.y - f9) * fMin2) + f9;
                float f13 = f8 - ((f8 - f7) * 0.5519f);
                float f14 = f10 - ((f10 - f9) * 0.5519f);
                float f15 = f11 - ((f11 - f7) * 0.5519f);
                float f16 = f12 - ((f12 - f9) * 0.5519f);
                nr0 nr0Var4 = listA2.get(c(i2 - 1, listA2.size()));
                nr0 nr0Var5 = listA2.get(i2);
                nr0Var4.e(f8, f10);
                nr0Var4.f(f8, f10);
                if (i == 0) {
                    z65VarI.f(f8, f10);
                }
                nr0Var5.d(f13, f14);
                i2++;
                nr0 nr0Var6 = listA2.get(i2);
                nr0Var5.e(f15, f16);
                nr0Var5.f(f11, f12);
                nr0Var6.d(f11, f12);
            } else {
                list = listA;
                nr0 nr0Var7 = listA2.get(c(i2 - 1, listA2.size()));
                nr0 nr0Var8 = listA2.get(i2);
                nr0Var7.e(nr0Var2.c().x, nr0Var2.c().y);
                nr0Var7.f(nr0Var2.c().x, nr0Var2.c().y);
                nr0Var8.d(nr0Var.c().x, nr0Var.c().y);
            }
            i2++;
            i++;
            listA = list;
        }
        return z65VarI;
    }

    public sq<Float, Float> h() {
        return this.c;
    }

    @NonNull
    public final z65 i(z65 z65Var) {
        List<nr0> listA = z65Var.a();
        boolean zD = z65Var.d();
        int size = listA.size() - 1;
        int i = 0;
        while (size >= 0) {
            nr0 nr0Var = listA.get(size);
            nr0 nr0Var2 = listA.get(c(size - 1, listA.size()));
            PointF pointFC = (size != 0 || zD) ? nr0Var2.c() : z65Var.b();
            i = (((size != 0 || zD) ? nr0Var2.b() : pointFC).equals(pointFC) && nr0Var.a().equals(pointFC) && !(!z65Var.d() && size == 0 && size == listA.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        z65 z65Var2 = this.d;
        if (z65Var2 == null || z65Var2.a().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new nr0());
            }
            this.d = new z65(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.d.e(zD);
        return this.d;
    }

    @Override // defpackage.ko0
    public void f(List<ko0> list, List<ko0> list2) {
    }
}
