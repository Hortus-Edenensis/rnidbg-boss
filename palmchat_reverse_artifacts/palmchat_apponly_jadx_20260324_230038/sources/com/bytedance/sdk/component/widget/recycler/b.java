package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class b implements Runnable {
    long b;
    long fx;
    static final ThreadLocal<b> u = new ThreadLocal<>();
    static Comparator<nr> pn = new Comparator<nr>() { // from class: com.bytedance.sdk.component.widget.recycler.b.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compare(nr nrVar, nr nrVar2) {
            RecyclerView recyclerView = nrVar.b;
            if ((recyclerView == null) != (nrVar2.b == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = nrVar.u;
            if (z != nrVar2.u) {
                return z ? -1 : 1;
            }
            int i = nrVar2.nr - nrVar.nr;
            if (i != 0) {
                return i;
            }
            int i2 = nrVar.fx - nrVar2.fx;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    ArrayList<RecyclerView> nr = new ArrayList<>();
    private ArrayList<nr> iz = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public RecyclerView b;
        public int fx;
        public int nr;
        public int pn;
        public boolean u;

        public void u() {
            this.u = false;
            this.nr = 0;
            this.fx = 0;
            this.b = null;
            this.pn = 0;
        }
    }

    public void nr(RecyclerView recyclerView) {
        this.nr.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.bytedance.sdk.component.widget.recycler.u.u.u.u("RV Prefetch");
            if (!this.nr.isEmpty()) {
                int size = this.nr.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.nr.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    u(TimeUnit.MILLISECONDS.toNanos(jMax) + this.b);
                }
            }
        } finally {
            this.fx = 0L;
            com.bytedance.sdk.component.widget.recycler.u.u.u.u();
        }
    }

    public void u(RecyclerView recyclerView) {
        this.nr.add(recyclerView);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements RecyclerView.a.u {
        int b;
        int[] fx;
        int nr;
        int u;

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a.u
        public void nr(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.b * 2;
            int[] iArr = this.fx;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.fx = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.fx = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.fx;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.b++;
        }

        public void u(int i, int i2) {
            this.u = i;
            this.nr = i2;
        }

        public void u(RecyclerView recyclerView, boolean z) {
            this.b = 0;
            int[] iArr = this.fx;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.a aVar = recyclerView.s;
            if (recyclerView.mv == null || aVar == null || !aVar.s()) {
                return;
            }
            if (z) {
                if (!recyclerView.iz.b()) {
                    aVar.u(recyclerView.mv.u(), this);
                }
            } else if (!recyclerView.dw()) {
                aVar.u(this.u, this.nr, recyclerView.h, this);
            }
            int i = this.b;
            if (i > aVar.my) {
                aVar.my = i;
                aVar.o = z;
                recyclerView.pn.nr();
            }
        }

        public boolean u(int i) {
            if (this.fx != null) {
                int i2 = this.b * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.fx[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void u() {
            int[] iArr = this.fx;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = 0;
        }
    }

    private void nr(long j) {
        for (int i = 0; i < this.iz.size(); i++) {
            nr nrVar = this.iz.get(i);
            if (nrVar.b == null) {
                return;
            }
            u(nrVar, j);
            nrVar.u();
        }
    }

    public void u(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.fx == 0) {
            this.fx = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.d.u(i, i2);
    }

    private void u() {
        nr nrVar;
        int size = this.nr.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.nr.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.d.u(recyclerView, false);
                i += recyclerView.d.b;
            }
        }
        this.iz.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.nr.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                u uVar = recyclerView2.d;
                int iAbs = Math.abs(uVar.u) + Math.abs(uVar.nr);
                for (int i5 = 0; i5 < uVar.b * 2; i5 += 2) {
                    if (i3 >= this.iz.size()) {
                        nrVar = new nr();
                        this.iz.add(nrVar);
                    } else {
                        nrVar = this.iz.get(i3);
                    }
                    int[] iArr = uVar.fx;
                    int i6 = iArr[i5 + 1];
                    nrVar.u = i6 <= iAbs;
                    nrVar.nr = iAbs;
                    nrVar.fx = i6;
                    nrVar.b = recyclerView2;
                    nrVar.pn = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.iz, pn);
    }

    public static boolean u(RecyclerView recyclerView, int i) {
        int iFx = recyclerView.x.fx();
        for (int i2 = 0; i2 < iFx; i2++) {
            RecyclerView.q qVarPn = RecyclerView.pn(recyclerView.x.b(i2));
            if (qVarPn.fx == i && !qVarPn.s()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.q u(RecyclerView recyclerView, int i, long j) {
        if (u(recyclerView, i)) {
            return null;
        }
        RecyclerView.my myVar = recyclerView.pn;
        try {
            recyclerView.l();
            RecyclerView.q qVarU = myVar.u(i, false, j);
            if (qVarU != null) {
                if (qVarU.my() && !qVarU.s()) {
                    myVar.u(qVarU.u);
                } else {
                    myVar.u(qVarU, false);
                }
            }
            return qVarU;
        } finally {
            recyclerView.nr(false);
        }
    }

    private void u(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.q && recyclerView.x.fx() != 0) {
                recyclerView.fx();
            }
            u uVar = recyclerView.d;
            uVar.u(recyclerView, true);
            if (uVar.b != 0) {
                try {
                    com.bytedance.sdk.component.widget.recycler.u.u.u.u("RV Nested Prefetch");
                    recyclerView.h.u(recyclerView.mv);
                    for (int i = 0; i < uVar.b * 2; i += 2) {
                        u(recyclerView, uVar.fx[i], j);
                    }
                } finally {
                    com.bytedance.sdk.component.widget.recycler.u.u.u.u();
                }
            }
        }
    }

    private void u(nr nrVar, long j) {
        RecyclerView.q qVarU = u(nrVar.b, nrVar.pn, nrVar.u ? Long.MAX_VALUE : j);
        if (qVarU == null || qVarU.nr == null || !qVarU.my() || qVarU.s()) {
            return;
        }
        u(qVarU.nr.get(), j);
    }

    public void u(long j) {
        u();
        nr(j);
    }
}
