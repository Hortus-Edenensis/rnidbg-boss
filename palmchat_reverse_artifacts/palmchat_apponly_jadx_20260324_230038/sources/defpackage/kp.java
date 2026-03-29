package defpackage;

import android.text.TextUtils;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class kp {
    public static String a() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.REDACTBANNER);
        if (dynamicConfig == null || !dynamicConfig.isEnable() || TextUtils.isEmpty(dynamicConfig.getExtra())) {
            return null;
        }
        LogUtil.i("BannerUtils", "banner config :" + dynamicConfig.getExtra());
        try {
            JSONObject jSONObject = new JSONObject(dynamicConfig.getExtra());
            String strOptString = jSONObject.optString(LxAdDLManager.ITEM_ICONURL);
            if (!b(jSONObject.optInt("openFriendNum", 0), jSONObject.optInt("openFriendOps", 0))) {
                return null;
            }
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return strOptString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean b(int i, int i2) {
        int iJ = bo0.r().j();
        return i2 == 0 ? iJ == i : i2 == 1 ? iJ > i : i2 == 2 && iJ < i;
    }
}
