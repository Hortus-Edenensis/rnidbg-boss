package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class yu2 {
    public static int b;
    public static yu2 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Integer> f22280a = new HashMap();

    public static yu2 b() {
        if (c == null) {
            synchronized (yu2.class) {
                if (c == null) {
                    c = new yu2();
                }
            }
        }
        return c;
    }

    public static boolean e(InetAddress inetAddress) {
        try {
            if (inetAddress instanceof Inet6Address) {
                if (!inetAddress.getHostAddress().substring(0, 4).equalsIgnoreCase("fe80")) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void f(int i) {
        if (i > 3 || i < 0) {
            return;
        }
        b = i;
    }

    public final int a(boolean z) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            boolean z2 = false;
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (!nl5.m(networkInterfaceNextElement.getName(), "dummy")) {
                    boolean zM = nl5.m(networkInterfaceNextElement.getName(), "wlan");
                    if (!z || zM) {
                        Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if (!inetAddressNextElement.isLoopbackAddress() && e(inetAddressNextElement)) {
                                if (zM) {
                                    return 3;
                                }
                                z2 = true;
                            }
                        }
                    }
                }
            }
            return z2 ? 0 : 1;
        } catch (Exception unused) {
            k63.l("IpvxHelper", "checkIpvxSupport:");
            return 0;
        }
    }

    public int c(int i) {
        int i2 = b;
        if (i2 == 2 || i2 == 1) {
            return i2;
        }
        if (i == 1) {
            return 1;
        }
        if (i != 2) {
            return i2;
        }
        return 2;
    }

    public int d(Context context) {
        int iA;
        int i = 0;
        try {
            String strA = cu5.a(context);
            boolean zEquals = "wifi".equals(strA);
            boolean z = !TextUtils.isEmpty("");
            if (!zEquals || z) {
                Integer num = this.f22280a.get(strA + "");
                if (num != null && num.intValue() != 0) {
                    k63.a("IpvxHelper", "net=" + strA + "  get cache support=" + num);
                    return num.intValue();
                }
            }
            if (z) {
                iA = ((Integer) lg5.c(context, zz2.T(""))).intValue();
                try {
                    k63.a("IpvxHelper", "net=" + strA + "  get wifi history support=" + iA);
                } catch (Throwable th) {
                    th = th;
                    i = iA;
                    k63.l("IpvxHelper", "getPreferVx e:" + th);
                }
            } else {
                iA = 0;
            }
            if (iA == 0) {
                iA = a(zEquals);
                k63.a("IpvxHelper", "net=" + strA + "  get networkinterface support=" + iA);
                if (z) {
                    lg5.h(context, zz2.T("").a0(Integer.valueOf(iA)));
                }
            }
            i = iA;
            if (!zEquals || z) {
                this.f22280a.put(strA + "", Integer.valueOf(i));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return i;
    }

    public void g(Context context, int i) {
        String strA = cu5.a(context);
        boolean zEquals = "wifi".equals(strA);
        boolean z = !TextUtils.isEmpty("");
        if (!zEquals || z) {
            this.f22280a.put(strA + "", Integer.valueOf(i));
        }
        if (z) {
            lg5.h(context, zz2.T("").a0(Integer.valueOf(i)));
        }
    }
}
