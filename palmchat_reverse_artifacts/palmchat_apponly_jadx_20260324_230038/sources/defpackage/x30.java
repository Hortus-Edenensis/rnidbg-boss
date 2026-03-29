package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.Vo.ChatOneVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.NoticeBarStyle;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.conversations.threadsnew.chatone.vo.ChatOneItemVo;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class x30 {
    public static Set<String> b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChatterAdapter f21864a;

    public x30(ChatterAdapter chatterAdapter) {
        this.f21864a = chatterAdapter;
    }

    public static MessageVo a(ChatItem chatItem, ChatOneItemVo chatOneItemVo) {
        MessageVo messageVoG = u0.g(chatItem);
        messageVoG.mimeType = 71;
        RichMsgVo richMsgVo = new RichMsgVo();
        ChatOneVo chatOneVo = new ChatOneVo();
        richMsgVo.chatOne = chatOneVo;
        chatOneVo.selfContent = chatOneItemVo.dialogMsgForSelf;
        chatOneVo.realContent = chatOneItemVo.highDialogMsgForOther;
        chatOneVo.lowrealContent = chatOneItemVo.lowDialogMsgForOther;
        NoticeBarStyle noticeBarStyle = new NoticeBarStyle();
        richMsgVo.noticeBar = noticeBarStyle;
        noticeBarStyle.unnoticeable = true;
        messageVoG.extention = az2.c(richMsgVo);
        messageVoG.text = chatOneItemVo.dialogMsgForSelf;
        return messageVoG;
    }

    public static String b(ChatOneItemVo chatOneItemVo, String str) {
        return chatOneItemVo.requestId + str;
    }

    public static Set<String> c() {
        if (b == null) {
            b = g();
        }
        return b;
    }

    public static boolean d(ChatOneItemVo chatOneItemVo, String str) {
        boolean z = !c().contains(b(chatOneItemVo, str));
        LogUtil.i("ChatOneMsgUIHelper", "needShowChatOneMsg" + z);
        return z;
    }

    public static void f(ChatOneItemVo chatOneItemVo, String str) {
        LogUtil.i("ChatOneMsgUIHelper", "onItemHasSendMsg");
        c().add(b(chatOneItemVo, str));
        SPUtil.f14322a.v(SPUtil.SCENE.APP_COMMON, "key_chat_one_has_chat_uids", TextUtils.join(",", b));
    }

    public static Set<String> g() {
        HashSet hashSet = new HashSet();
        String strP = SPUtil.f14322a.p(SPUtil.SCENE.APP_COMMON, "key_chat_one_has_chat_uids", "");
        if (!TextUtils.isEmpty(strP)) {
            String[] strArrSplit = strP.split(",");
            if (strArrSplit.length > 0) {
                hashSet.addAll(Arrays.asList(strArrSplit));
            }
        }
        return hashSet;
    }

    public void e(ArrayList<MessageVo> arrayList) {
        ChatItem chatItemF = this.f21864a.F();
        ChatOneItemVo chatOneItemVoF = this.f21864a.J().f();
        if (chatOneItemVoF == null || !d(chatOneItemVoF, chatItemF.getChatId())) {
            return;
        }
        LogUtil.i("ChatOneMsgUIHelper", "add temp guide msg");
        arrayList.add(a(chatItemF, chatOneItemVoF));
    }
}
