package com.zenmen.palmchat.chat;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatBreakHelper;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a65;
import defpackage.az2;
import defpackage.b5;
import defpackage.g13;
import defpackage.il5;
import defpackage.ir5;
import defpackage.nl0;
import defpackage.v4;
import defpackage.vs0;
import defpackage.wc;
import defpackage.xn3;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatBreakHelper {
    public static volatile ChatBreakHelper d;
    public static final String e = nl0.z + "/userem.nochat.guide.v1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f12506a = -1;
    public final long b = 86400000;
    public ChatBreak c = null;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class ChatAns {
        public long aid;
        public String ans;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class ChatBreak {
        public List<ChatQue> list = new ArrayList();
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class ChatQue {
        public List<ChatAns> ans = new ArrayList();
        public long id;
        public String pro;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class ConfigAnswer {
        public String answer_title = "Ta很想知道你的答案，立即回答Ta吧";
        public String answer_type = "close";
        public String answer_but = "发送";
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class ConfigNoChat {
        public ConfigQuestion question = new ConfigQuestion();
        public ConfigAnswer answer = new ConfigAnswer();
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class ConfigQuestion {
        public String question_title = "聊聊这些，Ta可能会感兴趣哦";
        public String question_type = "change";
        public String question_but = "发送";
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class MsgCardOption {
        public ConfigNoChat nochat = new ConfigNoChat();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f12507a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.ChatBreakHelper$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0970a implements b5 {
            public C0970a() {
            }

            @Override // defpackage.b5
            public void call() {
                ChatBreakHelper.this.A(true);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements b5 {
            public b() {
            }

            @Override // defpackage.b5
            public void call() {
                ChatBreakHelper.this.A(true);
            }
        }

        public a(long j, boolean z) {
            this.f12507a = j;
            this.b = z;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            exc.printStackTrace();
            LogUtil.i("logbreak", "onFail" + exc);
            if (this.b) {
                return;
            }
            wc.a().a().b(new b(), 5L, TimeUnit.SECONDS);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.json("logbreak", jSONObject, ChatBreakHelper.e);
            if (yy2Var == null || !yy2Var.f22300a || yy2Var.d == null) {
                if (this.b) {
                    return;
                }
                wc.a().a().b(new C0970a(), 5L, TimeUnit.SECONDS);
                return;
            }
            ChatBreakHelper.this.f12506a = this.f12507a;
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.CHAT_GUIDE;
            sPUtil.t(scene, "key_chat_break_config_updatetime", Long.valueOf(ChatBreakHelper.this.f12506a));
            try {
                ChatBreak chatBreak = (ChatBreak) az2.a(yy2Var.d.toString(), ChatBreak.class);
                if (ChatBreakHelper.this.w(chatBreak)) {
                    ChatBreakHelper.this.c = chatBreak;
                    sPUtil.t(scene, "key_chat_break_config", az2.c(ChatBreakHelper.this.c));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static MessageVo j(ChatAns chatAns, ChatItem chatItem) {
        if (chatItem != null) {
            try {
                if (chatItem.getChatId() != null && !a65.e(chatItem)) {
                    MessageVo messageVo = new MessageVo();
                    messageVo.mimeType = 1;
                    messageVo.mid = xn3.a();
                    messageVo.time = ir5.b();
                    messageVo.contactRelate = DomainHelper.e(chatItem);
                    messageVo.to = DomainHelper.e(chatItem);
                    messageVo.isRead = true;
                    messageVo.isSend = true;
                    messageVo.status = 4;
                    messageVo.sendFlag = String.valueOf(0);
                    messageVo.attachStatus = 2;
                    messageVo.from = AccountUtils.p(AppContext.getContext());
                    messageVo.text = chatAns.ans;
                    messageVo.setThreadBizType(AppContext.getContext(), chatItem.getBizType());
                    messageVo.extention = new JSONObject().put("noChat", 3).put("noChatAnsId", chatAns.aid).toString();
                    return messageVo;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static MessageVo k(MessageProto.Message message) {
        try {
            MessageVo messageVo = new MessageVo();
            messageVo.mimeType = 20003;
            messageVo.mid = "noChat" + message.getMid();
            messageVo.time = ir5.b();
            String strT = DomainHelper.t(message.getFrom());
            messageVo.to = strT;
            int iM = com.zenmen.palmchat.database.b.m(message);
            messageVo.bizType = iM;
            messageVo.contactRelate = DomainHelper.c(DomainHelper.k(strT), iM);
            messageVo.text = message.getBody();
            messageVo.isRead = true;
            messageVo.isSend = true;
            messageVo.status = 2;
            messageVo.sendFlag = String.valueOf(0);
            messageVo.attachStatus = 2;
            messageVo.from = AccountUtils.p(AppContext.getContext());
            messageVo.extention = message.getExtension();
            return messageVo;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<MessageVo> l(List<MessageProto.Message> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    Iterator<MessageProto.Message> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(k(it.next()));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    public static MessageVo m(ChatQue chatQue, ChatItem chatItem) {
        if (chatItem != null) {
            try {
                if (chatItem.getChatId() != null && !a65.e(chatItem)) {
                    MessageVo messageVo = new MessageVo();
                    messageVo.mimeType = 1;
                    messageVo.mid = xn3.a();
                    messageVo.time = ir5.b();
                    messageVo.contactRelate = DomainHelper.e(chatItem);
                    messageVo.to = DomainHelper.e(chatItem);
                    messageVo.isRead = true;
                    messageVo.isSend = true;
                    messageVo.status = 4;
                    messageVo.sendFlag = String.valueOf(0);
                    messageVo.attachStatus = 2;
                    messageVo.from = AccountUtils.p(AppContext.getContext());
                    messageVo.text = chatQue.pro;
                    messageVo.setThreadBizType(AppContext.getContext(), chatItem.getBizType());
                    messageVo.extention = new JSONObject().put("noChat", 2).put("noChatQueId", chatQue.id).toString();
                    return messageVo;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void n(final String str, final ChatItem chatItem) {
        new g13(new Runnable() { // from class: w10
            @Override // java.lang.Runnable
            public final void run() {
                ChatBreakHelper.x(str, chatItem);
            }
        }).start();
    }

    public static MsgCardOption p() {
        MsgCardOption msgCardOption = new MsgCardOption();
        try {
            JSONObject config = vs0.a().getConfig("msg_card_option");
            if (config == null) {
                return msgCardOption;
            }
            MsgCardOption msgCardOption2 = (MsgCardOption) az2.a(config.toString(), MsgCardOption.class);
            return msgCardOption2 != null ? msgCardOption2 : msgCardOption;
        } catch (Exception e2) {
            e2.printStackTrace();
            return msgCardOption;
        }
    }

    public static ChatBreakHelper q() {
        if (d == null) {
            synchronized (ChatBreakHelper.class) {
                if (d == null) {
                    d = new ChatBreakHelper();
                }
            }
        }
        return d;
    }

    public static List<ChatQue> t() {
        ArrayList arrayList = new ArrayList();
        List<ChatQue> list = q().o().list;
        if (list != null) {
            arrayList.addAll(list);
        }
        Collections.shuffle(arrayList);
        return arrayList.size() > 3 ? arrayList.subList(0, 3) : arrayList;
    }

    public static void u(final MessageVo messageVo) {
        new g13(new Runnable() { // from class: x10
            @Override // java.lang.Runnable
            public final void run() {
                ChatBreakHelper.y(messageVo);
            }
        }).start();
    }

    public static void v(final List<MessageVo> list) {
        new g13(new Runnable() { // from class: y10
            @Override // java.lang.Runnable
            public final void run() {
                ChatBreakHelper.z(list);
            }
        }).start();
    }

    public static /* synthetic */ void x(String str, ChatItem chatItem) {
        if (il5.l(str) || chatItem == null) {
            return;
        }
        com.zenmen.palmchat.database.b.i(str, chatItem);
    }

    public static /* synthetic */ void y(MessageVo messageVo) {
        if (messageVo != null) {
            com.zenmen.palmchat.database.b.t(messageVo);
        }
    }

    public static /* synthetic */ void z(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.zenmen.palmchat.database.b.t((MessageVo) it.next());
        }
    }

    public void A(boolean z) {
        if (TextUtils.isEmpty(v4.e(AppContext.getContext()))) {
            return;
        }
        LogUtil.i("logbreak", "ChatBreakHelper: update");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - r()) > 86400000) {
            JSONObject jSONObject = new JSONObject();
            LogUtil.i("logbreak", "update params = " + jSONObject);
            zw4.a().c(e, 1, jSONObject, new a(jCurrentTimeMillis, z), true, true);
        }
    }

    public ChatBreak o() {
        if (this.c == null) {
            String strN = SPUtil.f14322a.n(SPUtil.SCENE.CHAT_GUIDE, "key_chat_break_config", "");
            this.c = new ChatBreak();
            LogUtil.i("logbreak", "init   configstr=" + strN);
            if (!TextUtils.isEmpty(strN)) {
                try {
                    ChatBreak chatBreak = (ChatBreak) az2.a(strN, ChatBreak.class);
                    if (w(chatBreak)) {
                        this.c = chatBreak;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return this.c;
    }

    public final long r() {
        if (this.f12506a == -1) {
            this.f12506a = SPUtil.f14322a.i(SPUtil.SCENE.CHAT_GUIDE, "key_chat_break_config_updatetime", 0L);
        }
        return this.f12506a;
    }

    public ChatQue s(long j) {
        ChatBreak chatBreakO = o();
        if (chatBreakO == null) {
            return null;
        }
        for (ChatQue chatQue : chatBreakO.list) {
            if (chatQue.id == j) {
                return chatQue;
            }
        }
        return null;
    }

    public final boolean w(ChatBreak chatBreak) {
        List<ChatQue> list;
        return (chatBreak == null || (list = chatBreak.list) == null || list.size() <= 0) ? false : true;
    }
}
