package defpackage;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import defpackage.sq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class y65 implements rc4, sq.b {
    public final String b;
    public final boolean c;
    public final u83 d;
    public final g75 e;
    public boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f22149a = new Path();
    public final uk0 g = new uk0();

    public y65(u83 u83Var, a aVar, j75 j75Var) {
        this.b = j75Var.b();
        this.c = j75Var.d();
        this.d = u83Var;
        g75 g75VarA = j75Var.c().a();
        this.e = g75VarA;
        aVar.i(g75VarA);
        g75VarA.a(this);
    }

    public final void b() {
        this.f = false;
        this.d.invalidateSelf();
    }

    @Override // sq.b
    public void e() {
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // defpackage.ko0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(List<ko0> list, List<ko0> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            ko0 ko0Var = list.get(i);
            if (ko0Var instanceof q16) {
                q16 q16Var = (q16) ko0Var;
                if (q16Var.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.g.a(q16Var);
                    q16Var.b(this);
                } else if (ko0Var instanceof i75) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((i75) ko0Var);
                }
            }
        }
        this.e.q(arrayList);
    }

    @Override // defpackage.rc4
    public Path getPath() {
        if (this.f) {
            return this.f22149a;
        }
        this.f22149a.reset();
        if (this.c) {
            this.f = true;
            return this.f22149a;
        }
        Path pathH = this.e.h();
        if (pathH == null) {
            return this.f22149a;
        }
        this.f22149a.set(pathH);
        this.f22149a.setFillType(Path.FillType.EVEN_ODD);
        this.g.b(this.f22149a);
        this.f = true;
        return this.f22149a;
    }
}
