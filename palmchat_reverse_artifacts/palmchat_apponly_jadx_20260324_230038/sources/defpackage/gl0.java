package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class gl0<O> implements pn5<O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gl0<O>.b<Set<String>> f17746a;
    public final ConcurrentMap<String, O> b = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Iterable<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f17747a;

        /* JADX INFO: renamed from: gl0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1199a extends r13<O> {
            public Iterator<Set<String>> c;
            public Iterator<String> d = Collections.emptyList().iterator();
            public Set<String> e = new HashSet();

            public C1199a() {
                this.c = gl0.this.f17746a.e(a.this.f17747a).iterator();
            }

            @Override // defpackage.r13
            public O a() {
                O o = null;
                while (o == null) {
                    while (!this.d.hasNext()) {
                        if (!this.c.hasNext()) {
                            return b();
                        }
                        this.d = this.c.next().iterator();
                    }
                    String next = this.d.next();
                    if (this.e.add(next)) {
                        o = (O) gl0.this.b.get(next);
                    }
                }
                return o;
            }
        }

        public a(CharSequence charSequence) {
            this.f17747a = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<O> iterator() {
            return new C1199a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b<V> extends fl0<V> {
        public b(oy3 oy3Var) {
            super(oy3Var);
        }

        @Override // defpackage.fl0
        public void b() {
            super.b();
        }

        @Override // defpackage.fl0
        public void j() {
            super.j();
        }
    }

    public gl0(oy3 oy3Var) {
        this.f17746a = new b<>(oy3Var);
    }

    @Override // defpackage.pn5
    public O a(CharSequence charSequence, O o) {
        if (charSequence == null) {
            throw new IllegalArgumentException("The key argument was null");
        }
        if (charSequence.length() == 0) {
            throw new IllegalArgumentException("The key argument was zero-length");
        }
        if (o == null) {
            throw new IllegalArgumentException("The value argument was null");
        }
        this.f17746a.b();
        try {
            String strH = a10.h(charSequence);
            O oPut = this.b.put(strH, o);
            if (oPut == null) {
                e(strH);
            }
            return oPut;
        } finally {
            this.f17746a.j();
        }
    }

    @Override // defpackage.pn5
    public Iterable<O> b(CharSequence charSequence) {
        return new a(charSequence);
    }

    public void e(String str) {
        for (CharSequence charSequence : a10.c(str)) {
            Set<String> setF = (Set) this.f17746a.d(charSequence);
            if (setF == null) {
                setF = f();
                this.f17746a.g(charSequence, setF);
            }
            setF.add(str);
        }
    }

    public Set<String> f() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }
}
