package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21515a = "BigTextConfigUtils";

    public static List<mo> a() {
        String extra = rl0.h().d().getDynamicConfig(DynamicConfig.Type.BIGTEXT).getExtra();
        String strOptString = null;
        if (!TextUtils.isEmpty(extra)) {
            try {
                strOptString = new JSONObject(extra).optString("background");
                LogUtil.i(f21515a, "config background extra: " + extra);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return mo.a(strOptString);
    }

    public static List<v02> b() {
        String extra = rl0.h().d().getDynamicConfig(DynamicConfig.Type.BIGTEXT).getExtra();
        LogUtil.i(f21515a, "config extra: " + extra);
        String strOptString = null;
        if (!TextUtils.isEmpty(extra)) {
            try {
                strOptString = new JSONObject(extra).optString("font");
                LogUtil.i(f21515a, "fontConfig extra: " + extra);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return v02.a(strOptString);
    }
}
