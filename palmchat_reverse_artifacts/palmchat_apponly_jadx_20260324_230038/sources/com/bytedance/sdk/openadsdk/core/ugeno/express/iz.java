package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.fx.bq;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.adsdk.ugeno.pn.nr.u;
import com.bytedance.sdk.component.adexpress.nr.n;
import com.bytedance.sdk.component.adexpress.nr.x;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.tm;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.y.pb;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import j$.util.Map;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends b implements u {
    private com.bytedance.sdk.openadsdk.core.ugeno.express.u.nr c;
    private t dw;

    public iz(Context context, bc bcVar, nr nrVar, ViewGroup viewGroup) {
        super(context, bcVar, nrVar, viewGroup);
    }

    private void s() {
        s sVar = new s();
        HashMap map = new HashMap();
        map.put("shake_value", Integer.valueOf(this.x.sx()));
        map.put("calculation_method", Integer.valueOf(this.x.qq()));
        map.put("rotation_angle", Integer.valueOf(this.x.bq()));
        map.put("calculation_method_twist", Integer.valueOf(this.x.kj()));
        map.put("twist_config", this.x.dw());
        map.put("image_info", this.x.s());
        map.put("cache_dir", this.x.o());
        map.put("shake_interact_conf", this.x.c());
        map.put("twist_interact_conf", this.x.q());
        sVar.u(map);
        sVar.u(this.nr);
        sVar.u(this.b);
        sVar.nr(this.pn);
        this.u.u("ad", sVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.b
    public JSONObject jk() {
        return this.x.pn();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.b
    public void nr(x xVar) {
        s();
        this.u.u((sx) this);
        this.u.u((bq) this);
        tm tmVarX = tk.x(this.iz);
        try {
            if (tmVarX != null) {
                this.fx = this.u.u(this.b, this.pn, tmVarX.pn());
            } else {
                this.fx = this.u.u(this.b, this.pn, (JSONObject) null);
            }
            if (this.u.u()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("component_not_exist", new JSONArray((Collection) this.u.nr()));
                this.x.pb().u(jSONObject);
                xVar.u(138, "ugen unknown component");
                return;
            }
            if (this.fx != null) {
                if (this.bq == null) {
                    this.bq = new com.bytedance.sdk.openadsdk.core.ugeno.t.u(this.x.pn());
                }
                this.bq.u(this.u, this.fx);
            }
            this.x.pb().nr();
            this.x.pb().fx();
        } catch (NoClassDefFoundError unused) {
            if (xVar != null) {
                xVar.u(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, "ugen no class def found error");
            }
        } catch (UnsatisfiedLinkError unused2) {
            if (xVar != null) {
                xVar.u(139, "ugen yoga so load fail");
            }
        } catch (Throwable unused3) {
            if (xVar != null) {
                xVar.u(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, "ugen other fail");
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.b
    public com.bytedance.adsdk.ugeno.nr.fx pn() {
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = this.fx;
        if (fxVar == null) {
            return null;
        }
        return fxVar.pn("VideoV3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.b, com.bytedance.sdk.component.adexpress.dynamic.b
    public void u(CharSequence charSequence, int i, int i2, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.b
    public JSONObject u() {
        return this.x.pn().optJSONObject("xTemplate");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.b, com.bytedance.adsdk.ugeno.fx.sx
    public void u(final com.bytedance.adsdk.ugeno.nr.fx fxVar, final String str, final iz.u uVar) {
        if (uVar == null) {
            return;
        }
        if (!TextUtils.equals(str, "shake") && !TextUtils.equals(str, com.huawei.openalliance.ad.constant.x.cz)) {
            nr(fxVar, str, uVar);
            return;
        }
        WeakReference<ViewGroup> weakReference = this.s;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        pb.u(this.s, new com.bytedance.sdk.openadsdk.core.nr.fx() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.iz.1
            @Override // com.bytedance.sdk.openadsdk.core.nr.fx
            public void u() {
                WeakReference<ViewGroup> weakReference2 = iz.this.s;
                if (weakReference2 == null || weakReference2.get() == null || !pb.u(iz.this.s.get())) {
                    return;
                }
                iz.this.nr(fxVar, str, uVar);
            }
        });
    }

    private byte u(String str) {
        if (TextUtils.isEmpty(str)) {
            return (byte) 0;
        }
        str.hashCode();
        switch (str) {
        }
        return (byte) 0;
    }

    public void u(String str, Map<String, String> map) {
        if (this.fx == null) {
            return;
        }
        iz.u uVar = new iz.u();
        uVar.u(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
        uVar.nr("emit");
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("name", str);
        uVar.u(map2);
        u.C0172u.u(this.fx, "jsb", uVar).u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.u
    public void u(t tVar) {
        this.dw = tVar;
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.express.u.nr nrVar) {
        this.c = nrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
        int i;
        CharSequence text;
        String strNr = uVar.nr();
        if (com.bytedance.sdk.openadsdk.core.ugeno.express.u.u.u.contains(strNr)) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.u.u.u(this.dw, this.c, this.iz, this.nr, strNr, uVar, this.o, fxVar);
            return;
        }
        strNr.hashCode();
        i = 12;
        switch (strNr) {
            case "openAppPermission":
                i = 10;
                break;
            case "openCommonUrl":
                i = 13;
                break;
            case "openPrivacy":
                i = 7;
                break;
            case "resumeVideo":
                t tVar = this.dw;
                if (tVar != null) {
                    tVar.u(3);
                    return;
                }
                return;
            case "pauseVideo":
                t tVar2 = this.dw;
                if (tVar2 != null) {
                    tVar2.u(2);
                    return;
                }
                return;
            case "skip":
                i = 6;
                break;
            case "close":
                i = 8;
                break;
            case "openAppFunction":
                break;
            case "videoControl":
                i = 4;
                break;
            case "convert":
                i = 2;
                break;
            case "muteVideo":
                i = 5;
                break;
            case "openAppPolicy":
                i = 9;
                break;
            case "dislike":
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        q.u uVarU = new q.u().b(this.mv.my()).fx(this.mv.o()).nr(this.mv.sx()).u(this.mv.bg()).u(fxVar.ja()).nr(this.mv.s()).u(this.mv.k()).u(u(str));
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, com.huawei.openalliance.ad.constant.x.cz)) {
            try {
                jSONObject.put("convertActionType", 1);
            } catch (Throwable unused) {
            }
        }
        try {
            String strU = com.bytedance.adsdk.ugeno.b.nr.u((String) Map.EL.getOrDefault(uVar.fx(), "webUrl", ""), jk());
            String strU2 = com.bytedance.adsdk.ugeno.b.nr.u((String) Map.EL.getOrDefault(uVar.fx(), "webTitle", ""), jk());
            jSONObject.put("openCommonWebUrl", strU);
            jSONObject.put("openCommonWebTitle", strU2);
        } catch (JSONException unused2) {
        }
        View viewA = fxVar.a();
        try {
            if ((viewA instanceof TextView) && (text = ((TextView) viewA).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused3) {
        }
        uVarU.u(jSONObject);
        q qVarU = uVarU.u();
        n nVar = this.f5383a;
        if (nVar != null) {
            nVar.u(viewA, i, qVarU);
        }
    }
}
