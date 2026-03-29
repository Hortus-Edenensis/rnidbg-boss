package com.kwad.components.core.e.e;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class g {
    private final List<f> Qz;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final g QA = new g(0);
    }

    public /* synthetic */ g(byte b) {
        this();
    }

    public static g qo() {
        return a.QA;
    }

    public final void a(f fVar) {
        this.Qz.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.Qz.remove(fVar);
        }
    }

    public final void qp() {
        Iterator<f> it = this.Qz.iterator();
        while (it.hasNext()) {
            it.next().show();
        }
    }

    public final void qq() {
        Iterator<f> it = this.Qz.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
        }
    }

    private g() {
        this.Qz = new CopyOnWriteArrayList();
    }
}
