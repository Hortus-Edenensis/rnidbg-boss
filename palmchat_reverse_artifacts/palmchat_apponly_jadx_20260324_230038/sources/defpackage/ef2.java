package defpackage;

import com.baidu.platform.comapi.map.MapController;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.GuideInfoForChatCard;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ef2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17290a = "ef2";
    public static boolean b = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17291a;

        public a(b bVar) {
            this.f17291a = bVar;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LogUtil.i(ef2.f17290a, "======getChatGuideInfo failure:");
            ef2.b = false;
            b bVar = this.f17291a;
            if (bVar != null) {
                bVar.onFail(exc);
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i(ef2.f17290a, "======getChatGuideInfo success info :" + jSONObject);
            ef2.b = false;
            if (jSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            int iOptInt = jSONObject.optInt("resultCode", -1);
            if (iOptInt != 0) {
                onFail(new Exception("code is wrong:" + iOptInt));
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            b bVar = this.f17291a;
            if (bVar != null) {
                bVar.onSuccess(jSONObjectOptJSONObject.toString());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onFail(Exception exc);

        void onSuccess(String str);
    }

    public static MessageVo c(ChatItem chatItem, String str) {
        if (chatItem != null) {
            try {
                if (chatItem.getChatId() == null || a65.e(chatItem) || chatItem.getChatType() != 0) {
                    return null;
                }
                MessageVo messageVo = new MessageVo();
                messageVo.mimeType = 20001;
                messageVo.mid = xn3.a();
                messageVo.time = ir5.b();
                messageVo.contactRelate = DomainHelper.e(chatItem);
                messageVo.to = DomainHelper.e(chatItem);
                messageVo.isRead = true;
                messageVo.isSend = true;
                messageVo.status = 2;
                messageVo.sendFlag = String.valueOf(0);
                messageVo.attachStatus = 2;
                messageVo.from = AccountUtils.p(AppContext.getContext());
                RichMsgVo richMsgVo = new RichMsgVo();
                richMsgVo.guideInfo = (GuideInfoForChatCard) az2.a(str, GuideInfoForChatCard.class);
                messageVo.extention = az2.c(richMsgVo);
                messageVo.text = MapController.DEFAULT_LAYER_TAG;
                messageVo.bizType = chatItem.getBizType();
                return messageVo;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void d(String str, boolean z, String str2, b bVar) {
        try {
            if (b) {
                return;
            }
            b = true;
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put("fexid", str);
            } else {
                jSONObject.put("fuid", str);
            }
            jSONObject.put("birth", str2);
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.CHAT_GUIDE;
            int iF = by5.k(sPUtil.i(scene, "key_chat_guide_request_time_stamp", System.currentTimeMillis())) ? sPUtil.f(scene, "key_chat_guide_request_times", 0) + 1 : 1;
            jSONObject.put("count", iF);
            sPUtil.t(scene, "key_chat_guide_request_times", Integer.valueOf(iF));
            sPUtil.t(scene, "key_chat_guide_request_time_stamp", Long.valueOf(System.currentTimeMillis()));
            zw4.f(vm0.j1, 1, jSONObject, new a(bVar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long e() {
        JSONObject config = vs0.a().getConfig("chatGuideInfo");
        int iOptInt = config != null ? config.optInt("frequency_day", 3) : 3;
        if (iOptInt <= 0) {
            return 259200000L;
        }
        return ((long) iOptInt) * 86400000;
    }

    public static void f(final MessageVo messageVo) {
        new g13(new Runnable() { // from class: df2
            @Override // java.lang.Runnable
            public final void run() {
                ef2.h(messageVo);
            }
        }).start();
    }

    public static boolean g() {
        return !"A".equals(jo6.e("LX-43051"));
    }

    public static /* synthetic */ void h(MessageVo messageVo) {
        if (messageVo != null) {
            com.zenmen.palmchat.database.b.t(messageVo);
        }
    }
}
