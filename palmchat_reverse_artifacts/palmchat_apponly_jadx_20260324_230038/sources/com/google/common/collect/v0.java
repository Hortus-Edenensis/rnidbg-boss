package com.google.common.collect;

import com.google.common.collect.t0;
import defpackage.m54;
import defpackage.u42;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u42<? extends Map<?, ?>, ? extends Map<?, ?>> f6225a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements u42<Map<Object, Object>, Map<Object, Object>> {
        @Override // defpackage.u42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b<R, C, V> implements t0.a<R, C, V> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof t0.a)) {
                return false;
            }
            t0.a aVar = (t0.a) obj;
            return m54.a(o(), aVar.o()) && m54.a(b(), aVar.b()) && m54.a(getValue(), aVar.getValue());
        }

        public int hashCode() {
            return m54.b(o(), b(), getValue());
        }

        public String toString() {
            return "(" + o() + "," + b() + ")=" + getValue();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<R, C, V> extends b<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f6226a;
        public final C b;
        public final V c;

        public c(R r, C c, V v) {
            this.f6226a = r;
            this.b = c;
            this.c = v;
        }

        @Override // com.google.common.collect.t0.a
        public C b() {
            return this.b;
        }

        @Override // com.google.common.collect.t0.a
        public V getValue() {
            return this.c;
        }

        @Override // com.google.common.collect.t0.a
        public R o() {
            return this.f6226a;
        }
    }

    public static boolean a(t0<?, ?, ?> t0Var, Object obj) {
        if (obj == t0Var) {
            return true;
        }
        if (obj instanceof t0) {
            return t0Var.cellSet().equals(((t0) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> t0.a<R, C, V> b(R r, C c2, V v) {
        return new c(r, c2, v);
    }
}
