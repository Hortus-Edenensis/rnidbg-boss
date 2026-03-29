package com.bytedance.sdk.openadsdk.core.nr.u.fx;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.gi;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.my.b;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends nr {
    protected Map<String, Object> iz;
    private com.bytedance.sdk.openadsdk.core.video.nr.nr l;
    protected boolean n;
    protected a pn;
    private String t;
    protected String x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5347a = -1;
    private int jk = -1;
    private boolean mv = false;

    public u() {
    }

    private void iz() {
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
        long j = fxVarU.get("click_to_live_duration", 0L);
        if (j == 0) {
            Map<String, Object> map = this.iz;
            if (map != null) {
                map.remove("click_livead_duration");
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        HashMap map2 = new HashMap();
        map2.put("click_livead_duration", Long.valueOf(jCurrentTimeMillis));
        u(map2);
        fxVarU.get("click_to_live_duration", 0L);
    }

    public a b() {
        int i = this.f5347a;
        if (i != -1) {
            this.f5347a = -1;
        } else {
            i = -1;
        }
        float fIz = y.iz(this.nr);
        int iN = y.n(this.nr);
        float fX = y.x(this.nr);
        View viewA = this.fx.a();
        View viewN = this.fx.n();
        return new a.u().iz(this.fx.my()).pn(this.fx.o()).b(this.fx.sx()).fx(this.fx.bg()).nr(this.fx.s()).u(this.fx.k()).nr(y.u(viewA)).u(y.u(viewN)).fx(y.fx(viewA)).b(y.fx(viewN)).fx(this.fx.b()).b(this.fx.pn()).pn(this.fx.iz()).u(this.fx.l()).nr(n.o().fx() ? 1 : 2).u(this.t).u(fIz).u(iN).nr(fX).iz(i).x(this.jk).n(this.fx.dw()).pn(this.fx.bq()).u(this.fx.fx()).u(this.fx.nr()).u();
    }

    public String fx() {
        return this.t;
    }

    public void nr(boolean z) {
        this.n = z;
    }

    public Map<String, Object> pn() {
        return this.iz;
    }

    public void u(boolean z) {
        this.mv = z;
    }

    public void nr() {
        this.jk = 1;
    }

    public void u(String str) {
        this.x = str;
    }

    public void nr(String str) {
        this.t = str;
    }

    public void u() {
        this.f5347a = 1;
    }

    public void u(a aVar) {
        this.pn = aVar;
    }

    public u(bc bcVar, Context context) {
        this.u = bcVar;
        this.nr = context;
        this.iz = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.u.fx.nr, com.bytedance.sdk.openadsdk.core.nr.u.u
    public int u(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.nr.u.fx fxVar) {
        if (this.mv) {
            return 0;
        }
        com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar = this.l;
        if (nrVar != null && nrVar.t() == 1) {
            return 0;
        }
        if (this.fx == null) {
            this.fx = new jk();
        }
        if (WifiNestConst.NestTypeConst.NEST_SPLASH_AD.equals(this.x) || "cache_splash_ad".equals(this.x) || "splash_ad_landingpage".equals(this.x)) {
            this.f5347a = this.f5347a == 1 ? 1 : 0;
        }
        Object obj = map.get("convert_res");
        boolean zBooleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
        if (this.pn == null) {
            this.pn = b();
        }
        Object obj2 = map.get("is_reward_live");
        if (obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false) {
            iz();
        }
        if (map.containsKey("reward_browse_banner_from")) {
            this.iz.put("refer", MediationConstant.RIT_TYPE_BANNER);
        }
        if (gi.u(this.u) && !b.u(String.valueOf(jp.t(this.u))) && this.u.tw() != null) {
            this.iz.put("refresh_num", Integer.valueOf(this.u.tw().fx()));
        }
        Object obj3 = map.get("click_saas_action");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.iz.put("click_saas_action", obj3);
        }
        Object obj4 = map.get("click_saas_area");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.iz.put("click_saas_area", obj4);
        }
        u(true);
        com.bytedance.sdk.openadsdk.core.s.b.u("click", this.u, this.pn, this.x, zBooleanValue, this.iz, this.fx.x() ? 1 : 2, this.n, this.fx.u());
        return 0;
    }

    public void u(Map<String, Object> map) {
        Map<String, Object> map2 = this.iz;
        if (map2 == null) {
            this.iz = map;
        } else {
            map2.putAll(map);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar) {
        this.l = nrVar;
    }
}
