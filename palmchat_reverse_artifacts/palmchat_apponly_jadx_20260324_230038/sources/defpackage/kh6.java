package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class kh6 {
    public static VoiceMatchConfig.EntryMsgItem a() {
        VoiceMatchConfig voiceMatchConfigC0 = lh6.V().c0(true);
        if (voiceMatchConfigC0 == null || voiceMatchConfigC0.entry_msg == null) {
            return null;
        }
        boolean zH = v4.h();
        VoiceMatchConfig.EntryMsg entryMsg = voiceMatchConfigC0.entry_msg;
        return zH ? entryMsg.female : entryMsg.male;
    }

    public static String b(String str) {
        return !TextUtils.isEmpty(str) ? str.replace("{", "<a").replace("}", "</a>") : "找人语音聊聊天？语音速配，真实声音、实时连线，<a href='zenxin://activity?page=a0623&from=7&subPage=1'>去试试></a>";
    }

    public static void c(ChatItem chatItem) {
        VoiceMatchConfig.EntryMsgItem entryMsgItemA = a();
        if (entryMsgItemA != null && entryMsgItemA.enable && lh6.g0()) {
            MessageVo messageVoG = u0.g(chatItem);
            messageVoG.status = 2;
            messageVoG.mimeType = 10000;
            messageVoG.text = !TextUtils.isEmpty(entryMsgItemA.sysmsg_show) ? entryMsgItemA.sysmsg_show : "找人语音聊聊天？语音速配，真实声音、实时连线，去试试>";
            messageVoG.data1 = "1";
            messageVoG.data2 = "{\"actionTypes\":\"activity\", \"actionBody\":\"" + b(entryMsgItemA.text) + "\"}";
            b.u(messageVoG, false);
            zn6.c("audioMatch_system_msg", "view");
        }
    }
}
