package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class e<T extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f3729a;
    private final int b;
    private List<T> c;
    private List<e<T>> d;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a {
        public abstract Point getPoint();
    }

    public e(c cVar) {
        this(cVar, 0);
    }

    public void a(T t) {
        Point point = t.getPoint();
        if (this.f3729a.a(point.x, point.y)) {
            a(point.x, point.y, t);
        }
    }

    private e(double d, double d2, double d3, double d4, int i) {
        this(new c(d, d2, d3, d4), i);
    }

    private e(c cVar, int i) {
        this.d = null;
        this.f3729a = cVar;
        this.b = i;
    }

    private void a(double d, double d2, T t) {
        List<e<T>> list = this.d;
        if (list != null) {
            c cVar = this.f3729a;
            if (d2 < cVar.f) {
                if (d < cVar.e) {
                    list.get(0).a(d, d2, t);
                    return;
                } else {
                    list.get(1).a(d, d2, t);
                    return;
                }
            }
            if (d < cVar.e) {
                list.get(2).a(d, d2, t);
                return;
            } else {
                list.get(3).a(d, d2, t);
                return;
            }
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(t);
        if (this.c.size() <= 40 || this.b >= 40) {
            return;
        }
        a();
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.d = arrayList;
        c cVar = this.f3729a;
        arrayList.add(new e(cVar.f3728a, cVar.e, cVar.b, cVar.f, this.b + 1));
        List<e<T>> list = this.d;
        c cVar2 = this.f3729a;
        list.add(new e<>(cVar2.e, cVar2.c, cVar2.b, cVar2.f, this.b + 1));
        List<e<T>> list2 = this.d;
        c cVar3 = this.f3729a;
        list2.add(new e<>(cVar3.f3728a, cVar3.e, cVar3.f, cVar3.d, this.b + 1));
        List<e<T>> list3 = this.d;
        c cVar4 = this.f3729a;
        list3.add(new e<>(cVar4.e, cVar4.c, cVar4.f, cVar4.d, this.b + 1));
        List<T> list4 = this.c;
        this.c = null;
        Iterator<T> it = list4.iterator();
        while (it.hasNext()) {
            a(r7.getPoint().x, r7.getPoint().y, it.next());
        }
    }
}
