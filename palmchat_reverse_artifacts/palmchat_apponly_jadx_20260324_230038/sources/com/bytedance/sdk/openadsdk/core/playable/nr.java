package com.bytedance.sdk.openadsdk.core.playable;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static volatile nr u;
    private int b;
    private final long fx;
    private LruCache<String, com.bytedance.sdk.openadsdk.core.playable.u.u> nr;
    private CopyOnWriteArrayList<String> pn = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<String> iz = new CopyOnWriteArrayList<>();
    private ConcurrentHashMap<String, WeakReference<com.bytedance.sdk.openadsdk.core.dw.fx>> x = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> n = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f5356a = new Object();

    private nr() {
        int iEn = dw.nr().en();
        this.b = iEn;
        if (iEn > 30) {
            this.b = 30;
        } else if (iEn < 0) {
            this.b = 5;
        }
        this.fx = dw.nr().tq() * 1000;
        this.nr = new LruCache<String, com.bytedance.sdk.openadsdk.core.playable.u.u>(this.b) { // from class: com.bytedance.sdk.openadsdk.core.playable.nr.1
            @Override // android.util.LruCache
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, com.bytedance.sdk.openadsdk.core.playable.u.u uVar) {
                return 1;
            }
        };
    }

    public static /* synthetic */ void u(nr nrVar, String str) {
    }

    private void b(final bc bcVar) {
        if (TextUtils.isEmpty(bcVar.vu())) {
            return;
        }
        final String strVu = bcVar.vu();
        if (this.pn.contains(strVu) || this.iz.contains(strVu) || this.nr.get(strVu) != null) {
            return;
        }
        this.pn.add(strVu);
        this.n.put(strVu, Long.valueOf(System.currentTimeMillis()));
        x.nr(new a("playable_prefetch") { // from class: com.bytedance.sdk.openadsdk.core.playable.nr.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nr.this.u(bcVar, strVu);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public long fx(bc bcVar) {
        try {
            if (this.n == null || bcVar == null || TextUtils.isEmpty(bcVar.vu())) {
                return 0L;
            }
            return this.n.get(bcVar.vu()).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public void nr(bc bcVar) {
        if (bcVar != null) {
            try {
                if (TextUtils.isEmpty(bcVar.vu())) {
                    return;
                }
                String strVu = bcVar.vu();
                this.iz.add(strVu);
                this.nr.remove(strVu);
                this.pn.remove(strVu);
                this.x.remove(strVu);
                this.n.remove(strVu);
                this.nr.size();
                this.pn.size();
                this.iz.size();
            } catch (Exception unused) {
            }
        }
    }

    public static nr u() {
        if (u == null) {
            synchronized (nr.class) {
                if (u == null) {
                    u = new nr();
                }
            }
        }
        return u;
    }

    public void u(bc bcVar) {
        if (bcVar != null) {
            try {
                if (bcVar.bt() == 3) {
                    b(bcVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(bc bcVar, final String str) {
        com.bytedance.sdk.openadsdk.core.gi.nr.u(bcVar, bcVar == null ? null : bcVar.yy(), new com.bytedance.sdk.openadsdk.core.dw.fx() { // from class: com.bytedance.sdk.openadsdk.core.playable.nr.3
            @Override // com.bytedance.sdk.openadsdk.core.dw.fx
            public void u(boolean z, List<bc> list, boolean z2) {
                try {
                    if (nr.this.iz != null && nr.this.iz.contains(str)) {
                        nr.u(nr.this, "prefetchCache-onAdLoaded.. discardTask. key: " + str);
                        return;
                    }
                    nr.u(nr.this, "prefetchCache-onAdLoaded.. success: ".concat(String.valueOf(z)));
                    synchronized (nr.this.f5356a) {
                        if (!z || list == null) {
                            nr.this.pn.remove(str);
                        } else {
                            if (list.size() > 0) {
                                com.bytedance.sdk.openadsdk.core.playable.u.u uVar = new com.bytedance.sdk.openadsdk.core.playable.u.u();
                                uVar.u = list;
                                uVar.nr = z;
                                uVar.fx = SystemClock.elapsedRealtime();
                                nr.this.nr.put(str, uVar);
                                nr.u(nr.this, "prefetchCache-onAdLoaded.. 缓存save  key: " + str);
                            }
                            nr.this.pn.remove(str);
                        }
                    }
                    WeakReference weakReference = (WeakReference) nr.this.x.get(str);
                    com.bytedance.sdk.openadsdk.core.dw.fx fxVar = weakReference == null ? null : (com.bytedance.sdk.openadsdk.core.dw.fx) weakReference.get();
                    if (fxVar != null) {
                        fxVar.u(z, list, true);
                        nr.this.x.remove(str);
                        nr.u(nr.this, "prefetchCache-onAdLoaded..callback invoke key: " + str);
                    }
                } catch (Exception unused) {
                }
            }
        }, (com.bytedance.sdk.openadsdk.my.fx.fx.nr) null);
    }

    public boolean u(bc bcVar, com.bytedance.sdk.openadsdk.core.dw.fx fxVar) {
        if (bcVar != null && !TextUtils.isEmpty(bcVar.vu())) {
            String strVu = bcVar.vu();
            try {
                synchronized (this.f5356a) {
                    if (this.pn.contains(strVu)) {
                        this.x.put(strVu, new WeakReference<>(fxVar));
                        return true;
                    }
                    com.bytedance.sdk.openadsdk.core.playable.u.u uVar = this.nr.get(strVu);
                    if (uVar == null) {
                        return false;
                    }
                    if (u(uVar)) {
                        nr(bcVar);
                        return false;
                    }
                    if (fxVar != null) {
                        fxVar.u(uVar.nr, uVar.u, true);
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean u(com.bytedance.sdk.openadsdk.core.playable.u.u uVar) {
        return this.fx > 0 && uVar != null && SystemClock.elapsedRealtime() - uVar.fx > this.fx;
    }
}
