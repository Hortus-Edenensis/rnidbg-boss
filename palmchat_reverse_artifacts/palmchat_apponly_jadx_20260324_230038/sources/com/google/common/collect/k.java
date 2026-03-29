package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Range;
import com.google.common.collect.k;
import com.google.common.collect.v;
import com.google.common.collect.x;
import defpackage.dm4;
import defpackage.lg0;
import defpackage.ps3;
import j$.util.Objects;
import j$.util.function.BiConsumer$CC;
import j$.util.function.BiFunction$CC;
import j$.util.function.Consumer$CC;
import j$.util.function.Function$CC;
import j$.util.stream.Collector;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collector<Object, ?, ImmutableList<Object>> f6176a = Collector.CC.of(new Supplier() { // from class: re0
        @Override // java.util.function.Supplier
        public final Object get() {
            return ImmutableList.builder();
        }
    }, new BiConsumer() { // from class: ue0
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((ImmutableList.a) obj).a(obj2);
        }

        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer$CC.$default$andThen(this, biConsumer);
        }
    }, new BinaryOperator() { // from class: we0
        public /* synthetic */ BiFunction andThen(Function function) {
            return BiFunction$CC.$default$andThen(this, function);
        }

        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((ImmutableList.a) obj).p((ImmutableList.a) obj2);
        }
    }, new Function() { // from class: xe0
        @Override // java.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function$CC.$default$andThen(this, function);
        }

        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((ImmutableList.a) obj).e();
        }

        public /* synthetic */ Function compose(Function function) {
            return Function$CC.$default$compose(this, function);
        }
    }, new Collector.Characteristics[0]);
    public static final Collector<Object, ?, ImmutableSet<Object>> b = Collector.CC.of(new Supplier() { // from class: ye0
        @Override // java.util.function.Supplier
        public final Object get() {
            return ImmutableSet.builder();
        }
    }, new BiConsumer() { // from class: ze0
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((ImmutableSet.a) obj).a(obj2);
        }

        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer$CC.$default$andThen(this, biConsumer);
        }
    }, new BinaryOperator() { // from class: af0
        public /* synthetic */ BiFunction andThen(Function function) {
            return BiFunction$CC.$default$andThen(this, function);
        }

        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((ImmutableSet.a) obj).p((ImmutableSet.a) obj2);
        }
    }, new Function() { // from class: bf0
        @Override // java.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function$CC.$default$andThen(this, function);
        }

        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((ImmutableSet.a) obj).e();
        }

        public /* synthetic */ Function compose(Function function) {
            return Function$CC.$default$compose(this, function);
        }
    }, new Collector.Characteristics[0]);
    public static final Collector<Range<Comparable<?>>, ?, ImmutableRangeSet<Comparable<?>>> c = Collector.CC.of(new Supplier() { // from class: cf0
        @Override // java.util.function.Supplier
        public final Object get() {
            return ImmutableRangeSet.builder();
        }
    }, new BiConsumer() { // from class: df0
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((ImmutableRangeSet.d) obj).a((Range) obj2);
        }

        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer$CC.$default$andThen(this, biConsumer);
        }
    }, new BinaryOperator() { // from class: se0
        public /* synthetic */ BiFunction andThen(Function function) {
            return BiFunction$CC.$default$andThen(this, function);
        }

        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((ImmutableRangeSet.d) obj).d((ImmutableRangeSet.d) obj2);
        }
    }, new Function() { // from class: te0
        @Override // java.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function$CC.$default$andThen(this, function);
        }

        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((ImmutableRangeSet.d) obj).c();
        }

        public /* synthetic */ Function compose(Function function) {
            return Function$CC.$default$compose(this, function);
        }
    }, new Collector.Characteristics[0]);

    public static /* synthetic */ ps3 A(ps3 ps3Var, ps3 ps3Var2) {
        ps3Var.putAll(ps3Var2);
        return ps3Var;
    }

    public static /* synthetic */ void B(Function function, Function function2, ImmutableBiMap.a aVar, Object obj) {
        aVar.h(function.apply(obj), function2.apply(obj));
    }

    public static /* synthetic */ void C(Function function, Function function2, ImmutableListMultimap.a aVar, Object obj) {
        aVar.f(function.apply(obj), function2.apply(obj));
    }

    public static /* synthetic */ void D(Function function, Function function2, ImmutableMap.b bVar, Object obj) {
        bVar.h(function.apply(obj), function2.apply(obj));
    }

    public static /* synthetic */ void E(Function function, ToIntFunction toIntFunction, x xVar, Object obj) {
        xVar.add(dm4.o(function.apply(obj)), toIntFunction.applyAsInt(obj));
    }

    public static /* synthetic */ x F(x xVar, x xVar2) {
        xVar.addAll(xVar2);
        return xVar;
    }

    public static /* synthetic */ ImmutableMultiset G(x xVar) {
        return ImmutableMultiset.copyFromEntries(xVar.entrySet());
    }

    public static /* synthetic */ void H(Function function, Function function2, ImmutableRangeMap.c cVar, Object obj) {
        cVar.c((Range) function.apply(obj), function2.apply(obj));
    }

    public static /* synthetic */ void I(Function function, Function function2, ImmutableSetMultimap.a aVar, Object obj) {
        aVar.f(function.apply(obj), function2.apply(obj));
    }

    public static /* synthetic */ TreeMap J(Comparator comparator) {
        return new TreeMap(comparator);
    }

    public static /* synthetic */ ImmutableSortedMap.b K(Comparator comparator) {
        return new ImmutableSortedMap.b(comparator);
    }

    public static /* synthetic */ void L(Function function, Function function2, ImmutableSortedMap.b bVar, Object obj) {
        bVar.h(function.apply(obj), function2.apply(obj));
    }

    public static /* synthetic */ ImmutableSortedSet.a M(Comparator comparator) {
        return new ImmutableSortedSet.a(comparator);
    }

    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> N(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        dm4.o(function);
        dm4.o(function2);
        return Collector.CC.of(new Supplier() { // from class: ne0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ImmutableBiMap.a();
            }
        }, new BiConsumer() { // from class: oe0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                k.B(function, function2, (ImmutableBiMap.a) obj, obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: pe0
            public /* synthetic */ BiFunction andThen(Function function3) {
                return BiFunction$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableBiMap.a) obj).e((ImmutableBiMap.a) obj2);
            }
        }, new Function() { // from class: qe0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function3) {
                return Function$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableBiMap.a) obj).d();
            }

            public /* synthetic */ Function compose(Function function3) {
                return Function$CC.$default$compose(this, function3);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <E> Collector<E, ?, ImmutableList<E>> O() {
        return (Collector<E, ?, ImmutableList<E>>) f6176a;
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> P(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        dm4.p(function, "keyFunction");
        dm4.p(function2, "valueFunction");
        return Collector.CC.of(new Supplier() { // from class: ag0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableListMultimap.builder();
            }
        }, new BiConsumer() { // from class: bg0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                k.C(function, function2, (ImmutableListMultimap.a) obj, obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: dg0
            public /* synthetic */ BiFunction andThen(Function function3) {
                return BiFunction$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableListMultimap.a) obj).l((ImmutableListMultimap.a) obj2);
            }
        }, new Function() { // from class: eg0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function3) {
                return Function$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableListMultimap.a) obj).k();
            }

            public /* synthetic */ Function compose(Function function3) {
                return Function$CC.$default$compose(this, function3);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> Q(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        dm4.o(function);
        dm4.o(function2);
        return Collector.CC.of(new Supplier() { // from class: sf0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ImmutableMap.b();
            }
        }, new BiConsumer() { // from class: tf0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                k.D(function, function2, (ImmutableMap.b) obj, obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: uf0
            public /* synthetic */ BiFunction andThen(Function function3) {
                return BiFunction$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableMap.b) obj).e((ImmutableMap.b) obj2);
            }
        }, new Function() { // from class: vf0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function3) {
                return Function$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableMap.b) obj).d();
            }

            public /* synthetic */ Function compose(Function function3) {
                return Function$CC.$default$compose(this, function3);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> R(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        dm4.o(function);
        dm4.o(function2);
        dm4.o(binaryOperator);
        return Collectors.collectingAndThen(Collectors.toMap(function, function2, binaryOperator, new Supplier() { // from class: og0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new LinkedHashMap();
            }
        }), new Function() { // from class: pg0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function3) {
                return Function$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableMap.copyOf((Map) obj);
            }

            public /* synthetic */ Function compose(Function function3) {
                return Function$CC.$default$compose(this, function3);
            }
        });
    }

    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> S(final Function<? super T, ? extends E> function, final ToIntFunction<? super T> toIntFunction) {
        dm4.o(function);
        dm4.o(toIntFunction);
        return Collector.CC.of(new Supplier() { // from class: qg0
            @Override // java.util.function.Supplier
            public final Object get() {
                return LinkedHashMultiset.create();
            }
        }, new BiConsumer() { // from class: rg0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                k.E(function, toIntFunction, (x) obj, obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: le0
            public /* synthetic */ BiFunction andThen(Function function2) {
                return BiFunction$CC.$default$andThen(this, function2);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return k.F((x) obj, (x) obj2);
            }
        }, new Function() { // from class: me0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function2) {
                return Function$CC.$default$andThen(this, function2);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return k.G((x) obj);
            }

            public /* synthetic */ Function compose(Function function2) {
                return Function$CC.$default$compose(this, function2);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> T(final Function<? super T, Range<K>> function, final Function<? super T, ? extends V> function2) {
        dm4.o(function);
        dm4.o(function2);
        return Collector.CC.of(new Supplier() { // from class: nf0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableRangeMap.builder();
            }
        }, new BiConsumer() { // from class: of0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                k.H(function, function2, (ImmutableRangeMap.c) obj, obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: pf0
            public /* synthetic */ BiFunction andThen(Function function3) {
                return BiFunction$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableRangeMap.c) obj).b((ImmutableRangeMap.c) obj2);
            }
        }, new Function() { // from class: qf0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function3) {
                return Function$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableRangeMap.c) obj).a();
            }

            public /* synthetic */ Function compose(Function function3) {
                return Function$CC.$default$compose(this, function3);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> U() {
        return (Collector<Range<E>, ?, ImmutableRangeSet<E>>) c;
    }

    public static <E> Collector<E, ?, ImmutableSet<E>> V() {
        return (Collector<E, ?, ImmutableSet<E>>) b;
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> W(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        dm4.p(function, "keyFunction");
        dm4.p(function2, "valueFunction");
        return Collector.CC.of(new Supplier() { // from class: jf0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableSetMultimap.builder();
            }
        }, new BiConsumer() { // from class: kf0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                k.I(function, function2, (ImmutableSetMultimap.a) obj, obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: lf0
            public /* synthetic */ BiFunction andThen(Function function3) {
                return BiFunction$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSetMultimap.a) obj).l((ImmutableSetMultimap.a) obj2);
            }
        }, new Function() { // from class: mf0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function3) {
                return Function$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSetMultimap.a) obj).k();
            }

            public /* synthetic */ Function compose(Function function3) {
                return Function$CC.$default$compose(this, function3);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> X(final Comparator<? super K> comparator, final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        dm4.o(comparator);
        dm4.o(function);
        dm4.o(function2);
        return Collector.CC.of(new Supplier() { // from class: wf0
            @Override // java.util.function.Supplier
            public final Object get() {
                return k.K(comparator);
            }
        }, new BiConsumer() { // from class: xf0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                k.L(function, function2, (ImmutableSortedMap.b) obj, obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: yf0
            public /* synthetic */ BiFunction andThen(Function function3) {
                return BiFunction$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSortedMap.b) obj).p((ImmutableSortedMap.b) obj2);
            }
        }, new Function() { // from class: zf0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function3) {
                return Function$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSortedMap.b) obj).d();
            }

            public /* synthetic */ Function compose(Function function3) {
                return Function$CC.$default$compose(this, function3);
            }
        }, Collector.Characteristics.UNORDERED);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> Y(final Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        dm4.o(comparator);
        dm4.o(function);
        dm4.o(function2);
        dm4.o(binaryOperator);
        return Collectors.collectingAndThen(Collectors.toMap(function, function2, binaryOperator, new Supplier() { // from class: ke0
            @Override // java.util.function.Supplier
            public final Object get() {
                return k.J(comparator);
            }
        }), new Function() { // from class: ve0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function3) {
                return Function$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableSortedMap.copyOfSorted((TreeMap) obj);
            }

            public /* synthetic */ Function compose(Function function3) {
                return Function$CC.$default$compose(this, function3);
            }
        });
    }

    public static <E> Collector<E, ?, ImmutableSortedSet<E>> Z(final Comparator<? super E> comparator) {
        dm4.o(comparator);
        return Collector.CC.of(new Supplier() { // from class: fg0
            @Override // java.util.function.Supplier
            public final Object get() {
                return k.M(comparator);
            }
        }, new BiConsumer() { // from class: gg0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableSortedSet.a) obj).a(obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: hg0
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSortedSet.a) obj).p((ImmutableSortedSet.a) obj2);
            }
        }, new Function() { // from class: ig0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSortedSet.a) obj).e();
            }

            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> s(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2) {
        dm4.o(function);
        dm4.o(function2);
        Function function3 = new Function() { // from class: gf0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function4) {
                return Function$CC.$default$andThen(this, function4);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return k.v(function, obj);
            }

            public /* synthetic */ Function compose(Function function4) {
                return Function$CC.$default$compose(this, function4);
            }
        };
        Function function4 = new Function() { // from class: rf0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function5) {
                return Function$CC.$default$andThen(this, function5);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return k.w(function2, obj);
            }

            public /* synthetic */ Function compose(Function function5) {
                return Function$CC.$default$compose(this, function5);
            }
        };
        final v.f<Object, Object> fVarA = v.c().a();
        Objects.requireNonNull(fVarA);
        return Collectors.collectingAndThen(u(function3, function4, new Supplier() { // from class: cg0
            @Override // java.util.function.Supplier
            public final Object get() {
                return fVarA.g();
            }
        }), new Function() { // from class: ng0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function5) {
                return Function$CC.$default$andThen(this, function5);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableListMultimap.copyOf((ps3) obj);
            }

            public /* synthetic */ Function compose(Function function5) {
                return Function$CC.$default$compose(this, function5);
            }
        });
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> t(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2) {
        dm4.o(function);
        dm4.o(function2);
        Function function3 = new Function() { // from class: ef0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function4) {
                return Function$CC.$default$andThen(this, function4);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return k.x(function, obj);
            }

            public /* synthetic */ Function compose(Function function4) {
                return Function$CC.$default$compose(this, function4);
            }
        };
        Function function4 = new Function() { // from class: ff0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function5) {
                return Function$CC.$default$andThen(this, function5);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return k.y(function2, obj);
            }

            public /* synthetic */ Function compose(Function function5) {
                return Function$CC.$default$compose(this, function5);
            }
        };
        final v.h<Object, Object> hVarD = v.c().d();
        Objects.requireNonNull(hVarD);
        return Collectors.collectingAndThen(u(function3, function4, new Supplier() { // from class: hf0
            @Override // java.util.function.Supplier
            public final Object get() {
                return hVarD.g();
            }
        }), new Function() { // from class: if0
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function5) {
                return Function$CC.$default$andThen(this, function5);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableSetMultimap.copyOf((ps3) obj);
            }

            public /* synthetic */ Function compose(Function function5) {
                return Function$CC.$default$compose(this, function5);
            }
        });
    }

    public static <T, K, V, M extends ps3<K, V>> Collector<T, ?, M> u(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2, Supplier<M> supplier) {
        dm4.o(function);
        dm4.o(function2);
        dm4.o(supplier);
        return Collector.CC.of(supplier, new BiConsumer() { // from class: jg0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                k.z(function, function2, (ps3) obj, obj2);
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: kg0
            public /* synthetic */ BiFunction andThen(Function function3) {
                return BiFunction$CC.$default$andThen(this, function3);
            }

            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return k.A((ps3) obj, (ps3) obj2);
            }
        }, new Collector.Characteristics[0]);
    }

    public static /* synthetic */ Object v(Function function, Object obj) {
        return dm4.o(function.apply(obj));
    }

    public static /* synthetic */ Stream w(Function function, Object obj) {
        return ((Stream) function.apply(obj)).peek(new lg0());
    }

    public static /* synthetic */ Object x(Function function, Object obj) {
        return dm4.o(function.apply(obj));
    }

    public static /* synthetic */ Stream y(Function function, Object obj) {
        return ((Stream) function.apply(obj)).peek(new lg0());
    }

    public static /* synthetic */ void z(Function function, Function function2, ps3 ps3Var, Object obj) {
        final Collection collection = ps3Var.get(function.apply(obj));
        Stream stream = (Stream) function2.apply(obj);
        Objects.requireNonNull(collection);
        stream.forEachOrdered(new Consumer() { // from class: mg0
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                collection.add(obj2);
            }

            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
    }
}
