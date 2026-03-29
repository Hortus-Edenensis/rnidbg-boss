package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.text.TextUtils;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.ss.android.ttvecamera.BuildConfig;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.utils.MD5Util;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class fo5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f17568a = 0;
    public static bo5 b = null;
    public static long c = 60000;
    public static long d = 60000;
    public static long e = 0;
    public static long f = 60000;
    public static LXBaseNetBean<SuperExposeInfo> g = null;
    public static String h = "on";
    public static String i;
    public static String j = "他正在{ href='zenxin://activity?page=a0521&scene=601&from=31'>超级曝光}中，享受10倍优先推荐。 我们发现你们的匹配度较高，特为你们牵线，不要错过缘分哦~".replace("{", "<a").replace("}", "</a>");
    public static String k = "他正在超级曝光中，享受10倍优先推荐";
    public static long l = 0;
    public static boolean m = false;

    public static boolean b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (AppContext.getContext().getSharedPreferences("super_expose_msg_tab_sp_name", 0).getInt(MD5Util.toMD5(str + str2), -1) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void c(io5 io5Var, boolean z, boolean z2) {
        int iD = d(io5Var);
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabManager SuperExposeMsgTabViewT SuperExpose7TaiJi checkMsgTabInfo showType " + iD);
        bo5 bo5Var = b;
        if (bo5Var != null) {
            bo5Var.b(iD, z, z2);
        }
    }

    public static int d(io5 io5Var) {
        if (io5Var == null) {
            return -1;
        }
        int iB = io5Var.b();
        int iA = io5Var.a();
        int iD = io5Var.d();
        String strC = io5Var.c();
        LogUtil.d("SuperExposeMsgTab", "checkMsgTabInfo SuperExpose7TaiJi mStatus " + iD + " mShowEntrance " + iB + " mExposeInfos " + iA + " mShowTai " + strC);
        if (WkAdxAdConfigMg.DSP_NAME_BAIDU.equals(strC)) {
            return 6;
        }
        if (WkAdxAdConfigMg.DSP_NAME_CSJ.equals(strC)) {
            return 7;
        }
        if (iA == 0 && iD == 0 && iB == 1) {
            return 1;
        }
        if (iA == 0 && iD == 1) {
            return 2;
        }
        if (iA == 1 && iD == 0 && iB == 1) {
            return 3;
        }
        if (iA == 1 && iD == 1) {
            return 4;
        }
        return (iA != 1 || iB == 1) ? -1 : 5;
    }

    public static void e() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SUPER_EXPOSE_MSG_TAB_CONFIG);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            m = false;
        } else {
            m = true;
            k(dynamicConfig.getExtra());
        }
    }

    public static void f(final String str, final ChatItem chatItem, Activity activity) {
        if (chatItem == null || TextUtils.isEmpty(str) || activity == null) {
            return;
        }
        LogUtil.d("", "insertMsgTabItem exposeStatus " + f17568a);
        if (f17568a != 1) {
            new g13(new Runnable() { // from class: eo5
                @Override // java.lang.Runnable
                public final void run() {
                    fo5.g(chatItem, str);
                }
            }).start();
        }
    }

    public static /* synthetic */ void g(ChatItem chatItem, String str) {
        try {
            LogUtil.d("SuperExposeMsgTab", "insertMsgTabItem start ");
            String str2 = j;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("actionTypes", "activity");
            jSONObject.put("actionBody", str2);
            String string = jSONObject.toString();
            ContentValues contentValues = new ContentValues();
            String strP = AccountUtils.p(AppContext.getContext());
            String strE = DomainHelper.e(chatItem);
            boolean zB = b(strP, strE);
            LogUtil.d("SuperExposeMsgTab", "insertMsgTabItem allowInsert " + zB);
            if (zB) {
                contentValues.put("src", strP);
                contentValues.put("dest", strE);
                contentValues.put("data1", (Integer) 1);
                contentValues.put("data2", string);
                contentValues.put("data3", (Integer) 12);
                contentValues.put("message", k);
                contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
                contentValues.put("msg_type", (Integer) 10000);
                contentValues.put("type", (Integer) 2);
                contentValues.put("packet_id", xn3.a());
                contentValues.put("contact_relate", DomainHelper.e(chatItem));
                contentValues.put("msg_extend", str);
                contentValues.put("read", (Integer) 1);
                contentValues.put("msg_status", (Integer) 2);
                contentValues.put("thread_biz_type", Integer.valueOf(chatItem.getBizType()));
                AppContext.getContext().getContentResolver().insert(DBUriManager.b(ho3.class, chatItem), contentValues);
                i(strP, strE);
                LogUtil.d("SuperExposeMsgTab", "insertMsgTabItem end ");
            }
        } catch (Exception e2) {
            LogUtil.d("SuperExposeMsgTab", "insertMsgTabItem error " + e2.toString());
        }
    }

    public static void h() {
        b = null;
    }

    public static void i(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        AppContext.getContext().getSharedPreferences("super_expose_msg_tab_sp_name", 0).edit().putInt(MD5Util.toMD5(str + str2), 1).apply();
    }

    public static void j(bo5 bo5Var) {
        b = bo5Var;
    }

    public static void k(String str) {
        ContactInfoItem contactInfoItemA;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            LogUtil.d("SuperExposeMsgTab", "updateConfig ext " + str);
            JSONObject jSONObject = new JSONObject(str);
            c = (long) (jSONObject.optInt("boost_msg_tab_pull_request_interval_male_V10", 60) * 1000);
            d = (long) (jSONObject.optInt("boost_msg_tab_purchase_request_interval_male_V10", 60) * 1000);
            String strE = v4.e(c.b());
            if (!TextUtils.isEmpty(strE) && (contactInfoItemA = dn0.a(strE)) != null && contactInfoItemA.getGender() == 1) {
                c = jSONObject.optInt("boost_msg_tab_pull_request_interval_female_V10", 60) * 1000;
                d = jSONObject.optInt("boost_msg_tab_purchase_request_interval_female_V10", 60) * 1000;
            }
            if (d == -1000) {
                d = -1L;
            }
            if (c == -1000) {
                c = -1L;
            }
            f = jSONObject.optInt("msgTab_animation_interval", 60) * 1000;
            h = jSONObject.optString("boost_msg_tab_request_cacheSwitch_V6", BuildConfig.USE_CLOUD_CONFIG);
            i = jSONObject.optString("boost_message_allPeopleEntrance_showuids");
            b05.d("读取boost_msg_tab_request_interval_V6 mRequestMsgTabUpdateTime =" + c);
            b05.d("读取boost_msg_tab_request mRequestMsgTabStatusTime =" + d);
            b05.d("读取boost_msg_tab_request_cacheSwitch_V6=" + h);
            b05.d(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("boost_systemMessage");
            if (jSONObjectOptJSONObject != null) {
                j = jSONObjectOptJSONObject.optString("text", "他正在{ href='zenxin://activity?page=a0521&scene=601&from=31'>超级曝光}中，享受10倍优先推荐。 我们发现你们的匹配度较高，特为你们牵线，不要错过缘分哦~").replace("{", "<a").replace("}", "</a>");
                k = jSONObjectOptJSONObject.optString("sysmsg_show", "他正在超级曝光中，享受10倍优先推荐");
            }
            zn5.f22460a = jSONObject.optInt("boost_square_tab_position", -1);
            zn5.b = jSONObject.optInt("boost_square_tab_request_interval", 1) * 60 * 1000;
        } catch (Exception unused) {
        }
    }
}
