package com.bytedance.sdk.openadsdk.core.component.reward.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.gi;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk extends u {
    private int ja;
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.u> rh;

    public jk(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        super(tTBaseVideoActivity, bcVar);
        this.rh = new ArrayList();
        this.ja = 0;
    }

    private com.bytedance.sdk.openadsdk.core.component.reward.layout.jk ju() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar = this.f5223a;
        if (nrVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) nrVar;
        }
        return null;
    }

    public static int nr(bc bcVar) {
        return 11;
    }

    public static boolean u(bc bcVar) {
        if (bcVar == null || !gi.u(bcVar)) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.my.b.u(String.valueOf(jp.t(bcVar)))) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", bcVar.en());
        } catch (JSONException unused) {
        }
        s.u().u(bcVar, "refresh_max", jSONObject);
        com.bytedance.sdk.openadsdk.core.s.b.x(bcVar, jp.nr(bcVar), "refresh_max", null);
        return false;
    }

    private int zx() {
        int iPn;
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.u uVar;
        bc bcVarU;
        gi giVarTw;
        com.bytedance.sdk.openadsdk.core.component.reward.layout.jk jkVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) this.f5223a;
        if (jkVar == null || (iPn = jkVar.pn()) < 0 || iPn >= this.rh.size() || (uVar = this.rh.get(iPn)) == null || (bcVarU = uVar.u()) == null || (giVarTw = bcVarU.tw()) == null) {
            return 0;
        }
        return giVarTw.fx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public View a() {
        FrameLayout frameLayout = new FrameLayout(this.u);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int bc() {
        return this.ja;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void c() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) this.f5223a).fx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void dw() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) this.f5223a).nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean eh() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u, com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void fx() {
        this.f5223a.fx(true);
        if (ju() != null) {
            ju().u(this.rh);
        }
        this.u.nr(false, true);
    }

    public void ge() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) this.f5223a).b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public boolean iz() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int jp() {
        return wi.fx(this.nr) - this.ja;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void k() {
        super.k();
        this.f5223a.jk();
        List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.u> list = this.rh;
        if (list != null) {
            Iterator<com.bytedance.sdk.openadsdk.core.component.reward.swiper.u> it = list.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean lf() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void n() {
        super.n();
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.u uVar = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.u(this.u, this.nr, this.l, lf(), true);
        uVar.u(this.mv);
        this.rh.add(uVar);
        if (gi.fx(this.nr)) {
            try {
                JSONArray jSONArray = new JSONArray(this.nr.lg());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(com.bytedance.sdk.openadsdk.core.u.u(jSONArray.getJSONObject(i)));
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.nr);
                arrayList2.addAll(arrayList);
                if (gi.u(arrayList2)) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        com.bytedance.sdk.openadsdk.core.component.reward.swiper.u uVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.u(this.u, (bc) arrayList.get(i2), this.l, lf(), false);
                        uVar2.u(this.mv);
                        this.rh.add(uVar2);
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean nb() {
        return true;
    }

    public void ob() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) this.f5223a).iz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void pn(boolean z) {
        super.pn(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void qq() {
        super.qq();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar = this.f5223a;
        if (nrVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) nrVar).jk();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int rh() {
        return nr(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void s() {
        super.s();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) this.f5223a).nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void wq() {
        super.wq();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar = this.f5223a;
        if (nrVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) nrVar).b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int x(boolean z) {
        return z ? jp() : wi.x(this.nr) - this.ja;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void za() {
        this.sx.u(false);
        this.sx.nr(false);
        this.sx.pn(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void nr(boolean z) {
        super.nr(z);
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.jk) this.f5223a).fx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void nr(Map<String, Object> map) {
        super.nr(map);
        map.put("refresh_num", Integer.valueOf(zx()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.nr u(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.jk jkVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.jk(this.u, this.nr, z);
        jkVar.u(new float[]{this.pn, this.iz});
        this.f5223a = jkVar;
        return jkVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public nr.u u(bc bcVar, final com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar) {
        this.u.y();
        com.bytedance.sdk.openadsdk.core.component.reward.fx.pn pnVar = new com.bytedance.sdk.openadsdk.core.component.reward.fx.pn(this.u, bcVar);
        pnVar.u(y());
        return pnVar.nr(new com.bytedance.sdk.openadsdk.core.component.reward.fx.jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.jk.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void fx() {
                super.fx();
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.fx();
                }
                jk.this.u.bc();
                jk.this.u.mh().u("reward_retain_dialog_next", 0, "");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void nr() {
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.nr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void u() {
                super.u();
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.u();
                }
                jk.this.u.bc();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void u(Map<String, Object> map) {
        super.u(map);
        map.put("refresh_num", Integer.valueOf(zx()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void u(JSONObject jSONObject) {
        super.u(jSONObject);
        try {
            jSONObject.put("refresh_num", zx());
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void u(View view) {
        super.u(view);
    }
}
