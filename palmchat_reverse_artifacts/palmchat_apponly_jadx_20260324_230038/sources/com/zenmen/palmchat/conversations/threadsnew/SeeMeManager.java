package com.zenmen.palmchat.conversations.threadsnew;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.conversations.threadsnew.a;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ax4;
import defpackage.bo0;
import defpackage.fg6;
import defpackage.i53;
import defpackage.n53;
import defpackage.rl0;
import defpackage.t45;
import defpackage.tg4;
import defpackage.vm0;
import defpackage.vs0;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SeeMeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13777a = "SeeMeManager";
    public static int b = 1;
    public static long c;
    public static JSONArray d;

    /* JADX INFO: compiled from: SearchBox */
    public static class LoadingWatcher<D> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Status f13778a;
        public D b;

        /* JADX INFO: compiled from: SearchBox */
        public enum Status {
            LOADING,
            SUCCESS,
            FAILURE
        }

        public LoadingWatcher() {
            this.f13778a = Status.LOADING;
            this.b = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadingWatcher f13780a;
        public final /* synthetic */ LoadingWatcher b;
        public final /* synthetic */ int c;
        public final /* synthetic */ t45 d;
        public final /* synthetic */ d e;

        public b(LoadingWatcher loadingWatcher, LoadingWatcher loadingWatcher2, int i, t45 t45Var, d dVar) {
            this.f13780a = loadingWatcher;
            this.b = loadingWatcher2;
            this.c = i;
            this.d = t45Var;
            this.e = dVar;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LoadingWatcher loadingWatcher = this.f13780a;
            LoadingWatcher.Status status = LoadingWatcher.Status.FAILURE;
            loadingWatcher.f13778a = status;
            if (this.b.f13778a != status) {
                this.e.onException(exc);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            if (jSONObject == 0) {
                onFail(new Exception("data is null"));
                return;
            }
            int iOptInt = jSONObject.optInt("resultCode", -1);
            if (iOptInt != 0) {
                onFail(new Exception("code is wrong:" + iOptInt));
                return;
            }
            LoadingWatcher loadingWatcher = this.f13780a;
            LoadingWatcher.Status status = LoadingWatcher.Status.SUCCESS;
            loadingWatcher.f13778a = status;
            loadingWatcher.b = jSONObject;
            LoadingWatcher loadingWatcher2 = this.b;
            if (loadingWatcher2.f13778a == status) {
                SeeMeManager.m(this.c, this.d, (JSONArray) loadingWatcher2.b, jSONObject, this.e);
            } else if (SeeMeManager.d != null) {
                SeeMeManager.m(this.c, this.d, SeeMeManager.d, jSONObject, this.e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadingWatcher f13781a;
        public final /* synthetic */ LoadingWatcher b;
        public final /* synthetic */ d c;
        public final /* synthetic */ int d;
        public final /* synthetic */ t45 e;

        public c(LoadingWatcher loadingWatcher, LoadingWatcher loadingWatcher2, d dVar, int i, t45 t45Var) {
            this.f13781a = loadingWatcher;
            this.b = loadingWatcher2;
            this.c = dVar;
            this.d = i;
            this.e = t45Var;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LoadingWatcher loadingWatcher = this.f13781a;
            LoadingWatcher.Status status = LoadingWatcher.Status.FAILURE;
            loadingWatcher.f13778a = status;
            if (this.b.f13778a != status) {
                this.c.onException(exc);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [D, org.json.JSONArray] */
        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            if (jSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            int iOptInt = jSONObject.optInt("resultCode", -1);
            if (iOptInt != 0) {
                onFail(new Exception("code is wrong:" + iOptInt));
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("iamVip", false);
            ?? OptJSONArray = jSONObjectOptJSONObject.optJSONArray("resultList");
            if (zOptBoolean || OptJSONArray == 0 || OptJSONArray.length() <= 0) {
                LoadingWatcher loadingWatcher = this.f13781a;
                LoadingWatcher.Status status = LoadingWatcher.Status.FAILURE;
                loadingWatcher.f13778a = status;
                if (this.b.f13778a != status) {
                    this.c.b();
                    return;
                }
                return;
            }
            LoadingWatcher loadingWatcher2 = this.f13781a;
            LoadingWatcher.Status status2 = LoadingWatcher.Status.SUCCESS;
            loadingWatcher2.f13778a = status2;
            loadingWatcher2.b = OptJSONArray;
            SeeMeManager.d = OptJSONArray;
            LoadingWatcher loadingWatcher3 = this.b;
            if (loadingWatcher3.f13778a == status2) {
                SeeMeManager.m(this.d, this.e, OptJSONArray, (JSONObject) loadingWatcher3.b, this.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(t45 t45Var, com.zenmen.palmchat.conversations.threadsnew.a aVar);

        void b();

        void onException(Exception exc);
    }

    public static String f(long j) {
        if (j < 1000) {
            return j + "米";
        }
        return (j / 1000) + "千米";
    }

    public static String g(long j) {
        long j2 = j / 1000;
        if (j2 < 60) {
            return "刚刚";
        }
        if (j2 < 3600) {
            return (j2 / 60) + "分钟前";
        }
        if (j2 < 86400) {
            return (j2 / 3600) + "小时前";
        }
        if (j2 < 2592000) {
            return (j2 / 86400) + "天前";
        }
        if (j2 >= 31104000) {
            return "1年前";
        }
        return (j2 / 2592000) + "月前";
    }

    public static void h(String str) {
        String str2 = f13777a;
        LogUtil.d(str2, "SeeMeManager getConfigData res " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b = new JSONObject(str).optInt("requestTime");
            LogUtil.d(str2, "SeeMeManager getConfigData mRequestAllowTime " + b);
        } catch (Exception unused) {
        }
    }

    public static t45 i() {
        t45 t45Var = new t45();
        JSONObject config = vs0.a().getConfig("vip_seeme");
        if (config == null) {
            return t45Var;
        }
        try {
            t45Var.f20902a = config.optBoolean("enable", t45Var.f20902a);
            t45Var.b = config.optInt("topType", t45Var.b);
            t45Var.c = config.optDouble("topLimit", t45Var.c);
            t45Var.d = config.optString("jumpPage", t45Var.d);
            t45Var.e = config.optString("mainText", t45Var.e);
            t45Var.i = config.optInt(EventParams.KEY_CT_SDK_POSITION, 0);
            JSONArray jSONArrayOptJSONArray = config.optJSONArray(LxAdDLManager.ITEM_DESC);
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(strOptString);
                    }
                }
                if (!arrayList.isEmpty()) {
                    t45Var.f.clear();
                    t45Var.f.addAll(arrayList);
                }
            }
            t45Var.g = config.optInt("antorun", t45Var.g);
            t45Var.h = config.optString("button", t45Var.h);
        } catch (Exception e) {
            LogUtil.e(f13777a, "get seeme config failed.", e);
        }
        return t45Var;
    }

    public static void j() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SEEME_REQUEST_TIME_ALLOW);
        String str = f13777a;
        LogUtil.d(str, "SeeMeManager initAdConfig item " + dynamicConfig);
        if (dynamicConfig == null || !dynamicConfig.isEnable() || TextUtils.isEmpty(dynamicConfig.getExtra())) {
            LogUtil.d(str, "SeeMeManager initAdConfig, item is null ");
        } else {
            h(dynamicConfig.getExtra());
        }
    }

    public static void k(Context context, d dVar) {
        if (tg4.b(context, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList)) {
            com.zenmen.palmchat.location.d.g().k(LocationScene.TAB_MSG, new a(context, dVar));
        } else {
            l(context, dVar, null);
        }
    }

    public static void l(Context context, d dVar, LocationEx locationEx) {
        String strP = AccountUtils.p(context);
        ContactInfoItem contactInfoItemL = bo0.r().l(strP);
        if (contactInfoItemL != null && fg6.q(fg6.g(contactInfoItemL.getExt()))) {
            LogUtil.i(f13777a, "is VIP, callback 'onNotShow'...");
            dVar.b();
            return;
        }
        int gender = contactInfoItemL == null ? -1 : contactInfoItemL.getGender();
        t45 t45VarI = i();
        if (!t45VarI.f20902a) {
            LogUtil.i(f13777a, "config is disable, callback 'onNotShow'...");
            dVar.b();
            return;
        }
        LoadingWatcher loadingWatcher = new LoadingWatcher();
        LoadingWatcher loadingWatcher2 = new LoadingWatcher();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, strP);
            jSONObject.put("index", 0);
            if (locationEx != null) {
                jSONObject.put("latitude", locationEx.getLatitude());
                jSONObject.put("longitude", locationEx.getLongitude());
            }
            ax4.l(new b(loadingWatcher2, loadingWatcher, gender, t45VarI, dVar));
            String str = f13777a;
            LogUtil.d(str, "SeeMeManager loadSeeMeInfoImpl lastTime:" + c);
            if (System.currentTimeMillis() - c < b * 60 * 1000) {
                LogUtil.i(str, "SeeMeManager time not allow");
                if (dVar != null) {
                    dVar.onException(new Exception("time not allow"));
                    return;
                }
                return;
            }
            c = System.currentTimeMillis();
            LogUtil.i(str, "SeeMeManager time allow lastTime " + c);
            zw4.f(vm0.c1, 1, jSONObject, new c(loadingWatcher, loadingWatcher2, dVar, gender, t45VarI));
        } catch (JSONException e) {
            dVar.onException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m(int i, t45 t45Var, JSONArray jSONArray, JSONObject jSONObject, d dVar) {
        long jCurrentTimeMillis;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        com.zenmen.palmchat.conversations.threadsnew.a aVar = new com.zenmen.palmchat.conversations.threadsnew.a();
        aVar.f13810a = t45Var.e;
        aVar.b = new ArrayList(t45Var.f);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("data");
        long j = 1;
        if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject3.optJSONObject("lookMes")) != null) {
            long jOptLong = jSONObjectOptJSONObject2.optLong("total", 100L);
            long jOptLong2 = jSONObjectOptJSONObject2.optLong("unreadCount", 1L);
            j = jOptLong > 0 ? jOptLong : 100L;
            if (jOptLong2 > 0) {
                j = jOptLong2;
            }
        }
        aVar.d = j;
        String str = j > 99 ? "99+" : j + "";
        String str2 = j <= 99 ? j + "" : "99+";
        String strN = n(aVar.f13810a, "m", str);
        aVar.f13810a = strN;
        aVar.f13810a = n(strN, "n", str2);
        ArrayList arrayList = new ArrayList(aVar.b.size());
        Iterator<String> it = aVar.b.iterator();
        while (it.hasNext()) {
            arrayList.add(n(n(it.next(), "m", str), "n", str2));
        }
        aVar.b = arrayList;
        aVar.c = new ArrayList();
        long j2 = -1;
        long j3 = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject4 = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject4 != null) {
                int iOptInt = jSONObjectOptJSONObject4.optInt("gender", -1);
                if (aVar.c.size() < 3 && iOptInt != -1) {
                    if (iOptInt != i) {
                        aVar.c.add(a.C1037a.a(jSONObjectOptJSONObject4));
                    }
                }
                long jOptLong3 = jSONObjectOptJSONObject4.optLong("distanceMi", -1L);
                long jOptLong4 = jSONObjectOptJSONObject4.optLong("visitTime", -1L);
                if (jOptLong3 != -1 && (j3 == -1 || jOptLong3 < j3)) {
                    j3 = jOptLong3;
                }
                if (jOptLong4 != -1 && (j2 == -1 || jOptLong4 > j2)) {
                    j2 = jOptLong4;
                }
            }
        }
        if (aVar.c.size() <= 0 && (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) != null) {
            aVar.c.add(a.C1037a.a(jSONObjectOptJSONObject));
        }
        if (j3 <= 0) {
            j3 = 1000;
        }
        String strF = f(j3);
        if (j2 != -1) {
            jCurrentTimeMillis = System.currentTimeMillis() - j2;
            if (jCurrentTimeMillis < 0) {
                jCurrentTimeMillis = 3600000;
            }
        }
        String strG = g(jCurrentTimeMillis);
        String strN2 = n(aVar.f13810a, "d", strF);
        aVar.f13810a = strN2;
        aVar.f13810a = n(strN2, t.f7496a, strG);
        ArrayList arrayList2 = new ArrayList(aVar.b.size());
        Iterator<String> it2 = aVar.b.iterator();
        while (it2.hasNext()) {
            arrayList2.add(n(n(it2.next(), "d", strF), t.f7496a, strG));
        }
        aVar.b = arrayList2;
        dVar.a(t45Var, aVar);
    }

    public static String n(String str, String str2, String str3) {
        if (str2.equals("")) {
            throw new IllegalArgumentException("Old pattern must have content.");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                stringBuffer.append(str.substring(length));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(length, iIndexOf));
            stringBuffer.append(str3);
            length = str2.length() + iIndexOf;
        }
    }

    public static void o(String str) {
        LogUtil.d(f13777a, "SeeMeManager updateConfig res " + str);
        h(str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements i53 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13779a;
        public final /* synthetic */ d b;

        public a(Context context, d dVar) {
            this.f13779a = context;
            this.b = dVar;
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            LogUtil.i(SeeMeManager.f13777a, "get location success " + locationEx + Thread.currentThread().getName());
            if (i != 0 || locationEx == null) {
                SeeMeManager.l(this.f13779a, this.b, null);
            } else {
                SeeMeManager.l(this.f13779a, this.b, locationEx);
            }
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
