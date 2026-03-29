package defpackage;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.transformer.ExportException;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.sdk.impl.connect.IpPort;
import cn.jiguang.sdk.impl.helper.JException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class he5 {
    public ie5 b;
    public ix3 c;
    public me5 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashSet<IpPort> f17942a = new LinkedHashSet<>();
    public wk5 d = new wk5(5, 2000, null, "ssn");
    public xu2 e = new xu2();

    public he5(ie5 ie5Var) {
        this.b = ie5Var;
    }

    public static boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        k63.a("SisConn", "newType=" + str + " last=" + ((String) lg5.c(context, zz2.i())));
        return !str.equalsIgnoreCase(r3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
    
        r11.f17942a.add(r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(IpPort ipPort) {
        if (this.c.d) {
            this.d.g(new JException(-991, null));
            return true;
        }
        if (this.d.i()) {
            return true;
        }
        if (ipPort != null && ipPort.isLegal() && !this.f17942a.contains(ipPort)) {
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
                    if (!this.c.d) {
                        if (!this.d.i()) {
                            IpPort ipPort2 = new IpPort(inetAddress, ipPort.port);
                            if (!this.f17942a.contains(ipPort2) && this.e.a(ipPort2)) {
                                this.f17942a.add(ipPort2);
                                wk5 wk5Var = this.d;
                                wk5Var.k(new hm0(this.b, wk5Var, this.e, this.c));
                                break;
                            }
                        } else {
                            return true;
                        }
                    } else {
                        this.d.g(new JException(-991, null));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean c() {
        return (b(this.b.b, cu5.a(this.b.b)) || z86.e(((Long) lg5.c(this.b.b, zz2.d0())).longValue(), 180000L)) ? false : true;
    }

    public final LinkedHashSet<IpPort> d() {
        LinkedList linkedListH;
        try {
            String strB = ui2.b(this.b.b);
            k63.a("SisConn", "load Default Conn, from host=" + strB);
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            mt0 mt0VarC = mt0.c();
            ie5 ie5Var = this.b;
            InetAddress[] inetAddressArrE = mt0VarC.e(ie5Var.b, strB, 3000L, ie5Var.k());
            if (inetAddressArrE != null && inetAddressArrE.length != 0 && (linkedListH = z86.h(Arrays.asList(inetAddressArrE))) != null && !linkedListH.isEmpty()) {
                String hostAddress = ((InetAddress) linkedListH.get(0)).getHostAddress();
                LinkedHashSet<IpPort> linkedHashSet = new LinkedHashSet<>();
                linkedHashSet.add(new IpPort(hostAddress, 7000));
                linkedHashSet.add(new IpPort(hostAddress, ExportException.ERROR_CODE_MUXING_TIMEOUT));
                linkedHashSet.add(new IpPort(hostAddress, ExportException.ERROR_CODE_MUXING_APPEND));
                linkedHashSet.add(new IpPort(hostAddress, 7004));
                linkedHashSet.add(new IpPort(hostAddress, 7005));
                linkedHashSet.add(new IpPort(hostAddress, 7006));
                linkedHashSet.add(new IpPort(hostAddress, 7007));
                linkedHashSet.add(new IpPort(hostAddress, 7008));
                linkedHashSet.add(new IpPort(hostAddress, 7009));
                return linkedHashSet;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void e() {
        IpPort ipPortFromString = IpPort.fromString((String) lg5.c(this.b.b, zz2.V(true)));
        k63.a("SisConn", "connect: use last good v4 address=" + ipPortFromString);
        if (a(ipPortFromString)) {
            return;
        }
        IpPort ipPortFromString2 = IpPort.fromString((String) lg5.c(this.b.b, zz2.V(false)));
        k63.a("SisConn", "connect: use last good v6 address=" + ipPortFromString2);
        if (a(ipPortFromString2)) {
            return;
        }
        LinkedHashSet<IpPort> linkedHashSetD = d();
        if (linkedHashSetD != null) {
            linkedHashSetD.removeAll(this.f17942a);
        }
        LinkedList linkedListH = z86.h(linkedHashSetD);
        k63.a("SisConn", "connect: use defaultConn=" + linkedListH);
        Iterator it = linkedListH.iterator();
        while (it.hasNext()) {
            if (a((IpPort) it.next())) {
                return;
            }
        }
        LinkedHashSet<IpPort> linkedHashSetD2 = f05.c().d(ui2.c(this.b.b), 10000L);
        linkedListH.clear();
        if (linkedHashSetD2 != null) {
            linkedHashSetD2.removeAll(this.f17942a);
            linkedListH = z86.h(linkedHashSetD2);
        }
        k63.a("SisConn", "connect: use srv address" + linkedListH);
        Iterator it2 = linkedListH.iterator();
        while (it2.hasNext() && !a((IpPort) it2.next())) {
        }
    }

    public final void f(LinkedHashSet<IpPort> linkedHashSet, long j) {
        InetAddress[] inetAddressArrE;
        this.e.b();
        this.d.e();
        linkedHashSet.removeAll(this.f17942a);
        LinkedHashSet<IpPort> linkedHashSetA = wu2.a(this.b.b, linkedHashSet, System.currentTimeMillis());
        k63.a("SisConn", "connect: new sis info=" + linkedHashSetA);
        if (linkedHashSetA.isEmpty()) {
            return;
        }
        for (IpPort ipPort : linkedHashSetA) {
            if (SystemClock.uptimeMillis() >= j || a(ipPort)) {
                return;
            }
        }
        k63.a("SisConn", "after connect use new sis, wait connect Result");
        long jUptimeMillis = j - SystemClock.uptimeMillis();
        if (jUptimeMillis > 0 && this.d.l(jUptimeMillis) == null && this.f == null) {
            HashSet hashSet = new HashSet();
            for (IpPort ipPort2 : linkedHashSetA) {
                if (this.f17942a.contains(ipPort2)) {
                    hashSet.add(ipPort2.ip);
                }
            }
            int iH = this.b.h();
            IpPort ipPortFromString = IpPort.fromString((String) lg5.c(this.b.b, zz2.W(iH == 1 || iH == 0)));
            if (ipPortFromString == null || (inetAddressArrE = mt0.c().e(this.b.b, ipPortFromString.ip, 3000L, false)) == null || inetAddressArrE.length <= 0) {
                return;
            }
            ipPortFromString.inetAddress = inetAddressArrE[0];
            long jUptimeMillis2 = j - SystemClock.uptimeMillis();
            if (jUptimeMillis2 < 10) {
                return;
            }
            this.f = new me5(this.b, ipPortFromString, hashSet);
            k63.a("SisConn", "second sis, addr=" + ipPortFromString + ", failIps=" + hashSet);
            FutureTask futureTask = new FutureTask(this.f);
            try {
                JCoreManager.onEvent(null, null, 11, "ASYNC", null, futureTask);
                je5 je5Var = (je5) futureTask.get(jUptimeMillis2, TimeUnit.MILLISECONDS);
                LinkedHashSet<IpPort> linkedHashSet2 = je5Var != null ? je5Var.f18393a : null;
                if (linkedHashSet2 == null || linkedHashSet2.isEmpty()) {
                    return;
                }
                this.b.e(je5Var.g);
                f(linkedHashSet2, j);
            } catch (Throwable th) {
                k63.l("SisConn", "second sis e:" + th);
            }
        }
    }

    public final void g(LinkedHashSet<IpPort> linkedHashSet) {
        linkedHashSet.removeAll(this.f17942a);
        if (linkedHashSet.isEmpty()) {
            return;
        }
        LinkedHashSet<IpPort> linkedHashSetA = wu2.a(this.b.b, linkedHashSet, 0L);
        k63.a("SisConn", "connect: last good sis info" + linkedHashSetA);
        Iterator<IpPort> it = linkedHashSetA.iterator();
        while (it.hasNext() && !a(it.next())) {
        }
    }

    public ur h(ix3 ix3Var) throws Exception {
        this.c = ix3Var;
        k63.a("SisConn", "start sisAndConnect...");
        this.e = new xu2();
        long jUptimeMillis = SystemClock.uptimeMillis() + 12000;
        LinkedHashSet<IpPort> linkedHashSetString2Set = IpPort.string2Set((String) lg5.c(this.b.b, zz2.S()));
        boolean z = (linkedHashSetString2Set == null || linkedHashSetString2Set.isEmpty()) ? false : true;
        boolean zC = c();
        if (z && zC) {
            g(linkedHashSetString2Set);
        }
        je5 je5VarF = this.b.f(12000L);
        LinkedHashSet<IpPort> linkedHashSet = je5VarF != null ? je5VarF.f18393a : null;
        if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
            this.b.e(je5VarF.g);
            f(linkedHashSet, jUptimeMillis);
        } else if (z && !zC) {
            g(linkedHashSetString2Set);
        }
        e();
        k63.a("SisConn", "wait final result...");
        Object objL = this.d.l(60000L);
        this.d.j(false);
        if (objL instanceof ur) {
            k63.a("SisConn", "connect succeed");
            return (ur) objL;
        }
        if (objL instanceof Exception) {
            k63.a("SisConn", "all sis and connect failed, e:" + objL);
            throw ((Exception) objL);
        }
        k63.l("SisConn", "all sis and connect failed:" + objL);
        throw new JException(1, null);
    }
}
