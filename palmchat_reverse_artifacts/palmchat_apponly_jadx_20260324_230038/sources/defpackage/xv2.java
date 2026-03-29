package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import com.baidu.location.LocationConst;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.x;
import com.igexin.sdk.PushConsts;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class xv2 extends yv2 {
    public static final String[] b = {"JDevice", "JWakeCmd", "JWake", "JCommon"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22060a = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends xw2 {
        public Context c;
        public Intent d;
        public String e;

        public a(Context context, Intent intent, String str) {
            this.c = context;
            this.e = str;
            this.d = intent;
            this.f22065a = "JCoreHelper#PushReceiverAction";
        }

        @Override // defpackage.xw2
        public void a() {
            try {
                f5.c().d(this.c, this.e, this.d);
                xv2.this.i(this.c, this.d);
            } catch (Throwable th) {
                k63.c("JCoreHelper", "[PushReceiverAction failed:]" + th.getMessage());
            }
        }
    }

    public static Object g(Context context) {
        return qv2.a(context, "deviceinfo", null);
    }

    public static Pair<String, Integer> h(Context context) {
        return m50.f(context);
    }

    public static void j(String str, String str2, boolean z, int i, String str3, Throwable th) {
        c63.b(str, str2, z, i, str3, th);
    }

    public static void k(Context context, String str, int i, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putInt(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, i);
        bundle.putInt("dynamic", i2);
        bundle.putInt("sdk_v", i3);
        qv2.a(context, "set_sdktype_info", bundle);
    }

    public static void l(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sdk_type", str);
        wv2.f(context, "tcp_a9", bundle);
    }

    public static void m(Context context, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        k63.b("JCoreHelper", "runActionWithService action:" + str2);
        bundle.putString("sdk_type", str);
        bundle.putString("internal_action", str2);
        wv2.f(context, "a3", bundle);
    }

    public static void n(Context context, String str, Bundle bundle, String str2) {
        if (bundle != null) {
            bundle.putString("sdk_type", str);
            wv2.f(context, str2, bundle);
        }
    }

    public static void o(Context context, String str, Bundle bundle) {
        wv2.f(context, str, bundle);
    }

    public static void p(Context context, String str) {
        m50.h(context, str);
    }

    public static void q(Context context, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return;
        }
        try {
            k63.a("JCoreHelper", "setSDKConfigs");
            int i = 86400;
            try {
                int i2 = bundle.getInt("heartbeat_interval", tv2.i);
                if (i2 < 30) {
                    i2 = 30;
                } else if (i2 > 86400) {
                    i2 = 86400;
                }
                tv2.i = i2;
                k63.a("JCoreHelper", "set heartbeat interval=" + i2);
            } catch (Throwable unused) {
            }
            try {
                int i3 = bundle.getInt("alarm_delay", tv2.j);
                if (i3 <= 86400) {
                    i = i3;
                }
                int i4 = tv2.i;
                if (i < i4 + 5) {
                    i = i4 + 5;
                }
                tv2.j = i;
                k63.a("JCoreHelper", "set alarm delay=" + i);
            } catch (Throwable unused2) {
            }
            byte b2 = (byte) bundle.getInt("tcp_algorithm", -1);
            if (b2 >= 0) {
                tv2.k = b2;
                k63.a("JCoreHelper", "set tcp algorithm=" + ((int) b2));
            }
            if (bundle.containsKey("tcp_report")) {
                nw4.b = bundle.getBoolean("tcp_report");
            }
            if (bundle.containsKey("plugin_report_switch")) {
                context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("plugin_report_switch", bundle.getBoolean("plugin_report_switch")).apply();
            }
            if (bundle.containsKey("plugin_multi_switch")) {
                context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("plugin_multi_switch", bundle.getBoolean("plugin_multi_switch")).apply();
            }
            int i5 = bundle.getInt("ipv_config", -1);
            yu2.f(i5);
            if (i5 != 2 && i5 != 3) {
                if (i5 == 0 || i5 == 1) {
                    nw4.d = true;
                    return;
                }
                return;
            }
            nw4.d = false;
        } catch (Throwable unused3) {
        }
    }

    public static Bundle s(Context context, int i, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            if (i == 4096) {
                if (bundle != null) {
                    p(context, m50.e(bundle, "arg1"));
                }
                return bundle2;
            }
            if (i == 4098) {
                JCoreManager.init(context);
                return bundle2;
            }
            switch (i) {
                case 36864:
                    r(bundle);
                    break;
                case 36865:
                    if (JCoreManager.isInternal()) {
                        tv2.d();
                    }
                    break;
            }
            return null;
        } catch (Throwable th) {
            k63.c("JCoreHelper", "si e:" + th);
            return null;
        }
    }

    public static void t(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sdk_type", str);
        wv2.f(context, "tcp_a8", bundle);
    }

    @Override // defpackage.yv2
    public Bundle a(Context context, String str, String str2, Bundle bundle) {
        return rw2.c().b(context, str, str2, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:296:0x059e  */
    @Override // defpackage.yv2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(Context context, String str, int i, String str2, Bundle bundle, Object... objArr) {
        char c;
        Throwable th;
        Object obj;
        Boolean bool;
        try {
            Context contextA = tv2.a(context);
            String str3 = "SCHEDULE_TASK";
            String str4 = "NORMAL_TASK";
            String str5 = "MAJOR_TASK";
            boolean zBooleanValue = false;
            switch (i) {
                case 0:
                    t(contextA, str);
                    return null;
                case 1:
                    l(contextA, str);
                    return null;
                case 2:
                    d(contextA, str2, bundle);
                    return null;
                case 3:
                    m(contextA, str, str2, bundle);
                    return null;
                case 4:
                    return fv2.k(contextA);
                case 5:
                    return fv2.c(contextA);
                case 6:
                    return fv2.f(contextA);
                case 7:
                    return fv2.e(contextA);
                case 8:
                    return fv2.g(contextA);
                case 9:
                    p(contextA, str2);
                    return null;
                case 10:
                    o(contextA, str2, bundle);
                    return null;
                case 11:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Runnable)) {
                        return null;
                    }
                    if (TextUtils.isEmpty(str) || !str.toLowerCase().equals("jpush")) {
                        if (!Arrays.asList(b).contains(str2)) {
                            str3 = str2;
                        }
                        str5 = str3;
                    }
                    wz4.a(str5, (Runnable) objArr[0]);
                    return null;
                case 12:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Runnable)) {
                        return null;
                    }
                    if (!TextUtils.isEmpty(str) && str.toLowerCase().equals("jpush")) {
                        str4 = "MAJOR_TASK";
                    }
                    wz4.a(str4, (Runnable) objArr[0]);
                    return null;
                case 13:
                case 27:
                case 28:
                case 32:
                case 33:
                case 58:
                case 64:
                case 65:
                case 69:
                default:
                    return null;
                case 14:
                    if (objArr == null || objArr.length <= 0) {
                        nw4.u(contextA, str, null);
                        return null;
                    }
                    nw4.u(contextA, str, objArr[0]);
                    return null;
                case 15:
                    if (objArr == null || objArr.length <= 1) {
                        return null;
                    }
                    Object obj2 = objArr[1];
                    if (!(obj2 instanceof ReportCallBack)) {
                        return null;
                    }
                    nw4.v(contextA, (JSONObject) objArr[0], (ReportCallBack) obj2);
                    return null;
                case 16:
                    n(contextA, str, bundle, "tcp_a3");
                    return null;
                case 17:
                    n(contextA, str, bundle, "tcp_a5");
                    return null;
                case 18:
                    if (objArr == null || objArr.length <= 2) {
                        return null;
                    }
                    if (objArr.length > 3) {
                        Object obj3 = objArr[3];
                        if (obj3 instanceof Throwable) {
                            th = (Throwable) obj3;
                            c = 1;
                        } else {
                            c = 1;
                            th = null;
                        }
                    }
                    j(str, str2, ((Boolean) objArr[c]).booleanValue(), ((Integer) objArr[0]).intValue(), (String) objArr[2], th);
                    return null;
                case 19:
                    if (objArr != null && objArr.length > 0) {
                        Object obj4 = objArr[0];
                        if (obj4 instanceof Long) {
                            return Long.valueOf(mg5.c(contextA, ((Long) obj4).longValue()));
                        }
                    }
                    return Long.valueOf(mg5.b(contextA));
                case 20:
                    return Long.valueOf(fv2.n(contextA));
                case 21:
                    return Boolean.valueOf(mg5.d(contextA));
                case 22:
                    lg5.h(contextA, zz2.D().a0(str2));
                    return null;
                case 23:
                    if (!tv2.f) {
                        return null;
                    }
                    tv2.n = str2;
                    return null;
                case 24:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Integer)) {
                        return null;
                    }
                    new Bundle().putInt("cmd", ((Integer) objArr[0]).intValue());
                    m(contextA, "JCore", "old_cmd", null);
                    return null;
                case 25:
                    return Integer.valueOf(wv2.c);
                case 26:
                    if (objArr != null && objArr.length > 1) {
                        Object obj5 = objArr[0];
                        if ((obj5 instanceof JSONObject) && ((obj = objArr[1]) == null || (obj instanceof String))) {
                            return fv2.b(contextA, (JSONObject) obj5, (String) obj);
                        }
                    }
                case 29:
                    if (objArr == null) {
                        return null;
                    }
                    if (!(objArr.length > 0) || !(objArr[0] instanceof Integer)) {
                        return null;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("scence", ((Integer) objArr[0]).intValue());
                    m(contextA, "JCore", "notification_state", bundle2);
                    return null;
                case 30:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    Object obj6 = objArr[0];
                    if (obj6 instanceof Integer) {
                        return s(contextA, ((Integer) obj6).intValue(), bundle);
                    }
                    return null;
                case 31:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    Object obj7 = objArr[0];
                    if (!(obj7 instanceof Intent)) {
                        return null;
                    }
                    wz4.a("MAJOR_TASK", new a(contextA, (Intent) obj7, str));
                    return null;
                case 34:
                    return fv2.j(contextA);
                case 35:
                    if (objArr == null || objArr.length <= 2 || !(objArr[0] instanceof Long) || !(objArr[1] instanceof String) || !(objArr[2] instanceof String)) {
                        return null;
                    }
                    lg5.h(contextA, zz2.K().a0(Long.valueOf(((Long) objArr[0]).longValue())), zz2.H().a0((String) objArr[1]), zz2.I().a0((String) objArr[2]));
                    return null;
                case 36:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    Object obj8 = objArr[0];
                    if (!(obj8 instanceof String)) {
                        return null;
                    }
                    tb1.d(contextA, (String) obj8);
                    return null;
                case 37:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    Object obj9 = objArr[0];
                    if (!(obj9 instanceof Long)) {
                        return null;
                    }
                    mg5.e(contextA, ((Long) obj9).longValue());
                    return null;
                case 38:
                    lg5.a(contextA, "cn.jiguang.sdk.user.profile");
                    return null;
                case 39:
                    nw4.t(contextA, objArr != null ? objArr[0] : null);
                    return null;
                case 40:
                    if (objArr == null || objArr.length <= 1) {
                        return null;
                    }
                    Object obj10 = objArr[0];
                    if (!(obj10 instanceof Boolean) || !(objArr[1] instanceof Long)) {
                        return null;
                    }
                    wv2.e(contextA, ((Boolean) obj10).booleanValue(), ((Long) objArr[1]).longValue());
                    return null;
                case 41:
                    if (objArr == null || objArr.length <= 1) {
                        return null;
                    }
                    Object obj11 = objArr[0];
                    if (!(obj11 instanceof String)) {
                        return null;
                    }
                    Object obj12 = objArr[1];
                    if (obj12 instanceof JSONObject) {
                        return Boolean.valueOf(nw4.A(contextA, (String) obj11, (JSONObject) obj12));
                    }
                    return null;
                case 42:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    Object obj13 = objArr[0];
                    if (obj13 instanceof String) {
                        return fv2.p(contextA, (String) obj13);
                    }
                    return null;
                case 43:
                    return fv2.d();
                case 44:
                    if (objArr == null || objArr.length <= 1 || !(objArr[0] instanceof String) || !(objArr[1] instanceof Long)) {
                        return null;
                    }
                    lg5.h(contextA, zz2.z().a0((String) objArr[0]), zz2.A().a0(Long.valueOf(((Long) objArr[1]).longValue())));
                    return null;
                case 45:
                    return fv2.l(contextA);
                case 46:
                    return Integer.valueOf(fv2.h(contextA));
                case 47:
                    return Integer.valueOf(fv2.m(contextA));
                case 48:
                    hw4.q(contextA);
                    return null;
                case 49:
                    return Boolean.TRUE;
                case 50:
                    n(contextA, str, bundle, "tcp_a4");
                    return null;
                case 51:
                    if (objArr == null || objArr.length != 1 || !(objArr[0] instanceof Integer)) {
                        return null;
                    }
                    lg5.h(contextA, zz2.F().a0(Integer.valueOf(((Integer) objArr[0]).intValue())));
                    return null;
                case 52:
                    r(bundle);
                    return null;
                case 53:
                    return Boolean.valueOf(gv2.a().b(contextA));
                case 54:
                    if (objArr == null || objArr.length <= 2) {
                        return null;
                    }
                    String str6 = (String) objArr[0];
                    int iIntValue = ((Integer) objArr[1]).intValue();
                    int iIntValue2 = ((Integer) objArr[2]).intValue();
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("name", str6);
                    bundle3.putInt(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, iIntValue);
                    bundle3.putInt("dynamic", iIntValue2);
                    qv2.a(contextA, "set_sdktype_info", bundle3);
                    return null;
                case 55:
                    q(contextA, bundle);
                    return null;
                case 56:
                    if (az.ag.equals(str2)) {
                        if (!tv2.g) {
                            return null;
                        }
                        fp4.g().n(contextA);
                        return null;
                    }
                    if ("pause".equals(str2)) {
                        if (!tv2.g) {
                            return null;
                        }
                        fp4.g().m(contextA);
                        return null;
                    }
                    if ("kill".equals(str2)) {
                        fp4.g().l(contextA);
                        return null;
                    }
                    if ("enable".equals(str2)) {
                        if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Boolean)) {
                            return null;
                        }
                        fp4.g().s(((Boolean) objArr[0]).booleanValue());
                        return null;
                    }
                    if ("s_timeout".equals(str2)) {
                        if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Long)) {
                            return null;
                        }
                        fp4.g().r(((Long) objArr[0]).longValue());
                        return null;
                    }
                    if ("f_resume".equals(str2)) {
                        if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                            return null;
                        }
                        fp4.g().k(contextA, (String) objArr[0]);
                        return null;
                    }
                    if (!"f_pause".equals(str2) || objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                        return null;
                    }
                    fp4.g().j(contextA, (String) objArr[0]);
                    return null;
                case 57:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Integer)) {
                        return null;
                    }
                    k63.a("JCoreHelper", "SET_SHARE_PROCESS_STATE state:" + objArr[0]);
                    lg5.h(contextA, zz2.y().a0(Integer.valueOf(((Integer) objArr[0]).intValue())));
                    return null;
                case 59:
                    n(contextA, str, bundle, "tcp_a20");
                    return null;
                case 60:
                    String str7 = "unknown msg";
                    if (objArr != null && objArr.length > 0) {
                        Object obj14 = objArr[0];
                        if (obj14 instanceof Boolean) {
                            zBooleanValue = ((Boolean) obj14).booleanValue();
                        }
                    }
                    if (objArr != null && objArr.length > 1) {
                        Object obj15 = objArr[1];
                        if (obj15 instanceof String) {
                            str7 = (String) obj15;
                        }
                    }
                    return Boolean.valueOf(tv2.b(contextA, zBooleanValue, str7));
                case 61:
                    if (objArr == null || objArr.length <= 6) {
                        return null;
                    }
                    nw4.p(contextA, ((Integer) objArr[0]).intValue(), (JSONObject) objArr[1], (byte[]) objArr[2], ((Integer) objArr[3]).intValue(), (File) objArr[4], (Set) objArr[5], (ReportCallBack) objArr[6]);
                    return null;
                case 62:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    rw2.c().e(contextA, (String) objArr[0], str2, bundle);
                    return null;
                case 63:
                    if (objArr == null || objArr.length <= 1) {
                        return null;
                    }
                    return rw2.c().a(contextA, (String) objArr[0], str2, bundle, (String) objArr[1]);
                case 66:
                    if (objArr == null || objArr.length <= 0 || (bool = (Boolean) objArr[0]) == null) {
                        return null;
                    }
                    e(contextA, bool.booleanValue());
                    if (!bool.booleanValue()) {
                        nw4.t(contextA, null);
                        nw4.u(contextA, str, null);
                        return null;
                    }
                    wv2.e(contextA, false, 0L);
                    Bundle bundle4 = new Bundle();
                    bundle4.putInt("scence", 1);
                    m(contextA, "JCore", "notification_state", bundle4);
                    return null;
                case 67:
                    return Boolean.valueOf(f(contextA));
                case 68:
                    return qv2.a(contextA, "deviceinfo", null);
                case 70:
                    tw2.e().h(contextA);
                    return null;
                case 71:
                    tw2.e().m(contextA);
                    return null;
                case 72:
                    if (objArr == null || objArr.length != 4) {
                        return null;
                    }
                    Object obj16 = objArr[0];
                    if (!(obj16 instanceof String)) {
                        return null;
                    }
                    Object obj17 = objArr[1];
                    if (!(obj17 instanceof Integer) || !(objArr[2] instanceof Integer)) {
                        return null;
                    }
                    k(contextA, (String) obj16, ((Integer) obj17).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                    return null;
                case 73:
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        Bundle bundle5 = new Bundle();
                        bundle5.putBoolean("enable", ((Boolean) objArr[0]).booleanValue());
                        m(contextA, "JCore", "set_wake_enable", bundle5);
                        break;
                    }
                case 74:
                    if (bundle == null) {
                        return null;
                    }
                    qv2.a(contextA, "waked", bundle);
                    return null;
                case 75:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    Object obj18 = objArr[0];
                    if (!(obj18 instanceof Runnable)) {
                        return null;
                    }
                    wz4.a("MAJOR_TASK", (Runnable) obj18);
                    return null;
                case 76:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    Object obj19 = objArr[0];
                    if (!(obj19 instanceof Runnable)) {
                        return null;
                    }
                    wz4.a("FUTURE_TASK", (Runnable) obj19);
                    return null;
                case 77:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    Object obj20 = objArr[0];
                    if (!(obj20 instanceof Runnable)) {
                        return null;
                    }
                    wz4.a("NORMAL_TASK", (Runnable) obj20);
                    return null;
                case 78:
                    if (objArr == null || objArr.length <= 0) {
                        return null;
                    }
                    Object obj21 = objArr[0];
                    if (!(obj21 instanceof Runnable)) {
                        return null;
                    }
                    wz4.a("SCHEDULE_TASK", (Runnable) obj21);
                    return null;
            }
        } catch (Throwable th2) {
            k63.l("JCoreHelper", "onEvent:" + th2);
            return null;
        }
    }

    public void d(Context context, String str, Bundle bundle) {
        wv2.b(context, str, bundle);
    }

    public void e(Context context, boolean z) {
        k63.a("JCoreHelper", "changeForegroudStat:" + z);
        this.f22060a = z;
        Bundle bundle = new Bundle();
        bundle.putBoolean("foreground", this.f22060a);
        wv2.f(context, "a4", bundle);
    }

    public boolean f(Context context) {
        try {
            Bundle bundleA = rw2.c().a(context, "INTERNAL_API", "isTcpLoggedIn", null, sv2.d(context));
            return (bundleA == null || !bundleA.containsKey(LocationConst.HDYawConst.KEY_HD_YAW_STATE)) ? tt5.u().C() : bundleA.getBoolean(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(Context context, Intent intent) {
        Method declaredMethod;
        boolean zBooleanValue;
        k63.a("JCoreHelper", "[handleReceiverIntent]:" + intent.getAction());
        qv2.a(context, "get_receiver", intent);
        String action = intent.getAction();
        if (action == null) {
            k63.l("JCoreHelper", "onReceive empty action");
            return;
        }
        if (action.equals(PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
            k63.g("JCoreHelper", "onReceiveandroid.intent.action.USER_PRESENT");
            wv2.e(context, true, 0L);
            m(context, "JCore", "user_present", null);
            return;
        }
        if (action.equals("android.intent.action.SCREEN_ON")) {
            wv2.e(context, false, 0L);
            return;
        }
        if (action.equalsIgnoreCase(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo == null) {
                k63.l("JCoreHelper", "Not found networkInfo");
                return;
            }
            k63.a("JCoreHelper", "Connection state changed to - " + networkInfo.toString());
            if (2 == networkInfo.getType() || 3 == networkInfo.getType()) {
                k63.a("JCoreHelper", "MMS or SUPL network state change, to do nothing!");
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            if (booleanExtra) {
                k63.a("JCoreHelper", "No any network is connected");
                extras.putBoolean(x.bq, false);
            } else {
                try {
                    if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                        k63.a("JCoreHelper", "Network is connected.");
                        extras.putBoolean(x.bq, true);
                    } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                        k63.a("JCoreHelper", "Network is disconnected.");
                        extras.putBoolean(x.bq, false);
                    } else {
                        k63.a("JCoreHelper", "other network state - " + networkInfo.getState() + ". Do nothing.");
                    }
                } catch (Throwable unused) {
                    extras.putBoolean(x.bq, ad.w(context));
                }
            }
            wv2.f(context, "tcp_a15", extras);
            return;
        }
        if (!action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED") && !action.equals("android.os.action.POWER_SAVE_MODE_CHANGED")) {
            if (action.equals("noti_open_proxy") && intent.getBooleanExtra("debug_notification", false)) {
                String stringExtra = intent.getStringExtra("toastText");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                Toast toastMakeText = Toast.makeText(context, stringExtra, 0);
                try {
                    View view = toastMakeText.getView();
                    if (view instanceof LinearLayout) {
                        View childAt = ((LinearLayout) view).getChildAt(0);
                        if (childAt instanceof TextView) {
                            TextView textView = (TextView) childAt;
                            if (!nl5.i(stringExtra)) {
                                textView.setText(stringExtra);
                            }
                            textView.setTextSize(13.0f);
                        }
                    }
                } catch (Exception unused2) {
                }
                toastMakeText.show();
                return;
            }
            return;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            try {
                Class<?> cls = Class.forName("android.os.PowerManager");
                if (action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED")) {
                    Method declaredMethod2 = cls.getDeclaredMethod("isDeviceIdleMode", new Class[0]);
                    zBooleanValue = declaredMethod2 != null ? ((Boolean) declaredMethod2.invoke(powerManager, new Object[0])).booleanValue() : true;
                } else if (action.equals("android.os.action.POWER_SAVE_MODE_CHANGED") && (declaredMethod = cls.getDeclaredMethod("isPowerSaveMode", new Class[0])) != null) {
                    zBooleanValue = ((Boolean) declaredMethod.invoke(powerManager, new Object[0])).booleanValue();
                }
                if (zBooleanValue) {
                    return;
                }
                k63.a("JCoreHelper", "doze or powersave mode exit.");
                wv2.e(context, true, 0L);
            } catch (Throwable th) {
                k63.c("JCoreHelper", "handle DEVICE_IDLE_MODE_CHANGED or POWER_SAVE_MODE_CHANGED fail:" + th);
            }
        }
    }

    public static void r(Bundle bundle) {
    }
}
