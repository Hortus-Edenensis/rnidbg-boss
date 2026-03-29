package defpackage;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.sdk.impl.connect.IpPort;
import cn.jiguang.sdk.impl.helper.JException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class me5 implements Callable<je5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ie5 f19201a;
    public final wk5 b;
    public final xu2 c;
    public Set<String> d;
    public IpPort e;

    public me5(ie5 ie5Var, wk5 wk5Var, xu2 xu2Var) {
        this.f19201a = ie5Var;
        this.b = wk5Var;
        this.c = xu2Var;
    }

    public static void d(Context context, je5 je5Var) {
        if (je5Var == null || je5Var.a()) {
            return;
        }
        String str = IpPort.set2String(je5Var.f18393a);
        String str2 = IpPort.set2String(je5Var.b);
        String strA = cu5.a(context);
        k63.a("SisTask", "updateSisInfo ips=" + str + " sslIps=" + str2 + " net=" + strA);
        zz2[] zz2VarArr = new zz2[8];
        zz2VarArr[0] = zz2.S().a0(str);
        zz2VarArr[1] = zz2.e0().a0(str2);
        zz2VarArr[2] = zz2.O(false).a0(IpPort.set2String(je5Var.c));
        zz2VarArr[3] = zz2.O(true).a0(IpPort.set2String(je5Var.d));
        zz2VarArr[4] = zz2.P().a0(IpPort.set2String(je5Var.e));
        zz2<String> zz2VarF0 = zz2.f0();
        JSONObject jSONObject = je5Var.f;
        zz2VarArr[5] = zz2VarF0.a0(jSONObject != null ? jSONObject.toString() : null);
        zz2VarArr[6] = zz2.U().a0(Boolean.valueOf(je5Var.h));
        zz2VarArr[7] = zz2.d0().a0(Long.valueOf(SystemClock.elapsedRealtime()));
        lg5.h(context, zz2VarArr);
        lg5.h(context, zz2.i().a0(strA));
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public je5 call() {
        try {
            if (this.c == null) {
                return c(this.e);
            }
            return c(this.c.d(this.f19201a.h()));
        } catch (Throwable th) {
            k63.l("SisTask", "run e:" + th);
            return null;
        }
    }

    public final Object[] b(DatagramSocket datagramSocket, InetAddress inetAddress, int i) {
        Object[] objArr = new Object[2];
        objArr[1] = 0;
        try {
            byte[] bArrJ = this.f19201a.j(this.d);
            DatagramPacket datagramPacket = new DatagramPacket(bArrJ, bArrJ.length, inetAddress, i);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                byte[] bArrG = jm0.g(datagramSocket, datagramPacket);
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis);
                try {
                    je5 je5Var = new je5(new String(jm0.p(bArrG)));
                    if (je5Var.a()) {
                        objArr[0] = 6;
                        return objArr;
                    }
                    d(this.f19201a.b, je5Var);
                    je5Var.g = new IpPort(inetAddress, i);
                    objArr[0] = je5Var;
                    return objArr;
                } catch (JException e) {
                    objArr[0] = Integer.valueOf(e.getCode());
                    return objArr;
                }
            } catch (Exception unused) {
                objArr[0] = 3;
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis);
                return objArr;
            }
        } catch (JException e2) {
            objArr[0] = Integer.valueOf(e2.getCode());
            return objArr;
        }
    }

    public je5 c(IpPort ipPort) {
        DatagramSocket datagramSocket;
        Object[] objArrB;
        Object obj;
        if (ipPort == null || ipPort.inetAddress == null) {
            return null;
        }
        try {
            datagramSocket = new DatagramSocket();
            try {
                if (!TextUtils.isEmpty(ui2.i)) {
                    ipPort.inetAddress = InetAddress.getByName(ui2.i);
                }
                int i = ui2.j;
                if (i > 0) {
                    ipPort.port = i;
                }
                k63.a("SisTask", "send sis:" + ipPort.inetAddress + " port:" + ipPort.port);
                objArrB = b(datagramSocket, ipPort.inetAddress, ipPort.port);
                obj = objArrB[0];
            } catch (Throwable th) {
                th = th;
                try {
                    k63.l("SisTask", "sis e:" + th);
                    if (datagramSocket != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    if (datagramSocket != null) {
                        try {
                            datagramSocket.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            datagramSocket = null;
        }
        if (obj instanceof je5) {
            boolean z = ipPort.inetAddress instanceof Inet4Address;
            this.f19201a.b(z);
            lg5.h(this.f19201a.b, zz2.W(z).a0(ipPort.toString()));
            wk5 wk5Var = this.b;
            if (wk5Var != null) {
                wk5Var.g(objArrB[0]);
            }
            je5 je5Var = (je5) objArrB[0];
            try {
                datagramSocket.close();
            } catch (Throwable unused2) {
            }
            return je5Var;
        }
        int iIntValue = ((Integer) obj).intValue();
        long jLongValue = ((Long) objArrB[1]).longValue();
        k63.l("SisTask", "sis failed(" + iIntValue + "):" + ipPort.inetAddress + " port:" + ipPort.port);
        this.f19201a.c(1, ipPort.inetAddress.getHostAddress(), ipPort.port, mg5.b(this.f19201a.b), jLongValue, iIntValue);
        try {
            datagramSocket.close();
        } catch (Throwable unused3) {
        }
        return null;
    }

    public me5(ie5 ie5Var, IpPort ipPort, Set<String> set) {
        this.f19201a = ie5Var;
        this.b = null;
        this.c = null;
        this.e = ipPort;
        this.d = set;
    }
}
