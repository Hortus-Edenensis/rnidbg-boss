package defpackage;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class wy4 implements np0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21832a;
    public final rd<Float, Float> b;

    public wy4(String str, rd<Float, Float> rdVar) {
        this.f21832a = str;
        this.b = rdVar;
    }

    @Override // defpackage.np0
    @Nullable
    public ko0 a(u83 u83Var, a aVar) {
        return new xy4(u83Var, aVar, this);
    }

    public rd<Float, Float> b() {
        return this.b;
    }

    public String c() {
        return this.f21832a;
    }
}
