package defpackage;

import com.google.protobuf.GeneratedMessageLite;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.AuthProto;
import im.youni.iccs.iprotobuf.domain.AuthResponseProto;
import java.util.HashMap;
import org.jivesoftware.smack.util.Base64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class uy3 {
    public static final String b = "uy3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public km0 f21324a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21325a;

        public a(String str) {
            this.f21325a = str;
            put("action", "generateMessageToken");
            put("status", "fail");
            put("detail", om1.f().o() ? "skey is null" : str == null ? "uid is null" : "timeStamp is null");
        }
    }

    public uy3(km0 km0Var) {
        this.f21324a = km0Var;
    }

    public static String b(String str) {
        String string = Long.toString(System.currentTimeMillis());
        byte[] bArrQ = null;
        if (!om1.f().o() || str == null || string == null) {
            LogUtil.i(b, 3, new a(str), (Throwable) null);
            return "";
        }
        try {
            bArrQ = om1.f().q((str + "_" + string).getBytes(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bArrQ != null ? Base64.encodeBytes(bArrQ) : "";
    }

    public AuthResponseProto.AuthResponse a(String str, String str2, String str3) throws Exception {
        long jB = ir5.b();
        AuthProto.Auth authBuild = AuthProto.Auth.newBuilder().setMid(kb4.a()).setVersion(Integer.valueOf(ac1.f).intValue()).setUid(str).setResource(str3).setLocale(c.b().getResources().getConfiguration().locale.toString()).setToken(b(str)).setDeviceId(ac1.h).setLogonSessionId(v4.c(c.b())).build();
        fb4 fb4VarC = this.f21324a.c(new hb4(authBuild.getMid()));
        this.f21324a.k(authBuild, authBuild.getMid());
        GeneratedMessageLite generatedMessageLiteB = fb4VarC.b(jf5.a());
        bs3.b().b(generatedMessageLiteB, jB);
        AuthResponseProto.AuthResponse authResponse = (AuthResponseProto.AuthResponse) generatedMessageLiteB;
        fb4VarC.a();
        return authResponse;
    }
}
