package com.bytedance.sdk.openadsdk.core.pn.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.n;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private static final Map<String, AtomicBoolean> fx = new ConcurrentHashMap();
    private final com.bytedance.sdk.openadsdk.core.pn.b.nr nr;
    u u;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public int b = 7232;
        public String fx;
        public long nr;
        public String pn;
        public long u;

        public nr(String str, long j, long j2, String str2) {
            this.u = j;
            this.nr = j2;
            this.fx = str;
            this.pn = str2;
        }

        public boolean u() {
            return (TextUtils.isEmpty(this.fx) || this.u == 0) ? false : true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final int b;
        private final boolean fx;
        private final int iz;
        private final int nr;
        private final int pn;
        private final String u;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.pn.b.x$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0281u {
            private int nr;
            private String u = "Default";
            private boolean fx = true;
            private int b = 1;
            private int pn = 0;
            private int iz = 1;

            public C0281u fx(int i) {
                this.b = i;
                return this;
            }

            public C0281u nr(int i) {
                this.iz = i;
                return this;
            }

            public C0281u u(String str) {
                this.u = str;
                return this;
            }

            public C0281u u(boolean z) {
                this.fx = z;
                return this;
            }

            public C0281u u(int i) {
                this.pn = i;
                return this;
            }

            public u u() {
                return new u(this);
            }
        }

        public int b() {
            return this.iz;
        }

        public int fx() {
            return this.b;
        }

        public boolean nr() {
            return this.fx;
        }

        private u(C0281u c0281u) {
            this.u = c0281u.u;
            this.nr = c0281u.nr;
            this.fx = c0281u.fx;
            this.pn = c0281u.pn;
            this.iz = c0281u.iz;
            this.b = c0281u.b;
        }

        public String u() {
            return this.u;
        }
    }

    public x(int i) {
        u uVarU = u(i);
        this.u = uVarU;
        if (uVarU.pn != 1) {
            this.nr = new fx();
        } else {
            this.nr = new b();
        }
    }

    private AtomicBoolean b(String str) {
        Map<String, AtomicBoolean> map = fx;
        if (!map.containsKey(str)) {
            map.put(str, new AtomicBoolean(false));
        }
        return map.get(str);
    }

    public void fx(String str) {
        try {
            if (b(str).compareAndSet(false, true)) {
                System.currentTimeMillis();
                this.nr.nr(str);
                System.currentTimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void nr(String str) {
        try {
            this.nr.u(str, this.u, dw.nr().wo() ? new com.bytedance.sdk.openadsdk.core.pn.b.u() { // from class: com.bytedance.sdk.openadsdk.core.pn.b.x.2
                @Override // com.bytedance.sdk.openadsdk.core.pn.b.u
                public void u(nr nrVar) {
                    try {
                        bc bcVarU = com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(com.bytedance.sdk.component.utils.u.fx(nrVar.fx)));
                        bcVarU.pm().b(2);
                        com.bytedance.sdk.openadsdk.core.s.b.fx(bcVarU, "embeded_ad");
                    } catch (Exception unused) {
                    }
                }
            } : null);
        } catch (Throwable unused) {
        }
    }

    public void u(String str, nr nrVar, boolean z, long j, int i) {
        try {
            com.bytedance.sdk.openadsdk.core.pn.b.u uVar = dw.nr().ba() ? new com.bytedance.sdk.openadsdk.core.pn.b.u() { // from class: com.bytedance.sdk.openadsdk.core.pn.b.x.1
                @Override // com.bytedance.sdk.openadsdk.core.pn.b.u
                public void u(nr nrVar2) {
                    try {
                        bc bcVarU = com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(com.bytedance.sdk.component.utils.u.fx(nrVar2.fx)));
                        bcVarU.pm().b(3);
                        com.bytedance.sdk.openadsdk.core.s.b.fx(bcVarU, "embeded_ad");
                    } catch (Exception unused) {
                    }
                }
            } : null;
            iz izVar = new iz();
            izVar.u = z;
            izVar.nr = (int) j;
            izVar.fx = i;
            this.nr.u(str, nrVar, izVar, this.u, uVar);
        } catch (Throwable unused) {
        }
    }

    public nr u(String str, boolean z, long j) {
        nr nrVarU;
        try {
            synchronized (b(str)) {
                System.currentTimeMillis();
                nrVarU = this.nr.u(str, this.u, j);
                if (nrVarU != null && nrVarU.u()) {
                    if (z) {
                        this.nr.u(str, nrVarU.pn, true);
                    }
                    System.currentTimeMillis();
                }
            }
            return nrVarU;
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<nr> u(String str, boolean z, long j, int i) {
        ArrayList<nr> arrayList = new ArrayList();
        try {
            synchronized (b(str)) {
                System.currentTimeMillis();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < i; i2++) {
                    nr nrVarU = this.nr.u(str, this.u, j, arrayList2);
                    if (nrVarU == null || !nrVarU.u()) {
                        break;
                    }
                    arrayList2.add(nrVarU.pn);
                    arrayList.add(nrVarU);
                }
                for (nr nrVar : arrayList) {
                    if (z) {
                        this.nr.u(str, nrVar.pn, true);
                    }
                    System.currentTimeMillis();
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    public nr u(String str, long j, List<String> list) {
        nr nrVarU;
        try {
            synchronized (b(str)) {
                System.currentTimeMillis();
                nrVarU = this.nr.u(str, this.u, j, list);
                if (nrVarU != null && nrVarU.u()) {
                    System.currentTimeMillis();
                }
            }
            return nrVarU;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void u() {
        try {
            this.nr.u(this.u);
        } catch (Throwable unused) {
        }
    }

    public void u(String str) {
        try {
            this.nr.u(str);
        } catch (Throwable unused) {
        }
    }

    public void u(String str, String str2, boolean z) {
        try {
            synchronized (b(str)) {
                this.nr.u(str, str2, z);
            }
        } catch (Throwable unused) {
        }
    }

    public void u(String str, String str2) {
        try {
            synchronized (b(str)) {
                this.nr.u(str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    private u u(int i) {
        String str;
        n.nr nrVarU = n.u(i);
        switch (i) {
            case 1:
                str = "Banner";
                break;
            case 2:
            default:
                str = "Default";
                break;
            case 3:
            case 4:
                str = ExploreConstants.SCENE_SPLASH;
                break;
            case 5:
                str = ExploreConstants.SCENE_FEED;
                break;
            case 6:
                str = "Stream";
                break;
            case 7:
                str = ExploreConstants.SCENE_REWARD;
                break;
            case 8:
                str = ExploreConstants.SCENE_FULL;
                break;
            case 9:
                str = "Draw";
                break;
        }
        if (nrVarU == null) {
            return new u.C0281u().u();
        }
        return new u.C0281u().u(str).u(nrVarU.n()).u(nrVarU.pn()).nr(nrVarU.nr()).fx(nrVarU.fx()).u();
    }
}
