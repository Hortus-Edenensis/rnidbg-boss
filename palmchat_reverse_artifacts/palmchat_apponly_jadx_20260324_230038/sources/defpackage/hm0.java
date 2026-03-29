package defpackage;

import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.sdk.impl.connect.IpPort;
import cn.jiguang.sdk.impl.helper.JException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hm0 implements Callable<ur> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ie5 f17993a;
    public final wk5 b;
    public final xu2 c;
    public final ix3 d;

    public hm0(ie5 ie5Var, wk5 wk5Var, xu2 xu2Var, ix3 ix3Var) {
        this.b = wk5Var;
        this.f17993a = ie5Var;
        this.c = xu2Var;
        this.d = ix3Var;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ur call() {
        try {
            if (this.c == null) {
                return null;
            }
            return b(this.c.d(this.f17993a.h()));
        } catch (Throwable th) {
            k63.l("ConnTask", "run e:" + th);
            return null;
        }
    }

    public ur b(IpPort ipPort) throws Exception {
        if (this.b.i()) {
            return null;
        }
        ix3 ix3Var = this.d;
        if (ix3Var == null || ix3Var.d) {
            this.b.g(new JException(-991, null));
            return null;
        }
        if (ipPort == null) {
            return null;
        }
        if (!TextUtils.isEmpty(ui2.k)) {
            String str = ui2.k;
            ipPort.ip = str;
            ipPort.inetAddress = InetAddress.getByName(str);
        }
        int i = ui2.l;
        if (i > 0) {
            ipPort.port = i;
        }
        k63.b("ConnTask", "Open connection with ip=" + ipPort.inetAddress + ", port:" + ipPort.port);
        long jUptimeMillis = SystemClock.uptimeMillis();
        zx3 zx3Var = new zx3(8128, 20);
        int iA = zx3Var.a(ipPort.ip, ipPort.port);
        if (this.b.i()) {
            z86.b(zx3Var);
            return null;
        }
        if (this.d.d) {
            this.b.g(new JException(-991, null));
            z86.b(zx3Var);
            return null;
        }
        if (iA == 0) {
            lg5.h(this.f17993a.b, zz2.V((ipPort.inetAddress instanceof Inet4Address) || nl5.j(ipPort.ip)).a0(ipPort.toString()));
            k63.h("ConnTask", "Succeed to open connection - ip:" + ipPort.inetAddress + ", port:" + ipPort.port);
            this.b.g(zx3Var);
            wu2.c(this.f17993a.b, ipPort, 1, 0L);
            return zx3Var;
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
        this.f17993a.c(2, ipPort.ip, ipPort.port, mg5.b(this.f17993a.b), jUptimeMillis2, iA);
        k63.g("ConnTask", "Failed(" + iA + ") to open connection - ip:" + ipPort.inetAddress + ", port:" + ipPort.port + ", cost:" + jUptimeMillis2);
        wu2.c(this.f17993a.b, ipPort, -1, jUptimeMillis2);
        z86.b(zx3Var);
        return null;
    }
}
