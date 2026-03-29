package defpackage;

import android.app.Activity;
import android.net.Uri;
import android.util.Pair;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rk4 {
    public static JSONObject a(ContactInfoItem contactInfoItem) {
        HashMap map = new HashMap();
        map.put("toUser", contactInfoItem.getUid());
        map.put("nickName", contactInfoItem.getNickName());
        HashMap map2 = new HashMap();
        Pair<String, Integer> pairJ = fu5.j(contactInfoItem.getBizType());
        map2.put("domain", pairJ.first);
        map2.put("bizType", pairJ.second);
        map.put("bizExt", map2);
        return new JSONObject(map);
    }

    public static String b(boolean z) {
        JSONObject config = vs0.a().getConfig("amulet");
        if (config != null) {
            return z ? config.optString("mytab_with_txt") : config.optString("mytab_without_txt");
        }
        return null;
    }

    public static String c() {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject config = vs0.a().getConfig("amulet");
            if (config == null || (jSONArrayOptJSONArray = config.optJSONArray("profile_txt_new")) == null || jSONArrayOptJSONArray.length() <= 0) {
                return null;
            }
            return jSONArrayOptJSONArray.optString(new Random().nextInt(jSONArrayOptJSONArray.length()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(Activity activity, int i, ContactInfoItem contactInfoItem, int i2, int i3, int i4) {
        int i5;
        StringBuilder sb = new StringBuilder();
        if (rw0.b()) {
            i5 = 1;
            if (i2 == 2) {
                sb.append("#/backpack");
                if (i != 15) {
                    i5 = 0;
                }
            } else if (i3 <= 0) {
            }
        } else {
            i5 = i2;
        }
        sb.append("?fromSource=" + i);
        sb.append("&activeName=" + i5);
        if (!rw0.b()) {
            sb.append("&taichiValue=" + WkAdxAdConfigMg.DSP_NAME_BAIDU);
        }
        if (i3 > 0) {
            sb.append("&itemId=" + i3);
        }
        if (i4 > 0) {
            sb.append("&ornamentId=" + i4);
        }
        if (contactInfoItem != null) {
            sb.append("&contact=" + Uri.encode(a(contactInfoItem).toString()));
        }
        LogUtil.i("PortraitDecorManager", "jump2Store " + sb.toString());
        if (rw0.b()) {
            ve.A(activity, "mall", sb.toString(), Boolean.FALSE, null, false, null);
        } else {
            ve.A(activity, "pendant", sb.toString(), Boolean.FALSE, null, false, null);
        }
    }

    public static boolean e() {
        JSONObject config = vs0.a().getConfig("amulet");
        if (config != null) {
            return config.optBoolean("store_enable", false);
        }
        return false;
    }
}
