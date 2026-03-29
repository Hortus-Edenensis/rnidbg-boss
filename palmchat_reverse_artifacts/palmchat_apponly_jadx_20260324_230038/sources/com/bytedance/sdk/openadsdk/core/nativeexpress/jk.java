package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.kj.bc;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk implements com.bytedance.adsdk.ugeno.fx.c, com.bytedance.sdk.component.adexpress.nr.a {
    private String b;
    private bc fx;
    private long iz;
    private String nr;
    private long pn;
    private com.bytedance.sdk.openadsdk.iz.u u;
    private com.bytedance.sdk.openadsdk.s.n x;

    public jk(com.bytedance.sdk.openadsdk.iz.u uVar, String str, bc bcVar, String str2) {
        this.u = uVar;
        this.nr = str;
        this.b = str2;
        this.fx = bcVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void a() {
        this.u.fx();
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void b() {
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void iz() {
        this.u.u();
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void jk() {
        this.u.u(true);
        this.u.pn();
        com.bytedance.sdk.component.jk.x.fx(new com.bytedance.sdk.component.jk.a("native_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.jk.2
            @Override // java.lang.Runnable
            public void run() {
                a.u(jk.this.nr, jk.this.b, jk.this.fx);
                com.bytedance.sdk.openadsdk.core.s.b.x(jk.this.fx, jk.this.nr, "dynamic_backup_render", null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void l() {
        this.u.s();
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void mv() {
        this.u.nr();
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void n() {
        this.u.nr();
        com.bytedance.sdk.openadsdk.s.n nVar = this.x;
        if (nVar == null) {
            return;
        }
        nVar.x(kj.u(this.fx));
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void pn() {
    }

    public void s() {
        this.u.k();
        this.u.my();
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void t() {
        this.u.u(true);
        this.u.mv();
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void u(boolean z) {
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void x() {
        com.bytedance.sdk.openadsdk.s.n nVar = this.x;
        if (nVar == null) {
            return;
        }
        nVar.iz(kj.u(this.fx));
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void b(int i) {
        if (i == 3) {
            this.u.nr("dynamic_sub_render2_start");
        } else {
            this.u.nr("dynamic_sub_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void fx(int i) {
        if (i == 3) {
            this.u.nr("dynamic_sub_analysis2_end");
        } else {
            this.u.nr("dynamic_sub_analysis_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void iz(int i) {
        final String str;
        this.iz = System.currentTimeMillis();
        if (i == 3) {
            this.u.fx("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.u.fx("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.u.u(true);
        com.bytedance.sdk.component.jk.x.fx(new com.bytedance.sdk.component.jk.a("dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.jk.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.s.b.x(jk.this.fx, jk.this.nr, str, null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void nr(boolean z) {
        this.u.u(z ? 1 : 0);
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void pn(int i) {
        if (i == 3) {
            this.u.nr("dynamic_sub_render2_end");
        } else {
            this.u.nr("dynamic_sub_render_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void nr(int i) {
        if (i == 3) {
            this.u.nr("dynamic_sub_analysis2_start");
        } else {
            this.u.nr("dynamic_sub_analysis_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void u(int i, String str) {
        this.u.u(i, str);
        a.u(i, this.nr, this.b, this.fx);
        com.bytedance.sdk.openadsdk.s.n nVar = this.x;
        if (nVar == null) {
            return;
        }
        nVar.u(true, kj.u(this.fx), 105);
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void fx() {
        this.u.b("ugen_sub_render_start");
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void nr() {
        this.u.b("ugen_sub_analysis_end");
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void u(int i) {
        this.pn = System.currentTimeMillis();
        if (i == 3) {
            this.u.u("dynamic_render2_start");
        } else {
            this.u.u("dynamic_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.a
    public void u(int i, int i2, String str, boolean z) {
        this.u.u(true);
        if (i == 3) {
            this.u.nr(i2, "dynamic_render2_error");
        } else {
            this.u.nr(i2, "dynamic_render_error");
        }
        a.u(i2, this.nr, this.b, this.fx);
    }

    public void u(com.bytedance.sdk.openadsdk.s.n nVar) {
        this.x = nVar;
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void u() {
        this.u.b("ugen_render_start");
        this.u.b("ugen_sub_analysis_start");
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void u(com.bytedance.adsdk.ugeno.fx.dw dwVar) {
        if (dwVar.u() == 0) {
            this.u.b("ugen_sub_render_end");
            this.u.pn("ugen_render_success");
        } else {
            this.u.fx(dwVar.u(), "ugen_render_error");
        }
        this.u.u(true);
    }

    @Override // com.bytedance.adsdk.ugeno.fx.c
    public void u(JSONObject jSONObject) {
        this.u.u(jSONObject);
    }
}
