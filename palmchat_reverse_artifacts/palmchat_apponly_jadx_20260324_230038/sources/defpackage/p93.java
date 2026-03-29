package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class p93 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19966a = "p93";
    public static l93 b = new l93();
    public static boolean c = false;
    public static WeakReference<o93> d;
    public static WeakReference<q93> e;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19968a;
        public final /* synthetic */ Activity b;

        public b(String str, Activity activity) {
            this.f19968a = str;
            this.b = activity;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LogUtil.e(p93.f19966a, "get love match info failed.", exc);
            p93.c = false;
            n93.h(this.f19968a, false, "");
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i(p93.f19966a, "======get love match info:" + jSONObject);
            p93.c = false;
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
            if (!jSONObjectOptJSONObject.optBoolean(bq.b.V, false)) {
                n93.h(this.f19968a, false, "");
                LogUtil.i(p93.f19966a, "server result returns not showing");
                return;
            }
            int iOptInt2 = jSONObjectOptJSONObject.optInt("remainNum", -1);
            if (iOptInt2 == -1) {
                onFail(new Exception("remainNum is null"));
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("loveMatchInfoList");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                n93.h(this.f19968a, false, "");
                LogUtil.i(p93.f19966a, "server result returns empty");
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(0);
            if (jSONObjectOptJSONObject2 == null) {
                n93.h(this.f19968a, false, "");
                LogUtil.i(p93.f19966a, "server result returns empty");
                return;
            }
            n93.h(this.f19968a, true, jSONObjectOptJSONObject2.optString(DeviceInfoUtil.UID_TAG, ""));
            if ((!fg6.d(this.b) || iOptInt2 > 0) && !this.b.isFinishing()) {
                q93 q93VarI = p93.i();
                if (q93VarI != null) {
                    q93VarI.dismiss();
                }
                if (p93.b.c == 1 && tg4.b(this.b, "android.permission.VIBRATE")) {
                    Vibrator vibrator = (Vibrator) this.b.getSystemService("vibrator");
                    if (vibrator.hasVibrator()) {
                        vibrator.vibrate(2000L);
                    }
                }
                o93 o93VarJ = p93.j();
                if (o93VarJ == null) {
                    o93VarJ = new o93(this.b);
                    o93VarJ.show();
                    p93.d = new WeakReference(o93VarJ);
                }
                o93VarJ.m(jSONObjectOptJSONObject2, iOptInt2, this.f19968a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f19969a;
        public final /* synthetic */ kd5 b;

        public c(Activity activity, kd5 kd5Var) {
            this.f19969a = activity;
            this.b = kd5Var;
        }

        @Override // p93.f
        public void a(ContactInfoItem contactInfoItem) {
            Activity activity = this.f19969a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            kd5 kd5Var = this.b;
            if (kd5Var != null) {
                kd5Var.dismiss();
            }
            if (contactInfoItem != null) {
                p93.q(this.f19969a, contactInfoItem);
            }
        }

        @Override // p93.f
        public void onError(String str) {
            Activity activity = this.f19969a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            kd5 kd5Var = this.b;
            if (kd5Var != null) {
                kd5Var.dismiss();
            }
            sy5.e(this.f19969a, R.string.get_user_info_failed, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f19970a;

        public d(f fVar) {
            this.f19970a = fVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject.optInt("resultCode") != 0) {
                this.f19970a.onError("");
                return;
            }
            try {
                ContactInfoItem contactInfoItemP = l92.p(jSONObject);
                if (contactInfoItemP == null) {
                    this.f19970a.onError("");
                    return;
                }
                ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItemP.getUid());
                if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
                    if (contactInfoItemL != null) {
                        contactInfoItemP.setRemarkName(contactInfoItemL.getRemarkName());
                        contactInfoItemP.setDescription(contactInfoItemL.getDescription());
                    }
                    AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.a(contactInfoItemP));
                }
                this.f19970a.a(contactInfoItemP);
            } catch (Exception e) {
                this.f19970a.onError("");
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f19971a;

        public e(f fVar) {
            this.f19971a = fVar;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f19971a.onError("");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(ContactInfoItem contactInfoItem);

        void onError(String str);
    }

    public static q93 i() {
        WeakReference<q93> weakReference = e;
        q93 q93Var = weakReference == null ? null : weakReference.get();
        if (q93Var == null || !q93Var.isShowing() || q93Var.e().isFinishing()) {
            return null;
        }
        return q93Var;
    }

    public static o93 j() {
        WeakReference<o93> weakReference = d;
        o93 o93Var = weakReference == null ? null : weakReference.get();
        if (o93Var == null || !o93Var.isShowing() || o93Var.k().isFinishing()) {
            return null;
        }
        return o93Var;
    }

    public static l93 k(JSONObject jSONObject) {
        WifiLog.d("LoveMatchManager createConfigModel ");
        l93 l93Var = new l93();
        if (jSONObject != null) {
            WifiLog.d("LoveMatchManager createConfigModel allObject " + jSONObject);
            l93Var.f18934a = jSONObject.optInt("switch", l93Var.f18934a);
            int iOptInt = jSONObject.optInt("frequencyInterval", l93Var.b);
            if (iOptInt < 0) {
                iOptInt = l93Var.b;
            }
            l93Var.b = iOptInt;
            l93Var.c = jSONObject.optInt("vibrationSwitch", l93Var.c);
            String strOptString = jSONObject.optString("button", l93Var.d);
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = l93Var.d;
            }
            l93Var.d = strOptString;
        }
        return l93Var;
    }

    public static void l() {
        WifiLog.d("LoveMatchManager getAdConfig ");
        b = new l93();
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.HEARTBEAT_MATCH);
        if (dynamicConfig != null) {
            String extra = dynamicConfig.getExtra();
            if (TextUtils.isEmpty(extra)) {
                return;
            }
            try {
                b = k(new JSONObject(extra));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static l93 m() {
        return b;
    }

    public static void n(String str, f fVar) {
        ContactInfoItem contactInfoItemA = dn0.a(str);
        if (contactInfoItemA != null) {
            fVar.a(contactInfoItemA);
            return;
        }
        try {
            new l92(new d(fVar), new e(fVar)).n(str);
        } catch (DaoException e2) {
            e2.printStackTrace();
            fVar.onError("");
        }
    }

    public static long o() {
        return SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, k86.a("key_lovematch_pre_request_time"), -1L);
    }

    public static void p(Activity activity, String str) {
        n(str, new c(activity, activity != null ? kd5.b(activity) : null));
    }

    public static void q(Activity activity, ContactInfoItem contactInfoItem) {
        contactInfoItem.setBizType(5003);
        contactInfoItem.setSourceType(fu5.n(5003));
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
        intent.putExtra("chat_item", contactInfoItem);
        intent.putExtra("thread_biz_type", contactInfoItem.getBizType());
        intent.putExtra("chat_need_back_to_main", false);
        intent.putExtra("chat_back_to_greet", false);
        k86.X(intent);
        activity.startActivity(intent);
    }

    public static void r(Activity activity) {
        if (b.f18934a != 1) {
            LogUtil.i(f19966a, "request love match abort: switch closed");
            return;
        }
        if (c) {
            LogUtil.i(f19966a, "request love match abort: in requesting");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jO = o();
        if (jO != -1 && Math.abs(jCurrentTimeMillis - jO) < b.b * 60 * 1000) {
            LogUtil.i(f19966a, "request love match abort: frequency not allowed");
            return;
        }
        t(jCurrentTimeMillis);
        c = true;
        String string = UUID.randomUUID().toString();
        n93.g(string);
        if (!tg4.b(activity, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList)) {
            s(activity, null, string);
        } else {
            new Handler(Looper.getMainLooper());
            com.zenmen.palmchat.location.d.g().k(LocationScene.LOVE_MATCH, new a(activity, string));
        }
    }

    public static void s(Activity activity, LocationEx locationEx, String str) {
        JSONObject jSONObject = new JSONObject();
        if (locationEx != null) {
            try {
                jSONObject.put("latitude", locationEx.getLatitude());
                jSONObject.put("longitude", locationEx.getLongitude());
                jSONObject.put("cityCode", locationEx.getCityCode());
            } catch (JSONException e2) {
                LogUtil.e(f19966a, "pack params failed.", e2);
                c = false;
                return;
            }
        }
        jSONObject.put("reqId", str);
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(activity));
        if (contactInfoItemL != null) {
            jSONObject.put("sex", contactInfoItemL.getGender());
            jSONObject.put("age", contactInfoItemL.getAgeInt());
        }
        jSONObject.put("from", 2);
        zw4.f(vm0.d1, 1, jSONObject, new b(str, activity));
    }

    public static void t(long j) {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_lovematch_pre_request_time"), Long.valueOf(j));
    }

    public static boolean u(Activity activity, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(DeviceInfoUtil.UID_TAG, "");
        n93.d(strOptString);
        if (j() != null) {
            n93.e(strOptString, 1);
            return false;
        }
        q93 q93VarI = i();
        if (q93VarI == null) {
            q93VarI = new q93(activity);
            q93VarI.show();
            e = new WeakReference<>(q93VarI);
        }
        q93VarI.f(jSONObject);
        return true;
    }

    public static void v(String str) {
        WifiLog.d("LoveMatchManager updateAdConfig ");
        b = new l93();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b = k(new JSONObject(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements i53 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f19967a;
        public final /* synthetic */ String b;

        public a(Activity activity, String str) {
            this.f19967a = activity;
            this.b = str;
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            p93.s(this.f19967a, locationEx, this.b);
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
