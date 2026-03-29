package defpackage;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.umeng.ccg.a;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.login.InitActivity;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class bp4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1796a = "bp4";
    public static AtomicLong b = new AtomicLong(0);
    public static AtomicLong c = new AtomicLong(0);

    public static void A(long j) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        if (sPUtil.i(scene, "key_pull_wake_chat_card_expire_time", 0L) < j) {
            sPUtil.t(scene, "key_pull_wake_chat_card_expire_time", Long.valueOf(j));
        }
    }

    public static void B(long j) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        if (sPUtil.i(scene, "key_pull_wake_expire_time", 0L) < j) {
            sPUtil.t(scene, "key_pull_wake_expire_time", Long.valueOf(j));
        }
    }

    public static void C(long j) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        if (sPUtil.i(scene, "key_pull_wake_enhanced_expire_time", 0L) < j) {
            sPUtil.t(scene, "key_pull_wake_enhanced_expire_time", Long.valueOf(j));
        }
    }

    public static void D(long j) {
        c.set(j);
    }

    public static void E() {
        try {
            if (Math.abs(System.currentTimeMillis() - b.get()) < 1000) {
                return;
            }
            b.set(System.currentTimeMillis());
            long jN = n();
            if (jN > 0) {
                if (!AppContext.getContext().isBackground() || jN <= System.currentTimeMillis()) {
                    dp4.a().f(3, 0, null);
                } else {
                    t();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        if (TextUtils.isEmpty(sPUtil.n(scene, "key_pull_wake_content_chat_card", ""))) {
            return;
        }
        sPUtil.t(scene, "key_pull_wake_content_chat_card", "");
    }

    public static void b() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        if (TextUtils.isEmpty(sPUtil.n(scene, "key_pull_wake_content_common", ""))) {
            return;
        }
        sPUtil.t(scene, "key_pull_wake_content_common", "");
    }

    public static void c() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        if (TextUtils.isEmpty(sPUtil.n(scene, "key_pull_wake_content_enhanced", ""))) {
            return;
        }
        sPUtil.t(scene, "key_pull_wake_content_enhanced", "");
    }

    public static void d() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        if (sPUtil.i(scene, "key_pull_wake_chat_card_expire_time", 0L) > 0) {
            sPUtil.t(scene, "key_pull_wake_chat_card_expire_time", 0L);
        }
    }

    public static void e() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        if (sPUtil.i(scene, "key_pull_wake_expire_time", 0L) > 0) {
            sPUtil.t(scene, "key_pull_wake_expire_time", 0L);
        }
    }

    public static void f() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        if (sPUtil.i(scene, "key_pull_wake_enhanced_expire_time", 0L) > 0) {
            sPUtil.t(scene, "key_pull_wake_enhanced_expire_time", 0L);
        }
    }

    public static void g() {
        if (!jo6.E()) {
            e();
            f();
            return;
        }
        long jK = k();
        if (jK > 0) {
            d();
            if (jK > System.currentTimeMillis()) {
                return;
            }
        }
        long jL = l();
        if (jL > 0) {
            e();
            if (jL > System.currentTimeMillis()) {
                return;
            }
        }
        f();
    }

    public static JSONObject h(int i, String str) {
        JSONObject jSONObjectOptJSONObject = null;
        try {
            jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("clientAlertCmd");
            if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.has("bizAction")) {
                if (i == 12) {
                    jSONObjectOptJSONObject.put("bizAction", "enter");
                } else if (i == 41) {
                    jSONObjectOptJSONObject.put("bizAction", "recpush");
                } else if (i == 32) {
                    jSONObjectOptJSONObject.put("bizAction", "top_alert");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObjectOptJSONObject;
    }

    public static List<String> i() {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = AppContext.getContext().getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().activityInfo.packageName);
        }
        return arrayList;
    }

    public static String j() {
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, "key_pull_wake_openstyle_type", "");
        return TextUtils.isEmpty(strN) ? "D" : strN;
    }

    public static long k() {
        return SPUtil.f14322a.i(SPUtil.SCENE.CONTACT, "key_pull_wake_chat_card_expire_time", 0L);
    }

    public static long l() {
        return SPUtil.f14322a.i(SPUtil.SCENE.CONTACT, "key_pull_wake_expire_time", 0L);
    }

    public static long m() {
        return SPUtil.f14322a.i(SPUtil.SCENE.CONTACT, "key_pull_wake_enhanced_expire_time", 0L);
    }

    public static long n() {
        if (!jo6.E()) {
            long jL = l();
            long jM = m();
            return jL >= jM ? jL : jM;
        }
        long jK = k();
        if (q()) {
            return jK;
        }
        long jL2 = l();
        long jM2 = m();
        if (jL2 < jM2) {
            jL2 = jM2;
        }
        return jL2 >= jK ? jL2 : jK;
    }

    public static void o(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString(DeviceInfoUtil.UID_TAG);
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(vn0.f21483a, null, "request_type = ? and insert_date=?  and from_uid=? ", new String[]{String.valueOf(302), um1.b().a(), strOptString}, null);
            if (cursorQuery != null) {
                j = cursorQuery.moveToNext() ? cursorQuery.getLong(cursorQuery.getColumnIndex("read_status")) : 0L;
                cursorQuery.close();
            }
            LogUtil.i(f1796a, "insertContEnhancedContact query , uid = " + strOptString + ", readStatus = " + j);
            String strA = um1.b().a();
            String strE = um1.e();
            if (!TextUtils.isEmpty(strA) && !strA.equals(strE)) {
                p(jSONObject, j, strA);
            }
            p(jSONObject, j, strE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void p(JSONObject jSONObject, long j, String str) {
        if (jSONObject == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        String strOptString = jSONObject.optString(DeviceInfoUtil.UID_TAG);
        String strOptString2 = jSONObject.optString("md5Phone");
        contentValues.put("mid", xn3.a());
        contentValues.put("read_status", Long.valueOf(j));
        contentValues.put("from_uid", strOptString);
        contentValues.put("from_nick_name", jSONObject.optString("nickname"));
        contentValues.put("from_head_img_url", jSONObject.optString("headImgUrl"));
        contentValues.put("from_signature", jSONObject.optString(a.A));
        contentValues.put("recommendText", jSONObject.optString("lpText"));
        contentValues.put("accept_status", (Long) 0L);
        int iOptInt = jSONObject.optInt("sourceType");
        contentValues.put("request_type", (Integer) 302);
        contentValues.put("source_type", Integer.valueOf(iOptInt));
        contentValues.put("identify_code", strOptString2);
        contentValues.put("expireTime", "");
        contentValues.put("insert_date", str);
        try {
            String strOptString3 = jSONObject.optString("realname");
            if (!TextUtils.isEmpty(strOptString3)) {
                jSONObject.put("realName", strOptString3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        contentValues.put("user_info", jSONObject.toString());
        contentValues.put("rid", AccountUtils.p(AppContext.getContext()) + "_" + strOptString);
        contentValues.put("send_time", Long.valueOf(System.currentTimeMillis()));
        rn0.i(contentValues);
    }

    public static boolean q() {
        if (jo6.E()) {
            return by5.k(SPUtil.f14322a.i(SPUtil.SCENE.CONTACT, "key_pull_wake_content_show_time", 0L));
        }
        return false;
    }

    public static boolean r() {
        try {
            boolean zIsScreenOn = ((PowerManager) AppContext.getContext().getSystemService("power")).isScreenOn();
            boolean zInKeyguardRestrictedInputMode = ((KeyguardManager) AppContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
            if (!zIsScreenOn || zInKeyguardRestrictedInputMode) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                LogUtil.d(f1796a, "topPackage: not support");
                return false;
            }
            String strA = no5.a();
            if (TextUtils.isEmpty(strA)) {
                LogUtil.d(f1796a, "topPackage from SuperRunningPackage: " + ((Object) null));
                return false;
            }
            LogUtil.d(f1796a, "topPackage from SuperRunningPackage: " + strA);
            Iterator<String> it = i().iterator();
            while (it.hasNext()) {
                if (strA.contains(it.next())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean s() {
        return Math.abs(System.currentTimeMillis() - c.get()) < 2000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0086, code lost:
    
        r4.moveTaskToFront(r5.get(r6).id, 1);
        D(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0098, code lost:
    
        r4 = true;
        r5 = 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void t() {
        int i;
        boolean z;
        dp4.a().h(dp4.a().b());
        boolean z2 = false;
        try {
            ActivityManager activityManager = (ActivityManager) AppContext.getContext().getSystemService("activity");
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
            int i2 = 0;
            while (true) {
                if (i2 >= runningTasks.size()) {
                    z = false;
                    i = 0;
                    break;
                }
                ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(i2);
                LogUtil.d(f1796a, "  " + runningTaskInfo.baseActivity.toShortString() + runningTaskInfo.topActivity.toShortString() + "   ID: " + runningTaskInfo.id + "");
                if (runningTasks.get(i2).baseActivity.toShortString().contains("com.zenmen.palmchat") && t5.j() != null) {
                    try {
                        break;
                    } catch (Exception e) {
                        e = e;
                        i = 2;
                        e.printStackTrace();
                        dp4.a().f(4, i, e);
                        if (jo6.E()) {
                            z2 = true;
                        }
                        if (!z2) {
                            z2 = true;
                        }
                        if (!z2) {
                            z2 = true;
                        }
                        dp4.a().f(z2 ? 2 : 1, i, null);
                    }
                }
                i2++;
            }
            if (!z) {
                try {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(AppContext.getContext(), (Class<?>) InitActivity.class));
                    intent.putExtra("key_from", 2);
                    intent.addFlags(335544320);
                    intent.addFlags(524288);
                    AppContext.getContext().startActivity(intent);
                    i = 1;
                } catch (Exception e2) {
                    e = e2;
                    i = 1;
                    e.printStackTrace();
                    dp4.a().f(4, i, e);
                }
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
        }
        if (jo6.E() && !TextUtils.isEmpty(SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, "key_pull_wake_content_chat_card", ""))) {
            z2 = true;
        }
        if (!z2 && !TextUtils.isEmpty(SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, "key_pull_wake_content_common", ""))) {
            z2 = true;
        }
        if (!z2 && !TextUtils.isEmpty(SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, "key_pull_wake_content_enhanced", ""))) {
            z2 = true;
        }
        dp4.a().f(z2 ? 2 : 1, i, null);
    }

    public static boolean u(int i, String str, int i2, String str2) {
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, "key_pull_wake_content_common", "");
        if (!TextUtils.isEmpty(strN)) {
            try {
                JSONObject jSONObject = new JSONObject(strN);
                int iOptInt = jSONObject.optInt("sourceType");
                int iOptInt2 = jSONObject.optInt("score");
                String strOptString = jSONObject.optString("bizAction");
                long jOptLong = jSONObject.optLong("expireTime");
                String strOptString2 = jSONObject.optString("type");
                if (jOptLong < System.currentTimeMillis() || TextUtils.equals(str2, "feednotice")) {
                    return true;
                }
                if (TextUtils.equals(strOptString2, "feednotice")) {
                    return false;
                }
                if ("top_alert".equals(str)) {
                    return true;
                }
                if ("top_alert".equals(strOptString)) {
                    return false;
                }
                if ("newuser".equals(strOptString)) {
                    return true;
                }
                if ("newuser".equals(str)) {
                    return false;
                }
                boolean zP = io0.p(i);
                boolean zP2 = io0.p(iOptInt);
                if (!zP && !zP2) {
                    return true;
                }
                if (zP && !zP2) {
                    return true;
                }
                if (!zP && zP2) {
                    return false;
                }
                if ("apply".equals(str)) {
                    return true;
                }
                return !"apply".equals(strOptString) && i2 - iOptInt2 >= 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void v(int i, int i2, String str) {
        int i3;
        try {
            JSONObject jSONObjectH = h(i2, str);
            if (jSONObjectH != null) {
                long jOptLong = jSONObjectH.optLong("expireTime");
                int iOptInt = jSONObjectH.optInt("alertType");
                int iOptInt2 = jSONObjectH.optInt("sourceType");
                String strOptString = jSONObjectH.optString("bizAction");
                boolean z = !AppContext.getContext().isBackground();
                boolean zR = z ? false : r();
                int iOptInt3 = jSONObjectH.optInt("score");
                jSONObjectH.optString("type");
                LogUtil.d(f1796a, "isAppForeground: " + z + ", isHome: " + zR);
                int i4 = jOptLong > System.currentTimeMillis() ? (i == 45 && iOptInt == 1) ? 5 : z ? 2 : zR ? 3 : 1 : 4;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", i4);
                    jSONObject.put("bizAction", strOptString);
                    jSONObject.put("status", i == 45 ? 1 : 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("2p2", "1", null, jSONObject.toString());
                if (i2 == 12 || ("add".equals(strOptString) && io0.o(iOptInt2))) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("lx17913", WkAdxAdConfigMg.DSP_NAME_CSJ);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    LogUtil.uploadInfoImmediate("3ptaichi", "1", null, jSONObject2.toString());
                }
                if ("add".equals(strOptString) && io0.o(iOptInt2)) {
                    o(jSONObjectH);
                }
                if (jOptLong > System.currentTimeMillis()) {
                    if (i2 == 12) {
                        if (io0.q()) {
                            return;
                        } else {
                            SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, "key_pull_wake_content_enhanced", jSONObjectH.toString());
                        }
                    } else if (i2 == 41) {
                        if (!jo6.E()) {
                            return;
                        }
                        String strOptString2 = jSONObjectH.optString("domain");
                        if (!TextUtils.isEmpty(strOptString2)) {
                            DomainHelper.Domains domainsN = DomainHelper.n(strOptString2);
                            if (strOptString2 != null) {
                                jSONObjectH.put("bizType", domainsN.bizType);
                                SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, "key_pull_wake_content_chat_card", jSONObjectH.toString());
                            }
                        }
                    } else if (i == 45) {
                        if ("newuser".equals(strOptString)) {
                            i3 = iOptInt3;
                            if (!u(iOptInt2, strOptString, i3, jSONObjectH.optString("type"))) {
                                return;
                            } else {
                                SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, "key_pull_wake_content_common", jSONObjectH.toString());
                            }
                        } else {
                            i3 = iOptInt3;
                            if ("add".equals(strOptString) && io0.p(iOptInt2)) {
                                return;
                            }
                        }
                        if (u(iOptInt2, strOptString, i3, jSONObjectH.optString("type"))) {
                            SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, "key_pull_wake_content_common", jSONObjectH.toString());
                        }
                    }
                    if (z) {
                        ch.s().I();
                        return;
                    }
                    if (i != 46) {
                        if (i != 45) {
                            return;
                        }
                        if (iOptInt != 2 && i2 != 12) {
                            return;
                        }
                    }
                    if (!zR || (q() && i2 != 41)) {
                        x(strOptString);
                        z(i2, jOptLong);
                    } else {
                        x(strOptString);
                        t();
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void w() {
        e();
        f();
        d();
        b();
        c();
        a();
    }

    public static void x(String str) {
        SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, "key_pull_wake_openstyle_type", "apply".equals(str) ? "A" : "add".equals(str) ? WkAdxAdConfigMg.DSP_NAME_BAIDU : "enter".equals(str) ? WkAdxAdConfigMg.DSP_NAME_CSJ : "recpush".equals(str) ? "F" : "D");
    }

    public static void y() {
        SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, "key_pull_wake_content_show_time", Long.valueOf(System.currentTimeMillis()));
    }

    public static void z(int i, long j) {
        if (i == 12) {
            C(j);
        } else if (i == 41) {
            A(j);
        } else {
            B(j);
        }
    }
}
