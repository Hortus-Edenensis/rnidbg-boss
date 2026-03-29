package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class hk0 implements zm5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<zm5> f17981a;
    public volatile boolean b;

    public static void c(Collection<zm5> collection) {
        if (collection == null) {
            return;
        }
        Iterator<zm5> it = collection.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                it.next().unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        yn1.c(arrayList);
    }

    public void a(zm5 zm5Var) {
        if (zm5Var.isUnsubscribed()) {
            return;
        }
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    if (this.f17981a == null) {
                        this.f17981a = new HashSet(4);
                    }
                    this.f17981a.add(zm5Var);
                    return;
                }
            }
        }
        zm5Var.unsubscribe();
    }

    public void b(zm5 zm5Var) {
        Set<zm5> set;
        if (this.b) {
            return;
        }
        synchronized (this) {
            if (!this.b && (set = this.f17981a) != null) {
                boolean zRemove = set.remove(zm5Var);
                if (zRemove) {
                    zm5Var.unsubscribe();
                }
            }
        }
    }

    @Override // defpackage.zm5
    public boolean isUnsubscribed() {
        return this.b;
    }

    @Override // defpackage.zm5
    public void unsubscribe() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            Set<zm5> set = this.f17981a;
            this.f17981a = null;
            c(set);
        }
    }
}
