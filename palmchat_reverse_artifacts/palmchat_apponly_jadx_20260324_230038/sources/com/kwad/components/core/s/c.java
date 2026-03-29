package com.kwad.components.core.s;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    private Set<b> acv;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static c acw = new c(0);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onPageClose();
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static c uu() {
        return a.acw;
    }

    public final void a(b bVar) {
        this.acv.add(bVar);
    }

    public final void b(b bVar) {
        this.acv.remove(bVar);
    }

    public final void uv() {
        if (this.acv.size() == 0) {
            return;
        }
        Iterator<b> it = this.acv.iterator();
        while (it.hasNext()) {
            it.next().onPageClose();
        }
    }

    private c() {
        this.acv = new HashSet();
    }
}
