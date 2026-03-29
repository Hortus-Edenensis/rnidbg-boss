package com.kwad.components.core.webview.tachikoma.e;

import com.kwad.components.core.webview.tachikoma.f.f;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    private final Set<Integer> alI = new HashSet();
    private final ConcurrentHashMap<Integer, Set<f>> alJ = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final b alK = new b();
    }

    private void bG(int i) {
        Set<f> set;
        this.alI.remove(Integer.valueOf(i));
        if (this.alJ.isEmpty() || this.alJ.get(Integer.valueOf(i)) == null || (set = this.alJ.get(Integer.valueOf(i))) == null || set.isEmpty()) {
            return;
        }
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().wY();
        }
        this.alJ.remove(Integer.valueOf(i));
    }

    public static b xn() {
        return a.alK;
    }

    public final void a(int i, f fVar) {
        Set<f> set = this.alJ.get(Integer.valueOf(i));
        if (set != null) {
            set.add(fVar);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(fVar);
        this.alJ.put(Integer.valueOf(i), hashSet);
    }

    public final void b(int i, String str, String str2) {
        a(i, str, str2);
    }

    public final boolean bF(int i) {
        if (this.alI.contains(Integer.valueOf(i))) {
            return false;
        }
        this.alI.add(Integer.valueOf(i));
        return true;
    }

    public final void bH(int i) {
        bG(i);
    }

    private void a(int i, String str, String str2) {
        Set<f> set;
        this.alI.remove(Integer.valueOf(i));
        if (this.alJ.isEmpty() || this.alJ.get(Integer.valueOf(i)) == null || (set = this.alJ.get(Integer.valueOf(i))) == null || set.isEmpty()) {
            return;
        }
        this.alJ.remove(Integer.valueOf(i));
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().wX();
        }
    }
}
