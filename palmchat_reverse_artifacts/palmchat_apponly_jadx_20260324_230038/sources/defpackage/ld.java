package defpackage;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ld implements rd<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dd f18958a;
    public final dd b;

    public ld(dd ddVar, dd ddVar2) {
        this.f18958a = ddVar;
        this.b = ddVar2;
    }

    @Override // defpackage.rd
    public sq<PointF, PointF> a() {
        return new hh5(this.f18958a.a(), this.b.a());
    }

    @Override // defpackage.rd
    public List<h03<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // defpackage.rd
    public boolean isStatic() {
        return this.f18958a.isStatic() && this.b.isStatic();
    }
}
