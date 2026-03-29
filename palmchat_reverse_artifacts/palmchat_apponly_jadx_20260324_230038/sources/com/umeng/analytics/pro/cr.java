package com.umeng.analytics.pro;

import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.cr;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class cr<T extends cr<?, ?>, F extends co> implements ch<T, F> {
    private static final Map<Class<? extends Cdo>, dp> c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Object f10911a;
    protected F b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends dq<cr> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, cr crVar) throws cn {
            crVar.b = null;
            crVar.f10911a = null;
            dgVar.j();
            db dbVarL = dgVar.l();
            Object objA = crVar.a(dgVar, dbVarL);
            crVar.f10911a = objA;
            if (objA != null) {
                crVar.b = (F) crVar.a(dbVarL.c);
            }
            dgVar.m();
            dgVar.l();
            dgVar.k();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, cr crVar) throws cn {
            if (crVar.a() == null || crVar.b() == null) {
                throw new dh("Cannot write a TUnion with no set value!");
            }
            dgVar.a(crVar.d());
            dgVar.a(crVar.c(crVar.b));
            crVar.a(dgVar);
            dgVar.c();
            dgVar.d();
            dgVar.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements dp {
        private b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends dr<cr> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, cr crVar) throws cn {
            crVar.b = null;
            crVar.f10911a = null;
            short sV = dgVar.v();
            Object objA = crVar.a(dgVar, sV);
            crVar.f10911a = objA;
            if (objA != null) {
                crVar.b = (F) crVar.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, cr crVar) throws cn {
            if (crVar.a() == null || crVar.b() == null) {
                throw new dh("Cannot write a TUnion with no set value!");
            }
            dgVar.a(crVar.b.a());
            crVar.b(dgVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements dp {
        private d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap map = new HashMap();
        c = map;
        map.put(dq.class, new b());
        map.put(dr.class, new d());
    }

    public cr() {
        this.b = null;
        this.f10911a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof ch ? ((ch) obj).deepCopy() : obj instanceof ByteBuffer ? ci.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    public abstract F a(short s);

    public abstract Object a(dg dgVar, db dbVar) throws cn;

    public abstract Object a(dg dgVar, short s) throws cn;

    public abstract void a(dg dgVar) throws cn;

    public Object b() {
        return this.f10911a;
    }

    public abstract void b(F f, Object obj) throws ClassCastException;

    public abstract void b(dg dgVar) throws cn;

    public abstract db c(F f);

    public boolean c() {
        return this.b != null;
    }

    @Override // com.umeng.analytics.pro.ch
    public final void clear() {
        this.b = null;
        this.f10911a = null;
    }

    public abstract dl d();

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        c.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object objB = b();
            sb.append(c(a()).f10926a);
            sb.append(":");
            if (objB instanceof ByteBuffer) {
                ci.a((ByteBuffer) objB, sb);
            } else {
                sb.append(objB.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        c.get(dgVar.D()).b().a(dgVar, this);
    }

    public boolean b(F f) {
        return this.b == f;
    }

    public boolean b(int i) {
        return b(a((short) i));
    }

    public cr(F f, Object obj) {
        a(f, obj);
    }

    public cr(cr<T, F> crVar) {
        if (crVar.getClass().equals(getClass())) {
            this.b = crVar.b;
            this.f10911a = a(crVar.f10911a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            map2.put(a(entry.getKey()), a(entry.getValue()));
        }
        return map2;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.b;
    }

    public Object a(F f) {
        if (f == this.b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.b);
    }

    public Object a(int i) {
        return a(a((short) i));
    }

    public void a(F f, Object obj) {
        b(f, obj);
        this.b = f;
        this.f10911a = obj;
    }

    public void a(int i, Object obj) {
        a(a((short) i), obj);
    }
}
