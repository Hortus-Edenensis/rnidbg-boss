package com.kwad.components.core.innerEc.a;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h {
    private final List<g> RW;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final h RX = new h(0);
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h qX() {
        return a.RX;
    }

    public final void a(g gVar) {
        this.RW.add(gVar);
    }

    public final void b(g gVar) {
        if (gVar != null) {
            this.RW.remove(gVar);
        }
    }

    public final void qY() {
        Iterator<g> it = this.RW.iterator();
        while (it.hasNext()) {
            it.next().di();
        }
    }

    public final void qZ() {
        Iterator<g> it = this.RW.iterator();
        while (it.hasNext()) {
            it.next().dj();
        }
    }

    private h() {
        this.RW = new CopyOnWriteArrayList();
    }
}
