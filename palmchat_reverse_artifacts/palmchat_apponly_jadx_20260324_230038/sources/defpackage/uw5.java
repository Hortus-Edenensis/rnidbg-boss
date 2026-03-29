package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class uw5 {
    public static String a() {
        JSONObject jSONObjectR = ts0.o().r();
        if (jSONObjectR == null) {
            return "消息";
        }
        jSONObjectR.optString("all");
        return "消息";
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        String strOptString;
        JSONObject jSONObjectR = ts0.o().r();
        int iC = c();
        if (jSONObjectR == null) {
            strOptString = null;
        } else if (iC == 0) {
            strOptString = jSONObjectR.optString("newgroup");
        } else if (iC == 1) {
            strOptString = jSONObjectR.optString("actionName");
        }
        return iC == 1 ? TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.circle_settings_find) : strOptString : TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.thread_tab_new_group) : strOptString;
    }

    public static int c() {
        JSONObject jSONObjectR = ts0.o().r();
        if (jSONObjectR != null) {
            return jSONObjectR.optInt("newActionId");
        }
        return 1;
    }

    public static boolean d() {
        return ts0.o().L();
    }
}
