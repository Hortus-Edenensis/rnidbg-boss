package defpackage;

import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.peoplenearby.PeopleNearbyVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xs2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22041a;
    public String b;
    public boolean c;
    public PeopleNearbyVo d;
    public JSONObject e;
    public String f;
    public String g;
    public String h;
    public String i;

    public xs2() {
    }

    public static xs2 a(JSONObject jSONObject) {
        LogUtil.i("InitVo", "" + jSONObject);
        if (jSONObject == null) {
            return null;
        }
        xs2 xs2Var = new xs2();
        xs2Var.c = jSONObject.optBoolean("userstatus", false);
        xs2Var.f22041a = jSONObject.optString("action");
        xs2Var.b = jSONObject.optString(DeviceInfoUtil.UID_TAG, null);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("contact");
        if (jSONObjectOptJSONObject != null) {
            xs2Var.d = PeopleNearbyVo.parseItem(jSONObjectOptJSONObject);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(EventParams.KEY_GROUP);
        if (jSONObjectOptJSONObject2 != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObjectOptJSONObject2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("modRooms", jSONArray);
                xs2Var.e = jSONObject2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return xs2Var;
    }

    public xs2(String str) {
        this.f22041a = str;
    }
}
