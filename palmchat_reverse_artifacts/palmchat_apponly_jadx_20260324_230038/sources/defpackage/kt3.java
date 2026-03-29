package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kt3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f18826a;
    public static int b;

    public static void a() {
        try {
            DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.MINE_MY_FRIEND_UP);
            if (dynamicConfig == null || dynamicConfig.getExtra() == null || !dynamicConfig.isEnable()) {
                return;
            }
            JSONObject jSONObject = new JSONObject(dynamicConfig.getExtra());
            f18826a = jSONObject.optInt("whether_show");
            b = jSONObject.optInt("red_tips");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            f18826a = jSONObject.optInt("whether_show");
            b = jSONObject.optInt("red_tips");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
