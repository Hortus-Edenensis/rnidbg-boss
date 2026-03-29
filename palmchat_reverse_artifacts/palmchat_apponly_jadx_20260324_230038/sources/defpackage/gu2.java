package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatGiftConfig;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.intimacy.vo.IntimacyConfig;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.giftkit.GiftPanel;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.text.DecimalFormat;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gu2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IntimacyConfig f17808a;

    public static IntimacyConfig a() {
        if (f17808a == null) {
            JSONObject config = vs0.a().getConfig("intimacy");
            if (config != null) {
                f17808a = (IntimacyConfig) az2.a(config.toString(), IntimacyConfig.class);
            }
            if (f17808a == null) {
                f17808a = new IntimacyConfig();
            }
        }
        return f17808a;
    }

    public static String b(float f, boolean z) {
        String strReplace = new DecimalFormat("#0.0").format(f);
        if (strReplace.endsWith(".0")) {
            strReplace = strReplace.replace(".0", "");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strReplace);
        sb.append(z ? "°" : "");
        return sb.toString();
    }

    public static GiftPanel.g c(ChatItem chatItem) {
        if (!f() || chatItem.getChatType() != 0) {
            return null;
        }
        if (!((ContactInfoItem) chatItem).getIsStranger()) {
            String str = a().giftpanel_banner;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new GiftPanel.g(str);
        }
        if (!p05.c()) {
            return null;
        }
        String str2 = ChatGiftConfig.getChatGiftConfig().gift_nofrdbanner;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return new GiftPanel.g(null, str2);
    }

    public static void d(ContactInfoItem contactInfoItem) {
        if (f()) {
            MessageVo messageVoG = u0.g(contactInfoItem);
            messageVoG.status = 2;
            messageVoG.mimeType = 10000;
            String str = "双方亲密度达" + b(a().chatwindow_alert_call, false) + "°可解锁与TA的音视频功能，";
            messageVoG.text = str + "立即为关系升温>";
            messageVoG.data1 = "1";
            messageVoG.data2 = "{\"actionTypes\":\"activity\", \"actionBody\":\"" + str + "<a href='zenxin://activity?page=a0500'>立即为关系升温></a>\"}";
            b.t(messageVoG);
        }
    }

    public static boolean f() {
        return t66.h().f("LX-50066", false);
    }

    public static void g(Activity activity, ContactInfoItem contactInfoItem, boolean z, int i, int i2, String str, int i3) {
        if (contactInfoItem != null) {
            String str2 = ((((((nl0.q + "/intimacy/#/") + "?targetUid=" + contactInfoItem.getUid()) + "&type=" + i) + "&subtype=" + i2) + "&isFriend=" + (z ? 1 : 0)) + "&domain=" + str) + "&bizType=" + i3;
            Intent intent = new Intent();
            intent.setClass(activity, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", str2);
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putBoolean("hide_toolbar", true);
            bundle.putBoolean("hide_progressbar", true);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            activity.startActivity(intent);
            LogUtil.i("IntimacyManager", "url =" + str2);
        }
    }

    public static void h() {
        ju2.c();
    }

    public static void e(ChatItem chatItem, int i) {
    }
}
