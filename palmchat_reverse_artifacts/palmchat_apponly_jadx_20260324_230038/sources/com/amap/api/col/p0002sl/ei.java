package com.amap.api.col.p0002sl;

import com.amap.api.col.p0002sl.eh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class ei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2727a = true;
    private long b = 86400;
    private int c = 10;
    private long d = 0;
    private final LinkedHashMap<eh.b, Object> e = new LinkedHashMap<>();
    private final Object f = new Object();
    private final LinkedHashMap<eh.b, Object> g = new LinkedHashMap<>();
    private final Object h = new Object();
    private ArrayList<String> i = new ArrayList<>();

    public ei(String... strArr) {
        a(strArr);
    }

    private void a(String... strArr) {
        this.d = System.currentTimeMillis();
        this.e.clear();
        this.i.clear();
        for (String str : strArr) {
            if (str != null) {
                this.i.add(str);
            }
        }
    }

    public Object b(LinkedHashMap<eh.b, Object> linkedHashMap, eh.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.get(bVar);
    }

    public Object c(LinkedHashMap<eh.b, Object> linkedHashMap, eh.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }

    private void b(eh.b bVar, Object obj) {
        synchronized (this.f) {
            a();
            b();
            this.e.put(bVar, obj);
        }
    }

    public boolean a(LinkedHashMap<eh.b, Object> linkedHashMap, eh.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return false;
        }
        return linkedHashMap.containsKey(bVar);
    }

    private void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ((jCurrentTimeMillis - this.d) / 1000 > this.b) {
            this.e.clear();
            this.d = jCurrentTimeMillis;
        }
    }

    public final eh.c a(eh.b bVar) {
        if (!this.f2727a || bVar == null || !b(bVar)) {
            return null;
        }
        b();
        synchronized (this.f) {
            if (a(this.e, bVar)) {
                return new eh.c(b(this.e, bVar), true);
            }
            synchronized (this.h) {
                if (a(this.g, bVar)) {
                    while (!a(this.e, bVar) && a(this.g, bVar)) {
                        try {
                            this.h.wait(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    this.g.put(bVar, null);
                }
            }
            return new eh.c(b(this.e, bVar), false);
        }
    }

    public final boolean b(eh.b bVar) {
        if (bVar != null && bVar.f2725a != null) {
            for (String str : this.i) {
                if (str != null && bVar.f2725a.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(eh.b bVar, Object obj) {
        if (this.f2727a && bVar != null && b(bVar)) {
            b(bVar, obj);
            synchronized (this.h) {
                c(this.g, bVar);
                this.h.notify();
            }
        }
    }

    private void a() {
        eh.b next;
        int size = this.e.size();
        if (size <= 0 || size < this.c) {
            return;
        }
        Iterator<eh.b> it = this.e.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next != null) {
                    break;
                }
            }
        }
        c(this.e, next);
    }

    public void a(eh.a aVar) {
        if (aVar != null) {
            this.f2727a = aVar.a();
            this.b = aVar.b();
            this.c = aVar.c();
        }
    }
}
