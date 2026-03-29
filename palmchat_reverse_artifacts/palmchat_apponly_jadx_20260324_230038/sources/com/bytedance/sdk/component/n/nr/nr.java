package com.bytedance.sdk.component.n.nr;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.n.u.a;
import com.bytedance.sdk.component.n.u.b;
import com.bytedance.sdk.component.n.u.iz;
import com.bytedance.sdk.component.n.u.pn;
import com.bytedance.sdk.component.n.u.x;
import com.bytedance.sdk.component.utils.bq;
import com.bytedance.sdk.component.utils.k;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements x {
    private static volatile com.bytedance.sdk.component.n.u.u.u b;
    private a fx;
    private Context nr;
    private pn u;

    public nr(com.bytedance.sdk.component.n.u.u uVar) {
        u(uVar);
    }

    public static com.bytedance.sdk.component.n.u.u.u iz() {
        if (b == null) {
            synchronized (nr.class) {
                if (b == null) {
                    b = new com.bytedance.sdk.component.n.nr.pn.u();
                }
            }
        }
        return b;
    }

    private boolean x() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    @Override // com.bytedance.sdk.component.n.u.x
    public a b() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.n.u.x
    public pn fx() {
        pn pnVar = this.u;
        if (pnVar == null) {
            return null;
        }
        return pnVar;
    }

    public void nr(pn pnVar) {
        this.u = pnVar;
        this.nr = pnVar.getContext();
        this.fx = new com.bytedance.sdk.component.n.nr.nr.nr(this.u);
    }

    @Override // com.bytedance.sdk.component.n.u.x
    public b pn() {
        pn pnVar = this.u;
        if (pnVar == null) {
            return null;
        }
        return pnVar.b();
    }

    public nr() {
    }

    private void nr(final com.bytedance.sdk.component.n.u.nr nrVar) {
        pn pnVar = this.u;
        if (pnVar != null && this.fx != null) {
            final b bVarB = pnVar.b();
            if (nrVar == null || bVarB == null || this.u.getContext() == null || bVarB.iz() == null) {
                return;
            }
            if (this.u.t()) {
                if (u(this.u.getContext(), bVarB)) {
                    this.fx.u(nrVar);
                    return;
                }
                x();
                if (x()) {
                    bVarB.iz().execute(new com.bytedance.sdk.component.n.nr.pn.nr("dispatchEvent") { // from class: com.bytedance.sdk.component.n.nr.nr.2
                        @Override // java.lang.Runnable
                        public void run() {
                            nr.this.u(nrVar, bVarB.n());
                        }
                    });
                    return;
                } else {
                    u(nrVar, bVarB.n());
                    return;
                }
            }
            this.fx.u(nrVar);
            return;
        }
        k.nr("log_error", "dispatch event configManager is null");
    }

    public void u(pn pnVar) {
        nr(pnVar);
    }

    @Override // com.bytedance.sdk.component.n.u.x
    public void u(iz izVar) {
        pn pnVar = this.u;
        if (pnVar != null) {
            if (izVar == null) {
                izVar = com.bytedance.sdk.component.n.nr.u.u.u.nr.u;
            }
            pnVar.u(izVar);
        }
    }

    @Override // com.bytedance.sdk.component.n.u.x
    public void u(boolean z) {
        pn pnVar = this.u;
        if (pnVar != null) {
            pnVar.u(z);
        }
    }

    private boolean u(Context context, b bVar) {
        if (context == null || bVar == null) {
            return false;
        }
        if (bVar.n() == 1) {
            return bVar.k();
        }
        try {
            return bq.u(context);
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // com.bytedance.sdk.component.n.u.x
    public void u() {
        final b bVarB;
        pn pnVar = this.u;
        if (pnVar == null || (bVarB = pnVar.b()) == null || this.u.getContext() == null || bVarB.iz() == null) {
            return;
        }
        if (this.u.t()) {
            if (u(this.u.getContext(), bVarB)) {
                a aVar = this.fx;
                if (aVar != null) {
                    aVar.u();
                    return;
                }
                return;
            }
            if (x()) {
                bVarB.iz().execute(new com.bytedance.sdk.component.n.nr.pn.nr("start") { // from class: com.bytedance.sdk.component.n.nr.nr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pn unused = nr.this.u;
                        nr.this.u(bVarB.n());
                    }
                });
                return;
            } else {
                u(bVarB.n());
                return;
            }
        }
        a aVar2 = this.fx;
        if (aVar2 != null) {
            aVar2.u();
        }
    }

    @Override // com.bytedance.sdk.component.n.u.x
    public void nr() {
        a aVar = this.fx;
        if (aVar != null) {
            aVar.nr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i) {
        if (i == 0 || i == 2) {
            com.bytedance.sdk.component.n.nr.nr.nr.u.u(this.u);
        } else if (i == 1) {
            com.bytedance.sdk.component.n.nr.nr.nr.nr.nr(this.u);
        }
    }

    @Override // com.bytedance.sdk.component.n.u.x
    public void u(com.bytedance.sdk.component.n.u.nr nrVar) {
        nr(nrVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.component.n.u.nr nrVar, int i) {
        if (i == 0 || i == 2) {
            com.bytedance.sdk.component.n.nr.nr.nr.u.u(nrVar, this.u);
        } else if (i == 1) {
            com.bytedance.sdk.component.n.nr.nr.nr.nr.u(nrVar, this.u);
        }
    }

    @Override // com.bytedance.sdk.component.n.u.x
    public void u(final String str, final List<String> list, final boolean z, Map<String, String> map, final JSONObject jSONObject) {
        pn pnVar = this.u;
        if (pnVar == null) {
            k.nr("log_error", "track configManager is null");
            return;
        }
        final b bVarB = pnVar.b();
        if (bVarB == null || this.u.getContext() == null || bVarB.iz() == null || !bVarB.jk()) {
            return;
        }
        if (bVarB.n() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (bVarB.n() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (this.u.t() && !u(this.u.getContext(), bVarB)) {
            if (x()) {
                bVarB.iz().execute(new com.bytedance.sdk.component.n.nr.pn.nr("trackFailed") { // from class: com.bytedance.sdk.component.n.nr.nr.3
                    @Override // java.lang.Runnable
                    public void run() {
                        nr.this.u(str, (List<String>) list, z, bVarB.n(), jSONObject);
                    }
                });
                return;
            } else {
                u(str, list, z, bVarB.n(), jSONObject);
                return;
            }
        }
        com.bytedance.sdk.component.n.nr.iz.u.u(this.u).u(str, list, z, map, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, List<String> list, boolean z, int i, JSONObject jSONObject) {
        if (i == 0) {
            com.bytedance.sdk.component.n.nr.nr.nr.u.u(str, list, z, this.u, jSONObject);
        } else if (i == 1) {
            com.bytedance.sdk.component.n.nr.nr.nr.nr.u(str, list, z, this.u);
        }
    }

    @Override // com.bytedance.sdk.component.n.u.x
    public void u(final String str) {
        pn pnVar = this.u;
        if (pnVar == null) {
            com.bytedance.sdk.component.n.nr.fx.fx.u("log_error", "trackFailedUrls configManager is null", pnVar);
            return;
        }
        final b bVarB = pnVar.b();
        if (bVarB == null || this.u.getContext() == null || bVarB.iz() == null || !bVarB.jk()) {
            return;
        }
        if (bVarB.n() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (this.u.t() && !u(this.u.getContext(), bVarB)) {
            if (x()) {
                bVarB.iz().execute(new com.bytedance.sdk.component.n.nr.pn.nr("trackFailed") { // from class: com.bytedance.sdk.component.n.nr.nr.4
                    @Override // java.lang.Runnable
                    public void run() {
                        nr.this.u(str, bVarB.n());
                    }
                });
                return;
            } else {
                u(str, bVarB.n());
                return;
            }
        }
        com.bytedance.sdk.component.n.nr.iz.u.u(this.u).u(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.n.nr.nr.nr.u.u(str, this.u);
        } else if (i == 1) {
            com.bytedance.sdk.component.n.nr.nr.nr.nr.u(str, this.u);
        }
    }
}
