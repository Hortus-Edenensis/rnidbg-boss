package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static c aWA = null;
    private static HandlerThread aWB = null;
    private static Handler aWC = null;
    private static int aWr = -1;
    private static volatile boolean aWs;
    private static List<HttpDnsInfo.IpInfo> aWt = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> aWu = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> aWv = new CopyOnWriteArrayList();
    private static List<c> aWw = new CopyOnWriteArrayList();
    private static List<c> aWx = new CopyOnWriteArrayList();
    private static PriorityBlockingQueue<c> aWy = new PriorityBlockingQueue<>();
    private static AtomicInteger aWz = new AtomicInteger(0);
    private static volatile boolean aWD = false;
    private static float aWE = -1.0f;
    private static float aWF = -1.0f;
    private static float aWG = -1.0f;
    private static int aWH = 0;
    private static volatile boolean aWI = false;
    private static volatile boolean aWJ = false;
    private static NetworkMonitor.a aWK = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange");
            if (!a.aWJ) {
                a.access$002(true);
            } else {
                a.access$102(true);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            }
        }
    };
    private static Runnable aWL = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.Oq();
        }
    };

    private static void J(List<HttpDnsInfo.IpInfo> list) {
        b(list, aWw);
        if (aWw.isEmpty()) {
            return;
        }
        Iterator<c> it = aWw.iterator();
        float fOG = 0.0f;
        while (it.hasNext()) {
            fOG += it.next().OG();
        }
        aWE = fOG / aWw.size();
    }

    private static void K(List<HttpDnsInfo.IpInfo> list) {
        b(list, aWx);
        if (aWx.isEmpty()) {
            return;
        }
        int weight = 0;
        float weight2 = 0.0f;
        for (c cVar : aWx) {
            if (cVar != null) {
                weight += cVar.getWeight();
                weight2 += cVar.getWeight() * cVar.OG();
            }
        }
        if (weight != 0) {
            aWF = weight2 / weight;
        }
    }

    private static void OA() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo next;
        c cVar = aWA;
        String ip = cVar == null ? "" : cVar.getIp();
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = aWt.iterator();
        while (true) {
            ipInfo = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && TextUtils.equals(ip, next.ip)) {
                break;
            }
        }
        if (next != null) {
            aWt.remove(next);
            next = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = aWu.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next2 = it2.next();
            if (next2 != null && TextUtils.equals(ip, next2.ip)) {
                next = next2;
                break;
            }
        }
        if (next != null) {
            aWu.remove(next);
        } else {
            ipInfo = next;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = aWv.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next3 = it3.next();
            if (next3 != null && TextUtils.equals(ip, next3.ip)) {
                ipInfo = next3;
                break;
            }
        }
        if (ipInfo != null) {
            aWv.remove(ipInfo);
        }
    }

    private static void OB() {
        c next;
        if (aWA == null) {
            return;
        }
        List<c> list = aWw;
        if (list != null && !list.isEmpty() && aWw.contains(aWA)) {
            aWw.remove(aWA);
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sRecommendEntityList remove:" + aWA);
        }
        List<c> list2 = aWx;
        if (list2 != null && !list2.isEmpty()) {
            if (aWx.contains(aWA)) {
                aWx.remove(aWA);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + aWA);
            }
            Iterator<c> it = aWx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && TextUtils.equals(next.getIp(), aWA.getIp())) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set removeEntity:" + next.getIp());
                    break;
                }
            }
            if (next != null) {
                aWx.remove(next);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + next);
            }
        }
        c cVarPeek = aWy.peek();
        if (cVarPeek != null && cVarPeek == aWA) {
            aWy.poll();
        }
        aWA = null;
    }

    private static void Ol() {
        Handler handler;
        if (aWD || (handler = aWC) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static String Om() {
        c cVar = aWA;
        return cVar != null ? cVar.getIp() : "";
    }

    public static float On() {
        return aWE;
    }

    public static float Oo() {
        return aWF;
    }

    public static float Op() {
        return aWG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Oq() {
        Ov();
        List<HttpDnsInfo.IpInfo> list = aWt;
        List<HttpDnsInfo.IpInfo> list2 = aWu;
        clear();
        if (aWD) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "start pick");
        aWD = true;
        J(list);
        K(list2);
        if (aWw.isEmpty() && aWx.isEmpty()) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar == null) {
                aWD = false;
                return;
            } else {
                if (!hVar.Dq()) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isIpPreferEnable:false");
                    aWD = false;
                    return;
                }
                Ot();
            }
        }
        aWD = false;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "end pick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Or() {
        if (Os()) {
            return;
        }
        Ou();
    }

    private static boolean Os() {
        List<c> list = aWw;
        List<c> list2 = aWx;
        if (!list.isEmpty()) {
            aWA = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from recommend:" + aWA);
            aWH = 1;
            return true;
        }
        int i = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int weight = 0;
        for (c cVar : list2) {
            if (cVar != null) {
                weight += cVar.getWeight();
            }
        }
        if (weight <= 0) {
            return false;
        }
        int iNextInt = random.nextInt(weight);
        int i2 = 0;
        while (true) {
            if (i2 >= list2.size()) {
                break;
            }
            if (list2.get(i2) != null) {
                iNextInt -= list2.get(i2).getWeight();
            }
            if (iNextInt < 0) {
                i = i2;
                break;
            }
            i2++;
        }
        aWA = list2.get(i);
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from backUp:" + aWA);
        aWH = 2;
        return true;
    }

    private static void Ot() {
        List<HttpDnsInfo.IpInfo> list = aWv;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c cVarF = b.f(ipInfo.ip, aWr);
                if (cVarF.isSuccess()) {
                    aWy.offer(cVarF);
                }
            }
        }
        c cVarPeek = aWy.peek();
        if (cVarPeek != null) {
            aWG = cVarPeek.OG();
        }
    }

    private static void Ou() {
        if (aWy.isEmpty()) {
            return;
        }
        c cVarPeek = aWy.peek();
        if (cVarPeek.OG() < aWr) {
            aWA = cVarPeek;
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from Other:" + aWA);
            aWH = 3;
        }
    }

    private static void Ov() {
        if (aWr == -1) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar != null) {
                aWr = hVar.Dr();
            } else {
                aWr = 200;
            }
        }
    }

    private static boolean Ow() {
        if (aWI) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i = aWz.get();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "value:" + i);
        return i <= 3;
    }

    private static void Ox() {
        aWz.getAndIncrement();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "addFailedTimes:" + aWz.intValue());
    }

    public static void Oy() {
        c cVar;
        Handler handler;
        if (!aWs || (cVar = aWA) == null || TextUtils.isEmpty(cVar.getIp()) || (handler = aWC) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void Oz() {
        Ox();
        OA();
        OB();
        aWH = 0;
        Or();
        Oq();
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean zDp = hVar.Dp();
        aWs = zDp;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isEnable:" + zDp);
        if (zDp) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", httpDnsInfo.toString());
            List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
            aWt = list;
            aWu = httpDnsInfo.backUpList;
            aWv = httpDnsInfo.otherList;
            if (list.isEmpty() && aWu.isEmpty() && aWv.isEmpty()) {
                com.kwad.sdk.core.d.c.w("IpDirect_Helper", "HttpDnsInfo is empty");
            } else {
                init();
                Ol();
            }
        }
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        aWJ = true;
        return true;
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        aWI = true;
        return true;
    }

    private static void b(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", ipInfo.toString());
                c cVarF = b.f(ipInfo.ip, aWr);
                cVarF.er(ipInfo.weight);
                if (cVarF.isSuccess() && cVarF.OG() < aWr) {
                    list2.add(cVarF);
                }
            }
        }
    }

    private static void clear() {
        aWw.clear();
        aWx.clear();
        aWy.clear();
    }

    public static int getType() {
        return aWH;
    }

    @Nullable
    public static String go(String str) {
        if (!aWs) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost return by sIpDirectEnable false");
            return "";
        }
        if (gp(str)) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isHostInvalid:false ：" + str);
            return "";
        }
        if (!Ow()) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "canUseIpDirect:false");
            return "";
        }
        String strOm = Om();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost ip:" + strOm);
        return strOm;
    }

    private static boolean gp(String str) {
        boolean z = !TextUtils.equals("https://" + str, com.kwad.sdk.h.Co());
        if (z) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "非核心域名 current host:" + com.kwad.sdk.h.Co() + "try direct host:https://" + str);
        }
        return z;
    }

    private static void init() {
        if (aWB != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        aWB = handlerThread;
        handlerThread.start();
        aWC = new Handler(aWB.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            @Override // android.os.Handler
            public final void handleMessage(@NonNull Message message) {
                int i = message.what;
                if (i == 1) {
                    a.Oq();
                    a.Or();
                } else {
                    if (i != 2) {
                        return;
                    }
                    a.Oz();
                }
            }
        };
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            NetworkMonitor.getInstance().a(fVar.getContext(), aWK);
        }
    }
}
