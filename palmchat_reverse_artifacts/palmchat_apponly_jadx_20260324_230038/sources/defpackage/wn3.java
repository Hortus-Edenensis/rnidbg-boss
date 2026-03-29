package defpackage;

import im.youni.iccs.iprotobuf.domain.MessageProto;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wn3 {
    public static String a(MessageProto.Message message) {
        String extension;
        if (message == null || (extension = message.getExtension()) == null) {
            return null;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(extension).optJSONObject("revokeMsg");
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject.optString("replaceMid");
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
