package defpackage;

import android.graphics.PointF;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class y35 implements x35 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f22114a;
    public x35 b;
    public boolean c = true;

    @Override // defpackage.x35
    public boolean a(View view) {
        x35 x35Var = this.b;
        return x35Var != null ? x35Var.a(view) : nf5.a(view, this.f22114a, this.c);
    }

    @Override // defpackage.x35
    public boolean b(View view) {
        x35 x35Var = this.b;
        return x35Var != null ? x35Var.b(view) : nf5.b(view, this.f22114a);
    }
}
