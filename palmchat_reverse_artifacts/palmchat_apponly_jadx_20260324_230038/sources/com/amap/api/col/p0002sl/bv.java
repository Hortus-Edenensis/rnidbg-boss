package com.amap.api.col.p0002sl;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static bv f2661a = new bv();
    private ArrayList<a> b = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public static bv a() {
        return f2661a;
    }

    public final synchronized void b() {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final synchronized void a(a aVar) {
        this.b.remove(aVar);
    }
}
