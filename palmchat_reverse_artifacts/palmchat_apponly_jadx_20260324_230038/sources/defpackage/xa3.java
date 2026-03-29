package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.Vo.MessageVo;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class xa3 {
    public static ah a(String str, String str2, String str3) {
        ah ahVar = new ah("LX_MSG_PUSH");
        ahVar.f18275a = str;
        ahVar.d = str3;
        ahVar.h = String.valueOf(str2);
        ahVar.i = "push";
        return ahVar;
    }

    public static void b(String str, String str2, String str3) {
        JSONObject jSONObject;
        String str4 = "";
        long j = 0;
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject2 = new JSONObject(str2).getJSONObject("openInfo");
                if (jSONObject2 != null && (jSONObject = jSONObject2.getJSONObject("content")) != null) {
                    String string = jSONObject.getString("appId");
                    try {
                        j = jSONObject.getLong("requestId");
                        str4 = string;
                    } catch (JSONException e) {
                        e = e;
                        str4 = string;
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        f84.e(a(str4, String.valueOf(j), str3), str);
    }

    public static void c(String str, String str2, String str3, String str4) {
        f84.e(a(str2, str3, str4), str);
    }

    public static void d(String str, MessageVo messageVo, Object... objArr) {
        String string;
        JSONObject jSONObject;
        Integer num;
        if (messageVo != null && a65.f(messageVo.from)) {
            String str2 = messageVo.extention;
            String string2 = "";
            if (TextUtils.isEmpty(str2)) {
                string = "";
            } else {
                try {
                    jSONObject = new JSONObject(str2).getJSONObject("openInfo");
                    string = jSONObject.getString("requestId");
                } catch (JSONException e) {
                    e = e;
                    string = "";
                } catch (Exception e2) {
                    e = e2;
                    string = "";
                }
                try {
                    string2 = new JSONObject(jSONObject.getString("content")).getString("appId");
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            if (objArr != null && objArr.length > 0 && (num = (Integer) objArr[0]) != null) {
                string = string + "_" + num;
            }
            f84.e(ah.b(string2, "seviceAccount", string), str);
        }
    }

    public static void e(String str, MessageProto.Message message) {
        String string;
        if (message != null && a65.f(m40.c(message.getFrom()))) {
            String extension = message.getExtension();
            String string2 = "";
            if (TextUtils.isEmpty(extension)) {
                string = "";
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(extension).getJSONObject("openInfo");
                    string = jSONObject.getString("requestId");
                    try {
                        string2 = new JSONObject(jSONObject.getString("content")).getString("appId");
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (JSONException e3) {
                    e = e3;
                    string = "";
                } catch (Exception e4) {
                    e = e4;
                    string = "";
                }
            }
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            f84.e(ah.b(string2, "seviceAccount", string), str);
        }
    }
}
