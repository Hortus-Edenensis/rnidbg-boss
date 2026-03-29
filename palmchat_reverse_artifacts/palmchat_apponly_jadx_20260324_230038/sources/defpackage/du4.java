package defpackage;

import android.graphics.PointF;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class du4 implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17139a;
    public final rd<PointF, PointF> b;
    public final rd<PointF, PointF> c;
    public final dd d;
    public final boolean e;

    public du4(String str, rd<PointF, PointF> rdVar, rd<PointF, PointF> rdVar2, dd ddVar, boolean z) {
        this.f17139a = str;
        this.b = rdVar;
        this.c = rdVar2;
        this.d = ddVar;
        this.e = z;
    }

    @Override // defpackage.np0
    public ko0 a(u83 u83Var, a aVar) {
        return new cu4(u83Var, aVar, this);
    }

    public dd b() {
        return this.d;
    }

    public String c() {
        return this.f17139a;
    }

    public rd<PointF, PointF> d() {
        return this.b;
    }

    public rd<PointF, PointF> e() {
        return this.c;
    }

    public boolean f() {
        return this.e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.c + '}';
    }
}
