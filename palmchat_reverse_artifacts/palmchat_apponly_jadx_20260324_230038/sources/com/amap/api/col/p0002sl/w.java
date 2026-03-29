package com.amap.api.col.p0002sl;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static w f3051a = new w();
    private ArrayList<a> b = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void o();
    }

    public static w a() {
        return f3051a;
    }

    public final synchronized void b() {
        for (a aVar : this.b) {
            if (aVar != null) {
                aVar.o();
            }
        }
    }

    public final synchronized void a(a aVar) {
        this.b.add(aVar);
    }

    public final synchronized void b(a aVar) {
        this.b.remove(aVar);
    }
}
