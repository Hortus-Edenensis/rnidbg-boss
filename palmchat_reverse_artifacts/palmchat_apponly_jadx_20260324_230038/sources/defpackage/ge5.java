package defpackage;

import android.content.Context;
import cn.jiguang.sdk.impl.connect.IpPort;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ge5 implements Callable<je5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashSet<IpPort> f17716a = new LinkedHashSet<>();
    public ie5 b;

    public ge5(ie5 ie5Var) {
        this.b = ie5Var;
    }

    public final boolean a(IpPort ipPort, wk5 wk5Var, xu2 xu2Var) {
        if (wk5Var.i()) {
            return true;
        }
        if (ipPort != null && ipPort.isLegal() && !this.f17716a.contains(ipPort)) {
            mt0 mt0VarC = mt0.c();
            ie5 ie5Var = this.b;
            InetAddress[] inetAddressArrE = mt0VarC.e(ie5Var.b, ipPort.ip, 3000L, ie5Var.k());
            if (inetAddressArrE != null && inetAddressArrE.length != 0) {
                Iterator it = z86.h(Arrays.asList(inetAddressArrE)).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    InetAddress inetAddress = (InetAddress) it.next();
                    if (!wk5Var.i()) {
                        IpPort ipPort2 = new IpPort(inetAddress, ipPort.port);
                        if (!this.f17716a.contains(ipPort2) && xu2Var.a(ipPort2)) {
                            this.f17716a.add(ipPort2);
                            wk5Var.k(new me5(this.b, wk5Var, xu2Var));
                            break;
                        }
                    } else {
                        return true;
                    }
                }
                this.f17716a.add(ipPort);
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public je5 call() throws Exception {
        xu2 xu2Var = new xu2();
        wk5 wk5Var = new wk5(5, 2000, null, "ss");
        e(wk5Var, xu2Var);
        k63.a("Sis", "main sis: after host and last good, wait Result");
        Object objL = wk5Var.l(60000L);
        if (objL instanceof je5) {
            return (je5) objL;
        }
        d(wk5Var, xu2Var);
        k63.a("Sis", "main sis: after default and srv, wait Result");
        Object objL2 = wk5Var.l(60000L);
        wk5Var.j(false);
        if (objL2 instanceof je5) {
            return (je5) objL2;
        }
        return null;
    }

    public final LinkedHashSet<IpPort> c(Context context) {
        LinkedHashSet<IpPort> linkedHashSetString2Set = IpPort.string2Set((String) lg5.c(context, zz2.P()));
        return (linkedHashSetString2Set == null || linkedHashSetString2Set.isEmpty()) ? IpPort.map2Set(ui2.e()) : linkedHashSetString2Set;
    }

    public final void d(wk5 wk5Var, xu2 xu2Var) {
        LinkedHashSet<IpPort> linkedHashSetC = c(this.b.b);
        linkedHashSetC.removeAll(this.f17716a);
        LinkedList linkedListH = z86.h(linkedHashSetC);
        k63.a("Sis", "main sis: default sis" + linkedListH);
        Iterator it = linkedListH.iterator();
        while (it.hasNext()) {
            if (a((IpPort) it.next(), wk5Var, xu2Var)) {
                return;
            }
        }
        LinkedHashSet<IpPort> linkedHashSetD = f05.c().d(ui2.f(), 10000L);
        linkedListH.clear();
        if (linkedHashSetD != null) {
            linkedHashSetD.removeAll(this.f17716a);
            linkedListH = z86.h(linkedHashSetD);
        }
        k63.a("Sis", "main sis: sis srv" + linkedListH);
        Iterator it2 = linkedListH.iterator();
        while (it2.hasNext() && !a((IpPort) it2.next(), wk5Var, xu2Var)) {
        }
    }

    public final void e(wk5 wk5Var, xu2 xu2Var) {
        LinkedHashSet<IpPort> linkedHashSetMap2Set = IpPort.map2Set(ui2.d());
        linkedHashSetMap2Set.removeAll(this.f17716a);
        LinkedList linkedListH = z86.h(linkedHashSetMap2Set);
        k63.a("Sis", "main sis: sis host=" + linkedListH);
        Iterator it = linkedListH.iterator();
        while (it.hasNext()) {
            if (a((IpPort) it.next(), wk5Var, xu2Var)) {
                return;
            }
        }
        IpPort ipPortFromString = IpPort.fromString((String) lg5.c(this.b.b, zz2.W(true)));
        k63.a("Sis", "main sis: last good sis v4 address=" + ipPortFromString);
        if (a(ipPortFromString, wk5Var, xu2Var)) {
            return;
        }
        IpPort ipPortFromString2 = IpPort.fromString((String) lg5.c(this.b.b, zz2.W(false)));
        k63.a("Sis", "main sis: last good sis v6 address=" + ipPortFromString2);
        a(ipPortFromString2, wk5Var, xu2Var);
    }
}
