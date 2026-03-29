package defpackage;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ry3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<ny3> f20623a = new ly3();

    public static int a(AtomicReferenceArray<ky3> atomicReferenceArray, Character ch) {
        return Collections.binarySearch(new aj(atomicReferenceArray), new my3(ch), f20623a);
    }

    public static void b(List<ky3> list) {
        HashSet hashSet = new HashSet(list.size());
        Iterator<ky3> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().a());
        }
        if (list.size() == hashSet.size()) {
            return;
        }
        throw new IllegalStateException("Duplicate edge detected in list of nodes supplied: " + list);
    }
}
