package com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.u0;
import com.google.common.collect.v0;
import com.qq.gdt.action.ActionUtils;
import defpackage.dm4;
import j$.util.function.BiConsumer$CC;
import j$.util.function.BiFunction$CC;
import j$.util.function.Function$CC;
import j$.util.stream.Collector;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class u0 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c<R, C, V>> f6216a;
        public final t0<R, C, c<R, C, V>> b;

        public b() {
            this.f6216a = new ArrayList();
            this.b = HashBasedTable.create();
        }

        public b<R, C, V> a(b<R, C, V> bVar, BinaryOperator<V> binaryOperator) {
            for (c<R, C, V> cVar : bVar.f6216a) {
                b(cVar.o(), cVar.b(), cVar.getValue(), binaryOperator);
            }
            return this;
        }

        public void b(R r, C c, V v, BinaryOperator<V> binaryOperator) {
            c<R, C, V> cVar = this.b.get(r, c);
            if (cVar != null) {
                cVar.a(v, binaryOperator);
                return;
            }
            c<R, C, V> cVar2 = new c<>(r, c, v);
            this.f6216a.add(cVar2);
            this.b.put(r, c, cVar2);
        }

        public ImmutableTable<R, C, V> c() {
            return ImmutableTable.copyOf(this.f6216a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<R, C, V> extends v0.b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f6217a;
        public final C b;
        public V c;

        public c(R r, C c, V v) {
            this.f6217a = (R) dm4.p(r, "row");
            this.b = (C) dm4.p(c, "column");
            this.c = (V) dm4.p(v, ActionUtils.PAYMENT_AMOUNT);
        }

        public void a(V v, BinaryOperator<V> binaryOperator) {
            dm4.p(v, ActionUtils.PAYMENT_AMOUNT);
            this.c = (V) dm4.p(binaryOperator.apply(this.c, v), "mergeFunction.apply");
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
            return this.f6217a;
        }
    }

    public static /* synthetic */ void f(Function function, Function function2, Function function3, ImmutableTable.a aVar, Object obj) {
        aVar.e(function.apply(obj), function2.apply(obj), function3.apply(obj));
    }

    public static /* synthetic */ b g() {
        return new b();
    }

    public static /* synthetic */ void h(Function function, Function function2, Function function3, BinaryOperator binaryOperator, b bVar, Object obj) {
        bVar.b(function.apply(obj), function2.apply(obj), function3.apply(obj), binaryOperator);
    }

    public static /* synthetic */ b i(BinaryOperator binaryOperator, b bVar, b bVar2) {
        return bVar.a(bVar2, binaryOperator);
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> k(final Function<? super T, ? extends R> function, final Function<? super T, ? extends C> function2, final Function<? super T, ? extends V> function3) {
        dm4.p(function, "rowFunction");
        dm4.p(function2, "columnFunction");
        dm4.p(function3, "valueFunction");
        return Collector.CC.of(new Supplier() { // from class: ts5
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ImmutableTable.a();
            }
        }, new BiConsumer() { // from class: us5
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                u0.f(function, function2, function3, (ImmutableTable.a) obj, obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: vs5
            public /* synthetic */ BiFunction andThen(Function function4) {
                return BiFunction$CC.$default$andThen(this, function4);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableTable.a) obj).c((ImmutableTable.a) obj2);
            }
        }, new Function() { // from class: ws5
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function4) {
                return Function$CC.$default$andThen(this, function4);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableTable.a) obj).a();
            }

            public /* synthetic */ Function compose(Function function4) {
                return Function$CC.$default$compose(this, function4);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> l(final Function<? super T, ? extends R> function, final Function<? super T, ? extends C> function2, final Function<? super T, ? extends V> function3, final BinaryOperator<V> binaryOperator) {
        dm4.p(function, "rowFunction");
        dm4.p(function2, "columnFunction");
        dm4.p(function3, "valueFunction");
        dm4.p(binaryOperator, "mergeFunction");
        return Collector.CC.of(new Supplier() { // from class: xs5
            @Override // java.util.function.Supplier
            public final Object get() {
                return u0.g();
            }
        }, new BiConsumer() { // from class: ys5
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                u0.h(function, function2, function3, binaryOperator, (u0.b) obj, obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: zs5
            public /* synthetic */ BiFunction andThen(Function function4) {
                return BiFunction$CC.$default$andThen(this, function4);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return u0.i(binaryOperator, (u0.b) obj, (u0.b) obj2);
            }
        }, new Function() { // from class: at5
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function4) {
                return Function$CC.$default$andThen(this, function4);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((u0.b) obj).c();
            }

            public /* synthetic */ Function compose(Function function4) {
                return Function$CC.$default$compose(this, function4);
            }
        }, new Collector.Characteristics[0]);
    }
}
