package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class bn5 implements zm5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<zm5> f1785a;
    public volatile boolean b;

    public bn5() {
    }

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
                    List linkedList = this.f1785a;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.f1785a = linkedList;
                    }
                    linkedList.add(zm5Var);
                    return;
                }
            }
        }
        zm5Var.unsubscribe();
    }

    public void b(zm5 zm5Var) {
        if (this.b) {
            return;
        }
        synchronized (this) {
            List<zm5> list = this.f1785a;
            if (!this.b && list != null) {
                boolean zRemove = list.remove(zm5Var);
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
            List<zm5> list = this.f1785a;
            this.f1785a = null;
            c(list);
        }
    }

    public bn5(zm5... zm5VarArr) {
        this.f1785a = new LinkedList(Arrays.asList(zm5VarArr));
    }

    public bn5(zm5 zm5Var) {
        LinkedList linkedList = new LinkedList();
        this.f1785a = linkedList;
        linkedList.add(zm5Var);
    }
}
