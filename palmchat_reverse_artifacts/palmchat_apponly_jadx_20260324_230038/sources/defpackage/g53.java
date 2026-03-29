package defpackage;

import com.umeng.analytics.pro.f;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.location.LocationEx;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class g53 {
    public static LocationEx a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new LocationEx(jSONObject.getDouble(f.C), jSONObject.getDouble("lon"), jSONObject.getString("type"), jSONObject.getString("name"), jSONObject.getString("address"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static LocationEx b(MessageVo messageVo) {
        LocationEx locationExA = a(messageVo.data1);
        if (locationExA == null) {
            return null;
        }
        locationExA.setStaticMapImageUrl(messageVo.data2);
        return locationExA;
    }

    public static String c(LocationEx locationEx, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f.C, locationEx.getLatitude());
            jSONObject.put("lon", locationEx.getLongitude());
            jSONObject.put("name", locationEx.getName());
            jSONObject.put("address", locationEx.getAddress());
            jSONObject.put("type", locationEx.getCoorType());
            jSONObject.put("nearbyCount", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
