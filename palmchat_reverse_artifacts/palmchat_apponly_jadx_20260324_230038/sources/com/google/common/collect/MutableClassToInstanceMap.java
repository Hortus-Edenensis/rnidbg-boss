package com.google.common.collect;

import defpackage.dm4;
import defpackage.n12;
import defpackage.o12;
import defpackage.r12;
import defpackage.sm4;
import defpackage.x06;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class MutableClassToInstanceMap<B> extends n12<Class<? extends B>, B> implements Serializable {
    private final Map<Class<? extends B>, B> delegate;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends o12<Class<? extends B>, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f6127a;

        public a(Map.Entry entry) {
            this.f6127a = entry;
        }

        @Override // defpackage.p12
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<Class<? extends B>, B> delegate() {
            return this.f6127a;
        }

        @Override // defpackage.o12, java.util.Map.Entry
        public B setValue(B b) {
            MutableClassToInstanceMap.cast(getKey(), b);
            return (B) super.setValue(b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends r12<Map.Entry<Class<? extends B>, B>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends x06<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            public a(Iterator it) {
                super(it);
            }

            @Override // defpackage.x06
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> entry) {
                return MutableClassToInstanceMap.checkedEntry(entry);
            }
        }

        public b() {
        }

        @Override // defpackage.h12, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new a(delegate().iterator());
        }

        @Override // defpackage.h12, java.util.Collection
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // defpackage.h12, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // defpackage.r12, defpackage.h12, defpackage.p12
        public Set<Map.Entry<Class<? extends B>, B>> delegate() {
            return MutableClassToInstanceMap.this.delegate().entrySet();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<B> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<? extends B>, B> f6129a;

        public c(Map<Class<? extends B>, B> map) {
            this.f6129a = map;
        }

        public Object readResolve() {
            return MutableClassToInstanceMap.create(this.f6129a);
        }
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        this.delegate = (Map) dm4.o(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T cast(Class<T> cls, Object obj) {
        return (T) sm4.d(cls).cast(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <B> Map.Entry<Class<? extends B>, B> checkedEntry(Map.Entry<Class<? extends B>, B> entry) {
        return new a(entry);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new c(delegate());
    }

    @Override // defpackage.n12, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new b();
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return (T) cast(cls, get(cls));
    }

    @Override // defpackage.n12, java.util.Map
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            cast((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends B> T putInstance(Class<T> cls, T t) {
        return (T) cast(cls, put((Class<? extends T>) cls, t));
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }

    @Override // defpackage.n12, defpackage.p12
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    @Override // defpackage.n12, java.util.Map
    public B put(Class<? extends B> cls, B b2) {
        cast(cls, b2);
        return (B) super.put(cls, b2);
    }
}
