package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class of2 {
    public static String a(String str, int i, String str2) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter("scene", i + "");
        builderBuildUpon.appendQueryParameter("roomid", str2);
        return builderBuildUpon.build().toString();
    }

    public static String b() {
        JSONObject config = vs0.a().getConfig("h5url");
        LogUtil.i("H5Url", "getBaseUrl h5Object=" + config);
        String strOptString = null;
        if (h()) {
            if (config != null && config.has("lxd_recharge_v3")) {
                strOptString = config.optString("lxd_recharge_v3");
            }
            return TextUtils.isEmpty(strOptString) ? c() : strOptString;
        }
        if (config != null && config.has("lxd_recharge")) {
            strOptString = config.optString("lxd_recharge");
        }
        if (TextUtils.isEmpty(strOptString)) {
            return nl0.k() ? "https://vas.cdn.lianxinapp.com/wallet-h5/gifts.html" : "http://short3.lx-qa.com/wallet-h5/gifts.html";
        }
        return strOptString;
    }

    public static String c() {
        return nl0.q + "/wallet/#/gifts";
    }

    public static String d() {
        return nl0.q + "/wallet/#/";
    }

    public static String e(int i, int i2, String str) {
        Uri.Builder builderBuildUpon = Uri.parse(b()).buildUpon();
        builderBuildUpon.appendQueryParameter("scene", i + "");
        builderBuildUpon.appendQueryParameter("from", i2 + "");
        builderBuildUpon.appendQueryParameter("roomid", str);
        return builderBuildUpon.build().toString();
    }

    public static String f(int i, int i2, String str, int i3, String str2, int i4) {
        return g(i, i2, str, i3, str2, i4, "-1", 0);
    }

    public static String g(int i, int i2, String str, int i3, String str2, int i4, String str3, int i5) {
        Uri.Builder builderBuildUpon = Uri.parse(b()).buildUpon();
        builderBuildUpon.appendQueryParameter("from", i + "");
        builderBuildUpon.appendQueryParameter("scene", i2 + "");
        builderBuildUpon.appendQueryParameter("roomid", str);
        builderBuildUpon.appendQueryParameter("type", i3 + "");
        builderBuildUpon.appendQueryParameter("domain", str2);
        builderBuildUpon.appendQueryParameter("bizType", i4 + "");
        builderBuildUpon.appendQueryParameter("sku", str3 + "");
        if (i5 > 0) {
            builderBuildUpon.appendQueryParameter("welfareType", i5 + "");
        }
        return builderBuildUpon.build().toString();
    }

    public static boolean h() {
        return true;
    }
}
