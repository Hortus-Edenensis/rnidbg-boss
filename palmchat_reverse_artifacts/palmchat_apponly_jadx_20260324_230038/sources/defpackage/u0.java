package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.google.protobuf.GeneratedMessageLite;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.kn2;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public abstract class u0 implements mn2, zi0 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends jo3 {
        public final /* synthetic */ e h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MessageProto.Message message, Context context, int i, String str, e eVar) {
            super(message, context, i, str);
            this.h = eVar;
        }

        @Override // defpackage.jo3
        public void d() {
            this.h.a(null);
        }

        @Override // defpackage.jo3
        public void e(GeneratedMessageLite generatedMessageLite) {
            this.h.a(generatedMessageLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends eo3 {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements e {
            public a() {
            }

            @Override // u0.e
            public void a(GeneratedMessageLite generatedMessageLite) {
                b bVar = b.this;
                u0.this.j(bVar.f20636a, generatedMessageLite);
                b.this.c();
            }
        }

        /* JADX INFO: renamed from: u0$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1276b implements kn2.a<UploadResultVo> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f21103a;

            public C1276b(e eVar) {
                this.f21103a = eVar;
            }
        }

        public b(MessageVo messageVo) {
            super(messageVo);
        }

        @Override // defpackage.eo3, defpackage.s0
        public void d() {
            LogUtil.i(s0.e, "buildMessageSendTask mid=" + this.f20636a.mid + " type=" + this.f20636a.mimeType + " ");
            a aVar = new a();
            if (!u0.this.a(this.f20636a)) {
                jo3 jo3VarH = u0.this.h(this.f20636a, aVar);
                f(jo3VarH);
                jo3VarH.i();
            } else {
                kn2 kn2VarD = u0.this.d(this.f20636a, new C1276b(aVar));
                if (kn2VarD != null) {
                    e(kn2VarD);
                    kn2VarD.a(false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21104a;
        public final /* synthetic */ String b;

        public c(String str, String str2) {
            this.f21104a = str;
            this.b = str2;
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", "dealWithReplyPacket");
            put("detail", str);
            put("mid", str2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21105a;

        public d(String str) {
            this.f21105a = str;
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", "dealWithReplyPacket");
            put("detail", "replyPacket received success");
            put("mid", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(GeneratedMessageLite generatedMessageLite);
    }

    public static MessageVo g(ChatItem chatItem) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = xn3.a();
        messageVo.time = ir5.b();
        messageVo.contactRelate = DomainHelper.e(chatItem);
        messageVo.to = DomainHelper.e(chatItem);
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(0);
        messageVo.attachStatus = 2;
        messageVo.from = AccountUtils.p(AppContext.getContext());
        messageVo.extention = "";
        messageVo.text = MapController.DEFAULT_LAYER_TAG;
        return messageVo;
    }

    @Override // defpackage.mn2
    public eo3 b(MessageVo messageVo) {
        return new b(messageVo);
    }

    public final jo3 h(MessageVo messageVo, e eVar) {
        return new a(i(messageVo), fs0.d().e(), k(messageVo), "", eVar);
    }

    public MessageProto.Message i(MessageVo messageVo) {
        String strF = DomainHelper.f(messageVo);
        String strB = DomainHelper.b();
        MessageProto.Message.Builder flag = MessageProto.Message.newBuilder().setFrom(strB).setTo(strF).setMid(messageVo.mid).setType(messageVo.mimeType).setBody(messageVo.text).setFlag(k(messageVo));
        flag.setSubType(messageVo.getSubTypeForSend());
        flag.setExType(messageVo.getExTypeForSend());
        String str = messageVo.extention;
        if (TextUtils.isEmpty(messageVo.bizExtension)) {
            flag.setExtension(str);
        } else {
            flag.setExtension(MessageVo.mergeJsonStrings(messageVo.bizExtension, str));
        }
        return flag.build();
    }

    public final void j(MessageVo messageVo, GeneratedMessageLite generatedMessageLite) {
        String str = messageVo.mid;
        if (generatedMessageLite == null) {
            l(messageVo, null, "replyPacket null");
            return;
        }
        if (!(generatedMessageLite instanceof MessageProto.Message)) {
            l(messageVo, null, "replyPacket type is not MessageProto.Message");
            return;
        }
        MessageProto.Message message = (MessageProto.Message) generatedMessageLite;
        if (message.getType() != 5) {
            return;
        }
        if (message.getStatus() != 10) {
            l(messageVo, message, "replyPacket status" + message.getStatus());
            return;
        }
        LogUtil.i("AbsSender", 3, new d(str), (Throwable) null);
        m(messageVo, message);
        if (mb4.e(message, str, "send_sync")) {
            return;
        }
        gq5.b(message.getSyncKey(), message.getVersion());
    }

    public int k(MessageVo messageVo) {
        if (messageVo == null) {
            return 0;
        }
        String str = messageVo.sendFlag;
        int iIntValue = str != null ? Integer.valueOf(str).intValue() : 0;
        if (iIntValue == 1 && messageVo.isNetworkError()) {
            return 3;
        }
        return iIntValue;
    }

    public void l(MessageVo messageVo, MessageProto.Message message, String str) {
        String str2 = messageVo.mid;
        if (com.zenmen.palmchat.database.b.P(messageVo, null)) {
            mb4.l(messageVo);
            LogUtil.i("AbsSender", 3, new c(str, str2), (Throwable) null);
        }
    }

    public void m(MessageVo messageVo, MessageProto.Message message) {
        com.zenmen.palmchat.database.b.Q(messageVo, message);
    }
}
