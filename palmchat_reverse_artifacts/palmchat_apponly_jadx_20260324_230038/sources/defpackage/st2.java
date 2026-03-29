package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.peoplenearby.CompleteGenderActivity;
import com.zenmen.palmchat.peoplenearby.CompleteSignatureActivity;
import com.zenmen.palmchat.peoplenearby.PeopleNearbyActivity;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class st2 {
    public static String a() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY);
        if (dynamicConfig == null) {
            return "附近1公里有人对你感兴趣，点击下一步去看看吧";
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return "附近1公里有人对你感兴趣，点击下一步去看看吧";
        }
        try {
            return new JSONObject(extra).optString("genderDialogContent", "附近1公里有人对你感兴趣，点击下一步去看看吧");
        } catch (Exception unused) {
            return "附近1公里有人对你感兴趣，点击下一步去看看吧";
        }
    }

    public static String b() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY);
        if (dynamicConfig == null) {
            return "向附近的人介绍自己";
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return "向附近的人介绍自己";
        }
        try {
            return new JSONObject(extra).optString("genderTitle", "向附近的人介绍自己");
        } catch (Exception unused) {
            return "向附近的人介绍自己";
        }
    }

    public static Intent c() {
        return e(false, false);
    }

    public static Intent d(boolean z) {
        return e(z, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent e(boolean z, boolean z2) {
        boolean z3;
        Intent intent = new Intent();
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
        if (contactInfoItemL != null) {
            z3 = true;
            if (TextUtils.isEmpty(contactInfoItemL.getGender() + "") || contactInfoItemL.getGender() == -1) {
                intent.setClass(AppContext.getContext(), CompleteGenderActivity.class);
            } else if (TextUtils.isEmpty(contactInfoItemL.getSignature())) {
                intent.setClass(AppContext.getContext(), CompleteSignatureActivity.class);
            } else {
                z3 = false;
            }
        }
        if (!z3) {
            intent.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, z);
            intent.setClass(AppContext.getContext(), PeopleNearbyActivity.class);
        }
        return intent;
    }

    public static String f() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY);
        if (dynamicConfig == null) {
            return "查看附近的人";
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return "查看附近的人";
        }
        try {
            return new JSONObject(extra).optString("signAction", "查看附近的人");
        } catch (Exception unused) {
            return "查看附近的人";
        }
    }

    public static String g() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY);
        if (dynamicConfig == null) {
            return "填写个性签名";
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return "填写个性签名";
        }
        try {
            return new JSONObject(extra).optString("signHint", "填写个性签名");
        } catch (Exception unused) {
            return "填写个性签名";
        }
    }

    public static String h() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY);
        if (dynamicConfig == null) {
            return "附近1公里有人对你很感兴趣";
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return "附近1公里有人对你很感兴趣";
        }
        try {
            return new JSONObject(extra).optString("signTips", "附近1公里有人对你很感兴趣");
        } catch (Exception unused) {
            return "附近1公里有人对你很感兴趣";
        }
    }

    public static String i() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY);
        if (dynamicConfig == null) {
            return "填写个性签名，会更受欢迎哦";
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return "填写个性签名，会更受欢迎哦";
        }
        try {
            return new JSONObject(extra).optString("signTitle", "填写个性签名，会更受欢迎哦");
        } catch (Exception unused) {
            return "填写个性签名，会更受欢迎哦";
        }
    }

    public static Intent j(Context context, String str) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        return intent;
    }

    public static void k(boolean z) {
        r75.o(AppContext.getContext(), k86.a("sp_has_used_people_nearby"), z);
    }
}
