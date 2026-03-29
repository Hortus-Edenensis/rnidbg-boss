package com.zenmen.palmchat.smallvideo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.NoticeBarExt;
import com.zenmen.palmchat.Vo.NoticeBarStyle;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a65;
import defpackage.az2;
import defpackage.il5;
import defpackage.k86;
import defpackage.rl0;
import defpackage.sy5;
import defpackage.ts0;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SmallVideoEntranceController {

    /* JADX INFO: compiled from: SearchBox */
    public enum EntranceEventType {
        EVENT_TAB_ONRESUME,
        EVENT_TAB_ONCONTACTCHANGED,
        EVENT_TAB_FLAG_FORGROUND_HEATBEAT,
        EVENT_SEC_TAB_ONCREATE,
        EVENT_PROTECT_MODE_CHANGE
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoticeBarStyle f15364a;

        public a(NoticeBarStyle noticeBarStyle) {
            this.f15364a = noticeBarStyle;
            put("pushid", noticeBarStyle.ext.pushId);
            put("source_actsite", noticeBarStyle.ext.sourceActSite);
            put("title", noticeBarStyle.title);
            put(MediaFormat.KEY_SUBTITLE, noticeBarStyle.digest);
            put("videoid", noticeBarStyle.ext.videoId);
            put(EventParams.KEY_PARAM_MEDIAID, noticeBarStyle.ext.mediaId);
            put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            put("unionid", noticeBarStyle.ext.unionId);
            put("scene_from", noticeBarStyle.ext.sceneFrom);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichMsgExItemVo f15365a;

        public b(RichMsgExItemVo richMsgExItemVo) {
            this.f15365a = richMsgExItemVo;
            RichMsgExItemVo.WinEx winEx = richMsgExItemVo.wineEx;
            if (winEx != null) {
                put("feed_id", winEx.wineFeedId);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {
        public static boolean a() {
            return false;
        }
    }

    public static void a(String str, EnterScene enterScene, String str2) {
        e(AppContext.getContext());
    }

    public static void b(String str, EnterScene enterScene, String str2) {
        e(AppContext.getContext());
    }

    public static String c(String str) {
        try {
            return !il5.l(str) ? str.substring(7) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static VideoTabConfig d() {
        VideoTabConfig videoTabConfig;
        if (AccountUtils.r(AppContext.getContext())) {
            DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.VIDEOTAB);
            if (dynamicConfig.isEnable()) {
                LogUtil.i("SVEController", "getVideoTabConfig extra=" + dynamicConfig.getExtra());
                videoTabConfig = (VideoTabConfig) dynamicConfig.parseExtra(VideoTabConfig.class);
            } else {
                videoTabConfig = null;
            }
        }
        LogUtil.i("SVEController", "getVideoTabConfig" + videoTabConfig);
        return videoTabConfig;
    }

    public static synchronized void e(Application application) {
        f(application, false);
    }

    public static boolean g(String str) {
        if (il5.l(str)) {
            return false;
        }
        return str.startsWith("tiktok-");
    }

    public static boolean h(RichMsgExItemVo richMsgExItemVo) {
        int i;
        if (richMsgExItemVo == null || richMsgExItemVo.showType != 11 || richMsgExItemVo.wineEx == null) {
            return richMsgExItemVo != null && richMsgExItemVo.showType == 0 && ((i = richMsgExItemVo.subType) == 1 || i == 2 || i == 3 || i == 4);
        }
        return true;
    }

    public static void i(Context context, String str, EnterScene enterScene, String str2) {
        e(AppContext.getContext());
        o();
    }

    public static void j(Context context, int i, String str, EnterScene enterScene, String str2) {
        k(context, i, str, "", "", enterScene, str2);
    }

    public static void k(Context context, int i, String str, String str2, String str3, EnterScene enterScene, String str4) {
        if (!g(str)) {
            e(AppContext.getContext());
            o();
            return;
        }
        if (!c.a()) {
            sy5.f(AppContext.getContext(), "视频丢失了，看看其他内容吧", 1).g();
            return;
        }
        Intent intent = new Intent();
        intent.setClass(AppContext.getContext(), MainTabsActivity.class);
        intent.putExtra("new_intent_need_show_videoTab", true);
        Bundle bundle = new Bundle();
        bundle.putString("extra_new_intent_dh_groupid", c(str));
        intent.putExtra("extra_new_intent_videotab_init_bundle", bundle);
        k86.X(intent);
        AppContext.getContext().startActivity(intent);
    }

    public static void l(Context context, String str, EnterScene enterScene, String str2) {
        j(context, 0, str, enterScene, str2);
    }

    public static void m(Context context, NoticeBarStyle noticeBarStyle) {
        if (noticeBarStyle == null || noticeBarStyle.url == null) {
            return;
        }
        String strC = null;
        if (noticeBarStyle.ext != null) {
            zn6.d("dou_push_cl", null, new JSONObject(new a(noticeBarStyle)).toString());
            strC = az2.c(noticeBarStyle.ext);
        }
        i(context, noticeBarStyle.url, EnterScene.PUSH, strC);
    }

    public static boolean n(Context context, ChatItem chatItem, MessageVo messageVo, RichMsgExItemVo richMsgExItemVo) {
        String strC;
        NoticeBarExt noticeBarExt;
        boolean zH = h(richMsgExItemVo);
        if (zH) {
            LogUtil.uploadInfoImmediate("M36_2", new b(richMsgExItemVo));
            NoticeBarStyle fromMsgExtension = NoticeBarStyle.parseFromMsgExtension(messageVo.extention);
            if (fromMsgExtension == null || (noticeBarExt = fromMsgExtension.ext) == null) {
                strC = null;
            } else {
                if (TextUtils.isEmpty(noticeBarExt.pushId)) {
                    fromMsgExtension.ext.pushId = fromMsgExtension.mid;
                }
                strC = az2.c(fromMsgExtension.ext);
            }
            int i = richMsgExItemVo.subType;
            if (i == 0) {
                j(context, i, richMsgExItemVo.wineEx.wineFeedId, a65.e(chatItem) ? EnterScene.LX_JUE : EnterScene.LX_CHAT, strC);
            } else if (i == 1) {
                j(context, i, richMsgExItemVo.wineEx.wid, a65.e(chatItem) ? EnterScene.LX_JUE : EnterScene.LX_CHAT, strC);
            } else if (i == 2) {
                j(context, i, richMsgExItemVo.wineEx.topicId, a65.e(chatItem) ? EnterScene.LX_JUE : EnterScene.LX_CHAT, strC);
            } else if (i == 3) {
                j(context, i, null, a65.e(chatItem) ? EnterScene.LX_JUE : EnterScene.LX_CHAT, strC);
            } else if (i == 4) {
                RichMsgExItemVo.WinEx winEx = richMsgExItemVo.wineEx;
                k(context, i, winEx.poiId, winEx.adCode, winEx.cityCode, a65.e(chatItem) ? EnterScene.LX_JUE : EnterScene.LX_CHAT, strC);
            }
        }
        return zH;
    }

    public static void o() {
        sy5.f(AppContext.getContext(), ts0.o().p(), 1).g();
    }

    public static void f(Application application, boolean z) {
    }
}
