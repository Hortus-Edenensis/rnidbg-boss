package com.zenmen.palmchat.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.NoticeBarExt;
import com.zenmen.palmchat.Vo.NoticeBarStyle;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.NewContactActivity;
import com.zenmen.palmchat.smallvideo.EnterScene;
import com.zenmen.palmchat.smallvideo.SmallVideoEntranceController;
import com.zenmen.palmchat.smallvideo.VideoSDKPushReceiver;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.af6;
import defpackage.az2;
import defpackage.b65;
import defpackage.fk2;
import defpackage.gi5;
import defpackage.h05;
import defpackage.k86;
import defpackage.m66;
import defpackage.n5;
import defpackage.on0;
import defpackage.rn0;
import defpackage.vt0;
import defpackage.xg5;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class NotificationClickReceiver extends BroadcastReceiver {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichMsgExItemVo.WinEx f15711a;
        public final /* synthetic */ NoticeBarStyle b;

        public a(RichMsgExItemVo.WinEx winEx, NoticeBarStyle noticeBarStyle) {
            NoticeBarExt noticeBarExt;
            this.f15711a = winEx;
            this.b = noticeBarStyle;
            put("wid", winEx.wid);
            put("wineFeedId", winEx.wineFeedId);
            if (noticeBarStyle != null) {
                put("mid", noticeBarStyle.mid);
            }
            if (noticeBarStyle == null || (noticeBarExt = noticeBarStyle.ext) == null) {
                return;
            }
            put("scene_from", noticeBarExt.sceneFrom);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15712a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ContactInfoItem d;

        public b(String str, String str2, int i, ContactInfoItem contactInfoItem) {
            this.f15712a = str;
            this.b = str2;
            this.c = i;
            this.d = contactInfoItem;
            put("from", "friend");
            put("mid", str);
            put("type", str2);
            put("sourceType", Integer.valueOf(i));
            if (contactInfoItem != null) {
                put("fromUid", contactInfoItem.getUid());
            }
        }
    }

    public final void a(String str, String str2, ContactInfoItem contactInfoItem, int i) {
        b bVar = new b(str, str2, i, contactInfoItem);
        LogUtil.uploadInfoImmediate("msg_cli", bVar);
        vt0.d().j(3, bVar);
    }

    public final void b(Context context, Intent intent) {
        String action;
        Intent intentB;
        String strC;
        NoticeBarExt noticeBarExt;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("extra_mid");
        ContactInfoItem contactInfoItem = (ContactInfoItem) intent.getParcelableExtra("user_item_info");
        int intExtra = intent.getIntExtra("extra_sourcetype", 0);
        if (action.equals("extra_action_add_contact")) {
            boolean booleanExtra = intent.getBooleanExtra("isAccept", false);
            String stringExtra2 = intent.getStringExtra("from_uid");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", booleanExtra ? 1 : 2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("rep2", null, null, jSONObject.toString());
            if (!TextUtils.isEmpty(stringExtra2)) {
                rn0.r(stringExtra2);
            }
            com.zenmen.palmchat.utils.a.E().t(0);
            return;
        }
        if (action.equals("extra_action_jump_smallvideo")) {
            RichMsgExItemVo.WinEx winEx = (RichMsgExItemVo.WinEx) intent.getParcelableExtra("extra_winex");
            if (af6.c()) {
                b65.c();
                return;
            }
            if (winEx != null) {
                NoticeBarStyle fromMsgExtension = NoticeBarStyle.parseFromMsgExtension(intent.getStringExtra("extra_extension"));
                if (fromMsgExtension == null || (noticeBarExt = fromMsgExtension.ext) == null) {
                    strC = null;
                } else {
                    if (TextUtils.isEmpty(noticeBarExt.pushId)) {
                        fromMsgExtension.ext.pushId = fromMsgExtension.mid;
                    }
                    strC = az2.c(fromMsgExtension.ext);
                }
                a aVar = new a(winEx, fromMsgExtension);
                LogUtil.uploadInfoImmediate("msj-cli-sp", aVar);
                vt0.d().k(3, new JSONObject(aVar));
                SmallVideoEntranceController.l(AppContext.getContext(), winEx.wineFeedId, EnterScene.PUSH, strC);
                return;
            }
            return;
        }
        if (action.equals("extra_action_jump_smallvideo_msg_push")) {
            String stringExtra3 = intent.getStringExtra("extra_extension");
            LogUtil.i(VideoSDKPushReceiver.TAG, "EXTRA_ACTION_JUMP_SMALLVIDEO_MSG_PUSH ext=" + stringExtra3);
            NoticeBarStyle fromMsgExtension2 = NoticeBarStyle.parseFromMsgExtension(stringExtra3);
            if (af6.c()) {
                b65.c();
                return;
            } else {
                if (fromMsgExtension2 == null || TextUtils.isEmpty(fromMsgExtension2.url)) {
                    return;
                }
                SmallVideoEntranceController.m(AppContext.getContext(), fromMsgExtension2);
                return;
            }
        }
        if (action.equals("extra_action_add_contact_click")) {
            a(stringExtra, "tzl", contactInfoItem, intExtra);
            new Intent();
            if (contactInfoItem.getRequestType() >= 100) {
                intentB = on0.a("");
                intentB.putExtra("SOURCE_TYPE", intExtra);
            } else {
                intentB = NewContactActivity.h.b(AppContext.getContext());
            }
            intentB.addFlags(335544320);
            context.startActivity(intentB);
            return;
        }
        if (action.equals("extra_action_add_contact_action")) {
            String stringExtra4 = intent.getStringExtra("rid");
            boolean booleanExtra2 = intent.getBooleanExtra("isSenderReceiveReply", false);
            Intent intent2 = new Intent(AppContext.getContext(), (Class<?>) m66.c());
            intent2.putExtra("user_item_info", contactInfoItem);
            intent2.putExtra("from", 7);
            intent2.putExtra("rid", stringExtra4);
            intent2.putExtra("isAccept", !booleanExtra2);
            intent2.putExtra("launch_from_notification", true);
            k86.X(intent2);
            context.startActivity(intent2);
            if (booleanExtra2) {
                a(stringExtra, OapsKey.KEY_CK, contactInfoItem, intExtra);
                return;
            } else {
                a(stringExtra, "js", contactInfoItem, intExtra);
                return;
            }
        }
        if (action.equals("extra_action_add_contact_ignore")) {
            a(stringExtra, "hl", contactInfoItem, intExtra);
            boolean booleanExtra3 = intent.getBooleanExtra("isAccept", false);
            String stringExtra5 = intent.getStringExtra("from_uid");
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", booleanExtra3 ? 1 : 2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("rep2", null, null, jSONObject2.toString());
            if (!TextUtils.isEmpty(stringExtra5)) {
                rn0.r(stringExtra5);
            }
            com.zenmen.palmchat.utils.a.E().t(0);
            return;
        }
        if (!action.equals("extra_action_jump_moments")) {
            if (action.equals("cancel_special_attention")) {
                zn6.b("noticebar_permanent_close");
                xg5.e().s(true);
                return;
            }
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            String stringExtra6 = intent.getStringExtra("moment_from_mid");
            if (!TextUtils.isEmpty(stringExtra6)) {
                jSONObject3.put("mid", stringExtra6);
            }
            String stringExtra7 = intent.getStringExtra("moment_from_uid");
            if (!TextUtils.isEmpty(stringExtra7)) {
                jSONObject3.put("fromuid", stringExtra7);
            }
            if (h05.c(stringExtra7)) {
                jSONObject3.put("type", "H-feedpush");
            }
            int intExtra2 = intent.getIntExtra("notice_type", -1);
            if (intExtra2 == 0) {
                jSONObject3.put("type", 113);
            } else if (intExtra2 == 1) {
                jSONObject3.put("type", 114);
            }
            int intExtra3 = intent.getIntExtra("comment_type", -1);
            if (intExtra3 == 11) {
                jSONObject3.put("action", 111);
            } else if (intExtra3 == 12) {
                jSONObject3.put("action", 112);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("msg_cli", "1", null, jSONObject3.toString());
        vt0.d().i(3, jSONObject3.toString());
        if (gi5.t("momentsTitle")) {
            fk2.a aVar2 = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_square");
            bundle.putString("square_tab", "momentsTitle");
            aVar2.b(bundle);
            context.startActivity(n5.b(AppContext.getContext(), aVar2));
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            b(context, intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
