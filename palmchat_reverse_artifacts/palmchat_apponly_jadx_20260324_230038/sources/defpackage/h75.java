package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.model.layer.b;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class h75 extends a {
    public final mo0 D;
    public final b E;

    public h75(u83 u83Var, Layer layer, b bVar) {
        super(u83Var, layer);
        this.E = bVar;
        mo0 mo0Var = new mo0(u83Var, this, new e75("__container", layer.n(), false));
        this.D = mo0Var;
        mo0Var.f(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void H(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        this.D.c(b03Var, i, list, b03Var2);
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.ah1
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.D.a(rectF, this.o, z);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void t(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.D.d(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.a
    @Nullable
    public eu v() {
        eu euVarV = super.v();
        return euVarV != null ? euVarV : this.E.v();
    }

    @Override // com.airbnb.lottie.model.layer.a
    @Nullable
    public ii1 x() {
        ii1 ii1VarX = super.x();
        return ii1VarX != null ? ii1VarX : this.E.x();
    }
}
