package defpackage;

import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class g00 {
    public static void a(yw4 yw4Var) {
        LogUtil.d("ChangeAppBackGroundDao", "postAppForBackgroud");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("verCode", ac1.f);
            jSONObject.put("verName", ac1.g);
            jSONObject.put("dhid", ac1.h);
            LocationEx locationExI = d.g().i(Long.MAX_VALUE);
            if (locationExI != null) {
                jSONObject.put(WkParams.LONGI, "" + locationExI.getLongitude());
                jSONObject.put(WkParams.LATI, "" + locationExI.getLatitude());
            }
            jSONObject.put(WkParams.IMEI, ac1.i);
            jSONObject.put("androidId", ac1.p);
            jSONObject.put("chanId", ac1.m);
            jSONObject.put("unreadMsgs", ch.s().A() + gu4.a());
            zw4.f(vm0.M, 1, jSONObject, yw4Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
