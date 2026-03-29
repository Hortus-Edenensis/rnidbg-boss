package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ao0 {
    public static String a() {
        String strOptString;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.CONTACTPERMISSIONGUIDE);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            strOptString = null;
        } else {
            try {
                strOptString = new JSONObject(dynamicConfig.getExtra()).optString("button");
            } catch (Exception e) {
                e.printStackTrace();
                strOptString = null;
            }
        }
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.permission_granted_guide_contact_button) : strOptString;
    }

    public static boolean b() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.CONTACTPERMISSIONGUIDE);
        if (dynamicConfig == null) {
            return false;
        }
        return dynamicConfig.isEnable();
    }

    public static String c() {
        String strOptString;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.CONTACTPERMISSIONGUIDE);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            strOptString = null;
        } else {
            try {
                strOptString = new JSONObject(dynamicConfig.getExtra()).optString("subTitle");
            } catch (Exception e) {
                e.printStackTrace();
                strOptString = null;
            }
        }
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.permission_granted_guide_contact_detail) : strOptString;
    }

    public static String d() {
        String strOptString;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.CONTACTPERMISSIONGUIDE);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            strOptString = null;
        } else {
            try {
                strOptString = new JSONObject(dynamicConfig.getExtra()).optString("title");
            } catch (Exception e) {
                e.printStackTrace();
                strOptString = null;
            }
        }
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.permission_granted_guide_contact_title) : strOptString;
    }

    public static String e() {
        String strOptString;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ALERTNEWUSER);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            strOptString = null;
        } else {
            try {
                strOptString = new JSONObject(dynamicConfig.getExtra()).optString("detailClickTip");
            } catch (Exception e) {
                e.printStackTrace();
                strOptString = null;
            }
        }
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.contact_alert_high_node_recommend_detail_click_toast) : strOptString;
    }

    public static boolean f() {
        return true;
    }
}
