package defpackage;

import com.github.mikephil.charting.data.Entry;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ii4 extends h10<ao2> {
    @Override // defpackage.h10
    public Entry j(vh2 vh2Var) {
        return u().h((int) vh2Var.h());
    }

    public ao2 u() {
        return (ao2) this.i.get(0);
    }

    @Override // defpackage.h10
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public ao2 e(int i) {
        if (i == 0) {
            return u();
        }
        return null;
    }

    public float w() {
        float y = 0.0f;
        for (int i = 0; i < u().K0(); i++) {
            y += u().h(i).getY();
        }
        return y;
    }
}
