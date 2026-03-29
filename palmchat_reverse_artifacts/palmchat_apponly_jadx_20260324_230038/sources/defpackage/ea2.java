package defpackage;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ea2 {
    public static void a(String str, int i, String str2, int i2, yw4 yw4Var) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("toUid", str);
            jSONObject.put("giftId", i);
            jSONObject.put("domain", str2);
            if (DomainHelper.Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(str2) && fu5.q(i2)) {
                jSONObject.put("bizType", i2 + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zw4.f(vm0.Z0, 1, jSONObject, yw4Var);
    }
}
