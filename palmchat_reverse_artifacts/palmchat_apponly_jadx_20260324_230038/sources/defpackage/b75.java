package defpackage;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class b75 implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1661a;
    public final Path.FillType b;
    public final String c;

    @Nullable
    public final cd d;

    @Nullable
    public final fd e;
    public final boolean f;

    public b75(String str, boolean z, Path.FillType fillType, @Nullable cd cdVar, @Nullable fd fdVar, boolean z2) {
        this.c = str;
        this.f1661a = z;
        this.b = fillType;
        this.d = cdVar;
        this.e = fdVar;
        this.f = z2;
    }

    @Override // defpackage.np0
    public ko0 a(u83 u83Var, a aVar) {
        return new lv1(u83Var, aVar, this);
    }

    @Nullable
    public cd b() {
        return this.d;
    }

    public Path.FillType c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    @Nullable
    public fd e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f1661a + '}';
    }
}
