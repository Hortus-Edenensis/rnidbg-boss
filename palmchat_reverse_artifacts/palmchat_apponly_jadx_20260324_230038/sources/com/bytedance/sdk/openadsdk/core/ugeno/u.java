package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.widget.x;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements sx, rh.u, nr {
    private ja b;
    private x.u fx;
    private Context nr;
    private bc pn;
    private com.bytedance.adsdk.ugeno.nr.fx<View> u;
    private com.bytedance.sdk.openadsdk.core.ugeno.n.x x;
    private AtomicBoolean n = new AtomicBoolean(false);
    private final rh iz = new rh(Looper.getMainLooper(), this);

    public u(Context context, bc bcVar) {
        this.nr = context;
        this.pn = bcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar) {
        this.x = xVar;
        k kVar = new k(this.nr);
        s sVar = new s();
        sVar.u(this.nr);
        HashMap map = new HashMap();
        ja jaVar = new ja(this.nr);
        this.b = jaVar;
        jaVar.u(this.fx);
        this.b.u(this);
        this.b.nr(u(jSONObject2));
        String strNr = jp.nr(this.pn);
        this.b.fx(jp.nr(strNr));
        this.b.u(strNr);
        map.put("key_js_object", this.b);
        map.put("key_material", this.pn);
        sVar.nr(jSONObject2);
        sVar.u(map);
        kVar.u("easy_dl_dialog", sVar);
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVarU = kVar.u(jSONObject);
        this.u = fxVarU;
        if (fxVarU == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar2 = this.x;
            if (xVar2 != null) {
                xVar2.u(-1, "UGenWidget is null");
                return;
            }
            return;
        }
        kVar.u(this);
        kVar.nr(jSONObject2);
        rh rhVar = this.iz;
        if (rhVar != null) {
            rhVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
    }

    public void u(x.u uVar) {
        this.fx = uVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // com.bytedance.adsdk.ugeno.fx.sx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(my myVar, sx.nr nrVar, sx.u uVar) {
        JSONObject jSONObjectFx;
        if (myVar == null || this.fx == null) {
            return;
        }
        if (myVar.nr() != 1 || (jSONObjectFx = myVar.fx()) == null) {
        }
        String strOptString = jSONObjectFx.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                this.fx.nr(null);
                break;
            case "openAppFunctionDesc":
                this.fx.u();
                break;
            case "closeDialog":
                this.fx.fx(null);
                break;
            case "downloadEvent":
                this.fx.u(null);
                break;
            case "openAppPolicy":
                this.fx.b(null);
                break;
        }
    }

    public void u(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nr(jSONObject, jSONObject2, xVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.nr(jSONObject, jSONObject2, xVar);
                }
            });
        }
    }

    private JSONObject u(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_dl_dialog")) == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("app_name", jSONObjectOptJSONObject.opt("app_name"));
            jSONObject2.put("app_version", jSONObjectOptJSONObject.opt("app_version"));
            jSONObject2.put(WfConstant.EXTRA_KEY_DEVELOPER_NAME, jSONObjectOptJSONObject.opt(WfConstant.EXTRA_KEY_DEVELOPER_NAME));
            jSONObject2.put("package_name", jSONObjectOptJSONObject.opt("package_name"));
            jSONObject2.put("score", jSONObjectOptJSONObject.opt("score"));
            jSONObject2.put("icon_url", jSONObjectOptJSONObject.opt("icon_url"));
            jSONObject2.put("description", jSONObjectOptJSONObject.opt("description"));
            jSONObject2.put("creative_tags", jSONObjectOptJSONObject.opt("creative_tags"));
            jSONObject2.put("easy_pl_material", jSONObjectOptJSONObject.opt("easy_pl_material"));
            jSONObject3.put("ugen_download_dialog", jSONObject2);
            return jSONObject3;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void nr() {
        rh rhVar = this.iz;
        if (rhVar == null) {
            return;
        }
        rhVar.removeMessages(1);
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message == null || message.what != 1 || this.n.get()) {
            return;
        }
        if (this.x != null) {
            this.n.set(true);
            this.x.u(10, "load time out");
        }
        nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.nr
    public void u() {
        nr();
        if (this.n.get() || this.x == null) {
            return;
        }
        this.n.set(true);
        this.x.u(this.u);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.nr
    public void u(int i, String str) {
        nr();
        if (this.n.get() || this.x == null) {
            return;
        }
        this.n.set(true);
        this.x.u(i, str);
    }
}
