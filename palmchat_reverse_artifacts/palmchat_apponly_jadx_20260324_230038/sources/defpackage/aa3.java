package defpackage;

import android.text.TextUtils;
import com.zenmen.openapi.OpenApiManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class aa3 {
    public static String a() {
        return c("defaultShareIconUrl", n44.f());
    }

    public static z93 b(String str) {
        z93 z93Var = new z93(null);
        String configString = OpenApiManager.getConfigString(str);
        if (TextUtils.isEmpty(configString)) {
            return z93Var;
        }
        try {
            return new z93(new JSONObject(configString));
        } catch (JSONException e) {
            ma3.d("get lxConfig failed because extra is not valid json str");
            ma3.c(e);
            return z93Var;
        }
    }

    public static String c(String str, String str2) {
        return b("openapiWebApp").a(str, str2);
    }
}
