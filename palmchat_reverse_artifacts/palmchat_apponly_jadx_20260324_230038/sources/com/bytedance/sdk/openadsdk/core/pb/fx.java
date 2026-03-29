package com.bytedance.sdk.openadsdk.core.pb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.d;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.bf;
import com.bytedance.sdk.openadsdk.core.y.gi;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.xw;
import com.huawei.openalliance.ad.constant.be;
import com.igexin.sdk.PushConsts;
import com.lantern.auth.server.WkParams;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends com.bytedance.sdk.component.jk.a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile fx u;
    private AtomicBoolean b;
    private final u fx;
    private volatile AtomicBoolean iz;
    private final Context nr;
    private boolean pn;
    private Comparator<JSONObject> x;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public static String u(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u {
        private com.bytedance.sdk.component.b.nr.fx nr;

        public u(Context context) {
            try {
                this.nr = u(context);
            } catch (Throwable unused) {
            }
        }

        private com.bytedance.sdk.component.b.nr.fx u(Context context) {
            try {
                return bf.u("tt_sp_app_list");
            } catch (Exception unused) {
                return null;
            }
        }

        public boolean fx() {
            com.bytedance.sdk.component.b.nr.fx fxVar = this.nr;
            return !jp.u(fxVar != null ? fxVar.get("day_update_time", 0L) : 0L, System.currentTimeMillis());
        }

        public String nr() {
            com.bytedance.sdk.component.b.nr.fx fxVar = this.nr;
            return fxVar == null ? "" : fxVar.get("old_app_list", "");
        }

        public void u(String str) {
            com.bytedance.sdk.component.b.nr.fx fxVar;
            if (TextUtils.isEmpty(str) || (fxVar = this.nr) == null) {
                return;
            }
            fxVar.put("old_app_list", str);
        }

        public void u() {
            com.bytedance.sdk.component.b.nr.fx fxVar = this.nr;
            if (fxVar == null) {
                return;
            }
            fxVar.put("day_update_time", System.currentTimeMillis());
        }
    }

    private fx() {
        super("ApplistHelper");
        this.b = new AtomicBoolean(false);
        this.pn = false;
        this.iz = new AtomicBoolean(true);
        this.x = new Comparator<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.pb.fx.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString("package_name").compareTo(jSONObject2.optString("package_name"));
            }
        };
        Context context = dw.getContext();
        this.nr = context;
        this.fx = new u(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!o.u(this.nr)) {
            this.b.set(false);
            return;
        }
        try {
            boolean zFx = this.fx.fx();
            this.iz.set(false);
            if (zFx) {
                nr(nr(this.nr));
            } else {
                this.b.set(false);
            }
        } catch (Throwable unused) {
            this.b.set(false);
        }
    }

    public static fx u() {
        if (u == null) {
            synchronized (fx.class) {
                if (u == null) {
                    u = new fx();
                }
            }
        }
        return u;
    }

    public void nr() {
        if (jp.nr()) {
            this.pn = dw.nr().bl() && com.bytedance.sdk.openadsdk.core.n.o().sx().nr();
            if (n.b() && this.iz.get() && !this.b.get()) {
                this.b.set(true);
                try {
                    com.bytedance.sdk.component.jk.x.u(this, 1);
                } catch (Throwable unused) {
                    this.b.set(false);
                }
            }
        }
    }

    public List<String> u(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.u.fx(nr.u("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = d.u(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(d.u(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((objInvoke instanceof List) && (list = (List) objInvoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        if (u(packageInfo) != 1) {
                            arrayList.add("unknown:" + packageInfo.packageName);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private List<JSONObject> nr(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (context == null || !this.pn || (gi.c() && Build.VERSION.SDK_INT >= 29)) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.u.fx(nr.u("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = d.u(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(d.u(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((objInvoke instanceof List) && (list = (List) objInvoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("package_name", packageInfo.packageName);
                        jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                        jSONObject2.put("last_update_time", packageInfo.lastUpdateTime);
                        jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                        jSONObject2.put("version_code", packageInfo.versionCode);
                        jSONObject2.put("app_name", "unknown");
                        jSONObject2.put("app_type", u(packageInfo));
                        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                        jSONObject2.put("apk_dir", applicationInfo != null ? applicationInfo.sourceDir : "unknown");
                        arrayList.add(jSONObject2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private int u(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null || (applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
            return 2;
        }
        return 1 & packageInfo.applicationInfo.flags;
    }

    private boolean u(List<JSONObject> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Collections.sort(list, this.x);
        String strFx = com.bytedance.sdk.component.utils.u.fx(this.fx.nr());
        if (TextUtils.isEmpty(strFx)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(strFx);
            int length = jSONArray.length();
            if (length != list.size()) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getJSONObject(i));
            }
            Collections.sort(arrayList, this.x);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = list.get(i2);
                JSONObject jSONObject2 = (JSONObject) arrayList.get(i2);
                String strOptString = jSONObject.optString("package_name");
                String strOptString2 = jSONObject.optString("last_update_time");
                if (strOptString == null || strOptString2 == null || !strOptString.equals(jSONObject2.optString("package_name")) || !strOptString2.equals(jSONObject2.optString("last_update_time"))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            k.u("ApplistHelper", "is app change error: ", th);
            return true;
        }
    }

    private void nr(final List<JSONObject> list) {
        boolean zU = u(list);
        JSONObject jSONObjectU = u(zU ? list : new ArrayList<>(), dw.nr().qf(), dw.nr().qb());
        if (list != null) {
            list.size();
        }
        xw xwVar = new xw(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().iz());
        xwVar.u(jp.n("/api/ad/union/sdk/upload/app_info/"));
        xwVar.fx(jSONObjectU, "applist");
        xwVar.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.pb.fx.2
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                if (nrVar == null || !nrVar.a() || TextUtils.isEmpty(nrVar.pn())) {
                    fx.this.iz.set(true);
                } else {
                    try {
                        if (PushConsts.SEND_MESSAGE_ERROR.equals(new JSONObject(nrVar.pn()).optString("status"))) {
                            fx.this.fx.u();
                            fx.this.fx.u(com.bytedance.sdk.component.utils.u.nr(new JSONArray((Collection) list).toString()));
                        }
                    } catch (JSONException unused) {
                    }
                }
                fx.this.b.set(false);
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                fx.this.b.set(false);
                fx.this.iz.set(true);
            }
        });
    }

    private JSONObject u(List<JSONObject> list, List<String> list2, List<String> list3) {
        int i;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            String strN = com.bytedance.sdk.openadsdk.core.y.jk.n();
            Object obj2 = "";
            if (TextUtils.isEmpty(strN)) {
                strN = "";
            }
            if (TextUtils.isEmpty(strN)) {
                i = -1;
                obj = "";
            } else {
                obj = strN;
                i = 1;
            }
            int i2 = 0;
            String strFx = com.bytedance.sdk.openadsdk.core.y.jk.fx(false);
            if (TextUtils.isEmpty(strFx)) {
                strFx = "";
            }
            if (i < 0 && !TextUtils.isEmpty(strFx)) {
                i = 4;
                obj = strFx;
            }
            String strU = com.bytedance.sdk.openadsdk.core.y.jk.u();
            if (TextUtils.isEmpty(strU)) {
                strU = "";
            }
            String strO = com.bytedance.sdk.openadsdk.core.y.jk.o();
            if (!TextUtils.isEmpty(strO)) {
                obj2 = strO;
            }
            if (i < 0) {
                i = 3;
                obj = strU;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<JSONObject> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().optString("package_name"));
            }
            jSONObject.put("app_list", jSONArray);
            jSONObject.put(be.D, new JSONArray((Collection) list));
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("device_id", obj);
            jSONObject.put("did", sx.fx());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_platform", "android");
            jSONObject.put("device_model", com.bytedance.sdk.openadsdk.core.y.jk.nr());
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.n.o().c());
            jSONObject.put("app_list_type", 1);
            jSONObject.put("sdk_version", com.bytedance.sdk.openadsdk.core.d.b);
            jSONObject.put("device_id_type", i);
            jSONObject.put(WkParams.IMEI, strN);
            jSONObject.put("oaid", strFx);
            jSONObject.put("applog_did", obj2);
            jSONObject.put("android_id", strU);
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (jp.fx(dw.getContext(), str)) {
                                jSONArray2.put(str);
                            } else {
                                jSONArray3.put(str);
                            }
                        } catch (Throwable unused) {
                            jSONArray3.put(str);
                        }
                    }
                }
                jSONObject.put("have_applist", jSONArray2);
                jSONObject.put("no_applist", jSONArray3);
            }
            boolean zWj = dw.nr().wj();
            if (!zWj) {
                i2 = 1;
            }
            jSONObject.put("scheme_get_type", i2);
            if (list3 != null && !list3.isEmpty() && zWj) {
                for (String str2 : list3) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Uri uri = Uri.parse(str2);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(uri);
                            jp.u(dw.getContext(), intent, true);
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
            Map<String, Boolean> mapU = com.bytedance.sdk.openadsdk.core.y.d.u(259200000L);
            if (mapU != null && mapU.size() > 0) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (Map.Entry<String, Boolean> entry : mapU.entrySet()) {
                    if (entry.getValue().booleanValue()) {
                        jSONArray4.put(entry.getKey());
                    } else {
                        jSONArray5.put(entry.getKey());
                    }
                }
                jSONObject.put("scheme_success_list", jSONArray4);
                jSONObject.put("scheme_fail_list", jSONArray5);
            }
            List<String> listU = jp.u();
            if (listU.size() > 0) {
                jSONObject.put("query_all_package", listU);
            }
        } catch (Exception unused3) {
        }
        return jSONObject;
    }
}
