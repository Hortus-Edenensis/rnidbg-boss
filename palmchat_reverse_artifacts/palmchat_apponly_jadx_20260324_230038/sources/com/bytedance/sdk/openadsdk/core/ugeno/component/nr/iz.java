package com.bytedance.sdk.openadsdk.core.ugeno.component.nr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.fx.a;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.nr.u;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends com.bytedance.adsdk.ugeno.nr.u<RecyclerView> {
    private pn.fx fn;
    private pn gb;
    private b gl;
    private Map<Integer, a.u> hs;
    private RecyclerView.a ki;
    private List<fx> te;
    private nr ti;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u();

        void u(int i, int i2);

        void u(int i, View view, fx fxVar);

        void u(RecyclerView recyclerView, int i);
    }

    public iz(Context context) {
        super(context);
        this.hs = new HashMap();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u
    public u.C0171u n() {
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(ViewGroup.LayoutParams layoutParams) {
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        pn pnVar = new pn(this.nr);
        this.gb = pnVar;
        pnVar.u(this.sf);
        this.gb.u(this.i);
        this.gb.u(this.qe);
        this.gb.u(this.gl);
        this.gb.u(this.fn);
        this.gb.u(this.hs);
        this.gb.u(this.te);
        ((RecyclerView) this.pn).setLayoutManager(this.ki);
        ((RecyclerView) this.pn).setAdapter(this.gb);
        ((RecyclerView) this.pn).u((RecyclerView.n) new u((int) n.u(this.nr, 10.0f)));
        ((RecyclerView) this.pn).u((RecyclerView.s) new com.bytedance.sdk.openadsdk.core.ugeno.component.nr.nr(new com.bytedance.sdk.openadsdk.core.ugeno.component.nr.u()) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.nr
            public void nr(RecyclerView recyclerView, int i) {
                if (iz.this.ti != null) {
                    iz.this.ti.u(recyclerView, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.nr
            public void u(int i, int i2) {
                if (iz.this.ti != null) {
                    iz.this.ti.u(i, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.nr
            public void u(int i, View view) {
                if (iz.this.ti == null || i < 0 || iz.this.te == null || i >= iz.this.te.size()) {
                    return;
                }
                iz.this.ti.u(i, view, (fx) iz.this.te.get(i));
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.nr
            public void u() {
                if (iz.this.ti != null) {
                    iz.this.ti.u();
                }
            }
        });
    }

    public void u(b bVar) {
        this.gl = bVar;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public View u() {
        return new RecyclerView(this.nr);
    }

    public void u(nr nrVar) {
        this.ti = nrVar;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(JSONObject jSONObject) {
        super.u(jSONObject);
    }

    public void u(List<fx> list) {
        this.te = list;
    }

    public void u(int i, Object obj) {
        pn pnVar = this.gb;
        if (pnVar != null) {
            pnVar.u(obj);
            this.gb.u(i, obj);
        }
    }

    public void u(pn.b bVar) {
        this.gb.u(bVar);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        if (fxVar == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.nr.u) this).u.add(fxVar);
        if (fxVar.ja() != null) {
            this.hs.put(Integer.valueOf(fxVar.ja().hashCode()), fxVar.d());
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void nr(List<fx> list) {
        if (this.gb == null || list == null || list.isEmpty()) {
            return;
        }
        if (this.te == null) {
            this.te = new ArrayList();
        }
        int size = this.te.size();
        this.te.addAll(list);
        this.gb.u(list);
        this.gb.u(size, this.te.size());
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        if (str.equals("layoutType") && !TextUtils.equals("grid", str2)) {
            this.ki = new com.bytedance.sdk.component.widget.recycler.pn(this.nr);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, ViewGroup.LayoutParams layoutParams) {
        ((com.bytedance.adsdk.ugeno.nr.u) this).u.add(fxVar);
        this.hs.put(Integer.valueOf(fxVar.ja().hashCode()), fxVar.d());
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends RecyclerView.n implements pn.u {
        private int u;

        public u(int i) {
            this.u = i;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn.u
        public View fx() {
            return null;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.n
        public void u(Rect rect, View view, RecyclerView recyclerView, RecyclerView.bq bqVar) {
            super.u(rect, view, recyclerView, bqVar);
            int i = this.u;
            rect.left = i;
            rect.right = i;
            rect.bottom = i;
            if (recyclerView.iz(view) == 0) {
                rect.top = this.u;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn.u
        public void L_() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn.u
        public void M_() {
        }
    }
}
