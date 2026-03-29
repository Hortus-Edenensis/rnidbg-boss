package defpackage;

import com.lantern.auth.server.WkParams;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class fc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17502a = "";

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020 A[Catch: JSONException -> 0x0035, TryCatch #0 {JSONException -> 0x0035, blocks: (B:6:0x0014, B:8:0x001a, B:10:0x0025, B:9:0x0020), top: B:15:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, Map map) {
        JSONObject jSONObject;
        if ("svideo_tab_click".equals(str)) {
            f17502a = UUID.randomUUID().toString();
        }
        if (map != null) {
            try {
                jSONObject = !map.isEmpty() ? new JSONObject(map) : new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.putOpt(WkParams.SESSIONID, f17502a);
        zn6.d(str, null, jSONObject.toString());
    }
}
