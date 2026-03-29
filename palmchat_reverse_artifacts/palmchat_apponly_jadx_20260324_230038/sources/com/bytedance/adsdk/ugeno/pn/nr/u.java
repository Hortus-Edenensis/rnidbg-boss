package com.bytedance.adsdk.ugeno.pn.nr;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.dc;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u {
    public static final HashSet<String> u = new HashSet<>(Arrays.asList("convert", "dislike", "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", "close", dc.F, "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    protected String b;
    protected com.bytedance.adsdk.ugeno.nr.fx fx;
    protected Map<String, String> iz;
    protected String n;
    protected iz.u nr;
    protected String pn;
    protected String x;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.pn.nr.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0172u {
        public static u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
            if (uVar == null) {
                return null;
            }
            com.bytedance.adsdk.ugeno.pn.nr nrVarU = com.bytedance.adsdk.ugeno.pn.b.u(uVar.nr());
            if (nrVarU == null) {
                return new fx(fxVar, str, uVar);
            }
            u uVarU = nrVarU.u(fxVar, str, uVar);
            return uVarU == null ? new fx(fxVar, str, uVar) : uVarU;
        }
    }

    public u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
        this.fx = fxVar;
        this.nr = uVar;
        this.x = str;
        pn();
    }

    private void pn() {
        iz.u uVar = this.nr;
        if (uVar == null) {
            return;
        }
        this.b = uVar.u();
        this.pn = this.nr.nr();
        Map<String, String> mapFx = this.nr.fx();
        this.iz = mapFx;
        if (mapFx == null || mapFx.isEmpty() || !this.iz.containsKey("emitCustomEvent")) {
            return;
        }
        this.n = this.iz.get("emitCustomEvent");
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.n);
    }

    public void fx() {
        if (b()) {
            iz.u uVar = new iz.u();
            uVar.u(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
            uVar.nr("emit");
            HashMap map = new HashMap();
            map.put("name", this.n);
            uVar.u(map);
            new nr(this.fx, this.pn, uVar).u();
        }
    }

    public void nr() {
        fx();
    }

    public abstract void u();
}
