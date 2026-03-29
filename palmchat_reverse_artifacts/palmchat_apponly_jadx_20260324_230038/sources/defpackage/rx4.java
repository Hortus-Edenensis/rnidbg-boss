package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rx4 {
    public static String a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.send_failed) : strOptString;
    }

    public static void b(Context context, JSONObject jSONObject) {
        Context context2 = (Context) new WeakReference(context).get();
        if (context2 == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("resultCode");
        String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (iOptInt == 1320) {
            sd3 sd3Var = new sd3(context2);
            sd3Var.U(AppContext.getContext().getResources().getString(R.string.send_failed));
            sd3Var.k(strOptString);
            sd3Var.P(AppContext.getContext().getResources().getString(R.string.alert_dialog_ok));
            sd3Var.Q();
            return;
        }
        if (iOptInt == 1321) {
            sd3 sd3Var2 = new sd3(context2);
            sd3Var2.U(AppContext.getContext().getResources().getString(R.string.send_failed));
            sd3Var2.k(strOptString);
            sd3Var2.P(AppContext.getContext().getResources().getString(R.string.alert_dialog_ok));
            sd3Var2.Q();
        }
    }
}
