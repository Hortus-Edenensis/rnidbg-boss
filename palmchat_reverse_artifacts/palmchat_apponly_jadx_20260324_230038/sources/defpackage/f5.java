package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.api.JDispatchAction;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f5 f17435a;
    public static final Object b = new Object();
    public static HashMap<String, JDispatchAction> c = new HashMap<>();
    public static HashMap<String, String> d = new HashMap<>();

    public f5() {
        gv2.a();
    }

    public static HashMap<String, String> b() {
        return d;
    }

    public static f5 c() {
        if (f17435a == null) {
            synchronized (b) {
                if (f17435a == null) {
                    f17435a = new f5();
                }
            }
        }
        return f17435a;
    }

    public void a(String str, String str2) {
        Log.d("ActionManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (c.containsKey(str)) {
            k63.a("ActionManager", "has same type action");
            return;
        }
        try {
            Object objNewInstance = Class.forName(str2).newInstance();
            if (objNewInstance instanceof JDispatchAction) {
                d.put(str, str2);
                c.put(str, (JDispatchAction) objNewInstance);
            } else {
                k63.l("ActionManager", "this action is not a JDispatchAction,please check and extends JDispatchAction");
            }
        } catch (Throwable th) {
            k63.n("ActionManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public void d(Context context, String str, Object obj) {
        k63.j("ActionManager", "onSended type:" + str + ",actionMap size:" + c.size());
        if (TextUtils.isEmpty(str)) {
            for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
                entry.getValue().handleMessage(context, entry.getKey(), obj);
            }
            return;
        }
        JDispatchAction jDispatchAction = c.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.handleMessage(context, str, obj);
        }
    }

    public boolean e(JSONObject jSONObject) {
        if (jSONObject == null) {
            k63.l("ActionManager", "wrapSdkVersionInfo failed ,container is null");
            return false;
        }
        try {
            jSONObject.put("core_sdk_ver", wv2.b);
            for (Map.Entry<String, JDispatchAction> entry : c.entrySet()) {
                JDispatchAction value = entry.getValue();
                jSONObject.put(value.getReportVersionKey(entry.getKey()), value.getSdkVersion(entry.getKey()));
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }
}
