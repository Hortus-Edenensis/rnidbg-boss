package defpackage;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gd implements rd<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h03<PointF>> f17712a;

    public gd(List<h03<PointF>> list) {
        this.f17712a = list;
    }

    @Override // defpackage.rd
    public sq<PointF, PointF> a() {
        return this.f17712a.get(0).h() ? new ek4(this.f17712a) : new tc4(this.f17712a);
    }

    @Override // defpackage.rd
    public List<h03<PointF>> b() {
        return this.f17712a;
    }

    @Override // defpackage.rd
    public boolean isStatic() {
        return this.f17712a.size() == 1 && this.f17712a.get(0).h();
    }
}
