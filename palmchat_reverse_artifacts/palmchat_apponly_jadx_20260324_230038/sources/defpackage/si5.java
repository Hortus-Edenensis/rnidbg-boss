package defpackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.constants.ErrorCode;
import com.zenmen.listui.duration.BaseDurationActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.giftkit.GiftBizType;
import com.zenmen.palmchat.giftkit.GiftPanel;
import com.zenmen.palmchat.giftkit.chat.ChatGiftMessageExtensionBean;
import com.zenmen.palmchat.giftkit.chat.GiftReceiverInfo;
import com.zenmen.palmchat.giftkit.event.GiftMsgEvent;
import com.zenmen.palmchat.giftkit.play.GiftPlayVo;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.q05;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class si5 {
    public static int j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GiftPanel f20759a;
    public ContactInfoItem b;
    public wb2 c;
    public Activity d;
    public View e;
    public yl2 f;
    public q05.e<GiftPlayVo> g;
    public int h = 0;
    public SquareFeed i;

    public si5() {
        this.f = null;
        this.f = ap3.a().Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(ChatGiftMessageExtensionBean chatGiftMessageExtensionBean, ContactInfoItem contactInfoItem, fb2 fb2Var) {
        GiftPlayVo giftPlayVo = new GiftPlayVo();
        giftPlayVo.itemId = chatGiftMessageExtensionBean.itemId;
        giftPlayVo.relatedId = chatGiftMessageExtensionBean.relatedId;
        giftPlayVo.itemName = chatGiftMessageExtensionBean.itemName;
        giftPlayVo.iconUrl = chatGiftMessageExtensionBean.iconUrl;
        giftPlayVo.showIconUrl = chatGiftMessageExtensionBean.showIconUrl;
        giftPlayVo.itemCount = chatGiftMessageExtensionBean.itemCount;
        giftPlayVo.fromUserId = contactInfoItem.getChatId();
        giftPlayVo.fromUserName = contactInfoItem.getChatName();
        giftPlayVo.fromUserAvatarUrl = contactInfoItem.getIconURL();
        giftPlayVo.toUserId = this.b.getChatId();
        giftPlayVo.toUserName = this.b.getChatName();
        giftPlayVo.toUserAvatarUrl = this.b.getIconURL();
        giftPlayVo.priceLevel = chatGiftMessageExtensionBean.priceLevel;
        giftPlayVo.comboNumber = chatGiftMessageExtensionBean.comboNumber;
        giftPlayVo.giftMessageType = fb2Var.b ? 1 : 0;
        int i = j;
        if (i == 200101 || i == 200102 || i == 200103) {
            if (this.h == 2000000) {
                this.c.K(giftPlayVo);
            }
        } else if (i == this.h) {
            this.c.K(giftPlayVo);
        }
        q05.e<GiftPlayVo> eVar = this.g;
        if (eVar != null) {
            eVar.a(giftPlayVo);
        }
    }

    public static /* synthetic */ void h(GiftMsgEvent giftMsgEvent, ChatGiftMessageExtensionBean chatGiftMessageExtensionBean) {
        for (int i = 0; i < giftMsgEvent.toUserList.size(); i++) {
            try {
                ChatGiftMessageExtensionBean chatGiftMessageExtensionBean2 = (ChatGiftMessageExtensionBean) chatGiftMessageExtensionBean.clone();
                chatGiftMessageExtensionBean2.toUser = new GiftReceiverInfo(giftMsgEvent.toUserList.get(i), null, null);
                ds0.a().b(new fb2(chatGiftMessageExtensionBean2, true));
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    public final ContactInfoItem c(ContactInfoItem contactInfoItem) {
        if (contactInfoItem.getIsStranger()) {
            contactInfoItem.setBizType(ErrorCode.BIDDING_C2S_NO_AD);
            contactInfoItem.setSourceType(60);
        }
        return contactInfoItem;
    }

    public final List<ContactInfoItem> d(List<String> list) {
        ArrayList arrayList = new ArrayList();
        ContactInfoItem contactInfoItem = this.b;
        if (contactInfoItem != null) {
            arrayList.add(contactInfoItem);
        }
        return arrayList;
    }

    public final void e(ContactInfoItem contactInfoItem, int i) {
        if (contactInfoItem != null) {
            HashMap<String, Object> mapB = this.f.b(contactInfoItem);
            mapB.put("isShow", Boolean.TRUE);
            String str = (String) mapB.get("domain");
            GiftPanel giftPanel = new GiftPanel();
            this.f20759a = giftPanel;
            giftPanel.p1(true);
            this.f20759a.i1(new JSONObject(mapB).toString());
            this.f20759a.r1(contactInfoItem.getChatId());
            this.f20759a.m1(i, contactInfoItem.getChatId() + str, contactInfoItem.getBizType(), str);
        }
    }

    public final void f(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (this.c == null) {
            this.c = new wb2(this.d, GiftBizType.Chat, viewGroup, viewGroup2);
        }
    }

    public void i(Activity activity, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.d = activity;
        this.e = viewGroup;
        ds0.a().c(this);
        f(viewGroup, viewGroup2);
    }

    public void j() {
        ds0.a().d(this);
        wb2 wb2Var = this.c;
        if (wb2Var != null) {
            wb2Var.Q();
        }
    }

    public void k(BaseDurationActivity baseDurationActivity, ContactInfoItem contactInfoItem, int i, int i2, SquareFeed squareFeed) {
        try {
            j = i2;
            this.i = squareFeed;
            this.b = contactInfoItem;
            e(c(contactInfoItem), i);
            this.f20759a.s1(baseDurationActivity.getSupportFragmentManager(), i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @qm5
    public void receivedGiftMsgPlayEvent(final fb2 fb2Var) {
        final ChatGiftMessageExtensionBean chatGiftMessageExtensionBean;
        final ContactInfoItem contactInfoItemF;
        b05.a("最新的giftPanelFrom===》" + j);
        b05.a("接收到接收礼物的事件GiftMsgPlayEvent");
        if (fb2Var == null || this.e == null || this.c == null || (chatGiftMessageExtensionBean = fb2Var.f17496a) == null || (contactInfoItemF = v4.f()) == null || this.b == null) {
            return;
        }
        this.e.post(new Runnable() { // from class: qi5
            @Override // java.lang.Runnable
            public final void run() {
                this.f20257a.g(chatGiftMessageExtensionBean, contactInfoItemF, fb2Var);
            }
        });
    }

    @qm5
    public void receivedSendGiftMsgEvent(final GiftMsgEvent giftMsgEvent) {
        ContactInfoItem contactInfoItem;
        String str;
        final ChatGiftMessageExtensionBean chatGiftMessageExtensionBean;
        b05.a("receivedSendGiftMsgEvent===》收到事件");
        if (giftMsgEvent == null || this.e == null || (contactInfoItem = this.b) == null) {
            return;
        }
        if (j > 0) {
            if (801 != giftMsgEvent.panelId) {
                return;
            }
        } else if (301 != giftMsgEvent.panelId) {
            return;
        }
        String str2 = giftMsgEvent.roomId;
        if ((str2 != null && !str2.contains(contactInfoItem.getChatId())) || (str = giftMsgEvent.bizData) == null || (chatGiftMessageExtensionBean = (ChatGiftMessageExtensionBean) az2.a(str, ChatGiftMessageExtensionBean.class)) == null) {
            return;
        }
        this.f.a(giftMsgEvent.bizData, d(giftMsgEvent.toUserList), this.b);
        this.e.post(new Runnable() { // from class: ri5
            @Override // java.lang.Runnable
            public final void run() {
                si5.h(giftMsgEvent, chatGiftMessageExtensionBean);
            }
        });
    }
}
