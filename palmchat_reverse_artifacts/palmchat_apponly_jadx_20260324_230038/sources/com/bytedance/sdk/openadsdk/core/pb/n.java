package com.bytedance.sdk.openadsdk.core.pb;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.bf;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.qq;
import com.bytedance.sdk.openadsdk.core.y.xw;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.config.EventParams;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n extends com.bytedance.sdk.component.jk.a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile n b;
    private final Context nr;
    private final pn u;
    private volatile Runnable x;
    private static final AtomicLong fx = new AtomicLong(0);
    private static boolean pn = true;
    private static volatile boolean iz = false;

    /* JADX INFO: compiled from: SearchBox */
    public class u extends BroadcastReceiver {
        private u() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    n.fx.set(longExtra);
                    return;
                }
                return;
            }
            if (intExtra == 2) {
                try {
                    if (n.this.u != null) {
                        n.this.u.u();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private n(pn pnVar) {
        super("SdkSettingsHelper");
        this.u = pnVar == null ? dw.nr() : pnVar;
        Context context = dw.getContext();
        this.nr = context;
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            try {
                context.registerReceiver(new u(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"), jp.z(), com.bytedance.sdk.component.utils.jk.u());
            } catch (Throwable unused) {
            }
        }
    }

    private static JSONObject a() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectWq = com.bytedance.sdk.openadsdk.core.n.o().wq();
        if (jSONObjectWq == null) {
            return new JSONObject();
        }
        Iterator<String> itKeys = jSONObjectWq.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject = jSONObjectWq.optJSONObject(next)) != null) {
                try {
                    jSONObjectOptJSONObject.put("plugin_update_network", com.bytedance.sdk.openadsdk.core.n.o().z().u(next));
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObjectWq;
    }

    public static boolean b() {
        return iz;
    }

    private boolean n() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.n.o().c());
    }

    public void fx() {
        u(false);
    }

    public JSONObject pn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.core.y.jk.s());
            jSONObject.put("ipv6", com.bytedance.sdk.openadsdk.core.y.jk.k());
            jSONObject.put("oaid", com.bytedance.sdk.openadsdk.core.y.jk.fx(false));
            jSONObject.put("oaid_source", qq.u());
            jSONObject.put(WkParams.MODEL, com.bytedance.sdk.openadsdk.core.y.jk.nr());
            jSONObject.put("conn_type", o.nr(this.nr));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", d.b);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
            jSONObject.put("is_plugin", d.u());
            jSONObject.put("is_boost", true);
            jSONObject.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.b.u.b());
            jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.core.l.a.b());
            jSONObject.put("package_name", jp.a());
            jSONObject.put(EventParams.KEY_CT_SDK_POSITION, jp.b() ? 1 : 2);
            jSONObject.put("app_version", jp.t());
            jSONObject.put("app_code", jp.jk());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.n.o().c());
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.x.nr(com.bytedance.sdk.openadsdk.core.n.o().c() != null ? com.bytedance.sdk.openadsdk.core.n.o().c().concat(String.valueOf(jCurrentTimeMillis)).concat(d.b) : ""));
            jp.t();
            jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.y.jk.fx());
            jSONObject.put("channel", d.x);
            jSONObject.put("applog_did", com.bytedance.sdk.openadsdk.core.y.jk.o());
            jSONObject.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.n.o().iz());
            com.bytedance.sdk.openadsdk.k.nr.u(this.nr, jSONObject);
            com.bytedance.sdk.openadsdk.k.nr.nr(this.nr, jSONObject);
            jSONObject.put("system_app", d.fx());
            if (d.u()) {
                jSONObject.put("plugins", a());
            }
            jSONObject.put(WkParams.IMEI, com.bytedance.sdk.openadsdk.core.y.jk.n());
            jSONObject.put(az.at, 1);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            String strLf = com.bytedance.sdk.openadsdk.core.n.o().lf();
            if (!TextUtils.isEmpty(strLf)) {
                jSONObject.put("rit_list", strLf);
            }
            long jMh = dw.nr().mh();
            if (jMh > 0) {
                jSONObject.put("data_time", jMh);
            }
            JSONObject jSONObjectSu = dw.nr().su();
            if (jSONObjectSu != null) {
                jSONObject.put("digest", jSONObjectSu);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.rh.u.u().u("DeviceRate", "bytebench_value")));
            } catch (NumberFormatException unused) {
                jSONObject.put("device_score", -1);
            }
            jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.n.o().xw() ? 1 : 0);
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!o.u(this.nr)) {
            try {
                this.u.u();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (n()) {
            return;
        }
        if (!a.u() || bg.u) {
            JSONObject jSONObjectPn = pn();
            xw xwVar = new xw(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().iz());
            xwVar.u(com.bytedance.sdk.openadsdk.x.fx.u(xwVar, jp.n("/api/ad/union/sdk/settings/")));
            xwVar.nr("User-Agent", com.bytedance.sdk.openadsdk.core.y.jk.mv());
            xwVar.nr(jSONObjectPn, "settings");
            com.bytedance.sdk.openadsdk.x.fx.u(jSONObjectPn, 1);
            xwVar.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.pb.n.2
                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                    if (nrVar == null || !nrVar.a()) {
                        try {
                            n.this.u.u();
                            dw.nr().z();
                        } catch (Throwable unused2) {
                        }
                        bg.nr();
                        return;
                    }
                    try {
                        try {
                            final JSONObject jSONObject = (JSONObject) com.bytedance.sdk.openadsdk.core.fx.iz.u(nrVar, "settings", false).second;
                            if (jSONObject == null) {
                                return;
                            }
                            try {
                                if (!n.this.u(jSONObject)) {
                                    return;
                                }
                            } catch (Throwable unused3) {
                            }
                            n.this.u.u(jSONObject);
                            if (jk.fx() || jk.iz() || jk.b()) {
                                com.bytedance.sdk.openadsdk.core.ja.nr.fx.u();
                            }
                            if (d.iz) {
                                n.this.u.nr(jSONObject);
                            }
                            new com.bytedance.sdk.openadsdk.core.b.nr("check_and_update_pl").u(5).nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pb.n.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONArray jSONArrayOptJSONArray;
                                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("plugins");
                                    if (jSONArrayOptJSONArray2 != null) {
                                        com.bytedance.sdk.openadsdk.core.ja.u.nr.u().u(jSONArrayOptJSONArray2);
                                    }
                                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
                                    if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("plugins")) == null) {
                                        return;
                                    }
                                    com.bytedance.sdk.openadsdk.core.ja.u.nr.u().u(jSONArrayOptJSONArray);
                                }
                            });
                            try {
                                n.this.u.fx(jSONObject);
                                bg.u();
                                if (!n.iz) {
                                    boolean unused4 = n.iz = true;
                                }
                                com.bytedance.sdk.openadsdk.core.n.o().z().pn();
                                com.bytedance.sdk.openadsdk.core.xg.u.nr();
                            } catch (Throwable th) {
                                s.u().u("setting_saveData_failed", n.this.u(th), th);
                            }
                            s.u().nr();
                            if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
                                n.nr();
                            }
                            com.bytedance.sdk.openadsdk.x.fx.nr(jSONObject, 1);
                        } catch (Throwable th2) {
                            s.u().u("setting_decrypt", th2);
                        }
                    } catch (Throwable th3) {
                        s.u().u("setting_parse", th3);
                    }
                }

                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                    try {
                        Iterator<String> itKeys = com.bytedance.sdk.openadsdk.core.n.o().wq().keys();
                        while (itKeys.hasNext()) {
                            com.bytedance.sdk.openadsdk.core.ja.u.nr.u().u(itKeys.next(), 1007);
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        n.this.u.u();
                        dw.nr().z();
                    } catch (Throwable unused3) {
                    }
                    bg.nr();
                }
            });
        }
    }

    public static void nr() {
        if (dw.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(jp.a());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                dw.getContext().sendBroadcast(intent, jp.a() + ".openadsdk.permission.TT_PANGOLIN");
            } catch (Throwable unused) {
            }
        }
    }

    public static n u(pn pnVar) {
        if (b == null) {
            synchronized (n.class) {
                if (b == null) {
                    b = new n(pnVar);
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(long j) {
        fx.set(j);
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            u(j);
        }
        com.bytedance.sdk.component.jk.x.u(this, 10);
    }

    public static void u() {
        try {
            bf.u("tt_sdk_settings_other").clear();
            bf.u("tt_sdk_settings_other_bst").clear();
            bf.u("tt_sdk_settings_slot").clear();
            bf.u("tt_sdk_settings_slot_bst").clear();
            bf.u("tt_sdk_settings_slot_splash").clear();
            bf.u("tt_sdk_settings_slot_splash_bst").clear();
        } catch (Throwable unused) {
        }
    }

    public static void u(long j) {
        if (j > 0 && dw.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(jp.a());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                dw.getContext().sendBroadcast(intent, jp.z());
            } catch (Throwable unused) {
            }
        }
    }

    public void u(boolean z) {
        try {
            if (n()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!z) {
                if (jCurrentTimeMillis - fx.get() < 600000) {
                    return;
                }
                nr(jCurrentTimeMillis);
            } else {
                if (this.x != null) {
                    return;
                }
                long j = (fx.get() + 60000) - jCurrentTimeMillis;
                if (j > 0) {
                    this.x = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pb.n.1
                        @Override // java.lang.Runnable
                        public void run() {
                            n.this.x = null;
                            n.this.nr(System.currentTimeMillis());
                        }
                    };
                    com.bytedance.sdk.component.utils.jk.u().postDelayed(this.x, j);
                } else {
                    this.x = null;
                    nr(jCurrentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("active_control", 1);
                a.u(iOptInt);
                return iOptInt == 1;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject u(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        if (th == null) {
            return jSONObject;
        }
        int i = 0;
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            i++;
            if (stackTraceElement != null) {
                try {
                    jSONObject.putOpt(String.valueOf(i), stackTraceElement.toString());
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }
}
