package defpackage;

import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class oc0 {
    public static boolean a() {
        return jo6.a("LX-29585", false);
    }

    public static boolean b() {
        return f();
    }

    public static boolean c() {
        return f();
    }

    public static boolean d() {
        return f();
    }

    public static boolean e() {
        return f() && jo6.a("LX-33153", false);
    }

    public static boolean f() {
        return true;
    }

    public static void g(String str) {
        h(str, null);
    }

    public static void h(String str, Map<String, Object> map) {
        HashMap map2 = new HashMap(1);
        if (map == null) {
            map = new HashMap<>(1);
        }
        map.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
        JSONObject jSONObject = new JSONObject(map);
        map2.put("ext", jSONObject.toString());
        LogUtil.d("EventId", "evenid = " + str + ",map=" + map2);
        zn6.g(str, jSONObject);
    }

    public static void i(String str, Map<String, Object> map) {
        HashMap map2 = new HashMap(1);
        if (map == null) {
            map = new HashMap<>(1);
        }
        JSONObject jSONObject = new JSONObject(map);
        map2.put("ext", jSONObject.toString());
        LogUtil.d("EventId", "evenid = " + str + ",map=" + map2);
        zn6.g(str, jSONObject);
    }

    public static boolean j(MessageProto.Message message) {
        return message != null && d() && fu5.o(message) == 0 && message.getExType() == 1;
    }
}
