package defpackage;

import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.contacts.UserDetailActivityV2;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class m66 {
    public static String a() {
        JSONObject config = vs0.a().getConfig("user_detail");
        return config != null ? config.optString("profileedit_title", "头像相册上线，立即设置") : "头像相册上线，立即设置";
    }

    public static String b() {
        JSONObject config = vs0.a().getConfig("user_detail");
        return config != null ? config.optString("my_title", "全新个人主页") : "全新个人主页";
    }

    public static Class c() {
        return f() ? UserDetailActivityV2.class : UserDetailActivity.class;
    }

    public static boolean d() {
        JSONObject config = vs0.a().getConfig("user_detail");
        if (config != null) {
            return config.optBoolean("portrait_permission_enable", true);
        }
        return true;
    }

    public static boolean e() {
        JSONObject config = vs0.a().getConfig("user_detail");
        if (config != null) {
            return config.optBoolean("albumreddot", true);
        }
        return true;
    }

    public static boolean f() {
        ContactInfoItem contactInfoItemA = dn0.a(v4.e(c.b()));
        return (contactInfoItemA != null ? contactInfoItemA.getGender() : -1) == 1;
    }
}
