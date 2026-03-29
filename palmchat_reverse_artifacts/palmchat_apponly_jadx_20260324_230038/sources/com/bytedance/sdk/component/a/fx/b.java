package com.bytedance.sdk.component.a.fx;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static final Object b = new Object();
    private boolean fx;
    private fx nr = new fx();
    private int pn;
    private Context u;

    public b(Context context, boolean z, int i) {
        this.u = context;
        this.fx = z;
        this.pn = i;
    }

    public fx fx() {
        return this.nr;
    }

    public void nr() {
        try {
            String strU = com.bytedance.sdk.component.a.b.b.u(this.u, 1, this.pn);
            if (TextUtils.isEmpty(strU)) {
                com.bytedance.sdk.component.a.b.fx.nr("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            fx fxVarNr = nr(new JSONObject(strU));
            StringBuilder sb = new StringBuilder("loadLocalConfigForOtherProcess, config: ");
            sb.append(fxVarNr == null ? com.igexin.push.core.b.m : fxVarNr.toString());
            com.bytedance.sdk.component.a.b.fx.nr("TNCConfigHandler", sb.toString());
            if (fxVarNr != null) {
                this.nr = fxVarNr;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.a.b.fx.nr("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (!this.fx) {
            com.bytedance.sdk.component.a.b.fx.nr("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        x.u().u(this.pn).pn();
        try {
            try {
                boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
                if (x.u().u(this.pn).fx() && z && jSONArrayOptJSONArray != null) {
                    ArrayList<JSONObject> arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject3 = ((JSONObject) jSONArrayOptJSONArray.get(i)).getJSONObject(RemoteMessageConst.MessageBody.PARAM);
                        if (jSONObject3.optString(FFmpegMediaMetadataRetriever.METADATA_KEY_SERVICE_NAME, "").equals("idc_selection")) {
                            arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        jSONObject2 = new JSONObject();
                        for (JSONObject jSONObject4 : arrayList) {
                            Iterator<String> itKeys = jSONObject4.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                jSONObject2.put(next, jSONObject4.getString(next));
                            }
                        }
                    }
                } else {
                    jSONObject2 = null;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tnc_config");
                if (jSONObjectOptJSONObject == null && jSONObject2 == null) {
                    com.bytedance.sdk.component.a.b.fx.u("TNCConfigHandler", " tnc host_replace_map config is null");
                } else if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
                } else if (jSONObject2 != null) {
                    jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
                }
                fx fxVarNr = nr(jSONObjectOptJSONObject);
                StringBuilder sb = new StringBuilder("handleConfigChanged, newConfig: ");
                sb.append(fxVarNr == null ? com.igexin.push.core.b.m : fxVarNr.toString());
                com.bytedance.sdk.component.a.b.fx.nr("TNCConfigHandler", sb.toString());
                if (fxVarNr == null) {
                    synchronized (b) {
                        com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.u, x.u().u(this.pn).u(), 0).edit().putString("tnc_config_str", "").apply();
                        com.bytedance.sdk.component.a.b.b.u(this.u, 1, "", this.pn);
                    }
                    return;
                } else {
                    this.nr = fxVarNr;
                    String string = jSONObjectOptJSONObject.toString();
                    synchronized (b) {
                        com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.u, x.u().u(this.pn).u(), 0).edit().putString("tnc_config_str", string).apply();
                        com.bytedance.sdk.component.a.b.b.u(this.u, 1, string, this.pn);
                    }
                    return;
                }
            } catch (Throwable unused) {
                this.nr = new fx();
                synchronized (b) {
                    com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.u, x.u().u(this.pn).u(), 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.component.a.b.b.u(this.u, 1, "", this.pn);
                    return;
                }
            }
        } catch (Throwable th) {
            synchronized (b) {
            }
        }
        synchronized (b) {
            com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.u, x.u().u(this.pn).u(), 0).edit().putString("tnc_config_str", "").apply();
            com.bytedance.sdk.component.a.b.b.u(this.u, 1, "", this.pn);
            throw th;
        }
    }

    private fx nr(JSONObject jSONObject) {
        try {
            fx fxVar = new fx();
            if (jSONObject.has("local_enable")) {
                fxVar.u = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                fxVar.nr = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, 0);
                        }
                    }
                }
                fxVar.fx = map;
            } else {
                fxVar.fx = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap map2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            map2.put(next, string2);
                        }
                    }
                }
                fxVar.b = map2;
            } else {
                fxVar.b = null;
            }
            fxVar.pn = jSONObject.optInt("req_to_cnt", fxVar.pn);
            fxVar.iz = jSONObject.optInt("req_to_api_cnt", fxVar.iz);
            fxVar.x = jSONObject.optInt("req_to_ip_cnt", fxVar.x);
            fxVar.n = jSONObject.optInt("req_err_cnt", fxVar.n);
            fxVar.f5075a = jSONObject.optInt("req_err_api_cnt", fxVar.f5075a);
            fxVar.jk = jSONObject.optInt("req_err_ip_cnt", fxVar.jk);
            fxVar.t = jSONObject.optInt(WkAdConfigModel.TAG_UPDATETIME, fxVar.t);
            fxVar.l = jSONObject.optInt("update_random_range", fxVar.l);
            fxVar.mv = jSONObject.optString("http_code_black", fxVar.mv);
            return fxVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void u() {
        if (this.fx) {
            String string = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.u, x.u().u(this.pn).u(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.component.a.b.fx.nr("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                fx fxVarNr = nr(new JSONObject(string));
                if (fxVarNr != null) {
                    this.nr = fxVarNr;
                }
                StringBuilder sb = new StringBuilder("loadLocalConfig: ");
                sb.append(fxVarNr == null ? com.igexin.push.core.b.m : fxVarNr.toString());
                com.bytedance.sdk.component.a.b.fx.nr("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.a.b.fx.nr("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }
}
