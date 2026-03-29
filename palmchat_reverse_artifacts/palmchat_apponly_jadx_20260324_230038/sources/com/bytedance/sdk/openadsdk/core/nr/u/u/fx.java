package com.bytedance.sdk.openadsdk.core.nr.u.u;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.nr.u.u.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.x;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.huawei.openalliance.ad.constant.az;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends u {
    private int iz;
    private boolean n;
    private x x;

    private boolean a() {
        if (this.u == null || jk() || !bc.nr(this.u)) {
            return false;
        }
        if (this.iz == 0) {
            this.iz = jp.jk(this.u);
        }
        pn();
        x();
        iz();
        if (this.iz == 5 && t() && x() && !pn() && !iz()) {
            return false;
        }
        int i = this.iz;
        return i == 1 || i == 2 || i == 5;
    }

    private boolean jk() {
        return this.n;
    }

    private boolean n() {
        return a() && nr(this.b) && !this.pn.nr();
    }

    private boolean nr(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof NativeVideoTsView) || view.getId() == 2114387961 || view.getId() == 2114387664 || view.getId() == 2114387957 || view.getId() == 2114387764 || view.getId() == 2114387686 || view.getId() == 2114387626) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (nr(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean t() {
        bc bcVar = this.u;
        return bcVar != null && bcVar.mk() == 1 && bc.nr(this.u);
    }

    public boolean iz() {
        x xVar = this.x;
        if (xVar == null) {
            return false;
        }
        return xVar.nr();
    }

    public boolean pn() {
        x xVar = this.x;
        if (xVar == null) {
            return false;
        }
        return xVar.u();
    }

    public boolean x() {
        bc bcVar = this.u;
        if (bcVar == null) {
            return true;
        }
        int iIz = dw.nr().iz(jp.t(bcVar));
        if (iIz == 1) {
            return o.b(this.nr);
        }
        if (iIz == 2) {
            return o.pn(this.nr) || o.b(this.nr) || o.iz(this.nr);
        }
        if (iIz != 3) {
            return iIz != 5 || o.b(this.nr) || o.iz(this.nr);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.u.u.u, com.bytedance.sdk.openadsdk.core.nr.u.u
    public int u(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.nr.u.fx fxVar) {
        boolean z;
        nr(this.u.qf());
        fx();
        final u.InterfaceC0278u interfaceC0278uU = this.pn.u();
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nr.u.u.fx.1
            @Override // java.lang.Runnable
            public void run() {
                u.InterfaceC0278u interfaceC0278u = interfaceC0278uU;
                if (interfaceC0278u != null) {
                    interfaceC0278u.u(((com.bytedance.sdk.openadsdk.core.nr.u.u) fx.this).b, fx.this.pn.fx());
                }
            }
        });
        Map<String, Object> mapN = this.pn.n();
        String strQ = this.fx.q();
        if (TextUtils.isEmpty(strQ)) {
            strQ = "clickEvent";
        }
        String str = strQ;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        mapN.put("click_from_uchain", 1);
        mapN.put("event_type", str);
        jp.gi();
        HashMap map2 = new HashMap();
        map2.put("material_meta", this.u);
        map2.put("click_chain", fxVar);
        map2.put("dpa_tag", this.fx.c());
        map2.put("context", this.nr);
        map2.put("event_tag", this.pn.a());
        map2.put(az.at, Integer.valueOf(this.pn.x()));
        map2.put("view", this.b);
        View view = this.b;
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            z = text != null && (text.toString().contains("下载") || text.toString().contains("安装"));
            if (this.b instanceof Button) {
                z = true;
            }
        } else {
            z = false;
        }
        map2.put("is_click_button", Boolean.valueOf(z || this.fx.fx()));
        map2.put("handle_chain_data", map);
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarIz = this.pn.iz();
        if (fxVarIz != null) {
            map2.put("download_adapter", fxVarIz);
            map2.put("is_market_covert", Boolean.valueOf(fxVarIz.fx()));
            map2.putAll(fxVarIz.pn());
        }
        Map<String, Object> mapU = com.bytedance.sdk.component.t.pn.u.u().u(this.u.hashCode() + this.u.xx());
        this.x = (x) c.u(this.u.pg(), x.class);
        Object objRemove = mapU.remove("is_express_ad");
        if (objRemove instanceof Boolean) {
            this.n = ((Boolean) objRemove).booleanValue();
        }
        map2.put("is_video_lp", Boolean.valueOf(n()));
        map2.putAll(mapU);
        Boolean bool = Boolean.FALSE;
        map2.put("convert_from_downloader", bool);
        map2.put("convert_from_landing_page", Boolean.valueOf(this.pn.nr()));
        map2.put("pip_controller", this.pn.l());
        com.bytedance.sdk.openadsdk.core.a.u.u.nr.u uVar = new com.bytedance.sdk.openadsdk.core.a.u.u.nr.u(this.u, this.nr, this.pn.a(), this.pn.x());
        uVar.u(!n() && this.pn.b());
        uVar.nr(this.pn.jk());
        map2.put("is_open_web_page", bool);
        uVar.nr(map2);
        map2.put("activity_type", Integer.valueOf(jp.u(uVar.u())));
        map2.put("is_feed_register_direct_download", Boolean.valueOf(this.fx.fx()));
        com.bytedance.sdk.openadsdk.core.a.u.b.u.u(this.u, mapN, str, map2, this.pn.a(), new HashMap());
        b();
        return 0;
    }
}
