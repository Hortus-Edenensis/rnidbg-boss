package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.g;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.settings.about.AboutActivity;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.update.UpdateManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zy4 {
    public static String a(String str, String str2, String str3) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String b(String str, Map<String, String> map) {
        try {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            for (String str2 : map.keySet()) {
                builderBuildUpon.appendQueryParameter(str2, map.get(str2));
            }
            return builderBuildUpon.build().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String c(String str) {
        return Uri.parse(str).getHost();
    }

    public static List<String> d(String str) {
        return Uri.parse(str).getPathSegments();
    }

    public static HashMap<String, String> e(String str) {
        HashMap<String, String> map = new HashMap<>();
        try {
            Uri uri = Uri.parse(str);
            for (String str2 : uri.getQueryParameterNames()) {
                map.put(str2, uri.getQueryParameter(str2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String f(String str) {
        return Uri.parse(str).getScheme();
    }

    public static boolean g(Activity activity, int i, ContentValues contentValues, y56 y56Var, String str, RichMsgExItemVo richMsgExItemVo, ChatItem chatItem) {
        if (i == -1) {
            return k(activity, contentValues, y56Var, str, richMsgExItemVo, chatItem);
        }
        if (i == 3) {
            return h(activity, contentValues);
        }
        if (i == 10 && (activity instanceof FrameworkBaseActivity)) {
            ve.s((FrameworkBaseActivity) activity, str, false);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(Activity activity, ContentValues contentValues) {
        String asString = contentValues.getAsString("page");
        if (TextUtils.isEmpty(asString)) {
            return false;
        }
        asString.hashCode();
        switch (asString) {
            case "a00010":
                activity.startActivity(tj6.a(activity, contentValues.getAsString("url"), "1".equals(contentValues.getAsString("fullwindow")), false));
                return true;
            case "a00320":
                activity.startActivity(on0.a("upload_contact_from_newcontact"));
                return true;
            case "a0001":
                Intent intentC = st2.c();
                if (TeenagersModeManager.a().d()) {
                    zt5.c();
                } else {
                    intentC.putExtra("fromType", 7);
                    activity.startActivity(intentC);
                }
                return true;
            case "a0002":
                activity.startActivity(nn4.a(activity, 10));
                return true;
            case "a0003":
                UpdateManager.G().Z();
                return true;
            case "a0004":
                if (nx3.a("key_new_feedback")) {
                    nx3.e("key_new_feedback");
                }
                Intent intent = new Intent();
                intent.setClass(activity, CordovaWebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("web_url", AboutActivity.B);
                bundle.putBoolean("web_show_right_menu", false);
                bundle.putInt("BackgroundColor", -1);
                intent.putExtras(bundle);
                activity.startActivity(intent);
                return true;
            case "a0043":
                Intent intent2 = new Intent();
                intent2.setClass(activity, CordovaWebActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("web_url", tj2.s());
                bundle2.putBoolean("web_show_right_menu", false);
                bundle2.putInt("BackgroundColor", -1);
                intent2.putExtras(bundle2);
                activity.startActivity(intent2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(az.at, 2);
                    break;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("H2", null, null, jSONObject.toString());
                return true;
            case "a0061":
                Intent intent3 = new Intent(activity, (Class<?>) m66.c());
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(AccountUtils.p(AppContext.getContext()));
                intent3.putExtra("user_item_info", contactInfoItem);
                intent3.putExtra("from", 5);
                activity.startActivity(intent3);
                return true;
            case "a0100":
                n86.d(activity);
                return true;
            case "a0101":
                wg4.a(activity).e();
                return true;
            case "a0102":
                v66.b().e();
                LogUtil.uploadInfoImmediate("801", "1", null, null);
                return true;
            default:
                return false;
        }
    }

    public static Map<String, String> i(String str, ChatItem chatItem) {
        return j(str, DomainHelper.a(chatItem, true));
    }

    public static Map<String, String> j(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("srcUid", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("scene", str2);
        }
        return map;
    }

    public static boolean k(Activity activity, ContentValues contentValues, y56 y56Var, String str, RichMsgExItemVo richMsgExItemVo, ChatItem chatItem) {
        String str2;
        if (y56Var == null || "1".equals(y56Var.a())) {
            str2 = str;
        } else {
            String strB = y56Var.b();
            if ("1".equals(y56Var.k())) {
                try {
                    strB = k86.Z(strB);
                } catch (UnsupportedEncodingException unused) {
                }
            }
            str2 = strB;
        }
        p(activity, str2, richMsgExItemVo, true, true, null, -1, -1, null, -1, chatItem, false);
        return true;
    }

    public static void l(Context context, String str, RichMsgExItemVo richMsgExItemVo, boolean z, boolean z2) {
        m(context, str, richMsgExItemVo, z, z2, null, -1);
    }

    public static void m(Context context, String str, RichMsgExItemVo richMsgExItemVo, boolean z, boolean z2, String str2, int i) {
        n(context, str, richMsgExItemVo, z, z2, str2, i, -1, null);
    }

    public static void n(Context context, String str, RichMsgExItemVo richMsgExItemVo, boolean z, boolean z2, String str2, int i, int i2, String str3) {
        o(context, str, richMsgExItemVo, z, z2, str2, i, i2, str3, -1);
    }

    public static void o(Context context, String str, RichMsgExItemVo richMsgExItemVo, boolean z, boolean z2, String str2, int i, int i2, String str3, int i3) {
        p(context, str, richMsgExItemVo, z, z2, str2, i, i2, str3, i3, null, false);
    }

    public static void p(Context context, String str, RichMsgExItemVo richMsgExItemVo, boolean z, boolean z2, String str2, int i, int i2, String str3, int i3, ChatItem chatItem, boolean z3) {
        int color;
        int color2;
        boolean z4 = richMsgExItemVo != null;
        String strB = z4 ? mu4.b(str, i(str2, chatItem)) : str;
        Intent intent = new Intent();
        if (z2) {
            intent.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, true);
        }
        if (chatItem != null) {
            intent.putExtra("back_jump_chatItem", chatItem);
        }
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", strB);
        bundle.putString("web_url_origin", str);
        bundle.putInt("from_source", i3);
        bundle.putBoolean("extra_key_from_ads", g.r(richMsgExItemVo));
        bundle.putString("extra_key_from_uid", str2);
        bundle.putBoolean("web_show_right_menu", z);
        bundle.putBoolean("extra_key_full_window", z3);
        bundle.putInt("BackgroundColor", -1);
        if (i != -1) {
            bundle.putInt("sourceType", i);
        }
        bundle.putInt("extra_key_biz_type", i2);
        bundle.putString("extra_key_mid", str3);
        if (richMsgExItemVo != null) {
            try {
                color = !TextUtils.isEmpty(richMsgExItemVo.topBarColor) ? Color.parseColor(richMsgExItemVo.topBarColor) : -1;
            } catch (Exception e) {
                e = e;
                color = -1;
            }
            try {
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
            color2 = !TextUtils.isEmpty(richMsgExItemVo.topBarTextColor) ? Color.parseColor(richMsgExItemVo.topBarTextColor) : -1;
        } else {
            color2 = -1;
            color = -1;
        }
        if (color != -1) {
            bundle.putInt("extra_key_top_bar_color", color);
        }
        if (color2 != -1) {
            bundle.putInt("extra_key_top_bar_text_color", color2);
        }
        if (z4) {
            intent.putExtra("android.intent.extra.SUBJECT", richMsgExItemVo.title);
            intent.putExtra("android.intent.extra.TEXT", richMsgExItemVo.digest);
            intent.putExtra("android.intent.extra.shortcut.ICON", richMsgExItemVo.cover);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
