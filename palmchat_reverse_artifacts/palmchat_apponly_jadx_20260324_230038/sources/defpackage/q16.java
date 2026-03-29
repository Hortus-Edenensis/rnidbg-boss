package defpackage;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import defpackage.sq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class q16 implements ko0, sq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20158a;
    public final boolean b;
    public final List<sq.b> c = new ArrayList();
    public final ShapeTrimPath.Type d;
    public final sq<?, Float> e;
    public final sq<?, Float> f;
    public final sq<?, Float> g;

    public q16(a aVar, ShapeTrimPath shapeTrimPath) {
        this.f20158a = shapeTrimPath.c();
        this.b = shapeTrimPath.g();
        this.d = shapeTrimPath.f();
        sq<Float, Float> sqVarA = shapeTrimPath.e().a();
        this.e = sqVarA;
        sq<Float, Float> sqVarA2 = shapeTrimPath.b().a();
        this.f = sqVarA2;
        sq<Float, Float> sqVarA3 = shapeTrimPath.d().a();
        this.g = sqVarA3;
        aVar.i(sqVarA);
        aVar.i(sqVarA2);
        aVar.i(sqVarA3);
        sqVarA.a(this);
        sqVarA2.a(this);
        sqVarA3.a(this);
    }

    public void b(sq.b bVar) {
        this.c.add(bVar);
    }

    public sq<?, Float> c() {
        return this.f;
    }

    @Override // sq.b
    public void e() {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).e();
        }
    }

    public sq<?, Float> h() {
        return this.g;
    }

    public sq<?, Float> i() {
        return this.e;
    }

    public ShapeTrimPath.Type j() {
        return this.d;
    }

    public boolean k() {
        return this.b;
    }

    @Override // defpackage.ko0
    public void f(List<ko0> list, List<ko0> list2) {
    }
}
