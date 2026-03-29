package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class zd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile zd1 f22396a;
    public static final Object b = new Object();
    public static HashMap<String, JDispatchAction> c = new HashMap<>();

    public zd1() {
        Object objD = fv2.d();
        if (objD instanceof HashMap) {
            StringBuilder sb = new StringBuilder();
            sb.append("actiom map size:");
            HashMap<String, String> map = (HashMap) objD;
            sb.append(map.size());
            k63.a("DispatchActionManager", sb.toString());
            o(map);
            a("JCore", vv2.class.getCanonicalName());
        }
    }

    public static zd1 e() {
        if (f22396a == null) {
            synchronized (b) {
                if (f22396a == null) {
                    f22396a = new zd1();
                }
            }
        }
        return f22396a;
    }

    public static int n(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] strArrSplit = str.split("\\.");
        return (Integer.parseInt(strArrSplit[0]) << 16) + (Integer.parseInt(strArrSplit[1]) << 8) + Integer.parseInt(strArrSplit[2]);
    }

    public void a(String str, String str2) {
        k63.a("DispatchActionManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (c.containsKey(str)) {
            k63.a("DispatchActionManager", "has same type action");
            return;
        }
        try {
            Object objNewInstance = Class.forName(str2).newInstance();
            if (objNewInstance instanceof JDispatchAction) {
                c.put(str, (JDispatchAction) objNewInstance);
                k63.a("DispatchActionManager", "action init:" + objNewInstance.getClass().getName());
            } else {
                k63.l("DispatchActionManager", "this action is not a JDispatchAction,please check and extends JDispatchAction");
            }
        } catch (Throwable th) {
            k63.n("DispatchActionManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public void b(Context context, int i, int i2, String str) {
        for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                value.onEvent(context, entry.getKey(), i, i2, str);
            }
        }
        r(context, i, i2, str);
    }

    public void c(Context context, pw2 pw2Var, ByteBuffer byteBuffer) {
        if (pw2Var == null) {
            k63.l("DispatchActionManager", "Action - dispatchMessage unexcepted - head was null");
            return;
        }
        bt2 bt2VarB = wt5.c().b(pw2Var.e);
        if (bt2VarB == null) {
            for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && value.isSupportedCMD(entry.getKey(), pw2Var.c)) {
                    value.dispatchMessage(context, entry.getKey(), pw2Var.c, pw2Var.b, pw2Var.e, -1L, byteBuffer);
                }
            }
            return;
        }
        k63.a("DispatchActionManager", "dispacth msg with reuqest :" + bt2VarB);
        JDispatchAction jDispatchAction = c.get(bt2VarB.c);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchMessage(context, bt2VarB.c, pw2Var.c, pw2Var.b, pw2Var.e, bt2VarB.b, byteBuffer);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("rid", pw2Var.e);
        tt5.u().r(context, "tcp_a7", bundle);
    }

    public void d(Context context, String str, long j, int i) {
        if (!TextUtils.isEmpty(str) && str.equals("JCore")) {
            if (i == 26) {
                e66.b().g(context, j);
                return;
            } else {
                if (i == 30 || i == 32) {
                    o75.m().v(context, i);
                    return;
                }
                return;
            }
        }
        JDispatchAction jDispatchAction = c.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchTimeOutMessage(context, str, j, i);
            return;
        }
        k63.l("DispatchActionManager", "not found dispatch action by sdktype:" + str);
    }

    public String f() {
        String str = n(wv2.b) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
            short logPriority = entry.getValue().getLogPriority(entry.getKey());
            if (s < logPriority) {
                s = logPriority;
            }
        }
        k63.a("DispatchActionManager", "max login priority:" + ((int) s));
        for (int i = 1; i <= s; i++) {
            Iterator<Map.Entry<String, JDispatchAction>> it = c.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, JDispatchAction> next = it.next();
                    JDispatchAction value = next.getValue();
                    if (value.getLogPriority(next.getKey()) == i) {
                        str = str + n(value.getSdkVersion(next.getKey()));
                        break;
                    }
                }
            }
            str = str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return str.substring(0, str.length() - 1);
    }

    public short g() {
        short loginFlag;
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (loginFlag = value.getLoginFlag(entry.getKey())) != 0) {
                s = (short) (s | loginFlag);
            }
        }
        return s;
    }

    public String h(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object objBeforLogin = value.beforLogin(context, entry.getKey(), 24, "platformregid");
                if (objBeforLogin instanceof String) {
                    return (String) objBeforLogin;
                }
            }
        }
        return "";
    }

    public byte i(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object objBeforLogin = value.beforLogin(context, entry.getKey(), 24, "platformtype");
                if (objBeforLogin instanceof Byte) {
                    return ((Byte) objBeforLogin).byteValue();
                }
            }
        }
        return (byte) 0;
    }

    public short j() {
        short regFlag;
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (regFlag = value.getRegFlag(entry.getKey())) != 0) {
                s = (short) (s | regFlag);
            }
        }
        return s;
    }

    public String k() {
        short s = 3;
        for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
            short regPriority = entry.getValue().getRegPriority(entry.getKey());
            if (s < regPriority) {
                s = regPriority;
            }
        }
        k63.a("DispatchActionManager", "max reg priority:" + ((int) s));
        String str = "";
        for (int i = 0; i <= s; i++) {
            if (i == 3) {
                str = str + wv2.b + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
            } else {
                Iterator<Map.Entry<String, JDispatchAction>> it = c.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, JDispatchAction> next = it.next();
                    JDispatchAction value = next.getValue();
                    if (value.getRegPriority(next.getKey()) == i) {
                        str = str + value.getSdkVersion(next.getKey());
                        break;
                    }
                }
                str = str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
            }
        }
        return str.substring(0, str.length() - 1);
    }

    public String l(int i) {
        for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && value.getRegPriority(entry.getKey()) == i) {
                return value.getSdkVersion(entry.getKey());
            }
        }
        return "";
    }

    public String m(String str, String str2) {
        JDispatchAction jDispatchAction = c.get(str);
        if (jDispatchAction != null) {
            String sdkVersion = jDispatchAction.getSdkVersion(str);
            if (!TextUtils.isEmpty(sdkVersion)) {
                return sdkVersion;
            }
            k63.j("DispatchActionManager", str + " sdk action sdkversion:" + sdkVersion);
        } else {
            k63.j("DispatchActionManager", str + " sdk action is null");
        }
        return str2;
    }

    public void o(HashMap<String, String> map) {
        if (map == null || map.isEmpty()) {
            k63.l("DispatchActionManager", "init map is empty");
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public boolean p(int i) {
        for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                try {
                    k63.b("DispatchActionManager", "isAllowAction actionType:" + i + ",sdktype:" + entry.getKey() + ",action:" + value.checkAction(entry.getKey(), i));
                    if (!value.checkAction(entry.getKey(), i)) {
                        return false;
                    }
                } catch (Throwable th) {
                    k63.l("DispatchActionManager", "isAllowAction error:" + th.getMessage());
                }
            }
        }
        return true;
    }

    public void q(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            k63.n("DispatchActionManager", "run action bundle is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            k63.n("DispatchActionManager", "run action sdktype is empty");
            return;
        }
        if ("JCore".contains(str)) {
            str = "JCore";
        }
        JDispatchAction jDispatchAction = c.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.onActionRun(context, str, bundle.getString("internal_action"), bundle);
            return;
        }
        k63.n("DispatchActionManager", "dispacth action is null by sdktype:" + str);
    }

    public final void r(Context context, int i, int i2, String str) {
        Intent intent;
        try {
            if (i == 0 && i2 == 0) {
                intent = new Intent("cn.jpush.android.intent.REGISTRATION");
                intent.putExtra("cn.jpush.android.REGISTRATION_ID", str);
            } else if (i == -1 || i == 1) {
                Intent intent2 = new Intent("cn.jpush.android.intent.CONNECTION");
                if (i == -1) {
                    intent2.putExtra("cn.jpush.android.CONNECTION_CHANGE", false);
                } else {
                    intent2.putExtra("cn.jpush.android.CONNECTION_CHANGE", true);
                }
                intent = intent2;
            } else {
                intent = null;
            }
            if (intent != null) {
                String packageName = context.getPackageName();
                intent.addCategory(packageName);
                intent.setPackage(packageName);
                ad.B(context, intent);
            }
        } catch (Throwable th) {
            k63.l("DispatchActionManager", "sendToOldPushUser failed:" + th.getMessage());
        }
    }
}
