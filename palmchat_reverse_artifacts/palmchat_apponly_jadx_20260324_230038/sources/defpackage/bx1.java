package defpackage;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bx1 extends as {
    public final int h;

    @Nullable
    public final Object i;

    public bx1(qz5 qz5Var, int i, int i2) {
        this(qz5Var, i, i2, 0, null);
    }

    @Override // defpackage.or1
    public int getSelectedIndex() {
        return 0;
    }

    @Override // defpackage.or1
    @Nullable
    public Object getSelectionData() {
        return this.i;
    }

    @Override // defpackage.or1
    public int getSelectionReason() {
        return this.h;
    }

    public bx1(qz5 qz5Var, int i, int i2, int i3, @Nullable Object obj) {
        super(qz5Var, new int[]{i}, i2);
        this.h = i3;
        this.i = obj;
    }

    @Override // defpackage.or1
    public void b(long j, long j2, long j3, List<? extends te3> list, ue3[] ue3VarArr) {
    }
}
