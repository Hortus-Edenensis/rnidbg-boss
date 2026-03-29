package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.service.DownloadProvider;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.ccg.a;
import com.zenmen.palmchat.jiguang.JKeepLiveReportHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class mx2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f19385a = false;
    public static long b;

    public static List<String> a(List<String> list, List<String> list2) {
        return b(list, list2, true);
    }

    public static List<String> b(List<String> list, List<String> list2, boolean z) {
        if (list == null || list.size() == 0) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list2) {
            if (list.contains(str)) {
                if (z) {
                    p63.a("JWakeHelper", str + " in the white list");
                    arrayList.add(str);
                } else {
                    p63.a("JWakeHelper", str + " in the black list");
                }
            }
            if (!z) {
                p63.a("JWakeHelper", str + " not in the global black list");
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean c() {
        if (System.currentTimeMillis() - b > 300000) {
            b = System.currentTimeMillis();
            JSONObject config = vs0.a().getConfig("Aurora_keepalive");
            if (config != null) {
                f19385a = config.optInt("pullalive_otherapp", 0) == 1;
            }
        }
        return f19385a;
    }

    public static void d(Context context) {
        synchronized ("wake_cache_v2.json") {
            mv2.d(context, "wake_cache_v2.json", null);
        }
    }

    public static List<rx2> e(Context context, List<rx2> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(list.get(i).f20619a, 128);
                list.get(i).c = applicationInfo.targetSdkVersion;
            } catch (Throwable unused) {
            }
        }
        return list;
    }

    public static List<rx2> f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\$");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("\\|");
            String str3 = strArrSplit2[0];
            String str4 = strArrSplit2[1];
            rx2 rx2Var = new rx2();
            rx2Var.f20619a = str3;
            rx2Var.b = str4;
            rx2Var.h = 1;
            rx2Var.f = 4;
            arrayList.add(rx2Var);
        }
        return arrayList;
    }

    public static String g(List<rx2> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).f20619a;
            String str2 = list.get(i).b;
            sb.append(str);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(str2);
            sb.append("$");
        }
        return sb.toString();
    }

    public static List<String> h(List<String> list, List<String> list2) {
        return b(list, list2, false);
    }

    public static Bundle i(HashMap<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    public static String j(HashMap<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        for (String str : map.keySet()) {
            builder.appendQueryParameter(str, map.get(str));
        }
        return builder.toString();
    }

    public static List<String> k(kx2 kx2Var, List<String> list) {
        return kx2Var == null ? list : t(kx2Var, u(kx2Var, list));
    }

    public static JSONObject l(List<qx2> list) {
        if (list == null || list.size() == 0) {
            p63.a("JWakeHelper", "wakeUpResult is empty, no need report");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (qx2 qx2Var : list) {
            try {
                HashMap<Integer, Integer> map = qx2Var.b;
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("package", qx2Var.f20349a);
                    JSONArray jSONArray2 = new JSONArray();
                    HashMap<Integer, Integer> map2 = qx2Var.b;
                    for (Integer num : map2.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("wake_type", num);
                        jSONObject2.put("wake_status", map2.get(num));
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("package", qx2Var.f20349a);
                    jSONObject.put("data", jSONArray2);
                    jSONArray.put(jSONObject);
                }
            } catch (Throwable th) {
                p63.c("JWakeHelper", "formatReportData:" + th);
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put(a.F, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject3;
    }

    public static HashMap<String, rx2> m(Context context, HashMap<String, rx2> map) {
        try {
            HashMap<String, rx2> map2 = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.PushService");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() != 0) {
                for (int i = 0; i < listQueryIntentServices.size(); i++) {
                    ServiceInfo serviceInfo = listQueryIntentServices.get(i).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && ((map == null || !map.containsKey(str2)) && !context.getPackageName().equals(str2))) {
                        int iCheckPermission = packageManager.checkPermission(str2 + ".permission.JPUSH_MESSAGE", str2);
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str2, 128);
                        if (applicationInfo != null && applicationInfo.metaData != null) {
                            String strE = rv2.e(context);
                            if (iCheckPermission == 0 && !TextUtils.isEmpty(strE) && strE.length() == 24 && !context.getPackageName().equals(applicationInfo.packageName)) {
                                rx2 rx2Var = new rx2(str2, "", applicationInfo.targetSdkVersion);
                                ComponentInfo componentInfoG = rv2.g(context, str2, DownloadProvider.class);
                                if (componentInfoG instanceof ProviderInfo) {
                                    ProviderInfo providerInfo = (ProviderInfo) componentInfoG;
                                    if (providerInfo.exported && providerInfo.enabled && providerInfo.authority != null) {
                                        if (TextUtils.equals(str2 + ".DownloadProvider", providerInfo.authority)) {
                                            rx2Var.d = providerInfo.authority;
                                        }
                                    }
                                }
                                map2.put(rx2Var.f20619a, rx2Var);
                            }
                        }
                    }
                }
                p63.a("JWakeHelper", "getWakeAppListWithoutDService:" + map2.toString());
                return map2;
            }
            return null;
        } catch (Throwable th) {
            p63.f("JWakeHelper", "getWakeAppListWithoutDService throwable:" + th.getMessage());
            return null;
        }
    }

    public static JSONArray n(Context context) {
        JSONObject jSONObjectA;
        synchronized ("wake_cache_v2.json") {
            jSONObjectA = mv2.a(context, "wake_cache_v2.json");
        }
        if (jSONObjectA == null) {
            jSONObjectA = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("content");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            return q(context, jSONArrayOptJSONArray);
        }
        p63.a("JWakeHelper", "no save data");
        return null;
    }

    public static rx2 o(Context context, String str) {
        try {
            return new rx2(str, "", context.getPackageManager().getApplicationInfo(str, 0).targetSdkVersion);
        } catch (Throwable th) {
            p63.f("JWakeHelper", "getWakeTarget throwable:" + th.getMessage());
            return null;
        }
    }

    public static HashMap<String, rx2> p(Context context) {
        rx2 rx2VarB;
        try {
            HashMap<String, rx2> map = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DaemonService");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() != 0) {
                for (int i = 0; i < listQueryIntentServices.size(); i++) {
                    ServiceInfo serviceInfo = listQueryIntentServices.get(i).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && serviceInfo.exported && serviceInfo.enabled && !context.getPackageName().equals(str2) && (rx2VarB = ix2.b(context, packageManager, str2, str)) != null) {
                        p63.a("JWakeHelper", "wakeTarget:" + rx2VarB.toString());
                        map.put(rx2VarB.f20619a, rx2VarB);
                    }
                }
                return map;
            }
            return null;
        } catch (Throwable th) {
            p63.f("JWakeHelper", "getWakeTargetMap throwable:" + th.getMessage());
            return null;
        }
    }

    public static JSONArray q(Context context, JSONArray jSONArray) {
        int i;
        if (jSONArray == null) {
            return jSONArray;
        }
        try {
            if (jSONArray.length() <= 0) {
                return jSONArray;
            }
            HashMap map = new HashMap();
            int i2 = 0;
            while (true) {
                i = 1;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String strOptString = jSONObject.optString("type");
                if ("aa3".equals(strOptString)) {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(a.F);
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        break;
                    }
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                        String strOptString2 = jSONObjectOptJSONObject.optString("package");
                        JSONArray jSONArray2 = jSONObjectOptJSONObject.getJSONArray("data");
                        if (jSONArray2 != null) {
                            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                                if (jSONObject2 != null) {
                                    int i5 = jSONObject2.getInt("wake_type");
                                    int i6 = jSONObject2.getInt("wake_status");
                                    if (map.containsKey(strOptString2)) {
                                        Map map2 = (Map) map.get(strOptString2);
                                        if (map2.containsKey(Integer.valueOf(i5))) {
                                            Map map3 = (Map) map2.get(Integer.valueOf(i5));
                                            if (map3.containsKey(Integer.valueOf(i6))) {
                                                map3.put(Integer.valueOf(i6), Integer.valueOf(((Integer) map3.get(Integer.valueOf(i6))).intValue() + 1));
                                            } else {
                                                map3.put(Integer.valueOf(i6), 1);
                                            }
                                            map2.put(Integer.valueOf(i5), map3);
                                        } else {
                                            HashMap map4 = new HashMap();
                                            map4.put(Integer.valueOf(i6), 1);
                                            map2.put(Integer.valueOf(i5), map4);
                                        }
                                        map.put(strOptString2, map2);
                                    } else {
                                        HashMap map5 = new HashMap();
                                        map5.put(Integer.valueOf(i6), 1);
                                        HashMap map6 = new HashMap();
                                        map6.put(Integer.valueOf(i5), map5);
                                        map.put(strOptString2, map6);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    p63.f("JWakeHelper", "unkown type :" + strOptString);
                }
                i2++;
            }
            JSONArray jSONArray3 = new JSONArray();
            JSONArray jSONArray4 = new JSONArray();
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("p", entry.getKey());
                JSONArray jSONArray5 = new JSONArray();
                Iterator it2 = ((Map) entry.getValue()).entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    Integer num = (Integer) entry2.getKey();
                    Map map7 = (Map) entry2.getValue();
                    int iIntValue = map7.containsKey(Integer.valueOf(i)) ? ((Integer) map7.get(Integer.valueOf(i))).intValue() : 0;
                    int iIntValue2 = map7.containsKey(101) ? ((Integer) map7.get(101)).intValue() : 0;
                    Iterator it3 = it;
                    int iIntValue3 = map7.containsKey(102) ? ((Integer) map7.get(102)).intValue() : 0;
                    Iterator it4 = it2;
                    int iIntValue4 = map7.containsKey(103) ? ((Integer) map7.get(103)).intValue() : 0;
                    jSONArray5.put(num + "_" + (iIntValue + iIntValue2 + iIntValue3 + iIntValue4) + "_" + iIntValue + "_" + iIntValue2 + "_" + iIntValue3 + "_" + iIntValue4);
                    it = it3;
                    it2 = it4;
                    i = 1;
                }
                jSONObject3.put("d", jSONArray5);
                jSONArray4.put(jSONObject3);
                it = it;
                i = 1;
            }
            if (jSONArray4.length() > 0) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("t", jSONArray4);
                jSONObject4.put("itime", rv2.q(context));
                jSONObject4.put("type", "aa3");
                jSONArray3.put(jSONObject4);
            }
            return jSONArray3.length() > 0 ? jSONArray3 : jSONArray;
        } catch (Throwable th) {
            p63.g("JWakeHelper", "merge wake json failed:" + th.getMessage());
            return null;
        }
    }

    public static void r(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            p63.a("JWakeHelper", "save wake data : " + jSONObject.toString());
            jSONObject.put("itime", rv2.q(context));
            jSONObject.put("type", "aa3");
            synchronized ("wake_cache_v2.json") {
                JSONObject jSONObjectA = mv2.a(context, "wake_cache_v2.json");
                if (jSONObjectA == null) {
                    jSONObjectA = new JSONObject();
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("content");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject);
                jSONObjectA.put("content", jSONArrayOptJSONArray);
                mv2.c(context, "wake_cache_v2.json", jSONObjectA);
            }
        } catch (Throwable th) {
            p63.f("JWakeHelper", "saveWakeData failed:" + th.getMessage());
        }
    }

    public static void s(Context context, kx2 kx2Var, List<qx2> list) {
        JSONObject jSONObjectL = l(list);
        JKeepLiveReportHelper.getInstance().reportSend(jSONObjectL);
        if (!kx2Var.t) {
            p63.f("JWakeHelper", "server set do not report wake data,give up save");
            return;
        }
        p63.a("JWakeHelper", "wake json:" + jSONObjectL);
        r(context, jSONObjectL);
    }

    public static List<String> t(kx2 kx2Var, List<String> list) {
        return h(kx2Var.p, list);
    }

    public static List<String> u(kx2 kx2Var, List<String> list) {
        if (TextUtils.isEmpty(kx2Var.n) || kx2Var.n.equals("disable")) {
            return list;
        }
        List<String> list2 = kx2Var.o;
        String str = kx2Var.n;
        str.hashCode();
        return !str.equals("exclude") ? !str.equals("include") ? list : a(list2, list) : h(list2, list);
    }
}
