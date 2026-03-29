package defpackage;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.sdk.impl.connect.IpPort;
import cn.jiguang.sdk.impl.helper.JException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ie5 {
    public static ie5 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18152a = 0;
    public Context b;
    public final LinkedList<ke5> c;
    public byte[] d;
    public int e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends xw2 {
        public final /* synthetic */ IpPort c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, IpPort ipPort) {
            super(str);
            this.c = ipPort;
        }

        @Override // defpackage.xw2
        public void a() {
            DatagramSocket datagramSocket;
            Object th;
            StringBuilder sb;
            try {
                datagramSocket = new DatagramSocket();
                try {
                    String str = (String) lg5.c(ie5.this.b, zz2.j());
                    if (TextUtils.isEmpty(str)) {
                        k63.a("SisConnContext", "reportInfo is Empty, quit report");
                        try {
                            datagramSocket.close();
                            return;
                        } catch (Throwable th2) {
                            k63.l("SisConnContext", "sisReport ,close udpsocket error:" + th2.getMessage());
                            return;
                        }
                    }
                    byte[] bArrN = jm0.n("DG", str);
                    k63.a("SisConnContext", "sis report data(" + bArrN.length + ") at " + this.c.inetAddress + ":" + this.c.port);
                    ie5 ie5Var = ie5.this;
                    IpPort ipPort = this.c;
                    if (ie5Var.l(ipPort.inetAddress, ipPort.port, datagramSocket, bArrN)) {
                        k63.a("SisConnContext", "report succeed : " + str);
                        lg5.h(ie5.this.b, zz2.X().a0(Long.valueOf(SystemClock.elapsedRealtime())));
                        lg5.h(ie5.this.b, zz2.j().a0(null));
                    } else {
                        k63.l("SisConnContext", "report failed" + str);
                    }
                    try {
                        datagramSocket.close();
                    } catch (Throwable th3) {
                        th = th3;
                        sb = new StringBuilder();
                        sb.append("sisReport ,close udpsocket error:");
                        sb.append(th.getMessage());
                        k63.l("SisConnContext", sb.toString());
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        k63.l("SisConnContext", "sisReport failed, error:" + th);
                        if (datagramSocket != null) {
                            try {
                                datagramSocket.close();
                            } catch (Throwable th5) {
                                th = th5;
                                sb = new StringBuilder();
                                sb.append("sisReport ,close udpsocket error:");
                                sb.append(th.getMessage());
                                k63.l("SisConnContext", sb.toString());
                            }
                        }
                    } catch (Throwable th6) {
                        if (datagramSocket != null) {
                            try {
                                datagramSocket.close();
                            } catch (Throwable th7) {
                                k63.l("SisConnContext", "sisReport ,close udpsocket error:" + th7.getMessage());
                            }
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th8) {
                datagramSocket = null;
                th = th8;
            }
        }
    }

    public ie5(Context context) {
        this.b = context;
        this.c = ke5.c((String) lg5.c(context, zz2.j()));
    }

    public static ie5 g(Context context) {
        if (f == null) {
            synchronized (ie5.class) {
                if (f == null) {
                    f = new ie5(context);
                }
            }
        }
        return f;
    }

    public void b(boolean z) {
        this.f18152a = (z ? 1 : 2) | this.f18152a;
        yu2.b().g(this.b, this.f18152a);
    }

    public void c(int i, String str, int i2, long j, long j2, int i3) {
        if (IpPort.isLegal(str, i2)) {
            ke5 ke5Var = new ke5();
            ke5Var.f18673a = fv2.e(this.b);
            ke5Var.b = i;
            ke5Var.c = new IpPort(str, i2);
            ke5Var.e = j;
            ke5Var.f = j2;
            ke5Var.k = i3;
            ke5Var.g = cu5.b(this.b);
            ke5Var.d = fv2.n(this.b);
            ke5Var.h = 200.0d;
            ke5Var.i = 200.0d;
            ke5Var.j = System.currentTimeMillis();
            d(ke5Var);
        }
    }

    public final synchronized void d(ke5 ke5Var) {
        this.c.add(ke5Var);
        k63.a("SisConnContext", "addSisReportInfo:" + ke5Var.d().toString());
        while (this.c.size() > 30) {
            this.c.removeFirst();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<ke5> it = this.c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().d());
        }
        lg5.h(this.b, zz2.j().a0(jSONArray.toString()));
    }

    public void e(IpPort ipPort) {
        if (((Boolean) lg5.c(this.b, zz2.U())).booleanValue()) {
            if (z86.e(((Long) lg5.c(this.b, zz2.X())).longValue(), 3600000L)) {
                bw2.f(new a("SisConnContext#asyncSisReportIfNeed", ipPort), new int[0]);
            } else {
                k63.a("SisConnContext", "sis report: not yet");
            }
        }
    }

    public je5 f(long j) {
        FutureTask futureTask = new FutureTask(new ge5(this));
        this.f18152a = 0;
        bw2.c(futureTask, new int[0]);
        if (j < 10) {
            j = 10;
        }
        try {
            return (je5) futureTask.get(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public int h() {
        if (this.f18152a == 0) {
            this.f18152a = yu2.b().d(this.b);
        }
        int iC = yu2.b().c(this.f18152a);
        k63.a("SisConnContext", "ipvsupport=" + this.f18152a + ", prefer=" + iC);
        return iC;
    }

    public final le5 i(int i) {
        return new le5(i, fv2.e(this.b), wv2.b, fv2.n(this.b), cu5.d(this.b), 200.0d, 200.0d, System.currentTimeMillis());
    }

    public byte[] j(Set<String> set) throws JException {
        int iB = cu5.b(this.b);
        if (this.d == null || iB != this.e) {
            this.e = iB;
            try {
                this.d = jm0.n("UG", i(iB).b(set).toString());
            } catch (Exception e) {
                throw new JException(2, "Failed to package data - " + e);
            }
        }
        return this.d;
    }

    public boolean k() {
        return false;
    }

    public final boolean l(InetAddress inetAddress, int i, DatagramSocket datagramSocket, byte[] bArr) {
        try {
            return z86.a(jm0.p(jm0.g(datagramSocket, new DatagramPacket(bArr, bArr.length, inetAddress, i)))) == 0;
        } catch (Throwable th) {
            k63.c("SisConnContext", "report failed : " + th);
            return false;
        }
    }
}
