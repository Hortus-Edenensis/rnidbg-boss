package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class qp3 {
    public static volatile qp3 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentMap<a, Integer> f20286a = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str, Object obj);
    }

    public static qp3 a() {
        if (b != null) {
            return b;
        }
        b = new qp3();
        return b;
    }

    public void b(String str, Object obj) {
        Iterator<a> it = this.f20286a.keySet().iterator();
        while (it.hasNext()) {
            it.next().a(str, obj);
        }
    }

    public void c(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f20286a.putIfAbsent(aVar, 0);
    }

    public void d(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f20286a.remove(aVar);
    }
}
