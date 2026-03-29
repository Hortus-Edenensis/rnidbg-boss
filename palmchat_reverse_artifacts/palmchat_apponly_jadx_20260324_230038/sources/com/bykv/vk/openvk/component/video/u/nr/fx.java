package com.bykv.vk.openvk.component.video.u.nr;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.component.video.u.nr.iz;
import com.bykv.vk.openvk.component.video.u.nr.nr;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {
    private static volatile fx pn;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashSet<u> f4971a;
    private final ExecutorService b;
    private final nr<Runnable> fx;
    private volatile com.bykv.vk.openvk.component.video.u.nr.nr.fx iz;
    private final nr.InterfaceC0160nr jk;
    private volatile boolean l;
    private volatile com.bykv.vk.openvk.component.video.u.nr.u.nr n;
    private final SparseArray<Map<String, com.bykv.vk.openvk.component.video.u.nr.nr>> nr;
    private volatile String t;
    private volatile int u = 163840;
    private volatile com.bykv.vk.openvk.component.video.u.nr.u.fx x;

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr<T> extends LinkedBlockingDeque<T> {
        private ThreadPoolExecutor u;

        private nr() {
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.u.getPoolSize();
                int activeCount = this.u.getActiveCount();
                int maximumPoolSize = this.u.getMaximumPoolSize();
                if (activeCount < poolSize || poolSize >= maximumPoolSize) {
                    return offerFirst(t);
                }
                int i = b.fx;
                return false;
            }
        }

        public void u(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.u != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.u = threadPoolExecutor;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        final String b;
        final int fx;
        final String[] iz;
        final boolean nr;
        final Map<String, String> pn;
        final boolean u;

        public u(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.u = z;
            this.nr = z2;
            this.fx = i;
            this.b = str;
            this.pn = map;
            this.iz = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || u.class != obj.getClass()) {
                return false;
            }
            u uVar = (u) obj;
            if (this.u == uVar.u && this.nr == uVar.nr && this.fx == uVar.fx) {
                return this.b.equals(uVar.b);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.u ? 1 : 0) * 31) + (this.nr ? 1 : 0)) * 31) + this.fx) * 31) + this.b.hashCode();
        }
    }

    private fx() {
        SparseArray<Map<String, com.bykv.vk.openvk.component.video.u.nr.nr>> sparseArray = new SparseArray<>(2);
        this.nr = sparseArray;
        this.f4971a = new HashSet<>();
        this.jk = new nr.InterfaceC0160nr() { // from class: com.bykv.vk.openvk.component.video.u.nr.fx.1
            @Override // com.bykv.vk.openvk.component.video.u.nr.nr.InterfaceC0160nr
            public void u(com.bykv.vk.openvk.component.video.u.nr.nr nrVar) {
                int iPn = nrVar.pn();
                synchronized (fx.this.nr) {
                    Map map = (Map) fx.this.nr.get(iPn);
                    if (map != null) {
                        map.remove(nrVar.n);
                    }
                }
                int i = b.fx;
            }
        };
        nr<Runnable> nrVar = new nr<>();
        this.fx = nrVar;
        ExecutorService executorServiceU = u(nrVar);
        this.b = executorServiceU;
        nrVar.u((ThreadPoolExecutor) executorServiceU);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public void nr() {
        com.bykv.vk.openvk.component.video.u.fx.u.u(new a("cancelAll") { // from class: com.bykv.vk.openvk.component.video.u.nr.fx.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                synchronized (fx.this.nr) {
                    int size = fx.this.nr.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) fx.this.nr.get(fx.this.nr.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    fx.this.fx.clear();
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.bykv.vk.openvk.component.video.u.nr.nr) it.next()).u();
                    int i2 = b.fx;
                }
            }
        });
    }

    public void u(com.bykv.vk.openvk.component.video.u.nr.u.fx fxVar) {
        this.x = fxVar;
    }

    public void u(com.bykv.vk.openvk.component.video.u.nr.nr.fx fxVar) {
        this.iz = fxVar;
    }

    public void u(int i) {
        if (i > 0) {
            this.u = i;
        }
        int i2 = b.fx;
    }

    public static fx u() {
        if (pn == null) {
            synchronized (fx.class) {
                if (pn == null) {
                    pn = new fx();
                }
            }
        }
        return pn;
    }

    public void u(boolean z, boolean z2, int i, String str, String... strArr) {
        u(z, z2, i, str, null, strArr);
    }

    public void u(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) {
        ArrayList arrayList;
        int i2 = b.fx;
        com.bykv.vk.openvk.component.video.u.nr.u.u uVar = z ? this.n : this.x;
        com.bykv.vk.openvk.component.video.u.nr.nr.fx fxVar = this.iz;
        if (uVar != null && fxVar != null) {
            if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
                return;
            }
            int i3 = i <= 0 ? this.u : i;
            String strU = z2 ? str : com.bykv.vk.openvk.component.video.api.iz.nr.u(str);
            File fileB = uVar.b(strU);
            if (fileB != null && fileB.length() >= i3) {
                if (b.pn) {
                    fileB.length();
                    return;
                }
                return;
            }
            synchronized (this.nr) {
                Map<String, com.bykv.vk.openvk.component.video.u.nr.nr> map2 = this.nr.get(z ? 1 : 0);
                if (map2.containsKey(strU)) {
                    return;
                }
                u uVar2 = new u(z, z2, i3, str, map, strArr);
                String str2 = this.t;
                if (str2 != null) {
                    int i4 = b.fx;
                    if (i4 == 3) {
                        synchronized (this.f4971a) {
                            this.f4971a.add(uVar2);
                        }
                        return;
                    } else {
                        if (i4 == 2) {
                            return;
                        }
                        if (i4 == 1 && this.l == z && str2.equals(strU)) {
                            return;
                        }
                    }
                }
                List<iz.nr> listU = com.bykv.vk.openvk.component.video.u.fx.u.u(com.bykv.vk.openvk.component.video.u.fx.u.u(map));
                if (listU != null) {
                    arrayList = new ArrayList(listU.size());
                    int size = listU.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        iz.nr nrVar = listU.get(i5);
                        if (nrVar != null) {
                            arrayList.add(new iz.nr(nrVar.u, nrVar.nr));
                        }
                    }
                } else {
                    arrayList = null;
                }
                com.bykv.vk.openvk.component.video.u.nr.nr nrVarU = new nr.u().u(uVar).u(fxVar).u(str).nr(strU).u(new n(com.bykv.vk.openvk.component.video.u.fx.u.u(strArr))).u((List<iz.nr>) arrayList).u(i3).u(this.jk).u(uVar2).u();
                map2.put(strU, nrVarU);
                this.b.execute(nrVarU);
                return;
            }
        }
        if (b.pn) {
            k.nr("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
        }
    }

    public void u(String str) {
        u(false, false, str);
    }

    public void u(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bykv.vk.openvk.component.video.u.fx.u.u(new a("cancel b b S") { // from class: com.bykv.vk.openvk.component.video.u.nr.fx.2
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.component.video.u.nr.nr nrVar;
                synchronized (fx.this.nr) {
                    Map map = (Map) fx.this.nr.get(com.bykv.vk.openvk.component.video.u.nr.nr.nr.u(z));
                    if (map != null) {
                        nrVar = (com.bykv.vk.openvk.component.video.u.nr.nr) map.remove(z2 ? str : com.bykv.vk.openvk.component.video.api.iz.nr.u(str));
                    } else {
                        nrVar = null;
                    }
                }
                if (nrVar != null) {
                    nrVar.u();
                }
            }
        });
    }

    private static ExecutorService u(final nr<Runnable> nrVar) {
        int iU = com.bykv.vk.openvk.component.video.u.fx.u.u();
        return new com.bytedance.sdk.component.jk.b.b(0, iU <= 0 ? 1 : iU > 4 ? 4 : iU, 60L, TimeUnit.SECONDS, nrVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.component.video.u.nr.fx.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.jk.b.fx fxVar = new com.bytedance.sdk.component.jk.b.fx(runnable) { // from class: com.bykv.vk.openvk.component.video.u.nr.fx.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable unused) {
                        }
                        super.run();
                    }
                };
                fxVar.setName("csj_video_preload_" + fxVar.getId());
                fxVar.setDaemon(true);
                if (b.pn) {
                    fxVar.getName();
                }
                return fxVar;
            }
        }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.component.video.u.nr.fx.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    nrVar.offerFirst(runnable);
                    int i = b.fx;
                } catch (Throwable unused) {
                }
            }
        });
    }
}
