package com.bytedance.adsdk.nr.nr.nr.u;

import com.oplus.tblplayer.Constants;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class bg implements com.bytedance.adsdk.nr.nr.nr.nr {
    private com.bytedance.adsdk.nr.nr.nr.u fx;
    private com.bytedance.adsdk.nr.nr.nr.u nr;
    private com.bytedance.adsdk.nr.nr.nr.u u;

    @Override // com.bytedance.adsdk.nr.nr.nr.nr
    public void fx(com.bytedance.adsdk.nr.nr.nr.u uVar) {
        this.fx = uVar;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.nr
    public void nr(com.bytedance.adsdk.nr.nr.nr.u uVar) {
        this.nr = uVar;
    }

    public String toString() {
        return nr();
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        Object objU = this.u.u(map);
        if (objU == null) {
            return null;
        }
        return ((Boolean) objU).booleanValue() ? this.nr.u(map) : this.fx.u(map);
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public String nr() {
        return this.u.nr() + Constants.STRING_VALUE_UNSET + this.nr.nr() + ":" + this.fx.nr();
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public com.bytedance.adsdk.nr.nr.b.pn u() {
        return com.bytedance.adsdk.nr.nr.b.iz.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.nr
    public void u(com.bytedance.adsdk.nr.nr.nr.u uVar) {
        this.u = uVar;
    }
}
