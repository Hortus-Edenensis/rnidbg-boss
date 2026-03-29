package defpackage;

import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.JCoreManager;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class yd1 {
    public static volatile yd1 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, to5> f22178a = new HashMap<>();
    public static HashMap<String, JAction> b = new HashMap<>();
    public static HashMap<String, JActionExtra> c = new HashMap<>();
    public static final Object e = new Object();

    public static yd1 c() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new yd1();
                }
            }
        }
        return d;
    }

    public void a(String str, String str2) {
        l63.e("DispacthManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f22178a.containsKey(str)) {
            to5 to5Var = new to5();
            JCoreManager.addDispatchAction(str, to5.class.getCanonicalName());
            f22178a.put(str, to5Var);
        }
        if (b.containsKey(str)) {
            return;
        }
        try {
            Object objNewInstance = Class.forName(str2).newInstance();
            if (objNewInstance instanceof JAction) {
                b.put(str, (JAction) objNewInstance);
            }
        } catch (Throwable th) {
            l63.g("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public void b(String str, String str2) {
        l63.e("DispacthManager", "addActionExtra type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f22178a.containsKey(str)) {
            to5 to5Var = new to5();
            JCoreManager.addDispatchAction(str, to5.class.getCanonicalName());
            f22178a.put(str, to5Var);
        }
        if (c.containsKey(str)) {
            return;
        }
        try {
            Object objNewInstance = Class.forName(str2).newInstance();
            if (objNewInstance instanceof JActionExtra) {
                c.put(str, (JActionExtra) objNewInstance);
            }
        } catch (Throwable th) {
            l63.g("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public JAction d(String str) {
        if (b.containsKey(str)) {
            return b.get(str);
        }
        return null;
    }

    public JActionExtra e(String str) {
        if (c.containsKey(str)) {
            return c.get(str);
        }
        return null;
    }
}
