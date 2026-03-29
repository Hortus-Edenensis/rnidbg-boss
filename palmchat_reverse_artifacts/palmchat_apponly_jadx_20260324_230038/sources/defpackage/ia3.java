package defpackage;

import android.os.Build;
import android.util.Pair;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Dns;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ia3 implements Dns {
    public static volatile ia3 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18132a;
    public Boolean b = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ia3 ia3Var = ia3.this;
            ia3Var.b = Boolean.valueOf(ia3Var.f());
        }
    }

    public ia3() {
        this.f18132a = false;
        this.f18132a = lh3.a().e();
        LogUtil.i("LxHttpDns", "isIpV6Enable" + this.f18132a);
    }

    public static ia3 d() {
        if (c == null) {
            synchronized (ia3.class) {
                if (c == null) {
                    c = new ia3();
                }
            }
        }
        return c;
    }

    public final List<InetAddress> c(String str) throws UnknownHostException {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        z = false;
        if (this.f18132a) {
            boolean zE = e();
            DNSNode[] dNSNodeArrJ = it0.k().j(str, !zE);
            if (dNSNodeArrJ != null && dNSNodeArrJ.length > 0) {
                for (DNSNode dNSNode : dNSNodeArrJ) {
                    arrayList.add(InetAddress.getByName(dNSNode.host));
                }
            }
            z = zE;
        } else {
            Pair<te1, DNSNode> pairL = it0.k().l(str);
            if (pairL != null) {
                arrayList.add(InetAddress.getByName(((DNSNode) pairL.second).host));
            }
        }
        if (LogUtil.isLogEnable()) {
            LogUtil.i("LxHttpDns", "getAddressList isIpV6Enable= " + this.f18132a + "isSupportIpV6 =" + z + " result=" + az2.c(arrayList));
        }
        return arrayList;
    }

    public final boolean e() {
        if (this.b == null) {
            this.b = Boolean.valueOf(f());
        }
        return this.b.booleanValue();
    }

    public final boolean f() {
        boolean zB = Build.VERSION.SDK_INT >= 23 ? do2.f17103a.b(c.b()) : false;
        LogUtil.i("LxHttpDns", "isIPv6SupportedImp=" + zB);
        return zB;
    }

    public void g() {
        LogUtil.i("LxHttpDns", "onNetChanged isIpV6Enable=" + this.f18132a);
        if (this.f18132a) {
            u93.b(1000, new a());
        }
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        if (LogUtil.isLogEnable()) {
            LogUtil.i("LxHttpDns", "lookup start hostname=" + str);
        }
        List<InetAddress> listC = c(str);
        if (listC == null || listC.size() <= 0) {
            listC = Dns.SYSTEM.lookup(str);
        }
        if (LogUtil.isLogEnable()) {
            LogUtil.i("LxHttpDns", "lookup end hostname=" + str + " result" + az2.c(listC));
        }
        return listC;
    }
}
