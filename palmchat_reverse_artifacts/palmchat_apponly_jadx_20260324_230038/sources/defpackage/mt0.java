package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class mt0 {
    public static volatile mt0 d;
    public static final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19360a = 36000000;
    public long b = 900000;
    public final Map<String, Pair<InetAddress[], Long>> c = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Callable<InetAddress[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f19361a;
        public String b;
        public mt0 c;

        public a(Context context, String str, mt0 mt0Var) {
            this.f19361a = context;
            this.b = str;
            this.c = mt0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InetAddress[] call() throws Exception {
            InetAddress[] allByName;
            boolean z;
            try {
                allByName = InetAddress.getAllByName(this.b);
            } catch (UnknownHostException e) {
                k63.l("DNSLoader", "dns resolve failed:" + e);
                allByName = null;
            }
            if (allByName == null || allByName.length <= 0) {
                return allByName;
            }
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int i2 = 0;
            for (InetAddress inetAddress : allByName) {
                if (i < 3 && (inetAddress instanceof Inet4Address)) {
                    i++;
                } else if (i2 >= 3 || !(inetAddress instanceof Inet6Address)) {
                    z = false;
                    if (z) {
                        arrayList.add(inetAddress);
                        sb.append(inetAddress.getHostAddress());
                        sb.append(",");
                    }
                    if (i != 3 && i2 == 3) {
                        break;
                    }
                } else {
                    i2++;
                }
                z = true;
                if (z) {
                }
                if (i != 3) {
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            InetAddress[] inetAddressArr = (InetAddress[]) arrayList.toArray(new InetAddress[0]);
            long jCurrentTimeMillis = System.currentTimeMillis();
            k63.a("DNSLoader", "update dns cache url=" + this.b + " resolved=" + Arrays.toString(inetAddressArr));
            this.c.c.put(this.b, new Pair(inetAddressArr, Long.valueOf(jCurrentTimeMillis)));
            try {
                sb.deleteCharAt(sb.length() - 1);
                lg5.h(this.f19361a, zz2.a(this.b).a0(sb.toString()), zz2.b(this.b).a0(Long.valueOf(jCurrentTimeMillis)));
                return inetAddressArr;
            } catch (Throwable unused) {
                return inetAddressArr;
            }
        }
    }

    public static mt0 c() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new mt0();
                }
            }
        }
        return d;
    }

    public final InetAddress b(String str) {
        if (nl5.j(str) || nl5.l(str)) {
            try {
                return InetAddress.getByName(str);
            } catch (UnknownHostException e2) {
                k63.l("DNSLoader", "dns resolve failed:" + e2);
            }
        }
        return null;
    }

    public InetAddress d(Context context, String str, long j, boolean z) {
        InetAddress[] inetAddressArrE = e(context, str, j, z);
        if (inetAddressArrE == null || inetAddressArrE.length <= 0) {
            return null;
        }
        return inetAddressArrE[0];
    }

    public InetAddress[] e(Context context, String str, long j, boolean z) {
        InetAddress[] inetAddressArr;
        InetAddress[] inetAddressArr2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        InetAddress inetAddressB = b(str);
        if (inetAddressB != null) {
            return new InetAddress[]{inetAddressB};
        }
        Pair<InetAddress[], Boolean> pairF = f(context, str, this.f19360a, this.b);
        if (pairF != null) {
            Object obj = pairF.first;
            inetAddressArr = obj != null ? (InetAddress[]) obj : null;
            if (!((Boolean) pairF.second).booleanValue()) {
                if (z) {
                    bw2.c(new FutureTask(new a(context, str, this)), new int[0]);
                }
                k63.a("DNSLoader", "use cache=" + Arrays.toString(inetAddressArr));
                return inetAddressArr;
            }
        } else {
            inetAddressArr = null;
        }
        FutureTask futureTask = new FutureTask(new a(context, str, this));
        bw2.c(futureTask, new int[0]);
        if (j == 0) {
            k63.a("DNSLoader", "use cache=" + Arrays.toString(inetAddressArr));
            return inetAddressArr;
        }
        try {
            k63.a("DNSLoader", "waiting dns for " + str);
            inetAddressArr2 = (InetAddress[]) futureTask.get(j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            k63.l("DNSLoader", "run futureTask e:" + th);
        }
        if (inetAddressArr2 != null) {
            k63.a("DNSLoader", "use resolved result=" + Arrays.toString(inetAddressArr2));
            return inetAddressArr2;
        }
        k63.a("DNSLoader", "use cache=" + Arrays.toString(inetAddressArr));
        return inetAddressArr;
    }

    public final Pair<InetAddress[], Boolean> f(Context context, String str, long j, long j2) {
        InetAddress[] inetAddressArrG;
        Pair<InetAddress[], Long> pair = this.c.get(str);
        boolean z = pair == null || pair.first == null;
        long jLongValue = z ? ((Long) lg5.c(context, zz2.b(str))).longValue() : ((Long) pair.second).longValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis > jLongValue + j) {
            return null;
        }
        if (z) {
            inetAddressArrG = g(context, str);
            if (inetAddressArrG != null) {
                this.c.put(str, new Pair<>(inetAddressArrG, Long.valueOf(jLongValue)));
            }
        } else {
            inetAddressArrG = (InetAddress[]) pair.first;
        }
        if (inetAddressArrG != null) {
            return new Pair<>(inetAddressArrG, Boolean.valueOf(jCurrentTimeMillis > jLongValue + j2));
        }
        return null;
    }

    public final InetAddress[] g(Context context, String str) {
        String str2 = (String) lg5.c(context, zz2.a(str));
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] strArrSplit = str2.split(",");
        LinkedList linkedList = new LinkedList();
        for (String str3 : strArrSplit) {
            InetAddress inetAddressB = b(str3);
            if (inetAddressB != null) {
                linkedList.add(inetAddressB);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return (InetAddress[]) linkedList.toArray(new InetAddress[0]);
    }
}
