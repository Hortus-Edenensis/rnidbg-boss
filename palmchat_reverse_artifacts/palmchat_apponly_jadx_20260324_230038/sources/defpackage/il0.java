package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.cdo.oaps.ad.Launcher;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003\u0012#\u000fB\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\b\u0010\b\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\nR\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR&\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001b¨\u0006$"}, d2 = {"Lil0;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/AbstractMutableMap;", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", ActionUtils.PAYMENT_AMOUNT, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "clear", "()V", "c", "d", "Ljava/lang/ref/ReferenceQueue;", "a", "Ljava/lang/ref/ReferenceQueue;", "weakRefQueue", "", "getSize", "()I", "size", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getEntries", "entries", "", "<init>", "(Z)V", t.l, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class il0<K, V> extends AbstractMutableMap<K, V> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(il0.class, "_size");
    private volatile /* synthetic */ int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ReferenceQueue<K> weakRefQueue;
    volatile /* synthetic */ Object core;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0013¢\u0006\u0004\b \u0010!J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004J3\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u0010\"\u0004\b\u0002\u0010\r2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001c¨\u0006\""}, d2 = {"Lil0$a;", "", "key", t.l, "(Ljava/lang/Object;)Ljava/lang/Object;", ActionUtils.PAYMENT_AMOUNT, "Lsg2;", "weakKey0", "e", "(Ljava/lang/Object;Ljava/lang/Object;Lsg2;)Ljava/lang/Object;", "Lil0;", "g", "()Lil0$a;", ExifInterface.LONGITUDE_EAST, "Lkotlin/Function2;", "factory", "", "d", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "", "hash", "c", "(I)I", "index", "", "h", "(I)V", "a", "I", "allocated", "shift", "threshold", "<init>", "(Lil0;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public final class a {
        public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int allocated;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final int shift;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final int threshold;
        public /* synthetic */ AtomicReferenceArray d;
        public /* synthetic */ AtomicReferenceArray e;
        private volatile /* synthetic */ int load = 0;

        /* JADX INFO: renamed from: il0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\u0010\u0010\u0005\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0002R&\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010\u0013\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00028\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lil0$a$a;", ExifInterface.LONGITUDE_EAST, "", "", "hasNext", "next", "()Ljava/lang/Object;", "", t.l, "", "a", "Lkotlin/Function2;", "Lkotlin/jvm/functions/Function2;", "factory", "", "I", "index", "c", "Ljava/lang/Object;", "key", "d", ActionUtils.PAYMENT_AMOUNT, "<init>", "(Lil0$a;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
        public final class C1210a<E> implements Iterator<E>, KMutableIterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final Function2<K, V, E> factory;

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public int index = -1;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            public K key;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata */
            public V value;

            /* JADX WARN: Multi-variable type inference failed */
            public C1210a(Function2<? super K, ? super V, ? extends E> function2) {
                this.factory = function2;
                a();
            }

            public final void a() {
                K k;
                while (true) {
                    int i = this.index + 1;
                    this.index = i;
                    if (i >= a.this.allocated) {
                        return;
                    }
                    sg2 sg2Var = (sg2) a.this.d.get(this.index);
                    if (sg2Var != null && (k = (K) sg2Var.get()) != null) {
                        this.key = k;
                        Object obj = (V) a.this.e.get(this.index);
                        if (obj instanceof cd3) {
                            obj = (V) ((cd3) obj).com.cdo.oaps.ad.OapsKey.KEY_REF java.lang.String;
                        }
                        if (obj != null) {
                            this.value = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                jl0.e();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < a.this.allocated;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.index >= a.this.allocated) {
                    throw new NoSuchElementException();
                }
                Function2<K, V, E> function2 = this.factory;
                K k = this.key;
                if (k == false) {
                    Intrinsics.throwUninitializedPropertyAccessException("key");
                    k = (K) Unit.INSTANCE;
                }
                V v = this.value;
                if (v == false) {
                    Intrinsics.throwUninitializedPropertyAccessException(ActionUtils.PAYMENT_AMOUNT);
                    v = (V) Unit.INSTANCE;
                }
                E e = (E) function2.mo5invoke(k, v);
                a();
                return e;
            }
        }

        public a(int i) {
            this.allocated = i;
            this.shift = Integer.numberOfLeadingZeros(i) + 1;
            this.threshold = (i * 2) / 3;
            this.d = new AtomicReferenceArray(i);
            this.e = new AtomicReferenceArray(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object f(a aVar, Object obj, Object obj2, sg2 sg2Var, int i, Object obj3) {
            if ((i & 4) != 0) {
                sg2Var = null;
            }
            return aVar.e(obj, obj2, sg2Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final V b(K key) {
            int iC = c(key.hashCode());
            while (true) {
                sg2 sg2Var = (sg2) this.d.get(iC);
                if (sg2Var == null) {
                    return null;
                }
                T t = sg2Var.get();
                if (Intrinsics.areEqual(key, t)) {
                    V v = (V) this.e.get(iC);
                    return v instanceof cd3 ? (V) ((cd3) v).com.cdo.oaps.ad.OapsKey.KEY_REF java.lang.String : v;
                }
                if (t == 0) {
                    h(iC);
                }
                if (iC == 0) {
                    iC = this.allocated;
                }
                iC--;
            }
        }

        public final int c(int hash) {
            return (hash * (-1640531527)) >>> this.shift;
        }

        public final <E> Iterator<E> d(Function2<? super K, ? super V, ? extends E> factory) {
            return new C1210a(factory);
        }

        public final Object e(K key, V value, sg2<K> weakKey0) {
            int i;
            Object obj;
            int iC = c(key.hashCode());
            boolean z = false;
            while (true) {
                sg2 sg2Var = (sg2) this.d.get(iC);
                if (sg2Var != null) {
                    T t = sg2Var.get();
                    if (!Intrinsics.areEqual(key, t)) {
                        if (t == 0) {
                            h(iC);
                        }
                        if (iC == 0) {
                            iC = this.allocated;
                        }
                        iC--;
                    } else if (z) {
                        g.decrementAndGet(this);
                    }
                } else if (value != null) {
                    if (!z) {
                        do {
                            i = this.load;
                            if (i >= this.threshold) {
                                return jl0.f18430a;
                            }
                        } while (!g.compareAndSet(this, i, i + 1));
                        z = true;
                    }
                    if (weakKey0 == null) {
                        weakKey0 = new sg2<>(key, il0.this.weakRefQueue);
                    }
                    if (hl0.a(this.d, iC, null, weakKey0)) {
                        break;
                    }
                } else {
                    return null;
                }
            }
            do {
                obj = this.e.get(iC);
                if (obj instanceof cd3) {
                    return jl0.f18430a;
                }
            } while (!hl0.a(this.e, iC, obj, value));
            return obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final il0<K, V>.a g() {
            int i;
            Object obj;
            while (true) {
                il0<K, V>.a aVar = (il0<K, V>.a) il0.this.new a(Integer.highestOneBit(RangesKt___RangesKt.coerceAtLeast(il0.this.size(), 4)) * 4);
                int i2 = this.allocated;
                while (i < i2) {
                    sg2 sg2Var = (sg2) this.d.get(i);
                    Object obj2 = sg2Var != null ? sg2Var.get() : null;
                    if (sg2Var != null && obj2 == null) {
                        h(i);
                    }
                    while (true) {
                        obj = this.e.get(i);
                        if (obj instanceof cd3) {
                            obj = ((cd3) obj).com.cdo.oaps.ad.OapsKey.KEY_REF java.lang.String;
                            break;
                        }
                        if (hl0.a(this.e, i, obj, jl0.d(obj))) {
                            break;
                        }
                    }
                    i = (obj2 == null || obj == null || aVar.e(obj2, obj, sg2Var) != jl0.f18430a) ? i + 1 : 0;
                }
                return aVar;
            }
        }

        public final void h(int index) {
            Object obj;
            do {
                obj = this.e.get(index);
                if (obj == null || (obj instanceof cd3)) {
                    return;
                }
            } while (!hl0.a(this.e, index, obj, null));
            il0.this.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u000b\u001a\u00028\u0002\u0012\u0006\u0010\u000e\u001a\u00028\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00028\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\u00028\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lil0$b;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "a", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "key", t.l, "getValue", ActionUtils.PAYMENT_AMOUNT, "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class b<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final K key;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final V value;

        public b(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            jl0.e();
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0096\u0002R&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lil0$c;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableSet;", "element", "", "add", "(Ljava/lang/Object;)Z", "", "iterator", "Lkotlin/Function2;", "a", "Lkotlin/jvm/functions/Function2;", "factory", "", "getSize", "()I", "size", "<init>", "(Lil0;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public final class c<E> extends AbstractMutableSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Function2<K, V, E> factory;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super K, ? super V, ? extends E> function2) {
            this.factory = function2;
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E element) {
            jl0.e();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return il0.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return ((a) il0.this.core).d(this.factory);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010'\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, t.f7496a, "v", "", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function2<K, V, Map.Entry<K, V>> {
        public static final d b = new d();

        public d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map.Entry<K, V> mo5invoke(K k, V v) {
            return new b(k, v);
        }
    }

    public il0() {
        this(false, 1, null);
    }

    public final void c() {
        b.decrementAndGet(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final synchronized V d(K key, V value) {
        V v;
        a aVarG = (a) this.core;
        while (true) {
            v = (V) a.f(aVarG, key, value, null, 4, null);
            if (v == jl0.f18430a) {
                aVarG = aVarG.g();
                this.core = aVarG;
            }
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        if (key == null) {
            return null;
        }
        return (V) ((a) this.core).b(key);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> getEntries() {
        return new c(d.b);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> getKeys() {
        return new c(e.b);
    }

    @Override // kotlin.collections.AbstractMutableMap
    /* JADX INFO: renamed from: getSize, reason: from getter */
    public int get_size() {
        return this._size;
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        V vD = (V) a.f((a) this.core, key, value, null, 4, null);
        if (vD == jl0.f18430a) {
            vD = d(key, value);
        }
        if (vD == null) {
            b.incrementAndGet(this);
        }
        return vD;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        if (key == 0) {
            return null;
        }
        V vD = (V) a.f((a) this.core, key, null, null, 4, null);
        if (vD == jl0.f18430a) {
            vD = d(key, null);
        }
        if (vD != null) {
            b.decrementAndGet(this);
        }
        return vD;
    }

    public /* synthetic */ il0(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public il0(boolean z) {
        this._size = 0;
        this.core = new a(16);
        this.weakRefQueue = z ? new ReferenceQueue<>() : null;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0005\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, t.f7496a, "<anonymous parameter 1>", Launcher.Method.INVOKE_CALLBACK, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class e extends Lambda implements Function2<K, V, K> {
        public static final e b = new e();

        public e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final K mo5invoke(K k, V v) {
            return k;
        }
    }
}
