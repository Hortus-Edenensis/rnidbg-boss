package defpackage;

import com.airbnb.lottie.model.layer.a;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class e75 implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17229a;
    public final List<np0> b;
    public final boolean c;

    public e75(String str, List<np0> list, boolean z) {
        this.f17229a = str;
        this.b = list;
        this.c = z;
    }

    @Override // defpackage.np0
    public ko0 a(u83 u83Var, a aVar) {
        return new mo0(u83Var, aVar, this);
    }

    public List<np0> b() {
        return this.b;
    }

    public String c() {
        return this.f17229a;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f17229a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
    }
}
