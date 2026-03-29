package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.service.WakedResultReceiver;
import com.zenmen.palmchat.jiguang.JKeepLiveReportHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class vx2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WakedResultReceiver f21553a = null;
    public static boolean b = false;

    public static void a(Context context) {
        synchronized ("waked_cache_v2.json") {
            mv2.d(context, "waked_cache_v2.json", null);
        }
    }

    public static void b(Context context, Bundle bundle, int i) {
        try {
            p63.a("JWakedHelper", "executeWakedAction.");
            JKeepLiveReportHelper.getInstance().reportReceiver(bundle.getString("from_package"), i);
            f(context, i);
            i(context, bundle, i);
        } catch (Throwable th) {
            p63.a("JWakedHelper", "executeWakedAction failed:" + th.getLocalizedMessage());
        }
    }

    public static JSONArray c(Context context) {
        JSONObject jSONObjectA;
        synchronized ("waked_cache_v2.json") {
            jSONObjectA = mv2.a(context, "waked_cache_v2.json");
        }
        if (jSONObjectA == null) {
            jSONObjectA = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("content");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            return e(context, jSONArrayOptJSONArray);
        }
        p63.a("JWakedHelper", "no save data");
        return null;
    }

    public static WakedResultReceiver d(Context context) {
        WakedResultReceiver wakedResultReceiver = f21553a;
        if (wakedResultReceiver != null) {
            return wakedResultReceiver;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.WakedReceiver");
            intent.setPackage(context.getPackageName());
            intent.addCategory(context.getPackageName());
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (listQueryBroadcastReceivers == null || listQueryBroadcastReceivers.size() == 0) {
                return null;
            }
            return (WakedResultReceiver) Class.forName(listQueryBroadcastReceivers.get(0).activityInfo.name).newInstance();
        } catch (Throwable th) {
            p63.f("JWakedHelper", "find waked receiver throwable:" + th.getMessage());
            return null;
        }
    }

    public static JSONArray e(Context context, JSONArray jSONArray) {
        String str;
        if (jSONArray == null) {
            return jSONArray;
        }
        try {
            if (jSONArray.length() <= 0) {
                return jSONArray;
            }
            HashMap map = new HashMap();
            int i = 0;
            while (true) {
                str = "active";
                if (i >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String strOptString = jSONObject.optString("type");
                if ("android_awake_target2".equals(strOptString) || "aat3".equals(strOptString)) {
                    String strOptString2 = jSONObject.optString("package");
                    if (!jSONObject.optBoolean("app_alive")) {
                        str = "dead";
                    }
                    int iOptInt = jSONObject.optInt("wake_type");
                    if (map.containsKey(strOptString2)) {
                        Map map2 = (Map) map.get(strOptString2);
                        if (map2.containsKey(Integer.valueOf(iOptInt))) {
                            Map map3 = (Map) map2.get(Integer.valueOf(iOptInt));
                            if (map3.containsKey(str)) {
                                map3.put(str, Integer.valueOf(((Integer) map3.get(str)).intValue() + 1));
                            } else {
                                map3.put(str, 1);
                            }
                            map2.put(Integer.valueOf(iOptInt), map3);
                        } else {
                            HashMap map4 = new HashMap();
                            map4.put(str, 1);
                            map2.put(Integer.valueOf(iOptInt), map4);
                        }
                        map.put(strOptString2, map2);
                    } else {
                        HashMap map5 = new HashMap();
                        map5.put(str, 1);
                        HashMap map6 = new HashMap();
                        map6.put(Integer.valueOf(iOptInt), map5);
                        map.put(strOptString2, map6);
                    }
                } else {
                    p63.f("JWakedHelper", "unkown type :" + strOptString);
                }
                i++;
            }
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray3 = new JSONArray();
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("p", entry.getKey());
                p63.c("JWakedHelper", "pkg:" + ((String) entry.getKey()));
                Iterator it2 = ((Map) entry.getValue()).entrySet().iterator();
                JSONArray jSONArray4 = new JSONArray();
                while (it2.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    int iIntValue = ((Integer) entry2.getKey()).intValue();
                    Iterator it3 = it;
                    StringBuilder sb = new StringBuilder();
                    Iterator it4 = it2;
                    sb.append("type:");
                    sb.append(iIntValue);
                    p63.c("JWakedHelper", sb.toString());
                    Map map7 = (Map) entry2.getValue();
                    p63.c("JWakedHelper", "value:" + map7);
                    int iIntValue2 = map7.containsKey(str) ? ((Integer) map7.get(str)).intValue() : 0;
                    int iIntValue3 = map7.containsKey("dead") ? ((Integer) map7.get("dead")).intValue() : 0;
                    jSONArray4.put(iIntValue + "_" + (iIntValue2 + iIntValue3) + "_" + iIntValue2 + "_" + iIntValue3);
                    it = it3;
                    it2 = it4;
                    str = str;
                }
                jSONObject3.put("d", jSONArray4);
                jSONArray3.put(jSONObject3);
                it = it;
                str = str;
            }
            if (jSONArray3.length() > 0) {
                jSONObject2.put("f", jSONArray3);
                jSONObject2.put("itime", rv2.q(context));
                jSONObject2.put("type", "aat3");
                jSONArray2.put(jSONObject2);
            }
            return jSONArray2.length() > 0 ? jSONArray2 : jSONArray;
        } catch (Throwable th) {
            p63.g("JWakedHelper", "merge waked json failed:" + th.getMessage());
            th.printStackTrace();
            return null;
        }
    }

    public static void f(Context context, int i) {
        if (context == null) {
            p63.f("JWakedHelper", "context is null,can not notify waked");
            return;
        }
        WakedResultReceiver wakedResultReceiverD = d(context);
        f21553a = wakedResultReceiverD;
        if (wakedResultReceiverD == null) {
            p63.f("JWakedHelper", "waked receiver is null");
            return;
        }
        HashMap map = new HashMap(2);
        map.put("1", context);
        map.put("2", Integer.valueOf(i));
        f21553a.onWakeMap(map);
    }

    public static JSONObject g(String str, int i, boolean z) {
        if (str == null) {
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wake_type", i);
            jSONObject.put("package", str);
            jSONObject.put("app_alive", z);
            return jSONObject;
        } catch (Throwable th) {
            p63.f("JWakedHelper", "packageWakedJson error:" + th.getMessage());
            return null;
        }
    }

    public static void h(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            p63.a("JWakedHelper", "save waked data : " + jSONObject.toString());
            jSONObject.put("itime", rv2.q(context));
            jSONObject.put("type", "aat3");
            synchronized ("waked_cache_v2.json") {
                JSONObject jSONObjectA = mv2.a(context, "waked_cache_v2.json");
                if (jSONObjectA == null) {
                    jSONObjectA = new JSONObject();
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("content");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject);
                jSONObjectA.put("content", jSONArrayOptJSONArray);
                mv2.c(context, "waked_cache_v2.json", jSONObjectA);
            }
        } catch (Throwable th) {
            p63.f("JWakedHelper", "saveWakedData failed:" + th.getMessage());
        }
    }

    public static void i(Context context, Bundle bundle, int i) {
        if (bundle == null) {
            p63.f("JWakedHelper", "bundle is null,give up save");
            return;
        }
        if (!jx2.d(context).u) {
            p63.f("JWakedHelper", "server set do not report waked data,give up save");
            return;
        }
        String string = bundle.getString("from_package");
        if (string == null) {
            string = "";
        }
        JSONObject jSONObjectG = g(string, i, b);
        b = true;
        if (jSONObjectG == null) {
            return;
        }
        try {
            String string2 = bundle.getString("jg_extras");
            if (!TextUtils.isEmpty(string2)) {
                jSONObjectG.put("jg_extras", string2);
            }
        } catch (Throwable th) {
            p63.f("JWakedHelper", "save waked extras error:" + th.getMessage());
        }
        h(context, jSONObjectG);
    }
}
