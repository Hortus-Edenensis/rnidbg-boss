package com.bytedance.sdk.openadsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.gi.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.cj;
import com.bytedance.sdk.openadsdk.core.kj.gc;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.bytedance.sdk.openadsdk.core.kj.kw;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.kj.mk;
import com.bytedance.sdk.openadsdk.core.kj.nb;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.kj.su;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.v;
import com.bytedance.sdk.openadsdk.core.kj.w;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.bq;
import com.kwad.sdk.api.model.AdnName;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.EventParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.cordova.jssdk.RedPacketPullNewPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static com.bytedance.sdk.openadsdk.core.kj.kj b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.kj.kj kjVar = new com.bytedance.sdk.openadsdk.core.kj.kj();
        kjVar.b(jSONObject.optString("bg_url"));
        kjVar.fx(jSONObject.optString("title"));
        kjVar.u(jSONObject.optString("reward_image_url"));
        kjVar.nr(jSONObject.optString("reward_title"));
        kjVar.pn(jSONObject.optString(MediaFormat.KEY_SUBTITLE));
        return kjVar;
    }

    public static com.bytedance.sdk.openadsdk.core.kj.qq fx(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.kj.qq qqVar = new com.bytedance.sdk.openadsdk.core.kj.qq();
        qqVar.fx(jSONObject.optString("ugen_dialog_md5"));
        qqVar.nr(jSONObject.optString("ugen_dialog_url"));
        qqVar.u(jSONObject.optString("dialog_style"));
        return qqVar;
    }

    private static com.bytedance.sdk.openadsdk.core.kj.dw iz(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.kj.dw dwVar = new com.bytedance.sdk.openadsdk.core.kj.dw();
        dwVar.u(jSONObject.optInt("ah", 1));
        dwVar.nr(jSONObject.optInt("am", 1));
        return dwVar;
    }

    public static com.bytedance.sdk.openadsdk.core.kj.pn nr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.kj.pn pnVar = new com.bytedance.sdk.openadsdk.core.kj.pn();
        pnVar.fx(jSONObject.optString("app_name"));
        pnVar.b(jSONObject.optString("package_name"));
        pnVar.nr(jSONObject.optString(WfConstant.EXTRA_KEY_DOWNLOAD_URL));
        pnVar.u(jSONObject.optInt("score", 4));
        pnVar.nr(jSONObject.optInt("comment_num", 0));
        pnVar.fx(jSONObject.optInt("app_size", 0));
        pnVar.u(jSONObject.optString("quick_app_url", ""));
        return pnVar;
    }

    public static com.bytedance.sdk.openadsdk.core.kj.iz pn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.kj.iz izVar = new com.bytedance.sdk.openadsdk.core.kj.iz();
        izVar.b(jSONObject.optString(WfConstant.EXTRA_KEY_DEVELOPER_NAME));
        izVar.nr(jSONObject.optString("app_version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("permissions");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            izVar.nr(jSONArrayOptJSONArray);
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    izVar.u(jSONObjectOptJSONObject.optString("permission_name"), jSONObjectOptJSONObject.optString("permission_desc"));
                }
            }
        }
        izVar.u(jSONObject.optString("permissions_url"));
        izVar.u(jSONObject.optInt("score", 0));
        izVar.u(jSONObject.optJSONArray("creative_tags"));
        izVar.pn(jSONObject.optString("privacy_policy_url"));
        izVar.iz(jSONObject.optString("desc_url"));
        izVar.x(jSONObject.optString("reg_number"));
        izVar.n(jSONObject.optString("reg_url"));
        izVar.jk(jSONObject.optString("app_name"));
        izVar.a(jSONObject.optString("package_name"));
        return izVar;
    }

    public static Pair<com.bytedance.sdk.openadsdk.core.kj.u, ArrayList<Integer>> u(JSONObject jSONObject, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, long j) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.kj.u uVar = new com.bytedance.sdk.openadsdk.core.kj.u();
            uVar.u(jSONObject.optString(be.g));
            uVar.u(jSONObject.optInt("ret"));
            uVar.nr(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("auction_price");
            com.bytedance.sdk.openadsdk.core.y.sx.nr(jSONObject.optString("client_ipv4", ""));
            boolean zOptBoolean = jSONObject.optBoolean("need_get_materials");
            if (uVar.u() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                int i = 0;
                while (i < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    i++;
                    bc bcVarU = u(jSONObjectOptJSONObject, nrVar, oaVar, i);
                    int iU = u(bcVarU, nrVar != null ? nrVar.bq() : 0);
                    boolean zPb = bcVarU.pb();
                    String strM = bcVarU.m();
                    if (iU != 200 && ((!zOptBoolean && !zPb) || TextUtils.isEmpty(strM))) {
                        arrayList.add(Integer.valueOf(iU));
                    }
                    bcVarU.rh(strOptString);
                    bcVarU.fx(j);
                    bcVarU.iz(zOptBoolean);
                    uVar.u(bcVarU);
                }
            }
            return new Pair<>(uVar, arrayList);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Map<String, Object> x(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    private static int nr(bc bcVar, int i) {
        if (i != 3 && i != 4 && i != 0) {
            if (!m.u(bcVar)) {
                return 416;
            }
            if (TextUtils.isEmpty(m.x(bcVar))) {
                return 417;
            }
        }
        return 200;
    }

    private static int nr(List<com.bytedance.sdk.openadsdk.core.kj.rh> list) {
        if (list == null) {
            return 409;
        }
        if (list.size() <= 0) {
            return 410;
        }
        for (com.bytedance.sdk.openadsdk.core.kj.rh rhVar : list) {
            if (rhVar == null) {
                return 411;
            }
            if (TextUtils.isEmpty(rhVar.u())) {
                return 412;
            }
        }
        return 200;
    }

    public static bc u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return u(jSONObject, (com.bytedance.sdk.openadsdk.my.fx.fx.nr) null, (oa) null, 0);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x06ba  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x078d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0811  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0885  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0893  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0930  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0951  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0954  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0572  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static bc u(JSONObject jSONObject, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i) {
        int i2;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        m mVar;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        String strOptString;
        JSONObject jSONObjectOptJSONObject5;
        JSONObject jSONObjectOptJSONObject6;
        JSONObject jSONObjectOptJSONObject7;
        Map<String, Object> mapSj;
        String strYf;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject8;
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVarU;
        if (jSONObject == null) {
            return null;
        }
        if (oaVar != null && nrVar != null) {
            dw.nr().fx(jSONObject.optInt("settings_open", 1));
        }
        final bc bcVar = new bc();
        bcVar.bf(jSONObject.optString("s_sig_ts"));
        bcVar.jk(jSONObject.optLong("ad_rec_stamp", 0L));
        bcVar.pb(jSONObject.optInt(WfConstant.EXTRA_KEY_INTERACTION_TYPE));
        bcVar.my(jSONObject.optString("target_url"));
        bcVar.mv(jSONObject.optInt("use_media_video_player", 0));
        bcVar.xg(jSONObject.optInt("landing_scroll_percentage", -1));
        bcVar.o(jSONObject.optString("gecko_id"));
        bcVar.n(jSONObject.optBoolean("is_from_local_cache"));
        bcVar.oa(jSONObject.optInt("is_from_cache_type", -1));
        bcVar.n(jSONObject.optLong("correct_action_code", -1L));
        bcVar.a(jSONObject.optLong("correct_result_code", -1L));
        if (jSONObject.has("set_click_type")) {
            JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("set_click_type");
            bcVar.nr(jSONObjectOptJSONObject9.optDouble("cta", 2.0d));
            bcVar.u(jSONObjectOptJSONObject9.optDouble(AdnName.OTHER, 2.0d));
        }
        bcVar.l(jSONObject.optInt("feed_video_finish_type"));
        JSONObject jSONObjectOptJSONObject10 = jSONObject.optJSONObject("extension");
        bcVar.b(jSONObjectOptJSONObject10);
        bcVar.pn(jSONObject.optJSONObject("overlay"));
        bcVar.c(jSONObject.optString(MediationConstant.EXTRA_ADID));
        bcVar.fx(jSONObject.optInt("get_phone_num_status"));
        bcVar.k(jSONObject.optString(az.at));
        bcVar.h(jSONObject.optString("package_name"));
        bcVar.q(jSONObject.optInt("play_bar_show_time", -200));
        JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject("icon");
        bcVar.x(jSONObject.optBoolean(RedPacketPullNewPlugin.ACTION_SCREENSHOT, false));
        bcVar.bq(jSONObject.optInt("play_bar_style", 0));
        bcVar.d(jSONObject.optString(WfConstant.EXTRA_KEY_MARKET_URL, ""));
        bcVar.sx(jSONObject.optInt("video_adaptation", 0));
        bcVar.my(jSONObject.optInt("feed_video_opentype", 0));
        bcVar.o(jSONObject.optInt("feed_reward_type", -1));
        bcVar.iz(jSONObject.optJSONObject("session_params"));
        bcVar.x(jSONObject.optJSONObject("cache_control"));
        bcVar.rh(jSONObject.optString("auction_price", ""));
        bcVar.tk(jSONObject.optInt("no_default_ttdsp_price", 0));
        int iOptInt = jSONObject.optInt("meta_hashcode", 0);
        bcVar.pn(iOptInt != 0 ? iOptInt : (int) SystemClock.elapsedRealtime());
        String str = "width";
        if (jSONObjectOptJSONObject11 != null) {
            com.bytedance.sdk.openadsdk.core.kj.rh rhVar = new com.bytedance.sdk.openadsdk.core.kj.rh();
            rhVar.u(jSONObjectOptJSONObject11.optString("url"));
            rhVar.nr(jSONObjectOptJSONObject11.optInt("height"));
            rhVar.u(jSONObjectOptJSONObject11.optInt("width"));
            bcVar.u(rhVar);
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("image");
        if (jSONArrayOptJSONArray2 != null) {
            int i3 = 0;
            while (i3 < jSONArrayOptJSONArray2.length()) {
                com.bytedance.sdk.openadsdk.core.kj.rh rhVar2 = new com.bytedance.sdk.openadsdk.core.kj.rh();
                JSONObject jSONObjectOptJSONObject12 = jSONArrayOptJSONArray2.optJSONObject(i3);
                rhVar2.u(jSONObjectOptJSONObject12.optString("url"));
                rhVar2.nr(jSONObjectOptJSONObject12.optInt("height"));
                rhVar2.u(jSONObjectOptJSONObject12.optInt(str));
                rhVar2.u(jSONObjectOptJSONObject12.optInt("duration"));
                rhVar2.u(jSONObjectOptJSONObject12.optBoolean("image_preview"));
                rhVar2.nr(jSONObjectOptJSONObject12.optString("image_key"));
                bcVar.nr(rhVar2);
                i3++;
                str = str;
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("show_url");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                bcVar.ad().add(jSONArrayOptJSONArray3.optString(i4));
            }
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("click_url");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                bcVar.mx().add(jSONArrayOptJSONArray4.optString(i5));
            }
        }
        JSONObject jSONObjectOptJSONObject13 = jSONObject.optJSONObject("adslot");
        bcVar.u(jSONObjectOptJSONObject13 != null ? com.bytedance.sdk.openadsdk.core.y.h.u(jSONObjectOptJSONObject13.toString()) : nrVar);
        bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.z(jSONObject.optJSONObject("extension")));
        bcVar.dw(jSONObject.optInt("intercept_flag", 0));
        bcVar.c(jSONObject.optInt("web_inspector", 0));
        bcVar.sx(jSONObject.optString("phone_num"));
        bcVar.bg(jSONObject.optString("title"));
        bcVar.b(jSONObject.optLong("download_num"));
        bcVar.bq(jSONObject.optString("description"));
        bcVar.dw(jSONObject.optString("button_text"));
        bcVar.bg(jSONObject.optInt("ad_logo", 1));
        bcVar.fx(jSONObject.optBoolean("isDirectDownload", false));
        String strOptString2 = jSONObject.optString("ext");
        bcVar.q(strOptString2);
        try {
            if (!TextUtils.isEmpty(strOptString2)) {
                JSONObject jSONObject2 = new JSONObject(strOptString2);
                bcVar.qq(jSONObject2.optString(ReportItem.RequestKeyRequestId));
                bcVar.n(jSONObject2.optString(ReportItem.RequestKeyRequestId));
                bcVar.kj(jSONObject2.optString(MediationConstant.EXTRA_ADID));
                com.bytedance.sdk.openadsdk.core.y.t.u(jSONObject2.optLong("global_did", -1L));
            }
        } catch (Exception unused) {
        }
        bcVar.t(jSONObject.optString(OapsKey.KEY_PRICE));
        bcVar.y(jSONObject.optInt("image_mode"));
        bcVar.wi(jSONObject.optInt(bq.f.V, 1));
        bcVar.u((float) jSONObject.optDouble("aspect_ratio", 100.0d));
        bcVar.nr((float) jSONObject.optDouble("aspect_margin", 0.07000000029802322d));
        bcVar.fx((float) jSONObject.optDouble("corner_radius", 0.0d));
        JSONObject jSONObjectOptJSONObject14 = jSONObject.optJSONObject("app");
        JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("download_sdk_conf");
        bcVar.u(nr(jSONObjectOptJSONObject14));
        bcVar.u(iz(jSONObjectOptJSONObject15));
        bcVar.nr(jSONObject.optLong("parse_material_ts", System.currentTimeMillis()));
        JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("deep_link");
        if (jSONObjectOptJSONObject16 != null) {
            bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.my(jSONObjectOptJSONObject16));
        }
        bcVar.u(new yd(jSONObject));
        bcVar.u(new tk(jSONObject, String.valueOf(jp.t(bcVar)), oaVar));
        bcVar.u(new cj(jSONObject));
        bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.bg(jSONObject));
        bcVar.u(new nb(jSONObject));
        bcVar.u(new com.bytedance.sdk.openadsdk.core.dislike.fx.nr(jSONObject, com.bytedance.sdk.openadsdk.core.dislike.b.u()));
        bcVar.u(new w(jSONObject));
        bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.wq(jSONObject));
        bcVar.u(new su(jSONObject));
        bcVar.u(new wi(jSONObject));
        bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.ja(jSONObject));
        bcVar.bc(jSONObject.optInt("count_down"));
        bcVar.pn(jSONObject.optLong("expiration_time"));
        bcVar.iz(jSONObject.optLong("client_expiration_time"));
        bcVar.jp(jSONObject.optString("_child_metas"));
        bcVar.gi(jSONObject.optString("src_req_id"));
        bcVar.ja(jSONObject.optInt("video_encode_type", 0));
        bcVar.v(jSONObject.optInt("player_type", 0));
        bcVar.bf(jSONObject.optInt("video_voice_control", -1));
        bcVar.wq(jSONObject.optInt("if_show_win", 1));
        if (!d.b() && bcVar.oi() == 1) {
            bcVar.ja(0);
            bcVar.v(0);
        }
        JSONObject jSONObjectOptJSONObject17 = jSONObject.optJSONObject("download_conf");
        if (jSONObjectOptJSONObject17 != null) {
            bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.bq(jSONObjectOptJSONObject17));
        }
        bcVar.w(jSONObject.optInt("if_both_open"));
        bcVar.cj(jSONObject.optInt("if_double_deeplink"));
        JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("app_manage");
        if (jSONObjectOptJSONObject18 != null) {
            bcVar.u(pn(jSONObjectOptJSONObject18));
            bcVar.s(jSONObjectOptJSONObject18.toString());
        }
        JSONObject jSONObjectOptJSONObject19 = jSONObject.optJSONObject("easy_dl_dialog");
        if (jSONObjectOptJSONObject19 != null) {
            bcVar.u(fx(jSONObjectOptJSONObject19));
        }
        JSONObject jSONObjectOptJSONObject20 = jSONObject.optJSONObject("easy_pl_material");
        if (jSONObjectOptJSONObject20 != null) {
            bcVar.n(jSONObjectOptJSONObject20);
            bcVar.u(b(jSONObjectOptJSONObject20));
        }
        bcVar.rh(jSONObject.optString("lp_down_rule", "0").equals("1") ? 1 : 0);
        bcVar.u(jSONObject.optInt("micro_app_type", -1));
        String strOptString3 = jSONObject.optString("app_manage_type", "0");
        if (strOptString3.equals("1")) {
            bcVar.h(1);
        } else if (strOptString3.equals("2")) {
            bcVar.h(2);
        } else {
            i2 = 0;
            bcVar.h(0);
            bcVar.u(x(jSONObject.optJSONObject("media_ext")));
            bcVar.s(jSONObject.optInt("if_block_lp", i2));
            bcVar.qq(jSONObject.optInt("cache_sort", 1));
            bcVar.kj(jSONObject.optInt("if_sp_cache", 1));
            bcVar.z(jSONObject.optInt("splash_timeout_stage", 1));
            bcVar.jk(jSONObject.optInt("page_render_type", 0));
            if (bcVar.rh() == 1 && (jSONObjectOptJSONObject8 = jSONObject.optJSONObject("ugeno")) != null) {
                uVarU = u(jSONObjectOptJSONObject8, bcVar);
                bcVar.u(uVarU);
                if (!com.bytedance.sdk.openadsdk.core.ugeno.x.u().nr(uVarU.u(), uVarU.nr())) {
                    com.bytedance.sdk.openadsdk.core.gi.nr.u(uVarU, (nr.InterfaceC0259nr) null);
                }
            }
            bcVar.a(jSONObject.optInt("native_lp_tpl_id"));
            bcVar.b(jSONObject.optString("native_lp_data"));
            bcVar.pn(jSONObject.optString("native_lp_ugen_url"));
            bcVar.iz(jSONObject.optString("native_lp_ugen_md5"));
            bcVar.b(jSONObject.optBoolean("native_lp_is_preload"));
            bcVar.fx(jSONObject.optString(WfConstant.EXTRA_KEY_DOWNLOAD_URL));
            if (bcVar.kj()) {
                JSONObject jSONObjectOptJSONObject21 = jSONObject.optJSONObject("native_lp_content");
                if (jSONObjectOptJSONObject21 != null) {
                    bcVar.nr(jSONObjectOptJSONObject21);
                } else {
                    com.bytedance.sdk.openadsdk.core.gi.nr.u(bcVar.dw(), new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.u.1
                        @Override // com.bytedance.sdk.openadsdk.core.gi.nr.u
                        public void u(int i6, String str2) {
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.gi.nr.u
                        public void u(JSONObject jSONObject3) {
                            bcVar.nr(jSONObject3);
                        }
                    });
                }
            }
            bcVar.t(jSONObject.optInt("promotion_type"));
            jSONObjectOptJSONObject = jSONObject.optJSONObject("dylite_info");
            if (jSONObjectOptJSONObject != null) {
                com.bytedance.sdk.openadsdk.core.ugeno.jk.u uVar = new com.bytedance.sdk.openadsdk.core.ugeno.jk.u();
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("product_infos");
                if (jSONArrayOptJSONArray5 != null) {
                    uVar.u(jSONArrayOptJSONArray5);
                }
                JSONObject jSONObjectOptJSONObject22 = jSONObjectOptJSONObject.optJSONObject("coupon");
                if (jSONObjectOptJSONObject22 != null) {
                    uVar.u(jSONObjectOptJSONObject22);
                }
                JSONObject jSONObjectOptJSONObject23 = jSONObjectOptJSONObject.optJSONObject("render_config");
                if (jSONObjectOptJSONObject23 != null) {
                    uVar.nr(jSONObjectOptJSONObject23);
                }
                JSONObject jSONObjectOptJSONObject24 = jSONObjectOptJSONObject.optJSONObject("live_room_data");
                if (jSONObjectOptJSONObject24 != null) {
                    uVar.fx(jSONObjectOptJSONObject24);
                }
                JSONObject jSONObjectOptJSONObject25 = jSONObjectOptJSONObject.optJSONObject("ec_mall_conf");
                if (jSONObjectOptJSONObject25 != null) {
                    uVar.b(jSONObjectOptJSONObject25);
                }
                bcVar.u(uVar);
            }
            jSONObjectOptJSONObject2 = jSONObject.optJSONObject("splash_control");
            if (jSONObjectOptJSONObject2 != null) {
                bcVar.u(u(jSONObjectOptJSONObject2, bcVar.sv()));
            }
            bcVar.ja(jSONObject.optString("ad_info"));
            bcVar.t(jSONObject.optBoolean("close_on_dislike", false));
            bcVar.wq(jSONObject.optString("adx_name"));
            bcVar.yd(jSONObject.optInt("endcard_close_time", 0));
            bcVar.ay(jSONObject.optInt("proportion_watching", 100));
            bcVar.gc(jSONObject.optInt("video_skip_result", 3));
            mVar = new m(jSONObject);
            bcVar.u(mVar);
            if (mVar.u()) {
                if (d.b()) {
                    bcVar.v(-2);
                } else {
                    bcVar.v(0);
                }
            }
            bcVar.u(new zx(jSONObject));
            bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.c(jSONObject));
            bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.bf(jSONObject));
            u(bcVar, jSONObject);
            jSONObjectOptJSONObject3 = jSONObject.optJSONObject("skip_control");
            if (jSONObjectOptJSONObject3 != null) {
                kw kwVar = new kw();
                kwVar.u(jSONObjectOptJSONObject3.optInt(EventParams.KEY_CT_SDK_POSITION, 2));
                kwVar.nr(jSONObjectOptJSONObject3.optInt("left_or_right_margin", 16));
                kwVar.fx(jSONObjectOptJSONObject3.optInt("top_or_bottom_margin", 30));
                kwVar.b(jSONObjectOptJSONObject3.optInt("skip_style", 1));
                kwVar.pn(jSONObjectOptJSONObject3.optInt("hide_native_skip_logo", 0));
                bcVar.u(kwVar);
            }
            bcVar.su(jSONObject.optInt("shake_value", 13));
            bcVar.mk(jSONObject.optInt("deep_shake_value"));
            bcVar.mh(jSONObject.optInt("rotation_angle", 50));
            bcVar.m(jSONObject.optInt("dynamic_join_type", 0));
            bcVar.jp(jSONObject.optInt("dynamic_join_duration", 0));
            bcVar.gi(jSONObject.optInt("calculation_method", 0));
            jSONObjectOptJSONObject4 = jSONObject.optJSONObject("splash_compliance_bar");
            if (jSONObjectOptJSONObject4 != null) {
                gc gcVar = new gc();
                gcVar.u(jSONObjectOptJSONObject4.optInt("show_type", 0));
                gcVar.nr(jSONObjectOptJSONObject4.optInt("blank", 90));
                gcVar.fx(jSONObjectOptJSONObject4.optInt("half_blank", 90));
                bcVar.u(gcVar);
            }
            bcVar.eh(jSONObject.optInt("show_poll_time", Integer.MIN_VALUE));
            bcVar.l(jSONObject.optString("adm"));
            bcVar.pn(jSONObject.optBoolean("is_cache"));
            bcVar.a(jSONObject.optString("log_ext"));
            bcVar.x(jSONObject.optString(EventParams.KEY_CACHE_EXT));
            strOptString = jSONObject.optString(ReportItem.RequestKeyRequestId);
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(bcVar.wq())) {
                bcVar.n(strOptString);
            }
            bcVar.u(jSONObject.optLong("cache_time"));
            bcVar.jk(jSONObject.optString("material_key"));
            bcVar.iz(jSONObject.optBoolean("need_get_materials"));
            bcVar.fx(jSONObject.optLong("s_send_ts"));
            bcVar.u(jw.u(jSONObject.optJSONObject("wc_miniapp_info")));
            bcVar.xg(jSONObject.optString("live_room_id", ""));
            bcVar.lf(jSONObject.optInt(EventParams.KEY_PARAM_ADTYPE, 0));
            bcVar.nb(jSONObject.optInt("live_interaction_type", 1));
            bcVar.mv(jSONObject.optString("ec_schema", ""));
            bcVar.k(jSONObject.optInt("draw_video_playcount", 2));
            jSONObjectOptJSONObject5 = jSONObject.optJSONObject("dynamic_join_coupon_style");
            if (jSONObjectOptJSONObject5 != null) {
                com.bytedance.sdk.openadsdk.core.kj.s sVar = new com.bytedance.sdk.openadsdk.core.kj.s();
                sVar.u(jSONObjectOptJSONObject5.optInt("style_type"));
                sVar.u(jSONObjectOptJSONObject5.optString(WfConstant.EXTRA_KEY_IMAGE_URL));
                sVar.nr(jSONObjectOptJSONObject5.optInt(EventParams.KEY_CT_SDK_POSITION));
                sVar.u(jSONObjectOptJSONObject5.optDouble(WfConstant.EXTRA_KEY_IMAGE_HEIGHT));
                sVar.nr(jSONObjectOptJSONObject5.optString("image_gif_url"));
                sVar.nr(jSONObjectOptJSONObject5.optDouble("image_scale_rate"));
                sVar.fx(jSONObjectOptJSONObject5.optDouble("image_gif_aspect_ratio"));
                bcVar.u(sVar);
            }
            bcVar.m(jSONObject.optString("ecom_live_params"));
            bcVar.fx(jSONObject.optJSONObject(f.K));
            bcVar.u(com.bytedance.sdk.openadsdk.core.kj.mv.u(jSONObject.optJSONObject("coupon")));
            bcVar.u(com.bytedance.sdk.openadsdk.core.kj.jp.u(jSONObject.optJSONObject("live_info")));
            bcVar.u(v.u(jSONObject.optJSONObject("saas_info")));
            jSONObjectOptJSONObject6 = jSONObject.optJSONObject("video_config");
            if (jSONObjectOptJSONObject6 != null) {
                com.bytedance.sdk.openadsdk.core.kj.f fVar = new com.bytedance.sdk.openadsdk.core.kj.f();
                fVar.u(jSONObjectOptJSONObject6.optInt("video_adapter_type", 1));
                fVar.nr(jSONObjectOptJSONObject6.optInt("video_mute_type", 1));
                bcVar.u(fVar);
            }
            jSONObjectOptJSONObject7 = jSONObject.optJSONObject("click_trigger_config");
            if (jSONObjectOptJSONObject7 != null) {
                com.bytedance.sdk.openadsdk.core.kj.t tVar = new com.bytedance.sdk.openadsdk.core.kj.t();
                tVar.u(jSONObjectOptJSONObject7.optInt("click_trigger_type"));
                tVar.u((float) jSONObjectOptJSONObject7.optDouble("shake_start_time", 0.0d));
                tVar.nr((float) jSONObjectOptJSONObject7.optDouble("shake_end_time", 2.147483648E9d));
                bcVar.u(tVar);
            }
            bcVar.d(jSONObject.optInt("calculation_method_twist"));
            bcVar.pb(jSONObject.optString("dynamic_configs"));
            bcVar.p(jSONObject.optInt("gnd_prefetch_timing"));
            bcVar.y(jSONObject.optString("gnd_prefetch_cache_key"));
            mapSj = bcVar.sj();
            if (mapSj == null) {
                mapSj = new HashMap<>();
                bcVar.u(mapSj);
            }
            strYf = bcVar.yf();
            if (strYf != null) {
                mapSj.put("ad_token", strYf);
                b.u().nr(strYf);
            }
            if (jSONObjectOptJSONObject10 != null && jSONObjectOptJSONObject10.optInt("style_category") != 0) {
                mapSj.put("style_category", Integer.valueOf(jSONObjectOptJSONObject10.optInt("style_category")));
            }
            bcVar.kw(jSONObject.optInt("click_freq"));
            bcVar.f(jSONObject.optInt("if_lpua_package"));
            bcVar.a(jSONObject.optJSONObject("twist_config"));
            bcVar.jk(jSONObject.optJSONObject("shake_interact_conf"));
            bcVar.t(jSONObject.optJSONObject("twist_interact_conf"));
            bcVar.u(com.bytedance.sdk.openadsdk.core.kj.gi.u(jSONObject));
            bcVar.u(jSONObject.optJSONObject("sdk_derive_info"));
            bcVar.b(jSONObject.optInt("disable_video_join"));
            bcVar.x(jSONObject.optInt("disable_top_bar"));
            bcVar.n(jSONObject.optInt("disable_rtn_button"));
            bcVar.nr(jSONObject.optInt("web_monitor_rate", 0));
            bcVar.iz(jSONObject.optInt("disable_slide_return"));
            bcVar.nr(jSONObject.optBoolean("disable_safe_area"));
            jSONArrayOptJSONArray = jSONObject.optJSONArray("haptic");
            if (jSONArrayOptJSONArray != null) {
                for (int i6 = 0; i6 < jSONArrayOptJSONArray.length(); i6++) {
                    bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.h(jSONArrayOptJSONArray.optJSONObject(i6)));
                }
            }
            bcVar.l(jSONObject.optJSONObject("_meta_life_record"));
            bcVar.xw(i <= 0 ? i : jSONObject.optInt("_ad_index", 1));
            return bcVar;
        }
        i2 = 0;
        bcVar.u(x(jSONObject.optJSONObject("media_ext")));
        bcVar.s(jSONObject.optInt("if_block_lp", i2));
        bcVar.qq(jSONObject.optInt("cache_sort", 1));
        bcVar.kj(jSONObject.optInt("if_sp_cache", 1));
        bcVar.z(jSONObject.optInt("splash_timeout_stage", 1));
        bcVar.jk(jSONObject.optInt("page_render_type", 0));
        if (bcVar.rh() == 1) {
            uVarU = u(jSONObjectOptJSONObject8, bcVar);
            bcVar.u(uVarU);
            if (!com.bytedance.sdk.openadsdk.core.ugeno.x.u().nr(uVarU.u(), uVarU.nr())) {
            }
        }
        bcVar.a(jSONObject.optInt("native_lp_tpl_id"));
        bcVar.b(jSONObject.optString("native_lp_data"));
        bcVar.pn(jSONObject.optString("native_lp_ugen_url"));
        bcVar.iz(jSONObject.optString("native_lp_ugen_md5"));
        bcVar.b(jSONObject.optBoolean("native_lp_is_preload"));
        bcVar.fx(jSONObject.optString(WfConstant.EXTRA_KEY_DOWNLOAD_URL));
        if (bcVar.kj()) {
        }
        bcVar.t(jSONObject.optInt("promotion_type"));
        jSONObjectOptJSONObject = jSONObject.optJSONObject("dylite_info");
        if (jSONObjectOptJSONObject != null) {
        }
        jSONObjectOptJSONObject2 = jSONObject.optJSONObject("splash_control");
        if (jSONObjectOptJSONObject2 != null) {
        }
        bcVar.ja(jSONObject.optString("ad_info"));
        bcVar.t(jSONObject.optBoolean("close_on_dislike", false));
        bcVar.wq(jSONObject.optString("adx_name"));
        bcVar.yd(jSONObject.optInt("endcard_close_time", 0));
        bcVar.ay(jSONObject.optInt("proportion_watching", 100));
        bcVar.gc(jSONObject.optInt("video_skip_result", 3));
        mVar = new m(jSONObject);
        bcVar.u(mVar);
        if (mVar.u()) {
        }
        bcVar.u(new zx(jSONObject));
        bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.c(jSONObject));
        bcVar.u(new com.bytedance.sdk.openadsdk.core.kj.bf(jSONObject));
        u(bcVar, jSONObject);
        jSONObjectOptJSONObject3 = jSONObject.optJSONObject("skip_control");
        if (jSONObjectOptJSONObject3 != null) {
        }
        bcVar.su(jSONObject.optInt("shake_value", 13));
        bcVar.mk(jSONObject.optInt("deep_shake_value"));
        bcVar.mh(jSONObject.optInt("rotation_angle", 50));
        bcVar.m(jSONObject.optInt("dynamic_join_type", 0));
        bcVar.jp(jSONObject.optInt("dynamic_join_duration", 0));
        bcVar.gi(jSONObject.optInt("calculation_method", 0));
        jSONObjectOptJSONObject4 = jSONObject.optJSONObject("splash_compliance_bar");
        if (jSONObjectOptJSONObject4 != null) {
        }
        bcVar.eh(jSONObject.optInt("show_poll_time", Integer.MIN_VALUE));
        bcVar.l(jSONObject.optString("adm"));
        bcVar.pn(jSONObject.optBoolean("is_cache"));
        bcVar.a(jSONObject.optString("log_ext"));
        bcVar.x(jSONObject.optString(EventParams.KEY_CACHE_EXT));
        strOptString = jSONObject.optString(ReportItem.RequestKeyRequestId);
        if (!TextUtils.isEmpty(strOptString)) {
            bcVar.n(strOptString);
        }
        bcVar.u(jSONObject.optLong("cache_time"));
        bcVar.jk(jSONObject.optString("material_key"));
        bcVar.iz(jSONObject.optBoolean("need_get_materials"));
        bcVar.fx(jSONObject.optLong("s_send_ts"));
        bcVar.u(jw.u(jSONObject.optJSONObject("wc_miniapp_info")));
        bcVar.xg(jSONObject.optString("live_room_id", ""));
        bcVar.lf(jSONObject.optInt(EventParams.KEY_PARAM_ADTYPE, 0));
        bcVar.nb(jSONObject.optInt("live_interaction_type", 1));
        bcVar.mv(jSONObject.optString("ec_schema", ""));
        bcVar.k(jSONObject.optInt("draw_video_playcount", 2));
        jSONObjectOptJSONObject5 = jSONObject.optJSONObject("dynamic_join_coupon_style");
        if (jSONObjectOptJSONObject5 != null) {
        }
        bcVar.m(jSONObject.optString("ecom_live_params"));
        bcVar.fx(jSONObject.optJSONObject(f.K));
        bcVar.u(com.bytedance.sdk.openadsdk.core.kj.mv.u(jSONObject.optJSONObject("coupon")));
        bcVar.u(com.bytedance.sdk.openadsdk.core.kj.jp.u(jSONObject.optJSONObject("live_info")));
        bcVar.u(v.u(jSONObject.optJSONObject("saas_info")));
        jSONObjectOptJSONObject6 = jSONObject.optJSONObject("video_config");
        if (jSONObjectOptJSONObject6 != null) {
        }
        jSONObjectOptJSONObject7 = jSONObject.optJSONObject("click_trigger_config");
        if (jSONObjectOptJSONObject7 != null) {
        }
        bcVar.d(jSONObject.optInt("calculation_method_twist"));
        bcVar.pb(jSONObject.optString("dynamic_configs"));
        bcVar.p(jSONObject.optInt("gnd_prefetch_timing"));
        bcVar.y(jSONObject.optString("gnd_prefetch_cache_key"));
        mapSj = bcVar.sj();
        if (mapSj == null) {
        }
        strYf = bcVar.yf();
        if (strYf != null) {
        }
        if (jSONObjectOptJSONObject10 != null) {
            mapSj.put("style_category", Integer.valueOf(jSONObjectOptJSONObject10.optInt("style_category")));
        }
        bcVar.kw(jSONObject.optInt("click_freq"));
        bcVar.f(jSONObject.optInt("if_lpua_package"));
        bcVar.a(jSONObject.optJSONObject("twist_config"));
        bcVar.jk(jSONObject.optJSONObject("shake_interact_conf"));
        bcVar.t(jSONObject.optJSONObject("twist_interact_conf"));
        bcVar.u(com.bytedance.sdk.openadsdk.core.kj.gi.u(jSONObject));
        bcVar.u(jSONObject.optJSONObject("sdk_derive_info"));
        bcVar.b(jSONObject.optInt("disable_video_join"));
        bcVar.x(jSONObject.optInt("disable_top_bar"));
        bcVar.n(jSONObject.optInt("disable_rtn_button"));
        bcVar.nr(jSONObject.optInt("web_monitor_rate", 0));
        bcVar.iz(jSONObject.optInt("disable_slide_return"));
        bcVar.nr(jSONObject.optBoolean("disable_safe_area"));
        jSONArrayOptJSONArray = jSONObject.optJSONArray("haptic");
        if (jSONArrayOptJSONArray != null) {
        }
        bcVar.l(jSONObject.optJSONObject("_meta_life_record"));
        bcVar.xw(i <= 0 ? i : jSONObject.optInt("_ad_index", 1));
        return bcVar;
    }

    private static com.bytedance.sdk.openadsdk.core.ugeno.x.u u(JSONObject jSONObject, bc bcVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar = new com.bytedance.sdk.openadsdk.core.ugeno.x.u();
        uVar.u(jSONObject.optString("id"));
        uVar.nr(jSONObject.optString("md5"));
        uVar.fx(jSONObject.optString("url"));
        uVar.u(jSONObject.optInt("scene"));
        return uVar;
    }

    private static void u(bc bcVar, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.kj.my myVarKv;
        if (bcVar == null || jSONObject == null) {
            return;
        }
        if ((m.u(bcVar) || su.u(bcVar)) && (myVarKv = bcVar.kv()) != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live_deep_link_params");
            com.bytedance.sdk.openadsdk.core.kj.xg xgVar = new com.bytedance.sdk.openadsdk.core.kj.xg();
            if (jSONObjectOptJSONObject != null) {
                xgVar.u(jSONObjectOptJSONObject.optString("reward_live_deep_link_user_id"));
                xgVar.pn(jSONObjectOptJSONObject.optString("reward_live_deep_link_request_id"));
                xgVar.nr(jSONObjectOptJSONObject.optString("reward_live_deep_link_room_id"));
                xgVar.fx(jSONObjectOptJSONObject.optString("reawrd_live_short_touch_params"));
                xgVar.b(jSONObjectOptJSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
                xgVar.u(jSONObjectOptJSONObject.optLong("reward_live_last_time"));
                bcVar.u(xgVar);
            } else {
                Map<String, String> mapU = com.bytedance.sdk.openadsdk.core.y.bc.u(myVarKv.nr());
                if (mapU == null || mapU.size() <= 0) {
                    return;
                }
                xgVar.u(mapU.get("user_id"));
                xgVar.pn(mapU.get(be.g));
                xgVar.nr(mapU.get("room_id"));
                xgVar.fx(mapU.get("live_short_touch_params"));
                xgVar.b(mapU.get("extra_pangle_scheme_params"));
                bcVar.u(xgVar);
            }
            bcVar.jk(jSONObject.optBoolean("not_valid_download_url", false));
        }
    }

    private static mk u(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        mk mkVar = new mk();
        double dOptDouble = jSONObject.optDouble("splash_clickarea", 1.0d);
        mkVar.u((int) ((dOptDouble == 1.0d || dOptDouble == 2.0d) ? dOptDouble : 1.0d));
        mkVar.x(jSONObject.optInt("splash_style_id", 0));
        mkVar.u(jSONObject.optString("splash_clicktext", ""));
        mkVar.nr(jSONObject.optInt("area_height", 50));
        mkVar.fx(jSONObject.optInt("area_width", 236));
        if (i == 2) {
            mkVar.b(jSONObject.optInt("area_blank_height", 32));
        } else {
            mkVar.b(jSONObject.optInt("area_blank_height", 82));
        }
        mkVar.pn(jSONObject.optInt("half_blank_height", 56));
        mkVar.nr(jSONObject.optString("btn_background_dest_color", "#008DEA"));
        mkVar.fx(jSONObject.optString("top_splash_clicktext"));
        mkVar.u(jSONObject.optJSONObject("text_config"));
        mkVar.nr(jSONObject.optJSONObject("top_text_config"));
        mkVar.n(jSONObject.optInt("sliding_distance", 5));
        mkVar.u(jSONObject.optJSONObject("slide_area"), i);
        mkVar.iz(jSONObject.optInt("splash_load_time_optimization"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mock_interact");
        if (jSONObjectOptJSONObject != null) {
            try {
                mkVar.u((float) jSONObjectOptJSONObject.optDouble("enable_ratio", 0.0d));
                mkVar.a(jSONObjectOptJSONObject.optInt("backup_add", 0));
                mkVar.jk(jSONObjectOptJSONObject.optInt("slide_direction", 0));
                mkVar.t(jSONObjectOptJSONObject.optInt("slide_threshold", 55));
                mkVar.l(jSONObjectOptJSONObject.optInt("view_height_dynamic", 0));
                mkVar.nr((float) jSONObjectOptJSONObject.optDouble("view_height_percent", 0.0d));
                mkVar.mv(jSONObjectOptJSONObject.optInt("view_post", 100));
                mkVar.s(jSONObjectOptJSONObject.optInt("ignore_up", 0));
                mkVar.k(jSONObjectOptJSONObject.optInt("long_press_duration", 0));
                mkVar.my(jSONObjectOptJSONObject.optInt("long_press_threshold", 10));
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.k.nr("SplashControl", "interact parse error");
            }
        }
        return mkVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int u(bc bcVar, int i) {
        if (TextUtils.isEmpty(bcVar.lk()) || bcVar.lk().length() <= 1) {
            return 401;
        }
        int iU = u(bcVar.kv());
        if (iU != 200) {
            return iU;
        }
        int iU2 = u(bcVar);
        if (iU2 != 200) {
            return iU2;
        }
        int iQf = bcVar.qf();
        if (iQf == 2 || iQf == 3) {
            if (TextUtils.isEmpty(bcVar.jf())) {
                return 405;
            }
        } else if (iQf != 4) {
            if (iQf == 5 && TextUtils.isEmpty(bcVar.vp())) {
                return 408;
            }
        } else {
            iU2 = u(bcVar.pu());
            if (iU2 != 200) {
                return iU2;
            }
        }
        int iOl = bcVar.ol();
        if (iOl == 2 || iOl == 3 || iOl == 4) {
            iU2 = nr(bcVar.zu());
            if (iU2 != 200) {
            }
        } else if (iOl == 5 || iOl == 15) {
            iU2 = zx.jk(bcVar);
            if (iU2 != 200) {
                return iU2;
            }
        } else if (iOl != 16) {
            if (iOl == 166 && (iU2 = nr(bcVar, i)) != 200) {
                return iU2;
            }
        }
        return iU2;
    }

    private static int u(bc bcVar) {
        if (!(bcVar.ol() == 166 && m.u(bcVar)) || d.b()) {
            return 200;
        }
        com.bytedance.sdk.component.utils.k.u("穿山甲sdk没有集成点播/直播aar，不支持直播物料");
        return 404;
    }

    private static int u(com.bytedance.sdk.openadsdk.core.kj.my myVar) {
        if (myVar == null) {
            return 200;
        }
        if (!TextUtils.isEmpty(myVar.nr()) && !TextUtils.isEmpty(myVar.b())) {
            return (myVar.pn() == 1 || myVar.pn() == 2) ? 200 : 403;
        }
        if (TextUtils.isEmpty(myVar.nr())) {
            return 402;
        }
        return TTAdConstant.DEEPLINK_FALL_BACK_CODE;
    }

    private static int u(com.bytedance.sdk.openadsdk.core.kj.pn pnVar) {
        if (pnVar == null) {
            return 406;
        }
        return TextUtils.isEmpty(pnVar.nr()) ? 407 : 200;
    }

    public static void u(List<bc> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        List<bc> listSubList = list.subList(1, list.size());
        JSONArray jSONArray = new JSONArray();
        Iterator<bc> it = listSubList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().et());
        }
        if (jSONArray.length() > 0) {
            list.get(0).jp(jSONArray.toString());
        }
    }
}
