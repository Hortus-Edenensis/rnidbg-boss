package com.bytedance.sdk.openadsdk.core.ugeno.jk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.s.x;
import com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz;
import com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.openadsdk.core.ugeno.n.u {
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> c;
    private int q;
    private boolean qq;

    public b(Context context, ViewGroup viewGroup, x xVar, bc bcVar, String str, int i) {
        super(context, viewGroup, xVar, bcVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int fx() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void iz() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.u
    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> l() {
        this.c = new ArrayList();
        JSONObject jSONObjectEt = this.pn.et();
        this.c.add(0, new com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx(jSONObjectEt, -1221270899));
        this.c.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx(jSONObjectEt, -2134548432));
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int nr() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void pn() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public long u() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void fx(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void iz(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
        JSONObject jSONObjectJk;
        if (fxVar == null || (jSONObjectJk = fxVar.jk()) == null) {
            return;
        }
        Object objB = fxVar.b("video_".concat(String.valueOf(jSONObjectJk.optInt("image_mode"))));
        if (objB instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) objB).lf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void nr(int i) {
    }

    public void pn(int i) {
        this.q = i;
        if (i < 0) {
            return;
        }
        final String str = String.format("浏览%d秒可领金币", Integer.valueOf(i));
        if (this.x instanceof iz) {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.jk.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.n.u) b.this).x != null) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) ((iz) ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) b.this).x).u();
                            if (recyclerView.getScrollState() != 0 || recyclerView.s()) {
                                return;
                            }
                            ((iz) ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) b.this).x).u(0, "header");
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            ((iz) this.x).u(new pn.b() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.jk.b.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn.b
                public void u(RecyclerView.q qVar, int i2) {
                    com.bytedance.adsdk.ugeno.nr.fx fxVarB = ((pn.C0294pn) qVar).gi().b("count_down");
                    if (fxVarB instanceof com.bytedance.adsdk.ugeno.widget.text.nr) {
                        ((com.bytedance.adsdk.ugeno.widget.text.nr) fxVarB).t(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void b(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
        u(fxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.fx
    public void fx(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        bc bcVarU;
        if (fxVar == null || (bcVarU = com.bytedance.sdk.openadsdk.core.u.u(fxVar.jk())) == null) {
            return;
        }
        u(bcVarU, fxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(int i, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void u(RecyclerView recyclerView, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void pn(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
        if (fxVar == null) {
            return;
        }
        if (this.q <= 0 && !this.qq && TextUtils.equals(fxVar.ja(), "header")) {
            pn(0);
            this.qq = true;
        }
        JSONObject jSONObjectJk = fxVar.jk();
        if (jSONObjectJk == null) {
            return;
        }
        Object objB = fxVar.b("video_".concat(String.valueOf(jSONObjectJk.optInt("image_mode"))));
        if (objB instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) objB;
            nrVar.u(this.mv);
            nrVar.ay();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void u(int i, int i2) {
        if (i2 > 0) {
            this.jk.set(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, int i, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx fxVar2) {
        if (fxVar2 == null || fxVar2.u() == null) {
            return;
        }
        int iHashCode = fxVar2.u().hashCode();
        if (this.t.get(Integer.valueOf(iHashCode)) != null && this.t.containsKey(Integer.valueOf(iHashCode)) && this.t.get(Integer.valueOf(iHashCode)).booleanValue()) {
            return;
        }
        u(fxVar2.u());
        this.t.put(Integer.valueOf(iHashCode), Boolean.TRUE);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void jk() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void n() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void t() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void x() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void setPauseFromExpressView(boolean z) {
    }
}
