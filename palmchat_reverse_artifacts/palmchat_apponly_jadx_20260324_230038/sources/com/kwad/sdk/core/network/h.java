package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class h {
    private static volatile h aJs;
    private List<a> aJr = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(f fVar, int i);
    }

    private h() {
    }

    public static h Js() {
        if (aJs == null) {
            synchronized (h.class) {
                if (aJs == null) {
                    aJs = new h();
                }
            }
        }
        return aJs;
    }

    public final void a(a aVar) {
        this.aJr.add(aVar);
    }

    public final void b(f fVar, int i) {
        Iterator<a> it = this.aJr.iterator();
        while (it.hasNext()) {
            it.next().a(fVar, i);
        }
    }
}
