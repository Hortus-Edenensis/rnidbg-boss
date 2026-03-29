package defpackage;

import android.graphics.Path;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class g75 extends sq<z65, Path> {
    public final z65 i;
    public final Path j;
    public List<i75> k;

    public g75(List<h03<z65>> list) {
        super(list);
        this.i = new z65();
        this.j = new Path();
    }

    @Override // defpackage.sq
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Path i(h03<z65> h03Var, float f) {
        this.i.c(h03Var.b, h03Var.c, f);
        z65 z65VarG = this.i;
        List<i75> list = this.k;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                z65VarG = this.k.get(size).g(z65VarG);
            }
        }
        sp3.h(z65VarG, this.j);
        return this.j;
    }

    public void q(@Nullable List<i75> list) {
        this.k = list;
    }
}
