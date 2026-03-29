package com.bytedance.sdk.openadsdk.core.pb;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.widget.web.MultiWebview;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.fx.pn;
import com.bytedance.sdk.openadsdk.core.kj.bf;
import com.bytedance.sdk.openadsdk.core.kj.d;
import com.bytedance.sdk.openadsdk.core.kj.ge;
import com.bytedance.sdk.openadsdk.core.kj.ja;
import com.bytedance.sdk.openadsdk.core.kj.pb;
import com.bytedance.sdk.openadsdk.core.kj.sx;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.y;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.nativeexpress.bq;
import com.bytedance.sdk.openadsdk.core.y.gi;
import com.bytedance.sdk.openadsdk.core.y.h;
import com.bytedance.sdk.openadsdk.core.y.kj;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t implements pn {
    private static final String mx = null;
    private String ad;
    private int ah;
    private JSONObject al;
    private int an;
    private JSONObject ap;
    private boolean ar;
    private boolean az;
    public volatile com.bytedance.sdk.component.b.nr.fx b;
    private boolean ba;
    private int bb;
    private volatile SharedPreferences bj;
    private JSONObject bl;
    private String bo;
    private int bp;
    private iz bv;
    private volatile boolean cb;
    private String cj;

    /* JADX INFO: renamed from: cn, reason: collision with root package name */
    private String f5350cn;
    private String db;
    private float dd;

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    private int f5351de;
    private String df;
    private y dj;
    private JSONObject dr;
    private boolean dx;
    private JSONObject e;
    private String ec;
    private int ej;
    private int en;
    private Boolean et;
    private int ex;
    private bq fa;
    private boolean fi;
    private boolean fn;
    private boolean fq;
    public volatile com.bytedance.sdk.component.b.nr.fx fx;
    private Object fz;
    private JSONObject g;
    private int ga;
    private float gb;
    private float gl;
    private volatile int gq;
    private boolean gs;
    private boolean gz;
    private int hc;
    private int hj;
    private int hl;
    private String hm;
    private int hs;
    private int i;
    private float ic;

    /* JADX INFO: renamed from: im, reason: collision with root package name */
    private int f5352im;
    private boolean iq;
    private JSONObject ir;
    private long is;
    private int it;
    private volatile com.bytedance.sdk.component.b.nr.fx j;
    private int jc;
    private float je;
    private JSONObject jf;
    private int jn;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private String f5353jp;
    private volatile SharedPreferences jq;
    private int kd;
    private Boolean kg;
    private int ki;
    private boolean kp;
    private JSONObject kv;
    private float ky;
    private int la;
    private boolean lc;
    private int lg;
    private JSONObject lk;
    private int ll;
    private String ln;
    private int ls;
    private int md;
    private JSONObject mf;
    private pb mh;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f5354ms;
    private String na;
    private Map<String, Object> ng;
    private int nu;
    private int nz;
    private JSONObject oa;
    private int of;
    private boolean oi;
    private int ol;
    private boolean ox;
    public int pn;
    private boolean pq;
    private String ps;
    private JSONObject pu;
    private int qb;
    private final String qe;
    private SharedPreferences qf;
    private int qj;
    private boolean qn;
    private boolean qp;
    private x qv;
    private int r;
    private int re;
    private boolean ri;
    private final int sf;
    private long sj;
    private boolean ss;
    private String su;
    private boolean sv;
    private int te;
    private int ti;
    private int tn;
    private int tq;
    private int tr;
    private JSONObject ts;
    private boolean uc;
    private volatile int ud;
    private int uk;
    private List<Integer> uo;
    private nr up;
    private volatile boolean uu;
    private final AtomicInteger vb;
    private int vg;
    private String vk;
    private boolean vm;
    private int vp;
    private volatile int vz;
    private long w;
    private int wf;
    private String wj;
    private boolean wo;
    private String wu;
    private int wv;
    private String xh;
    private String xx;
    private String y;
    private JSONObject yb;
    private com.bytedance.sdk.openadsdk.core.sx.u.u yd;
    private JSONObject yf;
    private int ym;
    private int yy;
    private int zn;
    private String zq;
    private boolean zu;
    private static final int[] si = {1, 3, 5};
    private static volatile boolean mw = false;
    private static volatile boolean yk = true;
    private int iz = Integer.MAX_VALUE;
    private Set<String> x = Collections.synchronizedSet(new HashSet());
    private int n = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5349a = Integer.MAX_VALUE;
    private int jk = Integer.MAX_VALUE;
    private int t = Integer.MAX_VALUE;
    private String l = null;
    private int mv = Integer.MAX_VALUE;
    private int s = Integer.MAX_VALUE;
    private int k = Integer.MAX_VALUE;
    private int my = Integer.MIN_VALUE;
    private int o = Integer.MIN_VALUE;
    private int sx = Integer.MIN_VALUE;
    private int bg = Integer.MIN_VALUE;
    private int bq = Integer.MAX_VALUE;
    private int dw = Integer.MAX_VALUE;
    private int c = Integer.MAX_VALUE;
    private int q = -1;
    private int qq = Integer.MIN_VALUE;
    private int kj = Integer.MIN_VALUE;
    private String z = null;
    public int u = 0;
    private int gi = Integer.MIN_VALUE;
    private int d = Integer.MAX_VALUE;
    public int nr = 10;
    private int h = Integer.MAX_VALUE;
    private com.bytedance.sdk.openadsdk.core.x.nr rh = null;
    private int ja = 1;
    private com.bytedance.sdk.openadsdk.core.dislike.b bf = null;
    private boolean wq = false;
    private int pb = Integer.MAX_VALUE;
    private final Map<String, u> xg = new ConcurrentHashMap();
    private Map<String, com.bytedance.sdk.component.adexpress.u.fx.b> m = new HashMap();
    private Set<String> bc = Collections.synchronizedSet(new HashSet());
    private final List<Object> xw = new CopyOnWriteArrayList();
    private JSONObject tk = null;
    private String wi = "";
    private int ay = Integer.MAX_VALUE;
    private int v = Integer.MAX_VALUE;
    private long eh = 0;
    private Set<String> lf = new ConcurrentSkipListSet();
    private Set<String> nb = new ConcurrentSkipListSet();
    private Set<String> gc = new ConcurrentSkipListSet();
    private int mk = Integer.MAX_VALUE;
    private int p = Integer.MAX_VALUE;
    private long kw = 2147483647L;
    private int f = Integer.MAX_VALUE;
    private int za = Integer.MAX_VALUE;
    private int tm = Integer.MAX_VALUE;
    private int rv = Integer.MAX_VALUE;
    private int ge = Integer.MAX_VALUE;
    private int ob = 0;
    private long ju = 0;
    private int zx = 0;
    private long jw = 0;
    private int uq = Integer.MAX_VALUE;
    private JSONObject rg = null;
    private JSONObject dc = null;
    private int ua = 3;

    public t() {
        int iFx = com.bytedance.sdk.openadsdk.u.nr.nr.fx();
        this.sf = iFx;
        this.i = iFx;
        this.qe = "live_sdk_conf";
        this.tr = Integer.MAX_VALUE;
        this.ex = Integer.MAX_VALUE;
        this.df = null;
        this.zq = null;
        this.ki = Integer.MAX_VALUE;
        this.hs = Integer.MAX_VALUE;
        this.te = Integer.MAX_VALUE;
        this.ti = 0;
        this.gb = 0.0f;
        this.gl = 0.0f;
        this.fn = false;
        this.je = 8.5f;
        this.ic = 7.3f;
        this.hm = null;
        this.wu = null;
        this.xh = "apps.bytesfield.com";
        this.zn = Integer.MAX_VALUE;
        this.r = Integer.MAX_VALUE;
        this.uk = 0;
        this.jn = 2;
        this.cb = false;
        this.ky = -1.0f;
        this.dd = 2.1474836E9f;
        this.jf = null;
        this.qb = Integer.MAX_VALUE;
        this.wv = 2;
        this.bl = null;
        this.e = null;
        this.zu = false;
        this.vp = 3;
        this.wf = 0;
        this.bp = 1;
        this.ym = Integer.MAX_VALUE;
        this.ts = null;
        this.f5351de = 0;
        this.xx = null;
        this.en = 0;
        this.tq = 0;
        this.vk = null;
        this.ol = 1;
        this.qn = true;
        this.fi = false;
        this.dr = null;
        this.ah = 1;
        this.ln = "跳过";
        this.nu = 0;
        this.bv = new iz();
        this.ls = 0;
        this.la = 0;
        this.db = "";
        this.ps = "21ea2d6d4f321553dd684e6b864bf0b7";
        this.bo = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20103/uchain_dsl.bin";
        this.jc = -1;
        this.sj = -1L;
        this.yy = 0;
        this.is = 2147483647L;
        this.kd = Integer.MAX_VALUE;
        this.ll = Integer.MAX_VALUE;
        this.hl = Integer.MAX_VALUE;
        this.hc = Integer.MAX_VALUE;
        this.hj = Integer.MAX_VALUE;
        this.vz = Integer.MAX_VALUE;
        this.bj = null;
        this.al = null;
        this.ir = null;
        this.jq = null;
        this.fz = new Object();
        this.fx = null;
        this.yf = null;
        this.sv = false;
        this.ba = false;
        this.wo = false;
        this.fq = false;
        this.uo = new ArrayList();
        this.gz = false;
        this.pn = 0;
        this.qv = new x();
        this.az = true;
        this.uc = false;
        this.f5352im = 0;
        this.f5354ms = Integer.MAX_VALUE;
        this.lc = false;
        this.gs = false;
        this.ss = false;
        this.qj = 0;
        this.md = 1;
        this.ng = new HashMap();
        this.f5350cn = "";
        this.kg = null;
        this.et = null;
        this.ar = true;
        this.oi = false;
        this.kp = false;
        this.dx = false;
        this.re = Integer.MAX_VALUE;
        this.uu = true;
        this.ud = Integer.MAX_VALUE;
        this.gq = Integer.MAX_VALUE;
        this.ri = true;
        this.bb = 0;
        this.nz = -1;
        this.vm = false;
        this.ox = false;
        this.an = 1000;
        this.lg = 1;
        this.ga = 0;
        this.tn = 0;
        this.vb = new AtomicInteger(-1);
        this.of = -1;
    }

    public static String b() {
        return "tt_sdk_settings_other_bst";
    }

    private String bg(String str) {
        return "ad_slot_conf_".concat(String.valueOf(str));
    }

    private SharedPreferences cn() {
        if (this.qf == null) {
            this.qf = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), b(), 0);
        }
        return this.qf;
    }

    public static String iz() {
        return com.bytedance.sdk.openadsdk.core.b.u.x() ? "tt_sdk_settings_slot_bst" : "tt_sdk_settings_slot";
    }

    private void md() {
        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("") { // from class: com.bytedance.sdk.openadsdk.core.pb.t.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.rh.nr.u.u();
            }
        });
    }

    private void ng() {
        nr();
        this.fx.put("url_stats", this.wj);
        this.fx.put("open_mini_game", this.md);
        if (!"https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".equals(this.ec) && !TextUtils.isEmpty(this.ec)) {
            this.fx.put("img_bucket", this.ec);
        }
        SharedPreferences.Editor editorEdit = cn().edit();
        editorEdit.putString("url_stats", this.wj);
        this.fx.put("url_alog", this.zq);
        editorEdit.putString("url_alog", this.zq);
        this.fx.put("xpath", this.cj);
        if (this.oa != null) {
            this.fx.put("digest", this.oa.toString());
        }
        this.fx.put("data_time", this.w);
        this.fx.put("fetch_template", this.ex);
        this.fx.put("pyload_h5", this.su);
        com.bytedance.sdk.component.b.nr.fx fxVar = this.fx;
        pb pbVar = this.mh;
        fxVar.put("insert_js_config", pbVar != null ? pbVar.toString() : "");
        com.bytedance.sdk.component.b.nr.fx fxVar2 = this.fx;
        com.bytedance.sdk.openadsdk.core.sx.u.u uVar = this.yd;
        fxVar2.put("white_check_config", uVar != null ? uVar.toString() : "");
        this.fx.put("splash_check_type", this.ay);
        this.fx.put("if_both_open", this.mk);
        this.fx.put("adlog_exception_batch", this.za);
        this.fx.put("adlog_interval", this.kw);
        this.fx.put("enable_kite", this.k);
        this.fx.put("adlog_batch", this.f);
        this.fx.put("adlog_debug", this.tm);
        this.fx.put("adlog_monitor", this.rv);
        this.fx.put("enable_ttvideo", this.q);
        this.fx.put("enable_zaid", this.qq);
        this.fx.put("player_stats_check_switch", this.kj);
        this.fx.put("enable_cdn_opt", this.bq);
        this.fx.put("download_button_effect", this.c);
        this.fx.put("ext_use_type", this.jw);
        this.fx.put("enable_glgpu", 0);
        this.fx.put("enable_dl_ext", this.zx);
        this.fx.put("download_receiver_enable", this.h);
        this.fx.put("launch_strategy", this.u);
        this.fx.put("dl_popup_duration", this.gi);
        this.fx.put("switch_audio_focus", this.uq);
        this.fx.put("opt_show_check", this.d);
        if (this.rg != null) {
            this.fx.put("pitaya_general_settings", this.rg.toString());
        }
        if (this.yb != null) {
            this.fx.put("live_stream_cof", this.yb.toString());
        }
        if (this.kv != null) {
            this.fx.put("video_start", this.kv.toString());
        }
        if (this.g != null) {
            this.fx.put("volume", this.g.toString());
        }
        if (this.ap != null) {
            this.fx.put("brightness", this.ap.toString());
        }
        if (this.lk != null) {
            this.fx.put("dl_notification", this.lk.toString());
        }
        this.fx.put("disable_show_url", this.ym);
        if (this.ts != null) {
            this.fx.put("sensor_direction", this.ts.toString());
        }
        if (this.pu != null) {
            this.fx.put("pitaya_business_conf", this.pu.toString());
        }
        com.bytedance.sdk.component.b.nr.fx fxVar3 = this.fx;
        JSONObject jSONObject = this.dc;
        fxVar3.put("http_drop", jSONObject == null ? "" : jSONObject.toString());
        this.fx.put("stats_batch", this.ua);
        this.fx.put("event_switch", this.i);
        this.fx.put("pre_fetch_cnt", this.nr);
        this.fx.put("web_upload_enable", this.iz);
        this.fx.put("web_upload_content_type", this.x);
        this.fx.put("web_upload_send_restowv", this.n);
        this.fx.put("web_upload_max_retry", this.s);
        this.fx.put("web_upload_max_single_file", this.f5349a);
        this.fx.put("web_upload_max_zip_file", this.jk);
        this.fx.put("web_upload_report_url", this.l);
        this.fx.put("web_upload_storage_type", this.mv);
        this.fx.put("web_upload_report_only_wifi", this.t);
        this.fx.put("app_list_control", this.v);
        this.fx.put("max_tpl_cnts", this.ki);
        this.fx.put("fetch_tpl_timeout_ctrl", this.hs);
        this.fx.put("interact_show_after_time", this.te);
        this.fx.put("fetch_tpl_timeout_ctrl_bad_device", this.ti);
        this.fx.put("tpl_render_error_rate_h5", this.gb);
        this.fx.put("tpl_render_error_rate_native", this.gl);
        this.fx.put("mid_value", this.je);
        this.fx.put("low_value", this.ic);
        this.fx.put("tpl_enable_render_timeout_opt", this.fn);
        this.fx.put("open_single_abi", this.iq);
        com.bytedance.sdk.component.b.nr.fx fxVar4 = this.fx;
        int i = this.re;
        if (i == Integer.MAX_VALUE) {
            i = 0;
        }
        fxVar4.put("show_callback_mult", i);
        this.fx.put("webview_cache_count", this.r);
        this.fx.put("webview_cache_count_v3", this.uk);
        this.fx.put("webview_render_concurrent_count", this.jn);
        this.fx.put("enable_apm_pv", this.pq);
        this.fx.put("hit_app_list_time", this.eh);
        this.fx.put("hit_app_list_data", this.lf);
        this.fx.put("scheme_list_data", this.nb);
        this.fx.put("top_scheme_list_data", this.gc);
        this.fx.put("policy_url", this.ad);
        com.bytedance.sdk.component.b.nr.fx fxVar5 = this.fx;
        Boolean bool = this.kg;
        fxVar5.put("use_mediation_map", bool != null ? bool.booleanValue() : false);
        this.fx.put("apm_pv_config", this.z);
        this.fx.put("dyn_draw_engine_url", this.hm);
        this.fx.put("play_component_ugen_engine_url", this.wu);
        this.fx.put("ad_pkg_info_url", this.xh);
        this.fx.put("sp_key_if_sp_cache", this.zn);
        this.fx.put("download_sdk_config", this.wi);
        com.bytedance.sdk.component.b.nr.fx fxVar6 = this.fx;
        JSONObject jSONObject2 = this.e;
        fxVar6.put("thread_config", jSONObject2 != null ? jSONObject2.toString() : "");
        this.fx.put("npth_enable_type", this.pn);
        this.fx.put("is_sp_send_meta", this.az);
        this.fx.put("opt_config", this.qv.toString());
        this.fx.put("kv_config", this.bv.toString());
        this.fx.put("is_first_plugin_resources", this.uc);
        this.fx.put("vbtt", this.tr);
        this.fx.put("preload_switch", this.lc);
        this.fx.put("cache_ana_lru_switch", this.gs);
        this.fx.put("cache_ana_expire_switch", this.ss);
        this.fx.put("preload_time_point", this.qj);
        this.fx.put("app_info_cache_switch", this.qp);
        this.fx.put("is_adapt_density", this.ar);
        this.fx.put("disable_easy_playable", this.uu);
        this.fx.put("enable_target_34", this.ud);
        this.fx.put("enable_xm_market", this.gq);
        this.fx.put("disable_repeat_render", this.ri);
        this.fx.put("status_bar_adapt", this.bb);
        this.fx.put("jump_shield_short_duration", this.an);
        this.fx.put("replace_dummy_video", this.lg);
        this.fx.put("template_pull_timeout", this.vg);
        this.fx.put("template_pull_type", this.ej);
        if (!TextUtils.isEmpty(this.y)) {
            this.fx.put("template_ids", this.y);
        }
        if (!TextUtils.isEmpty(this.f5353jp)) {
            this.fx.put("tpl_infos", this.f5353jp);
        }
        com.bytedance.sdk.component.b.nr.fx fxVar7 = this.fx;
        bq bqVar = this.fa;
        fxVar7.put("tpl_timeout_ctrl", bqVar != null ? bqVar.toString() : "");
        this.fx.put("call_stack_rate", this.ky);
        this.fx.put("gnd_prefetch_cache_ttl", this.sj);
        this.fx.put("gnd_prefetch_cache_size", this.jc);
        this.fx.put("global_sample", this.dd);
        this.fx.put("read_video_from_cache", this.qb);
        this.fx.put("brand_video_cache_count", this.wv);
        this.fx.put("enable_bw_screen_detection", this.zu);
        this.fx.put("splash_card_show_max_count", this.vp);
        com.bytedance.sdk.component.b.nr.fx fxVar8 = this.fx;
        com.bytedance.sdk.openadsdk.core.x.nr nrVar = this.rh;
        fxVar8.put("clog_config", nrVar != null ? nrVar.toString() : "");
        com.bytedance.sdk.component.b.nr.fx fxVar9 = this.fx;
        com.bytedance.sdk.openadsdk.core.dislike.b bVar = this.bf;
        fxVar9.put("oncall_upload", bVar != null ? bVar.toString() : "");
        this.fx.put("feedback_opt", this.ja);
        this.fx.put("check_live_room", this.wq);
        this.fx.put("can_init_live", this.qn);
        this.fx.put("new_app_list", this.fi);
        com.bytedance.sdk.component.b.nr.fx fxVar10 = this.fx;
        nr nrVar2 = this.up;
        fxVar10.put("app_live_config", nrVar2 != null ? nrVar2.toString() : "");
        com.bytedance.sdk.component.b.nr.fx fxVar11 = this.fx;
        JSONObject jSONObject3 = this.dr;
        fxVar11.put("plugin_update_state", jSONObject3 != null ? jSONObject3.toString() : "");
        com.bytedance.sdk.component.b.nr.fx fxVar12 = this.fx;
        JSONObject jSONObject4 = this.al;
        fxVar12.put("antispam_autoclick_detect", jSONObject4 != null ? jSONObject4.toString() : "");
        com.bytedance.sdk.component.b.nr.fx fxVar13 = this.fx;
        JSONObject jSONObject5 = this.ir;
        fxVar13.put("plugin_retry_opt", jSONObject5 != null ? jSONObject5.toString() : "");
        this.fx.put("pglam_main_enable", this.en);
        this.fx.put("pglam_dns_check_enable", this.tq);
        this.fx.put("pglam_clazz_check", this.vk);
        this.fx.put("ud_enable", this.ol);
        this.fx.put("is_open_isw", this.ah);
        editorEdit.putInt("is_kv_cache_type", this.nu);
        editorEdit.putInt("kv_init_type", this.ls);
        editorEdit.putString("md5", this.ps);
        editorEdit.putString("url", this.bo);
        editorEdit.apply();
        this.fx.put("lp_url_sw", this.la);
        if (this.la == 1 && (com.bytedance.sdk.openadsdk.core.fx.fx.u().a() || !com.bytedance.sdk.openadsdk.core.n.o().ja())) {
            qj().put("lp_list", this.db);
        }
        if (this.dj != null) {
            this.fx.put("live_sdk_conf", this.dj.toString());
        }
        this.fx.put("open_dl_type", this.f5352im);
        this.fx.put("app_dl_scheme_list", this.na);
        this.fx.put("scheme_get_type", this.wf);
        this.fx.put("scheme_get_num", this.bp);
        this.fx.put("if_query_all_package", this.f5351de);
        if (this.bl != null) {
            this.fx.put("video_cache_config", this.bl.toString());
        }
        if (this.jf != null) {
            this.fx.put("log_rate_conf", this.jf.toString());
        }
        this.fx.put("splash_close_text", this.ln);
        this.fx.put("network_module", this.pb);
        this.fx.put("m_vids_join", this.f5354ms);
        this.fx.put("mini_event_upload_version", this.yy);
        this.fx.put("bg_web_readd_t", this.is);
        this.fx.put("title_priority", this.kd);
        this.fx.put("splash_video_opt_enable", this.ll);
        this.fx.put("support_live_code", this.dw);
        this.fx.put("gesture_through_enable", this.hl);
        this.fx.put("refresh_req_num", this.hc);
        this.fx.put("refresh_max_times", this.hj);
        this.fx.put("shake_trigger_control", this.it);
        this.fx.put("net_rating", this.sv);
        this.fx.put("device_rating", this.ba);
        this.fx.put("bytebench_rating", this.wo);
        com.bytedance.sdk.component.b.nr.fx fxVar14 = this.fx;
        JSONObject jSONObject6 = this.yf;
        fxVar14.put("net_rating_config", jSONObject6 != null ? jSONObject6.toString() : "");
        this.fx.put("express_gesture_enable", this.my);
        this.fx.put("enable_download_proto", this.sx);
        this.fx.put("main_start_downloader", this.bg);
        this.fx.put("app_express_gesture_priority", this.o);
        this.fx.put("ad_slot_conf_block", this.f5350cn);
        this.fx.put("view_check_by_window", this.oi);
        this.fx.put("shake_twist_bind_show", this.kp);
        this.fx.put("view_check_by_click", this.dx);
        this.fx.put("node_line_enable", this.vm);
        this.fx.put("node_line_detail_enable", this.ox);
        this.fx.put("enable", this.fq);
        this.fx.put("session_enable", this.gz);
        this.fx.put("endcard_lazy", this.ga);
        this.fx.put("use_new_shake_manager", this.tn);
        this.fx.put("stats_report_register_info", this.of);
        bf.u(this.fx);
        yd.u(this.fx);
        com.bytedance.sdk.openadsdk.core.kj.n.nr(this.fx);
        sx.u(this.fx);
        d.nr(this.fx);
        ja.nr(this.fx);
        tk.u(this.fx);
    }

    public static String pn() {
        return com.bytedance.sdk.openadsdk.core.b.u.x() ? "tt_sdk_lp_w_list_bst" : "tt_sdk_lp_w_list";
    }

    private com.bytedance.sdk.component.b.nr.fx qj() {
        if (this.b == null) {
            this.b = com.bytedance.sdk.openadsdk.core.y.bf.u(pn());
        }
        return this.b;
    }

    public static void s() {
        t tVarNr = dw.nr();
        if (tVarNr != null) {
            boolean zUq = tVarNr.uq();
            if (com.bytedance.sdk.openadsdk.my.fx.nr(com.bytedance.sdk.openadsdk.core.n.o().y()).booleanValue(1) != zUq) {
                com.bytedance.sdk.openadsdk.core.n.o().y().apply(com.bytedance.sdk.openadsdk.my.b.u().u(10).u(Void.class).u(0, new wq().u("downloadPath", com.bytedance.sdk.openadsdk.core.l.a.u(zUq))).nr());
            }
            if (tVarNr.qn && tVarNr.dj != null) {
                com.bytedance.sdk.openadsdk.core.live.nr.u().nr();
            }
            com.bytedance.sdk.openadsdk.core.bf.fx();
            com.bytedance.sdk.openadsdk.core.xw.u.u().u(dw.getContext());
            com.bytedance.sdk.component.utils.jk.fx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pb.t.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.k.u.fx.u().u(dw.nr().i());
                }
            }, 3000L);
        }
    }

    private void t(int i) {
        if (i <= 0) {
            i = 1;
        }
        com.bytedance.adsdk.lottie.x.u(i);
    }

    public static String x() {
        return com.bytedance.sdk.openadsdk.core.b.u.x() ? "tt_sdk_settings_slot_splash_bst" : "tt_sdk_settings_slot_splash";
    }

    public boolean a() {
        if (this.of == -1) {
            this.of = nr().getInt("stats_report_register_info", 0);
        }
        return this.of == 1;
    }

    public int ad() {
        if (this.te == Integer.MAX_VALUE) {
            this.te = nr().get("interact_show_after_time", 500);
        }
        return this.te;
    }

    public int ah() {
        return this.vg;
    }

    public int al() {
        return this.nu;
    }

    public int ap() {
        if (this.uk == Integer.MAX_VALUE) {
            this.uk = nr().get("webview_cache_count_v3", 0);
        }
        int i = this.uk;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int ay() {
        if (this.iz == Integer.MAX_VALUE) {
            this.iz = nr().get("web_upload_enable", 0);
        }
        return this.iz;
    }

    public boolean az() {
        return this.qp;
    }

    public boolean ba() {
        return this.gs;
    }

    public long bc() {
        if (this.jw == this.ju) {
            this.jw = nr().get("ext_use_type", this.ju);
        }
        return this.jw;
    }

    public int bf() {
        if (this.f == Integer.MAX_VALUE) {
            this.f = nr().get("adlog_batch", 10);
        }
        return this.f;
    }

    public int bj() {
        if (this.nu == 0) {
            this.nu = cn().getInt("is_kv_cache_type", 0);
        }
        return this.nu;
    }

    public boolean bl() {
        if (this.v == Integer.MAX_VALUE) {
            this.v = nr().get("app_list_control", 0);
        }
        return this.v == 1;
    }

    public boolean bo() {
        return this.qv.u;
    }

    public float bp() {
        if (this.gb == 0.0f) {
            this.gb = nr().get("tpl_render_error_rate_h5", 4.5f);
        }
        return this.gb;
    }

    public boolean bq() {
        if (this.my == Integer.MIN_VALUE) {
            this.my = nr().get("express_gesture_enable", 0);
        }
        return this.my == 1;
    }

    public int bv() {
        return this.vp;
    }

    public boolean c() {
        if (this.bg == Integer.MIN_VALUE) {
            this.bg = nr().get("main_start_downloader", 0);
        }
        return this.bg == 1;
    }

    public int cb() {
        if (this.hj == Integer.MAX_VALUE) {
            this.hj = nr().get("refresh_max_times", 1);
        }
        if (this.hj < 0) {
            this.hj = 1;
        }
        return this.hj;
    }

    public int cj() {
        if (this.za == Integer.MAX_VALUE) {
            this.za = nr().get("adlog_exception_batch", 100);
        }
        return this.za;
    }

    public boolean d() {
        if (this.tm == Integer.MAX_VALUE) {
            this.tm = nr().get("adlog_debug", 0);
        }
        return this.tm == 1;
    }

    public boolean db() {
        return this.az;
    }

    public JSONObject dc() {
        if (this.dc == null) {
            String str = nr().get("http_drop", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.dc = new JSONObject(str);
                } catch (Exception unused) {
                }
            }
        }
        return this.dc;
    }

    public int dd() {
        if (this.zn == Integer.MAX_VALUE) {
            this.zn = nr().get("sp_key_if_sp_cache", 1);
        }
        return this.zn;
    }

    public void de() {
        if (this.jq == null) {
            synchronized (this.fz) {
                if (this.jq == null) {
                    this.jq = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), x(), 0);
                }
            }
        }
    }

    public y df() {
        return this.dj;
    }

    public JSONObject dj() {
        return this.lk;
    }

    public boolean dr() {
        return this.lg != 1;
    }

    public int dw() {
        if (this.o == Integer.MIN_VALUE) {
            this.o = nr().get("app_express_gesture_priority", -1);
        }
        return this.o;
    }

    public int e() {
        if (this.ki == Integer.MAX_VALUE) {
            this.ki = nr().get("max_tpl_cnts", 100);
        }
        return this.ki;
    }

    public int ec() {
        int i = this.bp;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public int eh() {
        if (this.n == Integer.MAX_VALUE) {
            this.n = nr().get("web_upload_send_restowv", 0);
        }
        return this.n;
    }

    public int en() {
        if (this.jc == -1) {
            this.jc = nr().get("gnd_prefetch_cache_size", 5);
        }
        return this.jc;
    }

    public JSONObject ex() {
        return this.pu;
    }

    public pb f() {
        if (this.mh == null) {
            this.mh = pb.u(nr().get("insert_js_config", ""));
        }
        return this.mh;
    }

    public boolean fa() {
        return this.ja == 1;
    }

    public int fi() {
        return this.bb;
    }

    public boolean fn() {
        int iGl = gl();
        com.bytedance.sdk.component.b.u uVarNr = kj.nr();
        return (iGl == 40001 || iGl == 40002 || iGl == 4) && uVarNr != null && uVarNr.getArmorLoadStatus();
    }

    public JSONObject fq() {
        return this.ir;
    }

    public boolean fx() {
        return this.md == 1;
    }

    public String fz() {
        if (TextUtils.isEmpty(this.ps)) {
            this.ps = cn().getString("md5", "");
        }
        return this.ps;
    }

    public List<Integer> g() {
        return new ArrayList(this.uo);
    }

    public String gb() {
        if (TextUtils.isEmpty(this.ln)) {
            this.ln = nr().get("splash_close_text", "跳过");
        }
        if (TextUtils.isEmpty(this.ln)) {
            this.ln = "跳过";
        }
        return this.ln;
    }

    public int gc() {
        if (this.s == Integer.MAX_VALUE) {
            this.s = nr().get("web_upload_max_retry", 0);
        }
        return this.s;
    }

    public int ge() {
        if (this.ay == Integer.MAX_VALUE) {
            this.ay = nr().get("splash_check_type", 1);
        }
        return this.ay;
    }

    public String gi() {
        if (TextUtils.isEmpty(this.zq)) {
            String str = nr().get("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
            this.zq = str;
            if (TextUtils.isEmpty(str)) {
                this.zq = "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
            }
        }
        return this.zq;
    }

    public int gl() {
        return com.bytedance.sdk.openadsdk.core.fx.pn.u().a();
    }

    public boolean gs() {
        return this.ox;
    }

    public boolean gz() {
        return this.ba;
    }

    public boolean h() {
        if (this.rv == Integer.MAX_VALUE) {
            this.rv = nr().get("adlog_monitor", 1);
        }
        return this.rv != 0;
    }

    public boolean hc() {
        return this.fi;
    }

    public JSONObject hj() {
        return this.dr;
    }

    public boolean hl() {
        return this.qn;
    }

    public int hm() {
        if (this.f5354ms == Integer.MAX_VALUE) {
            this.f5354ms = nr().get("m_vids_join", 0);
        }
        int i = this.f5354ms;
        if (i == Integer.MAX_VALUE) {
            return 0;
        }
        return i;
    }

    public String hs() {
        if (TextUtils.isEmpty(this.hm)) {
            this.hm = nr().get("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        }
        return this.hm;
    }

    public JSONObject i() {
        return this.ap;
    }

    public int ic() {
        if (this.c == Integer.MAX_VALUE) {
            this.c = nr().getInt("download_button_effect", 0);
        }
        return this.c;
    }

    public boolean im() {
        return this.oi;
    }

    public boolean iq() {
        if (this.vz == Integer.MAX_VALUE) {
            this.vz = nr().get("settings_open", 1);
        }
        return this.vz == 1;
    }

    public int ir() {
        if (this.ls == 0) {
            this.ls = cn().getInt("kv_init_type", 0);
        }
        return this.ls;
    }

    public boolean is() {
        return this.wq;
    }

    public nr it() {
        return this.up;
    }

    public boolean j() {
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.d.b) && com.bytedance.sdk.openadsdk.core.d.b.compareTo(com.bytedance.sdk.openadsdk.core.d.f5274a) < 0) {
            return false;
        }
        Boolean bool = this.et;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.kg == null) {
            this.kg = Boolean.valueOf(nr().get("use_mediation_map", false));
        }
        Boolean bool2 = this.kg;
        this.et = bool2;
        return bool2.booleanValue();
    }

    public boolean ja() {
        if (this.k == Integer.MAX_VALUE) {
            this.k = nr().get("enable_kite", 0);
        }
        return this.k == 1;
    }

    public x jc() {
        return this.qv;
    }

    public boolean je() {
        if (this.bq == Integer.MAX_VALUE) {
            this.bq = nr().getInt("enable_cdn_opt", 0);
        }
        return this.bq == 1;
    }

    public JSONObject jf() {
        if (this.bl == null) {
            try {
                String str = nr().get("video_cache_config", "");
                if (!TextUtils.isEmpty(str)) {
                    this.bl = new JSONObject(str);
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return this.bl;
    }

    public boolean jk() {
        if (this.vb.get() == -1) {
            this.vb.set(nr().get("use_new_shake_manager", 0));
        }
        return this.vb.get() == 1;
    }

    public int jn() {
        if (this.hc == Integer.MAX_VALUE) {
            this.hc = nr().get("refresh_req_num", 2);
        }
        if (this.hc <= 0) {
            this.hc = 2;
        }
        return this.hc;
    }

    public boolean jp() {
        if (this.i == this.sf) {
            this.i = nr().get("event_switch", this.sf);
        }
        return this.i == 1;
    }

    public String jq() {
        if (this.la != 1) {
            return "";
        }
        if (!TextUtils.isEmpty(this.db)) {
            return this.db;
        }
        String str = qj().get("lp_list", this.db);
        this.db = str;
        return str;
    }

    public boolean ju() {
        if (this.dd == 2.1474836E9f) {
            this.dd = nr().get("global_sample", 1.0f);
        }
        return com.bytedance.sdk.openadsdk.core.iz.nr.u(this.dd, false);
    }

    public JSONObject jw() {
        if (this.jf == null) {
            try {
                this.jf = new JSONObject(nr().get("log_rate_conf", ""));
            } catch (Exception unused) {
            }
        }
        return this.jf;
    }

    public boolean k() {
        return this.it == 1;
    }

    public int kd() {
        return this.tq;
    }

    public boolean ki() {
        if (this.ym == Integer.MAX_VALUE) {
            this.ym = this.fx.get("disable_show_url", 0);
        }
        return this.ym == 1;
    }

    public boolean kj() {
        boolean z = nr().get("enable_apm_pv", false);
        this.pq = z;
        return z;
    }

    public int kv() {
        if (this.r == Integer.MAX_VALUE) {
            this.r = nr().get("webview_cache_count", 0);
        }
        int i = this.r;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int kw() {
        if (this.mv == Integer.MAX_VALUE) {
            this.mv = nr().get("web_upload_storage_type", 0);
        }
        return this.mv;
    }

    public String ky() {
        if (TextUtils.isEmpty(this.ad)) {
            this.ad = nr().get("policy_url", mx);
        }
        return this.ad;
    }

    public JSONObject l() {
        if (this.mf == null) {
            String str = nr().get("settings_json_str", "");
            if (!TextUtils.isEmpty(str)) {
                String strFx = com.bytedance.sdk.component.utils.u.fx(str);
                if (!TextUtils.isEmpty(strFx)) {
                    try {
                        this.mf = new JSONObject(strFx);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return this.mf;
    }

    public int la() {
        int i = nr().get("npth_enable_type", 0);
        this.pn = i;
        return i;
    }

    public boolean lc() {
        return this.vm;
    }

    public int lf() {
        if (this.f5349a == Integer.MAX_VALUE) {
            this.f5349a = nr().get("web_upload_max_single_file", 2);
        }
        return this.f5349a;
    }

    public boolean lk() {
        if (!this.fq) {
            this.fq = nr().get("enable", true);
        }
        return this.fq;
    }

    public String[] ll() {
        String str = this.vk;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return this.vk.split("//");
    }

    public int ln() {
        return this.ej;
    }

    public int ls() {
        return this.wv;
    }

    public boolean m() {
        if (this.uq == Integer.MAX_VALUE) {
            this.uq = nr().get("switch_audio_focus", 0);
        }
        return this.uq == 1;
    }

    public long mh() {
        if (this.w == 0) {
            this.w = nr().get("data_time", 0L);
        }
        return this.w;
    }

    public int mk() {
        if (this.t == Integer.MAX_VALUE) {
            this.t = nr().get("web_upload_report_only_wifi", 0);
        }
        return this.t;
    }

    public boolean ms() {
        return this.dx;
    }

    public void mv() {
        com.bytedance.sdk.openadsdk.core.my.iz.u().u(this.fx.get("req_exemption_cfg", ""));
    }

    public int mx() {
        if (this.ti == 0) {
            this.ti = nr().get("fetch_tpl_timeout_ctrl_bad_device", 300);
        }
        return this.ti;
    }

    public String my() {
        if (TextUtils.isEmpty(this.df)) {
            this.df = com.bytedance.sdk.openadsdk.core.fx.fx.u().b();
        }
        return this.df;
    }

    public com.bytedance.sdk.component.b.nr.fx n() {
        if (this.j == null) {
            this.j = com.bytedance.sdk.openadsdk.core.y.bf.u(iz());
        }
        if (com.bytedance.sdk.openadsdk.core.y.bf.nr() != 1) {
            return null;
        }
        return this.j;
    }

    public boolean na() {
        return this.kp;
    }

    public int nb() {
        if (this.jk == Integer.MAX_VALUE) {
            this.jk = nr().get("web_upload_max_zip_file", 5);
        }
        return this.jk;
    }

    public com.bytedance.sdk.component.b.nr.fx nr() {
        if (this.fx == null) {
            this.fx = com.bytedance.sdk.openadsdk.core.y.bf.u(b());
        }
        return this.fx;
    }

    public boolean nu() {
        if (this.qb == Integer.MAX_VALUE) {
            this.qb = nr().get("read_video_from_cache", 1);
        }
        return this.qb == 1;
    }

    public boolean o() {
        if (this.q == -1) {
            this.q = nr().get("enable_ttvideo", -1);
        }
        int i = this.q;
        if (i == 0) {
            return false;
        }
        return (i == 1 && (gi.bg() || gi.sx())) ? false : true;
    }

    public boolean oa() {
        if (this.u == 0) {
            this.u = nr().get("launch_strategy", 0);
        }
        return this.u == 1;
    }

    public boolean ob() {
        return ge() == 1;
    }

    public int ol() {
        if (this.gq == Integer.MAX_VALUE) {
            this.gq = nr().get("enable_xm_market", 1);
        }
        return this.gq;
    }

    public String p() {
        if (TextUtils.equals(this.l, "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/")) {
            this.l = nr().get("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
        }
        return this.l;
    }

    public int pb() {
        if (this.ua == 3) {
            this.ua = nr().get("stats_batch", 5);
        }
        int i = this.ua;
        if (i <= 0 || i > 100) {
            return 5;
        }
        return i;
    }

    public boolean pq() {
        return this.f5351de == 1;
    }

    public boolean ps() {
        return this.qv.fx;
    }

    public boolean pu() {
        if (!this.gz) {
            this.gz = nr().get("session_enable", false);
        }
        return this.gz;
    }

    public String q() {
        if (TextUtils.isEmpty(this.wj)) {
            String str = nr().get("url_stats", "api-access.pangolin-sdk-toutiao1.com");
            this.wj = str;
            if (TextUtils.isEmpty(str)) {
                this.wj = "api-access.pangolin-sdk-toutiao1.com";
            }
        }
        return this.wj;
    }

    public List<String> qb() {
        if (this.eh + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        Map<String, Boolean> mapNr = com.bytedance.sdk.openadsdk.core.y.d.nr(86400000L);
        ArrayList arrayList = new ArrayList();
        synchronized (this.nb) {
            for (String str : this.nb) {
                if (!mapNr.containsKey(str.replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""))) {
                    arrayList.add(str);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.bytedance.sdk.openadsdk.core.pb.t.4
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public int compare(String str2, String str3) {
                try {
                    return Integer.parseInt(Uri.parse(str2).getQueryParameter("tt_csj_scheme_priority")) - Integer.parseInt(Uri.parse(str3).getQueryParameter("tt_csj_scheme_priority"));
                } catch (Throwable unused) {
                    return 0;
                }
            }
        });
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.set(i, ((String) arrayList.get(i)).replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""));
        }
        return arrayList;
    }

    public JSONObject qe() {
        return this.kv;
    }

    public List<String> qf() {
        if (this.eh + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.lf.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public boolean qn() {
        return this.ri;
    }

    public String qq() {
        if (TextUtils.isEmpty(this.ec)) {
            this.ec = nr().get("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
        }
        return this.ec;
    }

    public boolean qv() {
        return this.wo;
    }

    public boolean r() {
        if (this.ll == Integer.MAX_VALUE) {
            this.ll = nr().get("splash_video_opt_enable", 0);
        }
        return this.ll == 1;
    }

    public JSONObject rg() {
        return this.rg;
    }

    public long rh() {
        if (this.kw == 2147483647L) {
            this.kw = nr().get("adlog_interval", 5000L);
        }
        return this.kw;
    }

    public JSONObject rv() {
        return this.e;
    }

    public JSONObject sf() {
        return this.g;
    }

    public int si() {
        return this.qj;
    }

    public iz sj() {
        return this.bv;
    }

    public boolean ss() {
        return this.ga == 1;
    }

    public JSONObject su() {
        if (this.oa == null) {
            String str = nr().get("digest", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.oa = new JSONObject(str);
                } catch (Exception unused) {
                }
            }
        }
        return this.oa;
    }

    public boolean sv() {
        return this.lc;
    }

    public boolean sx() {
        if (this.qq == Integer.MIN_VALUE) {
            this.qq = nr().get("enable_zaid", 0);
        }
        return this.qq != 0;
    }

    public String te() {
        if (TextUtils.isEmpty(this.wu)) {
            this.wu = nr().get("play_component_ugen_engine_url", "");
        }
        return this.wu;
    }

    public String ti() {
        if (TextUtils.isEmpty(this.xh)) {
            this.xh = nr().get("ad_pkg_info_url", "apps.bytesfield.com");
        }
        if (TextUtils.isEmpty(this.xh)) {
            this.xh = "apps.bytesfield.com";
        }
        return this.xh;
    }

    public boolean tk() {
        if (this.p == Integer.MAX_VALUE) {
            this.p = 1;
        }
        return this.p == 1;
    }

    public JSONObject tm() {
        if (this.tk == null) {
            String str = nr().get("download_sdk_config", "");
            this.wi = str;
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.tk = new JSONObject(this.wi);
                } catch (JSONException unused) {
                }
            }
        }
        return this.tk;
    }

    public long tq() {
        if (this.sj == -1) {
            this.sj = nr().get("gnd_prefetch_cache_ttl", 0L);
        }
        return this.sj;
    }

    public JSONObject tr() {
        return this.ts;
    }

    public int ts() {
        if (this.tr == Integer.MAX_VALUE) {
            this.tr = nr().get("vbtt", 5);
        }
        return this.tr;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x073a A[Catch: all -> 0x09e5, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x018d, B:6:0x0194, B:8:0x01a4, B:9:0x01ab, B:11:0x01bb, B:12:0x01c2, B:14:0x01d2, B:18:0x01f2, B:20:0x0202, B:21:0x0209, B:23:0x0219, B:24:0x0220, B:26:0x0230, B:27:0x0237, B:29:0x0251, B:33:0x0271, B:35:0x0281, B:39:0x02a1, B:41:0x02b1, B:42:0x02b8, B:46:0x047c, B:48:0x04a1, B:50:0x04a7, B:51:0x04ab, B:53:0x04b1, B:54:0x04bd, B:56:0x0518, B:58:0x051e, B:59:0x0522, B:61:0x0528, B:62:0x0534, B:63:0x0536, B:73:0x056c, B:74:0x056e, B:84:0x05a4, B:86:0x05b6, B:90:0x05ca, B:92:0x05da, B:96:0x05ef, B:98:0x067b, B:99:0x0682, B:101:0x0692, B:103:0x069f, B:104:0x06a4, B:106:0x06b4, B:107:0x06bb, B:109:0x06cb, B:110:0x06d6, B:112:0x073a, B:113:0x0748, B:115:0x0783, B:116:0x0789, B:118:0x097e, B:119:0x0988, B:121:0x0998, B:122:0x099f, B:124:0x09b8, B:125:0x09c1, B:127:0x09c7, B:129:0x09d7, B:95:0x05e6, B:89:0x05c1, B:134:0x09e1, B:137:0x09e4, B:38:0x028a, B:32:0x025a, B:17:0x01db, B:64:0x0537, B:66:0x054f, B:68:0x0555, B:69:0x0559, B:71:0x055f, B:72:0x056b, B:75:0x056f, B:77:0x0587, B:79:0x058d, B:80:0x0591, B:82:0x0597, B:83:0x05a3), top: B:165:0x0001, inners: #1, #3, #7, #14, #18, #19, #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0783 A[Catch: all -> 0x09e5, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x018d, B:6:0x0194, B:8:0x01a4, B:9:0x01ab, B:11:0x01bb, B:12:0x01c2, B:14:0x01d2, B:18:0x01f2, B:20:0x0202, B:21:0x0209, B:23:0x0219, B:24:0x0220, B:26:0x0230, B:27:0x0237, B:29:0x0251, B:33:0x0271, B:35:0x0281, B:39:0x02a1, B:41:0x02b1, B:42:0x02b8, B:46:0x047c, B:48:0x04a1, B:50:0x04a7, B:51:0x04ab, B:53:0x04b1, B:54:0x04bd, B:56:0x0518, B:58:0x051e, B:59:0x0522, B:61:0x0528, B:62:0x0534, B:63:0x0536, B:73:0x056c, B:74:0x056e, B:84:0x05a4, B:86:0x05b6, B:90:0x05ca, B:92:0x05da, B:96:0x05ef, B:98:0x067b, B:99:0x0682, B:101:0x0692, B:103:0x069f, B:104:0x06a4, B:106:0x06b4, B:107:0x06bb, B:109:0x06cb, B:110:0x06d6, B:112:0x073a, B:113:0x0748, B:115:0x0783, B:116:0x0789, B:118:0x097e, B:119:0x0988, B:121:0x0998, B:122:0x099f, B:124:0x09b8, B:125:0x09c1, B:127:0x09c7, B:129:0x09d7, B:95:0x05e6, B:89:0x05c1, B:134:0x09e1, B:137:0x09e4, B:38:0x028a, B:32:0x025a, B:17:0x01db, B:64:0x0537, B:66:0x054f, B:68:0x0555, B:69:0x0559, B:71:0x055f, B:72:0x056b, B:75:0x056f, B:77:0x0587, B:79:0x058d, B:80:0x0591, B:82:0x0597, B:83:0x05a3), top: B:165:0x0001, inners: #1, #3, #7, #14, #18, #19, #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x09b8 A[Catch: Exception -> 0x09d7, all -> 0x09e5, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x018d, B:6:0x0194, B:8:0x01a4, B:9:0x01ab, B:11:0x01bb, B:12:0x01c2, B:14:0x01d2, B:18:0x01f2, B:20:0x0202, B:21:0x0209, B:23:0x0219, B:24:0x0220, B:26:0x0230, B:27:0x0237, B:29:0x0251, B:33:0x0271, B:35:0x0281, B:39:0x02a1, B:41:0x02b1, B:42:0x02b8, B:46:0x047c, B:48:0x04a1, B:50:0x04a7, B:51:0x04ab, B:53:0x04b1, B:54:0x04bd, B:56:0x0518, B:58:0x051e, B:59:0x0522, B:61:0x0528, B:62:0x0534, B:63:0x0536, B:73:0x056c, B:74:0x056e, B:84:0x05a4, B:86:0x05b6, B:90:0x05ca, B:92:0x05da, B:96:0x05ef, B:98:0x067b, B:99:0x0682, B:101:0x0692, B:103:0x069f, B:104:0x06a4, B:106:0x06b4, B:107:0x06bb, B:109:0x06cb, B:110:0x06d6, B:112:0x073a, B:113:0x0748, B:115:0x0783, B:116:0x0789, B:118:0x097e, B:119:0x0988, B:121:0x0998, B:122:0x099f, B:124:0x09b8, B:125:0x09c1, B:127:0x09c7, B:129:0x09d7, B:95:0x05e6, B:89:0x05c1, B:134:0x09e1, B:137:0x09e4, B:38:0x028a, B:32:0x025a, B:17:0x01db, B:64:0x0537, B:66:0x054f, B:68:0x0555, B:69:0x0559, B:71:0x055f, B:72:0x056b, B:75:0x056f, B:77:0x0587, B:79:0x058d, B:80:0x0591, B:82:0x0597, B:83:0x05a3), top: B:165:0x0001, inners: #1, #3, #7, #14, #18, #19, #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x067b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0537 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0692 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x05da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x097e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0281 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0202 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0230 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0219 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0998 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x06cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0251 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0271 A[Catch: all -> 0x09e5, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x018d, B:6:0x0194, B:8:0x01a4, B:9:0x01ab, B:11:0x01bb, B:12:0x01c2, B:14:0x01d2, B:18:0x01f2, B:20:0x0202, B:21:0x0209, B:23:0x0219, B:24:0x0220, B:26:0x0230, B:27:0x0237, B:29:0x0251, B:33:0x0271, B:35:0x0281, B:39:0x02a1, B:41:0x02b1, B:42:0x02b8, B:46:0x047c, B:48:0x04a1, B:50:0x04a7, B:51:0x04ab, B:53:0x04b1, B:54:0x04bd, B:56:0x0518, B:58:0x051e, B:59:0x0522, B:61:0x0528, B:62:0x0534, B:63:0x0536, B:73:0x056c, B:74:0x056e, B:84:0x05a4, B:86:0x05b6, B:90:0x05ca, B:92:0x05da, B:96:0x05ef, B:98:0x067b, B:99:0x0682, B:101:0x0692, B:103:0x069f, B:104:0x06a4, B:106:0x06b4, B:107:0x06bb, B:109:0x06cb, B:110:0x06d6, B:112:0x073a, B:113:0x0748, B:115:0x0783, B:116:0x0789, B:118:0x097e, B:119:0x0988, B:121:0x0998, B:122:0x099f, B:124:0x09b8, B:125:0x09c1, B:127:0x09c7, B:129:0x09d7, B:95:0x05e6, B:89:0x05c1, B:134:0x09e1, B:137:0x09e4, B:38:0x028a, B:32:0x025a, B:17:0x01db, B:64:0x0537, B:66:0x054f, B:68:0x0555, B:69:0x0559, B:71:0x055f, B:72:0x056b, B:75:0x056f, B:77:0x0587, B:79:0x058d, B:80:0x0591, B:82:0x0597, B:83:0x05a3), top: B:165:0x0001, inners: #1, #3, #7, #14, #18, #19, #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02a1 A[Catch: all -> 0x09e5, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x018d, B:6:0x0194, B:8:0x01a4, B:9:0x01ab, B:11:0x01bb, B:12:0x01c2, B:14:0x01d2, B:18:0x01f2, B:20:0x0202, B:21:0x0209, B:23:0x0219, B:24:0x0220, B:26:0x0230, B:27:0x0237, B:29:0x0251, B:33:0x0271, B:35:0x0281, B:39:0x02a1, B:41:0x02b1, B:42:0x02b8, B:46:0x047c, B:48:0x04a1, B:50:0x04a7, B:51:0x04ab, B:53:0x04b1, B:54:0x04bd, B:56:0x0518, B:58:0x051e, B:59:0x0522, B:61:0x0528, B:62:0x0534, B:63:0x0536, B:73:0x056c, B:74:0x056e, B:84:0x05a4, B:86:0x05b6, B:90:0x05ca, B:92:0x05da, B:96:0x05ef, B:98:0x067b, B:99:0x0682, B:101:0x0692, B:103:0x069f, B:104:0x06a4, B:106:0x06b4, B:107:0x06bb, B:109:0x06cb, B:110:0x06d6, B:112:0x073a, B:113:0x0748, B:115:0x0783, B:116:0x0789, B:118:0x097e, B:119:0x0988, B:121:0x0998, B:122:0x099f, B:124:0x09b8, B:125:0x09c1, B:127:0x09c7, B:129:0x09d7, B:95:0x05e6, B:89:0x05c1, B:134:0x09e1, B:137:0x09e4, B:38:0x028a, B:32:0x025a, B:17:0x01db, B:64:0x0537, B:66:0x054f, B:68:0x0555, B:69:0x0559, B:71:0x055f, B:72:0x056b, B:75:0x056f, B:77:0x0587, B:79:0x058d, B:80:0x0591, B:82:0x0597, B:83:0x05a3), top: B:165:0x0001, inners: #1, #3, #7, #14, #18, #19, #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x04b1 A[Catch: all -> 0x09e5, LOOP:0: B:51:0x04ab->B:53:0x04b1, LOOP_END, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x018d, B:6:0x0194, B:8:0x01a4, B:9:0x01ab, B:11:0x01bb, B:12:0x01c2, B:14:0x01d2, B:18:0x01f2, B:20:0x0202, B:21:0x0209, B:23:0x0219, B:24:0x0220, B:26:0x0230, B:27:0x0237, B:29:0x0251, B:33:0x0271, B:35:0x0281, B:39:0x02a1, B:41:0x02b1, B:42:0x02b8, B:46:0x047c, B:48:0x04a1, B:50:0x04a7, B:51:0x04ab, B:53:0x04b1, B:54:0x04bd, B:56:0x0518, B:58:0x051e, B:59:0x0522, B:61:0x0528, B:62:0x0534, B:63:0x0536, B:73:0x056c, B:74:0x056e, B:84:0x05a4, B:86:0x05b6, B:90:0x05ca, B:92:0x05da, B:96:0x05ef, B:98:0x067b, B:99:0x0682, B:101:0x0692, B:103:0x069f, B:104:0x06a4, B:106:0x06b4, B:107:0x06bb, B:109:0x06cb, B:110:0x06d6, B:112:0x073a, B:113:0x0748, B:115:0x0783, B:116:0x0789, B:118:0x097e, B:119:0x0988, B:121:0x0998, B:122:0x099f, B:124:0x09b8, B:125:0x09c1, B:127:0x09c7, B:129:0x09d7, B:95:0x05e6, B:89:0x05c1, B:134:0x09e1, B:137:0x09e4, B:38:0x028a, B:32:0x025a, B:17:0x01db, B:64:0x0537, B:66:0x054f, B:68:0x0555, B:69:0x0559, B:71:0x055f, B:72:0x056b, B:75:0x056f, B:77:0x0587, B:79:0x058d, B:80:0x0591, B:82:0x0597, B:83:0x05a3), top: B:165:0x0001, inners: #1, #3, #7, #14, #18, #19, #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0528 A[Catch: all -> 0x09e5, LOOP:1: B:59:0x0522->B:61:0x0528, LOOP_END, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x018d, B:6:0x0194, B:8:0x01a4, B:9:0x01ab, B:11:0x01bb, B:12:0x01c2, B:14:0x01d2, B:18:0x01f2, B:20:0x0202, B:21:0x0209, B:23:0x0219, B:24:0x0220, B:26:0x0230, B:27:0x0237, B:29:0x0251, B:33:0x0271, B:35:0x0281, B:39:0x02a1, B:41:0x02b1, B:42:0x02b8, B:46:0x047c, B:48:0x04a1, B:50:0x04a7, B:51:0x04ab, B:53:0x04b1, B:54:0x04bd, B:56:0x0518, B:58:0x051e, B:59:0x0522, B:61:0x0528, B:62:0x0534, B:63:0x0536, B:73:0x056c, B:74:0x056e, B:84:0x05a4, B:86:0x05b6, B:90:0x05ca, B:92:0x05da, B:96:0x05ef, B:98:0x067b, B:99:0x0682, B:101:0x0692, B:103:0x069f, B:104:0x06a4, B:106:0x06b4, B:107:0x06bb, B:109:0x06cb, B:110:0x06d6, B:112:0x073a, B:113:0x0748, B:115:0x0783, B:116:0x0789, B:118:0x097e, B:119:0x0988, B:121:0x0998, B:122:0x099f, B:124:0x09b8, B:125:0x09c1, B:127:0x09c7, B:129:0x09d7, B:95:0x05e6, B:89:0x05c1, B:134:0x09e1, B:137:0x09e4, B:38:0x028a, B:32:0x025a, B:17:0x01db, B:64:0x0537, B:66:0x054f, B:68:0x0555, B:69:0x0559, B:71:0x055f, B:72:0x056b, B:75:0x056f, B:77:0x0587, B:79:0x058d, B:80:0x0591, B:82:0x0597, B:83:0x05a3), top: B:165:0x0001, inners: #1, #3, #7, #14, #18, #19, #21 }] */
    @Override // com.bytedance.sdk.openadsdk.core.pb.pn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void u() {
        String str;
        String str2;
        String str3;
        String str4;
        Set<String> set;
        Set<String> set2;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i;
        String str10;
        String str11;
        String str12;
        JSONObject jSONObject;
        Iterator<String> it;
        Iterator<String> it2;
        nr();
        this.cb = true;
        this.za = this.fx.get("adlog_exception_batch", 100);
        this.wj = this.fx.get("url_stats", "api-access.pangolin-sdk-toutiao1.com");
        this.md = this.fx.get("open_mini_game", 1);
        this.ec = this.fx.get("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
        this.pq = this.fx.get("enable_apm_pv", false);
        this.zq = this.fx.get("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
        this.cj = this.fx.get("xpath", "");
        this.w = this.fx.get("data_time", 0L);
        this.ex = this.fx.get("fetch_template", 3600);
        this.tr = this.fx.get("vbtt", 5);
        this.y = this.fx.get("template_ids", this.xx);
        this.su = this.fx.get("pyload_h5", this.xx);
        this.mh = pb.u(this.fx.get("insert_js_config", this.xx));
        this.ay = this.fx.get("splash_check_type", 1);
        this.tm = this.fx.get("adlog_debug", 0);
        this.f = this.fx.get("adlog_batch", 10);
        this.kw = this.fx.get("adlog_interval", 5000L);
        this.k = this.fx.get("enable_kite", 0);
        this.za = this.fx.get("adlog_exception_batch", 100);
        this.rv = this.fx.get("adlog_monitor", 1);
        this.q = this.fx.get("enable_ttvideo", -1);
        this.qq = this.fx.get("enable_zaid", 0);
        this.kj = this.fx.get("player_stats_check_switch", 1);
        this.bq = this.fx.get("enable_cdn_opt", 0);
        this.c = this.fx.get("download_button_effect", 0);
        this.zx = this.fx.get("enable_dl_ext", this.ob);
        this.jw = this.fx.get("ext_use_type", this.ju);
        this.ge = this.fx.get("enable_glgpu", 0);
        this.u = this.fx.get("launch_strategy", 0);
        this.gi = this.fx.get("dl_popup_duration", 1000);
        this.d = this.fx.get("opt_show_check", 0);
        this.fa = bq.fx(this.fx.get("tpl_timeout_ctrl", ""));
        MultiWebview.setMaxWebViewCount(this.fx.get("open_webview_count", 0));
        String str13 = this.fx.get("digest", "");
        if (!TextUtils.isEmpty(str13)) {
            try {
                this.oa = new JSONObject(str13);
            } catch (Exception unused) {
            }
        }
        String str14 = this.fx.get("pitaya_general_settings", "");
        if (!TextUtils.isEmpty(str14)) {
            try {
                this.rg = new JSONObject(str14);
            } catch (Exception unused2) {
            }
        }
        String str15 = this.fx.get("dl_notification", "");
        if (!TextUtils.isEmpty(str15)) {
            try {
                this.lk = new JSONObject(str15);
            } catch (Exception unused3) {
            }
        }
        String str16 = this.fx.get("live_stream_cof", "");
        if (TextUtils.isEmpty(str16)) {
            str = this.fx.get("volume", "");
            if (!TextUtils.isEmpty(str)) {
            }
            String str17 = this.fx.get("brightness", "");
            if (!TextUtils.isEmpty(str)) {
            }
            String str18 = this.fx.get("video_start", "");
            if (!TextUtils.isEmpty(str)) {
            }
            this.ym = this.fx.get("disable_show_url", 0);
            str2 = this.fx.get("sensor_direction", "");
            if (TextUtils.isEmpty(str2)) {
            }
        } else {
            try {
                this.yb = new JSONObject(str16);
            } catch (Exception e) {
                k.nr("parse exception", "e:" + e.getMessage());
            }
            str = this.fx.get("volume", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.g = new JSONObject(str);
                } catch (Exception unused4) {
                }
            }
            String str172 = this.fx.get("brightness", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.ap = new JSONObject(str172);
                } catch (Exception unused5) {
                }
            }
            String str182 = this.fx.get("video_start", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.kv = new JSONObject(str182);
                } catch (Exception unused6) {
                }
            }
            this.ym = this.fx.get("disable_show_url", 0);
            str2 = this.fx.get("sensor_direction", "");
            if (TextUtils.isEmpty(str2)) {
                try {
                    this.ts = new JSONObject(str2);
                } catch (Exception e2) {
                    k.nr("parse ex", "e:" + e2.getMessage());
                }
                str3 = this.fx.get("pitaya_business_conf", "");
                if (TextUtils.isEmpty(str3)) {
                    try {
                        this.pu = new JSONObject(str3);
                    } catch (Exception e3) {
                        k.nr("parse exception", "e:" + e3.getMessage());
                    }
                    str4 = this.fx.get("http_drop", "");
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            this.dc = new JSONObject(str4);
                        } catch (Exception unused7) {
                        }
                    }
                    this.ua = this.fx.get("stats_batch", 5);
                    this.uq = this.fx.get("switch_audio_focus", 0);
                    this.h = this.fx.get("download_receiver_enable", 1);
                    this.i = this.fx.get("event_switch", this.sf);
                    this.nr = this.fx.get("pre_fetch_cnt", 10);
                    this.mk = this.fx.get("if_both_open", 0);
                    this.f5353jp = this.fx.get("tpl_infos", this.xx);
                    this.sj = this.fx.get("gnd_prefetch_cache_ttl", 0L);
                    this.jc = this.fx.get("gnd_prefetch_cache_size", 5);
                    this.dd = this.fx.get("global_sample", 1.0f);
                    this.v = this.fx.get("app_list_control", 0);
                    this.ki = this.fx.get("max_tpl_cnts", 100);
                    this.hs = this.fx.get("fetch_tpl_timeout_ctrl", 5000);
                    this.te = this.fx.get("interact_show_after_time", 500);
                    this.ti = this.fx.get("fetch_tpl_timeout_ctrl_bad_device", 300);
                    this.gb = this.fx.get("tpl_render_error_rate_h5", 4.5f);
                    this.fn = this.fx.get("tpl_enable_render_timeout_opt", false);
                    this.gl = this.fx.get("tpl_render_error_rate_native", 1.0f);
                    this.wo = this.fx.get("enable", false);
                    this.je = this.fx.get("mid_value", 8.5f);
                    this.ic = this.fx.get("low_value", 7.3f);
                    this.iq = this.fx.get("open_single_abi", false);
                    this.re = this.fx.get("show_callback_mult", 0);
                    this.r = this.fx.get("webview_cache_count", 0);
                    this.uk = this.fx.get("webview_cache_count_v3", 0);
                    this.jn = this.fx.get("webview_render_concurrent_count", 2);
                    this.ad = this.fx.get("policy_url", mx);
                    this.kg = Boolean.valueOf(this.fx.get("use_mediation_map", false));
                    this.eh = this.fx.get("hit_app_list_time", 0L);
                    this.lf.clear();
                    this.z = this.fx.get("apm_pv_config", "");
                    this.hm = this.fx.get("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
                    this.wu = this.fx.get("play_component_ugen_engine_url", "");
                    this.xh = this.fx.get("ad_pkg_info_url", "apps.bytesfield.com");
                    this.zn = this.fx.get("sp_key_if_sp_cache", 1);
                    this.my = this.fx.get("express_gesture_enable", 0);
                    this.sx = this.fx.get("enable_download_proto", 1);
                    this.bg = this.fx.get("main_start_downloader", 0);
                    this.o = this.fx.get("app_express_gesture_priority", -1);
                    this.ln = this.fx.get("splash_close_text", "跳过");
                    this.pb = this.fx.get("network_module", 1);
                    com.bytedance.sdk.component.nr.u.u.u.u().u(this.pb == 2);
                    this.iz = this.fx.get("web_upload_enable", 0);
                    set = this.fx.get("web_upload_content_type", Collections.synchronizedSet(new HashSet()));
                    this.x.clear();
                    if (set != null && set.size() != 0) {
                        it2 = set.iterator();
                        while (it2.hasNext()) {
                            this.x.add(it2.next());
                        }
                    }
                    this.n = this.fx.get("web_upload_send_restowv", 0);
                    this.f5349a = this.fx.get("web_upload_max_single_file", 2);
                    this.jk = this.fx.get("web_upload_max_zip_file", 5);
                    this.s = this.fx.get("web_upload_max_retry", 0);
                    this.l = this.fx.get("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
                    this.mv = this.fx.get("web_upload_storage_type", 0);
                    this.t = this.fx.get("web_upload_report_only_wifi", 0);
                    set2 = this.fx.get("hit_app_list_data", Collections.synchronizedSet(new HashSet()));
                    if (set2 != null && !set2.isEmpty()) {
                        it = set2.iterator();
                        while (it.hasNext()) {
                            this.lf.add(it.next());
                        }
                    }
                    synchronized (this.nb) {
                        this.nb.clear();
                        Set<String> set3 = this.fx.get("scheme_list_data", Collections.synchronizedSet(new HashSet()));
                        if (set3 != null && !set3.isEmpty()) {
                            Iterator<String> it3 = set3.iterator();
                            while (it3.hasNext()) {
                                this.nb.add(it3.next());
                            }
                        }
                    }
                    synchronized (this.gc) {
                        this.gc.clear();
                        Set<String> set4 = this.fx.get("top_scheme_list_data", Collections.synchronizedSet(new HashSet()));
                        if (set4 != null && !set4.isEmpty()) {
                            Iterator<String> it4 = set4.iterator();
                            while (it4.hasNext()) {
                                this.gc.add(it4.next());
                            }
                        }
                    }
                    String str19 = this.fx.get("download_sdk_config", "");
                    this.wi = str19;
                    if (TextUtils.isEmpty(str19)) {
                        str5 = this.fx.get("thread_config", "");
                        if (!TextUtils.isEmpty(str5)) {
                        }
                        this.ky = this.fx.get("call_stack_rate", 0.0f);
                        this.qb = this.fx.get("read_video_from_cache", 1);
                        this.wv = this.fx.get("brand_video_cache_count", 2);
                        this.zu = this.fx.get("enable_bw_screen_detection", false);
                        this.vp = this.fx.get("splash_card_show_max_count", 3);
                        this.rh = com.bytedance.sdk.openadsdk.core.x.nr.u(this.fx.get("clog_config", this.xx));
                        this.bf = com.bytedance.sdk.openadsdk.core.dislike.b.u(this.fx.get("oncall_upload", ""));
                        this.ja = this.fx.get("feedback_opt", 1);
                        this.wq = this.fx.get("check_live_room", false);
                        this.qn = this.fx.get("can_init_live", true);
                        this.fi = this.fx.get("new_app_list", false);
                        str6 = this.fx.get("plugin_update_state", "");
                        if (!TextUtils.isEmpty(str6)) {
                        }
                        str7 = this.fx.get("antispam_autoclick_detect", "");
                        if (!TextUtils.isEmpty(str7)) {
                        }
                        str8 = this.fx.get("plugin_retry_opt", "");
                        if (!TextUtils.isEmpty(str8)) {
                        }
                        str9 = this.fx.get("app_live_config", "");
                        if (!TextUtils.isEmpty(str9)) {
                        }
                        this.en = this.fx.get("pglam_main_enable", 0);
                        this.tq = this.fx.get("pglam_dns_check_enable", 0);
                        this.vk = this.fx.get("pglam_clazz_check", "");
                        this.ol = this.fx.get("ud_enable", 1);
                        this.nu = cn().getInt("is_kv_cache_type", 0);
                        this.ls = cn().getInt("kv_init_type", 0);
                        this.f5352im = this.fx.get("open_dl_type", 0);
                        this.na = this.fx.get("app_dl_scheme_list", "");
                        i = this.fx.get("lp_url_sw", 0);
                        this.la = i;
                        if (i == 1) {
                        }
                        this.ps = cn().getString("md5", "");
                        String string = cn().getString("url", "");
                        this.bo = string;
                        com.bytedance.sdk.openadsdk.core.a.u.b.u.u(this.ps, string);
                        this.ah = this.fx.get("is_open_isw", 1);
                        str10 = this.fx.get("live_sdk_conf", this.xx);
                        if (!TextUtils.isEmpty(str10)) {
                        }
                        this.pn = this.fx.get("npth_enable_type", 0);
                        this.wf = this.fx.get("scheme_get_type", 0);
                        this.bp = this.fx.get("scheme_get_num", 1);
                        this.f5351de = this.fx.get("if_query_all_package", 0);
                        this.az = this.fx.get("is_sp_send_meta", true);
                        this.qv = x.u(this.fx.get("opt_config", ""));
                        this.bv = iz.u(this.fx.get("kv_config", ""));
                        this.uc = this.fx.get("is_first_plugin_resources", false);
                        this.f5354ms = this.fx.get("m_vids_join", 0);
                        this.yy = this.fx.get("mini_event_upload_version", 0);
                        this.is = this.fx.get("bg_web_readd_t", 3000L);
                        this.kd = this.fx.get("title_priority", 0);
                        this.ll = this.fx.get("splash_video_opt_enable", 0);
                        this.dw = this.fx.get("support_live_code", -1);
                        this.hl = this.fx.get("gesture_through_enable", 0);
                        this.hc = this.fx.get("refresh_req_num", 2);
                        this.hj = this.fx.get("refresh_max_times", 1);
                        this.vz = this.fx.get("settings_open", 1);
                        this.it = this.fx.get("shake_trigger_control", 0);
                        this.lc = this.fx.get("preload_switch", false);
                        this.gs = this.fx.get("cache_ana_lru_switch", false);
                        this.ss = this.fx.get("cache_ana_expire_switch", false);
                        this.qj = this.fx.get("preload_time_point", 0);
                        this.ar = this.fx.get("is_adapt_density", true);
                        this.qp = this.fx.get("app_info_cache_switch", false);
                        this.uu = this.fx.get("disable_easy_playable", true);
                        this.ud = this.fx.get("enable_target_34", 1);
                        this.gq = this.fx.get("enable_xm_market", 1);
                        this.ri = this.fx.get("disable_repeat_render", true);
                        this.bb = this.fx.get("status_bar_adapt", 1);
                        this.an = this.fx.get("jump_shield_short_duration", 1000);
                        this.lg = this.fx.get("replace_dummy_video", 1);
                        this.vg = this.fx.get("template_pull_timeout", -1);
                        this.ej = this.fx.get("template_pull_type", 0);
                        this.oi = this.fx.get("view_check_by_window", false);
                        this.kp = this.fx.get("shake_twist_bind_show", false);
                        this.dx = this.fx.get("view_check_by_click", false);
                        this.vm = this.fx.get("node_line_enable", false);
                        this.ox = this.fx.get("node_line_detail_enable", false);
                        this.fq = this.fx.get("enable", true);
                        this.gz = this.fx.get("session_enable", false);
                        t(this.fx.get("lottie_composition_cache_size", 20));
                        mv();
                        this.ga = this.fx.get("endcard_lazy", 0);
                        bf.nr(this.fx);
                        yd.nr(this.fx);
                        com.bytedance.sdk.openadsdk.core.kj.n.u(this.fx);
                        sx.nr(this.fx);
                        d.u(this.fx);
                        ja.u(this.fx);
                        tk.nr(this.fx);
                        str11 = this.fx.get("video_cache_config", "");
                        if (!TextUtils.isEmpty(str11)) {
                        }
                        str12 = this.fx.get("log_rate_conf", "");
                        if (!TextUtils.isEmpty(str12)) {
                        }
                        this.f5350cn = this.fx.get("ad_slot_conf_block", "");
                        jSONObject = new JSONObject(this.f5350cn);
                        if (jSONObject.length() > 0) {
                        }
                        s();
                        com.bytedance.sdk.openadsdk.gi.u.u.u(true);
                    } else {
                        try {
                            this.tk = new JSONObject(this.wi);
                        } catch (JSONException e4) {
                            k.u("TTSdkSettings", e4);
                        }
                        str5 = this.fx.get("thread_config", "");
                        if (!TextUtils.isEmpty(str5)) {
                            try {
                                this.e = new JSONObject(str5);
                                com.bytedance.sdk.openadsdk.core.xg.u.nr();
                            } catch (JSONException e5) {
                                k.u("TTSdkSettings", e5);
                            }
                        }
                        this.ky = this.fx.get("call_stack_rate", 0.0f);
                        this.qb = this.fx.get("read_video_from_cache", 1);
                        this.wv = this.fx.get("brand_video_cache_count", 2);
                        this.zu = this.fx.get("enable_bw_screen_detection", false);
                        this.vp = this.fx.get("splash_card_show_max_count", 3);
                        this.rh = com.bytedance.sdk.openadsdk.core.x.nr.u(this.fx.get("clog_config", this.xx));
                        this.bf = com.bytedance.sdk.openadsdk.core.dislike.b.u(this.fx.get("oncall_upload", ""));
                        this.ja = this.fx.get("feedback_opt", 1);
                        this.wq = this.fx.get("check_live_room", false);
                        this.qn = this.fx.get("can_init_live", true);
                        this.fi = this.fx.get("new_app_list", false);
                        str6 = this.fx.get("plugin_update_state", "");
                        if (!TextUtils.isEmpty(str6)) {
                            try {
                                this.dr = new JSONObject(str6);
                            } catch (JSONException unused8) {
                            }
                        }
                        str7 = this.fx.get("antispam_autoclick_detect", "");
                        if (!TextUtils.isEmpty(str7)) {
                            try {
                                this.al = new JSONObject(str7);
                                com.bytedance.sdk.component.b.u uVarNr = kj.nr();
                                if (uVarNr != null) {
                                    uVarNr.updateHARSettings(this.al);
                                }
                            } catch (JSONException unused9) {
                            }
                        }
                        str8 = this.fx.get("plugin_retry_opt", "");
                        if (!TextUtils.isEmpty(str8)) {
                            try {
                                this.ir = new JSONObject(str8);
                            } catch (JSONException unused10) {
                            }
                        }
                        str9 = this.fx.get("app_live_config", "");
                        if (!TextUtils.isEmpty(str9)) {
                            try {
                                this.up = nr.u(new JSONObject(str9));
                            } catch (JSONException unused11) {
                            }
                        }
                        this.en = this.fx.get("pglam_main_enable", 0);
                        this.tq = this.fx.get("pglam_dns_check_enable", 0);
                        this.vk = this.fx.get("pglam_clazz_check", "");
                        this.ol = this.fx.get("ud_enable", 1);
                        this.nu = cn().getInt("is_kv_cache_type", 0);
                        this.ls = cn().getInt("kv_init_type", 0);
                        this.f5352im = this.fx.get("open_dl_type", 0);
                        this.na = this.fx.get("app_dl_scheme_list", "");
                        i = this.fx.get("lp_url_sw", 0);
                        this.la = i;
                        if (i == 1) {
                            this.db = qj().get("lp_list", "");
                        }
                        this.ps = cn().getString("md5", "");
                        String string2 = cn().getString("url", "");
                        this.bo = string2;
                        com.bytedance.sdk.openadsdk.core.a.u.b.u.u(this.ps, string2);
                        this.ah = this.fx.get("is_open_isw", 1);
                        str10 = this.fx.get("live_sdk_conf", this.xx);
                        if (!TextUtils.isEmpty(str10)) {
                            this.dj = y.u(str10);
                        }
                        this.pn = this.fx.get("npth_enable_type", 0);
                        this.wf = this.fx.get("scheme_get_type", 0);
                        this.bp = this.fx.get("scheme_get_num", 1);
                        this.f5351de = this.fx.get("if_query_all_package", 0);
                        this.az = this.fx.get("is_sp_send_meta", true);
                        this.qv = x.u(this.fx.get("opt_config", ""));
                        this.bv = iz.u(this.fx.get("kv_config", ""));
                        this.uc = this.fx.get("is_first_plugin_resources", false);
                        this.f5354ms = this.fx.get("m_vids_join", 0);
                        this.yy = this.fx.get("mini_event_upload_version", 0);
                        this.is = this.fx.get("bg_web_readd_t", 3000L);
                        this.kd = this.fx.get("title_priority", 0);
                        this.ll = this.fx.get("splash_video_opt_enable", 0);
                        this.dw = this.fx.get("support_live_code", -1);
                        this.hl = this.fx.get("gesture_through_enable", 0);
                        this.hc = this.fx.get("refresh_req_num", 2);
                        this.hj = this.fx.get("refresh_max_times", 1);
                        this.vz = this.fx.get("settings_open", 1);
                        this.it = this.fx.get("shake_trigger_control", 0);
                        this.lc = this.fx.get("preload_switch", false);
                        this.gs = this.fx.get("cache_ana_lru_switch", false);
                        this.ss = this.fx.get("cache_ana_expire_switch", false);
                        this.qj = this.fx.get("preload_time_point", 0);
                        this.ar = this.fx.get("is_adapt_density", true);
                        this.qp = this.fx.get("app_info_cache_switch", false);
                        this.uu = this.fx.get("disable_easy_playable", true);
                        this.ud = this.fx.get("enable_target_34", 1);
                        this.gq = this.fx.get("enable_xm_market", 1);
                        this.ri = this.fx.get("disable_repeat_render", true);
                        this.bb = this.fx.get("status_bar_adapt", 1);
                        this.an = this.fx.get("jump_shield_short_duration", 1000);
                        this.lg = this.fx.get("replace_dummy_video", 1);
                        this.vg = this.fx.get("template_pull_timeout", -1);
                        this.ej = this.fx.get("template_pull_type", 0);
                        this.oi = this.fx.get("view_check_by_window", false);
                        this.kp = this.fx.get("shake_twist_bind_show", false);
                        this.dx = this.fx.get("view_check_by_click", false);
                        this.vm = this.fx.get("node_line_enable", false);
                        this.ox = this.fx.get("node_line_detail_enable", false);
                        this.fq = this.fx.get("enable", true);
                        this.gz = this.fx.get("session_enable", false);
                        t(this.fx.get("lottie_composition_cache_size", 20));
                        mv();
                        this.ga = this.fx.get("endcard_lazy", 0);
                        bf.nr(this.fx);
                        yd.nr(this.fx);
                        com.bytedance.sdk.openadsdk.core.kj.n.u(this.fx);
                        sx.nr(this.fx);
                        d.u(this.fx);
                        ja.u(this.fx);
                        tk.nr(this.fx);
                        str11 = this.fx.get("video_cache_config", "");
                        if (!TextUtils.isEmpty(str11)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(str11);
                                this.bl = jSONObject2;
                                com.bykv.vk.openvk.component.video.u.u.u(jSONObject2);
                            } catch (JSONException unused12) {
                            }
                        }
                        str12 = this.fx.get("log_rate_conf", "");
                        if (!TextUtils.isEmpty(str12)) {
                            try {
                                this.jf = new JSONObject(str12);
                            } catch (Exception unused13) {
                            }
                        }
                        try {
                            this.f5350cn = this.fx.get("ad_slot_conf_block", "");
                            jSONObject = new JSONObject(this.f5350cn);
                            if (jSONObject.length() > 0) {
                                this.ng.clear();
                                Iterator<String> itKeys = jSONObject.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    this.ng.put(next, jSONObject.opt(next));
                                }
                            }
                        } catch (Exception unused14) {
                        }
                        s();
                        com.bytedance.sdk.openadsdk.gi.u.u.u(true);
                    }
                } else {
                    str4 = this.fx.get("http_drop", "");
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    this.ua = this.fx.get("stats_batch", 5);
                    this.uq = this.fx.get("switch_audio_focus", 0);
                    this.h = this.fx.get("download_receiver_enable", 1);
                    this.i = this.fx.get("event_switch", this.sf);
                    this.nr = this.fx.get("pre_fetch_cnt", 10);
                    this.mk = this.fx.get("if_both_open", 0);
                    this.f5353jp = this.fx.get("tpl_infos", this.xx);
                    this.sj = this.fx.get("gnd_prefetch_cache_ttl", 0L);
                    this.jc = this.fx.get("gnd_prefetch_cache_size", 5);
                    this.dd = this.fx.get("global_sample", 1.0f);
                    this.v = this.fx.get("app_list_control", 0);
                    this.ki = this.fx.get("max_tpl_cnts", 100);
                    this.hs = this.fx.get("fetch_tpl_timeout_ctrl", 5000);
                    this.te = this.fx.get("interact_show_after_time", 500);
                    this.ti = this.fx.get("fetch_tpl_timeout_ctrl_bad_device", 300);
                    this.gb = this.fx.get("tpl_render_error_rate_h5", 4.5f);
                    this.fn = this.fx.get("tpl_enable_render_timeout_opt", false);
                    this.gl = this.fx.get("tpl_render_error_rate_native", 1.0f);
                    this.wo = this.fx.get("enable", false);
                    this.je = this.fx.get("mid_value", 8.5f);
                    this.ic = this.fx.get("low_value", 7.3f);
                    this.iq = this.fx.get("open_single_abi", false);
                    this.re = this.fx.get("show_callback_mult", 0);
                    this.r = this.fx.get("webview_cache_count", 0);
                    this.uk = this.fx.get("webview_cache_count_v3", 0);
                    this.jn = this.fx.get("webview_render_concurrent_count", 2);
                    this.ad = this.fx.get("policy_url", mx);
                    this.kg = Boolean.valueOf(this.fx.get("use_mediation_map", false));
                    this.eh = this.fx.get("hit_app_list_time", 0L);
                    this.lf.clear();
                    this.z = this.fx.get("apm_pv_config", "");
                    this.hm = this.fx.get("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
                    this.wu = this.fx.get("play_component_ugen_engine_url", "");
                    this.xh = this.fx.get("ad_pkg_info_url", "apps.bytesfield.com");
                    this.zn = this.fx.get("sp_key_if_sp_cache", 1);
                    this.my = this.fx.get("express_gesture_enable", 0);
                    this.sx = this.fx.get("enable_download_proto", 1);
                    this.bg = this.fx.get("main_start_downloader", 0);
                    this.o = this.fx.get("app_express_gesture_priority", -1);
                    this.ln = this.fx.get("splash_close_text", "跳过");
                    this.pb = this.fx.get("network_module", 1);
                    com.bytedance.sdk.component.nr.u.u.u.u().u(this.pb == 2);
                    this.iz = this.fx.get("web_upload_enable", 0);
                    set = this.fx.get("web_upload_content_type", Collections.synchronizedSet(new HashSet()));
                    this.x.clear();
                    if (set != null) {
                        it2 = set.iterator();
                        while (it2.hasNext()) {
                        }
                    }
                    this.n = this.fx.get("web_upload_send_restowv", 0);
                    this.f5349a = this.fx.get("web_upload_max_single_file", 2);
                    this.jk = this.fx.get("web_upload_max_zip_file", 5);
                    this.s = this.fx.get("web_upload_max_retry", 0);
                    this.l = this.fx.get("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
                    this.mv = this.fx.get("web_upload_storage_type", 0);
                    this.t = this.fx.get("web_upload_report_only_wifi", 0);
                    set2 = this.fx.get("hit_app_list_data", Collections.synchronizedSet(new HashSet()));
                    if (set2 != null) {
                        it = set2.iterator();
                        while (it.hasNext()) {
                        }
                    }
                    synchronized (this.nb) {
                    }
                }
            } else {
                str3 = this.fx.get("pitaya_business_conf", "");
                if (TextUtils.isEmpty(str3)) {
                }
            }
        }
    }

    public JSONObject ua() {
        return this.yb;
    }

    public boolean uc() {
        return this.ar;
    }

    public boolean uk() {
        if (this.hl == Integer.MAX_VALUE) {
            this.hl = nr().get("gesture_through_enable", 0);
        }
        return this.hl == 1;
    }

    public boolean uo() {
        if (this.ol == 1) {
            this.ol = nr().get("ud_enable", 1);
        }
        return this.ol == 1;
    }

    public int up() {
        return this.an;
    }

    public boolean uq() {
        return com.bytedance.sdk.openadsdk.core.fx.pn.u().n();
    }

    public Set<String> v() {
        Set<String> set;
        if (this.x.isEmpty() && (set = nr().get("web_upload_content_type", Collections.synchronizedSet(new HashSet()))) != null && set.size() != 0) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                this.x.add(it.next());
            }
        }
        return this.x;
    }

    public int vk() {
        if (this.ud == Integer.MAX_VALUE) {
            this.ud = nr().get("enable_target_34", 1);
        }
        return this.ud;
    }

    public boolean vp() {
        if (this.re == Integer.MAX_VALUE) {
            this.re = nr().get("show_callback_mult", 0);
        }
        return this.re == 1;
    }

    public boolean vz() {
        return com.bytedance.sdk.openadsdk.core.d.x() && this.ah == 1;
    }

    public boolean w() {
        if (this.d == Integer.MAX_VALUE) {
            this.d = nr().get("opt_show_check", 0);
        }
        return this.d == 1;
    }

    public boolean wf() {
        if (!this.fn) {
            this.fn = nr().get("tpl_enable_render_timeout_opt", false);
        }
        return this.fn;
    }

    public String wi() {
        if (TextUtils.isEmpty(this.cj)) {
            this.cj = nr().get("xpath", "");
        }
        return this.cj;
    }

    public boolean wj() {
        return this.wf != 1;
    }

    public boolean wo() {
        return this.ss;
    }

    public boolean wq() {
        if (this.zx == this.ob) {
            this.zx = nr().get("enable_dl_ext", this.ob);
        }
        return this.zx == 1;
    }

    public boolean wu() {
        return Build.VERSION.SDK_INT < this.yy;
    }

    public Set<String> wv() {
        if (this.gc.size() == 0) {
            return null;
        }
        return this.gc;
    }

    public boolean xg() {
        if (this.h == Integer.MAX_VALUE) {
            this.h = nr().get("download_receiver_enable", 1);
        }
        return this.h != 0;
    }

    public long xh() {
        if (this.is == 2147483647L) {
            this.is = nr().get("bg_web_readd_t", 3000L);
        }
        return this.is;
    }

    public boolean xw() {
        if (this.ge == Integer.MAX_VALUE) {
            this.ge = nr().get("enable_glgpu", 0);
        }
        return this.ge == 1;
    }

    public boolean xx() {
        return this.cb;
    }

    public int y() {
        if (this.nr == 10) {
            this.nr = nr().get("pre_fetch_cnt", 10);
        }
        return this.nr;
    }

    public float yb() {
        if (this.ic == 0.0f) {
            this.ic = nr().get("low_value", 7.3f);
        }
        return this.ic;
    }

    public float yd() {
        if (this.ky < 0.0f) {
            this.ky = nr().get("call_stack_rate", 0.0f);
        }
        return this.ky;
    }

    public String yf() {
        if (TextUtils.isEmpty(this.bo)) {
            this.bo = cn().getString("url", "");
        }
        return this.bo;
    }

    public float ym() {
        if (this.gl == 0.0f) {
            this.gl = nr().get("tpl_render_error_rate_native", 1.0f);
        }
        return this.gl;
    }

    public synchronized boolean yy() {
        if (!mw) {
            yk = nr().get("disable_easy_playable", true);
            mw = true;
        }
        return yk;
    }

    public void z() {
        this.df = "api-access.pangolin-sdk-toutiao-b.com";
    }

    public com.bytedance.sdk.openadsdk.core.sx.u.u za() {
        if (this.yd == null) {
            this.yd = com.bytedance.sdk.openadsdk.core.sx.u.u.u(nr().get("white_check_config", ""));
        }
        return this.yd;
    }

    public boolean zn() {
        if (this.kd == Integer.MAX_VALUE) {
            this.kd = nr().get("title_priority", 0);
        }
        return this.kd == 1;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.b zq() {
        return this.bf;
    }

    public boolean zu() {
        return this.iq;
    }

    public String zx() {
        if (TextUtils.isEmpty(this.z)) {
            this.z = nr().get("apm_pv_config", "");
        }
        return this.z;
    }

    private static u b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("code_id");
        boolean zU = h.u(jSONObject, "enable_bidding_cache", false);
        long jU = h.u(jSONObject, "bidding_cache_skip_time", 0L);
        boolean zU2 = h.u(jSONObject, "enable_bidding_pre_fetch", false);
        int iU = h.u(jSONObject, "auto_play", 1);
        int iU2 = h.u(jSONObject, "rv_preload", 2);
        int iU3 = h.u(jSONObject, "nv_preload", 1);
        int iU4 = h.u(jSONObject, "sp_preload", 0);
        int iU5 = h.u(jSONObject, "skip_time_displayed", 0);
        int iU6 = h.u(jSONObject, "reg_creative_control", 1);
        int iU7 = h.u(jSONObject, "rv_skip_time", 0);
        int iU8 = h.u(jSONObject, "iv_skip_time", 0);
        int iU9 = h.u(jSONObject, "stop_time", TTAdConstant.STYLE_SIZE_RADIO_3_2);
        boolean zU3 = h.u(jSONObject, "close_on_click", false);
        int iU10 = h.u(jSONObject, "splash_load_type", 2);
        int iU11 = h.u(jSONObject, "splash_buffer_time", 100);
        int iU12 = h.u(jSONObject, "time_out_control", 2000);
        int iU13 = h.u(jSONObject, "time_out_control_type", 0);
        int iU14 = h.u(jSONObject, "slot_type", -1);
        return u.u().u(strOptString).n(iU).a(iU2).jk(iU3).t(iU5).l(iU6).iz(iU7).b(iU4).pn(iU9).fx(iU12).mv(iU10).s(iU11).x(iU8).fx(zU3).k(iU13).u(jU).nr(zU).u(zU2).nr(iU14).u(h.u(jSONObject, "refresh_rit_sw", 0));
    }

    private void iz(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.iz = 0;
            this.x.clear();
            this.n = 0;
            this.f5349a = 2;
            this.jk = 5;
            this.s = 0;
            this.l = "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/";
            this.mv = 0;
            this.t = 0;
            return;
        }
        this.iz = jSONObject.optInt("enable", 0);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ActionUtils.CONTENT_TYPE);
        this.x.clear();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    this.x.add(strOptString);
                }
            }
        }
        this.n = jSONObject.optInt("send_response_to_webview", 0);
        this.f5349a = jSONObject.optInt("max_report_size_single", 2);
        this.jk = jSONObject.optInt("max_report_size_total", 5);
        this.s = jSONObject.optInt("max_report_times", 0);
        this.l = jSONObject.optString("report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
        this.mv = jSONObject.optInt("storage_type", 0);
        this.t = jSONObject.optInt("report_only_wifi_enable", 0);
    }

    private void pn(JSONObject jSONObject) {
        Object objRemove = jSONObject.remove("ad_slot_conf_list");
        Object objRemove2 = jSONObject.remove("ad_slot_conf_block");
        String string = jSONObject.toString();
        try {
            jSONObject.putOpt("ad_slot_conf_list", objRemove);
            jSONObject.putOpt("ad_slot_conf_block", objRemove2);
            this.mf = new JSONObject(string);
            nr().put("settings_json_str", com.bytedance.sdk.component.utils.u.nr(string));
        } catch (JSONException unused) {
        }
    }

    private int x(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("splash_check_type", 1);
        this.ay = iOptInt;
        if (iOptInt == 0 || iOptInt == 1) {
            return iOptInt;
        }
        return 1;
    }

    public boolean bg() {
        if (this.kj == Integer.MIN_VALUE) {
            this.kj = nr().get("player_stats_check_switch", 1);
        }
        return this.kj == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pb.pn
    public void fx(final JSONObject jSONObject) {
        pn(jSONObject);
        this.hm = u(jSONObject, "dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        this.wu = jSONObject.optString("play_component_ugen_engine_url", "");
        this.df = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
        this.zq = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
        this.cj = jSONObject.optString("xpath");
        this.oa = jSONObject.optJSONObject("digest");
        this.w = jSONObject.optLong("data_time");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("feq_policy");
        pn.nr nrVar = new pn.nr();
        if (jSONObjectOptJSONObject != null) {
            nrVar.u(jSONObjectOptJSONObject.optLong("duration") * 1000);
            nrVar.u(jSONObjectOptJSONObject.optInt("max"));
            nrVar.u((float) jSONObjectOptJSONObject.optDouble("agg_multiple"));
        }
        this.tr = jSONObject.optInt("vbtt", 5);
        this.ex = jSONObject.optInt("fetch_tpl_interval", 3600);
        this.ad = jSONObject.optString("privacy_url", mx);
        this.kg = Boolean.valueOf(jSONObject.optBoolean("use_mediation_map"));
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("abtest");
        if (jSONObjectOptJSONObject2 != null) {
            nrVar.u(jSONObjectOptJSONObject2.optString("version"));
            nrVar.nr(jSONObjectOptJSONObject2.optString(RemoteMessageConst.MessageBody.PARAM));
        } else {
            com.bytedance.sdk.openadsdk.core.fx.pn.u().x();
        }
        this.qb = jSONObject.optInt("read_video_from_cache", 1);
        this.zu = jSONObject.optBoolean("enable_bw_screen_detection", false);
        iz(jSONObject.optJSONObject("web_upload"));
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("log_rate_conf");
        this.jf = jSONObjectOptJSONObject3;
        if (jSONObjectOptJSONObject3 != null) {
            this.dd = (float) jSONObjectOptJSONObject3.optDouble("global_sample", 1.0d);
            if (this.jf.has("call_stack_rate")) {
                this.ky = (float) this.jf.optDouble("call_stack_rate");
            } else {
                this.ky = this.dd;
            }
        } else {
            this.dd = 1.0f;
        }
        this.su = jSONObject.optString("pyload_h5");
        this.mh = pb.u(jSONObject.optJSONObject("insert_js_config"));
        this.ay = x(jSONObject);
        k.nr("splashLoad", "setting-》mSplashCheckType=" + this.ay);
        this.mk = jSONObject.optInt("if_both_open", 0);
        this.p = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
        this.v = jSONObject.optInt("al", 1);
        this.ki = jSONObject.optInt("max_tpl_cnts", 100);
        com.bytedance.sdk.openadsdk.core.fx.fx.u().u(jSONObject);
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject4 != null) {
            this.wj = jSONObjectOptJSONObject4.optString("stats_url", "api-access.pangolin-sdk-toutiao1.com");
            this.md = jSONObjectOptJSONObject4.optInt("mini_game_preload", 1);
            this.ec = jSONObjectOptJSONObject4.optString("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
            this.pq = jSONObjectOptJSONObject4.optBoolean("enable_apm_pv", false);
            this.iq = jSONObjectOptJSONObject4.optBoolean("open_single_abi", false);
            this.re = jSONObjectOptJSONObject4.optBoolean("show_callback_mult", false) ? 1 : 0;
            this.hs = jSONObjectOptJSONObject4.optInt("fetch_tpl_timeout_ctrl", 5000);
            this.te = jSONObjectOptJSONObject4.optInt("interact_show_after_time", 500);
            this.ti = jSONObjectOptJSONObject4.optInt("fetch_tpl_timeout_ctrl_bad_device", 300);
            this.gb = (float) jSONObjectOptJSONObject4.optDouble("tpl_render_error_rate_h5", 4.5d);
            this.gl = (float) jSONObjectOptJSONObject4.optDouble("tpl_render_error_rate_native", 1.0d);
            this.fn = jSONObjectOptJSONObject4.optBoolean("tpl_enable_render_timeout_opt", false);
            String strOptString = jSONObjectOptJSONObject4.optString("tpl_timeout_ctrl");
            if (!TextUtils.isEmpty(strOptString)) {
                this.fa = bq.fx(strOptString);
            }
            this.zn = jSONObjectOptJSONObject4.optInt("if_sp_cache", 1);
            nrVar.u(jSONObjectOptJSONObject4.optBoolean("is_spl_cache_remove_change", false));
            this.my = jSONObjectOptJSONObject4.optInt("express_gesture_enable", 0);
            this.sx = jSONObjectOptJSONObject4.optInt("enable_download_proto", 1);
            this.bg = jSONObjectOptJSONObject4.optInt("main_start_downloader", 0);
            this.o = jSONObjectOptJSONObject4.optInt("app_express_gesture_priority", -1);
            this.r = jSONObjectOptJSONObject4.optInt("webview_cache_count", 0);
            this.uk = jSONObjectOptJSONObject4.optInt("webview_cache_count_v3", 0);
            this.jn = jSONObjectOptJSONObject4.optInt("webview_render_concurrent_count", 2);
            this.xh = jSONObjectOptJSONObject4.optString("ad_pkg_info_url", "apps.bytesfield.com");
            this.ln = jSONObjectOptJSONObject4.optString("splash_close_text", "跳过");
            this.pb = jSONObjectOptJSONObject4.optInt("network_module", 1);
            nrVar.nr(jSONObjectOptJSONObject4.optInt("cypher_version", 40001));
            com.bytedance.sdk.component.nr.u.u.u.u().u(this.pb != 2);
            this.tm = jSONObjectOptJSONObject4.optInt("adlog_debug", 0);
            this.f = jSONObjectOptJSONObject4.optInt("adlog_batch", 10);
            this.kw = jSONObjectOptJSONObject4.optLong("adlog_interval", 5000L);
            this.k = jSONObjectOptJSONObject4.optInt("enable_kite", 0);
            this.za = jSONObjectOptJSONObject4.optInt("adlog_exception_batch", 100);
            this.rv = jSONObjectOptJSONObject4.optInt("adlog_monitor", 1);
            this.q = jSONObjectOptJSONObject4.optInt("enable_ttvideo", -1);
            this.qq = jSONObjectOptJSONObject4.optInt("enable_zaid", 0);
            this.kj = jSONObjectOptJSONObject4.optInt("player_stats_check_switch", 1);
            this.bq = jSONObjectOptJSONObject4.optInt("enable_cdn_opt", 0);
            this.c = jSONObjectOptJSONObject4.optInt("download_button_effect", 0);
            this.jw = jSONObjectOptJSONObject4.optLong("ext_use_type", this.ju);
            this.ge = jSONObjectOptJSONObject4.optInt("enable_glgpu", 0);
            this.zx = jSONObjectOptJSONObject4.optInt("enable_dl_ext", this.ob);
            this.h = jSONObjectOptJSONObject4.optInt("download_receiver_enable", 1);
            this.u = jSONObjectOptJSONObject4.optInt("launch_strategy", 0);
            this.gi = jSONObjectOptJSONObject4.optInt("dl_popup_duration", 1000);
            this.d = jSONObjectOptJSONObject4.optInt("opt_show_check", 0);
            this.it = jSONObjectOptJSONObject4.optInt("shake_trigger_control", 0);
            this.rg = jSONObjectOptJSONObject4.optJSONObject("pitaya_general_settings");
            this.dc = jSONObjectOptJSONObject4.optJSONObject("http_drop");
            this.ua = jSONObjectOptJSONObject4.optInt("stats_batch", 5);
            this.yb = jSONObjectOptJSONObject4.optJSONObject("live_stream_cof");
            this.lk = jSONObjectOptJSONObject4.optJSONObject("dl_notification");
            this.ym = jSONObjectOptJSONObject4.optInt("disable_show_url", 0);
            this.g = jSONObjectOptJSONObject4.optJSONObject("volume");
            this.ap = jSONObjectOptJSONObject4.optJSONObject("brightness");
            this.kv = jSONObjectOptJSONObject4.optJSONObject("video_start");
            this.ts = jSONObjectOptJSONObject4.optJSONObject("sensor_direction");
            this.pu = jSONObjectOptJSONObject4.optJSONObject("pitaya_business_conf");
            nrVar.fx(jSONObjectOptJSONObject4.optInt("spl_cache_conf", 14));
            nrVar.b(jSONObjectOptJSONObject4.optInt("spl_thread_conf", 1));
            nrVar.pn(jSONObjectOptJSONObject4.optInt("spl_common_conf", 0));
            nrVar.iz(jSONObjectOptJSONObject4.optInt("spl_cache_expired", 0));
            nrVar.fx(jSONObjectOptJSONObject4.optString("drop_cache_black_conf", ""));
            nrVar.u(this.pu);
            nrVar.x(jSONObjectOptJSONObject4.optInt("splash_render_timeout_backup", 100));
            JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("client_intelligence_conf");
            if (jSONObjectOptJSONObject5 != null) {
                this.sv = jSONObjectOptJSONObject5.optBoolean("net_rating");
                this.yf = jSONObjectOptJSONObject5.optJSONObject("net_rating_config");
                this.ba = jSONObjectOptJSONObject5.optBoolean("device_rating");
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("bytebench_rating");
            if (jSONObjectOptJSONObject6 != null) {
                this.wo = jSONObjectOptJSONObject6.optBoolean("enable");
                this.je = (float) jSONObjectOptJSONObject6.optDouble("mid_value");
                this.ic = (float) jSONObjectOptJSONObject6.optDouble("low_value");
            }
            this.fq = true;
            this.uo.add(1);
            this.uo.add(3);
            this.uo.add(5);
            this.gz = true;
            JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject4.optJSONObject("realtime_feature");
            if (jSONObjectOptJSONObject7 != null) {
                this.fq = jSONObjectOptJSONObject7.optBoolean("enable", true);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject7.optJSONArray("time_window");
                this.uo.clear();
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        this.uo.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
                    }
                } else {
                    this.uo.add(1);
                    this.uo.add(3);
                    this.uo.add(5);
                }
                this.gz = jSONObjectOptJSONObject7.optBoolean("session_enable", false);
            }
            this.i = jSONObjectOptJSONObject4.optInt("event_switch", this.sf);
            this.uq = jSONObjectOptJSONObject4.optInt("switch_audio_focus", 0);
            this.z = jSONObjectOptJSONObject4.optString("apm_pv_config", "");
            this.vp = jSONObjectOptJSONObject4.optInt("splash_card_show_max_count", 3);
            this.nr = jSONObjectOptJSONObject4.optInt("pre_fetch_cnt", 10);
            this.jc = jSONObjectOptJSONObject4.optInt("gnd_prefetch_cache_size", 5);
            this.sj = jSONObjectOptJSONObject4.optLong("gnd_prefetch_cache_ttl", 0L);
            this.yd = com.bytedance.sdk.openadsdk.core.sx.u.u.u(jSONObjectOptJSONObject4.optJSONObject("white_check_config"));
            this.wf = jSONObjectOptJSONObject4.optInt("scheme_get_type", 0);
            this.bp = jSONObjectOptJSONObject4.optInt("scheme_get_num", 1);
            this.f5351de = jSONObjectOptJSONObject4.optInt("if_query_all_package", 0);
            this.rh = com.bytedance.sdk.openadsdk.core.x.nr.u(jSONObjectOptJSONObject4.optJSONObject("clog_config"));
            this.bf = com.bytedance.sdk.openadsdk.core.dislike.b.u(jSONObjectOptJSONObject4.optJSONObject("oncall_upload"));
            this.ja = jSONObjectOptJSONObject4.optInt("feedback_opt", 1);
            this.wq = jSONObjectOptJSONObject4.optBoolean("check_live_room", false);
            JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject4.optJSONObject("pglam");
            if (jSONObjectOptJSONObject8 != null) {
                this.en = jSONObjectOptJSONObject8.optInt("pglam_main_enable", 0);
                this.tq = jSONObjectOptJSONObject8.optInt("pglam_dns_check_enable", 0);
                this.vk = jSONObjectOptJSONObject8.optString("pglam_clazz_check", "");
            }
            this.ol = jSONObjectOptJSONObject4.optInt("ud_enable", 1);
            this.e = jSONObjectOptJSONObject4.optJSONObject("thread_config");
            com.bytedance.sdk.openadsdk.core.xg.u.nr();
            this.fi = jSONObjectOptJSONObject4.optBoolean("new_app_list", false);
            this.up = nr.u(jSONObjectOptJSONObject4.optJSONObject("app_live_config"));
            this.dr = jSONObjectOptJSONObject4.optJSONObject("plugin_update_state");
            this.al = jSONObjectOptJSONObject4.optJSONObject("antispam_autoclick_detect");
            com.bytedance.sdk.component.b.u uVarNr = kj.nr();
            if (uVarNr != null) {
                uVarNr.updateHARSettings(this.al);
            }
            this.ah = jSONObjectOptJSONObject4.optInt("is_open_isw", 1);
            this.nu = jSONObjectOptJSONObject4.optInt("is_kv_cache_type", 0);
            this.ls = jSONObjectOptJSONObject4.optInt("kv_init_type", 0);
            this.f5352im = jSONObjectOptJSONObject4.optInt("open_dl_type", 0);
            this.na = jSONObjectOptJSONObject4.optString("app_dl_scheme_list", "");
            int iOptInt = jSONObjectOptJSONObject4.optInt("lp_url_sw", 0);
            this.la = iOptInt;
            if (iOptInt == 1) {
                this.db = jSONObjectOptJSONObject4.optString("lp_list", "");
            }
            JSONObject jSONObjectOptJSONObject9 = jSONObjectOptJSONObject4.optJSONObject("uchain");
            if (jSONObjectOptJSONObject9 != null) {
                String strOptString2 = jSONObjectOptJSONObject9.optString("md5", "");
                String strOptString3 = jSONObjectOptJSONObject9.optString("url", "");
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                    this.ps = strOptString2;
                    this.bo = strOptString3;
                }
            }
            com.bytedance.sdk.openadsdk.core.a.u.b.u.u(this.ps, this.bo);
            this.f5354ms = jSONObjectOptJSONObject4.optInt("m_vids_join", 0);
            this.yy = jSONObjectOptJSONObject4.optInt("mini_event_upload_version", 0);
            this.is = jSONObjectOptJSONObject4.optLong("bg_web_readd_t", 3000L);
            this.kd = jSONObjectOptJSONObject4.optInt("title_priority", 0);
            this.ll = jSONObjectOptJSONObject4.optInt("splash_video_opt_enable", 0);
            this.dw = jSONObjectOptJSONObject4.optInt("support_live_code", -1);
            this.hl = jSONObjectOptJSONObject4.optInt("gesture_through_enable", 0);
            this.hc = jSONObjectOptJSONObject4.optInt("refresh_req_num", 2);
            this.hj = jSONObjectOptJSONObject4.optInt("refresh_max_times", 1);
            cn().edit().putBoolean("_use_pl_", jSONObjectOptJSONObject4.optBoolean("_use_pl_", false)).apply();
            this.pn = jSONObjectOptJSONObject4.optInt("npth_enable_type", 0);
            this.az = jSONObjectOptJSONObject4.optBoolean("is_sp_send_meta", true);
            this.qv = x.u(jSONObjectOptJSONObject4.optString("opt_config"));
            this.bv = iz.u(jSONObjectOptJSONObject4.optString("kv_config"));
            this.lc = jSONObjectOptJSONObject4.optBoolean("preload_switch", false);
            this.gs = jSONObjectOptJSONObject4.optBoolean("cache_ana_lru_switch", false);
            this.ss = jSONObjectOptJSONObject4.optBoolean("cache_ana_expire_switch", false);
            this.qj = jSONObjectOptJSONObject4.optInt("preload_time_point", 0);
            this.ar = jSONObjectOptJSONObject4.optBoolean("is_adapt_density", true);
            this.uu = jSONObjectOptJSONObject4.optBoolean("disable_easy_playable", true);
            this.ud = jSONObjectOptJSONObject4.optInt("enable_target_34", 1);
            this.gq = jSONObjectOptJSONObject4.optInt("enable_xm_market", 1);
            this.qp = jSONObjectOptJSONObject4.optBoolean("app_info_cache_switch", false);
            this.ri = jSONObjectOptJSONObject4.optBoolean("disable_repeat_render", true);
            this.bb = jSONObjectOptJSONObject4.optInt("status_bar_adapt", 1);
            this.an = jSONObjectOptJSONObject4.optInt("jump_shield_short_duration", 1000);
            this.lg = jSONObjectOptJSONObject4.optInt("replace_dummy_video", 1);
            this.vg = jSONObjectOptJSONObject4.optInt("template_pull_timeout", -1);
            this.ej = jSONObjectOptJSONObject4.optInt("template_pull_type", 0);
            JSONObject jSONObjectOptJSONObject10 = jSONObjectOptJSONObject4.optJSONObject("view_report_opt");
            if (jSONObjectOptJSONObject10 != null) {
                this.oi = jSONObjectOptJSONObject10.optBoolean("view_check_by_window", false);
                this.kp = jSONObjectOptJSONObject10.optBoolean("shake_twist_bind_show", false);
                this.dx = jSONObjectOptJSONObject10.optBoolean("view_check_by_click", false);
            }
            JSONObject jSONObjectOptJSONObject11 = jSONObjectOptJSONObject4.optJSONObject("tt_csj_lifecycle_opt");
            if (jSONObjectOptJSONObject11 != null) {
                this.vm = jSONObjectOptJSONObject11.optBoolean("node_line_enable", false);
                this.ox = jSONObjectOptJSONObject11.optBoolean("node_line_detail_enable", false);
            }
            xg.u();
            this.uc = jSONObjectOptJSONObject4.optBoolean("is_first_plugin_resources", false);
            int iOptInt2 = jSONObjectOptJSONObject4.optInt("open_webview_count");
            MultiWebview.setMaxWebViewCount(iOptInt2);
            nr().put("open_webview_count", iOptInt2);
            new com.bytedance.sdk.openadsdk.core.pb.u.nr().u(jSONObjectOptJSONObject4);
            int iOptInt3 = jSONObjectOptJSONObject4.optInt("lottie_composition_cache_size", 20);
            t(iOptInt3);
            nr().put("lottie_composition_cache_size", iOptInt3);
            JSONObject jSONObjectOptJSONObject12 = jSONObjectOptJSONObject4.optJSONObject("video_opt");
            if (jSONObjectOptJSONObject12 != null) {
                this.nz = jSONObjectOptJSONObject12.optInt("video_size_gap_report", 0);
                nr().put("video_size_gap_report", this.nz);
            }
            JSONObject jSONObjectOptJSONObject13 = jSONObjectOptJSONObject4.optJSONObject("req_exemption_cfg");
            com.bytedance.sdk.openadsdk.core.my.iz.u().u(jSONObjectOptJSONObject13);
            if (jSONObjectOptJSONObject13 != null) {
                nr().put("req_exemption_cfg", jSONObjectOptJSONObject13.toString());
            } else {
                nr().remove("req_exemption_cfg");
            }
            this.ga = jSONObjectOptJSONObject4.optInt("endcard_lazy", 0);
            this.tn = jSONObjectOptJSONObject4.optInt("use_new_shake_manager", 0);
            this.of = jSONObjectOptJSONObject4.optInt("stats_report_register_info", 0);
        }
        JSONObject jSONObjectOptJSONObject14 = jSONObject.optJSONObject("download_config");
        if (jSONObjectOptJSONObject14 != null) {
            nrVar.n(jSONObjectOptJSONObject14.optInt("if_storage_internal", 1));
        }
        nrVar.u();
        bf.nr(jSONObject);
        yd.u(jSONObject);
        ja.u(jSONObject);
        com.bytedance.sdk.openadsdk.core.kj.n.u(jSONObject);
        sx.u(jSONObject);
        tk.u(jSONObject);
        new com.bytedance.sdk.openadsdk.core.b.nr("h5_resource_sync").nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pb.t.2
            @Override // java.lang.Runnable
            public void run() {
                d.u(jSONObject, new d.u() { // from class: com.bytedance.sdk.openadsdk.core.pb.t.2.1
                    @Override // com.bytedance.sdk.openadsdk.core.kj.d.u
                    public void nr(d.fx fxVar) {
                        d.nr(t.this.fx, fxVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kj.d.u
                    public void u(d.fx fxVar) {
                        d.u(t.this.fx, fxVar);
                    }
                });
            }
        });
        ge.u(jSONObject);
        this.eh = System.currentTimeMillis();
        this.lf.clear();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("spam_app_list");
        if (jSONArrayOptJSONArray2 != null) {
            int length = jSONArrayOptJSONArray2.length();
            for (int i2 = 0; i2 < length; i2++) {
                String strOptString4 = jSONArrayOptJSONArray2.optString(i2);
                if (!TextUtils.isEmpty(strOptString4)) {
                    this.lf.add(strOptString4);
                }
            }
        }
        synchronized (this.nb) {
            this.nb.clear();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("scheme_check_list");
            if (jSONArrayOptJSONArray3 != null) {
                int length2 = jSONArrayOptJSONArray3.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    String strOptString5 = jSONArrayOptJSONArray3.optString(i3);
                    if (!TextUtils.isEmpty(strOptString5)) {
                        this.nb.add(strOptString5);
                    }
                }
            }
        }
        synchronized (this.gc) {
            this.gc.clear();
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("top_scheme_list");
            if (jSONArrayOptJSONArray4 != null) {
                int length3 = jSONArrayOptJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    String strOptString6 = jSONArrayOptJSONArray4.optString(i4);
                    if (!TextUtils.isEmpty(strOptString6)) {
                        this.gc.add(strOptString6);
                    }
                }
            }
        }
        JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("download_sdk_config");
        if (jSONObjectOptJSONObject15 != null) {
            this.wi = jSONObjectOptJSONObject15.toString();
        } else {
            this.wi = "";
        }
        this.tk = jSONObjectOptJSONObject15;
        try {
            JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("ad_slot_conf_block");
            if (jSONObjectOptJSONObject16 != null) {
                this.f5350cn = jSONObjectOptJSONObject16.toString();
                this.ng.clear();
                Iterator<String> itKeys = jSONObjectOptJSONObject16.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.ng.put(next, jSONObjectOptJSONObject16.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        if (com.bytedance.sdk.openadsdk.core.fx.fx.u().a() || !com.bytedance.sdk.openadsdk.core.n.o().ja()) {
            n(jSONObject);
        }
        com.bytedance.sdk.openadsdk.tools.nr.fx(15, this.df);
        if (com.bytedance.sdk.openadsdk.tools.nr.u()) {
            JSONObject jSONObjectOptJSONObject17 = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optJSONObject("test_tool_urls") : null;
            if (jSONObjectOptJSONObject17 != null) {
                if (jSONObjectOptJSONObject17.has("qa_tool_host")) {
                    try {
                        String host = new URL(jSONObjectOptJSONObject17.optString("qa_tool_host")).getHost();
                        if (!TextUtils.isEmpty(host)) {
                            com.bytedance.sdk.openadsdk.core.n.o().t(host);
                        }
                    } catch (MalformedURLException unused2) {
                    }
                }
                if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.n.o().f())) {
                    if (jSONObjectOptJSONObject17.has("ad_preview_url")) {
                        com.bytedance.sdk.openadsdk.core.n.o().l(jSONObjectOptJSONObject17.optString("ad_preview_url"));
                    }
                    if (jSONObjectOptJSONObject17.has("basic_info_url")) {
                        com.bytedance.sdk.openadsdk.core.n.o().mv(jSONObjectOptJSONObject17.optString("basic_info_url"));
                    }
                }
            }
        }
        this.wv = jSONObject.optInt("pre_cache_brand_count", this.wv);
        JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("video_cache_config");
        this.bl = jSONObjectOptJSONObject18;
        if (jSONObjectOptJSONObject18 != null) {
            com.bykv.vk.openvk.component.video.u.u.u(jSONObjectOptJSONObject18);
        }
        s();
        ng();
        com.bytedance.sdk.openadsdk.core.x.fx.u(this.rh);
        md();
        com.bytedance.sdk.openadsdk.gi.u.u.u(false);
    }

    public boolean k(String str) {
        return o(str).nr() == 1;
    }

    public int mv(String str) {
        int iU;
        if (this.fa == null) {
            return 5000;
        }
        str.hashCode();
        switch (str) {
            case "banner_ad":
                iU = this.fa.u(MediationConstant.RIT_TYPE_BANNER);
                break;
            case "rewarded_video":
                iU = this.fa.u("rewarded");
                break;
            case "fullscreen_interstitial_ad":
                iU = this.fa.u("fullscreen");
                break;
            case "embeded_ad":
                iU = this.fa.u(MediationConstant.RIT_TYPE_FEED);
                break;
            case "draw_ad":
                iU = this.fa.u(MediationConstant.RIT_TYPE_DRAW);
                break;
            default:
                iU = 5000;
                break;
        }
        if (iU <= 0) {
            return 5000;
        }
        return iU;
    }

    public boolean t() {
        if (this.nz == -1) {
            this.nz = nr().getInt("video_size_gap_report", 0);
        }
        return this.nz == 1;
    }

    public boolean x(String str) {
        return str == null || dw.nr().my(str).jk == 0;
    }

    private u bq(String str) {
        u uVarB = null;
        try {
            de();
            String string = this.jq.getString(bg(str), null);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            uVarB = b(new JSONObject(string));
            this.xg.put(str, uVarB);
            return uVarB;
        } catch (Throwable th) {
            th.getMessage();
            return uVarB;
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.na)) {
            this.na = nr().get("app_dl_scheme_list", "");
        }
        if (TextUtils.isEmpty(this.na)) {
            return false;
        }
        String[] strArrSplit = this.na.split(",");
        if (strArrSplit.length == 0) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private u dw(String str) {
        String string;
        com.bytedance.sdk.component.b.nr.fx fxVarN = n();
        u uVarB = null;
        try {
            if (fxVarN == null) {
                if (this.bj == null) {
                    this.bj = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), iz(), 0);
                }
                string = this.bj.getString(bg(str), "");
            } else {
                string = fxVarN.get(bg(str), "");
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            uVarB = b(new JSONObject(string));
            this.xg.put(str, uVarB);
            return uVarB;
        } catch (Throwable th) {
            th.getMessage();
            return uVarB;
        }
    }

    public boolean a(String str) {
        try {
            u uVarO = dw.nr().o(String.valueOf(str));
            if (uVarO != null) {
                return uVarO.s != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean jk(String str) {
        try {
            u uVarMy = dw.nr().my(String.valueOf(str));
            if (uVarMy != null) {
                return uVarMy.s != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public u my(String str) {
        if (str == null) {
            return b(new JSONObject());
        }
        u uVarBq = this.xg.get(str);
        if (uVarBq == null) {
            uVarBq = bq(str);
        }
        if (uVarBq != null) {
            return uVarBq;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code_id", str);
            return b(jSONObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pb.pn
    public void nr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject2 != null) {
            this.qn = jSONObjectOptJSONObject2.optBoolean("can_init_live", true);
        }
        if (!this.qn || (jSONObjectOptJSONObject = jSONObject.optJSONObject("live_sdk_conf")) == null) {
            return;
        }
        this.dj = y.u(jSONObjectOptJSONObject);
        com.bytedance.sdk.openadsdk.core.live.nr.u().nr();
    }

    public boolean sx(String str) {
        if (TextUtils.isEmpty(str) || str.equals(HttpHost.DEFAULT_SCHEME_NAME) || str.equals(BaseConstants.SCHEME_HTTPS)) {
            return false;
        }
        if (this.f5352im == 0) {
            this.f5352im = nr().get("open_dl_type", 0);
        }
        int i = this.f5352im;
        if (i == 0) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        return c(str);
    }

    private void n(JSONObject jSONObject) {
        int length;
        SharedPreferences.Editor editorEdit;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
        if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) <= 0) {
            return;
        }
        this.xg.clear();
        de();
        com.bytedance.sdk.component.b.nr.fx fxVarN = n();
        SharedPreferences.Editor editorEdit2 = null;
        if (fxVarN == null) {
            if (this.bj == null) {
                this.bj = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), iz(), 0);
            }
            editorEdit = this.bj.edit();
        } else {
            editorEdit = null;
        }
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            u uVarB = b(jSONObjectOptJSONObject);
            if (uVarB != null) {
                this.xg.put(uVarB.u, uVarB);
                if (com.bytedance.sdk.openadsdk.core.fx.b.u().x(uVarB.fx())) {
                    if (editorEdit2 == null && this.jq != null) {
                        editorEdit2 = this.jq.edit();
                    }
                    if (editorEdit2 != null) {
                        editorEdit2.putString(bg(uVarB.u), jSONObjectOptJSONObject.toString());
                    }
                }
                if (fxVarN != null) {
                    fxVarN.put(bg(uVarB.u), jSONObjectOptJSONObject.toString());
                } else if (editorEdit != null) {
                    editorEdit.putString(bg(uVarB.u), jSONObjectOptJSONObject.toString());
                }
                com.bytedance.sdk.openadsdk.tools.nr.u(uVarB.u, jSONObjectOptJSONObject);
            }
        }
        if (editorEdit2 != null) {
            try {
                editorEdit2.commit();
            } catch (Throwable th) {
                th.getMessage();
                return;
            }
        }
        if (editorEdit != null) {
            editorEdit.commit();
        }
    }

    public u o(String str) {
        if (str == null) {
            return b(new JSONObject());
        }
        u uVarDw = this.xg.get(str);
        if (uVarDw == null) {
            uVarDw = dw(str);
        }
        if (uVarDw != null) {
            return uVarDw;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code_id", str);
            return b(jSONObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public int t(String str) {
        return o(str).x;
    }

    public int x(int i) {
        return o(String.valueOf(i)).iz;
    }

    public int a(int i) {
        return my(String.valueOf(i)).my;
    }

    public boolean jk(int i) {
        return o(String.valueOf(i)).mv;
    }

    public int l(String str) {
        int iNr;
        if (this.fa == null) {
            return 5000;
        }
        str.hashCode();
        switch (str) {
            case "banner_ad":
                iNr = this.fa.nr(MediationConstant.RIT_TYPE_BANNER);
                break;
            case "rewarded_video":
                iNr = this.fa.nr("rewarded");
                break;
            case "fullscreen_interstitial_ad":
                iNr = this.fa.nr("fullscreen");
                break;
            case "embeded_ad":
                iNr = this.fa.nr(MediationConstant.RIT_TYPE_FEED);
                break;
            case "draw_ad":
                iNr = this.fa.nr(MediationConstant.RIT_TYPE_DRAW);
                break;
            default:
                iNr = 5000;
                break;
        }
        if (iNr <= 0) {
            return 5000;
        }
        return iNr;
    }

    public boolean nr(int i) {
        return n(i) != 0;
    }

    public boolean pn(String str) {
        return o(String.valueOf(str)).pn == 1;
    }

    public boolean nr(String str) {
        return o(str).bg;
    }

    public int pn(int i) {
        return Math.max(o(String.valueOf(i)).f5355a, 0);
    }

    public int s(String str) {
        return my(String.valueOf(str)).o;
    }

    public int iz(String str) {
        return my(str).l;
    }

    public int n(String str) {
        return str == null ? TTAdConstant.STYLE_SIZE_RADIO_3_2 : dw.nr().o(str).t;
    }

    public int iz(int i) {
        int i2 = o(String.valueOf(i)).nr;
        if (i2 <= 0 || i2 > 5) {
            return 1;
        }
        return i2;
    }

    public int n(int i) {
        int i2 = my(String.valueOf(i)).k;
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return i2;
        }
        return 2;
    }

    public boolean b(String str) {
        int i = dw.nr().o(String.valueOf(str)).b;
        if (i != 1) {
            return i == 2 && o.fx(dw.getContext()) != 0;
        }
        return o.b(dw.getContext());
    }

    public int b(int i) {
        return Math.max(o(String.valueOf(i)).n, 0);
    }

    private String u(JSONObject jSONObject, String str, String str2) {
        String strOptString = jSONObject.optString(str, str2);
        if (!com.bytedance.sdk.openadsdk.core.n.o().su()) {
            return strOptString;
        }
        String string = nr().getString(str + "_qa_modify_setting", "");
        return TextUtils.isEmpty(string) ? strOptString : string;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pb.pn
    public void u(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config")) == null) {
            return;
        }
        this.ir = jSONObjectOptJSONObject.optJSONObject("plugin_retry_opt");
    }

    public <T> T u(String str, T t) {
        try {
            if (this.ng.containsKey(str)) {
                T t2 = (T) this.ng.get(str);
                if (t2 != null) {
                    return t2;
                }
            }
        } catch (Exception unused) {
        }
        return t;
    }

    public void u(int i) {
        this.p = i;
    }

    public boolean u(String str) {
        return o(str).sx;
    }

    public int u(String str, int i) {
        if (i != 0 && i != 9) {
            return l(str);
        }
        return mv(str);
    }

    public long fx(String str) {
        return o(str).bq;
    }

    public void fx(int i) {
        if (this.vz != i) {
            this.vz = i;
            nr().put("settings_open", this.vz);
        }
    }
}
