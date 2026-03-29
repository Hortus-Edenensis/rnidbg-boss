package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class cf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1968a = "GuideCongifUtils";

    public static boolean a() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SAVELX);
        boolean zOptBoolean = false;
        if (dynamicConfig.isEnable() && !TextUtils.isEmpty(dynamicConfig.getExtra())) {
            try {
                zOptBoolean = new JSONObject(dynamicConfig.getExtra()).optBoolean("huawei", false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        LogUtil.i(f1968a, "isHuaweiGuideEnable = " + zOptBoolean);
        return zOptBoolean;
    }
}
