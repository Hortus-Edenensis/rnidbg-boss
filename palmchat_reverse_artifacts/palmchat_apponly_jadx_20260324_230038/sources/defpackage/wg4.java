package defpackage;

import android.content.Context;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class wg4 {
    public static vg4 a(Context context) {
        ol2 ol2VarB = sb1.b(context);
        if (ol2VarB == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.e, 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("3711", null, jSONObject.toString());
            return new y82(context);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(az.e, ol2VarB.getDeviceType());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("3711", null, jSONObject2.toString());
        int deviceType = ol2VarB.getDeviceType();
        return deviceType != 1 ? deviceType != 2 ? deviceType != 3 ? deviceType != 4 ? new y82(context) : new og6(context, ol2VarB) : new l94(context, ol2VarB) : new xj2(context, ol2VarB) : new dp3(context, ol2VarB);
    }
}
