package com.bytedance.adsdk.ugeno.pn.fx;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.location.LocationConst;
import com.bytedance.adsdk.ugeno.pn.t;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends nr implements com.bytedance.adsdk.ugeno.u.nr {
    private String t;

    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr
    public void nr() {
        t tVar;
        if ((TextUtils.equals(this.t, "complete") || TextUtils.isEmpty(this.t)) && (tVar = this.u) != null) {
            tVar.u(this.nr, this.iz, this.fx.nr());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pn.fx.nr
    public boolean u(Object... objArr) {
        com.bytedance.adsdk.ugeno.nr.fx fxVar;
        com.bytedance.adsdk.ugeno.nr.fx fxVarNr;
        com.bytedance.adsdk.ugeno.u.u uVarJk;
        Map<String, String> map = this.pn;
        if (map != null && map.size() > 0) {
            String str = this.pn.get("name");
            this.t = this.pn.get(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
            if (!TextUtils.isEmpty(str) && (fxVarNr = (fxVar = this.nr).nr(fxVar)) != null && (uVarJk = fxVarNr.iz(str).jk(str)) != null) {
                uVarJk.u(this);
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.u.nr
    public void u() {
        t tVar;
        if ((TextUtils.equals(this.t, "start") || TextUtils.isEmpty(this.t)) && (tVar = this.u) != null) {
            tVar.u(this.nr, this.iz, this.fx.nr());
        }
    }
}
