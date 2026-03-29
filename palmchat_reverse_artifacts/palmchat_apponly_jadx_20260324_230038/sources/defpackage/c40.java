package defpackage;

import com.zenmen.palmchat.chat.chatprofile.bean.ChatProfileInfo;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c40 {
    public static c40 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1888a = 300000;
    public HashMap<String, c> b = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1889a;
        public final /* synthetic */ b b;

        public a(String str, b bVar) {
            this.f1889a = str;
            this.b = bVar;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            this.b.onFail();
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObject2;
            if (yy2Var == null || !yy2Var.f22300a || (jSONObject2 = yy2Var.d) == null) {
                this.b.onFail();
                return;
            }
            ChatProfileInfo chatProfileInfo = (ChatProfileInfo) az2.a(jSONObject2.toString(), ChatProfileInfo.class);
            if (chatProfileInfo == null) {
                this.b.onFail();
            } else {
                c40.this.b.put(this.f1889a, new c(ir5.b(), chatProfileInfo));
                this.b.a(chatProfileInfo);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(ChatProfileInfo chatProfileInfo);

        void onFail();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChatProfileInfo f1890a;
        public long b;

        public c(long j, ChatProfileInfo chatProfileInfo) {
            this.b = j;
            this.f1890a = chatProfileInfo;
        }
    }

    public static c40 b() {
        if (c == null) {
            synchronized (c40.class) {
                if (c == null) {
                    c = new c40();
                }
            }
        }
        return c;
    }

    public ChatProfileInfo c(String str, b bVar, boolean z) {
        c cVar = this.b.get(str);
        if (cVar == null || Math.abs(cVar.b - ir5.b()) > 300000) {
            b40.a(str, new a(str, bVar));
        }
        if (cVar == null) {
            return null;
        }
        if (z) {
            bVar.a(cVar.f1890a);
        }
        return cVar.f1890a;
    }
}
