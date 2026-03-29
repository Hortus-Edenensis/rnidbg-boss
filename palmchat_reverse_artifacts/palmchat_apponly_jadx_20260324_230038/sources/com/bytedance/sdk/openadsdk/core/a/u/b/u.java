package com.bytedance.sdk.openadsdk.core.a.u.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.t.b.b;
import com.bytedance.sdk.component.t.b.fx;
import com.bytedance.sdk.component.t.b.pn;
import com.bytedance.sdk.component.t.u.nr;
import com.bytedance.sdk.openadsdk.api.plugin.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.fx.iz;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.pb.t;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static long iz;
    private static String n;
    private static long pn;
    private static String x;
    private static AtomicInteger u = new AtomicInteger(0);
    private static SharedPreferences nr = nr.nr(dw.getContext(), "uchain_data", 0);
    private static int fx = -1;
    private static int b = -1;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.a.u.b.u$3, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class AnonymousClass3 implements fx {
        final /* synthetic */ JSONArray u;

        public AnonymousClass3(JSONArray jSONArray) {
            this.u = jSONArray;
        }

        @Override // com.bytedance.sdk.component.t.b.fx
        public void u(com.bytedance.sdk.component.t.u.u uVar) {
            uVar.u(new b() { // from class: com.bytedance.sdk.openadsdk.core.a.u.b.u.3.1
                @Override // com.bytedance.sdk.component.t.b.b
                public pn nr() {
                    return new pn() { // from class: com.bytedance.sdk.openadsdk.core.a.u.b.u.3.1.1
                        @Override // com.bytedance.sdk.component.t.b.pn
                        public void nr(com.bytedance.sdk.component.t.u.u uVar2, Map<String, Object> map) {
                            try {
                                String strU = uVar2.x().u();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event", strU);
                                jSONObject.put("status", false);
                                AnonymousClass3.this.u.put(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }

                        @Override // com.bytedance.sdk.component.t.b.pn
                        public void u(com.bytedance.sdk.component.t.u.u uVar2, Map<String, Object> map) {
                            try {
                                String strU = uVar2.x().u();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event", strU);
                                jSONObject.put("status", true);
                                AnonymousClass3.this.u.put(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                    };
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jk() {
        fx = 100008;
        long jCurrentTimeMillis = System.currentTimeMillis() - iz;
        pn = jCurrentTimeMillis;
        nr(fx, b, jCurrentTimeMillis);
        t();
    }

    private static void t() {
        String strFz;
        String strYf;
        JSONObject jSONObjectNr;
        fx = -1;
        t tVarNr = dw.nr();
        if (tVarNr != null && (jSONObjectNr = nr((strFz = tVarNr.fz()), (strYf = tVarNr.yf()))) != null && jSONObjectNr.length() > 0) {
            b = 2;
            x = strFz;
            n = strYf;
            long jCurrentTimeMillis = System.currentTimeMillis() - iz;
            pn = jCurrentTimeMillis;
            nr(fx, b, jCurrentTimeMillis);
            nr(jSONObjectNr);
            return;
        }
        JSONObject jSONObjectU = u();
        if (jSONObjectU == null || jSONObjectU.length() <= 0) {
            u.set(3);
            nr(fx, b, pn);
            return;
        }
        b = 0;
        n = "uc_dsl/uc_dsl.bin";
        long jCurrentTimeMillis2 = System.currentTimeMillis() - iz;
        pn = jCurrentTimeMillis2;
        nr(fx, b, jCurrentTimeMillis2);
        nr(jSONObjectU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            jSONObject = u();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_template");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                com.bytedance.sdk.component.t.fx.nr.INSTANCE.u(jSONObjectOptJSONObject);
                u.set(2);
                return;
            } else {
                u.set(3);
                return;
            }
        }
        u.set(3);
    }

    public static void u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = "21ea2d6d4f321553dd684e6b864bf0b7";
            str2 = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20103/uchain_dsl.bin";
        }
        x = str;
        n = str2;
        iz = System.currentTimeMillis();
        JSONObject jSONObjectNr = nr(x, n);
        if (jSONObjectNr != null && jSONObjectNr.length() > 0) {
            b = 2;
            long jCurrentTimeMillis = System.currentTimeMillis() - iz;
            pn = jCurrentTimeMillis;
            nr(fx, b, jCurrentTimeMillis);
            nr(jSONObjectNr);
            return;
        }
        com.bytedance.sdk.component.a.nr.u uVarPn = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().pn();
        if (uVarPn == null) {
            u.set(3);
            return;
        }
        uVarPn.u(n);
        final String str3 = x;
        final String str4 = n;
        uVarPn.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.b.u.1
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                int unused = u.b = 1;
                String unused2 = u.x = str3;
                String unused3 = u.n = str4;
                if (nrVar != null) {
                    try {
                        if (nrVar.a()) {
                            JSONObject jSONObjectU = iz.u(nrVar.t(), "uchain_dsl");
                            long unused4 = u.pn = System.currentTimeMillis() - u.iz;
                            if (jSONObjectU != null && jSONObjectU.length() > 0) {
                                u.nr(u.fx, u.b, u.pn);
                                u.nr(jSONObjectU);
                                u.nr.edit().putString(str3, com.bytedance.sdk.component.utils.u.nr(jSONObjectU.toString())).apply();
                                return;
                            }
                            u.nr(u.fx, u.b, u.pn);
                            u.jk();
                            return;
                        }
                    } catch (Throwable unused5) {
                        u.jk();
                        return;
                    }
                }
                u.jk();
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                int unused = u.b = 1;
                u.jk();
            }
        });
    }

    public static JSONObject nr(String str, String str2) {
        if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String string = nr.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            String strFx = com.bytedance.sdk.component.utils.u.fx(string);
            b = 2;
            x = str;
            n = str2;
            return new JSONObject(strFx);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(final int i, final int i2, final long j) {
        com.bytedance.sdk.openadsdk.core.qq.nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.b.u.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() {
                JSONObject jSONObject = new JSONObject();
                try {
                    int i3 = i;
                    if (i3 != -1) {
                        jSONObject.put("dsl_error_code", i3);
                    }
                    jSONObject.put("dsl_url", u.n);
                    jSONObject.put("dsl_md5", u.x);
                    jSONObject.put("dsl_load_type", i2);
                    jSONObject.put("dsl_load_time", j);
                    jSONObject.put("dsl_stats_id", UUID.randomUUID());
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("uchain_stats_tracker").nr(jSONObject.toString());
            }
        }, "uchain_stats_tracker", false);
    }

    public static void u(bc bcVar, Map<String, Object> map, String str, HashMap<String, Object> map2, String str2, HashMap<String, Object> map3) {
        if (u.get() != 2) {
            iz = System.currentTimeMillis();
            t();
        }
        if (bcVar == null) {
            return;
        }
        JSONObject jSONObjectEt = bcVar.et();
        try {
            for (Map.Entry<String, Object> entry : map3.entrySet()) {
                jSONObjectEt.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        JSONArray jSONArray = new JSONArray();
        new nr.u(str).u(jSONObjectEt).u(map2).u(new AnonymousClass3(jSONArray)).u().u();
        JSONObject jSONObject = new JSONObject();
        UUID uuidRandomUUID = UUID.randomUUID();
        if (map != null) {
            map.put("uchain_event_id", uuidRandomUUID);
        }
        try {
            jSONObject.put("uchain_event_id", uuidRandomUUID);
            jSONObject.put(str, jSONArray);
            jSONObject.put("slot_type", jp.jk(bcVar));
            com.bytedance.sdk.openadsdk.core.s.b.nr(bcVar, str2, "uchain_event_tracker", jSONObject);
        } catch (JSONException unused2) {
        }
    }

    public static boolean u(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("is_feed_register_direct_download");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static JSONObject u() {
        try {
            return new JSONObject("{\"template_info\":{\"version\":\"2.1.3\"},\"event_template\":{\"clickEvent\":{\"main\":\"open_sass_live\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_sass_live\",\"scheme\":\"uchain://open_sass_live?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&coupon=${coupon}&ec_schema=${ec_schema}&ecom_live_params=${ecom_live_params}&live_interaction_type=${live_interaction_type}&live_room_id=${live_room_id}&deep_link=${deep_link}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"name\":\"open_miniapp\"}]}},{\"name\":\"open_miniapp\",\"scheme\":\"uchain://open_miniapp?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&wc_miniapp_info=${wc_miniapp_info}&target_url=${target_url}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(is_video_lp==true||if_both_open==1)&&deep_link==null&&ulink==null}\",\"name\":\"open_landing_page\"},{\"condition\":\"${deep_link!=null||ulink!=null||(is_video_lp!=true&&if_both_open==0)}\",\"name\":\"open_scheme\"}]}},{\"name\":\"open_landing_page\",\"scheme\":\"uchain://open_landing_page?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&title=${title!=null?title:'广告'}&url=${target_url}&button_text=${button_text!=null?button_text:'立即下载'}&gecko_id=${gecko_id}&block_auto_open=${block_auto_open}&ugeno=${ugeno}&page_render_type=${page_render_type}&session_params=${session_params}&dylite_info=${dylite_info}&filter_words=${filter_words}&video=${video}&app_info=${app}&use_media_video_player=${use_media_video_player}&source=${source}&title=${title}&image_mode=${image_mode}&landing_page_conf=${landing_page_conf}&image=${image}&landing_scroll_percentage=${landing_scroll_percentage}&sdk_derive_info=${sdk_derive_info}&dynamic_join_type=${dynamic_join_type}&audio=${audio}&disable_video_join=${disable_video_join}&disable_top_bar=${disable_top_bar}&disable_rtn_button=${disable_rtn_button}&disable_safe_area=${disable_safe_area}&gnd_prefetch_timing=${gnd_prefetch_timing}&gnd_prefetch_cache_key=${gnd_prefetch_cache_key}&direct_landing_page_info=${direct_landing_page_info}&reward_browse_type=${reward_browse_type}&voice_control=${voice_control}\",\"params\":{},\"next\":[{\"condition\":\"${if_both_open==1&&(is_video_lp!=true||app.appleid==null||app.appleid=='0')}\",\"name\":\"download\"}],\"callback\":{\"success\":[],\"fail\":[]}},{\"name\":\"open_scheme\",\"scheme\":\"uchain://open_scheme?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&deep_link=${deep_link}&ulink=${ulink}&ulink_priority=${ulink_priority}&sub_convert_link=${sub_convert_link}&app_info=${app}&block_auto_open=${block_auto_open}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==1)||(deep_link==null&&(interaction_type==3||ext.interaction_type==3))}\",\"name\":\"open_landing_page\"},{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==2)||(deep_link==null&&(interaction_type==4||ext.interaction_type==4))}\",\"name\":\"download\"}]}},{\"name\":\"download\",\"scheme\":\"uchain://download?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&app_info=${app}&download_conf=${download_conf}&appstore_jump_type=${appstore_jump_type}&market_url=${market_url}&download_sdk_conf=${download_sdk_conf}&icon=${icon}&interaction_type=${interaction_type}&skan=${skan}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${if_both_open==0}\",\"name\":\"open_landing_page\"}]}}]},\"ugen_view_visibility_tracker\":{\"main\":\"report_event\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"report_event\",\"scheme\":\"uchain://report_event?label=ugen_view_visibility&ad_id=${ad_id}&log_extra=${ext}&ugen_id=${ugen_event_params.ugen_id}&visibility=${ugen_event_params.visibility}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_rate\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=rate&identifier=${ad_info}&rate=1.0\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_pause\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=pause&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_play\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=play&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_replay\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=replay&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"openPolicy\":{\"main\":\"open_policy\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_policy\",\"scheme\":\"uchain://open_policy?ad_info=${ad_info}&adx_name=${adx_name}&filter_words=${filter_words}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"continue_watch\":{\"main\":\"reward_continue\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_continue\",\"scheme\":\"uchain://reward_continue\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"exit_watch\":{\"main\":\"close_reward\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"close_reward\",\"scheme\":\"uchain://close_reward\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"reward_again\":{\"main\":\"reward_again\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_again\",\"scheme\":\"uchain://reward_again?pression_sessions=${play_again.pression_sessions}&play_again_rit=${play_again.play_again_rit}&log_extra=${ext}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]}}}");
        } catch (Exception unused) {
            return null;
        }
    }
}
