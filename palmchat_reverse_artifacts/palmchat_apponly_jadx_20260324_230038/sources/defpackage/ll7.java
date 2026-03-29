package defpackage;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.my.nr.u;
import j$.util.function.Function$CC;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ll7 {
    public static final PluginValueSet c = c(0).a();
    public static final Function<SparseArray<Object>, Object> d = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<Object> f19026a;
    public PluginValueSet b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements PluginValueSet {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<Object> f19027a;
        public PluginValueSet b;
        public int c;

        public final boolean a() {
            if (this.f19027a instanceof u) {
                return true;
            }
            PluginValueSet pluginValueSet = this.b;
            return pluginValueSet != null && (pluginValueSet.sparseArray() instanceof u);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.f19027a.get(i);
            if (obj == null) {
                PluginValueSet pluginValueSet = this.b;
                if (pluginValueSet != null) {
                    return (T[]) pluginValueSet.arrayValue(i, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        public final boolean b() {
            return kl7.b().a() >= 6803 && kl7.b().a() < 7000;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        public final boolean c(Object obj) {
            return b() ? (!(obj instanceof Supplier) || (obj instanceof Function) || (obj instanceof ValueSet)) ? false : true : (obj instanceof Supplier) && !(obj instanceof Function);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean containsKey(int i) {
            PluginValueSet pluginValueSet;
            int iIndexOfKey = this.f19027a.indexOfKey(i);
            return (iIndexOfKey >= 0 || (pluginValueSet = this.b) == null) ? iIndexOfKey >= 0 : pluginValueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public double doubleValue(int i) {
            PluginValueSet pluginValueSet;
            Object obj = this.f19027a.get(i);
            if (obj == null && (pluginValueSet = this.b) != null) {
                return pluginValueSet.doubleValue(i);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public Set<Integer> keys() {
            int size = this.f19027a.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.f19027a.keyAt(i)));
            }
            PluginValueSet pluginValueSet = this.b;
            if (pluginValueSet != null) {
                hashSet.addAll(pluginValueSet.keys());
            }
            this.c = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.f19027a.get(i);
            if (supplier == null) {
                PluginValueSet pluginValueSet = this.b;
                if (pluginValueSet != null) {
                    return (T) pluginValueSet.objectValue(i, cls);
                }
                return null;
            }
            if (c(supplier)) {
                supplier = (T) supplier.get();
            }
            if (cls.isInstance(supplier)) {
                return (T) supplier;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public void remove(int i) {
            this.f19027a.remove(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int size() {
            if (this.c < 0) {
                keys();
            }
            return this.c;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            if (kl7.b().a() < 6803 && a()) {
                return new u(this);
            }
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            PluginValueSet pluginValueSet = this.b;
            if (pluginValueSet != null && (sparseArray = pluginValueSet.sparseArray()) != null && sparseArray.size() > 0) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
            SparseArray<Object> sparseArray3 = this.f19027a;
            if (sparseArray3 != null && sparseArray3.size() > 0) {
                for (int i2 = 0; i2 < this.f19027a.size(); i2++) {
                    sparseArray2.put(this.f19027a.keyAt(i2), this.f19027a.valueAt(i2));
                }
            }
            return sparseArray2;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        public b(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
            this.c = -1;
            this.f19027a = sparseArray;
            this.b = pluginValueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i, boolean z) {
            PluginValueSet pluginValueSet;
            Object obj = this.f19027a.get(i);
            if (obj == null && (pluginValueSet = this.b) != null) {
                return pluginValueSet.booleanValue(i, z);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i, float f) {
            PluginValueSet pluginValueSet;
            Object obj = this.f19027a.get(i);
            if (obj == null && (pluginValueSet = this.b) != null) {
                return pluginValueSet.floatValue(i, f);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i, int i2) {
            PluginValueSet pluginValueSet;
            Object obj = this.f19027a.get(i);
            if (obj == null && (pluginValueSet = this.b) != null) {
                return pluginValueSet.intValue(i, i2);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i, long j) {
            PluginValueSet pluginValueSet;
            Object obj = this.f19027a.get(i);
            if (obj == null && (pluginValueSet = this.b) != null) {
                return pluginValueSet.longValue(i, j);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i, String str) {
            PluginValueSet pluginValueSet;
            Object obj = this.f19027a.get(i);
            if (obj == null && (pluginValueSet = this.b) != null) {
                return pluginValueSet.stringValue(i, str);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<T, R> implements Function<T, R> {
        @Override // java.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function$CC.$default$andThen(this, function);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(T t) {
            if (!(t instanceof SparseArray)) {
                return null;
            }
            Class cls = (Class) ((SparseArray) t).get(-99999985);
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (R) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (R) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (R) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (R) Double.valueOf(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (R) Float.valueOf(0.0f);
            }
            return null;
        }

        public /* synthetic */ Function compose(Function function) {
            return Function$CC.$default$compose(this, function);
        }

        public c() {
        }
    }

    public ll7(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
        this.f19026a = sparseArray;
        this.b = pluginValueSet;
    }

    public static final ll7 b() {
        return new ll7(new SparseArray());
    }

    public static final ll7 c(int i) {
        return new ll7(new SparseArray(i));
    }

    public static final ll7 j(SparseArray<Object> sparseArray) {
        return new ll7(sparseArray);
    }

    public static final ll7 k(PluginValueSet pluginValueSet) {
        return new ll7(new SparseArray(), pluginValueSet);
    }

    public PluginValueSet a() {
        return new b(this.f19026a, this.b);
    }

    public ll7 d(int i, double d2) {
        this.f19026a.put(i, Double.valueOf(d2));
        return this;
    }

    public ll7 e(int i, float f) {
        this.f19026a.put(i, Float.valueOf(f));
        return this;
    }

    public ll7 f(int i, int i2) {
        this.f19026a.put(i, Integer.valueOf(i2));
        return this;
    }

    public ll7 g(int i, Object obj) {
        this.f19026a.put(i, obj);
        return this;
    }

    public ll7 h(int i, String str) {
        this.f19026a.put(i, str);
        return this;
    }

    public ll7 i(int i, boolean z) {
        this.f19026a.put(i, Boolean.valueOf(z));
        return this;
    }

    public ll7(SparseArray<Object> sparseArray) {
        this.f19026a = sparseArray == null ? new SparseArray<>() : sparseArray;
    }
}
