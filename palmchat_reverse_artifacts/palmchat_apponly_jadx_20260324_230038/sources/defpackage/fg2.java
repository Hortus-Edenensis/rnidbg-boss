package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class fg2 {
    public static long a() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.HANDINHANDV3);
        if (dynamicConfig != null && dynamicConfig.isEnable()) {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    return new JSONObject(extra).optLong("interval");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        String strOptString;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.HANDINHANDV3);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            strOptString = null;
        } else {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    strOptString = new JSONObject(extra).optString("subTitle");
                } catch (JSONException e) {
                    e.printStackTrace();
                    strOptString = null;
                }
            }
        }
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.settings_item_handinhandv3_subtitl_head) : strOptString;
    }

    public static boolean c() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.HANDINHANDV3);
        return dynamicConfig != null && dynamicConfig.isEnable();
    }
}
