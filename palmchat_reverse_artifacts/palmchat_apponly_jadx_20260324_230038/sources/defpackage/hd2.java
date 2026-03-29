package defpackage;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hd2 implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientType f17933a;
    public final Path.FillType b;
    public final ed c;
    public final fd d;
    public final id e;
    public final id f;
    public final String g;

    @Nullable
    public final dd h;

    @Nullable
    public final dd i;
    public final boolean j;

    public hd2(String str, GradientType gradientType, Path.FillType fillType, ed edVar, fd fdVar, id idVar, id idVar2, dd ddVar, dd ddVar2, boolean z) {
        this.f17933a = gradientType;
        this.b = fillType;
        this.c = edVar;
        this.d = fdVar;
        this.e = idVar;
        this.f = idVar2;
        this.g = str;
        this.h = ddVar;
        this.i = ddVar2;
        this.j = z;
    }

    @Override // defpackage.np0
    public ko0 a(u83 u83Var, a aVar) {
        return new id2(u83Var, aVar, this);
    }

    public id b() {
        return this.f;
    }

    public Path.FillType c() {
        return this.b;
    }

    public ed d() {
        return this.c;
    }

    public GradientType e() {
        return this.f17933a;
    }

    public String f() {
        return this.g;
    }

    public fd g() {
        return this.d;
    }

    public id h() {
        return this.e;
    }

    public boolean i() {
        return this.j;
    }
}
