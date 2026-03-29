package com.opos.mobad.f.a.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8826a;
    private int b;
    private final List<b<T>> c;
    private Set<Integer> d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<b<T>> f8827a = new ArrayList();
        private int b = 0;

        public v<T> a() {
            return new v<>(this.f8827a, this.b);
        }

        public void a(T t, int i) {
            if (i <= 0) {
                return;
            }
            this.f8827a.add(new b<>(t, i));
            this.b += i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8828a;
        private final T b;

        public b(T t, int i) {
            this.b = t;
            this.f8828a = i;
        }
    }

    private v(List<b<T>> list, int i) {
        this.c = list;
        this.f8826a = i;
        this.b = i;
        this.d = new HashSet(list.size());
    }

    public T a() {
        if (this.b <= 0 || this.c.size() <= 0 || this.d.size() >= this.c.size()) {
            return null;
        }
        int iRandom = (int) (Math.random() * ((double) this.b));
        int iMax = 0;
        for (int i = 0; i < this.c.size(); i++) {
            if (!this.d.contains(Integer.valueOf(i))) {
                b<T> bVar = this.c.get(i);
                iMax += Math.max(0, ((b) bVar).f8828a);
                if (iRandom <= iMax) {
                    T t = (T) ((b) bVar).b;
                    this.d.add(Integer.valueOf(i));
                    this.b -= ((b) bVar).f8828a;
                    return t;
                }
            }
        }
        return null;
    }

    public void b() {
        this.b = this.f8826a;
        this.d.clear();
    }
}
