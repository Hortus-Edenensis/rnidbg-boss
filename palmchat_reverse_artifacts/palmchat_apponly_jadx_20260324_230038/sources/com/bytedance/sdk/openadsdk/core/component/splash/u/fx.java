package com.bytedance.sdk.openadsdk.core.component.splash.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz;
import com.bytedance.sdk.openadsdk.core.component.splash.u.u;
import com.bytedance.sdk.openadsdk.core.kj;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.lf;
import com.bytedance.sdk.openadsdk.core.kj.n;
import com.bytedance.sdk.openadsdk.core.pn.b.x;
import com.bytedance.sdk.openadsdk.core.y.jp;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends u {
    private volatile x t;
    static ConcurrentHashMap<String, nr> x = new ConcurrentHashMap<>();
    static ConcurrentHashMap<String, List<String>> n = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static ReferenceQueue<Object> f5273a = new ReferenceQueue<>();
    static Map<Object, nr> jk = new ConcurrentHashMap();

    private void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.t = new x(3);
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "NewCache 初始化耗时: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private static int iz() {
        if (n.u() == null) {
            return 1;
        }
        return n.u().b();
    }

    private void pn() {
        if (iz() != 3) {
            return;
        }
        try {
            for (Reference<? extends Object> referencePoll = f5273a.poll(); referencePoll != null; referencePoll = f5273a.poll()) {
                nr nrVar = jk.get(referencePoll);
                if (nrVar != null) {
                    u(nrVar.fx, nrVar.u);
                }
                jk.remove(referencePoll);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void fx() {
        if (this.t == null) {
            nr();
        }
        if (this.t != null) {
            this.t.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void nr() {
        if (this.t == null) {
            synchronized (this) {
                if (this.t == null) {
                    b();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void u(final lf lfVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z) {
        if (nrVar == null || lfVar == null || lfVar.u() == null) {
            return;
        }
        if (this.t == null) {
            nr();
        }
        try {
            final String strB = nrVar.b();
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "saveCache start >>  rit: " + strB + "  isUsing: " + z);
            final bc bcVarU = lfVar.u();
            String strXx = bcVarU.xx();
            String strNr = nr(strB, strXx);
            if (x.contains(strNr)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "save-updateMemoryRecord start >>  rit: " + strB + "  reqId: " + strXx);
            u(strNr, strB, strXx, z ? 2 : 1);
            u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.fx.1
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    fx.this.t.u(strB, new x.nr(com.bytedance.sdk.component.utils.u.nr(lfVar.nr().fx().toString()), bcVarU.ln(), 1000 * bcVarU.qn(), bcVarU.xx()), false, jp.o(bcVarU), bcVarU.bv());
                    com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "saveMeta >>  rit: " + strB + " saveDb cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                }
            });
        } catch (Throwable unused) {
        }
    }

    private String nr(String str, String str2) {
        return str + str2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar, final String str, u.InterfaceC0257u interfaceC0257u, pn pnVar) {
        final x.nr nrVarU;
        if (str == null || interfaceC0257u == null) {
            return;
        }
        if (this.t == null) {
            nr();
        }
        this.iz = pnVar;
        x.nr nrVar = null;
        iz izVar = null;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            pn();
            List<String> listU = u(str);
            StringBuilder sb = new StringBuilder("readcache start >>  rit: ");
            sb.append(str);
            sb.append("  usedReqIdList: ");
            sb.append(listU == null ? 0 : listU.size());
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", sb.toString());
            pn pnVar2 = this.iz;
            nrVarU = this.t.u(str, pnVar2 == null ? 0L : pnVar2.u, listU);
            try {
                com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "readcache-getCacheMeta cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable unused) {
                nrVar = nrVarU;
                nrVarU = nrVar;
            }
        } catch (Throwable unused2) {
        }
        if (nrVarU == null) {
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "readcache-cacheMeta: null ");
            if (xVar != null) {
                xVar.b(0);
                xVar.nr(1);
                xVar.u("no cache");
            }
            interfaceC0257u.u();
            return;
        }
        String str2 = nrVarU.pn;
        String strNr = nr(str, str2);
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "readcache-mapkey: " + strNr);
        nr nrVar2 = x.get(strNr);
        if (nrVar2 != null && nrVar2.nr > 1) {
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "readcache-cacheRecord != null && cacheRecord.status > CACHE_STATUS_NOUSE");
            if (xVar != null) {
                xVar.b(0);
                xVar.nr(1);
                xVar.u("no cache");
            }
            interfaceC0257u.u();
            return;
        }
        u(strNr, str, str2, 2);
        com.bytedance.sdk.openadsdk.core.kj.u uVar = kj.u.u(new JSONObject(com.bytedance.sdk.component.utils.u.fx(nrVarU.fx))).n;
        iz izVar2 = new iz(uVar, true);
        bc bcVar = (uVar == null || uVar.nr() == null || uVar.nr().isEmpty()) ? null : uVar.nr().get(0);
        if (bcVar != null) {
            izVar2.u(bcVar);
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "readcache-updateMemoryRecord start >>  rit: " + str + "  reqId: " + str2);
        if (com.bytedance.sdk.openadsdk.core.live.nr.u().fx(bcVar) != 3) {
            izVar = izVar2;
        } else {
            izVar2.u((bc) null);
        }
        interfaceC0257u.u(izVar);
        boolean zJk = com.bytedance.sdk.openadsdk.core.fx.pn.u().jk();
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "isSplashCacheRemoveChange: " + zJk);
        if (zJk) {
            return;
        }
        u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.fx.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    fx.this.t.u(str, nrVarU.pn);
                    com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "readcache-deleteCacheMeta start >>  rit: " + str + "  reqId: " + nrVarU.pn + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis2));
                } catch (Exception unused3) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b<a, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x> bVar, final bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z) {
        final String strB;
        String strXx;
        String strNr;
        if (bcVar == null || nrVar == null) {
            return;
        }
        if (this.t == null) {
            nr();
        }
        try {
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "removeCache>> start ");
            strB = nrVar.b();
            strXx = bcVar.xx();
            strNr = nr(strB, strXx);
        } catch (Throwable unused) {
        }
        if (this.pn.get()) {
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "removeCache-mIsRemoveCacheAd: true");
            return;
        }
        this.pn.set(true);
        u(strNr, strB, strXx, 3);
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "removeCache-updateMemoryRecord: 完成");
        u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.fx.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    fx.this.t.u(strB, bcVar.xx());
                    com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "removeCache-deleteCacheMeta  rit: " + strB + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                } catch (Throwable unused2) {
                }
            }
        });
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void u(String str, bc bcVar) {
        if (this.t == null) {
            nr();
        }
        if (this.t != null) {
            this.t.u(str, bcVar.xx());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void u(String str, String str2, boolean z, boolean z2, Object obj) {
        if (iz() != 3 || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z2 && z) {
            u(obj, str, str2);
        } else {
            u(str, str2);
        }
    }

    private void u(final Runnable runnable) {
        if (com.bytedance.sdk.openadsdk.gi.x.u()) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.fx.4
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    private List<String> u(String str) {
        List<String> list = n.get(str);
        StringBuilder sb = new StringBuilder("getUsedReqIdList: list : ");
        sb.append(list == null ? 0 : list.size());
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", sb.toString());
        return list;
    }

    private void u(String str, String str2, String str3, int i) {
        int iIz = iz();
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "updateMemoryRecord>> start rit: " + str2 + ", status: " + i + ", cacheStrategyType: " + iIz);
        if (iIz != 3) {
            return;
        }
        x.put(str, new nr(str3, i, str2));
        if (i <= 1) {
            com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "updateMemoryRecord>> :status <= CACHE_STATUS_NOUSE");
            return;
        }
        List<String> copyOnWriteArrayList = n.get(str2);
        StringBuilder sb = new StringBuilder("updateMemoryRecord>>: list1 : ");
        sb.append(copyOnWriteArrayList == null ? 0 : copyOnWriteArrayList.size());
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", sb.toString());
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(str3);
        } else if (copyOnWriteArrayList.contains(str3)) {
            return;
        } else {
            copyOnWriteArrayList.add(str3);
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "updateMemoryRecord>>: list2 : " + copyOnWriteArrayList.size());
        n.put(str2, copyOnWriteArrayList);
    }

    private void u(Object obj, String str, String str2) {
        try {
            nr nrVar = x.get(nr(str, str2));
            if (nrVar != null && obj != null) {
                PhantomReference phantomReference = new PhantomReference(obj, f5273a);
                com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", nrVar.fx + "，uuid：" + nrVar.u + " watching");
                jk.put(phantomReference, nrVar);
            }
        } catch (Exception unused) {
        }
    }

    private void u(String str, String str2) {
        x.remove(nr(str, str2));
        List<String> list = n.get(str);
        StringBuilder sb = new StringBuilder("checkCaches>>: list1 : ");
        sb.append(list == null ? 0 : list.size());
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", sb.toString());
        if (list == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "checkCaches>>: rmCache : " + str2);
        list.remove(str2);
        n.put(str, list);
    }
}
