package com.zenmen.palmchat.chat.pay;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import defpackage.fu5;
import defpackage.n20;
import defpackage.of2;
import defpackage.u0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12896a = false;

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.pay.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0999a implements a.InterfaceC1055a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1055a f12897a;

        public C0999a(a.InterfaceC1055a interfaceC1055a) {
            this.f12897a = interfaceC1055a;
        }

        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            a.this.f12896a = false;
            com.zenmen.palmchat.giftkit.b.j().q();
            a.InterfaceC1055a interfaceC1055a = this.f12897a;
            if (interfaceC1055a != null) {
                interfaceC1055a.a(z);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f12898a;

        public b(c cVar) {
            this.f12898a = cVar;
        }

        @Override // com.zenmen.palmchat.chat.pay.a.c
        public void a(boolean z) {
            this.f12898a.a(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(boolean z);
    }

    public static a c() {
        return b;
    }

    public static void d(ChatItem chatItem, String str) {
        if (chatItem == null || chatItem.getChatId() == null || chatItem.getChatType() != 0 || chatItem.getBizType() == 5003 || chatItem.getBizType() == 5012 || chatItem.getBizType() == 5015 || chatItem.getBizType() == 5017) {
            return;
        }
        if (SPUtil.f14322a.a(SPUtil.SCENE.CHAT_PAY, "key_has_insert_pay_chatInfo" + chatItem.getChatId(), false)) {
            return;
        }
        MessageVo messageVoG = u0.g(chatItem);
        messageVoG.status = 2;
        messageVoG.mimeType = 10000;
        messageVoG.data1 = String.valueOf(1);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionBody", str);
            jSONObject.put("actionTypes", "activity");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        messageVoG.data2 = jSONObject.toString();
        messageVoG.data3 = String.valueOf(12);
        messageVoG.text = new SpannableStringBuilder(Html.fromHtml(str)).toString();
        com.zenmen.palmchat.database.b.u(messageVoG, false);
        SPUtil.f14322a.t(SPUtil.SCENE.CHAT_PAY, "key_has_insert_pay_chatInfo" + chatItem.getChatId(), Boolean.TRUE);
    }

    public void b(Context context, PayChatInfo payChatInfo, ChatItem chatItem, c cVar) {
        if (!e(chatItem, payChatInfo)) {
            cVar.a(true);
            return;
        }
        ChatPayInfoDialog chatPayInfoDialog = new ChatPayInfoDialog(context, payChatInfo, new b(cVar));
        chatPayInfoDialog.w(false);
        chatPayInfoDialog.show();
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_has_show_chat_pay_info", Boolean.TRUE);
    }

    public final boolean e(ChatItem chatItem, PayChatInfo payChatInfo) {
        return (payChatInfo == null || !payChatInfo.isNeedShowPayInfo() || chatItem == null || !fu5.u(chatItem) || SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_has_show_chat_pay_info", false)) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(Context context, ChatItem chatItem, long j, a.InterfaceC1055a interfaceC1055a) {
        int i;
        if (this.f12896a) {
            return;
        }
        if (chatItem == null) {
            i = 8;
        } else if (5016 == chatItem.getBizType()) {
            i = 10;
        } else if (5012 == chatItem.getBizType()) {
            i = 9;
        }
        String str = fu5.k(chatItem.getBizType()).domain;
        com.zenmen.palmchat.giftkit.a.a().b(context, of2.f(i, 801, chatItem.getChatId() + str, n20.h(chatItem), str, chatItem.getBizType()), j, new C0999a(interfaceC1055a));
        this.f12896a = true;
    }
}
