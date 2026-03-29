package com.zenmen.palmchat.chat.gift;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.TransparentCordovaWebActivity;
import com.zenmen.palmchat.chat.ChatGiftConfig;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.giftkit.chat.ChatGiftMessageExtensionBean;
import com.zenmen.palmchat.giftkit.chat.GiftMessageExtensionBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.paidservices.readstate.guide.GuideConfig;
import com.zenmen.palmchat.paidservices.readstate.guide.ReadStateGuideManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a65;
import defpackage.az2;
import defpackage.b05;
import defpackage.bo0;
import defpackage.ds0;
import defpackage.dx5;
import defpackage.ea2;
import defpackage.fa2;
import defpackage.fu5;
import defpackage.g13;
import defpackage.hx3;
import defpackage.k86;
import defpackage.me1;
import defpackage.o30;
import defpackage.p05;
import defpackage.ry5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.ts0;
import defpackage.u0;
import defpackage.u93;
import defpackage.v8;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zh;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GiftMessageHelper {

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class CheckBean {
        public int amuletGuideCount;
        public int lastGuideType;
        public int readStateGuideCount;
        public List<String> uidList = new ArrayList();
        public String yearMonthDay;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputFragment f12857a;
        public final /* synthetic */ ChatItem b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.gift.GiftMessageHelper$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0994a extends MaterialDialog.e {
            public C0994a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public a(InputFragment inputFragment, ChatItem chatItem, int i, int i2) {
            this.f12857a = inputFragment;
            this.b = chatItem;
            this.c = i;
            this.d = i2;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            this.f12857a.G();
            LogUtil.i("sendGiftMessage", "onFail: " + exc.getMessage());
            sy5.f(this.f12857a.getActivity(), "礼物发送失败，请稍后重试", 0).g();
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            this.f12857a.G();
            if (jSONObject != null) {
                try {
                    LogUtil.i("sendGiftMessage", "onSuccess: " + jSONObject);
                    int iOptInt = jSONObject.optInt("resultCode", -1);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                    String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                    if (iOptInt != 0 || jSONObjectOptJSONObject == null) {
                        if (1003 == iOptInt) {
                            fa2 fa2Var = new fa2(1);
                            fa2Var.d = 11;
                            ds0.a().b(fa2Var);
                            return;
                        } else if (TextUtils.isEmpty(strOptString)) {
                            ry5.a("礼物发送失败，请稍后重试");
                            return;
                        } else {
                            new sd3(this.f12857a.getActivity()).k(strOptString).n(GravityEnum.CENTER).O(R.string.alert_dialog_i_knoW).f(new C0994a()).e().show();
                            return;
                        }
                    }
                    GiftMessageHelper.A0(this.f12857a.getActivity());
                    if (jSONObjectOptJSONObject.has("giftId") && jSONObjectOptJSONObject.has("balance")) {
                        ds0.a().b(new fa2(3, jSONObjectOptJSONObject.getInt("giftId"), jSONObjectOptJSONObject.getInt("balance")));
                    }
                    if (jSONObjectOptJSONObject.has("giftMsg")) {
                        GiftMessageHelper.X(jSONObjectOptJSONObject.getString("giftMsg"), this.b);
                    }
                    GiftMessageHelper.x0(this.b, this.c, this.d);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f12859a;
        public final /* synthetic */ PopupWindow b;

        public b(Activity activity, PopupWindow popupWindow) {
            this.f12859a = activity;
            this.b = popupWindow;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow;
            Activity activity = this.f12859a;
            if (activity == null || activity.isFinishing() || this.f12859a.isDestroyed() || (popupWindow = this.b) == null || !popupWindow.isShowing()) {
                return;
            }
            this.b.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12860a;
        public final /* synthetic */ String b;

        public c(String str, String str2) {
            this.f12860a = str;
            this.b = str2;
            put("roomid", 301);
            put("roomid", str + str2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f12861a;
        public final /* synthetic */ int b;

        public d(ChatItem chatItem, int i) {
            this.f12861a = chatItem;
            this.b = i;
        }

        public static /* synthetic */ void b(ChatItem chatItem, int i) {
            GuideConfig.FirstMsg firstMsg;
            MessageVo messageVoG = u0.g(chatItem);
            messageVoG.status = 2;
            if (i == 0) {
                messageVoG.mimeType = 20000;
                ChatGiftGuideCard chatGiftGuideCardF = GiftMessageHelper.F();
                messageVoG.text = chatGiftGuideCardF.getTitleForShow();
                if (chatGiftGuideCardF.isNewStyle) {
                    ChatGiftConfig.GiftTextItem giftTextItemByTime = ChatGiftConfig.getGiftTextItemByTime(bo0.r().l(chatItem.getChatId()) != null ? !r2.getIsStranger() : false);
                    chatGiftGuideCardF.giftName = giftTextItemByTime.giftname;
                    chatGiftGuideCardF.giftPrice = giftTextItemByTime.giftprice;
                    chatGiftGuideCardF.giftId = giftTextItemByTime.giftID;
                    chatGiftGuideCardF.giftIcon = giftTextItemByTime.gifticon;
                    String str = giftTextItemByTime.subtitle;
                    chatGiftGuideCardF.subtitle = str;
                    messageVoG.text = str;
                }
                messageVoG.extention = az2.c(chatGiftGuideCardF);
            } else if (i == 2) {
                messageVoG.mimeType = 12346;
                GuideConfig guideConfigD = ReadStateGuideManager.e().d();
                messageVoG.text = (guideConfigD == null || (firstMsg = guideConfigD.firstMsg) == null) ? "查看消息是否已读" : firstMsg.text;
                messageVoG.data2 = ReadStateGuideManager.Scene.TYPE_FIRSTMSG.value;
            } else {
                ChatAmuletGuideCard chatAmuletGuideCardE = GiftMessageHelper.E(!(chatItem instanceof ContactInfoItem) || ((ContactInfoItem) chatItem).getGender() == 0);
                if (chatAmuletGuideCardE == null) {
                    messageVoG.mimeType = 20000;
                    ChatGiftGuideCard chatGiftGuideCardF2 = GiftMessageHelper.F();
                    messageVoG.text = chatGiftGuideCardF2.getTitleForShow();
                    if (chatGiftGuideCardF2.isNewStyle) {
                        ChatGiftConfig.GiftTextItem giftTextItemByTime2 = ChatGiftConfig.getGiftTextItemByTime(bo0.r().l(chatItem.getChatId()) != null ? !r2.getIsStranger() : false);
                        chatGiftGuideCardF2.giftName = giftTextItemByTime2.giftname;
                        chatGiftGuideCardF2.giftPrice = giftTextItemByTime2.giftprice;
                        chatGiftGuideCardF2.giftId = giftTextItemByTime2.giftID;
                        chatGiftGuideCardF2.giftIcon = giftTextItemByTime2.gifticon;
                        String str2 = giftTextItemByTime2.subtitle;
                        chatGiftGuideCardF2.subtitle = str2;
                        messageVoG.text = str2;
                    }
                    messageVoG.extention = az2.c(chatGiftGuideCardF2);
                } else {
                    messageVoG.mimeType = 20004;
                    messageVoG.text = chatAmuletGuideCardE.getTitleForShow();
                    messageVoG.extention = az2.c(chatAmuletGuideCardE);
                }
            }
            messageVoG.data1 = "0";
            com.zenmen.palmchat.database.b.t(messageVoG);
            GiftMessageHelper.D0(chatItem.getChatId(), i);
        }

        @Override // java.lang.Runnable
        public void run() {
            final ChatItem chatItem = this.f12861a;
            final int i = this.b;
            new g13(new Runnable() { // from class: eb2
                @Override // java.lang.Runnable
                public final void run() {
                    GiftMessageHelper.d.b(chatItem, i);
                }
            }).start();
        }
    }

    public static void A0(FragmentActivity fragmentActivity) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        if (!TextUtils.isEmpty(sPUtil.n(scene, k86.a("key_show_first_send_gift_message_dialog"), "")) || fragmentActivity == null) {
            return;
        }
        try {
            FirstSendGiftMessageSuccessDialog.D().show(fragmentActivity.getSupportFragmentManager(), FirstSendGiftMessageSuccessDialog.class.getSimpleName());
            sPUtil.t(scene, k86.a("key_show_first_send_gift_message_dialog"), "1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Pair<Boolean, Integer> B(String str) {
        CheckBean checkBean;
        long jL = L();
        boolean z = false;
        if (jL == 0) {
            return new Pair<>(Boolean.FALSE, 0);
        }
        String strK = K();
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, k86.a("key_buy_vip_gift_check"), "");
        if (!TextUtils.isEmpty(strN) && (checkBean = (CheckBean) az2.a(strN, CheckBean.class)) != null) {
            String str2 = checkBean.yearMonthDay;
            List<String> list = checkBean.uidList;
            if (strK.equals(str2) && list != null) {
                HashSet hashSet = new HashSet(list);
                int i = 1;
                boolean z2 = !hashSet.contains(str) && ((long) hashSet.size()) < jL;
                if (!z2) {
                    return new Pair<>(Boolean.FALSE, 0);
                }
                if (checkBean.lastGuideType != 0) {
                    z = z2;
                    i = 0;
                } else {
                    if (!ReadStateGuideManager.e().h()) {
                        if (checkBean.amuletGuideCount < D()) {
                            z = z2;
                        }
                        z = z2;
                    } else if (ReadStateGuideManager.e().i(str)) {
                        if (checkBean.readStateGuideCount < O()) {
                            ReadStateGuideManager.e().j(str);
                            z = z2;
                            i = 2;
                        }
                        z = z2;
                    }
                    i = 0;
                }
                return new Pair<>(Boolean.valueOf(z), Integer.valueOf(i));
            }
        }
        return new Pair<>(Boolean.TRUE, 0);
    }

    public static void B0(Activity activity, View view, String str, String str2) {
        if (!C(str) || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.layout_popup_gift_guide, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_tip)).setText(J());
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(false);
        popupWindow.showAsDropDown(view, 20, -me1.b(activity, 116));
        popupWindow.update();
        E0(str);
        view.postDelayed(new b(activity, popupWindow), 3500L);
        zn6.j("gift_bubble", "view", new c(str, str2));
    }

    public static boolean C(String str) {
        CheckBean checkBean;
        long jI = I();
        if (jI == 0) {
            return false;
        }
        String strK = K();
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, k86.a("key_chat_gift_pop_window_guide_check"), "");
        if (!TextUtils.isEmpty(strN) && (checkBean = (CheckBean) az2.a(strN, CheckBean.class)) != null) {
            String str2 = checkBean.yearMonthDay;
            List<String> list = checkBean.uidList;
            if (strK.equals(str2) && list != null) {
                HashSet hashSet = new HashSet(list);
                return !hashSet.contains(str) && ((long) hashSet.size()) < jI;
            }
        }
        return true;
    }

    public static void C0() {
        String[] strArr = {String.valueOf(1), String.valueOf(System.currentTimeMillis() - R())};
        ContentValues contentValues = new ContentValues();
        contentValues.put("pin_gift_message", (Integer) 0);
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, dx5.f17178a, contentValues, "pin_gift_message=? and pin_gift_message_last_time_stamp>0 and pin_gift_message_last_time_stamp<?", strArr);
    }

    public static int D() {
        try {
            JSONObject jSONObjectF = ts0.o().f();
            if (jSONObjectF == null) {
                return 0;
            }
            int i = jSONObjectF.getInt("gift_num_amuletshow");
            if (i >= 0) {
                return i;
            }
            return 0;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void D0(String str, int i) {
        int i2;
        int i3;
        CheckBean checkBean;
        List<String> list;
        String strK = K();
        ArrayList arrayList = new ArrayList();
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        String strN = sPUtil.n(scene, k86.a("key_buy_vip_gift_check"), "");
        if (TextUtils.isEmpty(strN) || (checkBean = (CheckBean) az2.a(strN, CheckBean.class)) == null || !strK.equals(checkBean.yearMonthDay) || (list = checkBean.uidList) == null || list.size() <= 0) {
            i2 = 0;
            i3 = 0;
        } else {
            arrayList.addAll(checkBean.uidList);
            i2 = checkBean.amuletGuideCount;
            i3 = checkBean.readStateGuideCount;
        }
        CheckBean checkBean2 = new CheckBean();
        arrayList.add(str);
        checkBean2.yearMonthDay = strK;
        checkBean2.uidList = arrayList;
        checkBean2.lastGuideType = i;
        if (i == 1) {
            i2++;
        }
        checkBean2.amuletGuideCount = i2;
        if (i == 2) {
            i3++;
        }
        checkBean2.readStateGuideCount = i3;
        sPUtil.t(scene, k86.a("key_buy_vip_gift_check"), az2.c(checkBean2));
    }

    public static ChatAmuletGuideCard E(boolean z) {
        ChatAmuletGuideCard chatAmuletGuideCard = null;
        try {
            JSONObject jSONObjectF = ts0.o().f();
            if (jSONObjectF != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectF.optJSONArray(z ? "amulet_cards_male" : "amulet_cards_female");
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(new Random().nextInt(jSONArrayOptJSONArray.length()));
                if (jSONObject != null) {
                    ChatAmuletGuideCard chatAmuletGuideCard2 = (ChatAmuletGuideCard) az2.a(jSONObject.toString(), ChatAmuletGuideCard.class);
                    if (chatAmuletGuideCard2 != null) {
                        chatAmuletGuideCard = chatAmuletGuideCard2;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.i("GiftMessageHelper", "getChatAmuletGuideCard" + az2.c(chatAmuletGuideCard));
        return chatAmuletGuideCard;
    }

    public static void E0(String str) {
        CheckBean checkBean;
        List<String> list;
        String strK = K();
        ArrayList arrayList = new ArrayList();
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        String strN = sPUtil.n(scene, k86.a("key_chat_gift_pop_window_guide_check"), "");
        if (!TextUtils.isEmpty(strN) && (checkBean = (CheckBean) az2.a(strN, CheckBean.class)) != null && strK.equals(checkBean.yearMonthDay) && (list = checkBean.uidList) != null && list.size() > 0) {
            arrayList.addAll(checkBean.uidList);
        }
        CheckBean checkBean2 = new CheckBean();
        arrayList.add(str);
        checkBean2.yearMonthDay = strK;
        checkBean2.uidList = arrayList;
        sPUtil.t(scene, k86.a("key_chat_gift_pop_window_guide_check"), az2.c(checkBean2));
    }

    public static ChatGiftGuideCard F() {
        ChatGiftGuideCard chatGiftGuideCard = new ChatGiftGuideCard();
        try {
            JSONObject jSONObjectF = ts0.o().f();
            if (jSONObjectF != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectF.optJSONArray("gift_cards");
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(new Random().nextInt(jSONArrayOptJSONArray.length()));
                if (jSONObject != null) {
                    ChatGiftGuideCard chatGiftGuideCard2 = (ChatGiftGuideCard) az2.a(jSONObject.toString(), ChatGiftGuideCard.class);
                    if (chatGiftGuideCard2 != null) {
                        chatGiftGuideCard = chatGiftGuideCard2;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        chatGiftGuideCard.isNewStyle = com.zenmen.palmchat.giftkit.a.a().c();
        return chatGiftGuideCard;
    }

    public static ChatGiftGuideCard G() {
        ChatGiftGuideCard chatGiftGuideCardF = F();
        chatGiftGuideCardF.guideType = 2;
        return chatGiftGuideCardF;
    }

    public static ChatGiftGuideCard H(int i) {
        ChatGiftGuideCard chatGiftGuideCardF = F();
        chatGiftGuideCardF.guideType = 1;
        chatGiftGuideCardF.applySource = i;
        return chatGiftGuideCardF;
    }

    public static long I() {
        try {
            JSONObject jSONObjectF = ts0.o().f();
            if (jSONObjectF == null) {
                return 3L;
            }
            int i = jSONObjectF.getInt("guide_num");
            if (i >= 0) {
                return i;
            }
            return 3L;
        } catch (JSONException e) {
            e.printStackTrace();
            return 3L;
        }
    }

    public static String J() {
        try {
            JSONObject jSONObjectF = ts0.o().f();
            if (jSONObjectF == null) {
                return "回复率涨3倍";
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectF.optJSONArray("gift_bubbles");
            String string = jSONArrayOptJSONArray.getString(new Random().nextInt(jSONArrayOptJSONArray.length()));
            return !TextUtils.isEmpty(string) ? string : "回复率涨3倍";
        } catch (Exception e) {
            e.printStackTrace();
            return "回复率涨3倍";
        }
    }

    public static String K() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(5);
        int i2 = calendar.get(2) + 1;
        return calendar.get(1) + "_" + i2 + "_" + i;
    }

    public static long L() {
        try {
            JSONObject jSONObjectF = ts0.o().f();
            if (jSONObjectF == null) {
                return 3L;
            }
            int i = jSONObjectF.getInt("gift_num");
            if (i >= 0) {
                return i;
            }
            return 3L;
        } catch (JSONException e) {
            e.printStackTrace();
            return 3L;
        }
    }

    public static String M() {
        try {
            JSONObject jSONObjectF = ts0.o().F();
            if (jSONObjectF == null) {
                return "每天5个礼物，消息置顶24小时";
            }
            String string = jSONObjectF.getString("gift_info");
            return !TextUtils.isEmpty(string) ? string : "每天5个礼物，消息置顶24小时";
        } catch (JSONException e) {
            e.printStackTrace();
            return "每天5个礼物，消息置顶24小时";
        }
    }

    public static GiftMessageExtensionBean N(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strOptString = new JSONObject(str).optString("giftMsg", "");
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject = new JSONObject(strOptString);
                String strOptString2 = jSONObject.optString("fromUser", "");
                String strOptString3 = jSONObject.optString("toUser", "");
                if (z) {
                    if (!TextUtils.isEmpty(strOptString2)) {
                        return (GiftMessageExtensionBean) az2.a(strOptString2, GiftMessageExtensionBean.class);
                    }
                } else if (!TextUtils.isEmpty(strOptString3)) {
                    return (GiftMessageExtensionBean) az2.a(strOptString3, GiftMessageExtensionBean.class);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int O() {
        try {
            JSONObject jSONObjectF = ts0.o().f();
            if (jSONObjectF != null) {
                return jSONObjectF.optInt("guide_num_msgStatus", 4);
            }
            return 4;
        } catch (Exception e) {
            e.printStackTrace();
            return 4;
        }
    }

    public static ChatAmuletMessageExtensionBean P(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strOptString = new JSONObject(str).optString("ornamentMsg", "");
            if (!TextUtils.isEmpty(strOptString)) {
                return (ChatAmuletMessageExtensionBean) az2.a(strOptString, ChatAmuletMessageExtensionBean.class);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ChatGiftMessageExtensionBean Q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strOptString = new JSONObject(str).optString("giftMsg", "");
            if (!TextUtils.isEmpty(strOptString)) {
                return (ChatGiftMessageExtensionBean) az2.a(strOptString, ChatGiftMessageExtensionBean.class);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long R() {
        long j = 24;
        try {
            JSONObject jSONObjectF = ts0.o().F();
            if (jSONObjectF != null) {
                int i = jSONObjectF.getInt("top_limit");
                if (i > 0) {
                    j = i;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return j * 1000 * 60 * 60;
    }

    public static void S(final ChatItem chatItem) {
        b05.c(new b05.a() { // from class: cb2
            @Override // b05.a
            public final Object getValue() {
                return GiftMessageHelper.Z();
            }
        });
        if (!com.zenmen.palmchat.giftkit.a.a().c()) {
            b05.c(new b05.a() { // from class: db2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.a0();
                }
            });
            return;
        }
        if (chatItem == null || chatItem.getChatId() == null) {
            b05.c(new b05.a() { // from class: ha2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.b0();
                }
            });
            return;
        }
        if (chatItem.getChatType() != 0) {
            b05.c(new b05.a() { // from class: ia2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.c0();
                }
            });
            return;
        }
        if (a65.c(chatItem)) {
            b05.c(new b05.a() { // from class: ja2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.d0();
                }
            });
            return;
        }
        if (v8.C(chatItem.getChatId())) {
            b05.c(new b05.a() { // from class: ka2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.e0();
                }
            });
            return;
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
        if (contactInfoItemL == null || contactInfoItemL.getGender() != 0) {
            b05.c(new b05.a() { // from class: la2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.f0();
                }
            });
        } else {
            b05.c(new b05.a() { // from class: ma2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.g0(chatItem);
                }
            });
            new g13(new Runnable() { // from class: na2
                @Override // java.lang.Runnable
                public final void run() {
                    GiftMessageHelper.j0(chatItem);
                }
            }).start();
        }
    }

    public static void T(final ChatItem chatItem, final int i) {
        b05.c(new b05.a() { // from class: ga2
            @Override // b05.a
            public final Object getValue() {
                return GiftMessageHelper.m0(i);
            }
        });
        if (!com.zenmen.palmchat.giftkit.a.a().c()) {
            b05.c(new b05.a() { // from class: ra2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.n0();
                }
            });
            return;
        }
        if (chatItem == null || chatItem.getChatId() == null) {
            b05.c(new b05.a() { // from class: wa2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.o0();
                }
            });
            return;
        }
        if (chatItem.getChatType() != 0) {
            b05.c(new b05.a() { // from class: xa2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.p0();
                }
            });
            return;
        }
        if (a65.c(chatItem)) {
            b05.c(new b05.a() { // from class: ya2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.q0();
                }
            });
        } else if (v8.C(chatItem.getChatId())) {
            b05.c(new b05.a() { // from class: za2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.r0();
                }
            });
        } else {
            b05.c(new b05.a() { // from class: ab2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.s0(chatItem);
                }
            });
            new g13(new Runnable() { // from class: bb2
                @Override // java.lang.Runnable
                public final void run() {
                    GiftMessageHelper.l0(chatItem, i);
                }
            }).start();
        }
    }

    public static void U(ChatItem chatItem) {
        if (chatItem == null) {
            return;
        }
        String str = ChatGiftConfig.getChatGiftConfig().gift_givetxt;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MessageVo messageVoG = u0.g(chatItem);
        messageVoG.status = 2;
        messageVoG.mimeType = 10000;
        messageVoG.text = str;
        com.zenmen.palmchat.database.b.t(messageVoG);
    }

    public static void V(ChatItem chatItem) {
        if (chatItem == null || chatItem.getChatId() == null || chatItem.getChatType() != 0 || a65.c(chatItem) || chatItem.getBizType() == 5003) {
            return;
        }
        if (o30.q(chatItem.getChatId())) {
            LogUtil.d("insertGuideGiftMessage", "最佳聊友不允许显示礼物挂件");
            return;
        }
        if (v8.B.contains(chatItem.getChatId())) {
            LogUtil.d("insertGuideGiftMessage", "AI虚拟人不允许显示礼物挂件");
            return;
        }
        if (v8.C(chatItem.getChatId())) {
            b05.c(new b05.a() { // from class: oa2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.u0();
                }
            });
            return;
        }
        Pair<Boolean, Integer> pairB = B(chatItem.getChatId());
        if (((Boolean) pairB.first).booleanValue()) {
            W(chatItem, ((Integer) pairB.second).intValue());
        }
    }

    public static void W(ChatItem chatItem, int i) {
        u93.d(500, new d(chatItem, i));
    }

    public static void X(final String str, final ChatItem chatItem) {
        new g13(new Runnable() { // from class: va2
            @Override // java.lang.Runnable
            public final void run() {
                GiftMessageHelper.v0(str, chatItem);
            }
        }).start();
    }

    public static void Y(final String str, final List<ContactInfoItem> list, final ChatItem chatItem) {
        if (chatItem == null || TextUtils.isEmpty(str)) {
            return;
        }
        new g13(new Runnable() { // from class: sa2
            @Override // java.lang.Runnable
            public final void run() {
                GiftMessageHelper.w0(chatItem, list, str);
            }
        }).start();
    }

    public static /* synthetic */ Object Z() {
        return "insertFriendAgreeGiftGuide 开始执行";
    }

    public static /* synthetic */ Object a0() {
        return "insertFriendAgreeGiftGuide 非新太极，跳过";
    }

    public static /* synthetic */ Object b0() {
        return "insertFriendAgreeGiftGuide chatItem为空，跳过";
    }

    public static /* synthetic */ Object c0() {
        return "insertFriendAgreeGiftGuide 非单聊，跳过";
    }

    public static /* synthetic */ Object d0() {
        return "insertFriendAgreeGiftGuide 客服账号，跳过";
    }

    public static /* synthetic */ Object e0() {
        return "ai虚拟人，跳过";
    }

    public static /* synthetic */ Object f0() {
        return "insertFriendAgreeGiftGuide 非男性用户，跳过";
    }

    public static /* synthetic */ Object g0(ChatItem chatItem) {
        return "insertFriendAgreeGiftGuide 插入好友成交礼物引导消息, chatId=" + chatItem.getChatId();
    }

    public static /* synthetic */ Object h0() {
        return "insertFriendAgreeGiftGuide 消息已存在，跳过";
    }

    public static /* synthetic */ Object i0() {
        return "insertFriendAgreeGiftGuide 插入成功";
    }

    public static /* synthetic */ void j0(ChatItem chatItem) {
        if (com.zenmen.palmchat.database.b.y(chatItem.getChatId(), "REQUEST_GIFT_CARD")) {
            b05.c(new b05.a() { // from class: ta2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.h0();
                }
            });
            return;
        }
        MessageVo messageVoG = u0.g(chatItem);
        messageVoG.status = 2;
        messageVoG.mimeType = 20000;
        ChatGiftGuideCard chatGiftGuideCardG = G();
        ChatGiftConfig.GiftApplyChat giftAgreeChatItem = ChatGiftConfig.getGiftAgreeChatItem();
        chatGiftGuideCardG.giftName = giftAgreeChatItem.giftname;
        chatGiftGuideCardG.giftPrice = giftAgreeChatItem.giftprice;
        chatGiftGuideCardG.giftId = giftAgreeChatItem.giftID;
        chatGiftGuideCardG.giftIcon = giftAgreeChatItem.gifticon;
        String str = giftAgreeChatItem.subtitle;
        chatGiftGuideCardG.subtitle = str;
        messageVoG.text = str;
        messageVoG.extention = az2.c(chatGiftGuideCardG);
        messageVoG.data1 = "0";
        messageVoG.data2 = "REQUEST_GIFT_CARD";
        com.zenmen.palmchat.database.b.t(messageVoG);
        b05.c(new b05.a() { // from class: ua2
            @Override // b05.a
            public final Object getValue() {
                return GiftMessageHelper.i0();
            }
        });
    }

    public static /* synthetic */ Object k0() {
        return "insertFriendApplyGiftGuide 插入成功";
    }

    public static /* synthetic */ void l0(ChatItem chatItem, int i) {
        if (com.zenmen.palmchat.database.b.y(chatItem.getChatId(), "REQUEST_GIFT_CARD")) {
            b05.c(new b05.a() { // from class: pa2
                @Override // b05.a
                public final Object getValue() {
                    return GiftMessageHelper.t0();
                }
            });
            return;
        }
        MessageVo messageVoG = u0.g(chatItem);
        messageVoG.status = 2;
        messageVoG.mimeType = 20000;
        ChatGiftGuideCard chatGiftGuideCardH = H(i);
        ChatGiftConfig.GiftApplyChat giftApplyChatItem = ChatGiftConfig.getGiftApplyChatItem();
        chatGiftGuideCardH.giftName = giftApplyChatItem.giftname;
        chatGiftGuideCardH.giftPrice = giftApplyChatItem.giftprice;
        chatGiftGuideCardH.giftId = giftApplyChatItem.giftID;
        chatGiftGuideCardH.giftIcon = giftApplyChatItem.gifticon;
        String str = giftApplyChatItem.subtitle;
        chatGiftGuideCardH.subtitle = str;
        messageVoG.text = str;
        messageVoG.extention = az2.c(chatGiftGuideCardH);
        messageVoG.data1 = "0";
        messageVoG.data2 = "REQUEST_GIFT_CARD";
        com.zenmen.palmchat.database.b.t(messageVoG);
        b05.c(new b05.a() { // from class: qa2
            @Override // b05.a
            public final Object getValue() {
                return GiftMessageHelper.k0();
            }
        });
    }

    public static /* synthetic */ Object m0(int i) {
        return "insertFriendApplyGiftGuide 开始执行, applySource=" + i;
    }

    public static /* synthetic */ Object n0() {
        return "insertFriendApplyGiftGuide 非新太极，跳过";
    }

    public static /* synthetic */ Object o0() {
        return "insertFriendApplyGiftGuide chatItem为空，跳过";
    }

    public static /* synthetic */ Object p0() {
        return "insertFriendApplyGiftGuide 非单聊，跳过";
    }

    public static /* synthetic */ Object q0() {
        return "insertFriendApplyGiftGuide 客服账号，跳过";
    }

    public static /* synthetic */ Object r0() {
        return "ai虚拟人，跳过";
    }

    public static /* synthetic */ Object s0(ChatItem chatItem) {
        return "insertFriendApplyGiftGuide 插入好友申请礼物引导消息, chatId=" + chatItem.getChatId();
    }

    public static /* synthetic */ Object t0() {
        return "insertFriendApplyGiftGuide 消息已存在，跳过";
    }

    public static /* synthetic */ Object u0() {
        return "ai虚拟人，跳过";
    }

    public static /* synthetic */ void v0(String str, ChatItem chatItem) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("mid");
            jSONObject.optString("from");
            jSONObject.optString(RemoteMessageConst.TO);
            String strOptString2 = jSONObject.optString("body");
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt(SharePluginInfo.ISSUE_SUB_TYPE);
            if (DomainHelper.Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(DomainHelper.m(chatItem).domain)) {
                iOptInt2 = fu5.A(iOptInt2, false);
            }
            int iOptInt3 = jSONObject.optInt("exType");
            String strOptString3 = jSONObject.optString("extension");
            MessageVo messageVoG = u0.g(chatItem);
            messageVoG.mid = strOptString;
            messageVoG.text = strOptString2;
            messageVoG.mimeType = iOptInt;
            messageVoG.data1 = String.valueOf(iOptInt2);
            messageVoG.data2 = String.valueOf(iOptInt3);
            messageVoG.data3 = "0";
            messageVoG.extention = strOptString3;
            messageVoG.status = 2;
            messageVoG.bizType = chatItem.getBizType();
            com.zenmen.palmchat.database.b.t(messageVoG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void w0(ChatItem chatItem, List list, String str) {
        try {
            ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
            long jO = com.zenmen.palmchat.database.b.o(chatItem.getChatId());
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ContactInfoItem contactInfoItem = (ContactInfoItem) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(bd.h, contactInfoItemL.getExid());
                jSONObject.put("nickname", contactInfoItemL.getNameForShow());
                jSONObject.put("headIconUrl", contactInfoItemL.getIconURL());
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(DeviceInfoUtil.UID_TAG, contactInfoItem.getUid());
                jSONObject3.put("nickname", contactInfoItem.getNickName());
                jSONObject3.put("headIconUrl", contactInfoItem.getIconURL());
                jSONObject2.put("toUser", jSONObject3);
                jSONObject.put("giftMsg", jSONObject2.toString());
                MessageVo messageVoG = u0.g(chatItem);
                messageVoG.mimeType = 35;
                messageVoG.data1 = String.valueOf(1);
                messageVoG.data2 = chatItem.getChatType() == 0 ? String.valueOf(1) : String.valueOf(2);
                messageVoG.status = 2;
                messageVoG.bizType = chatItem.getBizType();
                messageVoG.extention = jSONObject.toString();
                messageVoG.versionId = jO;
                arrayList.add(messageVoG);
            }
            com.zenmen.palmchat.database.b.v(chatItem, arrayList);
            if (p05.c() && chatItem.getChatType() == 0) {
                U(chatItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void x0(ChatItem chatItem, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("item_uid", chatItem.getChatId());
            jSONObject.put("giftId", i);
            jSONObject.put("from", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("pagechat_gift_send", null, jSONObject.toString());
    }

    public static void y0(Context context, String str) {
        if (!hx3.m(context)) {
            sy5.f(context, context.getString(R.string.net_status_unavailable_connect), 0).g();
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, TransparentCordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putString("page_index", "gift-animation");
        bundle.putBoolean("extra_key_full_window", true);
        bundle.putBoolean("hide_progressbar", true);
        intent.putExtras(bundle);
        new com.zenmen.palmchat.activity.webview2.b(context, intent).show();
    }

    public static void z0(InputFragment inputFragment, ChatItem chatItem, int i, int i2) {
        if (inputFragment == null || chatItem == null) {
            return;
        }
        inputFragment.L();
        ea2.a(chatItem.getChatId(), i, DomainHelper.m(chatItem).domain, chatItem.getBizType(), new a(inputFragment, chatItem, i, i2));
    }
}
