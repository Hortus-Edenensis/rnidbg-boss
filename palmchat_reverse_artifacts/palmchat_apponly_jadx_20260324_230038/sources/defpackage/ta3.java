package defpackage;

import com.google.protobuf.GeneratedMessageLite;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.messaging.TokenInValidateException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.support.SquareSingleton;
import im.youni.iccs.iprotobuf.domain.AuthResponseProto;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class ta3 implements jn2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20940a = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20941a;
        public final /* synthetic */ long b;

        public a(int i, long j) {
            this.f20941a = i;
            this.b = j;
            put("action", "msg_auth");
            put("status", i > 0 ? "success" : "fail");
            put("duration", Long.valueOf(ir5.e(j)));
        }
    }

    @Override // defpackage.jn2
    public void a() {
        iq5.d().g(false, new String[0]);
        if (AppContext.getContext() != null && !AppContext.getContext().isBackground()) {
            SquareSingleton.getInstance().reloadPraiseCount();
        }
        AccountUtils.x(AccountUtils.p(AppContext.getContext()), AccountUtils.j(AppContext.getContext()), AccountUtils.o(AppContext.getContext()), AccountUtils.m(AppContext.getContext()));
        if (this.f20940a) {
            return;
        }
        this.f20940a = true;
        HashMap map = new HashMap();
        map.put("rom_name", wb1.b());
        map.put("rom_name_ver", wb1.d());
        map.put("isHarmony", Boolean.valueOf(wb1.h()));
        map.put("arch64", Boolean.valueOf(wb1.g()));
        map.put("arch64New", Boolean.valueOf(wb1.f()));
        map.put("sysVersion", ac1.d);
        LogUtil.uploadInfoImmediate("lx_rom_info", map);
    }

    @Override // defpackage.jn2
    public void b(GeneratedMessageLite generatedMessageLite, long j) throws Exception {
        int i = (generatedMessageLite != null && (generatedMessageLite instanceof AuthResponseProto.AuthResponse) && ((AuthResponseProto.AuthResponse) generatedMessageLite).getCode().equals(String.valueOf(200))) ? 1 : (generatedMessageLite != null && (generatedMessageLite instanceof AuthResponseProto.AuthResponse) && ((AuthResponseProto.AuthResponse) generatedMessageLite).getCode().equals(String.valueOf(401))) ? 0 : -1;
        if (generatedMessageLite instanceof AuthResponseProto.AuthResponse) {
            AuthResponseProto.AuthResponse authResponse = (AuthResponseProto.AuthResponse) generatedMessageLite;
            if (authResponse.getTimestamp() > 0) {
                ir5.g(authResponse.getTimestamp());
            }
        }
        LogUtil.i("LxMsgConnection", 3, new a(i, j), (Throwable) null);
        if (i == 0) {
            throw new TokenInValidateException("Validate fail from the server ");
        }
        if (i == -1) {
            throw new Exception("No response from the server.");
        }
    }
}
