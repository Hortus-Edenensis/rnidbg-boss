package com.bytedance.sdk.openadsdk.core.d.u;

import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.q.iz;
import com.bytedance.sdk.openadsdk.core.y.u;
import com.huawei.openalliance.ad.constant.bq;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.config.EventParams;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bytedance.sdk.openadsdk.core.q.nr.nr {
    private com.bytedance.sdk.openadsdk.core.component.nr n;
    private List<com.bytedance.sdk.openadsdk.core.d.u> x = new CopyOnWriteArrayList();
    int u = 0;
    int nr = 0;
    int fx = 0;
    boolean b = false;
    boolean pn = false;
    u.nr iz = new u.nr() { // from class: com.bytedance.sdk.openadsdk.core.d.u.nr.1
        @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
        public void u() {
            if (n.o().ja()) {
                return;
            }
            nr nrVar = nr.this;
            if (nrVar.pn || nrVar.n == null || nr.this.n.pn == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("ad_load_id", nr.this.n.u);
                jSONObject.putOpt("ad_show_id", nr.this.n.u());
                jSONObject.putOpt("node_line_version", "1.0.0");
                jSONObject.putOpt("unexpected_type", Integer.valueOf(nr.this.fx));
                jSONObject.putOpt("bidding_type", Integer.valueOf(com.bytedance.sdk.openadsdk.core.d.nr.u(nr.this.n)));
                jSONObject.putOpt("node_line", com.bytedance.sdk.openadsdk.core.d.nr.u((List<com.bytedance.sdk.openadsdk.core.d.u>) nr.this.x));
                jSONObject.putOpt("node_line_detail", com.bytedance.sdk.openadsdk.core.d.nr.nr((List<com.bytedance.sdk.openadsdk.core.d.u>) nr.this.x));
                jSONObject.putOpt("creative_id", nr.this.n.pn.lk());
                jSONObject.putOpt(ReportItem.RequestKeyRequestId, nr.this.n.pn.xx());
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_EXTRA, nr.this.n.pn.ap());
                jSONObject.putOpt(EventParams.KEY_PARAM_ADTYPE, Integer.valueOf(nr.this.n.nr));
                jSONObject.putOpt("rit", nr.this.n.fx);
                jSONObject.putOpt("ad_info", nr.this.n.pn.yf());
                jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
                jSONObject.putOpt("need_node_line_detail", Boolean.valueOf(nr.this.nr()));
                com.bytedance.sdk.openadsdk.core.d.nr.u("key_tt_csj_node_line_" + nr.this.n.u(), jSONObject.toString());
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
        public void nr() {
        }
    };

    @Override // com.bytedance.sdk.openadsdk.core.q.nr.nr
    public void b(com.bytedance.sdk.openadsdk.core.component.nr nrVar, iz izVar) {
        if (u()) {
            this.n = nrVar;
            n.o().b().u(this.iz);
        }
        if (!this.b && !nrVar.x.isEmpty()) {
            this.b = true;
            this.x.addAll(0, nrVar.x);
        }
        this.x.add(new com.bytedance.sdk.openadsdk.core.d.u("ad_show", "click", izVar != null ? izVar.u() : System.currentTimeMillis()));
        this.nr++;
        if (this.u == 0) {
            this.fx = 2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q.nr.nr
    public void pn(com.bytedance.sdk.openadsdk.core.component.nr nrVar, iz izVar) {
        if (this.pn) {
            return;
        }
        this.pn = true;
        n.o().b().nr(this.iz);
        this.x.add(new com.bytedance.sdk.openadsdk.core.d.u("ad_show", "end", izVar != null ? izVar.u() : System.currentTimeMillis(), nrVar.b));
        u(nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.q.nr.nr
    public void fx(com.bytedance.sdk.openadsdk.core.component.nr nrVar, iz izVar) {
        if (u()) {
            this.n = nrVar;
            n.o().b().u(this.iz);
        }
        if (!this.b && !nrVar.x.isEmpty()) {
            this.b = true;
            this.x.addAll(0, nrVar.x);
        }
        boolean zVp = dw.nr().vp();
        if (!nrVar.iz || zVp) {
            this.u++;
            this.x.add(new com.bytedance.sdk.openadsdk.core.d.u("ad_show", bq.b.V, izVar != null ? izVar.u() : System.currentTimeMillis()));
            if (this.u > 1) {
                this.fx = 1;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q.nr.nr
    public void nr(com.bytedance.sdk.openadsdk.core.component.nr nrVar, iz izVar) {
        this.x.add(new com.bytedance.sdk.openadsdk.core.d.u("ad_show", "start", izVar != null ? izVar.u() : System.currentTimeMillis()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.q.nr.nr
    public void u(com.bytedance.sdk.openadsdk.core.component.nr nrVar, iz izVar) {
        this.x.add(new com.bytedance.sdk.openadsdk.core.d.u("ad_show", "create", izVar != null ? izVar.u() : System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nr() {
        return dw.nr().gs();
    }

    private void u(com.bytedance.sdk.openadsdk.core.component.nr nrVar) {
        Iterator<com.bytedance.sdk.openadsdk.core.d.u> it = this.x.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (nrVar == null || nrVar.pn == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.nr.u(this.x);
        if (!(this.u == 0 && this.nr == 0) && u()) {
            com.bytedance.sdk.openadsdk.core.d.nr.u(this.x, nrVar, nr(), this.fx);
            com.bytedance.sdk.openadsdk.core.d.nr.u(nrVar.u());
        }
    }

    private boolean u() {
        return dw.nr().lc();
    }
}
