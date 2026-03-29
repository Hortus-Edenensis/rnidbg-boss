package defpackage;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class yz2 {
    public static MessageVo b(ChatItem chatItem, String str) {
        if (chatItem != null) {
            try {
                if (chatItem.getChatId() == null || a65.e(chatItem) || chatItem.getChatType() != 0) {
                    return null;
                }
                Spanned spannedFromHtml = Html.fromHtml(str.replace("\n", "<br>"));
                MessageVo messageVo = new MessageVo();
                messageVo.mimeType = 1;
                messageVo.mid = xn3.a();
                messageVo.time = ir5.b();
                messageVo.contactRelate = DomainHelper.e(chatItem);
                messageVo.to = DomainHelper.e(chatItem);
                messageVo.isRead = true;
                messageVo.isSend = false;
                messageVo.status = 2;
                messageVo.sendFlag = String.valueOf(0);
                messageVo.attachStatus = 2;
                messageVo.from = AccountUtils.p(AppContext.getContext());
                messageVo.extention = "";
                messageVo.text = spannedFromHtml.toString();
                messageVo.bizType = chatItem.getBizType();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("linkFlag2", 1);
                jSONObject.put("richText", str);
                messageVo.data2 = jSONObject.toString();
                return messageVo;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void c(final MessageVo messageVo) {
        new g13(new Runnable() { // from class: xz2
            @Override // java.lang.Runnable
            public final void run() {
                yz2.d(messageVo);
            }
        }).start();
    }

    public static /* synthetic */ void d(MessageVo messageVo) {
        if (messageVo != null) {
            b.t(messageVo);
        }
    }

    public static void e(ChatItem chatItem) {
        long jOptInt;
        JSONObject config = vs0.a().getConfig("customerServiceInfo");
        String strReplace = "";
        if (config != null) {
            strReplace = config.optString("welcomeMsg", "").replace("<<", "<a").replace(">>", "</a>");
            jOptInt = config.optInt("timeInterval", 24);
        } else {
            jOptInt = 0;
        }
        if (TextUtils.isEmpty(strReplace)) {
            return;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CHAT_GUIDE;
        long jI = sPUtil.i(scene, "key_chat_kefu_guide_request_times", 0L);
        if (jI == 0) {
            c(b(chatItem, strReplace));
            sPUtil.t(scene, "key_chat_kefu_guide_request_times", Long.valueOf(System.currentTimeMillis()));
        } else {
            if (jI <= 0 || System.currentTimeMillis() - jI <= jOptInt * 60 * 60 * 1000) {
                return;
            }
            c(b(chatItem, strReplace));
            sPUtil.t(scene, "key_chat_kefu_guide_request_times", Long.valueOf(System.currentTimeMillis()));
        }
    }
}
