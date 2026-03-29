package defpackage;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class mv2 {
    public static JSONObject a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    Object objOnEvent = JCoreManager.onEvent(context, "JCOMMON", 42, null, null, str);
                    if (!(objOnEvent instanceof JSONObject)) {
                        return null;
                    }
                    return (JSONObject) objOnEvent;
                }
            } catch (Throwable th) {
                p63.f("JCommonFileHelper", "readJson throwable:" + th.getMessage());
            }
        }
        return null;
    }

    public static String b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File fileW = rv2.w(context, str);
                    if (fileW == null) {
                        return null;
                    }
                    return rv2.B(fileW);
                }
            } catch (Throwable th) {
                p63.f("JCommonFileHelper", "readString throwable:" + th.getMessage());
            }
        }
        return null;
    }

    public static boolean c(Context context, String str, JSONObject jSONObject) {
        boolean zBooleanValue;
        if (context != null && !TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                synchronized (str) {
                    Object objOnEvent = JCoreManager.onEvent(context, "JCOMMON", 41, null, null, str, jSONObject);
                    zBooleanValue = objOnEvent instanceof Boolean ? ((Boolean) objOnEvent).booleanValue() : false;
                }
                return zBooleanValue;
            } catch (Throwable th) {
                p63.f("JCommonFileHelper", "writeJson throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static boolean d(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File fileW = rv2.w(context, str);
                    if (fileW == null) {
                        return false;
                    }
                    return rv2.E(fileW, str2);
                }
            } catch (Throwable th) {
                p63.f("JCommonFileHelper", "writeString throwable:" + th.getMessage());
            }
        }
        return false;
    }
}
