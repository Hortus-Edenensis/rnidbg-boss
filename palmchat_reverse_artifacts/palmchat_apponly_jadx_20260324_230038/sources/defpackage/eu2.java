package defpackage;

import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class eu2 extends a41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f17362a = 0;
    public static int b = 1;
    public static int c = 2;
    public static int d = 3;

    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message.getType() == 60 && (message.getSubType() == 0 || message.getSubType() == 1 || message.getSubType() == 2 || message.getSubType() == 3);
    }

    @Override // defpackage.a41, defpackage.wk2
    public boolean b() {
        return false;
    }

    @Override // defpackage.a41, defpackage.ln2
    public void d(MessageProto.Message message) {
        try {
            hu2.a(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
