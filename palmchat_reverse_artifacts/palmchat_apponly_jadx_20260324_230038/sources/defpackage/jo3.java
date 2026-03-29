package defpackage;

import android.content.Context;
import com.google.protobuf.GeneratedMessageLite;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public abstract class jo3 {
    public static final String g = "MessagingService_" + jo3.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageProto.Message f18444a;
    public Context b;
    public int c;
    public String d;
    public boolean e = false;
    public boolean f = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", LogUtil.VALUE_SEND);
            put("mid", jo3.this.f18444a.getMid());
            put("type", Integer.valueOf(jo3.this.f18444a.getType()));
            put("from", jo3.this.f18444a.getFrom());
            put(RemoteMessageConst.TO, jo3.this.f18444a.getTo());
            put("flag", Integer.valueOf(jo3.this.c));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", LogUtil.VALUE_SEND);
            put("mid", jo3.this.f18444a.getMid());
            put("type", Integer.valueOf(jo3.this.f18444a.getType()));
            put("from", jo3.this.f18444a.getFrom());
            put(RemoteMessageConst.TO, jo3.this.f18444a.getTo());
            put("flag", Integer.valueOf(jo3.this.c));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18447a;

        public c(int i) {
            this.f18447a = i;
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", com.zenmen.palmchat.messaging.b.d().c().g() == null ? "startConnectXNetwork" : "resetXNetwork");
            put("mid", jo3.this.f18444a.getMid());
            put("type", Integer.valueOf(jo3.this.f18444a.getType()));
            put("from", jo3.this.f18444a.getFrom());
            put(RemoteMessageConst.TO, jo3.this.f18444a.getTo());
            put("flag", Integer.valueOf(jo3.this.c));
            put("i", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18448a;

        public d(int i) {
            this.f18448a = i;
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", LogUtil.VALUE_SEND);
            put("mid", jo3.this.f18444a.getMid());
            put("type", Integer.valueOf(jo3.this.f18444a.getType()));
            put("from", jo3.this.f18444a.getFrom());
            put(RemoteMessageConst.TO, jo3.this.f18444a.getTo());
            put("i", Integer.valueOf(i));
            put("flag", Integer.valueOf(jo3.this.c));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18449a;
        public final /* synthetic */ GeneratedMessageLite b;
        public final /* synthetic */ int c;

        public e(boolean z, GeneratedMessageLite generatedMessageLite, int i) {
            this.f18449a = z;
            this.b = generatedMessageLite;
            this.c = i;
            put("action", LogUtil.VALUE_MSG_SEND);
            StringBuilder sb = new StringBuilder();
            sb.append("reply_");
            sb.append(z ? "success" : "fail");
            put("status", sb.toString());
            if (z) {
                MessageProto.Message message = (MessageProto.Message) generatedMessageLite;
                put("detail", message.getSyncKey() + ":" + message.getVersion());
            }
            put("mid", jo3.this.f18444a.getMid());
            put("type", Integer.valueOf(jo3.this.f18444a.getType()));
            put(RemoteMessageConst.TO, jo3.this.f18444a.getTo());
            put("i", Integer.valueOf(i));
            put("flag", Integer.valueOf(jo3.this.c));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", "start");
            put("mid", jo3.this.f18444a.getMid());
            put("type", Integer.valueOf(jo3.this.f18444a.getType()));
            put(RemoteMessageConst.TO, jo3.this.f18444a.getTo());
            put("flag", Integer.valueOf(jo3.this.c));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {
        public g() {
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", "sendFailed");
            put("mid", jo3.this.f18444a.getMid());
            put("type", Integer.valueOf(jo3.this.f18444a.getType()));
            put("from", jo3.this.f18444a.getFrom());
            put(RemoteMessageConst.TO, jo3.this.f18444a.getTo());
            put("flag", Integer.valueOf(jo3.this.c));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GeneratedMessageLite f18452a;

        public h(GeneratedMessageLite generatedMessageLite) {
            this.f18452a = generatedMessageLite;
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", generatedMessageLite == null ? "reply_fail" : "reply_success");
            put("mid", jo3.this.f18444a.getMid());
            put("type", Integer.valueOf(jo3.this.f18444a.getType()));
            put(RemoteMessageConst.TO, jo3.this.f18444a.getTo());
            put("flag", Integer.valueOf(jo3.this.c));
        }
    }

    public jo3(MessageProto.Message message, Context context, int i, String str) {
        this.f18444a = message;
        this.b = context;
        this.c = i;
        this.d = str;
    }

    public void c() {
        this.e = true;
    }

    public abstract void d();

    public abstract void e(GeneratedMessageLite generatedMessageLite);

    public final void f(int i) {
        if (this.e) {
            return;
        }
        LogUtil.i(g, 3, new c(i), (Throwable) null);
        if (com.zenmen.palmchat.messaging.b.d().c().m()) {
            com.zenmen.palmchat.messaging.b.d().c().s(false);
        } else {
            com.zenmen.palmchat.messaging.b.d().c().w(true, "STASRT_REASON_SEND_MSG_RECONNECT");
        }
        com.zenmen.palmchat.messaging.b.d().c().y(30000L);
    }

    public final GeneratedMessageLite g(int i) {
        if (this.e || !com.zenmen.palmchat.messaging.b.d().c().m()) {
            return null;
        }
        if (this.f && this.f18444a.getFlag() != 2) {
            this.f18444a = this.f18444a.toBuilder().setFlag(2).build();
        }
        String str = g;
        LogUtil.i(str, 3, new d(i), (Throwable) null);
        LogUtil.d("logmsg", "sendPacket: " + this.f18444a.toString());
        xo6 xo6VarG = com.zenmen.palmchat.messaging.b.d().c().g();
        MessageProto.Message message = this.f18444a;
        xo6VarG.k(message, message.getMid());
        this.f = true;
        fb4 fb4VarC = com.zenmen.palmchat.messaging.b.d().c().g().c(new hb4(this.f18444a.getMid()));
        GeneratedMessageLite generatedMessageLiteB = fb4VarC.b(jf5.b());
        StringBuilder sb = new StringBuilder();
        sb.append("replyPacket: ");
        sb.append(generatedMessageLiteB != null ? generatedMessageLiteB.toString() : com.igexin.push.core.b.m);
        LogUtil.d("logmsg", sb.toString());
        fb4VarC.a();
        LogUtil.i(str, 3, new e(generatedMessageLiteB != null && (generatedMessageLiteB instanceof MessageProto.Message) && ((MessageProto.Message) generatedMessageLiteB).getStatus() == 10, generatedMessageLiteB, i), (Throwable) null);
        return generatedMessageLiteB;
    }

    public GeneratedMessageLite h() {
        for (int i = 0; i < 11; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                GeneratedMessageLite generatedMessageLiteG = g(i2);
                if (generatedMessageLiteG != null) {
                    return generatedMessageLiteG;
                }
            }
            if (i != 10) {
                f(i);
            }
        }
        return null;
    }

    public void i() {
        String str = g;
        LogUtil.LogType logType = LogUtil.LogType.LOG_TYPE_QA_NORMAL;
        LogUtil.i(str, logType, 3, new f(), (Throwable) null);
        com.zenmen.palmchat.messaging.b.d().c().v(true);
        GeneratedMessageLite generatedMessageLiteH = h();
        com.zenmen.palmchat.messaging.b.d().c().v(false);
        if (generatedMessageLiteH == null) {
            LogUtil.i(str, 3, new g(), (Throwable) null);
            d();
        } else {
            e(generatedMessageLiteH);
        }
        LogUtil.i(str, logType, 3, new h(generatedMessageLiteH), (Throwable) null);
    }

    public void j() {
        if (com.zenmen.palmchat.messaging.b.d().c().m()) {
            LogUtil.i(g, 3, new a(), (Throwable) null);
            LogUtil.d("logmsg", "sendMessageWithoutProcessReply: " + this.f18444a.toString());
            xo6 xo6VarG = com.zenmen.palmchat.messaging.b.d().c().g();
            MessageProto.Message message = this.f18444a;
            xo6VarG.k(message, message.getMid());
        }
    }

    public void k() {
        if (com.zenmen.palmchat.messaging.b.d().c().m()) {
            LogUtil.i(g, 3, new b(), (Throwable) null);
            LogUtil.d("logmsg", "sendMessageWithoutRetry: " + this.f18444a.toString());
            xo6 xo6VarG = com.zenmen.palmchat.messaging.b.d().c().g();
            MessageProto.Message message = this.f18444a;
            xo6VarG.k(message, message.getMid());
            fb4 fb4VarC = com.zenmen.palmchat.messaging.b.d().c().g().c(new hb4(this.f18444a.getMid()));
            GeneratedMessageLite generatedMessageLiteB = fb4VarC.b(jf5.b());
            fb4VarC.a();
            StringBuilder sb = new StringBuilder();
            sb.append("sendMessageWithoutRetry replyPacket: ");
            sb.append(generatedMessageLiteB != null ? generatedMessageLiteB.toString() : com.igexin.push.core.b.m);
            LogUtil.d("logmsg", sb.toString());
            if (generatedMessageLiteB == null) {
                d();
            } else {
                e(generatedMessageLiteB);
            }
        }
    }
}
