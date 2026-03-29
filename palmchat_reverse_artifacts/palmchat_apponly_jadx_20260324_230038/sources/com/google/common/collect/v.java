package com.google.common.collect;

import defpackage.cj4;
import defpackage.dm4;
import defpackage.m33;
import defpackage.m65;
import defpackage.q94;
import defpackage.qo5;
import defpackage.sg0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class v<K0, V0> {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends g<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6218a;

        public a(int i) {
            this.f6218a = i;
        }

        @Override // com.google.common.collect.v.g
        public <K, V> Map<K, Collection<V>> c() {
            return cj4.d(this.f6218a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends g<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6219a;

        public b(int i) {
            this.f6219a = i;
        }

        @Override // com.google.common.collect.v.g
        public <K, V> Map<K, Collection<V>> c() {
            return cj4.f(this.f6219a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends g<K0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f6220a;

        public c(Comparator comparator) {
            this.f6220a = comparator;
        }

        @Override // com.google.common.collect.v.g
        public <K extends K0, V> Map<K, Collection<V>> c() {
            return new TreeMap(this.f6220a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d<V> implements qo5<List<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6221a;

        public d(int i) {
            this.f6221a = sg0.b(i, "expectedValuesPerKey");
        }

        @Override // defpackage.qo5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<V> get() {
            return new ArrayList(this.f6221a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e<V> implements qo5<Set<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6222a;

        public e(int i) {
            this.f6222a = sg0.b(i, "expectedValuesPerKey");
        }

        @Override // defpackage.qo5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Set<V> get() {
            return cj4.g(this.f6222a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class f<K0, V0> extends v<K0, V0> {
        public f() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> m33<K, V> g();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class g<K0> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends f<K0, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f6223a;
            public final /* synthetic */ g b;

            public a(g gVar, int i) {
                this.f6223a = i;
                this.b = gVar;
            }

            @Override // com.google.common.collect.v.f
            public <K extends K0, V> m33<K, V> g() {
                return w.b(this.b.c(), new d(this.f6223a));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends h<K0, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f6224a;
            public final /* synthetic */ g b;

            public b(g gVar, int i) {
                this.f6224a = i;
                this.b = gVar;
            }

            @Override // com.google.common.collect.v.h
            public <K extends K0, V> m65<K, V> g() {
                return w.c(this.b.c(), new e(this.f6224a));
            }
        }

        public f<K0, Object> a() {
            return b(2);
        }

        public f<K0, Object> b(int i) {
            sg0.b(i, "expectedValuesPerKey");
            return new a(this, i);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> c();

        public h<K0, Object> d() {
            return e(2);
        }

        public h<K0, Object> e(int i) {
            sg0.b(i, "expectedValuesPerKey");
            return new b(this, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class h<K0, V0> extends v<K0, V0> {
        public h() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> m65<K, V> g();
    }

    public /* synthetic */ v(a aVar) {
        this();
    }

    public static g<Object> a() {
        return b(8);
    }

    public static g<Object> b(int i) {
        sg0.b(i, "expectedKeys");
        return new a(i);
    }

    public static g<Object> c() {
        return d(8);
    }

    public static g<Object> d(int i) {
        sg0.b(i, "expectedKeys");
        return new b(i);
    }

    public static g<Comparable> e() {
        return f(q94.o());
    }

    public static <K0> g<K0> f(Comparator<K0> comparator) {
        dm4.o(comparator);
        return new c(comparator);
    }

    public v() {
    }
}
