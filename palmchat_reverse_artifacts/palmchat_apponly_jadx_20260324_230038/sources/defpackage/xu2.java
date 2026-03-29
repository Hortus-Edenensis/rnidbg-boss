package defpackage;

import cn.jiguang.sdk.impl.connect.IpPort;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class xu2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashSet<IpPort> f22054a = new LinkedHashSet<>();
    public LinkedHashSet<IpPort> b = new LinkedHashSet<>();
    public List<Boolean> c = new ArrayList();

    public static <T> T e(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        Iterator<T> it = collection.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        collection.remove(next);
        return next;
    }

    public boolean a(IpPort ipPort) {
        if (ipPort == null || !ipPort.isLegal()) {
            return false;
        }
        InetAddress inetAddress = ipPort.inetAddress;
        if (inetAddress instanceof Inet4Address) {
            return this.f22054a.add(ipPort);
        }
        if (inetAddress instanceof Inet6Address) {
            return this.b.add(ipPort);
        }
        return false;
    }

    public void b() {
        try {
            this.f22054a.clear();
            this.b.clear();
        } catch (Throwable unused) {
        }
    }

    public final IpPort c(boolean z, boolean z2) {
        LinkedHashSet<IpPort> linkedHashSet = z ? this.b : this.f22054a;
        LinkedHashSet<IpPort> linkedHashSet2 = z2 ? null : z ? this.f22054a : this.b;
        return (linkedHashSet2 == null || linkedHashSet2.isEmpty()) ? (IpPort) e(linkedHashSet) : (linkedHashSet == null || linkedHashSet.isEmpty()) ? (IpPort) e(linkedHashSet2) : f(z) ? (IpPort) e(linkedHashSet2) : (IpPort) e(linkedHashSet);
    }

    public IpPort d(int i) {
        k63.a("IpPool", "current ipv4List=" + this.f22054a + " ipv6List=" + this.b);
        IpPort ipPortC = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : c(true, false) : c(true, true) : c(false, true) : c(false, false);
        k63.a("IpPool", "get ipPort=" + ipPortC);
        if (ipPortC != null) {
            InetAddress inetAddress = ipPortC.inetAddress;
            if (inetAddress instanceof Inet4Address) {
                this.c.add(Boolean.FALSE);
            } else if (inetAddress instanceof Inet6Address) {
                this.c.add(Boolean.TRUE);
            }
        }
        return ipPortC;
    }

    public final boolean f(boolean z) {
        if (this.c.size() < 2) {
            return false;
        }
        for (int size = this.c.size() - 1; size >= this.c.size() - 2; size--) {
            if (this.c.get(size).booleanValue() != z) {
                return false;
            }
        }
        return true;
    }
}
