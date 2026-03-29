package com.bytedance.adsdk.lottie.u.u;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.bytedance.adsdk.lottie.model.nr.a;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@TargetApi(19)
public class l implements jk, mv {
    private final String b;
    private final com.bytedance.adsdk.lottie.model.nr.a iz;
    private final Path u = new Path();
    private final Path nr = new Path();
    private final Path fx = new Path();
    private final List<mv> pn = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.u.u.l$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[a.u.values().length];
            u = iArr;
            try {
                iArr[a.u.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[a.u.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[a.u.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                u[a.u.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                u[a.u.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(com.bytedance.adsdk.lottie.model.nr.a aVar) {
        this.b = aVar.u();
        this.iz = aVar;
    }

    @Override // com.bytedance.adsdk.lottie.u.u.mv
    public Path b() {
        this.fx.reset();
        if (this.iz.fx()) {
            return this.fx;
        }
        int i = AnonymousClass1.u[this.iz.nr().ordinal()];
        if (i == 1) {
            u();
        } else if (i == 2) {
            u(Path.Op.UNION);
        } else if (i == 3) {
            u(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            u(Path.Op.INTERSECT);
        } else if (i == 5) {
            u(Path.Op.XOR);
        }
        return this.fx;
    }

    @Override // com.bytedance.adsdk.lottie.u.u.jk
    public void u(ListIterator<fx> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            fx fxVarPrevious = listIterator.previous();
            if (fxVarPrevious instanceof mv) {
                this.pn.add((mv) fxVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.u.u.fx
    public void u(List<fx> list, List<fx> list2) {
        for (int i = 0; i < this.pn.size(); i++) {
            this.pn.get(i).u(list, list2);
        }
    }

    private void u() {
        for (int i = 0; i < this.pn.size(); i++) {
            this.fx.addPath(this.pn.get(i).b());
        }
    }

    @TargetApi(19)
    private void u(Path.Op op) {
        this.nr.reset();
        this.u.reset();
        for (int size = this.pn.size() - 1; size > 0; size--) {
            mv mvVar = this.pn.get(size);
            if (mvVar instanceof b) {
                b bVar = (b) mvVar;
                List<mv> listNr = bVar.nr();
                for (int size2 = listNr.size() - 1; size2 >= 0; size2--) {
                    Path pathB = listNr.get(size2).b();
                    pathB.transform(bVar.fx());
                    this.nr.addPath(pathB);
                }
            } else {
                this.nr.addPath(mvVar.b());
            }
        }
        mv mvVar2 = this.pn.get(0);
        if (mvVar2 instanceof b) {
            b bVar2 = (b) mvVar2;
            List<mv> listNr2 = bVar2.nr();
            for (int i = 0; i < listNr2.size(); i++) {
                Path pathB2 = listNr2.get(i).b();
                pathB2.transform(bVar2.fx());
                this.u.addPath(pathB2);
            }
        } else {
            this.u.set(mvVar2.b());
        }
        this.fx.op(this.u, this.nr, op);
    }
}
