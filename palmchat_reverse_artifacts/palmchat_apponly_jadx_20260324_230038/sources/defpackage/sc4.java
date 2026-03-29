package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class sc4 extends h03<PointF> {

    @Nullable
    public Path q;
    public final h03<PointF> r;

    public sc4(u73 u73Var, h03<PointF> h03Var) {
        super(u73Var, h03Var.b, h03Var.c, h03Var.d, h03Var.e, h03Var.f, h03Var.g, h03Var.h);
        this.r = h03Var;
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        T t;
        T t2;
        T t3 = this.c;
        boolean z = (t3 == 0 || (t2 = this.b) == 0 || !((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = this.b;
        if (t4 == 0 || (t = this.c) == 0 || z) {
            return;
        }
        h03<PointF> h03Var = this.r;
        this.q = r86.d((PointF) t4, (PointF) t, h03Var.o, h03Var.p);
    }

    @Nullable
    public Path j() {
        return this.q;
    }
}
