package defpackage;

import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class j75 implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18340a;
    public final int b;
    public final kd c;
    public final boolean d;

    public j75(String str, int i, kd kdVar, boolean z) {
        this.f18340a = str;
        this.b = i;
        this.c = kdVar;
        this.d = z;
    }

    @Override // defpackage.np0
    public ko0 a(u83 u83Var, a aVar) {
        return new y65(u83Var, aVar, this);
    }

    public String b() {
        return this.f18340a;
    }

    public kd c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f18340a + ", index=" + this.b + '}';
    }
}
