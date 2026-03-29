package com.heytap.nearx.protobuff.wire;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class e<E> {
    public static final e<Boolean> c;
    public static final e<Integer> d;
    public static final e<Integer> e;
    public static final e<Integer> f;
    public static final e<Integer> g;
    public static final e<Integer> h;
    public static final e<Long> i;
    public static final e<Long> j;
    public static final e<Long> k;
    public static final e<Long> l;
    public static final e<Long> m;
    public static final e<Float> n;
    public static final e<Double> o;
    public static final e<String> p;
    public static final e<ByteString> q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Class<?> f6424a;
    e<List<E>> b;
    private final com.heytap.nearx.protobuff.wire.a r;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends IllegalArgumentException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6425a;

        public a(int i, Class<?> cls) {
            super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
            this.f6425a = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b<K, V> extends e<Map.Entry<K, V>> {
        final e<K> r;
        final e<V> s;

        public b(e<K> eVar, e<V> eVar2) {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, null);
            this.r = eVar;
            this.s = eVar2;
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(f fVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(Map.Entry<K, V> entry) {
            return this.r.a(1, entry.getKey()) + this.s.a(2, entry.getValue());
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(g gVar, Map.Entry<K, V> entry) throws IOException {
            this.r.a(gVar, 1, entry.getKey());
            this.s.a(gVar, 2, entry.getValue());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<K, V> extends e<Map<K, V>> {
        private final b<K, V> r;

        public c(e<K> eVar, e<V> eVar2) {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, null);
            this.r = new b<>(eVar, eVar2);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<K, V> a(f fVar) throws IOException {
            long jA = fVar.a();
            K kA = null;
            V vA = null;
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    break;
                }
                if (iB == 1) {
                    kA = this.r.r.a(fVar);
                } else if (iB == 2) {
                    vA = this.r.s.a(fVar);
                }
            }
            fVar.a(jA);
            if (kA == null) {
                throw new IllegalStateException("Map entry with null key");
            }
            if (vA != null) {
                return Collections.singletonMap(kA, vA);
            }
            throw new IllegalStateException("Map entry with null value");
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(int i, Map<K, V> map) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            int iA = 0;
            while (it.hasNext()) {
                iA += this.r.a(i, it.next());
            }
            return iA;
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(g gVar, int i, Map<K, V> map) throws IOException {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                this.r.a(gVar, i, it.next());
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(g gVar, Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }
    }

    static {
        com.heytap.nearx.protobuff.wire.a aVar = com.heytap.nearx.protobuff.wire.a.VARINT;
        c = new e<Boolean>(aVar, Boolean.class) { // from class: com.heytap.nearx.protobuff.wire.e.1
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Boolean bool) {
                return 1;
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a(f fVar) throws IOException {
                int iF = fVar.f();
                if (iF == 0) {
                    return Boolean.FALSE;
                }
                if (iF == 1) {
                    return Boolean.TRUE;
                }
                throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(iF)));
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Boolean bool) throws IOException {
                gVar.g(bool.booleanValue() ? 1 : 0);
            }
        };
        Class<Integer> cls = Integer.class;
        d = new e<Integer>(aVar, cls) { // from class: com.heytap.nearx.protobuff.wire.e.7
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Integer num) {
                return g.b(num.intValue());
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Integer a(f fVar) throws IOException {
                return Integer.valueOf(fVar.f());
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Integer num) throws IOException {
                gVar.f(num.intValue());
            }
        };
        e = new e<Integer>(aVar, cls) { // from class: com.heytap.nearx.protobuff.wire.e.8
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Integer num) {
                return g.c(num.intValue());
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Integer a(f fVar) throws IOException {
                return Integer.valueOf(fVar.f());
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Integer num) throws IOException {
                gVar.g(num.intValue());
            }
        };
        f = new e<Integer>(aVar, cls) { // from class: com.heytap.nearx.protobuff.wire.e.9
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Integer num) {
                return g.c(g.d(num.intValue()));
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Integer a(f fVar) throws IOException {
                return Integer.valueOf(g.e(fVar.f()));
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Integer num) throws IOException {
                gVar.g(g.d(num.intValue()));
            }
        };
        com.heytap.nearx.protobuff.wire.a aVar2 = com.heytap.nearx.protobuff.wire.a.FIXED32;
        e<Integer> eVar = new e<Integer>(aVar2, cls) { // from class: com.heytap.nearx.protobuff.wire.e.10
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Integer num) {
                return 4;
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Integer a(f fVar) throws IOException {
                return Integer.valueOf(fVar.h());
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Integer num) throws IOException {
                gVar.h(num.intValue());
            }
        };
        g = eVar;
        h = eVar;
        Class<Long> cls2 = Long.class;
        i = new e<Long>(aVar, cls2) { // from class: com.heytap.nearx.protobuff.wire.e.11
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Long l2) {
                return g.a(l2.longValue());
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(fVar.g());
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.d(l2.longValue());
            }
        };
        j = new e<Long>(aVar, cls2) { // from class: com.heytap.nearx.protobuff.wire.e.12
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Long l2) {
                return g.a(l2.longValue());
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(fVar.g());
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.d(l2.longValue());
            }
        };
        k = new e<Long>(aVar, cls2) { // from class: com.heytap.nearx.protobuff.wire.e.13
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Long l2) {
                return g.a(g.b(l2.longValue()));
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(g.c(fVar.g()));
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.d(g.b(l2.longValue()));
            }
        };
        com.heytap.nearx.protobuff.wire.a aVar3 = com.heytap.nearx.protobuff.wire.a.FIXED64;
        e<Long> eVar2 = new e<Long>(aVar3, cls2) { // from class: com.heytap.nearx.protobuff.wire.e.14
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Long l2) {
                return 8;
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(fVar.i());
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.e(l2.longValue());
            }
        };
        l = eVar2;
        m = eVar2;
        n = new e<Float>(aVar2, Float.class) { // from class: com.heytap.nearx.protobuff.wire.e.2
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Float f2) {
                return 4;
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Float a(f fVar) throws IOException {
                return Float.valueOf(Float.intBitsToFloat(fVar.h()));
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Float f2) throws IOException {
                gVar.h(Float.floatToIntBits(f2.floatValue()));
            }
        };
        o = new e<Double>(aVar3, Double.class) { // from class: com.heytap.nearx.protobuff.wire.e.3
            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(Double d2) {
                return 8;
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Double a(f fVar) throws IOException {
                return Double.valueOf(Double.longBitsToDouble(fVar.i()));
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, Double d2) throws IOException {
                gVar.e(Double.doubleToLongBits(d2.doubleValue()));
            }
        };
        com.heytap.nearx.protobuff.wire.a aVar4 = com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED;
        p = new e<String>(aVar4, String.class) { // from class: com.heytap.nearx.protobuff.wire.e.4
            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public String a(f fVar) throws IOException {
                return fVar.e();
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(String str) {
                return g.a(str);
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, String str) throws IOException {
                gVar.b(str);
            }
        };
        q = new e<ByteString>(aVar4, ByteString.class) { // from class: com.heytap.nearx.protobuff.wire.e.5
            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ByteString a(f fVar) throws IOException {
                return fVar.d();
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(ByteString byteString) {
                return byteString.size();
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, ByteString byteString) throws IOException {
                gVar.a(byteString);
            }
        };
    }

    public e(com.heytap.nearx.protobuff.wire.a aVar, Class<?> cls) {
        this.r = aVar;
        this.f6424a = cls;
    }

    private e<List<E>> b() {
        return new e<List<E>>(this.r, List.class) { // from class: com.heytap.nearx.protobuff.wire.e.6
            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public List<E> a(f fVar) throws IOException {
                return Collections.singletonList(e.this.a(fVar));
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(int i2, List<E> list) {
                int size = list.size();
                int iA = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    iA += e.this.a(i2, list.get(i3));
                }
                return iA;
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, int i2, List<E> list) throws IOException {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    e.this.a(gVar, i2, list.get(i3));
                }
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(g gVar, List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }
        };
    }

    public int a(int i2, E e2) {
        int iA = a(e2);
        if (this.r == com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED) {
            iA += g.c(iA);
        }
        return iA + g.a(i2);
    }

    public abstract int a(E e2);

    public abstract E a(f fVar) throws IOException;

    public abstract void a(g gVar, E e2) throws IOException;

    public String c(E e2) {
        return e2.toString();
    }

    public static <M> e<M> b(Class<M> cls) {
        try {
            return (e) cls.getField("ADAPTER").get(null);
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e2);
        }
    }

    public final e<List<E>> a() {
        e<List<E>> eVar = this.b;
        if (eVar != null) {
            return eVar;
        }
        e<List<E>> eVarB = b();
        this.b = eVarB;
        return eVarB;
    }

    public static <K, V> e<Map<K, V>> a(e<K> eVar, e<V> eVar2) {
        return new c(eVar, eVar2);
    }

    public final byte[] b(E e2) {
        d.a(e2, "value == null");
        Buffer buffer = new Buffer();
        try {
            a(buffer, e2);
            return buffer.readByteArray();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public static <E extends i> h<E> a(Class<E> cls) {
        return new h<>(cls);
    }

    public final E a(InputStream inputStream) throws IOException {
        d.a(inputStream, "stream == null");
        return a(Okio.buffer(Okio.source(inputStream)));
    }

    public final E a(BufferedSource bufferedSource) throws IOException {
        d.a(bufferedSource, "source == null");
        return a(new f(bufferedSource));
    }

    public final E a(byte[] bArr) throws IOException {
        d.a(bArr, "bytes == null");
        return a((BufferedSource) new Buffer().write(bArr));
    }

    public void a(g gVar, int i2, E e2) throws IOException {
        gVar.a(i2, this.r);
        if (this.r == com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED) {
            gVar.g(a(e2));
        }
        a(gVar, e2);
    }

    public final void a(BufferedSink bufferedSink, E e2) throws IOException {
        d.a(e2, "value == null");
        d.a(bufferedSink, "sink == null");
        a(new g(bufferedSink), e2);
    }
}
