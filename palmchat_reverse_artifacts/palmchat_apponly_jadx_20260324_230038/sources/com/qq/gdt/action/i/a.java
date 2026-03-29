package com.qq.gdt.action.i;

import android.os.Build;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.lantern.auth.server.WkParams;
import com.lantern.core.configuration.ConfigConstant;
import com.opos.mobad.activity.VideoActivity;
import com.qq.gdt.action.d;
import com.qq.gdt.action.e;
import com.qq.gdt.action.j.g;
import com.qq.gdt.action.j.h;
import com.qq.gdt.action.j.m;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.p;
import com.qq.gdt.action.j.x;
import com.wifi.ad.core.config.EventParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String[] f10524a;
    static List b;

    static {
        String[] strArr = {"ipcUserActionSetId", "ipcAppSecretKey", "ipcChannelId", "ipcSaveFileTimeEnd", "ipcUserUniqueId", "ipcChannelType", "ipcSaveFileTimeSuccess"};
        f10524a = strArr;
        b = Arrays.asList(strArr);
    }

    public static void a(com.qq.gdt.action.g.a.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        a(arrayList);
    }

    private static JSONObject b(com.qq.gdt.action.g.a.a aVar) throws JSONException {
        if (aVar == null) {
            return null;
        }
        if (aVar.b() < 0) {
            o.b("Eventid must not be empty.");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt(com.heytap.mcssdk.constant.b.k, Long.valueOf(aVar.b()));
        jSONObject.putOpt("curSessionId", aVar.c());
        jSONObject.putOpt("uniqueEventId", aVar.d());
        jSONObject.putOpt("currentTimeKey", Long.valueOf(aVar.i()));
        jSONObject.putOpt(VideoActivity.EXTRA_KEY_ACTION_TYPE, aVar.f());
        jSONObject.putOpt("actionTime", Long.valueOf(aVar.g()));
        jSONObject.putOpt("action_id", aVar.e());
        jSONObject.putOpt("actionLogId", Long.valueOf(aVar.j()));
        jSONObject.putOpt("eventLogId", Long.valueOf(aVar.k()));
        a(jSONObject, aVar.h());
        return jSONObject;
    }

    private static void c(JSONObject jSONObject) throws Exception {
        if (com.qq.gdt.action.b.a(d.a().g()).r() != 0) {
            return;
        }
        jSONObject.putOpt("osVersion", Integer.valueOf(Build.VERSION.SDK_INT));
        jSONObject.putOpt(EventParams.KEY_PARAM_NETTYPE, p.a());
        jSONObject.putOpt("cpuAbi", h.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(String str, JSONObject jSONObject, com.qq.gdt.action.f.a.b bVar) {
        boolean z;
        com.qq.gdt.action.b bVarA;
        try {
            bVarA = com.qq.gdt.action.b.a(d.a().g());
        } catch (Exception e) {
            o.a("sendEvent switch：" + e.getMessage(), new Object[0]);
        }
        if (str.equals("http://event.gdt.qq.com/report") || str.equals("https://event.gdt.qq.com/report")) {
            z = bVarA.m() == 0;
        }
        if (z) {
            com.qq.gdt.action.f.b.d().a(str).a(jSONObject.toString().getBytes()).b().b(bVar);
            return;
        }
        o.a("sendEvent unable url = " + str, new Object[0]);
    }

    private static void b(JSONObject jSONObject) throws Exception {
        if (com.qq.gdt.action.b.a(d.a().g()).s() != 0) {
            return;
        }
        jSONObject.putOpt("appPackageName", h.d());
        jSONObject.putOpt(WfConstant.EVENT_KEY_APP_NAME, h.c(d.a().g()));
        jSONObject.putOpt("appVersionCode", String.valueOf(h.b(d.a().g())));
        jSONObject.putOpt("gk", com.qq.gdt.action.j.d.f());
    }

    private static void a(List<com.qq.gdt.action.g.a.a> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    a(list, true, new com.qq.gdt.action.f.a.b() { // from class: com.qq.gdt.action.i.a.1
                        @Override // com.qq.gdt.action.f.a.a
                        public void a(int i, com.qq.gdt.action.f.a aVar) {
                            o.a("reportEvents onSuccess statusCode = " + i + " dp3Response = " + aVar.toString(), new Object[0]);
                        }

                        @Override // com.qq.gdt.action.f.a.a
                        public void b(Throwable th) {
                            o.a("reportEvents onFail e = " + th, new Object[0]);
                        }
                    });
                }
            } catch (Throwable th) {
                o.b("reportEvents e = ", th);
            }
        }
    }

    private static void a(JSONObject jSONObject) throws Exception {
        if (com.qq.gdt.action.b.a(d.a().g()).t() != 0) {
            return;
        }
        jSONObject.putOpt("sdkVersion", e.a());
        jSONObject.putOpt("actionSetId", d.a().h());
        jSONObject.putOpt("appkey", d.a().i());
        jSONObject.putOpt("channel", d.a().s());
        jSONObject.putOpt("channelId", d.a().t());
        jSONObject.putOpt("user_unique_id", d.a().v());
        jSONObject.putOpt(WkParams.SESSIONID, d.a().n());
        jSONObject.putOpt("processName", com.qq.gdt.action.j.d.a(d.a().g()));
        jSONObject.putOpt("processCp", Boolean.valueOf(g.a().b()));
        jSONObject.putOpt("processCpStatus", g.a().f10529a);
        jSONObject.putOpt("processMain", Boolean.valueOf(com.qq.gdt.action.j.d.d()));
    }

    private static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            jSONObject2.length();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (b.contains(next)) {
                try {
                    jSONObject.put(next, jSONObject2.optString(next));
                    arrayList.add(next);
                } catch (JSONException e) {
                    o.a("executeParam each key ex = " + e + " key = " + next, new Object[0]);
                }
            }
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONObject2.remove((String) it.next());
            }
            jSONObject.putOpt("event_param", jSONObject2);
        } catch (JSONException e2) {
            o.a("executeParam putOpt eventParam ex = " + e2, new Object[0]);
        }
    }

    public static boolean a(List<com.qq.gdt.action.g.a.a> list, boolean z, com.qq.gdt.action.f.a.b bVar) {
        if (list != null && list.size() != 0 && (z || com.qq.gdt.action.b.a(d.a().g()).d())) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(MapBundleKey.MapObjKey.OBJ_BID, 10021014);
                jSONObject.putOpt("hashImei", h.a());
                x.a(jSONObject, d.a().g());
                jSONObject.putOpt(ConfigConstant.COLUMN_OP, h.e());
                jSONObject.putOpt("osType", 2);
                try {
                    jSONObject.putOpt("privacyAgree", com.qq.gdt.action.multioprocess.d.a().f10548a.g());
                } catch (Throwable th) {
                    jSONObject.putOpt("privacyAgree", "privacy_unknow");
                    o.a("get privacy_agree ", th);
                }
                c(jSONObject);
                b(jSONObject);
                a(jSONObject);
                m.a(jSONObject);
                JSONArray jSONArray = new JSONArray();
                Iterator<com.qq.gdt.action.g.a.a> it = list.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectB = b(it.next());
                    if (jSONObjectB != null) {
                        jSONArray.put(jSONObjectB);
                    }
                }
                jSONObject.putOpt("body", jSONArray);
                String strA = com.qq.gdt.action.c.a(jSONObject, d.a().l());
                String strB = com.qq.gdt.action.c.b(strA);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("v", "0.1");
                jSONObject2.putOpt("data", strA);
                jSONObject2.putOpt("sign", strB);
                jSONObject2.putOpt("encrypt", Boolean.TRUE);
                o.a("Dp3Service 正式请求：" + jSONObject2.toString(), new Object[0]);
                a(p.c() ? "https://event.gdt.qq.com/report" : "http://event.gdt.qq.com/report", jSONObject2, bVar);
                return true;
            } catch (Exception e) {
                o.a("Dp3Service 加密后 处理Dp3请求时发生错误：" + e.getMessage(), new Object[0]);
            }
        }
        return false;
    }
}
