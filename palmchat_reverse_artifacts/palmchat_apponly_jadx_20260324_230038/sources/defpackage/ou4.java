package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ou4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w82 f19879a;
    public final List<x82> b;

    public ou4(w82 w82Var) {
        this.f19879a = w82Var;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new x82(w82Var, new int[]{1}));
    }

    public final x82 a(int i) {
        if (i >= this.b.size()) {
            List<x82> list = this.b;
            x82 x82VarI = list.get(list.size() - 1);
            for (int size = this.b.size(); size <= i; size++) {
                w82 w82Var = this.f19879a;
                x82VarI = x82VarI.i(new x82(w82Var, new int[]{1, w82Var.c((size - 1) + w82Var.d())}));
                this.b.add(x82VarI);
            }
        }
        return this.b.get(i);
    }

    public void b(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        x82 x82VarA = a(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrE = new x82(this.f19879a, iArr2).j(i, 1).b(x82VarA)[1].e();
        int length2 = i - iArrE.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(iArrE, 0, iArr, length + length2, iArrE.length);
    }
}
