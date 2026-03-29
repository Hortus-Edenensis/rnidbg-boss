package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ModifyContactInfoActivity;
import com.zenmen.palmchat.contacts.ModifyContactInfoActivityV2;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import com.zenmen.palmchat.contacts.bean.Skip;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class io0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18210a = ao0.class.getSimpleName();

    public static void a() {
        if (q()) {
            return;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        int iF = sPUtil.f(scene, k86.a("key_contact_enhanced_cancel_count"), 0);
        if (iF >= e()) {
            sPUtil.t(scene, k86.a("key_contact_enhanced_cancel_count"), 0);
        } else {
            sPUtil.t(scene, k86.a("key_contact_enhanced_cancel_count"), Integer.valueOf(iF + 1));
        }
    }

    public static void b() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        sPUtil.t(scene, k86.a("key_contact_enhanced_cancel_count"), 0);
        sPUtil.t(scene, k86.a("key_contact_enhanced_ignore_timestamp"), Long.valueOf(System.currentTimeMillis()));
    }

    public static int c() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.CONTACTCARD);
        if (dynamicConfig != null && dynamicConfig.isEnable()) {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    return new JSONObject(extra).optInt("showDay");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return 7;
    }

    public static String d(ContactInfoItem contactInfoItem) {
        ContactExtBean ext;
        Skip skip;
        if (contactInfoItem != null && (ext = contactInfoItem.getExt()) != null && (skip = ext.getSkip()) != null && skip.isEnable()) {
            String scope = skip.getScope();
            if (TextUtils.isEmpty(scope)) {
                return null;
            }
            boolean z = false;
            try {
                int[] iArr = {-1, -1};
                String[] strArrSplit = scope.split("-");
                if (strArrSplit.length == 2) {
                    iArr[0] = Integer.parseInt(strArrSplit[0]);
                    iArr[1] = Integer.parseInt(strArrSplit[1]);
                    long j = (Long.parseLong(AccountUtils.p(AppContext.getContext())) >> 14) % 100;
                    if (j >= iArr[0]) {
                        if (j <= iArr[1]) {
                            z = true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (z) {
                return skip.getUrl();
            }
        }
        return null;
    }

    public static int e() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ENHANCEDCONTACT);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return 3;
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return 3;
        }
        try {
            return new JSONObject(extra).optInt("cancelCount", 3);
        } catch (JSONException e) {
            e.printStackTrace();
            return 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long f() {
        int iOptInt;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ENHANCEDCONTACT);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            iOptInt = 0;
        } else {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    iOptInt = new JSONObject(extra).optInt("enterCoolTime");
                } catch (JSONException e) {
                    e.printStackTrace();
                    iOptInt = 0;
                }
            }
        }
        return ((long) iOptInt) * 1000;
    }

    public static int g() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ENHANCEDCONTACT);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return 7;
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return 7;
        }
        try {
            return new JSONObject(extra).optInt("ignoreDay", 7);
        } catch (JSONException e) {
            e.printStackTrace();
            return 7;
        }
    }

    public static Class<? extends Activity> h() {
        return jo6.t() ? ModifyContactInfoActivityV2.class : ModifyContactInfoActivity.class;
    }

    public static String i() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ONEKEYSWITCH);
        if (dynamicConfig != null && dynamicConfig.isEnable()) {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    return new JSONObject(extra).optString("guideMsg");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String j() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ONEKEYSWITCH);
        if (dynamicConfig != null && dynamicConfig.isEnable()) {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    return new JSONObject(extra).optString("notice");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static int k() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ONEKEYSWITCH);
        if (dynamicConfig != null && dynamicConfig.isEnable()) {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    return new JSONObject(extra).optInt("minNum");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public static int l() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ONEKEYSWITCH);
        if (dynamicConfig != null && dynamicConfig.isEnable()) {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    return new JSONObject(extra).optInt("userStatus");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public static List<String> m() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ONEKEYSWITCH);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return null;
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return null;
        }
        try {
            String strOptString = new JSONObject(extra).optString("filterList");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return Arrays.asList(strOptString.split(","));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean n() {
        return false;
    }

    public static boolean o(int i) {
        return i == 3 || i == 20 || i == 22;
    }

    public static boolean p(int i) {
        return i == 3 || i == 20 || i == 22 || i == 200;
    }

    public static boolean q() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        long jI = sPUtil.i(scene, k86.a("key_contact_enhanced_ignore_timestamp"), 0L);
        if (jI <= 0) {
            return false;
        }
        if (Math.abs(System.currentTimeMillis() - jI) < ((long) (g() * 24 * 60 * 60)) * 1000) {
            return true;
        }
        sPUtil.t(scene, k86.a("key_contact_enhanced_ignore_timestamp"), 0L);
        return false;
    }

    public static boolean r() {
        return SPUtil.f14322a.f(SPUtil.SCENE.CONTACT, k86.a("key_contact_enhanced_cancel_count"), 0) >= e();
    }

    public static boolean s(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public static boolean t(int i) {
        return true;
    }

    public static boolean u(int i) {
        return i == 7 || i == 17 || i == 10;
    }

    public static String v(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (dt2.b(str) <= 32) {
                return str;
            }
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= str.length()) {
                    i = 0;
                    break;
                }
                int iCodePointAt = Character.codePointAt(str, i);
                i2 = (iCodePointAt < 0 || iCodePointAt > 255) ? i2 + 2 : i2 + 1;
                if (i2 > 32) {
                    break;
                }
                i++;
            }
            return str.substring(0, i);
        } catch (Exception unused) {
            return "";
        }
    }
}
