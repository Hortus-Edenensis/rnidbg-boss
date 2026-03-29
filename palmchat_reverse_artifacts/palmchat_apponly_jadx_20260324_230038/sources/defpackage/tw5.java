package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class tw5 {
    public static String a(ChatItem chatItem, String str, String str2, String str3, String str4, String str5) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        if (chatItem != null) {
            try {
                jSONObject.put(DeviceInfoUtil.UID_TAG, chatItem.getChatId());
                jSONObject.put("nickname", chatItem.getChatName());
                if (!(chatItem instanceof GroupInfoItem) || TextUtils.isEmpty(str5)) {
                    z = false;
                } else {
                    jSONObject.put("body", str5);
                    z = true;
                }
                jSONObject.put("isgroup", z);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        jSONObject.put("senderUid", str);
        jSONObject.put("senderName", str2);
        jSONObject.put("toUid", str3);
        jSONObject.put("toName", str4);
        return jSONObject.toString();
    }

    public static String b(Context context, String str, String str2) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("nickname");
            String strOptString2 = jSONObject.optString("senderUid");
            String strOptString3 = jSONObject.optString("senderName");
            jSONObject.optString("toUid");
            jSONObject.optString("toName");
            if (jSONObject.optBoolean("isgroup")) {
                String strOptString4 = jSONObject.optString("body");
                if (!TextUtils.isEmpty(strOptString4)) {
                    return strOptString4;
                }
            }
            if (!TextUtils.isEmpty(strOptString2) && strOptString2.equals(AccountUtils.p(AppContext.getContext()))) {
                string = TextUtils.isEmpty(str2) ? context.getString(R.string.thread_name_card_content_self, strOptString) : context.getString(R.string.thread_name_card_content_self2, str2, strOptString);
            } else {
                if (!TextUtils.isEmpty(strOptString3)) {
                    str2 = strOptString3;
                }
                string = context.getString(R.string.thread_name_card_content_other, str2, strOptString);
            }
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String c(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("nickname");
            jSONObject.optString("senderUid");
            jSONObject.optString("senderName");
            jSONObject.optString("toUid");
            jSONObject.optString("toName");
            if (!jSONObject.optBoolean("isgroup")) {
                return "[个人名片]" + strOptString;
            }
            if (strOptString.equals("群聊")) {
                return "[群名片]";
            }
            return "[群名片]" + strOptString;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
