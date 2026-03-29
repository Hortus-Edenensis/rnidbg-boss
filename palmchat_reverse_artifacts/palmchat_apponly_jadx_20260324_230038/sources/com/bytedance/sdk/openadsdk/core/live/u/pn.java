package com.bytedance.sdk.openadsdk.core.live.u;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.be;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends u {
    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int b_(bc bcVar) {
        if (this.u != null) {
            long jNr = nr(bcVar);
            if (jNr == 0) {
                return 1;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putLong("room_id", jNr);
                Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(3).u(Object.class).u(0, 2).u(1, bundle).nr());
                if (objApply instanceof Integer) {
                    return ((Integer) objApply).intValue();
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public boolean iz() {
        return nr() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public JSONObject n() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int nr(Context context, bc bcVar, Map<String, Object> map) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int pn() {
        boolean zBooleanValue = false;
        if (this.u != null) {
            try {
                Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(3).u(Object.class).u(0, 3).nr());
                if (objApply instanceof Boolean) {
                    zBooleanValue = ((Boolean) objApply).booleanValue();
                }
            } catch (Throwable unused) {
            }
        }
        return zBooleanValue ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int u(com.bytedance.sdk.openadsdk.core.live.nr.nr nrVar, boolean z) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public String x() {
        if (this.u == null) {
            return null;
        }
        try {
            Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(3).u(Object.class).u(0, 4).nr());
            if (objApply instanceof String) {
                return (String) objApply;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.u
    public boolean x_() {
        return true;
    }

    private String nr(bc bcVar, Map<String, Object> map) {
        if (bcVar == null) {
            return "";
        }
        try {
            return com.bytedance.sdk.openadsdk.core.live.fx.u(Uri.parse("sslocal://webcast_room"), u(bcVar, map)).toString();
        } catch (Throwable unused) {
            k.nr("TTLiveSDkBridge", "link: null");
            return "";
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public void u(com.bytedance.sdk.openadsdk.k.b bVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public void u(String str, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int u(Context context, bc bcVar, Map<String, Object> map) {
        int i;
        if (context == null || bcVar == null || !a_(bcVar)) {
            return -1;
        }
        String str = map != null ? (String) map.get("event_tag") : "";
        int iGq = bcVar.gq();
        int iIntValue = 1;
        if (!iz()) {
            u(bcVar, str, iGq, 1, iGq == 7 ? 1 : 2);
            return 1;
        }
        if (this.u != null) {
            int iFx = 0;
            Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(0).u(Integer.class).u(0, nr(bcVar, map)).nr());
            iIntValue = objApply != null ? ((Integer) objApply).intValue() : 0;
            if (iIntValue == 0) {
                if (u(bcVar, 0) && (iFx = fx(bcVar)) == 0) {
                    try {
                        new com.bytedance.sdk.openadsdk.core.live.fx.u().u(str).u(context, bcVar);
                    } catch (Exception unused) {
                        iFx = 3;
                    }
                }
                i = iFx;
            } else {
                iFx = 3;
                i = iFx;
            }
        } else {
            i = 1;
        }
        u(bcVar, str, iGq, iGq, i);
        return iIntValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(String str, bc bcVar, long j) {
        try {
            if (this.u == null) {
                return;
            }
            Map<String, String> mapU = u(bcVar, (Map<String, Object>) null);
            Map<String, String> mapU2 = com.bytedance.sdk.openadsdk.core.video.fx.u.u(dw.getContext());
            mapU2.put("room_id", mapU.get("room_id"));
            mapU2.put("anchor_id", mapU.get("owner_open_id"));
            mapU2.put("enter_from_merge", mapU.get("enter_from_merge"));
            mapU2.put("enter_method", mapU.get("enter_method"));
            mapU2.put("action_type", "click");
            mapU2.put(be.g, mapU.get(be.g));
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            mapU2.put("duration", sb.toString());
            mapU2.put("is_other_channel", "union_ad");
            mapU2.put("IESLiveEffectAdTrackExtraServiceKey", mapU.get("IESLiveEffectAdTrackExtraServiceKey"));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : mapU2.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(4).u(Void.class).u(0, str).u(1, jSONObject).nr());
        } catch (Throwable th) {
            if (k.fx()) {
                k.u("TTInnerLiveHelper", "Throwable : ", th);
            }
        }
    }

    public Map<String, String> u(bc bcVar, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (bcVar == null) {
            return map2;
        }
        map2.put("room_id", bcVar.uu());
        if (this.u != null) {
            int iJk = jp.jk(bcVar);
            String str = (String) this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(1).u(String.class).u(0, Integer.valueOf(iJk)).nr());
            String str2 = (String) this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(2).u(String.class).u(0, Integer.valueOf(iJk)).u(1, Boolean.valueOf(com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar))).nr());
            map2.put("enter_from_merge", str);
            map2.put("enter_method", str2);
        }
        map2.put("host", "aweme");
        map2.put("is_other_channel", "union_ad");
        String strU = u(bcVar, bcVar.ri(), map);
        if (!TextUtils.isEmpty(strU)) {
            map2.put("ecom_live_params", strU);
        }
        my myVarKv = bcVar.kv();
        if (myVarKv != null && !TextUtils.isEmpty(myVarKv.nr())) {
            try {
                Uri uri = Uri.parse(myVarKv.nr());
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                String strOptString = jSONObject.optString("log_extra");
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString);
                    jSONObject3.put("ad_event_aid", jSONObject.optString("aid"));
                    jSONObject3.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.fx.u(uri, az.at));
                    jSONObject3.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.fx.u(uri, "gd_label"));
                    jSONObject3.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.fx.u(uri, "union_user_id"));
                    jSONObject3.put("ad_event_app_siteid", n.o().c());
                    jSONObject3.put("ad_event_live_type", "1");
                    map2.put("log_extra", jSONObject3.toString());
                    jSONObject2.put("log_extra", jSONObject3.toString());
                }
                String strOptString2 = jSONObject.optString("cid");
                jSONObject2.put("creativeID", strOptString2);
                map2.put("creative_id", strOptString2);
                map2.put("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                String strU2 = com.bytedance.sdk.openadsdk.core.live.fx.u(uri, "owner_open_id");
                if (TextUtils.isEmpty(strU2)) {
                    strU2 = com.bytedance.sdk.openadsdk.core.live.fx.u(uri, "user_id");
                }
                map2.put("owner_open_id", strU2);
                String strU3 = com.bytedance.sdk.openadsdk.core.live.fx.u(uri, "pangle_live_room_data");
                if (!TextUtils.isEmpty(strU3)) {
                    map2.put("pangle_live_room_data", strU3);
                }
                map2.put(be.g, com.bytedance.sdk.openadsdk.core.live.fx.u(uri, be.g));
            } catch (Exception unused) {
            }
        }
        return map2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int nr() {
        if (this.u != null) {
            try {
                Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(3).u(Object.class).u(0, 1).nr());
                if (objApply instanceof Integer) {
                    return ((Integer) objApply).intValue();
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public boolean u(bc bcVar) {
        return a_(bcVar) && this.u != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.u, com.bytedance.sdk.openadsdk.core.live.u.b
    public void u(final String str, final bc bcVar, final long j) {
        com.bytedance.sdk.openadsdk.gi.x.nr(new a("csj_live_log_event_v2") { // from class: com.bytedance.sdk.openadsdk.core.live.u.pn.1
            @Override // java.lang.Runnable
            public void run() {
                pn.this.nr(str, bcVar, j);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int u(bc bcVar, fx fxVar, String str) {
        if (bcVar == null || TextUtils.isEmpty(bcVar.eh()) || this.u == null) {
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", bcVar.eh());
            Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(3).u(Object.class).u(0, 5).u(1, bundle).nr());
            if (objApply == null) {
                return 4;
            }
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int u(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", str);
            Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(3).u(Object.class).u(0, 6).u(1, bundle).nr());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
