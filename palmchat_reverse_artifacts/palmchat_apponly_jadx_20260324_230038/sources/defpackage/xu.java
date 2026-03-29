package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class xu {
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d6, code lost:
    
        if ((r7 - r11) < (((long) (r4 * 60)) * 1000)) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str) {
        boolean z;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.REDACTBUBBLE);
        if (!TextUtils.isEmpty(str) && dynamicConfig != null && dynamicConfig.isEnable() && !TextUtils.isEmpty(dynamicConfig.getExtra())) {
            LogUtil.i("BubbleUtils", "bubble config :" + dynamicConfig.getExtra());
            try {
                JSONObject jSONObject = new JSONObject(dynamicConfig.getExtra());
                int iOptInt = jSONObject.optInt("vanishType", 0);
                int iOptInt2 = jSONObject.optInt("openFriendNum", 0);
                int iOptInt3 = jSONObject.optInt("openFriendOps", 0);
                int iOptInt4 = jSONObject.optInt("rate", 0);
                int iOptInt5 = jSONObject.optInt("version", 0);
                if (b(str, jSONObject.optJSONArray("iconPos")) && c(iOptInt2, iOptInt3)) {
                    long jB = ir5.b();
                    long jH = r75.h(c.b(), "sp_bubble_first_show_time");
                    boolean zC = r75.c(c.b(), "sp_bubble_click_flag");
                    boolean zC2 = r75.c(c.b(), "sp_bubble_cancel_flag");
                    if (r75.f(c.b(), "sp_bubble_version") != iOptInt5 || jH == 0 || (iOptInt4 != 0 && jB - jH > ((long) (iOptInt4 * 3600)) * 1000)) {
                        try {
                            r75.q(c.b(), "sp_bubble_first_show_time", 0L);
                            r75.o(c.b(), "sp_bubble_click_flag", false);
                            r75.o(c.b(), "sp_bubble_cancel_flag", false);
                            r75.p(c.b(), "sp_bubble_version", iOptInt5);
                        } catch (Exception e) {
                            e = e;
                            z = true;
                            e.printStackTrace();
                            return z;
                        }
                    } else if (!zC2) {
                        if (iOptInt != -1) {
                            if (iOptInt >= 0) {
                            }
                        } else if (zC) {
                        }
                    }
                    return true;
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
        }
        return false;
    }

    public static boolean b(String str, JSONArray jSONArray) {
        boolean z = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            if (str.equals(jSONArray.optString(i))) {
                z = true;
            }
        }
        return z;
    }

    public static boolean c(int i, int i2) {
        int iJ = bo0.r().j();
        return i2 == 0 ? iJ == i : i2 == 1 ? iJ > i : i2 == 2 && iJ < i;
    }
}
