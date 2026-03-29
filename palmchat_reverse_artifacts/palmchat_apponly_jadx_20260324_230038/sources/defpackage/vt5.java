package defpackage;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.common.C;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.sdk.impl.connect.IpPort;
import cn.jiguang.sdk.impl.helper.JException;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.analytics.pro.dn;
import com.umeng.analytics.pro.f;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class vt5 {
    public static vt5 e;
    public static int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f21525a = new AtomicBoolean(false);
    public final Map<IpPort, Pair<Integer, ur>> b = new ConcurrentHashMap();
    public final Map<IpPort, ConcurrentHashMap<Integer, b>> c = new ConcurrentHashMap();
    public Map<String, Set<IpPort>> d = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21526a;
        public JSONObject b;
        public byte[] c;
        public File d;
        public Set<String> e;
        public int f = -1;
        public IpPort g;
        public LinkedHashSet<IpPort> h;
        public boolean i;
        public transient ReportCallBack j;

        public String toString() {
            return "TcpReportData{types=" + this.e + ", seqId=" + this.f + ", ipPort=" + this.g + ", restUrls=" + this.h + '}';
        }
    }

    public static vt5 i() {
        if (e == null) {
            synchronized (vt5.class) {
                if (e == null) {
                    e = new vt5();
                }
            }
        }
        return e;
    }

    public static byte[] k(Context context, long j, byte[] bArr) {
        byte[] bArrF = nl5.f(j + nl5.h((String) lg5.c(context, zz2.H())) + nl5.e(bArr));
        if (bArrF == null) {
            return new byte[16];
        }
        if (bArrF.length == 16) {
            return bArrF;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArrF.length, 16));
        return bArr2;
    }

    public static synchronized int m(Context context) {
        Integer numValueOf;
        Integer numValueOf2 = (Integer) lg5.f(context, zz2.B());
        if (numValueOf2 == null) {
            numValueOf2 = Integer.valueOf(Math.abs(new SecureRandom().nextInt(10000)));
        }
        numValueOf = Integer.valueOf((numValueOf2.intValue() + 1) % 10000);
        lg5.h(context, zz2.B().a0(numValueOf));
        return numValueOf.intValue();
    }

    public static synchronized int n() {
        int i;
        i = (f + 1) % 10000;
        f = i;
        return i;
    }

    public final void e(Context context) {
        Map<String, Set<IpPort>> map = this.d;
        if (map == null || map.isEmpty()) {
            String str = (String) lg5.c(context, zz2.f0());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                x(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    public final void f(Context context, IpPort ipPort, int i) {
        int iIntValue;
        Pair<Integer, ur> pairRemove = this.b.remove(ipPort);
        if (pairRemove != null) {
            iIntValue = ((Integer) pairRemove.first).intValue();
            z86.b((Closeable) pairRemove.second);
        } else {
            iIntValue = 0;
        }
        ConcurrentHashMap<Integer, b> concurrentHashMapRemove = this.c.remove(ipPort);
        if (i == 0 && !ad.w(context)) {
            i = -2;
        }
        if (concurrentHashMapRemove == null || concurrentHashMapRemove.size() <= 0) {
            if (iIntValue > 0) {
                k63.a("TcpReporter", "socket(" + iIntValue + ") at " + ipPort + " is disconnected, no task left");
                return;
            }
            return;
        }
        if (i == 0) {
            k63.a("TcpReporter", "socket(" + iIntValue + ") at " + ipPort + " is disconnected, go on send waiting request");
        } else {
            k63.a("TcpReporter", "socket(" + iIntValue + ") at " + ipPort + " is disconnected, finish waiting request, code=" + i);
        }
        for (b bVar : concurrentHashMapRemove.values()) {
            if (bVar != null) {
                nt5.b().f(bVar.f + 50000);
                if (i == 0) {
                    t(context, bVar);
                } else {
                    a aVar = new a(context, 3, bVar);
                    aVar.f = i;
                    bw2.g(aVar, new int[0]);
                }
            }
        }
    }

    public b g(Context context, JSONObject jSONObject, byte[] bArr, int i, File file, Set<String> set, ReportCallBack reportCallBack) {
        b bVar = new b();
        bVar.b = jSONObject;
        bVar.f21526a = i;
        bVar.c = bArr;
        bVar.d = file;
        bVar.e = set;
        bVar.f = m(context);
        bVar.j = reportCallBack;
        return bVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL;
        }
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1245458676:
                if (str.equals("active_launch")) {
                    b2 = 0;
                }
                break;
            case -1177318867:
                if (str.equals("account")) {
                    b2 = 1;
                }
                break;
            case -1091230153:
                if (str.equals("android_awake_target2")) {
                    b2 = 2;
                }
                break;
            case -1051289244:
                if (str.equals(f.L)) {
                    b2 = 3;
                }
                break;
            case -1039745817:
                if (str.equals(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL)) {
                    b2 = 4;
                }
                break;
            case -820729752:
                if (str.equals("active_terminate")) {
                    b2 = 5;
                }
                break;
            case -693746763:
                if (str.equals("android_awake")) {
                    b2 = 6;
                }
                break;
            case -295020531:
                if (str.equals("android_notification_state")) {
                    b2 = 7;
                }
                break;
            case -31313123:
                if (str.equals("android_awake2")) {
                    b2 = 8;
                }
                break;
            case 96275:
                if (str.equals("aa3")) {
                    b2 = 9;
                }
                break;
            case 2986591:
                if (str.equals("aat3")) {
                    b2 = 10;
                }
                break;
            case 93223301:
                if (str.equals("awake")) {
                    b2 = 11;
                }
                break;
            case 907150721:
                if (str.equals("detach_account")) {
                    b2 = 12;
                }
                break;
            case 1350272347:
                if (str.equals("android_awake_target")) {
                    b2 = dn.k;
                }
                break;
            case 1973539834:
                if (str.equals("identify_account")) {
                    b2 = dn.l;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 3:
            case 5:
                return f.L;
            case 1:
            case 12:
            case 14:
                return "account";
            case 2:
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
                return "awake";
            case 4:
                break;
            case 7:
                return "android_notification_state";
            default:
                if (this.d.containsKey(str)) {
                    return str;
                }
                break;
        }
        return PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL;
    }

    public final LinkedHashSet<IpPort> j(Context context, Set<String> set) {
        LinkedHashSet<IpPort> linkedHashSet = new LinkedHashSet<>();
        IpPort ipPortFromString = IpPort.fromString(ui2.g());
        if (ipPortFromString == null || !ipPortFromString.isLegal()) {
            Set<IpPort> setL = l(context, set);
            if (setL != null) {
                for (IpPort ipPort : setL) {
                    if (ipPort != null && ipPort.isLegal()) {
                        linkedHashSet.add(ipPort);
                    }
                }
            }
        } else {
            linkedHashSet.add(ipPortFromString);
        }
        k63.a("TcpReporter", "tcp report find urls=" + linkedHashSet);
        return linkedHashSet;
    }

    public final Set<IpPort> l(Context context, Set<String> set) {
        e(context);
        if (set == null || set.isEmpty()) {
            return this.d.get(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL);
        }
        Iterator<String> it = set.iterator();
        Set<IpPort> set2 = null;
        while (it.hasNext()) {
            Set<IpPort> set3 = this.d.get(h(it.next()));
            if (set3 == null || set3.isEmpty()) {
                return this.d.get(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL);
            }
            if (set2 == null) {
                set2 = set3;
            } else {
                set2.retainAll(set3);
            }
            if (set2.isEmpty()) {
                return this.d.get(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL);
            }
        }
        return set2;
    }

    public final void o(Context context, b bVar, int i) {
        ConcurrentHashMap<Integer, b> concurrentHashMap;
        IpPort ipPort = bVar.g;
        if (ipPort != null && (concurrentHashMap = this.c.get(ipPort)) != null) {
            concurrentHashMap.remove(Integer.valueOf(bVar.f));
        }
        nt5.b().f(bVar.f + 50000);
        a aVar = new a(context, 3, bVar);
        aVar.f = i;
        bw2.g(aVar, new int[0]);
    }

    public final void p(Context context, IpPort ipPort) {
        ur urVar;
        k63.a("TcpReporter", "socket at " + ipPort + " is connected, deal with waiting request");
        ConcurrentHashMap<Integer, b> concurrentHashMap = this.c.get(ipPort);
        Pair<Integer, ur> pair = this.b.get(ipPort);
        if (pair == null) {
            return;
        }
        if (concurrentHashMap != null && (urVar = (ur) pair.second) != null && urVar.c()) {
            for (b bVar : concurrentHashMap.values()) {
                if (bVar != null && !bVar.i) {
                    u(context, ((Integer) pair.first).intValue(), urVar, ipPort, bVar);
                }
            }
        }
        nt5.b().g(((Integer) pair.first).intValue() + 60000, 31000L, new a(context, ipPort));
    }

    public final void q(Context context, ByteBuffer byteBuffer, IpPort ipPort) {
        try {
            k63.a("TcpReporter", "Received bytes - len:" + byteBuffer.array().length);
            byte b2 = byteBuffer.get(2);
            if (b2 == 1 || b2 == 0) {
                short s = byteBuffer.getShort(15);
                short s2 = byteBuffer.getShort(17);
                k63.a("TcpReporter", "onResult seqId=" + ((int) s) + " code=" + ((int) s2));
                nt5.b().f(50000 + s);
                b bVarS = s(ipPort, s);
                if (bVarS != null) {
                    if (s2 == 0) {
                        a aVar = new a(context, 3, bVarS);
                        aVar.f = s2;
                        bw2.g(aVar, new int[0]);
                    } else if (s2 == 401) {
                        f(context, ipPort, s2);
                    } else {
                        t(context, bVarS);
                    }
                }
            } else {
                k63.l("TcpReporter", "wrong version");
            }
        } catch (Throwable th) {
            k63.l("TcpReporter", "tcp reporter onReceive err:" + th);
        }
    }

    public final byte[] r(Context context, byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length == 0 || bArr.length > 30683) {
            return null;
        }
        ia4 ia4Var = new ia4(bArr.length + 37);
        ia4Var.h(0);
        ia4Var.l(1);
        ia4Var.j(zd1.e().j());
        long jLongValue = ((Long) lg5.c(context, zz2.K())).longValue();
        ia4Var.k(jLongValue);
        ia4Var.e(k(context, jLongValue, bArr));
        ia4Var.j(i);
        ia4Var.h(i2);
        ia4Var.e(bArr);
        ia4Var.i(ia4Var.b(), 0);
        return ia4Var.d();
    }

    public final b s(IpPort ipPort, int i) {
        ConcurrentHashMap<Integer, b> concurrentHashMap;
        if (ipPort == null || (concurrentHashMap = this.c.get(ipPort)) == null) {
            return null;
        }
        b bVar = concurrentHashMap.get(Integer.valueOf(i));
        concurrentHashMap.remove(Integer.valueOf(i));
        return bVar;
    }

    public void t(Context context, b bVar) {
        IpPort next;
        try {
            boolean z = bVar.h == null;
            if (z) {
                nt5.b().d(context);
                bVar.h = j(context, bVar.e);
                k63.a("TcpReporter", "tcp report begin=" + bVar);
            }
            if (!ad.w(context)) {
                o(context, bVar, -2);
                return;
            }
            LinkedHashSet<IpPort> linkedHashSet = bVar.h;
            if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
                Iterator<IpPort> it = this.b.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (bVar.h.contains(next)) {
                        k63.a("TcpReporter", "use exist ipPort=" + next);
                        break;
                    }
                }
                if (next == null) {
                    next = bVar.h.iterator().next();
                    k63.a("TcpReporter", "use next ipPort=" + next);
                }
                bVar.g = next;
                bVar.h.remove(next);
                if (z) {
                    nt5.b().g(bVar.f + 50000, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, new a(context, bVar));
                }
                ConcurrentHashMap<Integer, b> concurrentHashMap = this.c.get(next);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.c.put(next, concurrentHashMap);
                }
                bVar.i = false;
                concurrentHashMap.put(Integer.valueOf(bVar.f), bVar);
                w(context, next, bVar);
                return;
            }
            o(context, bVar, -1);
        } catch (Throwable th) {
            k63.l("TcpReporter", "tcp upload e:" + th);
        }
    }

    public final void u(Context context, int i, ur urVar, IpPort ipPort, b bVar) {
        byte[] bArrR = r(context, bVar.c, bVar.f21526a, bVar.f);
        if (bArrR == null || bArrR.length == 0) {
            k63.a("TcpReporter", "package data failed, give up, data=" + bVar);
            o(context, bVar, -1);
            return;
        }
        k63.a("TcpReporter", "send tcp data, len=" + bArrR.length + ", data=" + bVar);
        bVar.i = true;
        urVar.h(bArrR);
        nt5.b().g(i + 60000, 31000L, new a(context, ipPort));
        nt5.b().g(bVar.f + 50000, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, new a(context, bVar));
    }

    public final void v(Context context, IpPort ipPort) {
        ur urVar;
        if (ipPort == null) {
            return;
        }
        try {
            Pair<Integer, ur> pair = this.b.get(ipPort);
            if (pair != null && (urVar = (ur) pair.second) != null && !urVar.c()) {
                k63.a("TcpReporter", "start tcp socket(" + pair.first + "):" + ipPort);
                if (urVar.a(ipPort.ip, ipPort.port) != 0) {
                    f(context, ipPort, 0);
                } else {
                    bw2.g(new a(context, 2, ipPort), new int[0]);
                    a aVar = new a(context, ipPort);
                    while (!this.f21525a.get()) {
                        try {
                            q(context, urVar.f(), ipPort);
                            nt5.b().g(((Integer) pair.first).intValue() + 60000, 31000L, aVar);
                        } catch (JException e2) {
                            if (e2.code != -997) {
                                k63.l("TcpReporter", "recv failed with error:" + e2);
                            }
                        }
                    }
                }
                f(context, ipPort, 0);
                if (this.f21525a.get()) {
                    k63.l("TcpReporter", "Break receiving by wantStop");
                } else {
                    k63.l("TcpReporter", NetworkUtil.NETWORK_CLASS_DISCONNECTED);
                }
            }
        } catch (Throwable th) {
            k63.m("TcpReporter", "socket exception", th);
        }
    }

    public final synchronized void w(Context context, IpPort ipPort, b bVar) {
        Pair<Integer, ur> pair = this.b.get(ipPort);
        ur urVar = pair != null ? (ur) pair.second : null;
        if (urVar == null) {
            this.b.put(ipPort, new Pair<>(Integer.valueOf(n()), new zx3(30720, 19)));
            wz4.a("ONCE_TASK", new a(context, 1, ipPort));
        } else if (urVar.c()) {
            u(context, ((Integer) pair.first).intValue(), urVar, ipPort, bVar);
        }
    }

    public final void x(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        IpPort ipPortFromString = IpPort.fromString(jSONArrayOptJSONArray.getString(i));
                        if (ipPortFromString != null && ipPortFromString.isLegal()) {
                            linkedHashSet.add(ipPortFromString);
                        }
                    }
                }
                map.put(next, linkedHashSet);
            }
            if (map.isEmpty()) {
                return;
            }
            this.d = map;
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends gt5 implements Runnable {
        public Context c;
        public int d;
        public final Object e;
        public int f;

        public a(Context context, Object obj) {
            this.c = context;
            this.e = obj;
        }

        @Override // defpackage.gt5
        public void a(Message message) {
            int i = message.what;
            if (i >= 60000) {
                if (this.e instanceof IpPort) {
                    k63.a("TcpReporter", "time to idle=" + this.e);
                    vt5.i().f(this.c, (IpPort) this.e, 0);
                    return;
                }
                return;
            }
            if (i >= 50000) {
                Object obj = this.e;
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    k63.a("TcpReporter", "onTimeout=" + bVar);
                    vt5.i().s(bVar.g, bVar.f);
                    vt5.i().t(this.c, bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int i = this.d;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            Object obj = this.e;
                            if (obj instanceof b) {
                                b bVar = (b) obj;
                                k63.a("TcpReporter", "onResult, data=" + bVar + " code=" + this.f);
                                JCoreManager.onEvent(this.c, "JCore", 61, "", null, Integer.valueOf(this.f), bVar.b, bVar.c, Integer.valueOf(bVar.f21526a), bVar.d, bVar.e, bVar.j);
                            }
                        }
                    } else if (this.e instanceof IpPort) {
                        vt5.i().p(this.c, (IpPort) this.e);
                    }
                } else if (this.e instanceof IpPort) {
                    vt5.i().v(this.c, (IpPort) this.e);
                }
            } catch (Throwable unused) {
            }
        }

        public a(Context context, int i, Object obj) {
            this.c = context;
            this.d = i;
            this.e = obj;
        }
    }
}
