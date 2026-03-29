package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f18707a = false;
    public static Boolean b;

    public static boolean a() {
        JSONObject config = vs0.a().getConfig("HttpDnsAndroid");
        boolean zOptBoolean = config != null ? config.optBoolean("videoEnable") : false;
        LogUtil.d("HttpDnsConfigHelper", "isExoPlayerUserHttpDns result =" + zOptBoolean);
        return zOptBoolean;
    }

    public static boolean b() {
        if (b == null) {
            b = Boolean.valueOf(c());
        }
        LogUtil.d("HttpDnsConfigHelper", "isImageLoadUserHttpDns result =" + b);
        return b.booleanValue();
    }

    public static boolean c() {
        JSONObject config = vs0.a().getConfig("HttpDnsAndroid");
        boolean zOptBoolean = config != null ? config.optBoolean("imageEnable") : false;
        LogUtil.d("HttpDnsConfigHelper", "isExoPlayerUserHttpDns result =" + zOptBoolean);
        return zOptBoolean;
    }

    public static boolean d(String str) {
        boolean z;
        JSONObject config;
        JSONArray jSONArrayOptJSONArray;
        try {
            config = vs0.a().getConfig("HttpDnsAndroid");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (config == null || (jSONArrayOptJSONArray = config.optJSONArray("webViewWhiteList")) == null || jSONArrayOptJSONArray.length() <= 0) {
            z = false;
        } else {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (Pattern.matches((String) jSONArrayOptJSONArray.get(i), str)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        LogUtil.d("HttpDnsConfigHelper", "isWebUrlInWhite url=" + str + " result =" + z);
        return z || f18707a;
    }
}
