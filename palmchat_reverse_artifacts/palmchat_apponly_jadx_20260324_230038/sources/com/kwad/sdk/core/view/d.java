package com.kwad.sdk.core.view;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    private List<c> aRJ = new CopyOnWriteArrayList();

    private boolean c(c cVar) {
        if (cVar != null) {
            return this.aRJ.contains(cVar);
        }
        return false;
    }

    public final void a(c cVar) {
        if (c(cVar)) {
            return;
        }
        this.aRJ.add(cVar);
    }

    public final void b(c cVar) {
        this.aRJ.remove(cVar);
    }

    public final void j(View view, boolean z) {
        Iterator<c> it = this.aRJ.iterator();
        while (it.hasNext()) {
            it.next().i(view, z);
        }
    }
}
