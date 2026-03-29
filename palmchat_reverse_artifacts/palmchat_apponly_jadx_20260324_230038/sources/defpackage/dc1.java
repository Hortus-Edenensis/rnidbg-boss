package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class dc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ec1 f17018a;

    public static void a() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.DHREDDOT);
        if (dynamicConfig == null || dynamicConfig.getExtra() == null) {
            return;
        }
        try {
            f17018a = new ec1(new JSONObject(dynamicConfig.getExtra()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String b() {
        return jo6.c("LX-38802", "A");
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f17018a = new ec1(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
