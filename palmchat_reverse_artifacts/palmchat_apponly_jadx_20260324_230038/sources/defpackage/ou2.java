package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ou2 {
    public static String a() {
        String string = AppContext.getContext().getString(R.string.contact_invite_notice);
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.INVITEFRIENDS);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return string;
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return string;
        }
        try {
            return new JSONObject(extra).optString("notice", "");
        } catch (JSONException e) {
            e.printStackTrace();
            return string;
        }
    }
}
