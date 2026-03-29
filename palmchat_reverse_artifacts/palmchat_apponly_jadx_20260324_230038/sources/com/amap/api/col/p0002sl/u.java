package com.amap.api.col.p0002sl;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static u f3049a = new u();
    private ArrayList<a> b = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void p();
    }

    public static u a() {
        return f3049a;
    }

    public final void b() {
        for (a aVar : this.b) {
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    public final void a(a aVar) {
        this.b.add(aVar);
    }

    public final void b(a aVar) {
        this.b.remove(aVar);
    }
}
