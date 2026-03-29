package defpackage;

import android.text.TextUtils;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.zenmen.palmchat.chat.chatprofile.bean.ChatProfileInfo;
import com.zenmen.palmchat.chat.chatprofile.bean.LifeFeed;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class px3 {
    public static String a(String str, ChatProfileInfo chatProfileInfo) {
        if (chatProfileInfo == null) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("cityName", chatProfileInfo.cityName);
            jSONObject.put("feedUrls", b(chatProfileInfo));
            jSONObject.put("ext", chatProfileInfo.ext);
            jSONObject.put("sex", chatProfileInfo.sex);
            jSONObject.put("age", chatProfileInfo.age);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String b(ChatProfileInfo chatProfileInfo) {
        StringBuilder sb = new StringBuilder();
        List<LifeFeed> list = chatProfileInfo.lifeList;
        if (list != null) {
            int iMin = Math.min(3, list.size());
            for (int i = 0; i < iMin; i++) {
                sb.append(chatProfileInfo.lifeList.get(i).thumbUrl);
                if (i != iMin - 1) {
                    sb.append(",");
                }
            }
        }
        LogUtil.i("NewFriendRequestInfoHelper", "genFeedUrls " + ((Object) sb));
        return sb.toString();
    }

    public static List<String> c(String str) {
        if (str == null) {
            return null;
        }
        try {
            String strOptString = new JSONObject(str).optString("feedUrls");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return Arrays.asList(strOptString.split(","));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void d(String str, int i) {
        HashMap map = new HashMap();
        map.put("type", i == 0 ? IMediaFormat.KEY_PROFILE : "button");
        map.put("fuid", str);
        zn6.i("pagemsg_newfrd_cli", map);
    }
}
