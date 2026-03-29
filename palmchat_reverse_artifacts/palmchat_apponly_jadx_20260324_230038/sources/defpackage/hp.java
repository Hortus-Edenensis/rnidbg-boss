package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class hp {
    public static MessageVo d(MessageProto.Message message) {
        try {
            MessageVo messageVo = new MessageVo();
            messageVo.mimeType = 20002;
            messageVo.mid = "chatGuidance" + message.getMid();
            messageVo.time = ir5.b();
            String strT = DomainHelper.t(message.getFrom());
            messageVo.to = strT;
            int iM = b.m(message);
            messageVo.bizType = iM;
            messageVo.contactRelate = DomainHelper.c(DomainHelper.k(strT), iM);
            messageVo.text = message.getBody();
            messageVo.isRead = true;
            messageVo.isSend = true;
            messageVo.status = 2;
            messageVo.sendFlag = String.valueOf(0);
            messageVo.attachStatus = 2;
            messageVo.from = AccountUtils.p(AppContext.getContext());
            return messageVo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<MessageVo> e(List<MessageProto.Message> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    Iterator<MessageProto.Message> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(d(it.next()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static MessageVo f(String str, ChatItem chatItem) {
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
                    messageVo.text = str;
                    messageVo.bizType = chatItem.getBizType();
                    messageVo.extention = new JSONObject().put("chatGuidance", 1).toString();
                    return messageVo;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void g(final String str, final ChatItem chatItem) {
        new g13(new Runnable() { // from class: fp
            @Override // java.lang.Runnable
            public final void run() {
                hp.l(str, chatItem);
            }
        }).start();
    }

    public static ArrayList<String> h() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArrayC = vs0.a().c("banned_message");
            if (jSONArrayC == null) {
                jSONArrayC = new JSONArray("[\"你好，你是哪里人\", \"你在我的附近吗？\", \"你今年多大了呀？\", \"你一般什么时候在线？\", \"你看我们合适吗？\", \"你现在有空吗？\", \"你在做什么呢？\", \"你愿意和我做朋友吗？\"] ");
            }
            for (int i = 0; i < jSONArrayC.length(); i++) {
                String strOptString = jSONArrayC.optString(i);
                if (!il5.l(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<String> i() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayListH = h();
        Collections.shuffle(arrayListH);
        if (arrayListH.size() >= 3) {
            arrayList.addAll(arrayListH.subList(0, 3));
        } else {
            arrayList.addAll(arrayListH);
        }
        return arrayList;
    }

    public static void j(final MessageVo messageVo) {
        new g13(new Runnable() { // from class: ep
            @Override // java.lang.Runnable
            public final void run() {
                hp.m(messageVo);
            }
        }).start();
    }

    public static void k(final List<MessageVo> list) {
        new g13(new Runnable() { // from class: gp
            @Override // java.lang.Runnable
            public final void run() {
                hp.n(list);
            }
        }).start();
    }

    public static /* synthetic */ void l(String str, ChatItem chatItem) {
        if (il5.l(str) || chatItem == null) {
            return;
        }
        b.i(str, chatItem);
    }

    public static /* synthetic */ void m(MessageVo messageVo) {
        if (messageVo != null) {
            b.t(messageVo);
        }
    }

    public static /* synthetic */ void n(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b.t((MessageVo) it.next());
        }
    }
}
