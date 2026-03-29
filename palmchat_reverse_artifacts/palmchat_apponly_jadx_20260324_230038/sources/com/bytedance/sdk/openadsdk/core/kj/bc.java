package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.mk;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bq;
import com.kwad.sdk.api.model.AdnName;
import com.qiniu.android.collect.ReportItem;
import com.wifi.ad.core.config.EventParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.cordova.jssdk.RedPacketPullNewPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f5298a;
    private int ad;
    private t ah;
    private int al;
    private bg ap;
    private yd ay;
    private int az;
    private int b;
    private xw ba;
    private int bf;
    private int bj;
    private gc bl;
    private int bo;
    private mv bp;
    private String bv;
    private dw c;
    private kw cb;

    /* JADX INFO: renamed from: cn, reason: collision with root package name */
    private String f5299cn;
    private String d;
    private String db;
    private int dc;
    private int dd;

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    private wq f5300de;
    private boolean df;
    private long dj;
    private int dr;
    private pn dw;
    private int e;
    private m eh;
    private c en;
    private com.bytedance.sdk.openadsdk.core.ugeno.x.u et;
    private String ex;
    private String f;
    private boolean fa;
    private String fi;
    private String fn;
    private com.bytedance.sdk.openadsdk.core.dislike.fx.nr fx;
    private JSONObject fz;
    private tk g;
    private boolean gb;
    private com.bytedance.sdk.openadsdk.my.fx.fx.nr gc;
    private JSONObject ge;
    private JSONObject gi;
    private String gl;
    private volatile String gs;
    private z gz;
    private long h;
    private JSONObject hc;
    private kj hl;
    private String hs;

    /* JADX INFO: renamed from: im, reason: collision with root package name */
    private int f5301im;
    private JSONObject ir;
    private volatile JSONObject is;
    private String it;
    private String iz;
    private int j;
    private int ja;
    private String jc;
    private int je;
    private int jf;
    private JSONObject jk;
    private JSONObject jq;
    private JSONObject ju;
    private String k;
    private String kd;
    private int kg;
    private String ki;
    private String kj;
    private cj kv;
    private int ky;
    private String l;
    private f lk;
    private qq ll;
    private boolean ls;
    private boolean m;
    private int md;
    private bq mh;
    private int mk;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f5303ms;
    private s mx;
    private long my;
    private String n;
    private int na;
    private int ng;
    public String nr;
    private JSONObject nu;
    private String o;
    private int ol;
    private int p;
    private int pb;
    private rh pn;
    private String ps;
    private long pu;
    private my q;
    private int qf;
    private boolean qj;
    private int qn;
    private com.bytedance.sdk.openadsdk.core.ugeno.jk.u qp;
    private int qq;
    private o qv;
    private xg r;
    private long rh;
    private mk sf;
    private boolean si;
    private String sj;
    private boolean su;
    private ja sv;
    private String sx;
    private long te;
    private String ti;
    private iz tq;
    private String tr;
    private nb ts;
    public jw u;
    private int ua;
    private int uc;
    private wi v;
    private String vk;
    private int vp;
    private String vz;
    private String wf;
    private String wj;
    private zx wq;
    private boolean xg;
    private w xh;
    private bf xx;
    private v yb;
    private Map<String, Object> yd;
    private gi yf;
    private jp ym;
    private boolean yy;
    private String z;
    private su zn;
    private String zq;
    private String zu;
    private int zx;
    private int x = -1;
    private List<rh> t = new ArrayList();
    private List<String> mv = new ArrayList();
    private List<String> s = new ArrayList();
    private String bg = "0";
    private String bq = "0";

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private int f5302jp = -1;
    private long y = -1;
    private long bc = -1;
    private int xw = -1;
    private int oa = 1;
    private long w = System.currentTimeMillis();
    private String cj = UUID.randomUUID().toString();
    private int tk = 1;
    private String wi = "";
    private int lf = -200;
    private int nb = 0;
    private int kw = 1;
    private int za = 0;
    private int tm = 0;
    private int rv = 0;
    private int ob = 1;
    private int jw = 0;
    private int uq = 0;
    private int rg = 0;
    private int i = 1;
    private boolean qe = false;
    private int ic = 1;
    private float iq = 100.0f;
    private int ec = 0;
    private int pq = 2;
    private int hm = 0;
    private int wu = 100;
    private int uk = 2;
    private int jn = 2;
    private float qb = 0.07f;
    private float wv = 0.0f;
    private long up = 0;
    private boolean ln = true;
    private int la = -1;
    private int hj = 0;
    private int wo = 0;
    private long fq = 0;
    private int uo = 0;
    private List<h> lc = new ArrayList();
    private int ss = -1;

    private float ml() {
        if (this.sf == null) {
            return 5.0f;
        }
        return r0.k();
    }

    public int a() {
        return this.az;
    }

    public List<String> ad() {
        return this.mv;
    }

    public boolean ah() {
        return this.m;
    }

    public wq al() {
        return this.f5300de;
    }

    public int an() {
        if (this.b == 4 && TextUtils.isEmpty(this.f)) {
            return this.qf;
        }
        return 0;
    }

    public String ap() {
        return this.z;
    }

    public boolean ar() {
        return this.ls;
    }

    public cj ay() {
        return this.kv;
    }

    public boolean az() {
        int iMy = com.bytedance.sdk.openadsdk.core.y.jp.my(this);
        return iMy == 3 || iMy == 6;
    }

    public int b() {
        return this.ss;
    }

    public float ba() {
        if (this.iq <= 0.0f) {
            this.iq = 100.0f;
        }
        return (this.iq * 1000.0f) / 1000.0f;
    }

    public mv bb() {
        return this.bp;
    }

    public long bc() {
        return this.te;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.jk.u bf() {
        return this.qp;
    }

    public boolean bg() {
        return this.si;
    }

    public JSONObject bi() {
        return this.fz;
    }

    public w bj() {
        return this.xh;
    }

    public JSONObject bl() {
        return this.f5298a;
    }

    public long bo() {
        return this.bc;
    }

    public long bp() {
        return this.my;
    }

    public String bq() {
        return this.kd;
    }

    public int bt() {
        return this.hj;
    }

    public int bv() {
        return this.tk;
    }

    public int c() {
        return this.bo;
    }

    public boolean cb() {
        return this.oa == 1;
    }

    public int cj() {
        return this.bf;
    }

    public float cn() {
        float f = this.wv;
        if (f < 0.0f || f > 50.0f) {
            this.wv = 0.0f;
        }
        return this.wv;
    }

    public String d() {
        return this.tr;
    }

    public int db() {
        return this.f5302jp;
    }

    public boolean dc() {
        mk mkVar = this.sf;
        return mkVar == null || mkVar.fx();
    }

    public rh dd() {
        return this.pn;
    }

    public int de() {
        return this.ua;
    }

    public int df() {
        mk mkVar = this.sf;
        if (mkVar == null) {
            return 0;
        }
        return mkVar.n();
    }

    public int dj() {
        mk mkVar = this.sf;
        if (mkVar == null) {
            return 0;
        }
        return mkVar.a();
    }

    public boolean dr() {
        return this.xg;
    }

    public String dv() {
        JSONObject jSONObject = this.ge;
        String strOptString = jSONObject != null ? jSONObject.optString("session_id") : "";
        return TextUtils.isEmpty(strOptString) ? pg() : strOptString;
    }

    public String dw() {
        return this.ps;
    }

    public gc dx() {
        return this.bl;
    }

    public JSONObject e() {
        return this.jk;
    }

    public JSONObject ec() {
        return this.nu;
    }

    public String eh() {
        return this.vz;
    }

    public v ej() {
        return this.yb;
    }

    public String en() {
        return this.bq;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            bc bcVar = (bc) obj;
            if (this.bg.equals(bcVar.bg) && this.z.equals(bcVar.z)) {
                return true;
            }
        }
        return false;
    }

    public JSONObject et() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s_sig_ts", wo());
            jSONObject.put("ad_rec_stamp", si());
            jSONObject.put(WfConstant.EXTRA_KEY_INTERACTION_TYPE, qf());
            jSONObject.put("target_url", jf());
            jSONObject.put("use_media_video_player", tk());
            jSONObject.put("landing_scroll_percentage", qb());
            jSONObject.put("gecko_id", wv());
            jSONObject.put("extension", bl());
            jSONObject.put("overlay", e());
            jSONObject.put(MediationConstant.EXTRA_ADID, lk());
            jSONObject.put(az.at, j());
            jSONObject.put("package_name", it());
            jSONObject.put(RedPacketPullNewPlugin.ACTION_SCREENSHOT, dr());
            jSONObject.put("play_bar_style", za());
            jSONObject.put("play_bar_show_time", ob());
            jSONObject.put("if_block_lp", mh());
            jSONObject.put("cache_sort", ju());
            jSONObject.put("if_sp_cache", zx());
            jSONObject.put("splash_timeout_stage", jw());
            jSONObject.put("is_from_local_cache", ah());
            jSONObject.put("is_from_cache_type", db());
            jSONObject.put("correct_action_code", ps());
            jSONObject.put("correct_result_code", bo());
            jSONObject.put("meta_hashcode", n());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cta", w());
            jSONObject2.put(AdnName.OTHER, oa());
            jSONObject.put("set_click_type", jSONObject2);
            rh rhVarDd = dd();
            if (rhVarDd != null && !TextUtils.isEmpty(rhVarDd.u())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", rhVarDd.u());
                jSONObject3.put("height", rhVarDd.fx());
                jSONObject3.put("width", rhVarDd.nr());
                jSONObject.put("icon", jSONObject3);
            }
            Object objYy = yy();
            if (objYy != null) {
                jSONObject.put("session_params", objYy);
            }
            Object objIs = is();
            if (objIs != null) {
                jSONObject.put("cache_control", objIs);
            }
            com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm = tm();
            if (nrVarTm != null) {
                jSONObject.put("adslot", com.bytedance.sdk.openadsdk.core.y.h.u(nrVarTm));
            }
            List<rh> listZu = zu();
            if (listZu != null) {
                JSONArray jSONArray = new JSONArray();
                for (rh rhVar : listZu) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("url", rhVar.u());
                    jSONObject4.put("height", rhVar.fx());
                    jSONObject4.put("width", rhVar.nr());
                    jSONObject4.put("image_preview", rhVar.iz());
                    jSONObject4.put("image_key", rhVar.x());
                    jSONArray.put(jSONObject4);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> listAd = ad();
            if (listAd != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = listAd.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> listMx = mx();
            if (listMx != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = listMx.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put("click_url", jSONArray3);
            }
            jSONObject.put("phone_num", vp());
            jSONObject.put("title", wf());
            jSONObject.put("download_num", bp());
            jSONObject.put("description", ym());
            jSONObject.put("ext", ap());
            jSONObject.put(ReportItem.RequestKeyRequestId, xx());
            jSONObject.put("image_mode", ol());
            jSONObject.put("intercept_flag", rv());
            jSONObject.put("web_inspector", ge());
            jSONObject.put("button_text", yb());
            jSONObject.put("ad_logo", f());
            jSONObject.put("video_adaptation", kw());
            jSONObject.put("feed_video_opentype", mk());
            jSONObject.put("feed_reward_type", p());
            jSONObject.put(bq.f.V, sv());
            jSONObject.put("aspect_ratio", ba());
            jSONObject.put("aspect_margin", ng());
            jSONObject.put("corner_radius", cn());
            pn pnVarPu = pu();
            if (pnVarPu != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("app_name", pnVarPu.fx());
                jSONObject5.put("package_name", pnVarPu.b());
                jSONObject5.put(WfConstant.EXTRA_KEY_DOWNLOAD_URL, pnVarPu.nr());
                jSONObject5.put("score", pnVarPu.pn());
                jSONObject5.put("comment_num", pnVarPu.iz());
                jSONObject5.put("quick_app_url", pnVarPu.u());
                jSONObject5.put("app_size", pnVarPu.x());
                jSONObject.put("app", jSONObject5);
            }
            dw dwVarG = g();
            if (dwVarG != null) {
                jSONObject.put("download_sdk_conf", dwVarG.fx());
            }
            if (wi() != null) {
                wi().nr(jSONObject);
            }
            if (ga() != null) {
                ga().u(jSONObject);
            }
            if (kv() != null) {
                kv().u(jSONObject);
            }
            if (vz() != null) {
                vz().u(jSONObject);
            }
            if (v() != null) {
                v().nr(jSONObject);
            }
            if (ay() != null) {
                ay().u(jSONObject);
            }
            if (nb() != null) {
                nb().u(jSONObject);
            }
            if (bj() != null) {
                bj().u(jSONObject);
            }
            if (gc() != null) {
                gc().u(jSONObject);
            }
            if (al() != null) {
                al().u(jSONObject);
            }
            if (qj() != null) {
                qj().u(jSONObject);
            }
            if (su() != null) {
                su().nr(jSONObject);
            }
            jSONObject.put("count_down", up());
            jSONObject.put("expiration_time", qn());
            jSONObject.put("client_expiration_time", qn());
            jSONObject.put("_child_metas", lg());
            jSONObject.put("_meta_life_record", pm().u());
            jSONObject.put("src_req_id", ls());
            jSONObject.put("player_type", oi());
            jSONObject.put("video_encode_type", uk());
            jSONObject.put("feed_video_finish_type", cj());
            if (r() != null) {
                r().u(jSONObject);
            }
            if (wj() != null) {
                wj().u(jSONObject);
            }
            jSONObject.put("if_both_open", ll());
            jSONObject.put("if_double_deeplink", hj());
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("splash_clickarea", uq());
            jSONObject6.put("splash_clicktext", rg());
            jSONObject6.put("area_height", ua());
            jSONObject6.put("area_width", sf());
            jSONObject6.put("area_blank_height", i());
            jSONObject6.put("half_blank_height", qe());
            jSONObject6.put("splash_style_id", dj());
            jSONObject6.put("btn_background_dest_color", tr());
            jSONObject6.put("top_splash_clicktext", ex());
            jSONObject6.put("splash_load_time_optimization", df());
            jSONObject6.put("text_config", hs() != null ? hs().u() : null);
            jSONObject6.put("top_text_config", te() != null ? te().u() : null);
            jSONObject6.put("sliding_distance", ml());
            jSONObject6.put("slide_area", ti() != null ? ti().pn() : null);
            jSONObject.put("splash_control", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put(EventParams.KEY_CT_SDK_POSITION, gb());
            jSONObject7.put("left_or_right_margin", gl());
            jSONObject7.put("top_or_bottom_margin", fn());
            kw kwVar = this.cb;
            jSONObject7.put("skip_style", kwVar == null ? 1 : kwVar.b());
            kw kwVar2 = this.cb;
            jSONObject7.put("hide_native_skip_logo", kwVar2 == null ? 0 : kwVar2.pn());
            jSONObject.put("skip_control", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("show_type", je());
            jSONObject8.put("blank", ic());
            jSONObject8.put("half_blank", iq());
            jSONObject.put("splash_compliance_bar", jSONObject8);
            if (sj() != null) {
                JSONObject jSONObject9 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = sj().entrySet();
                if (setEntrySet != null && !setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject9.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject9);
            }
            jSONObject.put("isDirectDownload", bg());
            jSONObject.put("page_render_type", rh());
            jSONObject.put("promotion_type", xw());
            jSONObject.put("if_lpua_package", this.al);
            jSONObject.put("click_freq", this.wo);
            com.bytedance.sdk.openadsdk.core.ugeno.x.u uVarJa = ja();
            if (uVarJa != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("id", uVarJa.u());
                jSONObject10.put("md5", uVarJa.nr());
                jSONObject10.put("url", uVarJa.fx());
                jSONObject10.put("scene", uVarJa.b());
                jSONObject.put("ugeno", jSONObject10);
            }
            com.bytedance.sdk.openadsdk.core.ugeno.jk.u uVarBf = bf();
            if (uVarBf != null) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("product_infos", uVarBf.u());
                jSONObject11.put("coupon", uVarBf.nr());
                jSONObject11.put("render_config", uVarBf.fx());
                jSONObject11.put("live_room_data", uVarBf.b());
                jSONObject11.putOpt("ec_mall_conf", uVarBf.pn());
                jSONObject.put("dylite_info", jSONObject11);
            }
            jSONObject.put("native_lp_data", dw());
            jSONObject.put("native_lp_tpl_id", c());
            jSONObject.put("native_lp_ugen_url", q());
            jSONObject.put("native_lp_ugen_md5", qq());
            jSONObject.put(WfConstant.EXTRA_KEY_DOWNLOAD_URL, bq());
            jSONObject.put("native_lp_is_preload", kj());
            if (kj()) {
                jSONObject.put("native_lp_content", z());
            }
            jSONObject.put(WfConstant.EXTRA_KEY_MARKET_URL, kd());
            jSONObject.put("close_on_dislike", nz());
            iz izVarHm = hm();
            if (izVarHm != null) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put(WfConstant.EXTRA_KEY_DEVELOPER_NAME, izVarHm.x());
                jSONObject12.put("app_version", izVarHm.pn());
                jSONObject12.put("permissions", izVarHm.l());
                jSONObject12.put("privacy_policy_url", izVarHm.n());
                jSONObject12.put("package_name", izVarHm.mv());
                jSONObject12.put("app_name", izVarHm.s());
                jSONObject12.put("score", izVarHm.fx());
                jSONObject12.put("creative_tags", izVarHm.b());
                jSONObject12.put("permissions_url", izVarHm.nr());
                jSONObject12.put("desc_url", izVarHm.a());
                jSONObject12.put("reg_number", izVarHm.jk());
                jSONObject12.put("reg_url", izVarHm.t());
                jSONObject.put("app_manage", jSONObject12);
            }
            qq qqVarFa = fa();
            if (qqVarFa != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("ugen_dialog_url", qqVarFa.nr());
                jSONObject13.put("ugen_dialog_md5", qqVarFa.fx());
                jSONObject13.put("dialog_style", qqVarFa.u());
                jSONObject.put("easy_dl_dialog", jSONObject13);
            }
            if (ms() != null) {
                jSONObject.put("easy_pl_material", ms());
            }
            jSONObject.put("micro_app_type", b());
            jSONObject.put("app_manage_type", xh());
            jSONObject.put("lp_down_rule", zn() == 1 ? 1 : 0);
            jSONObject.put("auction_price", ir());
            jSONObject.put(OapsKey.KEY_PRICE, y());
            jSONObject.put("ad_info", yf());
            jSONObject.put("adx_name", uc());
            jSONObject.put("no_default_ttdsp_price", fz());
            jSONObject.put("endcard_close_time", im());
            jSONObject.put("proportion_watching", na());
            jSONObject.put("video_skip_result", mf());
            jSONObject.put("shake_value", gz());
            jSONObject.put("deep_shake_value", an());
            jSONObject.put("rotation_angle", qv());
            jSONObject.put("calculation_method", zq());
            jSONObject.put("calculation_method_twist", ki());
            jSONObject.put("show_poll_time", re());
            jSONObject.put("dynamic_join_type", ts());
            jSONObject.put("dynamic_join_duration", de());
            jSONObject.put(EventParams.KEY_CACHE_EXT, d());
            jSONObject.put("cache_time", gi());
            jSONObject.put(ReportItem.RequestKeyRequestId, wq());
            jSONObject.put("is_cache", pb());
            jSONObject.put("log_ext", xg());
            jSONObject.put("material_key", m());
            jSONObject.put("need_get_materials", jp());
            jSONObject.put("s_send_ts", bc());
            jSONObject.put("parse_material_ts", h());
            jw jwVar = this.u;
            if (jwVar != null) {
                jSONObject.put("wc_miniapp_info", jwVar.a());
            }
            t tVarTn = tn();
            if (tVarTn != null) {
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("click_trigger_type", tVarTn.u());
                jSONObject14.put("shake_start_time", tVarTn.nr());
                jSONObject14.put("shake_end_time", tVarTn.fx());
                jSONObject.put("click_trigger_config", jSONObject14);
            }
            jSONObject.put("web_monitor_rate", pn());
        } catch (Exception unused) {
        }
        if (vb() != null) {
            vb().u(jSONObject);
        }
        try {
            jSONObject.put("live_room_id", uu());
            jSONObject.put(EventParams.KEY_PARAM_ADTYPE, ud());
            jSONObject.put("live_interaction_type", gq());
            jSONObject.put("ec_schema", eh());
        } catch (JSONException unused2) {
        }
        try {
            jSONObject.put("ecom_live_params", ri());
        } catch (JSONException unused3) {
        }
        bf bfVarMw = mw();
        if (bfVarMw != null) {
            bfVarMw.u(jSONObject);
        }
        c cVarYk = yk();
        if (cVarYk != null) {
            cVarYk.u(jSONObject);
        }
        xg xgVarMd = md();
        if (xgVarMd != null) {
            try {
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("reward_live_deep_link_user_id", xgVarMd.u());
                jSONObject15.put("reward_live_deep_link_request_id", xgVarMd.iz());
                jSONObject15.put("reward_live_deep_link_room_id", xgVarMd.nr());
                jSONObject15.put("reward_live_last_time", xgVarMd.pn());
                jSONObject15.put("reawrd_live_short_touch_params", xgVarMd.fx());
                jSONObject15.put("reawrd_live_extra_pangle_scheme_params", xgVarMd.b());
                jSONObject.put("reward_live_deep_link_params", jSONObject15);
            } catch (Exception unused4) {
            }
        }
        s sVarVm = vm();
        if (sVarVm != null) {
            try {
                JSONObject jSONObject16 = new JSONObject();
                jSONObject16.put("style_type", sVarVm.u());
                jSONObject16.put(WfConstant.EXTRA_KEY_IMAGE_URL, sVarVm.nr());
                jSONObject16.put(EventParams.KEY_CT_SDK_POSITION, sVarVm.fx());
                jSONObject16.put(WfConstant.EXTRA_KEY_IMAGE_HEIGHT, sVarVm.b());
                jSONObject16.put("image_scale_rate", sVarVm.iz());
                jSONObject16.put("image_gif_url", sVarVm.pn());
                jSONObject16.put("image_gif_aspect_ratio", sVarVm.x());
                jSONObject.put("dynamic_join_coupon_style", jSONObject16);
            } catch (Exception unused5) {
            }
        }
        mv mvVarBb = bb();
        if (mvVarBb != null) {
            try {
                jSONObject.put("coupon", mvVarBb.u());
            } catch (JSONException unused6) {
            }
        }
        jp jpVarVg = vg();
        if (jpVarVg != null) {
            try {
                jSONObject.put("live_info", jpVarVg.u());
            } catch (JSONException unused7) {
            }
        }
        v vVarEj = ej();
        if (vVarEj != null) {
            try {
                jSONObject.put("saas_info", vVarEj.u());
            } catch (JSONException unused8) {
            }
        }
        Object objEc = ec();
        if (objEc != null) {
            try {
                jSONObject.put(com.umeng.analytics.pro.f.K, objEc);
            } catch (Exception unused9) {
            }
        }
        f fVarOx = ox();
        if (fVarOx != null) {
            try {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("video_adapter_type", fVarOx.u());
                jSONObject17.put("video_mute_type", fVarOx.nr());
                jSONObject.put("video_config", jSONObject17);
            } catch (Exception unused10) {
            }
        }
        try {
            jSONObject.put("not_valid_download_url", ar());
        } catch (JSONException unused11) {
        }
        try {
            jSONObject.put("dynamic_configs", qp());
            String strVu = vu();
            if (!TextUtils.isEmpty(strVu)) {
                jSONObject.put("gnd_prefetch_cache_key", strVu);
                jSONObject.put("gnd_prefetch_timing", bt());
            }
        } catch (JSONException unused12) {
        }
        try {
            jSONObject.put("twist_config", xs());
            jSONObject.put("shake_interact_conf", or());
            jSONObject.put("twist_interact_conf", bi());
        } catch (JSONException unused13) {
        }
        try {
            gi giVar = this.yf;
            if (giVar != null) {
                giVar.nr(jSONObject);
            }
        } catch (Throwable unused14) {
        }
        try {
            ja jaVar = this.sv;
            if (jaVar != null) {
                jaVar.nr(jSONObject);
            }
        } catch (Throwable unused15) {
        }
        o oVarSx = sx();
        if (oVarSx != null) {
            try {
                JSONObject jSONObject18 = new JSONObject();
                jSONObject18.put("lottie_tmp_url", oVarSx.fx());
                JSONArray jSONArray4 = new JSONArray();
                List<rh> listU = oVarSx.u();
                if (listU != null) {
                    for (rh rhVar2 : listU) {
                        if (rhVar2 != null) {
                            JSONObject jSONObject19 = new JSONObject();
                            jSONObject19.put("width", rhVar2.nr());
                            jSONObject19.put("height", rhVar2.fx());
                            jSONObject19.put("url", rhVar2.u());
                            jSONArray4.put(jSONObject19);
                        }
                    }
                }
                JSONArray jSONArray5 = new JSONArray();
                List<com.bykv.vk.openvk.component.video.api.fx.b> listNr = oVarSx.nr();
                if (listNr != null) {
                    for (com.bykv.vk.openvk.component.video.api.fx.b bVar : listNr) {
                        if (bVar != null) {
                            JSONObject jSONObject20 = new JSONObject();
                            jSONObject20.put("file_hash", bVar.k());
                            jSONObject20.put("resolution", bVar.a());
                            jSONObject20.put(WfConstant.EXTRA_KEY_VIDEO_DURATION, bVar.iz());
                            jSONObject20.put(WfConstant.EXTRA_KEY_VIDEO_URL, bVar.l());
                            jSONArray5.put(jSONObject20);
                        }
                    }
                }
                JSONObject jSONObject21 = new JSONObject();
                jSONObject21.put("bg_anim_img_android", jSONArray4);
                jSONObject21.put("bg_videos", jSONArray5);
                JSONObject jSONObject22 = new JSONObject();
                jSONObject22.put("sdk_template_info", jSONObject18);
                jSONObject22.put("aigc", jSONObject21);
                jSONObject.put("sdk_derive_info", jSONObject22);
            } catch (JSONException unused16) {
            }
        }
        try {
            jSONObject.put("disable_video_join", a());
            jSONObject.put("disable_top_bar", mv());
            jSONObject.put("disable_rtn_button", k());
            jSONObject.put("disable_safe_area", x());
            jSONObject.put("disable_slide_return", t());
        } catch (Throwable unused17) {
        }
        try {
            jSONObject.put("_ad_index", bv());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String ex() {
        mk mkVar = this.sf;
        return mkVar == null ? "点击查看" : mkVar.t();
    }

    public int f() {
        return this.kw;
    }

    public qq fa() {
        return this.ll;
    }

    public long fi() {
        return this.rh;
    }

    public int fn() {
        kw kwVar = this.cb;
        if (kwVar == null) {
            return 30;
        }
        return kwVar.fx();
    }

    public boolean fq() {
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this)) {
            return true;
        }
        if (this.t.isEmpty()) {
            return false;
        }
        if (this.qq == 4 && this.t.size() < 3) {
            return false;
        }
        Iterator<rh> it = this.t.iterator();
        while (it.hasNext()) {
            if (!it.next().pn()) {
                return false;
            }
        }
        return true;
    }

    public boolean fx() {
        return this.ss == 3;
    }

    public int fz() {
        return this.je;
    }

    public dw g() {
        return this.c;
    }

    public wi ga() {
        return this.v;
    }

    public int gb() {
        kw kwVar = this.cb;
        if (kwVar == null) {
            return 2;
        }
        return kwVar.u();
    }

    public nb gc() {
        return this.ts;
    }

    public int ge() {
        return this.p;
    }

    public long gi() {
        return this.dj;
    }

    public int gl() {
        kw kwVar = this.cb;
        if (kwVar == null) {
            return 16;
        }
        return kwVar.nr();
    }

    public int gq() {
        return this.ad;
    }

    public int gs() {
        return bg.n(this);
    }

    public int gz() {
        return this.ky;
    }

    public long h() {
        return this.pu;
    }

    public int hashCode() {
        return (this.bg.hashCode() * 31) + this.z.hashCode();
    }

    public boolean hc() {
        return hj() == 1;
    }

    public int hj() {
        return this.uq;
    }

    public boolean hl() {
        return ll() == 1;
    }

    public iz hm() {
        return this.tq;
    }

    public mk.nr hs() {
        mk mkVar = this.sf;
        if (mkVar != null) {
            return mkVar.l();
        }
        return null;
    }

    public int i() {
        mk mkVar = this.sf;
        if (mkVar == null) {
            return 82;
        }
        return mkVar.iz();
    }

    public int ic() {
        gc gcVar = this.bl;
        if (gcVar == null) {
            return 90;
        }
        return gcVar.nr();
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public z m49if() {
        return this.gz;
    }

    public int im() {
        return this.ec;
    }

    public int iq() {
        gc gcVar = this.bl;
        if (gcVar == null) {
            return 90;
        }
        return gcVar.fx();
    }

    public String ir() {
        return this.fn;
    }

    public JSONObject is() {
        return this.ju;
    }

    public String it() {
        return this.nr;
    }

    public int iz() {
        return this.md;
    }

    public String j() {
        return this.kj;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.x.u ja() {
        return this.et;
    }

    public boolean jc() {
        return this.su;
    }

    public int je() {
        gc gcVar = this.bl;
        if (gcVar == null) {
            return 0;
        }
        return gcVar.u();
    }

    public String jf() {
        return this.iz;
    }

    public boolean jk() {
        return a() == 1;
    }

    public int jn() {
        int i = this.xw;
        if (i != -1) {
            return i;
        }
        if (com.bytedance.sdk.openadsdk.core.y.jp.jk(this) == 7) {
            return 0;
        }
        return (com.bytedance.sdk.openadsdk.core.y.jp.jk(this) == 8 && ba() == 100.0f) ? 0 : 1;
    }

    public boolean jp() {
        return this.gb;
    }

    public boolean jq() {
        return fz() != 1;
    }

    public int ju() {
        return this.ob;
    }

    public int jw() {
        return this.i;
    }

    public int k() {
        return this.na;
    }

    public String kd() {
        return this.f;
    }

    public jw kg() {
        return this.u;
    }

    public int ki() {
        return this.jf;
    }

    public boolean kj() {
        return this.yy;
    }

    public kw kp() {
        return this.cb;
    }

    public my kv() {
        return this.q;
    }

    public int kw() {
        return this.tm;
    }

    public int ky() {
        return this.oa;
    }

    public boolean l() {
        return this.uc == 1;
    }

    public boolean la() {
        return (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.y.jp.l(this)) || TextUtils.isEmpty(this.wi) || com.bytedance.sdk.openadsdk.core.y.jp.l(this).contains(this.wi)) ? false : true;
    }

    public kj lc() {
        return this.hl;
    }

    public int lf() {
        return this.bj;
    }

    public String lg() {
        return this.f5299cn;
    }

    public String lk() {
        return this.bg;
    }

    public int ll() {
        return this.jw;
    }

    public long ln() {
        return this.w;
    }

    public String ls() {
        return this.wi;
    }

    public String m() {
        return this.ti;
    }

    public xg md() {
        return this.r;
    }

    public int mf() {
        return this.pq;
    }

    public int mh() {
        return this.za;
    }

    public int mk() {
        return this.rv;
    }

    public JSONObject ms() {
        return this.hc;
    }

    public int mv() {
        return this.f5301im;
    }

    public bf mw() {
        return this.xx;
    }

    public List<String> mx() {
        return this.s;
    }

    public boolean my() {
        return k() == 1;
    }

    public int na() {
        return this.wu;
    }

    public bg nb() {
        return this.ap;
    }

    public float ng() {
        float f = this.qb;
        if (f < 0.07f || f > 0.175f) {
            this.qb = 0.07f;
        }
        return this.qb;
    }

    public boolean nr() {
        return this.fa;
    }

    public String nu() {
        return this.cj;
    }

    public boolean nz() {
        return this.qe;
    }

    public String o() {
        return this.bv;
    }

    public int oa() {
        return this.jn;
    }

    public int ob() {
        return this.lf;
    }

    public boolean of() {
        return this.ln;
    }

    public int oi() {
        return this.hm;
    }

    public int ol() {
        return this.qq;
    }

    public JSONObject or() {
        return this.jq;
    }

    public f ox() {
        return this.lk;
    }

    public int p() {
        return this.la;
    }

    public boolean pb() {
        return this.df;
    }

    public String pg() {
        return hashCode() + xx() + h();
    }

    public xw pm() {
        if (this.ba == null) {
            this.ba = new xw(this);
        }
        return this.ba;
    }

    public int pn() {
        return this.f5303ms;
    }

    public mk pq() {
        return this.sf;
    }

    public long ps() {
        return this.y;
    }

    public pn pu() {
        return this.dw;
    }

    public String q() {
        return this.jc;
    }

    public int qb() {
        return this.x;
    }

    public int qe() {
        mk mkVar = this.sf;
        if (mkVar == null) {
            return 56;
        }
        return mkVar.x();
    }

    public int qf() {
        return this.b;
    }

    public su qj() {
        return this.zn;
    }

    public long qn() {
        return this.h;
    }

    public String qp() {
        return this.db;
    }

    public String qq() {
        return this.sj;
    }

    public int qv() {
        return this.j;
    }

    public zx r() {
        return this.wq;
    }

    public int re() {
        return this.e;
    }

    public String rg() {
        mk mkVar = this.sf;
        return mkVar == null ? "" : mkVar.nr();
    }

    public int rh() {
        if (bg.b(this)) {
            return 0;
        }
        return this.kg;
    }

    public String ri() {
        return this.wf;
    }

    public int rv() {
        return this.mk;
    }

    public boolean s() {
        return mv() == 1;
    }

    public int sf() {
        mk mkVar = this.sf;
        if (mkVar == null) {
            return 236;
        }
        return mkVar.pn();
    }

    public long si() {
        return this.up;
    }

    public Map<String, Object> sj() {
        return this.yd;
    }

    public int ss() {
        JSONObject jSONObject = this.f5298a;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    public ja su() {
        return this.sv;
    }

    public int sv() {
        if (this.ic != 2) {
            this.ic = 1;
        }
        return this.ic;
    }

    public o sx() {
        return this.qv;
    }

    public int t() {
        return this.uc;
    }

    public mk.nr te() {
        mk mkVar = this.sf;
        if (mkVar != null) {
            return mkVar.mv();
        }
        return null;
    }

    public mk.u ti() {
        mk mkVar = this.sf;
        if (mkVar != null) {
            return mkVar.s();
        }
        return null;
    }

    public int tk() {
        return this.rg;
    }

    public com.bytedance.sdk.openadsdk.my.fx.fx.nr tm() {
        return this.gc;
    }

    public t tn() {
        return this.ah;
    }

    public JSONObject tq() {
        if (this.gi == null) {
            try {
                if (!TextUtils.isEmpty(this.z)) {
                    this.gi = new JSONObject(this.z);
                }
            } catch (JSONException unused) {
            }
        }
        return this.gi;
    }

    public String tr() {
        mk mkVar = this.sf;
        return mkVar == null ? "#008DEA" : mkVar.jk();
    }

    public int ts() {
        return this.dc;
    }

    public gi tw() {
        return this.yf;
    }

    public void u(h hVar) {
        if (hVar == null) {
            return;
        }
        if (this.lc == null) {
            this.lc = new ArrayList();
        }
        this.lc.add(hVar);
    }

    public int ua() {
        mk mkVar = this.sf;
        if (mkVar == null) {
            return 50;
        }
        return mkVar.b();
    }

    public String uc() {
        if (!TextUtils.isEmpty(this.wj)) {
            this.wj = this.wj.trim();
        }
        return this.wj;
    }

    public int ud() {
        return this.vp;
    }

    public int uk() {
        return this.pb;
    }

    public boolean uo() {
        if (vz() != null) {
            return vz().iz();
        }
        return false;
    }

    public int up() {
        return this.ja;
    }

    public int uq() {
        mk mkVar = this.sf;
        if (mkVar == null) {
            return 1;
        }
        return mkVar.u();
    }

    public String uu() {
        return this.zu;
    }

    public tk v() {
        return this.g;
    }

    public m vb() {
        return this.eh;
    }

    public jp vg() {
        return this.ym;
    }

    public String vk() {
        try {
            return tq().optString("convert_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s vm() {
        return this.mx;
    }

    public String vp() {
        return this.l;
    }

    public String vu() {
        return this.it;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.fx.nr vz() {
        com.bytedance.sdk.openadsdk.core.dislike.nr.u();
        return this.fx;
    }

    public int w() {
        return this.uk;
    }

    public String wf() {
        return this.k;
    }

    public yd wi() {
        return this.ay;
    }

    public bq wj() {
        return this.mh;
    }

    public String wo() {
        return this.fi;
    }

    public String wq() {
        return this.ex;
    }

    public String wu() {
        return this.vk;
    }

    public String wv() {
        return this.n;
    }

    public String xg() {
        return this.zq;
    }

    public int xh() {
        return this.ol;
    }

    public JSONObject xs() {
        return this.ir;
    }

    public int xw() {
        return this.dr;
    }

    public String xx() {
        return this.d;
    }

    public String y() {
        return this.hs;
    }

    public String yb() {
        return this.sx;
    }

    public boolean yd() {
        return this.za == 1;
    }

    public String yf() {
        return this.gl;
    }

    public c yk() {
        return this.en;
    }

    public String ym() {
        return this.o;
    }

    public JSONObject yy() {
        return this.ge;
    }

    public JSONObject z() {
        return this.is;
    }

    public int za() {
        if (ba() != 100.0f || tk.u(this) == 2) {
            return 0;
        }
        return this.nb;
    }

    public int zn() {
        return this.qn;
    }

    public int zq() {
        return this.dd;
    }

    public List<rh> zu() {
        return this.t;
    }

    public int zx() {
        return this.zx;
    }

    public void a(int i) {
        this.bo = i;
    }

    public void ay(int i) {
        if (i < 0 || i > 100) {
            return;
        }
        this.wu = i;
    }

    public void b(int i) {
        this.az = i;
    }

    public void bc(int i) {
        this.ja = i;
    }

    public void bf(int i) {
        this.xw = i;
    }

    public void bg(int i) {
        this.kw = i;
    }

    public void bq(int i) {
        this.nb = i;
    }

    public void c(int i) {
        this.p = i;
    }

    public void cj(int i) {
        this.uq = i;
    }

    public void d(int i) {
        this.jf = i;
    }

    public void dw(int i) {
        this.mk = i;
    }

    public void eh(int i) {
        int i2 = 500;
        if (i == Integer.MIN_VALUE) {
            i = com.bytedance.sdk.openadsdk.core.y.jp.jk(this) == 3 ? 500 : 1000;
        }
        if (i >= 500) {
            i2 = 3000;
            if (i <= 3000) {
                i2 = i;
            }
        }
        this.e = i2;
    }

    public void f(int i) {
        this.al = i;
    }

    public void fx(int i) {
        this.md = i;
    }

    public void gc(int i) {
        if (i <= 0 || i > 9) {
            this.pq = 3;
        } else {
            this.pq = i;
        }
    }

    public void gi(int i) {
        this.dd = i;
    }

    public void h(int i) {
        this.ol = i;
    }

    public void iz(int i) {
        this.uc = i;
    }

    public void ja(int i) {
        this.pb = i;
    }

    public void jk(int i) {
        this.kg = i;
    }

    public void jp(int i) {
        this.ua = Math.max(0, i);
    }

    public void k(int i) {
        this.bj = i;
    }

    public void kj(int i) {
        this.zx = i;
    }

    public void kw(int i) {
        this.wo = i;
    }

    public void l(String str) {
        this.ki = str;
    }

    public void lf(int i) {
        this.vp = i;
    }

    public void m(int i) {
        this.dc = i;
    }

    public void mh(int i) {
        if (i < 0 || i > 180) {
            this.j = 50;
        } else {
            this.j = i;
        }
    }

    public void mk(int i) {
        this.qf = i;
    }

    public void mv(int i) {
        this.rg = i;
    }

    public void my(int i) {
        this.rv = i;
    }

    public int n() {
        return this.ng;
    }

    public void nb(int i) {
        this.ad = i;
    }

    public void nr(int i) {
        this.f5303ms = i;
    }

    public void o(int i) {
        this.la = i;
    }

    public void oa(int i) {
        this.f5302jp = i;
    }

    public void p(int i) {
        this.hj = i;
    }

    public void pb(int i) {
        this.b = i;
    }

    public void pn(int i) {
        if (this.ng == 0) {
            this.ng = i;
        }
    }

    public void q(int i) {
        this.lf = i;
    }

    public void qq(int i) {
        this.ob = i;
    }

    public void s(int i) {
        this.za = i;
    }

    public void su(int i) {
        if (i < 12) {
            i = 12;
        }
        if (i > 20) {
            i = 20;
        }
        this.ky = i;
    }

    public void sx(int i) {
        this.tm = i;
    }

    public void t(String str) {
        this.hs = str;
    }

    public void tk(int i) {
        this.je = i;
    }

    public void v(int i) {
        this.hm = i;
    }

    public void w(int i) {
        this.jw = i;
    }

    public void wi(int i) {
        this.ic = i;
    }

    public void wq(int i) {
        this.oa = i;
    }

    public boolean x() {
        return this.qj && s();
    }

    public void xg(int i) {
        this.x = i;
    }

    public void xw(int i) {
        this.tk = i;
    }

    public void y(int i) {
        this.qq = i;
    }

    public void yd(int i) {
        this.ec = i;
    }

    public void z(int i) {
        this.i = i;
    }

    public void a(String str) {
        this.zq = str;
    }

    public void b(String str) {
        this.ps = str;
    }

    public void bf(String str) {
        this.fi = str;
    }

    public void bg(String str) {
        this.k = str;
    }

    public void bq(String str) {
        this.o = str;
    }

    public void c(String str) {
        this.bg = str;
    }

    public void d(String str) {
        this.f = str;
    }

    public void dw(String str) {
        this.sx = str;
    }

    public void fx(boolean z) {
        this.si = z;
    }

    public void gi(String str) {
        this.wi = str;
    }

    public void h(String str) {
        this.nr = str;
    }

    public void iz(String str) {
        this.sj = str;
    }

    public void ja(String str) {
        this.gl = str;
    }

    public void jk(String str) {
        this.ti = str;
    }

    public void jp(String str) {
        this.f5299cn = str;
    }

    public void k(String str) {
        this.kj = str;
    }

    public void kj(String str) {
        this.bq = str;
    }

    public void l(int i) {
        this.bf = i;
    }

    public void m(String str) {
        this.wf = str;
    }

    public void mv(String str) {
        this.vz = str;
    }

    public void my(String str) {
        this.iz = str;
    }

    public void n(int i) {
        this.na = i;
    }

    public void nr(boolean z) {
        this.qj = z;
    }

    public void o(String str) {
        this.n = str;
    }

    public void pb(String str) {
        this.db = str;
    }

    public void q(String str) {
        this.z = str;
    }

    public void qq(String str) {
        this.d = str;
    }

    public void rh(int i) {
        if (i != 1) {
            i = 0;
        }
        this.qn = i;
    }

    public void s(String str) {
        this.vk = str;
    }

    public void sx(String str) {
        this.l = str;
    }

    public void t(int i) {
        this.dr = i;
    }

    public void wq(String str) {
        this.wj = str;
    }

    public void x(int i) {
        this.f5301im = i;
    }

    public void xg(String str) {
        this.zu = str;
    }

    public void y(String str) {
        this.it = str;
    }

    public void z(String str) {
        this.cj = str;
    }

    public void a(long j) {
        this.bc = j;
    }

    public void b(boolean z) {
        this.yy = z;
    }

    public void fx(String str) {
        this.kd = str;
    }

    public void iz(boolean z) {
        this.gb = z;
    }

    public void jk(long j) {
        if (j != 0) {
            this.up = j;
        } else {
            this.up = System.currentTimeMillis() / 1000;
        }
    }

    public void l(boolean z) {
        this.ln = z;
    }

    public void n(String str) {
        this.ex = str;
    }

    public void nr(String str) {
        this.bv = str;
    }

    public void pn(String str) {
        this.jc = str;
    }

    public void rh(String str) {
        this.fn = str;
    }

    public void t(boolean z) {
        this.qe = z;
    }

    public h u(String str) {
        List<h> list = this.lc;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.lc.size(); i++) {
                h hVar = this.lc.get(i);
                if (hVar != null) {
                    String strU = hVar.u();
                    if (!TextUtils.isEmpty(strU) && strU.equals(str)) {
                        return hVar;
                    }
                }
            }
        }
        return null;
    }

    public void x(String str) {
        this.tr = str;
    }

    public static boolean fx(bc bcVar) {
        try {
            if (bcVar.yy() != null) {
                if (bcVar.yy().optInt("parent_type") == 1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void a(boolean z) {
        this.su = z;
    }

    public void b(JSONObject jSONObject) {
        this.f5298a = jSONObject;
    }

    public void iz(long j) {
        this.rh = j;
    }

    public void l(JSONObject jSONObject) {
        this.ba = new xw(this, jSONObject);
    }

    public void n(boolean z) {
        this.m = z;
    }

    public void nr(JSONObject jSONObject) {
        this.is = jSONObject;
    }

    public void pn(boolean z) {
        this.df = z;
    }

    public void t(JSONObject jSONObject) {
        this.fz = jSONObject;
    }

    public void x(boolean z) {
        this.xg = z;
    }

    public static boolean nr(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        return bcVar.ol() == 5 || bcVar.ol() == 15 || bcVar.ol() == 166;
    }

    public void a(JSONObject jSONObject) {
        this.ir = jSONObject;
    }

    public void b(long j) {
        this.my = j;
    }

    public void fx(long j) {
        this.te = j;
    }

    public void iz(JSONObject jSONObject) {
        this.ge = jSONObject;
    }

    public void jk(boolean z) {
        this.ls = z;
    }

    public void n(long j) {
        this.y = j;
    }

    public void pn(JSONObject jSONObject) {
        this.jk = jSONObject;
    }

    public void x(long j) {
        this.w = j;
    }

    public static boolean b(bc bcVar) {
        return bcVar != null && bcVar.al == 1;
    }

    public static void iz(bc bcVar) {
        if (bcVar == null) {
            return;
        }
        bcVar.fq = System.currentTimeMillis();
    }

    public void fx(JSONObject jSONObject) {
        this.nu = jSONObject;
    }

    public void jk(JSONObject jSONObject) {
        this.jq = jSONObject;
    }

    public void n(JSONObject jSONObject) {
        this.hc = jSONObject;
    }

    public void pn(long j) {
        this.h = j;
    }

    public void x(JSONObject jSONObject) {
        this.ju = jSONObject;
    }

    public static boolean pn(bc bcVar) {
        if (bcVar == null || bcVar.fq <= 0 || bcVar.wo <= 0) {
            return false;
        }
        boolean z = System.currentTimeMillis() - bcVar.fq < ((long) bcVar.wo);
        if (z) {
            bcVar.uo++;
            com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.bc.1
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("count", bc.this.uo);
                    jSONObject.put("click_freq", bc.this.wo);
                    return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("click_intercept").n(bc.this.ap()).nr(jSONObject.toString());
                }
            }, "click_intercept");
        }
        return z;
    }

    public void fx(float f) {
        this.wv = f;
    }

    public void nr(long j) {
        this.pu = j;
    }

    public synchronized String u() {
        if (TextUtils.isEmpty(this.gs)) {
            String strL = com.bytedance.sdk.openadsdk.core.y.jp.l(this);
            String strEn = en();
            String strLk = lk();
            if (TextUtils.isEmpty(strL)) {
                strL = "0";
            }
            if (TextUtils.isEmpty(strLk)) {
                strLk = "0";
            }
            if (TextUtils.isEmpty(strEn)) {
                strEn = "0";
            }
            this.gs = strL + "_" + strEn + "_" + strLk;
        }
        return this.gs;
    }

    public void nr(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.uk = 2;
        } else {
            this.uk = (int) d;
        }
    }

    public void nr(rh rhVar) {
        this.t.add(rhVar);
    }

    public void nr(float f) {
        this.qb = f;
    }

    public void u(boolean z) {
        this.fa = z;
    }

    public void u(int i) {
        this.ss = i;
    }

    public void u(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.qv = new o();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sdk_template_info");
            if (jSONObjectOptJSONObject != null) {
                this.qv.u(jSONObjectOptJSONObject.optString("lottie_tmp_url"));
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("aigc");
            if (jSONObjectOptJSONObject2 != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("bg_anim_img_android");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    this.qv.u(arrayList);
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject3 != null) {
                            rh rhVar = new rh();
                            rhVar.u(jSONObjectOptJSONObject3.optInt("width"));
                            rhVar.nr(jSONObjectOptJSONObject3.optInt("height"));
                            rhVar.u(jSONObjectOptJSONObject3.optString("url"));
                            arrayList.add(rhVar);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("bg_videos");
                if (jSONArrayOptJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    this.qv.nr(arrayList2);
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i2);
                        if (jSONObjectOptJSONObject4 != null) {
                            com.bykv.vk.openvk.component.video.api.fx.b bVar = new com.bykv.vk.openvk.component.video.api.fx.b();
                            bVar.pn(jSONObjectOptJSONObject4.optString("file_hash"));
                            bVar.u(jSONObjectOptJSONObject4.optString("resolution"));
                            bVar.u(jSONObjectOptJSONObject4.optDouble(WfConstant.EXTRA_KEY_VIDEO_DURATION));
                            bVar.fx(jSONObjectOptJSONObject4.optString(WfConstant.EXTRA_KEY_VIDEO_URL));
                            arrayList2.add(bVar);
                        }
                    }
                }
            }
        }
    }

    public static boolean u(bc bcVar) {
        return bcVar != null && bcVar.tk() == 1;
    }

    public void u(long j) {
        this.dj = j;
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar) {
        this.et = uVar;
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.jk.u uVar) {
        this.qp = uVar;
    }

    public void u(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.jn = 2;
        } else {
            this.jn = (int) d;
        }
    }

    public void u(yd ydVar) {
        this.ay = ydVar;
    }

    public void u(ja jaVar) {
        this.sv = jaVar;
    }

    public void u(cj cjVar) {
        this.kv = cjVar;
    }

    public void u(tk tkVar) {
        this.g = tkVar;
    }

    public void u(bg bgVar) {
        this.ap = bgVar;
    }

    public void u(nb nbVar) {
        this.ts = nbVar;
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (nrVar == null) {
            com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar2 = this.gc;
            if (nrVar2 != null) {
                this.gc = new fx(nrVar2);
                return;
            }
            return;
        }
        this.gc = nrVar;
    }

    public void u(bq bqVar) {
        this.mh = bqVar;
    }

    public void u(mk mkVar) {
        this.sf = mkVar;
    }

    public void u(iz izVar) {
        this.tq = izVar;
    }

    public void u(zx zxVar) {
        this.wq = zxVar;
    }

    public void u(rh rhVar) {
        this.pn = rhVar;
    }

    public void u(pn pnVar) {
        this.dw = pnVar;
    }

    public void u(dw dwVar) {
        this.c = dwVar;
    }

    public void u(my myVar) {
        this.q = myVar;
    }

    public void u(Map<String, Object> map) {
        this.yd = map;
    }

    public void u(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar) {
        this.fx = nrVar;
    }

    public void u(w wVar) {
        this.xh = wVar;
    }

    public void u(wq wqVar) {
        this.f5300de = wqVar;
    }

    public void u(float f) {
        this.iq = f;
    }

    public void u(qq qqVar) {
        this.ll = qqVar;
        if (qqVar != null) {
            String strNr = qqVar.nr();
            String strFx = this.ll.fx();
            if (TextUtils.isEmpty(strNr)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ugeno.jk.u(strNr, strFx, (com.bytedance.sdk.openadsdk.core.ugeno.fx) null);
        }
    }

    public void u(kj kjVar) {
        this.hl = kjVar;
    }

    public void u(su suVar) {
        this.zn = suVar;
    }

    public void u(xg xgVar) {
        this.r = xgVar;
    }

    public void u(jw jwVar) {
        this.u = jwVar;
    }

    public void u(kw kwVar) {
        this.cb = kwVar;
    }

    public void u(gc gcVar) {
        this.bl = gcVar;
    }

    public void u(wi wiVar) {
        this.v = wiVar;
    }

    public void u(mv mvVar) {
        this.bp = mvVar;
    }

    public void u(jp jpVar) {
        this.ym = jpVar;
    }

    public void u(v vVar) {
        this.yb = vVar;
    }

    public void u(s sVar) {
        this.mx = sVar;
    }

    public void u(f fVar) {
        this.lk = fVar;
    }

    public void u(t tVar) {
        this.ah = tVar;
    }

    public void u(m mVar) {
        this.eh = mVar;
    }

    public void u(com.bykv.vk.openvk.component.video.api.fx.b bVar) {
        if (this.wq == null) {
            this.wq = new zx();
        }
        this.wq.u(bVar);
    }

    public void u(bf bfVar) {
        this.xx = bfVar;
    }

    public void u(c cVar) {
        this.en = cVar;
    }

    public void u(gi giVar) {
        this.yf = giVar;
    }

    public void u(z zVar) {
        this.gz = zVar;
    }
}
