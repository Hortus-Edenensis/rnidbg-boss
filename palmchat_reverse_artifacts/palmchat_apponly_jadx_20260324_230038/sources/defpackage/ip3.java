package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ip3 {
    public static void a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("report_type", str2);
            LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_KEEPALIVE, null, str, null, null, jSONObject.toString());
            zn6.d(str, null, jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(String str, String str2, Map<String, String> map) {
        zn6.h(str, str2, map);
    }

    public static void c(String str) {
        a(str, "click");
    }

    public static void d(String str) {
        a(str, "view");
    }
}
