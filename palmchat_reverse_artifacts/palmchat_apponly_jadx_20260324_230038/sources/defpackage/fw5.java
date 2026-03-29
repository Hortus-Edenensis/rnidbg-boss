package defpackage;

import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class fw5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f17612a;

    public static void a() {
        f17612a = 0L;
    }

    public static boolean b(MessageProto.Message message) {
        return message == null || message.getVersion() > f17612a;
    }

    public static void c(long j) {
        if (j > f17612a) {
            f17612a = j;
        }
    }
}
