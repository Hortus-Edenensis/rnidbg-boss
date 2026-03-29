package defpackage;

import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class nz {
    public static void a(HashMap<String, Object> map, CaptchaResult captchaResult) {
        if (map != null) {
            if (captchaResult == null) {
                map.put("verifyStatus", Boolean.FALSE);
                return;
            }
            map.put("verifyStatus", Boolean.TRUE);
            map.put("rid", captchaResult.rid);
            map.put("modeType", captchaResult.modeType);
            map.put("diffTime", Long.valueOf(captchaResult.diffTime));
        }
    }

    public static void b(JSONObject jSONObject, CaptchaResult captchaResult) {
        if (captchaResult != null) {
            try {
                jSONObject.put("verifyStatus", true);
                jSONObject.put("rid", captchaResult.rid);
                jSONObject.put("modeType", captchaResult.modeType);
                jSONObject.put("diffTime", captchaResult.diffTime);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean c(int i) {
        return i == 1900;
    }
}
