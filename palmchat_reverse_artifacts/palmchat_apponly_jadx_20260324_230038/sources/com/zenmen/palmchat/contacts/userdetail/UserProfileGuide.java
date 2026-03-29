package com.zenmen.palmchat.contacts.userdetail;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.TransparentCordovaWebActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.userdetail.UserProfileGuide;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a65;
import defpackage.az2;
import defpackage.bo0;
import defpackage.g13;
import defpackage.ho3;
import defpackage.ir5;
import defpackage.k86;
import defpackage.nl0;
import defpackage.o30;
import defpackage.vs0;
import defpackage.xn3;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserProfileGuide {

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class CheckBean {
        public List<String> uidList = new ArrayList();
        public String yearMonthDay;
    }

    public static boolean b(String str) {
        CheckBean checkBean;
        long jC = c();
        if (jC <= 0) {
            return false;
        }
        String strD = d();
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, k86.a("key_insert_profile_guide_msg"), "");
        if (!TextUtils.isEmpty(strN) && (checkBean = (CheckBean) az2.a(strN, CheckBean.class)) != null) {
            String str2 = checkBean.yearMonthDay;
            List<String> list = checkBean.uidList;
            if (strD.equals(str2) && list != null) {
                HashSet hashSet = new HashSet(list);
                return !hashSet.contains(str) && ((long) hashSet.size()) < jC;
            }
        }
        return true;
    }

    public static long c() {
        return vs0.a().getConfig("profile_guide") != null ? r0.optInt("chat_timestamp_times", 3) : 3;
    }

    public static String d() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(5);
        int i2 = calendar.get(2) + 1;
        return calendar.get(1) + "_" + i2 + "_" + i;
    }

    public static long e() {
        return vs0.a().getConfig("newprofile_popinvite") != null ? r0.optInt(EventParams.KEY_PARAM_NUMBER, 5) : 5;
    }

    public static long f() {
        JSONObject config = vs0.a().getConfig("newprofile_popinvite");
        return ((long) ((config != null ? config.optInt("hour", 24) : 24) * 60 * 60)) * 1000;
    }

    public static String g() {
        String str = nl0.q + "/popup/#/popularity";
        JSONObject config = vs0.a().getConfig("newprofile_popinvite");
        return config != null ? config.optString("url", str) : str;
    }

    public static void h(final String str, final ChatItem chatItem, final Activity activity) {
        if (TextUtils.isEmpty(str) || chatItem == null || activity == null) {
            return;
        }
        new g13(new Runnable() { // from class: x66
            @Override // java.lang.Runnable
            public final void run() {
                UserProfileGuide.j(chatItem, str, activity);
            }
        }).start();
    }

    public static boolean i(int i) {
        String str;
        JSONObject config;
        if (i == 2) {
            str = "find_tab";
        } else if (i == 3) {
            str = "friend_screen";
        } else if (i == 7) {
            str = "friend_broadcast";
        } else if (i == 18) {
            str = "chat_window";
        } else if (i == 15) {
            str = "myfriend";
        } else if (i != 16) {
            switch (i) {
                case 11:
                    str = "friend_cycle";
                    break;
                case 12:
                    str = "chat_timestamp";
                    break;
                case 13:
                    str = "halfchat_window";
                    break;
                default:
                    str = null;
                    break;
            }
        } else {
            str = IMediaFormat.KEY_PROFILE;
        }
        if (TextUtils.isEmpty(str) || (config = vs0.a().getConfig("profile_guide")) == null) {
            return false;
        }
        return config.optBoolean(str, false);
    }

    public static /* synthetic */ void j(ChatItem chatItem, String str, Activity activity) {
        try {
            if (chatItem.getChatType() != 0) {
                LogUtil.d("insertProfileGuideMessage", "不是单聊");
                return;
            }
            if (!i(12)) {
                LogUtil.d("insertProfileGuideMessage", "配置关闭");
                return;
            }
            ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
            if (contactInfoItemL != null && contactInfoItemL.needCompleteProfile()) {
                if (a65.f(str)) {
                    LogUtil.d("insertProfileGuideMessage", "服务号不插入消息");
                    return;
                }
                if (!b(str)) {
                    LogUtil.d("insertProfileGuideMessage", "达到最大次数或者已插入消息");
                    return;
                }
                if (o30.q(str)) {
                    LogUtil.d("insertProfileGuideMessage", "最佳聊友不允许出现完善资料");
                    return;
                }
                Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.b(ho3.class, chatItem), null, "contact_relate=? and type=?", new String[]{DomainHelper.a(chatItem, false), String.valueOf(1)}, null);
                if (cursorQuery != null && cursorQuery.getCount() != 0) {
                    cursorQuery.close();
                    String string = activity.getString(R.string.user_profile_guide_msg);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("actionTypes", "activity");
                    jSONObject.put("actionBody", string);
                    String string2 = jSONObject.toString();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("src", AccountUtils.p(AppContext.getContext()));
                    contentValues.put("dest", DomainHelper.e(chatItem));
                    contentValues.put("data1", (Integer) 1);
                    contentValues.put("data2", string2);
                    contentValues.put("message", "寻找更多共同话题？填写资料让Ta更了解你");
                    contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
                    contentValues.put("msg_type", (Integer) 10000);
                    contentValues.put("type", (Integer) 2);
                    contentValues.put("packet_id", xn3.a());
                    contentValues.put("contact_relate", DomainHelper.e(chatItem));
                    contentValues.put("msg_extend", str);
                    contentValues.put("read", (Integer) 1);
                    contentValues.put("msg_status", (Integer) 2);
                    AppContext.getContext().getContentResolver().insert(DBUriManager.b(ho3.class, chatItem), contentValues);
                    l(str);
                    return;
                }
                LogUtil.d("insertProfileGuideMessage", "没有回复消息");
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            }
            LogUtil.d("insertProfileGuideMessage", "资料已完善");
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.d("insertProfileGuideMessage", e.getMessage());
        }
    }

    public static void k(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        try {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
            long jI = sPUtil.i(scene, k86.a("key_profile_guide_time_new"), 0L);
            if (System.currentTimeMillis() - jI < f()) {
                LogUtil.d("loguser", "tryShowDialog: return, time = " + jI);
                return;
            }
            int iF = sPUtil.f(scene, k86.a("key_profile_guide_count_new"), 0);
            if (iF >= e()) {
                LogUtil.d("loguser", "tryShowDialog: return, count = " + iF);
                return;
            }
            if (i(i)) {
                ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
                if (contactInfoItemL == null) {
                    return;
                }
                if (!contactInfoItemL.needCompleteProfile()) {
                    LogUtil.d("loguser", "tryShowDialog: return, profile completed");
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(activity, TransparentCordovaWebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("web_url", g() + "?from=" + i);
                bundle.putBoolean("extra_key_full_window", true);
                bundle.putBoolean("hide_progressbar", true);
                bundle.putBoolean("extra_key_sync_profile", true);
                intent.putExtras(bundle);
                activity.startActivity(intent);
                sPUtil.t(scene, k86.a("key_profile_guide_time_new"), Long.valueOf(System.currentTimeMillis()));
                sPUtil.t(scene, k86.a("key_profile_guide_count_new"), Integer.valueOf(iF + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void l(String str) {
        CheckBean checkBean;
        List<String> list;
        String strD = d();
        ArrayList arrayList = new ArrayList();
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        String strN = sPUtil.n(scene, k86.a("key_insert_profile_guide_msg"), "");
        if (!TextUtils.isEmpty(strN) && (checkBean = (CheckBean) az2.a(strN, CheckBean.class)) != null && strD.equals(checkBean.yearMonthDay) && (list = checkBean.uidList) != null && list.size() > 0) {
            arrayList.addAll(checkBean.uidList);
        }
        CheckBean checkBean2 = new CheckBean();
        arrayList.add(str);
        checkBean2.yearMonthDay = strD;
        checkBean2.uidList = arrayList;
        sPUtil.t(scene, k86.a("key_insert_profile_guide_msg"), az2.c(checkBean2));
    }
}
