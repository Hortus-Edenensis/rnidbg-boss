package defpackage;

import android.content.Context;
import cn.jiguang.sdk.impl.connect.IpPort;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class wu2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<uu2> f21803a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<uu2> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(uu2 uu2Var, uu2 uu2Var2) {
            if (uu2Var.equals(uu2Var2)) {
                return 0;
            }
            int i = uu2Var.b;
            int i2 = uu2Var2.b;
            if (i > i2) {
                return -1;
            }
            if (i < i2) {
                return 1;
            }
            int i3 = uu2Var.e;
            int i4 = uu2Var2.e;
            if (i3 > i4) {
                return -1;
            }
            if (i3 < i4) {
                return 1;
            }
            long j = uu2Var.d;
            if (j != 0) {
                long j2 = uu2Var2.d;
                if (j2 != 0) {
                    if (j < j2) {
                        return -1;
                    }
                    if (j > j2) {
                        return 1;
                    }
                }
            }
            long j3 = uu2Var.c;
            if (j3 != 0) {
                long j4 = uu2Var2.c;
                if (j4 != 0) {
                    if (j3 > j4 + 180000) {
                        return -1;
                    }
                    if (j3 < j4 - 180000) {
                        return 1;
                    }
                }
            }
            return 0;
        }
    }

    public static LinkedHashSet<IpPort> a(Context context, LinkedHashSet<IpPort> linkedHashSet, long j) {
        if ((linkedHashSet != null ? linkedHashSet.size() : 0) == 0) {
            return new LinkedHashSet<>();
        }
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (IpPort ipPort : linkedHashSet) {
            if (ipPort.isLegal()) {
                zz2<String> zz2VarR = zz2.R(ipPort.toString());
                uu2 uu2VarA = uu2.a((String) lg5.c(context, zz2VarR));
                if (uu2VarA == null) {
                    uu2VarA = new uu2(ipPort);
                }
                if (z) {
                    uu2VarA.e = 1;
                    z = false;
                }
                if (j > 0) {
                    uu2VarA.c = j;
                    lg5.h(context, zz2VarR.a0(uu2VarA.b()));
                }
                linkedList.add(uu2VarA);
            }
        }
        LinkedList linkedListB = b(linkedList, f21803a);
        LinkedHashSet<IpPort> linkedHashSet2 = new LinkedHashSet<>();
        Iterator it = linkedListB.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((LinkedList) it.next()).iterator();
            while (it2.hasNext()) {
                linkedHashSet2.add(((uu2) it2.next()).f21290a);
            }
        }
        return linkedHashSet2;
    }

    public static <T> LinkedList<LinkedList<T>> b(Collection<T> collection, Comparator<T> comparator) {
        boolean z;
        int size = collection != null ? collection.size() : 0;
        if (size == 0) {
            return new LinkedList<>();
        }
        LinkedList<LinkedList<T>> linkedList = new LinkedList<>();
        if (size == 1) {
            linkedList.add(new LinkedList<>(collection));
            return linkedList;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (T t : collection) {
            for (int i = 0; i < linkedList.size(); i++) {
                LinkedList<T> linkedList2 = linkedList.get(i);
                int iCompare = comparator.compare(t, linkedList2.getFirst());
                if (iCompare == 0) {
                    linkedList2.add(secureRandom.nextInt(linkedList2.size() + 1), t);
                } else if (iCompare < 0) {
                    LinkedList<T> linkedList3 = new LinkedList<>();
                    linkedList3.add(t);
                    linkedList.add(i, linkedList3);
                }
                z = true;
            }
            z = false;
            if (!z) {
                LinkedList<T> linkedList4 = new LinkedList<>();
                linkedList4.add(t);
                linkedList.add(linkedList4);
            }
        }
        return linkedList;
    }

    public static void c(Context context, IpPort ipPort, int i, long j) {
        if (ipPort != null) {
            zz2<String> zz2VarR = zz2.R(ipPort.toString());
            uu2 uu2VarA = uu2.a((String) lg5.c(context, zz2VarR));
            if (uu2VarA == null) {
                uu2VarA = new uu2(ipPort);
            }
            uu2VarA.d = j;
            uu2VarA.b = i;
            lg5.h(context, zz2VarR.a0(uu2VarA.b()));
        }
    }
}
