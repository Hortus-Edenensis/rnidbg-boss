package defpackage;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class fq0<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f17578a = new Object();

    @GuardedBy("lock")
    public final Map<E, Integer> b = new HashMap();

    @GuardedBy("lock")
    public Set<E> c = Collections.emptySet();

    @GuardedBy("lock")
    public List<E> d = Collections.emptyList();

    public void a(E e) {
        synchronized (this.f17578a) {
            ArrayList arrayList = new ArrayList(this.d);
            arrayList.add(e);
            this.d = Collections.unmodifiableList(arrayList);
            Integer num = this.b.get(e);
            if (num == null) {
                HashSet hashSet = new HashSet(this.c);
                hashSet.add(e);
                this.c = Collections.unmodifiableSet(hashSet);
            }
            this.b.put(e, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    public void b(E e) {
        synchronized (this.f17578a) {
            Integer num = this.b.get(e);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.d);
            arrayList.remove(e);
            this.d = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.b.remove(e);
                HashSet hashSet = new HashSet(this.c);
                hashSet.remove(e);
                this.c = Collections.unmodifiableSet(hashSet);
            } else {
                this.b.put(e, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public int count(E e) {
        int iIntValue;
        synchronized (this.f17578a) {
            iIntValue = this.b.containsKey(e) ? this.b.get(e).intValue() : 0;
        }
        return iIntValue;
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.f17578a) {
            set = this.c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.f17578a) {
            it = this.d.iterator();
        }
        return it;
    }
}
