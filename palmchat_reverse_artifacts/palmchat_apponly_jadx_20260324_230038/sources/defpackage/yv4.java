package defpackage;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class yv4 implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22288a;
    public final dd b;
    public final dd c;
    public final pd d;
    public final boolean e;

    public yv4(String str, dd ddVar, dd ddVar2, pd pdVar, boolean z) {
        this.f22288a = str;
        this.b = ddVar;
        this.c = ddVar2;
        this.d = pdVar;
        this.e = z;
    }

    @Override // defpackage.np0
    @Nullable
    public ko0 a(u83 u83Var, a aVar) {
        return new zv4(u83Var, aVar, this);
    }

    public dd b() {
        return this.b;
    }

    public String c() {
        return this.f22288a;
    }

    public dd d() {
        return this.c;
    }

    public pd e() {
        return this.d;
    }

    public boolean f() {
        return this.e;
    }
}
