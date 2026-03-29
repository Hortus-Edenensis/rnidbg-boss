package defpackage;

import android.text.TextUtils;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bg2 {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a() {
        String strOptString;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.HANDINHAND);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            strOptString = null;
        } else {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    strOptString = new JSONObject(extra).optString(LxAdDLManager.ITEM_ICONURL);
                } catch (JSONException e) {
                    e.printStackTrace();
                    strOptString = null;
                }
            }
        }
        return strOptString == null ? "" : strOptString;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        String strOptString;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.HANDINHAND);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            strOptString = null;
        } else {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    strOptString = new JSONObject(extra).optString("name");
                } catch (JSONException e) {
                    e.printStackTrace();
                    strOptString = null;
                }
            }
        }
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.settings_item_handinhand) : strOptString;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c() {
        String strOptString;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.HANDINHAND);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            strOptString = null;
        } else {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    strOptString = new JSONObject(extra).optString("url");
                } catch (JSONException e) {
                    e.printStackTrace();
                    strOptString = null;
                }
            }
        }
        return strOptString == null ? "" : strOptString;
    }

    public static boolean d() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.HANDINHAND);
        return dynamicConfig != null && dynamicConfig.isEnable();
    }
}
