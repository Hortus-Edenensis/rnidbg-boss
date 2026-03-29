package com.baidu.bdhttpdns;

import android.util.LruCache;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3357a;
    private final LruCache<String, a> b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);
    private boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<String> f3358a;
        private ArrayList<String> b;
        private long c;
        private long d;

        public void a(long j) {
            this.c = j;
        }

        public ArrayList<String> b() {
            return this.f3358a;
        }

        public ArrayList<String> c() {
            return this.b;
        }

        public long d() {
            return this.c;
        }

        public long e() {
            return this.d;
        }

        public void a(ArrayList<String> arrayList) {
            this.f3358a = arrayList;
        }

        public void b(long j) {
            this.d = j;
        }

        public boolean a() {
            return e() + this.c < System.currentTimeMillis() / 1000;
        }

        public void b(ArrayList<String> arrayList) {
            this.b = arrayList;
        }
    }

    public h(String str, boolean z) {
        this.c = false;
        this.f3357a = str;
        this.c = z;
    }

    public a a(String str) {
        a aVar = this.b.get(str);
        if (aVar == null || !aVar.a() || !this.c) {
            return aVar;
        }
        this.b.remove(str);
        l.a("Remove expired entry from %s cache while reading, host(%s)", this.f3357a, str);
        return null;
    }

    public ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = this.b.snapshot().keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public void a() {
        this.b.evictAll();
        l.a("Clear %s cache", this.f3357a);
    }

    public void b(String str) {
        a aVarA = a(str);
        if (aVarA == null || !aVarA.a()) {
            return;
        }
        this.b.remove(str);
        l.a("Remove expired entry from %s cache, host(%s)", this.f3357a, str);
    }

    public void a(String str, a aVar) {
        ArrayList<String> arrayListB = aVar.b();
        ArrayList<String> arrayListC = aVar.c();
        if ((arrayListB == null || arrayListB.isEmpty()) && (arrayListC == null || arrayListC.isEmpty())) {
            return;
        }
        this.b.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.f3357a;
        objArr[1] = str;
        objArr[2] = arrayListB != null ? arrayListB.toString() : null;
        objArr[3] = arrayListC != null ? arrayListC.toString() : null;
        objArr[4] = Long.valueOf(aVar.d());
        l.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    public void a(boolean z) {
        this.c = z;
    }
}
