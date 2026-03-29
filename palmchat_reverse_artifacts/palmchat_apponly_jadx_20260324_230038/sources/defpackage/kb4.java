package defpackage;

import com.google.protobuf.GeneratedMessageLite;
import im.youni.iccs.iprotobuf.domain.AuthProto;
import im.youni.iccs.iprotobuf.domain.AuthResponseProto;
import im.youni.iccs.iprotobuf.domain.LogoutProto;
import im.youni.iccs.iprotobuf.domain.LogoutResponseProto;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import im.youni.iccs.iprotobuf.domain.PingProto;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class kb4 {
    public static String a() {
        return String.valueOf(System.currentTimeMillis()) + "-" + String.valueOf(Math.abs(new Random().nextInt()));
    }

    public static byte b(GeneratedMessageLite generatedMessageLite) {
        if (generatedMessageLite instanceof PingProto.Ping) {
            return (byte) 0;
        }
        if (generatedMessageLite instanceof AuthProto.Auth) {
            return (byte) 1;
        }
        if (generatedMessageLite instanceof AuthResponseProto.AuthResponse) {
            return (byte) 2;
        }
        if (generatedMessageLite instanceof LogoutProto.Logout) {
            return (byte) 3;
        }
        if (generatedMessageLite instanceof LogoutResponseProto.LogoutResponse) {
            return (byte) 4;
        }
        return generatedMessageLite instanceof MessageProto.Message ? (byte) 17 : (byte) -1;
    }

    public static void c(xo6 xo6Var, String str, String str2, String str3) {
        xo6Var.k(MessageProto.Message.newBuilder().setMid(str).setFrom(str2).setTo(str3).setStatus(200).setType(5).build(), str);
    }
}
