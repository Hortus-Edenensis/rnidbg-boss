package defpackage;

import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.sdk.impl.connect.IpPort;
import cn.jiguang.sdk.impl.dnssrv.Name;
import cn.jiguang.sdk.impl.dnssrv.RRset;
import cn.jiguang.sdk.impl.dnssrv.Record;
import cn.jiguang.sdk.impl.dnssrv.SRVRecord;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class f05 {
    public static volatile f05 d;
    public static final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f17404a = 86400000;
    public long b = 1800000;
    public final Map<String, Pair<LinkedHashSet<IpPort>, Long>> c = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Callable<LinkedHashSet<IpPort>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17405a;
        public f05 b;

        public a(String str, f05 f05Var) {
            this.f17405a = str;
            this.b = f05Var;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LinkedHashSet<IpPort> call() throws Exception {
            LinkedHashSet<IpPort> linkedHashSetG = f05.g(this.f17405a);
            if (linkedHashSetG != null && linkedHashSetG.size() > 0) {
                this.b.f(this.f17405a, new Pair(linkedHashSetG, Long.valueOf(System.currentTimeMillis())));
            }
            return linkedHashSetG;
        }
    }

    public static byte[] b(String str) throws IOException {
        return un3.f(Record.newRecord(Name.concatenate(Name.fromString(str), Name.root), 33, 1)).j(65535);
    }

    public static f05 c() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new f05();
                }
            }
        }
        return d;
    }

    public static LinkedHashSet<IpPort> g(String str) {
        String[] strArrM;
        un3 un3Var;
        Record recordC;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrB = b(str);
            k63.a("SRVLoader", "srv host:" + str);
            LinkedHashSet<IpPort> linkedHashSet = new LinkedHashSet<>();
            try {
                strArrM = hx4.j().m();
            } catch (Throwable th) {
                k63.n("SRVLoader", "Get default ports error with Exception:" + th);
            }
            if (strArrM != null && strArrM.length != 0) {
                LinkedHashSet<InetAddress> linkedHashSet2 = new LinkedHashSet();
                mt0 mt0VarC = mt0.c();
                for (String str2 : strArrM) {
                    InetAddress inetAddressD = mt0VarC.d(null, str2, 3000L, false);
                    if (inetAddressD != null) {
                        linkedHashSet2.add(inetAddressD);
                    }
                }
                for (InetAddress inetAddress : linkedHashSet2) {
                    try {
                        un3Var = new un3(pr5.h(null, new InetSocketAddress(inetAddress, 53), bArrB, System.currentTimeMillis() + 1000));
                        recordC = un3Var.c();
                    } catch (IOException e2) {
                        k63.l("SRVLoader", "tcp send to " + inetAddress.getHostAddress() + " err:" + e2);
                    }
                    if (recordC == null) {
                        break;
                    }
                    for (RRset rRset : un3Var.e(1)) {
                        if (rRset.getDClass() == recordC.getDClass() && rRset.getType() == recordC.getType() && rRset.getName().equals(recordC.getName())) {
                            Iterator itRrs = rRset.rrs();
                            while (itRrs.hasNext()) {
                                SRVRecord sRVRecord = (SRVRecord) itRrs.next();
                                if (sRVRecord.getPort() > 0) {
                                    String string = sRVRecord.getTarget().toString();
                                    if (!TextUtils.isEmpty(string)) {
                                        if (string.endsWith(".")) {
                                            string = string.substring(0, string.length() - 1);
                                        }
                                        IpPort ipPort = new IpPort(string, sRVRecord.getPort());
                                        if (ipPort.isLegal()) {
                                            linkedHashSet.add(ipPort);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return linkedHashSet;
            }
            return linkedHashSet;
        } catch (IOException e3) {
            k63.l("SRVLoader", "can't srv, create query:" + e3);
            return null;
        }
    }

    public LinkedHashSet<IpPort> d(String str, long j) {
        LinkedHashSet<IpPort> linkedHashSet;
        LinkedHashSet<IpPort> linkedHashSet2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Pair<LinkedHashSet<IpPort>, Boolean> pairE = e(str, this.f17404a, this.b);
        if (pairE != null) {
            Object obj = pairE.first;
            linkedHashSet = (obj == null || ((LinkedHashSet) obj).size() <= 0) ? null : (LinkedHashSet) pairE.first;
            if (!((Boolean) pairE.second).booleanValue()) {
                return linkedHashSet;
            }
        } else {
            linkedHashSet = null;
        }
        FutureTask futureTask = new FutureTask(new a(str, this));
        bw2.c(futureTask, new int[0]);
        if (j == 0) {
            k63.a("SRVLoader", "use cache=" + linkedHashSet);
            return linkedHashSet;
        }
        try {
            linkedHashSet2 = (LinkedHashSet) futureTask.get(j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            k63.l("SRVLoader", "run futureTask e:" + th);
        }
        if (linkedHashSet2 == null || linkedHashSet2.size() <= 0) {
            k63.a("SRVLoader", "use cache=" + linkedHashSet);
            return linkedHashSet;
        }
        k63.a("SRVLoader", "use resolved result=" + linkedHashSet2);
        return linkedHashSet2;
    }

    public final Pair<LinkedHashSet<IpPort>, Boolean> e(String str, long j, long j2) {
        Object obj;
        Pair<LinkedHashSet<IpPort>, Long> pair = this.c.get(str);
        boolean z = pair == null || (obj = pair.first) == null || ((LinkedHashSet) obj).size() == 0;
        long jLongValue = z ? ((Long) lg5.c(null, zz2.d(str))).longValue() : ((Long) pair.second).longValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis > jLongValue + j) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z) {
            String str2 = (String) lg5.c(null, zz2.c(str));
            if (!TextUtils.isEmpty(str2)) {
                for (String str3 : str2.split(",")) {
                    IpPort ipPortFromString = IpPort.fromString(str3);
                    if (ipPortFromString != null && ipPortFromString.isLegal()) {
                        linkedHashSet.add(ipPortFromString);
                    }
                }
                this.c.put(str, new Pair<>(linkedHashSet, Long.valueOf(System.currentTimeMillis())));
            }
        } else {
            linkedHashSet = (LinkedHashSet) pair.first;
        }
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return new Pair<>(linkedHashSet, Boolean.valueOf(jCurrentTimeMillis > jLongValue + j2));
    }

    public final void f(String str, Pair<LinkedHashSet<IpPort>, Long> pair) {
        Object obj = pair.first;
        if (obj == null || ((LinkedHashSet) obj).size() <= 0 || pair.second == null) {
            return;
        }
        this.c.put(str, pair);
        StringBuilder sb = new StringBuilder();
        Iterator it = ((LinkedHashSet) pair.first).iterator();
        while (it.hasNext()) {
            sb.append(((IpPort) it.next()).toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        lg5.h(null, zz2.c(str).a0(sb.toString()), zz2.d(str).a0((Long) pair.second));
    }
}
