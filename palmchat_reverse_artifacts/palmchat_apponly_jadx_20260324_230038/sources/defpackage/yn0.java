package defpackage;

import com.qiniu.android.collect.ReportItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Long f22234a = null;
    public static String b = null;
    public static boolean c = false;

    public static void a(String str, HashMap<String, Long> map) {
        if (str == null || !str.equals(b) || f22234a == null || map == null || !map.containsKey("2")) {
            return;
        }
        Long l = map.get("2");
        boolean z = l != null && l.longValue() < f22234a.longValue();
        c = z;
        LogUtil.setClientErrorLogOpen(z);
        LogUtil.i("ContactSyncLoopChecker", "checkContactSyncInErrorLoop lastContactSyncVersionResult=" + f22234a + " requestContactVerson=" + l + " isCurrentContactSyncInErrorLoop=" + c);
        if (c) {
            HashMap map2 = new HashMap();
            map2.put("action", "ClientSyncError");
            map2.put(ReportItem.LogTypeRequest, "" + l);
            map2.put("lastResponse", "" + f22234a);
            LogUtil.i("ContactSyncLoopChecker", LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, (HashMap<String, Object>) map2, (Throwable) null);
        }
    }

    public static boolean b() {
        LogUtil.i("ContactSyncLoopChecker", "isCurrentContactSyncInErrorLoop=" + c);
        return c;
    }

    public static void c(jq5 jq5Var, String str) {
        HashMap<String, Long> map;
        if (jq5Var == null || (map = jq5Var.c) == null || !map.containsKey("2")) {
            return;
        }
        b = str;
        f22234a = jq5Var.c.get("2");
        LogUtil.i("ContactSyncLoopChecker", "onLastSyncResult=" + f22234a);
    }
}
