package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class lu4 {
    public static boolean a() {
        return false;
    }

    public static boolean b() {
        return false;
    }

    public static boolean c() {
        if (!nl0.g()) {
            return true;
        }
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.REDPACKET);
        if (!dynamicConfig.isEnable() || TextUtils.isEmpty(dynamicConfig.getExtra())) {
            return false;
        }
        try {
            return new JSONObject(dynamicConfig.getExtra()).optBoolean("basicOpen", false);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean d() {
        return false;
    }
}
