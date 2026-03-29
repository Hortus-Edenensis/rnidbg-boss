package defpackage;

import android.graphics.PointF;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cc0 implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1946a;
    public final rd<PointF, PointF> b;
    public final id c;
    public final boolean d;
    public final boolean e;

    public cc0(String str, rd<PointF, PointF> rdVar, id idVar, boolean z, boolean z2) {
        this.f1946a = str;
        this.b = rdVar;
        this.c = idVar;
        this.d = z;
        this.e = z2;
    }

    @Override // defpackage.np0
    public ko0 a(u83 u83Var, a aVar) {
        return new ol1(u83Var, aVar, this);
    }

    public String b() {
        return this.f1946a;
    }

    public rd<PointF, PointF> c() {
        return this.b;
    }

    public id d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.d;
    }
}
