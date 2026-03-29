package defpackage;

import com.huawei.openalliance.ad.constant.be;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f43 {
    public static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject b(bc4 bc4Var, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(bc4Var.g());
        map.put("room_id", sb.toString());
        map.put("anchor_id", bc4Var.b());
        map.put("enter_from_merge", bc4Var.d().lowerName());
        map.put("enter_method", bc4Var.e().lowerName());
        map.put("action_type", bc4Var.a().lowerName());
        map.put(be.g, bc4Var.f());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bc4Var.c());
        map.put("duration", sb2.toString());
        map.put("is_other_channel", "union_ad");
        return a(map);
    }
}
