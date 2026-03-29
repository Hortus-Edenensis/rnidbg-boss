package com.bytedance.sdk.openadsdk.core.live.u;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jp;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.kj.su;
import com.bytedance.sdk.openadsdk.core.kj.v;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.s.a;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.be;
import com.qq.gdt.action.ActionUtils;
import j$.util.Objects;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class iz extends com.bytedance.sdk.openadsdk.core.live.u.u {
    protected String b;
    protected volatile SoftReference<bc> iz;
    protected String pn;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(boolean z);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e7 A[Catch: Exception -> 0x0293, TryCatch #7 {Exception -> 0x0293, blocks: (B:108:0x01c0, B:110:0x01e7, B:111:0x023a, B:113:0x0269, B:114:0x026c, B:116:0x0278, B:117:0x027e), top: B:159:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0269 A[Catch: Exception -> 0x0293, TryCatch #7 {Exception -> 0x0293, blocks: (B:108:0x01c0, B:110:0x01e7, B:111:0x023a, B:113:0x0269, B:114:0x026c, B:116:0x0278, B:117:0x027e), top: B:159:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0278 A[Catch: Exception -> 0x0293, TryCatch #7 {Exception -> 0x0293, blocks: (B:108:0x01c0, B:110:0x01e7, B:111:0x023a, B:113:0x0269, B:114:0x026c, B:116:0x0278, B:117:0x027e), top: B:159:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0303 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0105 A[Catch: Exception -> 0x0113, TryCatch #8 {Exception -> 0x0113, blocks: (B:62:0x00e8, B:67:0x0105, B:69:0x010f), top: B:161:0x00e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bundle fx(Context context, bc bcVar, Map<String, Object> map) {
        String str;
        int i;
        int i2;
        Map<String, Object> map2;
        String strOptString;
        String strU;
        String strU2;
        JSONObject jSONObject;
        int i3;
        int i4;
        int i5;
        Bundle bundle = new Bundle();
        if (bcVar != null) {
            try {
                bundle.putLong("room_id", Long.parseLong(bcVar.uu()));
            } catch (Exception unused) {
            }
            Bundle bundle2 = new Bundle();
            my myVarKv = bcVar.kv();
            int iU = com.bytedance.sdk.openadsdk.core.live.pn.fx.u(map);
            v vVarEj = bcVar.ej();
            if (vVarEj != null && vVarEj.fx() == 0) {
                int iNr = vVarEj.nr();
                if (iNr == 1) {
                    iU = 101;
                } else if (iNr == 3) {
                    iU = 104;
                }
            }
            int iGq = bcVar.gq();
            int iPn = pn(bcVar);
            jp jpVarVg = bcVar.vg();
            String strU3 = null;
            if (!com.bytedance.sdk.openadsdk.core.a.u.u.u.iz.u(iU)) {
                str = "live_auto_auth_login_source";
                if (iPn > 0 && pn() != 2) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        c.u(bcVar.dv(), new Integer(1), Integer.class);
                        jSONObject2.put("auth_reward_gold", iPn);
                        bundle2.putString("live_auth_extra_info", jSONObject2.toString());
                    } catch (JSONException unused2) {
                    }
                } else if (fx(bcVar) == 0) {
                    if (bcVar.gq() == 7) {
                        bundle2.putInt("live_popup_dou_auth_dialog", 1);
                    } else if (bcVar.gq() == 8) {
                        bundle2.putInt("live_popup_dou_deeplink_dialog", 1);
                        bundle2.putString("live_popup_dou_deeplink_url", myVarKv != null ? myVarKv.nr() : "");
                    }
                }
                i = iGq;
                i2 = -1;
            } else if (iU == 101 || iU == 102 || iU == 104) {
                try {
                    jSONObject = new JSONObject();
                    if (jpVarVg != null) {
                        i3 = iU == 101 ? 1 : iU == 104 ? 3 : 2;
                        try {
                            jSONObject.put("live_auto_auth_login_source", i3);
                            int i6 = iU;
                            int i7 = i3;
                            try {
                                jSONObject.put("live_auto_auth_success_has_ticket", com.bytedance.sdk.openadsdk.core.live.pn.fx.u(bcVar.ri()));
                                jSONObject.put("live_auto_auth_promotion_id", jpVarVg.nr());
                                iU = i6;
                                i3 = i7;
                                if (iPn > 0) {
                                    if (jSONObject == null) {
                                        try {
                                            jSONObject = new JSONObject();
                                        } catch (Exception unused3) {
                                            str = "live_auto_auth_login_source";
                                            i2 = i3;
                                            i = iU;
                                            if (jpVarVg != null) {
                                            }
                                            if (myVarKv != null) {
                                            }
                                            if (TextUtils.isEmpty(strU3)) {
                                            }
                                            bundle2.putString("enter_from_merge", strU3);
                                            bundle2.putString("enter_method", nr(com.bytedance.sdk.openadsdk.core.y.jp.jk(bcVar)));
                                            bundle2.putInt("live_pangle_interaction_type", i);
                                            bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                            String strRi = bcVar.ri();
                                            if (i2 != -1) {
                                            }
                                            map2 = map;
                                            bundle.putString("ecom_live_params", u(bcVar, strRi, map2));
                                            if (bcVar.qj() == null) {
                                            }
                                        }
                                    }
                                    i4 = iU;
                                    try {
                                        i5 = i3;
                                    } catch (Exception unused4) {
                                        str = "live_auto_auth_login_source";
                                        iU = i4;
                                        i2 = i3;
                                        i = iU;
                                    }
                                    try {
                                        str = "live_auto_auth_login_source";
                                        try {
                                            c.u(bcVar.dv(), new Integer(1), Integer.class);
                                            jSONObject.put("auth_reward_gold", iPn);
                                        } catch (Exception unused5) {
                                            iU = i4;
                                            i3 = i5;
                                            i2 = i3;
                                            i = iU;
                                        }
                                    } catch (Exception unused6) {
                                        str = "live_auto_auth_login_source";
                                        iU = i4;
                                        i3 = i5;
                                        i2 = i3;
                                        i = iU;
                                    }
                                } else {
                                    i4 = iU;
                                    i5 = i3;
                                    str = "live_auto_auth_login_source";
                                }
                                if (jSONObject != null) {
                                    String string = jSONObject.toString();
                                    if (!TextUtils.isEmpty(string)) {
                                        bundle2.putString("live_auth_extra_info", string);
                                    }
                                }
                                i = i4;
                                i2 = i5;
                            } catch (Exception unused7) {
                                i3 = i7;
                                iU = iGq;
                                str = "live_auto_auth_login_source";
                                i2 = i3;
                                i = iU;
                                if (jpVarVg != null) {
                                }
                                if (myVarKv != null) {
                                    try {
                                        Uri uri = Uri.parse(myVarKv.nr());
                                        JSONObject jSONObject3 = new JSONObject(uri.getQueryParameter("ad_data_params"));
                                        strOptString = jSONObject3.optString("log_extra");
                                        HashMap map3 = new HashMap();
                                        JSONObject jSONObject4 = new JSONObject();
                                        if (!TextUtils.isEmpty(strOptString)) {
                                        }
                                        String strOptString2 = jSONObject3.optString("cid");
                                        jSONObject4.put("creativeID", strOptString2);
                                        bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject4.toString());
                                        map3.put("is_other_channel", "union_ad");
                                        map3.put(ActionUtils.PAYMENT_AMOUNT, strOptString2);
                                        bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                                        strU = com.bytedance.sdk.openadsdk.core.live.fx.u(uri, "pangle_live_room_data");
                                        if (!TextUtils.isEmpty(strU)) {
                                        }
                                        strU2 = com.bytedance.sdk.openadsdk.core.live.fx.u(uri, "owner_open_id");
                                        if (TextUtils.isEmpty(strU2)) {
                                        }
                                        bundle2.putString("anchor_id", strU2);
                                        bundle2.putString("live.intent.extra.REQUEST_ID", com.bytedance.sdk.openadsdk.core.live.fx.u(uri, be.g));
                                        strU3 = com.bytedance.sdk.openadsdk.core.live.fx.u(uri, "enter_from_merge");
                                    } catch (Exception unused8) {
                                    }
                                }
                                if (TextUtils.isEmpty(strU3)) {
                                }
                                bundle2.putString("enter_from_merge", strU3);
                                bundle2.putString("enter_method", nr(com.bytedance.sdk.openadsdk.core.y.jp.jk(bcVar)));
                                bundle2.putInt("live_pangle_interaction_type", i);
                                bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                String strRi2 = bcVar.ri();
                                if (i2 != -1) {
                                }
                                map2 = map;
                                bundle.putString("ecom_live_params", u(bcVar, strRi2, map2));
                                if (bcVar.qj() == null) {
                                }
                            }
                        } catch (Exception unused9) {
                        }
                    } else {
                        iU = iGq;
                        i3 = -1;
                        if (iPn > 0) {
                        }
                        if (jSONObject != null) {
                        }
                        i = i4;
                        i2 = i5;
                    }
                } catch (Exception unused10) {
                    str = "live_auto_auth_login_source";
                    iU = iGq;
                    i3 = -1;
                    i2 = i3;
                    i = iU;
                    if (jpVarVg != null) {
                    }
                    if (myVarKv != null) {
                    }
                    if (TextUtils.isEmpty(strU3)) {
                    }
                    bundle2.putString("enter_from_merge", strU3);
                    bundle2.putString("enter_method", nr(com.bytedance.sdk.openadsdk.core.y.jp.jk(bcVar)));
                    bundle2.putInt("live_pangle_interaction_type", i);
                    bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                    String strRi22 = bcVar.ri();
                    if (i2 != -1) {
                    }
                    map2 = map;
                    bundle.putString("ecom_live_params", u(bcVar, strRi22, map2));
                    if (bcVar.qj() == null) {
                    }
                }
            } else {
                if (iU == 103) {
                    try {
                        bundle2.putInt("live_popup_dou_auth_dialog", 1);
                    } catch (Exception unused11) {
                        str = "live_auto_auth_login_source";
                        i3 = -1;
                        i2 = i3;
                        i = iU;
                        if (jpVarVg != null) {
                        }
                        if (myVarKv != null) {
                        }
                        if (TextUtils.isEmpty(strU3)) {
                        }
                        bundle2.putString("enter_from_merge", strU3);
                        bundle2.putString("enter_method", nr(com.bytedance.sdk.openadsdk.core.y.jp.jk(bcVar)));
                        bundle2.putInt("live_pangle_interaction_type", i);
                        bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                        String strRi222 = bcVar.ri();
                        if (i2 != -1) {
                        }
                        map2 = map;
                        bundle.putString("ecom_live_params", u(bcVar, strRi222, map2));
                        if (bcVar.qj() == null) {
                        }
                    }
                } else {
                    iU = iGq;
                }
                jSONObject = null;
                i3 = -1;
                if (iPn > 0) {
                }
                if (jSONObject != null) {
                }
                i = i4;
                i2 = i5;
            }
            if (jpVarVg != null) {
                if (!TextUtils.isEmpty(jpVarVg.x())) {
                    bundle2.putString("live_csj_libra_param", jpVarVg.x());
                }
                JSONArray jSONArrayN = jpVarVg.n();
                if (jSONArrayN != null) {
                    u(jSONArrayN, bcVar);
                    bundle.putString("live_tob_task_center_config", jSONArrayN.toString());
                    bundle.putString("live_tob_task_key", bcVar.dv());
                }
            }
            if (myVarKv != null && !TextUtils.isEmpty(myVarKv.nr())) {
                Uri uri2 = Uri.parse(myVarKv.nr());
                JSONObject jSONObject32 = new JSONObject(uri2.getQueryParameter("ad_data_params"));
                strOptString = jSONObject32.optString("log_extra");
                HashMap map32 = new HashMap();
                JSONObject jSONObject42 = new JSONObject();
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject5 = new JSONObject(strOptString);
                    jSONObject5.put("ad_event_aid", jSONObject32.optString("aid"));
                    jSONObject5.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.fx.u(uri2, az.at));
                    jSONObject5.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.fx.u(uri2, "gd_label"));
                    jSONObject5.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.fx.u(uri2, "union_user_id"));
                    jSONObject5.put("ad_event_app_siteid", n.o().c());
                    jSONObject5.put("ad_event_live_type", "1");
                    map32.put("log_extra", jSONObject5.toString());
                    jSONObject42.put("log_extra", jSONObject5.toString());
                }
                String strOptString22 = jSONObject32.optString("cid");
                jSONObject42.put("creativeID", strOptString22);
                bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject42.toString());
                map32.put("is_other_channel", "union_ad");
                map32.put(ActionUtils.PAYMENT_AMOUNT, strOptString22);
                bundle.putSerializable("live_effect_ad_log_extra_map", map32);
                strU = com.bytedance.sdk.openadsdk.core.live.fx.u(uri2, "pangle_live_room_data");
                if (!TextUtils.isEmpty(strU)) {
                    bundle.putString("pangle_live_room_data", strU);
                }
                strU2 = com.bytedance.sdk.openadsdk.core.live.fx.u(uri2, "owner_open_id");
                if (TextUtils.isEmpty(strU2)) {
                    strU2 = com.bytedance.sdk.openadsdk.core.live.fx.u(uri2, "user_id");
                }
                bundle2.putString("anchor_id", strU2);
                bundle2.putString("live.intent.extra.REQUEST_ID", com.bytedance.sdk.openadsdk.core.live.fx.u(uri2, be.g));
                strU3 = com.bytedance.sdk.openadsdk.core.live.fx.u(uri2, "enter_from_merge");
            }
            if (TextUtils.isEmpty(strU3)) {
                strU3 = u(com.bytedance.sdk.openadsdk.core.y.jp.jk(bcVar));
            }
            bundle2.putString("enter_from_merge", strU3);
            bundle2.putString("enter_method", nr(com.bytedance.sdk.openadsdk.core.y.jp.jk(bcVar)));
            bundle2.putInt("live_pangle_interaction_type", i);
            bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
            String strRi2222 = bcVar.ri();
            if (i2 != -1) {
                try {
                    if (!TextUtils.isEmpty(strRi2222)) {
                        JSONObject jSONObject6 = new JSONObject(strRi2222);
                        JSONObject jSONObjectOptJSONObject = jSONObject6.optJSONObject("enter_request");
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put(str, i2);
                        jSONObjectOptJSONObject.put("live_commerce_sdk_custom_params", jSONObject7);
                        jSONObject6.remove("enter_request");
                        jSONObject6.put("enter_request", jSONObjectOptJSONObject);
                        strRi2222 = jSONObject6.toString();
                    }
                } catch (Exception unused12) {
                }
            }
            map2 = map;
            bundle.putString("ecom_live_params", u(bcVar, strRi2222, map2));
        } else {
            map2 = map;
        }
        if (bcVar.qj() == null) {
            return bundle;
        }
        Object obj = map2.get("reward_countdown");
        if (obj instanceof Long) {
            long jLongValue = ((Long) obj).longValue();
            if (jLongValue > 0) {
                bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                bundle.putInt("android.app.activity.request_code", 1);
                if (map2.containsKey("reward_live_scene") && ((Integer) map2.get("reward_live_scene")).intValue() == 1) {
                    bundle.putInt("live_popup_reward_auth", 1);
                }
            }
        }
        return bundle;
    }

    public static String nr(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                return EnterMethod.LIVE_CELL.lowerName();
            case 5:
                return EnterMethod.LIVE_CARD.lowerName();
            default:
                return EnterMethod.NO_VALUE.lowerName();
        }
    }

    private int pn(bc bcVar) {
        String strQp = bcVar.qp();
        Integer num = (Integer) c.u(bcVar.dv(), Integer.class);
        if ((num != null && num.intValue() > 0) || TextUtils.isEmpty(strQp)) {
            return 0;
        }
        try {
            return new JSONObject(strQp).optInt("auth_reward_gold");
        } catch (Throwable th) {
            k.u("TTLiveSDkBridge", th);
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.u
    public void a_(String str) {
        this.pn = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    @Deprecated
    public int b_(bc bcVar) {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int u(bc bcVar, fx fxVar, String str) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public String x() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.u
    public boolean x_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.u, com.bytedance.sdk.openadsdk.core.live.u.b
    public void u(Function<SparseArray<Object>, Object> function) {
        super.u(function);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int nr(Context context, bc bcVar, Map<String, Object> map) {
        Object obj;
        long jLongValue;
        if (map != null) {
            try {
                obj = map.get("reward_countdown");
            } catch (Exception unused) {
            }
            jLongValue = obj instanceof Long ? ((Long) obj).longValue() : 0L;
        }
        if (context == null || bcVar == null) {
            return 5;
        }
        if (!(context instanceof Activity)) {
            return 7;
        }
        if (!su.u(bcVar)) {
            return 5;
        }
        if (jLongValue < 0) {
            return 8;
        }
        if (su.nr(bcVar) == 1) {
            return 9;
        }
        return u(context, bcVar, map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int u(final Context context, final bc bcVar, final Map<String, Object> map) {
        b(bcVar);
        if (!a_(bcVar)) {
            return 6;
        }
        bcVar.dv();
        final String str = map != null ? (String) map.get("event_tag") : "";
        final int iGq = bcVar.gq();
        if (!iz()) {
            u(bcVar, str, iGq, 1, iGq == 7 ? 1 : 2);
            return 1;
        }
        bcVar.pg();
        if (this.u == null) {
            return 4;
        }
        this.nr = str;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (pn() != 2 ? u(bcVar, new u() { // from class: com.bytedance.sdk.openadsdk.core.live.u.iz.1
            @Override // com.bytedance.sdk.openadsdk.core.live.u.iz.u
            public void u(boolean z) {
                boolean z2;
                if (atomicBoolean.compareAndSet(false, true)) {
                    iz izVar = iz.this;
                    izVar.u(context, bcVar, iGq, izVar.nr, (Map<String, Object>) map);
                    z2 = false;
                } else {
                    z2 = true;
                }
                s.u().u(bcVar, System.currentTimeMillis() - jCurrentTimeMillis, z, z2);
            }
        }, true) : false) {
            v vVarEj = bcVar.ej();
            if (vVarEj != null) {
                long jPn = vVarEj.pn();
                if (jPn > 0) {
                    jk.fx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.u.iz.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                iz.this.u(context, bcVar, iGq, str, (Map<String, Object>) map);
                            }
                        }
                    }, jPn);
                }
                if (vVarEj.iz() == 1 && n.o().b() != null) {
                    new a().u(new a.u() { // from class: com.bytedance.sdk.openadsdk.core.live.u.iz.3
                        @Override // com.bytedance.sdk.openadsdk.core.s.a.u
                        public void u(boolean z) {
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.s.a.u
                        public void u() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                iz.this.u(context, bcVar, iGq, str, (Map<String, Object>) map);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.s.a.u
                        public void u(String str2) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                iz.this.u(context, bcVar, iGq, str, (Map<String, Object>) map);
                            }
                        }
                    });
                }
            }
            return 0;
        }
        return u(context, bcVar, iGq, str, map);
    }

    public boolean u(bc bcVar, final u uVar, boolean z) {
        v vVarEj;
        if (this.pn == null || (vVarEj = bcVar.ej()) == null || vVarEj.fx() == 0) {
            return false;
        }
        try {
            if (Integer.parseInt(this.pn.replaceAll("\\.", "")) < 211413) {
                return false;
            }
        } catch (Exception unused) {
        }
        int iNr = vVarEj.nr();
        boolean z2 = iNr > 0;
        if (z) {
            z2 = iNr == 3;
        }
        if (z2) {
            this.iz = new SoftReference<>(bcVar);
            if (u(new com.bytedance.sdk.openadsdk.core.live.nr.nr() { // from class: com.bytedance.sdk.openadsdk.core.live.u.iz.4
                @Override // com.bytedance.sdk.openadsdk.core.live.nr.nr
                public void u(Object obj) {
                    boolean z3 = false;
                    if (obj instanceof Map) {
                        Map map = (Map) obj;
                        if (map.containsKey("code")) {
                            Object obj2 = map.get("code");
                            if (obj2 instanceof String) {
                                try {
                                    if (Integer.parseInt((String) obj2) == 1) {
                                        z3 = true;
                                    }
                                } catch (NumberFormatException unused2) {
                                }
                            }
                        }
                    }
                    uVar.u(z3);
                }
            }, iNr == 3) == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(Context context, bc bcVar, int i, String str, Map<String, Object> map) {
        int iIntValue;
        int i2;
        int i3;
        int i4;
        int i5;
        bcVar.pg();
        if (this.u != null) {
            int iFx = 0;
            Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(0).u(Integer.class).u(0, new wq().u("context", context).u("bundle", fx(context, bcVar, map))).nr());
            iIntValue = objApply != null ? ((Integer) objApply).intValue() : 0;
            this.nr = str;
            this.b = bcVar.dv();
            if (iIntValue == 0) {
                this.iz = new SoftReference<>(bcVar);
                int iU = com.bytedance.sdk.openadsdk.core.live.pn.fx.u(map);
                if (iU == 101 || iU == 102) {
                    iIntValue |= iU << 8;
                } else {
                    if (u(bcVar, iU)) {
                        iFx = fx(bcVar);
                        i = 7;
                        if (iFx == 0) {
                            try {
                                new com.bytedance.sdk.openadsdk.core.live.fx.u().u(str).u(context, bcVar);
                                iIntValue |= iU << 8;
                            } catch (Exception unused) {
                            }
                            i5 = 7;
                        } else {
                            i5 = 2;
                        }
                    }
                    i3 = i5;
                    i2 = i;
                    i4 = iFx;
                }
            } else {
                iFx = 3;
            }
            i5 = i;
            i3 = i5;
            i2 = i;
            i4 = iFx;
        } else {
            iIntValue = 4;
            i2 = i;
            i3 = i2;
            i4 = 1;
        }
        u(bcVar, str, i2, i3, i4);
        return iIntValue;
    }

    private void u(JSONArray jSONArray, bc bcVar) {
        com.bytedance.sdk.openadsdk.core.live.b.u uVar;
        if (bcVar == null || jSONArray == null || (uVar = (com.bytedance.sdk.openadsdk.core.live.b.u) c.u(bcVar.dv(), com.bytedance.sdk.openadsdk.core.live.b.u.class)) == null || uVar.nr.isEmpty()) {
            return;
        }
        String strLk = bcVar.lk();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String strOptString = jSONObject.optString("type");
                if (uVar.nr.contains(strLk + "_" + strOptString)) {
                    jSONObject.put("status", 1);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static String u(int i) {
        if (i == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION.lowerName();
        }
        if (i == 8) {
            return EnterFromMerge.AD_UNION_INSERT.lowerName();
        }
        if (i == 5) {
            return EnterFromMerge.AD_UNION_FEED.lowerName();
        }
        if (i == 9) {
            return EnterFromMerge.AD_UNION_DRAW.lowerName();
        }
        return i == 1 ? "ad_union_banner" : (i == 3 || i == 4) ? "ad_union_topview" : i == 2 ? "ad_union_former_insert" : i == 6 ? "ad_union_patch" : EnterFromMerge.NO_VALUE.lowerName();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public boolean u(bc bcVar) {
        return a_(bcVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int u(String str) {
        if (TextUtils.isEmpty(str)) {
            return 10;
        }
        if (this.u == null) {
            return 12;
        }
        if (!iz()) {
            return 11;
        }
        Object objP = n.o().p();
        if (objP == null) {
            return 13;
        }
        try {
            Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(8).u(Boolean.class).u(0, new wq().u("context", objP).u("scheme_uri", str)).nr());
            return objApply != null ? ((Boolean) objApply).booleanValue() : false ? 1 : 10;
        } catch (Exception unused) {
            return 14;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int u(com.bytedance.sdk.openadsdk.core.live.nr.nr nrVar, boolean z) {
        if (this.u == null) {
            return 12;
        }
        if (!iz()) {
            return 11;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", "requestDyAuth");
        map.put("expand_method_param", new Object[]{n.o().p(), nrVar, Boolean.valueOf(z)});
        Objects.toString(this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(7).u(Void.class).u(0, map).nr()));
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.u, com.bytedance.sdk.openadsdk.core.live.u.b
    public void u(String str, bc bcVar, long j) {
        com.bytedance.sdk.openadsdk.core.video.fx.u.u(str, bcVar, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public void u(String str, boolean z) {
        if (this.u != null && iz()) {
            HashMap map = new HashMap();
            map.put("expand_method_name", str);
            map.put("expand_method_param", new Object[]{Boolean.valueOf(z)});
            this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(7).u(Void.class).u(0, map).nr());
        }
    }
}
